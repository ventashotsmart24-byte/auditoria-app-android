package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class cq {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f14055a;

    /* renamed from: b  reason: collision with root package name */
    private final ds f14056b;

    /* renamed from: c  reason: collision with root package name */
    private dg f14057c;

    public cq() {
        this(new da.a());
    }

    public byte[] a(ch chVar) {
        this.f14055a.reset();
        chVar.write(this.f14057c);
        return this.f14055a.toByteArray();
    }

    public String b(ch chVar) {
        return new String(a(chVar));
    }

    public cq(di diVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f14055a = byteArrayOutputStream;
        ds dsVar = new ds((OutputStream) byteArrayOutputStream);
        this.f14056b = dsVar;
        this.f14057c = diVar.a(dsVar);
    }

    public String a(ch chVar, String str) {
        try {
            return new String(a(chVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
