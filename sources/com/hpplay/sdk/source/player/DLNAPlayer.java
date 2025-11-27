package com.hpplay.sdk.source.player;

import android.content.Context;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.protocol.AbsBridge;
import com.hpplay.sdk.source.protocol.DLNABridge;

public class DLNAPlayer extends AbsPlayer {
    private static final String TAG = "DLNAPlayer";

    public DLNAPlayer(Context context, OutParameter outParameter) {
        super(context);
        this.mBridge = new DLNABridge(context, outParameter);
        initListener();
    }

    public void onAppPause() {
        AbsBridge absBridge = this.mBridge;
        if (absBridge != null) {
            absBridge.onAppPause();
        }
    }

    public void onAppResume() {
        AbsBridge absBridge = this.mBridge;
        if (absBridge != null) {
            absBridge.onAppResume();
        }
    }

    public boolean pause(String str) {
        this.mBridge.pause(str);
        return true;
    }

    public void release(String str) {
        this.mBridge.release();
        removeListener();
    }

    public boolean resume(String str) {
        this.mBridge.resume(str);
        return true;
    }

    public boolean seekTo(String str, int i10) {
        this.mBridge.seekTo(i10);
        return true;
    }

    public boolean start(String str) {
        this.mBridge.play(str);
        return true;
    }

    public void stop(String str) {
        this.mBridge.stop(str);
    }
}
