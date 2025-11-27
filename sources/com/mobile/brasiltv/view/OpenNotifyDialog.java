package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import t9.i;

public final class OpenNotifyDialog extends Dialog {
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final NotificationListener mListener;

    public interface NotificationListener {
        void onOpen(Dialog dialog);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OpenNotifyDialog(Context context, NotificationListener notificationListener) {
        super(context, R.style.OptionDialog);
        i.g(context, "mContext");
        i.g(notificationListener, "mListener");
        this.mContext = context;
        this.mListener = notificationListener;
        setContentView(R.layout.dialog_open_notify);
        ((KoocanButton) findViewById(R$id.mKbTurnedOn)).setOnClickListener(new c0(this));
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new d0(this));
        setCanceledOnTouchOutside(false);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(OpenNotifyDialog openNotifyDialog, View view) {
        i.g(openNotifyDialog, "this$0");
        q5.i.f19305a.l(openNotifyDialog.getContext());
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(OpenNotifyDialog openNotifyDialog, View view) {
        i.g(openNotifyDialog, "this$0");
        openNotifyDialog.mListener.onOpen(openNotifyDialog);
        openNotifyDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onWindowFocusChanged$lambda$2(OpenNotifyDialog openNotifyDialog) {
        i.g(openNotifyDialog, "this$0");
        openNotifyDialog.mListener.onOpen(openNotifyDialog);
        openNotifyDialog.dismiss();
    }

    public void onBackPressed() {
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10 && q5.i.f19305a.j(this.mContext)) {
            this.mHandler.postDelayed(new b0(this), 600);
        }
    }
}
