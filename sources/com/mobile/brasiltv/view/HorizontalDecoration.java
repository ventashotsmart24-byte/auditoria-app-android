package com.mobile.brasiltv.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalDecoration extends RecyclerView.n {
    private int size;

    public HorizontalDecoration(int i10) {
        this.size = i10;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (-1 != recyclerView.getChildLayoutPosition(view)) {
            rect.right = this.size;
        }
    }
}
