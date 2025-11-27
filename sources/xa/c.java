package xa;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class c {

    /* renamed from: q  reason: collision with root package name */
    public static String f9727q = "EventBus";

    /* renamed from: r  reason: collision with root package name */
    public static volatile c f9728r;

    /* renamed from: s  reason: collision with root package name */
    public static final d f9729s = new d();

    /* renamed from: t  reason: collision with root package name */
    public static final Map f9730t = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Map f9731a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f9732b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f9733c;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadLocal f9734d;

    /* renamed from: e  reason: collision with root package name */
    public final f f9735e;

    /* renamed from: f  reason: collision with root package name */
    public final b f9736f;

    /* renamed from: g  reason: collision with root package name */
    public final a f9737g;

    /* renamed from: h  reason: collision with root package name */
    public final m f9738h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f9739i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f9740j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f9741k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f9742l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f9743m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f9744n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f9745o;

    /* renamed from: p  reason: collision with root package name */
    public final int f9746p;

    public class a extends ThreadLocal {
        public a() {
        }

        /* renamed from: a */
        public C0131c initialValue() {
            return new C0131c();
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9748a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.greenrobot.eventbus.ThreadMode[] r0 = org.greenrobot.eventbus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9748a = r0
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.POSTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9748a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.MAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9748a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9748a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.greenrobot.eventbus.ThreadMode r1 = org.greenrobot.eventbus.ThreadMode.ASYNC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xa.c.b.<clinit>():void");
        }
    }

    /* renamed from: xa.c$c  reason: collision with other inner class name */
    public static final class C0131c {

        /* renamed from: a  reason: collision with root package name */
        public final List f9749a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public boolean f9750b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9751c;

        /* renamed from: d  reason: collision with root package name */
        public n f9752d;

        /* renamed from: e  reason: collision with root package name */
        public Object f9753e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9754f;
    }

    public c() {
        this(f9729s);
    }

    public static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static c c() {
        if (f9728r == null) {
            synchronized (c.class) {
                if (f9728r == null) {
                    f9728r = new c();
                }
            }
        }
        return f9728r;
    }

    public static List i(Class cls) {
        List list;
        Map map = f9730t;
        synchronized (map) {
            list = (List) map.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f9730t.put(cls, list);
            }
        }
        return list;
    }

    public final void b(n nVar, Object obj) {
        boolean z10;
        if (obj != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z10 = true;
            } else {
                z10 = false;
            }
            n(nVar, obj, z10);
        }
    }

    public ExecutorService d() {
        return this.f9739i;
    }

    public final void e(n nVar, Object obj, Throwable th) {
        if (obj instanceof k) {
            if (this.f9741k) {
                String str = f9727q;
                Log.e(str, "SubscriberExceptionEvent subscriber " + nVar.f9800a.getClass() + " threw an exception", th);
                k kVar = (k) obj;
                String str2 = f9727q;
                Log.e(str2, "Initial event " + kVar.f9780c + " caused exception in " + kVar.f9781d, kVar.f9779b);
            }
        } else if (!this.f9740j) {
            if (this.f9741k) {
                String str3 = f9727q;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + nVar.f9800a.getClass(), th);
            }
            if (this.f9743m) {
                j(new k(this, th, obj, nVar.f9800a));
            }
        } else {
            throw new e("Invoking subscriber failed", th);
        }
    }

    public void f(h hVar) {
        Object obj = hVar.f9773a;
        n nVar = hVar.f9774b;
        h.b(hVar);
        if (nVar.f9802c) {
            g(nVar, obj);
        }
    }

    public void g(n nVar, Object obj) {
        try {
            nVar.f9801b.f9782a.invoke(nVar.f9800a, new Object[]{obj});
        } catch (InvocationTargetException e10) {
            e(nVar, obj, e10.getCause());
        } catch (IllegalAccessException e11) {
            throw new IllegalStateException("Unexpected exception", e11);
        }
    }

    public synchronized boolean h(Object obj) {
        return this.f9732b.containsKey(obj);
    }

    public void j(Object obj) {
        boolean z10;
        C0131c cVar = (C0131c) this.f9734d.get();
        List list = cVar.f9749a;
        list.add(obj);
        if (!cVar.f9750b) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z10 = true;
            } else {
                z10 = false;
            }
            cVar.f9751c = z10;
            cVar.f9750b = true;
            if (!cVar.f9754f) {
                while (!list.isEmpty()) {
                    try {
                        k(list.remove(0), cVar);
                    } finally {
                        cVar.f9750b = false;
                        cVar.f9751c = false;
                    }
                }
                return;
            }
            throw new e("Internal error. Abort state was not reset");
        }
    }

    public final void k(Object obj, C0131c cVar) {
        boolean z10;
        Class<?> cls = obj.getClass();
        if (this.f9745o) {
            List i10 = i(cls);
            int size = i10.size();
            z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                z10 |= l(obj, cVar, (Class) i10.get(i11));
            }
        } else {
            z10 = l(obj, cVar, cls);
        }
        if (!z10) {
            if (this.f9742l) {
                StringBuilder sb = new StringBuilder();
                sb.append("No subscribers registered for event ");
                sb.append(cls);
            }
            if (this.f9744n && cls != g.class && cls != k.class) {
                j(new g(this, obj));
            }
        }
    }

    public final boolean l(Object obj, C0131c cVar, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9731a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            cVar.f9753e = obj;
            cVar.f9752d = nVar;
            try {
                n(nVar, obj, cVar.f9751c);
                if (cVar.f9754f) {
                    return true;
                }
            } finally {
                cVar.f9753e = null;
                cVar.f9752d = null;
                cVar.f9754f = false;
            }
        }
        return true;
    }

    public void m(Object obj) {
        synchronized (this.f9733c) {
            this.f9733c.put(obj.getClass(), obj);
        }
        j(obj);
    }

    public final void n(n nVar, Object obj, boolean z10) {
        int i10 = b.f9748a[nVar.f9801b.f9783b.ordinal()];
        if (i10 == 1) {
            g(nVar, obj);
        } else if (i10 != 2) {
            if (i10 != 3) {
                if (i10 == 4) {
                    this.f9737g.a(nVar, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + nVar.f9801b.f9783b);
            } else if (z10) {
                this.f9736f.a(nVar, obj);
            } else {
                g(nVar, obj);
            }
        } else if (z10) {
            g(nVar, obj);
        } else {
            this.f9735e.a(nVar, obj);
        }
    }

    public void o(Object obj) {
        List<l> a10 = this.f9738h.a(obj.getClass());
        synchronized (this) {
            for (l q10 : a10) {
                q(obj, q10);
            }
        }
    }

    public boolean p(Object obj) {
        synchronized (this.f9733c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f9733c.get(cls))) {
                return false;
            }
            this.f9733c.remove(cls);
            return true;
        }
    }

    public final void q(Object obj, l lVar) {
        Class cls = lVar.f9784c;
        n nVar = new n(obj, lVar);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9731a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f9731a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 > size) {
                break;
            } else if (i10 == size || lVar.f9785d > ((n) copyOnWriteArrayList.get(i10)).f9801b.f9785d) {
                copyOnWriteArrayList.add(i10, nVar);
            } else {
                i10++;
            }
        }
        copyOnWriteArrayList.add(i10, nVar);
        List list = (List) this.f9732b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f9732b.put(obj, list);
        }
        list.add(cls);
        if (!lVar.f9786e) {
            return;
        }
        if (this.f9745o) {
            for (Map.Entry entry : this.f9733c.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    b(nVar, entry.getValue());
                }
            }
            return;
        }
        b(nVar, this.f9733c.get(cls));
    }

    public synchronized void r(Object obj) {
        List<Class> list = (List) this.f9732b.get(obj);
        if (list != null) {
            for (Class s10 : list) {
                s(obj, s10);
            }
            this.f9732b.remove(obj);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Subscriber to unregister was not registered before: ");
            sb.append(obj.getClass());
        }
    }

    public final void s(Object obj, Class cls) {
        List list = (List) this.f9731a.get(cls);
        if (list != null) {
            int size = list.size();
            int i10 = 0;
            while (i10 < size) {
                n nVar = (n) list.get(i10);
                if (nVar.f9800a == obj) {
                    nVar.f9802c = false;
                    list.remove(i10);
                    i10--;
                    size--;
                }
                i10++;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f9746p + ", eventInheritance=" + this.f9745o + "]";
    }

    public c(d dVar) {
        this.f9734d = new a();
        this.f9731a = new HashMap();
        this.f9732b = new HashMap();
        this.f9733c = new ConcurrentHashMap();
        this.f9735e = new f(this, Looper.getMainLooper(), 10);
        this.f9736f = new b(this);
        this.f9737g = new a(this);
        List list = dVar.f9765j;
        this.f9746p = list != null ? list.size() : 0;
        this.f9738h = new m(dVar.f9765j, dVar.f9763h, dVar.f9762g);
        this.f9741k = dVar.f9756a;
        this.f9742l = dVar.f9757b;
        this.f9743m = dVar.f9758c;
        this.f9744n = dVar.f9759d;
        this.f9740j = dVar.f9760e;
        this.f9745o = dVar.f9761f;
        this.f9739i = dVar.f9764i;
    }
}
