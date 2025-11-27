package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

abstract class NoModificationModel implements ReadOnlyModel {
    private transient RetrievalAdapter adapter;

    public static class InvalidSqlViewOperationException extends RuntimeException {
        public InvalidSqlViewOperationException(String str) {
            super(str);
        }
    }

    public boolean exists() {
        return getRetrievalAdapter().exists(this);
    }

    public RetrievalAdapter getRetrievalAdapter() {
        if (this.adapter == null) {
            this.adapter = FlowManager.getInstanceAdapter(getClass());
        }
        return this.adapter;
    }

    public void load() {
        getRetrievalAdapter().load(this);
    }

    public boolean exists(DatabaseWrapper databaseWrapper) {
        return getRetrievalAdapter().exists(this, databaseWrapper);
    }

    public void load(DatabaseWrapper databaseWrapper) {
        getRetrievalAdapter().load(this, databaseWrapper);
    }
}
