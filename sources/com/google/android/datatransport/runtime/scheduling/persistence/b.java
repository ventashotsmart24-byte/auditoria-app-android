package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class b implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5871a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogEventDropped.Reason f5872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f5873c;

    public /* synthetic */ b(String str, LogEventDropped.Reason reason, long j10) {
        this.f5871a = str;
        this.f5872b = reason;
        this.f5873c = j10;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$18(this.f5871a, this.f5872b, this.f5873c, (SQLiteDatabase) obj);
    }
}
