package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class o implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5889a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5890b;

    public /* synthetic */ o(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f5889a = sQLiteEventStore;
        this.f5890b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f5889a.lambda$loadBatch$8(this.f5890b, (SQLiteDatabase) obj);
    }
}
