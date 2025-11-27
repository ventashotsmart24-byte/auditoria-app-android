package com.hpplay.sdk.source.da;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.da.a.a;
import com.hpplay.sdk.source.da.a.b;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.ADENSTUtils;
import com.taobao.accs.common.Constants;
import com.umeng.umcrash.UMCrash;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11814a = "DaRequest";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public l f11815b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AsyncTask f11816c;

    /* access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(f11814a, "parseDaConfig,json is invalid");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(Constants.KEY_HTTP_CODE);
            String optString = jSONObject.optString("data");
            String optString2 = jSONObject.optString("ciphertext");
            if (optInt != 200) {
                SourceLog.w(f11814a, "parseDaConfig, msg: " + jSONObject.optString(Constant.KEY_MSG));
                return;
            }
            if (TextUtils.isEmpty(optString)) {
                optString = null;
            }
            if (!TextUtils.isEmpty(optString2)) {
                optString = ADENSTUtils.decryptByKey(Session.getInstance().appSecret, optString2);
            }
            SourceLog.i(f11814a, "parseDaConfig resultData:" + optString);
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                d.a(jSONObject2.optInt("se_app_sw"));
                d.b(jSONObject2.optInt("dlna_sw"));
                String optString3 = jSONObject2.optString("re_app_list");
                if (!TextUtils.isEmpty(optString3)) {
                    d.a(optString3.substring(1, optString3.length() - 1));
                }
            }
        } catch (Exception e10) {
            SourceLog.w(f11814a, (Throwable) e10);
        }
    }

    /* access modifiers changed from: private */
    public a c(String str) {
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(f11814a, "parseDaBean,json is invalid");
            return null;
        }
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.f11756a = jSONObject.optInt(Constant.KEY_STATUS);
            String optString = jSONObject.optString("data");
            String optString2 = jSONObject.optString("aesda");
            if (aVar.f11756a != 200) {
                SourceLog.w(f11814a, "parseDaBean, error status");
                return aVar;
            }
            if (TextUtils.isEmpty(optString)) {
                optString = null;
            }
            if (!TextUtils.isEmpty(optString2)) {
                optString = ADENSTUtils.decryptByKey(Session.getInstance().appSecret, optString2);
            }
            SourceLog.debug(f11814a, "parseDaBean resultData:" + optString);
            if (TextUtils.isEmpty(optString)) {
                return aVar;
            }
            aVar.f11758c = jSONObject.optInt("adrnum");
            aVar.f11759d = jSONObject.optInt("adtout");
            JSONObject jSONObject2 = new JSONObject(optString);
            a.C0162a aVar2 = new a.C0162a();
            aVar2.f11760a = jSONObject2.optInt("postua");
            aVar2.f11761b = jSONObject2.optString("er");
            aVar2.f11762c = jSONObject2.optString("ads");
            aVar2.f11763d = jSONObject2.optInt("cid");
            aVar2.f11766g = jSONObject2.optString("surl");
            JSONArray optJSONArray = jSONObject2.optJSONArray("tpurl");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("tpurl2");
            aVar2.f11764e = new ArrayList();
            aVar2.f11765f = new ArrayList();
            if (optJSONArray != null) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    aVar2.f11764e.add(optJSONArray.optString(i10));
                }
            }
            if (optJSONArray2 != null) {
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    aVar2.f11765f.add(optJSONArray2.optString(i11));
                }
            }
            aVar.f11757b = aVar2;
            return aVar;
        } catch (Exception e10) {
            SourceLog.w(f11814a, "parseDaBean" + e10);
            return null;
        }
    }

    public void a() {
        String str = Session.getInstance().appKey;
        String str2 = Session.getInstance().appSecret;
        TreeMap treeMap = new TreeMap();
        treeMap.put("se_app_id", str);
        treeMap.put("se_uid", Session.getInstance().getUID());
        treeMap.put(UMCrash.SP_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        treeMap.put("sign", EncryptUtil.md5EncryData(HapplayUtils.getMapParams(treeMap) + str2).toLowerCase());
        AnonymousClass1 r02 = new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                if (asyncHttpParameter != null && asyncHttpParameter.out != null) {
                    SourceLog.debug(i.f11814a, "onRequestResult result:" + asyncHttpParameter.out.result);
                    if (asyncHttpParameter.out.resultType == 0) {
                        SourceLog.i(i.f11814a, "onRequestResult type:" + asyncHttpParameter.out.resultType);
                        i.b(asyncHttpParameter.out.result);
                    }
                }
            }
        };
        String mapParams = HapplayUtils.getMapParams(treeMap);
        SourceLog.debug(f11814a, "requestDaConfig url:" + CloudAPI.sQuerySeAppConfig + mapParams);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sQuerySeAppConfig, mapParams);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 0;
        in.connectTimeout = 10000;
        in.readTimeout = 10000;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, r02);
    }

    public void a(Context context, final b bVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(UMCrash.SP_KEY_TIMESTAMP, "" + System.currentTimeMillis());
        treeMap.put("adpos", bVar.f11767a);
        treeMap.put(ParamsMap.DeviceParams.KEY_APPID, bVar.f11768b);
        if (!TextUtils.isEmpty(bVar.f11769c)) {
            treeMap.put(ParamsMap.DeviceParams.KEY_HID, bVar.f11769c);
        }
        if (!TextUtils.isEmpty(bVar.f11770d)) {
            treeMap.put(ParamsMap.DeviceParams.KEY_UID, bVar.f11770d);
        }
        String wifiBSSIDNoneColon = NetworkUtil.getWifiBSSIDNoneColon(context);
        if (!TextUtils.isEmpty(wifiBSSIDNoneColon)) {
            treeMap.put("bid", wifiBSSIDNoneColon);
        }
        String aid = DeviceUtil.getAID(context);
        if (!TextUtils.isEmpty(aid)) {
            treeMap.put("manid", aid);
        }
        String oaid = DeviceUtil.getOAID(context);
        if (!TextUtils.isEmpty(oaid)) {
            treeMap.put("mloaid", oaid);
        }
        treeMap.put("cappid", Session.getInstance().appKey);
        treeMap.put("suid", Session.getInstance().getUID());
        treeMap.put("s", bVar.f11773g);
        treeMap.put("csv", "4.12.14");
        if (!TextUtils.isEmpty(bVar.f11771e)) {
            treeMap.put("udn", bVar.f11771e);
        }
        treeMap.put("uri", bVar.f11774h);
        treeMap.put("version", "1.1");
        treeMap.put("suuid", Preference.getInstance().get(Constant.KEY_VUUID, ""));
        treeMap.put("sssid", Preference.getInstance().get(Constant.KEY_VSESSION, ""));
        treeMap.put("url", bVar.f11772f);
        String md5EncryData = EncryptUtil.md5EncryData(HapplayUtils.getMapParamsWithoutEmpty(treeMap) + Session.getInstance().appSecret);
        if (!TextUtils.isEmpty(md5EncryData)) {
            treeMap.put("sign", md5EncryData.toLowerCase());
        }
        if (!TextUtils.isEmpty(bVar.f11772f)) {
            try {
                treeMap.put("url", URLEncoder.encode(bVar.f11772f, XML.CHARSET_UTF8));
            } catch (Exception e10) {
                SourceLog.w(f11814a, (Throwable) e10);
            }
        }
        final HttpEncrypt httpEncrypt = new HttpEncrypt();
        AnonymousClass2 r12 = new AsyncHttpRequestListener() {
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                String str;
                AsyncHttpParameter.Out out;
                AsyncHttpParameter.In in;
                AsyncTask unused = i.this.f11816c = null;
                if (asyncHttpParameter == null || (in = asyncHttpParameter.in) == null) {
                    str = "";
                } else {
                    str = in.id;
                }
                if (!(asyncHttpParameter == null || (out = asyncHttpParameter.out) == null || out.resultType == 2)) {
                    String decode = httpEncrypt.decode(out);
                    SourceLog.debug(i.f11814a, "requestDaData onRequestResult result:" + decode);
                    a a10 = i.this.c(decode);
                    if (i.this.f11815b != null) {
                        i.this.f11815b.a(bVar.f11767a, str, a10);
                        return;
                    }
                }
                if (i.this.f11815b != null) {
                    i.this.f11815b.a(bVar.f11767a, str, (a) null);
                }
            }
        };
        String mapParams = HapplayUtils.getMapParams(treeMap);
        SourceLog.debug(f11814a, "requestDaData params:" + CloudAPI.sSendCreative + mapParams);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sSendCreative, httpEncrypt.encode(mapParams));
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.tryCount = 1;
        in.id = String.valueOf(bVar.f11775i);
        asyncHttpParameter.in.requestHeaders = httpEncrypt.buildHeader();
        this.f11816c = AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, r12);
    }

    public void b() {
        if (this.f11816c != null) {
            SourceLog.i(f11814a, "release");
            this.f11816c.cancel(true);
            this.f11815b = null;
        }
    }

    public void c() {
        if (this.f11816c != null) {
            SourceLog.i(f11814a, "cancelTask");
            this.f11816c.cancel(true);
        }
    }

    public void a(l lVar) {
        this.f11815b = lVar;
    }
}
