package r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.raizlabs.android.dbflow.sql.language.Operator;
import q.d;
import q.h;
import y.f;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final k f8951a;

    /* renamed from: b  reason: collision with root package name */
    public static final androidx.collection.e f8952b = new androidx.collection.e(16);

    public static class a extends f.c {

        /* renamed from: a  reason: collision with root package name */
        public h.c f8953a;

        public a(h.c cVar) {
            this.f8953a = cVar;
        }

        public void a(int i10) {
            h.c cVar = this.f8953a;
            if (cVar != null) {
                cVar.onFontRetrievalFailed(i10);
            }
        }

        public void b(Typeface typeface) {
            h.c cVar = this.f8953a;
            if (cVar != null) {
                cVar.onFontRetrieved(typeface);
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f8951a = new j();
        } else if (i10 >= 28) {
            f8951a = new i();
        } else if (i10 >= 26) {
            f8951a = new h();
        } else if (i10 >= 24 && g.m()) {
            f8951a = new g();
        } else if (i10 >= 21) {
            f8951a = new f();
        } else {
            f8951a = new k();
        }
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        Typeface g10;
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null");
        } else if (Build.VERSION.SDK_INT >= 21 || (g10 = g(context, typeface, i10)) == null) {
            return Typeface.create(typeface, i10);
        } else {
            return g10;
        }
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        return f8951a.c(context, cancellationSignal, bVarArr, i10);
    }

    public static Typeface c(Context context, d.a aVar, Resources resources, int i10, int i11, h.c cVar, Handler handler, boolean z10) {
        Typeface typeface;
        boolean z11;
        int i12;
        d.a aVar2 = aVar;
        h.c cVar2 = cVar;
        Handler handler2 = handler;
        if (aVar2 instanceof d.C0117d) {
            d.C0117d dVar = (d.C0117d) aVar2;
            Typeface h10 = h(dVar.c());
            if (h10 != null) {
                if (cVar2 != null) {
                    cVar2.callbackSuccessAsync(h10, handler2);
                }
                return h10;
            }
            if (!z10 ? cVar2 != null : dVar.a() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z10) {
                i12 = dVar.d();
            } else {
                i12 = -1;
            }
            Context context2 = context;
            typeface = f.a(context2, dVar.b(), i11, z11, i12, h.c.getHandler(handler), new a(cVar2));
            Resources resources2 = resources;
            int i13 = i11;
        } else {
            Context context3 = context;
            Resources resources3 = resources;
            typeface = f8951a.b(context, (d.b) aVar2, resources, i11);
            if (cVar2 != null) {
                if (typeface != null) {
                    cVar2.callbackSuccessAsync(typeface, handler2);
                } else {
                    cVar2.callbackFailAsync(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f8952b.put(e(resources, i10, i11), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        Typeface e10 = f8951a.e(context, resources, i10, str, i11);
        if (e10 != null) {
            f8952b.put(e(resources, i10, i11), e10);
        }
        return e10;
    }

    public static String e(Resources resources, int i10, int i11) {
        return resources.getResourcePackageName(i10) + Operator.Operation.MINUS + i10 + Operator.Operation.MINUS + i11;
    }

    public static Typeface f(Resources resources, int i10, int i11) {
        return (Typeface) f8952b.get(e(resources, i10, i11));
    }

    public static Typeface g(Context context, Typeface typeface, int i10) {
        k kVar = f8951a;
        d.b i11 = kVar.i(typeface);
        if (i11 == null) {
            return null;
        }
        return kVar.b(context, i11, context.getResources(), i10);
    }

    public static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
