package com.raizlabs.android.dbflow.config;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class FlowConfig {
    private final Context context;
    private final Map<Class<?>, DatabaseConfig> databaseConfigMap;
    private final Set<Class<? extends DatabaseHolder>> databaseHolders;
    private final boolean openDatabasesOnInit;

    public static class Builder {
        final Context context;
        final Map<Class<?>, DatabaseConfig> databaseConfigMap = new HashMap();
        Set<Class<? extends DatabaseHolder>> databaseHolders = new HashSet();
        boolean openDatabasesOnInit;

        public Builder(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Builder addDatabaseConfig(DatabaseConfig databaseConfig) {
            this.databaseConfigMap.put(databaseConfig.databaseClass(), databaseConfig);
            return this;
        }

        public Builder addDatabaseHolder(Class<? extends DatabaseHolder> cls) {
            this.databaseHolders.add(cls);
            return this;
        }

        public FlowConfig build() {
            return new FlowConfig(this);
        }

        public Builder openDatabasesOnInit(boolean z10) {
            this.openDatabasesOnInit = z10;
            return this;
        }
    }

    public FlowConfig(Builder builder) {
        this.databaseHolders = Collections.unmodifiableSet(builder.databaseHolders);
        this.databaseConfigMap = builder.databaseConfigMap;
        this.context = builder.context;
        this.openDatabasesOnInit = builder.openDatabasesOnInit;
    }

    public static Builder builder(Context context2) {
        return new Builder(context2);
    }

    public Map<Class<?>, DatabaseConfig> databaseConfigMap() {
        return this.databaseConfigMap;
    }

    public Set<Class<? extends DatabaseHolder>> databaseHolders() {
        return this.databaseHolders;
    }

    public DatabaseConfig getConfigForDatabase(Class<?> cls) {
        return databaseConfigMap().get(cls);
    }

    public Context getContext() {
        return this.context;
    }

    public boolean openDatabasesOnInit() {
        return this.openDatabasesOnInit;
    }
}
