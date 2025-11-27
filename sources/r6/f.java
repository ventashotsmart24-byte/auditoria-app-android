package r6;

import android.content.Context;
import com.mobile.brasiltv.player.view.ProgramRecommendInfoView;
import g5.w;
import s9.a;
import t9.i;
import t9.j;

public final class f extends j implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProgramRecommendInfoView f19408a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ProgramRecommendInfoView programRecommendInfoView) {
        super(0);
        this.f19408a = programRecommendInfoView;
    }

    /* renamed from: b */
    public final w invoke() {
        Context context = this.f19408a.getContext();
        i.f(context, com.umeng.analytics.pro.f.X);
        return new w(context);
    }
}
