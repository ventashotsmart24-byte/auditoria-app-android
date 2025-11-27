package o0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f8415a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8416b = n(System.getProperty("java.vm.version"));

    /* renamed from: o0.a$a  reason: collision with other inner class name */
    public static final class C0110a {
        public static void a(ClassLoader classLoader, List list, File file) {
            IOException[] iOExceptionArr;
            Object obj = a.g(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                }
                Field a10 = a.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) a10.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                a10.set(obj, iOExceptionArr);
                IOException iOException2 = new IOException("I/O exception during makeDexElement");
                iOException2.initCause((Throwable) arrayList.get(0));
                throw iOException2;
            }
        }

        public static Object[] b(Object obj, ArrayList arrayList, File file, ArrayList arrayList2) {
            Class<ArrayList> cls = ArrayList.class;
            return (Object[]) a.h(obj, "makeDexElements", cls, File.class, cls).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    public static void d(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing old secondary dex dir (");
            sb.append(file.getPath());
            sb.append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to list secondary dex dir content (");
                sb2.append(file.getPath());
                sb2.append(").");
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Trying to delete old file ");
                sb3.append(file2.getPath());
                sb3.append(" of size ");
                sb3.append(file2.length());
                if (!file2.delete()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to delete old file ");
                    sb4.append(file2.getPath());
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Deleted old file ");
                    sb5.append(file2.getPath());
                }
            }
            if (!file.delete()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Failed to delete secondary dex dir ");
                sb6.append(file.getPath());
                return;
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Deleted old secondary dex dir ");
            sb7.append(file.getPath());
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0051 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x007e */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076 A[SYNTHETIC, Splitter:B:33:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            java.util.Set r0 = f8415a
            monitor-enter(r0)
            boolean r1 = r0.contains(r6)     // Catch:{ all -> 0x007f }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            return
        L_0x000b:
            r0.add(r6)     // Catch:{ all -> 0x007f }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x007f }
            r2 = 20
            if (r1 <= r2) goto L_0x0046
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r3.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r4 = "MultiDex is not guaranteed to work in SDK version "
            r3.append(r4)     // Catch:{ all -> 0x007f }
            r3.append(r1)     // Catch:{ all -> 0x007f }
            java.lang.String r1 = ": SDK version higher than "
            r3.append(r1)     // Catch:{ all -> 0x007f }
            r3.append(r2)     // Catch:{ all -> 0x007f }
            java.lang.String r1 = " should be backed by "
            r3.append(r1)     // Catch:{ all -> 0x007f }
            java.lang.String r1 = "runtime with built-in multidex capabilty but it's not the "
            r3.append(r1)     // Catch:{ all -> 0x007f }
            java.lang.String r1 = "case here: java.vm.version=\""
            r3.append(r1)     // Catch:{ all -> 0x007f }
            java.lang.String r1 = "java.vm.version"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch:{ all -> 0x007f }
            r3.append(r1)     // Catch:{ all -> 0x007f }
            java.lang.String r1 = "\""
            r3.append(r1)     // Catch:{ all -> 0x007f }
        L_0x0046:
            java.lang.ClassLoader r1 = j(r5)     // Catch:{ all -> 0x007f }
            if (r1 != 0) goto L_0x004e
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            return
        L_0x004e:
            d(r5)     // Catch:{ all -> 0x0051 }
        L_0x0051:
            java.io.File r7 = k(r5, r7, r8)     // Catch:{ all -> 0x007f }
            o0.b r8 = new o0.b     // Catch:{ all -> 0x007f }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x007f }
            r6 = 0
            java.util.List r6 = r8.q(r5, r9, r6)     // Catch:{ all -> 0x007a }
            m(r1, r7, r6)     // Catch:{ IOException -> 0x0063 }
            goto L_0x006e
        L_0x0063:
            r6 = move-exception
            if (r10 == 0) goto L_0x0079
            r6 = 1
            java.util.List r5 = r8.q(r5, r9, r6)     // Catch:{ all -> 0x007a }
            m(r1, r7, r5)     // Catch:{ all -> 0x007a }
        L_0x006e:
            r8.close()     // Catch:{ IOException -> 0x0073 }
            r5 = 0
            goto L_0x0074
        L_0x0073:
            r5 = move-exception
        L_0x0074:
            if (r5 != 0) goto L_0x0078
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            return
        L_0x0078:
            throw r5     // Catch:{ all -> 0x007f }
        L_0x0079:
            throw r6     // Catch:{ all -> 0x007a }
        L_0x007a:
            r5 = move-exception
            r8.close()     // Catch:{ IOException -> 0x007e }
        L_0x007e:
            throw r5     // Catch:{ all -> 0x007f }
        L_0x007f:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.a.e(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    public static void f(Object obj, String str, Object[] objArr) {
        Field g10 = g(obj, str);
        Object[] objArr2 = (Object[]) g10.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        g10.set(obj, objArr3);
    }

    public static Field g(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static Method h(Object obj, String str, Class... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static ClassLoader j(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                return classLoader;
            }
            Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException unused) {
        }
    }

    public static File k(Context context, File file, String str) {
        File file2 = new File(file, "code_cache");
        try {
            o(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            o(file2);
        }
        File file3 = new File(file2, str);
        o(file3);
        return file3;
    }

    public static void l(Context context) {
        if (!f8416b) {
            try {
                ApplicationInfo i10 = i(context);
                if (i10 != null) {
                    e(context, new File(i10.sourceDir), new File(i10.dataDir), "secondary-dexes", "", true);
                }
            } catch (Exception e10) {
                Log.e("MultiDex", "MultiDex installation failure", e10);
                throw new RuntimeException("MultiDex installation failed (" + e10.getMessage() + ").");
            }
        }
    }

    public static void m(ClassLoader classLoader, File file, List list) {
        if (!list.isEmpty()) {
            C0110a.a(classLoader, list, file);
        }
    }

    public static boolean n(String str) {
        String str2;
        String str3;
        boolean z10 = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String str4 = null;
            if (stringTokenizer.hasMoreTokens()) {
                str3 = stringTokenizer.nextToken();
            } else {
                str3 = null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                str4 = stringTokenizer.nextToken();
            }
            if (!(str3 == null || str4 == null)) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    int parseInt2 = Integer.parseInt(str4);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z10 = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        if (z10) {
            str2 = " has multidex support";
        } else {
            str2 = " does not have multidex support";
        }
        sb.append(str2);
        return z10;
    }

    public static void o(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}
