package com.hpplay.sdk.source.exscreen.api;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import com.hpplay.sdk.source.api.IExternalScreenListener;
import com.hpplay.sdk.source.api.LelinkExternalScreen;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;

@Deprecated
public abstract class ExScreenMirrorActivity extends Activity implements IExternalScreenListener {
    private static final String TAG = "ExScreenMirrorActivity";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public LelinkExternalScreen onCreateScreen(int i10, Display display) {
        return onStartBuildExternalScreen(i10, display);
    }

    public void onDestroy() {
        SourceLog.i(TAG, "onDestroy");
        super.onDestroy();
    }

    public void onResume() {
        SourceLog.i(TAG, "onResume");
        super.onResume();
    }

    public abstract LelinkExternalScreen onStartBuildExternalScreen(int i10, Display display);

    public void onStop() {
        SourceLog.i(TAG, "onStop");
        super.onStop();
    }

    public void startExternalMirror(LelinkServiceInfo lelinkServiceInfo, boolean z10, boolean z11, int i10, int i11) {
    }
}
