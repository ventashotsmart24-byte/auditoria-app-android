package com.hpplay.sdk.source.api;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import com.hpplay.sdk.source.log.SourceLog;

public abstract class LelinkPresentation extends Presentation {
    private static final String TAG = "LelinkPresentation";
    public Activity mActivity;

    public LelinkPresentation(Context context, Display display) {
        super(context, display);
        this.mActivity = (Activity) context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDisplayRemoved() {
        super.onDisplayRemoved();
        this.mActivity = null;
        SourceLog.i(TAG, "------- onDisplayRemoved ---- ");
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

    public LelinkPresentation(Context context, Display display, int i10) {
        super(context, display, i10);
        this.mActivity = (Activity) context;
    }
}
