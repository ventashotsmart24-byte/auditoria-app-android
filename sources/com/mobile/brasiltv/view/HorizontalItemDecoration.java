package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.push.IPushHandler;
import t9.i;

public final class HorizontalItemDecoration extends RecyclerView.n {
    private final Context content;
    private final int left;

    public HorizontalItemDecoration(Context context, int i10) {
        i.g(context, "content");
        this.content = context;
        this.left = i10;
    }

    public final Context getContent() {
        return this.content;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        i.g(rect, "outRect");
        i.g(view, "view");
        i.g(recyclerView, "parent");
        i.g(a0Var, IPushHandler.STATE);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = this.left;
        }
    }

    public final int getLeft() {
        return this.left;
    }
}
