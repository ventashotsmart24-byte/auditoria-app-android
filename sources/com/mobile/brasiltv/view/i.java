package com.mobile.brasiltv.view;

import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.view.DropDownPop;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropDownPop.MyAdapter f12793a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f12794b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f12795c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwitchAccountBean f12796d;

    public /* synthetic */ i(DropDownPop.MyAdapter myAdapter, int i10, TextView textView, SwitchAccountBean switchAccountBean) {
        this.f12793a = myAdapter;
        this.f12794b = i10;
        this.f12795c = textView;
        this.f12796d = switchAccountBean;
    }

    public final void onClick(View view) {
        DropDownPop.MyAdapter.getView$lambda$0(this.f12793a, this.f12794b, this.f12795c, this.f12796d, view);
    }
}
