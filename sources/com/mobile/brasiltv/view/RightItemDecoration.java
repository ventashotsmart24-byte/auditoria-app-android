package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.push.IPushHandler;
import com.mobile.brasiltv.utils.s0;
import t9.i;

public final class RightItemDecoration extends RecyclerView.n {
    private final Context content;
    private final int right;

    public RightItemDecoration(Context context, int i10) {
        i.g(context, "content");
        this.content = context;
        this.right = i10;
    }

    public final Context getContent() {
        return this.content;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        int i10;
        i.g(rect, "outRect");
        i.g(view, "view");
        i.g(recyclerView, "parent");
        i.g(a0Var, IPushHandler.STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 0) {
            rect.left = 0;
        }
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = -1;
        }
        if (childLayoutPosition == i10) {
            rect.right = 0;
        } else {
            rect.right = s0.c(this.content, (float) this.right);
        }
    }

    public final int getRight() {
        return this.right;
    }
}
