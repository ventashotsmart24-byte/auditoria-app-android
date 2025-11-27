package com.umeng.commonsdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.hpplay.component.common.ParamsMap;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.ccg.b;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMLogCommon;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.TagHelper;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.c;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class UMConfigure {
    public static MobclickAgent.PageMode AUTO_ACTIVITY_PAGE_COLLECTION = MobclickAgent.PageMode.AUTO;
    private static final String[] BUSINESS_TYPE = {"apm", "push", "share", "ulink", "uverify", "usms", "urec", "abtest", ParamsMap.MirrorParams.MIRROR_GAME_MODE, bt.al};
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static Object PreInitLock = new Object();
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog = false;
    private static volatile long initCompleteTs = 0;
    private static boolean isFinish = false;
    public static boolean isInit = false;
    private static Object lock = new Object();
    private static Object lockObject = new Object();
    /* access modifiers changed from: private */
    public static OnGetOaidListener mOnGetOaidListener;
    private static int policyGrantInvokedFlag = 0;
    private static int policyGrantResult = 0;
    private static boolean preInitComplete = false;
    private static int preInitInvokedFlag = 0;
    public static String sAppkey = "";
    public static String sChannel = "";
    private static boolean shouldCheckShareSdk = true;
    private static volatile boolean shouldCollectAid = true;
    private static volatile boolean shouldCollectApl = true;
    private static volatile boolean shouldCollectIccid = true;
    private static volatile boolean shouldCollectImei = true;
    private static volatile boolean shouldCollectImsi = true;
    private static volatile boolean shouldCollectOaid = true;
    private static volatile boolean shouldCollectWiFiMac = true;
    private static volatile boolean shouldOutputRT = false;
    public static UMLog umDebugLog = new UMLog();

    public enum BS_TYPE {
        APM,
        PUSH,
        SHARE,
        ULINK,
        UVERIFY,
        USMS,
        UREC,
        ABTEST,
        GAME,
        ZID
    }

    private static boolean checkShareSdk(Class<?> cls) {
        try {
            if (cls.getDeclaredField("isZyb") != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void deleteModuleTag(BS_TYPE bs_type, String str) {
        if (bs_type == null) {
            Log.e("UMLog", UMLogCommon.SC_10025);
        } else if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", UMLogCommon.SC_10020);
        } else {
            try {
                if (str.trim().getBytes().length > 64) {
                    Log.e("UMLog", UMLogCommon.SC_10021);
                    return;
                }
                int ordinal = bs_type.ordinal();
                String str2 = "";
                String[] strArr = BUSINESS_TYPE;
                if (ordinal < strArr.length) {
                    str2 = strArr[ordinal];
                }
                if (TextUtils.isEmpty(str2)) {
                    Log.e("UMLog", UMLogCommon.SC_10022);
                    return;
                }
                TagHelper.deleteModuleTag(str2 + "_" + str);
            } catch (Throwable unused) {
            }
        }
    }

    private static void disableAidCollect() {
        try {
            Class<?> cls = getClass("com.umeng.socialize.UMShareAPI");
            Class<?> cls2 = getClass("com.uyumao.nns.zmd.ZmdManager");
            if (cls != null || cls2 != null) {
                shouldCollectAid = false;
            }
        } catch (Throwable unused) {
        }
    }

    private static void disableOaidCollect() {
        try {
            if (getClass("com.uyumao.nns.zmd.ZmdManager") != null) {
                shouldCollectOaid = false;
            }
        } catch (Throwable unused) {
        }
    }

    public static void enableAplCollection(boolean z10) {
        shouldCollectApl = z10;
    }

    public static void enableAzxSwitch(boolean z10) {
        b.a(z10);
    }

    public static void enableIccidCollection(boolean z10) {
        shouldCollectIccid = z10;
    }

    public static void enableImeiCollection(boolean z10) {
        shouldCollectImei = z10;
    }

    public static void enableImsiCollection(boolean z10) {
        shouldCollectImsi = z10;
    }

    public static void enableUmcCfgSwitch(boolean z10) {
        b.b(z10);
    }

    public static void enableWiFiMacCollection(boolean z10) {
        shouldCollectWiFiMac = z10;
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static String getCurrentActivityName() {
        return PageNameMonitor.getInstance().getCurrentActivityName();
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        Constructor<?> constructor;
        if (cls == null) {
            return null;
        }
        try {
            constructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException unused) {
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        constructor.setAccessible(true);
        try {
            return constructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
            return null;
        }
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    public static long getInitCompleteTs() {
        return initCompleteTs;
    }

    public static boolean getInitStatus() {
        boolean z10;
        synchronized (lockObject) {
            z10 = isFinish;
        }
        return z10;
    }

    private static Map<String, String> getModuleTags() {
        try {
            return TagHelper.getModuleTags();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            mOnGetOaidListener = onGetOaidListener;
            if (!shouldCollectOaid) {
                OnGetOaidListener onGetOaidListener2 = mOnGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid((String) null);
                    return;
                }
                return;
            }
            new Thread(new Runnable() {
                public void run() {
                    String b10 = bf.b(applicationContext);
                    if (UMConfigure.mOnGetOaidListener != null) {
                        UMConfigure.mOnGetOaidListener.onGetOaid(b10);
                    }
                }
            }).start();
        } else if (debugLog) {
            Log.e(TAG, "context is null !!!");
        }
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        if (context != null) {
            return UMUtils.getUMId(context.getApplicationContext());
        }
        return null;
    }

    public static String getUmengZID(Context context) {
        if (context != null) {
            return UMUtils.getZid(context.getApplicationContext());
        }
        return null;
    }

    private static void ignoreSdkCheck(Context context) {
        shouldCheckShareSdk = false;
    }

    public static void init(Context context, int i10, String str) {
        init(context, (String) null, (String) null, i10, str);
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method != null && obj != null) {
            try {
                method.invoke(obj, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static Boolean isInForeground() {
        return Boolean.valueOf(com.umeng.analytics.vshelper.b.d());
    }

    private static boolean isPreInit() {
        boolean z10;
        synchronized (PreInitLock) {
            z10 = preInitComplete;
        }
        return z10;
    }

    private static boolean isSilentMode() {
        boolean a10 = c.a();
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> isSilentMode() return: " + a10);
        return a10;
    }

    private static boolean needCheckPolicyResult(Context context) {
        File filesDir = context.getFilesDir();
        if (new File(filesDir.getAbsolutePath() + File.separator + bx.f13997m).exists()) {
            return false;
        }
        return true;
    }

    public static boolean needSendZcfgEnv(Context context) {
        File filesDir = context.getFilesDir();
        if (new File(filesDir.getAbsolutePath() + File.separator + bx.f13996l).exists()) {
            return false;
        }
        return true;
    }

    public static void onActEvent(String str, String str2, Bundle bundle) {
        CcgAgent.onActUpEvent(str, str2, bundle);
    }

    public static void preInit(Context context, String str, String str2) {
        synchronized (lock) {
            preInitInvokedFlag = 1;
        }
        preInitInternal(context, str, str2);
    }

    private static void preInitInternal(Context context, String str, String str2) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if ("1".equals(UMUtils.getSystemProperty("debug.umeng.rtlog", "0"))) {
                shouldOutputRT = true;
            }
            if (TextUtils.isEmpty(str)) {
                str = UMUtils.getAppkeyByXML(applicationContext);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = UMUtils.getChannelByXML(applicationContext);
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "Unknown";
            }
            if (!TextUtils.isEmpty(str)) {
                sAppkey = str;
                sChannel = str2;
                UMGlobalContext.getInstance(applicationContext);
                n.a(applicationContext);
                if (!needSendZcfgEnv(applicationContext)) {
                    FieldManager.a().a(applicationContext);
                }
                synchronized (PreInitLock) {
                    preInitComplete = true;
                }
                boolean a10 = c.a();
                if (debugLog && a10) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 当前处于静默模式!");
                }
            }
        } else if (debugLog) {
            Log.e(TAG, "preInit: context is null, pls check!");
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        CcgAgent.registerActionInfo(actionInfo);
    }

    public static void resetStorePath() {
        resetStorePrefix("um_");
    }

    public static void resetStorePrefix(String str) {
        bd.b().a(str);
    }

    private static void setCheckDevice(boolean z10) {
        AnalyticsConstants.CHECK_DEVICE = z10;
    }

    public static void setDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("UMLog", "setDomain: Parameter domain is null or empty string, do nothing.");
            return;
        }
        UMServerURL.DEFAULT_URL = str;
        UMServerURL.SECONDARY_URL = str;
    }

    public static void setEncryptEnabled(boolean z10) {
        com.umeng.commonsdk.statistics.b.a(z10);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j10) {
        a.f14875c = ((int) j10) * 1000;
    }

    public static void setLogEnabled(boolean z10) {
        try {
            debugLog = z10;
            MLog.DEBUG = z10;
            Class<?> cls = getClass("com.umeng.message.PushAgent");
            Object decInstanceObject = getDecInstanceObject(cls);
            Class cls2 = Boolean.TYPE;
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{cls2}), decInstanceObject, new Object[]{Boolean.valueOf(z10)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z10);
            invoke(getDecMethod(getClass("com.umeng.umcrash.UMCrash"), "setDebug", new Class[]{cls2}), new Object[]{Boolean.valueOf(z10)});
        } catch (Exception e10) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + e10);
            }
        } catch (Throwable th) {
            if (debugLog) {
                Log.e(TAG, "set log enabled e is " + th);
            }
        }
    }

    private static void setModuleTag(BS_TYPE bs_type, String str, String str2) {
        if (bs_type == null) {
            try {
                Log.e("UMLog", UMLogCommon.SC_10024);
            } catch (Throwable unused) {
            }
        } else {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    if (str.trim().getBytes().length > 64) {
                        Log.e("UMLog", UMLogCommon.SC_10017);
                        return;
                    } else if (str2.trim().getBytes().length > 128) {
                        Log.e("UMLog", UMLogCommon.SC_10018);
                        return;
                    } else {
                        int ordinal = bs_type.ordinal();
                        String str3 = "";
                        String[] strArr = BUSINESS_TYPE;
                        if (ordinal < strArr.length) {
                            str3 = strArr[ordinal];
                        }
                        if (TextUtils.isEmpty(str3)) {
                            Log.e("UMLog", UMLogCommon.SC_10019);
                            return;
                        }
                        TagHelper.setModuleTag(str3 + "_" + str, str2);
                        return;
                    }
                }
            }
            Log.e("UMLog", UMLogCommon.SC_10016);
        }
    }

    public static void setProcessEvent(boolean z10) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z10;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(WRAPER_TYPE_NATIVE)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_NATIVE;
                a.f14873a = WRAPER_TYPE_NATIVE;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_COCOS2DX_X;
                a.f14873a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_COCOS2DX_XLUA;
                a.f14873a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_UNITY;
                a.f14873a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_REACTNATIVE;
                a.f14873a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_PHONEGAP;
                a.f14873a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_WEEX;
                a.f14873a = WRAPER_TYPE_WEEX;
            } else if (str.equals(WRAPER_TYPE_HYBRID)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_HYBRID;
                a.f14873a = WRAPER_TYPE_HYBRID;
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.f14844a = WRAPER_TYPE_FLUTTER;
                a.f14873a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.umeng.commonsdk.stateless.a.f14845b = str2;
            a.f14874b = str2;
        }
    }

    public static boolean shouldCollectAid() {
        return shouldCollectAid;
    }

    public static boolean shouldCollectApl() {
        return shouldCollectApl;
    }

    public static boolean shouldCollectIccid() {
        return shouldCollectIccid;
    }

    public static boolean shouldCollectImei() {
        return shouldCollectImei;
    }

    public static boolean shouldCollectImsi() {
        return shouldCollectImsi;
    }

    public static boolean shouldCollectOaid() {
        return shouldCollectOaid;
    }

    public static boolean shouldCollectWifiMac() {
        return shouldCollectWiFiMac;
    }

    public static boolean shouldOutput() {
        return shouldOutputRT;
    }

    public static void submitPolicyGrantResult(Context context, boolean z10) {
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.B, com.umeng.commonsdk.internal.b.a(context).a(), (Object) null);
        synchronized (lock) {
            policyGrantInvokedFlag = 1;
            if (z10) {
                policyGrantResult = 1;
            } else {
                policyGrantResult = 2;
            }
        }
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f14775z, com.umeng.commonsdk.internal.b.a(context).a(), Integer.valueOf(policyGrantResult));
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:201:0x0423 */
    public static void init(android.content.Context r10, java.lang.String r11, java.lang.String r12, int r13, java.lang.String r14) {
        /*
            r0 = 0
            r1 = 2
            r2 = 0
            r3 = 1
            boolean r4 = debugLog     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r4 == 0) goto L_0x0017
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r4.<init>()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r5 = "common type is "
            r4.append(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            int r5 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r4.append(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0017:
            if (r10 != 0) goto L_0x0025
            boolean r11 = debugLog     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0024
            java.lang.String r11 = "UMConfigure"
            java.lang.String r12 = "context is null !!!"
            android.util.Log.e(r11, r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0024:
            return
        L_0x0025:
            boolean r4 = isInit     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r4 == 0) goto L_0x0035
            boolean r11 = debugLog     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0034
            java.lang.String r11 = "UMConfigure"
            java.lang.String r12 = "has inited !!!"
            android.util.Log.e(r11, r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0034:
            return
        L_0x0035:
            android.content.Context r4 = r10.getApplicationContext()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.service.UMGlobalContext.getInstance(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r5 = com.umeng.commonsdk.utils.c.a()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r5 == 0) goto L_0x0061
            boolean r13 = isPreInit()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r13 != 0) goto L_0x0052
            preInitInternal(r4, r11, r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r11 = isPreInit()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 != 0) goto L_0x0052
            return
        L_0x0052:
            com.umeng.commonsdk.internal.b r11 = com.umeng.commonsdk.internal.b.a(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.internal.c r11 = r11.a()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r12 = 32802(0x8022, float:4.5965E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r4, r12, r11, r0)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            return
        L_0x0061:
            java.lang.String r5 = "com.umeng.umzid.ZIDManager"
            java.lang.Class r5 = getClass(r5)     // Catch:{ all -> 0x0079 }
            if (r5 != 0) goto L_0x0079
            java.lang.String r5 = "UMConfigure"
            java.lang.String r6 = "--->>> SDK 初始化失败，请检查是否集成umeng-asms-1.2.x.aar库。<<<--- "
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x0079 }
            com.umeng.commonsdk.UMConfigure$1 r5 = new com.umeng.commonsdk.UMConfigure$1     // Catch:{ all -> 0x0079 }
            r5.<init>(r4)     // Catch:{ all -> 0x0079 }
            r5.start()     // Catch:{ all -> 0x0079 }
            return
        L_0x0079:
            java.lang.String r5 = "com.umeng.message.PushAgent"
            java.lang.Class r5 = getClass(r5)     // Catch:{ all -> 0x009a }
            if (r5 == 0) goto L_0x009a
            boolean r5 = checkShareSdk(r5)     // Catch:{ all -> 0x009a }
            if (r5 != 0) goto L_0x009a
            java.lang.String r5 = "UMLog"
            java.lang.String r6 = "基础组件库9.3.x版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。"
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x009a }
            boolean r5 = shouldCheckShareSdk     // Catch:{ all -> 0x009a }
            if (r5 == 0) goto L_0x009a
            com.umeng.commonsdk.UMConfigure$2 r5 = new com.umeng.commonsdk.UMConfigure$2     // Catch:{ all -> 0x009a }
            r5.<init>(r4)     // Catch:{ all -> 0x009a }
            r5.start()     // Catch:{ all -> 0x009a }
        L_0x009a:
            java.lang.String r5 = "com.umeng.socialize.UMShareAPI"
            java.lang.Class r5 = getClass(r5)     // Catch:{ all -> 0x00bb }
            if (r5 == 0) goto L_0x00bb
            boolean r5 = checkShareSdk(r5)     // Catch:{ all -> 0x00bb }
            if (r5 != 0) goto L_0x00bb
            java.lang.String r5 = "UMLog"
            java.lang.String r6 = "基础组件库9.3.x版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。"
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x00bb }
            boolean r5 = shouldCheckShareSdk     // Catch:{ all -> 0x00bb }
            if (r5 == 0) goto L_0x00bb
            com.umeng.commonsdk.UMConfigure$3 r5 = new com.umeng.commonsdk.UMConfigure$3     // Catch:{ all -> 0x00bb }
            r5.<init>(r4)     // Catch:{ all -> 0x00bb }
            r5.start()     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            boolean r5 = isPreInit()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r5 != 0) goto L_0x00cb
            preInitInternal(r4, r11, r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r11 = isPreInit()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 != 0) goto L_0x00cb
            return
        L_0x00cb:
            com.umeng.commonsdk.framework.UMEnvelopeBuild.registerNetReceiver(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r11 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.utils.UMUtils.setAppkey(r4, r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r11 = com.umeng.commonsdk.utils.UMUtils.getLastAppkey(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r12 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r12 != 0) goto L_0x00fd
            java.lang.String r12 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r12 = r12.equals(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r12 != 0) goto L_0x00fd
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r12 != 0) goto L_0x00f8
            boolean r12 = debugLog     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r12 == 0) goto L_0x00f8
            java.lang.String r12 = "AppKey改变!!!"
            java.lang.String r5 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r12, (int) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x00f8:
            java.lang.String r12 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.utils.UMUtils.setLastAppkey(r4, r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x00fd:
            boolean r12 = debugLog     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r12 == 0) goto L_0x0118
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r12.<init>()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r5 = "current appkey is "
            r12.append(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r5 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r12.append(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r5 = ", last appkey is "
            r12.append(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r12.append(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0118:
            boolean r11 = debugLog     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r12 = 3
            if (r11 == 0) goto L_0x0150
            java.lang.String r11 = com.umeng.commonsdk.utils.UMUtils.getAppkeyByXML(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r5 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r5 != 0) goto L_0x0150
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r5 != 0) goto L_0x0150
            java.lang.String r5 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r5 = r5.equals(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r5 != 0) goto L_0x0150
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r6 = "@"
            r5[r2] = r6     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r6 = "#"
            r5[r3] = r6     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r7 = sAppkey     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r6[r2] = r7     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r6[r3] = r11     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r11 = "请注意：您init接口中设置的AppKey是@，manifest中设置的AppKey是#，init接口设置的AppKey会覆盖manifest中设置的AppKey"
            java.lang.String r7 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo(r11, r12, r7, r5, r6)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0150:
            java.lang.String r11 = sChannel     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.utils.UMUtils.setChannel(r4, r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r11 = debugLog     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0168
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r11.<init>()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r5 = "channel is "
            r11.append(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r5 = sChannel     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r11.append(r5)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0168:
            java.lang.Class<com.umeng.analytics.MobclickAgent> r11 = com.umeng.analytics.MobclickAgent.class
            java.lang.String r5 = "init"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ all -> 0x01e6 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r2] = r7     // Catch:{ all -> 0x01e6 }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x01e6 }
            if (r5 == 0) goto L_0x01ab
            r5.setAccessible(r3)     // Catch:{ all -> 0x01e6 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x01e6 }
            r6[r2] = r4     // Catch:{ all -> 0x01e6 }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x01e6 }
            java.lang.String r5 = "header_first_resume"
            boolean r5 = com.umeng.commonsdk.config.FieldManager.allow(r5)     // Catch:{ all -> 0x01e6 }
            if (r5 == 0) goto L_0x0199
            java.lang.String r5 = "MobclickRT"
            java.lang.String r6 = "--->>> FirstResumeTrigger enabled."
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r6)     // Catch:{ all -> 0x01e6 }
            com.umeng.analytics.pro.n r5 = com.umeng.analytics.pro.n.a((android.content.Context) r4)     // Catch:{ all -> 0x01e6 }
            r5.b((android.content.Context) r4)     // Catch:{ all -> 0x01e6 }
            goto L_0x01a0
        L_0x0199:
            java.lang.String r5 = "MobclickRT"
            java.lang.String r6 = "--->>> FirstResumeTrigger disabled."
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r6)     // Catch:{ all -> 0x01e6 }
        L_0x01a0:
            boolean r5 = debugLog     // Catch:{ all -> 0x01e6 }
            if (r5 == 0) goto L_0x01ab
            java.lang.String r5 = "统计SDK初始化成功"
            java.lang.String r6 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r5, (int) r1, (java.lang.String) r6)     // Catch:{ all -> 0x01e6 }
        L_0x01ab:
            java.lang.String r5 = "com.umeng.analytics.game.UMGameAgent"
            java.lang.Class.forName(r5)     // Catch:{ all -> 0x01e6 }
            java.lang.String r5 = "setGameScenarioType"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ all -> 0x01e6 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r2] = r7     // Catch:{ all -> 0x01e6 }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x01e6 }
            if (r5 == 0) goto L_0x01c8
            r5.setAccessible(r3)     // Catch:{ all -> 0x01e6 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x01e6 }
            r6[r2] = r4     // Catch:{ all -> 0x01e6 }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x01e6 }
        L_0x01c8:
            java.lang.String r11 = com.umeng.commonsdk.statistics.b.f14876a     // Catch:{ all -> 0x01e6 }
            java.lang.String r5 = "e"
            int r11 = r11.indexOf(r5)     // Catch:{ all -> 0x01e6 }
            if (r11 < 0) goto L_0x01e6
            java.lang.Class<com.umeng.analytics.MobclickAgent> r11 = com.umeng.analytics.MobclickAgent.class
            java.lang.String r5 = "disableExceptionCatch"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x01e6 }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x01e6 }
            if (r5 == 0) goto L_0x01e6
            r5.setAccessible(r3)     // Catch:{ all -> 0x01e6 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x01e6 }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x01e6 }
        L_0x01e6:
            java.lang.Class<com.umeng.message.PushAgent> r11 = com.umeng.message.PushAgent.class
            int r5 = com.umeng.message.PushAgent.f6187a     // Catch:{ all -> 0x0202 }
            java.lang.String r5 = "init"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ all -> 0x0202 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r2] = r7     // Catch:{ all -> 0x0202 }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x0202 }
            if (r5 == 0) goto L_0x0202
            r5.setAccessible(r3)     // Catch:{ all -> 0x0202 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x0202 }
            r6[r2] = r4     // Catch:{ all -> 0x0202 }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x0202 }
        L_0x0202:
            java.lang.Class<com.umeng.message.MessageSharedPrefs> r11 = com.umeng.message.MessageSharedPrefs.class
            java.lang.String r5 = "getInstance"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r2] = r7     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r5 == 0) goto L_0x02a1
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r6[r2] = r4     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Object r5 = r5.invoke(r11, r6)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r5 == 0) goto L_0x02a1
            java.lang.String r6 = "setMessageAppKey"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r2] = r8     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.reflect.Method r6 = r11.getDeclaredMethod(r6, r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r6 == 0) goto L_0x0241
            r6.setAccessible(r3)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.String r8 = sAppkey     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r7[r2] = r8     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r6.invoke(r5, r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            boolean r6 = debugLog     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r6 == 0) goto L_0x0241
            java.lang.String r6 = "PUSH AppKey设置成功"
            java.lang.String r7 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r6, (int) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
        L_0x0241:
            java.lang.String r6 = "setMessageChannel"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r2] = r8     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.reflect.Method r6 = r11.getDeclaredMethod(r6, r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r6 == 0) goto L_0x0266
            r6.setAccessible(r3)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.String r8 = sChannel     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r7[r2] = r8     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r6.invoke(r5, r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            boolean r6 = debugLog     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r6 == 0) goto L_0x0266
            java.lang.String r6 = "PUSH Channel设置成功"
            java.lang.String r7 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r6, (int) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
        L_0x0266:
            boolean r6 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r6 == 0) goto L_0x026d
            goto L_0x02a1
        L_0x026d:
            boolean r6 = debugLog     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r6 == 0) goto L_0x027e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r6.<init>()     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.String r7 = "push secret is "
            r6.append(r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r6.append(r14)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
        L_0x027e:
            java.lang.String r6 = "setMessageAppSecret"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r2] = r8     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.reflect.Method r11 = r11.getDeclaredMethod(r6, r7)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r11 == 0) goto L_0x02a1
            r11.setAccessible(r3)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r6[r2] = r14     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            r11.invoke(r5, r6)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            boolean r11 = debugLog     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
            if (r11 == 0) goto L_0x02a1
            java.lang.String r11 = "PUSH Secret设置成功"
            java.lang.String r5 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r11, (int) r1, (java.lang.String) r5)     // Catch:{ Exception -> 0x02a1, all -> 0x047d }
        L_0x02a1:
            java.lang.String r11 = "com.umeng.socialize.UMShareAPI"
            java.lang.Class r11 = getClass(r11)     // Catch:{ all -> 0x02db }
            java.lang.String r5 = "APPKEY"
            java.lang.String r6 = sAppkey     // Catch:{ all -> 0x02db }
            setFile((java.lang.Class<?>) r11, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x02db }
            if (r11 == 0) goto L_0x02db
            java.lang.String r5 = "init"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ all -> 0x02db }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r2] = r7     // Catch:{ all -> 0x02db }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r3] = r7     // Catch:{ all -> 0x02db }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x02db }
            if (r5 == 0) goto L_0x02db
            r5.setAccessible(r3)     // Catch:{ all -> 0x02db }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x02db }
            r6[r2] = r4     // Catch:{ all -> 0x02db }
            java.lang.String r7 = sAppkey     // Catch:{ all -> 0x02db }
            r6[r3] = r7     // Catch:{ all -> 0x02db }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x02db }
            boolean r11 = debugLog     // Catch:{ all -> 0x02db }
            if (r11 == 0) goto L_0x02db
            java.lang.String r11 = "Share AppKey设置成功"
            java.lang.String r5 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r11, (int) r1, (java.lang.String) r5)     // Catch:{ all -> 0x02db }
        L_0x02db:
            com.umeng.commonsdk.statistics.AnalyticsConstants.setDeviceType(r13)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            java.lang.String r11 = "com.umeng.error.UMError"
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x0307 }
            java.lang.String r5 = "init"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ all -> 0x0307 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r2] = r7     // Catch:{ all -> 0x0307 }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x0307 }
            if (r5 == 0) goto L_0x0307
            r5.setAccessible(r3)     // Catch:{ all -> 0x0307 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x0307 }
            r6[r2] = r4     // Catch:{ all -> 0x0307 }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x0307 }
            boolean r11 = debugLog     // Catch:{ all -> 0x0307 }
            if (r11 == 0) goto L_0x0307
            java.lang.String r11 = "错误分析SDK初始化成功"
            java.lang.String r5 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r11, (int) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0307 }
        L_0x0307:
            java.lang.String r11 = "com.umeng.umefs.UMEfs"
            java.lang.Class r11 = getClass(r11)     // Catch:{ all -> 0x0368 }
            if (r11 != 0) goto L_0x0368
            java.lang.String r11 = "com.umeng.umcrash.UMCrash"
            java.lang.Class r11 = getClass(r11)     // Catch:{ all -> 0x0368 }
            if (r11 == 0) goto L_0x0368
            int r5 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE     // Catch:{ all -> 0x0368 }
            if (r5 != r3) goto L_0x0335
            java.lang.String r5 = "useIntlServices"
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ all -> 0x0368 }
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0368 }
            r6[r2] = r7     // Catch:{ all -> 0x0368 }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x0368 }
            if (r5 == 0) goto L_0x0335
            r5.setAccessible(r3)     // Catch:{ all -> 0x0368 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x0368 }
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0368 }
            r6[r2] = r7     // Catch:{ all -> 0x0368 }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x0368 }
        L_0x0335:
            java.lang.String r5 = "init"
            java.lang.Class[] r6 = new java.lang.Class[r12]     // Catch:{ all -> 0x0368 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r2] = r7     // Catch:{ all -> 0x0368 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r3] = r7     // Catch:{ all -> 0x0368 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r1] = r7     // Catch:{ all -> 0x0368 }
            java.lang.reflect.Method r5 = r11.getDeclaredMethod(r5, r6)     // Catch:{ all -> 0x0368 }
            if (r5 == 0) goto L_0x0368
            r5.setAccessible(r3)     // Catch:{ all -> 0x0368 }
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x0368 }
            r6[r2] = r4     // Catch:{ all -> 0x0368 }
            java.lang.String r7 = sAppkey     // Catch:{ all -> 0x0368 }
            r6[r3] = r7     // Catch:{ all -> 0x0368 }
            java.lang.String r7 = sChannel     // Catch:{ all -> 0x0368 }
            r6[r1] = r7     // Catch:{ all -> 0x0368 }
            r5.invoke(r11, r6)     // Catch:{ all -> 0x0368 }
            boolean r11 = debugLog     // Catch:{ all -> 0x0368 }
            if (r11 == 0) goto L_0x0368
            java.lang.String r11 = "APM SDK初始化成功"
            java.lang.String r5 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r11, (int) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0368 }
        L_0x0368:
            java.lang.String r11 = "com.umeng.vt.facade.EventFacade"
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.String r5 = "init"
            r6 = 5
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.Class<android.app.Application> r8 = android.app.Application.class
            r7[r2] = r8     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r3] = r8     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r1] = r8     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x03ac }
            r7[r12] = r8     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r9 = 4
            r7[r9] = r8     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.reflect.Method r11 = r11.getDeclaredMethod(r5, r7)     // Catch:{ ClassNotFoundException -> 0x03ac }
            if (r11 == 0) goto L_0x03ac
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x03ac }
            r5[r2] = r4     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.String r6 = sAppkey     // Catch:{ ClassNotFoundException -> 0x03ac }
            r5[r3] = r6     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.String r6 = sChannel     // Catch:{ ClassNotFoundException -> 0x03ac }
            r5[r1] = r6     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ ClassNotFoundException -> 0x03ac }
            r5[r12] = r13     // Catch:{ ClassNotFoundException -> 0x03ac }
            r5[r9] = r14     // Catch:{ ClassNotFoundException -> 0x03ac }
            r11.invoke(r0, r5)     // Catch:{ ClassNotFoundException -> 0x03ac }
            java.lang.String r11 = "MobclickRT"
            java.lang.String r12 = "--->>>初始化 EventFacade 成功."
            com.umeng.commonsdk.debug.UMRTLog.i(r11, r12)     // Catch:{ ClassNotFoundException -> 0x03ac }
        L_0x03ac:
            java.lang.String r11 = "com.umeng.vt.common.VTTracker"
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ ClassNotFoundException -> 0x03d6 }
            java.lang.String r12 = "init"
            java.lang.Class[] r13 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x03d6 }
            java.lang.Class<android.app.Application> r14 = android.app.Application.class
            r13[r2] = r14     // Catch:{ ClassNotFoundException -> 0x03d6 }
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            r13[r3] = r14     // Catch:{ ClassNotFoundException -> 0x03d6 }
            java.lang.reflect.Method r11 = r11.getDeclaredMethod(r12, r13)     // Catch:{ ClassNotFoundException -> 0x03d6 }
            if (r11 == 0) goto L_0x03d6
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x03d6 }
            r12[r2] = r4     // Catch:{ ClassNotFoundException -> 0x03d6 }
            java.lang.String r13 = sAppkey     // Catch:{ ClassNotFoundException -> 0x03d6 }
            r12[r3] = r13     // Catch:{ ClassNotFoundException -> 0x03d6 }
            r11.invoke(r0, r12)     // Catch:{ ClassNotFoundException -> 0x03d6 }
            java.lang.String r11 = "MobclickRT"
            java.lang.String r12 = "--->>>初始化 VTTracker 成功."
            com.umeng.commonsdk.debug.UMRTLog.i(r11, r12)     // Catch:{ ClassNotFoundException -> 0x03d6 }
        L_0x03d6:
            java.lang.Object r11 = lockObject     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            monitor-enter(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            isFinish = r3     // Catch:{ all -> 0x047a }
            monitor-exit(r11)     // Catch:{ all -> 0x047a }
            boolean r11 = needCheckPolicyResult(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0428
            java.lang.Object r11 = lock     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            monitor-enter(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            int r12 = preInitInvokedFlag     // Catch:{ all -> 0x0425 }
            if (r12 != 0) goto L_0x03f0
            java.lang.String r12 = "UMConfigure"
            java.lang.String r13 = "检测到SDK初始化过程遗漏UMConfigure.preInit函数，请参考【友盟+】合规指南: https://developer.umeng.com/docs/119267/detail/182050"
            android.util.Log.e(r12, r13)     // Catch:{ all -> 0x0425 }
        L_0x03f0:
            int r12 = policyGrantResult     // Catch:{ all -> 0x0425 }
            if (r12 != 0) goto L_0x03fb
            java.lang.String r12 = "UMConfigure"
            java.lang.String r13 = "检测到未调用隐私授权API，详情见：https://developer.umeng.com/docs/119267/detail/182050"
            android.util.Log.e(r12, r13)     // Catch:{ all -> 0x0425 }
        L_0x03fb:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x0423 }
            r12.<init>()     // Catch:{ all -> 0x0423 }
            java.lang.String r13 = "preInitInvoked"
            int r14 = preInitInvokedFlag     // Catch:{ all -> 0x0423 }
            r12.put(r13, r14)     // Catch:{ all -> 0x0423 }
            java.lang.String r13 = "policyGrantInvoked"
            int r14 = policyGrantInvokedFlag     // Catch:{ all -> 0x0423 }
            r12.put(r13, r14)     // Catch:{ all -> 0x0423 }
            java.lang.String r13 = "policyGrantResult"
            int r14 = policyGrantResult     // Catch:{ all -> 0x0423 }
            r12.put(r13, r14)     // Catch:{ all -> 0x0423 }
            com.umeng.commonsdk.internal.b r13 = com.umeng.commonsdk.internal.b.a(r4)     // Catch:{ all -> 0x0423 }
            com.umeng.commonsdk.internal.c r13 = r13.a()     // Catch:{ all -> 0x0423 }
            r14 = 32793(0x8019, float:4.5953E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r4, r14, r13, r12)     // Catch:{ all -> 0x0423 }
        L_0x0423:
            monitor-exit(r11)     // Catch:{ all -> 0x0425 }
            goto L_0x0428
        L_0x0425:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0425 }
            throw r12     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0428:
            boolean r11 = needSendZcfgEnv(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0444
            java.lang.String r11 = "MobclickRT"
            java.lang.String r12 = "--->>> 走零号报文发送逻辑"
            com.umeng.commonsdk.debug.UMRTLog.e(r11, r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.internal.b r11 = com.umeng.commonsdk.internal.b.a(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.internal.c r11 = r11.a()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r12 = 32781(0x800d, float:4.5936E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r4, r12, r11, r0)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            goto L_0x0470
        L_0x0444:
            boolean r11 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0470
            java.lang.String r11 = "MobclickRT"
            java.lang.String r12 = "--->>> 走正常逻辑."
            com.umeng.commonsdk.debug.UMRTLog.e(r11, r12)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            boolean r11 = com.umeng.commonsdk.config.FieldManager.b()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0465
            com.umeng.commonsdk.internal.b r11 = com.umeng.commonsdk.internal.b.a(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            com.umeng.commonsdk.internal.c r11 = r11.a()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            r12 = 32791(0x8017, float:4.595E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r4, r12, r11, r0)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0465:
            java.lang.String r11 = "header_device_oaid"
            boolean r11 = com.umeng.commonsdk.config.FieldManager.allow(r11)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x0470
            com.umeng.commonsdk.internal.c.a((android.content.Context) r4, (boolean) r2)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x0470:
            boolean r11 = isDebugLog()     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            if (r11 == 0) goto L_0x04b4
            com.umeng.commonsdk.UMConfigureInternation.doSelfCheck(r4)     // Catch:{ Exception -> 0x0499, all -> 0x047d }
            goto L_0x04b4
        L_0x047a:
            r12 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x047a }
            throw r12     // Catch:{ Exception -> 0x0499, all -> 0x047d }
        L_0x047d:
            r11 = move-exception
            boolean r12 = debugLog
            if (r12 == 0) goto L_0x04b4
            java.lang.String r12 = "UMConfigure"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "init e is "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            android.util.Log.e(r12, r11)
            goto L_0x04b4
        L_0x0499:
            r11 = move-exception
            boolean r12 = debugLog
            if (r12 == 0) goto L_0x04b4
            java.lang.String r12 = "UMConfigure"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "init e is "
            r13.append(r14)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            android.util.Log.e(r12, r11)
        L_0x04b4:
            android.content.Context r11 = r10.getApplicationContext()     // Catch:{ Exception -> 0x04e9 }
            java.lang.String r12 = "com.umeng.cconfig.UMRemoteConfig"
            java.lang.Class r12 = java.lang.Class.forName(r12)     // Catch:{ Exception -> 0x04e9 }
            java.lang.String r13 = "getInstance"
            java.lang.Class[] r14 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x04e9 }
            java.lang.reflect.Method r13 = r12.getDeclaredMethod(r13, r14)     // Catch:{ Exception -> 0x04e9 }
            if (r13 == 0) goto L_0x04ea
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04e9 }
            java.lang.Object r13 = r13.invoke(r12, r14)     // Catch:{ Exception -> 0x04e9 }
            if (r13 == 0) goto L_0x04ea
            java.lang.String r14 = "init"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x04e9 }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r4[r2] = r5     // Catch:{ Exception -> 0x04e9 }
            java.lang.reflect.Method r12 = r12.getDeclaredMethod(r14, r4)     // Catch:{ Exception -> 0x04e9 }
            if (r12 == 0) goto L_0x04ea
            r12.setAccessible(r3)     // Catch:{ Exception -> 0x04e9 }
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x04e9 }
            r14[r2] = r11     // Catch:{ Exception -> 0x04e9 }
            r12.invoke(r13, r14)     // Catch:{ Exception -> 0x04e9 }
            goto L_0x04ea
        L_0x04e9:
        L_0x04ea:
            com.umeng.commonsdk.internal.b r11 = com.umeng.commonsdk.internal.b.a(r10)
            com.umeng.commonsdk.internal.c r11 = r11.a()
            r12 = 32804(0x8024, float:4.5968E-41)
            com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r10, r12, r11, r0)
            boolean r10 = isInit
            if (r10 != 0) goto L_0x04fe
            isInit = r3
        L_0x04fe:
            long r10 = java.lang.System.currentTimeMillis()
            initCompleteTs = r10
            boolean r10 = debugLog
            if (r10 == 0) goto L_0x050f
            java.lang.String r10 = "如需使用卸载分析、反作弊功能，请务必集成高级运营分析功能依赖库（可选），并重新配置混淆，详请：https://developer.umeng.com/docs/119267/detail/118637#3091c7c11fx3q"
            java.lang.String r11 = ""
            com.umeng.commonsdk.debug.UMLog.mutlInfo((java.lang.String) r10, (int) r1, (java.lang.String) r11)
        L_0x050f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigure.init(android.content.Context, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke((Object) null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z10) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }
}
