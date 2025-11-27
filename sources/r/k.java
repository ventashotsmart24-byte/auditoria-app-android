package r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import q.d;
import y.f;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f8970a = new ConcurrentHashMap();

    public class a implements c {
        public a() {
        }

        /* renamed from: c */
        public int b(f.b bVar) {
            return bVar.e();
        }

        /* renamed from: d */
        public boolean a(f.b bVar) {
            return bVar.f();
        }
    }

    public class b implements c {
        public b() {
        }

        /* renamed from: c */
        public int b(d.c cVar) {
            return cVar.e();
        }

        /* renamed from: d */
        public boolean a(d.c cVar) {
            return cVar.f();
        }
    }

    public interface c {
        boolean a(Object obj);

        int b(Object obj);
    }

    public static Object g(Object[] objArr, int i10, c cVar) {
        int i11;
        boolean z10;
        int i12;
        if ((i10 & 1) == 0) {
            i11 = 400;
        } else {
            i11 = 700;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Object obj = null;
        int i13 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = Math.abs(cVar.b(obj2) - i11) * 2;
            if (cVar.a(obj2) == z10) {
                i12 = 0;
            } else {
                i12 = 1;
            }
            int i14 = abs + i12;
            if (obj == null || i13 > i14) {
                obj = obj2;
                i13 = i14;
            }
        }
        return obj;
    }

    public static long j(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e10) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e10);
            return 0;
        } catch (IllegalAccessException e11) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e11);
            return 0;
        }
    }

    public final void a(Typeface typeface, d.b bVar) {
        long j10 = j(typeface);
        if (j10 != 0) {
            this.f8970a.put(Long.valueOf(j10), bVar);
        }
    }

    public Typeface b(Context context, d.b bVar, Resources resources, int i10) {
        d.c f10 = f(bVar, i10);
        if (f10 == null) {
            return null;
        }
        Typeface d10 = e.d(context, resources, f10.b(), f10.a(), i10);
        a(d10, bVar);
        return d10;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(h(bVarArr, i10).d());
            try {
                Typeface d10 = d(context, inputStream);
                l.a(inputStream);
                return d10;
            } catch (IOException unused) {
                l.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                l.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            l.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            l.a(inputStream2);
            throw th;
        }
    }

    public Typeface d(Context context, InputStream inputStream) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!l.d(e10, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e10.getPath());
            e10.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!l.c(e10, resources, i10)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e10.getPath());
            e10.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public final d.c f(d.b bVar, int i10) {
        return (d.c) g(bVar.a(), i10, new b());
    }

    public f.b h(f.b[] bVarArr, int i10) {
        return (f.b) g(bVarArr, i10, new a());
    }

    public d.b i(Typeface typeface) {
        long j10 = j(typeface);
        if (j10 == 0) {
            return null;
        }
        return (d.b) this.f8970a.get(Long.valueOf(j10));
    }
}
