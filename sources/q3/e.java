package q3;

import a4.r;
import com.fasterxml.jackson.databind.ser.std.k;
import d4.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import k3.a0;
import k3.c;
import k3.f;
import k3.j;
import n3.o;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class e implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final Class f8935c = Node.class;

    /* renamed from: d  reason: collision with root package name */
    public static final Class f8936d;

    /* renamed from: e  reason: collision with root package name */
    public static final e f8937e = new e();

    /* renamed from: a  reason: collision with root package name */
    public final Map f8938a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f8939b;

    static {
        Class<Document> cls = Document.class;
        f8936d = cls;
        try {
            a.a();
        } catch (Throwable unused) {
        }
    }

    public e() {
        HashMap hashMap = new HashMap();
        this.f8938a = hashMap;
        hashMap.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        hashMap.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap hashMap2 = new HashMap();
        this.f8939b = hashMap2;
        hashMap2.put("java.sql.Timestamp", k.f5767d);
        hashMap2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        hashMap2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        hashMap2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        hashMap2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public final boolean a(Class cls, Class cls2) {
        if (cls2 == null || !cls2.isAssignableFrom(cls)) {
            return false;
        }
        return true;
    }

    public k3.k b(j jVar, f fVar, c cVar) {
        Object f10;
        Class q10 = jVar.q();
        if (a(q10, f8935c)) {
            return (k3.k) f("com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer", jVar);
        }
        if (a(q10, f8936d)) {
            return (k3.k) f("com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer", jVar);
        }
        String name = q10.getName();
        String str = (String) this.f8938a.get(name);
        if (str != null) {
            return (k3.k) f(str, jVar);
        }
        if ((name.startsWith("javax.xml.") || d(q10, "javax.xml.")) && (f10 = f("com.fasterxml.jackson.databind.ext.CoreXMLDeserializers", jVar)) != null) {
            return ((o) f10).a(jVar, fVar, cVar);
        }
        return null;
    }

    public k3.o c(a0 a0Var, j jVar, c cVar) {
        Object f10;
        Class q10 = jVar.q();
        if (a(q10, f8935c)) {
            return (k3.o) f("com.fasterxml.jackson.databind.ext.DOMSerializer", jVar);
        }
        String name = q10.getName();
        Object obj = this.f8939b.get(name);
        if (obj != null) {
            if (obj instanceof k3.o) {
                return (k3.o) obj;
            }
            return (k3.o) f((String) obj, jVar);
        } else if ((name.startsWith("javax.xml.") || d(q10, "javax.xml.")) && (f10 = f("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", jVar)) != null) {
            return ((r) f10).c(a0Var, jVar, cVar);
        } else {
            return null;
        }
    }

    public final boolean d(Class<Object> cls, String str) {
        do {
            cls = cls.getSuperclass();
            if (cls == null || cls == Object.class) {
                return false;
            }
        } while (!cls.getName().startsWith(str));
        return true;
    }

    public final Object e(Class cls, j jVar) {
        try {
            return h.l(cls, false);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + h.G(jVar) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    public final Object f(String str, j jVar) {
        try {
            return e(Class.forName(str), jVar);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to find class `" + str + "` for handling values of type " + h.G(jVar) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }
}
