package n6;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import o6.b;
import t9.i;

public final class c extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f19015a;

    /* renamed from: b  reason: collision with root package name */
    public int f19016b;

    public c(boolean z10) {
        super((int) R.layout.item_landscape_quality);
        this.f19015a = z10;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, b bVar) {
        boolean z10;
        int i10;
        i.g(baseViewHolder, "helper");
        i.g(bVar, PlistBuilder.KEY_ITEM);
        int adapterPosition = baseViewHolder.getAdapterPosition();
        boolean z11 = false;
        if (this.f19016b == adapterPosition) {
            z10 = true;
        } else {
            z10 = false;
        }
        baseViewHolder.setGone(R.id.ivState, z10).setText((int) R.id.tvName, (CharSequence) bVar.a());
        if (this.f19016b == adapterPosition) {
            z11 = true;
        }
        if (z11) {
            i10 = this.mContext.getResources().getColor(R.color.color_important);
        } else {
            i10 = this.mContext.getResources().getColor(R.color.color_ffffff);
        }
        baseViewHolder.setTextColor(R.id.tvName, i10);
    }

    public final void b(int i10) {
        this.f19016b = i10;
        notifyDataSetChanged();
    }
}
