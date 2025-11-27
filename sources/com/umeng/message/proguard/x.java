package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.util.Iterator;
import java.util.LinkedList;

public class x {

    /* renamed from: b  reason: collision with root package name */
    private static volatile x f16083b;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<ad> f16084a = new LinkedList<>();

    private x() {
    }

    public static x a() {
        if (f16083b == null) {
            synchronized (x.class) {
                if (f16083b == null) {
                    f16083b = new x();
                }
            }
        }
        return f16083b;
    }

    public final ad b() {
        ad pollFirst;
        synchronized (this.f16084a) {
            pollFirst = this.f16084a.pollFirst();
        }
        return pollFirst;
    }

    public final int c() {
        int size;
        synchronized (this.f16084a) {
            size = this.f16084a.size();
        }
        return size;
    }

    public final void b(ad adVar) {
        synchronized (this.f16084a) {
            this.f16084a.remove(adVar);
        }
    }

    public final void a(ad adVar) {
        synchronized (this.f16084a) {
            this.f16084a.addLast(adVar);
        }
    }

    public final ad a(String str) {
        synchronized (this.f16084a) {
            Iterator<ad> it = this.f16084a.iterator();
            while (it.hasNext()) {
                ad next = it.next();
                UMessage uMessage = next.f15320b;
                if (uMessage != null && TextUtils.equals(str, uMessage.getMsgId())) {
                    return next;
                }
            }
            return null;
        }
    }
}
