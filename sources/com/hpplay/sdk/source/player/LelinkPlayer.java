package com.hpplay.sdk.source.player;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.AbsBridge;
import com.hpplay.sdk.source.protocol.LelinkBridge;

public class LelinkPlayer extends AbsPlayer {
    private static final String TAG = "LelinkPlayer";

    public LelinkPlayer(Context context, OutParameter outParameter) {
        super(context);
        this.mBridge = new LelinkBridge(context, outParameter);
        initListener();
    }

    public boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        this.mBridge.appendPlayList(str, dramaInfoBeanArr, i10, i11, i12);
        return true;
    }

    public boolean clearPlayList(String str) {
        this.mBridge.clearPlayList(str);
        return true;
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

    public boolean playDrama(String str, String str2) {
        this.mBridge.playDrama(str, str2);
        return true;
    }

    public boolean playNextDrama(String str) {
        this.mBridge.playNextDrama(str);
        return true;
    }

    public boolean playPreDrama(String str) {
        this.mBridge.playPreDrama(str);
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

    public void setMirrorScreenSecret(boolean z10) {
        this.mBridge.setMirrorScreenSecret(z10);
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mBridge.setSecondMirrorView(secondMirrorView);
    }

    public void setWatermarkVisible(boolean z10) {
        this.mBridge.setWatermarkVisible(z10);
    }

    public boolean start(String str) {
        this.mCurrentState = 1;
        this.mBridge.play(str);
        return true;
    }

    public void stop(String str) {
        SourceLog.w(TAG, "Lelink play  stop ");
        this.mBridge.stop(str);
    }

    public boolean switchExpansionScreen(boolean z10) {
        return this.mBridge.switchExpansionScreen(z10);
    }
}
