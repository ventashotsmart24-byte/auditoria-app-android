package com.alibaba.sdk.android.utils;

import java.util.Map;

public class SdkInfo {

    /* renamed from: a  reason: collision with root package name */
    String f5055a;

    /* renamed from: b  reason: collision with root package name */
    String f5056b;

    /* renamed from: c  reason: collision with root package name */
    String f5057c;

    /* renamed from: c  reason: collision with other field name */
    Map<String, String> f44c;

    public SdkInfo setAppKey(String str) {
        this.f5057c = str;
        return this;
    }

    public SdkInfo setExt(Map<String, String> map) {
        this.f44c = map;
        return this;
    }

    public SdkInfo setSdkId(String str) {
        this.f5055a = str;
        return this;
    }

    public SdkInfo setSdkVersion(String str) {
        this.f5056b = str;
        return this;
    }
}
