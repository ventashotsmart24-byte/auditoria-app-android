package com.mobile.brasiltv.view.adView;

import android.content.Context;
import com.msandroid.mobile.R;
import s9.a;
import t9.i;
import t9.j;

public final class PauseAdView$mAdLandUnitId$2 extends j implements a {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PauseAdView$mAdLandUnitId$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final String invoke() {
        String string = this.$context.getString(R.string.play_pause_ad_id_land);
        i.f(string, "context.getString(R.string.play_pause_ad_id_land)");
        return string;
    }
}
