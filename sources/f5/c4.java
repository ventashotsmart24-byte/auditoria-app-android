package f5;

import android.view.KeyEvent;
import android.widget.TextView;
import com.mobile.brasiltv.activity.SearchAty;

public final /* synthetic */ class c4 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchAty f16558a;

    public /* synthetic */ c4(SearchAty searchAty) {
        this.f16558a = searchAty;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return SearchAty.k3(this.f16558a, textView, i10, keyEvent);
    }
}
