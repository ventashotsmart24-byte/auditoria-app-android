package com.hpplay.logwriter;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f10596a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f10597b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f10598c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f10599d = 100;

    /* renamed from: e  reason: collision with root package name */
    public static final long f10600e = 102400;

    /* renamed from: f  reason: collision with root package name */
    public static final long f10601f = 204800;

    /* renamed from: g  reason: collision with root package name */
    private static final String f10602g = "hpplay-java:LW";

    /* renamed from: h  reason: collision with root package name */
    private static final int f10603h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f10604i = 11;

    /* renamed from: j  reason: collision with root package name */
    private static volatile f f10605j;

    /* renamed from: k  reason: collision with root package name */
    private String f10606k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10607l = false;

    /* renamed from: m  reason: collision with root package name */
    private volatile ConcurrentLinkedQueue<String> f10608m = new ConcurrentLinkedQueue<>();

    /* renamed from: n  reason: collision with root package name */
    private volatile long f10609n = 0;

    /* renamed from: o  reason: collision with root package name */
    private ILogcatCollect f10610o;

    /* renamed from: p  reason: collision with root package name */
    private volatile ConcurrentLinkedQueue<String> f10611p = new ConcurrentLinkedQueue<>();

    /* renamed from: q  reason: collision with root package name */
    private volatile long f10612q = 0;

    /* renamed from: r  reason: collision with root package name */
    private HandlerThread f10613r;

    /* renamed from: s  reason: collision with root package name */
    private Handler f10614s;

    /* renamed from: t  reason: collision with root package name */
    private b f10615t;

    /* renamed from: u  reason: collision with root package name */
    private Context f10616u;

    /* renamed from: v  reason: collision with root package name */
    private int f10617v = 100;

    private f() {
        HandlerThread handlerThread = new HandlerThread("log write thread");
        this.f10613r = handlerThread;
        handlerThread.start();
        this.f10614s = new Handler(this.f10613r.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                try {
                    int i10 = message.what;
                    if (i10 == 1) {
                        f.this.d(message.obj.toString());
                    } else if (i10 == 11) {
                        f.this.e(message.obj.toString());
                    }
                } catch (Exception e10) {
                    g.a(f.f10602g, e10);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        try {
            long length = (long) str.getBytes().length;
            if (this.f10609n + length >= f10600e) {
                f();
                this.f10609n = 0;
            }
            this.f10608m.add(str);
            this.f10609n += length;
        } catch (Exception e10) {
            g.a(f10602g, e10);
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        try {
            long length = (long) str.getBytes().length;
            if (this.f10612q + length >= f10600e) {
                g();
                this.f10612q = 0;
            }
            this.f10611p.add(str);
            this.f10612q += length;
        } catch (Exception e10) {
            g.a(f10602g, e10);
        }
    }

    private void f() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f10608m.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
                try {
                    it.remove();
                } catch (Exception e10) {
                    g.a(f10602g, e10);
                }
                if (((long) sb.length()) > f10601f) {
                    break;
                }
            }
            if (this.f10615t == null) {
                b bVar = new b();
                this.f10615t = bVar;
                bVar.a(this.f10606k);
            }
            byte[] bytes = sb.toString().getBytes();
            if (((long) bytes.length) < f10601f) {
                this.f10615t.a(bytes);
            }
        } catch (Exception e11) {
            g.a(f10602g, e11);
        }
    }

    private void g() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f10611p.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
                try {
                    it.remove();
                } catch (Exception e10) {
                    g.a(f10602g, e10);
                }
                if (((long) sb.length()) > f10601f) {
                    break;
                }
            }
            if (this.f10615t == null) {
                b bVar = new b();
                this.f10615t = bVar;
                bVar.a(this.f10606k);
            }
            byte[] bytes = sb.toString().getBytes();
            if (((long) bytes.length) < f10601f) {
                this.f10615t.b(bytes);
            }
        } catch (Exception e11) {
            g.a(f10602g, e11);
        }
    }

    public void c(String str) {
        f();
        g();
        e.b(this.f10606k, str);
    }

    public static f a() {
        if (f10605j == null) {
            synchronized (f.class) {
                if (f10605j == null) {
                    f10605j = new f();
                }
            }
        }
        return f10605j;
    }

    public void b() {
        int i10 = this.f10617v;
        if (i10 == 1) {
            f();
        } else if (i10 == 2) {
            g();
        } else if (i10 == 100) {
            f();
            g();
        }
    }

    public void c() {
        this.f10607l = false;
        ILogcatCollect iLogcatCollect = this.f10610o;
        if (iLogcatCollect != null) {
            iLogcatCollect.stop();
        }
        a(true);
        b bVar = this.f10615t;
        if (bVar != null) {
            bVar.a();
            this.f10615t = null;
        }
    }

    public void b(String str) {
        try {
            Handler handler = this.f10614s;
            handler.sendMessage(handler.obtainMessage(11, str));
        } catch (Exception e10) {
            g.a(f10602g, e10);
        }
    }

    public void a(ILogcatCollect iLogcatCollect) {
        this.f10610o = iLogcatCollect;
    }

    public String d() {
        return this.f10606k;
    }

    public boolean e() {
        return this.f10607l;
    }

    public void a(Context context, String str) {
        a(context, str, 100);
    }

    public void a(Context context, String str, int i10) {
        ILogcatCollect iLogcatCollect;
        if (!this.f10607l && context != null && !TextUtils.isEmpty(str)) {
            this.f10616u = context;
            this.f10606k = str;
            a(false);
            this.f10607l = true;
            if ((i10 == 2 || i10 == 100) && (iLogcatCollect = this.f10610o) != null) {
                iLogcatCollect.start();
            }
        }
    }

    public synchronized void a(String str) {
        try {
            Handler handler = this.f10614s;
            handler.sendMessage(handler.obtainMessage(1, str));
        } catch (Exception e10) {
            g.a(f10602g, e10);
        }
        return;
    }

    private void a(boolean z10) {
        if (z10) {
            try {
                f();
                g();
            } catch (Exception e10) {
                g.a(f10602g, e10);
                return;
            }
        }
        this.f10608m.clear();
        this.f10609n = 0;
        this.f10611p.clear();
        this.f10612q = 0;
    }
}
