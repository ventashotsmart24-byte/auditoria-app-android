package com.hpplay.a.a.a.e;

import com.hpplay.a.a.a.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final File f10527a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f10528b;

    public b() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        this.f10527a = file;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f10528b = new ArrayList();
    }

    public void a() {
        for (d a10 : this.f10528b) {
            try {
                a10.a();
            } catch (Exception e10) {
                d.LOG.log(Level.WARNING, "could not delete file ", e10);
            }
        }
        this.f10528b.clear();
    }

    public d a(String str) {
        a aVar = new a(this.f10527a);
        this.f10528b.add(aVar);
        return aVar;
    }
}
