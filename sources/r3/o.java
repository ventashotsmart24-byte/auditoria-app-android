package r3;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class o {

    /* renamed from: b  reason: collision with root package name */
    public static final d4.b f9138b = new c();

    /* renamed from: a  reason: collision with root package name */
    public final Object f9139a;

    public static class a extends o {

        /* renamed from: c  reason: collision with root package name */
        public static final a f9140c = new a((Object) null);

        public a(Object obj) {
            super(obj);
        }

        public o a(Annotation annotation) {
            return new e(this.f9139a, annotation.annotationType(), annotation);
        }

        public p b() {
            return new p();
        }

        public d4.b c() {
            return o.f9138b;
        }

        public boolean f(Annotation annotation) {
            return false;
        }
    }

    public static class b extends o {

        /* renamed from: c  reason: collision with root package name */
        public final HashMap f9141c;

        public b(Object obj, Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            super(obj);
            HashMap hashMap = new HashMap();
            this.f9141c = hashMap;
            hashMap.put(cls, annotation);
            hashMap.put(cls2, annotation2);
        }

        public o a(Annotation annotation) {
            this.f9141c.put(annotation.annotationType(), annotation);
            return this;
        }

        public p b() {
            p pVar = new p();
            for (Annotation d10 : this.f9141c.values()) {
                pVar.d(d10);
            }
            return pVar;
        }

        public d4.b c() {
            if (this.f9141c.size() != 2) {
                return new p(this.f9141c);
            }
            Iterator it = this.f9141c.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it.next();
            return new f((Class) entry.getKey(), (Annotation) entry.getValue(), (Class) entry2.getKey(), (Annotation) entry2.getValue());
        }

        public boolean f(Annotation annotation) {
            return this.f9141c.containsKey(annotation.annotationType());
        }
    }

    public static class c implements d4.b, Serializable {
        public boolean a(Class cls) {
            return false;
        }

        public boolean b(Class[] clsArr) {
            return false;
        }

        public Annotation get(Class cls) {
            return null;
        }

        public int size() {
            return 0;
        }
    }

    public static class d implements d4.b, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Class f9142a;

        /* renamed from: b  reason: collision with root package name */
        public final Annotation f9143b;

        public d(Class cls, Annotation annotation) {
            this.f9142a = cls;
            this.f9143b = annotation;
        }

        public boolean a(Class cls) {
            if (this.f9142a == cls) {
                return true;
            }
            return false;
        }

        public boolean b(Class[] clsArr) {
            for (Class cls : clsArr) {
                if (cls == this.f9142a) {
                    return true;
                }
            }
            return false;
        }

        public Annotation get(Class cls) {
            if (this.f9142a == cls) {
                return this.f9143b;
            }
            return null;
        }

        public int size() {
            return 1;
        }
    }

    public static class e extends o {

        /* renamed from: c  reason: collision with root package name */
        public Class f9144c;

        /* renamed from: d  reason: collision with root package name */
        public Annotation f9145d;

        public e(Object obj, Class cls, Annotation annotation) {
            super(obj);
            this.f9144c = cls;
            this.f9145d = annotation;
        }

        public o a(Annotation annotation) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Class<? extends Annotation> cls = this.f9144c;
            if (cls != annotationType) {
                return new b(this.f9139a, cls, this.f9145d, annotationType, annotation);
            }
            this.f9145d = annotation;
            return this;
        }

        public p b() {
            return p.f(this.f9144c, this.f9145d);
        }

        public d4.b c() {
            return new d(this.f9144c, this.f9145d);
        }

        public boolean f(Annotation annotation) {
            if (annotation.annotationType() == this.f9144c) {
                return true;
            }
            return false;
        }
    }

    public static class f implements d4.b, Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Class f9146a;

        /* renamed from: b  reason: collision with root package name */
        public final Class f9147b;

        /* renamed from: c  reason: collision with root package name */
        public final Annotation f9148c;

        /* renamed from: d  reason: collision with root package name */
        public final Annotation f9149d;

        public f(Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            this.f9146a = cls;
            this.f9148c = annotation;
            this.f9147b = cls2;
            this.f9149d = annotation2;
        }

        public boolean a(Class cls) {
            if (this.f9146a == cls || this.f9147b == cls) {
                return true;
            }
            return false;
        }

        public boolean b(Class[] clsArr) {
            for (Class cls : clsArr) {
                if (cls == this.f9146a || cls == this.f9147b) {
                    return true;
                }
            }
            return false;
        }

        public Annotation get(Class cls) {
            if (this.f9146a == cls) {
                return this.f9148c;
            }
            if (this.f9147b == cls) {
                return this.f9149d;
            }
            return null;
        }

        public int size() {
            return 2;
        }
    }

    public o(Object obj) {
        this.f9139a = obj;
    }

    public static d4.b d() {
        return f9138b;
    }

    public static o e() {
        return a.f9140c;
    }

    public abstract o a(Annotation annotation);

    public abstract p b();

    public abstract d4.b c();

    public abstract boolean f(Annotation annotation);
}
