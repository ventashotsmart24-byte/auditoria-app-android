package e6;

import android.content.DialogInterface;
import com.mobile.brasiltv.mine.activity.EmailAty;

public final /* synthetic */ class y implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmailAty f16499a;

    public /* synthetic */ y(EmailAty emailAty) {
        this.f16499a = emailAty;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        EmailAty.q3(this.f16499a, dialogInterface);
    }
}
