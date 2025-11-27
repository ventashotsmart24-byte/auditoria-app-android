package u4;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import v4.a;
import w4.a;
import y4.b;

public class c implements a.C0287a, a.C0288a {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f19621a;

    /* renamed from: b  reason: collision with root package name */
    public final a f19622b;

    /* renamed from: c  reason: collision with root package name */
    public final y4.a f19623c;

    /* renamed from: d  reason: collision with root package name */
    public final t4.a f19624d;

    /* renamed from: e  reason: collision with root package name */
    public final List f19625e;

    /* renamed from: f  reason: collision with root package name */
    public final a f19626f;

    /* renamed from: g  reason: collision with root package name */
    public long f19627g = System.currentTimeMillis();

    /* renamed from: h  reason: collision with root package name */
    public long f19628h;

    /* renamed from: i  reason: collision with root package name */
    public volatile AtomicBoolean f19629i = new AtomicBoolean(false);

    public interface a {
        void a(y4.a aVar);
    }

    public c(ExecutorService executorService, a aVar, y4.a aVar2, t4.a aVar3, a aVar4) {
        this.f19621a = executorService;
        this.f19622b = aVar;
        this.f19623c = aVar2;
        this.f19624d = aVar3;
        this.f19626f = aVar4;
        this.f19625e = new ArrayList();
    }

    public void a(long j10, boolean z10) {
        long j11;
        boolean z11 = z10;
        this.f19623c.E(z11);
        this.f19623c.B(j10);
        d(this.f19623c.h());
        ArrayList arrayList = new ArrayList();
        if (z11) {
            long j12 = this.f19623c.j();
            int f10 = this.f19624d.f();
            long j13 = j12 / ((long) f10);
            int i10 = 0;
            while (i10 < f10) {
                long j14 = j13 * ((long) i10);
                if (i10 == f10 - 1) {
                    j11 = j12 - 1;
                } else {
                    j11 = (j14 + j13) - 1;
                }
                int i11 = i10;
                b bVar = new b(i11, this.f19623c.g(), this.f19623c.m(), this.f19623c.a(), j14, j11);
                arrayList.add(bVar);
                w4.a aVar = new w4.a(bVar, this.f19622b, this.f19624d, this.f19623c, this);
                this.f19621a.submit(aVar);
                this.f19625e.add(aVar);
                i10 = i11 + 1;
            }
        } else {
            b bVar2 = new b(0, this.f19623c.g(), this.f19623c.m(), this.f19623c.a(), 0, this.f19623c.j() - 1);
            arrayList.add(bVar2);
            w4.a aVar2 = new w4.a(bVar2, this.f19622b, this.f19624d, this.f19623c, this);
            this.f19621a.submit(aVar2);
            this.f19625e.add(aVar2);
        }
        this.f19623c.v(arrayList);
        this.f19623c.C(2);
        this.f19622b.a(this.f19623c);
    }

    public void b() {
        e();
        if (this.f19623c.i() == this.f19623c.j()) {
            this.f19623c.C(5);
            this.f19622b.a(this.f19623c);
            a aVar = this.f19626f;
            if (aVar != null) {
                aVar.a(this.f19623c);
            }
        }
    }

    public void c() {
        if (!this.f19629i.get()) {
            synchronized (this) {
                if (!this.f19629i.get()) {
                    this.f19629i.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f19627g > 1000) {
                        e();
                        this.f19622b.a(this.f19623c);
                        this.f19627g = currentTimeMillis;
                    }
                    this.f19629i.set(false);
                }
            }
        }
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
            } catch (SecurityException e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void e() {
        this.f19628h = 0;
        for (b e10 : this.f19623c.e()) {
            this.f19628h += e10.e();
        }
        this.f19623c.A(this.f19628h);
    }

    public final void f() {
        this.f19621a.submit(new v4.a(this.f19622b, this.f19623c, this));
    }

    public void g() {
        if (this.f19623c.j() <= 0) {
            f();
            return;
        }
        List<b> e10 = this.f19623c.e();
        if (e10.size() == 0) {
            this.f19623c.A(0);
            f();
            return;
        }
        for (b aVar : e10) {
            w4.a aVar2 = new w4.a(aVar, this.f19622b, this.f19624d, this.f19623c, this);
            this.f19621a.submit(aVar2);
            this.f19625e.add(aVar2);
        }
        this.f19623c.C(2);
        this.f19622b.a(this.f19623c);
    }
}
