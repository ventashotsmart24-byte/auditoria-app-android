package g3;

import c3.h;
import c3.k;
import java.util.HashSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f6764a;

    /* renamed from: b  reason: collision with root package name */
    public String f6765b;

    /* renamed from: c  reason: collision with root package name */
    public String f6766c;

    /* renamed from: d  reason: collision with root package name */
    public HashSet f6767d;

    public a(Object obj) {
        this.f6764a = obj;
    }

    public static a e(h hVar) {
        return new a(hVar);
    }

    public static a f(k kVar) {
        return new a(kVar);
    }

    public a a() {
        return new a(this.f6764a);
    }

    public Object b() {
        return this.f6764a;
    }

    public boolean c(String str) {
        String str2 = this.f6765b;
        if (str2 == null) {
            this.f6765b = str;
            return false;
        } else if (str.equals(str2)) {
            return true;
        } else {
            String str3 = this.f6766c;
            if (str3 == null) {
                this.f6766c = str;
                return false;
            } else if (str.equals(str3)) {
                return true;
            } else {
                if (this.f6767d == null) {
                    HashSet hashSet = new HashSet(16);
                    this.f6767d = hashSet;
                    hashSet.add(this.f6765b);
                    this.f6767d.add(this.f6766c);
                }
                return !this.f6767d.add(str);
            }
        }
    }

    public void d() {
        this.f6765b = null;
        this.f6766c = null;
        this.f6767d = null;
    }
}
