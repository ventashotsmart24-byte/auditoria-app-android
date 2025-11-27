package f5;

import android.view.View;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.view.dialog.StandardDialog;

public final /* synthetic */ class d1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainAty f16562a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StandardDialog f16563b;

    public /* synthetic */ d1(MainAty mainAty, StandardDialog standardDialog) {
        this.f16562a = mainAty;
        this.f16563b = standardDialog;
    }

    public final void onClick(View view) {
        MainAty.I3(this.f16562a, this.f16563b, view);
    }
}
