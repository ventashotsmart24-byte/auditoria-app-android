package n0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.hpplay.component.protocol.PlistBuilder;
import com.umeng.analytics.pro.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n0.p0;
import n0.t0;

public final class q1 extends p0 implements ServiceConnection {

    /* renamed from: q  reason: collision with root package name */
    public static final boolean f8006q = Log.isLoggable("MediaRouteProviderProxy", 3);

    /* renamed from: i  reason: collision with root package name */
    public final ComponentName f8007i;

    /* renamed from: j  reason: collision with root package name */
    public final d f8008j;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f8009k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public boolean f8010l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f8011m;

    /* renamed from: n  reason: collision with root package name */
    public a f8012n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f8013o;

    /* renamed from: p  reason: collision with root package name */
    public b f8014p;

    public final class a implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final Messenger f8015a;

        /* renamed from: b  reason: collision with root package name */
        public final e f8016b;

        /* renamed from: c  reason: collision with root package name */
        public final Messenger f8017c;

        /* renamed from: d  reason: collision with root package name */
        public int f8018d = 1;

        /* renamed from: e  reason: collision with root package name */
        public int f8019e = 1;

        /* renamed from: f  reason: collision with root package name */
        public int f8020f;

        /* renamed from: g  reason: collision with root package name */
        public int f8021g;

        /* renamed from: h  reason: collision with root package name */
        public final SparseArray f8022h = new SparseArray();

        /* renamed from: n0.q1$a$a  reason: collision with other inner class name */
        public class C0101a implements Runnable {
            public C0101a() {
            }

            public void run() {
                a.this.e();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            public void run() {
                a aVar = a.this;
                q1.this.J(aVar);
            }
        }

        public a(Messenger messenger) {
            this.f8015a = messenger;
            e eVar = new e(this);
            this.f8016b = eVar;
            this.f8017c = new Messenger(eVar);
        }

        public void a(int i10, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = this.f8018d;
            this.f8018d = i11 + 1;
            s(12, i11, i10, (Object) null, bundle);
        }

        public int b(String str, t0.d dVar) {
            int i10 = this.f8019e;
            this.f8019e = i10 + 1;
            int i11 = this.f8018d;
            this.f8018d = i11 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            s(11, i11, i10, (Object) null, bundle);
            this.f8022h.put(i11, dVar);
            return i10;
        }

        public void binderDied() {
            q1.this.f8008j.post(new b());
        }

        public int c(String str, String str2) {
            int i10 = this.f8019e;
            this.f8019e = i10 + 1;
            Bundle bundle = new Bundle();
            bundle.putString("routeId", str);
            bundle.putString("routeGroupId", str2);
            int i11 = this.f8018d;
            this.f8018d = i11 + 1;
            s(3, i11, i10, (Object) null, bundle);
            return i10;
        }

        public void d() {
            s(2, 0, 0, (Object) null, (Bundle) null);
            this.f8016b.a();
            this.f8015a.getBinder().unlinkToDeath(this, 0);
            q1.this.f8008j.post(new C0101a());
        }

        public void e() {
            int size = this.f8022h.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((t0.d) this.f8022h.valueAt(i10)).a((String) null, (Bundle) null);
            }
            this.f8022h.clear();
        }

        public boolean f(int i10, String str, Bundle bundle) {
            t0.d dVar = (t0.d) this.f8022h.get(i10);
            if (dVar == null) {
                return false;
            }
            this.f8022h.remove(i10);
            dVar.a(str, bundle);
            return true;
        }

        public boolean g(int i10, Bundle bundle) {
            t0.d dVar = (t0.d) this.f8022h.get(i10);
            if (dVar == null) {
                return false;
            }
            this.f8022h.remove(i10);
            dVar.b(bundle);
            return true;
        }

        public void h(int i10) {
            q1.this.H(this, i10);
        }

        public boolean i(Bundle bundle) {
            if (this.f8020f == 0) {
                return false;
            }
            q1.this.I(this, q0.a(bundle));
            return true;
        }

        public void j(int i10, Bundle bundle) {
            t0.d dVar = (t0.d) this.f8022h.get(i10);
            if (bundle == null || !bundle.containsKey("routeId")) {
                dVar.a("DynamicGroupRouteController is created without valid route id.", bundle);
                return;
            }
            this.f8022h.remove(i10);
            dVar.b(bundle);
        }

        public boolean k(int i10, Bundle bundle) {
            n0 n0Var;
            if (this.f8020f == 0) {
                return false;
            }
            Bundle bundle2 = (Bundle) bundle.getParcelable("groupRoute");
            if (bundle2 != null) {
                n0Var = n0.d(bundle2);
            } else {
                n0Var = null;
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("dynamicRoutes");
            ArrayList arrayList = new ArrayList();
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(p0.b.c.a((Bundle) it.next()));
            }
            q1.this.N(this, i10, n0Var, arrayList);
            return true;
        }

        public boolean l(int i10) {
            if (i10 == this.f8021g) {
                this.f8021g = 0;
                q1.this.K(this, "Registration failed");
            }
            t0.d dVar = (t0.d) this.f8022h.get(i10);
            if (dVar == null) {
                return true;
            }
            this.f8022h.remove(i10);
            dVar.a((String) null, (Bundle) null);
            return true;
        }

        public boolean m(int i10) {
            return true;
        }

        public boolean n(int i10, int i11, Bundle bundle) {
            if (this.f8020f != 0 || i10 != this.f8021g || i11 < 1) {
                return false;
            }
            this.f8021g = 0;
            this.f8020f = i11;
            q1.this.I(this, q0.a(bundle));
            q1.this.L(this);
            return true;
        }

        public boolean o() {
            int i10 = this.f8018d;
            this.f8018d = i10 + 1;
            this.f8021g = i10;
            if (!s(1, i10, 4, (Object) null, (Bundle) null)) {
                return false;
            }
            try {
                this.f8015a.getBinder().linkToDeath(this, 0);
                return true;
            } catch (RemoteException unused) {
                binderDied();
                return false;
            }
        }

        public void p(int i10) {
            int i11 = this.f8018d;
            this.f8018d = i11 + 1;
            s(4, i11, i10, (Object) null, (Bundle) null);
        }

        public void q(int i10, String str) {
            Bundle bundle = new Bundle();
            bundle.putString("memberRouteId", str);
            int i11 = this.f8018d;
            this.f8018d = i11 + 1;
            s(13, i11, i10, (Object) null, bundle);
        }

        public void r(int i10) {
            int i11 = this.f8018d;
            this.f8018d = i11 + 1;
            s(5, i11, i10, (Object) null, (Bundle) null);
        }

        public final boolean s(int i10, int i11, int i12, Object obj, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            obtain.arg1 = i11;
            obtain.arg2 = i12;
            obtain.obj = obj;
            obtain.setData(bundle);
            obtain.replyTo = this.f8017c;
            try {
                this.f8015a.send(obtain);
                return true;
            } catch (DeadObjectException unused) {
                return false;
            } catch (RemoteException e10) {
                if (i10 == 2) {
                    return false;
                }
                Log.e("MediaRouteProviderProxy", "Could not send message to service.", e10);
                return false;
            }
        }

        public void t(o0 o0Var) {
            Bundle bundle;
            int i10 = this.f8018d;
            this.f8018d = i10 + 1;
            if (o0Var != null) {
                bundle = o0Var.a();
            } else {
                bundle = null;
            }
            s(10, i10, 0, bundle, (Bundle) null);
        }

        public void u(int i10, int i11) {
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i11);
            int i12 = this.f8018d;
            this.f8018d = i12 + 1;
            s(7, i12, i10, (Object) null, bundle);
        }

        public void v(int i10, int i11) {
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", i11);
            int i12 = this.f8018d;
            this.f8018d = i12 + 1;
            s(6, i12, i10, (Object) null, bundle);
        }

        public void w(int i10, List list) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("memberRouteIds", new ArrayList(list));
            int i11 = this.f8018d;
            this.f8018d = i11 + 1;
            s(14, i11, i10, (Object) null, bundle);
        }

        public void x(int i10, int i11) {
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i11);
            int i12 = this.f8018d;
            this.f8018d = i12 + 1;
            s(8, i12, i10, (Object) null, bundle);
        }
    }

    public interface b {
        void a(p0.e eVar);
    }

    public interface c {
        void a(a aVar);

        int b();

        void c();
    }

    public static final class d extends Handler {
    }

    public static final class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f8026a;

        public e(a aVar) {
            this.f8026a = new WeakReference(aVar);
        }

        public void a() {
            this.f8026a.clear();
        }

        public final boolean b(a aVar, int i10, int i11, int i12, Object obj, Bundle bundle) {
            String str;
            switch (i10) {
                case 0:
                    aVar.l(i11);
                    return true;
                case 1:
                    aVar.m(i11);
                    return true;
                case 2:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.n(i11, i12, (Bundle) obj);
                    }
                    return false;
                case 3:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.g(i11, (Bundle) obj);
                    }
                    return false;
                case 4:
                    if (obj != null && !(obj instanceof Bundle)) {
                        return false;
                    }
                    if (bundle == null) {
                        str = null;
                    } else {
                        str = bundle.getString("error");
                    }
                    return aVar.f(i11, str, (Bundle) obj);
                case 5:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.i((Bundle) obj);
                    }
                    return false;
                case 6:
                    if (!(obj instanceof Bundle)) {
                        return false;
                    }
                    aVar.j(i11, (Bundle) obj);
                    return false;
                case 7:
                    if (obj == null || (obj instanceof Bundle)) {
                        return aVar.k(i12, (Bundle) obj);
                    }
                    return false;
                case 8:
                    aVar.h(i12);
                    return false;
                default:
                    return false;
            }
        }

        public void handleMessage(Message message) {
            a aVar = (a) this.f8026a.get();
            if (aVar != null) {
                if (!b(aVar, message.what, message.arg1, message.arg2, message.obj, message.peekData()) && q1.f8006q) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unhandled message from server: ");
                    sb.append(message);
                }
            }
        }
    }

    public final class f extends p0.b implements c {

        /* renamed from: f  reason: collision with root package name */
        public final String f8027f;

        /* renamed from: g  reason: collision with root package name */
        public String f8028g;

        /* renamed from: h  reason: collision with root package name */
        public String f8029h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f8030i;

        /* renamed from: j  reason: collision with root package name */
        public int f8031j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f8032k;

        /* renamed from: l  reason: collision with root package name */
        public a f8033l;

        /* renamed from: m  reason: collision with root package name */
        public int f8034m = -1;

        public class a extends t0.d {
            public a() {
            }

            public void a(String str, Bundle bundle) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error: ");
                sb.append(str);
                sb.append(", data: ");
                sb.append(bundle);
            }

            public void b(Bundle bundle) {
                f.this.f8028g = bundle.getString("groupableTitle");
                f.this.f8029h = bundle.getString("transferableTitle");
            }
        }

        public f(String str) {
            this.f8027f = str;
        }

        public void a(a aVar) {
            a aVar2 = new a();
            this.f8033l = aVar;
            int b10 = aVar.b(this.f8027f, aVar2);
            this.f8034m = b10;
            if (this.f8030i) {
                aVar.r(b10);
                int i10 = this.f8031j;
                if (i10 >= 0) {
                    aVar.u(this.f8034m, i10);
                    this.f8031j = -1;
                }
                int i11 = this.f8032k;
                if (i11 != 0) {
                    aVar.x(this.f8034m, i11);
                    this.f8032k = 0;
                }
            }
        }

        public int b() {
            return this.f8034m;
        }

        public void c() {
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.p(this.f8034m);
                this.f8033l = null;
                this.f8034m = 0;
            }
        }

        public void d() {
            q1.this.M(this);
        }

        public void e() {
            this.f8030i = true;
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.r(this.f8034m);
            }
        }

        public void f(int i10) {
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.u(this.f8034m, i10);
                return;
            }
            this.f8031j = i10;
            this.f8032k = 0;
        }

        public void g() {
            h(0);
        }

        public void h(int i10) {
            this.f8030i = false;
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.v(this.f8034m, i10);
            }
        }

        public void i(int i10) {
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.x(this.f8034m, i10);
            } else {
                this.f8032k += i10;
            }
        }

        public String j() {
            return this.f8028g;
        }

        public String k() {
            return this.f8029h;
        }

        public void m(String str) {
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.a(this.f8034m, str);
            }
        }

        public void n(String str) {
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.q(this.f8034m, str);
            }
        }

        public void o(List list) {
            a aVar = this.f8033l;
            if (aVar != null) {
                aVar.w(this.f8034m, list);
            }
        }

        public void q(n0 n0Var, List list) {
            l(n0Var, list);
        }
    }

    public final class g extends p0.e implements c {

        /* renamed from: a  reason: collision with root package name */
        public final String f8037a;

        /* renamed from: b  reason: collision with root package name */
        public final String f8038b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8039c;

        /* renamed from: d  reason: collision with root package name */
        public int f8040d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f8041e;

        /* renamed from: f  reason: collision with root package name */
        public a f8042f;

        /* renamed from: g  reason: collision with root package name */
        public int f8043g;

        public g(String str, String str2) {
            this.f8037a = str;
            this.f8038b = str2;
        }

        public void a(a aVar) {
            this.f8042f = aVar;
            int c10 = aVar.c(this.f8037a, this.f8038b);
            this.f8043g = c10;
            if (this.f8039c) {
                aVar.r(c10);
                int i10 = this.f8040d;
                if (i10 >= 0) {
                    aVar.u(this.f8043g, i10);
                    this.f8040d = -1;
                }
                int i11 = this.f8041e;
                if (i11 != 0) {
                    aVar.x(this.f8043g, i11);
                    this.f8041e = 0;
                }
            }
        }

        public int b() {
            return this.f8043g;
        }

        public void c() {
            a aVar = this.f8042f;
            if (aVar != null) {
                aVar.p(this.f8043g);
                this.f8042f = null;
                this.f8043g = 0;
            }
        }

        public void d() {
            q1.this.M(this);
        }

        public void e() {
            this.f8039c = true;
            a aVar = this.f8042f;
            if (aVar != null) {
                aVar.r(this.f8043g);
            }
        }

        public void f(int i10) {
            a aVar = this.f8042f;
            if (aVar != null) {
                aVar.u(this.f8043g, i10);
                return;
            }
            this.f8040d = i10;
            this.f8041e = 0;
        }

        public void g() {
            h(0);
        }

        public void h(int i10) {
            this.f8039c = false;
            a aVar = this.f8042f;
            if (aVar != null) {
                aVar.v(this.f8043g, i10);
            }
        }

        public void i(int i10) {
            a aVar = this.f8042f;
            if (aVar != null) {
                aVar.x(this.f8043g, i10);
            } else {
                this.f8041e += i10;
            }
        }
    }

    public q1(Context context, ComponentName componentName) {
        super(context, new p0.d(componentName));
        this.f8007i = componentName;
        this.f8008j = new d();
    }

    public final void A() {
        int i10;
        if (!this.f8011m) {
            boolean z10 = f8006q;
            if (z10) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Binding");
            }
            Intent intent = new Intent("android.media.MediaRouteProviderService");
            intent.setComponent(this.f8007i);
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i10 = q.a.f14388a;
                } else {
                    i10 = 1;
                }
                boolean bindService = n().bindService(intent, this, i10);
                this.f8011m = bindService;
                if (!bindService && z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this);
                    sb2.append(": Bind failed");
                }
            } catch (SecurityException unused) {
                if (f8006q) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this);
                    sb3.append(": Bind failed");
                }
            }
        }
    }

    public final p0.b B(String str) {
        q0 o10 = o();
        if (o10 == null) {
            return null;
        }
        List b10 = o10.b();
        int size = b10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((n0) b10.get(i10)).l().equals(str)) {
                f fVar = new f(str);
                this.f8009k.add(fVar);
                if (this.f8013o) {
                    fVar.a(this.f8012n);
                }
                U();
                return fVar;
            }
        }
        return null;
    }

    public final p0.e C(String str, String str2) {
        q0 o10 = o();
        if (o10 == null) {
            return null;
        }
        List b10 = o10.b();
        int size = b10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((n0) b10.get(i10)).l().equals(str)) {
                g gVar = new g(str, str2);
                this.f8009k.add(gVar);
                if (this.f8013o) {
                    gVar.a(this.f8012n);
                }
                U();
                return gVar;
            }
        }
        return null;
    }

    public final void D() {
        int size = this.f8009k.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) this.f8009k.get(i10)).c();
        }
    }

    public final void E() {
        if (this.f8012n != null) {
            w((q0) null);
            this.f8013o = false;
            D();
            this.f8012n.d();
            this.f8012n = null;
        }
    }

    public final c F(int i10) {
        Iterator it = this.f8009k.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b() == i10) {
                return cVar;
            }
        }
        return null;
    }

    public boolean G(String str, String str2) {
        if (!this.f8007i.getPackageName().equals(str) || !this.f8007i.getClassName().equals(str2)) {
            return false;
        }
        return true;
    }

    public void H(a aVar, int i10) {
        if (this.f8012n == aVar) {
            c F = F(i10);
            b bVar = this.f8014p;
            if (bVar != null && (F instanceof p0.e)) {
                bVar.a((p0.e) F);
            }
            M(F);
        }
    }

    public void I(a aVar, q0 q0Var) {
        if (this.f8012n == aVar) {
            if (f8006q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Descriptor changed, descriptor=");
                sb.append(q0Var);
            }
            w(q0Var);
        }
    }

    public void J(a aVar) {
        if (this.f8012n == aVar) {
            if (f8006q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Service connection died");
            }
            E();
        }
    }

    public void K(a aVar, String str) {
        if (this.f8012n == aVar) {
            if (f8006q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Service connection error - ");
                sb.append(str);
            }
            T();
        }
    }

    public void L(a aVar) {
        if (this.f8012n == aVar) {
            this.f8013o = true;
            z();
            o0 p10 = p();
            if (p10 != null) {
                this.f8012n.t(p10);
            }
        }
    }

    public void M(c cVar) {
        this.f8009k.remove(cVar);
        cVar.c();
        U();
    }

    public void N(a aVar, int i10, n0 n0Var, List list) {
        if (this.f8012n == aVar) {
            if (f8006q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": DynamicRouteDescriptors changed, descriptors=");
                sb.append(list);
            }
            c F = F(i10);
            if (F instanceof f) {
                ((f) F).q(n0Var, list);
            }
        }
    }

    public void O() {
        if (this.f8012n == null && Q()) {
            T();
            A();
        }
    }

    public void P(b bVar) {
        this.f8014p = bVar;
    }

    public final boolean Q() {
        if (!this.f8010l) {
            return false;
        }
        if (p() == null && this.f8009k.isEmpty()) {
            return false;
        }
        return true;
    }

    public void R() {
        if (!this.f8010l) {
            if (f8006q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Starting");
            }
            this.f8010l = true;
            U();
        }
    }

    public void S() {
        if (this.f8010l) {
            if (f8006q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Stopping");
            }
            this.f8010l = false;
            U();
        }
    }

    public final void T() {
        if (this.f8011m) {
            if (f8006q) {
                StringBuilder sb = new StringBuilder();
                sb.append(this);
                sb.append(": Unbinding");
            }
            this.f8011m = false;
            E();
            try {
                n().unbindService(this);
            } catch (IllegalArgumentException e10) {
                Log.e("MediaRouteProviderProxy", this + ": unbindService failed", e10);
            }
        }
    }

    public final void U() {
        if (Q()) {
            A();
        } else {
            T();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Messenger messenger;
        boolean z10 = f8006q;
        if (z10) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(": Connected");
        }
        if (this.f8011m) {
            E();
            if (iBinder != null) {
                messenger = new Messenger(iBinder);
            } else {
                messenger = null;
            }
            if (r0.a(messenger)) {
                a aVar = new a(messenger);
                if (aVar.o()) {
                    this.f8012n = aVar;
                } else if (z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this);
                    sb2.append(": Registration failed");
                }
            } else {
                Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (f8006q) {
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(": Service disconnected");
        }
        E();
    }

    public p0.b r(String str) {
        if (str != null) {
            return B(str);
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public p0.e s(String str) {
        if (str != null) {
            return C(str, (String) null);
        }
        throw new IllegalArgumentException("routeId cannot be null");
    }

    public p0.e t(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        } else if (str2 != null) {
            return C(str, str2);
        } else {
            throw new IllegalArgumentException("routeGroupId cannot be null");
        }
    }

    public String toString() {
        return "Service connection " + this.f8007i.flattenToShortString();
    }

    public void u(o0 o0Var) {
        if (this.f8013o) {
            this.f8012n.t(o0Var);
        }
        U();
    }

    public final void z() {
        int size = this.f8009k.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((c) this.f8009k.get(i10)).a(this.f8012n);
        }
    }
}
