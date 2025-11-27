package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.w;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class t extends w.c {

    /* renamed from: f  reason: collision with root package name */
    public static final Class[] f2326f;

    /* renamed from: g  reason: collision with root package name */
    public static final Class[] f2327g;

    /* renamed from: a  reason: collision with root package name */
    public final Application f2328a;

    /* renamed from: b  reason: collision with root package name */
    public final w.b f2329b;

    /* renamed from: c  reason: collision with root package name */
    public final Bundle f2330c;

    /* renamed from: d  reason: collision with root package name */
    public final d f2331d;

    /* renamed from: e  reason: collision with root package name */
    public final SavedStateRegistry f2332e;

    static {
        Class<s> cls = s.class;
        f2326f = new Class[]{Application.class, cls};
        f2327g = new Class[]{cls};
    }

    public t(Application application, b bVar, Bundle bundle) {
        w.b bVar2;
        this.f2332e = bVar.getSavedStateRegistry();
        this.f2331d = bVar.getLifecycle();
        this.f2330c = bundle;
        this.f2328a = application;
        if (application != null) {
            bVar2 = w.a.c(application);
        } else {
            bVar2 = w.d.b();
        }
        this.f2329b = bVar2;
    }

    public static Constructor d(Class cls, Class[] clsArr) {
        for (Constructor constructor : cls.getConstructors()) {
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    public v a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return c(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public void b(v vVar) {
        SavedStateHandleController.b(vVar, this.f2332e, this.f2331d);
    }

    public v c(String str, Class cls) {
        Constructor constructor;
        v vVar;
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        if (!isAssignableFrom || this.f2328a == null) {
            constructor = d(cls, f2327g);
        } else {
            constructor = d(cls, f2326f);
        }
        if (constructor == null) {
            return this.f2329b.a(cls);
        }
        SavedStateHandleController d10 = SavedStateHandleController.d(this.f2332e, this.f2331d, str, this.f2330c);
        if (isAssignableFrom) {
            try {
                Application application = this.f2328a;
                if (application != null) {
                    vVar = (v) constructor.newInstance(new Object[]{application, d10.e()});
                    vVar.e("androidx.lifecycle.savedstate.vm.tag", d10);
                    return vVar;
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Failed to access " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
            }
        }
        vVar = (v) constructor.newInstance(new Object[]{d10.e()});
        vVar.e("androidx.lifecycle.savedstate.vm.tag", d10);
        return vVar;
    }
}
