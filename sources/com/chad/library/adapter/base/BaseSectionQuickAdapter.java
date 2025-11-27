package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import java.util.List;

public abstract class BaseSectionQuickAdapter<T extends SectionEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    protected static final int SECTION_HEADER_VIEW = 1092;
    protected int mSectionHeadResId;

    public BaseSectionQuickAdapter(int i10, int i11, List<T> list) {
        super(i10, list);
        this.mSectionHeadResId = i11;
    }

    public abstract void convertHead(K k10, T t10);

    public int getDefItemViewType(int i10) {
        if (((SectionEntity) this.mData.get(i10)).isHeader) {
            return SECTION_HEADER_VIEW;
        }
        return 0;
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
        return super.onCreateDefViewHolder(viewGroup, i10);
    }

    public void onBindViewHolder(K k10, int i10) {
        if (k10.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder(k10, i10);
            return;
        }
        setFullSpan(k10);
        convertHead(k10, (SectionEntity) getItem(i10 - getHeaderLayoutCount()));
    }
}
