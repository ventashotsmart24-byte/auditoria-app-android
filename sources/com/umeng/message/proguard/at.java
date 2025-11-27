package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushInAppMessageCallback;
import com.umeng.message.common.UPLog;

public final class at extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View.OnClickListener f15427a;

    /* renamed from: b  reason: collision with root package name */
    private final ap f15428b;

    public at(Context context, ap apVar) {
        super(context);
        setLayerType(1, (Paint) null);
        this.f15428b = apVar;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean bool;
        if (this.f15427a != null) {
            if (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                View.OnClickListener onClickListener = this.f15427a;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            UPLog.i("Pop", "attach", this.f15428b.f15401a.getMsgId());
            UTrack.getInstance().trackInAppNotifyShow(this.f15428b.f15401a);
            UPushInAppMessageCallback inAppMessageCallback = v.a().getInAppMessageCallback();
            if (inAppMessageCallback != null) {
                inAppMessageCallback.onShow(y.a(), this.f15428b.f15401a);
            }
        } catch (Throwable th) {
            UPLog.e("Pop", "onAttachedToWindow", th);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            UPLog.i("Pop", "detach", this.f15428b.f15401a.getMsgId());
            UPushInAppMessageCallback inAppMessageCallback = v.a().getInAppMessageCallback();
            if (inAppMessageCallback != null) {
                inAppMessageCallback.onDismiss(y.a(), this.f15428b.f15401a);
            }
        } catch (Throwable th) {
            UPLog.e("Pop", "onDetachedFromWindow", th);
        }
    }

    public final void setDismissListener(View.OnClickListener onClickListener) {
        this.f15427a = onClickListener;
    }
}
