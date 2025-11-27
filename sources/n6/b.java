package n6;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import t9.g;
import t9.i;

public final class b extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f19013a;

    /* renamed from: b  reason: collision with root package name */
    public int f19014b;

    public b(boolean z10) {
        super((int) R.layout.itme_cast_articulation);
        this.f19013a = z10;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, o6.b bVar) {
        boolean z10;
        int i10;
        i.g(baseViewHolder, "helper");
        i.g(bVar, PlistBuilder.KEY_ITEM);
        int adapterPosition = baseViewHolder.getAdapterPosition();
        boolean z11 = false;
        if (this.f19014b == adapterPosition) {
            z10 = true;
        } else {
            z10 = false;
        }
        baseViewHolder.setGone(R.id.ivState, z10).setText((int) R.id.tvName, (CharSequence) bVar.a());
        AutoRelativeLayout.LayoutParams layoutParams = new AutoRelativeLayout.LayoutParams(-1, AutoUtils.getPercentHeightSize(1));
        if (adapterPosition == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = AutoUtils.getPercentWidthSize(24);
            layoutParams.rightMargin = AutoUtils.getPercentWidthSize(24);
        }
        baseViewHolder.getView(R.id.mVLine).setLayoutParams(layoutParams);
        if (this.f19014b == adapterPosition) {
            z11 = true;
        }
        if (z11) {
            i10 = this.mContext.getResources().getColor(R.color.color_important);
        } else {
            i10 = this.mContext.getResources().getColor(R.color.color_important_white);
        }
        baseViewHolder.setTextColor(R.id.tvName, i10);
    }

    public final int b() {
        return this.f19014b;
    }

    public final void c(int i10) {
        this.f19014b = i10;
        notifyDataSetChanged();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(boolean z10, int i10, g gVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
