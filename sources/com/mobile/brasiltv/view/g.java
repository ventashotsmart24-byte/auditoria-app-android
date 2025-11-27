package com.mobile.brasiltv.view;

import android.widget.PopupWindow;

public final /* synthetic */ class g implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropDownListView f12789a;

    public /* synthetic */ g(DropDownListView dropDownListView) {
        this.f12789a = dropDownListView;
    }

    public final void onDismiss() {
        DropDownListView.initListener$lambda$0(this.f12789a);
    }
}
