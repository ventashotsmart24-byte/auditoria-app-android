package e6;

import android.view.View;
import com.mobile.brasiltv.mine.activity.PlaylistActivity;

public final /* synthetic */ class w0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaylistActivity f16495a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f16496b;

    public /* synthetic */ w0(PlaylistActivity playlistActivity, String str) {
        this.f16495a = playlistActivity;
        this.f16496b = str;
    }

    public final void onClick(View view) {
        PlaylistActivity.T2(this.f16495a, this.f16496b, view);
    }
}
