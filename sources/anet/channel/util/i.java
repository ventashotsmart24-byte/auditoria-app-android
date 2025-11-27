package anet.channel.util;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f4024a = new AtomicInteger();

    public static String a(String str) {
        if (f4024a.get() == Integer.MAX_VALUE) {
            f4024a.set(0);
        }
        if (!TextUtils.isEmpty(str)) {
            return StringUtils.concatString(str, ".AWCN", String.valueOf(f4024a.incrementAndGet()));
        }
        return StringUtils.concatString("AWCN", String.valueOf(f4024a.incrementAndGet()));
    }
}
