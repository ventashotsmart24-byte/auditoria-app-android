package com.hpplay.a.a.a.c;

import com.hpplay.a.a.a.d;
import com.hpplay.cybergarage.http.HTTP;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;

public class c implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private b f10472a;

    /* renamed from: b  reason: collision with root package name */
    private String f10473b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f10474c;

    /* renamed from: d  reason: collision with root package name */
    private long f10475d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f10476e = new HashMap<String, String>() {
        /* renamed from: a */
        public String put(String str, String str2) {
            String str3;
            Map a10 = c.this.f10477f;
            if (str == null) {
                str3 = str;
            } else {
                str3 = str.toLowerCase();
            }
            a10.put(str3, str2);
            return (String) super.put(str, str2);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, String> f10477f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private com.hpplay.a.a.a.b.a f10478g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10479h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10480i;

    /* renamed from: j  reason: collision with root package name */
    private List<String> f10481j;

    /* renamed from: k  reason: collision with root package name */
    private a f10482k = a.DEFAULT;

    public enum a {
        DEFAULT,
        ALWAYS,
        NEVER
    }

    public c(b bVar, String str, InputStream inputStream, long j10) {
        this.f10472a = bVar;
        this.f10473b = str;
        boolean z10 = false;
        if (inputStream == null) {
            this.f10474c = new ByteArrayInputStream(new byte[0]);
            this.f10475d = 0;
        } else {
            this.f10474c = inputStream;
            this.f10475d = j10;
        }
        this.f10479h = this.f10475d < 0 ? true : z10;
        this.f10480i = true;
        this.f10481j = new ArrayList(10);
    }

    public boolean b() {
        return HTTP.CLOSE.equals(b("connection"));
    }

    public InputStream c() {
        return this.f10474c;
    }

    public void close() {
        InputStream inputStream = this.f10474c;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public String d() {
        return this.f10473b;
    }

    public com.hpplay.a.a.a.b.a e() {
        return this.f10478g;
    }

    public b f() {
        return this.f10472a;
    }

    public boolean g() {
        a aVar = this.f10482k;
        if (aVar == a.DEFAULT) {
            if (d() == null || (!d().toLowerCase().contains("text/") && !d().toLowerCase().contains("/json"))) {
                return false;
            }
            return true;
        } else if (aVar == a.ALWAYS) {
            return true;
        } else {
            return false;
        }
    }

    private void c(OutputStream outputStream, long j10) {
        long j11;
        byte[] bArr = new byte[((int) 16384)];
        boolean z10 = j10 == -1;
        while (true) {
            if (j10 > 0 || z10) {
                if (z10) {
                    j11 = 16384;
                } else {
                    j11 = Math.min(j10, 16384);
                }
                int read = this.f10474c.read(bArr, 0, (int) j11);
                if (read > 0) {
                    try {
                        outputStream.write(bArr, 0, read);
                    } catch (Exception unused) {
                        if (this.f10474c != null) {
                            this.f10474c.close();
                        }
                    }
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

    public static c d(String str) {
        return a((b) d.OK, d.MIME_HTML, str);
    }

    public void a(String str) {
        this.f10481j.add(str);
    }

    public String b(String str) {
        return this.f10477f.get(str.toLowerCase());
    }

    public List<String> a() {
        return this.f10481j;
    }

    public void b(boolean z10) {
        this.f10480i = z10;
    }

    public c d(boolean z10) {
        this.f10482k = z10 ? a.ALWAYS : a.NEVER;
        return this;
    }

    private void b(OutputStream outputStream, long j10) {
        GZIPOutputStream gZIPOutputStream;
        if (g()) {
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
            } catch (Exception unused) {
                InputStream inputStream = this.f10474c;
                if (inputStream != null) {
                    inputStream.close();
                }
                gZIPOutputStream = null;
            }
            if (gZIPOutputStream != null) {
                c(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            return;
        }
        c(outputStream, j10);
    }

    public void a(String str, String str2) {
        this.f10476e.put(str, str2);
    }

    public void a(boolean z10) {
        if (z10) {
            this.f10476e.put("connection", HTTP.CLOSE);
        } else {
            this.f10476e.remove("connection");
        }
    }

    public void a(OutputStream outputStream) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            if (this.f10472a != null) {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, new com.hpplay.a.a.a.a.a(this.f10473b).c())), false);
                printWriter.append("HTTP/1.1 ").append(this.f10472a.a()).append(" \r\n");
                String str = this.f10473b;
                if (str != null) {
                    a(printWriter, "Content-Type", str);
                }
                if (b("date") == null) {
                    a(printWriter, "Date", simpleDateFormat.format(new Date()));
                }
                for (Map.Entry next : this.f10476e.entrySet()) {
                    a(printWriter, (String) next.getKey(), (String) next.getValue());
                }
                for (String a10 : this.f10481j) {
                    a(printWriter, "Set-Cookie", a10);
                }
                if (b("connection") == null) {
                    a(printWriter, "Connection", this.f10480i ? "keep-alive" : HTTP.CLOSE);
                }
                if (b("content-length") != null) {
                    d(false);
                }
                if (g()) {
                    a(printWriter, "Content-Encoding", "gzip");
                    c(true);
                }
                long j10 = this.f10474c != null ? this.f10475d : 0;
                if (this.f10478g != com.hpplay.a.a.a.b.a.HEAD && this.f10479h) {
                    a(printWriter, "Transfer-Encoding", "chunked");
                } else if (!g()) {
                    j10 = a(printWriter, j10);
                }
                printWriter.append("\r\n");
                printWriter.flush();
                a(outputStream, j10);
                outputStream.flush();
                d.safeClose(this.f10474c);
                return;
            }
            throw new Error("sendResponse(): Status can't be null.");
        } catch (IOException e10) {
            d.LOG.log(Level.SEVERE, "Could not send response to the client", e10);
        }
    }

    public void c(boolean z10) {
        this.f10479h = z10;
    }

    public void c(String str) {
        this.f10473b = str;
    }

    public void a(PrintWriter printWriter, String str, String str2) {
        printWriter.append(str).append(": ").append(str2).append("\r\n");
    }

    public long a(PrintWriter printWriter, long j10) {
        String b10 = b("content-length");
        if (b10 != null) {
            try {
                return Long.parseLong(b10);
            } catch (NumberFormatException unused) {
                Logger logger = d.LOG;
                logger.severe("content-length was no number " + b10);
                return j10;
            }
        } else {
            printWriter.print("Content-Length: " + j10 + "\r\n");
            return j10;
        }
    }

    private void a(OutputStream outputStream, long j10) {
        if (this.f10478g == com.hpplay.a.a.a.b.a.HEAD || !this.f10479h) {
            b(outputStream, j10);
            return;
        }
        a aVar = new a(outputStream);
        b(aVar, -1);
        try {
            aVar.a();
        } catch (Exception unused) {
            if (this.f10474c != null) {
                this.f10474c.close();
            }
        }
    }

    public void a(InputStream inputStream) {
        this.f10474c = inputStream;
    }

    public void a(com.hpplay.a.a.a.b.a aVar) {
        this.f10478g = aVar;
    }

    public void a(b bVar) {
        this.f10472a = bVar;
    }

    public static c a(b bVar, String str, InputStream inputStream) {
        return new c(bVar, str, inputStream, -1);
    }

    public static c a(b bVar, String str, byte[] bArr) {
        return a(bVar, str, new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    public static c a(b bVar, String str, InputStream inputStream, long j10) {
        return new c(bVar, str, inputStream, j10);
    }

    public static c a(b bVar, String str, String str2) {
        byte[] bArr;
        com.hpplay.a.a.a.a.a aVar = new com.hpplay.a.a.a.a.a(str);
        if (str2 == null) {
            return a(bVar, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            if (!Charset.forName(aVar.c()).newEncoder().canEncode(str2)) {
                aVar = aVar.f();
            }
            bArr = str2.getBytes(aVar.c());
        } catch (UnsupportedEncodingException e10) {
            d.LOG.log(Level.SEVERE, "encoding problem, responding nothing", e10);
            bArr = new byte[0];
        }
        return a(bVar, aVar.a(), new ByteArrayInputStream(bArr), (long) bArr.length);
    }
}
