package l8;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.PlistBuilder;
import com.titan.ranger.NativeJni;
import com.titan.ranger.bean.Env;
import com.titan.ranger.bean.Program;
import com.titan.thumbnail.PreviewUtil;
import com.titan.thumbnail.ThumbnailCallback;
import com.titan.thumbnail.ThumbnailRequest;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import java.util.List;
import t9.x;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class h {

    /* renamed from: k  reason: collision with root package name */
    public static final h9.g f7637k = h9.h.b(a.f18772a);

    /* renamed from: l  reason: collision with root package name */
    public static String f7638l = "[2.5.4]";

    /* renamed from: m  reason: collision with root package name */
    public static final b f7639m = new b((t9.g) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f7640a;

    /* renamed from: b  reason: collision with root package name */
    public final e[] f7641b;

    /* renamed from: c  reason: collision with root package name */
    public String f7642c;

    /* renamed from: d  reason: collision with root package name */
    public k8.a f7643d;

    /* renamed from: e  reason: collision with root package name */
    public j8.a f7644e;

    /* renamed from: f  reason: collision with root package name */
    public j8.b f7645f;

    /* renamed from: g  reason: collision with root package name */
    public Env f7646g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f7647h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerThread f7648i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f7649j;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ z9.g[] f7650a = {x.e(new t9.r(x.a(b.class), "instance", "getInstance()Lcom/titan/media/TitanPlayer;"))};

        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final h a() {
            return b();
        }

        public final h b() {
            h9.g a10 = h.f7637k;
            z9.g gVar = f7650a[0];
            return (h) a10.getValue();
        }

        public final String c() {
            return h.f7638l;
        }

        public final void d(String str) {
            t9.i.h(str, "<set-?>");
            h.f7638l = str;
        }
    }

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18772a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final h invoke() {
            return new h((t9.g) null);
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18773a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18774b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j8.a f18775c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ j8.b f18776d;

        public c(h hVar, String str, j8.a aVar, j8.b bVar) {
            this.f18773a = hVar;
            this.f18774b = str;
            this.f18775c = aVar;
            this.f18776d = bVar;
        }

        public final void run() {
            this.f18773a.f7642c = this.f18774b;
            this.f18773a.f7644e = this.f18775c;
            this.f18773a.f7645f = this.f18776d;
            NativeJni.c().f(this.f18774b);
            this.f18773a.s(0);
            this.f18773a.s(1);
            this.f18773a.f7643d = new k8.a(0);
            k8.a c10 = this.f18773a.f7643d;
            if (c10 != null) {
                c10.s(com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT, false);
            }
            this.f18773a.q();
            this.f18773a.q();
            StringBuilder sb = new StringBuilder();
            sb.append("titan:2.5.4;ranger:");
            sb.append(NativeJni.f13324d);
        }
    }

    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i8.d f18777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i8.e f18778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i8.c f18779c;

        public d(i8.d dVar, i8.e eVar, i8.c cVar) {
            this.f18777a = dVar;
            this.f18778b = eVar;
            this.f18779c = cVar;
        }

        public final void run() {
            NativeJni.c().m(this.f18777a.a(), this.f18778b.a(), this.f18779c.a());
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i8.d f18780a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i8.e f18781b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f18782c;

        public e(i8.d dVar, i8.e eVar, int i10) {
            this.f18780a = dVar;
            this.f18781b = eVar;
            this.f18782c = i10;
        }

        public final void run() {
            NativeJni.c().m(this.f18780a.a(), this.f18781b.a(), String.valueOf(this.f18782c));
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18783a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18784b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18785c;

        public f(h hVar, int i10, String str) {
            this.f18783a = hVar;
            this.f18784b = i10;
            this.f18785c = str;
        }

        public final void run() {
            e eVar = this.f18783a.f7641b[this.f18784b];
            if (eVar != null) {
                eVar.s0(this.f18785c);
            }
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18786a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18787b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18788c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Program f18789d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18790e;

        public g(h hVar, int i10, String str, Program program, String str2) {
            this.f18786a = hVar;
            this.f18787b = i10;
            this.f18788c = str;
            this.f18789d = program;
            this.f18790e = str2;
        }

        public final void run() {
            e eVar = this.f18786a.f7641b[this.f18787b];
            if (eVar != null) {
                eVar.t0(this.f18788c, this.f18789d, this.f18790e);
            }
        }
    }

    /* renamed from: l8.h$h  reason: collision with other inner class name */
    public static final class C0271h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18791a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18792b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18793c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Program f18794d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18795e;

        public C0271h(h hVar, int i10, String str, Program program, String str2) {
            this.f18791a = hVar;
            this.f18792b = i10;
            this.f18793c = str;
            this.f18794d = program;
            this.f18795e = str2;
        }

        public final void run() {
            e eVar = this.f18791a.f7641b[this.f18792b];
            if (eVar != null) {
                eVar.u0(this.f18793c, this.f18794d, this.f18795e);
            }
        }
    }

    public static final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18796a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18798c;

        public i(h hVar, int i10, String str) {
            this.f18796a = hVar;
            this.f18797b = i10;
            this.f18798c = str;
        }

        public final void run() {
            e eVar = this.f18796a.f7641b[this.f18797b];
            if (eVar != null) {
                eVar.A0(this.f18798c);
            }
        }
    }

    public static final class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18799a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18800b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18801c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f18802d;

        public j(h hVar, int i10, String str, long j10) {
            this.f18799a = hVar;
            this.f18800b = i10;
            this.f18801c = str;
            this.f18802d = j10;
        }

        public final void run() {
            e eVar = this.f18799a.f7641b[this.f18800b];
            if (eVar != null) {
                eVar.C0(this.f18801c, this.f18802d);
            }
        }
    }

    public static final class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f18803a;

        public k(List list) {
            this.f18803a = list;
        }

        public final void run() {
            NativeJni.c().s(m8.a.a().toJson((Object) this.f18803a));
        }
    }

    public static final class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18804a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Env f18805b;

        public l(h hVar, Env env) {
            this.f18804a = hVar;
            this.f18805b = env;
        }

        public final void run() {
            int i10;
            Env env = this.f18805b;
            k8.a c10 = this.f18804a.f7643d;
            if (c10 != null) {
                i10 = c10.j();
            } else {
                i10 = -1;
            }
            env.setTitan_port(i10);
            this.f18804a.E(this.f18805b);
            NativeJni.c().u(m8.a.a().toJson((Object) this.f18805b));
        }
    }

    public static final class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18806a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18807b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18808c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18809d;

        public m(h hVar, int i10, String str, String str2) {
            this.f18806a = hVar;
            this.f18807b = i10;
            this.f18808c = str;
            this.f18809d = str2;
        }

        public final void run() {
            e eVar = this.f18806a.f7641b[this.f18807b];
            if (eVar != null) {
                eVar.J0(this.f18808c, this.f18809d);
            }
        }
    }

    public static final class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18810a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18811b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18812c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f18813d;

        public n(h hVar, int i10, String str, int i11) {
            this.f18810a = hVar;
            this.f18811b = i10;
            this.f18812c = str;
            this.f18813d = i11;
        }

        public final void run() {
            String str;
            e eVar = this.f18810a.f7641b[this.f18811b];
            String str2 = this.f18812c;
            switch (str2.hashCode()) {
                case -2060497896:
                    str = MediaTrack.ROLE_SUBTITLE;
                    break;
                case -1662454116:
                    str = "subtitle_delay";
                    break;
                case -1024974996:
                    str = "buffer_time";
                    break;
                case -810883302:
                    if (str2.equals(PlistBuilder.VALUE_TYPE_VOLUME) && eVar != null) {
                        eVar.P0(this.f18813d);
                        return;
                    }
                    return;
                case -46576386:
                    str = bt.aZ;
                    break;
                case 93166550:
                    if (str2.equals("audio") && eVar != null) {
                        eVar.D0(this.f18813d);
                        return;
                    }
                    return;
                case 109641799:
                    if (str2.equals("speed") && eVar != null) {
                        eVar.M0(this.f18813d);
                        return;
                    }
                    return;
                case 782236819:
                    str = "hdr_map";
                    break;
                case 1330532588:
                    if (str2.equals("thumbnail") && eVar != null) {
                        eVar.G0(this.f18813d);
                        return;
                    }
                    return;
                case 1689832893:
                    if (str2.equals("polling_period") && eVar != null) {
                        eVar.L0(this.f18813d);
                        return;
                    }
                    return;
                case 1943400114:
                    if (str2.equals("mediacodec") && eVar != null) {
                        eVar.H0(this.f18813d);
                        return;
                    }
                    return;
                case 2132222038:
                    str = "default_subtitle";
                    break;
                default:
                    return;
            }
            str2.equals(str);
        }
    }

    public static final class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18814a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18815b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18816c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18817d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f18818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f18819f;

        public o(h hVar, int i10, String str, String str2, Context context, int i11) {
            this.f18814a = hVar;
            this.f18815b = i10;
            this.f18816c = str;
            this.f18817d = str2;
            this.f18818e = context;
            this.f18819f = i11;
        }

        public final void run() {
            e eVar = this.f18814a.f7641b[this.f18815b];
            String str = this.f18816c;
            if (str.hashCode() == -985752863 && str.equals("player")) {
                if (eVar != null) {
                    eVar.I0(this.f18818e);
                }
                if (!this.f18814a.f7647h && t9.i.b(this.f18817d, "ijk")) {
                    String loadLibrariesOnce = IjkMediaPlayer.loadLibrariesOnce((IjkLibLoader) null);
                    if (loadLibrariesOnce != null) {
                        NativeJni.c().k(this.f18815b, "onError", 0, 1300, 0, loadLibrariesOnce);
                    }
                    this.f18814a.f7647h = true;
                    this.f18814a.q();
                    this.f18814a.q();
                    StringBuilder sb = new StringBuilder();
                    sb.append("ijk:");
                    sb.append(IjkMediaPlayer.getIjkVersion());
                    sb.append(";ffmpeg:");
                    sb.append(IjkMediaPlayer.getFFVersion());
                    b bVar = h.f7639m;
                    bVar.d(bVar.c() + "-[" + IjkMediaPlayer.getIjkVersion() + "]-[" + IjkMediaPlayer.getFFVersion() + ']');
                }
                if (eVar != null) {
                    eVar.W0(this.f18817d, this.f18819f);
                }
            }
        }
    }

    public static final class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18820a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18821b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Surface f18822c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f18823d;

        public p(h hVar, int i10, Surface surface, String str) {
            this.f18820a = hVar;
            this.f18821b = i10;
            this.f18822c = surface;
            this.f18823d = str;
        }

        public final void run() {
            e eVar = this.f18820a.f7641b[this.f18821b];
            if (eVar != null) {
                eVar.N0(this.f18822c, this.f18823d);
            }
        }
    }

    public static final class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18824a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18825b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18826c;

        public q(h hVar, int i10, String str) {
            this.f18824a = hVar;
            this.f18825b = i10;
            this.f18826c = str;
        }

        public final void run() {
            e eVar = this.f18824a.f7641b[this.f18825b];
            if (eVar != null) {
                eVar.T0(this.f18826c);
            }
        }
    }

    public static final class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f18827a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18828b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18829c;

        public r(h hVar, int i10, String str) {
            this.f18827a = hVar;
            this.f18828b = i10;
            this.f18829c = str;
        }

        public final void run() {
            e eVar = this.f18827a.f7641b[this.f18828b];
            if (eVar != null) {
                eVar.V0(this.f18829c);
            }
        }
    }

    public h() {
        String simpleName = h.class.getSimpleName();
        t9.i.c(simpleName, "javaClass.simpleName");
        this.f7640a = simpleName;
        this.f7641b = new e[2];
        this.f7642c = "";
        HandlerThread handlerThread = new HandlerThread("handlerTitan", -4);
        this.f7648i = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = this.f7648i;
        this.f7649j = new Handler(handlerThread2 != null ? handlerThread2.getLooper() : null);
    }

    public final void A(int i10, String str) {
        t9.i.h(str, "name");
        x(new i(this, i10, str));
    }

    public final void B(int i10, String str, long j10) {
        t9.i.h(str, "name");
        x(new j(this, i10, str, j10));
    }

    public final void C(List list) {
        t9.i.h(list, "entries");
        x(new k(list));
    }

    public final void D(Env env) {
        t9.i.h(env, bd.f13841a);
        x(new l(this, env));
    }

    public final void E(Env env) {
        this.f7646g = env;
    }

    public final void F(int i10, String str, String str2) {
        t9.i.h(str, "name");
        t9.i.h(str2, "media");
        x(new m(this, i10, str, str2));
    }

    public final void G(int i10, String str, int i11) {
        t9.i.h(str, "key");
        x(new n(this, i10, str, i11));
    }

    public final void H(int i10, String str, String str2, Context context, int i11) {
        t9.i.h(str, "key");
        t9.i.h(str2, "value");
        x(new o(this, i10, str, str2, context, i11));
    }

    public final void I(int i10, Surface surface, String str) {
        t9.i.h(str, "surfaceId");
        x(new p(this, i10, surface, str));
    }

    public final void J(int i10, String str) {
        t9.i.h(str, "name");
        x(new q(this, i10, str));
    }

    public final void K(int i10, String str) {
        t9.i.h(str, "name");
        x(new r(this, i10, str));
    }

    public final Env m() {
        return this.f7646g;
    }

    public final String n(int i10) {
        String c02;
        e eVar = this.f7641b[i10];
        if (eVar == null || (c02 = eVar.c0()) == null) {
            return "none";
        }
        return c02;
    }

    public final long o(int i10) {
        e eVar = this.f7641b[i10];
        if (eVar != null) {
            return eVar.V();
        }
        return -1;
    }

    public final d8.c p(int i10) {
        e eVar = this.f7641b[i10];
        if (eVar != null) {
            return eVar.f0();
        }
        return null;
    }

    public final String q() {
        return this.f7640a;
    }

    public final void r(String str, j8.a aVar, j8.b bVar) {
        t9.i.h(str, "workPath");
        t9.i.h(aVar, "playerCallback");
        t9.i.h(bVar, "rangerCallback");
        x(new c(this, str, aVar, bVar));
    }

    public final void s(int i10) {
        ThumbnailCallback thumbnailCallback;
        this.f7641b[i10] = new e(i10);
        j8.a aVar = this.f7644e;
        if (aVar != null && this.f7645f != null) {
            e eVar = this.f7641b[i10];
            if (eVar != null) {
                if (aVar == null) {
                    t9.i.q();
                }
                j8.b bVar = this.f7645f;
                if (bVar == null) {
                    t9.i.q();
                }
                eVar.E0(aVar, bVar);
            }
            if (i10 == 0) {
                PreviewUtil previewUtil = PreviewUtil.INSTANCE;
                e eVar2 = this.f7641b[i10];
                ThumbnailCallback thumbnailCallback2 = null;
                if (eVar2 != null) {
                    thumbnailCallback = eVar2.h0();
                } else {
                    thumbnailCallback = null;
                }
                previewUtil.setPreviewCallback(thumbnailCallback);
                ThumbnailRequest thumbnailRequest = ThumbnailRequest.INSTANCE;
                e eVar3 = this.f7641b[i10];
                if (eVar3 != null) {
                    thumbnailCallback2 = eVar3.h0();
                }
                thumbnailRequest.setThumbnailCallback(thumbnailCallback2);
            }
        }
    }

    public final boolean t(int i10) {
        e eVar = this.f7641b[i10];
        if (eVar != null) {
            return eVar.o0();
        }
        return false;
    }

    public final void u(i8.d dVar, i8.e eVar, int i10) {
        t9.i.h(dVar, "obj");
        t9.i.h(eVar, "type");
        x(new e(dVar, eVar, i10));
    }

    public final void v(i8.d dVar, i8.e eVar, i8.c cVar) {
        t9.i.h(dVar, "obj");
        t9.i.h(eVar, "type");
        t9.i.h(cVar, "event");
        x(new d(dVar, eVar, cVar));
    }

    public final void w(int i10, String str) {
        t9.i.h(str, "name");
        x(new f(this, i10, str));
    }

    public final void x(Runnable runnable) {
        Handler handler = this.f7649j;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public final void y(int i10, String str, Program program, String str2) {
        t9.i.h(str, "name");
        t9.i.h(program, "program");
        t9.i.h(str2, "extra");
        x(new g(this, i10, str, program, str2));
    }

    public final void z(int i10, String str, Program program, String str2) {
        t9.i.h(str, "name");
        t9.i.h(program, "program");
        t9.i.h(str2, "extra");
        x(new C0271h(this, i10, str, program, str2));
    }

    public /* synthetic */ h(t9.g gVar) {
        this();
    }
}
