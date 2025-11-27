package b5;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import h7.c;
import h7.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import j7.d;
import j7.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import r4.b;
import y4.a;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f10906c;

    /* renamed from: a  reason: collision with root package name */
    public final List f10907a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public y4.a f10908b;

    /* renamed from: b5.a$a  reason: collision with other inner class name */
    public class C0144a extends s4.a {

        /* renamed from: b5.a$a$a  reason: collision with other inner class name */
        public class C0145a implements Observer {
            public C0145a() {
            }

            /* renamed from: a */
            public void onNext(d5.b bVar) {
                a.this.l((String) bVar.a(), (String) bVar.b());
                Iterator it = new ArrayList(a.this.f10907a).iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onSuccess();
                }
                y4.a unused = a.this.f10908b = null;
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }

            public void onSubscribe(Disposable disposable) {
            }
        }

        /* renamed from: b5.a$a$b */
        public class b implements Callable {
            public b() {
            }

            /* renamed from: a */
            public d5.b call() {
                String b10 = d.b(new File(a.this.f10908b.h()));
                if (b10 == null || b10.isEmpty()) {
                    b10 = "apkMd5 is empty";
                }
                String h10 = a.this.f10908b.h();
                if (h10 == null || h10.trim().isEmpty()) {
                    h10 = "pathMd5 is empty";
                }
                return new d5.b(b10, h10);
            }
        }

        public C0144a() {
        }

        public void b() {
            super.b();
            Observable.fromCallable(new b()).compose(f.a()).subscribe(new C0145a());
        }

        public void d(long j10, long j11) {
            super.d(j10, j11);
            for (c A : a.this.f10907a) {
                A.A(j10, j11);
            }
        }

        public void e(z4.a aVar) {
            super.e(aVar);
            a.this.k(aVar);
            for (c onFailure : new ArrayList(a.this.f10907a)) {
                onFailure.onFailure(aVar);
            }
            y4.a unused = a.this.f10908b = null;
        }

        public void onStart() {
            super.onStart();
            for (c z10 : a.this.f10907a) {
                z10.z();
            }
        }
    }

    public static a g() {
        if (f10906c == null) {
            f10906c = new a();
        }
        return f10906c;
    }

    public final y4.a f(Context context, d5.c cVar, y4.a aVar) {
        if (cVar == null) {
            return null;
        }
        String i10 = cVar.i();
        if (TextUtils.isEmpty(i10)) {
            return null;
        }
        s4.c a10 = b.a(context);
        y4.a d10 = a10.d(i10);
        if (d10 != null) {
            d10.F(cVar.k());
            d10.r(cVar.j());
            Log.e("getDownloadInfo", "数据库存在安装包数据");
            File file = new File(cVar.g());
            if (aVar != null && aVar.o()) {
                return d10;
            }
            if (file.exists()) {
                Log.e("getDownloadInfo", "安装包已下载到本地");
                if (!d.b(file).equals(i10)) {
                    Log.e("getDownloadInfo", "安装包和数据库的md5对不上");
                    a10.c(d10);
                    return null;
                }
            } else {
                Log.e("getDownloadInfo", "安装包未下载");
                a10.c(d10);
                return null;
            }
        }
        return d10;
    }

    public List h() {
        return this.f10907a;
    }

    public final boolean i(String str) {
        return str.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public void j(c cVar) {
        this.f10907a.add(cVar);
    }

    public final void k(Throwable th) {
        y4.a aVar = this.f10908b;
        if (aVar != null) {
            String m10 = aVar.m();
            if (!TextUtils.isEmpty(m10)) {
                h.b(Uri.parse(m10).getHost(), th);
            }
        }
    }

    public final void l(String str, String str2) {
        String str3;
        y4.a aVar = this.f10908b;
        if (aVar != null) {
            String m10 = aVar.m();
            if (!TextUtils.isEmpty(m10)) {
                if (i(this.f10908b.h())) {
                    str3 = "externalStorage_";
                } else {
                    str3 = "internalStorage_";
                }
                h.c(Uri.parse(m10).getHost(), (System.currentTimeMillis() - this.f10908b.c()) / 1000, this.f10908b.b(), str3 + str2, this.f10908b.j(), str);
            }
        }
    }

    public void m(Context context, d5.c cVar) {
        y4.a f10 = f(context, cVar, this.f10908b);
        if (f10 == null) {
            String i10 = cVar.i();
            String k10 = cVar.k();
            String j10 = cVar.j();
            String g10 = cVar.g();
            if (!TextUtils.isEmpty(i10) && !TextUtils.isEmpty(k10) && !TextUtils.isEmpty(g10)) {
                f10 = new a.C0293a().c(i10).e(k10).b(j10).d(g10).a();
            } else {
                return;
            }
        }
        y4.a aVar = this.f10908b;
        if (aVar == null || aVar == f10) {
            this.f10908b = f10;
            if (f10.n()) {
                for (c onSuccess : new ArrayList(this.f10907a)) {
                    onSuccess.onSuccess();
                }
                this.f10908b = null;
                return;
            }
            this.f10908b.u(new C0144a());
            b.a(context).b(this.f10908b);
        }
    }

    public void n(c cVar) {
        this.f10907a.remove(cVar);
    }
}
