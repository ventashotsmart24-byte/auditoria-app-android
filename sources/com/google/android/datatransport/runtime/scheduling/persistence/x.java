package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class x implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f5902b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f5903c;

    public /* synthetic */ x(SQLiteEventStore sQLiteEventStore, Map map, ClientMetrics.Builder builder) {
        this.f5901a = sQLiteEventStore;
        this.f5902b = map;
        this.f5903c = builder;
    }

    public final Object apply(Object obj) {
        return this.f5901a.lambda$loadClientMetrics$19(this.f5902b, this.f5903c, (Cursor) obj);
    }
}
