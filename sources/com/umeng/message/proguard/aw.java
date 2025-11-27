package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Intent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import org.json.JSONObject;

public final class aw implements UPushMessageNotifyApi {

    /* renamed from: d  reason: collision with root package name */
    private static final aw f15463d = new aw();

    /* renamed from: a  reason: collision with root package name */
    public final ax f15464a = new ax();

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f15465b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15466c = true;

    private aw() {
    }

    public static aw a() {
        return f15463d;
    }

    public final void b() {
        if (!this.f15465b) {
            this.f15465b = true;
            this.f15464a.a();
        }
    }

    public final boolean isEnabled() {
        return this.f15464a.f15468b.a();
    }

    public final void setCallback(UPushMessageNotifyApi.Callback callback) {
        ax axVar = this.f15464a;
        axVar.f15467a = callback;
        if (callback != null && axVar.f15469c) {
            try {
                callback.onNotified();
                axVar.f15469c = false;
            } catch (Throwable unused) {
            }
        }
    }

    public final void setEnable(boolean z10) {
        this.f15466c = z10;
        ax axVar = this.f15464a;
        if (axVar.f15468b.a() != z10) {
            axVar.f15468b.f15479a.a("e_u", z10);
            b.b(new Runnable(z10) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f15477a;

                {
                    this.f15477a = r2;
                }

                public final void run() {
                    ax.this.f15468b.b(true);
                    boolean z10 = false;
                    try {
                        if (d.h(y.a())) {
                            z10 = ax.a(this.f15477a);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ax.this.f15468b.b(!z10);
                }
            });
        }
    }

    public final void a(JSONObject jSONObject) {
        this.f15464a.a(jSONObject);
    }

    public final void a(Activity activity, Intent intent) {
        this.f15464a.a(activity, intent);
    }
}
