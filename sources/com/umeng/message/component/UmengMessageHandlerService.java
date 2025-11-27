package com.umeng.message.component;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.LruCache;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.taobao.agoo.a.a.c;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushSettingCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.h;
import com.umeng.message.proguard.j;
import com.umeng.message.proguard.o;
import com.umeng.message.proguard.r;
import com.umeng.message.proguard.v;
import com.umeng.message.proguard.w;
import com.umeng.message.proguard.y;
import com.umeng.message.proguard.z;
import org.json.JSONObject;

public final class UmengMessageHandlerService extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final LruCache<String, String> f15220a = new LruCache<>(3);

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f15221b = 0;

    public final void onHandleWork(Intent intent) {
        UPushMessageHandler messageHandler;
        Intent intent2 = intent;
        final Application a10 = y.a();
        if (a10 == null) {
            UPLog.i("MsgHandlerService", "context null!");
        } else if (intent2 != null) {
            String action = intent.getAction();
            String stringExtra = intent2.getStringExtra("um_command");
            UPLog.i("MsgHandlerService", "action:", action, stringExtra);
            if (TextUtils.equals("com.umeng.message.action", action)) {
                if (stringExtra == null || stringExtra.length() == 0) {
                    return;
                }
                char c10 = 65535;
                switch (stringExtra.hashCode()) {
                    case -1298848381:
                        if (stringExtra.equals("enable")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1224577496:
                        if (stringExtra.equals("handle")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -690213213:
                        if (stringExtra.equals(c.JSON_CMD_REGISTER)) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 3526536:
                        if (stringExtra.equals("send")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case 443595041:
                        if (stringExtra.equals("third_token")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case 1671308008:
                        if (stringExtra.equals("disable")) {
                            c10 = 5;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        try {
                            boolean booleanExtra = intent2.getBooleanExtra(Constant.KEY_STATUS, false);
                            UPushSettingCallback settingCallback = v.a().getSettingCallback();
                            UPLog.i("MsgHandlerService", "push open status:".concat(String.valueOf(booleanExtra)));
                            if (booleanExtra) {
                                if (settingCallback != null) {
                                    settingCallback.onSuccess();
                                    return;
                                }
                                return;
                            } else if (settingCallback != null) {
                                settingCallback.onFailure(intent2.getStringExtra(Constants.KEY_HTTP_CODE), intent2.getStringExtra("desc"));
                                return;
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            UPLog.e("MsgHandlerService", th);
                            return;
                        }
                    case 1:
                        try {
                            String stringExtra2 = intent2.getStringExtra("body");
                            if (stringExtra2 != null) {
                                UMessage uMessage = new UMessage(new JSONObject(stringExtra2));
                                if ((!"notification".equals(uMessage.getDisplayType()) || !uMessage.hasResourceFromInternet() || !j.a().a(intent2)) && (messageHandler = v.a().getMessageHandler()) != null) {
                                    messageHandler.handleMessage(a10, uMessage);
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            UPLog.e("MsgHandlerService", th2);
                            return;
                        }
                    case 2:
                        try {
                            final String stringExtra3 = intent2.getStringExtra("registration_id");
                            boolean booleanExtra2 = intent2.getBooleanExtra(Constant.KEY_STATUS, false);
                            UPLog.i("MsgHandlerService", "deviceToken:", stringExtra3, "status:", Boolean.valueOf(booleanExtra2));
                            final UPushRegisterCallback registerCallback = v.a().getRegisterCallback();
                            if (booleanExtra2) {
                                try {
                                    b.c(new Runnable() {
                                        public final void run() {
                                            String str = "";
                                            try {
                                                MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
                                                str = instance.l();
                                                String str2 = stringExtra3;
                                                if (!(str2 == null || str == null || str2.equals(str))) {
                                                    String str3 = stringExtra3;
                                                    if (str3 == null) {
                                                        instance.f15211b.a("device_token");
                                                    } else {
                                                        instance.f15211b.a("device_token", str3);
                                                    }
                                                    Context context = a10;
                                                    instance.f15211b.a("has_register");
                                                    instance.f15211b.a(f.f14201p);
                                                    instance.f15211b.a("re_pop_times");
                                                    instance.f15211b.a("re_pop_cfg");
                                                    instance.f15211b.a("tags");
                                                    instance.f15211b.a("tag_remain");
                                                    instance.b("tag_add_");
                                                    instance.b("tag_del_");
                                                    instance.b("tag_get_");
                                                    instance.b("alias_del_");
                                                    instance.b("alias_set_");
                                                    instance.b("alias_add_");
                                                    context.getContentResolver().delete(h.b(context), (String) null, (String[]) null);
                                                }
                                            } catch (Throwable th) {
                                                UPLog.e("MsgHandlerService", th);
                                            }
                                            try {
                                                UPushRegisterCallback uPushRegisterCallback = registerCallback;
                                                if (uPushRegisterCallback != null) {
                                                    uPushRegisterCallback.onSuccess(stringExtra3);
                                                }
                                            } catch (Throwable th2) {
                                                UPLog.e("MsgHandlerService", th2);
                                            }
                                            z a10 = z.a();
                                            if (!z.c()) {
                                                MessageSharedPrefs instance2 = MessageSharedPrefs.getInstance(y.a());
                                                if (!instance2.f15211b.b("has_register", false) && !z.f16086a) {
                                                    z.f16086a = true;
                                                    b.c(new Runnable(str, instance2) {

                                                        /* renamed from: a  reason: collision with root package name */
                                                        final /* synthetic */ String f16096a;

                                                        /* renamed from: b  reason: collision with root package name */
                                                        final /* synthetic */ MessageSharedPrefs f16097b;

                                                        {
                                                            this.f16096a = r2;
                                                            this.f16097b = r3;
                                                        }

                                                        public final void run() {
                                                            try {
                                                                z.this.f16089c.a(this.f16096a);
                                                                UPLog.i("Track", "trackRegister deviceToken:", this.f16097b.l());
                                                            } catch (Throwable th) {
                                                                UPLog.e("Track", th);
                                                            } finally {
                                                                boolean unused = z.f16086a = false;
                                                            }
                                                        }
                                                    });
                                                }
                                            }
                                            v.a().onAppStart();
                                            o.a();
                                        }
                                    });
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    UPLog.e("MsgHandlerService", th);
                                    return;
                                }
                            } else {
                                if (registerCallback != null) {
                                    registerCallback.onFailure(intent2.getStringExtra(Constants.KEY_HTTP_CODE), intent2.getStringExtra("desc"));
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            UPLog.e("MsgHandlerService", th);
                            return;
                        }
                    case 3:
                        try {
                            String stringExtra4 = intent2.getStringExtra("send_message");
                            if (stringExtra4 != null) {
                                String stringExtra5 = intent2.getStringExtra("um_px_path");
                                JSONObject jSONObject = new JSONObject(stringExtra4);
                                jSONObject.put("um_px_path", stringExtra5);
                                UMWorkDispatch.sendEvent(a10, 16388, w.a(), jSONObject.toString());
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            UPLog.e("MsgHandlerService", th5);
                            return;
                        }
                    case 4:
                        try {
                            String stringExtra6 = intent2.getStringExtra("third_token");
                            String a11 = com.umeng.message.proguard.f.a(intent2.getStringExtra("type"));
                            if (!TextUtils.isEmpty(a11)) {
                                if (!TextUtils.isEmpty(stringExtra6)) {
                                    LruCache<String, String> lruCache = f15220a;
                                    if (TextUtils.equals(lruCache.get(a11), stringExtra6)) {
                                        UPLog.i("MsgHandlerService", "third push callback skipped! already called.");
                                        return;
                                    }
                                    UPLog.i("MsgHandlerService", "third push type:", a11, "token:", stringExtra6);
                                    UPushThirdTokenCallback thirdTokenCallback = v.a().getThirdTokenCallback();
                                    if (thirdTokenCallback != null) {
                                        thirdTokenCallback.onToken(a11, stringExtra6);
                                    } else {
                                        String pushIntentServiceClass = v.a().getPushIntentServiceClass();
                                        if (!TextUtils.isEmpty(pushIntentServiceClass)) {
                                            Class<?> cls = Class.forName(pushIntentServiceClass);
                                            Intent intent3 = new Intent();
                                            intent3.setPackage(a10.getPackageName());
                                            intent3.putExtra("um_command", "third_token");
                                            intent3.putExtra("third_token", stringExtra6);
                                            intent3.putExtra("type", a11);
                                            intent3.setClass(a10, cls);
                                            r.enqueueWork(a10, cls, intent3);
                                        }
                                    }
                                    lruCache.put(a11, stringExtra6);
                                    return;
                                }
                            }
                            UPLog.i("MsgHandlerService", "third push skipped! type:", a11, "token:", stringExtra6);
                            return;
                        } catch (Throwable th6) {
                            UPLog.e("MsgHandlerService", th6);
                            return;
                        }
                    case 5:
                        try {
                            boolean booleanExtra3 = intent2.getBooleanExtra(Constant.KEY_STATUS, false);
                            UPushSettingCallback settingCallback2 = v.a().getSettingCallback();
                            UPLog.i("MsgHandlerService", "push close status:".concat(String.valueOf(booleanExtra3)));
                            if (booleanExtra3) {
                                if (settingCallback2 != null) {
                                    settingCallback2.onSuccess();
                                    return;
                                }
                                return;
                            } else if (settingCallback2 != null) {
                                settingCallback2.onFailure(intent2.getStringExtra(Constants.KEY_HTTP_CODE), intent2.getStringExtra("desc"));
                                return;
                            } else {
                                return;
                            }
                        } catch (Throwable th7) {
                            UPLog.e("MsgHandlerService", th7);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }
}
