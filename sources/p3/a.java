package p3;

import c3.i;
import c3.k;
import java.util.Collection;

public class a extends g {
    public a(k kVar, String str, i iVar, Class cls, String str2, Collection collection) {
        super(kVar, str, iVar, cls, str2, collection);
    }

    public static a v(k kVar, Object obj, String str, Collection collection) {
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        Class<?> cls2 = cls;
        k kVar2 = kVar;
        a aVar = new a(kVar2, String.format("Ignored field \"%s\" (class %s) encountered; mapper configured not to allow this", new Object[]{str, cls2.getName()}), kVar.z(), cls2, str, collection);
        aVar.n(obj, str);
        return aVar;
    }
}
