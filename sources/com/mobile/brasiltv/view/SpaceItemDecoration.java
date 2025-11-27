package com.mobile.brasiltv.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.n {
    private int rightSpace;
    private int sizeLen;
    private int topSpace;

    public SpaceItemDecoration(int i10, int i11, int i12) {
        this.topSpace = i10;
        this.rightSpace = i11;
        this.sizeLen = i12;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (-1 != childLayoutPosition) {
            int i10 = childLayoutPosition + 1;
            int i11 = this.sizeLen;
            if (i10 > i11) {
                rect.top = this.topSpace;
            }
            if (i10 % i11 != 0) {
                rect.right = this.rightSpace;
            }
        }
    }
}
