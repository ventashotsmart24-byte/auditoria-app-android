package com.raizlabs.android.dbflow.structure.database;

import android.content.res.AssetManager;
import android.database.sqlite.SQLiteException;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.NaturalOrderComparator;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.migration.Migration;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.ModelViewAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDatabaseHelper {
    public static final String MIGRATION_PATH = "migrations";
    private final DatabaseDefinition databaseDefinition;

    public BaseDatabaseHelper(DatabaseDefinition databaseDefinition2) {
        this.databaseDefinition = databaseDefinition2;
    }

    private void executeSqlScript(DatabaseWrapper databaseWrapper, String str) {
        try {
            AssetManager assets = FlowManager.getContext().getAssets();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assets.open("migrations/" + getDatabaseDefinition().getDatabaseName() + Operator.Operation.DIVISION + str)));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                boolean endsWith = trim.endsWith(";");
                if (!trim.startsWith("--")) {
                    if (endsWith) {
                        trim = trim.substring(0, trim.length() - 1);
                    }
                    stringBuffer.append(" ");
                    stringBuffer.append(trim);
                    if (endsWith) {
                        databaseWrapper.execSQL(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.trim().length() > 0) {
                databaseWrapper.execSQL(stringBuffer2);
            }
        } catch (IOException e10) {
            FlowLog.Level level = FlowLog.Level.E;
            FlowLog.log(level, "Failed to execute " + str, e10);
        }
    }

    public void checkForeignKeySupport(DatabaseWrapper databaseWrapper) {
        if (this.databaseDefinition.isForeignKeysSupported()) {
            databaseWrapper.execSQL("PRAGMA foreign_keys=ON;");
            FlowLog.log(FlowLog.Level.I, "Foreign Keys supported. Enabling foreign key features.");
        }
    }

    public void executeMigrations(DatabaseWrapper databaseWrapper, int i10, int i11) {
        try {
            AssetManager assets = FlowManager.getContext().getAssets();
            List<String> asList = Arrays.asList(assets.list("migrations/" + this.databaseDefinition.getDatabaseName()));
            Collections.sort(asList, new NaturalOrderComparator());
            HashMap hashMap = new HashMap();
            for (String str : asList) {
                try {
                    Integer valueOf = Integer.valueOf(str.replace(".sql", ""));
                    List list = (List) hashMap.get(valueOf);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(valueOf, list);
                    }
                    list.add(str);
                } catch (NumberFormatException e10) {
                    FlowLog.Level level = FlowLog.Level.W;
                    FlowLog.log(level, "Skipping invalidly named file: " + str, e10);
                }
            }
            Map<Integer, List<Migration>> migrations = this.databaseDefinition.getMigrations();
            databaseWrapper.beginTransaction();
            for (int i12 = i10 + 1; i12 <= i11; i12++) {
                List<String> list2 = (List) hashMap.get(Integer.valueOf(i12));
                if (list2 != null) {
                    for (String str2 : list2) {
                        executeSqlScript(databaseWrapper, str2);
                        FlowLog.Level level2 = FlowLog.Level.I;
                        FlowLog.log(level2, str2 + " executed successfully.");
                    }
                }
                List<Migration> list3 = migrations.get(Integer.valueOf(i12));
                if (list3 != null) {
                    for (Migration migration : list3) {
                        migration.onPreMigrate();
                        migration.migrate(databaseWrapper);
                        migration.onPostMigrate();
                        FlowLog.Level level3 = FlowLog.Level.I;
                        FlowLog.log(level3, migration.getClass() + " executed successfully.");
                    }
                }
            }
            databaseWrapper.setTransactionSuccessful();
            databaseWrapper.endTransaction();
        } catch (IOException e11) {
            FlowLog.log(FlowLog.Level.E, "Failed to execute migrations.", e11);
        } catch (Throwable th) {
            databaseWrapper.endTransaction();
            throw th;
        }
    }

    public void executeTableCreations(DatabaseWrapper databaseWrapper) {
        try {
            databaseWrapper.beginTransaction();
            for (ModelAdapter next : this.databaseDefinition.getModelAdapters()) {
                if (next.createWithDatabase()) {
                    databaseWrapper.execSQL(next.getCreationQuery());
                }
            }
            databaseWrapper.setTransactionSuccessful();
            databaseWrapper.endTransaction();
        } catch (SQLiteException e10) {
            FlowLog.logError(e10);
        } catch (Throwable th) {
            databaseWrapper.endTransaction();
            throw th;
        }
    }

    public void executeViewCreations(DatabaseWrapper databaseWrapper) {
        try {
            databaseWrapper.beginTransaction();
            for (ModelViewAdapter next : this.databaseDefinition.getModelViewAdapters()) {
                databaseWrapper.execSQL(new QueryBuilder().append("CREATE VIEW IF NOT EXISTS").appendSpaceSeparated(next.getViewName()).append("AS ").append(next.getCreationQuery()).getQuery());
            }
            databaseWrapper.setTransactionSuccessful();
            databaseWrapper.endTransaction();
        } catch (SQLiteException e10) {
            FlowLog.logError(e10);
        } catch (Throwable th) {
            databaseWrapper.endTransaction();
            throw th;
        }
    }

    public DatabaseDefinition getDatabaseDefinition() {
        return this.databaseDefinition;
    }

    public void onCreate(DatabaseWrapper databaseWrapper) {
        checkForeignKeySupport(databaseWrapper);
        executeTableCreations(databaseWrapper);
        executeMigrations(databaseWrapper, -1, databaseWrapper.getVersion());
        executeViewCreations(databaseWrapper);
    }

    public void onDowngrade(DatabaseWrapper databaseWrapper, int i10, int i11) {
        checkForeignKeySupport(databaseWrapper);
    }

    public void onOpen(DatabaseWrapper databaseWrapper) {
        checkForeignKeySupport(databaseWrapper);
    }

    public void onUpgrade(DatabaseWrapper databaseWrapper, int i10, int i11) {
        checkForeignKeySupport(databaseWrapper);
        executeTableCreations(databaseWrapper);
        executeMigrations(databaseWrapper, i10, i11);
        executeViewCreations(databaseWrapper);
    }
}
