package com.hpplay.imsdk;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableListener;
import com.hpplay.common.log.LeLog;
import com.hpplay.cybergarage.soap.SOAP;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class IMEntrance implements Observer {
    public static final int IM_AUTH_RESULT_FAIL = 1;
    public static final int IM_AUTH_RESULT_SERVER_FULL = 2;
    public static final int IM_AUTH_RESULT_SUCCESS = 0;
    private static IMEntrance instance;
    public static int sRetryCount;
    private final String PATH_PUSH = "/1/push";
    private final String PATH_PUSHALL = "/1/push/all";
    private final String PATH_PUSHROOM = "/1/push/room";
    private final String PATH_PUSHS = "/1/pushs";
    private final int PORT_CONNECT = 8080;
    private final int PORT_PUSH = 7172;
    private final String TAG = "IM_IMEntrance";
    private final int WHAT_MSG = 1;
    private final int WHAT_RECONNECT = 2;
    private String appid;
    private String capability;
    private volatile boolean disconnect = true;
    private String imUrl;
    /* access modifiers changed from: private */
    public OnConnectServerListener mConnectListener;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                MessageBean messageBean = (MessageBean) message.obj;
                if (IMEntrance.this.mReceiveMessageListener == null) {
                    return false;
                }
                IMEntrance.this.mReceiveMessageListener.onMsg(messageBean.opt, messageBean.message);
                return false;
            } else if (i10 != 2) {
                return false;
            } else {
                IMEntrance.this.disconnect();
                if (IMEntrance.this.mConnectListener == null) {
                    return false;
                }
                IMEntrance.this.mConnectListener.onRestart();
                return false;
            }
        }
    });
    private AsyncTask mIMConnectTask;
    /* access modifiers changed from: private */
    public MessageClient mMsgClient;
    /* access modifiers changed from: private */
    public OnReceiveMessageListener mReceiveMessageListener;
    private OnReceiveMessageListener msgReceiver = new OnReceiveMessageListener() {
        public void onMsg(long j10, String str) {
            IMEntrance.this.mHandler.obtainMessage(1, new MessageBean(j10, str)).sendToTarget();
        }
    };
    private long qrtime;
    private String qrurl;
    private int sdkversion;
    private String token;
    private String uid;

    private IMEntrance() {
    }

    private String getHost(String str) {
        if (str.startsWith(HttpConstant.HTTP)) {
            try {
                if (str.lastIndexOf(SOAP.DELIM) > str.indexOf(HttpConstant.SCHEME_SPLIT) + 3) {
                    return str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3, str.lastIndexOf(SOAP.DELIM));
                }
                return str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
            } catch (Exception e10) {
                LeLog.w("IM_IMEntrance", (Throwable) e10);
            }
        }
        return str;
    }

    public static synchronized IMEntrance getInstance() {
        IMEntrance iMEntrance;
        synchronized (IMEntrance.class) {
            synchronized (IMEntrance.class) {
                if (instance == null) {
                    instance = new IMEntrance();
                }
            }
            iMEntrance = instance;
        }
        return iMEntrance;
    }

    private String getPushUrl() {
        if (TextUtils.isEmpty(this.imUrl)) {
            return "";
        }
        if (this.imUrl.endsWith(SOAP.DELIM)) {
            return this.imUrl + 7172;
        }
        return this.imUrl + SOAP.DELIM + 7172;
    }

    private boolean init(IMConnectBean iMConnectBean) {
        if (this.disconnect) {
            LeLog.w("IM_IMEntrance", "init can not init, reason: already disconnect");
            return false;
        }
        this.uid = iMConnectBean.uid;
        this.appid = iMConnectBean.appid;
        String str = iMConnectBean.imUrl;
        this.imUrl = str;
        this.sdkversion = iMConnectBean.sdkVersion;
        this.token = iMConnectBean.token;
        this.qrtime = iMConnectBean.qrTime;
        this.qrurl = iMConnectBean.qrUrl;
        this.capability = iMConnectBean.capability;
        try {
            MessageClient messageClient = new MessageClient(getHost(str), 8080, this.uid, this.capability, this.appid, this.token);
            this.mMsgClient = messageClient;
            messageClient.setMsgReceiver(this.msgReceiver);
            this.mMsgClient.setOnConnectListener(this.mConnectListener);
            this.mMsgClient.addObserver(this);
            this.mIMConnectTask = AsyncManager.getInstance().exeRunnable(this.mMsgClient, (AsyncRunnableListener) null);
            return true;
        } catch (Exception e10) {
            LeLog.w("IM_IMEntrance", (Throwable) e10);
            return false;
        }
    }

    private String padLeft(String str, int i10) {
        if (str.length() >= i10) {
            return str;
        }
        byte[] bArr = new byte[i10];
        byte[] bytes = str.getBytes();
        Arrays.fill(bArr, (byte) 48);
        System.arraycopy(bytes, 0, bArr, i10 - bytes.length, bytes.length);
        return new String(bArr);
    }

    public boolean connect(IMConnectBean iMConnectBean) {
        if (!this.disconnect) {
            LeLog.i("IM_IMEntrance", "connect im is connecting now, call disconnect here");
            disconnect();
        }
        LeLog.i("IM_IMEntrance", "connect imUrl: " + iMConnectBean.imUrl + "  uid: " + iMConnectBean.uid);
        this.disconnect = false;
        return init(iMConnectBean);
    }

    public void disconnect() {
        LeLog.i("IM_IMEntrance", "disconnect");
        this.disconnect = true;
        this.mReceiveMessageListener = null;
        MessageClient messageClient = this.mMsgClient;
        if (messageClient != null) {
            messageClient.deleteObservers();
            this.mMsgClient.stop();
            this.mMsgClient.deleteObservers();
        }
        AsyncTask asyncTask = this.mIMConnectTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mIMConnectTask = null;
        }
    }

    public boolean isConnected() {
        MessageClient messageClient = this.mMsgClient;
        if (messageClient == null || !messageClient.isRunning()) {
            return false;
        }
        return true;
    }

    public void sendChannelMsg(int i10, String str, int i11) {
        LeLog.i("IM_IMEntrance", "sendChannelMsg");
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(getPushUrl() + "/1/push/room" + "?rid=" + i11, padLeft(Integer.toHexString(i10), 8) + "," + str);
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                if (asyncHttpParameter.out.resultType == 0) {
                    LeLog.i("IM_IMEntrance", "sendChannelMsg success");
                } else {
                    LeLog.i("IM_IMEntrance", "sendChannelMsg failed");
                }
            }
        });
    }

    public void sendSingleMsg(int i10, String str, String str2, String str3) {
        sendSingleMsg(i10, str, str2, str3, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                if (asyncHttpParameter.out.resultType == 0) {
                    LeLog.i("IM_IMEntrance", "sendSingleMsg success");
                } else {
                    LeLog.i("IM_IMEntrance", "sendSingleMsg failed");
                }
            }
        });
    }

    public void setOnConnectListener(OnConnectServerListener onConnectServerListener) {
        this.mConnectListener = onConnectServerListener;
        MessageClient messageClient = this.mMsgClient;
        if (messageClient != null) {
            messageClient.setOnConnectListener(onConnectServerListener);
        }
    }

    public void setReceiveMessageListener(OnReceiveMessageListener onReceiveMessageListener) {
        this.mReceiveMessageListener = onReceiveMessageListener;
    }

    public void update(Observable observable, Object obj) {
        if (this.disconnect) {
            LeLog.w("IM_IMEntrance", "update im already disconnect,ignore");
        } else {
            this.mHandler.obtainMessage(2).sendToTarget();
        }
    }

    public void updateCapability(final String str) {
        this.capability = str;
        if (!isConnected()) {
            LeLog.w("IM_IMEntrance", "updateCapability ignore");
        } else {
            AsyncManager.getInstance().exeRunnable(new Runnable() {
                public void run() {
                    try {
                        IMEntrance.this.mMsgClient.capability = str;
                        IMEntrance.this.mMsgClient.updateCapabilityWrite();
                    } catch (Exception e10) {
                        LeLog.w("IM_IMEntrance", (Throwable) e10);
                    }
                }
            }, (AsyncRunnableListener) null);
        }
    }

    public void sendSingleMsg(int i10, String str, String str2, String str3, AsyncHttpRequestListener asyncHttpRequestListener) {
        LeLog.i("IM_IMEntrance", "sendSingleMsg");
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(getPushUrl() + "/1/push" + "?uid=" + str2 + "&appid=" + str3, padLeft(Integer.toHexString(i10), 8) + "," + str);
        asyncHttpParameter.in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, asyncHttpRequestListener);
    }
}
