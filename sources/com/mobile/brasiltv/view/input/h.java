package com.mobile.brasiltv.view.input;

import android.widget.PopupWindow;

public final /* synthetic */ class h implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EmailPrefixInputView f12805a;

    public /* synthetic */ h(EmailPrefixInputView emailPrefixInputView) {
        this.f12805a = emailPrefixInputView;
    }

    public final void onDismiss() {
        EmailPrefixInputView.showEmailSuffixPopup$lambda$3(this.f12805a);
    }
}
