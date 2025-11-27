package p2;

import android.app.Application;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import s2.a;
import s2.d;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Comparator f8804a = new a();

    public static /* synthetic */ boolean h(File file) {
        String name = file.getName();
        if (TextUtils.isEmpty(name) || !name.endsWith("user.meta")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Application application) {
        File filesDir = application.getFilesDir();
        e(new File(filesDir, ".com.google.firebase.crashlytics-ndk"));
        d(new File(filesDir, ".com.google.firebase.crashlytics"));
    }

    public final void d(File file) {
        File[] a10 = a.a(file, new c(), com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        if (a10 != null && a10.length > 10) {
            Arrays.sort(a10, this.f8804a);
            for (int i10 = 10; i10 < a10.length; i10++) {
                try {
                    a.b(a10[i10]);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        File[] a11 = a.a(new File(file, "log-files"), (FileFilter) null, com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        if (a11 != null && a11.length > 10) {
            Arrays.sort(a11, this.f8804a);
            for (int i11 = 10; i11 < a11.length; i11++) {
                try {
                    a.b(a11[i11]);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public final void e(File file) {
        File[] a10 = a.a(file, (FileFilter) null, com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        if (a10 != null) {
            if (a10.length > 10) {
                Arrays.sort(a10, this.f8804a);
                for (int i10 = 10; i10 < a10.length; i10++) {
                    try {
                        a.b(a10[i10]);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }
    }

    public void f(Application application) {
        g(application);
    }

    public final void g(Application application) {
        s2.d.c().schedule(new d.e("fix_firebase_log", (Runnable) new b(this, application), false), 30, TimeUnit.SECONDS);
    }
}
