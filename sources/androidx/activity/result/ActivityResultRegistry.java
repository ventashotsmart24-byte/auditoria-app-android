package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import o.j;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    public Random f506a = new Random();

    /* renamed from: b  reason: collision with root package name */
    public final Map f507b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map f508c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map f509d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f510e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final transient Map f511f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final Map f512g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f513h = new Bundle();

    public class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f518a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f519b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a f520c;

        public a(String str, int i10, c.a aVar) {
            this.f518a = str;
            this.f519b = i10;
            this.f520c = aVar;
        }

        public void b(Object obj, j jVar) {
            int i10;
            ActivityResultRegistry.this.f510e.add(this.f518a);
            Integer num = (Integer) ActivityResultRegistry.this.f508c.get(this.f518a);
            ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
            if (num != null) {
                i10 = num.intValue();
            } else {
                i10 = this.f519b;
            }
            activityResultRegistry.f(i10, this.f520c, obj, jVar);
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f518a);
        }
    }

    public class b extends c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f522a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f523b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a f524c;

        public b(String str, int i10, c.a aVar) {
            this.f522a = str;
            this.f523b = i10;
            this.f524c = aVar;
        }

        public void b(Object obj, j jVar) {
            int i10;
            ActivityResultRegistry.this.f510e.add(this.f522a);
            Integer num = (Integer) ActivityResultRegistry.this.f508c.get(this.f522a);
            ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
            if (num != null) {
                i10 = num.intValue();
            } else {
                i10 = this.f523b;
            }
            activityResultRegistry.f(i10, this.f524c, obj, jVar);
        }

        public void c() {
            ActivityResultRegistry.this.l(this.f522a);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f526a;

        /* renamed from: b  reason: collision with root package name */
        public final c.a f527b;

        public c(b bVar, c.a aVar) {
            this.f526a = bVar;
            this.f527b = aVar;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final androidx.lifecycle.d f528a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList f529b = new ArrayList();

        public d(androidx.lifecycle.d dVar) {
            this.f528a = dVar;
        }

        public void a(e eVar) {
            this.f528a.a(eVar);
            this.f529b.add(eVar);
        }

        public void b() {
            Iterator it = this.f529b.iterator();
            while (it.hasNext()) {
                this.f528a.c((e) it.next());
            }
            this.f529b.clear();
        }
    }

    public final void a(int i10, String str) {
        this.f507b.put(Integer.valueOf(i10), str);
        this.f508c.put(str, Integer.valueOf(i10));
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = (String) this.f507b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        this.f510e.remove(str);
        d(str, i11, intent, (c) this.f511f.get(str));
        return true;
    }

    public final boolean c(int i10, Object obj) {
        b bVar;
        String str = (String) this.f507b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        this.f510e.remove(str);
        c cVar = (c) this.f511f.get(str);
        if (cVar == null || (bVar = cVar.f526a) == null) {
            this.f513h.remove(str);
            this.f512g.put(str, obj);
            return true;
        }
        bVar.a(obj);
        return true;
    }

    public final void d(String str, int i10, Intent intent, c cVar) {
        b bVar;
        if (cVar == null || (bVar = cVar.f526a) == null) {
            this.f512g.remove(str);
            this.f513h.putParcelable(str, new a(i10, intent));
            return;
        }
        bVar.a(cVar.f527b.c(i10, intent));
    }

    public final int e() {
        int nextInt = this.f506a.nextInt(2147418112);
        while (true) {
            int i10 = nextInt + 65536;
            if (!this.f507b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            nextInt = this.f506a.nextInt(2147418112);
        }
    }

    public abstract void f(int i10, c.a aVar, Object obj, j jVar);

    public final void g(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                this.f510e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f506a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f513h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                    String str = stringArrayList.get(i10);
                    if (this.f508c.containsKey(str)) {
                        Integer num = (Integer) this.f508c.remove(str);
                        if (!this.f513h.containsKey(str)) {
                            this.f507b.remove(num);
                        }
                    }
                    a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f508c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f508c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f510e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f513h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f506a);
    }

    public final c i(final String str, g gVar, final c.a aVar, final b bVar) {
        androidx.lifecycle.d lifecycle = gVar.getLifecycle();
        if (!lifecycle.b().a(d.c.STARTED)) {
            int k10 = k(str);
            d dVar = (d) this.f509d.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            dVar.a(new e() {
                public void a(g gVar, d.b bVar) {
                    if (d.b.ON_START.equals(bVar)) {
                        ActivityResultRegistry.this.f511f.put(str, new c(bVar, aVar));
                        if (ActivityResultRegistry.this.f512g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f512g.get(str);
                            ActivityResultRegistry.this.f512g.remove(str);
                            bVar.a(obj);
                        }
                        a aVar = (a) ActivityResultRegistry.this.f513h.getParcelable(str);
                        if (aVar != null) {
                            ActivityResultRegistry.this.f513h.remove(str);
                            bVar.a(aVar.c(aVar.b(), aVar.a()));
                        }
                    } else if (d.b.ON_STOP.equals(bVar)) {
                        ActivityResultRegistry.this.f511f.remove(str);
                    } else if (d.b.ON_DESTROY.equals(bVar)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f509d.put(str, dVar);
            return new a(str, k10, aVar);
        }
        throw new IllegalStateException("LifecycleOwner " + gVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final c j(String str, c.a aVar, b bVar) {
        int k10 = k(str);
        this.f511f.put(str, new c(bVar, aVar));
        if (this.f512g.containsKey(str)) {
            Object obj = this.f512g.get(str);
            this.f512g.remove(str);
            bVar.a(obj);
        }
        a aVar2 = (a) this.f513h.getParcelable(str);
        if (aVar2 != null) {
            this.f513h.remove(str);
            bVar.a(aVar.c(aVar2.b(), aVar2.a()));
        }
        return new b(str, k10, aVar);
    }

    public final int k(String str) {
        Integer num = (Integer) this.f508c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int e10 = e();
        a(e10, str);
        return e10;
    }

    public final void l(String str) {
        Integer num;
        if (!this.f510e.contains(str) && (num = (Integer) this.f508c.remove(str)) != null) {
            this.f507b.remove(num);
        }
        this.f511f.remove(str);
        if (this.f512g.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Dropping pending result for request ");
            sb.append(str);
            sb.append(": ");
            sb.append(this.f512g.get(str));
            this.f512g.remove(str);
        }
        if (this.f513h.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.f513h.getParcelable(str));
            this.f513h.remove(str);
        }
        d dVar = (d) this.f509d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f509d.remove(str);
        }
    }
}
