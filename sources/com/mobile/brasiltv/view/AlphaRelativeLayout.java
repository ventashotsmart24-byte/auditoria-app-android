package com.mobile.brasiltv.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.utils.p0;
import com.zhy.autolayout.AutoRelativeLayout;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import s9.l;
import t9.i;

public class AlphaRelativeLayout extends AutoRelativeLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private OnVisibility listener;
    private boolean mEnableProxyVisibility;
    private boolean mVisibilitySwitch;
    private Disposable subscription;

    public interface OnVisibility {
        void onVisible(int i10);
    }

    public AlphaRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVisibilitySwitch = true;
    }

    /* access modifiers changed from: private */
    public static final void delayHide$lambda$0(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void hide() {
        super.setVisibility(8);
    }

    private final void show() {
        super.setVisibility(0);
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

    public final void cancelDalayHide() {
        Disposable disposable = this.subscription;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void delayHide() {
        Disposable disposable = this.subscription;
        if (disposable != null) {
            disposable.dispose();
        }
        this.subscription = Observable.timer(5, TimeUnit.SECONDS).compose(p0.a()).subscribe(new a(new AlphaRelativeLayout$delayHide$1(this)));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 0) {
            boolean z10 = false;
            if (motionEvent != null && motionEvent.getAction() == 0) {
                z10 = true;
            }
            if (z10) {
                delayHide();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void enableProxyVisibility(boolean z10) {
        this.mEnableProxyVisibility = z10;
    }

    public final OnVisibility getListener() {
        return this.listener;
    }

    public final boolean getMEnableProxyVisibility() {
        return this.mEnableProxyVisibility;
    }

    public final boolean getMVisibilitySwitch() {
        return this.mVisibilitySwitch;
    }

    public final Disposable getSubscription() {
        return this.subscription;
    }

    public final void setListener(OnVisibility onVisibility) {
        this.listener = onVisibility;
    }

    public final void setMEnableProxyVisibility(boolean z10) {
        this.mEnableProxyVisibility = z10;
    }

    public final void setMVisibilitySwitch(boolean z10) {
        this.mVisibilitySwitch = z10;
    }

    public final void setSubscription(Disposable disposable) {
        this.subscription = disposable;
    }

    public void setVisibility(int i10) {
        OnVisibility onVisibility;
        if (this.mVisibilitySwitch) {
            if (this.mEnableProxyVisibility && (onVisibility = this.listener) != null) {
                onVisibility.onVisible(i10);
            }
            if (i10 == 0) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
                ofFloat.setDuration(200);
                ofFloat.start();
                show();
                delayHide();
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
            ofFloat2.setDuration(200);
            ofFloat2.addListener(new AlphaRelativeLayout$setVisibility$1(this));
            ofFloat2.start();
        }
    }

    public final void setVisibilityListener(OnVisibility onVisibility) {
        i.g(onVisibility, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = onVisibility;
    }

    public final void setVisibilitySwitch(boolean z10) {
        this.mVisibilitySwitch = z10;
    }
}
