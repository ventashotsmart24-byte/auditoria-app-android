package com.hpplay.sdk.source.process;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.hpplay.sdk.source.a;
import com.hpplay.sdk.source.api.ICloudMirrorPlayListener;
import com.hpplay.sdk.source.api.ICommonListener;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.IFavoriteDeviceListener;
import com.hpplay.sdk.source.api.IHistoryDeviceListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.ILogCallback;
import com.hpplay.sdk.source.api.IMirrorChangeListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.api.IReceiverPropertiesCallback;
import com.hpplay.sdk.source.api.IRelevantInfoListener;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.ISendPassCallback;
import com.hpplay.sdk.source.api.ISinkKeyEventListener;
import com.hpplay.sdk.source.api.ISinkTouchEventListener;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.b;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.CastBean;
import com.hpplay.sdk.source.bean.CommonResultBean;
import com.hpplay.sdk.source.bean.DaCastBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.bean.ReceiverProperties;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoListParseListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.c;
import com.hpplay.sdk.source.d;
import com.hpplay.sdk.source.device.Device;
import com.hpplay.sdk.source.e;
import com.hpplay.sdk.source.f;
import com.hpplay.sdk.source.g;
import com.hpplay.sdk.source.h;
import com.hpplay.sdk.source.i;
import com.hpplay.sdk.source.j;
import com.hpplay.sdk.source.k;
import com.hpplay.sdk.source.l;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.m;
import com.hpplay.sdk.source.n;
import com.hpplay.sdk.source.o;
import com.hpplay.sdk.source.p;
import com.hpplay.sdk.source.q;
import com.hpplay.sdk.source.r;
import com.hpplay.sdk.source.s;
import com.hpplay.sdk.source.t;
import com.hpplay.sdk.source.u;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.hpplay.sdk.source.v;
import com.hpplay.sdk.source.w;
import com.hpplay.sdk.source.x;
import com.hpplay.sdk.source.z;
import java.util.List;

public class LelinkServiceBinder extends z.a {
    private static final String TAG = "LelinkServiceBinder";
    private ICreateShortUrlListener iCreateShortUrlListener = new ICreateShortUrlListener() {
        public void onCreateShortUrl(String str) {
            if (LelinkServiceBinder.this.mSubCreateShortUrlListener != null) {
                try {
                    LelinkServiceBinder.this.mSubCreateShortUrlListener.onCreateShortUrl(str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCreateShortUrl: process may be closed");
                }
            }
        }
    };
    private IDebugAVListener mAVListener = new IDebugAVListener() {
        public void onAudioCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
            if (LelinkServiceBinder.this.mStubAVListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAVListener.onAudioCallback(j10, i10, i11, i12, bArr);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onAudioCallback: process may be closed");
                }
            }
        }

        public void onVideoCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
            if (LelinkServiceBinder.this.mStubAVListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAVListener.onVideoCallback(j10, i10, i11, i12, bArr);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onVideoCallback: process may be closed");
                }
            }
        }
    };
    private AuthListener mAuthListener = new AuthListener() {
        public void onAuthFailed(int i10) {
            if (LelinkServiceBinder.this.mStubAuthListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAuthListener.onAuthFailed(i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onAuthFailed: process may be closed");
                }
            }
        }

        public void onAuthSuccess(String str, String str2) {
            if (LelinkServiceBinder.this.mStubAuthListener != null) {
                try {
                    LelinkServiceBinder.this.mStubAuthListener.onAuthSuccess(str, str2);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onAuthSuccess: process may be closed");
                }
            }
        }
    };
    private IBrowseListener mBrowserListener = new IBrowseListener() {
        public void onBrowse(int i10, List<LelinkServiceInfo> list) {
            if (LelinkServiceBinder.this.mStubBrowserListener != null) {
                try {
                    LelinkServiceBinder.this.mStubBrowserListener.onResult(i10, list);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onBrowse: process may be closed");
                }
            }
        }
    };
    private ICloudMirrorPlayListener mCloudMirrorPlayListener = new ICloudMirrorPlayListener() {
        public void onCloudMessage(long j10, String str) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubCloudMirrorPlayListener.onCloudMessage(j10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCloudMessage: process may be closed");
                }
            }
        }

        public void onCloudMirrorStart(boolean z10, String str, String str2, String str3, String str4, String str5) {
            if (LelinkServiceBinder.this.mStubCloudMirrorPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubCloudMirrorPlayListener.onCloudMirrorStart(z10, str, str2, str3, str4, str5);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCloudMirrorStart: process may be closed");
                }
            }
        }

        public void onCloudMirrorStop() {
            if (LelinkServiceBinder.this.mStubCloudMirrorPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubCloudMirrorPlayListener.onCloudMirrorStop();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCloudMirrorStop: process may be closed");
                }
            }
        }
    };
    private ICommonListener mCommonListener = new ICommonListener() {
        public CommonResultBean onCallback(int i10, int i11, String str) {
            if (LelinkServiceBinder.this.mStubCommonListener == null) {
                return null;
            }
            try {
                return LelinkServiceBinder.this.mStubCommonListener.onCallback(i10, i11, str);
            } catch (Exception e10) {
                SourceLog.w(LelinkServiceBinder.TAG, (Throwable) e10);
                return null;
            }
        }
    };
    private IConnectListener mConnectListener = new IConnectListener() {
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            if (LelinkServiceBinder.this.mStubConnectListener != null) {
                try {
                    LelinkServiceBinder.this.mStubConnectListener.onConnect(lelinkServiceInfo, i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onConnect: process may be closed");
                }
            }
        }

        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            if (LelinkServiceBinder.this.mStubConnectListener != null) {
                try {
                    LelinkServiceBinder.this.mStubConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onDisconnect: process may be closed");
                }
            }
        }
    };
    private Context mContext;
    private ICreatePinCodeListener mCreatePinCodeListener = new ICreatePinCodeListener() {
        public void onCreatePinCode(String str) {
            if (LelinkServiceBinder.this.mSubCreatePinCodeListener != null) {
                try {
                    LelinkServiceBinder.this.mSubCreatePinCodeListener.onCreatePinCode(str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCreatePinCode: process may be closed");
                }
            }
        }
    };
    private IDaPlayerListener mDaPlayerListener = new IDaPlayerListener() {
        public void onLoading(DaCastBean daCastBean) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onLoading(daCastBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onLoading: process may be closed");
                }
            }
        }

        public void onResult(DaCastBean daCastBean, boolean z10) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onResult(daCastBean, z10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onResult: process may be closed");
                }
            }
        }

        public void onStart(DaCastBean daCastBean) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onStart(daCastBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStart: process may be closed");
                }
            }
        }

        public void onStop(DaCastBean daCastBean) {
            if (LelinkServiceBinder.this.mStubDaPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubDaPlayListener.onStop(daCastBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStop: process may be closed");
                }
            }
        }
    };
    private IFavoriteDeviceListener mFavoriteDeviceListener = new IFavoriteDeviceListener() {
        public void onAddDevice(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onAddDevice(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        public void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onGetDeviceList(i10, i11, list);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        public void onRemoveDevice(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onRemoveDevice(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        public void onSetDeviceAlias(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubFavoriteDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubFavoriteDeviceListener.onSetDeviceAlias(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }
    };
    private IHistoryDeviceListener mHistoryDeviceListener = new IHistoryDeviceListener() {
        public void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list) {
            if (LelinkServiceBinder.this.mStubHistoryDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubHistoryDeviceListener.onGetDeviceList(i10, i11, list);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }

        public void onRemoveDevice(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubHistoryDeviceListener != null) {
                try {
                    LelinkServiceBinder.this.mStubHistoryDeviceListener.onRemoveDevice(i10, i11);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }
    };
    private ILelinkPlayerListener mLelinkPlayerListener = new ILelinkPlayerListener() {
        public void onCompletion() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onCompletion();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCompletion: process may be closed");
                }
            }
        }

        public void onError(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onError(i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onError: process may be closed");
                }
            }
        }

        public void onInfo(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onInfo(i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }

        public void onLoading() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onLoading();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onLoading: process may be closed");
                }
            }
        }

        public void onPause() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onPause();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPause: process may be closed");
                }
            }
        }

        public void onPositionUpdate(long j10, long j11) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onPositionUpdate(j10, j11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPositionUpdate: process may be closed");
                }
            }
        }

        public void onSeekComplete(int i10) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onSeekComplete(i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onSeekComplete: process may be closed");
                }
            }
        }

        public void onStart() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onStart();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStart: process may be closed");
                }
            }
        }

        public void onStop() {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onStop();
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStop: process may be closed");
                }
            }
        }

        public void onVolumeChanged(float f10) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onVolumeChanged(f10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onVolumeChanged: process may be closed");
                }
            }
        }

        public void onInfo(int i10, String str) {
            if (LelinkServiceBinder.this.mStubLelinkPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubLelinkPlayListener.onInfo2(i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }
    };
    private ILogCallback mLogCallback = new ILogCallback() {
        public void onCastLog(int i10, String str) {
            if (LelinkServiceBinder.this.mStubLogCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubLogCallback.onCastLog(i10, str);
                } catch (Exception unused) {
                }
            }
        }
    };
    private IMirrorChangeListener mMirrorChangeListener = new IMirrorChangeListener() {
        public void onMirrorChange(int i10, int i11) {
            if (LelinkServiceBinder.this.mStubMirrorChangeListener != null) {
                try {
                    LelinkServiceBinder.this.mStubMirrorChangeListener.onMirrorChange(i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onMirrorChange: process may be closed");
                }
            }
        }
    };
    private INewPlayerListener mNewPlayListener = new INewPlayerListener() {
        public void onCompletion(CastBean castBean, int i10) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onCompletion(castBean, i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onCompletion: process may be closed");
                }
            }
        }

        public void onError(CastBean castBean, int i10, int i11) {
            boolean z10;
            StringBuilder sb = new StringBuilder();
            sb.append("onError callbak ....");
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            SourceLog.i(LelinkServiceBinder.TAG, sb.toString());
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onError(castBean, i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onError: process may be closed");
                }
            }
        }

        public void onInfo(CastBean castBean, int i10, int i11) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onInfo(castBean, i10, i11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }

        public void onLoading(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onLoading(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onLoading: process may be closed");
                }
            }
        }

        public void onPause(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onPause(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPause: process may be closed");
                }
            }
        }

        public void onPositionUpdate(CastBean castBean, long j10, long j11) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onPositionUpdate(castBean, j10, j11);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onPositionUpdate: process may be closed");
                }
            }
        }

        public void onSeekComplete(CastBean castBean, int i10) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onSeekComplete(castBean, i10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onSeekComplete: process may be closed");
                }
            }
        }

        public void onStart(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onStart(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStart: process may be closed");
                }
            }
        }

        public void onStop(CastBean castBean) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onStop(castBean);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onStop: process may be closed");
                }
            }
        }

        public void onVolumeChanged(CastBean castBean, float f10) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onVolumeChanged(castBean, f10);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onVolumeChanged: process may be closed");
                }
            }
        }

        public void onInfo(CastBean castBean, int i10, String str) {
            if (LelinkServiceBinder.this.mStubNewPlayListener != null) {
                try {
                    LelinkServiceBinder.this.mStubNewPlayListener.onInfo2(castBean, i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onInfo: process may be closed");
                }
            }
        }
    };
    private IAPICallbackListener mOnlineCheckListener = new IAPICallbackListener() {
        public void onResult(int i10, Object obj) {
            if (LelinkServiceBinder.this.mStubOnlineCheckListener != null) {
                try {
                    LelinkServiceBinder.this.mStubOnlineCheckListener.onResult(i10, (List) obj);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onResult: process may be closed");
                }
            }
        }
    };
    private ISendPassCallback mPassCallback = new ISendPassCallback() {
        public void onSendPassCallBack(PassBean passBean) {
            if (LelinkServiceBinder.this.mStubPassCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubPassCallback.onSendPassCallBack(passBean);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, (Throwable) e10);
                }
            }
        }
    };
    private IReceiverPropertiesCallback mReceiverPropertiesCallback = new IReceiverPropertiesCallback() {
        public void callback(ReceiverProperties receiverProperties) {
            if (LelinkServiceBinder.this.mStubReceiverPropertiesCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubReceiverPropertiesCallback.callback(receiverProperties);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, e10.getMessage());
                }
            }
        }
    };
    private IRelevantInfoListener mRelevantListener = new IRelevantInfoListener() {
        public void onReverseInfoResult(int i10, String str) {
            super.onReverseInfoResult(i10, str);
            if (LelinkServiceBinder.this.mStubRelevantListener != null) {
                try {
                    LelinkServiceBinder.this.mStubRelevantListener.onReverseInfoResult(i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onReverseInfoResult: process may be closed");
                }
            }
        }

        public void onSendRelevantInfoResult(int i10, String str) {
            if (LelinkServiceBinder.this.mStubRelevantListener != null) {
                try {
                    LelinkServiceBinder.this.mStubRelevantListener.onSendRelevantInfoResult(i10, str);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onSendRelevantInfoResult: process may be closed");
                }
            }
        }
    };
    private ISearchBannerDataCallback mSearchBannerDataCallback = new ISearchBannerDataCallback() {
        public void onBannerData(String str) {
            if (LelinkServiceBinder.this.mStubSearchBannerDataCallback != null) {
                try {
                    LelinkServiceBinder.this.mStubSearchBannerDataCallback.onBannerData(str);
                } catch (Exception e10) {
                    SourceLog.w(LelinkServiceBinder.TAG, (Throwable) e10);
                }
            }
        }
    };
    private IServiceInfoListParseListener mServiceInfoListParseListener = new IServiceInfoListParseListener() {
        public void onParseResult(List<ServiceInfoParseBean> list) {
            if (LelinkServiceBinder.this.mStubServiceInfoListParseListener != null) {
                try {
                    LelinkServiceBinder.this.mStubServiceInfoListParseListener.onParseResult(list);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onParseResult: process may be closed");
                }
            }
        }
    };
    private IServiceInfoParseListener mServiceInfoParseListener = new IServiceInfoParseListener() {
        public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
            if (LelinkServiceBinder.this.mStubServiceInfoParseListener != null) {
                try {
                    LelinkServiceBinder.this.mStubServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onParseResult: process may be closed");
                }
            }
        }
    };
    private ISinkKeyEventListener mSinkKeyEventListener = new ISinkKeyEventListener() {
        public void onKeyEvent(KeyEvent keyEvent) {
            if (LelinkServiceBinder.this.mStubSinkKeyEventListener != null) {
                try {
                    LelinkServiceBinder.this.mStubSinkKeyEventListener.onKeyEvent(keyEvent);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onKeyEvent: process may be closed");
                }
            }
        }
    };
    private ISinkTouchEventListener mSinkTouchEventListener = new ISinkTouchEventListener() {
        public void onTouchEvent(MotionEvent motionEvent) {
            if (LelinkServiceBinder.this.mStubSinkTouchEventListener != null) {
                try {
                    LelinkServiceBinder.this.mStubSinkTouchEventListener.onTouchEvent(motionEvent);
                } catch (Exception unused) {
                    SourceLog.w(LelinkServiceBinder.TAG, "onTouchEvent: process may be closed");
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public i mStubAVListener;
    /* access modifiers changed from: private */
    public a mStubAuthListener;
    /* access modifiers changed from: private */
    public b mStubBrowserListener;
    /* access modifiers changed from: private */
    public c mStubCloudMirrorPlayListener;
    /* access modifiers changed from: private */
    public d mStubCommonListener;
    /* access modifiers changed from: private */
    public e mStubConnectListener;
    /* access modifiers changed from: private */
    public h mStubDaPlayListener;
    /* access modifiers changed from: private */
    public j mStubFavoriteDeviceListener;
    /* access modifiers changed from: private */
    public k mStubHistoryDeviceListener;
    /* access modifiers changed from: private */
    public l mStubLelinkPlayListener;
    /* access modifiers changed from: private */
    public m mStubLogCallback;
    /* access modifiers changed from: private */
    public n mStubMirrorChangeListener;
    /* access modifiers changed from: private */
    public o mStubNewPlayListener;
    /* access modifiers changed from: private */
    public p mStubOnlineCheckListener;
    /* access modifiers changed from: private */
    public t mStubPassCallback;
    /* access modifiers changed from: private */
    public q mStubReceiverPropertiesCallback;
    /* access modifiers changed from: private */
    public r mStubRelevantListener;
    /* access modifiers changed from: private */
    public s mStubSearchBannerDataCallback;
    /* access modifiers changed from: private */
    public u mStubServiceInfoListParseListener;
    /* access modifiers changed from: private */
    public v mStubServiceInfoParseListener;
    /* access modifiers changed from: private */
    public w mStubSinkKeyEventListener;
    /* access modifiers changed from: private */
    public x mStubSinkTouchEventListener;
    /* access modifiers changed from: private */
    public f mSubCreatePinCodeListener;
    /* access modifiers changed from: private */
    public g mSubCreateShortUrlListener;

    public LelinkServiceBinder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSdkManager.getInstance().addFavoriteDevice(lelinkServiceInfo);
    }

    public void addPinCodeToLelinkServiceInfo(String str) {
        LelinkSdkManager.getInstance().addPinCodeToLelinkServiceInfo(str);
    }

    public void addQRCodeToLelinkServiceInfo(String str) {
        LelinkSdkManager.getInstance().addQRCodeToLelinkServiceInfo(str);
    }

    public void addVolume() {
        LelinkSdkManager.getInstance().addVolume();
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        LelinkSdkManager.getInstance().appendPlayList(dramaInfoBeanArr, i10, i11, i12);
    }

    public void browse(boolean z10, boolean z11) {
        LelinkSdkManager.getInstance().startBrowseThread(z10, z11);
    }

    public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
        return LelinkSdkManager.getInstance().canPlayLocalMedia(lelinkServiceInfo);
    }

    public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
        return LelinkSdkManager.getInstance().canPlayScreen(lelinkServiceInfo);
    }

    public void clearPlayList() {
        LelinkSdkManager.getInstance().clearPlayList();
    }

    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        LelinkSdkManager.getInstance().connect(lelinkServiceInfo);
    }

    public void createPinCode() {
        Device.createPinCode(this.mCreatePinCodeListener);
    }

    public void createShortUrl() {
        Device.createShortUrl(this.iCreateShortUrlListener);
    }

    public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
        return LelinkSdkManager.getInstance().disconnect(lelinkServiceInfo);
    }

    public List<LelinkServiceInfo> getConnectInfos() {
        return LelinkSdkManager.getInstance().getConnectInfos();
    }

    public void getFavoriteDeviceList(int i10, int i11) {
        LelinkSdkManager.getInstance().getFavoriteDeviceList(i10, i11);
    }

    public void getHistoryDeviceList(int i10, int i11) {
        LelinkSdkManager.getInstance().getHistoryDeviceList(i10, i11);
    }

    public String getOption(int i10) {
        Object option = LelinkSdkManager.getInstance().getOption(i10, new Object[0]);
        if (option == null) {
            return null;
        }
        return option.toString();
    }

    public String getSDKInfos(int i10) {
        return LelinkSdkManager.getInstance().getSDKInfos(i10);
    }

    public void initSdkWithUserId(String str, String str2, String str3, String str4, String str5) {
        LelinkSdkManager.getInstance().initSDK(this.mContext, str, str2, str3, str5, str4);
    }

    public void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list) {
        LelinkSdkManager.getInstance().multiMirrorControl(z10, list);
    }

    public void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10) {
        LelinkSdkManager.getInstance().multiPushControl(z10, list, str, i10);
    }

    public void pause() {
        LelinkSdkManager.getInstance().pause();
    }

    public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
        LelinkSdkManager.getInstance().removeFavoriteDevice(list);
    }

    public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
        LelinkSdkManager.getInstance().removeHistoryDevice(list, i10);
    }

    public void resume() {
        LelinkSdkManager.getInstance().resume();
    }

    public void seekTo(int i10) {
        LelinkSdkManager.getInstance().seekTo(i10);
    }

    public void setAuthListener(a aVar) {
        this.mStubAuthListener = aVar;
        LelinkSdkManager.getInstance().setAuthListener(this.mAuthListener);
    }

    public void setCloudMirrorPlayListener(c cVar) {
        this.mStubCloudMirrorPlayListener = cVar;
        LelinkSdkManager.getInstance().setCloudMirrorPlayListener(this.mCloudMirrorPlayListener);
    }

    public void setCommonListener(d dVar) {
        this.mStubCommonListener = dVar;
        LelinkSdkManager.getInstance().setCommonListener(this.mCommonListener);
    }

    public void setConnectStatusListener(e eVar) {
        this.mStubConnectListener = eVar;
        LelinkSdkManager.getInstance().setConnectListener(this.mConnectListener);
    }

    public void setCreatePinCodeListener(f fVar) {
        this.mSubCreatePinCodeListener = fVar;
    }

    public void setCreateShortUrlListener(g gVar) {
        this.mSubCreateShortUrlListener = gVar;
    }

    public void setDaPlayListenerListener(h hVar) {
        this.mStubDaPlayListener = hVar;
        LelinkSdkManager.getInstance().setDaPlayListener(this.mDaPlayerListener);
    }

    public void setDebugAVListener(i iVar) {
        this.mStubAVListener = iVar;
        LelinkSdkManager.getInstance().setDebugAVListener(this.mAVListener);
    }

    public void setDebugMode(boolean z10) {
        SourceLog.i(TAG, "setDebugMode," + z10);
        LelinkSdkManager.getInstance().isDebug(z10);
    }

    public void setDebugTimestamp(boolean z10) {
        LelinkSdkManager.getInstance().isDebugTimestamp(z10);
    }

    public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
        LelinkSdkManager.getInstance().setFavoriteDeviceAlias(lelinkServiceInfo, str);
    }

    public void setFavoriteDeviceListener(j jVar) {
        this.mStubFavoriteDeviceListener = jVar;
        LelinkSdkManager.getInstance().setFavoriteDeviceListener(this.mFavoriteDeviceListener);
    }

    public void setHistoryDeviceListener(k kVar) {
        this.mStubHistoryDeviceListener = kVar;
        LelinkSdkManager.getInstance().setHistoryDeviceListener(this.mHistoryDeviceListener);
    }

    public void setLelinkPlayListenerListener(l lVar) {
        this.mStubLelinkPlayListener = lVar;
        LelinkSdkManager.getInstance().setPlayerListener(this.mLelinkPlayerListener);
    }

    public void setLelinkServiceInfoListener(b bVar) {
        this.mStubBrowserListener = bVar;
        LelinkSdkManager.getInstance().setBrowseListener(this.mBrowserListener);
    }

    public boolean setLelinkServiceInfoOption(int i10, LelinkServiceInfo lelinkServiceInfo) {
        switch (i10) {
            case IAPI.OPTION_35:
            case IAPI.OPTION_37:
            case IAPI.OPTION_63:
            case IAPI.OPTION_QUERY_SUPPORT_MULTI_CHANNEL:
            case IAPI.OPTION_QUERY_SUPPORT_URL_LIST:
            case IAPI.OPTION_QUERY_SUPPORT_REVERSE_CONTROL:
            case IAPI.OPTION_TEMP_RESTRICT:
            case IAPI.OPTION_QUERY_SUPPORT_TRACK:
            case IAPI.OPTION_SET_RECEIVER_PROPERTY:
            case IAPI.OPTION_GET_RECEIVER_PROPERTIES:
                Object option = LelinkSdkManager.getInstance().getOption(i10, lelinkServiceInfo);
                if (option == null || TextUtils.isEmpty(option.toString()) || !HpplayUtil.isDigitsOnly(option.toString()) || Integer.parseInt(option.toString()) != 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public void setLogCallback(m mVar) {
        this.mStubLogCallback = mVar;
        LelinkSdkManager.getInstance().setLogCallback(this.mLogCallback);
    }

    public void setMirrorChangeListener(n nVar) {
        this.mStubMirrorChangeListener = nVar;
        LelinkSdkManager.getInstance().setMirrorChangeListener(this.mMirrorChangeListener);
    }

    public void setNewPlayListenerListener(o oVar) {
        this.mStubNewPlayListener = oVar;
        LelinkSdkManager.getInstance().setNewPlayerListener(this.mNewPlayListener);
    }

    public void setOption(int i10, String[] strArr) {
        LelinkSdkManager.getInstance().setOption(i10, strArr);
    }

    public void setReceiverPropertiesCallback(q qVar) {
        this.mStubReceiverPropertiesCallback = qVar;
        LelinkSdkManager.getInstance().setReceiverPropertiesCallback(this.mReceiverPropertiesCallback);
    }

    public void setRelevantInfoListener(r rVar) {
        this.mStubRelevantListener = rVar;
        LelinkSdkManager.getInstance().setRelevantInfoListener(this.mRelevantListener);
    }

    public void setSearchBannerDataCallback(s sVar) {
        this.mStubSearchBannerDataCallback = sVar;
        LelinkSdkManager.getInstance().setSearchBannerDataCallback(this.mSearchBannerDataCallback);
    }

    public void setSendPassCallback(t tVar) {
        this.mStubPassCallback = tVar;
        LelinkSdkManager.getInstance().setPassCallback(this.mPassCallback);
    }

    public void setServiceInfoListParseListener(u uVar) {
        this.mStubServiceInfoListParseListener = uVar;
        LelinkSdkManager.getInstance().setServiceInfoListParseListener(this.mServiceInfoListParseListener);
    }

    public void setServiceInfoParseListener(v vVar) {
        this.mStubServiceInfoParseListener = vVar;
        LelinkSdkManager.getInstance().setServiceInfoParseListener(this.mServiceInfoParseListener);
    }

    public void setSinkKeyEventListener(w wVar) {
        this.mStubSinkKeyEventListener = wVar;
        LelinkSdkManager.getInstance().setSinkKeyEventListener(this.mSinkKeyEventListener);
    }

    public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, x xVar) {
        this.mStubSinkTouchEventListener = xVar;
        LelinkSdkManager.getInstance().setSinkTouchEventListener(sinkTouchEventArea, f10, this.mSinkTouchEventListener);
    }

    public void setSystemApp(boolean z10) {
        LelinkSdkManager.getInstance().setSystemApp(z10);
    }

    public void setVolume(int i10) {
        LelinkSdkManager.getInstance().setVolume(i10);
    }

    public void startMirrorForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSdkManager.getInstance().startMirror(lelinkPlayerInfo);
    }

    public void startOnlineCheck(p pVar, List<LelinkServiceInfo> list) {
        this.mStubOnlineCheckListener = pVar;
        LelinkSdkManager.getInstance().startOnlineCheck(this.mOnlineCheckListener, list);
    }

    public void startPlayMedia(String str, int i10, boolean z10) {
        LelinkSdkManager.getInstance().startPlayMedia((LelinkServiceInfo) null, str, i10, z10);
    }

    public void startPlayMediaForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
        LelinkSdkManager.getInstance().startPlayCheck(lelinkPlayerInfo);
    }

    public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
        LelinkSdkManager.getInstance().startPlayMedia(lelinkServiceInfo, str, i10, z10);
    }

    public void stopBrowse() {
        LelinkSdkManager.getInstance().stopBrowseThread();
    }

    public void stopPlay() {
        LelinkSdkManager.getInstance().stopPlay();
    }

    public void subVolume() {
        LelinkSdkManager.getInstance().subVolume();
    }

    public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
        LelinkSdkManager.getInstance().updateAudioData(bArr, audioFrameBean);
    }

    public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
        LelinkSdkManager.getInstance().updateVideoData(bArr, videoFrameBean);
    }
}
