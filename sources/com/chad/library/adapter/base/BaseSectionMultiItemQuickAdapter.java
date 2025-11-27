package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import java.util.List;

public abstract class BaseSectionMultiItemQuickAdapter<T extends SectionMultiEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    protected static final int SECTION_HEADER_VIEW = 1092;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;
    protected int mSectionHeadResId;

    public BaseSectionMultiItemQuickAdapter(int i10, List<T> list) {
        super(list);
        this.mSectionHeadResId = i10;
    }

    private int getLayoutId(int i10) {
        return this.layouts.get(i10, -404);
    }

    public void addItemType(int i10, int i11) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(i10, i11);
    }

    public abstract void convertHead(K k10, T t10);

    public int getDefItemViewType(int i10) {
        SectionMultiEntity sectionMultiEntity = (SectionMultiEntity) this.mData.get(i10);
        if (sectionMultiEntity == null) {
            return DEFAULT_VIEW_TYPE;
        }
        if (sectionMultiEntity.isHeader) {
            return SECTION_HEADER_VIEW;
        }
        return sectionMultiEntity.getItemType();
    }

    public boolean isFixedViewType(int i10) {
        if (super.isFixedViewType(i10) || i10 == SECTION_HEADER_VIEW) {
            return true;
        }
        return false;
    }

    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        if (i10 == SECTION_HEADER_VIEW) {
            return createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup));
        }
        return createBaseViewHolder(viewGroup, getLayoutId(i10));
    }

    public void remove(int i10) {
        List<T> list = this.mData;
        if (list != null && i10 >= 0 && i10 < list.size()) {
            SectionMultiEntity sectionMultiEntity = (SectionMultiEntity) this.mData.get(i10);
            if (sectionMultiEntity instanceof IExpandable) {
                removeAllChild((IExpandable) sectionMultiEntity, i10);
            }
            removeDataFromParent(sectionMultiEntity);
            super.remove(i10);
        }
    }

    public void removeAllChild(IExpandable iExpandable, int i10) {
        List subItems;
        if (iExpandable.isExpanded() && (subItems = iExpandable.getSubItems()) != null && subItems.size() != 0) {
            int size = subItems.size();
            for (int i11 = 0; i11 < size; i11++) {
                remove(i10 + 1);
            }
        }
    }

    public void removeDataFromParent(T t10) {
        int parentPosition = getParentPosition(t10);
        if (parentPosition >= 0) {
            ((IExpandable) this.mData.get(parentPosition)).getSubItems().remove(t10);
        }
    }

    public void setDefaultViewTypeLayout(int i10) {
        addItemType(DEFAULT_VIEW_TYPE, i10);
    }

    public void onBindViewHolder(K k10, int i10) {
        if (k10.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder(k10, i10);
            return;
        }
        setFullSpan(k10);
        convertHead(k10, (SectionMultiEntity) getItem(i10 - getHeaderLayoutCount()));
    }
}
