package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengMessageService;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushApi;
import com.umeng.message.api.UPushConnectStateListener;
import com.umeng.message.api.UPushInAppMessageCallback;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.UPushNotificationChannel;
import com.umeng.message.component.UmengMessageHandlerService;
import com.umeng.message.tag.TagManager;

public final class v implements UPushApi {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16052a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f16053b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16054c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16055d;

    /* renamed from: e  reason: collision with root package name */
    private volatile UPushRegisterCallback f16056e;

    /* renamed from: f  reason: collision with root package name */
    private volatile UPushThirdTokenCallback f16057f;

    /* renamed from: g  reason: collision with root package name */
    private volatile UPushSettingCallback f16058g;

    /* renamed from: h  reason: collision with root package name */
    private volatile UPushMessageHandler f16059h;

    /* renamed from: i  reason: collision with root package name */
    private volatile UPushMessageHandler f16060i;

    /* renamed from: j  reason: collision with root package name */
    private volatile UPushInAppMessageCallback f16061j;

    /* renamed from: k  reason: collision with root package name */
    private volatile UPushInAppMessageHandler f16062k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public volatile UPushConnectStateListener f16063l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public volatile boolean f16064m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public volatile ACCSClient f16065n;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final v f16080a = new v((byte) 0);
    }

    public /* synthetic */ v(byte b10) {
        this();
    }

    public final void addAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().addAlias(str, str2, uPushAliasCallback);
    }

    public final void deleteAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().deleteAlias(str, str2, uPushAliasCallback);
    }

    public final void disable(UPushSettingCallback uPushSettingCallback) {
        setSettingCallback(uPushSettingCallback);
        try {
            final Application a10 = y.a();
            TaobaoRegister.unbindAgoo(a10, new ICallback() {
                public final void onFailure(String str, String str2) {
                    UPLog.e("Mgr", "push disable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
                    intent.setClass(a10, cls);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(Constant.KEY_STATUS, false);
                    intent.putExtra(Constants.KEY_HTTP_CODE, str);
                    intent.putExtra("desc", str2);
                    r.enqueueWork(a10, cls, intent);
                }

                public final void onSuccess() {
                    UPLog.i("Mgr", "push disable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
                    intent.setClass(a10, cls);
                    intent.putExtra("um_command", "disable");
                    intent.putExtra(Constant.KEY_STATUS, true);
                    r.enqueueWork(a10, cls, intent);
                }
            });
        } catch (Exception e10) {
            UPLog.e("Mgr", (Throwable) e10);
        }
    }

    public final void enable(UPushSettingCallback uPushSettingCallback) {
        setSettingCallback(uPushSettingCallback);
        try {
            final Application a10 = y.a();
            TaobaoRegister.bindAgoo(a10, new ICallback() {
                public final void onFailure(String str, String str2) {
                    UPLog.i("Mgr", "push enable failed. code:", str, "desc:", str2);
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
                    intent.setClass(a10, cls);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(Constant.KEY_STATUS, false);
                    intent.putExtra(Constants.KEY_HTTP_CODE, str);
                    intent.putExtra("desc", str2);
                    r.enqueueWork(a10, cls, intent);
                }

                public final void onSuccess() {
                    UPLog.i("Mgr", "push enable success.");
                    Intent intent = new Intent("com.umeng.message.action");
                    intent.setPackage(a10.getPackageName());
                    Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
                    intent.setClass(a10, cls);
                    intent.putExtra("um_command", "enable");
                    intent.putExtra(Constant.KEY_STATUS, true);
                    r.enqueueWork(a10, cls, intent);
                }
            });
        } catch (Exception e10) {
            UPLog.e("Mgr", (Throwable) e10);
        }
    }

    public final UPushConnectStateListener getConnectStateListener() {
        return this.f16063l;
    }

    public final int getDisplayNotificationNumber() {
        return MessageSharedPrefs.getInstance(y.a()).b();
    }

    public final UPushInAppMessageCallback getInAppMessageCallback() {
        return this.f16061j;
    }

    public final UPushInAppMessageHandler getInAppMessageHandler() {
        return this.f16062k;
    }

    public final String getMessageAppkey() {
        Application a10 = y.a();
        String appkey = UMUtils.getAppkey(a10);
        if (!TextUtils.isEmpty(appkey)) {
            return appkey;
        }
        String c10 = MessageSharedPrefs.getInstance(a10).c();
        if (!TextUtils.isEmpty(c10)) {
            return c10;
        }
        return d.a((Context) a10, "UMENG_APPKEY");
    }

    public final String getMessageChannel() {
        Application a10 = y.a();
        String channel = UMUtils.getChannel(a10);
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        String b10 = MessageSharedPrefs.getInstance(a10).f15211b.b("channel", "");
        if (!TextUtils.isEmpty(b10)) {
            return b10;
        }
        return d.n(a10);
    }

    public final UPushMessageHandler getMessageHandler() {
        if (this.f16059h == null) {
            this.f16059h = new UmengMessageHandler();
        }
        return this.f16059h;
    }

    public final UPushMessageNotifyApi getMessageNotifyApi() {
        return aw.a();
    }

    public final String getMessageSecret() {
        Application a10 = y.a();
        String b10 = MessageSharedPrefs.getInstance(a10).f15211b.b("message_secret", "");
        if (!TextUtils.isEmpty(b10)) {
            return b10;
        }
        return d.a((Context) a10, "UMENG_MESSAGE_SECRET");
    }

    public final int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(y.a()).g();
    }

    public final int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(y.a()).f15211b.b("end_hour", 7);
    }

    public final int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(y.a()).f15211b.b("end_minute", 0);
    }

    public final int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(y.a()).f15211b.b("start_hour", 23);
    }

    public final int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(y.a()).f15211b.b("start_minute", 0);
    }

    public final String getNotificationChannelName() {
        String b10 = MessageSharedPrefs.getInstance(y.a()).f15211b.b("notification_channel_default", "");
        if (TextUtils.isEmpty(b10)) {
            return UPushNotificationChannel.DEFAULT_NOTIFICATION_CHANNEL_NAME;
        }
        return b10;
    }

    public final UPushMessageHandler getNotificationClickHandler() {
        if (this.f16060i == null) {
            this.f16060i = new UmengNotificationClickHandler();
        }
        return this.f16060i;
    }

    public final boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(y.a()).f15211b.b("notification_foreground_show", true);
    }

    public final int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(y.a()).j();
    }

    public final int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(y.a()).k();
    }

    public final int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(y.a()).i();
    }

    public final String getNotificationSilenceChannelName() {
        String b10 = MessageSharedPrefs.getInstance(y.a()).f15211b.b("notification_channel_silence", "");
        if (TextUtils.isEmpty(b10)) {
            return UPushNotificationChannel.DEFAULT_NOTIFICATION_SILENCE_CHANNEL_NAME;
        }
        return b10;
    }

    public final String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(y.a()).e();
    }

    public final UPushRegisterCallback getRegisterCallback() {
        return this.f16056e;
    }

    public final String getRegistrationId() {
        return MessageSharedPrefs.getInstance(y.a()).l();
    }

    public final String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(y.a()).h();
    }

    public final UPushSettingCallback getSettingCallback() {
        return this.f16058g;
    }

    public final TagManager getTagManager() {
        return TagManager.getInstance();
    }

    public final UPushThirdTokenCallback getThirdTokenCallback() {
        return this.f16057f;
    }

    public final boolean isConnected() {
        try {
            ACCSClient aCCSClient = this.f16065n;
            if (aCCSClient != null) {
                return aCCSClient.isAccsConnected();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean isPushCheck() {
        return this.f16055d;
    }

    public final void keepLowPowerMode(boolean z10) {
        this.f16052a = z10;
    }

    public final void onAppStart() {
        b.b(new Runnable() {
            public final void run() {
                z.a().b();
            }
        });
    }

    public final void register(UPushRegisterCallback uPushRegisterCallback) {
        if (!(uPushRegisterCallback == null || uPushRegisterCallback == this.f16056e)) {
            this.f16056e = uPushRegisterCallback;
        }
        AnonymousClass1 r32 = new Runnable() {
            public final void run() {
                v.a(v.this);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b.c(r32);
        } else {
            r32.run();
        }
    }

    public final void setAccsHeartbeatEnable(boolean z10) {
        this.f16054c = z10;
    }

    public final void setAlias(String str, String str2, UPushAliasCallback uPushAliasCallback) {
        UTrack.getInstance().setAlias(str, str2, uPushAliasCallback);
    }

    public final void setConnectStateListener(UPushConnectStateListener uPushConnectStateListener) {
        this.f16063l = uPushConnectStateListener;
    }

    public final void setDisplayNotificationNumber(int i10) {
        if (i10 >= 0 && i10 <= 10) {
            MessageSharedPrefs.getInstance(y.a()).f15211b.a("notification_number", i10);
        }
    }

    public final void setEnableAlarmHeartbeat(boolean z10) {
        try {
            GlobalConfig.setAlarmHeartbeatEnable(z10);
        } catch (Throwable th) {
            UPLog.e("Mgr", th);
        }
    }

    public final void setEnableForeground(boolean z10) {
        try {
            GlobalConfig.setEnableForeground(y.a(), z10);
        } catch (Throwable unused) {
        }
    }

    public final void setEnableJobHeartbeat(boolean z10) {
        try {
            GlobalConfig.setJobHeartbeatEnable(z10);
        } catch (Throwable th) {
            UPLog.e("Mgr", th);
        }
    }

    public final void setInAppMessageCallback(UPushInAppMessageCallback uPushInAppMessageCallback) {
        this.f16061j = uPushInAppMessageCallback;
    }

    public final void setInAppMessageHandler(UPushInAppMessageHandler uPushInAppMessageHandler) {
        this.f16062k = uPushInAppMessageHandler;
    }

    public final void setMessageHandler(UPushMessageHandler uPushMessageHandler) {
        this.f16059h = uPushMessageHandler;
    }

    public final void setMuteDurationSeconds(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("mute_duration", i10);
    }

    public final void setNoDisturbMode(int i10, int i11, int i12, int i13) {
        MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
        instance.f15211b.a("start_hour", i10);
        instance.f15211b.a("start_minute", i11);
        instance.f15211b.a("end_hour", i12);
        instance.f15211b.a("end_minute", i13);
    }

    public final void setNotificationChannelName(String str) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("notification_channel_default", str);
    }

    public final void setNotificationClickHandler(UPushMessageHandler uPushMessageHandler) {
        this.f16060i = uPushMessageHandler;
    }

    public final void setNotificationOnForeground(boolean z10) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("notification_foreground_show", z10);
    }

    public final void setNotificationPlayLights(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("notification_light", i10);
    }

    public final void setNotificationPlaySound(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("notification_sound", i10);
    }

    public final void setNotificationPlayVibrate(int i10) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("notification_vibrate", i10);
    }

    public final void setNotificationSilenceChannelName(String str) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("notification_channel_silence", str);
    }

    public final void setPullUpEnable(boolean z10) {
        this.f16053b = z10;
    }

    public final void setPushCheck(boolean z10) {
        this.f16055d = z10;
    }

    public final <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
        if (cls == null) {
            instance.f15211b.a("service_class");
        } else {
            instance.f15211b.a("service_class", cls.getName());
        }
    }

    public final void setRegisterCallback(UPushRegisterCallback uPushRegisterCallback) {
        this.f16056e = uPushRegisterCallback;
    }

    public final void setReportThirdTokenDelay(int i10) {
        try {
            GlobalConfig.setReportThirdTokenDelay(i10);
        } catch (Throwable th) {
            UPLog.e("Mgr", th);
        }
    }

    public final void setResourcePackageName(String str) {
        MessageSharedPrefs.getInstance(y.a()).f15211b.a("res_pkg", str);
    }

    public final void setSettingCallback(UPushSettingCallback uPushSettingCallback) {
        this.f16058g = uPushSettingCallback;
    }

    public final void setThirdTokenCallback(UPushThirdTokenCallback uPushThirdTokenCallback) {
        this.f16057f = uPushThirdTokenCallback;
    }

    private v() {
        this.f16053b = true;
    }

    public static UPushApi a() {
        return a.f16080a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:33|34|35|36|37|38|39|40|41|42|43|44|(2:46|47)|48|49|(6:51|52|53|(2:55|56)|60|(1:62)(17:63|(1:65)|66|67|68|69|(3:71|72|(2:74|(6:76|78|(2:82|(1:84))|85|(2:89|(2:91|92))|(2:94|95))))|77|78|80|82|(0)|85|87|89|(0)|(0)))|96|98) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0085 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0088 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x008b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0093 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A[SYNTHETIC, Splitter:B:46:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015a A[Catch:{ all -> 0x0185, all -> 0x02a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0231 A[Catch:{ all -> 0x0280 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0266 A[Catch:{ all -> 0x0280 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x027d A[SYNTHETIC, Splitter:B:94:0x027d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(com.umeng.message.proguard.v r17) {
        /*
            r1 = r17
            java.lang.String r2 = "cfg"
            java.lang.String r3 = "AutoLoad"
            java.lang.String r4 = "register failed."
            java.lang.String r5 = "-1"
            java.lang.String r6 = "register failed! code: -1"
            java.lang.String r7 = "Mgr"
            r8 = 1
            r9 = 0
            boolean r0 = com.umeng.message.proguard.f.b()     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x0035
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ all -> 0x02a7 }
            java.lang.String r2 = "init failed. silent mode!"
            r0[r9] = r2     // Catch:{ all -> 0x02a7 }
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)     // Catch:{ all -> 0x02a7 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)
            com.umeng.message.api.UPushRegisterCallback r0 = r17.getRegisterCallback()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002f
            r0.onFailure(r5, r4)     // Catch:{ all -> 0x0030 }
        L_0x002f:
            return
        L_0x0030:
            r0 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Throwable) r0)
            return
        L_0x0035:
            android.app.Application r0 = com.umeng.message.proguard.y.a()     // Catch:{ all -> 0x02a7 }
            boolean r10 = r17.isPushCheck()     // Catch:{ all -> 0x02a7 }
            if (r10 == 0) goto L_0x0064
            boolean r10 = com.umeng.message.proguard.k.a(r0)     // Catch:{ all -> 0x02a7 }
            if (r10 != 0) goto L_0x0064
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ all -> 0x02a7 }
            java.lang.String r2 = "AndroidManifest config error!"
            r0[r9] = r2     // Catch:{ all -> 0x02a7 }
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)     // Catch:{ all -> 0x02a7 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)
            com.umeng.message.api.UPushRegisterCallback r0 = r17.getRegisterCallback()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x005e
            r0.onFailure(r5, r4)     // Catch:{ all -> 0x005f }
        L_0x005e:
            return
        L_0x005f:
            r0 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Throwable) r0)
            return
        L_0x0064:
            java.lang.String r10 = r17.getMessageAppkey()     // Catch:{ all -> 0x02a7 }
            java.lang.String r11 = r17.getMessageSecret()     // Catch:{ all -> 0x02a7 }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x02a7 }
            if (r12 != 0) goto L_0x0288
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x02a7 }
            if (r12 == 0) goto L_0x007a
            goto L_0x0288
        L_0x007a:
            java.lang.Class<com.umeng.message.component.UmengMessageHandlerService> r12 = com.umeng.message.component.UmengMessageHandlerService.class
            com.umeng.message.proguard.f.a((android.content.Context) r0, (java.lang.Class<?>) r12)     // Catch:{ all -> 0x02a7 }
            anet.channel.AwcnConfig.setAccsSessionCreateForbiddenInBg(r9)     // Catch:{ all -> 0x0082 }
        L_0x0082:
            anet.channel.AwcnConfig.setWifiInfoEnable(r9)     // Catch:{ all -> 0x0085 }
        L_0x0085:
            anet.channel.strategy.dispatch.AmdcRuntimeInfo.setForceHttps(r8)     // Catch:{ all -> 0x0088 }
        L_0x0088:
            anet.channel.strategy.dispatch.AmdcRuntimeInfo.setTimeoutRetryEnable(r9)     // Catch:{ all -> 0x008b }
        L_0x008b:
            boolean r12 = r1.f16052a     // Catch:{ all -> 0x02a7 }
            r12 = r12 ^ r8
            if (r12 != 0) goto L_0x0093
            anet.channel.AwcnConfig.setIdleSessionCloseEnable(r9)     // Catch:{ all -> 0x0093 }
        L_0x0093:
            java.lang.String r13 = com.umeng.message.proguard.f.a((android.content.Context) r0)     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.v$3 r14 = new com.umeng.message.proguard.v$3     // Catch:{ all -> 0x02a7 }
            r14.<init>(r13)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.client.GlobalConfig.setCurrProcessNameImpl(r14)     // Catch:{ all -> 0x02a7 }
            anet.channel.GlobalAppRuntimeInfo.setCurrentProcess(r13)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig$Builder r13 = new com.taobao.accs.AccsClientConfig$Builder     // Catch:{ all -> 0x02a7 }
            r13.<init>()     // Catch:{ all -> 0x02a7 }
            java.lang.String r14 = "umeng:"
            java.lang.String r15 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x02a7 }
            java.lang.String r14 = r14.concat(r15)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig$Builder r14 = r13.setAppKey(r14)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig$Builder r14 = r14.setAppSecret(r11)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig$Builder r12 = r14.setKeepAlive(r12)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig$Builder r12 = r12.setDisableChannel(r8)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig$Builder r12 = r12.setAutoUnit(r9)     // Catch:{ all -> 0x02a7 }
            java.lang.String r14 = "default"
            com.taobao.accs.AccsClientConfig$Builder r12 = r12.setTag(r14)     // Catch:{ all -> 0x02a7 }
            boolean r14 = r1.f16053b     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig$Builder r12 = r12.setPullUpEnable(r14)     // Catch:{ all -> 0x02a7 }
            boolean r14 = r1.f16054c     // Catch:{ all -> 0x02a7 }
            r12.setAccsHeartbeatEnable(r14)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.ACCSClient.setEnvironment(r0, r9)     // Catch:{ all -> 0x02a7 }
            r13.setConfigEnv(r9)     // Catch:{ all -> 0x02a7 }
            java.lang.String r12 = "umengacs.m.taobao.com"
            r13.setInappHost(r12)     // Catch:{ all -> 0x02a7 }
            r12 = 11
            r13.setInappPubKey(r12)     // Catch:{ all -> 0x02a7 }
            java.lang.String r14 = "umengjmacs.m.taobao.com"
            r13.setChannelHost(r14)     // Catch:{ all -> 0x02a7 }
            r13.setChannelPubKey(r12)     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.AccsClientConfig r12 = r13.build()     // Catch:{ all -> 0x02a7 }
            com.taobao.accs.ACCSClient.init((android.content.Context) r0, (com.taobao.accs.AccsClientConfig) r12)     // Catch:{ all -> 0x02a7 }
            java.lang.String r12 = "deviceId"
            java.lang.String r13 = com.umeng.ut.device.UTDevice.getUtdid(r0)     // Catch:{ all -> 0x02a7 }
            anet.channel.strategy.dispatch.AmdcRuntimeInfo.setParam(r12, r13)     // Catch:{ all -> 0x02a7 }
            r12 = 3
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ all -> 0x02a7 }
            java.lang.String r14 = "amdcopen.m.umeng.com"
            r13[r9] = r14     // Catch:{ all -> 0x02a7 }
            java.lang.String r14 = "pre-amdcopen.m.umeng.com"
            r13[r8] = r14     // Catch:{ all -> 0x02a7 }
            java.lang.String r14 = "amdc.taobao.net"
            r15 = 2
            r13[r15] = r14     // Catch:{ all -> 0x02a7 }
            anet.channel.strategy.dispatch.DispatchConstants.setAmdcServerDomain(r13)     // Catch:{ all -> 0x02a7 }
            java.lang.String[][] r13 = new java.lang.String[r12][]     // Catch:{ all -> 0x02a7 }
            r14 = 0
            java.lang.String[] r16 = new java.lang.String[]{r14, r14}     // Catch:{ all -> 0x02a7 }
            r13[r9] = r16     // Catch:{ all -> 0x02a7 }
            r13[r8] = r14     // Catch:{ all -> 0x02a7 }
            r13[r15] = r14     // Catch:{ all -> 0x02a7 }
            anet.channel.strategy.dispatch.DispatchConstants.setAmdcServerFixIp(r13)     // Catch:{ all -> 0x02a7 }
            java.lang.Class<com.umeng.message.component.UmengIntentService> r13 = com.umeng.message.component.UmengIntentService.class
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x02a7 }
            com.taobao.agoo.TaobaoRegister.setAgooMsgReceiveService(r13)     // Catch:{ all -> 0x02a7 }
            java.lang.Object[] r13 = new java.lang.Object[r15]     // Catch:{ all -> 0x02a7 }
            java.lang.String r16 = "version:"
            r13[r9] = r16     // Catch:{ all -> 0x02a7 }
            java.lang.String r16 = "6.7.0"
            r13[r8] = r16     // Catch:{ all -> 0x02a7 }
            com.umeng.message.common.UPLog.i(r7, r13)     // Catch:{ all -> 0x02a7 }
            r13 = 4
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ all -> 0x02a7 }
            java.lang.String r16 = "appkey:"
            r13[r9] = r16     // Catch:{ all -> 0x02a7 }
            r13[r8] = r10     // Catch:{ all -> 0x02a7 }
            java.lang.String r16 = "appSecret:"
            r13[r15] = r16     // Catch:{ all -> 0x02a7 }
            r13[r12] = r11     // Catch:{ all -> 0x02a7 }
            com.umeng.message.common.UPLog.i(r7, r13)     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.v$4 r12 = new com.umeng.message.proguard.v$4     // Catch:{ all -> 0x02a7 }
            r12.<init>(r0, r10, r11)     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.b.c(r12)     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.u.b()     // Catch:{ all -> 0x02a7 }
            boolean r10 = com.umeng.message.proguard.f.b(r0)     // Catch:{ all -> 0x02a7 }
            if (r10 == 0) goto L_0x0280
            com.umeng.message.proguard.i.a()     // Catch:{ all -> 0x02a7 }
            com.umeng.message.common.UPLog.upload()     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.al r10 = com.umeng.message.proguard.ak.a()     // Catch:{ all -> 0x02a7 }
            r10.a((android.content.Context) r0)     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.de.a(r0)     // Catch:{ all -> 0x0185 }
            android.content.Context r0 = com.umeng.message.proguard.de.a()     // Catch:{ all -> 0x0185 }
            java.lang.String r10 = "autoad"
            java.lang.String r14 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r0, r10, r14)     // Catch:{ all -> 0x0185 }
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0185 }
            if (r0 != 0) goto L_0x0191
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0185 }
            byte[] r10 = com.umeng.message.proguard.bf.a((java.lang.String) r14)     // Catch:{ all -> 0x0185 }
            r0.<init>(r10)     // Catch:{ all -> 0x0185 }
            r14 = r0
            goto L_0x0191
        L_0x0185:
            r0 = move-exception
            java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x02a7 }
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x02a7 }
            r10[r9] = r0     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.ce.d(r3, r10)     // Catch:{ all -> 0x02a7 }
        L_0x0191:
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x019c
            com.umeng.message.proguard.bv.a(r9)     // Catch:{ all -> 0x02a7 }
            goto L_0x0280
        L_0x019c:
            java.lang.Object[] r0 = new java.lang.Object[r15]     // Catch:{ all -> 0x02a7 }
            java.lang.String r10 = "cfg: "
            r0[r9] = r10     // Catch:{ all -> 0x02a7 }
            r0[r8] = r14     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.ce.b(r3, r0)     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.dt r0 = com.umeng.message.proguard.dt.a()     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.du r0 = r0.f15882a     // Catch:{ all -> 0x02a7 }
            java.lang.String r3 = ""
            java.lang.String r0 = r0.b((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x02a7 }
            boolean r0 = android.text.TextUtils.equals(r0, r14)     // Catch:{ all -> 0x02a7 }
            if (r0 != 0) goto L_0x01ca
            com.umeng.message.proguard.ds r0 = com.umeng.message.proguard.ds.a()     // Catch:{ all -> 0x02a7 }
            android.content.SharedPreferences r0 = r0.f15880a     // Catch:{ all -> 0x02a7 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x02a7 }
            android.content.SharedPreferences$Editor r0 = r0.clear()     // Catch:{ all -> 0x02a7 }
            r0.apply()     // Catch:{ all -> 0x02a7 }
        L_0x01ca:
            com.umeng.message.proguard.dt r0 = com.umeng.message.proguard.dt.a()     // Catch:{ all -> 0x02a7 }
            com.umeng.message.proguard.du r0 = r0.f15882a     // Catch:{ all -> 0x02a7 }
            r0.a((java.lang.String) r2, (java.lang.String) r14)     // Catch:{ all -> 0x02a7 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0280 }
            r0.<init>(r14)     // Catch:{ all -> 0x0280 }
            com.umeng.message.proguard.bx$c r2 = com.umeng.message.proguard.bx.c.BANNER     // Catch:{ all -> 0x0280 }
            int r2 = com.umeng.message.proguard.bt.a((com.umeng.message.proguard.bx.c) r2)     // Catch:{ all -> 0x0280 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0280 }
            boolean r3 = r0.has(r2)     // Catch:{ all -> 0x0280 }
            java.lang.String r10 = "sc"
            if (r3 == 0) goto L_0x0210
            org.json.JSONObject r2 = r0.optJSONObject(r2)     // Catch:{ all -> 0x0280 }
            if (r2 == 0) goto L_0x0210
            java.lang.String r2 = r2.optString(r10)     // Catch:{ all -> 0x0280 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0280 }
            if (r3 != 0) goto L_0x0210
            com.umeng.message.proguard.bw$a r3 = new com.umeng.message.proguard.bw$a     // Catch:{ all -> 0x0280 }
            r3.<init>()     // Catch:{ all -> 0x0280 }
            r3.f15546a = r2     // Catch:{ all -> 0x0280 }
            com.umeng.message.proguard.bw r2 = r3.a()     // Catch:{ all -> 0x0280 }
            com.umeng.message.proguard.df r3 = com.umeng.message.proguard.df.a.f15749a     // Catch:{ all -> 0x0280 }
            r3.f15745b = r2     // Catch:{ all -> 0x0280 }
            r3.a()     // Catch:{ all -> 0x0280 }
            r2 = 1
            goto L_0x0211
        L_0x0210:
            r2 = 0
        L_0x0211:
            com.umeng.message.proguard.bx$c r3 = com.umeng.message.proguard.bx.c.INTERSTITIAL     // Catch:{ all -> 0x0280 }
            int r3 = com.umeng.message.proguard.bt.a((com.umeng.message.proguard.bx.c) r3)     // Catch:{ all -> 0x0280 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0280 }
            boolean r11 = r0.has(r3)     // Catch:{ all -> 0x0280 }
            if (r11 == 0) goto L_0x0246
            org.json.JSONObject r3 = r0.optJSONObject(r3)     // Catch:{ all -> 0x0280 }
            if (r3 == 0) goto L_0x0246
            java.lang.String r3 = r3.optString(r10)     // Catch:{ all -> 0x0280 }
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0280 }
            if (r11 != 0) goto L_0x0246
            com.umeng.message.proguard.bw$a r2 = new com.umeng.message.proguard.bw$a     // Catch:{ all -> 0x0280 }
            r2.<init>()     // Catch:{ all -> 0x0280 }
            r2.f15546a = r3     // Catch:{ all -> 0x0280 }
            com.umeng.message.proguard.bw r2 = r2.a()     // Catch:{ all -> 0x0280 }
            com.umeng.message.proguard.df r3 = com.umeng.message.proguard.df.a.f15749a     // Catch:{ all -> 0x0280 }
            r3.f15744a = r2     // Catch:{ all -> 0x0280 }
            r3.a()     // Catch:{ all -> 0x0280 }
            r2 = 1
        L_0x0246:
            com.umeng.message.proguard.bx$c r3 = com.umeng.message.proguard.bx.c.FLOATING_ICON     // Catch:{ all -> 0x0280 }
            int r3 = com.umeng.message.proguard.bt.a((com.umeng.message.proguard.bx.c) r3)     // Catch:{ all -> 0x0280 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0280 }
            boolean r11 = r0.has(r3)     // Catch:{ all -> 0x0280 }
            if (r11 == 0) goto L_0x027b
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x0280 }
            if (r0 == 0) goto L_0x027b
            java.lang.String r0 = r0.optString(r10)     // Catch:{ all -> 0x0280 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0280 }
            if (r3 != 0) goto L_0x027b
            com.umeng.message.proguard.bw$a r2 = new com.umeng.message.proguard.bw$a     // Catch:{ all -> 0x0280 }
            r2.<init>()     // Catch:{ all -> 0x0280 }
            r2.f15546a = r0     // Catch:{ all -> 0x0280 }
            com.umeng.message.proguard.bw r0 = r2.a()     // Catch:{ all -> 0x0280 }
            com.umeng.message.proguard.df r2 = com.umeng.message.proguard.df.a.f15749a     // Catch:{ all -> 0x0280 }
            r2.f15746c = r0     // Catch:{ all -> 0x0280 }
            r2.a()     // Catch:{ all -> 0x0280 }
            r2 = 1
        L_0x027b:
            if (r2 == 0) goto L_0x0280
            com.umeng.message.proguard.bv.a(r8)     // Catch:{ all -> 0x02a7 }
        L_0x0280:
            com.umeng.message.proguard.aw r0 = com.umeng.message.proguard.aw.a()     // Catch:{ all -> 0x02a7 }
            r0.b()     // Catch:{ all -> 0x02a7 }
            return
        L_0x0288:
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ all -> 0x02a7 }
            java.lang.String r2 = "Appkey、MessageSecret cannot be empty!"
            r0[r9] = r2     // Catch:{ all -> 0x02a7 }
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)     // Catch:{ all -> 0x02a7 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)
            com.umeng.message.api.UPushRegisterCallback r0 = r17.getRegisterCallback()     // Catch:{ all -> 0x02a2 }
            if (r0 == 0) goto L_0x02a1
            r0.onFailure(r5, r4)     // Catch:{ all -> 0x02a2 }
        L_0x02a1:
            return
        L_0x02a2:
            r0 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Throwable) r0)
            return
        L_0x02a7:
            r0 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02c1 }
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)
            com.umeng.message.api.UPushRegisterCallback r0 = r17.getRegisterCallback()     // Catch:{ all -> 0x02bc }
            if (r0 == 0) goto L_0x02bb
            r0.onFailure(r5, r4)     // Catch:{ all -> 0x02bc }
        L_0x02bb:
            return
        L_0x02bc:
            r0 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Throwable) r0)
            return
        L_0x02c1:
            r0 = move-exception
            r2 = r0
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r9] = r6
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Object[]) r0)
            com.umeng.message.api.UPushRegisterCallback r0 = r17.getRegisterCallback()     // Catch:{ all -> 0x02d4 }
            if (r0 == 0) goto L_0x02d8
            r0.onFailure(r5, r4)     // Catch:{ all -> 0x02d4 }
            goto L_0x02d8
        L_0x02d4:
            r0 = move-exception
            com.umeng.message.common.UPLog.e((java.lang.String) r7, (java.lang.Throwable) r0)
        L_0x02d8:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.v.a(com.umeng.message.proguard.v):void");
    }
}
