package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

public final /* synthetic */ class i implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5882a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f5883b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5884c;

    public /* synthetic */ i(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f5882a = sQLiteEventStore;
        this.f5883b = list;
        this.f5884c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f5882a.lambda$loadEvents$14(this.f5883b, this.f5884c, (Cursor) obj);
    }
}
