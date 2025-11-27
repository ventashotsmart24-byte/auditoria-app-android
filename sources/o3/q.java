package o3;

import d4.a;
import java.io.Serializable;
import k3.g;

public class q implements n3.q, Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final q f8528c = new q((Object) null);

    /* renamed from: d  reason: collision with root package name */
    public static final q f8529d = new q((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f8530a;

    /* renamed from: b  reason: collision with root package name */
    public final a f8531b;

    public q(Object obj) {
        a aVar;
        this.f8530a = obj;
        if (obj == null) {
            aVar = a.ALWAYS_NULL;
        } else {
            aVar = a.CONSTANT;
        }
        this.f8531b = aVar;
    }

    public static q a(Object obj) {
        if (obj == null) {
            return f8529d;
        }
        return new q(obj);
    }

    public static boolean b(n3.q qVar) {
        if (qVar == f8528c) {
            return true;
        }
        return false;
    }

    public static q c() {
        return f8529d;
    }

    public static q d() {
        return f8528c;
    }

    public Object getNullValue(g gVar) {
        return this.f8530a;
    }
}
