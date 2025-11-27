package com.hpplay.common.utils;

import android.util.Base64;
import com.hpplay.common.log.LeLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

public class HttpEncrypt {
    private static final String ENCRYPT_DATA = "encryptedData";
    private static final String KEY = "23046885";
    private static final String TAG = "HttpEncrypt";
    private static final String X_LB_EN = "x-lb-en";
    private static final String X_LB_EN_RAND = "x-lb-en-rand";
    private static final String X_LB_EN_VALUE = "2";
    private String randomKey;

    public HttpEncrypt() {
        this.randomKey = "";
        this.randomKey = getRandomKey();
    }

    private String getRandomKey() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i10 = 0; i10 < 8; i10++) {
            if (random.nextInt(2) % 2 != 0) {
                sb.append(random.nextInt(10));
            } else if (random.nextInt(2) % 2 == 0) {
                sb.append((char) (random.nextInt(27) + 65));
            } else {
                sb.append((char) (random.nextInt(27) + 97));
            }
        }
        return sb.toString();
    }

    public Map<String, String> buildHeader() {
        HashMap hashMap = new HashMap(2);
        hashMap.put(X_LB_EN, "2");
        hashMap.put(X_LB_EN_RAND, this.randomKey);
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        r1 = r6.get(X_LB_EN);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        r6 = r6.get(X_LB_EN_RAND);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String decode(com.hpplay.common.asyncmanager.AsyncHttpParameter.Out r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.result
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r6 = r6.headers
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "decode, headers = "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "HttpEncrypt"
            com.hpplay.common.log.LeLog.i(r2, r1)
            if (r6 != 0) goto L_0x001d
            return r0
        L_0x001d:
            java.lang.String r1 = "x-lb-en"
            java.lang.Object r1 = r6.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0058
            int r2 = r1.size()
            r3 = 1
            if (r2 < r3) goto L_0x0058
            java.lang.String r2 = "2"
            r4 = 0
            java.lang.Object r1 = r1.get(r4)
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x003c
            goto L_0x0058
        L_0x003c:
            java.lang.String r1 = "x-lb-en-rand"
            java.lang.Object r6 = r6.get(r1)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x0058
            int r1 = r6.size()
            if (r1 >= r3) goto L_0x004d
            goto L_0x0058
        L_0x004d:
            java.lang.Object r6 = r6.get(r4)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r5.decode(r0, r6)
            return r6
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.HttpEncrypt.decode(com.hpplay.common.asyncmanager.AsyncHttpParameter$Out):java.lang.String");
    }

    public String encode(String str) {
        LeLog.i(TAG, "encode, randomKey: " + this.randomKey + " , " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ENCRYPT_DATA, Base64.encodeToString(Encode.encodeToByte(str, this.randomKey + KEY), 2));
        } catch (Exception e10) {
            LeLog.w(TAG, "encode: " + e10);
        }
        LeLog.i(TAG, "encode, " + jSONObject.toString());
        return jSONObject.toString();
    }

    private String decode(String str, String str2) {
        LeLog.w(TAG, "decode, randomKey: " + str2);
        try {
            byte[] decode = Base64.decode(new JSONObject(str).optString(ENCRYPT_DATA), 2);
            str = Encode.decodeByteToString(decode, str2 + KEY);
        } catch (Exception e10) {
            LeLog.w(TAG, "decode: " + e10);
        }
        LeLog.w(TAG, "decode, result: " + str);
        return str;
    }
}
