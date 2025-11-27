package com.mobile.brasiltv.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.umeng.analytics.pro.q;
import com.zhy.autolayout.utils.AutoUtils;
import t9.g;
import t9.i;

public abstract class CommonDialog extends Dialog {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonDialog(Context context, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? R.style.OptionDialog : i10);
    }

    public final void fullScreenImmersive(View view) {
        if (view != null) {
            view.setSystemUiVisibility(5894);
        }
    }

    public abstract int getDialogHeight();

    public abstract int getDialogWidth();

    public int getGravity() {
        return 17;
    }

    public abstract int getLayoutId();

    public final void hideBottomUI(Activity activity) {
        View view;
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            view = null;
        } else {
            view = window.getDecorView();
        }
        if (view != null) {
            view.setSystemUiVisibility(q.a.f14394g);
        }
    }

    public abstract void initListener();

    public abstract void initView();

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView(getLayoutId());
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = getGravity();
            if (getDialogWidth() >= 0) {
                layoutParams.width = AutoUtils.getPercentWidthSize(getDialogWidth());
            } else {
                layoutParams.width = getDialogWidth();
            }
            if (getDialogHeight() >= 0) {
                layoutParams.height = AutoUtils.getPercentWidthSize(getDialogHeight());
            } else {
                layoutParams.height = getDialogHeight();
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        initView();
        initListener();
    }

    public void show() {
        View view;
        if (supportFSImmersive()) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(8);
            }
            super.show();
            Window window2 = getWindow();
            if (window2 != null) {
                view = window2.getDecorView();
            } else {
                view = null;
            }
            fullScreenImmersive(view);
            Window window3 = getWindow();
            if (window3 != null) {
                window3.clearFlags(8);
                return;
            }
            return;
        }
        super.show();
    }

    public boolean supportFSImmersive() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context, int i10) {
        super(context, i10);
        i.g(context, f.X);
    }
}
