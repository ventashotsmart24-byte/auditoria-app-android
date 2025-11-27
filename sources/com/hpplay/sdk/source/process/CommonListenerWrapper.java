package com.hpplay.sdk.source.process;

import com.hpplay.sdk.source.api.ICommonListener;
import com.hpplay.sdk.source.api.ISinkPreparedListener;
import com.hpplay.sdk.source.bean.MirrorSinkBean;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.transceiver.IHostStatusChangeListener;
import com.hpplay.sdk.source.transceiver.IRemoteServerListener;
import com.hpplay.sdk.source.transceiver.ISinkHostSettingChangeListener;
import com.hpplay.sdk.source.transceiver.ISinkNotifySourceCastListener;
import com.hpplay.sdk.source.transceiver.bean.RemoteServerBean;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

public class CommonListenerWrapper {
    private static final String TAG = "CommonListenerWrapper";
    private static CommonListenerWrapper sInstance;
    /* access modifiers changed from: private */
    public ICommonListener mAPPCommonListener;
    private IHostStatusChangeListener mHostStatusChangeListener;
    private IRemoteServerListener mRemoteServerListener;
    private ISinkHostSettingChangeListener mSinkHostSettingChangeListener;
    private ISinkNotifySourceCastListener mSinkNotifySourceCastListener;
    private ISinkPreparedListener mSinkPreparedListener;

    private CommonListenerWrapper() {
    }

    public static synchronized CommonListenerWrapper getInstance() {
        CommonListenerWrapper commonListenerWrapper;
        synchronized (CommonListenerWrapper.class) {
            synchronized (CommonListenerWrapper.class) {
                if (sInstance == null) {
                    sInstance = new CommonListenerWrapper();
                }
            }
            commonListenerWrapper = sInstance;
        }
        return commonListenerWrapper;
    }

    public IHostStatusChangeListener getHostStatusChangeListener() {
        return this.mHostStatusChangeListener;
    }

    public IRemoteServerListener getRemoteServerListener() {
        return this.mRemoteServerListener;
    }

    public ISinkHostSettingChangeListener getSinkHostSettingChangeListener() {
        return this.mSinkHostSettingChangeListener;
    }

    public ISinkNotifySourceCastListener getSinkNotifySourceCastListener() {
        return this.mSinkNotifySourceCastListener;
    }

    public ISinkPreparedListener getSinkPreparedListener() {
        return this.mSinkPreparedListener;
    }

    public void registerListener(Object... objArr) {
        try {
            int parseInt = Integer.parseInt(objArr[0].toString());
            if (parseInt == 1) {
                this.mRemoteServerListener = new IRemoteServerListener() {
                    public void onServerFailed(int i10) {
                        if (CommonListenerWrapper.this.mAPPCommonListener != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("error", i10);
                                CommonListenerWrapper.this.mAPPCommonListener.onCallback(1, 2, jSONObject.toString());
                            } catch (Exception e10) {
                                SourceLog.w(CommonListenerWrapper.TAG, (Throwable) e10);
                            }
                        }
                    }

                    public void onServerStarted(RemoteServerBean remoteServerBean) {
                        if (CommonListenerWrapper.this.mAPPCommonListener != null) {
                            CommonListenerWrapper.this.mAPPCommonListener.onCallback(1, 1, remoteServerBean.toJson());
                        }
                    }
                };
            } else if (parseInt == 2) {
                this.mSinkPreparedListener = new ISinkPreparedListener() {
                    public void onSinkPrepared(MirrorSinkBean mirrorSinkBean) {
                        if (CommonListenerWrapper.this.mAPPCommonListener != null) {
                            CommonListenerWrapper.this.mAPPCommonListener.onCallback(2, 1, mirrorSinkBean.toJson());
                        }
                    }
                };
            } else if (parseInt == 3) {
                this.mSinkHostSettingChangeListener = new ISinkHostSettingChangeListener() {
                    public void onCastSetting(int i10) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("value", i10);
                            if (CommonListenerWrapper.this.mAPPCommonListener != null) {
                                CommonListenerWrapper.this.mAPPCommonListener.onCallback(3, 1, jSONObject.toString());
                            }
                        } catch (Exception e10) {
                            SourceLog.w(CommonListenerWrapper.TAG, (Throwable) e10);
                        }
                    }

                    public void onReverseCastSetting(int i10) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("value", i10);
                            if (CommonListenerWrapper.this.mAPPCommonListener != null) {
                                CommonListenerWrapper.this.mAPPCommonListener.onCallback(3, 2, jSONObject.toString());
                            }
                        } catch (Exception e10) {
                            SourceLog.w(CommonListenerWrapper.TAG, (Throwable) e10);
                        }
                    }
                };
            } else if (parseInt == 4) {
                this.mHostStatusChangeListener = new IHostStatusChangeListener() {
                    public void onHostChange(boolean z10) {
                        if (CommonListenerWrapper.this.mAPPCommonListener != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(Constants.KEY_HOST, z10);
                                CommonListenerWrapper.this.mAPPCommonListener.onCallback(4, 1, jSONObject.toString());
                            } catch (Exception e10) {
                                SourceLog.w(CommonListenerWrapper.TAG, (Throwable) e10);
                            }
                        }
                    }
                };
            } else if (parseInt == 5) {
                this.mSinkNotifySourceCastListener = new ISinkNotifySourceCastListener() {
                    public void onSinkNotifySourceCast(int i10) {
                        if (CommonListenerWrapper.this.mAPPCommonListener != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("action", i10);
                                CommonListenerWrapper.this.mAPPCommonListener.onCallback(5, 1, jSONObject.toString());
                            } catch (Exception e10) {
                                SourceLog.w(CommonListenerWrapper.TAG, (Throwable) e10);
                            }
                        }
                    }
                };
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void release() {
        this.mAPPCommonListener = null;
    }

    public void setCommonListener(ICommonListener iCommonListener) {
        this.mAPPCommonListener = iCommonListener;
    }

    public void unRegisterListener(Object... objArr) {
        try {
            int parseInt = Integer.parseInt(objArr[0].toString());
            if (parseInt == 1) {
                this.mRemoteServerListener = null;
            } else if (parseInt == 2) {
                this.mSinkPreparedListener = null;
            } else if (parseInt == 3) {
                this.mSinkHostSettingChangeListener = null;
            } else if (parseInt == 4) {
                this.mHostStatusChangeListener = null;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }
}
