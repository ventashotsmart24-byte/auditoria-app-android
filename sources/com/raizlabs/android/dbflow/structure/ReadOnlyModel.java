package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public interface ReadOnlyModel {
    boolean exists();

    boolean exists(DatabaseWrapper databaseWrapper);

    void load();

    void load(DatabaseWrapper databaseWrapper);
}
