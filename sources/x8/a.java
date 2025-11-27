package x8;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.gms.cast.MediaError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.push.IPushHandler;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.sdk.source.common.global.Constant;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.http.StatusLine;

public abstract class a {

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f19789h = Pattern.compile(com.hpplay.a.a.a.d.CONTENT_DISPOSITION_REGEX, 2);

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f19790i = Pattern.compile(com.hpplay.a.a.a.d.CONTENT_TYPE_REGEX, 2);

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f19791j = Pattern.compile(com.hpplay.a.a.a.d.CONTENT_DISPOSITION_ATTRIBUTE_REGEX);

    /* renamed from: k  reason: collision with root package name */
    public static final Logger f19792k = Logger.getLogger(a.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final String f19793a;

    /* renamed from: b  reason: collision with root package name */
    public final int f19794b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ServerSocket f19795c;

    /* renamed from: d  reason: collision with root package name */
    public p f19796d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f19797e;

    /* renamed from: f  reason: collision with root package name */
    public b f19798f;

    /* renamed from: g  reason: collision with root package name */
    public r f19799g;

    public interface b {
        void a(c cVar);

        void b(c cVar);
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f19800a;

        /* renamed from: b  reason: collision with root package name */
        public final Socket f19801b;

        public c(InputStream inputStream, Socket socket) {
            this.f19800a = inputStream;
            this.f19801b = socket;
        }

        public void run() {
            OutputStream outputStream = null;
            try {
                outputStream = this.f19801b.getOutputStream();
                j jVar = new j(a.this.f19799g.create(), this.f19800a, outputStream, this.f19801b.getInetAddress());
                while (!this.f19801b.isClosed()) {
                    jVar.d();
                }
            } catch (Exception e10) {
                if ((!(e10 instanceof SocketException) || !"NanoHttpd Shutdown".equals(e10.getMessage())) && !(e10 instanceof SocketTimeoutException)) {
                    a.f19792k.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", e10);
                }
            } catch (Throwable th) {
                a.o((Object) null);
                a.o(this.f19800a);
                a.o(this.f19801b);
                a.this.f19798f.b(this);
                throw th;
            }
            a.o(outputStream);
            a.o(this.f19800a);
            a.o(this.f19801b);
            a.this.f19798f.b(this);
        }
    }

    public static class d {

        /* renamed from: e  reason: collision with root package name */
        public static final Pattern f19803e = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);

        /* renamed from: f  reason: collision with root package name */
        public static final Pattern f19804f = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* renamed from: g  reason: collision with root package name */
        public static final Pattern f19805g = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        /* renamed from: a  reason: collision with root package name */
        public final String f19806a;

        /* renamed from: b  reason: collision with root package name */
        public final String f19807b;

        /* renamed from: c  reason: collision with root package name */
        public final String f19808c;

        /* renamed from: d  reason: collision with root package name */
        public final String f19809d;

        public d(String str) {
            this.f19806a = str;
            if (str != null) {
                this.f19807b = b(str, f19803e, "", 1);
                this.f19808c = b(str, f19804f, (String) null, 2);
            } else {
                this.f19807b = "";
                this.f19808c = "UTF-8";
            }
            if ("multipart/form-data".equalsIgnoreCase(this.f19807b)) {
                this.f19809d = b(str, f19805g, (String) null, 2);
            } else {
                this.f19809d = null;
            }
        }

        public String a() {
            return this.f19806a;
        }

        public final String b(String str, Pattern pattern, String str2, int i10) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group(i10);
            }
            return str2;
        }

        public String c() {
            String str = this.f19808c;
            if (str == null) {
                return "US-ASCII";
            }
            return str;
        }

        public d d() {
            if (this.f19808c != null) {
                return this;
            }
            return new d(this.f19806a + "; charset=UTF-8");
        }
    }

    public class e implements Iterable {

        /* renamed from: a  reason: collision with root package name */
        public final HashMap f19810a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList f19811b = new ArrayList();

        public e(Map map) {
            String str = (String) map.get("cookie");
            if (str != null) {
                for (String trim : str.split(";")) {
                    String[] split = trim.trim().split(Operator.Operation.EQUALS);
                    if (split.length == 2) {
                        this.f19810a.put(split[0], split[1]);
                    }
                }
            }
        }

        public void a(m mVar) {
            Iterator it = this.f19811b.iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }

        public Iterator iterator() {
            return this.f19810a.keySet().iterator();
        }
    }

    public static class f implements b {

        /* renamed from: a  reason: collision with root package name */
        public long f19813a;

        /* renamed from: b  reason: collision with root package name */
        public final List f19814b = Collections.synchronizedList(new ArrayList());

        public void a(c cVar) {
            this.f19813a++;
            Thread thread = new Thread(cVar);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.f19813a + ")");
            this.f19814b.add(cVar);
            thread.start();
        }

        public void b(c cVar) {
            this.f19814b.remove(cVar);
        }
    }

    public static class g implements p {
        public ServerSocket create() {
            return new ServerSocket();
        }
    }

    public static class h implements q {

        /* renamed from: a  reason: collision with root package name */
        public final File f19815a;

        /* renamed from: b  reason: collision with root package name */
        public final List f19816b;

        public h() {
            File file = new File(System.getProperty("java.io.tmpdir"));
            this.f19815a = file;
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f19816b = new ArrayList();
        }

        public void clear() {
            for (Object a10 : this.f19816b) {
                androidx.appcompat.app.m.a(a10);
                try {
                    throw null;
                } catch (Exception e10) {
                    a.f19792k.log(Level.WARNING, "could not delete file ", e10);
                }
            }
            this.f19816b.clear();
        }
    }

    public class i implements r {
        public i() {
        }

        public q create() {
            return new h();
        }
    }

    public class j implements k {

        /* renamed from: a  reason: collision with root package name */
        public final q f19818a;

        /* renamed from: b  reason: collision with root package name */
        public final OutputStream f19819b;

        /* renamed from: c  reason: collision with root package name */
        public final BufferedInputStream f19820c;

        /* renamed from: d  reason: collision with root package name */
        public int f19821d;

        /* renamed from: e  reason: collision with root package name */
        public int f19822e;

        /* renamed from: f  reason: collision with root package name */
        public String f19823f;

        /* renamed from: g  reason: collision with root package name */
        public l f19824g;

        /* renamed from: h  reason: collision with root package name */
        public Map f19825h;

        /* renamed from: i  reason: collision with root package name */
        public Map f19826i;

        /* renamed from: j  reason: collision with root package name */
        public e f19827j;

        /* renamed from: k  reason: collision with root package name */
        public String f19828k;

        /* renamed from: l  reason: collision with root package name */
        public String f19829l;

        /* renamed from: m  reason: collision with root package name */
        public String f19830m;

        /* renamed from: n  reason: collision with root package name */
        public String f19831n;

        public j(q qVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            String str;
            String str2;
            this.f19818a = qVar;
            this.f19820c = new BufferedInputStream(inputStream, 8192);
            this.f19819b = outputStream;
            if (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) {
                str = "127.0.0.1";
            } else {
                str = inetAddress.getHostAddress().toString();
            }
            this.f19829l = str;
            if (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) {
                str2 = "localhost";
            } else {
                str2 = inetAddress.getHostName().toString();
            }
            this.f19830m = str2;
            this.f19826i = new HashMap();
        }

        public final String a() {
            return this.f19823f;
        }

        public final void b(BufferedReader bufferedReader, Map map, Map map2, Map map3) {
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
                                c(nextToken.substring(indexOf + 1), map2);
                                str = a.i(nextToken.substring(0, indexOf));
                            } else {
                                str = a.i(nextToken);
                            }
                            if (stringTokenizer.hasMoreTokens()) {
                                this.f19831n = stringTokenizer.nextToken();
                            } else {
                                this.f19831n = "HTTP/1.1";
                                a.f19792k.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
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
                        throw new n(m.d.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    }
                    throw new n(m.d.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
            } catch (IOException e10) {
                m.d dVar = m.d.INTERNAL_ERROR;
                throw new n(dVar, "SERVER INTERNAL ERROR: IOException: " + e10.getMessage(), e10);
            }
        }

        public final void c(String str, Map map) {
            String str2;
            String str3;
            if (str == null) {
                this.f19828k = "";
                return;
            }
            this.f19828k = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, DispatchConstants.SIGN_SPLIT_SYMBOL);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    str3 = a.i(nextToken.substring(0, indexOf)).trim();
                    str2 = a.i(nextToken.substring(indexOf + 1));
                } else {
                    str3 = a.i(nextToken).trim();
                    str2 = "";
                }
                List list = (List) map.get(str3);
                if (list == null) {
                    list = new ArrayList();
                    map.put(str3, list);
                }
                list.add(str2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0173, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            x8.a.n(r0.a(), com.hpplay.a.a.a.d.MIME_PLAINTEXT, r0.getMessage()).m(r10.f19819b);
            x8.a.a(r10.f19819b);
         */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0173 A[ExcHandler: n (r0v14 'e' x8.a$n A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r10 = this;
                java.lang.String r0 = "method"
                java.lang.String r1 = "NanoHttpd Shutdown"
                java.lang.String r2 = "text/plain"
                r3 = 8192(0x2000, float:1.14794E-41)
                r4 = 0
                byte[] r5 = new byte[r3]     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r6 = 0
                r10.f19821d = r6     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.f19822e = r6     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.BufferedInputStream r7 = r10.f19820c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r7.mark(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.BufferedInputStream r7 = r10.f19820c     // Catch:{ SSLException -> 0x016f, IOException -> 0x015f, n -> 0x0173 }
                int r3 = r7.read(r5, r6, r3)     // Catch:{ SSLException -> 0x016f, IOException -> 0x015f, n -> 0x0173 }
                r7 = -1
                if (r3 == r7) goto L_0x014f
            L_0x001e:
                if (r3 <= 0) goto L_0x0039
                int r7 = r10.f19822e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                int r7 = r7 + r3
                r10.f19822e = r7     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                int r3 = r10.e(r5, r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.f19821d = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r3 <= 0) goto L_0x002e
                goto L_0x0039
            L_0x002e:
                java.io.BufferedInputStream r3 = r10.f19820c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                int r7 = r10.f19822e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                int r8 = 8192 - r7
                int r3 = r3.read(r5, r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                goto L_0x001e
            L_0x0039:
                int r3 = r10.f19821d     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                int r7 = r10.f19822e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r3 >= r7) goto L_0x004c
                java.io.BufferedInputStream r3 = r10.f19820c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r3.reset()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.BufferedInputStream r3 = r10.f19820c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                int r7 = r10.f19821d     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                long r7 = (long) r7     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r3.skip(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x004c:
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r3.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.f19825h = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.util.Map r3 = r10.f19826i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r3 != 0) goto L_0x005f
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r3.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.f19826i = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                goto L_0x0062
            L_0x005f:
                r3.clear()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x0062:
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                int r9 = r10.f19822e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r8.<init>(r5, r6, r9)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r7.<init>(r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r3.<init>(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r5.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.util.Map r7 = r10.f19825h     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.util.Map r8 = r10.f19826i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.b(r3, r5, r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r3 = r10.f19829l     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r3 == 0) goto L_0x0093
                java.util.Map r7 = r10.f19826i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r8 = "remote-addr"
                r7.put(r8, r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.util.Map r3 = r10.f19826i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r7 = "http-client-ip"
                java.lang.String r8 = r10.f19829l     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r3.put(r7, r8)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x0093:
                java.lang.Object r3 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a$l r3 = x8.a.l.a(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.f19824g = r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r3 == 0) goto L_0x012b
                java.lang.String r0 = "uri"
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.f19823f = r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a$e r0 = new x8.a$e     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a r3 = x8.a.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.util.Map r5 = r10.f19826i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r0.<init>(r5)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r10.f19827j = r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.util.Map r0 = r10.f19826i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r3 = "connection"
                java.lang.Object r0 = r0.get(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r3 = "HTTP/1.1"
                java.lang.String r5 = r10.f19831n     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                boolean r3 = r3.equals(r5)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r5 = 1
                if (r3 == 0) goto L_0x00d7
                if (r0 == 0) goto L_0x00d5
                java.lang.String r3 = "(?i).*close.*"
                boolean r0 = r0.matches(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r0 != 0) goto L_0x00d7
            L_0x00d5:
                r0 = 1
                goto L_0x00d8
            L_0x00d7:
                r0 = 0
            L_0x00d8:
                x8.a r3 = x8.a.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a$m r4 = r3.p(r10)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r4 == 0) goto L_0x0121
                java.util.Map r3 = r10.f19826i     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r7 = "accept-encoding"
                java.lang.Object r3 = r3.get(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a$e r7 = r10.f19827j     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r7.a(r4)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a$l r7 = r10.f19824g     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r4.z(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a r7 = x8.a.this     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                boolean r7 = r7.t(r4)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r7 == 0) goto L_0x0107
                if (r3 == 0) goto L_0x0107
                java.lang.String r7 = "gzip"
                boolean r3 = r3.contains(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r3 == 0) goto L_0x0107
                r6 = 1
            L_0x0107:
                r4.x(r6)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r4.y(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.OutputStream r3 = r10.f19819b     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r4.m(r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r0 == 0) goto L_0x011b
                boolean r0 = r4.e()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                if (r0 != 0) goto L_0x011b
                goto L_0x018a
            L_0x011b:
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x0121:
                x8.a$n r0 = new x8.a$n     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a$m$d r1 = x8.a.m.d.INTERNAL_ERROR     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r3 = "SERVER INTERNAL ERROR: Serve() returned a null response."
                r0.<init>(r1, r3)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x012b:
                x8.a$n r1 = new x8.a$n     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a$m$d r3 = x8.a.m.d.BAD_REQUEST     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r6.<init>()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r7 = "BAD REQUEST: Syntax error. HTTP verb "
                r6.append(r7)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.Object r0 = r5.get(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r6.append(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r0 = " unhandled."
                r6.append(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.lang.String r0 = r6.toString()     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r1.<init>(r3, r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                throw r1     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x014f:
                java.io.BufferedInputStream r0 = r10.f19820c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a.o(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.OutputStream r0 = r10.f19819b     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a.o(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x015f:
                java.io.BufferedInputStream r0 = r10.f19820c     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a.o(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.io.OutputStream r0 = r10.f19819b     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                x8.a.o(r0)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                r0.<init>(r1)     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x016f:
                r0 = move-exception
                throw r0     // Catch:{ SocketException -> 0x01e4, SocketTimeoutException -> 0x01e2, SSLException -> 0x01ba, IOException -> 0x0193, n -> 0x0173 }
            L_0x0171:
                r0 = move-exception
                goto L_0x01e6
            L_0x0173:
                r0 = move-exception
                x8.a$m$d r1 = r0.a()     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                x8.a$m r0 = x8.a.n(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.f19819b     // Catch:{ all -> 0x0171 }
                r0.m(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.f19819b     // Catch:{ all -> 0x0171 }
                x8.a.o(r0)     // Catch:{ all -> 0x0171 }
            L_0x018a:
                x8.a.o(r4)
                x8.a$q r0 = r10.f19818a
                r0.clear()
                goto L_0x01e1
            L_0x0193:
                r0 = move-exception
                x8.a$m$d r1 = x8.a.m.d.INTERNAL_ERROR     // Catch:{ all -> 0x0171 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
                r3.<init>()     // Catch:{ all -> 0x0171 }
                java.lang.String r5 = "SERVER INTERNAL ERROR: IOException: "
                r3.append(r5)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                r3.append(r0)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0171 }
                x8.a$m r0 = x8.a.n(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.f19819b     // Catch:{ all -> 0x0171 }
                r0.m(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.f19819b     // Catch:{ all -> 0x0171 }
                x8.a.o(r0)     // Catch:{ all -> 0x0171 }
                goto L_0x018a
            L_0x01ba:
                r0 = move-exception
                x8.a$m$d r1 = x8.a.m.d.INTERNAL_ERROR     // Catch:{ all -> 0x0171 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
                r3.<init>()     // Catch:{ all -> 0x0171 }
                java.lang.String r5 = "SSL PROTOCOL FAILURE: "
                r3.append(r5)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0171 }
                r3.append(r0)     // Catch:{ all -> 0x0171 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0171 }
                x8.a$m r0 = x8.a.n(r1, r2, r0)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r1 = r10.f19819b     // Catch:{ all -> 0x0171 }
                r0.m(r1)     // Catch:{ all -> 0x0171 }
                java.io.OutputStream r0 = r10.f19819b     // Catch:{ all -> 0x0171 }
                x8.a.o(r0)     // Catch:{ all -> 0x0171 }
                goto L_0x018a
            L_0x01e1:
                return
            L_0x01e2:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0171 }
            L_0x01e4:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0171 }
            L_0x01e6:
                x8.a.o(r4)
                x8.a$q r1 = r10.f19818a
                r1.clear()
                goto L_0x01f0
            L_0x01ef:
                throw r0
            L_0x01f0:
                goto L_0x01ef
            */
            throw new UnsupportedOperationException("Method not decompiled: x8.a.j.d():void");
        }

        public final int e(byte[] bArr, int i10) {
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

        public final l getMethod() {
            return this.f19824g;
        }

        public final Map getParameters() {
            return this.f19825h;
        }
    }

    public interface k {
        String a();

        l getMethod();

        Map getParameters();
    }

    public enum l {
        GET,
        f19834b,
        POST,
        DELETE,
        HEAD,
        f19838f,
        TRACE,
        CONNECT,
        PATCH,
        PROPFIND,
        PROPPATCH,
        MKCOL,
        MOVE,
        COPY,
        LOCK,
        UNLOCK;

        public static l a(String str) {
            if (str == null) {
                return null;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public static class m implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public c f19850a;

        /* renamed from: b  reason: collision with root package name */
        public String f19851b;

        /* renamed from: c  reason: collision with root package name */
        public InputStream f19852c;

        /* renamed from: d  reason: collision with root package name */
        public long f19853d;

        /* renamed from: e  reason: collision with root package name */
        public final Map f19854e = new C0292a();

        /* renamed from: f  reason: collision with root package name */
        public final Map f19855f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        public l f19856g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19857h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19858i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f19859j;

        /* renamed from: x8.a$m$a  reason: collision with other inner class name */
        public class C0292a extends HashMap {
            public C0292a() {
            }

            /* renamed from: a */
            public String put(String str, String str2) {
                String str3;
                Map a10 = m.this.f19855f;
                if (str == null) {
                    str3 = str;
                } else {
                    str3 = str.toLowerCase();
                }
                a10.put(str3, str2);
                return (String) super.put(str, str2);
            }
        }

        public static class b extends FilterOutputStream {
            public b(OutputStream outputStream) {
                super(outputStream);
            }

            public void a() {
                this.out.write("0\r\n\r\n".getBytes());
            }

            public void write(int i10) {
                write(new byte[]{(byte) i10}, 0, 1);
            }

            public void write(byte[] bArr) {
                write(bArr, 0, bArr.length);
            }

            public void write(byte[] bArr, int i10, int i11) {
                if (i11 != 0) {
                    this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i11)}).getBytes());
                    this.out.write(bArr, i10, i11);
                    this.out.write("\r\n".getBytes());
                }
            }
        }

        public interface c {
            String getDescription();
        }

        public enum d implements c {
            SWITCH_PROTOCOL(101, IPushHandler.SP),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            MULTI_STATUS(207, "Multi-Status"),
            REDIRECT(301, "Moved Permanently"),
            FOUND(302, "Found"),
            REDIRECT_SEE_OTHER(303, "See Other"),
            NOT_MODIFIED(304, "Not Modified"),
            TEMPORARY_REDIRECT(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(UPnPStatus.OUT_OF_SYNC, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            GONE(Constant.TOKEN_EXPIRED, "Gone"),
            LENGTH_REQUIRED(MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER, "Length Required"),
            PRECONDITION_FAILED(412, "Precondition Failed"),
            PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
            UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            EXPECTATION_FAILED(417, "Expectation Failed"),
            TOO_MANY_REQUESTS(429, "Too Many Requests"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(UPnPStatus.ACTION_FAILED, "Not Implemented"),
            SERVICE_UNAVAILABLE(503, "Service Unavailable"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            

            /* renamed from: a  reason: collision with root package name */
            public final int f19885a;

            /* renamed from: b  reason: collision with root package name */
            public final String f19886b;

            /* access modifiers changed from: public */
            d(int i10, String str) {
                this.f19885a = i10;
                this.f19886b = str;
            }

            public String getDescription() {
                return "" + this.f19885a + " " + this.f19886b;
            }
        }

        public m(c cVar, String str, InputStream inputStream, long j10) {
            this.f19850a = cVar;
            this.f19851b = str;
            boolean z10 = false;
            if (inputStream == null) {
                this.f19852c = new ByteArrayInputStream(new byte[0]);
                this.f19853d = 0;
            } else {
                this.f19852c = inputStream;
                this.f19853d = j10;
            }
            this.f19857h = this.f19853d < 0 ? true : z10;
            this.f19859j = true;
        }

        public String b(String str) {
            return (String) this.f19855f.get(str.toLowerCase());
        }

        public String c() {
            return this.f19851b;
        }

        public void close() {
            InputStream inputStream = this.f19852c;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public boolean e() {
            return HTTP.CLOSE.equals(b("connection"));
        }

        public void f(PrintWriter printWriter, String str, String str2) {
            printWriter.append(str).append(": ").append(str2).append("\r\n");
        }

        public void m(OutputStream outputStream) {
            long j10;
            String str;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.f19850a != null) {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, new d(this.f19851b).c())), false);
                    printWriter.append("HTTP/1.1 ").append(this.f19850a.getDescription()).append(" \r\n");
                    String str2 = this.f19851b;
                    if (str2 != null) {
                        f(printWriter, "Content-Type", str2);
                    }
                    if (b("date") == null) {
                        f(printWriter, "Date", simpleDateFormat.format(new Date()));
                    }
                    for (Map.Entry entry : this.f19854e.entrySet()) {
                        f(printWriter, (String) entry.getKey(), (String) entry.getValue());
                    }
                    if (b("connection") == null) {
                        if (this.f19859j) {
                            str = "keep-alive";
                        } else {
                            str = HTTP.CLOSE;
                        }
                        f(printWriter, "Connection", str);
                    }
                    if (b("content-length") != null) {
                        this.f19858i = false;
                    }
                    if (this.f19858i) {
                        f(printWriter, "Content-Encoding", "gzip");
                        v(true);
                    }
                    if (this.f19852c != null) {
                        j10 = this.f19853d;
                    } else {
                        j10 = 0;
                    }
                    if (this.f19856g != l.HEAD && this.f19857h) {
                        f(printWriter, "Transfer-Encoding", "chunked");
                    } else if (!this.f19858i) {
                        j10 = u(printWriter, j10);
                    }
                    printWriter.append("\r\n");
                    printWriter.flush();
                    s(outputStream, j10);
                    outputStream.flush();
                    a.o(this.f19852c);
                    return;
                }
                throw new Error("sendResponse(): Status can't be null.");
            } catch (IOException e10) {
                a.f19792k.log(Level.SEVERE, "Could not send response to the client", e10);
            }
        }

        public final void n(OutputStream outputStream, long j10) {
            boolean z10;
            long j11;
            byte[] bArr = new byte[((int) 16384)];
            if (j10 == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            while (true) {
                if (j10 > 0 || z10) {
                    if (z10) {
                        j11 = 16384;
                    } else {
                        j11 = Math.min(j10, 16384);
                    }
                    int read = this.f19852c.read(bArr, 0, (int) j11);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (!z10) {
                            j10 -= (long) read;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void q(OutputStream outputStream, long j10) {
            if (this.f19858i) {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                n(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            n(outputStream, j10);
        }

        public final void s(OutputStream outputStream, long j10) {
            if (this.f19856g == l.HEAD || !this.f19857h) {
                q(outputStream, j10);
                return;
            }
            b bVar = new b(outputStream);
            q(bVar, -1);
            bVar.a();
        }

        public long u(PrintWriter printWriter, long j10) {
            String b10 = b("content-length");
            if (b10 != null) {
                try {
                    j10 = Long.parseLong(b10);
                } catch (NumberFormatException unused) {
                    Logger c10 = a.f19792k;
                    c10.severe("content-length was no number " + b10);
                }
            }
            printWriter.print("Content-Length: " + j10 + "\r\n");
            return j10;
        }

        public void v(boolean z10) {
            this.f19857h = z10;
        }

        public void x(boolean z10) {
            this.f19858i = z10;
        }

        public void y(boolean z10) {
            this.f19859j = z10;
        }

        public void z(l lVar) {
            this.f19856g = lVar;
        }
    }

    public class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f19888a;

        /* renamed from: b  reason: collision with root package name */
        public IOException f19889b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f19890c = false;

        public o(int i10) {
            this.f19888a = i10;
        }

        public void run() {
            InetSocketAddress inetSocketAddress;
            try {
                ServerSocket f10 = a.this.f19795c;
                if (a.this.f19793a != null) {
                    inetSocketAddress = new InetSocketAddress(a.this.f19793a, a.this.f19794b);
                } else {
                    inetSocketAddress = new InetSocketAddress(a.this.f19794b);
                }
                f10.bind(inetSocketAddress);
                this.f19890c = true;
                do {
                    try {
                        Socket accept = a.this.f19795c.accept();
                        int i10 = this.f19888a;
                        if (i10 > 0) {
                            accept.setSoTimeout(i10);
                        }
                        InputStream inputStream = accept.getInputStream();
                        a aVar = a.this;
                        aVar.f19798f.a(aVar.g(accept, inputStream));
                    } catch (IOException e10) {
                        a.f19792k.log(Level.FINE, "Communication with the client broken", e10);
                    }
                } while (!a.this.f19795c.isClosed());
            } catch (IOException e11) {
                this.f19889b = e11;
            }
        }
    }

    public interface p {
        ServerSocket create();
    }

    public interface q {
        void clear();
    }

    public interface r {
        q create();
    }

    public a(int i10) {
        this((String) null, i10);
    }

    public static String i(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e10) {
            f19792k.log(Level.WARNING, "Encoding not supported, ignored", e10);
            return null;
        }
    }

    public static m l(String str) {
        return n(m.d.OK, com.hpplay.a.a.a.d.MIME_HTML, str);
    }

    public static m m(m.c cVar, String str, InputStream inputStream, long j10) {
        return new m(cVar, str, inputStream, j10);
    }

    public static m n(m.c cVar, String str, String str2) {
        byte[] bArr;
        d dVar = new d(str);
        if (str2 == null) {
            return m(cVar, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            if (!Charset.forName(dVar.c()).newEncoder().canEncode(str2)) {
                dVar = dVar.d();
            }
            bArr = str2.getBytes(dVar.c());
        } catch (UnsupportedEncodingException e10) {
            f19792k.log(Level.SEVERE, "encoding problem, responding nothing", e10);
            bArr = new byte[0];
        }
        return m(cVar, dVar.a(), new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    public static final void o(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e10) {
                f19792k.log(Level.SEVERE, "Could not close", e10);
            }
        }
    }

    public c g(Socket socket, InputStream inputStream) {
        return new c(inputStream, socket);
    }

    public o h(int i10) {
        return new o(i10);
    }

    public final int j() {
        if (this.f19795c == null) {
            return -1;
        }
        return this.f19795c.getLocalPort();
    }

    public p k() {
        return this.f19796d;
    }

    public abstract m p(k kVar);

    public void q(b bVar) {
        this.f19798f = bVar;
    }

    public void r(r rVar) {
        this.f19799g = rVar;
    }

    public void s(int i10, boolean z10) {
        this.f19795c = k().create();
        this.f19795c.setReuseAddress(true);
        o h10 = h(i10);
        Thread thread = new Thread(h10);
        this.f19797e = thread;
        thread.setDaemon(z10);
        this.f19797e.setName("NanoHttpd Main Listener");
        this.f19797e.start();
        while (!h10.f19890c && h10.f19889b == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (h10.f19889b != null) {
            throw h10.f19889b;
        }
    }

    public boolean t(m mVar) {
        if (mVar.c() == null || (!mVar.c().toLowerCase().contains("text/") && !mVar.c().toLowerCase().contains("/json"))) {
            return false;
        }
        return true;
    }

    public static final class n extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public final m.d f19887a;

        public n(m.d dVar, String str) {
            super(str);
            this.f19887a = dVar;
        }

        public m.d a() {
            return this.f19887a;
        }

        public n(m.d dVar, String str, Exception exc) {
            super(str, exc);
            this.f19887a = dVar;
        }
    }

    public a(String str, int i10) {
        this.f19796d = new g();
        this.f19793a = str;
        this.f19794b = i10;
        r(new i());
        q(new f());
    }
}
