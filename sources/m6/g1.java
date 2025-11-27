package m6;

import android.content.DialogInterface;
import com.mobile.brasiltv.player.TitanPlayerController;

public final /* synthetic */ class g1 implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18884a;

    public /* synthetic */ g1(TitanPlayerController titanPlayerController) {
        this.f18884a = titanPlayerController;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        TitanPlayerController.p4(this.f18884a, dialogInterface);
    }
}
