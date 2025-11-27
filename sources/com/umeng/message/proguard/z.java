package com.umeng.message.proguard;

import android.app.Application;
import android.app.Notification;
import android.content.ContentProviderOperation;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.taobao.agoo.TaobaoRegister;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.bb;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

public final class z extends UTrack {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f16086a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final z f16087b = new z();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f16088e;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ab f16089c = new aa();

    /* renamed from: d  reason: collision with root package name */
    private long f16090d;

    private z() {
    }

    /* access modifiers changed from: private */
    public synchronized void b(String str, String str2, String str3) {
        if (MessageService.MSG_ACCS_NOTIFY_CLICK.equals(str3)) {
            TaobaoRegister.clickMessage(y.a(), str, str2);
        } else {
            TaobaoRegister.dismissMessage(y.a(), str, str2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendMsgLogForAgoo msgId:");
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" taskId:");
            sb.append(str2);
        }
        sb.append(" status:");
        sb.append(str3);
        UPLog.i("Track", sb);
    }

    public static boolean c() {
        if (f.b()) {
            UPLog.i("Track", "track failed, silent mode!");
            return true;
        }
        Application a10 = y.a();
        if (TextUtils.isEmpty(MessageSharedPrefs.getInstance(a10).l())) {
            return true;
        }
        return TextUtils.isEmpty(d.o(a10));
    }

    public static /* synthetic */ JSONObject f() {
        String l10 = MessageSharedPrefs.getInstance(y.a()).l();
        String o10 = d.o(y.a());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("utdid", o10);
        jSONObject.put("device_token", l10);
        return jSONObject;
    }

    public final void addAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        b.b(new Runnable() {
            public final void run() {
                boolean z10;
                MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
                try {
                    if (!instance.a("alias_add_")) {
                        uPushAliasCallback.onMessage(false, "interval limit.");
                        return;
                    }
                    String a10 = z.b(str, str2);
                    if (a10 != null && a10.length() > 0) {
                        uPushAliasCallback.onMessage(false, a10);
                        return;
                    }
                    String o10 = d.o(y.a());
                    String l10 = instance.l();
                    StringBuilder sb = new StringBuilder();
                    String str = "";
                    sb.append(str);
                    sb.append("utdid:");
                    sb.append(o10);
                    sb.append(", deviceToken:");
                    sb.append(l10);
                    sb.append(";");
                    String sb2 = sb.toString();
                    boolean z11 = true;
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                        UPLog.e("Track", "addAlias: type or alias empty.");
                        sb2 = sb2 + "addAlias: empty type or alias. ";
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (TextUtils.isEmpty(o10)) {
                        UPLog.e("Track", "utdid empty. ");
                        sb2 = sb2 + "utdid empty;";
                        z10 = false;
                    }
                    if (TextUtils.isEmpty(l10)) {
                        UPLog.e("Track", "deviceToken empty.");
                        sb2 = sb2 + "deviceToken empty;";
                        z10 = false;
                    }
                    if (instance.a(0, str, str2)) {
                        String format = String.format("addAlias: <%s, %s> has been synced to the server before. Ignore this request.", new Object[]{str, str2});
                        UPLog.i("Track", format);
                        str = str + format;
                        z10 = false;
                    } else {
                        z11 = false;
                    }
                    try {
                        JSONObject f10 = z.f();
                        if (z10) {
                            f10.put("alias", str);
                            f10.put("type", str2);
                            f10.put("last_alias", instance.a(0, str2));
                            f10.put("ts", System.currentTimeMillis());
                        } else if (z11) {
                            f10.put("success", str);
                        } else {
                            f10.put(ITagManager.FAIL, sb2);
                        }
                        z.this.f16089c.a(str, str2, f10, uPushAliasCallback);
                    } catch (Throwable th) {
                        UPLog.e("Track", th);
                        if (th.getMessage() != null) {
                            UPushAliasCallback uPushAliasCallback = uPushAliasCallback;
                            if (uPushAliasCallback != null) {
                                uPushAliasCallback.onMessage(false, "alias:" + str + " add failed:" + th.getMessage());
                                return;
                            }
                            return;
                        }
                        UPushAliasCallback uPushAliasCallback2 = uPushAliasCallback;
                        if (uPushAliasCallback2 != null) {
                            uPushAliasCallback2.onMessage(false, "alias:" + str + " add failed");
                        }
                    }
                } catch (Exception e10) {
                    UPLog.e("Track", (Throwable) e10);
                }
            }
        });
    }

    public final void deleteAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        b.b(new Runnable() {
            public final void run() {
                boolean z10;
                MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
                try {
                    if (!instance.a("alias_del_")) {
                        uPushAliasCallback.onMessage(false, "interval limit.");
                        return;
                    }
                    String a10 = z.b(str, str2);
                    if (a10 != null && a10.length() > 0) {
                        uPushAliasCallback.onMessage(false, a10);
                        return;
                    }
                    String str = "";
                    if (TextUtils.isEmpty(str2)) {
                        UPLog.e("Track", "removeAlias: type empty.");
                        str = str + "removeAlias: type empty. ";
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (TextUtils.isEmpty(d.o(y.a()))) {
                        UPLog.e("Track", "removeAlias: utdid empty.");
                        str = str + "utdid empty. ";
                        z10 = false;
                    }
                    if (TextUtils.isEmpty(instance.l())) {
                        UPLog.e("Track", "removeAlias: deviceToken empty.");
                        str = str + "deviceToken empty.";
                        z10 = false;
                    }
                    try {
                        JSONObject f10 = z.f();
                        if (z10) {
                            f10.put("alias", str);
                            f10.put("type", str2);
                            f10.put("ts", System.currentTimeMillis());
                        } else {
                            f10.put(ITagManager.FAIL, str);
                        }
                        z.this.f16089c.c(str, str2, f10, uPushAliasCallback);
                    } catch (Throwable th) {
                        UPLog.e("Track", th);
                        if (th.getMessage() != null) {
                            uPushAliasCallback.onMessage(false, "alias:" + str + "remove failed:" + th.getMessage());
                            return;
                        }
                        uPushAliasCallback.onMessage(false, "alias:" + str + "remove failed.");
                    }
                } catch (Throwable th2) {
                    UPLog.e("Track", th2);
                }
            }
        });
    }

    public final void setAlias(final String str, final String str2, final UPushAliasCallback uPushAliasCallback) {
        b.b(new Runnable() {
            public final void run() {
                boolean z10;
                String str;
                boolean z11;
                MessageSharedPrefs instance = MessageSharedPrefs.getInstance(y.a());
                try {
                    if (!instance.a("alias_set_")) {
                        uPushAliasCallback.onMessage(false, "interval limit.");
                        return;
                    }
                    String a10 = z.b(str, str2);
                    if (a10 != null && a10.length() > 0) {
                        uPushAliasCallback.onMessage(false, a10);
                        return;
                    }
                    String str2 = "";
                    if (TextUtils.isEmpty(str2)) {
                        UPLog.e("Track", "addExclusiveAlias: type empty.");
                        str = str2 + "addExclusiveAlias: type empty. ";
                        z10 = false;
                    } else {
                        str = str2;
                        z10 = true;
                    }
                    if (TextUtils.isEmpty(d.o(y.a()))) {
                        UPLog.e("Track", "addExclusiveAlias: utdid empty.");
                        str = str + "utdid empty. ";
                        z10 = false;
                    }
                    if (TextUtils.isEmpty(instance.l())) {
                        UPLog.e("Track", "addExclusiveAlias: deviceToken empty.");
                        str = str + "deviceToken empty.";
                        z10 = false;
                    }
                    if (instance.a(1, str, str2)) {
                        String format = String.format("addExclusiveAlias: <%s, %s> has been synced to the server before. Ignore this request.", new Object[]{str, str2});
                        UPLog.i("Track", format);
                        str2 = str2 + format;
                        z10 = false;
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    try {
                        JSONObject f10 = z.f();
                        if (z10) {
                            f10.put("alias", str);
                            f10.put("type", str2);
                            f10.put("last_alias", instance.a(1, str2));
                            f10.put("ts", System.currentTimeMillis());
                        } else if (z11) {
                            f10.put("success", str2);
                        } else {
                            f10.put(ITagManager.FAIL, str);
                        }
                        z.this.f16089c.b(str, str2, f10, uPushAliasCallback);
                    } catch (Throwable th) {
                        UPLog.e("Track", th);
                        if (th.getMessage() != null) {
                            uPushAliasCallback.onMessage(false, "alias:" + str + "add failed:" + th.getMessage());
                            return;
                        }
                        uPushAliasCallback.onMessage(false, "alias:" + str + "add failed.");
                    }
                } catch (Throwable th2) {
                    UPLog.e("Track", th2);
                }
            }
        });
    }

    public final void trackInAppNotifyClick(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            a(uMessage.getMsgId(), 11);
        }
    }

    public final void trackInAppNotifyShow(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            a(uMessage.getMsgId(), 10);
        }
    }

    public final void trackMfrPushMsgClick(UMessage uMessage, int i10) {
        try {
            if (!c() && uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
                this.f16089c.b(uMessage.getMsgId(), i10);
            }
        } catch (Throwable th) {
            UPLog.e("Track", th);
        }
    }

    public final void trackMsgArrival(UMessage uMessage) {
        if (uMessage != null) {
            a(uMessage.getMsgId(), 0);
        }
    }

    public final void trackMsgClick(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            a(uMessage.getMsgId(), 1);
        }
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getAgooMsgId())) {
            a(uMessage.getAgooMsgId(), uMessage.getTaskId(), MessageService.MSG_ACCS_NOTIFY_CLICK);
        }
    }

    public final void trackMsgDismissed(UMessage uMessage) {
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            a(uMessage.getMsgId(), 2);
        }
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getAgooMsgId())) {
            a(uMessage.getAgooMsgId(), uMessage.getTaskId(), MessageService.MSG_ACCS_NOTIFY_DISMISS);
        }
    }

    public final void trackMsgRepost(UMessage uMessage, Notification notification) {
        String str;
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            ad a10 = x.a().a(uMessage.getMsgId());
            if (a10 == null) {
                UPLog.i("Track", "sendMsgRepost item null, msgId:", uMessage.getMsgId());
                return;
            }
            int i10 = a10.f15322d;
            try {
                if (Build.VERSION.SDK_INT < 26 || notification == null) {
                    str = null;
                } else {
                    str = notification.getChannelId();
                }
                this.f16089c.a(uMessage.getMsgId(), str, i10);
            } catch (Throwable th) {
                UPLog.e("Track", th);
            }
        }
    }

    public final void trackMsgShow(UMessage uMessage, Notification notification) {
        int i10;
        String str;
        if (uMessage != null && !TextUtils.isEmpty(uMessage.getMsgId())) {
            if (TextUtils.equals(uMessage.getDisplayType(), "notification")) {
                i10 = 6;
            } else if (TextUtils.equals(uMessage.getDisplayType(), "custom")) {
                i10 = 7;
            } else {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT < 26 || notification == null) {
                    str = null;
                } else {
                    str = notification.getChannelId();
                }
                this.f16089c.a(uMessage.getMsgId(), i10, str);
            } catch (Throwable th) {
                UPLog.w("Track", "trackMsgShow error:", th.getMessage());
            }
        }
    }

    public static z a() {
        return f16087b;
    }

    public final void a(String str, int i10) {
        if (!c()) {
            if (TextUtils.isEmpty(str)) {
                UPLog.e("Track", "trackMsgLog skipped, msgId empty!");
                return;
            }
            try {
                this.f16089c.a(str, i10);
            } catch (Throwable th) {
                UPLog.e("Track", th);
            }
        }
    }

    private void a(final String str, final String str2, final String str3) {
        b.c(new Runnable() {
            public final void run() {
                try {
                    z.this.b(str, str2, str3);
                } catch (Throwable th) {
                    UPLog.e("Track", th);
                }
            }
        });
    }

    public final synchronized void b() {
        ArrayList arrayList;
        if (!c()) {
            try {
                Application a10 = y.a();
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.f16090d) >= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                    this.f16090d = currentTimeMillis;
                    if (f.b(a10)) {
                        bb a11 = bb.a(a10);
                        Cursor query = a11.f15490a.getContentResolver().query(h.d(a11.f15490a), (String[]) null, (String) null, (String[]) null, "Time Asc ");
                        if (query == null) {
                            arrayList = null;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
                                arrayList2.add(new bb.a(query));
                            }
                            query.close();
                            arrayList = arrayList2;
                        }
                        if (arrayList != null) {
                            if (!arrayList.isEmpty()) {
                                JSONArray jSONArray = new JSONArray();
                                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                    bb.a aVar = (bb.a) arrayList.get(i10);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("ts", aVar.f15492b);
                                    jSONObject.put("pa", "");
                                    jSONObject.put("device_token", MessageSharedPrefs.getInstance(a10).l());
                                    jSONObject.put("msg_id", aVar.f15491a);
                                    jSONObject.put("action_type", aVar.f15493c);
                                    jSONArray.put(jSONObject);
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject2.put("header", jSONObject3);
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("push", jSONArray);
                                jSONObject2.put("content", jSONObject4);
                                jSONObject3.put(bt.aR, MsgConstant.SDK_VERSION);
                                jSONObject3.put("din", d.c(a10));
                                jSONObject3.put("push_switch", d.p(a10));
                                UMWorkDispatch.sendEvent(y.a(), 16389, w.a(), jSONObject2.toString());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                UPLog.e("Track", th);
            }
            if (!f16088e) {
                f16088e = true;
                b.b(new Runnable() {
                    public final void run() {
                        boolean z10;
                        try {
                            Application a10 = y.a();
                            MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
                            boolean z11 = false;
                            if (instance.f15211b.b("launch_send_policy", -1) == 1) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                UPLog.i("Track", "launch policy 1, skipped.");
                                return;
                            }
                            String b10 = instance.f15211b.b("last_app_ver", "");
                            String appVersionName = UMUtils.getAppVersionName(a10);
                            if (!TextUtils.equals(b10, appVersionName)) {
                                z11 = true;
                            }
                            String b11 = instance.f15211b.b("last_ntf_switch", "");
                            String p10 = d.p(a10);
                            boolean z12 = !TextUtils.equals(b11, p10);
                            if (z11 || z12 || !instance.a()) {
                                z.this.f16089c.a();
                                if (z11) {
                                    instance.f15211b.a("last_app_ver", appVersionName);
                                }
                                if (z12) {
                                    instance.f15211b.a("last_ntf_switch", p10);
                                }
                                if (f.b(y.a())) {
                                    b.b(this, 1, TimeUnit.DAYS);
                                }
                                boolean unused = z.f16088e = false;
                                return;
                            }
                            boolean unused2 = z.f16088e = false;
                        } catch (Exception e10) {
                            UPLog.e("Track", (Throwable) e10);
                        } finally {
                            boolean unused3 = z.f16088e = false;
                        }
                    }
                }, 10, TimeUnit.SECONDS);
            }
        }
    }

    public static void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                Application a10 = y.a();
                ArrayList arrayList = new ArrayList();
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
                        arrayList.add(ContentProviderOperation.newDelete(h.d(a10)).withSelection("MsgId=? And ActionType=?", new String[]{jSONObject.optString("msg_id"), String.valueOf(jSONObject.optInt("action_type"))}).build());
                    }
                }
                a10.getContentResolver().applyBatch(h.f(a10), arrayList);
            } catch (Throwable th) {
                UPLog.e("Track", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String b(String str, String str2) {
        boolean z10 = false;
        if (f.b()) {
            UPLog.i("Track", "checkAlias failed, silent mode!");
            return "checkAlias failed, silent mode!";
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bytes2 = str2.getBytes("UTF-8");
            boolean z11 = bytes.length <= 128;
            if (bytes2.length <= 64) {
                z10 = true;
            }
            if (!z11 || !z10) {
                return "alias length must be <= 128 and aliasType length must be <= 64";
            }
            return null;
        } catch (Throwable th) {
            UPLog.e("Track", th);
            return null;
        }
    }
}
