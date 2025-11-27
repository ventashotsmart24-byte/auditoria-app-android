package com.umeng.message.proguard;

import android.app.Activity;
import com.umeng.message.proguard.bx;

public abstract class da implements bx.a {

    /* renamed from: a  reason: collision with root package name */
    public cf f15727a = new cf();

    public void a(Activity activity) {
    }

    public void b() {
        cf cfVar = this.f15727a;
        if (cfVar != null) {
            cfVar.f15574a = null;
            this.f15727a = null;
        }
    }

    public final void a() {
        a((Activity) null);
    }

    public final void a(bx.d dVar) {
        this.f15727a.f15574a = dVar;
    }
}
