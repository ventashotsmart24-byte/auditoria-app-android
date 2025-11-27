package r;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import q.d;
import y.f;

public class h extends f {

    /* renamed from: g  reason: collision with root package name */
    public final Class f8963g;

    /* renamed from: h  reason: collision with root package name */
    public final Constructor f8964h;

    /* renamed from: i  reason: collision with root package name */
    public final Method f8965i;

    /* renamed from: j  reason: collision with root package name */
    public final Method f8966j;

    /* renamed from: k  reason: collision with root package name */
    public final Method f8967k;

    /* renamed from: l  reason: collision with root package name */
    public final Method f8968l;

    /* renamed from: m  reason: collision with root package name */
    public final Method f8969m;

    public h() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor constructor;
        Class cls;
        try {
            cls = y();
            constructor = z(cls);
            method5 = v(cls);
            method4 = w(cls);
            method3 = A(cls);
            method2 = u(cls);
            method = x(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e10.getClass().getName(), e10);
            cls = null;
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f8963g = cls;
        this.f8964h = constructor;
        this.f8965i = method5;
        this.f8966j = method4;
        this.f8967k = method3;
        this.f8968l = method2;
        this.f8969m = method;
    }

    private Object o() {
        try {
            return this.f8964h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method A(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    public Typeface b(Context context, d.b bVar, Resources resources, int i10) {
        if (!t()) {
            return super.b(context, bVar, resources, i10);
        }
        Object o10 = o();
        if (o10 == null) {
            return null;
        }
        for (d.c cVar : bVar.a()) {
            if (!q(context, o10, cVar.a(), cVar.c(), cVar.e(), cVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                p(o10);
                return null;
            }
        }
        if (!s(o10)) {
            return null;
        }
        return l(o10);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        Typeface l10;
        ParcelFileDescriptor openFileDescriptor;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!t()) {
            f.b h10 = h(bVarArr, i10);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(h10.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(h10.e()).setItalic(h10.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map h11 = l.h(context, bVarArr, cancellationSignal);
            Object o10 = o();
            if (o10 == null) {
                return null;
            }
            boolean z10 = false;
            for (f.b bVar : bVarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) h11.get(bVar.d());
                if (byteBuffer != null) {
                    if (!r(o10, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                        p(o10);
                        return null;
                    }
                    z10 = true;
                }
            }
            if (!z10) {
                p(o10);
                return null;
            } else if (s(o10) && (l10 = l(o10)) != null) {
                return Typeface.create(l10, i10);
            } else {
                return null;
            }
        }
        throw th;
    }

    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        if (!t()) {
            return super.e(context, resources, i10, str, i11);
        }
        Object o10 = o();
        if (o10 == null) {
            return null;
        }
        if (!q(context, o10, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            p(o10);
            return null;
        } else if (!s(o10)) {
            return null;
        } else {
            return l(o10);
        }
    }

    public Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f8963g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f8969m.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void p(Object obj) {
        try {
            this.f8968l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean q(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f8965i.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean r(Object obj, ByteBuffer byteBuffer, int i10, int i11, int i12) {
        try {
            return ((Boolean) this.f8966j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Integer.valueOf(i12)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean s(Object obj) {
        try {
            return ((Boolean) this.f8967k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean t() {
        if (this.f8965i != null) {
            return true;
        }
        return false;
    }

    public Method u(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    public Method v(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    public Method w(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    public Method x(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class y() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor z(Class cls) {
        return cls.getConstructor(new Class[0]);
    }
}
