package f5;

import android.content.DialogInterface;
import com.mobile.brasiltv.activity.SubtitleAty;

public final /* synthetic */ class x5 implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleAty f16718a;

    public /* synthetic */ x5(SubtitleAty subtitleAty) {
        this.f16718a = subtitleAty;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SubtitleAty.h3(this.f16718a, dialogInterface);
    }
}
