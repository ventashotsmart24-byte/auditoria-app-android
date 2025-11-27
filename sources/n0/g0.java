package n0;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import androidx.mediarouter.R$string;
import com.hpplay.component.protocol.PlistBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import n0.n0;
import n0.p0;
import n0.q0;
import n0.s0;
import n0.t0;

public class g0 extends p0 {

    /* renamed from: s  reason: collision with root package name */
    public static final boolean f7922s = Log.isLoggable("MR2Provider", 3);

    /* renamed from: i  reason: collision with root package name */
    public final MediaRouter2 f7923i;

    /* renamed from: j  reason: collision with root package name */
    public final a f7924j;

    /* renamed from: k  reason: collision with root package name */
    public final Map f7925k = new ArrayMap();

    /* renamed from: l  reason: collision with root package name */
    public final MediaRouter2.RouteCallback f7926l = new e();

    /* renamed from: m  reason: collision with root package name */
    public final MediaRouter2.TransferCallback f7927m = new f();

    /* renamed from: n  reason: collision with root package name */
    public final MediaRouter2.ControllerCallback f7928n = new b();

    /* renamed from: o  reason: collision with root package name */
    public final Handler f7929o;

    /* renamed from: p  reason: collision with root package name */
    public final Executor f7930p;

    /* renamed from: q  reason: collision with root package name */
    public List f7931q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public Map f7932r = new ArrayMap();

    public static abstract class a {
        public abstract void a(p0.e eVar);

        public abstract void b(int i10);

        public abstract void c(String str, int i10);
    }

    public class b extends MediaRouter2.ControllerCallback {
        public b() {
        }

        public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
            g0.this.F(routingController);
        }
    }

    public class c extends p0.b {

        /* renamed from: f  reason: collision with root package name */
        public final String f7934f;

        /* renamed from: g  reason: collision with root package name */
        public final MediaRouter2.RoutingController f7935g;

        /* renamed from: h  reason: collision with root package name */
        public final Messenger f7936h;

        /* renamed from: i  reason: collision with root package name */
        public final Messenger f7937i;

        /* renamed from: j  reason: collision with root package name */
        public final SparseArray f7938j = new SparseArray();

        /* renamed from: k  reason: collision with root package name */
        public final Handler f7939k;

        /* renamed from: l  reason: collision with root package name */
        public AtomicInteger f7940l = new AtomicInteger(1);

        /* renamed from: m  reason: collision with root package name */
        public final Runnable f7941m = new l0(this);

        /* renamed from: n  reason: collision with root package name */
        public int f7942n = -1;

        public class a extends Handler {
            public a() {
                super(Looper.getMainLooper());
            }

            public void handleMessage(Message message) {
                String str;
                int i10 = message.what;
                int i11 = message.arg1;
                Object obj = message.obj;
                Bundle peekData = message.peekData();
                t0.d dVar = (t0.d) c.this.f7938j.get(i11);
                if (dVar != null) {
                    c.this.f7938j.remove(i11);
                    if (i10 == 3) {
                        dVar.b((Bundle) obj);
                    } else if (i10 == 4) {
                        if (peekData == null) {
                            str = null;
                        } else {
                            str = peekData.getString("error");
                        }
                        dVar.a(str, (Bundle) obj);
                    }
                }
            }
        }

        public c(MediaRouter2.RoutingController routingController, String str) {
            Messenger messenger;
            this.f7935g = routingController;
            this.f7934f = str;
            Messenger A = g0.A(routingController);
            this.f7936h = A;
            if (A == null) {
                messenger = null;
            } else {
                messenger = new Messenger(new a());
            }
            this.f7937i = messenger;
            this.f7939k = new Handler(Looper.getMainLooper());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r() {
            this.f7942n = -1;
        }

        public void d() {
            this.f7935g.release();
        }

        public void f(int i10) {
            MediaRouter2.RoutingController routingController = this.f7935g;
            if (routingController != null) {
                routingController.setVolume(i10);
                this.f7942n = i10;
                s();
            }
        }

        public void i(int i10) {
            MediaRouter2.RoutingController routingController = this.f7935g;
            if (routingController != null) {
                int i11 = this.f7942n;
                if (i11 < 0) {
                    i11 = routingController.getVolume();
                }
                int max = Math.max(0, Math.min(i11 + i10, this.f7935g.getVolumeMax()));
                this.f7942n = max;
                this.f7935g.setVolume(max);
                s();
            }
        }

        public void m(String str) {
            if (str != null && !str.isEmpty()) {
                MediaRoute2Info B = g0.this.B(str);
                if (B == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onAddMemberRoute: Specified route not found. routeId=");
                    sb.append(str);
                    return;
                }
                this.f7935g.selectRoute(B);
            }
        }

        public void n(String str) {
            if (str != null && !str.isEmpty()) {
                MediaRoute2Info B = g0.this.B(str);
                if (B == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onRemoveMemberRoute: Specified route not found. routeId=");
                    sb.append(str);
                    return;
                }
                this.f7935g.deselectRoute(B);
            }
        }

        public void o(List list) {
            if (list != null && !list.isEmpty()) {
                String str = (String) list.get(0);
                MediaRoute2Info B = g0.this.B(str);
                if (B == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onUpdateMemberRoutes: Specified route not found. routeId=");
                    sb.append(str);
                    return;
                }
                g0.this.f7923i.transferTo(B);
            }
        }

        public final void s() {
            this.f7939k.removeCallbacks(this.f7941m);
            this.f7939k.postDelayed(this.f7941m, 1000);
        }

        public void t(String str, int i10) {
            int andIncrement = this.f7940l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i10);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = this.f7937i;
            try {
                this.f7936h.send(obtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e10) {
                Log.e("MR2Provider", "Could not send control request to service.", e10);
            }
        }

        public void u(String str, int i10) {
            int andIncrement = this.f7940l.getAndIncrement();
            Message obtain = Message.obtain();
            obtain.what = 8;
            obtain.arg1 = andIncrement;
            Bundle bundle = new Bundle();
            bundle.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i10);
            bundle.putString("routeId", str);
            obtain.setData(bundle);
            obtain.replyTo = this.f7937i;
            try {
                this.f7936h.send(obtain);
            } catch (DeadObjectException unused) {
            } catch (RemoteException e10) {
                Log.e("MR2Provider", "Could not send control request to service.", e10);
            }
        }
    }

    public class d extends p0.e {

        /* renamed from: a  reason: collision with root package name */
        public final String f7945a;

        /* renamed from: b  reason: collision with root package name */
        public final c f7946b;

        public d(String str, c cVar) {
            this.f7945a = str;
            this.f7946b = cVar;
        }

        public void f(int i10) {
            c cVar;
            String str = this.f7945a;
            if (str != null && (cVar = this.f7946b) != null) {
                cVar.t(str, i10);
            }
        }

        public void i(int i10) {
            c cVar;
            String str = this.f7945a;
            if (str != null && (cVar = this.f7946b) != null) {
                cVar.u(str, i10);
            }
        }
    }

    public class e extends MediaRouter2.RouteCallback {
        public e() {
        }

        public void onRoutesAdded(List list) {
            g0.this.E();
        }

        public void onRoutesChanged(List list) {
            g0.this.E();
        }

        public void onRoutesRemoved(List list) {
            g0.this.E();
        }
    }

    public class f extends MediaRouter2.TransferCallback {
        public f() {
        }

        public void onStop(MediaRouter2.RoutingController routingController) {
            p0.e eVar = (p0.e) g0.this.f7925k.remove(routingController);
            if (eVar != null) {
                g0.this.f7924j.a(eVar);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onStop: No matching routeController found. routingController=");
            sb.append(routingController);
        }

        public void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
            g0.this.f7925k.remove(routingController);
            if (routingController2 == g0.this.f7923i.getSystemController()) {
                g0.this.f7924j.b(3);
                return;
            }
            List a10 = routingController2.getSelectedRoutes();
            if (!a10.isEmpty()) {
                String a11 = b.a(a10.get(0)).getId();
                g0.this.f7925k.put(routingController2, new c(routingController2, a11));
                g0.this.f7924j.c(a11, 3);
                g0.this.F(routingController2);
            }
        }

        public void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
            StringBuilder sb = new StringBuilder();
            sb.append("Transfer failed. requestedRoute=");
            sb.append(mediaRoute2Info);
        }
    }

    public g0(Context context, a aVar) {
        super(context);
        this.f7923i = MediaRouter2.getInstance(context);
        this.f7924j = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f7929o = handler;
        Objects.requireNonNull(handler);
        this.f7930p = new c0(handler);
    }

    public static Messenger A(MediaRouter2.RoutingController routingController) {
        Bundle a10;
        if (routingController == null || (a10 = routingController.getControlHints()) == null) {
            return null;
        }
        return (Messenger) a10.getParcelable("androidx.mediarouter.media.KEY_MESSENGER");
    }

    public static String C(p0.e eVar) {
        MediaRouter2.RoutingController routingController;
        if ((eVar instanceof c) && (routingController = ((c) eVar).f7935g) != null) {
            return routingController.getId();
        }
        return null;
    }

    public static /* synthetic */ boolean D(MediaRoute2Info mediaRoute2Info) {
        return !mediaRoute2Info.isSystemRoute();
    }

    public MediaRoute2Info B(String str) {
        if (str == null) {
            return null;
        }
        for (Object a10 : this.f7931q) {
            MediaRoute2Info a11 = b.a(a10);
            if (TextUtils.equals(a11.getId(), str)) {
                return a11;
            }
        }
        return null;
    }

    public void E() {
        List list = (List) this.f7923i.getRoutes().stream().distinct().filter(new f0()).collect(Collectors.toList());
        if (!list.equals(this.f7931q)) {
            this.f7931q = list;
            this.f7932r.clear();
            for (Object a10 : this.f7931q) {
                MediaRoute2Info a11 = b.a(a10);
                Bundle a12 = a11.getExtras();
                if (a12 == null || a12.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot find the original route Id. route=");
                    sb.append(a11);
                } else {
                    this.f7932r.put(a11.getId(), a12.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
                }
            }
            w(new q0.a().d(true).b((List) this.f7931q.stream().map(new d0()).filter(new e0()).collect(Collectors.toList())).c());
        }
    }

    public void F(MediaRouter2.RoutingController routingController) {
        int i10;
        c cVar = (c) this.f7925k.get(routingController);
        if (cVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setDynamicRouteDescriptors: No matching routeController found. routingController=");
            sb.append(routingController);
            return;
        }
        List a10 = i1.a(routingController.getSelectedRoutes());
        n0 c10 = i1.c(b.a(routingController.getSelectedRoutes().get(0)));
        Bundle a11 = routingController.getControlHints();
        String string = n().getString(R$string.mr_dialog_default_group_name);
        n0 n0Var = null;
        if (a11 != null) {
            try {
                String string2 = a11.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = a11.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    n0Var = n0.d(bundle);
                }
            } catch (Exception unused) {
            }
        }
        if (n0Var == null) {
            n0Var = new n0.a(routingController.getId(), string).g(2).p(1).r(routingController.getVolume()).t(routingController.getVolumeMax()).s(routingController.getVolumeHandling()).b(c10.f()).d(a10).e();
        }
        List a12 = i1.a(routingController.getSelectableRoutes());
        List a13 = i1.a(routingController.getDeselectableRoutes());
        q0 o10 = o();
        if (o10 != null) {
            ArrayList arrayList = new ArrayList();
            List<n0> b10 = o10.b();
            if (!b10.isEmpty()) {
                for (n0 n0Var2 : b10) {
                    String l10 = n0Var2.l();
                    p0.b.c.a aVar = new p0.b.c.a(n0Var2);
                    if (a10.contains(l10)) {
                        i10 = 3;
                    } else {
                        i10 = 1;
                    }
                    arrayList.add(aVar.e(i10).b(a12.contains(l10)).d(a13.contains(l10)).c(true).a());
                }
            }
            cVar.l(n0Var, arrayList);
        }
    }

    public void G(String str) {
        MediaRoute2Info B = B(str);
        if (B == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("transferTo: Specified route not found. routeId=");
            sb.append(str);
            return;
        }
        this.f7923i.transferTo(B);
    }

    public final o0 H(o0 o0Var, boolean z10) {
        if (o0Var == null) {
            o0Var = new o0(s0.f8047c, false);
        }
        List e10 = o0Var.c().e();
        if (!z10) {
            e10.remove("android.media.intent.category.LIVE_AUDIO");
        } else if (!e10.contains("android.media.intent.category.LIVE_AUDIO")) {
            e10.add("android.media.intent.category.LIVE_AUDIO");
        }
        return new o0(new s0.a().a(e10).d(), o0Var.d());
    }

    public p0.b r(String str) {
        for (Map.Entry value : this.f7925k.entrySet()) {
            c cVar = (c) value.getValue();
            if (TextUtils.equals(str, cVar.f7934f)) {
                return cVar;
            }
        }
        return null;
    }

    public p0.e s(String str) {
        return new d((String) this.f7932r.get(str), (c) null);
    }

    public p0.e t(String str, String str2) {
        String str3 = (String) this.f7932r.get(str);
        for (c cVar : this.f7925k.values()) {
            if (TextUtils.equals(str2, cVar.f7935g.getId())) {
                return new d(str3, cVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find the matching GroupRouteController. routeId=");
        sb.append(str);
        sb.append(", routeGroupId=");
        sb.append(str2);
        return new d(str3, (c) null);
    }

    public void u(o0 o0Var) {
        if (t0.h() > 0) {
            this.f7923i.registerRouteCallback(this.f7930p, this.f7926l, i1.b(H(o0Var, t0.p())));
            this.f7923i.registerTransferCallback(this.f7930p, this.f7927m);
            this.f7923i.registerControllerCallback(this.f7930p, this.f7928n);
            return;
        }
        this.f7923i.unregisterRouteCallback(this.f7926l);
        this.f7923i.unregisterTransferCallback(this.f7927m);
        this.f7923i.unregisterControllerCallback(this.f7928n);
    }
}
