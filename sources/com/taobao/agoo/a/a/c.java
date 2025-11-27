package com.taobao.agoo.a.a;

import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;
import com.umeng.analytics.pro.bt;

public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";

    /* renamed from: a  reason: collision with root package name */
    public String f13263a;

    /* renamed from: b  reason: collision with root package name */
    public String f13264b;

    /* renamed from: c  reason: collision with root package name */
    public String f13265c;

    /* renamed from: d  reason: collision with root package name */
    public String f13266d = String.valueOf(Constants.SDK_VERSION_CODE);

    /* renamed from: f  reason: collision with root package name */
    public String f13267f;

    /* renamed from: g  reason: collision with root package name */
    public String f13268g;

    /* renamed from: h  reason: collision with root package name */
    public String f13269h;

    /* renamed from: i  reason: collision with root package name */
    public String f13270i;

    /* renamed from: j  reason: collision with root package name */
    public String f13271j;

    /* renamed from: k  reason: collision with root package name */
    public String f13272k;

    /* renamed from: l  reason: collision with root package name */
    public String f13273l;

    /* renamed from: m  reason: collision with root package name */
    public String f13274m;

    /* renamed from: n  reason: collision with root package name */
    public String f13275n;

    /* renamed from: o  reason: collision with root package name */
    public String f13276o;

    /* renamed from: p  reason: collision with root package name */
    public String f13277p;

    /* renamed from: q  reason: collision with root package name */
    private String f13278q;

    /* renamed from: r  reason: collision with root package name */
    private String f13279r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13280s;

    /* renamed from: t  reason: collision with root package name */
    private String f13281t;

    public byte[] a() {
        try {
            String jSONObject = new p.a().a(b.JSON_CMD, this.f13262e).a(Constants.KEY_APP_KEY, this.f13263a).a("utdid", this.f13264b).a("appVersion", this.f13265c).a(Constants.KEY_SDK_VERSION, this.f13266d).a(Constants.KEY_TTID, this.f13267f).a(Constants.KEY_PACKAGE_NAME, this.f13268g).a("notifyEnable", this.f13269h).a("romInfo", this.f13270i).a("c0", this.f13271j).a("c1", this.f13272k).a("c2", this.f13273l).a("c3", this.f13274m).a("c4", this.f13275n).a("c5", this.f13276o).a("c6", this.f13277p).a("pSdkV", this.f13278q).a(bt.f13913g, this.f13279r).a("ohos", String.valueOf(this.f13280s)).a("ohosV", this.f13281t).a().toString();
            ALog.i("RegisterDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes(XML.CHARSET_UTF8);
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "RegisterDO"
            r1 = 0
            r2 = 1
            r3 = 0
            java.lang.String r4 = com.taobao.accs.utl.UtilityImpl.j(r9)     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = r9.getPackageName()     // Catch:{ all -> 0x00bc }
            com.taobao.accs.client.GlobalClientInfo r6 = com.taobao.accs.client.GlobalClientInfo.getInstance(r9)     // Catch:{ all -> 0x00bc }
            android.content.pm.PackageInfo r6 = r6.getPackageInfo()     // Catch:{ all -> 0x00bc }
            java.lang.String r6 = r6.versionName     // Catch:{ all -> 0x00bc }
            boolean r7 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00bc }
            if (r7 != 0) goto L_0x009d
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00bc }
            if (r7 != 0) goto L_0x009d
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00bc }
            if (r7 == 0) goto L_0x002a
            goto L_0x009d
        L_0x002a:
            com.taobao.agoo.a.a.c r7 = new com.taobao.agoo.a.a.c     // Catch:{ all -> 0x00bc }
            r7.<init>()     // Catch:{ all -> 0x00bc }
            java.lang.String r8 = "register"
            r7.f13262e = r8     // Catch:{ all -> 0x009b }
            r7.f13263a = r10     // Catch:{ all -> 0x009b }
            r7.f13264b = r4     // Catch:{ all -> 0x009b }
            r7.f13265c = r6     // Catch:{ all -> 0x009b }
            r7.f13267f = r11     // Catch:{ all -> 0x009b }
            r7.f13268g = r5     // Catch:{ all -> 0x009b }
            java.lang.String r10 = android.os.Build.BRAND     // Catch:{ all -> 0x009b }
            r7.f13271j = r10     // Catch:{ all -> 0x009b }
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ all -> 0x009b }
            r7.f13272k = r10     // Catch:{ all -> 0x009b }
            java.lang.String r10 = com.taobao.accs.utl.j.c(r9)     // Catch:{ all -> 0x009b }
            r7.f13269h = r10     // Catch:{ all -> 0x009b }
            java.lang.String r11 = "ACCS_SDK_CHANNEL"
            com.taobao.accs.utl.UtilityImpl.a((android.content.Context) r9, (java.lang.String) r11, (java.lang.String) r10)     // Catch:{ all -> 0x009b }
            com.taobao.accs.utl.o r10 = new com.taobao.accs.utl.o     // Catch:{ all -> 0x009b }
            r10.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r10 = r10.a()     // Catch:{ all -> 0x009b }
            r7.f13270i = r10     // Catch:{ all -> 0x009b }
            java.lang.Class<com.umeng.message.MsgConstant> r10 = com.umeng.message.MsgConstant.class
            java.lang.String r11 = "SDK_VERSION"
            java.lang.reflect.Field r10 = r10.getField(r11)     // Catch:{ all -> 0x006b }
            java.lang.Object r10 = r10.get(r3)     // Catch:{ all -> 0x006b }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x006b }
            r7.f13278q = r10     // Catch:{ all -> 0x006b }
        L_0x006b:
            java.lang.Class<com.umeng.commonsdk.utils.UMUtils> r10 = com.umeng.commonsdk.utils.UMUtils.class
            java.lang.String r11 = com.umeng.commonsdk.utils.UMUtils.UNKNOW     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "getUMId"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x0088 }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r4[r1] = r5     // Catch:{ all -> 0x0088 }
            java.lang.reflect.Method r10 = r10.getMethod(r11, r4)     // Catch:{ all -> 0x0088 }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ all -> 0x0088 }
            r11[r1] = r9     // Catch:{ all -> 0x0088 }
            java.lang.Object r9 = r10.invoke(r3, r11)     // Catch:{ all -> 0x0088 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0088 }
            r7.f13279r = r9     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x009b }
        L_0x008c:
            boolean r9 = com.taobao.accs.utl.UtilityImpl.j()     // Catch:{ all -> 0x00cd }
            r7.f13280s = r9     // Catch:{ all -> 0x00cd }
            if (r9 == 0) goto L_0x00cd
            java.lang.String r9 = com.taobao.accs.utl.UtilityImpl.k()     // Catch:{ all -> 0x00cd }
            r7.f13281t = r9     // Catch:{ all -> 0x00cd }
            goto L_0x00cd
        L_0x009b:
            r9 = move-exception
            goto L_0x00be
        L_0x009d:
            java.lang.String r9 = "buildRegister param null"
            r11 = 6
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = "appKey"
            r11[r1] = r5     // Catch:{ all -> 0x00bc }
            r11[r2] = r10     // Catch:{ all -> 0x00bc }
            java.lang.String r10 = "utdid"
            r5 = 2
            r11[r5] = r10     // Catch:{ all -> 0x00bc }
            r10 = 3
            r11[r10] = r4     // Catch:{ all -> 0x00bc }
            java.lang.String r10 = "appVersion"
            r4 = 4
            r11[r4] = r10     // Catch:{ all -> 0x00bc }
            r10 = 5
            r11[r10] = r6     // Catch:{ all -> 0x00bc }
            com.taobao.accs.utl.ALog.e(r0, r9, r11)     // Catch:{ all -> 0x00bc }
            return r3
        L_0x00bc:
            r9 = move-exception
            r7 = r3
        L_0x00be:
            java.lang.String r10 = "buildRegister"
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d2 }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00d2 }
            r11[r1] = r9     // Catch:{ all -> 0x00d2 }
            com.taobao.accs.utl.ALog.w(r0, r10, r11)     // Catch:{ all -> 0x00d2 }
            if (r7 == 0) goto L_0x00d1
        L_0x00cd:
            byte[] r3 = r7.a()
        L_0x00d1:
            return r3
        L_0x00d2:
            r9 = move-exception
            if (r7 == 0) goto L_0x00d8
            r7.a()
        L_0x00d8:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.a.a.c.a(android.content.Context, java.lang.String, java.lang.String):byte[]");
    }
}
