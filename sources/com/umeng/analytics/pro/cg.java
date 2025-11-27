package com.umeng.analytics.pro;

import com.taobao.accs.common.Constants;

public class cg extends cn {

    /* renamed from: a  reason: collision with root package name */
    public static final int f14035a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f14036b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f14037c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f14038d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f14039e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f14040f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f14041g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f14042h = 7;

    /* renamed from: j  reason: collision with root package name */
    private static final dl f14043j = new dl("TApplicationException");

    /* renamed from: k  reason: collision with root package name */
    private static final db f14044k = new db(Constants.SHARED_MESSAGE_ID_FILE, (byte) 11, 1);

    /* renamed from: l  reason: collision with root package name */
    private static final db f14045l = new db("type", (byte) 8, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final long f14046m = 1;

    /* renamed from: i  reason: collision with root package name */
    protected int f14047i;

    public cg() {
        this.f14047i = 0;
    }

    public int a() {
        return this.f14047i;
    }

    public void b(dg dgVar) {
        dgVar.a(f14043j);
        if (getMessage() != null) {
            dgVar.a(f14044k);
            dgVar.a(getMessage());
            dgVar.c();
        }
        dgVar.a(f14045l);
        dgVar.a(this.f14047i);
        dgVar.c();
        dgVar.d();
        dgVar.b();
    }

    public static cg a(dg dgVar) {
        dgVar.j();
        String str = null;
        int i10 = 0;
        while (true) {
            db l10 = dgVar.l();
            byte b10 = l10.f14130b;
            if (b10 == 0) {
                dgVar.k();
                return new cg(i10, str);
            }
            short s10 = l10.f14131c;
            if (s10 != 1) {
                if (s10 != 2) {
                    dj.a(dgVar, b10);
                } else if (b10 == 8) {
                    i10 = dgVar.w();
                } else {
                    dj.a(dgVar, b10);
                }
            } else if (b10 == 11) {
                str = dgVar.z();
            } else {
                dj.a(dgVar, b10);
            }
            dgVar.m();
        }
    }

    public cg(int i10) {
        this.f14047i = i10;
    }

    public cg(int i10, String str) {
        super(str);
        this.f14047i = i10;
    }

    public cg(String str) {
        super(str);
        this.f14047i = 0;
    }
}
