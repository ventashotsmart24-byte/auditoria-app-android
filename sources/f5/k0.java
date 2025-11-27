package f5;

import android.content.DialogInterface;
import com.mobile.brasiltv.activity.EmailManagerAty;

public final /* synthetic */ class k0 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmailManagerAty f16616a;

    public /* synthetic */ k0(EmailManagerAty emailManagerAty) {
        this.f16616a = emailManagerAty;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        EmailManagerAty.i3(this.f16616a, dialogInterface);
    }
}
