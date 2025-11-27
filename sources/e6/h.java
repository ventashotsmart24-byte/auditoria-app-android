package e6;

import android.content.DialogInterface;
import com.mobile.brasiltv.mine.activity.AccountAty;

public final /* synthetic */ class h implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountAty f16462a;

    public /* synthetic */ h(AccountAty accountAty) {
        this.f16462a = accountAty;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        AccountAty.v3(this.f16462a, dialogInterface);
    }
}
