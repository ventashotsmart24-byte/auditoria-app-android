package r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import q.d;
import y.f;

public class f extends k {

    /* renamed from: b  reason: collision with root package name */
    public static Class f8954b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Constructor f8955c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Method f8956d = null;

    /* renamed from: e  reason: collision with root package name */
    public static Method f8957e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f8958f = false;

    public static boolean k(Object obj, String str, int i10, boolean z10) {
        n();
        try {
            return ((Boolean) f8956d.invoke(obj, new Object[]{str, Integer.valueOf(i10), Boolean.valueOf(z10)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static Typeface l(Object obj) {
        n();
        try {
            Object newInstance = Array.newInstance(f8954b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f8957e.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void n() {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        Method method2;
        if (!f8958f) {
            f8958f = true;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                constructor = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            } catch (ClassNotFoundException | NoSuchMethodException e10) {
                Log.e("TypefaceCompatApi21Impl", e10.getClass().getName(), e10);
                cls = null;
                method2 = null;
                constructor = null;
                method = null;
            }
            f8955c = constructor;
            f8954b = cls;
            f8956d = method;
            f8957e = method2;
        }
    }

    public static Object o() {
        n();
        try {
            return f8955c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Typeface b(Context context, d.b bVar, Resources resources, int i10) {
        Object o10 = o();
        d.c[] a10 = bVar.a();
        int length = a10.length;
        int i11 = 0;
        while (i11 < length) {
            d.c cVar = a10[i11];
            File e10 = l.e(context);
            if (e10 == null) {
                return null;
            }
            try {
                if (!l.c(e10, resources, cVar.b())) {
                    e10.delete();
                    return null;
                } else if (!k(o10, e10.getPath(), cVar.e(), cVar.f())) {
                    return null;
                } else {
                    e10.delete();
                    i11++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e10.delete();
            }
        }
        return l(o10);
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        FileInputStream fileInputStream;
        if (bVarArr.length < 1) {
            return null;
        }
        f.b h10 = h(bVarArr, i10);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h10.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File m10 = m(openFileDescriptor);
                if (m10 != null) {
                    if (m10.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(m10);
                        openFileDescriptor.close();
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface d10 = super.d(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return d10;
            } catch (Throwable th) {
                openFileDescriptor.close();
                throw th;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public final File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }
}
