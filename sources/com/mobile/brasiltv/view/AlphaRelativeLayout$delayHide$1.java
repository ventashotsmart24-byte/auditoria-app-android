package com.mobile.brasiltv.view;

import com.mobile.brasiltv.view.AlphaRelativeLayout;
import h9.t;
import s9.l;
import t9.j;

public final class AlphaRelativeLayout$delayHide$1 extends j implements l {
    final /* synthetic */ AlphaRelativeLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlphaRelativeLayout$delayHide$1(AlphaRelativeLayout alphaRelativeLayout) {
        super(1);
        this.this$0 = alphaRelativeLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return t.f17319a;
    }

    public final void invoke(Long l10) {
        this.this$0.hide();
        AlphaRelativeLayout.OnVisibility listener = this.this$0.getListener();
        if (listener != null) {
            listener.onVisible(8);
        }
    }
}
