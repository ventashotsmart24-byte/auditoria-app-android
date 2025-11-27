package e6;

import android.content.DialogInterface;
import com.mobile.brasiltv.mine.activity.AccountSwitchAty;

public final /* synthetic */ class q implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountSwitchAty f16483a;

    public /* synthetic */ q(AccountSwitchAty accountSwitchAty) {
        this.f16483a = accountSwitchAty;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        AccountSwitchAty.m3(this.f16483a, dialogInterface);
    }
}
