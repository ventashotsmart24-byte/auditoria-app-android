package com.mobile.brasiltv.view.vod;

import android.widget.PopupWindow;

public final /* synthetic */ class a implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SeasonSpinner f12858a;

    public /* synthetic */ a(SeasonSpinner seasonSpinner) {
        this.f12858a = seasonSpinner;
    }

    public final void onDismiss() {
        SeasonSpinner.showSeasonPopup$lambda$1(this.f12858a);
    }
}
