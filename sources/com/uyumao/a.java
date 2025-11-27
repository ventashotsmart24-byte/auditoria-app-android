package com.uyumao;

import android.content.Context;
import com.uyumao.j;
import org.json.JSONArray;

public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f16249a;

    public a(Context context) {
        this.f16249a = context;
    }

    public void run() {
        try {
            Context context = this.f16249a;
            if (j.f16286a == null && context != null) {
                j.f16286a = context.getApplicationContext();
            }
            c.a(this.f16249a, c.a(this.f16249a, j.a.f16287a.a(), (JSONArray) null), false);
        } catch (Throwable unused) {
        }
    }
}
