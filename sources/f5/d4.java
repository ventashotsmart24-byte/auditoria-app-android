package f5;

import android.view.KeyEvent;
import android.view.View;
import com.mobile.brasiltv.activity.SearchAty;

public final /* synthetic */ class d4 implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAty f16566a;

    public /* synthetic */ d4(SearchAty searchAty) {
        this.f16566a = searchAty;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        return SearchAty.l3(this.f16566a, view, i10, keyEvent);
    }
}
