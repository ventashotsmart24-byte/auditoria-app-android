package j0;

import android.os.Bundle;
import android.os.Looper;
import androidx.collection.h;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import androidx.loader.content.b;
import j0.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f7043c = false;

    /* renamed from: a  reason: collision with root package name */
    public final g f7044a;

    /* renamed from: b  reason: collision with root package name */
    public final c f7045b;

    public static class a extends l implements b.C0033b {

        /* renamed from: l  reason: collision with root package name */
        public final int f7046l;

        /* renamed from: m  reason: collision with root package name */
        public final Bundle f7047m;

        /* renamed from: n  reason: collision with root package name */
        public final androidx.loader.content.b f7048n;

        /* renamed from: o  reason: collision with root package name */
        public g f7049o;

        /* renamed from: p  reason: collision with root package name */
        public C0093b f7050p;

        /* renamed from: q  reason: collision with root package name */
        public androidx.loader.content.b f7051q;

        public a(int i10, Bundle bundle, androidx.loader.content.b bVar, androidx.loader.content.b bVar2) {
            this.f7046l = i10;
            this.f7047m = bundle;
            this.f7048n = bVar;
            this.f7051q = bVar2;
            bVar.registerListener(i10, this);
        }

        public void a(androidx.loader.content.b bVar, Object obj) {
            if (b.f7043c) {
                StringBuilder sb = new StringBuilder();
                sb.append("onLoadComplete: ");
                sb.append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(obj);
                return;
            }
            boolean z10 = b.f7043c;
            l(obj);
        }

        public void j() {
            if (b.f7043c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
            }
            this.f7048n.startLoading();
        }

        public void k() {
            if (b.f7043c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
            }
            this.f7048n.stopLoading();
        }

        public void m(m mVar) {
            super.m(mVar);
            this.f7049o = null;
            this.f7050p = null;
        }

        public void n(Object obj) {
            super.n(obj);
            androidx.loader.content.b bVar = this.f7051q;
            if (bVar != null) {
                bVar.reset();
                this.f7051q = null;
            }
        }

        public androidx.loader.content.b o(boolean z10) {
            if (b.f7043c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
            }
            this.f7048n.cancelLoad();
            this.f7048n.abandon();
            C0093b bVar = this.f7050p;
            if (bVar != null) {
                m(bVar);
                if (z10) {
                    bVar.d();
                }
            }
            this.f7048n.unregisterListener(this);
            if ((bVar == null || bVar.c()) && !z10) {
                return this.f7048n;
            }
            this.f7048n.reset();
            return this.f7051q;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f7046l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f7047m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f7048n);
            androidx.loader.content.b bVar = this.f7048n;
            bVar.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f7050p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f7050p);
                C0093b bVar2 = this.f7050p;
                bVar2.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(q().dataToString(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        public androidx.loader.content.b q() {
            return this.f7048n;
        }

        public void r() {
            g gVar = this.f7049o;
            C0093b bVar = this.f7050p;
            if (gVar != null && bVar != null) {
                super.m(bVar);
                h(gVar, bVar);
            }
        }

        public androidx.loader.content.b s(g gVar, a.C0092a aVar) {
            C0093b bVar = new C0093b(this.f7048n, aVar);
            h(gVar, bVar);
            C0093b bVar2 = this.f7050p;
            if (bVar2 != null) {
                m(bVar2);
            }
            this.f7049o = gVar;
            this.f7050p = bVar;
            return this.f7048n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f7046l);
            sb.append(" : ");
            a0.b.a(this.f7048n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: j0.b$b  reason: collision with other inner class name */
    public static class C0093b implements m {

        /* renamed from: a  reason: collision with root package name */
        public final androidx.loader.content.b f7052a;

        /* renamed from: b  reason: collision with root package name */
        public final a.C0092a f7053b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7054c = false;

        public C0093b(androidx.loader.content.b bVar, a.C0092a aVar) {
            this.f7052a = bVar;
            this.f7053b = aVar;
        }

        public void a(Object obj) {
            if (b.f7043c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  onLoadFinished in ");
                sb.append(this.f7052a);
                sb.append(": ");
                sb.append(this.f7052a.dataToString(obj));
            }
            this.f7053b.onLoadFinished(this.f7052a, obj);
            this.f7054c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f7054c);
        }

        public boolean c() {
            return this.f7054c;
        }

        public void d() {
            if (this.f7054c) {
                if (b.f7043c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("  Resetting: ");
                    sb.append(this.f7052a);
                }
                this.f7053b.onLoaderReset(this.f7052a);
            }
        }

        public String toString() {
            return this.f7053b.toString();
        }
    }

    public static class c extends v {

        /* renamed from: e  reason: collision with root package name */
        public static final w.b f7055e = new a();

        /* renamed from: c  reason: collision with root package name */
        public h f7056c = new h();

        /* renamed from: d  reason: collision with root package name */
        public boolean f7057d = false;

        public static class a implements w.b {
            public v a(Class cls) {
                return new c();
            }
        }

        public static c h(x xVar) {
            return (c) new w(xVar, f7055e).a(c.class);
        }

        public void d() {
            super.d();
            int j10 = this.f7056c.j();
            for (int i10 = 0; i10 < j10; i10++) {
                ((a) this.f7056c.k(i10)).o(true);
            }
            this.f7056c.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f7056c.j() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f7056c.j(); i10++) {
                    a aVar = (a) this.f7056c.k(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f7056c.h(i10));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void g() {
            this.f7057d = false;
        }

        public a i(int i10) {
            return (a) this.f7056c.e(i10);
        }

        public boolean j() {
            return this.f7057d;
        }

        public void k() {
            int j10 = this.f7056c.j();
            for (int i10 = 0; i10 < j10; i10++) {
                ((a) this.f7056c.k(i10)).r();
            }
        }

        public void l(int i10, a aVar) {
            this.f7056c.i(i10, aVar);
        }

        public void m() {
            this.f7057d = true;
        }
    }

    public b(g gVar, x xVar) {
        this.f7044a = gVar;
        this.f7045b = c.h(xVar);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f7045b.f(str, fileDescriptor, printWriter, strArr);
    }

    public androidx.loader.content.b c(int i10, Bundle bundle, a.C0092a aVar) {
        if (this.f7045b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            a i11 = this.f7045b.i(i10);
            if (f7043c) {
                StringBuilder sb = new StringBuilder();
                sb.append("initLoader in ");
                sb.append(this);
                sb.append(": args=");
                sb.append(bundle);
            }
            if (i11 == null) {
                return e(i10, bundle, aVar, (androidx.loader.content.b) null);
            }
            if (f7043c) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Re-using existing loader ");
                sb2.append(i11);
            }
            return i11.s(this.f7044a, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void d() {
        this.f7045b.k();
    }

    /* JADX INFO: finally extract failed */
    public final androidx.loader.content.b e(int i10, Bundle bundle, a.C0092a aVar, androidx.loader.content.b bVar) {
        try {
            this.f7045b.m();
            androidx.loader.content.b onCreateLoader = aVar.onCreateLoader(i10, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                a aVar2 = new a(i10, bundle, onCreateLoader, bVar);
                if (f7043c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("  Created new loader ");
                    sb.append(aVar2);
                }
                this.f7045b.l(i10, aVar2);
                this.f7045b.g();
                return aVar2.s(this.f7044a, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f7045b.g();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a0.b.a(this.f7044a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
