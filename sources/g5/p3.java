package g5;

import android.view.View;
import com.mobile.brasiltv.db.SwitchAccountBean;

public final /* synthetic */ class p3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17041a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q3 f17042b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17043c;

    public /* synthetic */ p3(SwitchAccountBean switchAccountBean, q3 q3Var, int i10) {
        this.f17041a = switchAccountBean;
        this.f17042b = q3Var;
        this.f17043c = i10;
    }

    public final void onClick(View view) {
        q3.f(this.f17041a, this.f17042b, this.f17043c, view);
    }
}
