package com.hpplay.a.a.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.a.a.a.a.c;
import com.hpplay.a.a.a.b.a;
import com.hpplay.a.a.a.d;
import com.hpplay.a.a.a.e.e;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10433a = "postData";

    /* renamed from: b  reason: collision with root package name */
    public static final int f10434b = 8192;

    /* renamed from: c  reason: collision with root package name */
    public static final int f10435c = 1024;

    /* renamed from: d  reason: collision with root package name */
    private static final int f10436d = 512;

    /* renamed from: e  reason: collision with root package name */
    private static final int f10437e = 1024;

    /* renamed from: f  reason: collision with root package name */
    private final d f10438f;

    /* renamed from: g  reason: collision with root package name */
    private final e f10439g;

    /* renamed from: h  reason: collision with root package name */
    private final OutputStream f10440h;

    /* renamed from: i  reason: collision with root package name */
    private final BufferedInputStream f10441i;

    /* renamed from: j  reason: collision with root package name */
    private int f10442j;

    /* renamed from: k  reason: collision with root package name */
    private int f10443k;

    /* renamed from: l  reason: collision with root package name */
    private String f10444l;

    /* renamed from: m  reason: collision with root package name */
    private a f10445m;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, List<String>> f10446n;

    /* renamed from: o  reason: collision with root package name */
    private Map<String, String> f10447o;

    /* renamed from: p  reason: collision with root package name */
    private c f10448p;

    /* renamed from: q  reason: collision with root package name */
    private String f10449q;

    /* renamed from: r  reason: collision with root package name */
    private String f10450r;

    /* renamed from: s  reason: collision with root package name */
    private String f10451s;

    /* renamed from: t  reason: collision with root package name */
    private String f10452t;

    public b(d dVar, e eVar, InputStream inputStream, OutputStream outputStream) {
        this.f10438f = dVar;
        this.f10439g = eVar;
        this.f10441i = new BufferedInputStream(inputStream, 8192);
        this.f10440h = outputStream;
    }

    private void a(BufferedReader bufferedReader, Map<String, String> map, Map<String, List<String>> map2, Map<String, String> map3) {
        String str;
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    map.put(FirebaseAnalytics.Param.METHOD, stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        String nextToken = stringTokenizer.nextToken();
                        int indexOf = nextToken.indexOf(63);
                        if (indexOf >= 0) {
                            a(nextToken.substring(indexOf + 1), map2);
                            str = d.decodePercent(nextToken.substring(0, indexOf));
                        } else {
                            str = d.decodePercent(nextToken);
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            this.f10452t = stringTokenizer.nextToken();
                        } else {
                            this.f10452t = "HTTP/1.1";
                            d.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                        }
                        String readLine2 = bufferedReader.readLine();
                        while (readLine2 != null && !readLine2.trim().isEmpty()) {
                            int indexOf2 = readLine2.indexOf(58);
                            if (indexOf2 >= 0) {
                                map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                            }
                            readLine2 = bufferedReader.readLine();
                        }
                        map.put("uri", str);
                        return;
                    }
                    throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
        } catch (IOException e10) {
            com.hpplay.a.a.a.c.d dVar = com.hpplay.a.a.a.c.d.INTERNAL_ERROR;
            throw new d.a(dVar, "SERVER INTERNAL ERROR: IOException: " + e10.getMessage(), e10);
        }
    }

    private int b(byte[] bArr, int i10) {
        int i11;
        int i12 = 0;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= i10) {
                return 0;
            }
            byte b10 = bArr[i12];
            if (b10 == 13 && bArr[i13] == 10 && (i11 = i12 + 3) < i10 && bArr[i12 + 2] == 13 && bArr[i11] == 10) {
                return i12 + 4;
            }
            if (b10 == 10 && bArr[i13] == 10) {
                return i12 + 2;
            }
            i12 = i13;
        }
    }

    private RandomAccessFile m() {
        try {
            return new RandomAccessFile(this.f10439g.a((String) null).b(), "rw");
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    public final Map<String, String> c() {
        return this.f10447o;
    }

    public final InputStream d() {
        return this.f10441i;
    }

    public final a e() {
        return this.f10445m;
    }

    @Deprecated
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        for (String next : this.f10446n.keySet()) {
            hashMap.put(next, this.f10446n.get(next).get(0));
        }
        return hashMap;
    }

    public final Map<String, List<String>> g() {
        return this.f10446n;
    }

    public String h() {
        return this.f10449q;
    }

    public final String i() {
        return this.f10444l;
    }

    public long j() {
        if (this.f10447o.containsKey("content-length")) {
            return Long.parseLong(this.f10447o.get("content-length"));
        }
        int i10 = this.f10442j;
        int i11 = this.f10443k;
        if (i10 < i11) {
            return (long) (i11 - i10);
        }
        return 0;
    }

    public String k() {
        return this.f10450r;
    }

    public String l() {
        return this.f10451s;
    }

    public c b() {
        return this.f10448p;
    }

    public b(d dVar, e eVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.f10438f = dVar;
        this.f10439g = eVar;
        this.f10441i = new BufferedInputStream(inputStream, 8192);
        this.f10440h = outputStream;
        this.f10450r = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        this.f10451s = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "localhost" : inetAddress.getHostName().toString();
        this.f10447o = new HashMap();
    }

    private void a(com.hpplay.a.a.a.a.a aVar, ByteBuffer byteBuffer, Map<String, List<String>> map, Map<String, String> map2) {
        String str;
        ByteBuffer byteBuffer2 = byteBuffer;
        Map<String, List<String>> map3 = map;
        Map<String, String> map4 = map2;
        try {
            int[] a10 = a(byteBuffer2, aVar.d().getBytes());
            int i10 = 2;
            if (a10.length >= 2) {
                int i11 = 1024;
                byte[] bArr = new byte[1024];
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    int i15 = 1;
                    if (i13 < a10.length - 1) {
                        byteBuffer2.position(a10[i13]);
                        int remaining = byteBuffer.remaining() < i11 ? byteBuffer.remaining() : 1024;
                        byteBuffer2.get(bArr, i12, remaining);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i12, remaining), Charset.forName(aVar.c())), remaining);
                        String readLine = bufferedReader.readLine();
                        if (readLine != null && readLine.contains(aVar.d())) {
                            String readLine2 = bufferedReader.readLine();
                            String str2 = null;
                            String str3 = null;
                            String str4 = null;
                            int i16 = 2;
                            while (readLine2 != null && readLine2.trim().length() > 0) {
                                Matcher matcher = d.CONTENT_DISPOSITION_PATTERN.matcher(readLine2);
                                if (matcher.matches()) {
                                    Matcher matcher2 = d.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(i10));
                                    while (matcher2.find()) {
                                        String group = matcher2.group(i15);
                                        if ("name".equalsIgnoreCase(group)) {
                                            str = matcher2.group(2);
                                        } else {
                                            if ("filename".equalsIgnoreCase(group)) {
                                                String group2 = matcher2.group(2);
                                                if (!group2.isEmpty()) {
                                                    if (i14 > 0) {
                                                        str = str2 + String.valueOf(i14);
                                                        str3 = group2;
                                                        i14++;
                                                    } else {
                                                        i14++;
                                                    }
                                                }
                                                str3 = group2;
                                            }
                                            i15 = 1;
                                        }
                                        str2 = str;
                                        i15 = 1;
                                    }
                                }
                                Matcher matcher3 = d.CONTENT_TYPE_PATTERN.matcher(readLine2);
                                if (matcher3.matches()) {
                                    str4 = matcher3.group(2).trim();
                                }
                                readLine2 = bufferedReader.readLine();
                                i16++;
                                i10 = 2;
                                i15 = 1;
                            }
                            int i17 = 0;
                            while (true) {
                                int i18 = i16 - 1;
                                if (i16 <= 0) {
                                    break;
                                }
                                i17 = a(bArr, i17);
                                i16 = i18;
                            }
                            if (i17 < remaining - 4) {
                                int i19 = a10[i13] + i17;
                                i13++;
                                int i20 = a10[i13] - 4;
                                byteBuffer2.position(i19);
                                List list = map3.get(str2);
                                if (list == null) {
                                    list = new ArrayList();
                                    map3.put(str2, list);
                                }
                                if (str4 == null) {
                                    byte[] bArr2 = new byte[(i20 - i19)];
                                    byteBuffer2.get(bArr2);
                                    list.add(new String(bArr2, aVar.c()));
                                } else {
                                    String a11 = a(byteBuffer2, i19, i20 - i19, str3);
                                    if (!map4.containsKey(str2)) {
                                        map4.put(str2, a11);
                                    } else {
                                        int i21 = 2;
                                        while (true) {
                                            if (!map4.containsKey(str2 + i21)) {
                                                break;
                                            }
                                            i21++;
                                        }
                                        map4.put(str2 + i21, a11);
                                    }
                                    list.add(str3);
                                }
                                i11 = 1024;
                                i10 = 2;
                                i12 = 0;
                            } else {
                                throw new d.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                            }
                        }
                    } else {
                        return;
                    }
                }
                throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
            }
            throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
        } catch (d.a e10) {
            throw e10;
        } catch (Exception e11) {
            throw new d.a(com.hpplay.a.a.a.c.d.INTERNAL_ERROR, e11.toString());
        }
    }

    private int a(byte[] bArr, int i10) {
        while (bArr[i10] != 10) {
            i10++;
        }
        return i10 + 1;
    }

    private void a(String str, Map<String, List<String>> map) {
        String str2;
        String str3;
        if (str == null) {
            this.f10449q = "";
            return;
        }
        this.f10449q = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str, DispatchConstants.SIGN_SPLIT_SYMBOL);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf >= 0) {
                str3 = d.decodePercent(nextToken.substring(0, indexOf)).trim();
                str2 = d.decodePercent(nextToken.substring(indexOf + 1));
            } else {
                str3 = d.decodePercent(nextToken).trim();
                str2 = "";
            }
            List list = map.get(str3);
            if (list == null) {
                list = new ArrayList();
                map.put(str3, list);
            }
            list.add(str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0167, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        com.hpplay.a.a.a.c.c.a((com.hpplay.a.a.a.c.b) r0.a(), com.hpplay.a.a.a.d.MIME_PLAINTEXT, r0.getMessage()).a(r10.f10440h);
        com.hpplay.a.a.a.d.safeClose(r10.f10440h);
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0167 A[ExcHandler: a (r0v14 'e' com.hpplay.a.a.a.d$a A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r10 = this;
            java.lang.String r0 = "method"
            java.lang.String r1 = "NanoHttpd Shutdown"
            java.lang.String r2 = "text/plain"
            r3 = 8192(0x2000, float:1.14794E-41)
            r4 = 0
            byte[] r5 = new byte[r3]     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r6 = 0
            r10.f10442j = r6     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.f10443k = r6     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.BufferedInputStream r7 = r10.f10441i     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r7.mark(r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.BufferedInputStream r7 = r10.f10441i     // Catch:{ SSLException -> 0x0163, IOException -> 0x0153, a -> 0x0167 }
            int r3 = r7.read(r5, r6, r3)     // Catch:{ SSLException -> 0x0163, IOException -> 0x0153, a -> 0x0167 }
            r7 = -1
            if (r3 == r7) goto L_0x0143
        L_0x001e:
            if (r3 <= 0) goto L_0x0039
            int r7 = r10.f10443k     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            int r7 = r7 + r3
            r10.f10443k = r7     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            int r3 = r10.b(r5, r7)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.f10442j = r3     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 <= 0) goto L_0x002e
            goto L_0x0039
        L_0x002e:
            java.io.BufferedInputStream r3 = r10.f10441i     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            int r7 = r10.f10443k     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            int r8 = 8192 - r7
            int r3 = r3.read(r5, r7, r8)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            goto L_0x001e
        L_0x0039:
            int r3 = r10.f10442j     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            int r7 = r10.f10443k     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 >= r7) goto L_0x004c
            java.io.BufferedInputStream r3 = r10.f10441i     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r3.reset()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.BufferedInputStream r3 = r10.f10441i     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            int r7 = r10.f10442j     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            long r7 = (long) r7     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r3.skip(r7)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x004c:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r3.<init>()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.f10446n = r3     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r10.f10447o     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 != 0) goto L_0x005f
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r3.<init>()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.f10447o = r3     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            goto L_0x0062
        L_0x005f:
            r3.clear()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x0062:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            int r9 = r10.f10443k     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r8.<init>(r5, r6, r9)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r7.<init>(r8)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r3.<init>(r7)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r5.<init>()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r10.f10446n     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.util.Map<java.lang.String, java.lang.String> r8 = r10.f10447o     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.a((java.io.BufferedReader) r3, (java.util.Map<java.lang.String, java.lang.String>) r5, (java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r7, (java.util.Map<java.lang.String, java.lang.String>) r8)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r3 = r10.f10450r     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 == 0) goto L_0x0093
            java.util.Map<java.lang.String, java.lang.String> r7 = r10.f10447o     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r8 = "remote-addr"
            r7.put(r8, r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r10.f10447o     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r7 = "http-client-ip"
            java.lang.String r8 = r10.f10450r     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r3.put(r7, r8)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x0093:
            java.lang.Object r3 = r5.get(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.b.a r3 = com.hpplay.a.a.a.b.a.a(r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.f10445m = r3     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 == 0) goto L_0x011f
            java.lang.String r0 = "uri"
            java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.f10444l = r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.a.c r0 = new com.hpplay.a.a.a.a.c     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r10.f10447o     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r0.<init>(r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r10.f10448p = r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r10.f10447o     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r3 = "connection"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r3 = "HTTP/1.1"
            java.lang.String r5 = r10.f10452t     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            boolean r3 = r3.equals(r5)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 == 0) goto L_0x00d4
            if (r0 == 0) goto L_0x00d2
            java.lang.String r3 = "(?i).*close.*"
            boolean r0 = r0.matches(r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r0 != 0) goto L_0x00d4
        L_0x00d2:
            r0 = 1
            goto L_0x00d5
        L_0x00d4:
            r0 = 0
        L_0x00d5:
            com.hpplay.a.a.a.d r3 = r10.f10438f     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.c.c r4 = r3.handle(r10)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r4 == 0) goto L_0x0115
            java.util.Map<java.lang.String, java.lang.String> r3 = r10.f10447o     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r5 = "accept-encoding"
            java.lang.Object r3 = r3.get(r5)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.a.c r5 = r10.f10448p     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r5.a((com.hpplay.a.a.a.c.c) r4)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.b.a r5 = r10.f10445m     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r4.a((com.hpplay.a.a.a.b.a) r5)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 == 0) goto L_0x00fb
            java.lang.String r5 = "gzip"
            boolean r3 = r3.contains(r5)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r3 != 0) goto L_0x00fe
        L_0x00fb:
            r4.d((boolean) r6)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x00fe:
            r4.b((boolean) r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.OutputStream r3 = r10.f10440h     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r4.a((java.io.OutputStream) r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r0 == 0) goto L_0x010f
            boolean r0 = r4.b()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            if (r0 != 0) goto L_0x010f
            goto L_0x017e
        L_0x010f:
            java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r0.<init>(r1)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            throw r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x0115:
            com.hpplay.a.a.a.d$a r0 = new com.hpplay.a.a.a.d$a     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.c.d r1 = com.hpplay.a.a.a.c.d.INTERNAL_ERROR     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r3 = "SERVER INTERNAL ERROR: Serve() returned a null response."
            r0.<init>(r1, r3)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            throw r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x011f:
            com.hpplay.a.a.a.d$a r1 = new com.hpplay.a.a.a.d$a     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.c.d r3 = com.hpplay.a.a.a.c.d.BAD_REQUEST     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r6.<init>()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r7 = "BAD REQUEST: Syntax error. HTTP verb "
            r6.append(r7)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r6.append(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r0 = " unhandled."
            r6.append(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.lang.String r0 = r6.toString()     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r1.<init>(r3, r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            throw r1     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x0143:
            java.io.BufferedInputStream r0 = r10.f10441i     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.d.safeClose(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.OutputStream r0 = r10.f10440h     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.d.safeClose(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r0.<init>(r1)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            throw r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x0153:
            java.io.BufferedInputStream r0 = r10.f10441i     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.d.safeClose(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.io.OutputStream r0 = r10.f10440h     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            com.hpplay.a.a.a.d.safeClose(r0)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            r0.<init>(r1)     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
            throw r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x0163:
            r0 = move-exception
            throw r0     // Catch:{ SocketException -> 0x01d8, SocketTimeoutException -> 0x01d6, SSLException -> 0x01ae, IOException -> 0x0187, a -> 0x0167 }
        L_0x0165:
            r0 = move-exception
            goto L_0x01da
        L_0x0167:
            r0 = move-exception
            com.hpplay.a.a.a.c.d r1 = r0.a()     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0165 }
            com.hpplay.a.a.a.c.c r0 = com.hpplay.a.a.a.c.c.a((com.hpplay.a.a.a.c.b) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0165 }
            java.io.OutputStream r1 = r10.f10440h     // Catch:{ all -> 0x0165 }
            r0.a((java.io.OutputStream) r1)     // Catch:{ all -> 0x0165 }
            java.io.OutputStream r0 = r10.f10440h     // Catch:{ all -> 0x0165 }
            com.hpplay.a.a.a.d.safeClose(r0)     // Catch:{ all -> 0x0165 }
        L_0x017e:
            com.hpplay.a.a.a.d.safeClose(r4)
            com.hpplay.a.a.a.e.e r0 = r10.f10439g
            r0.a()
            goto L_0x01d5
        L_0x0187:
            r0 = move-exception
            com.hpplay.a.a.a.c.d r1 = com.hpplay.a.a.a.c.d.INTERNAL_ERROR     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r3.<init>()     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = "SERVER INTERNAL ERROR: IOException: "
            r3.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0165 }
            r3.append(r0)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0165 }
            com.hpplay.a.a.a.c.c r0 = com.hpplay.a.a.a.c.c.a((com.hpplay.a.a.a.c.b) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0165 }
            java.io.OutputStream r1 = r10.f10440h     // Catch:{ all -> 0x0165 }
            r0.a((java.io.OutputStream) r1)     // Catch:{ all -> 0x0165 }
            java.io.OutputStream r0 = r10.f10440h     // Catch:{ all -> 0x0165 }
            com.hpplay.a.a.a.d.safeClose(r0)     // Catch:{ all -> 0x0165 }
            goto L_0x017e
        L_0x01ae:
            r0 = move-exception
            com.hpplay.a.a.a.c.d r1 = com.hpplay.a.a.a.c.d.INTERNAL_ERROR     // Catch:{ all -> 0x0165 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0165 }
            r3.<init>()     // Catch:{ all -> 0x0165 }
            java.lang.String r5 = "SSL PROTOCOL FAILURE: "
            r3.append(r5)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0165 }
            r3.append(r0)     // Catch:{ all -> 0x0165 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0165 }
            com.hpplay.a.a.a.c.c r0 = com.hpplay.a.a.a.c.c.a((com.hpplay.a.a.a.c.b) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x0165 }
            java.io.OutputStream r1 = r10.f10440h     // Catch:{ all -> 0x0165 }
            r0.a((java.io.OutputStream) r1)     // Catch:{ all -> 0x0165 }
            java.io.OutputStream r0 = r10.f10440h     // Catch:{ all -> 0x0165 }
            com.hpplay.a.a.a.d.safeClose(r0)     // Catch:{ all -> 0x0165 }
            goto L_0x017e
        L_0x01d5:
            return
        L_0x01d6:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0165 }
        L_0x01d8:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0165 }
        L_0x01da:
            com.hpplay.a.a.a.d.safeClose(r4)
            com.hpplay.a.a.a.e.e r1 = r10.f10439g
            r1.a()
            goto L_0x01e4
        L_0x01e3:
            throw r0
        L_0x01e4:
            goto L_0x01e3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.a.a.a.b.a():void");
    }

    private int[] a(ByteBuffer byteBuffer, byte[] bArr) {
        int[] iArr = new int[0];
        if (byteBuffer.remaining() < bArr.length) {
            return iArr;
        }
        int length = bArr.length + 4096;
        byte[] bArr2 = new byte[length];
        int remaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
        byteBuffer.get(bArr2, 0, remaining);
        int length2 = remaining - bArr.length;
        int i10 = 0;
        do {
            int i11 = 0;
            while (i11 < length2) {
                int i12 = 0;
                while (i12 < bArr.length && bArr2[i11 + i12] == bArr[i12]) {
                    if (i12 == bArr.length - 1) {
                        int[] iArr2 = new int[(iArr.length + 1)];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        iArr2[iArr.length] = i10 + i11;
                        iArr = iArr2;
                    }
                    i12++;
                }
                i11++;
            }
            i10 += length2;
            System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
            length2 = length - bArr.length;
            if (byteBuffer.remaining() < length2) {
                length2 = byteBuffer.remaining();
            }
            byteBuffer.get(bArr2, bArr.length, length2);
        } while (length2 > 0);
        return iArr;
    }

    public void a(Map<String, String> map) {
        DataOutputStream dataOutputStream;
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteBuffer byteBuffer;
        Map<String, String> map2 = map;
        RandomAccessFile randomAccessFile2 = null;
        try {
            long j10 = j();
            if (j10 < 1024) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                randomAccessFile = null;
            } else {
                randomAccessFile = m();
                byteArrayOutputStream = null;
                dataOutputStream = randomAccessFile;
            }
            try {
                byte[] bArr = new byte[512];
                while (this.f10443k >= 0 && j10 > 0) {
                    int read = this.f10441i.read(bArr, 0, (int) Math.min(j10, 512));
                    this.f10443k = read;
                    j10 -= (long) read;
                    if (read > 0) {
                        dataOutputStream.write(bArr, 0, read);
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteBuffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                } else {
                    byteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
                    randomAccessFile.seek(0);
                }
                if (a.POST.equals(this.f10445m)) {
                    com.hpplay.a.a.a.a.a aVar = new com.hpplay.a.a.a.a.a(this.f10447o.get("content-type"));
                    if (!aVar.e()) {
                        byte[] bArr2 = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr2);
                        String trim = new String(bArr2, aVar.c()).trim();
                        if ("application/x-www-form-urlencoded".equalsIgnoreCase(aVar.b())) {
                            a(trim, this.f10446n);
                        } else if (trim.length() != 0) {
                            map2.put(f10433a, trim);
                        }
                    } else if (aVar.d() != null) {
                        a(aVar, byteBuffer, this.f10446n, map2);
                    } else {
                        throw new d.a(com.hpplay.a.a.a.c.d.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    }
                } else if (a.f10454b.equals(this.f10445m)) {
                    map2.put("content", a(byteBuffer, 0, byteBuffer.limit(), (String) null));
                }
                d.safeClose(randomAccessFile);
            } catch (Throwable th) {
                th = th;
                randomAccessFile2 = randomAccessFile;
                d.safeClose(randomAccessFile2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            d.safeClose(randomAccessFile2);
            throw th;
        }
    }

    private String a(ByteBuffer byteBuffer, int i10, int i11, String str) {
        if (i11 <= 0) {
            return "";
        }
        FileOutputStream fileOutputStream = null;
        try {
            com.hpplay.a.a.a.e.d a10 = this.f10439g.a(str);
            ByteBuffer duplicate = byteBuffer.duplicate();
            FileOutputStream fileOutputStream2 = new FileOutputStream(a10.b());
            try {
                FileChannel channel = fileOutputStream2.getChannel();
                duplicate.position(i10).limit(i10 + i11);
                channel.write(duplicate.slice());
                String b10 = a10.b();
                d.safeClose(fileOutputStream2);
                return b10;
            } catch (Exception e10) {
                e = e10;
                fileOutputStream = fileOutputStream2;
                try {
                    throw new Error(e);
                } catch (Throwable th) {
                    th = th;
                    d.safeClose(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                d.safeClose(fileOutputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            throw new Error(e);
        }
    }
}
