package com.efs.sdk.base.core.util.concurrent;

import com.efs.sdk.base.core.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private List<b<T>> f5314a = new ArrayList(5);

    /* renamed from: b  reason: collision with root package name */
    private c<T> f5315b;

    public d(c<T> cVar) {
        this.f5315b = cVar;
    }

    public final void a(List<b<T>> list) {
        this.f5314a.addAll(list);
    }

    public void run() {
        a();
    }

    public final T a() {
        T t10 = null;
        try {
            Iterator<b<T>> it = this.f5314a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            t10 = this.f5315b.a();
            for (b<T> a10 : this.f5314a) {
                a10.a(this.f5315b, t10);
            }
            for (b<T> result : this.f5314a) {
                result.result(t10);
            }
        } catch (Throwable th) {
            Log.w("efs.util.concurrent", th);
            Iterator<b<T>> it2 = this.f5314a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
        return t10;
    }
}
