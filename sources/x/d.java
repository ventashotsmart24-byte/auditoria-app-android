package x;

import android.content.res.Configuration;
import android.os.Build;

public abstract class d {
    public static g a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return g.d(configuration.getLocales());
        }
        return g.a(configuration.locale);
    }
}
