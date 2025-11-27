package g5;

import android.view.View;
import cn.bingoogolapple.bgabanner.BGABanner;

public final /* synthetic */ class m1 implements BGABanner.Delegate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r1 f17000a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s1 f17001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17002c;

    public /* synthetic */ m1(r1 r1Var, s1 s1Var, String str) {
        this.f17000a = r1Var;
        this.f17001b = s1Var;
        this.f17002c = str;
    }

    public final void onBannerItemClick(BGABanner bGABanner, View view, Object obj, int i10) {
        r1.u(this.f17000a, this.f17001b, this.f17002c, bGABanner, view, obj, i10);
    }
}
