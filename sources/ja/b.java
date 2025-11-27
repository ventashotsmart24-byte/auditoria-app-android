package ja;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import ba.s;
import c2.e;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.umeng.analytics.pro.f;
import h9.h;
import h9.t;
import i9.r;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Dns;
import s7.d;
import t9.g;
import t9.i;
import t9.j;
import t9.z;

public final class b implements Dns {

    /* renamed from: f  reason: collision with root package name */
    public static final a f7201f = new a((g) null);

    /* renamed from: g  reason: collision with root package name */
    public static b f7202g;

    /* renamed from: h  reason: collision with root package name */
    public static Context f7203h;

    /* renamed from: i  reason: collision with root package name */
    public static final Set f7204i = new LinkedHashSet();

    /* renamed from: a  reason: collision with root package name */
    public final String f7205a;

    /* renamed from: b  reason: collision with root package name */
    public final h9.g f7206b;

    /* renamed from: c  reason: collision with root package name */
    public final h9.g f7207c;

    /* renamed from: d  reason: collision with root package name */
    public o7.a f7208d;

    /* renamed from: e  reason: collision with root package name */
    public ha.c f7209e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final b a() {
            if (b.f7202g == null) {
                synchronized (b.class) {
                    if (b.f7202g == null) {
                        b.f7202g = new b((g) null);
                    }
                    t tVar = t.f17319a;
                }
            }
            b b10 = b.f7202g;
            i.d(b10);
            return b10;
        }

        public final void b(Context context) {
            i.g(context, f.X);
            b.f7203h = context.getApplicationContext();
        }
    }

    /* renamed from: ja.b$b  reason: collision with other inner class name */
    public static final class C0234b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0234b f17559a = new C0234b();

        public C0234b() {
            super(0);
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(i.b(d.a("debug.dns.enable", "1"), "1"));
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f17560a = new c();

        public c() {
            super(0);
        }

        /* renamed from: b */
        public final Boolean invoke() {
            return Boolean.valueOf(i.b(d.a("debug.dns.filter", "1"), "1"));
        }
    }

    public /* synthetic */ b(g gVar) {
        this();
    }

    public static final void n(String str, String str2, b bVar, String str3, String str4) {
        String str5;
        boolean z10;
        String str6;
        i.g(str, "$type");
        i.g(str2, "$hostname");
        i.g(bVar, "this$0");
        i.g(str3, "$mapper");
        i.g(str4, "$alias");
        if (i.b(str, "system")) {
            str5 = d.a("net.dns1", "") + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + d.a("net.dns2", "");
        } else {
            str5 = "google";
        }
        String str7 = str5;
        String a10 = a3.d.a(str2, a3.d.f162a);
        if (a10 == null || a10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            str6 = str2;
        } else {
            str6 = a10;
        }
        i.f(str6, "hostnameMapper");
        bVar.l(str, str6, str3, str7, str4);
    }

    public final boolean e(String str) {
        try {
            if (TextUtils.isDigitsOnly(s.j(s.j(str, ".", "", false, 4, (Object) null), SOAP.DELIM, "", false, 4, (Object) null))) {
                return true;
            }
            return false;
        } catch (MalformedURLException unused) {
        }
    }

    public final List f(List list, String str, String str2, String str3) {
        boolean z10;
        boolean z11;
        boolean z12;
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z13 = false;
        int i10 = 0;
        while (true) {
            boolean z14 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            byte[] address = ((InetAddress) next).getAddress();
            if (address == null || address.length != 4) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                z zVar = z.f19601a;
                String format = String.format("%03d.%03d.%03d.%03d", Arrays.copyOf(new Object[]{Integer.valueOf(address[0] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[1] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[2] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[3] & UnsignedBytes.MAX_VALUE)}, 4));
                i.f(format, "format(format, *args)");
                if (("192.168.000.000".compareTo(format) > 0 || "192.168.255.255".compareTo(format) < 0) && !TextUtils.equals(format, "127.000.000.001") && !TextUtils.equals(format, "000.000.000.000") && !TextUtils.equals(format, "255.255.255.255")) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    if (sb.length() > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        sb.append(",");
                    }
                    String format2 = String.format("%d.%d.%d.%d(%d/%d)", Arrays.copyOf(new Object[]{Integer.valueOf(address[0] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[1] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[2] & UnsignedBytes.MAX_VALUE), Integer.valueOf(address[3] & UnsignedBytes.MAX_VALUE), Integer.valueOf(i11), Integer.valueOf(size)}, 6));
                    i.f(format2, "format(format, *args)");
                    sb.append(format2);
                }
                z14 = z11;
            }
            if (z14) {
                arrayList.add(next);
            }
            i10 = i11;
        }
        List I = r.I(arrayList);
        if (sb.length() > 0) {
            z13 = true;
        }
        if (z13) {
            String sb2 = sb.toString();
            i.f(sb2, "filterDnsResult.toString()");
            m(str, str2, sb2, str3);
        }
        return I;
    }

    public final o7.c g() {
        File file;
        boolean z10;
        Context context = f7203h;
        if (context != null) {
            file = context.getCacheDir();
        } else {
            file = null;
        }
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            if (absolutePath == null || absolutePath.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return new p7.a(file.getAbsolutePath());
            }
        }
        return new p7.b();
    }

    public final boolean h() {
        return ((Boolean) this.f7206b.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) this.f7207c.getValue()).booleanValue();
    }

    public final List j(String str, String str2) {
        List k10;
        boolean z10;
        i.g(str, "hostname");
        i.g(str2, "alias");
        try {
            List<InetAddress> lookup = Dns.SYSTEM.lookup(str);
            if (lookup == null || lookup.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                throw new UnknownHostException("system dns lookup empty list.(" + str + ASCIIPropertyListParser.ARRAY_END_TOKEN);
            } else if (e(str)) {
                i.f(lookup, "lookupList");
                return lookup;
            } else {
                if (i()) {
                    i.f(lookup, "lookupList");
                    lookup = f(lookup, "system", str, str2);
                    if (lookup.isEmpty()) {
                        throw new UnknownHostException("system dns lookup empty list.(" + str + ASCIIPropertyListParser.ARRAY_END_TOKEN);
                    }
                }
                i.f(lookup, "lookupList");
                return lookup;
            }
        } catch (UnknownHostException e10) {
            e10.printStackTrace();
            if (this.f7208d == null || e(str)) {
                throw e10;
            } else if (!h() || (k10 = k(str)) == null) {
                throw new UnknownHostException("unknown host name(" + str + ASCIIPropertyListParser.ARRAY_END_TOKEN);
            } else if (true ^ k10.isEmpty()) {
                return f(k10, HttpConstant.HTTP, str, str2);
            } else {
                return k10;
            }
        }
    }

    public final List k(String str) {
        String[] strArr;
        boolean z10;
        try {
            o7.a aVar = this.f7208d;
            if (aVar != null) {
                strArr = aVar.e(str);
            } else {
                strArr = null;
            }
            if (strArr == null || strArr.length != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (strArr != null) {
                for (String allByName : strArr) {
                    InetAddress[] allByName2 = InetAddress.getAllByName(allByName);
                    i.f(allByName2, "getAllByName(it)");
                    arrayList.addAll(i9.f.a(allByName2));
                }
            }
            return arrayList;
        } catch (IOException e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("query http dns exception and exception info is ");
            sb.append(e10.getLocalizedMessage());
            e10.printStackTrace();
            return null;
        }
    }

    public final void l(String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        if (ba.t.o(str10, ".bigbee", false, 2, (Object) null)) {
            ha.c cVar = this.f7209e;
            if (cVar != null) {
                cVar.a(str6, str7, str8, str9);
                return;
            }
            return;
        }
        if (ba.t.o(str10, ".img", false, 2, (Object) null)) {
            String str11 = str6 + str7 + str8;
            Set set = f7204i;
            if (!set.contains(str11)) {
                set.add(str11);
                HashMap hashMap = new HashMap();
                hashMap.put("dns_type", str6);
                hashMap.put("domain|DES", str7);
                hashMap.put("mapper", str8);
                hashMap.put("resolver", str9);
                e.b(e.f4622a, "app_dns", hashMap, SystemClock.elapsedRealtime(), 0, false, false, 56, (Object) null);
                return;
            }
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("dns_type", str6);
        hashMap2.put("domain|DES", str7);
        hashMap2.put("mapper", str8);
        hashMap2.put("resolver", str9);
        e.b(e.f4622a, "app_dns", hashMap2, SystemClock.elapsedRealtime(), 0, false, false, 56, (Object) null);
    }

    public List lookup(String str) {
        i.g(str, "hostname");
        List<InetAddress> lookup = Dns.SYSTEM.lookup(str);
        i.f(lookup, "SYSTEM.lookup(hostname)");
        return lookup;
    }

    public final void m(String str, String str2, String str3, String str4) {
        s2.d.b("exception-dns", new a(str, str2, this, str3, str4), false);
    }

    public final void o(ha.c cVar) {
        i.g(cVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f7209e = cVar;
    }

    public b() {
        this.f7205a = b.class.getSimpleName();
        this.f7206b = h.b(C0234b.f17559a);
        this.f7207c = h.b(c.f17560a);
        this.f7208d = new o7.a(com.qiniu.android.dns.a.f12874d, new o7.d[]{new q7.a()}, g());
    }
}
