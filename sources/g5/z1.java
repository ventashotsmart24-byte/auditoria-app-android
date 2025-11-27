package g5;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import j5.a;
import java.util.List;
import t9.g;
import t9.i;

public final class z1 extends a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f17199a;

    public z1(boolean z10) {
        super(R.layout.adapter_recommend_horizontal_default_item, (List) null, 2, (g) null);
        this.f17199a = z10;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        i.g(baseViewHolder, "helper");
        i.g(str, PlistBuilder.KEY_ITEM);
        if (this.f17199a) {
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setPadding(7, 7, 7, 0);
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setBackgroundResource(R.drawable.bg_radius_white);
            ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setLayoutParams(new LinearLayout.LayoutParams(AutoUtils.getPercentWidthSize(210), AutoUtils.getPercentWidthSize(MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT)));
            ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(8);
            return;
        }
        ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(0);
        ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(8);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z1(boolean z10, int i10, g gVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
