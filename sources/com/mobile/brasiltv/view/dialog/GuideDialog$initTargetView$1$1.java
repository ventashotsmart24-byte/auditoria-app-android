package com.mobile.brasiltv.view.dialog;

import android.view.View;
import android.view.ViewTreeObserver;

public final class GuideDialog$initTargetView$1$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ View $targetView;
    final /* synthetic */ GuideDialog this$0;

    public GuideDialog$initTargetView$1$1(View view, GuideDialog guideDialog) {
        this.$targetView = view;
        this.this$0 = guideDialog;
    }

    public void onGlobalLayout() {
        this.$targetView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.$targetView.getLocationInWindow(this.this$0.mTargetLocation);
        this.this$0.handlerLocation(this.$targetView);
    }
}
