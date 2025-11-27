package com.hpplay.sdk.source.player;

import android.content.Context;
import android.os.Build;
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
import com.hpplay.sdk.source.protocol.CaptureBridge;

public class CastPlayer implements ICastPlayer {
    private static final String TAG = "CastPlayer";
    private Context mContext;
    private OutParameter mPlayInfo;
    private ICastPlayer mProtocolPlayer;

    public CastPlayer(Context context, OutParameter outParameter) {
        this.mContext = context;
        this.mPlayInfo = outParameter;
        initPlayer(outParameter);
    }

    private void initPlayer(OutParameter outParameter) {
        int i10;
        if (outParameter.currentBrowserInfo == null || outParameter.connectProtocol == -1) {
            SourceLog.w(TAG, "initPlayer ignore invalid service info");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initPlayer: protocol: ");
        sb.append(outParameter.protocol);
        sb.append(" group:");
        sb.append(outParameter.isGroup);
        sb.append("  ");
        sb.append(outParameter.connectProtocol);
        if (!outParameter.isGroup || (i10 = outParameter.connectProtocol) == 1 || i10 == 5) {
            if (Build.VERSION.SDK_INT >= 21) {
                CaptureBridge.getInstance().setICaptureDispatcher((CaptureBridge.ICaptureDispatcher) null);
            }
            int i11 = outParameter.protocol;
            if (i11 != 1) {
                if (i11 == 3) {
                    this.mProtocolPlayer = new DLNAPlayer(this.mContext, outParameter);
                    return;
                } else if (i11 != 4) {
                    if (i11 != 5) {
                        SourceLog.w(TAG, "initPlayer ignore invalid protocol");
                        return;
                    }
                } else if (outParameter.castType == 1) {
                    this.mProtocolPlayer = new CloudPlayer(this.mContext, this.mPlayInfo);
                    return;
                } else {
                    this.mProtocolPlayer = new YimPlayer(this.mContext, this.mPlayInfo);
                    return;
                }
            }
            this.mProtocolPlayer = new LelinkPlayer(this.mContext, outParameter);
            return;
        }
        this.mProtocolPlayer = new GroupPlayer(this.mContext, outParameter);
    }

    public void addVolume() {
        this.mProtocolPlayer.addVolume();
    }

    public boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        return this.mProtocolPlayer.appendPlayList(str, dramaInfoBeanArr, i10, i11, i12);
    }

    public boolean clearPlayList(String str) {
        return this.mProtocolPlayer.clearPlayList(str);
    }

    public void doChangeChannel(int i10) {
        ICastPlayer iCastPlayer = this.mProtocolPlayer;
        if (iCastPlayer instanceof GroupPlayer) {
            ((GroupPlayer) iCastPlayer).doChangeChannel(i10);
        }
    }

    public ICastPlayer getMediaPlayer() {
        return this.mProtocolPlayer;
    }

    public void onAppPause() {
        this.mProtocolPlayer.onAppPause();
    }

    public void onAppResume() {
        this.mProtocolPlayer.onAppResume();
    }

    public void onWifiConnected() {
        ICastPlayer iCastPlayer = this.mProtocolPlayer;
        if (iCastPlayer instanceof GroupPlayer) {
            ((GroupPlayer) iCastPlayer).onWifiConnected();
        }
    }

    public boolean pause(String str) {
        return this.mProtocolPlayer.pause(str);
    }

    public boolean playDrama(String str, String str2) {
        return this.mProtocolPlayer.playDrama(str, str2);
    }

    public boolean playNextDrama(String str) {
        return this.mProtocolPlayer.playNextDrama(str);
    }

    public boolean playPreDrama(String str) {
        return this.mProtocolPlayer.playPreDrama(str);
    }

    public void release(String str) {
        this.mProtocolPlayer.release(str);
    }

    public boolean resume(String str) {
        return this.mProtocolPlayer.resume(str);
    }

    public boolean seekTo(String str, int i10) {
        return this.mProtocolPlayer.seekTo(str, i10);
    }

    public void selectAudiotrack(int i10) {
        this.mProtocolPlayer.selectAudiotrack(i10);
    }

    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
        this.mProtocolPlayer.setDataSource(outParameter);
    }

    public void setMirrorScreenSecret(boolean z10) {
        this.mProtocolPlayer.setMirrorScreenSecret(z10);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mProtocolPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mProtocolPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mProtocolPlayer.setOnInfoListener(onInfoListener);
    }

    public void setOnLoadingListener(OnLoadingListener onLoadingListener) {
        this.mProtocolPlayer.setOnLoadingListener(onLoadingListener);
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mProtocolPlayer.setOnPreparedListener(onPreparedListener);
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mProtocolPlayer.setOnStateChangeListener(onStateChangeListener);
    }

    public void setOnStopListener(OnStopListener onStopListener) {
        this.mProtocolPlayer.setOnStopListener(onStopListener);
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mProtocolPlayer.setSecondMirrorView(secondMirrorView);
    }

    public void setVolume(int i10) {
        this.mProtocolPlayer.setVolume(i10);
    }

    public void setWatermarkVisible(boolean z10) {
        this.mProtocolPlayer.setWatermarkVisible(z10);
    }

    public boolean start(String str) {
        return this.mProtocolPlayer.start(str);
    }

    public void stop(String str) {
        SourceLog.i(TAG, "cast player stop ");
        this.mProtocolPlayer.stop(str);
    }

    public void subVolume() {
        this.mProtocolPlayer.subVolume();
    }

    public boolean switchExpansionScreen(boolean z10) {
        return this.mProtocolPlayer.switchExpansionScreen(z10);
    }
}
