package com.efs.sdk.base.core.a;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.core.util.secure.a;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    String f5124a;

    /* renamed from: b  reason: collision with root package name */
    String f5125b;

    /* renamed from: c  reason: collision with root package name */
    String f5126c;

    /* renamed from: d  reason: collision with root package name */
    public String f5127d;

    /* renamed from: e  reason: collision with root package name */
    public int f5128e;

    /* renamed from: f  reason: collision with root package name */
    public String f5129f;

    /* renamed from: g  reason: collision with root package name */
    public byte f5130g;

    /* renamed from: h  reason: collision with root package name */
    public String f5131h;

    /* renamed from: i  reason: collision with root package name */
    String f5132i;

    /* renamed from: j  reason: collision with root package name */
    String f5133j;

    /* renamed from: k  reason: collision with root package name */
    String f5134k;

    /* renamed from: l  reason: collision with root package name */
    String f5135l;

    /* renamed from: m  reason: collision with root package name */
    String f5136m = "";

    /* renamed from: n  reason: collision with root package name */
    String f5137n = "";

    /* renamed from: o  reason: collision with root package name */
    public long f5138o = 0;

    public static c a() {
        c cVar = new c();
        cVar.f5124a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.f5125b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.f5135l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.f5136m = ControllerCenter.getGlobalEnvStruct().getLogUid();
        cVar.f5137n = ControllerCenter.getGlobalEnvStruct().getLogDid();
        cVar.f5133j = BuildConfig.VERSION_NAME;
        cVar.f5126c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.f5132i = String.valueOf(b.a().f5225d.mConfigVersion);
        cVar.f5134k = EfsConstant.UM_SDK_VERSION;
        return cVar;
    }

    public final String b() {
        a.a();
        String valueOf = String.valueOf(a.b() / 1000);
        String base64EncodeToStr = EncodeUtil.base64EncodeToStr(a.a(this.f5135l + valueOf, this.f5125b));
        String base64EncodeToStr2 = EncodeUtil.base64EncodeToStr(a.a(EncodeUtil.base64DecodeToStr(this.f5136m.getBytes()) + "_" + valueOf, this.f5125b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.f5124a);
        treeMap.put(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_DESCRIPTION, base64EncodeToStr);
        treeMap.put("logud", base64EncodeToStr2);
        String a10 = a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        if (!TextUtils.isEmpty(a10)) {
            String base64EncodeToStr3 = EncodeUtil.base64EncodeToStr(a.a(a10 + "_" + valueOf, this.f5125b));
            treeMap.put("wl_dd", base64EncodeToStr3);
            treeMap.put("logdd", base64EncodeToStr3);
        }
        if (!TextUtils.isEmpty(this.f5127d)) {
            treeMap.put("cp", this.f5127d);
        }
        if (this.f5130g != 0) {
            treeMap.put("de", String.valueOf(this.f5128e));
            treeMap.put("type", this.f5131h);
            String str = this.f5129f;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long b10 = a.b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", new Object[]{Long.valueOf(b10), Integer.valueOf(new Random(b10).nextInt(10000))});
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.f5132i);
        treeMap.put("os", "android");
        treeMap.put("sver", this.f5132i);
        treeMap.put("tm", valueOf);
        treeMap.put(BrowserInfo.KEY_VER, this.f5126c);
        treeMap.put("um_sdk_ver", this.f5134k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + Operator.Operation.EQUALS + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        String md5 = EncodeUtil.md5(sb2.toString() + this.f5125b);
        sb.append("sign=");
        sb.append(md5);
        Log.d("efs.config", sb.toString());
        return EncodeUtil.urlEncode(sb.toString());
    }

    private static String a(Context context) {
        Method method;
        if (context == null) {
            return null;
        }
        Class<UMConfigure> cls = UMConfigure.class;
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", new Class[]{Context.class});
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke((Object) null, new Object[]{context});
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }
}
