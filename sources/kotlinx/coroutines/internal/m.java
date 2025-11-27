package kotlinx.coroutines.internal;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f18278a = new y("CONDITION_FALSE");

    /* renamed from: b  reason: collision with root package name */
    public static final Object f18279b = new y("LIST_EMPTY");

    public static final Object a() {
        return f18278a;
    }

    public static final n b(Object obj) {
        v vVar;
        n nVar;
        if (obj instanceof v) {
            vVar = (v) obj;
        } else {
            vVar = null;
        }
        if (vVar == null || (nVar = vVar.f18301a) == null) {
            return (n) obj;
        }
        return nVar;
    }
}
