package com.mobile.brasiltv.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import com.umeng.analytics.pro.f;
import h9.t;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.ConfigData;
import mobile.com.requestframe.utils.response.ConfigInfoBean;
import mobile.com.requestframe.utils.response.ConfigResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import t9.z;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f12622a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f12623b;

    /* renamed from: c  reason: collision with root package name */
    public static String f12624c;

    /* renamed from: d  reason: collision with root package name */
    public static int f12625d;

    /* renamed from: e  reason: collision with root package name */
    public static int f12626e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static int f12627f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static Disposable f12628g;

    /* renamed from: h  reason: collision with root package name */
    public static String f12629h;

    /* renamed from: i  reason: collision with root package name */
    public static String f12630i;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12631a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(1);
            this.f12631a = context;
        }

        public final void b(ConfigResult configResult) {
            String str;
            ConfigData data = configResult.getData();
            if (data != null) {
                str = data.getConfig();
            } else {
                str = null;
            }
            if (str != null) {
                Context context = this.f12631a;
                ConfigData data2 = configResult.getData();
                i.d(data2);
                String config = data2.getConfig();
                i.d(config);
                n7.a.e(context, "Properties", config);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ConfigResult) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f12632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f12633b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ x f12634c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(l lVar, l lVar2, x xVar) {
            super(1);
            this.f12632a = lVar;
            this.f12633b = lVar2;
            this.f12634c = xVar;
        }

        public final void b(ConfigResult configResult) {
            Gson a10 = s2.b.a();
            ConfigData data = configResult.getData();
            i.d(data);
            Object fromJson = a10.fromJson(data.getConfig(), ConfigInfoBean.class);
            i.f(fromJson, "jsoner.fromJson(it.data!…nfigInfoBean::class.java)");
            x.s(x.f12622a, (ConfigInfoBean) fromJson, this.f12632a, this.f12633b, false, 8, (Object) null);
            synchronized (this.f12634c) {
                x.f12627f = 1;
                t tVar = t.f17319a;
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ConfigResult) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x f12635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f12636b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(x xVar, l lVar) {
            super(1);
            this.f12635a = xVar;
            this.f12636b = lVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            synchronized (this.f12635a) {
                x.f12627f = 2;
                t tVar = t.f17319a;
            }
            x.f12625d = x.f12625d + 1;
            l lVar = this.f12636b;
            if (lVar != null) {
                lVar.invoke("");
            }
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f12637a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(w wVar) {
            super(1);
            this.f12637a = wVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            this.f12637a.f19600a = str;
        }
    }

    static {
        x xVar = new x();
        f12622a = xVar;
        String simpleName = xVar.getClass().getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        f12623b = simpleName;
    }

    public static /* synthetic */ void j(x xVar, Context context, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            lVar2 = null;
        }
        xVar.i(context, lVar, lVar2);
    }

    public static final void k(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void o(x xVar, Context context, l lVar, l lVar2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        if ((i10 & 4) != 0) {
            lVar2 = null;
        }
        xVar.n(context, lVar, lVar2);
    }

    public static /* synthetic */ void s(x xVar, ConfigInfoBean configInfoBean, l lVar, l lVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            lVar2 = null;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        xVar.r(configInfoBean, lVar, lVar2, z10);
    }

    public static final void u(Context context) {
        String str;
        boolean z10;
        i.g(context, "$context");
        Object b10 = n7.a.b(context, "Properties", "");
        if (b10 instanceof String) {
            str = (String) b10;
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            f12622a.r((ConfigInfoBean) s2.b.a().fromJson(str, ConfigInfoBean.class), (l) null, (l) null, true);
        }
    }

    public final String h() {
        boolean z10;
        String str;
        String str2 = f12624c;
        boolean z11 = false;
        if (str2 == null || str2.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            String str3 = f12624c;
            if (str3 == null) {
                return "";
            }
            return str3;
        }
        String str4 = f12629h;
        if (str4 == null || str4.length() == 0) {
            z11 = true;
        }
        if (z11 || (str = f12629h) == null) {
            return "";
        }
        return str;
    }

    public final void i(Context context, l lVar, l lVar2) {
        Disposable disposable;
        Disposable disposable2 = f12628g;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = f12628g) != null) {
            disposable.dispose();
        }
        f12628g = w6.i.f9510g.b().j1().doOnNext(new t(new a(context))).compose(s2.c.a()).subscribe(new u(new b(lVar, lVar2, this)), new v(new c(this, lVar)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(android.content.Context r7, s9.l r8, s9.l r9) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            t9.i.g(r7, r0)
            if (r9 == 0) goto L_0x001b
            java.lang.String r0 = f12630i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0013
            r6.i(r7, r8, r9)
            return
        L_0x0013:
            java.lang.String r0 = f12630i
            t9.i.d(r0)
            r9.invoke(r0)
        L_0x001b:
            java.lang.String r9 = f12624c
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x002b
            if (r8 == 0) goto L_0x002a
            java.lang.String r7 = f12624c
            r8.invoke(r7)
        L_0x002a:
            return
        L_0x002b:
            int r9 = f12625d
            int r0 = f12626e
            if (r9 < r0) goto L_0x003b
            java.lang.String r7 = r6.q()
            if (r8 == 0) goto L_0x003a
            r8.invoke(r7)
        L_0x003a:
            return
        L_0x003b:
            monitor-enter(r6)
            int r9 = f12627f     // Catch:{ all -> 0x005e }
            r0 = 2
            if (r9 == r0) goto L_0x004e
            com.mobile.brasiltv.utils.x r7 = f12622a     // Catch:{ all -> 0x005e }
            java.lang.String r7 = r7.q()     // Catch:{ all -> 0x005e }
            if (r8 == 0) goto L_0x004c
            r8.invoke(r7)     // Catch:{ all -> 0x005e }
        L_0x004c:
            monitor-exit(r6)
            return
        L_0x004e:
            r9 = 3
            f12627f = r9     // Catch:{ all -> 0x005e }
            h9.t r9 = h9.t.f17319a     // Catch:{ all -> 0x005e }
            monitor-exit(r6)
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            j(r0, r1, r2, r3, r4, r5)
            return
        L_0x005e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.x.n(android.content.Context, s9.l, s9.l):void");
    }

    public final String p(String str) {
        i.g(str, Scopes.EMAIL);
        int x10 = ba.t.x(str, '@', 0, false, 6, (Object) null);
        if (x10 == -1) {
            return null;
        }
        String substring = str.substring(x10);
        i.f(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String q() {
        if (!TextUtils.isEmpty(f12624c)) {
            return f12624c;
        }
        if (!TextUtils.isEmpty(f12629h)) {
            return f12629h;
        }
        return "";
    }

    public final void r(ConfigInfoBean configInfoBean, l lVar, l lVar2, boolean z10) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (configInfoBean != null) {
            str = configInfoBean.getOfficialWebsiteLink();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && !z10) {
            if (configInfoBean != null) {
                str3 = configInfoBean.getOfficialWebsiteLink();
            } else {
                str3 = null;
            }
            f12630i = str3;
            if (lVar2 != null) {
                i.d(str3);
                lVar2.invoke(str3);
            }
        }
        if (configInfoBean != null) {
            str2 = configInfoBean.getCustomerEmail();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (z10) {
                if (configInfoBean != null) {
                    str4 = configInfoBean.getCustomerEmail();
                }
                f12629h = str4;
                if (lVar != null) {
                    lVar.invoke(str4);
                    return;
                }
                return;
            }
            if (configInfoBean != null) {
                str4 = configInfoBean.getCustomerEmail();
            }
            f12624c = str4;
            if (lVar != null) {
                lVar.invoke(str4);
            }
        } else if (lVar != null) {
            lVar.invoke("");
        }
    }

    public final void t(Context context) {
        i.g(context, f.X);
        s2.d.b("loadCacheConfigInfo", new w(context), false);
    }

    public final String v(Context context) {
        i.g(context, f.X);
        w wVar = new w();
        wVar.f19600a = "";
        o(this, context, new d(wVar), (l) null, 4, (Object) null);
        return (String) wVar.f19600a;
    }

    public final void w(Context context, l lVar) {
        i.g(context, f.X);
        x(context, lVar, (l) null);
    }

    public final void x(Context context, l lVar, l lVar2) {
        i.g(context, f.X);
        n(context, lVar, lVar2);
    }

    public final String y(Context context, int i10) {
        i.g(context, f.X);
        z zVar = z.f19601a;
        String string = context.getString(i10);
        i.f(string, "context.getString(resId)");
        String format = String.format(string, Arrays.copyOf(new Object[]{h()}, 1));
        i.f(format, "format(format, *args)");
        return format;
    }
}
