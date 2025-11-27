package com.raizlabs.android.dbflow.structure.listener;

import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;

public interface SQLiteStatementListener {
    void onBindToDeleteStatement(DatabaseStatement databaseStatement);

    void onBindToInsertStatement(DatabaseStatement databaseStatement);

    void onBindToStatement(DatabaseStatement databaseStatement);

    void onBindToUpdateStatement(DatabaseStatement databaseStatement);
}
