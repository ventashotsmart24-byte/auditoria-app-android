package l8;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.SparseArray;
import android.view.Surface;
import ba.s;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.data.Message;
import com.titan.ranger.JniHandler;
import com.titan.ranger.NativeJni;
import com.titan.ranger.Status;
import com.titan.ranger.bean.Env;
import com.titan.ranger.bean.Program;
import com.titan.ranger.bean.report.PlayError;
import com.titan.ranger.bean.report.PlayFile;
import com.titan.ranger.bean.report.PlayMedia;
import com.titan.ranger.bean.report.PlayProgram;
import com.titan.ranger.bean.report.SwitchPlayer;
import com.titan.thumbnail.ThumbnailCallback;
import com.titan.thumbnail.ThumbnailUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m8.c;
import t9.v;
import t9.x;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.ExoMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;
import tv.danmaku.ijk.media.player.widget.media.FileMediaDataSource;
import tv.danmaku.ijk.media.player.widget.media.MediaPlayerCompat;

public final class e {
    public static final /* synthetic */ z9.g[] K = {x.e(new t9.r(x.a(e.class), "mPlayerContext", "getMPlayerContext()Lcom/titan/media/PlayerContext;"))};
    public final h9.g A;
    public final ReadWriteLock B;
    public final Lock C;
    public final Lock D;
    public HashMap E;
    public long F;
    public String G;
    public d H;
    public final ThumbnailCallback I;
    public final C0270e J;

    /* renamed from: a  reason: collision with root package name */
    public final String f18699a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f18700b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18701c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18702d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18703e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18704f;

    /* renamed from: g  reason: collision with root package name */
    public long f18705g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18706h;

    /* renamed from: i  reason: collision with root package name */
    public int f18707i;

    /* renamed from: j  reason: collision with root package name */
    public int f18708j;

    /* renamed from: k  reason: collision with root package name */
    public String f18709k = "";

    /* renamed from: l  reason: collision with root package name */
    public j8.a f18710l;

    /* renamed from: m  reason: collision with root package name */
    public j8.b f18711m;

    /* renamed from: n  reason: collision with root package name */
    public IMediaPlayer f18712n;

    /* renamed from: o  reason: collision with root package name */
    public int f18713o;

    /* renamed from: p  reason: collision with root package name */
    public Context f18714p;

    /* renamed from: q  reason: collision with root package name */
    public m8.c f18715q;

    /* renamed from: r  reason: collision with root package name */
    public g f18716r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f18717s;

    /* renamed from: t  reason: collision with root package name */
    public i8.b f18718t;

    /* renamed from: u  reason: collision with root package name */
    public i8.b f18719u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f18720v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f18721w;

    /* renamed from: x  reason: collision with root package name */
    public int f18722x;

    /* renamed from: y  reason: collision with root package name */
    public d8.c f18723y;

    /* renamed from: z  reason: collision with root package name */
    public f f18724z;

    public static final class a implements IjkMediaPlayer.OnSelectTrackListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18725a;

        public a(e eVar) {
            this.f18725a = eVar;
        }

        /* JADX INFO: finally extract failed */
        public final void onSelectTrack(ArrayList arrayList) {
            String str;
            String d10;
            ArrayList f10;
            ArrayList f11;
            ArrayList f12;
            ArrayList f13;
            String str2 = "";
            this.f18725a.D.lock();
            try {
                f m10 = this.f18725a.f18724z;
                if (m10 != null) {
                    str = m10.d();
                } else {
                    str = null;
                }
                if ((!t9.i.b(str, str2)) && this.f18725a.a0() != null) {
                    d8.c k10 = this.f18725a.f18723y;
                    if (k10 != null) {
                        k10.t(new ArrayList());
                    }
                    int size = arrayList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        SparseArray sparseArray = (SparseArray) arrayList.get(i10);
                        int keyAt = sparseArray.keyAt(0);
                        String str3 = (String) sparseArray.valueAt(0);
                        if (keyAt == i8.a.AVMEDIA_TYPE_VIDEO.a()) {
                            d8.b bVar = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            bVar.h(i10);
                            t9.i.c(str3, "stLang");
                            bVar.i(str3);
                            bVar.m("video");
                            d8.c k11 = this.f18725a.f18723y;
                            if (!(k11 == null || (f13 = k11.f()) == null)) {
                                f13.add(bVar);
                            }
                        } else if (keyAt == i8.a.AVMEDIA_TYPE_AUDIO.a()) {
                            d8.b bVar2 = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            bVar2.h(i10);
                            t9.i.c(str3, "stLang");
                            bVar2.i(str3);
                            bVar2.m("audio");
                            d8.c k12 = this.f18725a.f18723y;
                            if (!(k12 == null || (f12 = k12.f()) == null)) {
                                f12.add(bVar2);
                            }
                        } else if (keyAt == i8.a.AVMEDIA_TYPE_SUBTITLE.a()) {
                            d8.b bVar3 = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            bVar3.h(i10);
                            t9.i.c(str3, "stLang");
                            bVar3.i(str3);
                            bVar3.m(MediaTrack.ROLE_SUBTITLE);
                            d8.c k13 = this.f18725a.f18723y;
                            if (!(k13 == null || (f11 = k13.f()) == null)) {
                                f11.add(bVar3);
                            }
                        } else {
                            d8.b bVar4 = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            bVar4.h(i10);
                            t9.i.c(str3, "stLang");
                            bVar4.i(str3);
                            bVar4.m("unknown");
                            d8.c k14 = this.f18725a.f18723y;
                            if (!(k14 == null || (f10 = k14.f()) == null)) {
                                f10.add(bVar4);
                            }
                        }
                    }
                    this.f18725a.f18720v = true;
                    d8.c k15 = this.f18725a.f18723y;
                    if (k15 != null) {
                        j8.a a02 = this.f18725a.a0();
                        if (a02 == null) {
                            t9.i.q();
                        }
                        f m11 = this.f18725a.f18724z;
                        if (!(m11 == null || (d10 = m11.d()) == null)) {
                            str2 = d10;
                        }
                        d8.d f14 = a02.f(k15, str2);
                        if (f14 != null) {
                            this.f18725a.D0(f14.a());
                        }
                    }
                }
                this.f18725a.D.unlock();
                this.f18725a.f18721w = true;
            } catch (Throwable th) {
                this.f18725a.D.unlock();
                throw th;
            }
        }
    }

    public static final class b implements com.titan.ranger.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.titan.ranger.b f18726a;

        public b(com.titan.ranger.b bVar) {
            this.f18726a = bVar;
        }

        public void a(Status status) {
            com.titan.ranger.b bVar;
            if (status != null && (bVar = this.f18726a) != null) {
                bVar.a(status);
            }
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18727a;

        public c(e eVar) {
            this.f18727a = eVar;
        }

        public final void run() {
            this.f18727a.r0();
        }
    }

    public static final class d implements JniHandler.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18728a;

        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f18729a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f18730b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ long f18731c;

            public a(d dVar, Object obj, long j10) {
                this.f18729a = dVar;
                this.f18730b = obj;
                this.f18731c = j10;
            }

            public final void run() {
                f m10;
                f m11;
                f m12;
                f m13 = this.f18729a.f18728a.f18724z;
                if (m13 == null || !m13.r()) {
                    f m14 = this.f18729a.f18728a.f18724z;
                    if (m14 == null || !m14.s()) {
                        this.f18729a.f18728a.w0((Status) this.f18730b);
                        if (this.f18731c == 1000 && (m10 = this.f18729a.f18728a.f18724z) != null) {
                            m10.F(true);
                        }
                        e.R0(this.f18729a.f18728a, "", false, 2, (Object) null);
                        return;
                    }
                    this.f18729a.f18728a.w0((Status) this.f18730b);
                    if (this.f18731c == 1000 && (m11 = this.f18729a.f18728a.f18724z) != null) {
                        m11.F(true);
                    }
                    this.f18729a.f18728a.l0();
                    return;
                }
                f m15 = this.f18729a.f18728a.f18724z;
                if (m15 != null) {
                    m15.E((Status) this.f18730b);
                }
                if (this.f18731c == 1000 && (m12 = this.f18729a.f18728a.f18724z) != null) {
                    m12.F(true);
                }
            }
        }

        public d(e eVar) {
            this.f18728a = eVar;
        }

        public int getInstance() {
            return this.f18728a.f18713o;
        }

        public int m(String str, String str2, long j10) {
            t9.i.h(str, "name");
            t9.i.h(str2, "path");
            j8.b b02 = this.f18728a.b0();
            if (b02 != null) {
                b02.m(str, str2, j10);
            }
            if (!m8.d.b(str2)) {
                return 0;
            }
            this.f18728a.E.put(str, str2);
            return 0;
        }

        public int n(int i10, String str, String str2, String str3) {
            t9.i.h(str, "event");
            t9.i.h(str2, "data");
            t9.i.h(str3, "app_ctx");
            try {
                switch (str.hashCode()) {
                    case -1877933145:
                        if (!str.equals("play_file")) {
                            return 22;
                        }
                        PlayFile playFile = (PlayFile) m8.a.a().fromJson(str2, PlayFile.class);
                        t9.i.c(playFile, "playFile");
                        playFile.setTitan_ver(h.f7639m.c() + "-[" + NativeJni.f13324d + ']');
                        j8.b b02 = this.f18728a.b0();
                        if (b02 == null) {
                            return 0;
                        }
                        b02.j(i10, str, playFile, str3);
                        return 0;
                    case 1283382393:
                        if (!str.equals("play_program")) {
                            return 22;
                        }
                        PlayProgram playProgram = (PlayProgram) m8.a.a().fromJson(str2, PlayProgram.class);
                        t9.i.c(playProgram, "playProgram");
                        playProgram.setTitan_ver(h.f7639m.c() + "-[" + NativeJni.f13324d + ']');
                        j8.b b03 = this.f18728a.b0();
                        if (b03 == null) {
                            return 0;
                        }
                        b03.j(i10, str, playProgram, str3);
                        return 0;
                    case 1814306380:
                        if (!str.equals("switch_player")) {
                            return 22;
                        }
                        SwitchPlayer switchPlayer = (SwitchPlayer) m8.a.a().fromJson(str2, SwitchPlayer.class);
                        t9.i.c(switchPlayer, "swPlayer");
                        switchPlayer.setTitan_ver(h.f7639m.c() + "-[" + NativeJni.f13324d + ']');
                        j8.b b04 = this.f18728a.b0();
                        if (b04 == null) {
                            return 0;
                        }
                        b04.j(i10, str, switchPlayer, str3);
                        return 0;
                    case 1912965437:
                        if (!str.equals("play_error")) {
                            return 22;
                        }
                        PlayError playError = (PlayError) m8.a.a().fromJson(str2, PlayError.class);
                        t9.i.c(playError, "playError");
                        playError.setTitan_ver(h.f7639m.c() + "-[" + NativeJni.f13324d + ']');
                        j8.b b05 = this.f18728a.b0();
                        if (b05 == null) {
                            return 0;
                        }
                        b05.j(i10, str, playError, str3);
                        return 0;
                    case 1919952665:
                        if (!str.equals("play_media")) {
                            return 22;
                        }
                        PlayMedia playMedia = (PlayMedia) m8.a.a().fromJson(str2, PlayMedia.class);
                        t9.i.c(playMedia, "playMedia");
                        playMedia.setTitan_ver(h.f7639m.c() + "-[" + NativeJni.f13324d + ']');
                        j8.b b06 = this.f18728a.b0();
                        if (b06 == null) {
                            return 0;
                        }
                        b06.j(i10, str, playMedia, str3);
                        return 0;
                    default:
                        return 22;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return 0;
            }
            e10.printStackTrace();
            return 0;
        }

        public int o(String str, String str2, int i10) {
            String str3;
            t9.i.h(str, "obj");
            t9.i.h(str2, "action");
            j8.a a02 = this.f18728a.a0();
            if (a02 == null) {
                return 0;
            }
            int i11 = this.f18728a.f18713o;
            f m10 = this.f18728a.f18724z;
            if (m10 == null || (str3 = m10.d()) == null) {
                str3 = "";
            }
            a02.c(i11, str, str2, i10, str3);
            return 0;
        }

        public int p(int i10, String str, Object obj, long j10) {
            if (m8.d.a(str) || obj == null || !(obj instanceof Status)) {
                return 22;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1589184968) {
                    if (hashCode == 1948221757 && str.equals("cast_prepared")) {
                        Status status = (Status) obj;
                        this.f18728a.w0(status);
                        j8.b b02 = this.f18728a.b0();
                        if (b02 == null) {
                            return 0;
                        }
                        b02.i(i10, "cast_prepared", status, j10);
                        return 0;
                    }
                } else if (str.equals("media_prepared")) {
                    this.f18728a.J.post(new a(this, obj, j10));
                    return 0;
                }
            }
            j8.b b03 = this.f18728a.b0();
            if (b03 == null) {
                return 0;
            }
            if (str == null) {
                t9.i.q();
            }
            b03.i(i10, str, (Status) obj, j10);
            return 0;
        }
    }

    /* renamed from: l8.e$e  reason: collision with other inner class name */
    public static final class C0270e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18732a;

        public C0270e(e eVar) {
            this.f18732a = eVar;
        }

        public void handleMessage(android.os.Message message) {
            String str;
            j8.a a02;
            String str2;
            String d10;
            t9.i.h(message, Constant.KEY_MSG);
            int i10 = message.what;
            if (i10 == 61699) {
                f m10 = this.f18732a.f18724z;
                if (m10 != null) {
                    str = m10.d();
                } else {
                    str = null;
                }
                if ((!t9.i.b(str, "")) && (a02 = this.f18732a.a0()) != null) {
                    int i11 = this.f18732a.f18713o;
                    f m11 = this.f18732a.f18724z;
                    if (m11 == null || (d10 = m11.d()) == null) {
                        str2 = "";
                    } else {
                        str2 = d10;
                    }
                    a02.c(i11, "buffering", "none", 0, str2);
                }
                f m12 = this.f18732a.f18724z;
                if (m12 != null) {
                    m12.v(false);
                }
            } else if (i10 == 61703) {
                this.f18732a.U0();
                this.f18732a.F0(0);
                this.f18732a.O0(0);
                this.f18732a.l0();
                NativeJni.c().k(this.f18732a.f18713o, "onReplay", 0, 0, 0, "");
            }
        }
    }

    public static final class f extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f18733a = new f();

        public f() {
            super(0);
        }

        /* renamed from: b */
        public final b invoke() {
            return new b();
        }
    }

    public static final class g implements com.titan.ranger.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18734a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f18735b;

        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f18736a;

            public a(g gVar) {
                this.f18736a = gVar;
            }

            public final void run() {
                g gVar = this.f18736a;
                gVar.f18734a.B0(gVar.f18735b);
            }
        }

        public g(e eVar, long j10) {
            this.f18734a = eVar;
            this.f18735b = j10;
        }

        public final void a(String str) {
            this.f18734a.J.post(new a(this));
        }
    }

    public static final class h implements IMediaPlayer.OnPreparedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18737a;

        public h(e eVar) {
            this.f18737a = eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:173:0x02e4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer r14) {
            /*
                r13 = this;
                l8.e r14 = r13.f18737a
                l8.g r14 = r14.f18716r
                if (r14 != 0) goto L_0x0009
                return
            L_0x0009:
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                boolean r0 = r14 instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer
                r1 = 0
                if (r0 != 0) goto L_0x0015
                r14 = r1
            L_0x0015:
                tv.danmaku.ijk.media.player.IjkMediaPlayer r14 = (tv.danmaku.ijk.media.player.IjkMediaPlayer) r14
                java.lang.String r0 = ""
                r2 = 1
                if (r14 == 0) goto L_0x0080
                int r14 = r14.getVideoDecoder()
                if (r14 != r2) goto L_0x0080
                com.titan.ranger.NativeJni r3 = com.titan.ranger.NativeJni.c()
                l8.e r14 = r13.f18737a
                int r4 = r14.f18713o
                java.lang.String r5 = "onError"
                r6 = 0
                r7 = 1101(0x44d, float:1.543E-42)
                r8 = 0
                java.lang.String r10 = ""
                r3.k(r4, r5, r6, r7, r8, r10)
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x0045
                java.lang.String r14 = r14.d()
                goto L_0x0046
            L_0x0045:
                r14 = r1
            L_0x0046:
                boolean r14 = t9.i.b(r14, r0)
                r14 = r14 ^ r2
                if (r14 == 0) goto L_0x0080
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x0080
                boolean r14 = r14.m()
                if (r14 != 0) goto L_0x0080
                l8.e r14 = r13.f18737a
                j8.a r14 = r14.a0()
                if (r14 == 0) goto L_0x0080
                l8.e r3 = r13.f18737a
                int r3 = r3.f18713o
                l8.e r4 = r13.f18737a
                l8.f r4 = r4.f18724z
                if (r4 == 0) goto L_0x0078
                java.lang.String r4 = r4.d()
                if (r4 == 0) goto L_0x0078
                goto L_0x0079
            L_0x0078:
                r4 = r0
            L_0x0079:
                r5 = 1101(0x44d, float:1.543E-42)
                java.lang.String r6 = "ijk"
                r14.l(r3, r5, r6, r4)
            L_0x0080:
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                r3 = 0
                if (r14 == 0) goto L_0x008e
                int r14 = r14.getVideoWidth()
                goto L_0x008f
            L_0x008e:
                r14 = 0
            L_0x008f:
                if (r14 != 0) goto L_0x00f9
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                if (r14 == 0) goto L_0x009e
                int r14 = r14.getVideoHeight()
                goto L_0x009f
            L_0x009e:
                r14 = 0
            L_0x009f:
                if (r14 != 0) goto L_0x00f9
                com.titan.ranger.NativeJni r4 = com.titan.ranger.NativeJni.c()
                l8.e r14 = r13.f18737a
                int r5 = r14.f18713o
                java.lang.String r6 = "onError"
                r7 = 0
                r8 = 1102(0x44e, float:1.544E-42)
                r9 = 0
                java.lang.String r11 = ""
                r4.k(r5, r6, r7, r8, r9, r11)
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x00c4
                java.lang.String r14 = r14.d()
                goto L_0x00c5
            L_0x00c4:
                r14 = r1
            L_0x00c5:
                boolean r14 = t9.i.b(r14, r0)
                r14 = r14 ^ r2
                if (r14 == 0) goto L_0x00f9
                l8.e r14 = r13.f18737a
                j8.a r14 = r14.a0()
                if (r14 == 0) goto L_0x00f9
                l8.e r4 = r13.f18737a
                int r4 = r4.f18713o
                l8.e r5 = r13.f18737a
                i8.b r5 = r5.f18718t
                java.lang.String r5 = r5.a()
                l8.e r6 = r13.f18737a
                l8.f r6 = r6.f18724z
                if (r6 == 0) goto L_0x00f3
                java.lang.String r6 = r6.d()
                if (r6 == 0) goto L_0x00f3
                goto L_0x00f4
            L_0x00f3:
                r6 = r0
            L_0x00f4:
                r7 = 1102(0x44e, float:1.544E-42)
                r14.l(r4, r7, r5, r6)
            L_0x00f9:
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x010c
                com.titan.ranger.bean.Program r14 = r14.g()
                if (r14 == 0) goto L_0x010c
                java.lang.String r14 = r14.getBuss()
                goto L_0x010d
            L_0x010c:
                r14 = r1
            L_0x010d:
                java.lang.String r4 = "vod"
                boolean r14 = t9.i.b(r14, r4)
                if (r14 == 0) goto L_0x014c
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x014c
                boolean r14 = r14.r()
                if (r14 != 0) goto L_0x014c
                com.titan.thumbnail.ThumbnailUtil r14 = com.titan.thumbnail.ThumbnailUtil.INSTANCE
                boolean r14 = r14.hasThumbnail()
                if (r14 != 0) goto L_0x014c
                l8.e r14 = r13.f18737a
                l8.b r14 = r14.Y()
                int r14 = r14.c()
                if (r14 != r2) goto L_0x014c
                com.titan.thumbnail.ThumbnailRequest r14 = com.titan.thumbnail.ThumbnailRequest.INSTANCE
                l8.e r5 = r13.f18737a
                l8.f r5 = r5.f18724z
                if (r5 == 0) goto L_0x0148
                java.lang.String r5 = r5.l()
                if (r5 == 0) goto L_0x0148
                goto L_0x0149
            L_0x0148:
                r5 = r0
            L_0x0149:
                r14.getThumbnail(r5)
            L_0x014c:
                l8.e r14 = r13.f18737a
                r14.f18704f = r2
                com.titan.ranger.NativeJni r5 = com.titan.ranger.NativeJni.c()
                l8.e r14 = r13.f18737a
                int r6 = r14.f18713o
                java.lang.String r7 = "onPrepared"
                r8 = 0
                r9 = 0
                r10 = 0
                java.lang.String r12 = ""
                r5.k(r6, r7, r8, r9, r10, r12)
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                r5 = 0
                if (r14 == 0) goto L_0x0173
                r14.I(r5)
            L_0x0173:
                l8.e r14 = r13.f18737a
                boolean r14 = r14.f18700b
                if (r14 != 0) goto L_0x0190
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                if (r14 != 0) goto L_0x0186
                t9.i.q()
            L_0x0186:
                r14.start()
                l8.e r14 = r13.f18737a
                r7 = 3
                r14.O0(r7)
                goto L_0x01a9
            L_0x0190:
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                if (r14 == 0) goto L_0x01a9
                boolean r14 = r14.isPlaying()
                if (r14 != r2) goto L_0x01a9
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                if (r14 == 0) goto L_0x01a9
                r14.pause()
            L_0x01a9:
                l8.e r14 = r13.f18737a
                r7 = 2
                r14.F0(r7)
                l8.e r14 = r13.f18737a
                int r14 = r14.f18722x
                if (r14 < 0) goto L_0x01c6
                l8.e r14 = r13.f18737a
                int r7 = r14.f18722x
                r14.D0(r7)
                l8.e r14 = r13.f18737a
                r7 = -1
                r14.f18722x = r7
            L_0x01c6:
                l8.e r14 = r13.f18737a
                i8.b r14 = r14.f18718t
                i8.b r7 = i8.b.NATIVE
                if (r14 == r7) goto L_0x02f7
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x01dd
                long r7 = r14.i()
                goto L_0x01de
            L_0x01dd:
                r7 = r5
            L_0x01de:
                int r14 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r14 <= 0) goto L_0x0232
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x01f5
                com.titan.ranger.bean.Program r14 = r14.g()
                if (r14 == 0) goto L_0x01f5
                java.lang.String r14 = r14.getBuss()
                goto L_0x01f6
            L_0x01f5:
                r14 = r1
            L_0x01f6:
                boolean r14 = t9.i.b(r14, r4)
                if (r14 != 0) goto L_0x020a
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x0232
                boolean r14 = r14.s()
                if (r14 != r2) goto L_0x0232
            L_0x020a:
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x021b
                long r7 = r14.i()
                java.lang.Long r14 = java.lang.Long.valueOf(r7)
                goto L_0x021c
            L_0x021b:
                r14 = r1
            L_0x021c:
                if (r14 != 0) goto L_0x0221
                t9.i.q()
            L_0x0221:
                long r7 = r14.longValue()
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x02e0
                r14.G(r5)
                goto L_0x02e0
            L_0x0232:
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x023f
                long r7 = r14.j()
                goto L_0x0241
            L_0x023f:
                r7 = -1
            L_0x0241:
                int r14 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r14 < 0) goto L_0x0294
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x0258
                com.titan.ranger.bean.Program r14 = r14.g()
                if (r14 == 0) goto L_0x0258
                java.lang.String r14 = r14.getBuss()
                goto L_0x0259
            L_0x0258:
                r14 = r1
            L_0x0259:
                boolean r14 = t9.i.b(r14, r4)
                if (r14 == 0) goto L_0x0294
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x0294
                boolean r14 = r14.t()
                if (r14 != r2) goto L_0x0294
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x027e
                long r7 = r14.j()
                java.lang.Long r14 = java.lang.Long.valueOf(r7)
                goto L_0x027f
            L_0x027e:
                r14 = r1
            L_0x027f:
                if (r14 != 0) goto L_0x0284
                t9.i.q()
            L_0x0284:
                long r7 = r14.longValue()
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x02e0
                r14.F(r3)
                goto L_0x02e0
            L_0x0294:
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x02a7
                com.titan.ranger.bean.Program r14 = r14.g()
                if (r14 == 0) goto L_0x02a7
                long r7 = r14.getStart()
                goto L_0x02a8
            L_0x02a7:
                r7 = r5
            L_0x02a8:
                int r14 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r14 <= 0) goto L_0x02df
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x02c3
                com.titan.ranger.bean.Program r14 = r14.g()
                if (r14 == 0) goto L_0x02c3
                long r7 = r14.getStart()
                java.lang.Long r14 = java.lang.Long.valueOf(r7)
                goto L_0x02c4
            L_0x02c3:
                r14 = r1
            L_0x02c4:
                if (r14 != 0) goto L_0x02c9
                t9.i.q()
            L_0x02c9:
                long r7 = r14.longValue()
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x02e0
                com.titan.ranger.bean.Program r14 = r14.g()
                if (r14 == 0) goto L_0x02e0
                r14.setStart(r5)
                goto L_0x02e0
            L_0x02df:
                r7 = r5
            L_0x02e0:
                int r14 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r14 <= 0) goto L_0x02f7
                l8.e r14 = r13.f18737a
                l8.f r4 = r14.f18724z
                if (r4 == 0) goto L_0x02f3
                java.lang.String r4 = r4.d()
                if (r4 == 0) goto L_0x02f3
                goto L_0x02f4
            L_0x02f3:
                r4 = r0
            L_0x02f4:
                r14.C0(r4, r7)
            L_0x02f7:
                l8.e r14 = r13.f18737a
                r14.i0()
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                if (r14 == 0) goto L_0x0313
                tv.danmaku.ijk.media.player.MediaInfo r14 = r14.getMediaInfo()
                if (r14 == 0) goto L_0x0313
                tv.danmaku.ijk.media.player.IjkMediaMeta r14 = r14.mMeta
                if (r14 == 0) goto L_0x0313
                java.lang.String r14 = r14.mFormat
                if (r14 == 0) goto L_0x0313
                goto L_0x0314
            L_0x0313:
                r14 = r0
            L_0x0314:
                l8.e r4 = r13.f18737a
                d8.c r4 = r4.f18723y
                if (r4 == 0) goto L_0x031f
                r4.k(r14)
            L_0x031f:
                com.titan.ranger.NativeJni r4 = com.titan.ranger.NativeJni.c()
                l8.e r5 = r13.f18737a
                int r5 = r5.f18713o
                java.lang.String r6 = "format"
                r4.h(r5, r6, r14)
                l8.e r14 = r13.f18737a
                d8.c r14 = r14.f18723y
                if (r14 == 0) goto L_0x033f
                l8.e r4 = r13.f18737a
                long r4 = r4.W()
                r14.j(r4)
            L_0x033f:
                com.titan.ranger.NativeJni r14 = com.titan.ranger.NativeJni.c()
                l8.e r4 = r13.f18737a
                int r4 = r4.f18713o
                l8.e r5 = r13.f18737a
                long r5 = r5.W()
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.String r6 = "media_duration"
                r14.h(r4, r6, r5)
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x0365
                java.lang.String r14 = r14.d()
                goto L_0x0366
            L_0x0365:
                r14 = r1
            L_0x0366:
                boolean r14 = t9.i.b(r14, r0)
                r14 = r14 ^ r2
                if (r14 == 0) goto L_0x03ad
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                boolean r14 = r14 instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer
                if (r14 != 0) goto L_0x03ad
                l8.e r14 = r13.f18737a
                r14.f18720v = r2
                l8.e r14 = r13.f18737a
                d8.c r14 = r14.f18723y
                if (r14 == 0) goto L_0x03ad
                l8.e r4 = r13.f18737a
                j8.a r4 = r4.a0()
                if (r4 == 0) goto L_0x03a1
                l8.e r5 = r13.f18737a
                l8.f r5 = r5.f18724z
                if (r5 == 0) goto L_0x039b
                java.lang.String r5 = r5.d()
                if (r5 == 0) goto L_0x039b
                goto L_0x039c
            L_0x039b:
                r5 = r0
            L_0x039c:
                d8.d r14 = r4.f(r14, r5)
                goto L_0x03a2
            L_0x03a1:
                r14 = r1
            L_0x03a2:
                if (r14 == 0) goto L_0x03ad
                l8.e r4 = r13.f18737a
                int r14 = r14.a()
                r4.D0(r14)
            L_0x03ad:
                l8.e r14 = r13.f18737a
                r14.f18721w = r2
                l8.e r14 = r13.f18737a
                r14.S0()
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x03c3
                java.lang.String r1 = r14.d()
            L_0x03c3:
                boolean r14 = t9.i.b(r1, r0)
                r14 = r14 ^ r2
                if (r14 == 0) goto L_0x041e
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x03db
                boolean r14 = r14.r()
                if (r14 != r2) goto L_0x03db
                java.lang.String r14 = "ad"
                goto L_0x03dd
            L_0x03db:
                java.lang.String r14 = "media"
            L_0x03dd:
                r8 = r14
                l8.e r14 = r13.f18737a
                j8.a r4 = r14.a0()
                if (r4 == 0) goto L_0x041e
                l8.e r14 = r13.f18737a
                int r5 = r14.f18713o
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                if (r14 == 0) goto L_0x03fa
                int r14 = r14.getVideoWidth()
                r6 = r14
                goto L_0x03fb
            L_0x03fa:
                r6 = 0
            L_0x03fb:
                l8.e r14 = r13.f18737a
                tv.danmaku.ijk.media.player.IMediaPlayer r14 = r14.Z()
                if (r14 == 0) goto L_0x0409
                int r3 = r14.getVideoHeight()
                r7 = r3
                goto L_0x040a
            L_0x0409:
                r7 = 0
            L_0x040a:
                l8.e r14 = r13.f18737a
                l8.f r14 = r14.f18724z
                if (r14 == 0) goto L_0x041a
                java.lang.String r14 = r14.d()
                if (r14 == 0) goto L_0x041a
                r9 = r14
                goto L_0x041b
            L_0x041a:
                r9 = r0
            L_0x041b:
                r4.h(r5, r6, r7, r8, r9)
            L_0x041e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l8.e.h.onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer):void");
        }
    }

    public static final class i implements IMediaPlayer.OnCompletionListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18738a;

        public i(e eVar) {
            this.f18738a = eVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer r12) {
            /*
                r11 = this;
                l8.e r12 = r11.f18738a
                long r0 = r12.V()
                r12.f18705g = r0
                l8.e r12 = r11.f18738a
                r0 = 0
                r12.f18701c = r0
                l8.e r12 = r11.f18738a
                d8.c r12 = r12.f18723y
                r1 = 0
                if (r12 == 0) goto L_0x001e
                long r3 = r12.c()
                goto L_0x001f
            L_0x001e:
                r3 = r1
            L_0x001f:
                r12 = 1
                int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r5 <= 0) goto L_0x0026
                r3 = 1
                goto L_0x0027
            L_0x0026:
                r3 = 0
            L_0x0027:
                l8.e r4 = r11.f18738a
                l8.f r4 = r4.f18724z
                if (r4 == 0) goto L_0x0034
                long r4 = r4.k()
                goto L_0x0035
            L_0x0034:
                r4 = r1
            L_0x0035:
                r6 = 120000(0x1d4c0, float:1.68156E-40)
                int r7 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r7 <= 0) goto L_0x0060
                l8.e r4 = r11.f18738a
                l8.f r4 = r4.f18724z
                if (r4 == 0) goto L_0x0049
                long r4 = r4.k()
                goto L_0x004a
            L_0x0049:
                r4 = r1
            L_0x004a:
                l8.e r7 = r11.f18738a
                d8.c r7 = r7.f18723y
                if (r7 == 0) goto L_0x0057
                long r7 = r7.c()
                goto L_0x0058
            L_0x0057:
                r7 = r1
            L_0x0058:
                long r9 = (long) r6
                long r7 = r7 - r9
                int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                if (r9 < 0) goto L_0x0060
                r4 = 1
                goto L_0x0061
            L_0x0060:
                r4 = 0
            L_0x0061:
                l8.e r5 = r11.f18738a
                long r7 = r5.f18705g
                int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r5 <= 0) goto L_0x0085
                l8.e r5 = r11.f18738a
                long r7 = r5.f18705g
                l8.e r5 = r11.f18738a
                d8.c r5 = r5.f18723y
                if (r5 == 0) goto L_0x007d
                long r1 = r5.c()
            L_0x007d:
                long r5 = (long) r6
                long r1 = r1 - r5
                int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r5 < 0) goto L_0x0085
                r1 = 1
                goto L_0x0086
            L_0x0085:
                r1 = 0
            L_0x0086:
                l8.e r2 = r11.f18738a
                tv.danmaku.ijk.media.player.IMediaPlayer r2 = r2.Z()
                if (r2 == 0) goto L_0x0187
                l8.e r2 = r11.f18738a
                boolean r2 = r2.f18704f
                if (r2 == 0) goto L_0x0187
                if (r3 == 0) goto L_0x009c
                if (r4 != 0) goto L_0x00aa
                if (r1 != 0) goto L_0x00aa
            L_0x009c:
                l8.e r1 = r11.f18738a
                l8.f r1 = r1.f18724z
                if (r1 == 0) goto L_0x0187
                boolean r1 = r1.r()
                if (r1 != r12) goto L_0x0187
            L_0x00aa:
                com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
                l8.e r1 = r11.f18738a
                int r3 = r1.f18713o
                java.lang.String r4 = "onCompletion"
                r5 = 0
                r6 = 0
                r7 = 0
                java.lang.String r9 = ""
                r2.k(r3, r4, r5, r6, r7, r9)
                l8.e r1 = r11.f18738a
                l8.f r1 = r1.f18724z
                if (r1 == 0) goto L_0x00ca
                r1.w(r12)
            L_0x00ca:
                l8.e r1 = r11.f18738a
                r2 = 5
                r1.F0(r2)
                l8.e r1 = r11.f18738a
                r1.O0(r2)
                l8.e r1 = r11.f18738a
                l8.f r1 = r1.f18724z
                r2 = 0
                if (r1 == 0) goto L_0x00e3
                java.lang.String r1 = r1.d()
                goto L_0x00e4
            L_0x00e3:
                r1 = r2
            L_0x00e4:
                java.lang.String r3 = ""
                boolean r1 = t9.i.b(r1, r3)
                r1 = r1 ^ r12
                if (r1 == 0) goto L_0x0128
                l8.e r1 = r11.f18738a
                java.lang.String r4 = "end"
                r1.p0(r4)
                l8.e r1 = r11.f18738a
                l8.f r1 = r1.f18724z
                if (r1 == 0) goto L_0x0105
                boolean r1 = r1.r()
                if (r1 != r12) goto L_0x0105
                java.lang.String r1 = "ad"
                goto L_0x0107
            L_0x0105:
                java.lang.String r1 = "media"
            L_0x0107:
                l8.e r4 = r11.f18738a
                j8.a r4 = r4.a0()
                if (r4 == 0) goto L_0x0128
                l8.e r5 = r11.f18738a
                int r5 = r5.f18713o
                l8.e r6 = r11.f18738a
                l8.f r6 = r6.f18724z
                if (r6 == 0) goto L_0x0124
                java.lang.String r6 = r6.d()
                if (r6 == 0) goto L_0x0124
                goto L_0x0125
            L_0x0124:
                r6 = r3
            L_0x0125:
                r4.a(r5, r1, r6)
            L_0x0128:
                l8.e r1 = r11.f18738a
                r1.S()
                l8.e r1 = r11.f18738a
                l8.f r1 = r1.f18724z
                if (r1 == 0) goto L_0x0187
                boolean r1 = r1.r()
                if (r1 != r12) goto L_0x0187
                l8.e r12 = r11.f18738a
                l8.f r12 = r12.f18724z
                if (r12 == 0) goto L_0x0146
                r12.B(r0)
            L_0x0146:
                l8.e r12 = r11.f18738a
                r12.U0()
                l8.e r12 = r11.f18738a
                r12.F0(r0)
                l8.e r12 = r11.f18738a
                l8.f r12 = r12.f18724z
                if (r12 == 0) goto L_0x015d
                com.titan.ranger.Status r12 = r12.h()
                goto L_0x015e
            L_0x015d:
                r12 = r2
            L_0x015e:
                if (r12 == 0) goto L_0x0187
                l8.e r12 = r11.f18738a
                l8.f r1 = r12.f18724z
                if (r1 == 0) goto L_0x016d
                com.titan.ranger.Status r1 = r1.h()
                goto L_0x016e
            L_0x016d:
                r1 = r2
            L_0x016e:
                if (r1 != 0) goto L_0x0173
                t9.i.q()
            L_0x0173:
                r12.w0(r1)
                l8.e r12 = r11.f18738a
                l8.f r12 = r12.f18724z
                if (r12 == 0) goto L_0x0181
                r12.E(r2)
            L_0x0181:
                l8.e r12 = r11.f18738a
                r1 = 2
                l8.e.R0(r12, r3, r0, r1, r2)
            L_0x0187:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l8.e.i.onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer):void");
        }
    }

    public static final class j implements IMediaPlayer.OnErrorListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18739a;

        public j(e eVar) {
            this.f18739a = eVar;
        }

        /* renamed from: a */
        public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
            f m10;
            String str;
            j8.a a02;
            String d10;
            if (!(i10 == -38 || this.f18739a.f18707i == 5)) {
                if (this.f18739a.Z() instanceof AndroidMediaPlayer) {
                    this.f18739a.f18701c = false;
                }
                if (!(i10 == -10000 || i10 == -1004 || i10 == -110 || Build.VERSION.SDK_INT > 22)) {
                    NativeJni.c().k(this.f18739a.f18713o, "onError", 0, 1103, 0, "");
                    f m11 = this.f18739a.f18724z;
                    if (m11 != null) {
                        str = m11.d();
                    } else {
                        str = null;
                    }
                    String str2 = "";
                    if ((!t9.i.b(str, str2)) && (a02 = this.f18739a.a0()) != null) {
                        int i12 = this.f18739a.f18713o;
                        String a10 = this.f18739a.f18718t.a();
                        f m12 = this.f18739a.f18724z;
                        if (!(m12 == null || (d10 = m12.d()) == null)) {
                            str2 = d10;
                        }
                        a02.l(i12, 1103, a10, str2);
                    }
                }
                if (i11 == 1100 && (this.f18739a.Z() instanceof IjkMediaPlayer)) {
                    if (t9.i.b(Build.MODEL, "AFTSS") && (m10 = this.f18739a.f18724z) != null) {
                        m10.K(true);
                    }
                    NativeJni c10 = NativeJni.c();
                    int i13 = this.f18739a.f18713o;
                    IMediaPlayer Z = this.f18739a.Z();
                    if (Z != null) {
                        c10.h(i13, "codec_list", ((IjkMediaPlayer) Z).getCandidateCodecList());
                    } else {
                        throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
                    }
                }
                int c11 = this.f18739a.X(i10, i11);
                NativeJni.c().k(this.f18739a.f18713o, "onError", i10, c11, 0, "");
                if (!(i11 == 1104 || i11 == 1100 || i11 == 1201 || i11 == 1105 || i11 == 1106)) {
                    this.f18739a.F0(-1);
                }
                e eVar = this.f18739a;
                eVar.f18709k = ";mediaPlayError:(" + i10 + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + c11 + ASCIIPropertyListParser.ARRAY_END_TOKEN;
            }
            return true;
        }
    }

    public static final class k implements IMediaPlayer.OnInfoListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18740a;

        public k(e eVar) {
            this.f18740a = eVar;
        }

        /* JADX WARNING: type inference failed for: r4v21, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x01db  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer r11, int r12, int r13) {
            /*
                r10 = this;
                r9 = 701(0x2bd, float:9.82E-43)
                if (r12 != r9) goto L_0x0022
                l8.e r0 = r10.f18740a
                boolean r0 = r0.f18701c
                if (r0 == 0) goto L_0x0022
                com.titan.ranger.NativeJni r0 = com.titan.ranger.NativeJni.c()
                l8.e r1 = r10.f18740a
                int r1 = r1.f18713o
                java.lang.String r2 = "onInfo"
                r5 = 1
                java.lang.String r7 = ""
                r3 = r12
                r4 = r13
                r0.k(r1, r2, r3, r4, r5, r7)
                goto L_0x0037
            L_0x0022:
                com.titan.ranger.NativeJni r0 = com.titan.ranger.NativeJni.c()
                l8.e r1 = r10.f18740a
                int r1 = r1.f18713o
                java.lang.String r2 = "onInfo"
                r5 = 0
                java.lang.String r7 = ""
                r3 = r12
                r4 = r13
                r0.k(r1, r2, r3, r4, r5, r7)
            L_0x0037:
                java.lang.String r0 = ""
                r1 = 0
                r2 = 61699(0xf103, float:8.6459E-41)
                r3 = 1
                r4 = 0
                if (r12 != r9) goto L_0x0091
                l8.e r5 = r10.f18740a
                l8.e$e r5 = r5.J
                r5.removeMessages(r2)
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                if (r2 == 0) goto L_0x0056
                java.lang.String r4 = r2.d()
            L_0x0056:
                boolean r2 = t9.i.b(r4, r0)
                r2 = r2 ^ r3
                if (r2 == 0) goto L_0x0084
                l8.e r2 = r10.f18740a
                j8.a r4 = r2.a0()
                if (r4 == 0) goto L_0x0084
                l8.e r2 = r10.f18740a
                int r5 = r2.f18713o
                java.lang.String r6 = "buffering"
                java.lang.String r7 = "show"
                r8 = 0
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                if (r2 == 0) goto L_0x0080
                java.lang.String r2 = r2.d()
                if (r2 == 0) goto L_0x0080
                r9 = r2
                goto L_0x0081
            L_0x0080:
                r9 = r0
            L_0x0081:
                r4.c(r5, r6, r7, r8, r9)
            L_0x0084:
                l8.e r0 = r10.f18740a
                l8.f r0 = r0.f18724z
                if (r0 == 0) goto L_0x01ff
                r0.v(r3)
                goto L_0x01ff
            L_0x0091:
                r5 = 702(0x2be, float:9.84E-43)
                r6 = 3
                if (r12 != r5) goto L_0x00b6
                l8.e r0 = r10.f18740a
                r0.F0(r6)
                l8.e r0 = r10.f18740a
                l8.e$e r0 = r0.J
                r0.removeMessages(r2)
                l8.e r0 = r10.f18740a
                l8.e$e r0 = r0.J
                r3 = 1000(0x3e8, double:4.94E-321)
                r0.sendEmptyMessageDelayed(r2, r3)
                l8.e r0 = r10.f18740a
                r0.f18701c = r1
                goto L_0x01ff
            L_0x00b6:
                if (r12 != r6) goto L_0x01ff
                l8.e r2 = r10.f18740a
                java.lang.String r5 = "start"
                r2.p0(r5)
                l8.e r2 = r10.f18740a
                i8.b r2 = r2.f18718t
                i8.b r5 = i8.b.NATIVE
                if (r2 != r5) goto L_0x01ff
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                r5 = 0
                if (r2 == 0) goto L_0x00d8
                long r7 = r2.i()
                goto L_0x00d9
            L_0x00d8:
                r7 = r5
            L_0x00d9:
                java.lang.String r2 = "vod"
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 <= 0) goto L_0x012d
                l8.e r7 = r10.f18740a
                l8.f r7 = r7.f18724z
                if (r7 == 0) goto L_0x00f2
                com.titan.ranger.bean.Program r7 = r7.g()
                if (r7 == 0) goto L_0x00f2
                java.lang.String r7 = r7.getBuss()
                goto L_0x00f3
            L_0x00f2:
                r7 = r4
            L_0x00f3:
                boolean r7 = t9.i.b(r7, r2)
                if (r7 != 0) goto L_0x0107
                l8.e r7 = r10.f18740a
                l8.f r7 = r7.f18724z
                if (r7 == 0) goto L_0x012d
                boolean r7 = r7.s()
                if (r7 != r3) goto L_0x012d
            L_0x0107:
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                if (r2 == 0) goto L_0x0117
                long r2 = r2.i()
                java.lang.Long r4 = java.lang.Long.valueOf(r2)
            L_0x0117:
                if (r4 != 0) goto L_0x011c
                t9.i.q()
            L_0x011c:
                long r2 = r4.longValue()
                l8.e r4 = r10.f18740a
                l8.f r4 = r4.f18724z
                if (r4 == 0) goto L_0x01d7
                r4.G(r5)
                goto L_0x01d7
            L_0x012d:
                l8.e r7 = r10.f18740a
                l8.f r7 = r7.f18724z
                if (r7 == 0) goto L_0x013a
                long r7 = r7.j()
                goto L_0x013c
            L_0x013a:
                r7 = -1
            L_0x013c:
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 < 0) goto L_0x018d
                l8.e r7 = r10.f18740a
                l8.f r7 = r7.f18724z
                if (r7 == 0) goto L_0x0153
                com.titan.ranger.bean.Program r7 = r7.g()
                if (r7 == 0) goto L_0x0153
                java.lang.String r7 = r7.getBuss()
                goto L_0x0154
            L_0x0153:
                r7 = r4
            L_0x0154:
                boolean r2 = t9.i.b(r7, r2)
                if (r2 == 0) goto L_0x018d
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                if (r2 == 0) goto L_0x018d
                boolean r2 = r2.t()
                if (r2 != r3) goto L_0x018d
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                if (r2 == 0) goto L_0x0178
                long r2 = r2.j()
                java.lang.Long r4 = java.lang.Long.valueOf(r2)
            L_0x0178:
                if (r4 != 0) goto L_0x017d
                t9.i.q()
            L_0x017d:
                long r2 = r4.longValue()
                l8.e r4 = r10.f18740a
                l8.f r4 = r4.f18724z
                if (r4 == 0) goto L_0x01d7
                r4.F(r1)
                goto L_0x01d7
            L_0x018d:
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                if (r2 == 0) goto L_0x01a0
                com.titan.ranger.bean.Program r2 = r2.g()
                if (r2 == 0) goto L_0x01a0
                long r2 = r2.getStart()
                goto L_0x01a1
            L_0x01a0:
                r2 = r5
            L_0x01a1:
                int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r7 <= 0) goto L_0x01d6
                l8.e r2 = r10.f18740a
                l8.f r2 = r2.f18724z
                if (r2 == 0) goto L_0x01bb
                com.titan.ranger.bean.Program r2 = r2.g()
                if (r2 == 0) goto L_0x01bb
                long r2 = r2.getStart()
                java.lang.Long r4 = java.lang.Long.valueOf(r2)
            L_0x01bb:
                if (r4 != 0) goto L_0x01c0
                t9.i.q()
            L_0x01c0:
                long r2 = r4.longValue()
                l8.e r4 = r10.f18740a
                l8.f r4 = r4.f18724z
                if (r4 == 0) goto L_0x01d7
                com.titan.ranger.bean.Program r4 = r4.g()
                if (r4 == 0) goto L_0x01d7
                r4.setStart(r5)
                goto L_0x01d7
            L_0x01d6:
                r2 = r5
            L_0x01d7:
                int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x01ff
                l8.e r4 = r10.f18740a
                d8.c r4 = r4.f18723y
                if (r4 == 0) goto L_0x01e8
                long r7 = r4.c()
                goto L_0x01e9
            L_0x01e8:
                r7 = r5
            L_0x01e9:
                int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x01ff
                l8.e r4 = r10.f18740a
                l8.f r5 = r4.f18724z
                if (r5 == 0) goto L_0x01fc
                java.lang.String r5 = r5.d()
                if (r5 == 0) goto L_0x01fc
                r0 = r5
            L_0x01fc:
                r4.C0(r0, r2)
            L_0x01ff:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: l8.e.k.onInfo(tv.danmaku.ijk.media.player.IMediaPlayer, int, int):boolean");
        }
    }

    public static final class l implements IMediaPlayer.OnSeekCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18741a;

        public l(e eVar) {
            this.f18741a = eVar;
        }

        public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
            long j10;
            String str;
            i8.b bVar;
            f m10;
            j8.a a02;
            String str2;
            String d10;
            String str3;
            long j11;
            String d11;
            this.f18741a.f18701c = false;
            f m11 = this.f18741a.f18724z;
            if (m11 != null) {
                j10 = m11.e();
            } else {
                j10 = -1;
            }
            String str4 = "";
            if (j10 <= 0 || this.f18741a.f18718t != i8.b.NATIVE || !this.f18741a.n0()) {
                NativeJni.c().k(this.f18741a.f18713o, "onSeekComplete", 0, 0, 0, "");
                this.f18741a.F0(2);
                if (this.f18741a.f18713o != 1 && this.f18741a.f18715q == null) {
                    this.f18741a.S0();
                }
                f m12 = this.f18741a.f18724z;
                if (m12 != null) {
                    str = m12.d();
                } else {
                    str = null;
                }
                if (!t9.i.b(str, str4)) {
                    j8.a a03 = this.f18741a.a0();
                    if (a03 != null) {
                        int i10 = this.f18741a.f18713o;
                        f m13 = this.f18741a.f18724z;
                        if (m13 == null || (str3 = m13.d()) == null) {
                            str3 = str4;
                        }
                        a03.k(i10, str3);
                    }
                    if (this.f18741a.f18718t == i8.b.NATIVE && (m10 = this.f18741a.f18724z) != null && !m10.n() && (a02 = this.f18741a.a0()) != null) {
                        int i11 = this.f18741a.f18713o;
                        f m14 = this.f18741a.f18724z;
                        if (m14 == null || (d10 = m14.d()) == null) {
                            str2 = str4;
                        } else {
                            str2 = d10;
                        }
                        a02.c(i11, "buffering", "none", 0, str2);
                    }
                }
                if (this.f18741a.f18702d && this.f18741a.f18719u != (bVar = i8.b.NONE)) {
                    e eVar = this.f18741a;
                    eVar.W0(eVar.f18719u.a(), 0);
                    this.f18741a.f18719u = bVar;
                    return;
                }
                return;
            }
            e eVar2 = this.f18741a;
            f m15 = eVar2.f18724z;
            if (!(m15 == null || (d11 = m15.d()) == null)) {
                str4 = d11;
            }
            f m16 = this.f18741a.f18724z;
            if (m16 != null) {
                j11 = m16.e();
            } else {
                j11 = -1;
            }
            eVar2.C0(str4, j11);
            f m17 = this.f18741a.f18724z;
            if (m17 != null) {
                m17.A(-1);
            }
        }
    }

    public static final class m implements IMediaPlayer.OnBufferingUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18742a;

        public static final class a implements com.titan.ranger.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ v f18743a;

            public a(v vVar) {
                this.f18743a = vVar;
            }

            public void a(Status status) {
                v vVar = this.f18743a;
                if (status == null) {
                    t9.i.q();
                }
                vVar.f19599a = status.getBuffer();
            }
        }

        public m(e eVar) {
            this.f18742a = eVar;
        }

        public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10, long j10) {
            String str;
            boolean z10;
            j8.a a02;
            String d10;
            long j11;
            f m10;
            f m11;
            Program g10;
            f m12 = this.f18742a.f18724z;
            String str2 = null;
            if (m12 == null || (g10 = m12.g()) == null) {
                str = null;
            } else {
                str = g10.getBuss();
            }
            if (!t9.i.b(str, "live") || (m11 = this.f18742a.f18724z) == null || !m11.r()) {
                if (this.f18742a.f18713o == 1 || (((m10 = this.f18742a.f18724z) != null && m10.q() == 0) || this.f18742a.f18718t != i8.b.IJK)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                v vVar = new v();
                long j12 = 0;
                vVar.f19599a = 0;
                if (z10) {
                    this.f18742a.g0(new a(vVar));
                }
                if (j10 <= 0 && i10 > 0) {
                    d8.c k10 = this.f18742a.f18723y;
                    if (k10 != null) {
                        j11 = k10.c();
                    } else {
                        j11 = 0;
                    }
                    if (j11 > 0) {
                        d8.c k11 = this.f18742a.f18723y;
                        if (k11 != null) {
                            j12 = k11.c() / 100;
                        }
                        j10 = j12 * ((long) i10);
                    }
                }
                if (this.f18742a.Z() instanceof AndroidMediaPlayer) {
                    this.f18742a.F = j10;
                }
                long j13 = j10 + vVar.f19599a;
                f m13 = this.f18742a.f18724z;
                if (m13 != null) {
                    str2 = m13.d();
                }
                String str3 = "";
                if ((!t9.i.b(str2, str3)) && (a02 = this.f18742a.a0()) != null) {
                    int i11 = this.f18742a.f18713o;
                    f m14 = this.f18742a.f18724z;
                    if (!(m14 == null || (d10 = m14.d()) == null)) {
                        str3 = d10;
                    }
                    a02.d(i11, j13, str3);
                }
            }
        }
    }

    public static final class n implements IMediaPlayer.OnReplayListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18744a;

        public n(e eVar) {
            this.f18744a = eVar;
        }

        public final void onReplay(IMediaPlayer iMediaPlayer) {
            this.f18744a.J.removeMessages(61703);
            this.f18744a.J.sendEmptyMessageDelayed(61703, 1500);
        }
    }

    public static final class o implements IMediaPlayer.OnSeekListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18745a;

        public static final class a implements com.titan.ranger.c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f18746a = new a();

            public final void a(String str) {
            }
        }

        public o(e eVar) {
            this.f18745a = eVar;
        }

        public final void onSeek(IMediaPlayer iMediaPlayer, long j10) {
            String str;
            if (this.f18745a.Z() != null && this.f18745a.f18707i != 0 && this.f18745a.f18707i != -1) {
                this.f18745a.q0();
                NativeJni c10 = NativeJni.c();
                int i10 = this.f18745a.f18713o;
                f m10 = this.f18745a.f18724z;
                if (m10 != null) {
                    str = m10.d();
                } else {
                    str = null;
                }
                c10.r(i10, str, -1, j10, a.f18746a);
            }
        }
    }

    public static final class p extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18747a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(e eVar) {
            super(0);
            this.f18747a = eVar;
        }

        public final String invoke() {
            e eVar = this.f18747a;
            eVar.f18705g = eVar.V();
            e eVar2 = this.f18747a;
            eVar2.f18706h = eVar2.o0();
            return this.f18747a.G;
        }
    }

    public static final class q implements c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18748a;

        public q(e eVar) {
            this.f18748a = eVar;
        }

        public void a(String str) {
            String str2;
            j8.a a02;
            String d10;
            t9.i.h(str, "programData");
            f m10 = this.f18748a.f18724z;
            String str3 = null;
            if (m10 != null) {
                str2 = m10.f();
            } else {
                str2 = null;
            }
            if (m8.d.b(str2) && this.f18748a.Z() != null) {
                this.f18748a.q0();
                f m11 = this.f18748a.f18724z;
                if (m11 != null) {
                    str3 = m11.d();
                }
                String str4 = "";
                if ((!t9.i.b(str3, str4)) && (a02 = this.f18748a.a0()) != null) {
                    int i10 = this.f18748a.f18713o;
                    long e10 = this.f18748a.f18705g;
                    f m12 = this.f18748a.f18724z;
                    if (!(m12 == null || (d10 = m12.d()) == null)) {
                        str4 = d10;
                    }
                    a02.b(i10, e10, str4);
                }
            }
        }
    }

    public static final class r implements ThumbnailCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f18749a;

        public r(e eVar) {
            this.f18749a = eVar;
        }

        public void onBitmapPrepared(boolean z10, Bitmap bitmap) {
            String str;
            j8.a a02;
            String d10;
            String str2 = "";
            this.f18749a.C.lock();
            try {
                f m10 = this.f18749a.f18724z;
                if (m10 != null) {
                    str = m10.d();
                } else {
                    str = null;
                }
                if ((!t9.i.b(str, str2)) && (a02 = this.f18749a.a0()) != null) {
                    f m11 = this.f18749a.f18724z;
                    if (!(m11 == null || (d10 = m11.d()) == null)) {
                        str2 = d10;
                    }
                    a02.e(z10, bitmap, str2);
                }
            } finally {
                this.f18749a.C.unlock();
            }
        }

        public void onGetThumbnail(boolean z10) {
            String str;
            j8.a a02;
            String d10;
            String str2 = "";
            this.f18749a.C.lock();
            try {
                f m10 = this.f18749a.f18724z;
                if (m10 != null) {
                    str = m10.d();
                } else {
                    str = null;
                }
                if ((!t9.i.b(str, str2)) && (a02 = this.f18749a.a0()) != null) {
                    f m11 = this.f18749a.f18724z;
                    if (!(m11 == null || (d10 = m11.d()) == null)) {
                        str2 = d10;
                    }
                    a02.g(z10, str2);
                }
            } finally {
                this.f18749a.C.unlock();
            }
        }
    }

    public e(int i10) {
        String simpleName = e.class.getSimpleName();
        t9.i.c(simpleName, "javaClass.simpleName");
        this.f18699a = simpleName;
        this.f18713o = i10;
        this.f18718t = i8.b.NATIVE;
        this.f18719u = i8.b.NONE;
        this.f18722x = -1;
        this.A = h9.h.b(f.f18733a);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.B = reentrantReadWriteLock;
        this.C = reentrantReadWriteLock.readLock();
        this.D = reentrantReadWriteLock.writeLock();
        this.E = new HashMap();
        this.G = "";
        this.H = new d(this);
        this.I = new r(this);
        this.J = new C0270e(this);
    }

    public static /* synthetic */ void R0(e eVar, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        eVar.Q0(str, z10);
    }

    public final int A0(String str) {
        t9.i.h(str, "name");
        f fVar = this.f18724z;
        if (fVar != null && fVar.o()) {
            C0(str, 0);
        }
        this.f18700b = false;
        this.f18703e = false;
        O0(3);
        if (!n0()) {
            return -1;
        }
        f fVar2 = this.f18724z;
        if (fVar2 != null && !fVar2.p()) {
            NativeJni.c().q(this.f18713o, str);
        }
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (iMediaPlayer != null && !iMediaPlayer.isPlaying()) {
            try {
                IMediaPlayer iMediaPlayer2 = this.f18712n;
                if (iMediaPlayer2 != null) {
                    iMediaPlayer2.start();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            NativeJni.c().l(this.f18713o, "start", "", 0);
            this.f18701c = false;
            f fVar3 = this.f18724z;
            if (fVar3 != null) {
                fVar3.w(false);
            }
            F0(3);
            S0();
        }
        return 0;
    }

    public final void B0(long j10) {
        String str;
        j8.a aVar;
        String str2;
        String d10;
        if (n0()) {
            try {
                IMediaPlayer iMediaPlayer = this.f18712n;
                if (iMediaPlayer != null) {
                    iMediaPlayer.seekTo(j10);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            this.f18701c = true;
            NativeJni.c().l(this.f18713o, "seekTo", "", 0);
            f fVar = this.f18724z;
            if (fVar != null) {
                str = fVar.d();
            } else {
                str = null;
            }
            if ((true ^ t9.i.b(str, "")) && (aVar = this.f18710l) != null) {
                int i10 = this.f18713o;
                f fVar2 = this.f18724z;
                if (fVar2 == null || (d10 = fVar2.d()) == null) {
                    str2 = "";
                } else {
                    str2 = d10;
                }
                aVar.c(i10, "buffering", "show", 0, str2);
            }
            f fVar3 = this.f18724z;
            if (fVar3 != null) {
                fVar3.I(j10);
            }
        }
    }

    public final int C0(String str, long j10) {
        boolean z10;
        f fVar;
        f fVar2;
        t9.i.h(str, "name");
        if (!n0()) {
            return -1;
        }
        if (this.f18707i == 5) {
            F0(4);
        }
        f fVar3 = this.f18724z;
        if (fVar3 != null) {
            fVar3.w(false);
        }
        f fVar4 = this.f18724z;
        if (fVar4 != null) {
            fVar4.H(j10);
        }
        if (!this.f18701c || this.f18718t != i8.b.NATIVE) {
            NativeJni.c().h(this.f18713o, "seek_count", "");
            if (this.f18713o == 1 || (((fVar2 = this.f18724z) != null && fVar2.q() == 0) || this.f18718t != i8.b.IJK)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 || ((fVar = this.f18724z) != null && fVar.p())) {
                B0(j10);
            } else {
                NativeJni.c().r(this.f18713o, str, j10, -1, new g(this, j10));
            }
            return 0;
        }
        f fVar5 = this.f18724z;
        if (fVar5 != null) {
            fVar5.A(j10);
        }
        return -1;
    }

    public final int D0(int i10) {
        ExoMediaPlayer exoMediaPlayer;
        MediaPlayer internalMediaPlayer;
        ArrayList arrayList;
        d8.a a10;
        String str;
        MediaInfo mediaInfo;
        ExoMediaPlayer exoMediaPlayer2;
        MediaPlayer internalMediaPlayer2;
        if (n0()) {
            IMediaPlayer iMediaPlayer = this.f18712n;
            if (iMediaPlayer instanceof IjkMediaPlayer) {
                IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) iMediaPlayer;
                if (ijkMediaPlayer != null) {
                    ijkMediaPlayer.selectTrack(i10);
                }
            } else if (iMediaPlayer instanceof AndroidMediaPlayer) {
                AndroidMediaPlayer androidMediaPlayer = (AndroidMediaPlayer) iMediaPlayer;
                if (!(androidMediaPlayer == null || (internalMediaPlayer2 = androidMediaPlayer.getInternalMediaPlayer()) == null)) {
                    internalMediaPlayer2.selectTrack(i10);
                }
            } else if ((iMediaPlayer instanceof ExoMediaPlayer) && (exoMediaPlayer2 = (ExoMediaPlayer) iMediaPlayer) != null) {
                exoMediaPlayer2.selectAudioTrack(i10);
            }
            NativeJni.c().h(this.f18713o, "switch_count", "");
            int e02 = e0(2);
            d8.c cVar = this.f18723y;
            if (cVar != null) {
                arrayList = cVar.f();
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d8.b bVar = (d8.b) it.next();
                    if (e02 == bVar.b()) {
                        d8.c cVar2 = this.f18723y;
                        if (!(cVar2 == null || (a10 = cVar2.a()) == null)) {
                            a10.g(bVar.b());
                            a10.h(bVar.c());
                            a10.d(bVar.a());
                            IMediaPlayer iMediaPlayer2 = this.f18712n;
                            if (iMediaPlayer2 == null || (mediaInfo = iMediaPlayer2.getMediaInfo()) == null || (str = mediaInfo.mAudioDecoderImpl) == null) {
                                str = "";
                            }
                            a10.e(str);
                        }
                        NativeJni.c().h(this.f18713o, "acodec", bVar.a());
                    }
                }
            }
            return 0;
        }
        boolean z10 = this.f18720v;
        if (z10 && !this.f18721w) {
            IMediaPlayer iMediaPlayer3 = this.f18712n;
            if (iMediaPlayer3 instanceof IjkMediaPlayer) {
                IjkMediaPlayer ijkMediaPlayer2 = (IjkMediaPlayer) iMediaPlayer3;
                if (ijkMediaPlayer2 != null) {
                    ijkMediaPlayer2.selectTrack(i10);
                }
            } else if (iMediaPlayer3 instanceof AndroidMediaPlayer) {
                AndroidMediaPlayer androidMediaPlayer2 = (AndroidMediaPlayer) iMediaPlayer3;
                if (!(androidMediaPlayer2 == null || (internalMediaPlayer = androidMediaPlayer2.getInternalMediaPlayer()) == null)) {
                    internalMediaPlayer.selectTrack(i10);
                }
            } else if ((iMediaPlayer3 instanceof ExoMediaPlayer) && (exoMediaPlayer = (ExoMediaPlayer) iMediaPlayer3) != null) {
                exoMediaPlayer.selectAudioTrack(i10);
            }
            return 0;
        } else if (!z10) {
            return -1;
        } else {
            this.f18722x = i10;
            return 0;
        }
    }

    public final void E0(j8.a aVar, j8.b bVar) {
        t9.i.h(aVar, "playerCallback");
        t9.i.h(bVar, "rangerCallback");
        this.f18710l = aVar;
        this.f18711m = bVar;
        JniHandler.d(this.f18713o, this.H);
    }

    public final void F0(int i10) {
        this.f18707i = i10;
    }

    public final void G0(int i10) {
        Y().h(i10);
    }

    public final void H0(int i10) {
        Y().i(i10);
    }

    public final void I0(Context context) {
        this.f18714p = context;
    }

    public final int J0(String str, String str2) {
        Program g10;
        t9.i.h(str, "name");
        t9.i.h(str2, "media");
        f fVar = this.f18724z;
        if (!(fVar == null || (g10 = fVar.g()) == null)) {
            g10.setMedia(str2);
        }
        f fVar2 = this.f18724z;
        if (fVar2 != null) {
            fVar2.F(false);
        }
        f fVar3 = this.f18724z;
        if (fVar3 != null) {
            fVar3.H(-1);
        }
        f fVar4 = this.f18724z;
        if (fVar4 != null) {
            fVar4.G(0);
        }
        this.f18723y = null;
        p0("end");
        NativeJni.c().t(this.f18713o, str, str2);
        return 0;
    }

    public final void K0() {
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (iMediaPlayer != null) {
            iMediaPlayer.setOnPreparedListener(new h(this));
        }
        IMediaPlayer iMediaPlayer2 = this.f18712n;
        if (iMediaPlayer2 != null) {
            iMediaPlayer2.setOnCompletionListener(new i(this));
        }
        IMediaPlayer iMediaPlayer3 = this.f18712n;
        if (iMediaPlayer3 != null) {
            iMediaPlayer3.setOnErrorListener(new j(this));
        }
        IMediaPlayer iMediaPlayer4 = this.f18712n;
        if (iMediaPlayer4 != null) {
            iMediaPlayer4.setOnInfoListener(new k(this));
        }
        IMediaPlayer iMediaPlayer5 = this.f18712n;
        if (iMediaPlayer5 != null) {
            iMediaPlayer5.setOnSeekCompleteListener(new l(this));
        }
        IMediaPlayer iMediaPlayer6 = this.f18712n;
        if (iMediaPlayer6 != null) {
            iMediaPlayer6.setOnBufferingUpdateListener(new m(this));
        }
        IMediaPlayer iMediaPlayer7 = this.f18712n;
        if (iMediaPlayer7 != null) {
            iMediaPlayer7.setOnReplayListener(new n(this));
        }
        IMediaPlayer iMediaPlayer8 = this.f18712n;
        if (iMediaPlayer8 != null) {
            iMediaPlayer8.setOnSeekListener(new o(this));
        }
    }

    public final void L0(int i10) {
        Y().g(i10);
    }

    public final int M0(int i10) {
        n0();
        return 0;
    }

    public final void N0(Surface surface, String str) {
        String str2;
        t9.i.h(str, "surfaceId");
        String str3 = null;
        if (surface == null) {
            g gVar = this.f18716r;
            if (gVar != null) {
                str2 = gVar.a();
            } else {
                str2 = null;
            }
            if (t9.i.b(str, str2)) {
                IMediaPlayer iMediaPlayer = this.f18712n;
                if (iMediaPlayer != null) {
                    iMediaPlayer.setSurface((Surface) null);
                }
                this.f18716r = null;
                this.f18717s = false;
                return;
            }
            return;
        }
        g gVar2 = new g(str, surface);
        this.f18716r = gVar2;
        if (!this.f18717s) {
            IMediaPlayer iMediaPlayer2 = this.f18712n;
            if (iMediaPlayer2 != null) {
                iMediaPlayer2.setSurface(gVar2.b());
            }
            this.f18717s = true;
        }
        f fVar = this.f18724z;
        if (fVar != null) {
            str3 = fVar.f();
        }
        if (m8.d.b(str3) && this.f18712n == null) {
            l0();
        }
    }

    public final void O0(int i10) {
        this.f18708j = i10;
    }

    public final int P0(int i10) {
        float f10 = ((float) i10) / ((float) 100);
        if (n0()) {
            Y().j(f10);
            IMediaPlayer iMediaPlayer = this.f18712n;
            if (iMediaPlayer == null) {
                return 0;
            }
            iMediaPlayer.setVolume(f10, f10);
            return 0;
        }
        Y().j(f10);
        Y().k(true);
        return 0;
    }

    public final void Q0(String str, boolean z10) {
        String str2;
        String l10;
        Program g10;
        d8.c cVar;
        t9.i.h(str, "realPlayUrl");
        f fVar = this.f18724z;
        if (fVar != null) {
            fVar.B(z10);
        }
        f fVar2 = this.f18724z;
        if (fVar2 != null) {
            fVar2.I(0);
        }
        f fVar3 = this.f18724z;
        String str3 = "";
        if (fVar3 != null) {
            if (m8.d.a(str) && ((cVar = this.f18723y) == null || (str = cVar.e()) == null)) {
                str = str3;
            }
            fVar3.C(str);
        }
        f fVar4 = this.f18724z;
        if (fVar4 == null || (g10 = fVar4.g()) == null) {
            str2 = null;
        } else {
            str2 = g10.getBuss();
        }
        if (t9.i.b(str2, "vod") && !z10) {
            ThumbnailUtil thumbnailUtil = ThumbnailUtil.INSTANCE;
            f fVar5 = this.f18724z;
            if (!(fVar5 == null || (l10 = fVar5.l()) == null)) {
                str3 = l10;
            }
            thumbnailUtil.setSnapInfoUrl(str3);
        }
        l0();
    }

    public final void S() {
        if (this.f18713o != 1) {
            m8.c cVar = this.f18715q;
            if (cVar != null) {
                cVar.c();
            }
            this.f18715q = null;
        }
    }

    public final void S0() {
        String str;
        S();
        if (this.f18713o != 1) {
            f fVar = this.f18724z;
            if (fVar != null) {
                str = fVar.f();
            } else {
                str = null;
            }
            if (m8.d.b(str) && this.f18712n != null) {
                if (this.f18715q == null) {
                    this.f18715q = new m8.c();
                }
                m8.c cVar = this.f18715q;
                if (cVar == null) {
                    t9.i.q();
                }
                cVar.d((long) Y().a(), new p(this), new q(this));
            }
        }
    }

    public final void T() {
        IMediaPlayer iMediaPlayer;
        try {
            x0();
            this.f18712n = U();
            if (Y().e()) {
                IMediaPlayer iMediaPlayer2 = this.f18712n;
                if (iMediaPlayer2 != null) {
                    iMediaPlayer2.setVolume(Y().d(), Y().d());
                }
                if (Y().d() == 1.0f) {
                    Y().k(false);
                }
            }
            K0();
            g gVar = this.f18716r;
            if (!(gVar == null || (iMediaPlayer = this.f18712n) == null)) {
                iMediaPlayer.setSurface(gVar.b());
            }
            IMediaPlayer iMediaPlayer3 = this.f18712n;
            if (iMediaPlayer3 != null) {
                iMediaPlayer3.setScreenOnWhilePlaying(true);
            }
        } catch (Exception unused) {
        } catch (AssertionError unused2) {
            NativeJni.c().k(this.f18713o, "onError", 0, 1202, 0, "");
        }
    }

    public final int T0(String str) {
        t9.i.h(str, "name");
        NativeJni.c().v(this.f18713o, str);
        this.f18723y = null;
        this.f18724z = null;
        return 0;
    }

    public final IMediaPlayer U() {
        String str;
        String str2;
        f fVar;
        Program g10;
        f fVar2;
        f fVar3 = this.f18724z;
        String str3 = null;
        if (fVar3 != null) {
            str = fVar3.f();
        } else {
            str = null;
        }
        if (!m8.d.b(str)) {
            return null;
        }
        int i10 = d.f18698a[this.f18718t.ordinal()];
        boolean z10 = false;
        if (i10 == 1) {
            Context context = this.f18714p;
            if (context != null) {
                z10 = true;
            }
            if (z10) {
                return new ExoMediaPlayer(context);
            }
            throw new IllegalStateException("ExoMediaPlayer need context!".toString());
        } else if (i10 == 2) {
            return new AndroidMediaPlayer();
        } else {
            if (this.f18713o != 1 && ((fVar2 = this.f18724z) == null || fVar2.q() != 0)) {
                z10 = true;
            }
            a aVar = a.f18691a;
            String b10 = Y().b();
            f fVar4 = this.f18724z;
            if (fVar4 == null || (g10 = fVar4.g()) == null) {
                str2 = null;
            } else {
                str2 = g10.getBuss();
            }
            boolean b11 = t9.i.b(str2, "live");
            int f10 = Y().f();
            f fVar5 = this.f18724z;
            if (fVar5 != null) {
                str3 = fVar5.b();
            }
            IMediaPlayer a10 = aVar.a(b10, b11, f10, z10, str3);
            if (a10 != null) {
                IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) a10;
                if (z10 && (fVar = this.f18724z) != null) {
                    ijkMediaPlayer.setSharedBuffer(fVar.a());
                }
                ijkMediaPlayer.setOnSelectTrackListener(new a(this));
                return ijkMediaPlayer;
            }
            throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
        }
    }

    public final void U0() {
        try {
            IMediaPlayer iMediaPlayer = this.f18712n;
            if (iMediaPlayer != null) {
                iMediaPlayer.stop();
            }
        } catch (Exception unused) {
        }
        NativeJni.c().l(this.f18713o, "stop", "", 0);
        y0();
        S();
    }

    public final long V() {
        Long l10;
        if (!n0()) {
            return -1;
        }
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (iMediaPlayer != null) {
            l10 = Long.valueOf(iMediaPlayer.getCurrentPosition());
        } else {
            l10 = null;
        }
        if (l10 == null) {
            t9.i.q();
        }
        return l10.longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (t9.i.b(r11, "record") != false) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int V0(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "name"
            t9.i.h(r11, r0)
            r0 = 0
            r10.f18723y = r0
            r10.S()
            java.lang.String r1 = "end"
            r10.p0(r1)
            r10.x0()     // Catch:{ Exception -> 0x0027, AssertionError -> 0x0014 }
            goto L_0x0028
        L_0x0014:
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r10.f18713o
            java.lang.String r4 = "onError"
            r5 = 0
            r6 = 1202(0x4b2, float:1.684E-42)
            r7 = 0
            java.lang.String r9 = ""
            r2.k(r3, r4, r5, r6, r7, r9)
            goto L_0x0028
        L_0x0027:
        L_0x0028:
            r1 = 0
            r10.F0(r1)
            r10.O0(r1)
            l8.f r2 = r10.f18724z
            if (r2 == 0) goto L_0x0042
            boolean r2 = r2.p()
            if (r2 != 0) goto L_0x0042
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r10.f18713o
            r2.w(r3, r11)
        L_0x0042:
            l8.f r11 = r10.f18724z
            if (r11 == 0) goto L_0x0051
            com.titan.ranger.bean.Program r11 = r11.g()
            if (r11 == 0) goto L_0x0051
            java.lang.String r11 = r11.getBuss()
            goto L_0x0052
        L_0x0051:
            r11 = r0
        L_0x0052:
            java.lang.String r2 = "vod"
            boolean r11 = t9.i.b(r11, r2)
            if (r11 != 0) goto L_0x0072
            l8.f r11 = r10.f18724z
            if (r11 == 0) goto L_0x0069
            com.titan.ranger.bean.Program r11 = r11.g()
            if (r11 == 0) goto L_0x0069
            java.lang.String r11 = r11.getBuss()
            goto L_0x006a
        L_0x0069:
            r11 = r0
        L_0x006a:
            java.lang.String r2 = "record"
            boolean r11 = t9.i.b(r11, r2)
            if (r11 == 0) goto L_0x0081
        L_0x0072:
            com.titan.thumbnail.ThumbnailUtil r11 = com.titan.thumbnail.ThumbnailUtil.INSTANCE
            r11.reset()
            com.titan.thumbnail.PreviewUtil r11 = com.titan.thumbnail.PreviewUtil.INSTANCE
            r11.recycle()
            com.titan.thumbnail.ThumbnailRequest r11 = com.titan.thumbnail.ThumbnailRequest.INSTANCE
            r11.cancel()
        L_0x0081:
            java.util.concurrent.locks.Lock r11 = r10.D
            r11.lock()
            l8.f r11 = r10.f18724z     // Catch:{ all -> 0x0097 }
            if (r11 == 0) goto L_0x008f
            java.lang.String r2 = ""
            r11.z(r2)     // Catch:{ all -> 0x0097 }
        L_0x008f:
            r10.f18724z = r0     // Catch:{ all -> 0x0097 }
            java.util.concurrent.locks.Lock r11 = r10.D
            r11.unlock()
            return r1
        L_0x0097:
            r11 = move-exception
            java.util.concurrent.locks.Lock r0 = r10.D
            r0.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.e.V0(java.lang.String):int");
    }

    public final long W() {
        Long l10;
        if (!n0()) {
            return -1;
        }
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (iMediaPlayer != null) {
            l10 = Long.valueOf(iMediaPlayer.getDuration());
        } else {
            l10 = null;
        }
        if (l10 == null) {
            t9.i.q();
        }
        return l10.longValue();
    }

    public final int W0(String str, int i10) {
        String str2;
        boolean z10;
        String str3;
        f fVar;
        f fVar2;
        Program g10;
        t9.i.h(str, "playerType");
        f fVar3 = this.f18724z;
        if (fVar3 != null) {
            str2 = fVar3.f();
        } else {
            str2 = null;
        }
        if (!m8.d.b(str2) || this.f18712n == null) {
            if (!t9.i.b(str, this.f18718t.a())) {
                i8.b a10 = i8.b.f17369g.a(str);
                if (a10 == null) {
                    t9.i.q();
                }
                this.f18718t = a10;
                NativeJni.c().g(this.f18713o, this.f18718t.a(), -1);
            }
        } else if (!t9.i.b(str, this.f18718t.a())) {
            if (this.f18718t == i8.b.NATIVE) {
                z10 = true;
            } else {
                z10 = false;
            }
            i8.b a11 = i8.b.f17369g.a(str);
            if (a11 == null) {
                t9.i.q();
            }
            if (!this.f18701c || !z10) {
                this.f18718t = a11;
                f fVar4 = this.f18724z;
                if (fVar4 == null || (g10 = fVar4.g()) == null) {
                    str3 = null;
                } else {
                    str3 = g10.getBuss();
                }
                if (!t9.i.b(str3, "live")) {
                    long V = V();
                    if (V > 1 && (fVar = this.f18724z) != null && fVar.i() == 0 && (fVar2 = this.f18724z) != null) {
                        fVar2.G(V);
                    }
                }
                z0();
                f fVar5 = this.f18724z;
                if (fVar5 != null) {
                    fVar5.H(-1);
                }
                d8.c cVar = this.f18723y;
                if (cVar != null) {
                    cVar.p(this.f18718t.a());
                }
                d8.c cVar2 = this.f18723y;
                if (cVar2 != null) {
                    cVar2.u((d8.f) null);
                }
                d8.c cVar3 = this.f18723y;
                if (cVar3 != null) {
                    cVar3.h((d8.a) null);
                }
                d8.c cVar4 = this.f18723y;
                if (cVar4 != null) {
                    cVar4.r((d8.e) null);
                }
                d8.c cVar5 = this.f18723y;
                if (cVar5 != null) {
                    cVar5.t((ArrayList) null);
                }
                f fVar6 = this.f18724z;
                if (fVar6 == null || !fVar6.p()) {
                    NativeJni.c().g(this.f18713o, this.f18718t.a(), i10);
                } else {
                    l0();
                }
            } else {
                this.f18702d = true;
                this.f18719u = a11;
                return 0;
            }
        }
        return 0;
    }

    public final int X(int i10, int i11) {
        if (i10 == -10000) {
            return i11;
        }
        if (-1004 == i11) {
            return 3000;
        }
        if (-1007 == i11) {
            return AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN;
        }
        if (-1010 == i11) {
            return AuthApiStatusCodes.AUTH_API_CLIENT_ERROR;
        }
        return -110 == i11 ? AuthApiStatusCodes.AUTH_API_SERVER_ERROR : AuthApiStatusCodes.AUTH_TOKEN_ERROR;
    }

    /* JADX INFO: finally extract failed */
    public final void X0(String str, Program program) {
        this.D.lock();
        try {
            f fVar = new f();
            this.f18724z = fVar;
            fVar.z(str);
            this.D.unlock();
            f fVar2 = this.f18724z;
            if (fVar2 != null) {
                fVar2.D(program);
            }
        } catch (Throwable th) {
            this.D.unlock();
            throw th;
        }
    }

    public final b Y() {
        h9.g gVar = this.A;
        z9.g gVar2 = K[0];
        return (b) gVar.getValue();
    }

    public final IMediaPlayer Z() {
        return this.f18712n;
    }

    public final j8.a a0() {
        return this.f18710l;
    }

    public final j8.b b0() {
        return this.f18711m;
    }

    public final String c0() {
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            return "none";
        }
        if (iMediaPlayer != null) {
            String dumpPlayInfo = ((IjkMediaPlayer) iMediaPlayer).dumpPlayInfo();
            t9.i.c(dumpPlayInfo, "(mediaPlayer as IjkMediaPlayer).dumpPlayInfo()");
            return dumpPlayInfo;
        }
        throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
    }

    public final int d0(int i10) {
        return MediaPlayerCompat.getSelectedTrack(this.f18712n, i10);
    }

    public final int e0(int i10) {
        MediaPlayer internalMediaPlayer;
        if (!n0()) {
            return -1;
        }
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (!(iMediaPlayer instanceof AndroidMediaPlayer)) {
            return d0(i10);
        }
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        try {
            AndroidMediaPlayer androidMediaPlayer = (AndroidMediaPlayer) iMediaPlayer;
            if (androidMediaPlayer == null || (internalMediaPlayer = androidMediaPlayer.getInternalMediaPlayer()) == null) {
                return -1;
            }
            return internalMediaPlayer.getSelectedTrack(i10);
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public final d8.c f0() {
        d8.a a10;
        d8.a a11;
        d8.a a12;
        d8.f g10;
        d8.f g11;
        d8.f g12;
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            iMediaPlayer = null;
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) iMediaPlayer;
        if (ijkMediaPlayer != null) {
            d8.c cVar = this.f18723y;
            if (!(cVar == null || (g12 = cVar.g()) == null)) {
                g12.c(ijkMediaPlayer.getVideoCachedDuration());
            }
            d8.c cVar2 = this.f18723y;
            if (!(cVar2 == null || (g11 = cVar2.g()) == null)) {
                g11.b(ijkMediaPlayer.getVideoCachedBytes());
            }
            d8.c cVar3 = this.f18723y;
            if (!(cVar3 == null || (g10 = cVar3.g()) == null)) {
                g10.f(ijkMediaPlayer.getVideoDecodeFramesPerSecond());
            }
            d8.c cVar4 = this.f18723y;
            if (!(cVar4 == null || (a12 = cVar4.a()) == null)) {
                a12.c(ijkMediaPlayer.getAudioCachedDuration());
            }
            d8.c cVar5 = this.f18723y;
            if (!(cVar5 == null || (a11 = cVar5.a()) == null)) {
                a11.b(ijkMediaPlayer.getAudioCachedBytes());
            }
            d8.c cVar6 = this.f18723y;
            if (!(cVar6 == null || (a10 = cVar6.a()) == null)) {
                a10.f(ijkMediaPlayer.getAVDiff());
            }
        }
        d8.c cVar7 = this.f18723y;
        if (cVar7 != null) {
            cVar7.p(this.f18718t.a());
        }
        return this.f18723y;
    }

    public final void g0(com.titan.ranger.b bVar) {
        String str;
        f fVar = this.f18724z;
        String str2 = null;
        if (fVar != null) {
            str = fVar.d();
        } else {
            str = null;
        }
        if (m8.d.b(str)) {
            NativeJni c10 = NativeJni.c();
            int i10 = this.f18713o;
            f fVar2 = this.f18724z;
            if (fVar2 != null) {
                str2 = fVar2.d();
            }
            c10.e(i10, str2, new b(bVar));
        }
    }

    public final ThumbnailCallback h0() {
        return this.I;
    }

    public final void i0() {
        d8.c cVar;
        MediaInfo mediaInfo;
        String str;
        MediaInfo mediaInfo2;
        String str2;
        int e02 = e0(1);
        int e03 = e0(2);
        int e04 = e0(3);
        ArrayList j02 = j0();
        d8.c cVar2 = this.f18723y;
        if (cVar2 != null) {
            cVar2.t(j02);
        }
        Iterator it = j02.iterator();
        while (it.hasNext()) {
            d8.b bVar = (d8.b) it.next();
            int b10 = bVar.b();
            String str3 = "";
            if (b10 == e02) {
                d8.c cVar3 = this.f18723y;
                if (cVar3 != null) {
                    d8.f fVar = r8;
                    d8.f fVar2 = new d8.f(0, (String) null, (String) null, 0.0f, 0, 0, 63, (t9.g) null);
                    d8.f fVar3 = fVar;
                    fVar3.g(bVar.b());
                    fVar3.d(bVar.a());
                    IMediaPlayer iMediaPlayer = this.f18712n;
                    if (!(iMediaPlayer == null || (mediaInfo2 = iMediaPlayer.getMediaInfo()) == null || (str2 = mediaInfo2.mVideoDecoderImpl) == null)) {
                        str3 = str2;
                    }
                    fVar3.e(str3);
                    NativeJni.c().h(this.f18713o, "vdecoder", fVar3.a());
                    cVar3.u(fVar3);
                }
                NativeJni.c().h(this.f18713o, "vcodec", bVar.a());
            } else if (b10 == e03) {
                d8.c cVar4 = this.f18723y;
                if (cVar4 != null) {
                    d8.a aVar = r8;
                    d8.a aVar2 = new d8.a(0, (String) null, (String) null, (String) null, 0.0f, 0, 0, 127, (t9.g) null);
                    d8.a aVar3 = aVar;
                    aVar3.g(bVar.b());
                    aVar3.h(bVar.c());
                    aVar3.d(bVar.a());
                    IMediaPlayer iMediaPlayer2 = this.f18712n;
                    if (!(iMediaPlayer2 == null || (mediaInfo = iMediaPlayer2.getMediaInfo()) == null || (str = mediaInfo.mAudioDecoderImpl) == null)) {
                        str3 = str;
                    }
                    aVar3.e(str3);
                    cVar4.h(aVar3);
                }
                NativeJni.c().h(this.f18713o, "acodec", bVar.a());
            } else if (b10 == e04 && (cVar = this.f18723y) != null) {
                d8.e eVar = new d8.e(0, (String) null, (String) null, 0.0f, 15, (t9.g) null);
                eVar.b(bVar.b());
                eVar.a(bVar.a());
                eVar.c(bVar.c());
                cVar.r(eVar);
            }
        }
    }

    public final ArrayList j0() {
        ITrackInfo[] iTrackInfoArr;
        boolean z10;
        ArrayList f10;
        Object obj;
        ArrayList arrayList = new ArrayList();
        try {
            IMediaPlayer iMediaPlayer = this.f18712n;
            if (iMediaPlayer != null) {
                iTrackInfoArr = iMediaPlayer.getTrackInfo();
            } else {
                iTrackInfoArr = null;
            }
            if (iTrackInfoArr != null) {
                if (iTrackInfoArr.length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    int length = iTrackInfoArr.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        ITrackInfo iTrackInfo = iTrackInfoArr[i10];
                        t9.i.c(iTrackInfo, "info");
                        if (iTrackInfo.getTrackType() == 2) {
                            d8.b bVar = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            IMediaFormat format = iTrackInfo.getFormat();
                            if (!(format instanceof IjkMediaFormat)) {
                                format = null;
                            }
                            IjkMediaFormat ijkMediaFormat = (IjkMediaFormat) format;
                            if (ijkMediaFormat != null) {
                                String string = ijkMediaFormat.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar.f(string);
                                String string2 = ijkMediaFormat.getString(IjkMediaFormat.KEY_IJK_CHANNELS_UI);
                                t9.i.c(string2, "it.getString(IjkMediaFormat.KEY_IJK_CHANNELS_UI)");
                                bVar.e(string2);
                                String string3 = ijkMediaFormat.getString(IjkMediaFormat.KEY_IJK_SAMPLE_RATE_UI);
                                t9.i.c(string3, "it.getString(IjkMediaFor…t.KEY_IJK_SAMPLE_RATE_UI)");
                                bVar.l(string3);
                            }
                            bVar.h(i10);
                            String language = iTrackInfo.getLanguage();
                            t9.i.c(language, "info.language");
                            bVar.i(language);
                            bVar.m("audio");
                            arrayList.add(bVar);
                        } else if (iTrackInfo.getTrackType() == 1) {
                            d8.b bVar2 = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            IMediaFormat format2 = iTrackInfo.getFormat();
                            if (!(format2 instanceof IjkMediaFormat)) {
                                format2 = null;
                            }
                            IjkMediaFormat ijkMediaFormat2 = (IjkMediaFormat) format2;
                            if (ijkMediaFormat2 != null) {
                                String string4 = ijkMediaFormat2.getString(IjkMediaFormat.KEY_IJK_CODEC_PIXEL_FORMAT_UI);
                                t9.i.c(string4, "it.getString(IjkMediaFor…JK_CODEC_PIXEL_FORMAT_UI)");
                                bVar2.j(string4);
                                String string5 = ijkMediaFormat2.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string5, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar2.f(string5);
                                String string6 = ijkMediaFormat2.getString(IjkMediaFormat.KEY_IJK_FRAME_RATE_UI);
                                t9.i.c(string6, "it.getString(IjkMediaFormat.KEY_IJK_FRAME_RATE_UI)");
                                bVar2.g(string6);
                            }
                            bVar2.h(i10);
                            bVar2.m("video");
                            StringBuilder sb = new StringBuilder();
                            IMediaPlayer iMediaPlayer2 = this.f18712n;
                            Object obj2 = "0";
                            if (iMediaPlayer2 != null) {
                                obj = Integer.valueOf(iMediaPlayer2.getVideoWidth());
                            } else {
                                obj = obj2;
                            }
                            sb.append(obj);
                            sb.append(" x ");
                            IMediaPlayer iMediaPlayer3 = this.f18712n;
                            if (iMediaPlayer3 != null) {
                                obj2 = Integer.valueOf(iMediaPlayer3.getVideoHeight());
                            }
                            sb.append(obj2);
                            bVar2.k(sb.toString());
                            arrayList.add(bVar2);
                        } else if (iTrackInfo.getTrackType() == 3) {
                            d8.b bVar3 = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            IMediaFormat format3 = iTrackInfo.getFormat();
                            if (!(format3 instanceof IjkMediaFormat)) {
                                format3 = null;
                            }
                            IjkMediaFormat ijkMediaFormat3 = (IjkMediaFormat) format3;
                            if (ijkMediaFormat3 != null) {
                                String string7 = ijkMediaFormat3.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string7, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar3.f(string7);
                            }
                            bVar3.h(i10);
                            String language2 = iTrackInfo.getLanguage();
                            t9.i.c(language2, "info.language");
                            bVar3.i(language2);
                            bVar3.m(MediaTrack.ROLE_SUBTITLE);
                            arrayList.add(bVar3);
                        } else {
                            d8.b bVar4 = new d8.b(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Message.EXT_HEADER_VALUE_MAX_LEN, (t9.g) null);
                            IMediaFormat format4 = iTrackInfo.getFormat();
                            if (!(format4 instanceof IjkMediaFormat)) {
                                format4 = null;
                            }
                            IjkMediaFormat ijkMediaFormat4 = (IjkMediaFormat) format4;
                            if (ijkMediaFormat4 != null) {
                                String string8 = ijkMediaFormat4.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string8, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar4.f(string8);
                            }
                            bVar4.h(i10);
                            String language3 = iTrackInfo.getLanguage();
                            t9.i.c(language3, "info.language");
                            bVar4.i(language3);
                            bVar4.m("unknown");
                            d8.c cVar = this.f18723y;
                            if (!(cVar == null || (f10 = cVar.f()) == null)) {
                                f10.add(bVar4);
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (ba.s.f(r0, "Obox", true) == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String k0(java.lang.String r12) {
        /*
            r11 = this;
            l8.f r0 = r11.f18724z
            r1 = 1
            if (r0 == 0) goto L_0x000b
            boolean r0 = r0.s()
            if (r0 == r1) goto L_0x00c3
        L_0x000b:
            if (r12 == 0) goto L_0x00c3
            l8.f r0 = r11.f18724z
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.r()
            if (r0 != r1) goto L_0x0019
            goto L_0x00c3
        L_0x0019:
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r11.f18712n
            r2 = 0
            if (r0 == 0) goto L_0x0068
            boolean r0 = r0 instanceof tv.danmaku.ijk.media.player.AndroidMediaPlayer
            if (r0 == 0) goto L_0x0068
            l8.h$b r0 = l8.h.f7639m
            l8.h r0 = r0.a()
            com.titan.ranger.bean.Env r0 = r0.m()
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getDev_id()
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            boolean r0 = m8.d.b(r0)
            if (r0 == 0) goto L_0x0068
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r3 > r0) goto L_0x0044
            r3 = 23
            if (r3 >= r0) goto L_0x0056
        L_0x0044:
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r3 = "Ebox"
            boolean r3 = ba.s.f(r0, r3, r1)
            if (r3 != 0) goto L_0x0056
            java.lang.String r3 = "Obox"
            boolean r0 = ba.s.f(r0, r3, r1)
            if (r0 == 0) goto L_0x0068
        L_0x0056:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 115(0x73, float:1.61E-43)
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            return r12
        L_0x0068:
            java.lang.String r0 = "s"
            r3 = 2
            r4 = 0
            boolean r0 = ba.s.l(r12, r0, r4, r3, r2)
            if (r0 == 0) goto L_0x007b
            java.lang.String r12 = r12.substring(r1)
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            t9.i.c(r12, r0)
        L_0x007b:
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r11.f18712n
            boolean r2 = r0 instanceof tv.danmaku.ijk.media.player.AndroidMediaPlayer
            if (r2 != 0) goto L_0x00c3
            boolean r0 = r0 instanceof tv.danmaku.ijk.media.player.ExoMediaPlayer
            if (r0 == 0) goto L_0x0086
            goto L_0x00c3
        L_0x0086:
            java.lang.String r6 = "?"
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r12
            int r0 = ba.t.y(r5, r6, r7, r8, r9, r10)
            r2 = -1
            if (r0 == r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a0
            java.lang.String r0 = r12.substring(r4, r0)
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            t9.i.c(r0, r2)
            goto L_0x00a9
        L_0x00a0:
            h9.q r12 = new h9.q
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r12.<init>(r0)
            throw r12
        L_0x00a8:
            r0 = r12
        L_0x00a9:
            java.lang.String r2 = ".m3u8"
            boolean r0 = ba.s.d(r0, r2, r1)
            if (r0 == 0) goto L_0x00b2
            return r12
        L_0x00b2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ijkhttphook:"
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
        L_0x00c3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.e.k0(java.lang.String):java.lang.String");
    }

    public final void l0() {
        String str;
        f fVar = this.f18724z;
        if (fVar != null) {
            str = fVar.f();
        } else {
            str = null;
        }
        if (!m8.d.a(str) && this.f18716r != null) {
            T();
            y0();
            this.J.post(new c(this));
        }
    }

    public final boolean m0() {
        String str;
        if (Build.VERSION.SDK_INT == 28) {
            Env m10 = h.f7639m.a().m();
            if (m10 != null) {
                str = m10.getDev_id();
            } else {
                str = null;
            }
            if (m8.d.b(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean n0() {
        int i10;
        if (this.f18712n == null || (i10 = this.f18707i) == -1 || i10 == 0 || i10 == 1) {
            return false;
        }
        return true;
    }

    public final boolean o0() {
        String f10;
        boolean z10;
        IMediaPlayer iMediaPlayer;
        f fVar = this.f18724z;
        if (fVar == null || (f10 = fVar.f()) == null) {
            return false;
        }
        if (f10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || !n0() || (iMediaPlayer = this.f18712n) == null || !iMediaPlayer.isPlaying()) {
            return false;
        }
        return true;
    }

    public final void p0(String str) {
        String str2;
        f fVar = this.f18724z;
        if (fVar == null || !fVar.r()) {
            str2 = "media";
        } else {
            str2 = "ad";
        }
        NativeJni.c().i(this.f18713o, str, str2);
    }

    public final void q0() {
        long j10;
        long V = V();
        IMediaPlayer iMediaPlayer = this.f18712n;
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            j10 = this.F - V;
        } else if (iMediaPlayer != null) {
            j10 = ((IjkMediaPlayer) iMediaPlayer).getAudioCachedDuration();
        } else {
            throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
        }
        NativeJni.c().j(this.f18713o, V, j10);
    }

    public final void r0() {
        String str;
        String str2;
        IMediaDataSource iMediaDataSource;
        try {
            if (this.f18712n != null) {
                f fVar = this.f18724z;
                IMediaDataSource iMediaDataSource2 = null;
                if (fVar != null) {
                    str = fVar.f();
                } else {
                    str = null;
                }
                String k02 = k0(str);
                Uri parse = Uri.parse(k02);
                t9.i.c(parse, "mUri");
                String scheme = parse.getScheme();
                if (scheme == null) {
                    scheme = "";
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 23 || ((!m8.d.a(scheme) && !s.f(scheme, "file", true) && !s.f(scheme, "efile", true)) || !(this.f18712n instanceof IjkMediaPlayer))) {
                    IMediaPlayer iMediaPlayer = this.f18712n;
                    if (iMediaPlayer == null) {
                        t9.i.q();
                    }
                    iMediaPlayer.setDataSource(k02);
                } else {
                    f fVar2 = this.f18724z;
                    if (fVar2 != null) {
                        iMediaDataSource = fVar2.c();
                    } else {
                        iMediaDataSource = null;
                    }
                    if (iMediaDataSource != null) {
                        IMediaPlayer iMediaPlayer2 = this.f18712n;
                        if (iMediaPlayer2 != null) {
                            f fVar3 = this.f18724z;
                            if (fVar3 != null) {
                                iMediaDataSource2 = fVar3.c();
                            }
                            iMediaPlayer2.setDataSource(iMediaDataSource2);
                        }
                    } else {
                        FileMediaDataSource fileMediaDataSource = new FileMediaDataSource(new File(parse.toString()));
                        IMediaPlayer iMediaPlayer3 = this.f18712n;
                        if (iMediaPlayer3 == null) {
                            t9.i.q();
                        }
                        iMediaPlayer3.setDataSource((IMediaDataSource) fileMediaDataSource);
                    }
                }
                NativeJni c10 = NativeJni.c();
                int i11 = this.f18713o;
                f fVar4 = this.f18724z;
                if (fVar4 == null || (str2 = fVar4.f()) == null) {
                    str2 = "";
                }
                c10.l(i11, "setDataSource", str2, 0);
                if (i10 == 19 && (this.f18712n instanceof AndroidMediaPlayer)) {
                    v0();
                }
                IMediaPlayer iMediaPlayer4 = this.f18712n;
                if (iMediaPlayer4 != null) {
                    iMediaPlayer4.setLooping(false);
                }
                IMediaPlayer iMediaPlayer5 = this.f18712n;
                if (iMediaPlayer5 != null) {
                    iMediaPlayer5.prepareAsync();
                }
                F0(1);
                NativeJni.c().l(this.f18713o, "prepare(Async)", "", 0);
            } else if (this.f18716r != null) {
                l0();
            }
        } catch (Exception unused) {
            F0(-1);
        } catch (AssertionError unused2) {
            F0(-1);
            NativeJni.c().k(this.f18713o, "onError", 0, 1202, 0, "");
        }
    }

    public final int s0(String str) {
        int i10;
        t9.i.h(str, "name");
        this.f18700b = true;
        O0(4);
        if (n0()) {
            f fVar = this.f18724z;
            if (fVar != null && !fVar.p()) {
                NativeJni.c().n(this.f18713o, str);
            }
            try {
                IMediaPlayer iMediaPlayer = this.f18712n;
                if (iMediaPlayer != null) {
                    iMediaPlayer.pause();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            i10 = 0;
            NativeJni.c().l(this.f18713o, "pause", "", 0);
            F0(4);
        } else {
            i10 = -1;
        }
        this.f18703e = true;
        return i10;
    }

    /* JADX INFO: finally extract failed */
    public final int t0(String str, Program program, String str2) {
        String str3 = str;
        Program program2 = program;
        String str4 = str2;
        t9.i.h(str3, "name");
        t9.i.h(program2, "program");
        t9.i.h(str4, "extra");
        this.D.lock();
        try {
            f fVar = new f();
            this.f18724z = fVar;
            fVar.z(str3);
            this.D.unlock();
            this.f18723y = new d8.c(0, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, (String) null, (String) null, (d8.f) null, (d8.a) null, (d8.e) null, (ArrayList) null, 16383, (t9.g) null);
            NativeJni.c().o(this.f18713o, str3, m8.a.a().toJson((Object) program2), str4);
            return 0;
        } catch (Throwable th) {
            this.D.unlock();
            throw th;
        }
    }

    public final void u0(String str, Program program, String str2) {
        String str3 = str;
        Program program2 = program;
        String str4 = str2;
        t9.i.h(str3, "name");
        t9.i.h(program2, "program");
        t9.i.h(str4, "extra");
        X0(str, program);
        this.f18723y = new d8.c(0, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, (String) null, (String) null, (d8.f) null, (d8.a) null, (d8.e) null, (ArrayList) null, 16383, (t9.g) null);
        this.f18700b = false;
        NativeJni.c().p(this.f18713o, str3, m8.a.a().toJson((Object) program2), str4);
    }

    public final void v0() {
        Field field;
        try {
            IMediaPlayer iMediaPlayer = this.f18712n;
            if (iMediaPlayer != null) {
                if (iMediaPlayer != null) {
                    field = iMediaPlayer.getClass().getDeclaredField("subTitleService");
                } else {
                    field = null;
                }
                if (field != null) {
                    field.setAccessible(true);
                }
                if (field != null) {
                    field.set(this.f18712n, (Object) null);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void w0(Status status) {
        t9.i.h(status, Constant.KEY_STATUS);
        if (this.f18723y == null) {
            this.f18723y = new d8.c(0, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, (String) null, (String) null, (d8.f) null, (d8.a) null, (d8.e) null, (ArrayList) null, 16383, (t9.g) null);
        }
        d8.c cVar = this.f18723y;
        if (cVar != null) {
            String program = status.getProgram();
            t9.i.c(program, "status.program");
            cVar.q(program);
        }
        d8.c cVar2 = this.f18723y;
        if (cVar2 != null) {
            String title = status.getTitle();
            t9.i.c(title, "status.title");
            cVar2.s(title);
        }
        d8.c cVar3 = this.f18723y;
        if (cVar3 != null) {
            String buss = status.getBuss();
            t9.i.c(buss, "status.buss");
            cVar3.i(buss);
        }
        d8.c cVar4 = this.f18723y;
        if (cVar4 != null) {
            String media = status.getMedia();
            t9.i.c(media, "status.media");
            cVar4.n(media);
        }
        d8.c cVar5 = this.f18723y;
        if (cVar5 != null) {
            String play_url = status.getPlay_url();
            t9.i.c(play_url, "status.play_url");
            cVar5.o(play_url);
        }
        d8.c cVar6 = this.f18723y;
        if (cVar6 != null) {
            cVar6.m(status.getLinks());
        }
        d8.c cVar7 = this.f18723y;
        if (cVar7 != null) {
            cVar7.l(status.getLatency());
        }
        f fVar = this.f18724z;
        if (fVar != null) {
            String snapinfo_url = status.getSnapinfo_url();
            t9.i.c(snapinfo_url, "status.snapinfo_url");
            fVar.J(snapinfo_url);
        }
        f fVar2 = this.f18724z;
        if (fVar2 != null) {
            String play_url2 = status.getPlay_url();
            t9.i.c(play_url2, "status.play_url");
            fVar2.C(play_url2);
        }
        f fVar3 = this.f18724z;
        if (fVar3 != null) {
            String format = status.getFormat();
            t9.i.c(format, "status.format");
            fVar3.x(format);
        }
        f fVar4 = this.f18724z;
        if (fVar4 != null) {
            fVar4.u(status.getMedia_buffer());
        }
        String play_url3 = status.getPlay_url();
        t9.i.c(play_url3, "status.play_url");
        if (s.k(play_url3, "mem://", true)) {
            f fVar5 = this.f18724z;
            if (fVar5 != null) {
                fVar5.y(1);
                return;
            }
            return;
        }
        f fVar6 = this.f18724z;
        if (fVar6 != null) {
            fVar6.y(0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x0() {
        /*
            r5 = this;
            l8.e$e r0 = r5.J
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            r0 = 0
            r5.F0(r0)
            r5.O0(r0)
            r5.y0()
            r5.S()
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f18712n
            if (r2 == 0) goto L_0x005a
            boolean r2 = r5.m0()
            if (r2 == 0) goto L_0x0029
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f18712n
            boolean r3 = r2 instanceof tv.danmaku.ijk.media.player.AndroidMediaPlayer
            if (r3 == 0) goto L_0x0029
            if (r2 == 0) goto L_0x0030
            r2.reset()
            goto L_0x0030
        L_0x0029:
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f18712n
            if (r2 == 0) goto L_0x0030
            r2.stop()
        L_0x0030:
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r5.f18713o
            java.lang.String r4 = "stop"
            r2.l(r3, r4, r4, r0)
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f18712n
            if (r2 == 0) goto L_0x0042
            r2.release()
        L_0x0042:
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r5.f18713o
            java.lang.String r4 = "release"
            r2.l(r3, r4, r4, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "mediaPlayer has release;"
            r2.append(r3)
            r2.append(r5)
        L_0x005a:
            r5.f18717s = r0
            r5.f18712n = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.e.x0():void");
    }

    public final void y0() {
        this.f18701c = false;
        this.f18703e = false;
        this.f18704f = false;
        this.f18709k = "";
        this.f18720v = false;
        this.f18721w = false;
        this.f18722x = -1;
        this.G = "";
        this.f18702d = false;
        this.f18719u = i8.b.NONE;
        f fVar = this.f18724z;
        if (fVar != null) {
            fVar.v(false);
        }
        f fVar2 = this.f18724z;
        if (fVar2 != null) {
            fVar2.A(-1);
        }
        f fVar3 = this.f18724z;
        if (fVar3 != null) {
            fVar3.w(false);
        }
        f fVar4 = this.f18724z;
        if (fVar4 != null) {
            fVar4.K(false);
        }
    }

    public final void z0() {
        this.J.removeCallbacksAndMessages((Object) null);
        y0();
        F0(0);
    }
}
