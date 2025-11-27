package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoRelativeLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import s9.l;
import t9.i;

public final class AutoHideRelativeLayout extends AutoRelativeLayout {
    public Map<Integer, View> _$_findViewCache;
    private Disposable disposable;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoHideRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
        i.g(context, f.X);
    }

    /* access modifiers changed from: private */
    public static final void delayHide$lambda$0(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void delayHide$lambda$1(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
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

    public final void cancelDelayHide() {
        Disposable disposable2 = this.disposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    public final void delayHide() {
        Disposable disposable2 = this.disposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.disposable = Observable.timer(5, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe(new c(new AutoHideRelativeLayout$delayHide$1(this)), new d(AutoHideRelativeLayout$delayHide$2.INSTANCE));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (getVisibility() == 0) {
            boolean z11 = true;
            if (motionEvent == null || motionEvent.getAction() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                Disposable disposable2 = this.disposable;
                if (disposable2 != null) {
                    disposable2.dispose();
                }
            } else {
                if (motionEvent == null || motionEvent.getAction() != 1) {
                    z11 = false;
                }
                if (z11) {
                    delayHide();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setVisibility(int i10) {
        Disposable disposable2;
        super.setVisibility(i10);
        if (i10 == 0) {
            delayHide();
        } else if (i10 == 8 && (disposable2 = this.disposable) != null) {
            disposable2.dispose();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoHideRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoHideRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
    }
}
