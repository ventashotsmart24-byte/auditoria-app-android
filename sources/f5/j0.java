package f5;

import android.content.DialogInterface;
import com.mobile.brasiltv.activity.EmailManagerAty;

public final /* synthetic */ class j0 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmailManagerAty f16610a;

    public /* synthetic */ j0(EmailManagerAty emailManagerAty) {
        this.f16610a = emailManagerAty;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        EmailManagerAty.h3(this.f16610a, dialogInterface);
    }
}
