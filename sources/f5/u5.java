package f5;

import android.content.DialogInterface;
import com.mobile.brasiltv.activity.SubtitleAty;

public final /* synthetic */ class u5 implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleAty f16693a;

    public /* synthetic */ u5(SubtitleAty subtitleAty) {
        this.f16693a = subtitleAty;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SubtitleAty.l3(this.f16693a, dialogInterface);
    }
}
