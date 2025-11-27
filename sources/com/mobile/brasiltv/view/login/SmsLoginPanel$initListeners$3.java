package com.mobile.brasiltv.view.login;

import android.text.TextUtils;
import com.mobile.brasiltv.R$id;
import t9.i;

public final class SmsLoginPanel$initListeners$3 implements IVerifyCodeCallback {
    final /* synthetic */ SmsLoginPanel this$0;

    public SmsLoginPanel$initListeners$3(SmsLoginPanel smsLoginPanel) {
        this.this$0 = smsLoginPanel;
    }

    public void onSendSms() {
        this.this$0.requestFocus();
        ISmsLoginCallback access$getMSmsLoginCallback$p = this.this$0.mSmsLoginCallback;
        if (access$getMSmsLoginCallback$p != null) {
            String mobile2 = this.this$0.getMobile();
            SmsLoginPanel smsLoginPanel = this.this$0;
            int i10 = R$id.mPavArea;
            access$getMSmsLoginCallback$p.onSendSms(mobile2, ((PickAreaView) smsLoginPanel._$_findCachedViewById(i10)).getArea(), ((PickAreaView) this.this$0._$_findCachedViewById(i10)).getAreaCode());
        }
    }

    public void onVerifyCodeChanged(String str) {
        i.g(str, "content");
        this.this$0.mFindVerifyCode = !TextUtils.isEmpty(str);
        this.this$0.updateLoginBtnEnable();
    }
}
