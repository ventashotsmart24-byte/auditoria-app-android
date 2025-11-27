package com.umeng.umcrash;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.custommapping.IUMPerfCallback;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.h5pagesdk.H5Manager;
import com.efs.sdk.launch.LaunchManager;
import com.efs.sdk.memoryinfo.UMMemoryMonitor;
import com.efs.sdk.pa.IPaClient;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomLogInfo;
import com.uc.crashsdk.export.ICrashClient;
import com.uc.crashsdk.export.LogType;
import com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory;
import com.umeng.innner.umcrash.UMCrashUtil;
import com.umeng.logsdk.ULogManager;
import com.umeng.logsdk.UploadFileFilterCodeLog;
import com.umeng.pagesdk.PageManger;
import com.umeng.powersdk.PowerManager;
import com.umeng.umcrash.IUMCrashCallbackWithType;
import com.umeng.umcrash.customlog.UAPMCustomLogManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UMCrash {
    private static final long DEFAULT_PA_TIMEOUT_TIME = 2000;
    private static final boolean DEFAULT_VALUE_CODE_LOG = true;
    private static final boolean DEFAULT_VALUE_CRASH_ANR = true;
    private static final boolean DEFAULT_VALUE_CRASH_JAVA = true;
    private static final boolean DEFAULT_VALUE_CRASH_NATIVE = true;
    private static final boolean DEFAULT_VALUE_CRASH_UNEXP = false;
    private static final boolean DEFAULT_VALUE_FLUTTER = true;
    private static final boolean DEFAULT_VALUE_H5PAGE = true;
    private static final boolean DEFAULT_VALUE_LAUNCH = true;
    private static final boolean DEFAULT_VALUE_MEM = true;
    private static final boolean DEFAULT_VALUE_NET = true;
    private static final boolean DEFAULT_VALUE_PA = true;
    private static final boolean DEFAULT_VALUE_PAGE = true;
    private static final boolean DEFAULT_VALUE_POWER = true;
    private static final String INTEGRATIONTESTING_SP = "itconfig";
    private static final String IT_DEBUGKEY = "apm_debugkey";
    private static final String IT_SENDAGING = "apm_sendaging";
    private static final String KEY_ACTIITY_ON_CREATED = "onCreated";
    private static final String KEY_ACTIITY_ON_DESTROYED = "onDestroyed";
    private static final String KEY_ACTIITY_ON_PAUSED = "onPaused";
    private static final String KEY_ACTIITY_ON_RESUMED = "onResumed";
    private static final String KEY_ACTIITY_ON_STARTED = "onStarted";
    private static final String KEY_ACTIITY_ON_STOPPED = "onStopped";
    public static final String KEY_APM_DEFAULT_SECRET = "NEej8y@anWa*8hep";
    public static final String KEY_APM_ROOT_NAME = "UApm";
    public static final String KEY_CALLBACK_CUSTOM_LOG = "um_custom_log";
    public static final String KEY_CALLBACK_CUSTOM_MAPPING = "um_custom_mapping";
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_SESSION_ID = "um_session_id";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    public static final String KEY_CALLBACK_UM_INFOS = "um_infos:";
    private static final String KEY_CALLBACK_USER_STRING = "um_user_string";
    private static final String KEY_CALLBACK_USER_STRING_ANR = "um_user_str_anr:";
    private static final String KEY_CALLBACK_USER_STRING_CUSTOM_LOG = "um_user_str_custom_log:";
    private static final String KEY_CALLBACK_USER_STRING_JAVA = "um_user_str_java:";
    private static final String KEY_CALLBACK_USER_STRING_NATIVE = "um_user_str_native:";
    public static final String KEY_DEBUGKEY = "um_dk";
    public static final String KEY_ENABLE_ANR = "enableANRLog";
    public static final String KEY_ENABLE_CODE_LOG = "enableCodeLog";
    public static final String KEY_ENABLE_CRASH_JAVA = "enableJavaLog";
    public static final String KEY_ENABLE_CRASH_NATIVE = "enableNativeLog";
    public static final String KEY_ENABLE_CRASH_UNEXP = "enableUnexpLog";
    public static final String KEY_ENABLE_FLUTTER = "enableFlutterLog";
    public static final String KEY_ENABLE_H5PAGE = "enableH5PageLog";
    public static final String KEY_ENABLE_LAUNCH = "enableLaunchLog";
    public static final String KEY_ENABLE_MEM = "enableMemLog";
    public static final String KEY_ENABLE_NET = "enableNetLog";
    public static final String KEY_ENABLE_PA = "enablePaLog";
    public static final String KEY_ENABLE_PAGE = "enablePageLog";
    public static final String KEY_ENABLE_POWER = "enablePowerLog";
    public static final String KEY_HEADER_ACCESS = "um_access";
    public static final String KEY_HEADER_ACCESS_SUBTYPE = "um_access_subtype";
    public static final String KEY_HEADER_APPKEY = "um_app_key";
    public static final String KEY_HEADER_BESRIAL = "um_bserial";
    public static final String KEY_HEADER_BSVER = "um_bsver";
    public static final String KEY_HEADER_BVER = "um_bver";
    public static final String KEY_HEADER_CARRIER = "um_app_carrier";
    public static final String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final String KEY_HEADER_DEBUGKEY = "um_dk";
    public static final String KEY_HEADER_NETWORK_TYPE = "um_network_type";
    public static final String KEY_HEADER_OS = "um_os";
    public static final String KEY_HEADER_PROVIDER = "um_app_provider";
    public static final String KEY_HEADER_PUID = "um_app_puid";
    public static final String KEY_HEADER_START_TIME = "um_app_start_time";
    public static final String KEY_HEADER_UMID = "um_umid_header";
    public static final String KEY_LOG_DEVICES_ID = "log_devices_id";
    public static final String KEY_LOG_USER_ID = "log_user_id";
    private static final int KEY_MAX_LENGTH = 20480;
    private static final int KEY_MAX_LENGTH_128 = 128;
    public static final String KEY_PA_TIMEOUT_TIME = "pa_timeout_time";
    public static final String SP_KEY_DEBUG = "debugkey";
    public static final String SP_KEY_TIMESTAMP = "timestamp";
    /* access modifiers changed from: private */
    public static final String TAG = "UMCrash";
    private static String crashSdkVersion = "1.9.12";
    private static boolean enableANRLog = true;
    private static boolean enableCodeLog = true;
    private static boolean enableFlutterLog = true;
    private static boolean enableH5PageLog = true;
    private static boolean enableJavaLog = true;
    private static boolean enableLaunchLog = true;
    private static boolean enableMemLog = true;
    private static boolean enableNativeLog = true;
    private static boolean enableNetLog = true;
    private static boolean enablePaLog = true;
    private static boolean enablePageLog = true;
    private static boolean enablePowerLog = true;
    /* access modifiers changed from: private */
    public static int index = 0;
    private static boolean isBuildId = true;
    private static boolean isCodeLog = false;
    /* access modifiers changed from: private */
    public static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isFlutter = false;
    private static boolean isIntl = false;
    private static boolean isLa = false;
    private static boolean isNet = false;
    private static boolean isOpenUserCrash = true;
    /* access modifiers changed from: private */
    public static boolean isPA = false;
    /* access modifiers changed from: private */
    public static boolean isPage = false;
    private static boolean isPower = false;
    /* access modifiers changed from: private */
    public static boolean isUploadNowUserCrash = false;
    private static boolean isZip = true;
    /* access modifiers changed from: private */
    public static ArrayList<String> mArrayList = new ArrayList<>(10);
    /* access modifiers changed from: private */
    public static Context mContext = null;
    /* access modifiers changed from: private */
    public static UMCrashCallback mUMCrashCallback = null;
    /* access modifiers changed from: private */
    public static IUMCrashCallbackWithType mUMCrashCallbackWithType = null;
    /* access modifiers changed from: private */
    public static long paTimeoutTime = DEFAULT_PA_TIMEOUT_TIME;
    private static Object pageArrayLock = new Object();
    /* access modifiers changed from: private */
    public static int sApmCallbackLimit = 0;
    private static Map<String, String> sCustomInfo = new ConcurrentHashMap();
    private static boolean sIsEnableLogBackup = false;
    private static boolean sIsKillProcessAfterCrash = true;
    public static EfsReporter sReporter;
    private static String userBesrial;
    private static String userBsver;
    private static String userBver;

    public static class CrashClientImpl implements ICrashClient {
        private CrashClientImpl() {
        }

        public void onAddCrashStats(String str, int i10, int i11) {
        }

        public File onBeforeUploadLog(File file) {
            return file;
        }

        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        public void onCrashRestarting(boolean z10) {
        }

        public String onGetCallbackInfo(String str, boolean z10) {
            String onCallback;
            String onCallback2;
            String onCallback3;
            String onCallback4;
            String onCallback5;
            if (UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                return UMCrash.getUMID(UMCrash.mContext);
            }
            if (UMCrash.KEY_CALLBACK_UM_INFOS.equals(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("source", 0);
                        jSONObject2.put("action_name", "page_view");
                        jSONObject2.put("action_page_state", UMCrash.isPage);
                        JSONArray jSONArray = new JSONArray();
                        for (int i10 = 0; i10 < UMCrash.mArrayList.size(); i10++) {
                            String str2 = (String) UMCrash.mArrayList.get(i10);
                            if (str2 != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", str2);
                                jSONArray.put(jSONObject3);
                            }
                        }
                        jSONObject2.put("action_parameter", jSONArray);
                        String jSONObject4 = jSONObject2.toString();
                        if (UMCrash.isDebug) {
                            String unused = UMCrash.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("page json is ");
                            sb.append(jSONObject4);
                        }
                        jSONObject.put(UMCrash.KEY_CALLBACK_PAGE_ACTION, jSONObject4);
                    }
                } catch (Throwable unused2) {
                }
                try {
                    jSONObject.put(UMCrash.KEY_CALLBACK_SESSION_ID, UMCrash.getSessionId(UMCrash.mContext));
                    jSONObject.put(UMCrash.KEY_CALLBACK_CUSTOM_LOG, UAPMCustomLogManager.getCustomLogs());
                    jSONObject.put(UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, InnerCustomMappingManager.getCustomMappingJsonStr());
                    return jSONObject.toString();
                } catch (JSONException e10) {
                    throw new RuntimeException(e10);
                }
            } else if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                if (UMCrash.mUMCrashCallbackWithType != null || UMCrash.mUMCrashCallback == null || (onCallback5 = UMCrash.mUMCrashCallback.onCallback()) == null) {
                    return null;
                }
                if (onCallback5.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) {
                    return UMCrashUtils.splitByByte(onCallback5, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit));
                }
                return onCallback5;
            } else if (UMCrash.KEY_CALLBACK_USER_STRING_JAVA.equals(str)) {
                if (UMCrash.mUMCrashCallbackWithType == null || (onCallback4 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_JAVA)) == null) {
                    return null;
                }
                if (onCallback4.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) {
                    return UMCrashUtils.splitByByte(onCallback4, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit));
                }
                return onCallback4;
            } else if (UMCrash.KEY_CALLBACK_USER_STRING_NATIVE.equals(str)) {
                if (UMCrash.mUMCrashCallbackWithType == null || (onCallback3 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_NATIVE)) == null) {
                    return null;
                }
                if (onCallback3.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) {
                    return UMCrashUtils.splitByByte(onCallback3, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit));
                }
                return onCallback3;
            } else if (UMCrash.KEY_CALLBACK_USER_STRING_ANR.equals(str)) {
                if (UMCrash.mUMCrashCallbackWithType == null || (onCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_ANR)) == null) {
                    return null;
                }
                if (onCallback2.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) {
                    return UMCrashUtils.splitByByte(onCallback2, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit));
                }
                return onCallback2;
            } else if (!UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG.equals(str) || UMCrash.mUMCrashCallbackWithType == null || (onCallback = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_CUSTOM_LOG)) == null) {
                return null;
            } else {
                if (onCallback.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) {
                    return UMCrashUtils.splitByByte(onCallback, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit));
                }
                return onCallback;
            }
        }

        public void onLogGenerated(File file, String str) {
        }
    }

    public static class PaClientImpl implements IPaClient {
        private PaClientImpl() {
        }

        public String onGetCallbackInfo(String str) {
            String onCallback;
            String str2 = null;
            if (UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                try {
                    if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("source", 0);
                        jSONObject.put("action_name", "page_view");
                        jSONObject.put("action_page_state", UMCrash.isPage);
                        JSONArray jSONArray = new JSONArray();
                        for (int i10 = 0; i10 < UMCrash.mArrayList.size(); i10++) {
                            String str3 = (String) UMCrash.mArrayList.get(i10);
                            if (str3 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", str3);
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("action_parameter", jSONArray);
                        str2 = jSONObject.toString();
                        if (UMCrash.isDebug) {
                            String unused = UMCrash.TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("page json is ");
                            sb.append(str2);
                        }
                    }
                } catch (Throwable unused2) {
                }
                return str2;
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                if (UMCrash.mUMCrashCallbackWithType != null) {
                    String onCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_BLOCK);
                    if (onCallback2 == null) {
                        return null;
                    }
                    if (onCallback2.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) {
                        return UMCrashUtils.splitByByte(onCallback2, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit));
                    }
                    return onCallback2;
                } else if (UMCrash.mUMCrashCallback == null || (onCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                    return null;
                } else {
                    if (onCallback.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) {
                        return UMCrashUtils.splitByByte(onCallback, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit));
                    }
                    return onCallback;
                }
            }
            return null;
        }
    }

    public static /* synthetic */ int access$1208() {
        int i10 = index;
        index = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int access$1210() {
        int i10 = index;
        index = i10 - 1;
        return i10;
    }

    public static void addCustomInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "addCustomInfo failed ! key or value is empty .");
            return;
        }
        if (sCustomInfo.containsKey(str)) {
            sCustomInfo.put(str, str2);
        } else if (sCustomInfo.size() >= 10) {
            Log.e(TAG, "addCustomInfo failed ! sCustomInfo is full with 10 limit.");
        } else {
            sCustomInfo.put(str, str2);
        }
        JSONObject jSONObject = new JSONObject(sCustomInfo);
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_custom_info", jSONObject.toString());
        }
    }

    @Deprecated
    public static void enableANRLog(boolean z10) {
        enableANRLog = z10;
    }

    public static void enableJavaScriptBridge(WebView webView) {
        enableJavaScriptBridge((View) webView);
    }

    public static void enableKillProcessAfterCrash(boolean z10) {
        sIsKillProcessAfterCrash = z10;
    }

    public static void enableLogBackup(boolean z10) {
        sIsEnableLogBackup = z10;
    }

    @Deprecated
    public static void enableMemoryMonitor(boolean z10) {
        UMMemoryMonitor.get().setEnable(z10);
    }

    @Deprecated
    public static void enableNativeLog(boolean z10) {
        enableNativeLog = z10;
    }

    public static void generateCustomLog(Throwable th, String str) {
        generateCustomLog(th, str, false, false);
    }

    public static EfsReporter getReporter() {
        return sReporter;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getSessionId(android.content.Context r8) {
        /*
            java.lang.Class<com.umeng.umcrash.UMCrash> r0 = com.umeng.umcrash.UMCrash.class
            monitor-enter(r0)
            r1 = 0
            if (r8 != 0) goto L_0x0008
            monitor-exit(r0)
            return r1
        L_0x0008:
            java.lang.Class<com.umeng.commonsdk.statistics.common.DeviceConfig> r2 = com.umeng.commonsdk.statistics.common.DeviceConfig.class
            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.UNKNOW     // Catch:{ ClassNotFoundException -> 0x000d, all -> 0x0020 }
            goto L_0x000f
        L_0x000d:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x0038
            r3 = 0
            r4 = 1
            java.lang.String r5 = "getSid"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r3] = r7     // Catch:{ NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0022, all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r8 = move-exception
            goto L_0x0036
        L_0x0022:
            r2 = r1
        L_0x0024:
            if (r2 == 0) goto L_0x0038
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            r4[r3] = r8     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            java.lang.Object r8 = r2.invoke(r1, r4)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            if (r8 == 0) goto L_0x0038
            java.lang.String r8 = r8.toString()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            r1 = r8
            goto L_0x0038
        L_0x0036:
            monitor-exit(r0)
            throw r8
        L_0x0038:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrash.getSessionId(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0091 A[SYNTHETIC, Splitter:B:55:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0095 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x009e A[SYNTHETIC, Splitter:B:61:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a2 A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ab A[SYNTHETIC, Splitter:B:67:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00af A[Catch:{ all -> 0x00bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00b8 A[SYNTHETIC, Splitter:B:73:0x00b8] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00bc A[Catch:{ all -> 0x00bf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getUMAPMFlag() {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "version"
            r2 = 0
            r0.put(r1, r2)     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = "crash"
            r3 = 1
            r0.put(r1, r3)     // Catch:{ all -> 0x00bf }
            boolean r1 = enableJavaLog     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "crashJava"
            if (r1 == 0) goto L_0x001b
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x001e
        L_0x001b:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x001e:
            boolean r1 = enableNativeLog     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "crashNative"
            if (r1 == 0) goto L_0x0028
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x002b
        L_0x0028:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x002b:
            boolean r1 = enableANRLog     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "anr"
            if (r1 == 0) goto L_0x0035
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x0038
        L_0x0035:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x0038:
            boolean r1 = isPA     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "pa"
            if (r1 == 0) goto L_0x0042
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x0045
        L_0x0042:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x0045:
            boolean r1 = isLa     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "la"
            if (r1 == 0) goto L_0x004f
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x0052
        L_0x004f:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x0052:
            com.efs.sdk.memoryinfo.UMMemoryMonitorApi r1 = com.efs.sdk.memoryinfo.UMMemoryMonitor.get()     // Catch:{ all -> 0x00bf }
            boolean r1 = r1.isEnable()     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "mem"
            if (r1 == 0) goto L_0x0062
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x0065
        L_0x0062:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x0065:
            boolean r1 = isNet     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "net"
            if (r1 == 0) goto L_0x006f
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x0072
        L_0x006f:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x0072:
            com.efs.sdk.h5pagesdk.H5ConfigMananger r1 = com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger()     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "h5"
            if (r1 == 0) goto L_0x0088
            com.efs.sdk.h5pagesdk.H5ConfigMananger r1 = com.efs.sdk.h5pagesdk.H5Manager.getH5ConfigMananger()     // Catch:{ all -> 0x00bf }
            boolean r1 = r1.isH5TracerEnable()     // Catch:{ all -> 0x00bf }
            if (r1 == 0) goto L_0x0088
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x008b
        L_0x0088:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x008b:
            boolean r1 = isOpenUserCrash     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "crashUser"
            if (r1 == 0) goto L_0x0095
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x0098
        L_0x0095:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x0098:
            boolean r1 = isPage     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "page"
            if (r1 == 0) goto L_0x00a2
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x00a5
        L_0x00a2:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x00a5:
            boolean r1 = isPower     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "power"
            if (r1 == 0) goto L_0x00af
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x00b2
        L_0x00af:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x00b2:
            boolean r1 = isCodeLog     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = "codelog"
            if (r1 == 0) goto L_0x00bc
            r0.put(r4, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x00bf
        L_0x00bc:
            r0.put(r4, r2)     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrash.getUMAPMFlag():java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r2 = null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getUMID(android.content.Context r8) {
        /*
            java.lang.Class<com.umeng.umcrash.UMCrash> r0 = com.umeng.umcrash.UMCrash.class
            monitor-enter(r0)
            r1 = 0
            if (r8 != 0) goto L_0x0008
            monitor-exit(r0)
            return r1
        L_0x0008:
            java.lang.Class<com.umeng.commonsdk.UMConfigure> r2 = com.umeng.commonsdk.UMConfigure.class
            com.umeng.commonsdk.debug.UMLog r3 = com.umeng.commonsdk.UMConfigure.umDebugLog     // Catch:{ ClassNotFoundException -> 0x000d, all -> 0x0020 }
            goto L_0x000f
        L_0x000d:
            r2 = r1
        L_0x000f:
            if (r2 == 0) goto L_0x0038
            r3 = 0
            r4 = 1
            java.lang.String r5 = "getUMIDString"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r3] = r7     // Catch:{ NoSuchMethodException -> 0x0022, all -> 0x0020 }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0022, all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r8 = move-exception
            goto L_0x0036
        L_0x0022:
            r2 = r1
        L_0x0024:
            if (r2 == 0) goto L_0x0038
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            r4[r3] = r8     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            java.lang.Object r8 = r2.invoke(r1, r4)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            if (r8 == 0) goto L_0x0038
            java.lang.String r8 = r8.toString()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0038, all -> 0x0020 }
            r1 = r8
            goto L_0x0038
        L_0x0036:
            monitor-exit(r0)
            throw r8
        L_0x0038:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrash.getUMID(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:71|72) */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r5.addHeaderInfo(KEY_HEADER_PUID, "");
        r5.addHeaderInfo(KEY_HEADER_PROVIDER, "");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:110:0x0285 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x01e0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(android.content.Context r16, java.lang.String r17, java.lang.String r18) {
        /*
            r1 = r16
            r2 = r17
            java.lang.String r3 = "um_app_provider"
            java.lang.String r4 = "um_app_puid"
            java.lang.String r5 = "https://errnewlogos.umeng.com"
            java.lang.String r6 = "https://errnewlog.umeng.com"
            java.lang.String r7 = ""
            if (r1 == 0) goto L_0x05aa
            if (r2 != 0) goto L_0x0014
            goto L_0x05aa
        L_0x0014:
            java.lang.String r0 = TAG
            java.lang.String r8 = "==================可接入免费的网络分析能力!!!===================\n============================详情见============================\nhttps://developer.umeng.com/docs/193624/detail/194590#h2-n5n-d0l-fmj"
            android.util.Log.e(r0, r8)
            mContext = r1
            com.umeng.umcrash.UMCrash$1 r0 = new com.umeng.umcrash.UMCrash$1     // Catch:{ all -> 0x0026 }
            r0.<init>(r1)     // Catch:{ all -> 0x0026 }
            com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(r0)     // Catch:{ all -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002a:
            r8 = 0
            r9 = -1
            android.content.Context r0 = mContext     // Catch:{ all -> 0x0048 }
            java.lang.String r10 = "apm_ctr_flag"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r10, r8)     // Catch:{ all -> 0x0048 }
            boolean r10 = isDebug     // Catch:{ all -> 0x0048 }
            if (r10 == 0) goto L_0x0045
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            r10.<init>()     // Catch:{ all -> 0x0048 }
            java.lang.String r11 = "int apm. flag is "
            r10.append(r11)     // Catch:{ all -> 0x0048 }
            r10.append(r0)     // Catch:{ all -> 0x0048 }
        L_0x0045:
            if (r0 != r9) goto L_0x004c
            return
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004c:
            r10 = 1
            android.content.Context r0 = mContext     // Catch:{ all -> 0x006f }
            java.lang.String r11 = "hit_wl"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r11, r8)     // Catch:{ all -> 0x006f }
            boolean r11 = isDebug     // Catch:{ all -> 0x006f }
            if (r11 == 0) goto L_0x0066
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r11.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r12 = "int apm. hitWlState is "
            r11.append(r12)     // Catch:{ all -> 0x006f }
            r11.append(r0)     // Catch:{ all -> 0x006f }
        L_0x0066:
            if (r0 != r10) goto L_0x006a
            r0 = 1
            goto L_0x006b
        L_0x006a:
            r0 = 0
        L_0x006b:
            com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.setHitWL(r0)     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0073:
            java.lang.String r0 = "itconfig"
            android.content.SharedPreferences r11 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.getSharedPreferences(r1, r0)
            r12 = 100
            boolean r0 = enableJavaLog     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x008f
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x00d9 }
            java.lang.String r13 = "apm_crash_java_sampling_rate"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r13, r12)     // Catch:{ all -> 0x00d9 }
            boolean r0 = com.umeng.umcrash.UMCrashUtils.random(r0)     // Catch:{ all -> 0x00d9 }
            enableJavaLog = r0     // Catch:{ all -> 0x00d9 }
        L_0x008f:
            boolean r0 = enableNativeLog     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00a3
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x00d9 }
            java.lang.String r13 = "apm_crash_native_sampling_rate"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r13, r12)     // Catch:{ all -> 0x00d9 }
            boolean r0 = com.umeng.umcrash.UMCrashUtils.random(r0)     // Catch:{ all -> 0x00d9 }
            enableNativeLog = r0     // Catch:{ all -> 0x00d9 }
        L_0x00a3:
            boolean r0 = enableANRLog     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00b7
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x00d9 }
            java.lang.String r13 = "apm_crash_anr_sampling_rate"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r13, r12)     // Catch:{ all -> 0x00d9 }
            boolean r0 = com.umeng.umcrash.UMCrashUtils.random(r0)     // Catch:{ all -> 0x00d9 }
            enableANRLog = r0     // Catch:{ all -> 0x00d9 }
        L_0x00b7:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x00d9 }
            java.lang.String r13 = "apm_crash_user_sampling_rate"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r13, r12)     // Catch:{ all -> 0x00d9 }
            boolean r0 = com.umeng.umcrash.UMCrashUtils.random(r0)     // Catch:{ all -> 0x00d9 }
            isOpenUserCrash = r0     // Catch:{ all -> 0x00d9 }
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x00d9 }
            java.lang.String r13 = "apm_crash_user_upload_type"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r13, r9)     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00d6
            isUploadNowUserCrash = r10     // Catch:{ all -> 0x00d9 }
            goto L_0x00dd
        L_0x00d6:
            isUploadNowUserCrash = r8     // Catch:{ all -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0283 }
        L_0x00dd:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0283 }
            r0.<init>()     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "mDebug"
            boolean r14 = isDebug     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "mEncryptLog"
            boolean r14 = isEncrypt     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "mZipLog"
            boolean r14 = isZip     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "mEnableKillProcessAfterCrash"
            boolean r14 = sIsKillProcessAfterCrash     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "enableJavaLog"
            boolean r14 = enableJavaLog     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "enableNativeLog"
            r0.putBoolean(r13, r10)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "enableANRLog"
            boolean r14 = enableANRLog     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            boolean r13 = sIsEnableLogBackup     // Catch:{ all -> 0x0283 }
            if (r13 == 0) goto L_0x013b
            java.lang.String r13 = "mBackupLogs"
            r0.putBoolean(r13, r10)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "mLogsBackupPathName"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
            r14.<init>()     // Catch:{ all -> 0x0283 }
            android.content.pm.ApplicationInfo r15 = r16.getApplicationInfo()     // Catch:{ all -> 0x0283 }
            java.lang.String r15 = r15.dataDir     // Catch:{ all -> 0x0283 }
            r14.append(r15)     // Catch:{ all -> 0x0283 }
            java.lang.String r15 = java.io.File.separator     // Catch:{ all -> 0x0283 }
            r14.append(r15)     // Catch:{ all -> 0x0283 }
            java.lang.String r15 = "apm_backup_files"
            r14.append(r15)     // Catch:{ all -> 0x0283 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0283 }
            r0.putString(r13, r14)     // Catch:{ all -> 0x0283 }
        L_0x013b:
            boolean r13 = isDebug     // Catch:{ all -> 0x0283 }
            if (r13 == 0) goto L_0x0162
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
            r13.<init>()     // Catch:{ all -> 0x0283 }
            java.lang.String r14 = "enable : java is "
            r13.append(r14)     // Catch:{ all -> 0x0283 }
            boolean r14 = enableJavaLog     // Catch:{ all -> 0x0283 }
            r13.append(r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r14 = ", native is "
            r13.append(r14)     // Catch:{ all -> 0x0283 }
            boolean r14 = enableNativeLog     // Catch:{ all -> 0x0283 }
            r13.append(r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r14 = ", anr is "
            r13.append(r14)     // Catch:{ all -> 0x0283 }
            boolean r14 = enableANRLog     // Catch:{ all -> 0x0283 }
            r13.append(r14)     // Catch:{ all -> 0x0283 }
        L_0x0162:
            java.lang.String r13 = "enableUnexpLog"
            r0.putBoolean(r13, r8)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "mIsInternational"
            boolean r14 = isIntl     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            java.lang.String r13 = "mDumpUserSolibBuildId"
            boolean r14 = isBuildId     // Catch:{ all -> 0x0283 }
            r0.putBoolean(r13, r14)     // Catch:{ all -> 0x0283 }
            boolean r13 = isIntl     // Catch:{ all -> 0x0283 }
            java.lang.String r14 = "mCrashRateUploadUrl"
            java.lang.String r15 = "mCrashSDKAuthUrl"
            java.lang.String r12 = "mCrashLogUploadUrl"
            if (r13 == 0) goto L_0x018d
            java.lang.String r6 = "https://errnewlogos.umeng.com/upload"
            r0.putString(r12, r6)     // Catch:{ all -> 0x0283 }
            r0.putString(r15, r5)     // Catch:{ all -> 0x0283 }
            r0.putString(r14, r5)     // Catch:{ all -> 0x0283 }
            boolean r5 = isDebug     // Catch:{ all -> 0x0283 }
            goto L_0x019a
        L_0x018d:
            java.lang.String r5 = "https://errnewlog.umeng.com/upload"
            r0.putString(r12, r5)     // Catch:{ all -> 0x0283 }
            r0.putString(r15, r6)     // Catch:{ all -> 0x0283 }
            r0.putString(r14, r6)     // Catch:{ all -> 0x0283 }
            boolean r5 = isDebug     // Catch:{ all -> 0x0283 }
        L_0x019a:
            boolean r5 = isDebug     // Catch:{ all -> 0x0283 }
            com.umeng.umcrash.UMCrash$CrashClientImpl r6 = new com.umeng.umcrash.UMCrash$CrashClientImpl     // Catch:{ all -> 0x0283 }
            r12 = 0
            r6.<init>()     // Catch:{ all -> 0x0283 }
            com.uc.crashsdk.export.CrashApi r5 = com.uc.crashsdk.export.CrashApi.createInstanceEx(r1, r2, r5, r0, r6)     // Catch:{ all -> 0x0283 }
            if (r5 == 0) goto L_0x0279
            java.lang.String r0 = "um_app_key"
            r5.addHeaderInfo(r0, r2)     // Catch:{ all -> 0x0283 }
            java.lang.String r0 = "um_app_channel"
            r6 = r18
            r5.addHeaderInfo(r0, r6)     // Catch:{ all -> 0x0285 }
            java.lang.String r0 = "um_os"
            java.lang.String r12 = "android"
            r5.addHeaderInfo(r0, r12)     // Catch:{ all -> 0x0285 }
            java.lang.String r0 = "um_crash_sdk_version"
            java.lang.String r12 = crashSdkVersion     // Catch:{ all -> 0x0285 }
            r5.addHeaderInfo(r0, r12)     // Catch:{ all -> 0x0285 }
            java.lang.String r0 = "um_umid_header"
            java.lang.String r12 = getUMID(r16)     // Catch:{ all -> 0x0285 }
            r5.addHeaderInfo(r0, r12)     // Catch:{ all -> 0x0285 }
            java.lang.String[] r0 = com.umeng.umcrash.UMCrashUtils.getActiveUser(r16)     // Catch:{ all -> 0x01e0 }
            if (r0 == 0) goto L_0x01e6
            int r12 = r0.length     // Catch:{ all -> 0x01e0 }
            r13 = 2
            if (r12 != r13) goto L_0x01e6
            r12 = r0[r10]     // Catch:{ all -> 0x01e0 }
            r5.addHeaderInfo(r4, r12)     // Catch:{ all -> 0x01e0 }
            r0 = r0[r8]     // Catch:{ all -> 0x01e0 }
            r5.addHeaderInfo(r3, r0)     // Catch:{ all -> 0x01e0 }
            goto L_0x01e6
        L_0x01e0:
            r5.addHeaderInfo(r4, r7)     // Catch:{ all -> 0x0285 }
            r5.addHeaderInfo(r3, r7)     // Catch:{ all -> 0x0285 }
        L_0x01e6:
            java.lang.String r0 = "um_app_carrier"
            java.lang.String r3 = com.umeng.umcrash.UMCrashUtils.getNetworkOperatorName(r16)     // Catch:{ all -> 0x0285 }
            r5.addHeaderInfo(r0, r3)     // Catch:{ all -> 0x0285 }
            java.lang.String r0 = userBver     // Catch:{ all -> 0x0285 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0285 }
            if (r0 != 0) goto L_0x01fe
            java.lang.String r0 = "um_bver"
            java.lang.String r3 = userBver     // Catch:{ all -> 0x0285 }
            r5.addHeaderInfo(r0, r3)     // Catch:{ all -> 0x0285 }
        L_0x01fe:
            java.lang.String r0 = userBsver     // Catch:{ all -> 0x0285 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0285 }
            if (r0 != 0) goto L_0x020d
            java.lang.String r0 = "um_bsver"
            java.lang.String r3 = userBsver     // Catch:{ all -> 0x0285 }
            r5.addHeaderInfo(r0, r3)     // Catch:{ all -> 0x0285 }
        L_0x020d:
            java.lang.String r0 = userBesrial     // Catch:{ all -> 0x0285 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0285 }
            if (r0 != 0) goto L_0x021c
            java.lang.String r0 = "um_bserial"
            java.lang.String r3 = userBesrial     // Catch:{ all -> 0x0285 }
            r5.addHeaderInfo(r0, r3)     // Catch:{ all -> 0x0285 }
        L_0x021c:
            int r0 = com.efs.sdk.base.core.util.NetworkUtil.getNetworkTypeUmeng(r16)     // Catch:{ all -> 0x0235 }
            java.lang.String r3 = "um_network_type"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0235 }
            r4.<init>()     // Catch:{ all -> 0x0235 }
            r4.append(r7)     // Catch:{ all -> 0x0235 }
            r4.append(r0)     // Catch:{ all -> 0x0235 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0235 }
            r5.addHeaderInfo(r3, r0)     // Catch:{ all -> 0x0235 }
            goto L_0x0239
        L_0x0235:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0285 }
        L_0x0239:
            boolean r0 = com.umeng.umcrash.UMCrashUtils.isHarmony(r16)     // Catch:{ all -> 0x024d }
            java.lang.String r3 = "others_OS"
            if (r0 == 0) goto L_0x0247
            java.lang.String r0 = "harmony"
            r5.addHeaderInfo(r3, r0)     // Catch:{ all -> 0x024d }
            goto L_0x0251
        L_0x0247:
            java.lang.String r0 = "Android"
            r5.addHeaderInfo(r3, r0)     // Catch:{ all -> 0x024d }
            goto L_0x0251
        L_0x024d:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0285 }
        L_0x0251:
            registerInfoCallback(r5)     // Catch:{ all -> 0x0285 }
            boolean r0 = r1 instanceof android.app.Application     // Catch:{ all -> 0x0285 }
            if (r0 == 0) goto L_0x0264
            r0 = r1
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x0285 }
            com.umeng.umcrash.UMCrash$2 r3 = new com.umeng.umcrash.UMCrash$2     // Catch:{ all -> 0x0285 }
            r3.<init>(r2, r11)     // Catch:{ all -> 0x0285 }
            r0.registerActivityLifecycleCallbacks(r3)     // Catch:{ all -> 0x0285 }
            goto L_0x026b
        L_0x0264:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0285 }
            java.lang.String r3 = "context not instanceof application."
            android.util.Log.e(r0, r3)     // Catch:{ all -> 0x0285 }
        L_0x026b:
            com.umeng.umcrash.UMCrash$3 r0 = new com.umeng.umcrash.UMCrash$3     // Catch:{ all -> 0x0274 }
            r0.<init>(r1, r5)     // Catch:{ all -> 0x0274 }
            com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(r0)     // Catch:{ all -> 0x0274 }
            goto L_0x0285
        L_0x0274:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0285 }
            goto L_0x0285
        L_0x0279:
            r6 = r18
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0285 }
            java.lang.String r3 = "create CrashAPI is null."
            android.util.Log.e(r0, r3)     // Catch:{ all -> 0x0285 }
            goto L_0x0285
        L_0x0283:
            r6 = r18
        L_0x0285:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x02e9 }
            java.lang.String r3 = "apm_codelog_state"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r3, r9)     // Catch:{ all -> 0x02e9 }
            boolean r3 = isDebug     // Catch:{ all -> 0x02e9 }
            if (r3 == 0) goto L_0x02a0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e9 }
            r3.<init>()     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "inner config : code log rate is "
            r3.append(r4)     // Catch:{ all -> 0x02e9 }
            r3.append(r0)     // Catch:{ all -> 0x02e9 }
        L_0x02a0:
            if (r0 != 0) goto L_0x02a5
            boolean r0 = isDebug     // Catch:{ all -> 0x02e9 }
            goto L_0x02d5
        L_0x02a5:
            r3 = 100
            if (r0 != r3) goto L_0x02d5
            boolean r0 = isDebug     // Catch:{ all -> 0x02e9 }
            boolean r0 = enableCodeLog     // Catch:{ all -> 0x02e9 }
            if (r0 == 0) goto L_0x02d5
            java.lang.String r0 = com.umeng.logsdk.ULogManager.getDeviceID()     // Catch:{ all -> 0x02e9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02e9 }
            if (r0 == 0) goto L_0x02d3
            android.content.Context r0 = mContext     // Catch:{ all -> 0x02e9 }
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.getUMId(r0)     // Catch:{ all -> 0x02e9 }
            boolean r3 = isDebug     // Catch:{ all -> 0x02e9 }
            if (r3 == 0) goto L_0x02d0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e9 }
            r3.<init>()     // Catch:{ all -> 0x02e9 }
            java.lang.String r4 = "inner config : code log set umid is "
            r3.append(r4)     // Catch:{ all -> 0x02e9 }
            r3.append(r0)     // Catch:{ all -> 0x02e9 }
        L_0x02d0:
            com.umeng.logsdk.ULogManager.setDeviceID(r0)     // Catch:{ all -> 0x02e9 }
        L_0x02d3:
            isCodeLog = r10     // Catch:{ all -> 0x02e9 }
        L_0x02d5:
            boolean r0 = isDebug     // Catch:{ all -> 0x02e9 }
            if (r0 == 0) goto L_0x02ed
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02e9 }
            r0.<init>()     // Catch:{ all -> 0x02e9 }
            java.lang.String r3 = "enable codeLog is "
            r0.append(r3)     // Catch:{ all -> 0x02e9 }
            boolean r3 = isCodeLog     // Catch:{ all -> 0x02e9 }
            r0.append(r3)     // Catch:{ all -> 0x02e9 }
            goto L_0x02ed
        L_0x02e9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x02ed:
            initReporter(r16, r17, r18)     // Catch:{ all -> 0x02f1 }
            goto L_0x02f6
        L_0x02f1:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x02f6:
            java.lang.String r0 = "debugkey"
            java.lang.String r0 = r11.getString(r0, r7)     // Catch:{ all -> 0x0329 }
            java.lang.String r2 = "timestamp"
            r3 = 0
            long r5 = r11.getLong(r2, r3)     // Catch:{ all -> 0x0329 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0329 }
            long r5 = r5 - r12
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x031a
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0329 }
            if (r2 != 0) goto L_0x031a
            com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.setIntegrationTestingInPeriod(r10)     // Catch:{ all -> 0x0329 }
            com.umeng.umcrash.UMCrashUtils.setIntegrationTesingParams(r0)     // Catch:{ all -> 0x0329 }
            goto L_0x032d
        L_0x031a:
            android.content.SharedPreferences$Editor r0 = r11.edit()     // Catch:{ all -> 0x0329 }
            android.content.SharedPreferences$Editor r0 = r0.clear()     // Catch:{ all -> 0x0329 }
            r0.apply()     // Catch:{ all -> 0x0329 }
            com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.setIntegrationTestingInPeriod(r8)     // Catch:{ all -> 0x0329 }
            goto L_0x032d
        L_0x0329:
            r0 = move-exception
            r0.printStackTrace()
        L_0x032d:
            boolean r0 = enablePaLog     // Catch:{ all -> 0x0346 }
            if (r0 == 0) goto L_0x033a
            com.umeng.umcrash.UMCrash$4 r0 = new com.umeng.umcrash.UMCrash$4     // Catch:{ all -> 0x0346 }
            r0.<init>(r1)     // Catch:{ all -> 0x0346 }
            com.efs.sdk.base.core.util.concurrent.WorkThreadUtil.submit(r0)     // Catch:{ all -> 0x0346 }
            goto L_0x034a
        L_0x033a:
            boolean r0 = isDebug     // Catch:{ all -> 0x0346 }
            if (r0 == 0) goto L_0x034a
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0346 }
            java.lang.String r2 = "enablePaLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0346 }
            goto L_0x034a
        L_0x0346:
            r0 = move-exception
            r0.printStackTrace()
        L_0x034a:
            boolean r0 = enableLaunchLog     // Catch:{ all -> 0x0391 }
            if (r0 == 0) goto L_0x0385
            com.efs.sdk.base.EfsReporter r0 = sReporter     // Catch:{ all -> 0x0391 }
            com.efs.sdk.launch.LaunchManager.init(r1, r0)     // Catch:{ all -> 0x0391 }
            com.efs.sdk.launch.LaunchConfigManager r0 = com.efs.sdk.launch.LaunchManager.getLaunchConfigManager()     // Catch:{ all -> 0x0364 }
            if (r0 == 0) goto L_0x0368
            com.efs.sdk.launch.LaunchConfigManager r0 = com.efs.sdk.launch.LaunchManager.getLaunchConfigManager()     // Catch:{ all -> 0x0364 }
            boolean r0 = r0.enableTracer()     // Catch:{ all -> 0x0364 }
            isLa = r0     // Catch:{ all -> 0x0364 }
            goto L_0x0368
        L_0x0364:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0391 }
        L_0x0368:
            java.lang.String r0 = com.umeng.commonsdk.utils.UMUtils.getUMId(r16)     // Catch:{ all -> 0x0391 }
            if (r0 == 0) goto L_0x0374
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0391 }
            if (r0 == 0) goto L_0x0395
        L_0x0374:
            boolean r0 = isDebug     // Catch:{ all -> 0x0391 }
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(r16)     // Catch:{ all -> 0x0391 }
            java.lang.String r2 = "umid"
            com.umeng.umcrash.UMCrash$5 r3 = new com.umeng.umcrash.UMCrash$5     // Catch:{ all -> 0x0391 }
            r3.<init>(r1)     // Catch:{ all -> 0x0391 }
            r0.registImprintCallback(r2, r3)     // Catch:{ all -> 0x0391 }
            goto L_0x0395
        L_0x0385:
            boolean r0 = isDebug     // Catch:{ all -> 0x0391 }
            if (r0 == 0) goto L_0x0395
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0391 }
            java.lang.String r2 = "enableLaunchLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0391 }
            goto L_0x0395
        L_0x0391:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0395:
            boolean r0 = enableMemLog     // Catch:{ all -> 0x03af }
            if (r0 == 0) goto L_0x03a3
            com.efs.sdk.memoryinfo.UMMemoryMonitorApi r0 = com.efs.sdk.memoryinfo.UMMemoryMonitor.get()     // Catch:{ all -> 0x03af }
            com.efs.sdk.base.EfsReporter r2 = sReporter     // Catch:{ all -> 0x03af }
            r0.start(r1, r2)     // Catch:{ all -> 0x03af }
            goto L_0x03b3
        L_0x03a3:
            boolean r0 = isDebug     // Catch:{ all -> 0x03af }
            if (r0 == 0) goto L_0x03b3
            java.lang.String r0 = TAG     // Catch:{ all -> 0x03af }
            java.lang.String r2 = "enableMemLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x03af }
            goto L_0x03b3
        L_0x03af:
            r0 = move-exception
            r0.printStackTrace()
        L_0x03b3:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x0431 }
            java.lang.String r2 = "apm_netperf_state"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r2, r9)     // Catch:{ all -> 0x0431 }
            boolean r2 = isDebug     // Catch:{ all -> 0x0431 }
            if (r2 == 0) goto L_0x03ce
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0431 }
            r2.<init>()     // Catch:{ all -> 0x0431 }
            java.lang.String r3 = "inner config : net rate is "
            r2.append(r3)     // Catch:{ all -> 0x0431 }
            r2.append(r0)     // Catch:{ all -> 0x0431 }
        L_0x03ce:
            if (r0 != 0) goto L_0x03d3
            boolean r0 = isDebug     // Catch:{ all -> 0x0431 }
            goto L_0x0435
        L_0x03d3:
            r2 = 100
            if (r0 != r2) goto L_0x0435
            boolean r0 = isDebug     // Catch:{ all -> 0x0431 }
            boolean r0 = enableNetLog     // Catch:{ all -> 0x0431 }
            if (r0 == 0) goto L_0x0425
            com.efs.sdk.base.EfsReporter r0 = sReporter     // Catch:{ all -> 0x0431 }
            com.efs.sdk.net.NetManager.init(r1, r0)     // Catch:{ all -> 0x0431 }
            com.efs.sdk.net.NetConfigManager r0 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0420 }
            if (r0 == 0) goto L_0x0435
            com.efs.sdk.net.NetConfigManager r0 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0420 }
            boolean r0 = r0.enableTracer()     // Catch:{ all -> 0x0420 }
            isNet = r0     // Catch:{ all -> 0x0420 }
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x0420 }
            java.lang.String r2 = "apm_netperf_bd_state"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r2, r9)     // Catch:{ all -> 0x0420 }
            boolean r2 = isDebug     // Catch:{ all -> 0x0420 }
            if (r2 == 0) goto L_0x040d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0420 }
            r2.<init>()     // Catch:{ all -> 0x0420 }
            java.lang.String r3 = "inner config : net reqBody rate is "
            r2.append(r3)     // Catch:{ all -> 0x0420 }
            r2.append(r0)     // Catch:{ all -> 0x0420 }
        L_0x040d:
            r2 = 100
            if (r0 != r2) goto L_0x041b
            boolean r0 = isDebug     // Catch:{ all -> 0x0420 }
            com.efs.sdk.net.NetConfigManager r0 = com.efs.sdk.net.NetManager.getNetConfigManager()     // Catch:{ all -> 0x0420 }
            r0.setNetRequestBodyCollectState(r10)     // Catch:{ all -> 0x0420 }
            goto L_0x0435
        L_0x041b:
            if (r0 != 0) goto L_0x0435
            boolean r0 = isDebug     // Catch:{ all -> 0x0420 }
            goto L_0x0435
        L_0x0420:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0431 }
            goto L_0x0435
        L_0x0425:
            boolean r0 = isDebug     // Catch:{ all -> 0x0431 }
            if (r0 == 0) goto L_0x0435
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0431 }
            java.lang.String r2 = "enableNetLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0431 }
            goto L_0x0435
        L_0x0431:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0435:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x0471 }
            java.lang.String r2 = "apm_native_h5_state"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r2, r9)     // Catch:{ all -> 0x0471 }
            boolean r2 = isDebug     // Catch:{ all -> 0x0471 }
            if (r2 == 0) goto L_0x0450
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0471 }
            r2.<init>()     // Catch:{ all -> 0x0471 }
            java.lang.String r3 = "inner config : nativeH5Rate is "
            r2.append(r3)     // Catch:{ all -> 0x0471 }
            r2.append(r0)     // Catch:{ all -> 0x0471 }
        L_0x0450:
            if (r0 != 0) goto L_0x0455
            boolean r0 = isDebug     // Catch:{ all -> 0x0471 }
            goto L_0x0475
        L_0x0455:
            r2 = 100
            if (r0 != r2) goto L_0x0475
            boolean r0 = isDebug     // Catch:{ all -> 0x0471 }
            boolean r0 = enableH5PageLog     // Catch:{ all -> 0x0471 }
            if (r0 == 0) goto L_0x0465
            com.efs.sdk.base.EfsReporter r0 = sReporter     // Catch:{ all -> 0x0471 }
            com.efs.sdk.h5pagesdk.H5Manager.init(r1, r0)     // Catch:{ all -> 0x0471 }
            goto L_0x0475
        L_0x0465:
            boolean r0 = isDebug     // Catch:{ all -> 0x0471 }
            if (r0 == 0) goto L_0x0475
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0471 }
            java.lang.String r2 = "enableH5PageLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0471 }
            goto L_0x0475
        L_0x0471:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0475:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x04c8 }
            java.lang.String r2 = "apm_page_state"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r2, r9)     // Catch:{ all -> 0x04c8 }
            boolean r2 = isDebug     // Catch:{ all -> 0x04c8 }
            if (r2 == 0) goto L_0x0490
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x04c8 }
            r2.<init>()     // Catch:{ all -> 0x04c8 }
            java.lang.String r3 = "inner config : page rate is "
            r2.append(r3)     // Catch:{ all -> 0x04c8 }
            r2.append(r0)     // Catch:{ all -> 0x04c8 }
        L_0x0490:
            if (r0 != 0) goto L_0x0495
            boolean r0 = isDebug     // Catch:{ all -> 0x04c8 }
            goto L_0x04cc
        L_0x0495:
            r2 = 100
            if (r0 != r2) goto L_0x04cc
            boolean r0 = isDebug     // Catch:{ all -> 0x04c8 }
            boolean r0 = enablePageLog     // Catch:{ all -> 0x04c8 }
            if (r0 == 0) goto L_0x04bc
            android.content.Context r0 = mContext     // Catch:{ all -> 0x04c8 }
            com.efs.sdk.base.EfsReporter r2 = sReporter     // Catch:{ all -> 0x04c8 }
            com.umeng.pagesdk.PageManger.init(r0, r2)     // Catch:{ all -> 0x04c8 }
            com.umeng.pagesdk.PageConfigManger r0 = com.umeng.pagesdk.PageManger.getPageConfigManger()     // Catch:{ all -> 0x04b7 }
            if (r0 == 0) goto L_0x04cc
            com.umeng.pagesdk.PageConfigManger r0 = com.umeng.pagesdk.PageManger.getPageConfigManger()     // Catch:{ all -> 0x04b7 }
            boolean r0 = r0.enableTracer()     // Catch:{ all -> 0x04b7 }
            isPage = r0     // Catch:{ all -> 0x04b7 }
            goto L_0x04cc
        L_0x04b7:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x04c8 }
            goto L_0x04cc
        L_0x04bc:
            boolean r0 = isDebug     // Catch:{ all -> 0x04c8 }
            if (r0 == 0) goto L_0x04cc
            java.lang.String r0 = TAG     // Catch:{ all -> 0x04c8 }
            java.lang.String r2 = "enablePageLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x04c8 }
            goto L_0x04cc
        L_0x04c8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x04cc:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x051f }
            java.lang.String r2 = "apm_power_state"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r2, r9)     // Catch:{ all -> 0x051f }
            boolean r2 = isDebug     // Catch:{ all -> 0x051f }
            if (r2 == 0) goto L_0x04e7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x051f }
            r2.<init>()     // Catch:{ all -> 0x051f }
            java.lang.String r3 = "inner config : power rate is "
            r2.append(r3)     // Catch:{ all -> 0x051f }
            r2.append(r0)     // Catch:{ all -> 0x051f }
        L_0x04e7:
            if (r0 != 0) goto L_0x04ec
            boolean r0 = isDebug     // Catch:{ all -> 0x051f }
            goto L_0x0523
        L_0x04ec:
            r2 = 100
            if (r0 != r2) goto L_0x0523
            boolean r0 = isDebug     // Catch:{ all -> 0x051f }
            boolean r0 = enablePowerLog     // Catch:{ all -> 0x051f }
            if (r0 == 0) goto L_0x0513
            android.content.Context r0 = mContext     // Catch:{ all -> 0x051f }
            com.efs.sdk.base.EfsReporter r2 = sReporter     // Catch:{ all -> 0x051f }
            com.umeng.powersdk.PowerManager.init(r0, r2)     // Catch:{ all -> 0x051f }
            com.umeng.powersdk.PowerConfigManager r0 = com.umeng.powersdk.PowerManager.getPowerConfigManager()     // Catch:{ all -> 0x050e }
            if (r0 == 0) goto L_0x0523
            com.umeng.powersdk.PowerConfigManager r0 = com.umeng.powersdk.PowerManager.getPowerConfigManager()     // Catch:{ all -> 0x050e }
            boolean r0 = r0.enableTracer()     // Catch:{ all -> 0x050e }
            isPower = r0     // Catch:{ all -> 0x050e }
            goto L_0x0523
        L_0x050e:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x051f }
            goto L_0x0523
        L_0x0513:
            boolean r0 = isDebug     // Catch:{ all -> 0x051f }
            if (r0 == 0) goto L_0x0523
            java.lang.String r0 = TAG     // Catch:{ all -> 0x051f }
            java.lang.String r2 = "enablePowerLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x051f }
            goto L_0x0523
        L_0x051f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0523:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x0576 }
            java.lang.String r2 = "apm_flutter_state"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r2, r9)     // Catch:{ all -> 0x0576 }
            boolean r2 = isDebug     // Catch:{ all -> 0x0576 }
            if (r2 == 0) goto L_0x053e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0576 }
            r2.<init>()     // Catch:{ all -> 0x0576 }
            java.lang.String r3 = "inner config : flutter rate is "
            r2.append(r3)     // Catch:{ all -> 0x0576 }
            r2.append(r0)     // Catch:{ all -> 0x0576 }
        L_0x053e:
            if (r0 != 0) goto L_0x0543
            boolean r0 = isDebug     // Catch:{ all -> 0x0576 }
            goto L_0x057a
        L_0x0543:
            r2 = 100
            if (r0 != r2) goto L_0x057a
            boolean r0 = isDebug     // Catch:{ all -> 0x0576 }
            boolean r0 = enableFlutterLog     // Catch:{ all -> 0x0576 }
            if (r0 == 0) goto L_0x056a
            android.content.Context r0 = mContext     // Catch:{ all -> 0x0576 }
            com.efs.sdk.base.EfsReporter r2 = sReporter     // Catch:{ all -> 0x0576 }
            com.efs.sdk.fluttersdk.FlutterManager.init(r0, r2)     // Catch:{ all -> 0x0576 }
            com.efs.sdk.fluttersdk.FlutterConfigManager r0 = com.efs.sdk.fluttersdk.FlutterManager.getFlutterConfigManager()     // Catch:{ all -> 0x0565 }
            if (r0 == 0) goto L_0x057a
            com.efs.sdk.fluttersdk.FlutterConfigManager r0 = com.efs.sdk.fluttersdk.FlutterManager.getFlutterConfigManager()     // Catch:{ all -> 0x0565 }
            boolean r0 = r0.isFlutterEnable()     // Catch:{ all -> 0x0565 }
            isFlutter = r0     // Catch:{ all -> 0x0565 }
            goto L_0x057a
        L_0x0565:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x0576 }
            goto L_0x057a
        L_0x056a:
            boolean r0 = isDebug     // Catch:{ all -> 0x0576 }
            if (r0 == 0) goto L_0x057a
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0576 }
            java.lang.String r2 = "enableFlutterLog is false"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0576 }
            goto L_0x057a
        L_0x0576:
            r0 = move-exception
            r0.printStackTrace()
        L_0x057a:
            android.content.Context r0 = r16.getApplicationContext()     // Catch:{ all -> 0x059a }
            java.lang.String r1 = "apm_callback_limit"
            int r0 = com.umeng.umcrash.UMCrashUtils.getInnerConfig(r0, r1, r9)     // Catch:{ all -> 0x059a }
            sApmCallbackLimit = r0     // Catch:{ all -> 0x059a }
            boolean r0 = isDebug     // Catch:{ all -> 0x059a }
            if (r0 == 0) goto L_0x059e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x059a }
            r0.<init>()     // Catch:{ all -> 0x059a }
            java.lang.String r1 = "inner config : callback limit is "
            r0.append(r1)     // Catch:{ all -> 0x059a }
            int r1 = sApmCallbackLimit     // Catch:{ all -> 0x059a }
            r0.append(r1)     // Catch:{ all -> 0x059a }
            goto L_0x059e
        L_0x059a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x059e:
            boolean r0 = isCodeLog
            if (r0 == 0) goto L_0x05a9
            android.content.Context r0 = mContext
            com.efs.sdk.base.EfsReporter r1 = sReporter
            com.umeng.logsdk.ULogManager.init(r0, r1)
        L_0x05a9:
            return
        L_0x05aa:
            java.lang.String r0 = TAG
            java.lang.String r1 = "context is null or appkey is null, init failed."
            android.util.Log.e(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrash.init(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void initConfig(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean(KEY_ENABLE_CRASH_JAVA, true)) {
                enableJavaLog = true;
            } else {
                enableJavaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_CRASH_NATIVE, true)) {
                enableNativeLog = true;
            } else {
                enableNativeLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_ANR, true)) {
                enableANRLog = true;
            } else {
                enableANRLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_PA, true)) {
                enablePaLog = true;
            } else {
                enablePaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_LAUNCH, true)) {
                enableLaunchLog = true;
            } else {
                enableLaunchLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEM, true)) {
                enableMemLog = true;
            } else {
                enableMemLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_NET, true)) {
                enableNetLog = true;
            } else {
                enableNetLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_H5PAGE, true)) {
                enableH5PageLog = true;
            } else {
                enableH5PageLog = false;
            }
            paTimeoutTime = bundle.getLong(KEY_PA_TIMEOUT_TIME, DEFAULT_PA_TIMEOUT_TIME);
            if (bundle.getBoolean(KEY_ENABLE_PAGE, true)) {
                enablePageLog = true;
            } else {
                enablePageLog = false;
            }
            try {
                if (bundle.getBoolean(KEY_ENABLE_CODE_LOG, true)) {
                    enableCodeLog = true;
                } else {
                    enableCodeLog = false;
                }
                ULogManager.setUserID(bundle.getString(KEY_LOG_USER_ID, ""));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (bundle.getBoolean(KEY_ENABLE_POWER, true)) {
                enablePowerLog = true;
            } else {
                enablePowerLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_FLUTTER, true)) {
                enableFlutterLog = true;
            } else {
                enableFlutterLog = false;
            }
        }
    }

    private static void initReporter(final Context context, String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(KEY_HEADER_UMID, getUMID(context));
        hashMap.put(KEY_HEADER_CHANNEL, str2);
        hashMap.put(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
        hashMap.put(KEY_HEADER_OS, "android");
        hashMap.put(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
        try {
            String[] activeUser = UMCrashUtils.getActiveUser(context);
            if (activeUser != null && activeUser.length == 2) {
                hashMap.put(KEY_HEADER_PUID, activeUser[1]);
                hashMap.put(KEY_HEADER_PROVIDER, activeUser[0]);
            }
        } catch (Throwable unused) {
            hashMap.put(KEY_HEADER_PUID, "");
            hashMap.put(KEY_HEADER_PROVIDER, "");
        }
        if (!TextUtils.isEmpty(userBver)) {
            hashMap.put(KEY_HEADER_BVER, userBver);
        }
        if (!TextUtils.isEmpty(userBsver)) {
            hashMap.put(KEY_HEADER_BSVER, userBsver);
        }
        if (!TextUtils.isEmpty(userBesrial)) {
            hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
        }
        try {
            if (UMCrashUtils.isHarmony(context)) {
                hashMap.put("others_OS", "harmony");
            } else {
                hashMap.put("others_OS", "Android");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        EfsReporter build = new EfsReporter.Builder(context.getApplicationContext(), str, KEY_APM_DEFAULT_SECRET).debug(isDebug).enablePaBackup(sIsEnableLogBackup).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).enableWaStat(false).logUid(ULogManager.getUserID()).logDid(ULogManager.getDeviceID()).setOpenCodeLog(isCodeLog).build();
        sReporter = build;
        build.addPublicParams(hashMap);
        try {
            if (isCodeLog) {
                sReporter.setFileFilterCodeLog(new UploadFileFilterCodeLog());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            sReporter.getAllSdkConfig(new String[]{UMCrashContent.APM_STATE_CODE_LOG, UMCrashContent.APM_STATE_HIT_WL, UMCrashContent.APM_STATE_FLUTTER, UMCrashContent.APM_STATE_POWER, UMCrashContent.APM_STATE_PAGE, UMCrashContent.APM_STATE_NET, UMCrashContent.APM_STATE_NET_REQUEST_BODY, UMCrashContent.APM_STATE_NATIVE_H5, UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_MAX_COUNT, UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, UMCrashContent.APM_CALLBACK_LIMIT}, new IConfigCallback() {
                public void onChange(Map<String, Object> map) {
                    try {
                        Object obj = map.get(UMCrashContent.APM_STATE_NET);
                        if (obj != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("callback netRate is ");
                                sb.append(obj.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET, obj);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        Object obj2 = map.get(UMCrashContent.APM_STATE_NET_REQUEST_BODY);
                        if (obj2 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("callback netReqBodyRate is ");
                                sb2.append(obj2.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NET_REQUEST_BODY, obj2);
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        Object obj3 = map.get(UMCrashContent.APM_STATE_NATIVE_H5);
                        if (obj3 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("callback nativeH5Rate is ");
                                sb3.append(obj3.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_NATIVE_H5, obj3);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    try {
                        UMCrash.saveLocalCrashSampling(context, map);
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    try {
                        UMCrash.updateLocalCrashConfig(context, map);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    try {
                        Object obj4 = map.get(UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE);
                        if (obj4 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("callback uploadType is ");
                                sb4.append(obj4.toString());
                            }
                            if (Integer.valueOf(obj4.toString()).intValue() == 0) {
                                boolean unused = UMCrash.isUploadNowUserCrash = true;
                            } else {
                                boolean unused2 = UMCrash.isUploadNowUserCrash = false;
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, obj4);
                        }
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                    try {
                        Object obj5 = map.get(UMCrashContent.APM_STATE_PAGE);
                        if (obj5 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("callback pageRate is ");
                                sb5.append(obj5.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_PAGE, obj5);
                        }
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                    try {
                        Object obj6 = map.get(UMCrashContent.APM_STATE_CODE_LOG);
                        if (obj6 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("callback codeLogRate is ");
                                sb6.append(obj6.toString());
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_CODE_LOG, obj6);
                        }
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                    try {
                        Object obj7 = map.get(UMCrashContent.APM_STATE_POWER);
                        if (obj7 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("callback powerRate is ");
                                sb7.append(obj7);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_POWER, obj7);
                        }
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                    }
                    try {
                        Object obj8 = map.get(UMCrashContent.APM_STATE_HIT_WL);
                        if (obj8 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("callback hitwl is ");
                                sb8.append(obj8);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_HIT_WL, obj8);
                        }
                    } catch (Throwable th10) {
                        th10.printStackTrace();
                    }
                    try {
                        Object obj9 = map.get(UMCrashContent.APM_STATE_FLUTTER);
                        if (obj9 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append("callback flutterRate is ");
                                sb9.append(obj9);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_STATE_FLUTTER, obj9);
                        }
                    } catch (Throwable th11) {
                        th11.printStackTrace();
                    }
                    try {
                        Object obj10 = map.get(UMCrashContent.APM_CALLBACK_LIMIT);
                        if (obj10 != null) {
                            if (UMCrash.isDebug) {
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append("callback callbackLimit is ");
                                sb10.append(obj10);
                            }
                            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CALLBACK_LIMIT, obj10);
                        }
                    } catch (Throwable th12) {
                        th12.printStackTrace();
                    }
                }
            });
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void isBuildId(boolean z10) {
        isBuildId = z10;
    }

    private static void registerInfoCallback(CrashApi crashApi) {
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_JAVA, 16);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_NATIVE, 1);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_ANR, LogType.ANR);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_CUSTOM_LOG, 256);
        crashApi.registerInfoCallback(KEY_CALLBACK_UM_INFOS, IAPI.OPTION_11);
        crashApi.registerInfoCallback(KEY_CALLBACK_UMID, IAPI.OPTION_11);
    }

    public static void registerPerfCallback(IUMPerfCallback iUMPerfCallback) {
        EfsReporter.registerPerfCallback(iUMPerfCallback);
    }

    public static void registerUMCrashCallback(UMCrashCallback uMCrashCallback) {
        if (uMCrashCallback != null) {
            mUMCrashCallback = uMCrashCallback;
            if (CrashApi.getInstance() != null) {
                CrashApi.getInstance().registerInfoCallback(KEY_CALLBACK_USER_STRING, IAPI.OPTION_11);
            } else {
                Log.e(TAG, "callback error, instance is null.");
            }
        } else {
            Log.e(TAG, "callback error.");
        }
    }

    /* access modifiers changed from: private */
    public static void saveActivityState(String str, String str2) {
        try {
            ArrayList<String> arrayList = mArrayList;
            if (arrayList != null) {
                if (arrayList.size() >= 20) {
                    mArrayList.remove(0);
                }
                ArrayList<String> arrayList2 = mArrayList;
                arrayList2.add(str + Operator.Operation.MINUS + System.currentTimeMillis() + Operator.Operation.MINUS + str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void saveLocalCrashSampling(Context context, Map<String, Object> map) {
        if (context != null && map != null) {
            Object obj = map.get(UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE);
            if (obj != null) {
                if (isDebug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("callback crashJavaSampling is ");
                    sb.append(obj.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, obj);
            }
            Object obj2 = map.get(UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE);
            if (obj2 != null) {
                if (isDebug) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("callback crashNativeSampling is ");
                    sb2.append(obj2.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, obj2);
            }
            Object obj3 = map.get(UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE);
            if (obj3 != null) {
                if (isDebug) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("callback crashANRSampling is ");
                    sb3.append(obj3.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, obj3);
            }
            Object obj4 = map.get(UMCrashContent.APM_CRASH_USER_SAMPLING_RATE);
            if (obj4 != null) {
                if (isDebug) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("callback crashUserSampling is ");
                    sb4.append(obj4.toString());
                }
                UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, obj4);
            }
        }
    }

    public static void setAppVersion(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.trim().getBytes().length > 128) {
                    str = UMCrashUtils.splitByByte(str, 128);
                }
                userBver = str;
            } else if (isDebug) {
                Log.e(TAG, "version is null or empty !");
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.trim().getBytes().length > 128) {
                    str2 = UMCrashUtils.splitByByte(str2, 128);
                }
                userBsver = str2;
            } else if (isDebug) {
                Log.e(TAG, "sub version is null or empty !");
            }
            if (!TextUtils.isEmpty(str3)) {
                if (str3.trim().getBytes().length > 128) {
                    str3 = UMCrashUtils.splitByByte(str3, 128);
                }
                userBesrial = str3;
            } else if (isDebug) {
                Log.e(TAG, "build id is null or empty !");
            }
            CrashApi instance = CrashApi.getInstance();
            if (instance != null) {
                if (!TextUtils.isEmpty(userBver)) {
                    instance.addHeaderInfo(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    instance.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    instance.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                }
            } else if (isDebug) {
                Log.e(TAG, "set app version. crashApi is null");
            }
            HashMap hashMap = new HashMap(1);
            if (!TextUtils.isEmpty(userBver)) {
                hashMap.put(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                hashMap.put(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
            }
            EfsReporter efsReporter = sReporter;
            if (efsReporter != null) {
                efsReporter.addPublicParams(hashMap);
            } else if (isDebug) {
                Log.e(TAG, "set app version.  sReporter is null");
            }
            if (!TextUtils.isEmpty(userBver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BESRIAL, userBesrial);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setDebug(boolean z10) {
        isDebug = z10;
        LaunchManager.isDebug = z10;
        H5Manager.isDebug = z10;
        PageManger.isDebug = z10;
        PowerManager.isDebug = z10;
        ULogManager.isDebug = z10;
    }

    public static void setPaTimeoutTime(long j10) {
        paTimeoutTime = j10;
    }

    /* access modifiers changed from: private */
    public static void updateLocalCrashConfig(Context context, Map<String, Object> map) {
        if (context != null && map != null) {
            Bundle bundle = new Bundle();
            Object obj = map.get(UMCrashContent.APM_CRASH_USER_MAX_COUNT);
            if (obj != null) {
                if (isDebug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("callback crashMaxUserCount is ");
                    sb.append(obj.toString());
                }
                bundle.putInt("mMaxCustomLogCountPerTypePerDay", Integer.valueOf(obj.toString()).intValue());
                bundle.putInt("mMaxUploadCustomLogCountPerDay", Integer.valueOf(obj.toString()).intValue());
            }
            CrashApi.getInstance().updateCustomInfo(bundle);
        }
    }

    private static void updateLocalCrashSampling(Object obj, Object obj2, Object obj3, Object obj4) {
        CrashApi instance = CrashApi.getInstance();
        if (instance != null) {
            if (obj != null && UMCrashUtils.random(Integer.valueOf(obj.toString()).intValue())) {
                instance.disableLog(16);
            }
            if (obj2 != null && UMCrashUtils.random(Integer.valueOf(obj2.toString()).intValue())) {
                instance.disableLog(1);
            }
            if (obj3 != null && UMCrashUtils.random(Integer.valueOf(obj3.toString()).intValue())) {
                instance.disableLog(LogType.ANR);
            }
            if (obj4 != null && UMCrashUtils.random(Integer.valueOf(obj4.toString()).intValue())) {
                isOpenUserCrash = false;
            }
        }
    }

    private static void useIntlServices(boolean z10) {
        isIntl = z10;
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("useIntlServices is ");
            sb.append(isIntl);
        }
    }

    public static void enableJavaScriptBridge(View view) {
        try {
            H5Manager.setWebView(view);
        } catch (Throwable unused) {
        }
    }

    public static void generateCustomLog(Throwable th, String str, boolean z10, boolean z11) {
        generateCustomLog(th, str, (String) null, z10, z11);
    }

    public static void generateCustomLog(Throwable th, String str, String str2, boolean z10, boolean z11) {
        if (!isOpenUserCrash) {
            Log.e(TAG, "generate user is closed .");
        } else if (th == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
        } else {
            final String str3 = str;
            final Throwable th2 = th;
            final String str4 = str2;
            final boolean z12 = z10;
            final boolean z13 = z11;
            UMCrashThreadPoolExecutorFactory.execute(new Runnable() {
                public void run() {
                    CustomLogInfo customLogInfo;
                    try {
                        UMCustomLogInfoBuilder addLogCat = new UMCustomLogInfoBuilder(str3).stack(th2, str4).addLogCat(z12);
                        if (z13) {
                            StringBuilder sb = new StringBuilder("AllThreadsTraces: \n");
                            for (Map.Entry next : UMCrashUtil.getAllThreadTraces().entrySet()) {
                                sb.append((String) next.getKey());
                                sb.append("\n");
                                sb.append((String) next.getValue());
                                sb.append("\n");
                            }
                            customLogInfo = addLogCat.addSection(sb.toString()).build();
                        } else {
                            customLogInfo = addLogCat.build();
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(UMCrash.KEY_CALLBACK_UMID);
                        arrayList.add(UMCrash.KEY_CALLBACK_UM_INFOS);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                        customLogInfo.mCallbacks = arrayList;
                        String unused = UMCrash.TAG;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("upload is ");
                        sb2.append(UMCrash.isUploadNowUserCrash);
                        customLogInfo.mUploadNow = UMCrash.isUploadNowUserCrash;
                        CrashApi instance = CrashApi.getInstance();
                        if (instance == null) {
                            Log.e(UMCrash.TAG, "CrashApi is null, not init .");
                        } else {
                            instance.generateCustomLog(customLogInfo);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        }
    }

    public static void registerUMCrashCallback(IUMCrashCallbackWithType iUMCrashCallbackWithType) {
        if (iUMCrashCallbackWithType != null) {
            mUMCrashCallbackWithType = iUMCrashCallbackWithType;
        } else {
            Log.e(TAG, "callback error.");
        }
    }

    public static void generateCustomLog(String str, String str2) {
        generateCustomLog(str, str2, false, false);
    }

    public static void generateCustomLog(String str, String str2, boolean z10, boolean z11) {
        generateCustomLog(str, str2, (String) null, z10, z11);
    }

    public static void generateCustomLog(String str, String str2, String str3, boolean z10, boolean z11) {
        if (!isOpenUserCrash) {
            Log.e(TAG, "generate user is closed .");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
        } else {
            final boolean z12 = z10;
            final String str4 = str2;
            final String str5 = str3;
            final String str6 = str;
            final boolean z13 = z11;
            UMCrashThreadPoolExecutorFactory.execute(new Runnable() {
                public void run() {
                    try {
                        CustomLogInfo customLogInfo = new CustomLogInfo((StringBuffer) null, "exception");
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(UMCrash.KEY_CALLBACK_UMID);
                        arrayList.add(UMCrash.KEY_CALLBACK_UM_INFOS);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING);
                        arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                        customLogInfo.mCallbacks = arrayList;
                        String unused = UMCrash.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("upload is ");
                        sb.append(UMCrash.isUploadNowUserCrash);
                        customLogInfo.mUploadNow = UMCrash.isUploadNowUserCrash;
                        customLogInfo.mAddLogcat = z12;
                        HashMap hashMap = new HashMap(20);
                        hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
                        hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_AC, str4);
                        StringBuffer stringBuffer = new StringBuffer();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append(SOAP.DELIM);
                            stringBuffer.append((String) entry.getValue());
                            stringBuffer.append("\n");
                        }
                        String str = str5;
                        if (str == null) {
                            str = "";
                        }
                        String str2 = "Exception message:" + str + "\n" + "Back traces starts." + "\n" + str6 + "\n" + "Back traces ends.";
                        if (!TextUtils.isEmpty(str2)) {
                            stringBuffer.append(str2);
                            stringBuffer.append("\n");
                        }
                        if (z13) {
                            Map<String, String> allThreadTraces = UMCrashUtil.getAllThreadTraces();
                            stringBuffer.append(UMCustomLogInfoBuilder.LOG_SECTION_SEP);
                            stringBuffer.append("\n");
                            stringBuffer.append("AllThreadsTraces: \n");
                            for (Map.Entry next : allThreadTraces.entrySet()) {
                                stringBuffer.append((String) next.getKey());
                                stringBuffer.append("\n");
                                stringBuffer.append((String) next.getValue());
                                stringBuffer.append("\n");
                            }
                        }
                        customLogInfo.mData = stringBuffer;
                        CrashApi instance = CrashApi.getInstance();
                        if (instance == null) {
                            Log.e(UMCrash.TAG, "CrashApi is null, not init .");
                        } else {
                            instance.generateCustomLog(customLogInfo);
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        }
    }
}
