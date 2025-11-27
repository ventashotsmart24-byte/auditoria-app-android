package com.hpplay.sdk.source.business;

import android.content.Context;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.HistoryDeviceManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.da.e;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.player.CastPlayer;
import com.hpplay.sdk.source.player.ICastPlayer;
import com.hpplay.sdk.source.player.IPlayer;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.player.listener.OnStopListener;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.hpplay.sdk.source.utils.Feature;
import com.raizlabs.android.dbflow.sql.language.Operator;

public class PlayController implements IPlayer {
    private static final String TAG = "PlayController";
    /* access modifiers changed from: private */
    public boolean disconnectFromUser = false;
    private boolean isReleased = false;
    private boolean isReportStop = false;
    private boolean isStopped = false;
    private CastPlayer mCastPlayer;
    private final OnCompletionListener mCompletionListener = new OnCompletionListener() {
        public void onComplete(ICastPlayer iCastPlayer) {
            SourceLog.i(PlayController.TAG, "onComplete current:" + PlayController.this.mCurrentState);
            if (PlayController.this.mLelinkPlayerListener == null || PlayController.this.mCurrentState == 0) {
                int unused = PlayController.this.mCurrentState = 0;
                if (PlayController.this.mLelinkPlayerListener != null) {
                    PlayController.this.mLelinkPlayerListener.onStop(PlayController.this.mPlayInfo);
                }
            } else {
                int unused2 = PlayController.this.mCurrentState = 0;
                PlayController.this.mLelinkPlayerListener.onCompletion(PlayController.this.mPlayInfo, 0);
            }
            if (PlayController.this.mStopType <= 0) {
                int unused3 = PlayController.this.mStopType = 1002;
            }
            PlayController.this.reportStop();
            PlayController.this.pushAfterDa();
        }
    };
    private Context mContext;
    /* access modifiers changed from: private */
    public int mCurrentState = -1;
    /* access modifiers changed from: private */
    public long mDuration = -1;
    private final OnErrorListener mErrorListener = new OnErrorListener() {
        public void onError(ICastPlayer iCastPlayer, int i10, int i11, String str) {
            int i12 = i10;
            int i13 = i11;
            SourceLog.i(PlayController.TAG, "onError " + i12 + Operator.Operation.DIVISION + i13);
            if (PlayController.this.retry(i12, i13)) {
                boolean unused = PlayController.this.retry = true;
                PlayController.this.reopen();
                return;
            }
            if (i13 != 211026) {
                SourceDataReport.getInstance().onCastFailed(PlayController.this.mPlayInfo, "", "", PlayController.this.retry, str);
                ConnectManager.getInstance().notifyCastError(PlayController.this.mPlayInfo.serviceInfo);
            } else if (PlayController.this.mPlayInfo.castType == 1) {
                SourceDataReport.getInstance().onCastFailed(PlayController.this.mPlayInfo, ErrorCode.PUSH_NEED_SCREEN_CODE, "", PlayController.this.retry, str);
            } else {
                SourceDataReport.getInstance().onCastFailed(PlayController.this.mPlayInfo, ErrorCode.MIRROR_NEED_SCREEN_CODE, "", PlayController.this.retry, str);
            }
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onError(PlayController.this.mPlayInfo, i12, i13, str);
            }
            PlayController.this.pushAfterDa();
        }
    };
    private final OnInfoListener mInfoListener = new OnInfoListener() {
        public void onInfo(ICastPlayer iCastPlayer, int i10, int i11, int i12) {
            if (i10 != 100) {
                SourceLog.i(PlayController.TAG, "onInfo " + i11 + Operator.Operation.DIVISION + i12);
                return;
            }
            SourceLog.i(PlayController.TAG, "onPositionUpdate duration:" + i11 + Operator.Operation.DIVISION + i12);
            PlayController playController = PlayController.this;
            long j10 = (long) i12;
            long unused = playController.mPlayedDuration = Math.max(playController.mPlayedDuration, j10);
            long j11 = (long) i11;
            long unused2 = PlayController.this.mDuration = j11;
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onPositionUpdate(PlayController.this.mPlayInfo, j11, j10);
            }
            ConnectManager.getInstance().notifyCastStatusValid(PlayController.this.mPlayInfo.serviceInfo);
        }

        public void onInfo(ICastPlayer iCastPlayer, int i10, String str) {
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onInfo(PlayController.this.mPlayInfo, i10, str);
            }
        }
    };
    /* access modifiers changed from: private */
    public LelinkPlayerListenerDispatcher mLelinkPlayerListener;
    private OnLoadingListener mLoadingListener = new OnLoadingListener() {
        public void onLoading(ICastPlayer iCastPlayer, String str) {
            SourceLog.i(PlayController.TAG, "onLoading " + PlayController.this + " reportExtra:  " + str);
            SourceDataReport.getInstance().onCastSuccess(PlayController.this.mPlayInfo, PlayController.this.retry, str);
            if (PlayController.this.mPlayInfo != null) {
                int i10 = PlayController.this.mPlayInfo.castType;
                if (i10 != 1) {
                    if (i10 == 2) {
                        int unused = PlayController.this.mCurrentState = 1;
                    }
                } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                    int unused2 = PlayController.this.mCurrentState = 2;
                } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                    int unused3 = PlayController.this.mCurrentState = 3;
                } else if (PlayController.this.mPlayInfo.mimeType == 103) {
                    int unused4 = PlayController.this.mCurrentState = 4;
                }
                ConnectManager.getInstance().notifyCastSuccess(PlayController.this.mPlayInfo.serviceInfo);
                HistoryDeviceManager.getInstance().addHistoryDevice(PlayController.this.mPlayInfo.serviceInfo);
            }
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onLoading(PlayController.this.mPlayInfo);
            }
        }
    };
    /* access modifiers changed from: private */
    public OutParameter mPlayInfo;
    /* access modifiers changed from: private */
    public long mPlayedDuration = -1;
    private OnPreparedListener mPreparedListener = new OnPreparedListener() {
        public void onPrepared(ICastPlayer iCastPlayer) {
            SourceLog.i(PlayController.TAG, "onPrepared, " + PlayController.this);
            int i10 = PlayController.this.mPlayInfo.castType;
            if (i10 != 1) {
                if (i10 == 2) {
                    int unused = PlayController.this.mCurrentState = 5;
                }
            } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                int unused2 = PlayController.this.mCurrentState = 6;
            } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                int unused3 = PlayController.this.mCurrentState = 7;
            } else if (PlayController.this.mPlayInfo.mimeType == 103) {
                int unused4 = PlayController.this.mCurrentState = 8;
            }
            SourceDataReport.getInstance().onCastRender(PlayController.this.mPlayInfo);
            if (PlayController.this.mLelinkPlayerListener != null) {
                PlayController.this.mLelinkPlayerListener.onStart(PlayController.this.mPlayInfo);
            }
            ConnectManager.getInstance().notifyCastSuccess(PlayController.this.mPlayInfo.serviceInfo);
            if (PlayController.this.mPlayInfo.pushType == 1) {
                e.d().a(PlayController.this.mPlayInfo);
            }
        }
    };
    private String mReportStopDramaId = null;
    private OnStateChangeListener mStateChangeListener = new OnStateChangeListener() {
        public void onStateChanged(ICastPlayer iCastPlayer, int i10) {
            if (PlayController.this.mCurrentState == i10) {
                SourceLog.i(PlayController.TAG, "onStateChanged ignore " + PlayController.this.mCurrentState + Operator.Operation.DIVISION + i10);
                return;
            }
            SourceLog.i(PlayController.TAG, "onStateChanged " + i10 + Operator.Operation.DIVISION + PlayController.this.mCurrentState + ", " + PlayController.this);
            if (PlayController.this.mLelinkPlayerListener == null) {
                return;
            }
            if (i10 == 3) {
                if (PlayController.this.disconnectFromUser && !ConnectManager.getInstance().isConnected(PlayController.this.mPlayInfo)) {
                    SourceLog.i(PlayController.TAG, "onStateChanged stop disconnectFromUser");
                    PlayController.this.stop((int) Constant.STOP_USER_DISCONNECT);
                }
                int i11 = PlayController.this.mPlayInfo.castType;
                if (i11 != 1) {
                    if (i11 == 2) {
                        if (PlayController.this.mCurrentState != 5) {
                            int unused = PlayController.this.mCurrentState = 5;
                        } else {
                            return;
                        }
                    }
                } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                    int unused2 = PlayController.this.mCurrentState = 6;
                } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                    int unused3 = PlayController.this.mCurrentState = 7;
                } else if (PlayController.this.mPlayInfo.mimeType == 103) {
                    int unused4 = PlayController.this.mCurrentState = 8;
                }
                PlayController.this.mLelinkPlayerListener.onStart(PlayController.this.mPlayInfo);
                return;
            }
            int i12 = PlayController.this.mPlayInfo.castType;
            if (i12 != 1) {
                if (i12 == 2) {
                    int unused5 = PlayController.this.mCurrentState = 11;
                }
            } else if (PlayController.this.mPlayInfo.mimeType == 102) {
                int unused6 = PlayController.this.mCurrentState = 9;
            } else if (PlayController.this.mPlayInfo.mimeType == 101) {
                int unused7 = PlayController.this.mCurrentState = 10;
            }
            PlayController.this.mLelinkPlayerListener.onPause(PlayController.this.mPlayInfo);
        }
    };
    private final OnStopListener mStopListener = new OnStopListener() {
        public void onStop(ICastPlayer iCastPlayer, StopInfo stopInfo) {
            SourceLog.i(PlayController.TAG, "onStop current:" + PlayController.this.mCurrentState);
            if (PlayController.this.mStopType <= 0) {
                int unused = PlayController.this.mStopType = Constant.STOP_FROM_SINK;
            }
            if (PlayController.this.mLelinkPlayerListener == null || PlayController.this.mCurrentState == 0) {
                int unused2 = PlayController.this.mCurrentState = 0;
                if (PlayController.this.mLelinkPlayerListener != null) {
                    PlayController.this.mLelinkPlayerListener.onStop(PlayController.this.mPlayInfo);
                }
            } else {
                int unused3 = PlayController.this.mCurrentState = 0;
                if (stopInfo == null || stopInfo.type != 3) {
                    PlayController.this.mLelinkPlayerListener.onStop(PlayController.this.mPlayInfo);
                } else {
                    if (PlayController.this.mStopType <= 0) {
                        int unused4 = PlayController.this.mStopType = 1002;
                    }
                    PlayController.this.mLelinkPlayerListener.onCompletion(PlayController.this.mPlayInfo, 1);
                }
            }
            PlayController.this.reportStop();
            if (PlayController.this.mStopType == 1003 && stopInfo != null && stopInfo.type != 4) {
                PlayController.this.pushAfterDa();
            }
        }
    };
    /* access modifiers changed from: private */
    public int mStopType = 0;
    /* access modifiers changed from: private */
    public boolean retry = false;

    public PlayController(Context context, OutParameter outParameter) {
        SourceLog.i(TAG, "init:" + this + "," + outParameter.serviceInfo.getUid());
        this.mContext = context;
        this.mPlayInfo = outParameter;
        initPlayer();
    }

    private void initPlayer() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer != null) {
            castPlayer.release(this.mPlayInfo.getKey());
            this.mCastPlayer = null;
        }
        CastPlayer castPlayer2 = new CastPlayer(this.mContext, this.mPlayInfo);
        this.mCastPlayer = castPlayer2;
        castPlayer2.setOnLoadingListener(this.mLoadingListener);
        this.mCastPlayer.setOnPreparedListener(this.mPreparedListener);
        this.mCastPlayer.setOnStateChangeListener(this.mStateChangeListener);
        this.mCastPlayer.setOnInfoListener(this.mInfoListener);
        this.mCastPlayer.setOnErrorListener(this.mErrorListener);
        this.mCastPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mCastPlayer.setOnStopListener(this.mStopListener);
    }

    /* access modifiers changed from: private */
    public void pushAfterDa() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null && outParameter.pushType == 1) {
            e.d().b(this.mContext);
        }
    }

    /* access modifiers changed from: private */
    public void reportStop() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null && outParameter.urls != null) {
            String str = this.mReportStopDramaId;
            if (str == null || !str.equals(outParameter.dramaID)) {
                this.mReportStopDramaId = this.mPlayInfo.dramaID;
            } else {
                return;
            }
        } else if (!this.isReportStop) {
            this.isReportStop = true;
        } else {
            return;
        }
        if (this.mPlayInfo != null) {
            SourceDataReport.getInstance().onCastStop(this.mPlayInfo, this.mStopType);
            if (this.mPlayInfo.pushType == 1) {
                long j10 = this.mPlayedDuration;
                if (this.mStopType == 1002) {
                    j10 = Math.max(j10, this.mDuration);
                }
                e.d().a(this.mPlayInfo, j10);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean retry(int i10, int i11) {
        if (!(this.isStopped || this.isReleased || i11 == 211026 || i11 == 211001 || i11 == 211002 || i11 == 211055)) {
            BrowserInfo browserInfo = CastUtil.getBrowserInfo(this.mPlayInfo.serviceInfo, 3);
            BrowserInfo browserInfo2 = CastUtil.getBrowserInfo(this.mPlayInfo.serviceInfo, 4);
            OutParameter outParameter = this.mPlayInfo;
            if (outParameter.castType != 2) {
                int i12 = outParameter.protocol;
                if (i12 != 1) {
                    if (i12 != 3 || browserInfo2 == null) {
                        return false;
                    }
                    outParameter.protocol = 4;
                    outParameter.currentBrowserInfo = browserInfo2;
                    SourceLog.i(TAG, "retry with im");
                    return true;
                } else if (browserInfo != null) {
                    outParameter.protocol = 3;
                    outParameter.currentBrowserInfo = browserInfo;
                    SourceLog.i(TAG, "retry with dlna");
                    return true;
                } else if (browserInfo2 != null) {
                    outParameter.protocol = 4;
                    outParameter.currentBrowserInfo = browserInfo2;
                    SourceLog.i(TAG, "retry with im");
                    return true;
                }
            } else if (outParameter.protocol != 1 || outParameter.connectProtocol != 4 || browserInfo2 == null || (!Feature.isLeboApp() && !Feature.isHappyTest())) {
                return false;
            } else {
                OutParameter outParameter2 = this.mPlayInfo;
                outParameter2.protocol = 4;
                outParameter2.currentBrowserInfo = browserInfo2;
                SourceLog.i(TAG, "retry with im");
                return true;
            }
        }
        return false;
    }

    public void addVolume() {
        if (!isInPlaybackState()) {
            SourceLog.w(TAG, "addVolume ignore " + this.mCurrentState);
            return;
        }
        this.mCastPlayer.addVolume();
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "setPlayList ignore " + this.mCurrentState);
            return;
        }
        appendPlayList(outParameter.getKey(), dramaInfoBeanArr, i10, i11, i12);
    }

    public void clearPlayList() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "clearPlayList ignore " + this.mCurrentState);
            return;
        }
        clearPlayList(outParameter.getKey());
    }

    public void doChangeChannel(int i10) {
        this.mCastPlayer.doChangeChannel(i10);
    }

    public int getCurrentPlayState() {
        SourceLog.w(TAG, "getCurrentPlayState " + this.mCurrentState);
        return this.mCurrentState;
    }

    public ICastPlayer getMediaPlayer() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer == null) {
            return null;
        }
        return castPlayer.getMediaPlayer();
    }

    public OutParameter getPlayInfo() {
        return this.mPlayInfo;
    }

    public boolean isInPlaybackState() {
        if (this.mCastPlayer == null || this.mCurrentState == 0) {
            return false;
        }
        return true;
    }

    public void onAppPause() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer != null) {
            castPlayer.onAppPause();
        }
    }

    public void onAppResume() {
        CastPlayer castPlayer = this.mCastPlayer;
        if (castPlayer != null) {
            castPlayer.onAppResume();
        }
    }

    public void onWifiConnected() {
        this.mCastPlayer.onWifiConnected();
    }

    public void pause() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "pause ignore " + this.mCurrentState);
        } else if (outParameter.pushType == 1) {
            SourceLog.w(TAG, "pause ignore, da cannot seek");
        } else {
            pause(outParameter.getKey());
        }
    }

    public void playDrama(String str) {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "playDrama ignore " + this.mCurrentState);
            return;
        }
        playDrama(outParameter.getKey(), str);
    }

    public void playNextDrama() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "playNextDrama ignore " + this.mCurrentState);
            return;
        }
        playNextDrama(outParameter.getKey());
    }

    public void playPreDrama() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "playPreDrama ignore " + this.mCurrentState);
            return;
        }
        playPreDrama(outParameter.getKey());
    }

    public void release() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter != null) {
            release(outParameter.getKey());
        }
    }

    public void reopen() {
        SourceLog.i(TAG, "reopen");
        initPlayer();
        setDataSource(this.mPlayInfo);
        start();
    }

    public void resume() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "pause ignore " + this.mCurrentState);
            return;
        }
        resume(outParameter.getKey());
    }

    public void seekTo(int i10) {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "seekTo ignore");
        } else if (outParameter.pushType == 1) {
            SourceLog.w(TAG, "seekTo ignore, da cannot seek");
        } else if (!isInPlaybackState()) {
            SourceLog.w(TAG, "seekTo ignore 2: " + this.mCurrentState);
        } else {
            seekTo(this.mPlayInfo.getKey(), i10);
        }
    }

    public void selectAudiotrack(int i10) {
        if (!isInPlaybackState()) {
            SourceLog.w(TAG, "selectAudiotrack ignore " + this.mCurrentState);
            return;
        }
        this.mCastPlayer.selectAudiotrack(i10);
    }

    public void setDataSource(OutParameter outParameter, int i10) {
        setDataSource(outParameter);
        SourceLog.i(TAG, " setDataSource    " + outParameter.urlID + "  " + outParameter.session);
        SourceDataReport.getInstance().onCastStart(outParameter, i10);
    }

    public void setLelinkPlayerListener(LelinkPlayerListenerDispatcher lelinkPlayerListenerDispatcher) {
        this.mLelinkPlayerListener = lelinkPlayerListenerDispatcher;
    }

    public void setMirrorScreenSecret(boolean z10) {
        this.mCastPlayer.setMirrorScreenSecret(z10);
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        this.mCastPlayer.setSecondMirrorView(secondMirrorView);
    }

    public void setStopType(int i10) {
        if (this.mStopType <= 0) {
            this.mStopType = i10;
        }
    }

    @Deprecated
    public void setVolume(int i10) {
        this.mCastPlayer.setVolume(i10);
    }

    public void setWatermarkVisible(boolean z10) {
        this.mCastPlayer.setWatermarkVisible(z10);
    }

    public void start() {
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter == null) {
            SourceLog.w(TAG, "start ignore");
            return;
        }
        this.isReportStop = false;
        start(outParameter.getKey());
    }

    public void stop(int i10) {
        SourceLog.i(TAG, "stop stopType: " + i10);
        if (this.mPlayInfo != null) {
            if (i10 == 1005) {
                this.disconnectFromUser = true;
            }
            if (!isInPlaybackState()) {
                SourceLog.w(TAG, "stop ignore 2: " + this.mCurrentState + " " + this);
                return;
            }
            if (this.mStopType <= 0) {
                this.mStopType = i10;
            }
            stop(this.mPlayInfo.getKey());
            reportStop();
        }
    }

    public void stopWithCallback(int i10) {
        stop(i10);
        LelinkPlayerListenerDispatcher lelinkPlayerListenerDispatcher = this.mLelinkPlayerListener;
        if (lelinkPlayerListenerDispatcher != null) {
            lelinkPlayerListenerDispatcher.onStop(this.mPlayInfo);
        }
    }

    public void subVolume() {
        if (!isInPlaybackState()) {
            SourceLog.w(TAG, "subVolume ignore " + this.mCurrentState);
            return;
        }
        this.mCastPlayer.subVolume();
    }

    public boolean switchExpansionScreen(boolean z10) {
        return this.mCastPlayer.switchExpansionScreen(z10);
    }

    public void release(String str) {
        SourceLog.w(TAG, "release " + str);
        reportStop();
        this.isReleased = true;
        this.mCastPlayer.release(str);
        e.d().b();
    }

    public boolean appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        return this.mCastPlayer.appendPlayList(str, dramaInfoBeanArr, i10, i11, i12);
    }

    public boolean clearPlayList(String str) {
        return this.mCastPlayer.clearPlayList(str);
    }

    public boolean playDrama(String str, String str2) {
        return this.mCastPlayer.playDrama(str, str2);
    }

    public boolean playNextDrama(String str) {
        return this.mCastPlayer.playNextDrama(str);
    }

    public boolean playPreDrama(String str) {
        return this.mCastPlayer.playPreDrama(str);
    }

    public boolean resume(String str) {
        if (isInPlaybackState()) {
            return this.mCastPlayer.resume(str);
        }
        SourceLog.w(TAG, "pause ignore 2: " + this.mCurrentState);
        return false;
    }

    public void setDataSource(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
        this.mCastPlayer.setDataSource(outParameter);
        this.mCurrentState = -1;
    }

    public boolean start(String str) {
        if (isInPlaybackState()) {
            return this.mCastPlayer.start(str);
        }
        SourceLog.w(TAG, "start ignore 2: " + this.mCurrentState);
        return false;
    }

    public boolean pause(String str) {
        if (isInPlaybackState()) {
            return this.mCastPlayer.pause(str);
        }
        SourceLog.w(TAG, "pause ignore 2: " + this.mCurrentState);
        return false;
    }

    public boolean seekTo(String str, int i10) {
        return this.mCastPlayer.seekTo(str, i10);
    }

    public void stop(String str) {
        SourceLog.i(TAG, "play control stop");
        this.isStopped = true;
        this.mCurrentState = 0;
        this.mCastPlayer.stop(str);
    }
}
