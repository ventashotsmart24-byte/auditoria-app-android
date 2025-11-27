package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class q implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5891a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5892b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5893c;

    public /* synthetic */ q(SQLiteEventStore sQLiteEventStore, String str, String str2) {
        this.f5891a = sQLiteEventStore;
        this.f5892b = str;
        this.f5893c = str2;
    }

    public final Object apply(Object obj) {
        return this.f5891a.lambda$recordFailure$4(this.f5892b, this.f5893c, (SQLiteDatabase) obj);
    }
}
