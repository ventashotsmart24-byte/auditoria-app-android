package com.hpplay.sdk.source.protocol;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import java.nio.ByteBuffer;

public class LelinkBridge extends AbsBridge {
    private static final String TAG = "LelinkBridge";
    private AbsBridge mLelinkBridge;
    private OutParameter mPlayInfo;

    public LelinkBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
        this.mPlayInfo = outParameter;
        if (outParameter.castType == 1) {
            this.mLelinkBridge = new LelinkPushBridge(this.mContext, outParameter);
        } else {
            this.mLelinkBridge = new LelinkMirrorBridge(this.mContext, outParameter);
        }
    }

    public void addVolume() {
        super.addVolume();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "addVolume ignore");
        } else {
            absBridge.addVolume();
        }
    }

    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "appendPlayList ignore");
        } else {
            absBridge.appendPlayList(str, dramaInfoBeanArr, i10, i11, i12);
        }
    }

    public void clearPlayList(String str) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "clearPlayList ignore");
        } else {
            absBridge.clearPlayList(str);
        }
    }

    public void frozen(boolean z10) {
        super.frozen(z10);
        this.mLelinkBridge.frozen(z10);
    }

    public void onAppPause() {
        super.onAppPause();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "onAppPause ignore 2");
        } else {
            absBridge.onAppPause();
        }
    }

    public void onAppResume() {
        super.onAppResume();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "onAppResume ignore 2");
        } else {
            absBridge.onAppResume();
        }
    }

    public void onCaptureStart(int i10) {
        super.onCaptureStart(i10);
        this.mLelinkBridge.onCaptureStart(i10);
    }

    public void onCaptureStop(int i10) {
        super.onCaptureStop(i10);
        this.mLelinkBridge.onCaptureStop(i10);
    }

    public void onInfo(int i10, String str) {
        super.onInfo(i10, str);
        this.mLelinkBridge.onInfo(i10, str);
    }

    public void pause(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "pause ignore");
            return;
        }
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "pause ignore 2");
        } else {
            absBridge.pause(str);
        }
    }

    public void play(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "play ignore");
            return;
        }
        SourceLog.i(TAG, "play");
        this.mLelinkBridge.play(str);
    }

    public void playDrama(String str, String str2) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "playDrama ignore");
        } else {
            absBridge.playDrama(str, str2);
        }
    }

    public void playNextDrama(String str) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "playNextDrama ignore");
        } else {
            absBridge.playNextDrama(str);
        }
    }

    public void playPreDrama(String str) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "playPreDrama ignore");
        } else {
            absBridge.playPreDrama(str);
        }
    }

    public void release() {
        this.mLelinkBridge.release();
    }

    public void resume(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "resume ignore");
            return;
        }
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "resume ignore 2");
        } else {
            absBridge.resume(str);
        }
    }

    public void screenshot(int i10) {
        super.screenshot(i10);
        this.mLelinkBridge.screenshot(i10);
    }

    public void seekTo(int i10) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "seekTo ignore");
            return;
        }
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "seekTo ignore 2");
        } else {
            absBridge.seekTo(i10);
        }
    }

    public void selectAudiotrack(int i10) {
        super.selectAudiotrack(i10);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "selectAudiotrack ignore");
        } else {
            absBridge.selectAudiotrack(i10);
        }
    }

    public void sendAudioData(byte[] bArr, int i10, int i11) {
        super.sendAudioData(bArr, i10, i11);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "sendAudioData ignore");
        } else {
            absBridge.sendAudioData(bArr, i10, i11);
        }
    }

    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
        super.sendVideoData(byteBuffer, i10, i11, i12, j10);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "sendVideoData ignore");
        } else {
            absBridge.sendVideoData(byteBuffer, i10, i11, i12, j10);
        }
    }

    public void setDataSource(OutParameter outParameter) {
        super.setDataSource(outParameter);
        this.mLelinkBridge.setDataSource(outParameter);
    }

    public void setExternalMirrorData() {
        super.setExternalMirrorData();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setExternalMirrorData ignore");
        } else {
            absBridge.setExternalMirrorData();
        }
    }

    public void setMirrorScreenSecret(boolean z10) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setMirrorScreenSecret ignore");
        } else {
            absBridge.setMirrorScreenSecret(z10);
        }
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        super.setOnCompletionListener(onCompletionListener);
        this.mLelinkBridge.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
        this.mLelinkBridge.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        super.setOnInfoListener(onInfoListener);
        this.mLelinkBridge.setOnInfoListener(onInfoListener);
    }

    public void setOnLoadingListener(OnLoadingListener onLoadingListener) {
        super.setOnLoadingListener(onLoadingListener);
        this.mLelinkBridge.setOnLoadingListener(onLoadingListener);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
        this.mLelinkBridge.setOnPreparedListener(onPreparedListener);
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        super.setOnStateChangeListener(onStateChangeListener);
        this.mLelinkBridge.setOnStateChangeListener(onStateChangeListener);
    }

    public void setOnStopListener(OnStopListener onStopListener) {
        super.setOnStopListener(onStopListener);
        this.mLelinkBridge.setOnStopListener(onStopListener);
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        super.setSecondMirrorView(secondMirrorView);
        this.mLelinkBridge.setSecondMirrorView(secondMirrorView);
    }

    public void setVolume(int i10) {
        super.setVolume(i10);
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setVolume ignore");
        } else {
            absBridge.setVolume(i10);
        }
    }

    public void setWatermarkVisible(boolean z10) {
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "setWatermarkInfo ignore");
        } else {
            absBridge.setWatermarkVisible(z10);
        }
    }

    public void stop(String str) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "stop ignore");
        } else if (this.mLelinkBridge == null) {
            SourceLog.w(TAG, "stop ignore 2");
        } else {
            SourceLog.w(TAG, "Lelinkbrideg stop ");
            this.mLelinkBridge.stop(str);
        }
    }

    public void subVolume() {
        super.subVolume();
        AbsBridge absBridge = this.mLelinkBridge;
        if (absBridge == null) {
            SourceLog.w(TAG, "subVolume ignore");
        } else {
            absBridge.subVolume();
        }
    }

    public boolean switchExpansionScreen(boolean z10) {
        if (this.mPlayInfo == null) {
            SourceLog.w(TAG, "switchExpansionScreen ignore");
            return false;
        }
        SourceLog.i(TAG, "switchExpansionScreen");
        return this.mLelinkBridge.switchExpansionScreen(z10);
    }
}
