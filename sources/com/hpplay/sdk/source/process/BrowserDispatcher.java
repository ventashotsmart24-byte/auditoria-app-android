package com.hpplay.sdk.source.process;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.easycast.BrowserDevice;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.BrowserResolver;
import com.hpplay.sdk.source.utils.CastUtil;
import java.util.ArrayList;
import java.util.List;

public class BrowserDispatcher implements IBrowseListener {
    private static final String TAG = "IBrowserDispatcher";
    private final int DELAY_NOTIFY_WITH_DLNA = 2000;
    private final int WHAT_DELAY_NOTIFY_WITH_DLNA = 1;
    /* access modifiers changed from: private */
    public boolean isOnlyNotifyLelink = false;
    /* access modifiers changed from: private */
    public final List<LelinkServiceInfo> mBrowserList = new ArrayList();
    private long mBrowserTimeStamp = -1;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (BrowserDispatcher.this.hasLelink()) {
                    boolean unused = BrowserDispatcher.this.isOnlyNotifyLelink = true;
                } else {
                    boolean unused2 = BrowserDispatcher.this.isOnlyNotifyLelink = false;
                    SourceLog.i(BrowserDispatcher.TAG, "WHAT_DELAY_NOTIFY_ALL ");
                    if (BrowserDispatcher.this.mBrowserList.size() > 0 && BrowserDispatcher.this.mOuterBrowseListener != null) {
                        BrowserDispatcher.this.mOuterBrowseListener.onBrowse(1, BrowserDispatcher.this.filterLelink());
                    }
                }
            }
            return false;
        }
    });
    /* access modifiers changed from: private */
    public IBrowseListener mOuterBrowseListener;
    private IBrowseListener mRetryIBrowseListener;

    /* access modifiers changed from: private */
    public List<LelinkServiceInfo> filterLelink() {
        List<LelinkServiceInfo> list;
        SourceLog.i(TAG, "filterLelink,isOnlyNotifyLelink:" + this.isOnlyNotifyLelink);
        if (!this.isOnlyNotifyLelink) {
            list = BrowserDevice.getInstance().serviceListSort(this.mBrowserList);
        } else {
            ArrayList arrayList = new ArrayList();
            for (LelinkServiceInfo next : this.mBrowserList) {
                if (CastUtil.isSupportLelink(next)) {
                    arrayList.add(next);
                }
            }
            list = BrowserDevice.getInstance().serviceListSort(arrayList);
        }
        String sinkAppSearchNamePrefer = SDKConfig.getInstance().getSinkAppSearchNamePrefer();
        if (!TextUtils.isEmpty(sinkAppSearchNamePrefer) && list != null && list.size() > 0) {
            LelinkServiceInfo lelinkServiceInfo = list.get(0);
            if (BrowserDevice.PACKAGE_NAME_SINK_APP.equalsIgnoreCase(lelinkServiceInfo.getPackageName()) && !lelinkServiceInfo.getName().endsWith(sinkAppSearchNamePrefer)) {
                SourceLog.i(TAG, "filterLelink,set sink app search name prefer");
                lelinkServiceInfo.setName(lelinkServiceInfo.getName() + sinkAppSearchNamePrefer);
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public boolean hasLelink() {
        for (LelinkServiceInfo isSupportLelink : this.mBrowserList) {
            if (CastUtil.isSupportLelink(isSupportLelink)) {
                return true;
            }
        }
        return false;
    }

    private void notifyBrowserResult(int i10) {
        if (this.mOuterBrowseListener != null) {
            List<LelinkServiceInfo> filterLelink = filterLelink();
            if (i10 != 1) {
                this.mHandler.removeMessages(1);
                this.mOuterBrowseListener.onBrowse(i10, filterLelink);
            } else if (!filterLelink.isEmpty()) {
                this.mHandler.removeMessages(1);
                this.mOuterBrowseListener.onBrowse(i10, filterLelink);
            }
        }
    }

    public void browser() {
        this.mBrowserTimeStamp = System.currentTimeMillis();
        this.isOnlyNotifyLelink = Session.getInstance().isPreferLelink;
        if (Session.getInstance().isPreferLelink) {
            this.mHandler.sendEmptyMessageDelayed(1, 2000);
        }
    }

    public void clearBrowserList() {
        List<LelinkServiceInfo> list = this.mBrowserList;
        if (list != null) {
            list.clear();
        }
        this.mRetryIBrowseListener = null;
    }

    public List<LelinkServiceInfo> getBrowserList() {
        return this.mBrowserList;
    }

    public void notifyBrowserStop() {
        IBrowseListener iBrowseListener = this.mOuterBrowseListener;
        if (iBrowseListener != null) {
            iBrowseListener.onBrowse(2, filterLelink());
        }
    }

    public void notifyBrowserSuccess() {
        notifyBrowserResult(1);
    }

    public void onBrowse(int i10, List<LelinkServiceInfo> list) {
        BrowserResolver.updateServiceList(list);
        notifyBrowserResult(i10);
        IBrowseListener iBrowseListener = this.mRetryIBrowseListener;
        if (iBrowseListener != null) {
            iBrowseListener.onBrowse(i10, list);
        }
    }

    public void setBrowseListener(IBrowseListener iBrowseListener) {
        this.mOuterBrowseListener = iBrowseListener;
    }

    public void setRetryBrowseListener(IBrowseListener iBrowseListener) {
        this.mRetryIBrowseListener = iBrowseListener;
    }

    public void stopBrowser() {
        this.mHandler.removeMessages(1);
    }
}
