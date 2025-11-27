package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;

public abstract class QueryModelAdapter<TQueryModel> extends InstanceAdapter<TQueryModel> {
    public QueryModelAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public boolean exists(TQueryModel tquerymodel) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }

    public OperatorGroup getPrimaryConditionClause(TQueryModel tquerymodel) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }

    public boolean exists(TQueryModel tquerymodel, DatabaseWrapper databaseWrapper) {
        throw new UnsupportedOperationException("QueryModels cannot check for existence");
    }
}
