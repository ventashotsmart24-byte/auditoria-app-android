package la;

import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

public abstract class d implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final MediaType f18863a = MediaType.parse("application/json; charset=utf-8");

    public static String b(Request request) {
        RequestBody body = request.body();
        Charset forName = Charset.forName("UTF-8");
        StringBuilder sb = new StringBuilder();
        MediaType contentType = body.contentType();
        if (contentType != null) {
            forName = contentType.charset(Charset.forName("UTF-8"));
        }
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        sb.append(buffer.readString(forName));
        buffer.close();
        return sb.toString();
    }

    public abstract Iterable a();

    public abstract boolean c();

    /* JADX WARNING: Can't wrap try/catch for region: R(21:8|9|10|(1:12)(1:13)|14|(1:18)|19|20|(1:42)|43|44|(2:47|45)|70|48|(1:50)(1:51)|52|(1:60)(2:56|(1:58)(1:59))|61|(1:63)(1:64)|65|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00e9 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7 A[Catch:{ Exception -> 0x0178 }, LOOP:0: B:45:0x00f1->B:47:0x00f7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0113 A[Catch:{ Exception -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011f A[Catch:{ Exception -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012e A[Catch:{ Exception -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0146 A[Catch:{ Exception -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015a A[Catch:{ Exception -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0163 A[Catch:{ Exception -> 0x0178 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r11) {
        /*
            r10 = this;
            java.lang.String r0 = "userId"
            java.lang.String r1 = "securityKey"
            okhttp3.Request r2 = r11.request()
            java.lang.String r3 = r2.method()
            java.lang.String r4 = "POST"
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0020
            java.lang.String r3 = r2.method()
            java.lang.String r5 = "PUT"
            boolean r3 = android.text.TextUtils.equals(r3, r5)
            if (r3 == 0) goto L_0x0034
        L_0x0020:
            okhttp3.RequestBody r3 = r2.body()
            okhttp3.MediaType r3 = r3.contentType()
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "application/json;"
            boolean r3 = r3.contains(r5)
            if (r3 != 0) goto L_0x0039
        L_0x0034:
            okhttp3.Response r11 = r11.proceed(r2)
            return r11
        L_0x0039:
            java.lang.String r3 = "needEncrypt"
            java.lang.String r3 = r2.header(r3)     // Catch:{ Exception -> 0x0178 }
            okhttp3.RequestBody r5 = r2.body()     // Catch:{ Exception -> 0x0178 }
            long r5 = r5.contentLength()     // Catch:{ Exception -> 0x0178 }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0053
            com.google.gson.JsonObject r5 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x0178 }
            r5.<init>()     // Catch:{ Exception -> 0x0178 }
            goto L_0x0064
        L_0x0053:
            com.google.gson.JsonParser r5 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0178 }
            r5.<init>()     // Catch:{ Exception -> 0x0178 }
            java.lang.String r6 = b(r2)     // Catch:{ Exception -> 0x0178 }
            com.google.gson.JsonElement r5 = r5.parse((java.lang.String) r6)     // Catch:{ Exception -> 0x0178 }
            com.google.gson.JsonObject r5 = r5.getAsJsonObject()     // Catch:{ Exception -> 0x0178 }
        L_0x0064:
            java.lang.String r6 = "columnId"
            com.google.gson.JsonElement r6 = r5.get(r6)     // Catch:{ Exception -> 0x0178 }
            if (r6 == 0) goto L_0x007a
            int r6 = r6.getAsInt()     // Catch:{ Exception -> 0x0178 }
            r7 = -1
            if (r6 != r7) goto L_0x007a
            okhttp3.Call r6 = r11.call()     // Catch:{ Exception -> 0x0178 }
            r6.cancel()     // Catch:{ Exception -> 0x0178 }
        L_0x007a:
            okhttp3.HttpUrl r6 = r2.url()     // Catch:{ Exception -> 0x00e9 }
            java.net.URL r6 = r6.url()     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r6 = r6.getPath()     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r7 = "/sendEmailVerifyCode"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "/getAreaCode"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "/validateVerifyCode"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "/resetPwd"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "/qr/token"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "v3/getProgram"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "/feedback/userFeedBack"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "/getVerifiCode"
            boolean r7 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r7 != 0) goto L_0x00e9
            java.lang.String r7 = "/checkVerifiCode"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x00e9 }
            if (r6 != 0) goto L_0x00e9
            com.google.gson.JsonElement r6 = r5.get(r0)     // Catch:{ Exception -> 0x00e9 }
            if (r6 == 0) goto L_0x00e9
            com.google.gson.JsonElement r0 = r5.get(r0)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x00e9 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x00e9 }
            if (r0 == 0) goto L_0x00e9
            okhttp3.Call r0 = r11.call()     // Catch:{ Exception -> 0x00e9 }
            r0.cancel()     // Catch:{ Exception -> 0x00e9 }
        L_0x00e9:
            java.lang.Iterable r0 = r10.a()     // Catch:{ Exception -> 0x0178 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0178 }
        L_0x00f1:
            boolean r6 = r0.hasNext()     // Catch:{ Exception -> 0x0178 }
            if (r6 == 0) goto L_0x010d
            java.lang.Object r6 = r0.next()     // Catch:{ Exception -> 0x0178 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ Exception -> 0x0178 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ Exception -> 0x0178 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0178 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ Exception -> 0x0178 }
            com.google.gson.JsonElement r6 = (com.google.gson.JsonElement) r6     // Catch:{ Exception -> 0x0178 }
            r5.add(r7, r6)     // Catch:{ Exception -> 0x0178 }
            goto L_0x00f1
        L_0x010d:
            com.google.gson.JsonElement r0 = r5.get(r1)     // Catch:{ Exception -> 0x0178 }
            if (r0 == 0) goto L_0x011f
            com.google.gson.JsonElement r0 = r5.get(r1)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x0178 }
            r5.remove(r1)     // Catch:{ Exception -> 0x0178 }
            goto L_0x0120
        L_0x011f:
            r0 = 0
        L_0x0120:
            boolean r1 = r10.c()     // Catch:{ Exception -> 0x0178 }
            if (r1 == 0) goto L_0x0146
            java.lang.String r1 = "false"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0178 }
            if (r1 != 0) goto L_0x0146
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0178 }
            if (r1 != 0) goto L_0x013d
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x0178 }
            java.lang.String r0 = ma.i.e(r1, r0)     // Catch:{ Exception -> 0x0178 }
            goto L_0x014a
        L_0x013d:
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0178 }
            java.lang.String r0 = ma.i.d(r0)     // Catch:{ Exception -> 0x0178 }
            goto L_0x014a
        L_0x0146:
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0178 }
        L_0x014a:
            okhttp3.MediaType r1 = r10.f18863a     // Catch:{ Exception -> 0x0178 }
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create((okhttp3.MediaType) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0178 }
            java.lang.String r1 = r2.method()     // Catch:{ Exception -> 0x0178 }
            boolean r1 = android.text.TextUtils.equals(r1, r4)     // Catch:{ Exception -> 0x0178 }
            if (r1 == 0) goto L_0x0163
            okhttp3.Request$Builder r1 = r2.newBuilder()     // Catch:{ Exception -> 0x0178 }
            okhttp3.Request$Builder r0 = r1.post(r0)     // Catch:{ Exception -> 0x0178 }
            goto L_0x016b
        L_0x0163:
            okhttp3.Request$Builder r1 = r2.newBuilder()     // Catch:{ Exception -> 0x0178 }
            okhttp3.Request$Builder r0 = r1.put(r0)     // Catch:{ Exception -> 0x0178 }
        L_0x016b:
            okhttp3.Request r0 = r0.build()     // Catch:{ Exception -> 0x0178 }
            r2 = r0
            b(r2)     // Catch:{ Exception -> 0x0178 }
            okhttp3.Response r11 = r11.proceed(r2)     // Catch:{ Exception -> 0x0178 }
            return r11
        L_0x0178:
            okhttp3.Response r11 = r11.proceed(r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: la.d.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
