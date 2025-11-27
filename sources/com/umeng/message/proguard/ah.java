package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.IUmengInAppMsgCloseCallback;
import com.umeng.message.inapp.InAppMessageManager;
import com.umeng.message.inapp.UmengCardMessage;
import com.umeng.message.proguard.ag;
import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;

public final class ah implements ae, ag.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15337a = "com.umeng.message.proguard.ah";

    /* renamed from: b  reason: collision with root package name */
    public Context f15338b;

    /* renamed from: c  reason: collision with root package name */
    public String f15339c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15340d;

    /* renamed from: e  reason: collision with root package name */
    private UInAppMessage f15341e;

    /* renamed from: f  reason: collision with root package name */
    private IUmengInAppMsgCloseCallback f15342f;

    public ah(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        this.f15338b = activity;
        this.f15339c = str;
        this.f15342f = iUmengInAppMsgCloseCallback;
    }

    public final void a(UInAppMessage uInAppMessage) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.umeng.message.entity.UInAppMessage r4) {
        /*
            r3 = this;
            android.content.Context r0 = r3.f15338b
            com.umeng.message.inapp.InAppMessageManager r0 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
            java.lang.String r1 = r3.f15339c
            java.lang.String r0 = r0.a((java.lang.String) r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0021
            com.umeng.message.entity.UInAppMessage r1 = new com.umeng.message.entity.UInAppMessage     // Catch:{ JSONException -> 0x001d }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001d }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x001d }
            r1.<init>(r2)     // Catch:{ JSONException -> 0x001d }
            goto L_0x0022
        L_0x001d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0021:
            r1 = 0
        L_0x0022:
            if (r4 == 0) goto L_0x0049
            if (r1 == 0) goto L_0x0046
            java.lang.String r0 = r4.msg_id
            java.lang.String r2 = r1.msg_id
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0046
            java.io.File r0 = new java.io.File
            android.content.Context r2 = r3.f15338b
            java.lang.String r1 = r1.msg_id
            java.lang.String r1 = com.umeng.message.proguard.f.a((android.content.Context) r2, (java.lang.String) r1)
            r0.<init>(r1)
            android.content.Context r1 = r3.f15338b
            com.umeng.message.inapp.InAppMessageManager r1 = com.umeng.message.inapp.InAppMessageManager.getInstance(r1)
            r1.a((java.io.File) r0)
        L_0x0046:
            r3.f15341e = r4
            goto L_0x004d
        L_0x0049:
            if (r1 == 0) goto L_0x00b8
            r3.f15341e = r1
        L_0x004d:
            com.umeng.message.entity.UInAppMessage r4 = r3.f15341e
            int r4 = r4.show_type
            r0 = 1
            if (r4 != r0) goto L_0x006a
            java.lang.String r4 = r3.f15339c
            boolean r4 = r3.b((java.lang.String) r4)
            if (r4 != 0) goto L_0x006a
            android.content.Context r4 = r3.f15338b
            com.umeng.message.inapp.InAppMessageManager r4 = com.umeng.message.inapp.InAppMessageManager.getInstance(r4)
            com.umeng.message.entity.UInAppMessage r0 = r3.f15341e
            java.lang.String r0 = r0.msg_id
            r1 = 0
            r4.a((java.lang.String) r0, (int) r1)
        L_0x006a:
            android.content.Context r4 = r3.f15338b
            com.umeng.message.inapp.InAppMessageManager.getInstance(r4)
            com.umeng.message.entity.UInAppMessage r4 = r3.f15341e
            boolean r4 = com.umeng.message.inapp.InAppMessageManager.b((com.umeng.message.entity.UInAppMessage) r4)
            if (r4 == 0) goto L_0x00b8
            android.content.Context r4 = r3.f15338b
            com.umeng.message.inapp.InAppMessageManager r4 = com.umeng.message.inapp.InAppMessageManager.getInstance(r4)
            com.umeng.message.entity.UInAppMessage r0 = r3.f15341e
            boolean r4 = r4.c((com.umeng.message.entity.UInAppMessage) r0)
            if (r4 != 0) goto L_0x0086
            goto L_0x00b8
        L_0x0086:
            com.umeng.message.entity.UInAppMessage r4 = r3.f15341e
            int r4 = r4.msg_type
            r0 = 5
            if (r4 == r0) goto L_0x00a8
            r0 = 6
            if (r4 != r0) goto L_0x0091
            goto L_0x00a8
        L_0x0091:
            com.umeng.message.proguard.ag r4 = new com.umeng.message.proguard.ag
            android.content.Context r0 = r3.f15338b
            com.umeng.message.entity.UInAppMessage r1 = r3.f15341e
            r4.<init>(r0, r1)
            r4.f15334a = r3
            com.umeng.message.entity.UInAppMessage r0 = r3.f15341e
            java.lang.String r0 = r0.image_url
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r4.execute(r0)
            return
        L_0x00a8:
            android.content.Context r4 = r3.f15338b
            com.umeng.message.inapp.InAppMessageManager r4 = com.umeng.message.inapp.InAppMessageManager.getInstance(r4)
            com.umeng.message.entity.UInAppMessage r0 = r3.f15341e
            java.lang.String r1 = r3.f15339c
            r4.a((com.umeng.message.entity.UInAppMessage) r0, (java.lang.String) r1)
            r3.a()
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ah.b(com.umeng.message.entity.UInAppMessage):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.f15338b
            java.lang.String r0 = com.umeng.message.proguard.d.a((android.content.Context) r0)
            android.content.Context r1 = r5.f15338b
            com.umeng.message.inapp.InAppMessageManager r1 = com.umeng.message.inapp.InAppMessageManager.getInstance(r1)
            java.lang.String r2 = "KEY_LAST_VERSION_CODE"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.a((java.lang.String) r2, (java.lang.String) r3)
            boolean r0 = r0.equals(r1)
            java.lang.String r1 = "KEY_CARD_LABEL_LIST"
            if (r0 != 0) goto L_0x0025
            android.content.Context r0 = r5.f15338b
            com.umeng.message.inapp.InAppMessageManager r0 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
            r0.b(r1, r3)
        L_0x0025:
            android.content.Context r0 = r5.f15338b
            com.umeng.message.inapp.InAppMessageManager r0 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
            android.content.Context r4 = r5.f15338b
            java.lang.String r4 = com.umeng.message.proguard.d.a((android.content.Context) r4)
            r0.b(r2, r4)
            android.content.Context r0 = r5.f15338b
            com.umeng.message.inapp.InAppMessageManager r0 = com.umeng.message.inapp.InAppMessageManager.getInstance(r0)
            java.lang.String r0 = r0.a((java.lang.String) r1, (java.lang.String) r3)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x004e
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x004a }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x004a }
            goto L_0x004f
        L_0x004a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004e:
            r2 = 0
        L_0x004f:
            r0 = 1
            if (r2 != 0) goto L_0x0068
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            r2.put(r6)
            android.content.Context r6 = r5.f15338b
            com.umeng.message.inapp.InAppMessageManager r6 = com.umeng.message.inapp.InAppMessageManager.getInstance(r6)
            java.lang.String r2 = r2.toString()
            r6.b(r1, r2)
            return r0
        L_0x0068:
            boolean r3 = a(r2, r6)
            if (r3 == 0) goto L_0x006f
            return r0
        L_0x006f:
            int r3 = r2.length()
            r4 = 10
            if (r3 >= r4) goto L_0x0088
            r2.put(r6)
            android.content.Context r6 = r5.f15338b
            com.umeng.message.inapp.InAppMessageManager r6 = com.umeng.message.inapp.InAppMessageManager.getInstance(r6)
            java.lang.String r2 = r2.toString()
            r6.b(r1, r2)
            return r0
        L_0x0088:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ah.a(java.lang.String):boolean");
    }

    private boolean b(String str) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(InAppMessageManager.getInstance(this.f15338b).c(str));
        Calendar instance2 = Calendar.getInstance();
        if (instance.get(6) == instance2.get(6) && instance.get(1) == instance2.get(1)) {
            return true;
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        int i10 = 0;
        while (i10 < jSONArray.length()) {
            try {
                if (jSONArray.getString(i10).equals(str)) {
                    return true;
                }
                i10++;
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    private void a() {
        try {
            UmengCardMessage umengCardMessage = new UmengCardMessage();
            umengCardMessage.f15256a = this.f15342f;
            Bundle bundle = new Bundle();
            bundle.putString(Constants.ScionAnalytics.PARAM_LABEL, this.f15339c);
            bundle.putString(Constant.KEY_MSG, this.f15341e.getRaw().toString());
            umengCardMessage.setArguments(bundle);
            umengCardMessage.show(((Activity) this.f15338b).getFragmentManager(), this.f15339c);
            InAppMessageManager.getInstance(this.f15338b).a(this.f15341e.msg_id, 1);
            InAppMessageManager.getInstance(this.f15338b).b(this.f15339c);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void a(Bitmap[] bitmapArr) {
        Bitmap bitmap;
        if (!this.f15340d && (bitmap = bitmapArr[0]) != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                UmengCardMessage umengCardMessage = new UmengCardMessage();
                umengCardMessage.f15256a = this.f15342f;
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ScionAnalytics.PARAM_LABEL, this.f15339c);
                bundle.putString(Constant.KEY_MSG, this.f15341e.getRaw().toString());
                bundle.putByteArray("bitmapByte", byteArray);
                umengCardMessage.setArguments(bundle);
                umengCardMessage.show(((Activity) this.f15338b).getFragmentManager(), this.f15339c);
                InAppMessageManager.getInstance(this.f15338b).a(this.f15341e.msg_id, 1);
                InAppMessageManager.getInstance(this.f15338b).b(this.f15339c);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        InAppMessageManager.getInstance(this.f15338b).a(this.f15341e, this.f15339c);
    }
}
