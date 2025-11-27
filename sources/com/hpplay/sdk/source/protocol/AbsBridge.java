package com.hpplay.sdk.source.protocol;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.player.ICastPlayer;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import java.nio.ByteBuffer;

public abstract class AbsBridge implements IBridge {
    public static final int INFO_CODE_RESOLUTION_CHANGED = 10;
    protected boolean isAppResume = true;
    protected OnCompletionListener mCompletionListener;
    protected Context mContext;
    protected OnErrorListener mErrorListener;
    protected OnInfoListener mInfoListener;
    protected OnLoadingListener mLoadingListener;
    protected OutParameter mPlayInfo;
    protected OnPreparedListener mPreparedListener;
    protected OnStateChangeListener mStateChangeListener;
    protected OnStopListener mStopListener;

    public AbsBridge(Context context, OutParameter outParameter) {
        this.mContext = context;
        this.mPlayInfo = outParameter;
    }

    public void addVolume() {
    }

    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
    }

    public void clearPlayList(String str) {
    }

    public void frozen(boolean z10) {
    }

    public void onAppPause() {
        this.isAppResume = false;
    }

    public void onAppResume() {
        this.isAppResume = true;
    }

    public void onCaptureStart(int i10) {
    }

    public void onCaptureStop(int i10) {
    }

    public void onInfo(int i10, String str) {
        OnInfoListener onInfoListener;
        if (i10 == 120105112) {
            OnErrorListener onErrorListener = this.mErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError((ICastPlayer) null, PlayerListenerConstant.MIRROR_ERROR_CODEC, i10, str);
            }
            if (Preference.getInstance().get(Preference.KEY_ENCODE_ERROR_EXIT_MIRROR, true)) {
                try {
                    SourceLog.i("absBridge", " mirror encode error call stop");
                    stop(this.mPlayInfo.getKey());
                } catch (Exception e10) {
                    SourceLog.w("absBridge", (Throwable) e10);
                }
            }
        }
        if (i10 == 10 && (onInfoListener = this.mInfoListener) != null) {
            onInfoListener.onInfo((ICastPlayer) null, PlayerListenerConstant.MIRROR_INFO_CODE, str);
        }
    }

    public void playDrama(String str, String str2) {
    }

    public void playNextDrama(String str) {
    }

    public void playPreDrama(String str) {
    }

    public abstract void release();

    public void screenshot(int i10) {
    }

    public void selectAudiotrack(int i10) {
    }

    public void sendAudioData(byte[] bArr, int i10, int i11) {
    }

    public void sendVideoData(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
    }

    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
    }

    public void setExternalMirrorData() {
    }

    public void setMirrorScreenSecret(boolean z10) {
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mErrorListener = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mInfoListener = onInfoListener;
    }

    public void setOnLoadingListener(OnLoadingListener onLoadingListener) {
        this.mLoadingListener = onLoadingListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mPreparedListener = onPreparedListener;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mStateChangeListener = onStateChangeListener;
    }

    public void setOnStopListener(OnStopListener onStopListener) {
        this.mStopListener = onStopListener;
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
    }

    public void setVolume(int i10) {
    }

    public void setWatermarkVisible(boolean z10) {
    }

    public void subVolume() {
    }

    public boolean switchExpansionScreen(boolean z10) {
        return false;
    }
}
