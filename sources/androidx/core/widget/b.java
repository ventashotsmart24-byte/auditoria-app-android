package androidx.core.widget;

import android.os.Build;

public interface b {
    public static final boolean P;

    static {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 27) {
            z10 = true;
        } else {
            z10 = false;
        }
        P = z10;
    }
}
