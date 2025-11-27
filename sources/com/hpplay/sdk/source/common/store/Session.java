package com.hpplay.sdk.source.common.store;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.utils.ContextPath;
import com.hpplay.sdk.source.api.IDebugAVListener;
import com.hpplay.sdk.source.api.ILogCallback;
import com.hpplay.sdk.source.bean.AuthRepeatInfoBean;
import com.hpplay.sdk.source.bean.DebugTimestampBean;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.LeboUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Session {
    public static final String DEFAULT_M = "02:00:00:00:00:00";
    private static final String TAG = "Session";
    private static Session mInstance;
    public String appKey;
    public String appSecret;
    public String appVersion;
    public String department;
    private boolean disableIM;
    private AuthRepeatInfoBean infoBean;
    public boolean isAuthSuccess;
    public boolean isFilter501Version;
    public boolean isFirstBoot;
    public boolean isPreferLelink;
    public String jobNumber;
    private String mBannerData;
    private HashMap<String, String> mBrandMap;
    private final Context mContext;
    public ContextPath mContextPath;
    private IDebugAVListener mDebugAVListener;
    private DebugTimestampBean mDebugBean;
    private boolean mDebugTimestamp;
    public int mExpireTime;
    private String mHID;
    private ILogCallback mLogCallback;
    private long mRegTime;
    private String mSourceID;
    public String mTUID;
    private String mUID;
    public String oaID;
    @Deprecated
    public int scanTime;
    public int serverPort = 0;
    public String serverProtocolVer;
    public String tid;
    private String token;
    public String userID;

    private Session(Context context) {
        String str = "";
        this.serverProtocolVer = str;
        this.tid = str;
        this.token = str;
        this.scanTime = 60;
        this.isFirstBoot = true;
        this.isPreferLelink = false;
        this.isFilter501Version = true;
        this.mDebugTimestamp = false;
        this.mBannerData = null;
        this.disableIM = false;
        this.mSourceID = null;
        this.mBrandMap = new HashMap<>();
        this.mContext = context;
        try {
            this.mContextPath = ContextPath.getInstance(context, 2, Feature.isZTEChannel() ? "smartcast" : str);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public static synchronized Session getInstance() {
        Session session;
        Application application;
        synchronized (Session.class) {
            if (mInstance == null && (application = HapplayUtils.getApplication()) != null) {
                initSession(application);
            }
            session = mInstance;
        }
        return session;
    }

    public static void initSession(Context context) {
        synchronized (Session.class) {
            if (mInstance == null) {
                mInstance = new Session(context);
            }
        }
    }

    public void disableIM(boolean z10) {
        this.disableIM = z10;
    }

    public String getBannerData() {
        if (TextUtils.isEmpty(this.mBannerData)) {
            SourceLog.w(TAG, "invalid mBannerData");
        }
        return this.mBannerData;
    }

    public String getBrand(String str) {
        if (this.mBrandMap.containsKey(str)) {
            return this.mBrandMap.get(str);
        }
        return "unknown";
    }

    public Context getContext() {
        return this.mContext;
    }

    public ContextPath getContextPath() {
        String str;
        if (this.mContextPath == null) {
            try {
                Context applicationContext = this.mContext.getApplicationContext();
                if (Feature.isZTEChannel()) {
                    str = "smartcast";
                } else {
                    str = "";
                }
                this.mContextPath = ContextPath.getInstance(applicationContext, 2, str);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
        return this.mContextPath;
    }

    public IDebugAVListener getDebugAVListener() {
        return this.mDebugAVListener;
    }

    public boolean getDebugTimestamp() {
        return this.mDebugTimestamp;
    }

    public DebugTimestampBean getDebugTimestampBean() {
        return this.mDebugBean;
    }

    public String getHID() {
        if (TextUtils.isEmpty(this.mHID)) {
            updateHID();
        }
        return this.mHID;
    }

    public ILogCallback getLogCallback() {
        return this.mLogCallback;
    }

    public long getRegTime() {
        AuthRepeatInfoBean authRepeatInfoBean = this.infoBean;
        if (authRepeatInfoBean != null) {
            this.mRegTime = authRepeatInfoBean.getRegTime();
        }
        return this.mRegTime;
    }

    public String getSourceID() {
        if (this.mSourceID == null) {
            this.mSourceID = Preference.getInstance().get(Constant.KEY_SOURCE_ID, "");
        }
        return this.mSourceID;
    }

    public String getToken() {
        if (TextUtils.isEmpty(this.token)) {
            SourceLog.w(TAG, "invalid token");
        }
        return this.token;
    }

    public String getUID() {
        if (TextUtils.isEmpty(this.mUID)) {
            updateUID();
        }
        return this.mUID;
    }

    public void initManufacture() {
        try {
            if (this.mBrandMap.size() == 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mContext.getAssets().open("lelink_config")));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append(",");
                }
                String[] split = sb.toString().split(",");
                int i10 = 0;
                while (i10 < split.length) {
                    int i11 = i10 + 1;
                    if (i11 % 2 == 0 && i11 < split.length) {
                        this.mBrandMap.put(split[i10], split[i10 - 1]);
                    }
                    i10 = i11;
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public boolean isDisableIM() {
        return this.disableIM;
    }

    public void setBannerData(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "invalid mBannerData");
        }
        this.mBannerData = str;
    }

    public void setDebugAVListener(IDebugAVListener iDebugAVListener) {
        this.mDebugAVListener = iDebugAVListener;
    }

    public void setDebugTimestamp(boolean z10) {
        this.mDebugTimestamp = z10;
    }

    public void setDebugTimestampBean(DebugTimestampBean debugTimestampBean) {
        this.mDebugBean = debugTimestampBean;
    }

    public void setLogCallback(ILogCallback iLogCallback) {
        this.mLogCallback = iLogCallback;
    }

    public void setRegTime(long j10) {
        this.mRegTime = j10;
    }

    public void setSourceID(String str) {
        this.mSourceID = str;
        Preference.getInstance().put(Constant.KEY_SOURCE_ID, str);
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void updateHID() {
        AuthRepeatInfoBean authRepeatInfoBean = this.infoBean;
        if (authRepeatInfoBean == null || TextUtils.isEmpty(authRepeatInfoBean.getHid())) {
            this.mHID = LeboUtil.getNewSourceHID(this.mContext);
            SourceLog.i(TAG, "updateHID create new hid " + this.mHID);
            return;
        }
        this.mHID = this.infoBean.getHid();
        SourceLog.i(TAG, "updateHID use server hid " + this.mHID);
    }

    public void updateRepeatInfo(AuthRepeatInfoBean authRepeatInfoBean) {
        this.infoBean = authRepeatInfoBean;
        updateUID();
        updateHID();
    }

    public void updateUID() {
        AuthRepeatInfoBean authRepeatInfoBean = this.infoBean;
        if (authRepeatInfoBean == null || TextUtils.isEmpty(authRepeatInfoBean.getUid())) {
            this.mUID = String.valueOf(LeboUtil.getCUid64(this.mContext));
            SourceLog.i(TAG, "updateUID use local uid " + this.mUID);
            return;
        }
        this.mUID = this.infoBean.getUid();
        SourceLog.i(TAG, "updateUID use server uid " + this.mUID);
    }
}
