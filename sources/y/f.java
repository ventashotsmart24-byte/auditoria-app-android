package y;

import a0.h;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import java.util.concurrent.Executor;

public abstract class f {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f9834a;

        /* renamed from: b  reason: collision with root package name */
        public final b[] f9835b;

        public a(int i10, b[] bVarArr) {
            this.f9834a = i10;
            this.f9835b = bVarArr;
        }

        public static a a(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] b() {
            return this.f9835b;
        }

        public int c() {
            return this.f9834a;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f9836a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9837b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9838c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9839d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9840e;

        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f9836a = (Uri) h.d(uri);
            this.f9837b = i10;
            this.f9838c = i11;
            this.f9839d = z10;
            this.f9840e = i12;
        }

        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f9840e;
        }

        public int c() {
            return this.f9837b;
        }

        public Uri d() {
            return this.f9836a;
        }

        public int e() {
            return this.f9838c;
        }

        public boolean f() {
            return this.f9839d;
        }
    }

    public static class c {
        public abstract void a(int i10);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, d dVar, int i10, boolean z10, int i11, Handler handler, c cVar) {
        a aVar = new a(cVar, handler);
        if (z10) {
            return e.e(context, dVar, aVar, i10, i11);
        }
        return e.d(context, dVar, i10, (Executor) null, aVar);
    }
}
