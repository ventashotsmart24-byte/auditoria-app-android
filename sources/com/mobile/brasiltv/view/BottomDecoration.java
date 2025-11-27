package com.mobile.brasiltv.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class BottomDecoration extends RecyclerView.n {
    int bottomSize;
    int totalSize;

    public BottomDecoration(int i10) {
        this.bottomSize = i10;
        this.totalSize = 0;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (-1 != childLayoutPosition) {
            int i10 = this.totalSize;
            if (i10 == 0) {
                rect.bottom = this.bottomSize;
            } else if (childLayoutPosition + 1 != i10) {
                rect.bottom = this.bottomSize;
            }
        }
    }

    public BottomDecoration(int i10, int i11) {
        this.bottomSize = i10;
        this.totalSize = i11;
    }
}
