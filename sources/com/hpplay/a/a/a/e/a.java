package com.hpplay.a.a.a.e;

import com.hpplay.a.a.a.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final File f10525a;

    /* renamed from: b  reason: collision with root package name */
    private final OutputStream f10526b;

    public a(File file) {
        File createTempFile = File.createTempFile("NanoHTTPD-", "", file);
        this.f10525a = createTempFile;
        this.f10526b = new FileOutputStream(createTempFile);
    }

    public void a() {
        d.safeClose(this.f10526b);
        if (!this.f10525a.delete()) {
            throw new Exception("could not delete temporary file: " + this.f10525a.getAbsolutePath());
        }
    }

    public String b() {
        return this.f10525a.getAbsolutePath();
    }

    public OutputStream c() {
        return this.f10526b;
    }
}
