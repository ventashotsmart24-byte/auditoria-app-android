package g5;

import android.view.View;
import com.mobile.brasiltv.db.SwitchAccountBean;
import g5.q3;

public final /* synthetic */ class o3 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f17033a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q3 f17034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17035c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q3.b f17036d;

    public /* synthetic */ o3(SwitchAccountBean switchAccountBean, q3 q3Var, int i10, q3.b bVar) {
        this.f17033a = switchAccountBean;
        this.f17034b = q3Var;
        this.f17035c = i10;
        this.f17036d = bVar;
    }

    public final void onClick(View view) {
        q3.e(this.f17033a, this.f17034b, this.f17035c, this.f17036d, view);
    }
}
