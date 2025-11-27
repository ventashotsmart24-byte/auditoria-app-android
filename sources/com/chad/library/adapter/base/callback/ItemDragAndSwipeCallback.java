package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;

public class ItemDragAndSwipeCallback extends f.a {
    private BaseItemDraggableAdapter mAdapter;
    private int mDragMoveFlags = 15;
    private float mMoveThreshold = 0.1f;
    private int mSwipeMoveFlags = 32;
    private float mSwipeThreshold = 0.7f;

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter baseItemDraggableAdapter) {
        this.mAdapter = baseItemDraggableAdapter;
    }

    private boolean isViewCreateByAdapter(RecyclerView.d0 d0Var) {
        int itemViewType = d0Var.getItemViewType();
        if (itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365) {
            return true;
        }
        return false;
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        super.clearView(recyclerView, d0Var);
        if (!isViewCreateByAdapter(d0Var)) {
            View view = d0Var.itemView;
            int i10 = R.id.BaseQuickAdapter_dragging_support;
            if (view.getTag(i10) != null && ((Boolean) d0Var.itemView.getTag(i10)).booleanValue()) {
                this.mAdapter.onItemDragEnd(d0Var);
                d0Var.itemView.setTag(i10, Boolean.FALSE);
            }
            View view2 = d0Var.itemView;
            int i11 = R.id.BaseQuickAdapter_swiping_support;
            if (view2.getTag(i11) != null && ((Boolean) d0Var.itemView.getTag(i11)).booleanValue()) {
                this.mAdapter.onItemSwipeClear(d0Var);
                d0Var.itemView.setTag(i11, Boolean.FALSE);
            }
        }
    }

    public float getMoveThreshold(RecyclerView.d0 d0Var) {
        return this.mMoveThreshold;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        if (isViewCreateByAdapter(d0Var)) {
            return f.a.makeMovementFlags(0, 0);
        }
        return f.a.makeMovementFlags(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    public float getSwipeThreshold(RecyclerView.d0 d0Var) {
        return this.mSwipeThreshold;
    }

    public boolean isItemViewSwipeEnabled() {
        return this.mAdapter.isItemSwipeEnable();
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f10, float f11, int i10, boolean z10) {
        super.onChildDrawOver(canvas, recyclerView, d0Var, f10, f11, i10, z10);
        if (i10 == 1 && !isViewCreateByAdapter(d0Var)) {
            View view = d0Var.itemView;
            canvas.save();
            if (f10 > 0.0f) {
                canvas.clipRect((float) view.getLeft(), (float) view.getTop(), ((float) view.getLeft()) + f10, (float) view.getBottom());
                canvas.translate((float) view.getLeft(), (float) view.getTop());
            } else {
                canvas.clipRect(((float) view.getRight()) + f10, (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
                canvas.translate(((float) view.getRight()) + f10, (float) view.getTop());
            }
            this.mAdapter.onItemSwiping(canvas, d0Var, f10, f11, z10);
            canvas.restore();
        }
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        if (d0Var.getItemViewType() == d0Var2.getItemViewType()) {
            return true;
        }
        return false;
    }

    public void onMoved(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i10, RecyclerView.d0 d0Var2, int i11, int i12, int i13) {
        super.onMoved(recyclerView, d0Var, i10, d0Var2, i11, i12, i13);
        this.mAdapter.onItemDragMoving(d0Var, d0Var2);
    }

    public void onSelectedChanged(RecyclerView.d0 d0Var, int i10) {
        if (i10 == 2 && !isViewCreateByAdapter(d0Var)) {
            this.mAdapter.onItemDragStart(d0Var);
            d0Var.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.TRUE);
        } else if (i10 == 1 && !isViewCreateByAdapter(d0Var)) {
            this.mAdapter.onItemSwipeStart(d0Var);
            d0Var.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        }
        super.onSelectedChanged(d0Var, i10);
    }

    public void onSwiped(RecyclerView.d0 d0Var, int i10) {
        if (!isViewCreateByAdapter(d0Var)) {
            this.mAdapter.onItemSwiped(d0Var);
        }
    }

    public void setDragMoveFlags(int i10) {
        this.mDragMoveFlags = i10;
    }

    public void setMoveThreshold(float f10) {
        this.mMoveThreshold = f10;
    }

    public void setSwipeMoveFlags(int i10) {
        this.mSwipeMoveFlags = i10;
    }

    public void setSwipeThreshold(float f10) {
        this.mSwipeThreshold = f10;
    }
}
