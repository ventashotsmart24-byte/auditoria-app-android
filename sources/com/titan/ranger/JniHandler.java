package com.titan.ranger;

import android.text.TextUtils;
import com.titan.ranger.bean.RangerResult;

public class JniHandler {

    /* renamed from: a  reason: collision with root package name */
    public static a[] f13323a = new a[2];

    public interface a {
        int getInstance();

        int m(String str, String str2, long j10);

        int n(int i10, String str, String str2, String str3);

        int o(String str, String str2, int i10);

        int p(int i10, String str, Object obj, long j10);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r14.equals("OnPrepareEvent") == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String Callback(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            com.titan.ranger.bean.RangerResult r0 = new com.titan.ranger.bean.RangerResult
            java.lang.String r1 = ""
            r2 = 0
            r0.<init>(r2, r1)
            r14.hashCode()
            int r1 = r14.hashCode()
            r3 = 2
            r4 = -1
            switch(r1) {
                case -1086793358: goto L_0x0037;
                case 1241495447: goto L_0x002c;
                case 1528533011: goto L_0x0021;
                case 2046860249: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r2 = -1
            goto L_0x0040
        L_0x0016:
            java.lang.String r1 = "OnPrefetchAd"
            boolean r14 = r14.equals(r1)
            if (r14 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            r2 = 3
            goto L_0x0040
        L_0x0021:
            java.lang.String r1 = "OnReport"
            boolean r14 = r14.equals(r1)
            if (r14 != 0) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            r2 = 2
            goto L_0x0040
        L_0x002c:
            java.lang.String r1 = "SetPlayerUI"
            boolean r14 = r14.equals(r1)
            if (r14 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r2 = 1
            goto L_0x0040
        L_0x0037:
            java.lang.String r1 = "OnPrepareEvent"
            boolean r14 = r14.equals(r1)
            if (r14 != 0) goto L_0x0040
            goto L_0x0014
        L_0x0040:
            java.lang.String r14 = "err"
            java.lang.String r1 = "data"
            java.lang.String r4 = "event"
            java.lang.String r5 = "instance"
            r6 = 22
            switch(r2) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00b2;
                case 2: goto L_0x0082;
                case 3: goto L_0x0052;
                default: goto L_0x004d;
            }
        L_0x004d:
            r0.setErr(r3)
            goto L_0x011d
        L_0x0052:
            boolean r1 = android.text.TextUtils.isEmpty(r15)
            if (r1 != 0) goto L_0x007d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0074 }
            r1.<init>(r15)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r15 = "name"
            java.lang.String r15 = r1.getString(r15)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r2 = "path"
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0074 }
            int r14 = r1.getInt(r14)     // Catch:{ Exception -> 0x0074 }
            long r3 = (long) r14     // Catch:{ Exception -> 0x0074 }
            com.titan.ranger.bean.RangerResult r0 = r13.a(r15, r2, r3)     // Catch:{ Exception -> 0x0074 }
            goto L_0x011d
        L_0x0074:
            r14 = move-exception
            r14.printStackTrace()
            r0.setErr(r6)
            goto L_0x011d
        L_0x007d:
            r0.setErr(r6)
            goto L_0x011d
        L_0x0082:
            boolean r14 = android.text.TextUtils.isEmpty(r15)
            if (r14 != 0) goto L_0x00ae
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a5 }
            r14.<init>(r15)     // Catch:{ Exception -> 0x00a5 }
            int r15 = r14.getInt(r5)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r2 = r14.getString(r4)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r1 = r14.getString(r1)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r3 = "extra"
            java.lang.String r14 = r14.getString(r3)     // Catch:{ Exception -> 0x00a5 }
            com.titan.ranger.bean.RangerResult r0 = r13.c(r15, r2, r1, r14)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x011d
        L_0x00a5:
            r14 = move-exception
            r14.printStackTrace()
            r0.setErr(r6)
            goto L_0x011d
        L_0x00ae:
            r0.setErr(r6)
            goto L_0x011d
        L_0x00b2:
            boolean r14 = android.text.TextUtils.isEmpty(r15)
            if (r14 != 0) goto L_0x00de
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d6 }
            r14.<init>(r15)     // Catch:{ JSONException -> 0x00d6 }
            int r15 = r14.getInt(r5)     // Catch:{ JSONException -> 0x00d6 }
            java.lang.String r2 = "object"
            java.lang.String r2 = r14.getString(r2)     // Catch:{ JSONException -> 0x00d6 }
            java.lang.String r3 = "action"
            java.lang.String r3 = r14.getString(r3)     // Catch:{ JSONException -> 0x00d6 }
            int r14 = r14.getInt(r1)     // Catch:{ JSONException -> 0x00d6 }
            com.titan.ranger.bean.RangerResult r0 = r13.e(r15, r2, r3, r14)     // Catch:{ JSONException -> 0x00d6 }
            goto L_0x011d
        L_0x00d6:
            r14 = move-exception
            r14.printStackTrace()
            r0.setErr(r6)
            goto L_0x011d
        L_0x00de:
            r0.setErr(r6)
            goto L_0x011d
        L_0x00e2:
            boolean r1 = android.text.TextUtils.isEmpty(r15)
            if (r1 != 0) goto L_0x011a
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0112 }
            r1.<init>(r15)     // Catch:{ JSONException -> 0x0112 }
            int r8 = r1.getInt(r5)     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r9 = r1.getString(r4)     // Catch:{ JSONException -> 0x0112 }
            java.lang.String r15 = "status"
            java.lang.String r15 = r1.getString(r15)     // Catch:{ JSONException -> 0x0112 }
            long r11 = r1.getLong(r14)     // Catch:{ JSONException -> 0x0112 }
            com.google.gson.Gson r14 = m8.a.a()     // Catch:{ JSONException -> 0x0112 }
            java.lang.Class<com.titan.ranger.Status> r1 = com.titan.ranger.Status.class
            java.lang.Object r14 = r14.fromJson((java.lang.String) r15, r1)     // Catch:{ JSONException -> 0x0112 }
            r10 = r14
            com.titan.ranger.Status r10 = (com.titan.ranger.Status) r10     // Catch:{ JSONException -> 0x0112 }
            r7 = r13
            com.titan.ranger.bean.RangerResult r0 = r7.b(r8, r9, r10, r11)     // Catch:{ JSONException -> 0x0112 }
            goto L_0x011d
        L_0x0112:
            r14 = move-exception
            r14.printStackTrace()
            r0.setErr(r6)
            goto L_0x011d
        L_0x011a:
            r0.setErr(r6)
        L_0x011d:
            com.google.gson.Gson r14 = m8.a.a()
            java.lang.String r14 = r14.toJson((java.lang.Object) r0)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.titan.ranger.JniHandler.Callback(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void d(int i10, a aVar) {
        f13323a[i10] = aVar;
    }

    public final RangerResult a(String str, String str2, long j10) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f13323a[0];
            if (aVar != null) {
                rangerResult.setErr(aVar.m(str, str2, j10));
            }
        }
        return rangerResult;
    }

    public final RangerResult b(int i10, String str, Object obj, long j10) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (obj instanceof Status) {
            a aVar = f13323a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.p(i10, str, (Status) obj, j10));
            }
        } else {
            rangerResult.setErr(22);
        }
        return rangerResult;
    }

    public final RangerResult c(int i10, String str, String str2, String str3) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f13323a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.n(i10, str, str2, str3));
            }
        }
        return rangerResult;
    }

    public final RangerResult e(int i10, String str, String str2, int i11) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f13323a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.o(str, str2, i11));
            }
        }
        return rangerResult;
    }
}
