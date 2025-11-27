package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class k implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f5887a;

    public /* synthetic */ k(SQLiteDatabase sQLiteDatabase) {
        this.f5887a = sQLiteDatabase;
    }

    public final Object produce() {
        return this.f5887a.beginTransaction();
    }
}
