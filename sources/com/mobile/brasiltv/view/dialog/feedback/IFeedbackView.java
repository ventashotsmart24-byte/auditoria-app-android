package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;

public interface IFeedbackView {
    void editActionDone();

    Context getContext();

    String getType();

    void showLoading(boolean z10);

    void submitBntEnable(boolean z10);

    void submitSuc();
}
