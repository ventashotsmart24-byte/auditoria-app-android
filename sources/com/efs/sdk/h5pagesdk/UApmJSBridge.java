package com.efs.sdk.h5pagesdk;

import android.webkit.JavascriptInterface;

public class UApmJSBridge {
    @JavascriptInterface
    public String getLaunchOptionsSync() {
        try {
            if (H5Manager.getH5ConfigMananger() != null) {
                String generateLaunchOptions = H5Manager.getH5ConfigMananger().generateLaunchOptions();
                String str = H5Manager.TAG;
                return generateLaunchOptions;
            }
            String str2 = H5Manager.TAG;
            return "";
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void sendData(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    boolean z10 = H5Manager.isDebug;
                    if (H5Manager.getH5ConfigMananger() != null) {
                        H5Manager.getH5ConfigMananger().sendData(str);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
