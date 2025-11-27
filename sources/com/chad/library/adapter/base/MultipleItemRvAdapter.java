package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.chad.library.adapter.base.util.ProviderDelegate;
import java.util.List;

public abstract class MultipleItemRvAdapter<T, V extends BaseViewHolder> extends BaseQuickAdapter<T, V> {
    private SparseArray<BaseItemProvider> mItemProviders;
    protected ProviderDelegate mProviderDelegate;

    public MultipleItemRvAdapter(List<T> list) {
        super(list);
    }

    private void bindClick(V v10, T t10, int i10, BaseItemProvider baseItemProvider) {
        BaseQuickAdapter.OnItemClickListener onItemClickListener = getOnItemClickListener();
        BaseQuickAdapter.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemClickListener == null || onItemLongClickListener == null) {
            View view = v10.itemView;
            if (onItemClickListener == null) {
                final BaseItemProvider baseItemProvider2 = baseItemProvider;
                final V v11 = v10;
                final T t11 = t10;
                final int i11 = i10;
                view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        baseItemProvider2.onClick(v11, t11, i11);
                    }
                });
            }
            if (onItemLongClickListener == null) {
                final BaseItemProvider baseItemProvider3 = baseItemProvider;
                final V v12 = v10;
                final T t12 = t10;
                final int i12 = i10;
                view.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        return baseItemProvider3.onLongClick(v12, t12, i12);
                    }
                });
            }
        }
    }

    public void convert(V v10, T t10) {
        BaseItemProvider baseItemProvider = this.mItemProviders.get(v10.getItemViewType());
        baseItemProvider.mContext = v10.itemView.getContext();
        int layoutPosition = v10.getLayoutPosition() - getHeaderLayoutCount();
        baseItemProvider.convert(v10, t10, layoutPosition);
        bindClick(v10, t10, layoutPosition, baseItemProvider);
    }

    public void finishInitialize() {
        this.mProviderDelegate = new ProviderDelegate();
        setMultiTypeDelegate(new MultiTypeDelegate<T>() {
            public int getItemType(T t10) {
                return MultipleItemRvAdapter.this.getViewType(t10);
            }
        });
        registerItemProvider();
        this.mItemProviders = this.mProviderDelegate.getItemProviders();
        for (int i10 = 0; i10 < this.mItemProviders.size(); i10++) {
            int keyAt = this.mItemProviders.keyAt(i10);
            BaseItemProvider baseItemProvider = this.mItemProviders.get(keyAt);
            baseItemProvider.mData = this.mData;
            getMultiTypeDelegate().registerItemType(keyAt, baseItemProvider.layout());
        }
    }

    public abstract int getViewType(T t10);

    public abstract void registerItemProvider();
}
