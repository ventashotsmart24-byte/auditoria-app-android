package com.chad.library.adapter.base.listener;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

public abstract class OnItemChildLongClickListener extends SimpleClickListener {
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
    }

    public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        onSimpleItemChildLongClick(baseQuickAdapter, view, i10);
    }

    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
    }

    public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
    }

    public abstract void onSimpleItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10);
}
