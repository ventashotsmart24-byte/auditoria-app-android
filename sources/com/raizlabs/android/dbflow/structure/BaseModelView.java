package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public abstract class BaseModelView extends NoModificationModel {
    public /* bridge */ /* synthetic */ boolean exists() {
        return super.exists();
    }

    public /* bridge */ /* synthetic */ RetrievalAdapter getRetrievalAdapter() {
        return super.getRetrievalAdapter();
    }

    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    public /* bridge */ /* synthetic */ boolean exists(DatabaseWrapper databaseWrapper) {
        return super.exists(databaseWrapper);
    }

    public /* bridge */ /* synthetic */ void load(DatabaseWrapper databaseWrapper) {
        super.load(databaseWrapper);
    }
}
