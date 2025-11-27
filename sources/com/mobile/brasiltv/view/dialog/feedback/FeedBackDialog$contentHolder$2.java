package com.mobile.brasiltv.view.dialog.feedback;

import android.widget.ScrollView;
import com.mobile.brasiltv.R$id;
import s9.a;
import t9.i;
import t9.j;

public final class FeedBackDialog$contentHolder$2 extends j implements a {
    final /* synthetic */ String $name;
    final /* synthetic */ FeedBackDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackDialog$contentHolder$2(String str, FeedBackDialog feedBackDialog) {
        super(0);
        this.$name = str;
        this.this$0 = feedBackDialog;
    }

    public final ContentHolder invoke() {
        String str = this.$name;
        ScrollView scrollView = (ScrollView) this.this$0.findViewById(R$id.slItemContent);
        i.f(scrollView, "slItemContent");
        return new ContentHolder(str, scrollView, this.this$0);
    }
}
