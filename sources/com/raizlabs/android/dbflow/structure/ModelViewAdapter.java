package com.raizlabs.android.dbflow.structure;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;

public abstract class ModelViewAdapter<TModelView> extends InstanceAdapter<TModelView> {
    public ModelViewAdapter(DatabaseDefinition databaseDefinition) {
        super(databaseDefinition);
    }

    public abstract String getCreationQuery();

    public abstract String getViewName();
}
