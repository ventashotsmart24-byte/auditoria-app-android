package com.hpplay.sdk.source.exscreen;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import com.hpplay.sdk.source.log.SourceLog;

public class ExternalScreen extends Presentation {
    private static final String TAG = "ExternalScreen";
    public Activity mActivity;
    private IExternalScreenLifecycleListener mExternalScreenLifecycleListener;

    public interface IExternalScreenLifecycleListener {
        void onDestroy();

        void onResume();

        void onStop();
    }

    public ExternalScreen(Context context, Display display) {
        super(context, display);
        this.mActivity = (Activity) context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        if (isShowing()) {
            dismiss();
        }
        IExternalScreenLifecycleListener iExternalScreenLifecycleListener = this.mExternalScreenLifecycleListener;
        if (iExternalScreenLifecycleListener != null) {
            iExternalScreenLifecycleListener.onDestroy();
        }
    }

    public void onDisplayRemoved() {
        super.onDisplayRemoved();
        this.mActivity = null;
        SourceLog.i(TAG, "------- onDisplayRemoved ---- ");
    }

    public void onResume() {
        IExternalScreenLifecycleListener iExternalScreenLifecycleListener;
        Activity activity;
        if (!isShowing() && (activity = this.mActivity) != null && !activity.isFinishing() && !this.mActivity.isDestroyed()) {
            show();
        }
        if (Build.VERSION.SDK_INT < 26 && (iExternalScreenLifecycleListener = this.mExternalScreenLifecycleListener) != null) {
            iExternalScreenLifecycleListener.onResume();
        }
    }

    public void onStop() {
        if (Build.VERSION.SDK_INT < 26) {
            IExternalScreenLifecycleListener iExternalScreenLifecycleListener = this.mExternalScreenLifecycleListener;
            if (iExternalScreenLifecycleListener != null) {
                iExternalScreenLifecycleListener.onStop();
            }
            if (isShowing()) {
                dismiss();
            }
        }
    }

    public void setExternalScreenLifecycleListener(IExternalScreenLifecycleListener iExternalScreenLifecycleListener) {
        this.mExternalScreenLifecycleListener = iExternalScreenLifecycleListener;
    }

    public ExternalScreen(Context context, Display display, int i10) {
        super(context, display, i10);
        this.mActivity = (Activity) context;
    }
}
