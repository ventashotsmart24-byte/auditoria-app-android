package com.hpplay.sdk.source.device.pincode;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.DataBean;
import com.hpplay.sdk.source.bean.PinCodeBean;
import com.hpplay.sdk.source.browse.api.ICreatePinCodeListener;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.HashMap;
import org.json.JSONObject;

public class LelinkCodeCreator {
    private final String TAG = "LelinkCodeCreator";
    private final int WHAT_REFRESH = 1;
    private AsyncTask mCodeTask;
    /* access modifiers changed from: private */
    public ICreatePinCodeListener mCreatePinCodeListener;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            LelinkCodeCreator lelinkCodeCreator = LelinkCodeCreator.this;
            lelinkCodeCreator.createPinCode(lelinkCodeCreator.mCreatePinCodeListener);
            return false;
        }
    });

    /* access modifiers changed from: private */
    public void callbackPinCode(String str, int i10) {
        SourceLog.i("LelinkCodeCreator", "callbackPinCode,pinCode " + str);
        ICreatePinCodeListener iCreatePinCodeListener = this.mCreatePinCodeListener;
        if (iCreatePinCodeListener != null) {
            iCreatePinCodeListener.onCreatePinCode(str);
            startRefreshCode(i10);
        }
    }

    /* access modifiers changed from: private */
    public void startRefreshCode(int i10) {
        if (this.mHandler == null) {
            SourceLog.w("LelinkCodeCreator", "startRefreshCode ignore");
            return;
        }
        SourceLog.i("LelinkCodeCreator", "startRefreshCode " + i10);
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1), (long) i10);
    }

    public void createPinCode(ICreatePinCodeListener iCreatePinCodeListener) {
        this.mCreatePinCodeListener = iCreatePinCodeListener;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        SourceLog.i("LelinkCodeCreator", "createPinCode");
        Session instance = Session.getInstance();
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, instance.getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, instance.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
        DataBean dataBean = new DataBean();
        dataBean.f11583m = Session.DEFAULT_M;
        dataBean.tmp = String.valueOf(System.currentTimeMillis());
        dataBean.extendStr = "";
        dataBean.uid = instance.getUID();
        dataBean.f11582a = instance.appKey;
        dataBean.pt = "2";
        hashMap.put("data", dataBean.toJson().toString());
        final HttpEncrypt httpEncrypt = new HttpEncrypt();
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sPinCodeCreateUrl, httpEncrypt.encode(HapplayUtils.getMapParams(hashMap)));
        SourceLog.i("LelinkCodeCreator", "requestUrl:" + asyncHttpParameter.in.requestUrl);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.requestHeaders = httpEncrypt.buildHeader();
        this.mCodeTask = AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                PinCodeBean pinCodeBean;
                AsyncHttpParameter.Out out = asyncHttpParameter.out;
                if (out.result == null) {
                    SourceLog.i("LelinkCodeCreator", "createPinCode failed, result is null");
                    if (LelinkCodeCreator.this.mCreatePinCodeListener != null) {
                        LelinkCodeCreator.this.mCreatePinCodeListener.onCreatePinCode((String) null);
                    }
                    LelinkCodeCreator.this.startRefreshCode(60000);
                    return;
                }
                int i10 = out.resultType;
                if (i10 == 2) {
                    SourceLog.i("LelinkCodeCreator", "createPinCode task cancel");
                } else if (i10 == 0) {
                    String decode = httpEncrypt.decode(out);
                    SourceLog.debug("LelinkCodeCreator", "result:" + decode);
                    try {
                        pinCodeBean = new PinCodeBean(new JSONObject(decode));
                    } catch (Exception e10) {
                        SourceLog.w("LelinkCodeCreator", (Throwable) e10);
                        pinCodeBean = null;
                    }
                    if (pinCodeBean != null) {
                        int i11 = pinCodeBean.status;
                        if (i11 == 200) {
                            if (!TextUtils.isEmpty(pinCodeBean.data.code)) {
                                LelinkCodeCreator lelinkCodeCreator = LelinkCodeCreator.this;
                                PinCodeBean.DataBean dataBean = pinCodeBean.data;
                                lelinkCodeCreator.callbackPinCode(dataBean.code, Math.max(1, dataBean.codeTime - 1) * 60 * 1000);
                                return;
                            }
                            LelinkCodeCreator.this.callbackPinCode((String) null, 300000);
                        } else if (i11 == 401 || i11 == 410) {
                            AuthSDK.getInstance().authSDKByInvalidToken();
                            SourceLog.i("LelinkCodeCreator", "createPinCode fail token timeout!");
                            LelinkCodeCreator.this.startRefreshCode(30000);
                        } else {
                            LelinkCodeCreator.this.callbackPinCode((String) null, 300000);
                        }
                    } else {
                        LelinkCodeCreator.this.callbackPinCode((String) null, 60000);
                    }
                }
            }
        });
    }

    public void release() {
        SourceLog.i("LelinkCodeCreator", "release");
        AsyncTask asyncTask = this.mCodeTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.mCodeTask = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }
}
