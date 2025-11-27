package k7;

import java.util.ArrayList;
import java.util.List;

public class g implements i {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadLocal f18214a = new ThreadLocal();

    /* renamed from: b  reason: collision with root package name */
    public final List f18215b = new ArrayList();

    public void a(c cVar) {
        this.f18215b.add(cVar);
    }

    public void b(String str, Object... objArr) {
        j(4, (Throwable) null, str, objArr);
    }

    public void c(Object obj) {
        j(3, (Throwable) null, j.d(obj), new Object[0]);
    }

    public void d(String str, Object... objArr) {
        j(3, (Throwable) null, str, objArr);
    }

    public void e(String str, Object... objArr) {
        j(5, (Throwable) null, str, objArr);
    }

    public void f(Throwable th, String str, Object... objArr) {
        j(6, th, str, objArr);
    }

    public final String g(String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return str;
        }
        return String.format(str, objArr);
    }

    public final String h() {
        String str = (String) this.f18214a.get();
        if (str == null) {
            return null;
        }
        this.f18214a.remove();
        return str;
    }

    public synchronized void i(int i10, String str, String str2, Throwable th) {
        if (!(th == null || str2 == null)) {
            str2 = str2 + " : " + j.b(th);
        }
        if (th != null && str2 == null) {
            str2 = j.b(th);
        }
        if (j.c(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (c cVar : this.f18215b) {
            if (cVar.b(i10, str)) {
                cVar.a(i10, str, str2);
            }
        }
    }

    public final synchronized void j(int i10, Throwable th, String str, Object... objArr) {
        i(i10, h(), g(str, objArr), th);
    }
}
