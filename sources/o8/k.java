package o8;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import c2.f;
import com.hpplay.sdk.source.common.global.Constant;
import com.titan.ranger.Status;
import com.titan.ranger.bean.report.PlayError;
import com.titan.ranger.bean.report.PlayFile;
import com.titan.ranger.bean.report.PlayMedia;
import com.titan.ranger.bean.report.PlayProgram;
import com.titan.ranger.bean.report.SwitchPlayer;
import d8.c;
import d8.d;
import java.util.ArrayList;
import java.util.List;
import t9.i;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f8567a = new k();

    /* renamed from: b  reason: collision with root package name */
    public static final String f8568b = "TitanCallback";

    /* renamed from: c  reason: collision with root package name */
    public static final List f8569c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static final List f8570d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public static Handler f8571e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public static j8.a f8572f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static j8.b f8573g = new b();

    public static final class a implements j8.a {
        public static final void A(int i10, String str) {
            i.g(str, "$name");
            for (j8.a k10 : k.f8569c) {
                k10.k(i10, str);
            }
        }

        public static final void B(int i10, String str, String str2, int i11, String str3) {
            i.g(str, "$obj");
            i.g(str2, "$action");
            i.g(str3, "$name");
            for (j8.a c10 : k.f8569c) {
                c10.c(i10, str, str2, i11, str3);
            }
        }

        public static final void t(boolean z10, Bitmap bitmap, String str) {
            i.g(str, "$name");
            for (j8.a e10 : k.f8569c) {
                e10.e(z10, bitmap, str);
            }
        }

        public static final void u(int i10, long j10, String str) {
            i.g(str, "$name");
            for (j8.a d10 : k.f8569c) {
                d10.d(i10, j10, str);
            }
        }

        public static final void v(int i10, String str, String str2) {
            i.g(str, "$type");
            i.g(str2, "$name");
            for (j8.a a10 : k.f8569c) {
                a10.a(i10, str, str2);
            }
        }

        public static final void w(boolean z10, String str) {
            i.g(str, "$name");
            for (j8.a g10 : k.f8569c) {
                g10.g(z10, str);
            }
        }

        public static final void x(int i10, int i11, String str, String str2) {
            i.g(str, "$player");
            i.g(str2, "$name");
            for (j8.a l10 : k.f8569c) {
                l10.l(i10, i11, str, str2);
            }
        }

        public static final void y(int i10, int i11, int i12, String str, String str2) {
            i.g(str, "$type");
            i.g(str2, "$name");
            for (j8.a h10 : k.f8569c) {
                h10.h(i10, i11, i12, str, str2);
            }
        }

        public static final void z(int i10, long j10, String str) {
            i.g(str, "$name");
            for (j8.a b10 : k.f8569c) {
                b10.b(i10, j10, str);
            }
        }

        public void a(int i10, String str, String str2) {
            i.g(str, "type");
            i.g(str2, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onCompletion ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new g(i10, str, str2));
        }

        public void b(int i10, long j10, String str) {
            i.g(str, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onProgress ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new f(i10, j10, str));
        }

        public void c(int i10, String str, String str2, int i11, String str3) {
            i.g(str, "obj");
            i.g(str2, "action");
            i.g(str3, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("setPlayerUI ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new h(i10, str, str2, i11, str3));
        }

        public void d(int i10, long j10, String str) {
            i.g(str, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onBuffering ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new b(i10, j10, str));
        }

        public void e(boolean z10, Bitmap bitmap, String str) {
            i.g(str, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onBitmapPrepared ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new j(z10, bitmap, str));
        }

        public d f(c cVar, String str) {
            i.g(cVar, "playStatus");
            i.g(str, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onMediaInfo ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            d dVar = null;
            for (j8.a f10 : k.f8569c) {
                d f11 = f10.f(cVar, str);
                if (f11 != null) {
                    dVar = f11;
                }
            }
            return dVar;
        }

        public void g(boolean z10, String str) {
            i.g(str, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetThumbnail ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new i(z10, str));
        }

        public void h(int i10, int i11, int i12, String str, String str2) {
            i.g(str, "type");
            i.g(str2, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepared ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new c(i10, i11, i12, str, str2));
        }

        public void k(int i10, String str) {
            i.g(str, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onSeekComplete ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new d(i10, str));
        }

        public void l(int i10, int i11, String str, String str2) {
            i.g(str, "player");
            i.g(str2, "name");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPlayerError ----> 当前callBack集合size为");
            sb.append(k.f8569c.size());
            k.f8571e.post(new e(i10, i11, str, str2));
        }
    }

    public static final class b implements j8.b {
        public void i(int i10, String str, Status status, long j10) {
            i.g(str, "event");
            i.g(status, Constant.KEY_STATUS);
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepareEvent ----> 当前callBack集合size为");
            sb.append(k.f8570d.size());
            for (j8.b i11 : k.f8570d) {
                i11.i(i10, str, status, j10);
            }
        }

        public void j(int i10, String str, Object obj, String str2) {
            long j10;
            long j11;
            long j12;
            i.g(str, "event");
            i.g(obj, "data");
            i.g(str2, "app_ctx");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onReport ----> 当前callBack集合size为");
            sb.append(k.f8570d.size());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            switch (str.hashCode()) {
                case -1877933145:
                    if (str.equals("play_file")) {
                        if (obj instanceof PlayFile) {
                            long duration = elapsedRealtime - ((PlayFile) obj).getDuration();
                            if (duration > 0) {
                                j10 = duration;
                            } else {
                                j10 = elapsedRealtime;
                            }
                            com.bigbee.bean.request.PlayFile playFile = (com.bigbee.bean.request.PlayFile) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayFile.class);
                            f fVar = f.f4630a;
                            i.f(playFile, "playFile");
                            fVar.b(playFile, j10, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1283382393:
                    if (str.equals("play_program")) {
                        if (obj instanceof PlayProgram) {
                            long duration2 = elapsedRealtime - ((PlayProgram) obj).getDuration();
                            if (duration2 > 0) {
                                j11 = duration2;
                            } else {
                                j11 = elapsedRealtime;
                            }
                            com.bigbee.bean.request.PlayProgram playProgram = (com.bigbee.bean.request.PlayProgram) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayProgram.class);
                            f fVar2 = f.f4630a;
                            i.f(playProgram, "playProgram");
                            fVar2.d(playProgram, j11, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1814306380:
                    if (str.equals("switch_player")) {
                        if (obj instanceof SwitchPlayer) {
                            com.bigbee.bean.request.SwitchPlayer switchPlayer = (com.bigbee.bean.request.SwitchPlayer) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.SwitchPlayer.class);
                            f fVar3 = f.f4630a;
                            i.f(switchPlayer, "switchPlayer");
                            fVar3.e(switchPlayer, elapsedRealtime, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1912965437:
                    if (str.equals("play_error")) {
                        if (obj instanceof PlayError) {
                            com.bigbee.bean.request.PlayError playError = (com.bigbee.bean.request.PlayError) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayError.class);
                            f fVar4 = f.f4630a;
                            i.f(playError, "playError");
                            fVar4.a(playError, elapsedRealtime, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1919952665:
                    if (str.equals("play_media")) {
                        if (obj instanceof PlayMedia) {
                            long duration3 = elapsedRealtime - ((PlayMedia) obj).getDuration();
                            if (duration3 > 0) {
                                j12 = duration3;
                            } else {
                                j12 = elapsedRealtime;
                            }
                            com.bigbee.bean.request.PlayMedia playMedia = (com.bigbee.bean.request.PlayMedia) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayMedia.class);
                            f fVar5 = f.f4630a;
                            i.f(playMedia, "playMedia");
                            fVar5.c(playMedia, j12, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
            }
            for (j8.b j13 : k.f8570d) {
                j13.j(i10, str, obj, str2);
            }
        }

        public void m(String str, String str2, long j10) {
            i.g(str, "adName");
            i.g(str2, "path");
            String unused = k.f8568b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrefetchAd ----> 当前callBack集合size为");
            sb.append(k.f8570d.size());
            for (j8.b m10 : k.f8570d) {
                m10.m(str, str2, j10);
            }
        }
    }

    public final void e(j8.a aVar, j8.b bVar) {
        i.g(aVar, "playerCallback");
        i.g(bVar, "rangerCallback");
        List list = f8569c;
        if (!list.contains(aVar)) {
            list.add(aVar);
        }
        List list2 = f8570d;
        if (!list2.contains(bVar)) {
            list2.add(bVar);
        }
    }

    public final j8.a f() {
        return f8572f;
    }

    public final j8.b g() {
        return f8573g;
    }

    public final void h(j8.a aVar, j8.b bVar) {
        i.g(aVar, "playerCallback");
        i.g(bVar, "rangerCallback");
        List list = f8569c;
        if (list.contains(aVar)) {
            list.remove(aVar);
        }
        List list2 = f8570d;
        if (list2.contains(bVar)) {
            list2.remove(bVar);
        }
    }
}
