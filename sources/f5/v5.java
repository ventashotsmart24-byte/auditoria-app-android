package f5;

import android.content.DialogInterface;
import com.mobile.brasiltv.activity.SubtitleAty;

public final /* synthetic */ class v5 implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubtitleAty f16701a;

    public /* synthetic */ v5(SubtitleAty subtitleAty) {
        this.f16701a = subtitleAty;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SubtitleAty.j3(this.f16701a, dialogInterface);
    }
}
