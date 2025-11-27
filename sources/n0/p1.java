package n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class p1 extends BroadcastReceiver {
    public static boolean a(Context context) {
        Intent intent = new Intent(context, p1.class);
        intent.setPackage(context.getPackageName());
        if (context.getPackageManager().queryBroadcastReceivers(intent, 0).size() > 0) {
            return true;
        }
        return false;
    }
}
