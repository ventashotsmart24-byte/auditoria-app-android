package com.hpplay.cybergarage.xml;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.http.HTTPRequest;
import com.hpplay.cybergarage.http.HTTPResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

public abstract class Parser {
    private Node httpGet(URL url, int i10, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(i10);
        httpURLConnection.setRequestProperty("Content-Length", "0");
        if (str != null) {
            httpURLConnection.setRequestProperty(HTTP.HOST, str);
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        Node parse = parse(inputStream);
        inputStream.close();
        httpURLConnection.disconnect();
        CLog.i("parserp", "   end ======== " + (System.currentTimeMillis() - currentTimeMillis));
        return parse;
    }

    public abstract Node parse(InputStream inputStream);

    public Node parse(String str, int i10) {
        URL url;
        try {
            url = new URL(str);
        } catch (Exception unused) {
            url = new URL(URLDecoder.decode(str));
        }
        String host = url.getHost();
        int port = url.getPort();
        if (port == -1) {
            port = 80;
        }
        String path = url.getPath();
        CLog.i("parserp", "   start " + url.toString());
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return httpGet(url, i10, host);
        } catch (Exception unused2) {
            CLog.i("parserp", "first parse failed");
            CLog.i("parserp", url + "   error ");
            HTTPRequest hTTPRequest = new HTTPRequest();
            hTTPRequest.setMethod("GET");
            hTTPRequest.setURI(path);
            HTTPResponse post = hTTPRequest.post(host, port);
            if (post.isSuccessful()) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new String(post.getContent()).getBytes());
                CLog.i("parserp", "   end ======== " + (System.currentTimeMillis() - currentTimeMillis));
                return parse((InputStream) byteArrayInputStream);
            }
            throw new ParserException("HTTP comunication failed: no answer from peer.Unable to retrive resoure -> " + url.toString());
        }
    }

    public Node parseUrl(String str) {
        return parse(str, 30000);
    }

    public Node parse(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Node parse = parse((InputStream) fileInputStream);
            fileInputStream.close();
            return parse;
        } catch (Exception e10) {
            throw new ParserException(e10);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        return parse((java.io.InputStream) new java.io.ByteArrayInputStream(java.net.URLDecoder.decode(r3).getBytes()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        throw new com.hpplay.cybergarage.xml.ParserException(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.cybergarage.xml.Node parse(java.lang.String r3) {
        /*
            r2 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x000e }
            byte[] r1 = r3.getBytes()     // Catch:{ Exception -> 0x000e }
            r0.<init>(r1)     // Catch:{ Exception -> 0x000e }
            com.hpplay.cybergarage.xml.Node r3 = r2.parse((java.io.InputStream) r0)     // Catch:{ Exception -> 0x000e }
            return r3
        L_0x000e:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0020 }
            java.lang.String r3 = java.net.URLDecoder.decode(r3)     // Catch:{ Exception -> 0x0020 }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x0020 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0020 }
            com.hpplay.cybergarage.xml.Node r3 = r2.parse((java.io.InputStream) r0)     // Catch:{ Exception -> 0x0020 }
            return r3
        L_0x0020:
            r3 = move-exception
            com.hpplay.cybergarage.xml.ParserException r0 = new com.hpplay.cybergarage.xml.ParserException
            r0.<init>((java.lang.Exception) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.xml.Parser.parse(java.lang.String):com.hpplay.cybergarage.xml.Node");
    }
}
