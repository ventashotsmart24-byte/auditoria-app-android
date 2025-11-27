package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b0 implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5874a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EventInternal f5875b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f5876c;

    public /* synthetic */ b0(SQLiteEventStore sQLiteEventStore, EventInternal eventInternal, TransportContext transportContext) {
        this.f5874a = sQLiteEventStore;
        this.f5875b = eventInternal;
        this.f5876c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f5874a.lambda$persist$1(this.f5875b, this.f5876c, (SQLiteDatabase) obj);
    }
}
