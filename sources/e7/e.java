package e7;

import android.app.Activity;
import android.content.DialogInterface;

public final class e implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f16521a;

    public e(Activity activity) {
        this.f16521a = activity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void onClick(DialogInterface dialogInterface, int i10) {
        run();
    }

    public void run() {
        this.f16521a.finish();
    }
}
