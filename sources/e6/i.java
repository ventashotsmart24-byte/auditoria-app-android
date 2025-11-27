package e6;

import android.content.DialogInterface;
import com.mobile.brasiltv.mine.activity.AccountBindAty;

public final /* synthetic */ class i implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountBindAty f16465a;

    public /* synthetic */ i(AccountBindAty accountBindAty) {
        this.f16465a = accountBindAty;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        AccountBindAty.j3(this.f16465a, dialogInterface);
    }
}
