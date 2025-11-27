package com.mobile.brasiltv.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.msandroid.mobile.R;

public class RecyclerLoadMoreView extends LoadMoreView {
    public int getLayoutId() {
        return R.layout.layout_recycler_load_more;
    }

    public int getLoadEndViewId() {
        return R.id.layout_over_view;
    }

    public int getLoadFailViewId() {
        return R.id.layout_failed_view;
    }

    public int getLoadingViewId() {
        return R.id.layout_loading_view;
    }

    public boolean isLoadEndGone() {
        return false;
    }
}
