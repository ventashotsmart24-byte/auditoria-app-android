package j7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.content.FileProvider;
import com.mobile.autoupdate.R$string;
import h7.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.concurrent.Callable;

public abstract class a {

    /* renamed from: j7.a$a  reason: collision with other inner class name */
    public class C0233a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17548a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f17549b;

        public C0233a(String str, File file) {
            this.f17548a = str;
            this.f17549b = file;
        }

        /* renamed from: a */
        public void onNext(d5.b bVar) {
            String str;
            if (a.d(this.f17548a)) {
                str = "externalStorage_";
            } else {
                str = "internalStorage_";
            }
            h.d(str + ((String) bVar.b()), this.f17549b.length(), (String) bVar.a());
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        public void onSubscribe(Disposable disposable) {
        }
    }

    public class b implements Callable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f17550a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17551b;

        public b(File file, String str) {
            this.f17550a = file;
            this.f17551b = str;
        }

        /* renamed from: a */
        public d5.b call() {
            String b10 = d.b(this.f17550a);
            if (b10 == null || b10.isEmpty()) {
                b10 = "apkMd5 is empty";
            }
            String str = this.f17551b;
            if (str == null || str.trim().isEmpty()) {
                str = "pathMd5 is empty";
            }
            return new d5.b(b10, str);
        }
    }

    public static Long b() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Long.valueOf(Long.valueOf(statFs.getAvailableBlocksLong()).longValue() * Long.valueOf(statFs.getBlockSizeLong()).longValue());
    }

    public static void c(Context context, String str) {
        Long b10 = b();
        File file = new File(str);
        if (b10.longValue() < file.length()) {
            g.a(context, context.getString(R$string.insufficient_disk_space), 0);
        }
        e(file, str);
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            String packageName = context.getPackageName();
            Uri e10 = FileProvider.e(context, packageName + ".fileprovider", file);
            intent.setFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(e10, "application/vnd.android.package-archive");
        } else {
            intent.setFlags(268435456);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        if (f(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static boolean d(String str) {
        return str.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public static void e(File file, String str) {
        Observable.fromCallable(new b(file, str)).compose(f.a()).subscribe(new C0233a(str, file));
    }

    public static boolean f(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || packageManager.resolveActivity(intent, 0) == null) {
            return false;
        }
        return true;
    }
}
