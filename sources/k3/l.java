package k3;

import c3.h;
import c3.i;
import c3.k;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class l extends c3.l {

    /* renamed from: b  reason: collision with root package name */
    public LinkedList f7414b;

    /* renamed from: c  reason: collision with root package name */
    public transient Closeable f7415c;

    public l(Closeable closeable, String str) {
        super(str);
        this.f7415c = closeable;
        if (closeable instanceof k) {
            this.f4765a = ((k) closeable).c0();
        }
    }

    public static l g(h hVar, String str) {
        return new l((Closeable) hVar, str, (Throwable) null);
    }

    public static l h(h hVar, String str, Throwable th) {
        return new l((Closeable) hVar, str, th);
    }

    public static l i(k kVar, String str, Throwable th) {
        return new l((Closeable) kVar, str, th);
    }

    public static l j(g gVar, String str) {
        return new l(gVar.S(), str);
    }

    public static l k(g gVar, String str, Throwable th) {
        return new l((Closeable) gVar.S(), str, th);
    }

    public static l l(IOException iOException) {
        return new l((Closeable) null, String.format("Unexpected IOException (of type %s): %s", new Object[]{iOException.getClass().getName(), d4.h.o(iOException)}));
    }

    public static l p(Throwable th, Object obj, int i10) {
        return r(th, new a(obj, i10));
    }

    public static l q(Throwable th, Object obj, String str) {
        return r(th, new a(obj, str));
    }

    public static l r(Throwable th, a aVar) {
        l lVar;
        Closeable closeable;
        if (th instanceof l) {
            lVar = (l) th;
        } else {
            String o10 = d4.h.o(th);
            if (o10 == null || o10.isEmpty()) {
                o10 = "(was " + th.getClass().getName() + ")";
            }
            if (th instanceof c3.l) {
                Object d10 = ((c3.l) th).d();
                if (d10 instanceof Closeable) {
                    closeable = (Closeable) d10;
                    lVar = new l(closeable, o10, th);
                }
            }
            closeable = null;
            lVar = new l(closeable, o10, th);
        }
        lVar.o(aVar);
        return lVar;
    }

    public Object d() {
        return this.f7415c;
    }

    public void e(StringBuilder sb) {
        LinkedList linkedList = this.f7414b;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(((a) it.next()).toString());
                if (it.hasNext()) {
                    sb.append("->");
                }
            }
        }
    }

    public String f() {
        StringBuilder sb;
        String message = super.getMessage();
        if (this.f7414b == null) {
            return message;
        }
        if (message == null) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder(message);
        }
        sb.append(" (through reference chain: ");
        StringBuilder m10 = m(sb);
        m10.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        return m10.toString();
    }

    public String getLocalizedMessage() {
        return f();
    }

    public String getMessage() {
        return f();
    }

    public StringBuilder m(StringBuilder sb) {
        e(sb);
        return sb;
    }

    public void n(Object obj, String str) {
        o(new a(obj, str));
    }

    public void o(a aVar) {
        if (this.f7414b == null) {
            this.f7414b = new LinkedList();
        }
        if (this.f7414b.size() < 1000) {
            this.f7414b.addFirst(aVar);
        }
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public transient Object f7416a;

        /* renamed from: b  reason: collision with root package name */
        public String f7417b;

        /* renamed from: c  reason: collision with root package name */
        public int f7418c;

        /* renamed from: d  reason: collision with root package name */
        public String f7419d;

        public a(Object obj, String str) {
            this.f7418c = -1;
            this.f7416a = obj;
            if (str != null) {
                this.f7417b = str;
                return;
            }
            throw new NullPointerException("Cannot pass null fieldName");
        }

        public String a() {
            Class<?> cls;
            if (this.f7419d == null) {
                StringBuilder sb = new StringBuilder();
                Object obj = this.f7416a;
                if (obj != null) {
                    if (obj instanceof Class) {
                        cls = (Class) obj;
                    } else {
                        cls = obj.getClass();
                    }
                    int i10 = 0;
                    while (cls.isArray()) {
                        cls = cls.getComponentType();
                        i10++;
                    }
                    sb.append(cls.getName());
                    while (true) {
                        i10--;
                        if (i10 < 0) {
                            break;
                        }
                        sb.append("[]");
                    }
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append('[');
                if (this.f7417b != null) {
                    sb.append('\"');
                    sb.append(this.f7417b);
                    sb.append('\"');
                } else {
                    int i11 = this.f7418c;
                    if (i11 >= 0) {
                        sb.append(i11);
                    } else {
                        sb.append('?');
                    }
                }
                sb.append(']');
                this.f7419d = sb.toString();
            }
            return this.f7419d;
        }

        public String toString() {
            return a();
        }

        public a(Object obj, int i10) {
            this.f7416a = obj;
            this.f7418c = i10;
        }
    }

    public l(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.f7415c = closeable;
        if (th instanceof c3.l) {
            this.f4765a = ((c3.l) th).a();
        } else if (closeable instanceof k) {
            this.f4765a = ((k) closeable).c0();
        }
    }

    public l(Closeable closeable, String str, i iVar) {
        super(str, iVar);
        this.f7415c = closeable;
    }
}
