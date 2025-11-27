package com.hpplay.sdk.source.api;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.KeyEvent;
import com.hpplay.sdk.source.exscreen.ExternalScreen;
import com.hpplay.sdk.source.log.SourceLog;

public abstract class LelinkExternalScreen extends ExternalScreen {
    private static final String TAG = "LelinkExternalScreen";

    public LelinkExternalScreen(Context context, Display display) {
        super(context, display);
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public void onDestroy() {
        super.onDestroy();
        SourceLog.i(TAG, "LelinkExternalScreen onDestroy");
    }

    public abstract void onKeyBack();

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        SourceLog.i(TAG, "onKeyDown = " + i10);
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        onKeyBack();
        return true;
    }

    public void onResume() {
        super.onResume();
        SourceLog.i(TAG, "LelinkExternalScreen onResume");
    }

    public void onStop() {
        super.onStop();
        SourceLog.i(TAG, "LelinkExternalScreen onStop");
    }

    public LelinkExternalScreen(Context context, Display display, int i10) {
        super(context, display, i10);
    }
}
