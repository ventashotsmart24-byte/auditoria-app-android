package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import com.mobile.brasiltv.utils.f1;
import ha.a;
import mobile.com.requestframe.utils.response.FeedBackContactResult;
import t9.i;

public final class ServiceHolder$getCustomerService$1 extends a {
    final /* synthetic */ ServiceHolder this$0;

    public ServiceHolder$getCustomerService$1(ServiceHolder serviceHolder) {
        this.this$0 = serviceHolder;
    }

    public void showErrorHint(String str) {
        i.g(str, "returnCode");
        this.this$0.mIsRequesting = false;
        if (this.this$0.mIsShow) {
            this.this$0.getHost().showLoading(false);
            f1.f12517a.u(str);
        }
    }

    public void onNext(FeedBackContactResult feedBackContactResult) {
        i.g(feedBackContactResult, "t");
        this.this$0.mIsRequesting = false;
        this.this$0.getHost().showLoading(false);
        Context context = this.this$0.getHost().getContext();
        if (context != null) {
            this.this$0.mAdapter.a(context, w6.i.f9510g.o());
        }
    }
}
