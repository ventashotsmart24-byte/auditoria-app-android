package f5;

import android.content.DialogInterface;
import com.mobile.brasiltv.activity.SubtitleAty;

public final /* synthetic */ class w5 implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleAty f16709a;

    public /* synthetic */ w5(SubtitleAty subtitleAty) {
        this.f16709a = subtitleAty;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SubtitleAty.n3(this.f16709a, dialogInterface);
    }
}
