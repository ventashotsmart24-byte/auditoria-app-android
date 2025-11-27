package com.titan.ranger;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.gson.Gson;
import com.hpplay.component.common.dlna.IDLNAController;
import com.titan.ranger.bean.RangerResult;
import java.util.HashMap;

public class NativeJni {

    /* renamed from: d  reason: collision with root package name */
    public static String f13324d = "";

    /* renamed from: e  reason: collision with root package name */
    public static NativeJni f13325e;

    /* renamed from: a  reason: collision with root package name */
    public final String f13326a = NativeJni.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Handler f13327b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f13328c;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13329a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f13331c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f13332d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13333e;

        public a(int i10, String str, long j10, long j11, c cVar) {
            this.f13329a = i10;
            this.f13330b = str;
            this.f13331c = j10;
            this.f13332d = j11;
            this.f13333e = cVar;
        }

        public void run() {
            String unused = NativeJni.this.a(IDLNAController.SEEK, a.l(this.f13329a, this.f13330b, this.f13331c, this.f13332d));
            c cVar = this.f13333e;
            if (cVar != null) {
                cVar.a("");
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13335a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13336b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13337c;

        public b(int i10, String str, String str2) {
            this.f13335a = i10;
            this.f13336b = str;
            this.f13337c = str2;
        }

        public void run() {
            String unused = NativeJni.this.a("SetMedia", a.m(this.f13335a, this.f13336b, this.f13337c));
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13339a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13340b;

        public c(int i10, String str) {
            this.f13339a = i10;
            this.f13340b = str;
        }

        public void run() {
            String unused = NativeJni.this.a(IDLNAController.PAUSE, a.j(this.f13339a, this.f13340b));
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13342a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13343b;

        public d(int i10, String str) {
            this.f13342a = i10;
            this.f13343b = str;
        }

        public void run() {
            String unused = NativeJni.this.a(IDLNAController.RESUME, a.j(this.f13342a, this.f13343b));
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13345a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13346b;

        public e(int i10, String str) {
            this.f13345a = i10;
            this.f13346b = str;
        }

        public void run() {
            String unused = NativeJni.this.a("StopProgram", a.j(this.f13345a, this.f13346b));
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13348a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f13349b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f13350c;

        public f(int i10, long j10, long j11) {
            this.f13348a = i10;
            this.f13349b = j10;
            this.f13350c = j11;
        }

        public void run() {
            String unused = NativeJni.this.a("OnPlayBuffer", a.e(this.f13348a, this.f13349b, this.f13350c));
        }
    }

    public static class g implements c {
        public void a(String str) {
            NativeJni.f13324d = str;
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13352a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13353b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13354c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f13355d;

        public h(int i10, String str, String str2, int i11) {
            this.f13352a = i10;
            this.f13353b = str;
            this.f13354c = str2;
            this.f13355d = i11;
        }

        public void run() {
            String unused = NativeJni.this.a("OnPlayerOperation", a.g(this.f13352a, this.f13353b, this.f13354c, this.f13355d));
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13357a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13358b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f13359c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f13360d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f13361e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f13362f;

        public i(int i10, String str, int i11, int i12, long j10, String str2) {
            this.f13357a = i10;
            this.f13358b = str;
            this.f13359c = i11;
            this.f13360d = i12;
            this.f13361e = j10;
            this.f13362f = str2;
        }

        public void run() {
            String unused = NativeJni.this.a("OnPlayerEvent", a.f(this.f13357a, this.f13358b, this.f13359c, this.f13360d, this.f13361e, this.f13362f));
        }
    }

    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13365b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13366c;

        public j(int i10, String str, String str2) {
            this.f13364a = i10;
            this.f13365b = str;
            this.f13366c = str2;
        }

        public void run() {
            String unused = NativeJni.this.a("OnMediaInfo", a.c(this.f13364a, this.f13365b, this.f13366c));
        }
    }

    public class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13368a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13370c;

        public k(int i10, String str, String str2) {
            this.f13368a = i10;
            this.f13369b = str;
            this.f13370c = str2;
        }

        public void run() {
            String unused = NativeJni.this.a("OnPlayEvent", a.d(this.f13368a, this.f13369b, this.f13370c));
        }
    }

    public class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13372a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13373b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13374c;

        public l(String str, String str2, String str3) {
            this.f13372a = str;
            this.f13373b = str2;
            this.f13374c = str3;
        }

        public void run() {
            String unused = NativeJni.this.a("OnSystemEvent", a.h(this.f13372a, this.f13373b, this.f13374c));
        }
    }

    public class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13376a;

        public m(String str) {
            this.f13376a = str;
        }

        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("work_path", this.f13376a);
            String unused = NativeJni.this.a("Init", m8.a.a().toJson((Object) hashMap));
        }
    }

    public class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13378a;

        public n(c cVar) {
            this.f13378a = cVar;
        }

        public void run() {
            String res = ((RangerResult) m8.a.a().fromJson(NativeJni.this.a("GetVersion", "{}"), RangerResult.class)).getRes();
            c cVar = this.f13378a;
            if (cVar != null) {
                cVar.a(res);
            }
        }
    }

    public class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13380a;

        public o(String str) {
            this.f13380a = str;
        }

        public void run() {
            String unused = NativeJni.this.a("SetEnv", a.b(this.f13380a));
        }
    }

    public class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13382a;

        public p(String str) {
            this.f13382a = str;
        }

        public void run() {
            String unused = NativeJni.this.a("SetEntries", a.a(this.f13382a));
        }
    }

    public class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13384a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13385b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f13386c;

        public q(int i10, String str, int i11) {
            this.f13384a = i10;
            this.f13385b = str;
            this.f13386c = i11;
        }

        public void run() {
            String unused = NativeJni.this.a("SetPlayer", a.i(this.f13384a, this.f13385b, this.f13386c));
        }
    }

    public class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13388a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13389b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13390c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f13391d;

        public r(int i10, String str, String str2, String str3) {
            this.f13388a = i10;
            this.f13389b = str;
            this.f13390c = str2;
            this.f13391d = str3;
        }

        public void run() {
            String unused = NativeJni.this.a("PrepareProgram", a.k(this.f13388a, this.f13389b, this.f13390c, this.f13391d));
        }
    }

    public class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13393a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13394b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13395c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f13396d;

        public s(int i10, String str, String str2, String str3) {
            this.f13393a = i10;
            this.f13394b = str;
            this.f13395c = str2;
            this.f13396d = str3;
        }

        public void run() {
            String unused = NativeJni.this.a("PrepareCast", a.k(this.f13393a, this.f13394b, this.f13395c, this.f13396d));
        }
    }

    public class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f13398a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13399b;

        public t(int i10, String str) {
            this.f13398a = i10;
            this.f13399b = str;
        }

        public void run() {
            String unused = NativeJni.this.a("StopCast", a.j(this.f13398a, this.f13399b));
        }
    }

    static {
        System.loadLibrary("ranger-jni");
        System.loadLibrary("c++_shared");
    }

    public NativeJni() {
        HandlerThread handlerThread = new HandlerThread("handlerRanger");
        this.f13328c = handlerThread;
        handlerThread.start();
        this.f13327b = new Handler(this.f13328c.getLooper());
    }

    private native String Call(String str, String str2);

    public static NativeJni c() {
        if (f13325e == null) {
            synchronized (NativeJni.class) {
                if (f13325e == null) {
                    NativeJni nativeJni = new NativeJni();
                    f13325e = nativeJni;
                    nativeJni.d(new g());
                }
            }
        }
        return f13325e;
    }

    public final String a(String str, String str2) {
        return Call(str, str2);
    }

    public void d(c cVar) {
        this.f13327b.post(new n(cVar));
    }

    public void e(int i10, String str, b bVar) {
        String a10 = a("GetStatus", a.j(i10, str));
        Gson a11 = m8.a.a();
        Status status = (Status) a11.fromJson(((RangerResult) a11.fromJson(a10, RangerResult.class)).getRes(), Status.class);
        if (bVar != null) {
            bVar.a(status);
        }
    }

    public void f(String str) {
        Handler handler = this.f13327b;
        if (handler == null) {
            Log.e(this.f13326a, "threadHandler is not initialized");
        } else {
            handler.post(new m(str));
        }
    }

    public void g(int i10, String str, int i11) {
        this.f13327b.post(new q(i10, str, i11));
    }

    public void h(int i10, String str, String str2) {
        this.f13327b.post(new j(i10, str, str2));
    }

    public void i(int i10, String str, String str2) {
        this.f13327b.post(new k(i10, str, str2));
    }

    public void j(int i10, long j10, long j11) {
        this.f13327b.post(new f(i10, j10, j11));
    }

    public void k(int i10, String str, int i11, int i12, long j10, String str2) {
        this.f13327b.post(new i(i10, str, i11, i12, j10, str2));
    }

    public void l(int i10, String str, String str2, int i11) {
        this.f13327b.post(new h(i10, str, str2, i11));
    }

    public void m(String str, String str2, String str3) {
        this.f13327b.post(new l(str, str2, str3));
    }

    public void n(int i10, String str) {
        this.f13327b.post(new c(i10, str));
    }

    public void o(int i10, String str, String str2, String str3) {
        this.f13327b.post(new s(i10, str, str2, str3));
    }

    public void p(int i10, String str, String str2, String str3) {
        this.f13327b.post(new r(i10, str, str2, str3));
    }

    public void q(int i10, String str) {
        this.f13327b.post(new d(i10, str));
    }

    public void r(int i10, String str, long j10, long j11, c cVar) {
        this.f13327b.post(new a(i10, str, j10, j11, cVar));
    }

    public void s(String str) {
        this.f13327b.post(new p(str));
    }

    public void t(int i10, String str, String str2) {
        this.f13327b.post(new b(i10, str, str2));
    }

    public void u(String str) {
        this.f13327b.post(new o(str));
    }

    public void v(int i10, String str) {
        this.f13327b.post(new t(i10, str));
    }

    public void w(int i10, String str) {
        this.f13327b.post(new e(i10, str));
    }
}
