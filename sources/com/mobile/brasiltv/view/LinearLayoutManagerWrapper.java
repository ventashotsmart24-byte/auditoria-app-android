package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LinearLayoutManagerWrapper extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public LinearLayoutManagerWrapper(Context context) {
        super(context);
    }

    public boolean canScrollVertically() {
        if (!this.isScrollEnabled || !super.canScrollVertically()) {
            return false;
        }
        return true;
    }

    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        try {
            super.onLayoutChildren(vVar, a0Var);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setScrollEnabled(boolean z10) {
        this.isScrollEnabled = z10;
    }

    public LinearLayoutManagerWrapper(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public LinearLayoutManagerWrapper(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
