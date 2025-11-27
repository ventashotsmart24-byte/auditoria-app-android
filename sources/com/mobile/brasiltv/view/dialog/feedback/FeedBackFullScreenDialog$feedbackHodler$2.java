package com.mobile.brasiltv.view.dialog.feedback;

import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import s9.a;
import t9.i;
import t9.j;

public final class FeedBackFullScreenDialog$feedbackHodler$2 extends j implements a {
    final /* synthetic */ String $name;
    final /* synthetic */ FeedBackFullScreenDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFullScreenDialog$feedbackHodler$2(String str, FeedBackFullScreenDialog feedBackFullScreenDialog) {
        super(0);
        this.$name = str;
        this.this$0 = feedBackFullScreenDialog;
    }

    public final FeedbackHolder invoke() {
        String str = this.$name;
        RecyclerView recyclerView = (RecyclerView) this.this$0.findViewById(R$id.slItemFeedback);
        i.f(recyclerView, "slItemFeedback");
        return new FeedbackHolder(str, recyclerView, this.this$0);
    }
}
