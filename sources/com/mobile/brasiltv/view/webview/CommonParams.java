package com.mobile.brasiltv.view.webview;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;
import w6.i;

public class CommonParams {
    private final String TAG = CommonParams.class.getSimpleName();
    private boolean isEnterBrowser;
    private String mShareInvitationCode;

    public CommonParams(boolean z10, String str) {
        this.isEnterBrowser = z10;
        this.mShareInvitationCode = str;
    }

    @JavascriptInterface
    public String getAppId() {
        b0.U(this, "getAppId");
        return "com.msandroid.mobile";
    }

    @JavascriptInterface
    public String getCpuInfo() {
        b0.U(this, "getCpuInfo");
        return Build.CPU_ABI;
    }

    @JavascriptInterface
    public String getHardwareInfo() {
        b0.U(this, "getHardwareInfo");
        return Build.HARDWARE;
    }

    @JavascriptInterface
    public String getLanguage() {
        b0.U(this, "getLanguage");
        return f0.a();
    }

    @JavascriptInterface
    public String getModelInfo() {
        b0.U(this, "getModelInfo");
        return Build.MODEL;
    }

    @JavascriptInterface
    public String getPlatformType() {
        b0.U(this, "getPlatformType");
        return "3";
    }

    @JavascriptInterface
    public String getProductInfo() {
        b0.U(this, "getProductInfo");
        return Build.PRODUCT;
    }

    @JavascriptInterface
    public String getPublicJson() {
        b0.U(this, "getPublicJson");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", "com.msandroid.mobile");
            i.c cVar = i.f9510g;
            jSONObject.put("sn", cVar.E());
            jSONObject.put("versionCode", 60201);
            jSONObject.put("language", f0.a());
            jSONObject.put("userId", cVar.H());
            jSONObject.put("userIdentity", cVar.I());
            jSONObject.put("platformType", 3);
            jSONObject.put("systemVersion", Build.VERSION.RELEASE);
            jSONObject.put("hardware", Build.HARDWARE);
            jSONObject.put(Constants.KEY_MODEL, Build.MODEL);
            jSONObject.put("product", Build.PRODUCT);
            jSONObject.put(bt.f13929w, Build.CPU_ABI);
            jSONObject.put("portalCode", cVar.v());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getShareInvitationCode() {
        return this.mShareInvitationCode;
    }

    @JavascriptInterface
    public String getSystemVersion() {
        b0.U(this, "getSystemVersion");
        return Build.VERSION.RELEASE;
    }

    @JavascriptInterface
    public String getTk() {
        b0.U(this, "getTk");
        return i.f9510g.J();
    }

    @JavascriptInterface
    public String getUserId() {
        b0.U(this, "getUserId");
        return i.f9510g.H();
    }

    @JavascriptInterface
    public String getUserIdentity() {
        b0.U(this, "getUserIdentity");
        return i.f9510g.I();
    }

    @JavascriptInterface
    public String getUserInfo(String str) {
        b0.U(this, "getUserInfo key: " + str);
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1666653158:
                if (str.equals("areaCode")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1068855134:
                if (str.equals("mobile")) {
                    c10 = 1;
                    break;
                }
                break;
            case -822574282:
                if (str.equals("googlePhotoUrl")) {
                    c10 = 2;
                    break;
                }
                break;
            case 96619420:
                if (str.equals(Scopes.EMAIL)) {
                    c10 = 3;
                    break;
                }
                break;
            case 521442791:
                if (str.equals("googleNickName")) {
                    c10 = 4;
                    break;
                }
                break;
            case 866168583:
                if (str.equals("accountType")) {
                    c10 = 5;
                    break;
                }
                break;
            case 1594221417:
                if (str.equals("couponQualification")) {
                    c10 = 6;
                    break;
                }
                break;
            case 2043958003:
                if (str.equals("activeTime")) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return i.f9510g.f();
            case 1:
                return i.f9510g.t();
            case 2:
                return i.f9510g.q();
            case 3:
                return i.f9510g.m();
            case 4:
                return i.f9510g.p();
            case 5:
                return i.f9510g.c();
            case 6:
                return i.f9510g.M() ? "1" : "0";
            case 7:
                return i.f9510g.d();
            default:
                return "";
        }
    }

    @JavascriptInterface
    public int getVersionCode() {
        b0.U(this, "getVersionCode");
        return 60201;
    }

    @JavascriptInterface
    public boolean isEnterFromBrowser() {
        b0.U(this, "isEnterFromBrowser");
        return this.isEnterBrowser;
    }

    @JavascriptInterface
    public String getUserInfo() {
        b0.U(this, "getUserInfo");
        JSONObject jSONObject = new JSONObject();
        try {
            i.c cVar = i.f9510g;
            jSONObject.put("userId", cVar.H());
            jSONObject.put("userIdentity", cVar.I());
            jSONObject.put("activeTime", cVar.d());
            jSONObject.put(Scopes.EMAIL, cVar.m());
            jSONObject.put("mobile", cVar.t());
            jSONObject.put("areaCode", cVar.f());
            jSONObject.put("googleNickName", cVar.p());
            jSONObject.put("googlePhotoUrl", cVar.q());
            jSONObject.put("accountType", cVar.c());
            jSONObject.put("couponQualification", cVar.M() ? "1" : "0");
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }
}
