package com.efs.sdk.pa.a;

import android.os.SystemClock;
import android.util.Printer;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Iterator;
import java.util.Vector;

final class e implements Printer {

    /* renamed from: a  reason: collision with root package name */
    Vector<d> f5550a = new Vector<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f5551b = false;

    /* renamed from: c  reason: collision with root package name */
    private String f5552c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f5553d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f5554e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f5555f;

    public final void println(String str) {
        if (str.startsWith(Operator.Operation.GREATER_THAN)) {
            this.f5553d = SystemClock.elapsedRealtime();
            this.f5554e = SystemClock.currentThreadTimeMillis();
            this.f5552c = str;
            this.f5551b = true;
            Iterator<d> it = this.f5550a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        } else if (this.f5551b && str.startsWith(Operator.Operation.LESS_THAN)) {
            this.f5551b = false;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f5553d;
            if (elapsedRealtime > this.f5555f) {
                long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis() - this.f5554e;
                Iterator<d> it2 = this.f5550a.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.f5552c, elapsedRealtime, currentThreadTimeMillis);
                }
            }
        }
    }
}
