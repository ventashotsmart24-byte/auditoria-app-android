package com.mobile.brasiltv.view.webview;

import android.webkit.JavascriptInterface;

public class ExtraJson {
    private String mExtraJson;

    public ExtraJson(String str) {
        this.mExtraJson = str;
    }

    @JavascriptInterface
    public String getParamJson() {
        return this.mExtraJson;
    }
}
