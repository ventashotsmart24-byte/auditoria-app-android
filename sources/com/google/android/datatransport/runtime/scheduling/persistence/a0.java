package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class a0 implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5869a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5870b;

    public /* synthetic */ a0(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f5869a = sQLiteEventStore;
        this.f5870b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f5869a.lambda$hasPendingEventsFor$6(this.f5870b, (SQLiteDatabase) obj);
    }
}
