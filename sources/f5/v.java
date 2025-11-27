package f5;

import android.view.View;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.activity.CastModeAty;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdInfo f16694a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CastModeAty f16695b;

    public /* synthetic */ v(AdInfo adInfo, CastModeAty castModeAty) {
        this.f16694a = adInfo;
        this.f16695b = castModeAty;
    }

    public final void onClick(View view) {
        CastModeAty.j3(this.f16694a, this.f16695b, view);
    }
}
