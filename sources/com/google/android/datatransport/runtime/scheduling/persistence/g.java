package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class g implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5879a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5880b;

    public /* synthetic */ g(long j10, TransportContext transportContext) {
        this.f5879a = j10;
        this.f5880b = transportContext;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordNextCallTime$7(this.f5879a, this.f5880b, (SQLiteDatabase) obj);
    }
}
