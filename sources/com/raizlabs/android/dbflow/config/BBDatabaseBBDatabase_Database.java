package com.raizlabs.android.dbflow.config;

import com.bigbee.db.BBDatabase;
import com.bigbee.db.EventDbModel_Table;

public final class BBDatabaseBBDatabase_Database extends DatabaseDefinition {
    public BBDatabaseBBDatabase_Database(DatabaseHolder databaseHolder) {
        addModelAdapter(new EventDbModel_Table(this), databaseHolder);
    }

    public final boolean areConsistencyChecksEnabled() {
        return false;
    }

    public final boolean backupEnabled() {
        return false;
    }

    public final Class<?> getAssociatedDatabaseClassFile() {
        return BBDatabase.class;
    }

    public final String getDatabaseName() {
        return BBDatabase.NAME;
    }

    public final int getDatabaseVersion() {
        return 1;
    }

    public final boolean isForeignKeysSupported() {
        return false;
    }
}
