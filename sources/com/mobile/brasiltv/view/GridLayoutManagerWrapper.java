package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridLayoutManagerWrapper extends GridLayoutManager {
    public GridLayoutManagerWrapper(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        try {
            super.onLayoutChildren(vVar, a0Var);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public GridLayoutManagerWrapper(Context context, int i10) {
        super(context, i10);
    }

    public GridLayoutManagerWrapper(Context context, int i10, int i11, boolean z10) {
        super(context, i10, i11, z10);
    }
}
