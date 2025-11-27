package com.hpplay.sdk.source.process;

import com.hpplay.sdk.source.bean.BrowserConfigBean;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.concurrent.LinkedBlockingQueue;

public class BrowserThread extends Thread {
    private static final int BROWSER_START = 0;
    private static final int BROWSER_STOP = 1;
    private static final String TAG = "BrowserThread";
    private LinkedBlockingQueue<Integer> browserQeue = new LinkedBlockingQueue<>(2);
    private BrowserConfigBean configBean;
    private boolean isStart;

    public BrowserThread(BrowserConfigBean browserConfigBean) {
        this.configBean = browserConfigBean;
        this.isStart = true;
    }

    public void release() {
        this.isStart = false;
        interrupt();
    }

    public void run() {
        super.run();
        while (this.isStart) {
            try {
                int intValue = this.browserQeue.take().intValue();
                SourceLog.i(TAG, "browser flag => " + intValue + " b size " + this.browserQeue.size());
                if (intValue == 0) {
                    LelinkSdkManager.getInstance().stopBrowse();
                    LelinkSdkManager.getInstance().browse(this.configBean);
                } else {
                    LelinkSdkManager.getInstance().stopBrowse();
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
                return;
            }
        }
    }

    public void setConfigBean(BrowserConfigBean browserConfigBean) {
        this.configBean = browserConfigBean;
    }

    public void startBrowse() {
        try {
            this.browserQeue.add(0);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void stopBrowser() {
        try {
            this.browserQeue.add(1);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }
}
