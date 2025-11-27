package f5;

import android.view.View;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.activity.SplashAty;

public final /* synthetic */ class i5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashAty f16607a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdInfo f16608b;

    public /* synthetic */ i5(SplashAty splashAty, AdInfo adInfo) {
        this.f16607a = splashAty;
        this.f16608b = adInfo;
    }

    public final void onClick(View view) {
        SplashAty.s3(this.f16607a, this.f16608b, view);
    }
}
