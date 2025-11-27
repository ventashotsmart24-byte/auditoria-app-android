package com.mobile.brasiltv.utils;

import android.app.Activity;
import android.content.Context;
import com.mobile.brasiltv.app.App;
import java.util.Stack;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f12493b;

    /* renamed from: a  reason: collision with root package name */
    public Stack f12494a;

    public static Context a() {
        Activity c10 = b().c();
        if (c10 == null) {
            return App.f6051f;
        }
        return c10;
    }

    public static a b() {
        if (f12493b == null) {
            f12493b = new a();
        }
        return f12493b;
    }

    public Activity c() {
        Stack stack = this.f12494a;
        if (stack == null || stack.empty()) {
            return null;
        }
        return (Activity) this.f12494a.lastElement();
    }

    public void d(Activity activity) {
        Stack stack = this.f12494a;
        if (stack != null && stack.size() > 0 && activity != null) {
            this.f12494a.remove(activity);
        }
    }

    public void e() {
        Activity c10;
        Stack stack = this.f12494a;
        if (stack != null && stack.size() > 0) {
            while (this.f12494a.size() > 0 && (c10 = c()) != null) {
                c10.finish();
                this.f12494a.remove(c10);
            }
        }
    }

    public void f(Activity activity) {
        if (this.f12494a == null) {
            this.f12494a = new Stack();
        }
        this.f12494a.add(activity);
    }
}
