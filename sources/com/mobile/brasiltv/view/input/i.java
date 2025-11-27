package com.mobile.brasiltv.view.input;

import android.view.View;
import android.widget.AdapterView;

public final /* synthetic */ class i implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmailPrefixInputView f12806a;

    public /* synthetic */ i(EmailPrefixInputView emailPrefixInputView) {
        this.f12806a = emailPrefixInputView;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        EmailPrefixInputView.showEmailSuffixPopup$lambda$4(this.f12806a, adapterView, view, i10, j10);
    }
}
