package com.taobao.agoo.a.a;

import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;

public class d extends b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";

    /* renamed from: a  reason: collision with root package name */
    public String f13282a;

    /* renamed from: b  reason: collision with root package name */
    public String f13283b;

    /* renamed from: c  reason: collision with root package name */
    public String f13284c;

    public byte[] a() {
        try {
            p.a aVar = new p.a();
            aVar.a(b.JSON_CMD, this.f13262e).a(Constants.KEY_APP_KEY, this.f13282a);
            if (TextUtils.isEmpty(this.f13283b)) {
                aVar.a("utdid", this.f13284c);
            } else {
                aVar.a("deviceId", this.f13283b);
            }
            String jSONObject = aVar.a().toString();
            ALog.i("SwitchDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes(XML.CHARSET_UTF8);
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3, boolean z10) {
        d dVar = new d();
        dVar.f13282a = str;
        dVar.f13283b = str2;
        dVar.f13284c = str3;
        if (z10) {
            dVar.f13262e = JSON_CMD_ENABLEPUSH;
        } else {
            dVar.f13262e = JSON_CMD_DISABLEPUSH;
        }
        return dVar.a();
    }
}
