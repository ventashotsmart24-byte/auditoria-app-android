package com.hpplay.sdk.source.process;

import android.text.TextUtils;
import com.hpplay.sdk.source.browse.api.IAPI;
import com.hpplay.sdk.source.browse.api.IAPICallbackListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.KeepAliveUtitls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class OnlineCheckThread extends Thread {
    private static final String TAG = "OnlineCheckThread";
    private boolean isCompletion;
    private List<LelinkServiceInfo> mCopyLelinkServiceInfo = new CopyOnWriteArrayList();
    private IAPICallbackListener mIapiCallbackListener;
    private List<LelinkServiceInfo> mLelinkServiceInfos;

    public OnlineCheckThread(IAPICallbackListener iAPICallbackListener, List<LelinkServiceInfo> list) {
        setName(TAG);
        this.mLelinkServiceInfos = list;
        this.mIapiCallbackListener = iAPICallbackListener;
    }

    public static void doCheck(Collection<BrowserInfo> collection) {
        List<BrowserInfo> filterBrowserInfosByConnectType = filterBrowserInfosByConnectType(0, collection);
        if (filterBrowserInfosByConnectType != null && !filterBrowserInfosByConnectType.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("doCheck tcpCheck:");
            sb.append("\r\n");
            for (BrowserInfo next : filterBrowserInfosByConnectType) {
                if (!TextUtils.isEmpty(next.getIp())) {
                    boolean tcpCheckTvState = KeepAliveUtitls.tcpCheckTvState(next.getName(), next.getIp(), next.getPort());
                    sb.append("name:");
                    sb.append(next.getName());
                    sb.append(" alive state:");
                    sb.append(tcpCheckTvState);
                    sb.append("\r\n");
                    next.setLocalWifi(tcpCheckTvState);
                    next.setOnLine(tcpCheckTvState);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e10) {
                        SourceLog.w(TAG, (Throwable) e10);
                    }
                }
            }
            SourceLog.i(TAG, sb.toString());
        }
        List<BrowserInfo> filterBrowserInfosByConnectType2 = filterBrowserInfosByConnectType(1, collection);
        if (filterBrowserInfosByConnectType2 != null && !filterBrowserInfosByConnectType2.isEmpty()) {
            String httpPostCheckTvState = KeepAliveUtitls.httpPostCheckTvState(filterBrowserInfosByConnectType2);
            SourceLog.i(TAG, "doCheck cloud:" + httpPostCheckTvState);
        }
    }

    private static List<BrowserInfo> filterBrowserInfosByConnectType(int i10, Collection<BrowserInfo> collection) {
        if (collection == null || collection.isEmpty()) {
            SourceLog.i(TAG, "filterBrowserInfosByConnectType is empty");
            return null;
        }
        SourceLog.i(TAG, "filterBrowserInfosByConnectType");
        ArrayList arrayList = new ArrayList();
        for (BrowserInfo next : collection) {
            if (next.getConnectionType() == i10) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean isCompletion() {
        return this.isCompletion;
    }

    public void release() {
        this.mIapiCallbackListener = null;
        interrupt();
    }

    public void run() {
        super.run();
        try {
            this.isCompletion = false;
            this.mCopyLelinkServiceInfo.clear();
            this.mCopyLelinkServiceInfo.addAll(this.mLelinkServiceInfos);
            SourceLog.i(TAG, " init info size  : " + this.mCopyLelinkServiceInfo.size());
            if (this.mCopyLelinkServiceInfo.size() > 0) {
                for (LelinkServiceInfo next : this.mCopyLelinkServiceInfo) {
                    if (next != null) {
                        try {
                            Map<Integer, BrowserInfo> browserInfos = next.getBrowserInfos();
                            if (browserInfos != null) {
                                doCheck(browserInfos.values());
                            }
                        } catch (Exception e10) {
                            SourceLog.w(TAG, (Throwable) e10);
                        }
                    }
                }
            }
            if (this.mIapiCallbackListener != null) {
                SourceLog.i(TAG, " call back size : " + this.mCopyLelinkServiceInfo.size());
                this.mIapiCallbackListener.onResult(IAPI.OPTION_3, this.mCopyLelinkServiceInfo);
                this.isCompletion = true;
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, (Throwable) e11);
        }
    }
}
