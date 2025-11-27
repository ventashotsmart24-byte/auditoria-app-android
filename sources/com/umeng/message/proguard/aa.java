package com.umeng.message.proguard;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.component.UmengMessageHandlerService;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class aa extends ab {
    public final void a(String str, int i10, String str2) {
        String str3;
        NotificationManager notificationManager;
        List<Object> a10;
        String str4 = str;
        int i11 = i10;
        Application a11 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        String str5 = "";
        jSONObject3.put("pa", str5);
        jSONObject3.put("msg_id", str4);
        jSONObject3.put("action_type", i11);
        JSONArray jSONArray = new JSONArray();
        int i12 = -1;
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (notificationManager = (NotificationManager) a11.getSystemService("notification")) == null || (a10 = notificationManager.getNotificationChannels()) == null) {
            str3 = str5;
        } else {
            str3 = str5;
            for (Object a12 : a10) {
                NotificationChannel a13 = b0.a(a12);
                String str6 = str5;
                if (TextUtils.equals(str2, a13.getId())) {
                    String a14 = a13.getId();
                    str5 = a14;
                    str3 = String.valueOf(a13.getName());
                    i12 = a13.getImportance();
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("chan_id", a13.getId());
                    jSONObject4.put("chan_name", String.valueOf(a13.getName()));
                    jSONObject4.put("chan_imp", a13.getImportance());
                    jSONArray.put(jSONObject4);
                    str5 = str6;
                }
            }
            String str7 = str5;
        }
        jSONObject3.put("chan_id", str5);
        jSONObject3.put("chan_name", str3);
        jSONObject3.put("chan_imp", i12);
        jSONObject3.put("ext_chan_stat", jSONArray);
        jSONObject3.put("fg_stat", u.c() ? 1 : 0);
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a11).l());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (f.b(a11)) {
            jSONObject2.put(bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a11));
            jSONObject2.put("push_switch", d.p(a11));
            UMWorkDispatch.sendEvent(a11, 16391, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("jsonHeader", jSONObject2);
            jSONObject6.put("jsonBody", jSONObject5);
            jSONObject6.put("msgId", str4);
            jSONObject6.put("actionType", i11);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a11.getPackageName());
            Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
            intent.setClass(a11, cls);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject6.toString());
            r.enqueueWork(a11, cls, intent);
        }
        UPLog.i("Track", "sendMsgShow:", jSONObject);
    }

    public final void b(String str, int i10) {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", 21);
        if (i10 >= 0) {
            jSONObject3.put("chan_name", i10);
        }
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a10)) {
            jSONObject2.put(bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16385, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("jsonHeader", jSONObject2);
            jSONObject5.put("jsonBody", jSONObject4);
            jSONObject5.put("msgId", str);
            jSONObject5.put("actionType", 21);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
            intent.setClass(a10, cls);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject5.toString());
            r.enqueueWork(a10, cls, intent);
        }
        UPLog.i("Track", "sendMfrMsgClick:", jSONObject);
    }

    public final void c(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) {
        Application a10 = y.a();
        MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
        JSONObject a11 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias/delete", UMUtils.getAppkey(a10));
        if (a11 == null || !TextUtils.equals(a11.getString("success"), ITagManager.SUCCESS)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete failed.");
            return;
        }
        try {
            instance.f15210a.getContentResolver().delete(h.a(instance.f15210a), "type=? and alias=?", new String[]{str2, str});
        } catch (Exception e10) {
            UPLog.e("Prefs", (Throwable) e10);
        }
        instance.a("alias_del_", a11.optLong(bt.f13907ba));
        uPushAliasCallback.onMessage(true, "alias:" + str + ", type:" + str2 + " delete success.");
    }

    public final void b(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) {
        Application a10 = y.a();
        MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
        String optString = jSONObject.optString(ITagManager.FAIL, "");
        String optString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(optString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
        } else if (!TextUtils.isEmpty(optString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + " already exist.");
        } else {
            JSONObject a11 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias/set", UMUtils.getAppkey(a10));
            if (a11 == null || !TextUtils.equals(a11.optString("success", ""), ITagManager.SUCCESS)) {
                uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
                return;
            }
            instance.a(str, str2, 1, a11.optLong("ttl", 3600));
            instance.a("alias_set_", a11.optLong(bt.f13907ba));
            uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
        }
    }

    public final void a(String str, String str2, int i10) {
        String str3;
        NotificationManager notificationManager;
        List<Object> a10;
        String str4 = str;
        Application a11 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        String str5 = "";
        jSONObject3.put("pa", str5);
        jSONObject3.put("msg_id", str4);
        jSONObject3.put("action_type", 9);
        jSONObject3.put("repop_count", i10);
        JSONArray jSONArray = new JSONArray();
        int i11 = -1;
        if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str2) || (notificationManager = (NotificationManager) a11.getSystemService("notification")) == null || (a10 = notificationManager.getNotificationChannels()) == null) {
            str3 = str5;
        } else {
            str3 = str5;
            for (Object a12 : a10) {
                NotificationChannel a13 = b0.a(a12);
                if (TextUtils.equals(str2, a13.getId())) {
                    str5 = a13.getId();
                    str3 = String.valueOf(a13.getName());
                    i11 = a13.getImportance();
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("chan_id", a13.getId());
                    jSONObject4.put("chan_name", String.valueOf(a13.getName()));
                    jSONObject4.put("chan_imp", a13.getImportance());
                    jSONArray.put(jSONObject4);
                    str5 = str5;
                }
            }
            String str6 = str5;
        }
        jSONObject3.put("chan_id", str5);
        jSONObject3.put("chan_name", str3);
        jSONObject3.put("chan_imp", i11);
        jSONObject3.put("ext_chan_stat", jSONArray);
        jSONObject3.put("fg_stat", u.c() ? 1 : 0);
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a11).l());
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("push", jSONArray2);
        jSONObject.put("content", jSONObject5);
        if (f.b(a11)) {
            jSONObject2.put(bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a11));
            jSONObject2.put("push_switch", d.p(a11));
            UMWorkDispatch.sendEvent(a11, 16392, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("jsonHeader", jSONObject2);
            jSONObject6.put("jsonBody", jSONObject5);
            jSONObject6.put("msgId", str4);
            jSONObject6.put("actionType", 9);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a11.getPackageName());
            Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
            intent.setClass(a11, cls);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject6.toString());
            r.enqueueWork(a11, cls, intent);
        }
        UPLog.i("Track", "sendMsgRepost:", jSONObject);
    }

    public final void a(String str, int i10) {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ts", System.currentTimeMillis());
        jSONObject3.put("pa", "");
        jSONObject3.put("msg_id", str);
        jSONObject3.put("action_type", i10);
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a10)) {
            jSONObject2.put(bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16385, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("jsonHeader", jSONObject2);
            jSONObject5.put("jsonBody", jSONObject4);
            jSONObject5.put("msgId", str);
            jSONObject5.put("actionType", i10);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
            intent.setClass(a10, cls);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_logs");
            intent.putExtra("send_message", jSONObject5.toString());
            r.enqueueWork(a10, cls, intent);
        }
        UPLog.i("Track", "sendMsgLog:", jSONObject);
    }

    public final void a() {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("header", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("push", jSONArray);
        jSONObject.put("content", jSONObject4);
        if (f.b(a10)) {
            jSONObject2.put(bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put("push_switch", d.p(a10));
            UMWorkDispatch.sendEvent(a10, 16386, w.a(), jSONObject.toString());
        } else {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("jsonHeader", jSONObject2);
            jSONObject5.put("jsonBody", jSONObject4);
            Intent intent = new Intent("com.umeng.message.action");
            intent.setPackage(a10.getPackageName());
            Class<UmengMessageHandlerService> cls = UmengMessageHandlerService.class;
            intent.setClass(a10, cls);
            intent.putExtra("um_command", "send");
            intent.putExtra("um_px_path", "umpx_push_launch");
            intent.putExtra("send_message", jSONObject5.toString());
            r.enqueueWork(a10, cls, intent);
        }
        UPLog.i("Track", "sendLaunch:", jSONObject);
    }

    public final void a(String str) {
        Application a10 = y.a();
        if (f.b(a10)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("din", d.c(a10));
            jSONObject2.put(bt.aR, MsgConstant.SDK_VERSION);
            jSONObject2.put("push_switch", d.p(a10));
            jSONObject.put("header", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("device_token", MessageSharedPrefs.getInstance(a10).l());
            jSONObject3.put("old_device_token", str);
            try {
                if (f.c(a10)) {
                    jSONObject3.put("utdid_gen", 1);
                    String d10 = f.d(a10);
                    if (!TextUtils.isEmpty(d10)) {
                        jSONObject3.put("utdid_rst_id", d10);
                    }
                    f.e(a10);
                }
            } catch (Throwable unused) {
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("push", jSONArray);
            jSONObject.put("content", jSONObject4);
            UMWorkDispatch.sendEvent(a10, 16387, w.a(), jSONObject.toString());
            UPLog.i("Track", "sendRegister:", jSONObject);
        }
    }

    public final void a(String str, String str2, JSONObject jSONObject, UPushAliasCallback uPushAliasCallback) {
        Application a10 = y.a();
        MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
        String optString = jSONObject.optString(ITagManager.FAIL, "");
        String optString2 = jSONObject.optString("success", "");
        if (!TextUtils.isEmpty(optString)) {
            uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
        } else if (!TextUtils.isEmpty(optString2)) {
            uPushAliasCallback.onMessage(true, "alias:" + str + " already exist.");
        } else {
            JSONObject a11 = g.a(jSONObject, "https://msg.umengcloud.com/v3/alias", UMUtils.getAppkey(a10));
            if (a11 == null || !TextUtils.equals(a11.optString("success", ""), ITagManager.SUCCESS)) {
                uPushAliasCallback.onMessage(false, "alias:" + str + " add failed.");
                return;
            }
            instance.a(str, str2, 0, a11.optLong("ttl", 3600));
            instance.a("alias_add_", a11.optLong(bt.f13907ba));
            uPushAliasCallback.onMessage(true, "alias:" + str + " add success.");
        }
    }
}
