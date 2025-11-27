package com.umeng.message.proguard;

import android.view.View;
import com.umeng.message.proguard.bx;

public final class cf implements bx.d {

    /* renamed from: a  reason: collision with root package name */
    public bx.d f15574a;

    public final void a() {
        final bx.d dVar = this.f15574a;
        if (dVar != null) {
            cb.c(new Runnable() {
                public final void run() {
                    dVar.a();
                }
            });
        }
    }

    public final void b() {
        final bx.d dVar = this.f15574a;
        if (dVar != null) {
            cb.c(new Runnable() {
                public final void run() {
                    dVar.b();
                }
            });
        }
    }

    public final void a(final View view) {
        final bx.d dVar = this.f15574a;
        if (dVar != null) {
            cb.c(new Runnable() {
                public final void run() {
                    dVar.a(view);
                }
            });
        }
    }

    public final void a(final int i10, final String str) {
        final bx.d dVar = this.f15574a;
        if (dVar != null) {
            cb.c(new Runnable() {
                public final void run() {
                    dVar.a(i10, str);
                }
            });
        }
    }
}
