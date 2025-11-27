package p3;

import c3.i;
import c3.k;
import java.util.Collection;

public class h extends g {
    public h(k kVar, String str, i iVar, Class cls, String str2, Collection collection) {
        super(kVar, str, iVar, cls, str2, collection);
    }

    public static h v(k kVar, Object obj, String str, Collection collection) {
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        Class<?> cls2 = cls;
        k kVar2 = kVar;
        h hVar = new h(kVar2, String.format("Unrecognized field \"%s\" (class %s), not marked as ignorable", new Object[]{str, cls2.getName()}), kVar.z(), cls2, str, collection);
        hVar.n(obj, str);
        return hVar;
    }
}
