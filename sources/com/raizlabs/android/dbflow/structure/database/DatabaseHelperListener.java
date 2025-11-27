package com.raizlabs.android.dbflow.structure.database;

public interface DatabaseHelperListener {
    void onCreate(DatabaseWrapper databaseWrapper);

    void onDowngrade(DatabaseWrapper databaseWrapper, int i10, int i11);

    void onOpen(DatabaseWrapper databaseWrapper);

    void onUpgrade(DatabaseWrapper databaseWrapper, int i10, int i11);
}
