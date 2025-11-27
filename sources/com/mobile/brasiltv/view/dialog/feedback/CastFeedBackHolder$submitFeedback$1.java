package com.mobile.brasiltv.view.dialog.feedback;

import ha.a;
import mobile.com.requestframe.utils.response.BaseResult;
import t9.i;

public final class CastFeedBackHolder$submitFeedback$1 extends a {
    public void onNext(BaseResult baseResult) {
        i.g(baseResult, "t");
    }

    public void showErrorHint(String str) {
        i.g(str, "returnCode");
    }
}
