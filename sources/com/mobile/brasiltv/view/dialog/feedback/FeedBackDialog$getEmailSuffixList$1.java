package com.mobile.brasiltv.view.dialog.feedback;

import ba.t;
import com.mobile.brasiltv.utils.b0;
import ha.a;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import t9.i;

public final class FeedBackDialog$getEmailSuffixList$1 extends a {
    final /* synthetic */ FeedBackDialog this$0;

    public FeedBackDialog$getEmailSuffixList$1(FeedBackDialog feedBackDialog) {
        this.this$0 = feedBackDialog;
    }

    public void showErrorHint(String str) {
        i.g(str, "returnCode");
    }

    public void onNext(GetEmailSuffixResult getEmailSuffixResult) {
        i.g(getEmailSuffixResult, "t");
        super.onNext(getEmailSuffixResult);
        GetEmailSuffix data = getEmailSuffixResult.getData();
        if (b0.K(data != null ? data.getEmailSuffixStr() : null)) {
            GetEmailSuffix data2 = getEmailSuffixResult.getData();
            i.d(data2);
            String emailSuffixStr = data2.getEmailSuffixStr();
            i.d(emailSuffixStr);
            this.this$0.updateEmailSuffixList(t.M(emailSuffixStr, new String[]{","}, false, 0, 6, (Object) null));
        }
    }
}
