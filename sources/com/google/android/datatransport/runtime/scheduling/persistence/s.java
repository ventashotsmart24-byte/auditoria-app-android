package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class s implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5895a;

    public /* synthetic */ s(long j10) {
        this.f5895a = j10;
    }

    public final Object apply(Object obj) {
        return ((Cursor) obj).moveToNext();
    }
}
