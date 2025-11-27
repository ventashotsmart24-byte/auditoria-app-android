package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

public class GlobalInfoManager {

    /* renamed from: a  reason: collision with root package name */
    private GlobalInfo f5213a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5214b;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final GlobalInfoManager f5215a = new GlobalInfoManager((byte) 0);
    }

    public /* synthetic */ GlobalInfoManager(byte b10) {
        this();
    }

    private static String a(Context context) {
        Method method;
        if (context == null) {
            return null;
        }
        Class<DeviceConfig> cls = DeviceConfig.class;
        try {
            String str = DeviceConfig.UNKNOW;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", new Class[]{Context.class});
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

    public static GlobalInfoManager getInstance() {
        return a.f5215a;
    }

    public GlobalInfo getGlobalInfo() {
        try {
            String a10 = a(this.f5214b);
            if (!TextUtils.isEmpty(a10)) {
                this.f5213a.a(UMCrash.KEY_CALLBACK_SESSION_ID, a10);
            }
        } catch (Throwable th) {
            Log.d("efs.info.manager", "refreshSessionId caused error: " + th.getMessage());
        }
        return this.f5213a;
    }

    public String getNetStatus() {
        return this.f5213a.b("net", NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }

    public void initGlobalInfo() {
        String str;
        Log.e("ballack", "initGlobalInfo called once.");
        GlobalInfo globalInfo = new GlobalInfo();
        this.f5213a = globalInfo;
        globalInfo.a(ParamsMap.DeviceParams.KEY_APPID, ControllerCenter.getGlobalEnvStruct().getAppid());
        int myPid = ProcessUtil.myPid();
        this.f5213a.a("pid", Integer.valueOf(myPid));
        this.f5213a.a("ps", ProcessUtil.getProcessName(myPid));
        String a10 = c.a(this.f5214b);
        this.f5213a.a("wid", a10);
        if (TextUtils.isEmpty(ControllerCenter.getGlobalEnvStruct().getUid())) {
            this.f5213a.a(ParamsMap.DeviceParams.KEY_UID, a10);
        } else {
            this.f5213a.a(ParamsMap.DeviceParams.KEY_UID, ControllerCenter.getGlobalEnvStruct().getUid());
        }
        GlobalInfo globalInfo2 = this.f5213a;
        com.efs.sdk.base.core.a.a.a();
        globalInfo2.a("stime", Long.valueOf(com.efs.sdk.base.core.a.a.b() - Process.getElapsedCpuTime()));
        this.f5213a.a("pkg", PackageUtil.getPackageName(this.f5214b));
        this.f5213a.a(BrowserInfo.KEY_VER, PackageUtil.getAppVersionName(this.f5214b));
        this.f5213a.a("vcode", PackageUtil.getAppVersionCode(this.f5214b));
        this.f5213a.a("sdk_ver", BuildConfig.VERSION_NAME);
        this.f5213a.a(Constants.KEY_BRAND, Build.BRAND.toLowerCase());
        GlobalInfo globalInfo3 = this.f5213a;
        String str2 = Build.MODEL;
        if (str2 == null) {
            str = "unknown";
        } else {
            str = str2.replace(" ", Operator.Operation.MINUS).replace("_", Operator.Operation.MINUS).toLowerCase();
        }
        globalInfo3.a(Constants.KEY_MODEL, str);
        this.f5213a.a("build_model", str2);
        DisplayMetrics displayMetrics = this.f5214b.getResources().getDisplayMetrics();
        this.f5213a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
        this.f5213a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
        this.f5213a.a("fr", "android");
        this.f5213a.a("rom", Build.VERSION.RELEASE);
        this.f5213a.a(com.umeng.ccg.a.f14528u, Integer.valueOf(Build.VERSION.SDK_INT));
        this.f5213a.a("lang", Locale.getDefault().getLanguage());
        this.f5213a.a("tzone", TimeZone.getDefault().getID());
        this.f5213a.a("net", NetworkUtil.getNetworkType(this.f5214b));
        try {
            String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(this.f5214b);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                this.f5213a.a(UMCrash.KEY_HEADER_ACCESS, "wifi");
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                this.f5213a.a(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
            } else {
                this.f5213a.a(UMCrash.KEY_HEADER_ACCESS, "unknow");
            }
            if (!"".equals(networkAccessMode[1])) {
                this.f5213a.a(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
            }
            this.f5213a.a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(this.f5214b)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.f5213a.a("log_uid", EncodeUtil.base64DecodeToStr(ControllerCenter.getGlobalEnvStruct().getLogUid().getBytes()));
            this.f5213a.a("log_did", ControllerCenter.getGlobalEnvStruct().getLogDid());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void refreshNetStatus() {
        String networkType = NetworkUtil.getNetworkType(ControllerCenter.getGlobalEnvStruct().mAppContext);
        Log.w("efs.info.manager", "network change: ".concat(String.valueOf(networkType)));
        this.f5213a.a("net", networkType);
    }

    private GlobalInfoManager() {
        this.f5214b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }
}
