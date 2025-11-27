package com.mobile.brasiltv.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import ba.s;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.app.App;
import com.taobao.accs.common.Constants;
import com.titan.cast.JniHandler;
import com.titan.cast.bean.CastBean;
import com.titan.cast.bean.CastMedia;
import com.titan.cast.bean.Device;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData;
import na.f;
import t9.i;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import w6.i;

public final class g implements f8.a {

    /* renamed from: a  reason: collision with root package name */
    public static final g f12519a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f12520b = "CastEventUtils";

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList f12521c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static Device f12522d;

    /* renamed from: e  reason: collision with root package name */
    public static Device f12523e;

    /* renamed from: f  reason: collision with root package name */
    public static b f12524f;

    /* renamed from: g  reason: collision with root package name */
    public static a f12525g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f12526h = 1001;

    /* renamed from: i  reason: collision with root package name */
    public static String f12527i = "";

    /* renamed from: j  reason: collision with root package name */
    public static int f12528j = -1;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f12529k;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f12530l;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f12531m;

    /* renamed from: n  reason: collision with root package name */
    public static boolean f12532n = true;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f12533o;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f12534p;

    /* renamed from: q  reason: collision with root package name */
    public static String f12535q = "";

    /* renamed from: r  reason: collision with root package name */
    public static String f12536r = "";

    /* renamed from: s  reason: collision with root package name */
    public static h8.b f12537s;

    public interface a {
        void G0(boolean z10);

        void d1(List list);
    }

    public interface b {
        void a();

        void b(int i10, String str, String str2);

        void d();

        void onLoading();

        void onPositionUpdate(long j10, long j11);

        void onStop();
    }

    static {
        g gVar = new g();
        f12519a = gVar;
        f12537s = gVar.f();
    }

    public final void A(boolean z10) {
        f12529k = z10;
    }

    public final void B(boolean z10) {
        f12531m = z10;
    }

    public final void C(boolean z10) {
        f12530l = z10;
    }

    public final void D(String str, CastMedia castMedia, String str2) {
        i.g(str, "session");
        i.g(castMedia, "media");
        i.g(str2, "extra");
        Integer j10 = new h8.a().j(str, castMedia, str2);
        if (j10 != null && j10.intValue() == 0) {
            h.f12562a.v(true);
        }
        h.f12562a.H(true);
    }

    public final void E(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j10, String str12, boolean z10) {
        boolean z11;
        String str13 = str11;
        i.g(str, "url");
        i.g(str2, "name");
        i.g(str3, "program");
        i.g(str4, "title");
        i.g(str5, "episode");
        i.g(str6, "buss");
        i.g(str7, IjkMediaMeta.IJKM_KEY_FORMAT);
        i.g(str8, "encode");
        i.g(str9, "quality");
        i.g(str10, "lang");
        i.g(str13, "extra");
        i.g(str12, Constants.KEY_HOST);
        if (f12523e != null) {
            if (str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (h.f12562a.t()) {
                    G();
                }
                CastMedia castMedia = new CastMedia(str2, str3, str4, str5, str6, str7, str8, str9, str10, str, j10, str12, z10);
                String uuid = UUID.randomUUID().toString();
                i.f(uuid, "randomUUID().toString()");
                f12536r = uuid;
                D(uuid, castMedia, str13);
            }
        }
    }

    public final void F() {
        f12521c.clear();
        h8.b bVar = f12537s;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void G() {
        h8.b bVar = f12537s;
        if (bVar != null) {
            bVar.e(f12536r);
        }
        h hVar = h.f12562a;
        hVar.v(false);
        hVar.H(false);
    }

    public final void H() {
        h8.b bVar = f12537s;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void I(Device device) {
        App.a aVar = App.f6050e;
        f.k(aVar.a(), "last_dlna_uid", device.getUdn());
        f.k(aVar.a(), "last_dlna_name", device.getFriendly_name());
    }

    public void a(String str) {
        b bVar;
        if (str != null) {
            switch (str.hashCode()) {
                case -1911454386:
                    if (str.equals("Paused") && (bVar = f12524f) != null) {
                        bVar.a();
                        return;
                    }
                    return;
                case -219666003:
                    if (str.equals("Stopped")) {
                        if (f12534p) {
                            b bVar2 = f12524f;
                            if (bVar2 != null) {
                                bVar2.onStop();
                                return;
                            }
                            return;
                        }
                        h.f12562a.v(false);
                        b bVar3 = f12524f;
                        if (bVar3 != null) {
                            bVar3.b(-1, "", h(f12536r));
                            return;
                        }
                        return;
                    }
                    return;
                case 953020041:
                    if (str.equals("LG_TRANSITIONING")) {
                        h.f12562a.v(false);
                        b bVar4 = f12524f;
                        if (bVar4 != null) {
                            bVar4.b(IMediaPlayer.MEDIA_INFO_BUFFERING_START, "", h(f12536r));
                            return;
                        }
                        return;
                    }
                    return;
                case 1171089422:
                    if (str.equals("Playing")) {
                        f12534p = true;
                        h.f12562a.v(true);
                        b bVar5 = f12524f;
                        if (bVar5 != null) {
                            bVar5.d();
                            return;
                        }
                        return;
                    }
                    return;
                case 2001303836:
                    if (str.equals("Loading")) {
                        f12534p = false;
                        b bVar6 = f12524f;
                        if (bVar6 != null) {
                            bVar6.onLoading();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void b(String str, String str2, int i10) {
        boolean z10;
        if (!i.b(str2, "StartPlay")) {
            i.b(str2, "StopPlay");
        } else if (s.g(str, f12536r, false, 2, (Object) null)) {
            h hVar = h.f12562a;
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            hVar.v(z10);
            if (i10 != 0) {
                String h10 = h(str);
                b bVar = f12524f;
                if (bVar != null) {
                    bVar.b(i10, "", h10);
                }
            }
        }
        if (i10 == 0) {
            f12528j = 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.bigbee.bean.request.CastAction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.bigbee.bean.request.CastDeviceDiscovery} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            long r4 = android.os.SystemClock.elapsedRealtime()
            if (r7 == 0) goto L_0x00d3
            int r9 = r7.hashCode()
            r0 = 497724214(0x1daaab36, float:4.5175653E-21)
            r1 = 0
            if (r9 == r0) goto L_0x00ad
            r0 = 1100412980(0x4196f834, float:18.871193)
            r2 = 0
            if (r9 == r0) goto L_0x006c
            r0 = 1155545264(0x44e038b0, float:1793.7715)
            if (r9 == r0) goto L_0x001e
            goto L_0x00d3
        L_0x001e:
            java.lang.String r9 = "cast_discovery"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0028
            goto L_0x00d3
        L_0x0028:
            if (r8 == 0) goto L_0x0035
            g8.b r7 = g8.b.f17282a
            java.lang.Class<com.bigbee.bean.request.CastDeviceDiscovery> r9 = com.bigbee.bean.request.CastDeviceDiscovery.class
            java.lang.Object r7 = r7.a(r8, r9)
            com.bigbee.bean.request.CastDeviceDiscovery r7 = (com.bigbee.bean.request.CastDeviceDiscovery) r7
            r1 = r7
        L_0x0035:
            if (r1 != 0) goto L_0x0038
            goto L_0x003d
        L_0x0038:
            java.lang.String r7 = f12535q
            r1.setCast_ver(r7)
        L_0x003d:
            if (r1 != 0) goto L_0x0040
            goto L_0x0056
        L_0x0040:
            com.mobile.brasiltv.app.App$a r7 = com.mobile.brasiltv.app.App.f6050e
            com.mobile.brasiltv.app.App r7 = r7.a()
            android.content.Context r7 = r7.getBaseContext()
            java.lang.String r8 = "App.instance.baseContext"
            t9.i.f(r7, r8)
            boolean r7 = r6.n(r7)
            r1.setConnectToWifi(r7)
        L_0x0056:
            if (r1 == 0) goto L_0x00d3
            long r7 = r1.getDuration()
            long r7 = r4 - r7
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x0064
            r2 = r7
            goto L_0x0065
        L_0x0064:
            r2 = r4
        L_0x0065:
            c2.a r0 = c2.a.f4590a
            r0.b(r1, r2, r4)
            goto L_0x00d3
        L_0x006c:
            java.lang.String r9 = "cast_play"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0076
            goto L_0x00d3
        L_0x0076:
            if (r8 == 0) goto L_0x0083
            g8.b r7 = g8.b.f17282a
            java.lang.Class<com.bigbee.bean.request.CastPlay> r9 = com.bigbee.bean.request.CastPlay.class
            java.lang.Object r7 = r7.a(r8, r9)
            com.bigbee.bean.request.CastPlay r7 = (com.bigbee.bean.request.CastPlay) r7
            goto L_0x0084
        L_0x0083:
            r7 = r1
        L_0x0084:
            if (r7 != 0) goto L_0x0087
            goto L_0x008c
        L_0x0087:
            java.lang.String r8 = f12535q
            r7.setCast_ver(r8)
        L_0x008c:
            if (r7 == 0) goto L_0x0096
            long r8 = r7.getDuration()
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
        L_0x0096:
            t9.i.d(r1)
            long r8 = r1.longValue()
            long r8 = r4 - r8
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a5
            r2 = r8
            goto L_0x00a6
        L_0x00a5:
            r2 = r4
        L_0x00a6:
            c2.a r0 = c2.a.f4590a
            r1 = r7
            r0.c(r1, r2, r4)
            goto L_0x00d3
        L_0x00ad:
            java.lang.String r9 = "cast_action"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x00b6
            goto L_0x00d3
        L_0x00b6:
            if (r8 == 0) goto L_0x00c3
            g8.b r7 = g8.b.f17282a
            java.lang.Class<com.bigbee.bean.request.CastAction> r9 = com.bigbee.bean.request.CastAction.class
            java.lang.Object r7 = r7.a(r8, r9)
            com.bigbee.bean.request.CastAction r7 = (com.bigbee.bean.request.CastAction) r7
            r1 = r7
        L_0x00c3:
            if (r1 != 0) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            java.lang.String r7 = f12535q
            r1.setCast_ver(r7)
        L_0x00cb:
            if (r1 == 0) goto L_0x00d3
            c2.a r0 = c2.a.f4590a
            r2 = r4
            r0.a(r1, r2, r4)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.g.c(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void d(Device device) {
        i.g(device, com.hpplay.cybergarage.upnp.Device.ELEM_NAME);
        if (!device.getAlive()) {
            int size = f12521c.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                } else if (i.b(device.getUdn(), ((Device) f12521c.get(i10)).getUdn())) {
                    ArrayList arrayList = f12521c;
                    arrayList.remove(arrayList.get(i10));
                    break;
                } else {
                    i10++;
                }
            }
        } else if (!h.f12562a.o() || !i.b(device, f12523e)) {
            f12521c.add(device);
        }
        a aVar = f12525g;
        if (aVar != null) {
            aVar.d1(f12521c);
        }
    }

    public void e(long j10, long j11) {
        long j12 = (long) 1000;
        long j13 = j10 / j12;
        long j14 = j11 / j12;
        b bVar = f12524f;
        if (bVar != null) {
            bVar.onPositionUpdate(j13, j14);
        }
    }

    public final h8.b f() {
        return new h8.a();
    }

    public final Device g() {
        return f12523e;
    }

    public final String h(String str) {
        Integer num;
        if (b0.K(str)) {
            if (str != null) {
                num = Integer.valueOf(str.length());
            } else {
                num = null;
            }
            i.d(num);
            if (num.intValue() > 5) {
                String substring = str.substring(str.length() - 5, str.length());
                i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return null;
    }

    public final void i() {
        u();
        f12535q = String.valueOf(new h8.a().d());
        h8.b bVar = f12537s;
        if (bVar != null) {
            bVar.d();
        }
        CastBean o10 = o();
        h8.b bVar2 = f12537s;
        if (bVar2 != null) {
            bVar2.g(g8.b.f17282a.c(o10));
        }
        q();
    }

    public final boolean j() {
        return f12533o;
    }

    public final boolean k(Device device) {
        i.g(device, "compareServiceInfo");
        Device device2 = f12522d;
        if (device2 == null) {
            return false;
        }
        i.d(device2);
        if (b0.H(device2.getUdn())) {
            Device device3 = f12522d;
            i.d(device3);
            return i.b(device3.getUdn(), device.getUdn());
        }
        Device device4 = f12522d;
        i.d(device4);
        if (b0.H(device4.getFriendly_name())) {
            Device device5 = f12522d;
            i.d(device5);
            if (i.b(device5.getFriendly_name(), device.getFriendly_name())) {
                Device device6 = f12522d;
                i.d(device6);
                if (i.b(device6.getServer_product(), device.getServer_product())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean l() {
        return f12531m;
    }

    public final boolean m() {
        return f12530l;
    }

    public final boolean n(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        Object systemService = context.getSystemService("connectivity");
        i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public final CastBean o() {
        String str;
        i.c cVar = w6.i.f9510g;
        String H = cVar.H();
        String E = cVar.E();
        GetSlbInfoBeanResultData A = r5.i.f19378a.A();
        if (A == null || (str = A.getPlay_params()) == null) {
            str = "";
        }
        return new CastBean("com.msandroid.mobile", "60201", H, E, str);
    }

    public final void p() {
        f12530l = true;
        h8.b bVar = f12537s;
        if (bVar != null) {
            bVar.h(f12536r);
        }
    }

    public final void q() {
        boolean z10;
        App.a aVar = App.f6050e;
        String f10 = f.f(aVar.a(), "last_dlna_name", "");
        if (f10 == null || f10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            String f11 = f.f(aVar.a(), "last_dlna_uid", "");
            t9.i.f(f10, "name");
            t9.i.f(f11, ParamsMap.DeviceParams.KEY_UID);
            f12522d = new Device(f10, "", "", f11, "", "", false);
        }
    }

    public final void r() {
        f12531m = false;
        h8.b bVar = f12537s;
        if (bVar != null) {
            bVar.a(f12536r);
        }
    }

    public final void s(long j10) {
        h8.b bVar = f12537s;
        if (bVar != null) {
            bVar.c(f12536r, j10);
        }
    }

    public final void t(Device device) {
        t9.i.g(device, com.hpplay.cybergarage.upnp.Device.ELEM_NAME);
        Integer i10 = new h8.a().i(device);
        if (i10 != null && i10.intValue() == 0) {
            f12523e = device;
            f12522d = device;
            a aVar = f12525g;
            if (aVar != null) {
                aVar.G0(true);
            }
            I(device);
            f.k(App.f6050e.a(), "last_cast_mode", "DLNA_CAST");
            return;
        }
        a aVar2 = f12525g;
        if (aVar2 != null) {
            aVar2.G0(false);
        }
    }

    public final void u() {
        new JniHandler().setOnCastCallBack(this);
    }

    public final void v(a aVar) {
        f12525g = aVar;
    }

    public final void w(b bVar) {
        f12524f = bVar;
    }

    public final void x(String str) {
        t9.i.g(str, "<set-?>");
        f12527i = str;
    }

    public final void y(boolean z10) {
        f12533o = z10;
    }

    public final void z(boolean z10) {
        f12534p = z10;
    }
}
