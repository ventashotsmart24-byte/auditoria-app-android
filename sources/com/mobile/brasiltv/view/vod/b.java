package com.mobile.brasiltv.view.vod;

import android.view.View;
import android.widget.AdapterView;

public final /* synthetic */ class b implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SeasonSpinner f12859a;

    public /* synthetic */ b(SeasonSpinner seasonSpinner) {
        this.f12859a = seasonSpinner;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        SeasonSpinner.showSeasonPopup$lambda$2(this.f12859a, adapterView, view, i10, j10);
    }
}
