package com.hpplay.a.a.a.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected long f10529a;

    /* renamed from: b  reason: collision with root package name */
    private final List<com.hpplay.a.a.a.a> f10530b = Collections.synchronizedList(new ArrayList());

    public List<com.hpplay.a.a.a.a> a() {
        return this.f10530b;
    }

    public void b() {
        Iterator it = new ArrayList(this.f10530b).iterator();
        while (it.hasNext()) {
            ((com.hpplay.a.a.a.a) it.next()).a();
        }
    }

    public Thread c(com.hpplay.a.a.a.a aVar) {
        Thread thread = new Thread(aVar);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.f10529a + ")");
        return thread;
    }

    public void a(com.hpplay.a.a.a.a aVar) {
        this.f10530b.remove(aVar);
    }

    public void b(com.hpplay.a.a.a.a aVar) {
        this.f10529a++;
        this.f10530b.add(aVar);
        c(aVar).start();
    }
}
