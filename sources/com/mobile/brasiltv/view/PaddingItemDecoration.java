package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.push.IPushHandler;
import com.zhy.autolayout.utils.AutoUtils;
import t9.g;
import t9.i;

public final class PaddingItemDecoration extends RecyclerView.n {
    private final Context content;
    private final boolean hasBottom;
    private final boolean hasTop;
    private final int padding;

    public PaddingItemDecoration(Context context, int i10, boolean z10, boolean z11) {
        i.g(context, "content");
        this.content = context;
        this.padding = i10;
        this.hasTop = z10;
        this.hasBottom = z11;
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
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i10 = adapter.getItemCount();
        } else {
            i10 = -1;
        }
        if (childLayoutPosition == i10) {
            rect.left = AutoUtils.getPercentWidthSize(this.padding);
            rect.right = AutoUtils.getPercentWidthSize(this.padding);
            if (this.hasTop) {
                rect.top = AutoUtils.getPercentHeightSize(this.padding);
            }
            if (this.hasBottom) {
                rect.bottom = AutoUtils.getPercentHeightSize(this.padding);
                return;
            }
            return;
        }
        rect.left = AutoUtils.getPercentWidthSize(this.padding);
        rect.right = AutoUtils.getPercentWidthSize(this.padding);
        if (this.hasTop) {
            rect.top = AutoUtils.getPercentHeightSize(this.padding);
        }
        if (this.hasBottom) {
            rect.bottom = AutoUtils.getPercentHeightSize(this.padding);
        }
    }

    public final int getPadding() {
        return this.padding;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaddingItemDecoration(Context context, int i10, boolean z10, boolean z11, int i11, g gVar) {
        this(context, i10, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? false : z11);
    }
}
