package com.hpplay.sdk.source.easycast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.hpplay.sdk.source.api.ISearchBannerDataCallback;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.browse.api.IServiceSelectListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browser.b.b;
import com.hpplay.sdk.source.browser.c;
import com.hpplay.sdk.source.browser.view.a;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.ArrayList;
import java.util.List;

public class BrowserController {
    private static final String TAG = "BrowserController";
    public boolean isPush;
    /* access modifiers changed from: private */
    public a mBrowserView;
    private c mBusinessCallback = new c() {
        public void onDestroy() {
            SourceLog.i(BrowserController.TAG, "IBrowserUICallback onDestroy");
            BrowserController.this.mHandler.post(new Runnable() {
                public void run() {
                    BrowserController.this.destroyView();
                }
            });
        }

        public void onRefresh() {
            BrowserController.this.browser();
        }

        public void onSelect(int i10, com.hpplay.sdk.source.browser.a.a aVar) {
            try {
                for (LelinkServiceInfo lelinkServiceInfo : BrowserController.this.mLelinkServiceInfoList) {
                    if (lelinkServiceInfo.getName().equals(aVar.b())) {
                        SourceLog.i(BrowserController.TAG, "IBrowserUICallback onSelect position:" + i10 + ", info:" + lelinkServiceInfo);
                        BrowserController.this.mServiceSelectListener.onSelect(lelinkServiceInfo);
                        BrowserDevice.getInstance().setSelectInfo(lelinkServiceInfo);
                    }
                }
            } catch (Exception e10) {
                SourceLog.w(BrowserController.TAG, (Throwable) e10);
            }
        }
    };
    private IEasyCastListener mCastListener;
    private ViewGroup mContainerView = null;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public List<com.hpplay.sdk.source.browser.a.a> mLelinkServiceBeanList;
    /* access modifiers changed from: private */
    public List<LelinkServiceInfo> mLelinkServiceInfoList;
    private IEasyDeviceListener mListener = new IEasyDeviceListener() {
        public void onBrowserResult(int i10) {
            if (BrowserController.this.mBrowserView != null) {
                BrowserController.this.mBrowserView.a(i10);
            }
        }

        public void onConnect(LelinkServiceInfo lelinkServiceInfo) {
        }

        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            BrowserController.this.notifyError("网络异常", "请检查\n大屏和手机端网络后重试");
        }

        public synchronized void onUpdateDevices(List<LelinkServiceInfo> list) {
            if (BrowserController.this.mBrowserView != null) {
                List unused = BrowserController.this.mLelinkServiceInfoList = list;
                BrowserController.this.mLelinkServiceBeanList.clear();
                try {
                    boolean z10 = false;
                    for (LelinkServiceInfo lelinkServiceInfo : BrowserController.this.mLelinkServiceInfoList) {
                        try {
                            if (BrowserController.this.isPush || lelinkServiceInfo.getTypes().toLowerCase().contains("lelink")) {
                                com.hpplay.sdk.source.browser.a.a aVar = new com.hpplay.sdk.source.browser.a.a();
                                aVar.a(lelinkServiceInfo.getAppId());
                                aVar.c(lelinkServiceInfo.getIp());
                                aVar.b(lelinkServiceInfo.getName());
                                aVar.a(lelinkServiceInfo.getUid());
                                if (!z10 && BrowserDevice.getInstance().isSelectInfo(lelinkServiceInfo)) {
                                    aVar.a(true);
                                    z10 = true;
                                }
                                BrowserController.this.mLelinkServiceBeanList.add(aVar);
                            } else {
                                SourceLog.i(BrowserController.TAG, "++++++++++++++++++++++" + lelinkServiceInfo.getName());
                            }
                        } catch (Exception e10) {
                            SourceLog.w(BrowserController.TAG, (Throwable) e10);
                        }
                    }
                } catch (Exception e11) {
                    SourceLog.w(BrowserController.TAG, (Throwable) e11);
                }
                BrowserController.this.mBrowserView.a((List<com.hpplay.sdk.source.browser.a.a>) BrowserController.this.mLelinkServiceBeanList);
            }
        }
    };
    /* access modifiers changed from: private */
    public IServiceSelectListener mServiceSelectListener;

    public BrowserController(ViewGroup viewGroup, boolean z10) {
        this.mContainerView = viewGroup;
        this.mLelinkServiceBeanList = new ArrayList();
        this.isPush = z10;
        initView();
    }

    private void initView() {
        if (this.mContainerView == null) {
            SourceLog.w(TAG, "initView ignore,mContainerView is null");
            return;
        }
        a aVar = this.mBrowserView;
        if (aVar == null || aVar.getParent() == null) {
            Context context = this.mContainerView.getContext();
            b.d(context);
            a aVar2 = new a(context, Session.getInstance().getBannerData());
            this.mBrowserView = aVar2;
            aVar2.setBusinessCallback(this.mBusinessCallback);
            LelinkSourceSDK.getInstance().setSearchBannerDataCallback(new ISearchBannerDataCallback() {
                public void onBannerData(final String str) {
                    if (BrowserController.this.mBrowserView != null) {
                        SourceLog.i(BrowserController.TAG, "onBannerData");
                        BrowserController.this.mBrowserView.postDelayed(new Runnable() {
                            public void run() {
                                BrowserController.this.mBrowserView.a(str);
                            }
                        }, 0);
                        Session.getInstance().setBannerData(str);
                    }
                }
            });
            this.mContainerView.addView(this.mBrowserView, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        SourceLog.w(TAG, "initView ignore, parent is not null");
    }

    public void browser() {
        BrowserDevice.getInstance().setDeviceListener(this.mListener);
        BrowserDevice.getInstance().clearBrowseList();
        LelinkSourceSDK.getInstance().startBrowse();
    }

    public void destroyView() {
        SourceLog.i(TAG, "destroyView mBrowserView:" + this.mBrowserView);
        a aVar = this.mBrowserView;
        if (aVar != null) {
            aVar.a();
            if (this.mBrowserView.getParent() != null) {
                try {
                    SourceLog.i(TAG, "destroyView parent:" + this.mBrowserView.getParent());
                    ((ViewGroup) this.mBrowserView.getParent()).removeView(this.mBrowserView);
                    IEasyCastListener iEasyCastListener = this.mCastListener;
                    if (iEasyCastListener != null) {
                        iEasyCastListener.onDismiss();
                    }
                } catch (Exception e10) {
                    SourceLog.w(TAG, (Throwable) e10);
                }
            }
            this.mBrowserView = null;
        }
    }

    public boolean isShowing() {
        ViewGroup viewGroup = this.mContainerView;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return false;
        }
        return true;
    }

    public void notifyError(String str, String str2) {
        a aVar = this.mBrowserView;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void release() {
        destroyView();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void setCastListener(IEasyCastListener iEasyCastListener) {
        this.mCastListener = iEasyCastListener;
    }

    public void setServiceSelectListener(IServiceSelectListener iServiceSelectListener) {
        this.mServiceSelectListener = iServiceSelectListener;
    }
}
