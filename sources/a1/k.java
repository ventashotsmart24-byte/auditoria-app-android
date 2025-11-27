package a1;

import android.util.Log;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static k f115a = null;

    /* renamed from: b  reason: collision with root package name */
    public static final int f116b = 20;

    public static class a extends k {

        /* renamed from: c  reason: collision with root package name */
        public int f117c;

        public a(int i10) {
            super(i10);
            this.f117c = i10;
        }

        public void a(String str, String str2, Throwable... thArr) {
            if (this.f117c <= 3 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public void b(String str, String str2, Throwable... thArr) {
            if (this.f117c > 6) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }

        public void d(String str, String str2, Throwable... thArr) {
            if (this.f117c <= 4 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public void g(String str, String str2, Throwable... thArr) {
            if (this.f117c <= 2 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public void h(String str, String str2, Throwable... thArr) {
            if (this.f117c <= 5 && thArr != null && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public k(int i10) {
    }

    public static synchronized k c() {
        k kVar;
        synchronized (k.class) {
            if (f115a == null) {
                f115a = new a(3);
            }
            kVar = f115a;
        }
        return kVar;
    }

    public static synchronized void e(k kVar) {
        synchronized (k.class) {
            f115a = kVar;
        }
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i10 = f116b;
        if (length >= i10) {
            sb.append(str.substring(0, i10));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
