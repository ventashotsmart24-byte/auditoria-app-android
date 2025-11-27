package g5;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.msandroid.mobile.R;
import t9.i;

public final class o0 extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int f17031a = -1;

    public o0() {
        super((int) R.layout.adapter_live_sort_item);
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        i.g(baseViewHolder, "helper");
        i.g(str, "name");
        baseViewHolder.setText((int) R.id.mTextSortName, (CharSequence) str);
        if (this.f17031a == baseViewHolder.getLayoutPosition()) {
            baseViewHolder.setBackgroundColor(R.id.mLayoutSort, this.mContext.getResources().getColor(R.color.color_important));
        } else {
            baseViewHolder.setBackgroundColor(R.id.mLayoutSort, this.mContext.getResources().getColor(R.color.color_99000000));
        }
    }

    public final void b(int i10) {
        this.f17031a = i10;
        notifyDataSetChanged();
    }
}
