package i2;

import android.text.TextUtils;
import java.util.List;

public abstract class g {
    public static final boolean a(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    public static final boolean b(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }
}
