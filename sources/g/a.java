package g;

import android.content.Context;
import android.content.res.Configuration;
import androidx.appcompat.R$bool;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f6623a;

    public a(Context context) {
        this.f6623a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        if (this.f6623a.getApplicationInfo().targetSdkVersion < 14) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f6623a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f6623a.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i10 > 600) {
            return 5;
        }
        if (i10 > 960 && i11 > 720) {
            return 5;
        }
        if (i10 > 720 && i11 > 960) {
            return 5;
        }
        if (i10 >= 500) {
            return 4;
        }
        if (i10 > 640 && i11 > 480) {
            return 4;
        }
        if (i10 > 480 && i11 > 640) {
            return 4;
        }
        if (i10 >= 360) {
            return 3;
        }
        return 2;
    }

    public boolean e() {
        return this.f6623a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs);
    }

    public boolean f() {
        return true;
    }
}
