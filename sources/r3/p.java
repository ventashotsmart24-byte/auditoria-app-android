package r3;

import d4.b;
import java.lang.annotation.Annotation;
import java.util.HashMap;

public final class p implements b {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f9150a;

    public p() {
    }

    public p(HashMap hashMap) {
        this.f9150a = hashMap;
    }

    public static p e(p pVar, p pVar2) {
        HashMap hashMap;
        HashMap hashMap2;
        if (pVar == null || (hashMap = pVar.f9150a) == null || hashMap.isEmpty()) {
            return pVar2;
        }
        if (pVar2 == null || (hashMap2 = pVar2.f9150a) == null || hashMap2.isEmpty()) {
            return pVar;
        }
        HashMap hashMap3 = new HashMap();
        for (Annotation annotation : pVar2.f9150a.values()) {
            hashMap3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : pVar.f9150a.values()) {
            hashMap3.put(annotation2.annotationType(), annotation2);
        }
        return new p(hashMap3);
    }

    public static p f(Class cls, Annotation annotation) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(cls, annotation);
        return new p(hashMap);
    }

    public boolean a(Class cls) {
        HashMap hashMap = this.f9150a;
        if (hashMap == null) {
            return false;
        }
        return hashMap.containsKey(cls);
    }

    public boolean b(Class[] clsArr) {
        if (this.f9150a != null) {
            for (Class containsKey : clsArr) {
                if (this.f9150a.containsKey(containsKey)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean c(Annotation annotation) {
        if (this.f9150a == null) {
            this.f9150a = new HashMap();
        }
        Annotation annotation2 = (Annotation) this.f9150a.put(annotation.annotationType(), annotation);
        if (annotation2 == null || !annotation2.equals(annotation)) {
            return true;
        }
        return false;
    }

    public boolean d(Annotation annotation) {
        return c(annotation);
    }

    public Annotation get(Class cls) {
        HashMap hashMap = this.f9150a;
        if (hashMap == null) {
            return null;
        }
        return (Annotation) hashMap.get(cls);
    }

    public int size() {
        HashMap hashMap = this.f9150a;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public String toString() {
        HashMap hashMap = this.f9150a;
        if (hashMap == null) {
            return "[null]";
        }
        return hashMap.toString();
    }
}
