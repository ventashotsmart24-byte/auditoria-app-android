package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

public final class LoadingView extends Dialog {
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ LoadingView create$default(Companion companion, Context context, boolean z10, boolean z11, DialogInterface.OnDismissListener onDismissListener, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            if ((i10 & 4) != 0) {
                z11 = true;
            }
            if ((i10 & 8) != 0) {
                onDismissListener = null;
            }
            return companion.create(context, z10, z11, onDismissListener);
        }

        public final LoadingView create(Context context, boolean z10, boolean z11, DialogInterface.OnDismissListener onDismissListener) {
            i.g(context, f.X);
            return new LoadingView(context, z10, z11, onDismissListener);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingView(Context context, boolean z10, boolean z11, DialogInterface.OnDismissListener onDismissListener) {
        super(context, R.style.OptionDialog);
        WindowManager.LayoutParams layoutParams;
        i.g(context, f.X);
        setContentView(R.layout.layout_loading_view);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.dimAmount = 0.5f;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        setCanceledOnTouchOutside(z10);
        setCancelable(z11);
        if (onDismissListener != null) {
            setOnDismissListener(onDismissListener);
        }
    }
}
