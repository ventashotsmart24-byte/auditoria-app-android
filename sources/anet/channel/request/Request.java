package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /* renamed from: a  reason: collision with root package name */
    public final RequestStatistic f3782a;

    /* renamed from: b  reason: collision with root package name */
    private HttpUrl f3783b;

    /* renamed from: c  reason: collision with root package name */
    private HttpUrl f3784c;

    /* renamed from: d  reason: collision with root package name */
    private HttpUrl f3785d;

    /* renamed from: e  reason: collision with root package name */
    private URL f3786e;

    /* renamed from: f  reason: collision with root package name */
    private String f3787f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, String> f3788g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f3789h;

    /* renamed from: i  reason: collision with root package name */
    private String f3790i;

    /* renamed from: j  reason: collision with root package name */
    private BodyEntry f3791j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3792k;

    /* renamed from: l  reason: collision with root package name */
    private String f3793l;

    /* renamed from: m  reason: collision with root package name */
    private String f3794m;

    /* renamed from: n  reason: collision with root package name */
    private int f3795n;

    /* renamed from: o  reason: collision with root package name */
    private int f3796o;

    /* renamed from: p  reason: collision with root package name */
    private int f3797p;

    /* renamed from: q  reason: collision with root package name */
    private HostnameVerifier f3798q;

    /* renamed from: r  reason: collision with root package name */
    private SSLSocketFactory f3799r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f3800s;

    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        public static boolean a(String str) {
            if (str.equals("POST") || str.equals(PUT)) {
                return true;
            }
            return false;
        }

        public static boolean b(String str) {
            if (a(str) || str.equals("DELETE") || str.equals(OPTION)) {
                return true;
            }
            return false;
        }
    }

    private Map<String, String> a() {
        if (AwcnConfig.isCookieHeaderRedundantFix()) {
            return new HashMap(this.f3788g);
        }
        return this.f3788g;
    }

    private void b() {
        String a10 = d.a(this.f3789h, getContentEncoding());
        if (!TextUtils.isEmpty(a10)) {
            if (!Method.a(this.f3787f) || this.f3791j != null) {
                String urlString = this.f3783b.urlString();
                StringBuilder sb = new StringBuilder(urlString);
                if (sb.indexOf(Operator.Operation.EMPTY_PARAM) == -1) {
                    sb.append('?');
                } else if (urlString.charAt(urlString.length() - 1) != '&') {
                    sb.append('&');
                }
                sb.append(a10);
                HttpUrl parse = HttpUrl.parse(sb.toString());
                if (parse != null) {
                    this.f3784c = parse;
                }
            } else {
                try {
                    this.f3791j = new ByteArrayEntry(a10.getBytes(getContentEncoding()));
                    Map<String, String> map = this.f3788g;
                    map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            }
        }
        if (this.f3784c == null) {
            this.f3784c = this.f3783b;
        }
    }

    public boolean containsBody() {
        if (this.f3791j != null) {
            return true;
        }
        return false;
    }

    public String getBizId() {
        return this.f3793l;
    }

    public byte[] getBodyBytes() {
        if (this.f3791j == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try {
            postBody(byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getConnectTimeout() {
        return this.f3796o;
    }

    public String getContentEncoding() {
        String str = this.f3790i;
        if (str != null) {
            return str;
        }
        return "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f3788g);
    }

    public String getHost() {
        return this.f3784c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f3798q;
    }

    public HttpUrl getHttpUrl() {
        return this.f3784c;
    }

    public String getMethod() {
        return this.f3787f;
    }

    public int getReadTimeout() {
        return this.f3797p;
    }

    public int getRedirectTimes() {
        return this.f3795n;
    }

    public String getSeq() {
        return this.f3794m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f3799r;
    }

    public URL getUrl() {
        if (this.f3786e == null) {
            HttpUrl httpUrl = this.f3785d;
            if (httpUrl == null) {
                httpUrl = this.f3784c;
            }
            this.f3786e = httpUrl.toURL();
        }
        return this.f3786e;
    }

    public String getUrlString() {
        return this.f3784c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.f3800s;
    }

    public boolean isRedirectEnable() {
        return this.f3792k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        String unused = builder.f3803c = this.f3787f;
        Map unused2 = builder.f3804d = a();
        Map unused3 = builder.f3805e = this.f3789h;
        BodyEntry unused4 = builder.f3807g = this.f3791j;
        String unused5 = builder.f3806f = this.f3790i;
        boolean unused6 = builder.f3808h = this.f3792k;
        int unused7 = builder.f3809i = this.f3795n;
        HostnameVerifier unused8 = builder.f3810j = this.f3798q;
        SSLSocketFactory unused9 = builder.f3811k = this.f3799r;
        HttpUrl unused10 = builder.f3801a = this.f3783b;
        HttpUrl unused11 = builder.f3802b = this.f3784c;
        String unused12 = builder.f3812l = this.f3793l;
        String unused13 = builder.f3813m = this.f3794m;
        int unused14 = builder.f3814n = this.f3796o;
        int unused15 = builder.f3815o = this.f3797p;
        RequestStatistic unused16 = builder.f3816p = this.f3782a;
        boolean unused17 = builder.f3817q = this.f3800s;
        return builder;
    }

    public int postBody(OutputStream outputStream) {
        BodyEntry bodyEntry = this.f3791j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i10) {
        if (str != null) {
            if (this.f3785d == null) {
                this.f3785d = new HttpUrl(this.f3784c);
            }
            this.f3785d.replaceIpAndPort(str, i10);
        } else {
            this.f3785d = null;
        }
        this.f3786e = null;
        this.f3782a.setIPAndPort(str, i10);
    }

    public void setUrlScheme(boolean z10) {
        String str;
        if (this.f3785d == null) {
            this.f3785d = new HttpUrl(this.f3784c);
        }
        HttpUrl httpUrl = this.f3785d;
        if (z10) {
            str = "https";
        } else {
            str = HttpConstant.HTTP;
        }
        httpUrl.setScheme(str);
        this.f3786e = null;
    }

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public HttpUrl f3801a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public HttpUrl f3802b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f3803c = "GET";
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String> f3804d = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f3805e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f3806f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public BodyEntry f3807g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public boolean f3808h = true;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f3809i = 0;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public HostnameVerifier f3810j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public SSLSocketFactory f3811k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public String f3812l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public String f3813m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public int f3814n = 10000;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public int f3815o = 10000;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public RequestStatistic f3816p = null;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public boolean f3817q;

        public Builder addHeader(String str, String str2) {
            this.f3804d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f3805e == null) {
                this.f3805e = new HashMap();
            }
            this.f3805e.put(str, str2);
            this.f3802b = null;
            return this;
        }

        public Request build() {
            if (this.f3807g == null && this.f3805e == null && Method.a(this.f3803c)) {
                ALog.e("awcn.Request", "method " + this.f3803c + " must have a request body", (String) null, new Object[0]);
            }
            if (this.f3807g != null && !Method.b(this.f3803c)) {
                ALog.e("awcn.Request", "method " + this.f3803c + " should not have a request body", (String) null, new Object[0]);
                this.f3807g = null;
            }
            BodyEntry bodyEntry = this.f3807g;
            if (!(bodyEntry == null || bodyEntry.getContentType() == null)) {
                addHeader("Content-Type", this.f3807g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z10) {
            this.f3817q = z10;
            return this;
        }

        public Builder setBizId(String str) {
            this.f3812l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f3807g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f3806f = str;
            this.f3802b = null;
            return this;
        }

        public Builder setConnectTimeout(int i10) {
            if (i10 > 0) {
                this.f3814n = i10;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f3804d.clear();
            if (map != null) {
                this.f3804d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f3810j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (!TextUtils.isEmpty(str)) {
                if ("GET".equalsIgnoreCase(str)) {
                    this.f3803c = "GET";
                } else if ("POST".equalsIgnoreCase(str)) {
                    this.f3803c = "POST";
                } else if (Method.OPTION.equalsIgnoreCase(str)) {
                    this.f3803c = Method.OPTION;
                } else if ("HEAD".equalsIgnoreCase(str)) {
                    this.f3803c = "HEAD";
                } else if (Method.PUT.equalsIgnoreCase(str)) {
                    this.f3803c = Method.PUT;
                } else if ("DELETE".equalsIgnoreCase(str)) {
                    this.f3803c = "DELETE";
                } else {
                    this.f3803c = "GET";
                }
                return this;
            }
            throw new IllegalArgumentException("method is null or empty");
        }

        public Builder setParams(Map<String, String> map) {
            this.f3805e = map;
            this.f3802b = null;
            return this;
        }

        public Builder setReadTimeout(int i10) {
            if (i10 > 0) {
                this.f3815o = i10;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z10) {
            this.f3808h = z10;
            return this;
        }

        public Builder setRedirectTimes(int i10) {
            this.f3809i = i10;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.f3816p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.f3813m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f3811k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.f3801a = httpUrl;
            this.f3802b = null;
            return this;
        }

        public Builder setUrl(String str) {
            HttpUrl parse = HttpUrl.parse(str);
            this.f3801a = parse;
            this.f3802b = null;
            if (parse != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    private Request(Builder builder) {
        this.f3787f = "GET";
        this.f3792k = true;
        this.f3795n = 0;
        this.f3796o = 10000;
        this.f3797p = 10000;
        this.f3787f = builder.f3803c;
        this.f3788g = builder.f3804d;
        this.f3789h = builder.f3805e;
        this.f3791j = builder.f3807g;
        this.f3790i = builder.f3806f;
        this.f3792k = builder.f3808h;
        this.f3795n = builder.f3809i;
        this.f3798q = builder.f3810j;
        this.f3799r = builder.f3811k;
        this.f3793l = builder.f3812l;
        this.f3794m = builder.f3813m;
        this.f3796o = builder.f3814n;
        this.f3797p = builder.f3815o;
        this.f3783b = builder.f3801a;
        HttpUrl o10 = builder.f3802b;
        this.f3784c = o10;
        if (o10 == null) {
            b();
        }
        this.f3782a = builder.f3816p != null ? builder.f3816p : new RequestStatistic(getHost(), this.f3793l);
        this.f3800s = builder.f3817q;
    }
}
