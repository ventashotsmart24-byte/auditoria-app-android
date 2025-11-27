package m8;

import android.text.TextUtils;

public abstract class d {
    public static final boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public static final boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }
}
