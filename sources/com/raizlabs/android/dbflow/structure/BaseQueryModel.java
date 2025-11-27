package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.structure.NoModificationModel;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public class BaseQueryModel extends NoModificationModel {
    public boolean exists() {
        throw new NoModificationModel.InvalidSqlViewOperationException("Query " + getClass().getName() + " does not exist as a table.It's a convenient representation of a complex SQLite query.");
    }

    public /* bridge */ /* synthetic */ RetrievalAdapter getRetrievalAdapter() {
        return super.getRetrievalAdapter();
    }

    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    public boolean exists(DatabaseWrapper databaseWrapper) {
        return exists();
    }

    public /* bridge */ /* synthetic */ void load(DatabaseWrapper databaseWrapper) {
        super.load(databaseWrapper);
    }
}
