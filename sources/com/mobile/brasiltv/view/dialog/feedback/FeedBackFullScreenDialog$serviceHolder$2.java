package com.mobile.brasiltv.view.dialog.feedback;

import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import s9.a;
import t9.i;
import t9.j;

public final class FeedBackFullScreenDialog$serviceHolder$2 extends j implements a {
    final /* synthetic */ FeedBackFullScreenDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFullScreenDialog$serviceHolder$2(FeedBackFullScreenDialog feedBackFullScreenDialog) {
        super(0);
        this.this$0 = feedBackFullScreenDialog;
    }

    public final ServiceHolder invoke() {
        RecyclerView recyclerView = (RecyclerView) this.this$0.findViewById(R$id.slItemService);
        i.f(recyclerView, "slItemService");
        return new ServiceHolder(recyclerView, this.this$0);
    }
}
