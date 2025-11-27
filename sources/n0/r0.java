package n0;

import android.os.Messenger;

public abstract class r0 {
    public static boolean a(Messenger messenger) {
        if (messenger == null) {
            return false;
        }
        try {
            if (messenger.getBinder() != null) {
                return true;
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }
}
