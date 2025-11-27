package com.mobile.brasiltv.view.login;

import s9.a;
import t9.j;

public final class ScrollableImageView$registerScheduleScroll$1 extends j implements a {
    final /* synthetic */ ScrollableImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableImageView$registerScheduleScroll$1(ScrollableImageView scrollableImageView) {
        super(0);
        this.this$0 = scrollableImageView;
    }

    public final void invoke() {
        this.this$0.scheduleScroll();
        this.this$0.mMeasureListener = null;
    }
}
