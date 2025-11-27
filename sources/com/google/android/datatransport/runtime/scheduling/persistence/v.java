package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class v implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f5896a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f5897b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f5898c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f5899d;

    public /* synthetic */ v(SQLiteEventStore sQLiteEventStore, String str, Map map, ClientMetrics.Builder builder) {
        this.f5896a = sQLiteEventStore;
        this.f5897b = str;
        this.f5898c = map;
        this.f5899d = builder;
    }

    public final Object apply(Object obj) {
        return this.f5896a.lambda$loadClientMetrics$20(this.f5897b, this.f5898c, this.f5899d, (SQLiteDatabase) obj);
    }
}
