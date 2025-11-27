package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;

public class al {

    /* renamed from: a  reason: collision with root package name */
    private String f13725a;

    /* renamed from: b  reason: collision with root package name */
    private int f13726b;

    /* renamed from: c  reason: collision with root package name */
    private int f13727c;

    /* renamed from: d  reason: collision with root package name */
    private int f13728d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13729e = false;

    public al(String str) {
        this.f13725a = str;
        this.f13728d = -1;
        this.f13727c = -1;
        this.f13726b = -1;
        if (!TextUtils.isEmpty(str)) {
            a();
        }
    }

    private void a() {
        try {
            if (this.f13725a.contains(Operator.Operation.MINUS)) {
                String[] split = this.f13725a.split(Operator.Operation.MINUS);
                if (split.length == 2) {
                    this.f13726b = Integer.valueOf(split[0]).intValue();
                    int intValue = Integer.valueOf(split[1]).intValue();
                    this.f13727c = intValue;
                    if (this.f13726b < 1) {
                        this.f13726b = 1;
                    }
                    if (intValue > 24) {
                        this.f13727c = 24;
                    }
                }
                this.f13729e = true;
                return;
            }
            this.f13728d = Integer.valueOf(this.f13725a).intValue();
            this.f13729e = false;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r5) {
        /*
            r4 = this;
            boolean r0 = r4.f13729e
            r1 = 1
            r2 = -1
            if (r0 == 0) goto L_0x0013
            int r0 = r4.f13726b
            if (r0 == r2) goto L_0x001a
            int r3 = r4.f13727c
            if (r3 == r2) goto L_0x001a
            if (r5 < r0) goto L_0x001a
            if (r5 > r3) goto L_0x001a
            goto L_0x001b
        L_0x0013:
            int r0 = r4.f13728d
            if (r0 == r2) goto L_0x001a
            if (r5 != r0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.al.a(int):boolean");
    }
}
