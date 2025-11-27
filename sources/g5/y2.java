package g5;

import android.view.View;
import com.chad.library.adapter.base.BaseViewHolder;
import mobile.com.requestframe.utils.response.SearchShelveItem;

public final /* synthetic */ class y2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchShelveItem f17189a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b3 f17190b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseViewHolder f17191c;

    public /* synthetic */ y2(SearchShelveItem searchShelveItem, b3 b3Var, BaseViewHolder baseViewHolder) {
        this.f17189a = searchShelveItem;
        this.f17190b = b3Var;
        this.f17191c = baseViewHolder;
    }

    public final void onClick(View view) {
        b3.f(this.f17189a, this.f17190b, this.f17191c, view);
    }
}
