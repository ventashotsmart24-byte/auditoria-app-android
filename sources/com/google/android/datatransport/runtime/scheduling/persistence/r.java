package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class r implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5894a;

    public /* synthetic */ r(SQLiteEventStore sQLiteEventStore) {
        this.f5894a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f5894a.lambda$cleanUp$11((Cursor) obj);
    }
}
