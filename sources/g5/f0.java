package g5;

import android.content.Context;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import mobile.com.requestframe.utils.response.ShelveAsset;
import t9.i;

public final class f0 extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16906a;

    /* renamed from: b  reason: collision with root package name */
    public int f16907b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(Context context) {
        super((int) R.layout.adapter_hot_search);
        i.g(context, f.X);
        this.f16906a = context;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, ShelveAsset shelveAsset) {
        i.g(baseViewHolder, "helper");
        i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        int adapterPosition = this.f16907b + baseViewHolder.getAdapterPosition();
        if (adapterPosition == 0) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f16906a.getResources().getColor(R.color.color_e61739));
        } else if (adapterPosition == 1) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f16906a.getResources().getColor(R.color.color_e63917));
        } else if (adapterPosition != 2) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f16906a.getResources().getColor(R.color.color_808080));
        } else {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f16906a.getResources().getColor(R.color.color_e67e17));
        }
        ((TextView) baseViewHolder.getView(R.id.mTvNum)).setText(String.valueOf(this.f16907b + baseViewHolder.getAdapterPosition() + 1));
        ((TextView) baseViewHolder.getView(R.id.mTitle)).setText(b0.e(shelveAsset.getAlias(), shelveAsset.getName()));
    }

    public final void b(int i10) {
        this.f16907b = i10;
    }
}
