package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class j implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5885a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f5886b;

    public /* synthetic */ j(SQLiteEventStore sQLiteEventStore, long j10) {
        this.f5885a = sQLiteEventStore;
        this.f5886b = j10;
    }

    public final Object apply(Object obj) {
        return this.f5885a.lambda$cleanUp$12(this.f5886b, (SQLiteDatabase) obj);
    }
}
