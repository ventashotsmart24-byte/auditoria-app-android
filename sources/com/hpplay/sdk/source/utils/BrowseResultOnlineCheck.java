package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.ConnectManager;
import java.util.Map;

public class BrowseResultOnlineCheck {
    private static final String TAG = "BrowseResultOnlineCheck";
    private static final int WHAT_CALLBACK_DISCONNECT = 4;
    private static final int WHAT_TOAST_OFFLINE = 3;
    private static BrowseResultOnlineCheck sInstance;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 3) {
                try {
                    LelinkServiceInfo lelinkServiceInfo = (LelinkServiceInfo) message.obj;
                    ConnectManager.getInstance().notifyOffline(lelinkServiceInfo);
                    if (!Feature.isXigua()) {
                        return false;
                    }
                    if (BrowseResultOnlineCheck.this.mContext == null) {
                        return false;
                    }
                    if (lelinkServiceInfo != null) {
                        if (!TextUtils.isEmpty(lelinkServiceInfo.getName())) {
                            Context applicationContext = BrowseResultOnlineCheck.this.mContext.getApplicationContext();
                            Toast.makeText(applicationContext, lelinkServiceInfo.getName() + "已离线，请打开电视应用重新搜索投屏", 1).show();
                            return false;
                        }
                    }
                    Toast.makeText(BrowseResultOnlineCheck.this.mContext.getApplicationContext(), "接收端设备已离线，请打开电视应用重新搜索投屏", 1).show();
                    return false;
                } catch (Exception e10) {
                    SourceLog.w(BrowseResultOnlineCheck.TAG, (Throwable) e10);
                    return false;
                }
            } else if (i10 != 4) {
                return false;
            } else {
                try {
                    int i11 = message.arg1;
                    int i12 = message.arg2;
                    ConnectManager.getInstance().notifyDisconnect((LelinkServiceInfo) message.obj, i11, i12);
                    return false;
                } catch (Exception e11) {
                    SourceLog.w(BrowseResultOnlineCheck.TAG, (Throwable) e11);
                    return false;
                }
            }
        }
    });

    private BrowseResultOnlineCheck() {
    }

    public static synchronized BrowseResultOnlineCheck getInstance() {
        BrowseResultOnlineCheck browseResultOnlineCheck;
        synchronized (BrowseResultOnlineCheck.class) {
            synchronized (BrowseResultOnlineCheck.class) {
                if (sInstance == null) {
                    sInstance = new BrowseResultOnlineCheck();
                }
            }
            browseResultOnlineCheck = sInstance;
        }
        return browseResultOnlineCheck;
    }

    public void checkDeviceOnline(final LelinkServiceInfo lelinkServiceInfo, final int i10, final int i11) {
        if (lelinkServiceInfo == null) {
            SourceLog.w(TAG, "checkDeviceOnline ignore");
        } else {
            AsyncManager.getInstance().exeRunnable(new Runnable() {
                public void run() {
                    try {
                        Map<Integer, BrowserInfo> browserInfos = lelinkServiceInfo.getBrowserInfos();
                        if (browserInfos != null) {
                            if (browserInfos.get(1) != null) {
                                if (!KeepAliveUtitls.tcpCheckTvState(lelinkServiceInfo.getName(), lelinkServiceInfo.getIp(), lelinkServiceInfo.getPort())) {
                                    SourceLog.i(BrowseResultOnlineCheck.TAG, "checkDeviceOnline " + lelinkServiceInfo.getName() + " " + lelinkServiceInfo.getIp() + " lelink is offline, browse again");
                                    if (BrowseResultOnlineCheck.this.mHandler != null) {
                                        BrowseResultOnlineCheck.this.mHandler.obtainMessage(3, lelinkServiceInfo).sendToTarget();
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (browserInfos.get(3) != null && !KeepAliveUtitls.tcpCheckTvState(lelinkServiceInfo.getName(), lelinkServiceInfo.getIp(), lelinkServiceInfo.getPort())) {
                                SourceLog.i(BrowseResultOnlineCheck.TAG, "checkDeviceOnline " + lelinkServiceInfo.getName() + " " + lelinkServiceInfo.getIp() + " dlna is offline, browse again");
                                if (BrowseResultOnlineCheck.this.mHandler != null) {
                                    BrowseResultOnlineCheck.this.mHandler.obtainMessage(3, lelinkServiceInfo).sendToTarget();
                                }
                            } else if (BrowseResultOnlineCheck.this.mHandler != null) {
                                BrowseResultOnlineCheck.this.mHandler.obtainMessage(4, i10, i11, lelinkServiceInfo).sendToTarget();
                            }
                        }
                    } catch (Exception e10) {
                        SourceLog.w(BrowseResultOnlineCheck.TAG, (Throwable) e10);
                    }
                }
            }, (AsyncRunnableListener) null);
        }
    }

    public void release() {
        SourceLog.i(TAG, "release");
    }

    public void setContext(Context context) {
        this.mContext = context;
    }
}
