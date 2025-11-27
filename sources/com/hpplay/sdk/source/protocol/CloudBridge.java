package com.hpplay.sdk.source.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.MediaAssetBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.PlayerInfoBean;
import com.hpplay.sdk.source.bean.StopInfo;
import com.hpplay.sdk.source.business.IMQueue;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.SourceErrorLog;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.player.ICastPlayer;
import com.hpplay.sdk.source.player.listener.OnCompletionListener;
import com.hpplay.sdk.source.player.listener.OnErrorListener;
import com.hpplay.sdk.source.player.listener.OnInfoListener;
import com.hpplay.sdk.source.player.listener.OnLoadingListener;
import com.hpplay.sdk.source.player.listener.OnPreparedListener;
import com.hpplay.sdk.source.player.listener.OnStateChangeListener;
import com.hpplay.sdk.source.protocol.connect.OnPlayStateListener;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.raizlabs.android.dbflow.sql.language.Operator;
import org.json.JSONObject;

public class CloudBridge extends AbsBridge {
    private static final String TAG = "CloudBridge";
    /* access modifiers changed from: private */
    public boolean isCallPrepared = false;
    /* access modifiers changed from: private */
    public String mReportPrepareDramaId = null;
    private final OnPlayStateListener mStateListener = new OnPlayStateListener() {
        public void onError(String str, String str2) {
            if (!TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                SourceLog.w(CloudBridge.TAG, "onError ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
                return;
            }
            OnErrorListener onErrorListener = CloudBridge.this.mErrorListener;
            if (onErrorListener != null) {
                onErrorListener.onError((ICastPlayer) null, 210010, 210011, (String) null);
            }
        }

        public void onPause(String str) {
            if (!TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                SourceLog.w(CloudBridge.TAG, "onPause ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
                return;
            }
            OnStateChangeListener onStateChangeListener = CloudBridge.this.mStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged((ICastPlayer) null, 4);
            }
        }

        public void onPlaying(String str, int i10, int i11) {
            if (!TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                SourceLog.w(CloudBridge.TAG, "onPlaying ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
                return;
            }
            OnInfoListener onInfoListener = CloudBridge.this.mInfoListener;
            if (onInfoListener != null) {
                onInfoListener.onInfo((ICastPlayer) null, 100, i10, i11);
            }
        }

        public void onStart(String str) {
            if (!TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                SourceLog.w(CloudBridge.TAG, "onStart ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
                return;
            }
            CloudBridge cloudBridge = CloudBridge.this;
            OutParameter outParameter = cloudBridge.mPlayInfo;
            if (outParameter == null || outParameter.urls == null) {
                if (!cloudBridge.isCallPrepared) {
                    boolean unused = CloudBridge.this.isCallPrepared = true;
                    OnPreparedListener onPreparedListener = CloudBridge.this.mPreparedListener;
                    if (onPreparedListener != null) {
                        onPreparedListener.onPrepared((ICastPlayer) null);
                        return;
                    }
                    return;
                }
                OnStateChangeListener onStateChangeListener = CloudBridge.this.mStateChangeListener;
                if (onStateChangeListener != null) {
                    onStateChangeListener.onStateChanged((ICastPlayer) null, 3);
                }
            } else if (cloudBridge.mReportPrepareDramaId == null || !CloudBridge.this.mReportPrepareDramaId.equals(CloudBridge.this.mPlayInfo.dramaID)) {
                CloudBridge cloudBridge2 = CloudBridge.this;
                String unused2 = cloudBridge2.mReportPrepareDramaId = cloudBridge2.mPlayInfo.dramaID;
                OnPreparedListener onPreparedListener2 = CloudBridge.this.mPreparedListener;
                if (onPreparedListener2 != null) {
                    onPreparedListener2.onPrepared((ICastPlayer) null);
                }
            } else {
                OnStateChangeListener onStateChangeListener2 = CloudBridge.this.mStateChangeListener;
                if (onStateChangeListener2 != null) {
                    onStateChangeListener2.onStateChanged((ICastPlayer) null, 3);
                }
            }
        }

        public void onStop(String str, int i10) {
            if (!TextUtils.equals(str, CloudBridge.this.mPlayInfo.urlID)) {
                SourceLog.w(CloudBridge.TAG, "onStop ignore, " + str + Operator.Operation.DIVISION + CloudBridge.this.mPlayInfo.urlID);
                return;
            }
            boolean unused = CloudBridge.this.isCallPrepared = false;
            if (i10 == 0) {
                OnCompletionListener onCompletionListener = CloudBridge.this.mCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onComplete((ICastPlayer) null);
                }
            } else if (CloudBridge.this.mStopListener != null) {
                StopInfo stopInfo = new StopInfo();
                if (i10 == 2) {
                    stopInfo.type = 3;
                } else {
                    stopInfo.type = 1;
                }
                CloudBridge.this.mStopListener.onStop((ICastPlayer) null, stopInfo);
            }
        }
    };

    public CloudBridge(Context context, OutParameter outParameter) {
        super(context, outParameter);
    }

    public void addVolume() {
        SourceLog.i(TAG, "addVolume");
        PublicCastClient.getInstance().addVolume(this.mPlayInfo);
    }

    public void appendPlayList(String str, DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        SourceLog.i(TAG, "appendPlayList " + str);
        PublicCastClient.getInstance().setPlayList(this.mPlayInfo, DramaInfoBean.APPEND_PLAY_LIST, dramaInfoBeanArr, i10, i11, i12);
    }

    public void clearPlayList(String str) {
        SourceLog.i(TAG, "clearPlayList " + str);
        PublicCastClient.getInstance().setPlayList(this.mPlayInfo, DramaInfoBean.CLEAR_PLAY_LIST, (DramaInfoBean[]) null, 0, -1, -1);
    }

    public void pause(String str) {
        SourceLog.i(TAG, "pause: " + str);
        PublicCastClient.getInstance().pause(this.mPlayInfo);
    }

    public void play(String str) {
        SourceLog.i(TAG, "play: " + str);
        IMQueue.getInstance().clearTask();
        PublicCastClient.getInstance().setOnPlayStateListener(this.mStateListener);
        this.isCallPrepared = false;
        PlayerInfoBean playerInfoBean = this.mPlayInfo.playerInfoBean;
        if (playerInfoBean != null && !playerInfoBean.isEmpty()) {
            OutParameter outParameter = this.mPlayInfo;
            outParameter.playerInfoBean.setUri(outParameter.urlID);
            PassSender instance = PassSender.getInstance();
            OutParameter outParameter2 = this.mPlayInfo;
            instance.sendPlayerInfo(outParameter2.playerInfoBean, outParameter2.session);
        }
        MediaAssetBean mediaAssetBean = this.mPlayInfo.mediaAssetBean;
        if (mediaAssetBean != null && !mediaAssetBean.isEmpty()) {
            OutParameter outParameter3 = this.mPlayInfo;
            outParameter3.mediaAssetBean.setUri(outParameter3.urlID);
            PassSender instance2 = PassSender.getInstance();
            OutParameter outParameter4 = this.mPlayInfo;
            instance2.sendMediaAssets(outParameter4.mediaAssetBean, outParameter4.session);
        }
        PublicCastClient.getInstance().play(this.mPlayInfo, "", new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                AsyncHttpParameter.Out out;
                String str;
                AsyncHttpParameter.Out out2;
                if (asyncHttpParameter != null && (out2 = asyncHttpParameter.out) != null && out2.resultType == 2) {
                    SourceLog.w(CloudBridge.TAG, "play onRequestResult cancel ");
                } else if (asyncHttpParameter == null || (out = asyncHttpParameter.out) == null || (str = out.result) == null) {
                    SourceLog.w(CloudBridge.TAG, "play onRequestResult failed ");
                    OnErrorListener onErrorListener = CloudBridge.this.mErrorListener;
                    if (onErrorListener != null) {
                        onErrorListener.onError((ICastPlayer) null, 210000, 210011, SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.PUSH_ERROR_CLOUD_PUSH_FAILURE, "result is null"));
                    }
                } else {
                    SourceLog.debug(CloudBridge.TAG, "play onRequestResult " + str);
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt(Constant.KEY_STATUS);
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject != null) {
                            optJSONObject.optString(Constant.KEY_MSG);
                        }
                        if (optInt == 403) {
                            OnErrorListener onErrorListener2 = CloudBridge.this.mErrorListener;
                            if (onErrorListener2 != null) {
                                onErrorListener2.onError((ICastPlayer) null, 210010, 210004, SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.PUSH_ERROR_CLOUD_PUSH_TV_OFFLINE, str));
                                return;
                            }
                            return;
                        }
                        if (optInt == 200) {
                            OnLoadingListener onLoadingListener = CloudBridge.this.mLoadingListener;
                            if (onLoadingListener != null) {
                                onLoadingListener.onLoading((ICastPlayer) null, (String) null);
                                return;
                            }
                            return;
                        }
                        OnErrorListener onErrorListener3 = CloudBridge.this.mErrorListener;
                        if (onErrorListener3 != null) {
                            onErrorListener3.onError((ICastPlayer) null, 210010, 210011, SourceErrorLog.getInstance().getErrorReportExtra(ErrorCode.PUSH_ERROR_CLOUD_PUSH_FAILURE, str));
                        }
                    } catch (Exception e10) {
                        SourceLog.w(CloudBridge.TAG, (Throwable) e10);
                    }
                }
            }
        });
    }

    public void playDrama(String str, String str2) {
        SourceLog.i(TAG, "playDrama " + str + " / " + str2);
        PublicCastClient.getInstance().playDrama(this.mPlayInfo, str2);
    }

    public void playNextDrama(String str) {
        SourceLog.i(TAG, "playNextDrama " + str);
        PublicCastClient.getInstance().playNextDrama(this.mPlayInfo);
    }

    public void playPreDrama(String str) {
        SourceLog.i(TAG, "playPreDrama " + str);
        PublicCastClient.getInstance().playPreDrama(this.mPlayInfo);
    }

    public void release() {
    }

    public void resume(String str) {
        SourceLog.i(TAG, "resume: " + str);
        PublicCastClient.getInstance().resume(this.mPlayInfo);
    }

    public void seekTo(int i10) {
        SourceLog.i(TAG, "seekTo: second := " + i10);
        PublicCastClient.getInstance().seekTo(this.mPlayInfo, i10);
    }

    public void selectAudiotrack(int i10) {
        SourceLog.i(TAG, "selectAudiotrack index:" + i10);
        PublicCastClient.getInstance().selectTrack(this.mPlayInfo, i10);
    }

    public void setVolume(int i10) {
        SourceLog.i(TAG, "setVolume");
        PublicCastClient.getInstance().setVolume(this.mPlayInfo, i10);
    }

    public void stop(String str) {
        SourceLog.i(TAG, "stop: " + str);
        PublicCastClient.getInstance().stop(this.mPlayInfo);
    }

    public void subVolume() {
        SourceLog.i(TAG, "subVolume");
        PublicCastClient.getInstance().subVolume(this.mPlayInfo);
    }
}
