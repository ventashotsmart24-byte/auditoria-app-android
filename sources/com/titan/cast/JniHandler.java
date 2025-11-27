package com.titan.cast;

import com.google.gson.Gson;
import com.titan.cast.bean.CastResult;
import com.titan.cast.bean.Device;
import t9.g;

public final class JniHandler {
    public static final a Companion = new a((g) null);
    private static f8.a mCastCallBack;
    private final String TAG = "CastJniHandler";
    private final Gson mGson = new Gson();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String Callback(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "extra"
            java.lang.String r1 = "data"
            java.lang.String r2 = "action"
            java.lang.String r3 = "event"
            java.lang.String r4 = "state"
            java.lang.String r5 = "session"
            com.titan.cast.bean.CastResult r6 = new com.titan.cast.bean.CastResult
            r7 = 0
            java.lang.String r8 = ""
            r6.<init>(r7, r8)
            int r7 = r10.hashCode()
            r8 = 22
            switch(r7) {
                case -1864005230: goto L_0x00ea;
                case -251523458: goto L_0x00c2;
                case 1127897397: goto L_0x0088;
                case 1216256072: goto L_0x0058;
                case 1528533011: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x011f
        L_0x001f:
            java.lang.String r2 = "OnReport"
            boolean r10 = r10.equals(r2)
            if (r10 != 0) goto L_0x0029
            goto L_0x011f
        L_0x0029:
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L_0x0123
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004f }
            r10.<init>(r11)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r11 = r10.getString(r3)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r2 = r10.getString(r1)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r10 = r10.getString(r0)     // Catch:{ JSONException -> 0x004f }
            t9.i.f(r11, r3)     // Catch:{ JSONException -> 0x004f }
            t9.i.f(r2, r1)     // Catch:{ JSONException -> 0x004f }
            t9.i.f(r10, r0)     // Catch:{ JSONException -> 0x004f }
            com.titan.cast.bean.CastResult r6 = r9.onReport(r11, r2, r10)     // Catch:{ JSONException -> 0x004f }
            goto L_0x0123
        L_0x004f:
            r10 = move-exception
            r10.printStackTrace()
            r6.setErr(r8)
            goto L_0x0123
        L_0x0058:
            java.lang.String r0 = "OnPosition"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L_0x0062
            goto L_0x011f
        L_0x0062:
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L_0x0123
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007f }
            r10.<init>(r11)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r11 = "duration"
            long r0 = r10.getLong(r11)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r11 = "position"
            long r10 = r10.getLong(r11)     // Catch:{ JSONException -> 0x007f }
            com.titan.cast.bean.CastResult r6 = r9.onPosition(r0, r10)     // Catch:{ JSONException -> 0x007f }
            goto L_0x0123
        L_0x007f:
            r10 = move-exception
            r10.printStackTrace()
            r6.setErr(r8)
            goto L_0x0123
        L_0x0088:
            java.lang.String r0 = "OnDevice"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x011f
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L_0x00be
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b6 }
            r10.<init>(r11)     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r11 = "device"
            java.lang.String r10 = r10.getString(r11)     // Catch:{ JSONException -> 0x00b6 }
            com.google.gson.Gson r11 = r9.mGson     // Catch:{ JSONException -> 0x00b6 }
            java.lang.Class<com.titan.cast.bean.Device> r0 = com.titan.cast.bean.Device.class
            java.lang.Object r10 = r11.fromJson((java.lang.String) r10, r0)     // Catch:{ JSONException -> 0x00b6 }
            com.titan.cast.bean.Device r10 = (com.titan.cast.bean.Device) r10     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r11 = "deviceInfo"
            t9.i.f(r10, r11)     // Catch:{ JSONException -> 0x00b6 }
            com.titan.cast.bean.CastResult r6 = r9.onDevice(r10)     // Catch:{ JSONException -> 0x00b6 }
            goto L_0x0123
        L_0x00b6:
            r10 = move-exception
            r10.printStackTrace()
            r6.setErr(r8)
            goto L_0x0123
        L_0x00be:
            r6.setErr(r8)
            goto L_0x0123
        L_0x00c2:
            java.lang.String r0 = "OnPlayState"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L_0x00cb
            goto L_0x011f
        L_0x00cb:
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L_0x0123
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e2 }
            r10.<init>(r11)     // Catch:{ JSONException -> 0x00e2 }
            java.lang.String r10 = r10.getString(r4)     // Catch:{ JSONException -> 0x00e2 }
            t9.i.f(r10, r4)     // Catch:{ JSONException -> 0x00e2 }
            com.titan.cast.bean.CastResult r6 = r9.onPlayState(r10)     // Catch:{ JSONException -> 0x00e2 }
            goto L_0x0123
        L_0x00e2:
            r10 = move-exception
            r10.printStackTrace()
            r6.setErr(r8)
            goto L_0x0123
        L_0x00ea:
            java.lang.String r0 = "OnActionResult"
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L_0x00f3
            goto L_0x011f
        L_0x00f3:
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L_0x0123
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0117 }
            r10.<init>(r11)     // Catch:{ JSONException -> 0x0117 }
            java.lang.String r11 = r10.getString(r5)     // Catch:{ JSONException -> 0x0117 }
            java.lang.String r0 = r10.getString(r2)     // Catch:{ JSONException -> 0x0117 }
            java.lang.String r1 = "err"
            int r10 = r10.getInt(r1)     // Catch:{ JSONException -> 0x0117 }
            t9.i.f(r11, r5)     // Catch:{ JSONException -> 0x0117 }
            t9.i.f(r0, r2)     // Catch:{ JSONException -> 0x0117 }
            com.titan.cast.bean.CastResult r6 = r9.onActionResult(r11, r0, r10)     // Catch:{ JSONException -> 0x0117 }
            goto L_0x0123
        L_0x0117:
            r10 = move-exception
            r10.printStackTrace()
            r6.setErr(r8)
            goto L_0x0123
        L_0x011f:
            r10 = 2
            r6.setErr(r10)
        L_0x0123:
            com.google.gson.Gson r10 = r9.mGson
            java.lang.String r10 = r10.toJson((java.lang.Object) r6)
            java.lang.String r11 = "mGson.toJson(result)"
            t9.i.f(r10, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.titan.cast.JniHandler.Callback(java.lang.String, java.lang.String):java.lang.String");
    }

    private final CastResult onActionResult(String str, String str2, int i10) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.b(str, str2, i10);
        }
        return castResult;
    }

    private final CastResult onDevice(Device device) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.d(device);
        }
        return castResult;
    }

    private final CastResult onPlayState(String str) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.a(str);
        }
        return castResult;
    }

    private final CastResult onPosition(long j10, long j11) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.e(j10, j11);
        }
        return castResult;
    }

    private final CastResult onReport(String str, String str2, String str3) {
        CastResult castResult = new CastResult(0, "");
        f8.a aVar = mCastCallBack;
        if (aVar != null) {
            aVar.c(str, str2, str3);
        }
        return castResult;
    }

    public final void setOnCastCallBack(f8.a aVar) {
        mCastCallBack = aVar;
    }
}
