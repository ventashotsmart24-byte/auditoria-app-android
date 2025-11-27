package k1;

import a1.k;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7240a = k.f("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z10) {
        int i10;
        String str;
        String str2 = "enabled";
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z10) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i10, 1);
            k c10 = k.c();
            String str3 = f7240a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z10) {
                str = str2;
            } else {
                str = "disabled";
            }
            objArr[1] = str;
            c10.a(str3, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e10) {
            k c11 = k.c();
            String str4 = f7240a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z10) {
                str2 = "disabled";
            }
            objArr2[1] = str2;
            c11.a(str4, String.format("%s could not be %s", objArr2), e10);
        }
    }
}
