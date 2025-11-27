package n0;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import com.google.common.util.concurrent.ListenableFuture;
import com.hpplay.cybergarage.soap.SOAP;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import k0.l;
import n0.g0;
import n0.p0;
import n0.s0;
import n0.t1;
import n0.u1;
import n0.v1;

public final class t0 {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8051c = Log.isLoggable("MediaRouter", 3);

    /* renamed from: d  reason: collision with root package name */
    public static e f8052d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f8053a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f8054b = new ArrayList();

    public static abstract class b {
        public void onProviderAdded(t0 t0Var, h hVar) {
        }

        public void onProviderChanged(t0 t0Var, h hVar) {
        }

        public void onProviderRemoved(t0 t0Var, h hVar) {
        }

        public void onRouteAdded(t0 t0Var, i iVar) {
        }

        public void onRouteChanged(t0 t0Var, i iVar) {
        }

        public void onRoutePresentationDisplayChanged(t0 t0Var, i iVar) {
        }

        public void onRouteRemoved(t0 t0Var, i iVar) {
        }

        @Deprecated
        public void onRouteSelected(t0 t0Var, i iVar) {
        }

        @Deprecated
        public void onRouteUnselected(t0 t0Var, i iVar) {
        }

        public void onRouteVolumeChanged(t0 t0Var, i iVar) {
        }

        public void onRouteSelected(t0 t0Var, i iVar, int i10) {
            onRouteSelected(t0Var, iVar);
        }

        public void onRouteUnselected(t0 t0Var, i iVar, int i10) {
            onRouteUnselected(t0Var, iVar);
        }

        public void onRouteSelected(t0 t0Var, i iVar, int i10, i iVar2) {
            onRouteSelected(t0Var, iVar, i10);
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final t0 f8055a;

        /* renamed from: b  reason: collision with root package name */
        public final b f8056b;

        /* renamed from: c  reason: collision with root package name */
        public s0 f8057c = s0.f8047c;

        /* renamed from: d  reason: collision with root package name */
        public int f8058d;

        public c(t0 t0Var, b bVar) {
            this.f8055a = t0Var;
            this.f8056b = bVar;
        }

        public boolean a(i iVar, int i10, i iVar2, int i11) {
            if ((this.f8058d & 2) != 0 || iVar.E(this.f8057c)) {
                return true;
            }
            if (!t0.p() || !iVar.w() || i10 != 262 || i11 != 3 || iVar2 == null) {
                return false;
            }
            return !iVar2.w();
        }
    }

    public static abstract class d {
        public abstract void a(String str, Bundle bundle);

        public abstract void b(Bundle bundle);
    }

    public static final class e implements v1.e, t1.c {
        public f A;
        public g B;
        public d C;
        public MediaSessionCompat D;
        public MediaSessionCompat E;
        public MediaSessionCompat.j F = new a();
        public p0.b.d G = new b();

        /* renamed from: a  reason: collision with root package name */
        public final Context f8059a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8060b;

        /* renamed from: c  reason: collision with root package name */
        public final g0 f8061c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayList f8062d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList f8063e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public final Map f8064f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        public final ArrayList f8065g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public final ArrayList f8066h = new ArrayList();

        /* renamed from: i  reason: collision with root package name */
        public final u1.b f8067i = new u1.b();

        /* renamed from: j  reason: collision with root package name */
        public final f f8068j = new f();

        /* renamed from: k  reason: collision with root package name */
        public final c f8069k = new c();

        /* renamed from: l  reason: collision with root package name */
        public final t.a f8070l;

        /* renamed from: m  reason: collision with root package name */
        public final v1 f8071m;

        /* renamed from: n  reason: collision with root package name */
        public final boolean f8072n;

        /* renamed from: o  reason: collision with root package name */
        public o1 f8073o;

        /* renamed from: p  reason: collision with root package name */
        public t1 f8074p;

        /* renamed from: q  reason: collision with root package name */
        public i f8075q;

        /* renamed from: r  reason: collision with root package name */
        public i f8076r;

        /* renamed from: s  reason: collision with root package name */
        public i f8077s;

        /* renamed from: t  reason: collision with root package name */
        public p0.e f8078t;

        /* renamed from: u  reason: collision with root package name */
        public i f8079u;

        /* renamed from: v  reason: collision with root package name */
        public p0.e f8080v;

        /* renamed from: w  reason: collision with root package name */
        public final Map f8081w = new HashMap();

        /* renamed from: x  reason: collision with root package name */
        public o0 f8082x;

        /* renamed from: y  reason: collision with root package name */
        public o0 f8083y;

        /* renamed from: z  reason: collision with root package name */
        public int f8084z;

        public class a implements MediaSessionCompat.j {
            public a() {
            }

            public void a() {
                MediaSessionCompat mediaSessionCompat = e.this.D;
                if (mediaSessionCompat == null) {
                    return;
                }
                if (mediaSessionCompat.h()) {
                    e eVar = e.this;
                    eVar.g(eVar.D.e());
                    return;
                }
                e eVar2 = e.this;
                eVar2.F(eVar2.D.e());
            }
        }

        public class b implements p0.b.d {
            public b() {
            }

            public void a(p0.b bVar, n0 n0Var, Collection collection) {
                e eVar = e.this;
                if (bVar == eVar.f8080v && n0Var != null) {
                    h q10 = eVar.f8079u.q();
                    String l10 = n0Var.l();
                    i iVar = new i(q10, l10, e.this.h(q10, l10));
                    iVar.F(n0Var);
                    e eVar2 = e.this;
                    if (eVar2.f8077s != iVar) {
                        eVar2.D(eVar2, iVar, eVar2.f8080v, 3, eVar2.f8079u, collection);
                        e eVar3 = e.this;
                        eVar3.f8079u = null;
                        eVar3.f8080v = null;
                    }
                } else if (bVar == eVar.f8078t) {
                    if (n0Var != null) {
                        eVar.U(eVar.f8077s, n0Var);
                    }
                    e.this.f8077s.L(collection);
                }
            }
        }

        public final class c extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public final ArrayList f8087a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            public final List f8088b = new ArrayList();

            public c() {
            }

            public final void a(c cVar, int i10, Object obj, int i11) {
                i iVar;
                i iVar2;
                t0 t0Var = cVar.f8055a;
                b bVar = cVar.f8056b;
                int i12 = 65280 & i10;
                if (i12 == 256) {
                    if (i10 == 264 || i10 == 262) {
                        iVar = (i) ((a0.d) obj).second;
                    } else {
                        iVar = (i) obj;
                    }
                    if (i10 == 264 || i10 == 262) {
                        iVar2 = (i) ((a0.d) obj).first;
                    } else {
                        iVar2 = null;
                    }
                    if (iVar != null && cVar.a(iVar, i10, iVar2, i11)) {
                        switch (i10) {
                            case 257:
                                bVar.onRouteAdded(t0Var, iVar);
                                return;
                            case 258:
                                bVar.onRouteRemoved(t0Var, iVar);
                                return;
                            case 259:
                                bVar.onRouteChanged(t0Var, iVar);
                                return;
                            case 260:
                                bVar.onRouteVolumeChanged(t0Var, iVar);
                                return;
                            case 261:
                                bVar.onRoutePresentationDisplayChanged(t0Var, iVar);
                                return;
                            case 262:
                                bVar.onRouteSelected(t0Var, iVar, i11, iVar);
                                return;
                            case 263:
                                bVar.onRouteUnselected(t0Var, iVar, i11);
                                return;
                            case 264:
                                bVar.onRouteSelected(t0Var, iVar, i11, iVar2);
                                return;
                            default:
                                return;
                        }
                    }
                } else if (i12 == 512) {
                    h hVar = (h) obj;
                    switch (i10) {
                        case 513:
                            bVar.onProviderAdded(t0Var, hVar);
                            return;
                        case 514:
                            bVar.onProviderRemoved(t0Var, hVar);
                            return;
                        case 515:
                            bVar.onProviderChanged(t0Var, hVar);
                            return;
                        default:
                            return;
                    }
                }
            }

            public void b(int i10, Object obj) {
                obtainMessage(i10, obj).sendToTarget();
            }

            public void c(int i10, Object obj, int i11) {
                Message obtainMessage = obtainMessage(i10, obj);
                obtainMessage.arg1 = i11;
                obtainMessage.sendToTarget();
            }

            public final void d(int i10, Object obj) {
                if (i10 == 262) {
                    i iVar = (i) ((a0.d) obj).second;
                    e.this.f8071m.D(iVar);
                    if (e.this.f8075q != null && iVar.w()) {
                        for (i C : this.f8088b) {
                            e.this.f8071m.C(C);
                        }
                        this.f8088b.clear();
                    }
                } else if (i10 != 264) {
                    switch (i10) {
                        case 257:
                            e.this.f8071m.A((i) obj);
                            return;
                        case 258:
                            e.this.f8071m.C((i) obj);
                            return;
                        case 259:
                            e.this.f8071m.B((i) obj);
                            return;
                        default:
                            return;
                    }
                } else {
                    i iVar2 = (i) ((a0.d) obj).second;
                    this.f8088b.add(iVar2);
                    e.this.f8071m.A(iVar2);
                    e.this.f8071m.D(iVar2);
                }
            }

            public void handleMessage(Message message) {
                int i10 = message.what;
                Object obj = message.obj;
                int i11 = message.arg1;
                if (i10 == 259 && e.this.v().k().equals(((i) obj).k())) {
                    e.this.V(true);
                }
                d(i10, obj);
                try {
                    int size = e.this.f8062d.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        t0 t0Var = (t0) ((WeakReference) e.this.f8062d.get(size)).get();
                        if (t0Var == null) {
                            e.this.f8062d.remove(size);
                        } else {
                            this.f8087a.addAll(t0Var.f8054b);
                        }
                    }
                    int size2 = this.f8087a.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        a((c) this.f8087a.get(i12), i10, obj, i11);
                    }
                } finally {
                    this.f8087a.clear();
                }
            }
        }

        public final class d {

            /* renamed from: a  reason: collision with root package name */
            public final MediaSessionCompat f8090a;

            /* renamed from: b  reason: collision with root package name */
            public int f8091b;

            /* renamed from: c  reason: collision with root package name */
            public int f8092c;

            /* renamed from: d  reason: collision with root package name */
            public l f8093d;

            public class a extends l {

                /* renamed from: n0.t0$e$d$a$a  reason: collision with other inner class name */
                public class C0102a implements Runnable {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f8096a;

                    public C0102a(int i10) {
                        this.f8096a = i10;
                    }

                    public void run() {
                        i iVar = e.this.f8077s;
                        if (iVar != null) {
                            iVar.G(this.f8096a);
                        }
                    }
                }

                public class b implements Runnable {

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ int f8098a;

                    public b(int i10) {
                        this.f8098a = i10;
                    }

                    public void run() {
                        i iVar = e.this.f8077s;
                        if (iVar != null) {
                            iVar.H(this.f8098a);
                        }
                    }
                }

                public a(int i10, int i11, int i12, String str) {
                    super(i10, i11, i12, str);
                }

                public void e(int i10) {
                    e.this.f8069k.post(new b(i10));
                }

                public void f(int i10) {
                    e.this.f8069k.post(new C0102a(i10));
                }
            }

            public d(MediaSessionCompat mediaSessionCompat) {
                this.f8090a = mediaSessionCompat;
            }

            public void a() {
                MediaSessionCompat mediaSessionCompat = this.f8090a;
                if (mediaSessionCompat != null) {
                    mediaSessionCompat.p(e.this.f8067i.f8165d);
                    this.f8093d = null;
                }
            }

            public void b(int i10, int i11, int i12, String str) {
                if (this.f8090a != null) {
                    l lVar = this.f8093d;
                    if (lVar != null && i10 == this.f8091b && i11 == this.f8092c) {
                        lVar.h(i12);
                        return;
                    }
                    a aVar = new a(i10, i11, i12, str);
                    this.f8093d = aVar;
                    this.f8090a.q(aVar);
                }
            }

            public MediaSessionCompat.Token c() {
                MediaSessionCompat mediaSessionCompat = this.f8090a;
                if (mediaSessionCompat != null) {
                    return mediaSessionCompat.f();
                }
                return null;
            }
        }

        /* renamed from: n0.t0$e$e  reason: collision with other inner class name */
        public final class C0103e extends g0.a {
            public C0103e() {
            }

            public void a(p0.e eVar) {
                if (eVar == e.this.f8078t) {
                    d(2);
                } else if (t0.f8051c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("A RouteController unrelated to the selected route is released. controller=");
                    sb.append(eVar);
                }
            }

            public void b(int i10) {
                d(i10);
            }

            public void c(String str, int i10) {
                i iVar;
                Iterator it = e.this.u().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        iVar = null;
                        break;
                    }
                    iVar = (i) it.next();
                    if (iVar.r() == e.this.f8061c && TextUtils.equals(str, iVar.e())) {
                        break;
                    }
                }
                if (iVar == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onSelectRoute: The target RouteInfo is not found for descriptorId=");
                    sb.append(str);
                    return;
                }
                e.this.J(iVar, i10);
            }

            public void d(int i10) {
                i i11 = e.this.i();
                if (e.this.v() != i11) {
                    e.this.J(i11, i10);
                }
            }
        }

        public final class f extends p0.a {
            public f() {
            }

            public void a(p0 p0Var, q0 q0Var) {
                e.this.T(p0Var, q0Var);
            }
        }

        public final class g implements u1.c {

            /* renamed from: a  reason: collision with root package name */
            public final u1 f8102a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f8103b;

            public g(Object obj) {
                u1 b10 = u1.b(e.this.f8059a, obj);
                this.f8102a = b10;
                b10.d(this);
                e();
            }

            public void a(int i10) {
                i iVar;
                if (!this.f8103b && (iVar = e.this.f8077s) != null) {
                    iVar.G(i10);
                }
            }

            public void b(int i10) {
                i iVar;
                if (!this.f8103b && (iVar = e.this.f8077s) != null) {
                    iVar.H(i10);
                }
            }

            public void c() {
                this.f8103b = true;
                this.f8102a.d((u1.c) null);
            }

            public Object d() {
                return this.f8102a.a();
            }

            public void e() {
                this.f8102a.c(e.this.f8067i);
            }
        }

        public e(Context context) {
            this.f8059a = context;
            this.f8070l = t.a.a(context);
            this.f8072n = o.i.a((ActivityManager) context.getSystemService("activity"));
            if (Build.VERSION.SDK_INT >= 30) {
                this.f8060b = p1.a(context);
            } else {
                this.f8060b = false;
            }
            if (this.f8060b) {
                this.f8061c = new g0(context, new C0103e());
            } else {
                this.f8061c = null;
            }
            this.f8071m = v1.z(context, this);
        }

        public final boolean A(i iVar) {
            if (iVar.r() != this.f8071m || !iVar.J("android.media.intent.category.LIVE_AUDIO") || iVar.J("android.media.intent.category.LIVE_VIDEO")) {
                return false;
            }
            return true;
        }

        public boolean B() {
            o1 o1Var = this.f8073o;
            if (o1Var == null) {
                return false;
            }
            return o1Var.d();
        }

        public void C() {
            if (this.f8077s.y()) {
                List<i> l10 = this.f8077s.l();
                HashSet hashSet = new HashSet();
                for (i iVar : l10) {
                    hashSet.add(iVar.f8121c);
                }
                Iterator it = this.f8081w.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        p0.e eVar = (p0.e) entry.getValue();
                        eVar.h(0);
                        eVar.d();
                        it.remove();
                    }
                }
                for (i iVar2 : l10) {
                    if (!this.f8081w.containsKey(iVar2.f8121c)) {
                        p0.e t10 = iVar2.r().t(iVar2.f8120b, this.f8077s.f8120b);
                        t10.e();
                        this.f8081w.put(iVar2.f8121c, t10);
                    }
                }
            }
        }

        public void D(e eVar, i iVar, p0.e eVar2, int i10, i iVar2, Collection collection) {
            f fVar;
            g gVar = this.B;
            if (gVar != null) {
                gVar.b();
                this.B = null;
            }
            g gVar2 = new g(eVar, iVar, eVar2, i10, iVar2, collection);
            this.B = gVar2;
            if (gVar2.f8106b != 3 || (fVar = this.A) == null) {
                gVar2.d();
                return;
            }
            ListenableFuture onPrepareTransfer = fVar.onPrepareTransfer(this.f8077s, gVar2.f8108d);
            if (onPrepareTransfer == null) {
                this.B.d();
            } else {
                this.B.f(onPrepareTransfer);
            }
        }

        public void E(i iVar) {
            if (this.f8078t instanceof p0.b) {
                i.a p10 = p(iVar);
                if (!this.f8077s.l().contains(iVar) || p10 == null || !p10.d()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring attempt to remove a non-unselectable member route : ");
                    sb.append(iVar);
                } else if (this.f8077s.l().size() > 1) {
                    ((p0.b) this.f8078t).n(iVar.e());
                }
            } else {
                throw new IllegalStateException("There is no currently selected dynamic group route.");
            }
        }

        public void F(Object obj) {
            int k10 = k(obj);
            if (k10 >= 0) {
                ((g) this.f8066h.remove(k10)).c();
            }
        }

        public void G(i iVar, int i10) {
            p0.e eVar;
            p0.e eVar2;
            if (iVar == this.f8077s && (eVar2 = this.f8078t) != null) {
                eVar2.f(i10);
            } else if (!this.f8081w.isEmpty() && (eVar = (p0.e) this.f8081w.get(iVar.f8121c)) != null) {
                eVar.f(i10);
            }
        }

        public void H(i iVar, int i10) {
            p0.e eVar;
            p0.e eVar2;
            if (iVar == this.f8077s && (eVar2 = this.f8078t) != null) {
                eVar2.i(i10);
            } else if (!this.f8081w.isEmpty() && (eVar = (p0.e) this.f8081w.get(iVar.f8121c)) != null) {
                eVar.i(i10);
            }
        }

        public void I(i iVar, int i10) {
            g0 g0Var;
            if (!this.f8063e.contains(iVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring attempt to select removed route: ");
                sb.append(iVar);
            } else if (!iVar.f8125g) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Ignoring attempt to select disabled route: ");
                sb2.append(iVar);
            } else if (Build.VERSION.SDK_INT < 30 || iVar.r() != (g0Var = this.f8061c) || this.f8077s == iVar) {
                J(iVar, i10);
            } else {
                g0Var.G(iVar.e());
            }
        }

        public void J(i iVar, int i10) {
            if (t0.f8052d == null || (this.f8076r != null && iVar.v())) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder();
                for (int i11 = 3; i11 < stackTrace.length; i11++) {
                    StackTraceElement stackTraceElement = stackTrace[i11];
                    sb.append(stackTraceElement.getClassName());
                    sb.append(".");
                    sb.append(stackTraceElement.getMethodName());
                    sb.append(SOAP.DELIM);
                    sb.append(stackTraceElement.getLineNumber());
                    sb.append("  ");
                }
                if (t0.f8052d == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("setSelectedRouteInternal is called while sGlobal is null: pkgName=");
                    sb2.append(this.f8059a.getPackageName());
                    sb2.append(", callers=");
                    sb2.append(sb.toString());
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Default route is selected while a BT route is available: pkgName=");
                    sb3.append(this.f8059a.getPackageName());
                    sb3.append(", callers=");
                    sb3.append(sb.toString());
                }
            }
            if (this.f8077s != iVar) {
                if (this.f8079u != null) {
                    this.f8079u = null;
                    p0.e eVar = this.f8080v;
                    if (eVar != null) {
                        eVar.h(3);
                        this.f8080v.d();
                        this.f8080v = null;
                    }
                }
                if (x() && iVar.q().g()) {
                    p0.b r10 = iVar.r().r(iVar.f8120b);
                    if (r10 != null) {
                        r10.p(p.a.getMainExecutor(this.f8059a), this.G);
                        this.f8079u = iVar;
                        this.f8080v = r10;
                        r10.e();
                        return;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("setSelectedRouteInternal: Failed to create dynamic group route controller. route=");
                    sb4.append(iVar);
                }
                p0.e s10 = iVar.r().s(iVar.f8120b);
                if (s10 != null) {
                    s10.e();
                }
                if (t0.f8051c) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Route selected: ");
                    sb5.append(iVar);
                }
                if (this.f8077s == null) {
                    this.f8077s = iVar;
                    this.f8078t = s10;
                    this.f8069k.c(262, new a0.d((Object) null, iVar), i10);
                    return;
                }
                D(this, iVar, s10, i10, (i) null, (Collection) null);
            }
        }

        public void K(MediaSessionCompat mediaSessionCompat) {
            d dVar;
            this.E = mediaSessionCompat;
            if (Build.VERSION.SDK_INT >= 21) {
                if (mediaSessionCompat != null) {
                    dVar = new d(mediaSessionCompat);
                } else {
                    dVar = null;
                }
                L(dVar);
                return;
            }
            MediaSessionCompat mediaSessionCompat2 = this.D;
            if (mediaSessionCompat2 != null) {
                F(mediaSessionCompat2.e());
                this.D.j(this.F);
            }
            this.D = mediaSessionCompat;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.a(this.F);
                if (mediaSessionCompat.h()) {
                    g(mediaSessionCompat.e());
                }
            }
        }

        public final void L(d dVar) {
            d dVar2 = this.C;
            if (dVar2 != null) {
                dVar2.a();
            }
            this.C = dVar;
            if (dVar != null) {
                R();
            }
        }

        public void M(o1 o1Var) {
            boolean z10;
            o1 o1Var2 = this.f8073o;
            this.f8073o = o1Var;
            if (x()) {
                boolean z11 = false;
                if (o1Var2 == null) {
                    z10 = false;
                } else {
                    z10 = o1Var2.d();
                }
                if (o1Var != null) {
                    z11 = o1Var.d();
                }
                if (z10 != z11) {
                    this.f8061c.y(this.f8083y);
                }
            }
        }

        public void N() {
            a(this.f8071m);
            g0 g0Var = this.f8061c;
            if (g0Var != null) {
                a(g0Var);
            }
            t1 t1Var = new t1(this.f8059a, this);
            this.f8074p = t1Var;
            t1Var.i();
        }

        public void O(i iVar) {
            if (this.f8078t instanceof p0.b) {
                i.a p10 = p(iVar);
                if (p10 != null && p10.c()) {
                    ((p0.b) this.f8078t).o(Collections.singletonList(iVar.e()));
                    return;
                }
                return;
            }
            throw new IllegalStateException("There is no currently selected dynamic group route.");
        }

        public void P() {
            s0 s0Var;
            s0.a aVar = new s0.a();
            int size = this.f8062d.size();
            int i10 = 0;
            boolean z10 = false;
            boolean z11 = false;
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                t0 t0Var = (t0) ((WeakReference) this.f8062d.get(size)).get();
                if (t0Var == null) {
                    this.f8062d.remove(size);
                } else {
                    int size2 = t0Var.f8054b.size();
                    i10 += size2;
                    for (int i11 = 0; i11 < size2; i11++) {
                        c cVar = (c) t0Var.f8054b.get(i11);
                        aVar.c(cVar.f8057c);
                        int i12 = cVar.f8058d;
                        if ((i12 & 1) != 0) {
                            z10 = true;
                            z11 = true;
                        }
                        if ((i12 & 4) != 0 && !this.f8072n) {
                            z10 = true;
                        }
                        if ((i12 & 8) != 0) {
                            z10 = true;
                        }
                    }
                }
            }
            this.f8084z = i10;
            if (z10) {
                s0Var = aVar.d();
            } else {
                s0Var = s0.f8047c;
            }
            Q(aVar.d(), z11);
            o0 o0Var = this.f8082x;
            if (o0Var == null || !o0Var.c().equals(s0Var) || this.f8082x.d() != z11) {
                if (!s0Var.f() || z11) {
                    this.f8082x = new o0(s0Var, z11);
                } else if (this.f8082x != null) {
                    this.f8082x = null;
                } else {
                    return;
                }
                if (t0.f8051c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Updated discovery request: ");
                    sb.append(this.f8082x);
                }
                int size3 = this.f8065g.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    p0 p0Var = ((h) this.f8065g.get(i13)).f8115a;
                    if (p0Var != this.f8061c) {
                        p0Var.x(this.f8082x);
                    }
                }
            }
        }

        public final void Q(s0 s0Var, boolean z10) {
            if (x()) {
                o0 o0Var = this.f8083y;
                if (o0Var == null || !o0Var.c().equals(s0Var) || this.f8083y.d() != z10) {
                    if (!s0Var.f() || z10) {
                        this.f8083y = new o0(s0Var, z10);
                    } else if (this.f8083y != null) {
                        this.f8083y = null;
                    } else {
                        return;
                    }
                    if (t0.f8051c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Updated MediaRoute2Provider's discovery request: ");
                        sb.append(this.f8083y);
                    }
                    this.f8061c.x(this.f8083y);
                }
            }
        }

        public void R() {
            i iVar = this.f8077s;
            if (iVar != null) {
                this.f8067i.f8162a = iVar.s();
                this.f8067i.f8163b = this.f8077s.u();
                this.f8067i.f8164c = this.f8077s.t();
                this.f8067i.f8165d = this.f8077s.n();
                this.f8067i.f8166e = this.f8077s.o();
                if (!this.f8060b || this.f8077s.r() != this.f8061c) {
                    this.f8067i.f8167f = null;
                } else {
                    this.f8067i.f8167f = g0.C(this.f8078t);
                }
                int size = this.f8066h.size();
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    ((g) this.f8066h.get(i11)).e();
                }
                if (this.C == null) {
                    return;
                }
                if (this.f8077s == o() || this.f8077s == m()) {
                    this.C.a();
                    return;
                }
                u1.b bVar = this.f8067i;
                if (bVar.f8164c == 1) {
                    i10 = 2;
                }
                this.C.b(i10, bVar.f8163b, bVar.f8162a, bVar.f8167f);
                return;
            }
            d dVar = this.C;
            if (dVar != null) {
                dVar.a();
            }
        }

        public final void S(h hVar, q0 q0Var) {
            boolean z10;
            if (hVar.h(q0Var)) {
                int i10 = 0;
                if (q0Var == null || (!q0Var.c() && q0Var != this.f8071m.o())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring invalid provider descriptor: ");
                    sb.append(q0Var);
                    z10 = false;
                } else {
                    List<n0> b10 = q0Var.b();
                    ArrayList<a0.d> arrayList = new ArrayList<>();
                    ArrayList<a0.d> arrayList2 = new ArrayList<>();
                    z10 = false;
                    for (n0 n0Var : b10) {
                        if (n0Var == null || !n0Var.x()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Ignoring invalid system route descriptor: ");
                            sb2.append(n0Var);
                        } else {
                            String l10 = n0Var.l();
                            int b11 = hVar.b(l10);
                            if (b11 < 0) {
                                i iVar = new i(hVar, l10, h(hVar, l10));
                                int i11 = i10 + 1;
                                hVar.f8116b.add(i10, iVar);
                                this.f8063e.add(iVar);
                                if (n0Var.j().size() > 0) {
                                    arrayList.add(new a0.d(iVar, n0Var));
                                } else {
                                    iVar.F(n0Var);
                                    if (t0.f8051c) {
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Route added: ");
                                        sb3.append(iVar);
                                    }
                                    this.f8069k.b(257, iVar);
                                }
                                i10 = i11;
                            } else if (b11 < i10) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("Ignoring route descriptor with duplicate id: ");
                                sb4.append(n0Var);
                            } else {
                                i iVar2 = (i) hVar.f8116b.get(b11);
                                int i12 = i10 + 1;
                                Collections.swap(hVar.f8116b, b11, i10);
                                if (n0Var.j().size() > 0) {
                                    arrayList2.add(new a0.d(iVar2, n0Var));
                                } else if (U(iVar2, n0Var) != 0 && iVar2 == this.f8077s) {
                                    i10 = i12;
                                    z10 = true;
                                }
                                i10 = i12;
                            }
                        }
                    }
                    for (a0.d dVar : arrayList) {
                        i iVar3 = (i) dVar.first;
                        iVar3.F((n0) dVar.second);
                        if (t0.f8051c) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Route added: ");
                            sb5.append(iVar3);
                        }
                        this.f8069k.b(257, iVar3);
                    }
                    for (a0.d dVar2 : arrayList2) {
                        i iVar4 = (i) dVar2.first;
                        if (U(iVar4, (n0) dVar2.second) != 0 && iVar4 == this.f8077s) {
                            z10 = true;
                        }
                    }
                }
                for (int size = hVar.f8116b.size() - 1; size >= i10; size--) {
                    i iVar5 = (i) hVar.f8116b.get(size);
                    iVar5.F((n0) null);
                    this.f8063e.remove(iVar5);
                }
                V(z10);
                for (int size2 = hVar.f8116b.size() - 1; size2 >= i10; size2--) {
                    i iVar6 = (i) hVar.f8116b.remove(size2);
                    if (t0.f8051c) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Route removed: ");
                        sb6.append(iVar6);
                    }
                    this.f8069k.b(258, iVar6);
                }
                if (t0.f8051c) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Provider changed: ");
                    sb7.append(hVar);
                }
                this.f8069k.b(515, hVar);
            }
        }

        public void T(p0 p0Var, q0 q0Var) {
            h j10 = j(p0Var);
            if (j10 != null) {
                S(j10, q0Var);
            }
        }

        public int U(i iVar, n0 n0Var) {
            int F2 = iVar.F(n0Var);
            if (F2 != 0) {
                if ((F2 & 1) != 0) {
                    if (t0.f8051c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Route changed: ");
                        sb.append(iVar);
                    }
                    this.f8069k.b(259, iVar);
                }
                if ((F2 & 2) != 0) {
                    if (t0.f8051c) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Route volume changed: ");
                        sb2.append(iVar);
                    }
                    this.f8069k.b(260, iVar);
                }
                if ((F2 & 4) != 0) {
                    if (t0.f8051c) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Route presentation display changed: ");
                        sb3.append(iVar);
                    }
                    this.f8069k.b(261, iVar);
                }
            }
            return F2;
        }

        public void V(boolean z10) {
            i iVar = this.f8075q;
            if (iVar != null && !iVar.B()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Clearing the default route because it is no longer selectable: ");
                sb.append(this.f8075q);
                this.f8075q = null;
            }
            if (this.f8075q == null && !this.f8063e.isEmpty()) {
                Iterator it = this.f8063e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    i iVar2 = (i) it.next();
                    if (z(iVar2) && iVar2.B()) {
                        this.f8075q = iVar2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Found default route: ");
                        sb2.append(this.f8075q);
                        break;
                    }
                }
            }
            i iVar3 = this.f8076r;
            if (iVar3 != null && !iVar3.B()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Clearing the bluetooth route because it is no longer selectable: ");
                sb3.append(this.f8076r);
                this.f8076r = null;
            }
            if (this.f8076r == null && !this.f8063e.isEmpty()) {
                Iterator it2 = this.f8063e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    i iVar4 = (i) it2.next();
                    if (A(iVar4) && iVar4.B()) {
                        this.f8076r = iVar4;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Found bluetooth route: ");
                        sb4.append(this.f8076r);
                        break;
                    }
                }
            }
            i iVar5 = this.f8077s;
            if (iVar5 == null || !iVar5.x()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Unselecting the current route because it is no longer selectable: ");
                sb5.append(this.f8077s);
                J(i(), 0);
            } else if (z10) {
                C();
                R();
            }
        }

        public void a(p0 p0Var) {
            if (j(p0Var) == null) {
                h hVar = new h(p0Var);
                this.f8065g.add(hVar);
                if (t0.f8051c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Provider added: ");
                    sb.append(hVar);
                }
                this.f8069k.b(513, hVar);
                S(hVar, p0Var.o());
                p0Var.v(this.f8068j);
                p0Var.x(this.f8082x);
            }
        }

        public void b(p0 p0Var) {
            h j10 = j(p0Var);
            if (j10 != null) {
                p0Var.v((p0.a) null);
                p0Var.x((o0) null);
                S(j10, (q0) null);
                if (t0.f8051c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Provider removed: ");
                    sb.append(j10);
                }
                this.f8069k.b(514, j10);
                this.f8065g.remove(j10);
            }
        }

        public void c(String str) {
            i a10;
            this.f8069k.removeMessages(262);
            h j10 = j(this.f8071m);
            if (j10 != null && (a10 = j10.a(str)) != null) {
                a10.I();
            }
        }

        public void d(q1 q1Var, p0.e eVar) {
            if (this.f8078t == eVar) {
                I(i(), 2);
            }
        }

        public void f(i iVar) {
            if (this.f8078t instanceof p0.b) {
                i.a p10 = p(iVar);
                if (this.f8077s.l().contains(iVar) || p10 == null || !p10.b()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring attempt to add a non-groupable route to dynamic group : ");
                    sb.append(iVar);
                    return;
                }
                ((p0.b) this.f8078t).m(iVar.e());
                return;
            }
            throw new IllegalStateException("There is no currently selected dynamic group route.");
        }

        public void g(Object obj) {
            if (k(obj) < 0) {
                this.f8066h.add(new g(obj));
            }
        }

        public String h(h hVar, String str) {
            String flattenToShortString = hVar.c().flattenToShortString();
            String str2 = flattenToShortString + SOAP.DELIM + str;
            if (l(str2) < 0) {
                this.f8064f.put(new a0.d(flattenToShortString, str), str2);
                return str2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Either ");
            sb.append(str);
            sb.append(" isn't unique in ");
            sb.append(flattenToShortString);
            sb.append(" or we're trying to assign a unique ID for an already added route");
            int i10 = 2;
            while (true) {
                String format = String.format(Locale.US, "%s_%d", new Object[]{str2, Integer.valueOf(i10)});
                if (l(format) < 0) {
                    this.f8064f.put(new a0.d(flattenToShortString, str), format);
                    return format;
                }
                i10++;
            }
        }

        public i i() {
            Iterator it = this.f8063e.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar != this.f8075q && A(iVar) && iVar.B()) {
                    return iVar;
                }
            }
            return this.f8075q;
        }

        public final h j(p0 p0Var) {
            int size = this.f8065g.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((h) this.f8065g.get(i10)).f8115a == p0Var) {
                    return (h) this.f8065g.get(i10);
                }
            }
            return null;
        }

        public final int k(Object obj) {
            int size = this.f8066h.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((g) this.f8066h.get(i10)).d() == obj) {
                    return i10;
                }
            }
            return -1;
        }

        public final int l(String str) {
            int size = this.f8063e.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i) this.f8063e.get(i10)).f8121c.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public i m() {
            return this.f8076r;
        }

        public int n() {
            return this.f8084z;
        }

        public i o() {
            i iVar = this.f8075q;
            if (iVar != null) {
                return iVar;
            }
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        }

        public i.a p(i iVar) {
            return this.f8077s.h(iVar);
        }

        public MediaSessionCompat.Token q() {
            d dVar = this.C;
            if (dVar != null) {
                return dVar.c();
            }
            MediaSessionCompat mediaSessionCompat = this.E;
            if (mediaSessionCompat != null) {
                return mediaSessionCompat.f();
            }
            return null;
        }

        public i r(String str) {
            Iterator it = this.f8063e.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.f8121c.equals(str)) {
                    return iVar;
                }
            }
            return null;
        }

        public t0 s(Context context) {
            int size = this.f8062d.size();
            while (true) {
                size--;
                if (size >= 0) {
                    t0 t0Var = (t0) ((WeakReference) this.f8062d.get(size)).get();
                    if (t0Var == null) {
                        this.f8062d.remove(size);
                    } else if (t0Var.f8053a == context) {
                        return t0Var;
                    }
                } else {
                    t0 t0Var2 = new t0(context);
                    this.f8062d.add(new WeakReference(t0Var2));
                    return t0Var2;
                }
            }
        }

        public o1 t() {
            return this.f8073o;
        }

        public List u() {
            return this.f8063e;
        }

        public i v() {
            i iVar = this.f8077s;
            if (iVar != null) {
                return iVar;
            }
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
        }

        public String w(h hVar, String str) {
            return (String) this.f8064f.get(new a0.d(hVar.c().flattenToShortString(), str));
        }

        public boolean x() {
            return this.f8060b;
        }

        public boolean y(s0 s0Var, int i10) {
            if (s0Var.f()) {
                return false;
            }
            if ((i10 & 2) == 0 && this.f8072n) {
                return true;
            }
            int size = this.f8063e.size();
            for (int i11 = 0; i11 < size; i11++) {
                i iVar = (i) this.f8063e.get(i11);
                if (((i10 & 1) == 0 || !iVar.w()) && iVar.E(s0Var)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean z(i iVar) {
            if (iVar.r() != this.f8071m || !iVar.f8120b.equals("DEFAULT_ROUTE")) {
                return false;
            }
            return true;
        }
    }

    public interface f {
        ListenableFuture onPrepareTransfer(i iVar, i iVar2);
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final p0.e f8105a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8106b;

        /* renamed from: c  reason: collision with root package name */
        public final i f8107c;

        /* renamed from: d  reason: collision with root package name */
        public final i f8108d;

        /* renamed from: e  reason: collision with root package name */
        public final i f8109e;

        /* renamed from: f  reason: collision with root package name */
        public final List f8110f;

        /* renamed from: g  reason: collision with root package name */
        public final WeakReference f8111g;

        /* renamed from: h  reason: collision with root package name */
        public ListenableFuture f8112h = null;

        /* renamed from: i  reason: collision with root package name */
        public boolean f8113i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f8114j = false;

        public g(e eVar, i iVar, p0.e eVar2, int i10, i iVar2, Collection collection) {
            ArrayList arrayList = null;
            this.f8111g = new WeakReference(eVar);
            this.f8108d = iVar;
            this.f8105a = eVar2;
            this.f8106b = i10;
            this.f8107c = eVar.f8077s;
            this.f8109e = iVar2;
            this.f8110f = collection != null ? new ArrayList(collection) : arrayList;
            eVar.f8069k.postDelayed(new w0(this), 15000);
        }

        public void b() {
            if (!this.f8113i && !this.f8114j) {
                this.f8114j = true;
                p0.e eVar = this.f8105a;
                if (eVar != null) {
                    eVar.h(0);
                    this.f8105a.d();
                }
            }
        }

        /* renamed from: c */
        public void d() {
            ListenableFuture listenableFuture;
            t0.d();
            if (!this.f8113i && !this.f8114j) {
                e eVar = (e) this.f8111g.get();
                if (eVar == null || eVar.B != this || ((listenableFuture = this.f8112h) != null && listenableFuture.isCancelled())) {
                    b();
                    return;
                }
                this.f8113i = true;
                eVar.B = null;
                g();
                e();
            }
        }

        public final void e() {
            e eVar = (e) this.f8111g.get();
            if (eVar != null) {
                i iVar = this.f8108d;
                eVar.f8077s = iVar;
                eVar.f8078t = this.f8105a;
                i iVar2 = this.f8109e;
                if (iVar2 == null) {
                    eVar.f8069k.c(262, new a0.d(this.f8107c, iVar), this.f8106b);
                } else {
                    eVar.f8069k.c(264, new a0.d(iVar2, iVar), this.f8106b);
                }
                eVar.f8081w.clear();
                eVar.C();
                eVar.R();
                List list = this.f8110f;
                if (list != null) {
                    eVar.f8077s.L(list);
                }
            }
        }

        public void f(ListenableFuture listenableFuture) {
            e eVar = (e) this.f8111g.get();
            if (eVar == null || eVar.B != this) {
                b();
            } else if (this.f8112h == null) {
                this.f8112h = listenableFuture;
                u0 u0Var = new u0(this);
                e.c cVar = eVar.f8069k;
                Objects.requireNonNull(cVar);
                listenableFuture.addListener(u0Var, new v0(cVar));
            } else {
                throw new IllegalStateException("future is already set");
            }
        }

        public final void g() {
            i iVar;
            e eVar = (e) this.f8111g.get();
            if (eVar != null && eVar.f8077s == (iVar = this.f8107c)) {
                eVar.f8069k.c(263, iVar, this.f8106b);
                p0.e eVar2 = eVar.f8078t;
                if (eVar2 != null) {
                    eVar2.h(this.f8106b);
                    eVar.f8078t.d();
                }
                if (!eVar.f8081w.isEmpty()) {
                    for (p0.e eVar3 : eVar.f8081w.values()) {
                        eVar3.h(this.f8106b);
                        eVar3.d();
                    }
                    eVar.f8081w.clear();
                }
                eVar.f8078t = null;
            }
        }
    }

    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final p0 f8115a;

        /* renamed from: b  reason: collision with root package name */
        public final List f8116b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public final p0.d f8117c;

        /* renamed from: d  reason: collision with root package name */
        public q0 f8118d;

        public h(p0 p0Var) {
            this.f8115a = p0Var;
            this.f8117c = p0Var.q();
        }

        public i a(String str) {
            int size = this.f8116b.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i) this.f8116b.get(i10)).f8120b.equals(str)) {
                    return (i) this.f8116b.get(i10);
                }
            }
            return null;
        }

        public int b(String str) {
            int size = this.f8116b.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i) this.f8116b.get(i10)).f8120b.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public ComponentName c() {
            return this.f8117c.a();
        }

        public String d() {
            return this.f8117c.b();
        }

        public p0 e() {
            t0.d();
            return this.f8115a;
        }

        public List f() {
            t0.d();
            return Collections.unmodifiableList(this.f8116b);
        }

        public boolean g() {
            q0 q0Var = this.f8118d;
            if (q0Var == null || !q0Var.d()) {
                return false;
            }
            return true;
        }

        public boolean h(q0 q0Var) {
            if (this.f8118d == q0Var) {
                return false;
            }
            this.f8118d = q0Var;
            return true;
        }

        public String toString() {
            return "MediaRouter.RouteProviderInfo{ packageName=" + d() + " }";
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public final h f8119a;

        /* renamed from: b  reason: collision with root package name */
        public final String f8120b;

        /* renamed from: c  reason: collision with root package name */
        public final String f8121c;

        /* renamed from: d  reason: collision with root package name */
        public String f8122d;

        /* renamed from: e  reason: collision with root package name */
        public String f8123e;

        /* renamed from: f  reason: collision with root package name */
        public Uri f8124f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8125g;

        /* renamed from: h  reason: collision with root package name */
        public int f8126h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f8127i;

        /* renamed from: j  reason: collision with root package name */
        public final ArrayList f8128j = new ArrayList();

        /* renamed from: k  reason: collision with root package name */
        public int f8129k;

        /* renamed from: l  reason: collision with root package name */
        public int f8130l;

        /* renamed from: m  reason: collision with root package name */
        public int f8131m;

        /* renamed from: n  reason: collision with root package name */
        public int f8132n;

        /* renamed from: o  reason: collision with root package name */
        public int f8133o;

        /* renamed from: p  reason: collision with root package name */
        public int f8134p;

        /* renamed from: q  reason: collision with root package name */
        public Display f8135q;

        /* renamed from: r  reason: collision with root package name */
        public int f8136r = -1;

        /* renamed from: s  reason: collision with root package name */
        public Bundle f8137s;

        /* renamed from: t  reason: collision with root package name */
        public IntentSender f8138t;

        /* renamed from: u  reason: collision with root package name */
        public n0 f8139u;

        /* renamed from: v  reason: collision with root package name */
        public List f8140v = new ArrayList();

        /* renamed from: w  reason: collision with root package name */
        public Map f8141w;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public final p0.b.c f8142a;

            public a(p0.b.c cVar) {
                this.f8142a = cVar;
            }

            public int a() {
                p0.b.c cVar = this.f8142a;
                if (cVar != null) {
                    return cVar.c();
                }
                return 1;
            }

            public boolean b() {
                p0.b.c cVar = this.f8142a;
                if (cVar == null || !cVar.d()) {
                    return false;
                }
                return true;
            }

            public boolean c() {
                p0.b.c cVar = this.f8142a;
                if (cVar == null || !cVar.e()) {
                    return false;
                }
                return true;
            }

            public boolean d() {
                p0.b.c cVar = this.f8142a;
                if (cVar == null || cVar.f()) {
                    return true;
                }
                return false;
            }
        }

        public i(h hVar, String str, String str2) {
            this.f8119a = hVar;
            this.f8120b = str;
            this.f8121c = str2;
        }

        public static boolean D(i iVar) {
            return TextUtils.equals(iVar.r().q().b(), "android");
        }

        public final boolean A(List list, List list2) {
            if (list == list2) {
                return true;
            }
            if (list == null || list2 == null) {
                return false;
            }
            ListIterator listIterator = list.listIterator();
            ListIterator listIterator2 = list2.listIterator();
            while (listIterator.hasNext() && listIterator2.hasNext()) {
                if (!z((IntentFilter) listIterator.next(), (IntentFilter) listIterator2.next())) {
                    return false;
                }
            }
            if (listIterator.hasNext() || listIterator2.hasNext()) {
                return false;
            }
            return true;
        }

        public boolean B() {
            if (this.f8139u == null || !this.f8125g) {
                return false;
            }
            return true;
        }

        public boolean C() {
            t0.d();
            if (t0.f8052d.v() == this) {
                return true;
            }
            return false;
        }

        public boolean E(s0 s0Var) {
            if (s0Var != null) {
                t0.d();
                return s0Var.h(this.f8128j);
            }
            throw new IllegalArgumentException("selector must not be null");
        }

        public int F(n0 n0Var) {
            if (this.f8139u != n0Var) {
                return K(n0Var);
            }
            return 0;
        }

        public void G(int i10) {
            t0.d();
            t0.f8052d.G(this, Math.min(this.f8134p, Math.max(0, i10)));
        }

        public void H(int i10) {
            t0.d();
            if (i10 != 0) {
                t0.f8052d.H(this, i10);
            }
        }

        public void I() {
            t0.d();
            t0.f8052d.I(this, 3);
        }

        public boolean J(String str) {
            if (str != null) {
                t0.d();
                int size = this.f8128j.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (((IntentFilter) this.f8128j.get(i10)).hasCategory(str)) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("category must not be null");
        }

        public int K(n0 n0Var) {
            int i10;
            this.f8139u = n0Var;
            boolean z10 = false;
            if (n0Var == null) {
                return 0;
            }
            if (!a0.c.a(this.f8122d, n0Var.o())) {
                this.f8122d = n0Var.o();
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (!a0.c.a(this.f8123e, n0Var.g())) {
                this.f8123e = n0Var.g();
                i10 |= 1;
            }
            if (!a0.c.a(this.f8124f, n0Var.k())) {
                this.f8124f = n0Var.k();
                i10 |= 1;
            }
            if (this.f8125g != n0Var.w()) {
                this.f8125g = n0Var.w();
                i10 |= 1;
            }
            if (this.f8126h != n0Var.e()) {
                this.f8126h = n0Var.e();
                i10 |= 1;
            }
            if (!A(this.f8128j, n0Var.f())) {
                this.f8128j.clear();
                this.f8128j.addAll(n0Var.f());
                i10 |= 1;
            }
            if (this.f8129k != n0Var.q()) {
                this.f8129k = n0Var.q();
                i10 |= 1;
            }
            if (this.f8130l != n0Var.p()) {
                this.f8130l = n0Var.p();
                i10 |= 1;
            }
            if (this.f8131m != n0Var.h()) {
                this.f8131m = n0Var.h();
                i10 |= 1;
            }
            if (this.f8132n != n0Var.u()) {
                this.f8132n = n0Var.u();
                i10 |= 3;
            }
            if (this.f8133o != n0Var.t()) {
                this.f8133o = n0Var.t();
                i10 |= 3;
            }
            if (this.f8134p != n0Var.v()) {
                this.f8134p = n0Var.v();
                i10 |= 3;
            }
            if (this.f8136r != n0Var.r()) {
                this.f8136r = n0Var.r();
                this.f8135q = null;
                i10 |= 5;
            }
            if (!a0.c.a(this.f8137s, n0Var.i())) {
                this.f8137s = n0Var.i();
                i10 |= 1;
            }
            if (!a0.c.a(this.f8138t, n0Var.s())) {
                this.f8138t = n0Var.s();
                i10 |= 1;
            }
            if (this.f8127i != n0Var.a()) {
                this.f8127i = n0Var.a();
                i10 |= 5;
            }
            List<String> j10 = n0Var.j();
            ArrayList arrayList = new ArrayList();
            if (j10.size() != this.f8140v.size()) {
                z10 = true;
            }
            for (String w10 : j10) {
                i r10 = t0.f8052d.r(t0.f8052d.w(q(), w10));
                if (r10 != null) {
                    arrayList.add(r10);
                    if (!z10 && !this.f8140v.contains(r10)) {
                        z10 = true;
                    }
                }
            }
            if (!z10) {
                return i10;
            }
            this.f8140v = arrayList;
            return i10 | 1;
        }

        public void L(Collection collection) {
            this.f8140v.clear();
            if (this.f8141w == null) {
                this.f8141w = new androidx.collection.a();
            }
            this.f8141w.clear();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                p0.b.c cVar = (p0.b.c) it.next();
                i b10 = b(cVar);
                if (b10 != null) {
                    this.f8141w.put(b10.f8121c, cVar);
                    if (cVar.c() == 2 || cVar.c() == 3) {
                        this.f8140v.add(b10);
                    }
                }
            }
            t0.f8052d.f8069k.b(259, this);
        }

        public boolean a() {
            return this.f8127i;
        }

        public i b(p0.b.c cVar) {
            return q().a(cVar.b().l());
        }

        public int c() {
            return this.f8126h;
        }

        public String d() {
            return this.f8123e;
        }

        public String e() {
            return this.f8120b;
        }

        public int f() {
            return this.f8131m;
        }

        public p0.b g() {
            p0.e eVar = t0.f8052d.f8078t;
            if (eVar instanceof p0.b) {
                return (p0.b) eVar;
            }
            return null;
        }

        public a h(i iVar) {
            Map map = this.f8141w;
            if (map == null || !map.containsKey(iVar.f8121c)) {
                return null;
            }
            return new a((p0.b.c) this.f8141w.get(iVar.f8121c));
        }

        public Bundle i() {
            return this.f8137s;
        }

        public Uri j() {
            return this.f8124f;
        }

        public String k() {
            return this.f8121c;
        }

        public List l() {
            return Collections.unmodifiableList(this.f8140v);
        }

        public String m() {
            return this.f8122d;
        }

        public int n() {
            return this.f8130l;
        }

        public int o() {
            return this.f8129k;
        }

        public int p() {
            return this.f8136r;
        }

        public h q() {
            return this.f8119a;
        }

        public p0 r() {
            return this.f8119a.e();
        }

        public int s() {
            return this.f8133o;
        }

        public int t() {
            return this.f8132n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaRouter.RouteInfo{ uniqueId=" + this.f8121c + ", name=" + this.f8122d + ", description=" + this.f8123e + ", iconUri=" + this.f8124f + ", enabled=" + this.f8125g + ", connectionState=" + this.f8126h + ", canDisconnect=" + this.f8127i + ", playbackType=" + this.f8129k + ", playbackStream=" + this.f8130l + ", deviceType=" + this.f8131m + ", volumeHandling=" + this.f8132n + ", volume=" + this.f8133o + ", volumeMax=" + this.f8134p + ", presentationDisplayId=" + this.f8136r + ", extras=" + this.f8137s + ", settingsIntent=" + this.f8138t + ", providerPackageName=" + this.f8119a.d());
            if (y()) {
                sb.append(", members=[");
                int size = this.f8140v.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    if (this.f8140v.get(i10) != this) {
                        sb.append(((i) this.f8140v.get(i10)).k());
                    }
                }
                sb.append(']');
            }
            sb.append(" }");
            return sb.toString();
        }

        public int u() {
            return this.f8134p;
        }

        public boolean v() {
            t0.d();
            if (t0.f8052d.o() == this) {
                return true;
            }
            return false;
        }

        public boolean w() {
            if (v() || this.f8131m == 3) {
                return true;
            }
            if (!D(this) || !J("android.media.intent.category.LIVE_AUDIO") || J("android.media.intent.category.LIVE_VIDEO")) {
                return false;
            }
            return true;
        }

        public boolean x() {
            return this.f8125g;
        }

        public boolean y() {
            if (l().size() >= 1) {
                return true;
            }
            return false;
        }

        public final boolean z(IntentFilter intentFilter, IntentFilter intentFilter2) {
            int countActions;
            if (intentFilter == intentFilter2) {
                return true;
            }
            if (intentFilter == null || intentFilter2 == null || (countActions = intentFilter.countActions()) != intentFilter2.countActions()) {
                return false;
            }
            for (int i10 = 0; i10 < countActions; i10++) {
                if (!intentFilter.getAction(i10).equals(intentFilter2.getAction(i10))) {
                    return false;
                }
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories != intentFilter2.countCategories()) {
                return false;
            }
            for (int i11 = 0; i11 < countCategories; i11++) {
                if (!intentFilter.getCategory(i11).equals(intentFilter2.getCategory(i11))) {
                    return false;
                }
            }
            return true;
        }
    }

    public t0(Context context) {
        this.f8053a = context;
    }

    public static void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    public static int h() {
        e eVar = f8052d;
        if (eVar == null) {
            return 0;
        }
        return eVar.n();
    }

    public static t0 i(Context context) {
        if (context != null) {
            d();
            if (f8052d == null) {
                e eVar = new e(context.getApplicationContext());
                f8052d = eVar;
                eVar.N();
            }
            return f8052d.s(context);
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public static boolean n() {
        e eVar = f8052d;
        if (eVar == null) {
            return false;
        }
        return eVar.x();
    }

    public static boolean p() {
        e eVar = f8052d;
        if (eVar == null) {
            return false;
        }
        return eVar.B();
    }

    public void a(s0 s0Var, b bVar) {
        b(s0Var, bVar, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: n0.t0$c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(n0.s0 r3, n0.t0.b r4, int r5) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x007b
            if (r4 == 0) goto L_0x0073
            d()
            boolean r0 = f8051c
            if (r0 == 0) goto L_0x002c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "addCallback: selector="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = ", callback="
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ", flags="
            r0.append(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r5)
            r0.append(r1)
        L_0x002c:
            int r0 = r2.e(r4)
            if (r0 >= 0) goto L_0x003d
            n0.t0$c r0 = new n0.t0$c
            r0.<init>(r2, r4)
            java.util.ArrayList r4 = r2.f8054b
            r4.add(r0)
            goto L_0x0046
        L_0x003d:
            java.util.ArrayList r4 = r2.f8054b
            java.lang.Object r4 = r4.get(r0)
            r0 = r4
            n0.t0$c r0 = (n0.t0.c) r0
        L_0x0046:
            int r4 = r0.f8058d
            r1 = 1
            if (r5 == r4) goto L_0x004f
            r0.f8058d = r5
            r4 = 1
            goto L_0x0050
        L_0x004f:
            r4 = 0
        L_0x0050:
            n0.s0 r5 = r0.f8057c
            boolean r5 = r5.b(r3)
            if (r5 != 0) goto L_0x006a
            n0.s0$a r4 = new n0.s0$a
            n0.s0 r5 = r0.f8057c
            r4.<init>(r5)
            n0.s0$a r3 = r4.c(r3)
            n0.s0 r3 = r3.d()
            r0.f8057c = r3
            goto L_0x006b
        L_0x006a:
            r1 = r4
        L_0x006b:
            if (r1 == 0) goto L_0x0072
            n0.t0$e r3 = f8052d
            r3.P()
        L_0x0072:
            return
        L_0x0073:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "callback must not be null"
            r3.<init>(r4)
            throw r3
        L_0x007b:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "selector must not be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.t0.b(n0.s0, n0.t0$b, int):void");
    }

    public void c(i iVar) {
        d();
        f8052d.f(iVar);
    }

    public final int e(b bVar) {
        int size = this.f8054b.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((c) this.f8054b.get(i10)).f8056b == bVar) {
                return i10;
            }
        }
        return -1;
    }

    public i f() {
        d();
        return f8052d.m();
    }

    public i g() {
        d();
        return f8052d.o();
    }

    public MediaSessionCompat.Token j() {
        return f8052d.q();
    }

    public o1 k() {
        d();
        return f8052d.t();
    }

    public List l() {
        d();
        return f8052d.u();
    }

    public i m() {
        d();
        return f8052d.v();
    }

    public boolean o(s0 s0Var, int i10) {
        if (s0Var != null) {
            d();
            return f8052d.y(s0Var, i10);
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    public void q(b bVar) {
        if (bVar != null) {
            d();
            if (f8051c) {
                StringBuilder sb = new StringBuilder();
                sb.append("removeCallback: callback=");
                sb.append(bVar);
            }
            int e10 = e(bVar);
            if (e10 >= 0) {
                this.f8054b.remove(e10);
                f8052d.P();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public void r(i iVar) {
        d();
        f8052d.E(iVar);
    }

    public void s(i iVar) {
        if (iVar != null) {
            d();
            if (f8051c) {
                StringBuilder sb = new StringBuilder();
                sb.append("selectRoute: ");
                sb.append(iVar);
            }
            f8052d.I(iVar, 3);
            return;
        }
        throw new IllegalArgumentException("route must not be null");
    }

    public void t(MediaSessionCompat mediaSessionCompat) {
        if (f8051c) {
            StringBuilder sb = new StringBuilder();
            sb.append("addMediaSessionCompat: ");
            sb.append(mediaSessionCompat);
        }
        f8052d.K(mediaSessionCompat);
    }

    public void u(f fVar) {
        d();
        f8052d.A = fVar;
    }

    public void v(o1 o1Var) {
        d();
        f8052d.M(o1Var);
    }

    public void w(i iVar) {
        d();
        f8052d.O(iVar);
    }

    public void x(int i10) {
        if (i10 < 0 || i10 > 3) {
            throw new IllegalArgumentException("Unsupported reason to unselect route");
        }
        d();
        i i11 = f8052d.i();
        if (f8052d.v() != i11) {
            f8052d.I(i11, i10);
        }
    }
}
