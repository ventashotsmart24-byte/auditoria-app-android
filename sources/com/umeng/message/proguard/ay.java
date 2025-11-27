package com.umeng.message.proguard;

import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

final class ay {

    /* renamed from: a  reason: collision with root package name */
    final bd f15479a = new bd(AgooConstants.MESSAGE_NOTIFICATION);

    private long e() {
        return this.f15479a.b("rep_ts", 0);
    }

    public final boolean a() {
        return this.f15479a.b("e_u", true);
    }

    public final long b() {
        return this.f15479a.b("req_ts", 0);
    }

    public final boolean c() {
        if (Math.abs(System.currentTimeMillis() - e()) < 60000) {
            return true;
        }
        return false;
    }

    public final String d() {
        String b10 = this.f15479a.b("info", "");
        if (!TextUtils.isEmpty(b10)) {
            try {
                return new String(bf.a(b10));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final void a(boolean z10) {
        this.f15479a.a("e_s", z10);
    }

    public final void b(boolean z10) {
        this.f15479a.a("sync", z10);
    }

    public final void a(long j10) {
        this.f15479a.a("rep_ts", j10);
    }
}
