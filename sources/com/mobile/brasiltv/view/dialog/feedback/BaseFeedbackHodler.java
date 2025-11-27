package com.mobile.brasiltv.view.dialog.feedback;

import android.view.View;
import com.taobao.accs.common.Constants;
import t9.i;

public abstract class BaseFeedbackHodler {
    private final View contentView;
    private final IFeedbackView host;

    public BaseFeedbackHodler(View view, IFeedbackView iFeedbackView) {
        i.g(view, "contentView");
        i.g(iFeedbackView, Constants.KEY_HOST);
        this.contentView = view;
        this.host = iFeedbackView;
    }

    public abstract void clickSubmit();

    public abstract void dialogCancel();

    public final <T extends View> T findViewById(int i10) {
        T findViewById = this.contentView.findViewById(i10);
        i.f(findViewById, "contentView.findViewById(id)");
        return findViewById;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final IFeedbackView getHost() {
        return this.host;
    }

    public void show(boolean z10) {
        int i10;
        View view = this.contentView;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }
}
