package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class c implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchemaManager f5877a;

    public /* synthetic */ c(SchemaManager schemaManager) {
        this.f5877a = schemaManager;
    }

    public final Object produce() {
        return this.f5877a.getWritableDatabase();
    }
}
