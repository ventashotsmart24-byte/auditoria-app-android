package com.bigbee.db;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.sql.saveable.AutoIncrementModelSaver;
import com.raizlabs.android.dbflow.sql.saveable.ModelSaver;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import com.umeng.analytics.AnalyticsConfig;

public final class EventDbModel_Table extends ModelAdapter<EventDbModel> {
    public static final IProperty[] ALL_COLUMN_PROPERTIES;
    public static final Property<String> appVer;
    public static final Property<String> cipherStr;
    public static final Property<String> commonStr;
    public static final Property<Long> endTime;
    public static final Property<String> eventId;
    public static final Property<Integer> id;
    public static final Property<Boolean> notIntactEvent;
    public static final Property<Boolean> reporting;
    public static final Property<String> reserveA;
    public static final Property<String> reserveB;
    public static final Property<Long> startTime;
    public static final Property<String> sysVer;

    static {
        Class<EventDbModel> cls = EventDbModel.class;
        Property<Integer> property = new Property<>((Class<?>) cls, "id");
        id = property;
        Property<String> property2 = new Property<>((Class<?>) cls, "appVer");
        appVer = property2;
        Property<String> property3 = new Property<>((Class<?>) cls, "sysVer");
        sysVer = property3;
        Property<Long> property4 = new Property<>((Class<?>) cls, AnalyticsConfig.RTD_START_TIME);
        startTime = property4;
        Property<Long> property5 = new Property<>((Class<?>) cls, "endTime");
        endTime = property5;
        Property<String> property6 = new Property<>((Class<?>) cls, "eventId");
        eventId = property6;
        Property<Boolean> property7 = new Property<>((Class<?>) cls, "reporting");
        reporting = property7;
        Property<String> property8 = new Property<>((Class<?>) cls, "cipherStr");
        cipherStr = property8;
        Property<String> property9 = new Property<>((Class<?>) cls, "commonStr");
        commonStr = property9;
        Property<Boolean> property10 = new Property<>((Class<?>) cls, "notIntactEvent");
        notIntactEvent = property10;
        Property<String> property11 = new Property<>((Class<?>) cls, "reserveA");
        reserveA = property11;
        Property<String> property12 = new Property<>((Class<?>) cls, "reserveB");
        reserveB = property12;
        ALL_COLUMN_PROPERTIES = new IProperty[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12};
    }

    public EventDbModel_Table(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public final ModelSaver<EventDbModel> createSingleModelSaver() {
        return new AutoIncrementModelSaver();
    }

    public final IProperty[] getAllColumnProperties() {
        return ALL_COLUMN_PROPERTIES;
    }

    public final String getAutoIncrementingColumnName() {
        return "id";
    }

    public final String getCompiledStatementQuery() {
        return "INSERT INTO `EventDbModel`(`id`,`appVer`,`sysVer`,`startTime`,`endTime`,`eventId`,`reporting`,`cipherStr`,`commonStr`,`notIntactEvent`,`reserveA`,`reserveB`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final String getCreationQuery() {
        return "CREATE TABLE IF NOT EXISTS `EventDbModel`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, `appVer` TEXT, `sysVer` TEXT, `startTime` INTEGER, `endTime` INTEGER, `eventId` TEXT, `reporting` INTEGER, `cipherStr` TEXT, `commonStr` TEXT, `notIntactEvent` INTEGER, `reserveA` TEXT, `reserveB` TEXT)";
    }

    public final String getDeleteStatementQuery() {
        return "DELETE FROM `EventDbModel` WHERE `id`=?";
    }

    public final String getInsertStatementQuery() {
        return "INSERT INTO `EventDbModel`(`appVer`,`sysVer`,`startTime`,`endTime`,`eventId`,`reporting`,`cipherStr`,`commonStr`,`notIntactEvent`,`reserveA`,`reserveB`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    }

    public final Class<EventDbModel> getModelClass() {
        return EventDbModel.class;
    }

    public final Property getProperty(String str) {
        String quoteIfNeeded = QueryBuilder.quoteIfNeeded(str);
        quoteIfNeeded.hashCode();
        char c10 = 65535;
        switch (quoteIfNeeded.hashCode()) {
            case -1932196566:
                if (quoteIfNeeded.equals("`sysVer`")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1438839285:
                if (quoteIfNeeded.equals("`eventId`")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1056019110:
                if (quoteIfNeeded.equals("`cipherStr`")) {
                    c10 = 2;
                    break;
                }
                break;
            case -987826562:
                if (quoteIfNeeded.equals("`appVer`")) {
                    c10 = 3;
                    break;
                }
                break;
            case -512064708:
                if (quoteIfNeeded.equals("`notIntactEvent`")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1867912:
                if (quoteIfNeeded.equals("`endTime`")) {
                    c10 = 5;
                    break;
                }
                break;
            case 2964037:
                if (quoteIfNeeded.equals("`id`")) {
                    c10 = 6;
                    break;
                }
                break;
            case 337527195:
                if (quoteIfNeeded.equals("`reserveA`")) {
                    c10 = 7;
                    break;
                }
                break;
            case 337527226:
                if (quoteIfNeeded.equals("`reserveB`")) {
                    c10 = 8;
                    break;
                }
                break;
            case 475840826:
                if (quoteIfNeeded.equals("`commonStr`")) {
                    c10 = 9;
                    break;
                }
                break;
            case 1223362642:
                if (quoteIfNeeded.equals("`reporting`")) {
                    c10 = 10;
                    break;
                }
                break;
            case 2002700369:
                if (quoteIfNeeded.equals("`startTime`")) {
                    c10 = 11;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return sysVer;
            case 1:
                return eventId;
            case 2:
                return cipherStr;
            case 3:
                return appVer;
            case 4:
                return notIntactEvent;
            case 5:
                return endTime;
            case 6:
                return id;
            case 7:
                return reserveA;
            case 8:
                return reserveB;
            case 9:
                return commonStr;
            case 10:
                return reporting;
            case 11:
                return startTime;
            default:
                throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
        }
    }

    public final String getTableName() {
        return "`EventDbModel`";
    }

    public final String getUpdateStatementQuery() {
        return "UPDATE `EventDbModel` SET `id`=?,`appVer`=?,`sysVer`=?,`startTime`=?,`endTime`=?,`eventId`=?,`reporting`=?,`cipherStr`=?,`commonStr`=?,`notIntactEvent`=?,`reserveA`=?,`reserveB`=? WHERE `id`=?";
    }

    public final void bindToContentValues(ContentValues contentValues, EventDbModel eventDbModel) {
        contentValues.put("`id`", Integer.valueOf(eventDbModel.id));
        bindToInsertValues(contentValues, eventDbModel);
    }

    public final void bindToDeleteStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel) {
        databaseStatement.bindLong(1, (long) eventDbModel.id);
    }

    public final void bindToInsertStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel, int i10) {
        databaseStatement.bindStringOrNull(i10 + 1, eventDbModel.appVer);
        databaseStatement.bindStringOrNull(i10 + 2, eventDbModel.sysVer);
        databaseStatement.bindLong(i10 + 3, eventDbModel.startTime);
        databaseStatement.bindLong(i10 + 4, eventDbModel.endTime);
        databaseStatement.bindStringOrNull(i10 + 5, eventDbModel.eventId);
        long j10 = 1;
        databaseStatement.bindLong(i10 + 6, eventDbModel.reporting ? 1 : 0);
        databaseStatement.bindStringOrNull(i10 + 7, eventDbModel.cipherStr);
        databaseStatement.bindStringOrNull(i10 + 8, eventDbModel.commonStr);
        int i11 = i10 + 9;
        if (!eventDbModel.notIntactEvent) {
            j10 = 0;
        }
        databaseStatement.bindLong(i11, j10);
        databaseStatement.bindStringOrNull(i10 + 10, eventDbModel.reserveA);
        databaseStatement.bindStringOrNull(i10 + 11, eventDbModel.reserveB);
    }

    public final void bindToInsertValues(ContentValues contentValues, EventDbModel eventDbModel) {
        contentValues.put("`appVer`", eventDbModel.appVer);
        contentValues.put("`sysVer`", eventDbModel.sysVer);
        contentValues.put("`startTime`", Long.valueOf(eventDbModel.startTime));
        contentValues.put("`endTime`", Long.valueOf(eventDbModel.endTime));
        contentValues.put("`eventId`", eventDbModel.eventId);
        contentValues.put("`reporting`", Integer.valueOf(eventDbModel.reporting ? 1 : 0));
        contentValues.put("`cipherStr`", eventDbModel.cipherStr);
        contentValues.put("`commonStr`", eventDbModel.commonStr);
        contentValues.put("`notIntactEvent`", Integer.valueOf(eventDbModel.notIntactEvent ? 1 : 0));
        contentValues.put("`reserveA`", eventDbModel.reserveA);
        contentValues.put("`reserveB`", eventDbModel.reserveB);
    }

    public final void bindToStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel) {
        databaseStatement.bindLong(1, (long) eventDbModel.id);
        bindToInsertStatement(databaseStatement, eventDbModel, 1);
    }

    public final void bindToUpdateStatement(DatabaseStatement databaseStatement, EventDbModel eventDbModel) {
        databaseStatement.bindLong(1, (long) eventDbModel.id);
        databaseStatement.bindStringOrNull(2, eventDbModel.appVer);
        databaseStatement.bindStringOrNull(3, eventDbModel.sysVer);
        databaseStatement.bindLong(4, eventDbModel.startTime);
        databaseStatement.bindLong(5, eventDbModel.endTime);
        databaseStatement.bindStringOrNull(6, eventDbModel.eventId);
        long j10 = 1;
        databaseStatement.bindLong(7, eventDbModel.reporting ? 1 : 0);
        databaseStatement.bindStringOrNull(8, eventDbModel.cipherStr);
        databaseStatement.bindStringOrNull(9, eventDbModel.commonStr);
        if (!eventDbModel.notIntactEvent) {
            j10 = 0;
        }
        databaseStatement.bindLong(10, j10);
        databaseStatement.bindStringOrNull(11, eventDbModel.reserveA);
        databaseStatement.bindStringOrNull(12, eventDbModel.reserveB);
        databaseStatement.bindLong(13, (long) eventDbModel.id);
    }

    public final boolean exists(EventDbModel eventDbModel, DatabaseWrapper databaseWrapper) {
        if (eventDbModel.id <= 0) {
            return false;
        }
        if (SQLite.selectCountOf(new IProperty[0]).from(EventDbModel.class).where(getPrimaryConditionClause(eventDbModel)).hasData(databaseWrapper)) {
            return true;
        }
        return false;
    }

    public final Number getAutoIncrementingId(EventDbModel eventDbModel) {
        return Integer.valueOf(eventDbModel.id);
    }

    public final OperatorGroup getPrimaryConditionClause(EventDbModel eventDbModel) {
        OperatorGroup clause = OperatorGroup.clause();
        clause.and(id.eq(Integer.valueOf(eventDbModel.id)));
        return clause;
    }

    public final void loadFromCursor(FlowCursor flowCursor, EventDbModel eventDbModel) {
        eventDbModel.id = flowCursor.getIntOrDefault("id");
        eventDbModel.appVer = flowCursor.getStringOrDefault("appVer");
        eventDbModel.sysVer = flowCursor.getStringOrDefault("sysVer");
        eventDbModel.startTime = flowCursor.getLongOrDefault(AnalyticsConfig.RTD_START_TIME);
        eventDbModel.endTime = flowCursor.getLongOrDefault("endTime");
        eventDbModel.eventId = flowCursor.getStringOrDefault("eventId");
        int columnIndex = flowCursor.getColumnIndex("reporting");
        if (columnIndex == -1 || flowCursor.isNull(columnIndex)) {
            eventDbModel.reporting = false;
        } else {
            eventDbModel.reporting = flowCursor.getBoolean(columnIndex);
        }
        eventDbModel.cipherStr = flowCursor.getStringOrDefault("cipherStr");
        eventDbModel.commonStr = flowCursor.getStringOrDefault("commonStr");
        int columnIndex2 = flowCursor.getColumnIndex("notIntactEvent");
        if (columnIndex2 == -1 || flowCursor.isNull(columnIndex2)) {
            eventDbModel.notIntactEvent = false;
        } else {
            eventDbModel.notIntactEvent = flowCursor.getBoolean(columnIndex2);
        }
        eventDbModel.reserveA = flowCursor.getStringOrDefault("reserveA");
        eventDbModel.reserveB = flowCursor.getStringOrDefault("reserveB");
    }

    public final EventDbModel newInstance() {
        return new EventDbModel();
    }

    public final void updateAutoIncrement(EventDbModel eventDbModel, Number number) {
        eventDbModel.id = number.intValue();
    }
}
