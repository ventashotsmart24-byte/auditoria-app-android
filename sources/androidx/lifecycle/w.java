package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public final b f2341a;

    /* renamed from: b  reason: collision with root package name */
    public final x f2342b;

    public static class a extends d {

        /* renamed from: c  reason: collision with root package name */
        public static a f2343c;

        /* renamed from: b  reason: collision with root package name */
        public Application f2344b;

        public a(Application application) {
            this.f2344b = application;
        }

        public static a c(Application application) {
            if (f2343c == null) {
                f2343c = new a(application);
            }
            return f2343c;
        }

        public v a(Class cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                return (v) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f2344b});
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }
    }

    public interface b {
        v a(Class cls);
    }

    public static abstract class c extends e implements b {
        public abstract v c(String str, Class cls);
    }

    public static class d implements b {

        /* renamed from: a  reason: collision with root package name */
        public static d f2345a;

        public static d b() {
            if (f2345a == null) {
                f2345a = new d();
            }
            return f2345a;
        }

        public v a(Class cls) {
            try {
                return (v) cls.newInstance();
            } catch (InstantiationException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            }
        }
    }

    public static class e {
        public abstract void b(v vVar);
    }

    public w(x xVar, b bVar) {
        this.f2341a = bVar;
        this.f2342b = xVar;
    }

    public v a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public v b(String str, Class cls) {
        v vVar;
        v b10 = this.f2342b.b(str);
        if (cls.isInstance(b10)) {
            b bVar = this.f2341a;
            if (bVar instanceof e) {
                ((e) bVar).b(b10);
            }
            return b10;
        }
        b bVar2 = this.f2341a;
        if (bVar2 instanceof c) {
            vVar = ((c) bVar2).c(str, cls);
        } else {
            vVar = bVar2.a(cls);
        }
        this.f2342b.d(str, vVar);
        return vVar;
    }
}
