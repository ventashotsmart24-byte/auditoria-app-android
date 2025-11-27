package com.efs.sdk.base.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.taobao.accs.common.Constants;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalInfo {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f5212a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.f5212a.put(str, obj);
        }
    }

    public final Object b(String str, Object obj) {
        Object obj2 = this.f5212a.get(str);
        if (obj2 != null || this.f5212a.containsKey(str)) {
            return obj2;
        }
        return obj;
    }

    public Map<String, Object> getGlobalInfoMap() {
        HashMap hashMap = new HashMap(this.f5212a);
        a.a();
        hashMap.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        hashMap.put("w_tm", Long.valueOf(a.b() / 1000));
        return hashMap;
    }

    public List<AbsSection> getGlobalSectionList(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection put = kVSection.put("type", str).put(ParamsMap.DeviceParams.KEY_APPID, this.f5212a.get(ParamsMap.DeviceParams.KEY_APPID)).put("wid", this.f5212a.get("wid")).put("pid", this.f5212a.get("pid")).put("pkg", this.f5212a.get("pkg")).put(BrowserInfo.KEY_VER, this.f5212a.get(BrowserInfo.KEY_VER)).put("vcode", this.f5212a.get("vcode")).put("ps", this.f5212a.get("ps")).put("stime", this.f5212a.get("stime"));
        a.a();
        KVSection put2 = put.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        put2.put("w_tm", Long.valueOf(a.b() / 1000)).put("sdk_ver", this.f5212a.get("sdk_ver"));
        String valueOf = String.valueOf(b(ParamsMap.DeviceParams.KEY_UID, ""));
        if (!TextUtils.isEmpty(valueOf)) {
            kVSection.put(ParamsMap.DeviceParams.KEY_UID, valueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put("lang", this.f5212a.get("lang")).put(Constants.KEY_BRAND, this.f5212a.get(Constants.KEY_BRAND)).put(Constants.KEY_MODEL, this.f5212a.get(Constants.KEY_MODEL)).put("build_model", this.f5212a.get("build_model")).put("rom", this.f5212a.get("rom")).put(com.umeng.ccg.a.f14528u, this.f5212a.get(com.umeng.ccg.a.f14528u)).put("dsp_h", this.f5212a.get("dsp_h")).put("dsp_w", this.f5212a.get("dsp_w")).put("tzone", this.f5212a.get("tzone")).put("net", this.f5212a.get("net")).put("fr", this.f5212a.get("fr"));
        try {
            if (this.f5212a.containsKey(UMCrash.KEY_HEADER_ACCESS)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS, this.f5212a.get(UMCrash.KEY_HEADER_ACCESS));
            }
            if (this.f5212a.containsKey(UMCrash.KEY_HEADER_ACCESS_SUBTYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, this.f5212a.get(UMCrash.KEY_HEADER_ACCESS_SUBTYPE));
            }
            if (this.f5212a.containsKey(UMCrash.KEY_HEADER_NETWORK_TYPE)) {
                kVSection2.put(UMCrash.KEY_HEADER_NETWORK_TYPE, this.f5212a.get(UMCrash.KEY_HEADER_NETWORK_TYPE));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    public String getUUID(Context context) {
        String valueOf = String.valueOf(b("wid", ""));
        if (!TextUtils.isEmpty(valueOf)) {
            return valueOf;
        }
        String a10 = c.a(context);
        a("wid", a10);
        return a10;
    }
}
