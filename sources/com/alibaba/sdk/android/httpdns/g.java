package com.alibaba.sdk.android.httpdns;

import com.taobao.accs.common.Constants;
import org.json.JSONObject;

class g {

    /* renamed from: b  reason: collision with root package name */
    private int f4979b;

    /* renamed from: e  reason: collision with root package name */
    private String f4980e;

    public g(int i10, String str) {
        this.f4979b = i10;
        this.f4980e = new JSONObject(str).getString(Constants.KEY_HTTP_CODE);
    }

    public String b() {
        return this.f4980e;
    }

    public int getErrorCode() {
        return this.f4979b;
    }
}
