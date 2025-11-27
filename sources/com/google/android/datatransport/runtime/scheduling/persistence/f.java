package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class f implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5878a;

    public /* synthetic */ f(SQLiteEventStore sQLiteEventStore) {
        this.f5878a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f5878a.lambda$recordFailure$3((Cursor) obj);
    }
}
