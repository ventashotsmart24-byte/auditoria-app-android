package z5;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.CastStateListener;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.GoogleApiAvailability;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.i1;
import t9.i;
import t9.w;

public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final a f20263e = new a((t9.g) null);

    /* renamed from: a  reason: collision with root package name */
    public CastStateListener f20264a;

    /* renamed from: b  reason: collision with root package name */
    public SessionManagerListener f20265b;

    /* renamed from: c  reason: collision with root package name */
    public RemoteMediaClient.ProgressListener f20266c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteMediaClient.Callback f20267d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final boolean a(Context context) {
            boolean z10;
            i.g(context, com.umeng.analytics.pro.f.X);
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            try {
                CastContext.getSharedInstance(context);
                return z10;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public interface b {
        void P0();

        void g1();

        void l0();

        void r1();
    }

    /* renamed from: z5.c$c  reason: collision with other inner class name */
    public interface C0299c {
        void D0(CastSession castSession, String str);

        void K0(CastSession castSession, int i10);

        void V0(CastSession castSession);

        void Z(CastSession castSession, boolean z10);

        void b1(CastSession castSession, int i10);

        void w1(CastSession castSession, int i10);
    }

    public interface d {
        void L0();

        void L1(int i10);

        void U();

        void b0();

        void c2();

        void e0();
    }

    public interface e {
        void N1(long j10, long j11);
    }

    public static final class f implements SessionManagerListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ C0299c f20268a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f20269b;

        public f(C0299c cVar, Context context) {
            this.f20268a = cVar;
            this.f20269b = context;
        }

        /* renamed from: a */
        public void onSessionEnded(CastSession castSession, int i10) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionEnded ");
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            sb.append(", error: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
            C0299c cVar = this.f20268a;
            if (cVar != null) {
                cVar.w1(castSession, i10);
            }
        }

        /* renamed from: b */
        public void onSessionEnding(CastSession castSession) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionEnding ");
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            k7.f.c(sb.toString(), new Object[0]);
        }

        /* renamed from: c */
        public void onSessionResumeFailed(CastSession castSession, int i10) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionResumeFailed ");
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            sb.append(", error: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
            C0299c cVar = this.f20268a;
            if (cVar != null) {
                cVar.K0(castSession, i10);
            }
        }

        /* renamed from: d */
        public void onSessionResumed(CastSession castSession, boolean z10) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionResumed ");
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            sb.append(", wasSuspended: ");
            sb.append(z10);
            k7.f.c(sb.toString(), new Object[0]);
            C0299c cVar = this.f20268a;
            if (cVar != null) {
                cVar.Z(castSession, z10);
            }
        }

        /* renamed from: e */
        public void onSessionResuming(CastSession castSession, String str) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionResuming ");
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            sb.append(", sessionId: ");
            sb.append(str);
            k7.f.c(sb.toString(), new Object[0]);
        }

        /* renamed from: f */
        public void onSessionStartFailed(CastSession castSession, int i10) {
            CastDevice castDevice;
            CastDevice castDevice2;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionStartFailed ");
            String str = null;
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            sb.append(", error: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
            C0299c cVar = this.f20268a;
            if (cVar != null) {
                cVar.b1(castSession, i10);
            }
            App a10 = App.f6050e.a();
            String H = w6.i.f9510g.H();
            if (!(castSession == null || (castDevice2 = castSession.getCastDevice()) == null)) {
                str = castDevice2.getFriendlyName();
            }
            if (str == null) {
                str = "unknown";
            }
            i1.i(a10, H, "CHROME_CAST", str, false);
        }

        /* renamed from: g */
        public void onSessionStarted(CastSession castSession, String str) {
            CastDevice castDevice;
            CastDevice castDevice2;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionStarted ");
            String str2 = null;
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            sb.append(", sessionId: ");
            sb.append(str);
            k7.f.c(sb.toString(), new Object[0]);
            C0299c cVar = this.f20268a;
            if (cVar != null) {
                cVar.D0(castSession, str);
            }
            App a10 = App.f6050e.a();
            String H = w6.i.f9510g.H();
            if (!(castSession == null || (castDevice2 = castSession.getCastDevice()) == null)) {
                str2 = castDevice2.getFriendlyName();
            }
            if (str2 == null) {
                str2 = "unknown";
            }
            i1.i(a10, H, "CHROME_CAST", str2, true);
        }

        /* renamed from: h */
        public void onSessionStarting(CastSession castSession) {
            CastDevice castDevice;
            CastDevice castDevice2;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionStarting ");
            String str = null;
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            k7.f.c(sb.toString(), new Object[0]);
            C0299c cVar = this.f20268a;
            if (cVar != null) {
                cVar.V0(castSession);
            }
            na.f.k(this.f20269b, "last_cast_mode", "CHROME_CAST");
            App a10 = App.f6050e.a();
            String H = w6.i.f9510g.H();
            if (!(castSession == null || (castDevice2 = castSession.getCastDevice()) == null)) {
                str = castDevice2.getFriendlyName();
            }
            if (str == null) {
                str = "unknown";
            }
            i1.f(a10, H, "CHROME_CAST", str);
        }

        /* renamed from: i */
        public void onSessionSuspended(CastSession castSession, int i10) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionSuspended ");
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            sb.append(castDevice);
            sb.append(", reason: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
        }
    }

    public static final class g extends RemoteMediaClient.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f20270a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f20271b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f20272c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f20273d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20274e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20275f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20276g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f20277h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f20278i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f20279j;

        public g(w wVar, d dVar, c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f20270a = wVar;
            this.f20271b = dVar;
            this.f20272c = cVar;
            this.f20273d = str;
            this.f20274e = str2;
            this.f20275f = str3;
            this.f20276g = str4;
            this.f20277h = str5;
            this.f20278i = str6;
            this.f20279j = str7;
        }

        public void onStatusUpdated() {
            String str;
            CastDevice castDevice;
            d dVar;
            int playerState = ((RemoteMediaClient) this.f20270a.f19600a).getPlayerState();
            if (playerState == 0) {
                d dVar2 = this.f20271b;
                if (dVar2 != null) {
                    dVar2.b0();
                }
            } else if (playerState == 1) {
                d dVar3 = this.f20271b;
                if (dVar3 != null) {
                    dVar3.L1(((RemoteMediaClient) this.f20270a.f19600a).getIdleReason());
                }
                if (((RemoteMediaClient) this.f20270a.f19600a).getIdleReason() == 4) {
                    App a10 = App.f6050e.a();
                    String H = w6.i.f9510g.H();
                    CastSession i10 = this.f20272c.i();
                    if (i10 == null || (castDevice = i10.getCastDevice()) == null) {
                        str = null;
                    } else {
                        str = castDevice.getFriendlyName();
                    }
                    if (str == null) {
                        str = "unknown";
                    }
                    i1.h(a10, H, "CHROME_CAST", str, this.f20273d, "4", this.f20274e, this.f20275f, this.f20276g, this.f20277h, this.f20278i, this.f20279j);
                }
            } else if (playerState == 2) {
                d dVar4 = this.f20271b;
                if (dVar4 != null) {
                    dVar4.c2();
                }
            } else if (playerState == 3) {
                d dVar5 = this.f20271b;
                if (dVar5 != null) {
                    dVar5.U();
                }
            } else if (playerState == 4) {
                d dVar6 = this.f20271b;
                if (dVar6 != null) {
                    dVar6.e0();
                }
            } else if (playerState == 5 && (dVar = this.f20271b) != null) {
                dVar.L0();
            }
        }
    }

    public static final void d(b bVar, int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4 && bVar != null) {
                        bVar.g1();
                    }
                } else if (bVar != null) {
                    bVar.P0();
                }
            } else if (bVar != null) {
                bVar.l0();
            }
        } else if (bVar != null) {
            bVar.r1();
        }
    }

    public static final void f(e eVar, long j10, long j11) {
        if (eVar != null) {
            eVar.N1(j10, j11);
        }
    }

    public static /* synthetic */ void m(c cVar, d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        String str8;
        String str9;
        int i11 = i10;
        if ((i11 & 64) != 0) {
            str8 = "";
        } else {
            str8 = str6;
        }
        if ((i11 & 128) != 0) {
            str9 = "";
        } else {
            str9 = str7;
        }
        cVar.l(dVar, str, str2, str3, str4, str5, str8, str9);
    }

    public final void c(Context context, b bVar) {
        i.g(context, com.umeng.analytics.pro.f.X);
        if (this.f20264a == null) {
            this.f20264a = new b(bVar);
        }
        CastContext.getSharedInstance(context).addCastStateListener(this.f20264a);
    }

    public final void e(e eVar) {
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            a aVar = new a(eVar);
            this.f20266c = aVar;
            h10.addProgressListener(aVar, 2000);
        }
    }

    public final void g(Context context, C0299c cVar) {
        i.g(context, com.umeng.analytics.pro.f.X);
        if (this.f20265b == null) {
            this.f20265b = new f(cVar, context);
        }
        CastContext.getSharedInstance(context).getSessionManager().addSessionManagerListener(this.f20265b, CastSession.class);
    }

    public final RemoteMediaClient h() {
        SessionManager sessionManager;
        CastSession currentCastSession;
        CastContext sharedInstance = CastContext.getSharedInstance();
        if (sharedInstance == null || (sessionManager = sharedInstance.getSessionManager()) == null || (currentCastSession = sessionManager.getCurrentCastSession()) == null) {
            return null;
        }
        return currentCastSession.getRemoteMediaClient();
    }

    public final CastSession i() {
        SessionManager sessionManager;
        CastContext sharedInstance = CastContext.getSharedInstance();
        if (sharedInstance == null || (sessionManager = sharedInstance.getSessionManager()) == null) {
            return null;
        }
        return sessionManager.getCurrentCastSession();
    }

    public final void j(String str, int i10, long j10, MediaMetadata mediaMetadata) {
        i.g(str, "url");
        i.g(mediaMetadata, "mediaMetadata");
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            h10.load(new MediaLoadRequestData.Builder().setMediaInfo(new MediaInfo.Builder(str).setStreamType(1).setContentType("videos/mp4").setMetadata(mediaMetadata).setStreamDuration(j10).build()).setAutoplay(Boolean.TRUE).setCurrentTime(((long) i10) * 1000).build());
        }
    }

    public final void k() {
        RemoteMediaClient h10 = h();
        if (h10 == null) {
            return;
        }
        if (h10.isPaused()) {
            h10.play();
        } else if (h10.isPlaying() || h10.isBuffering()) {
            h10.pause();
        }
    }

    public final void l(d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        String str9;
        CastDevice castDevice;
        i.g(str, "resourceId");
        i.g(str2, "title");
        i.g(str3, "mCode");
        i.g(str4, "bussType");
        i.g(str5, "cdnType");
        if (TextUtils.isDigitsOnly(str5)) {
            u6.a aVar = u6.a.f19631a;
            if (str6 == null) {
                str8 = "";
            } else {
                str8 = str6;
            }
            CastSession i10 = i();
            if (i10 == null || (castDevice = i10.getCastDevice()) == null) {
                str9 = null;
            } else {
                str9 = castDevice.getFriendlyName();
            }
            if (str9 == null) {
                str9 = "unknown";
            }
            aVar.b(str3, str8, str4, str5, str2, "CHROME_CAST", str9, "app_cast_start");
        }
        w wVar = new w();
        RemoteMediaClient h10 = h();
        wVar.f19600a = h10;
        if (h10 != null) {
            g gVar = new g(wVar, dVar, this, str, str2, str3, str4, str5, str6, str7);
            this.f20267d = gVar;
            RemoteMediaClient remoteMediaClient = (RemoteMediaClient) wVar.f19600a;
            if (remoteMediaClient != null) {
                remoteMediaClient.registerCallback(gVar);
                return;
            }
            return;
        }
    }

    public final void n(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        CastContext.getSharedInstance(context).removeCastStateListener(this.f20264a);
    }

    public final void o() {
        RemoteMediaClient.ProgressListener progressListener;
        RemoteMediaClient h10 = h();
        if (h10 != null && (progressListener = this.f20266c) != null) {
            h10.removeProgressListener(progressListener);
        }
    }

    public final void p(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        CastContext.getSharedInstance(context).getSessionManager().removeSessionManagerListener(this.f20265b, CastSession.class);
    }

    public final void q(long j10) {
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            h10.seek(j10);
        }
    }

    public final void r() {
        SessionManager sessionManager;
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            h10.stop();
        }
        CastContext sharedInstance = CastContext.getSharedInstance();
        if (sharedInstance != null && (sessionManager = sharedInstance.getSessionManager()) != null) {
            sessionManager.endCurrentSession(true);
        }
    }

    public final void s() {
        RemoteMediaClient.Callback callback;
        RemoteMediaClient h10 = h();
        if (h10 != null && (callback = this.f20267d) != null) {
            h10.unregisterCallback(callback);
            this.f20267d = null;
        }
    }
}
