package com.mobile.brasiltv.view.dialog.feedback;

import android.widget.ScrollView;
import com.mobile.brasiltv.R$id;
import s9.a;
import t9.i;
import t9.j;

public final class CastFeedBackDialog$feedbackHodler$2 extends j implements a {
    final /* synthetic */ CastFeedBackDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CastFeedBackDialog$feedbackHodler$2(CastFeedBackDialog castFeedBackDialog) {
        super(0);
        this.this$0 = castFeedBackDialog;
    }

    public final CastFeedBackHolder invoke() {
        ScrollView scrollView = (ScrollView) this.this$0.findViewById(R$id.slItemContent);
        i.f(scrollView, "slItemContent");
        return new CastFeedBackHolder(scrollView, this.this$0);
    }
}
