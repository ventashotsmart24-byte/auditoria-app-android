package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.mobile.brasiltv.utils.i1;
import com.umeng.analytics.pro.f;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class ReportImageView extends AdvertImageView {
    public Map<Integer, View> _$_findViewCache;
    private Disposable reportDelayedSubp;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ReportImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    private final void stopReortDelayed() {
        boolean z10;
        Disposable disposable;
        Disposable disposable2 = this.reportDelayedSubp;
        if (disposable2 != null) {
            z10 = disposable2.isDisposed();
        } else {
            z10 = true;
        }
        if (!z10 && (disposable = this.reportDelayedSubp) != null) {
            disposable.dispose();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void visibilityChanged(boolean z10) {
        super.visibilityChanged(z10);
        if (z10) {
            i1.e(getContext(), "EVENT_AD_SHOW_HOME");
            this.reportDelayedSubp = i1.p(getContext(), "EVENT_AD_LONG_SHOW_HOME");
            return;
        }
        stopReortDelayed();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReportImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReportImageView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
