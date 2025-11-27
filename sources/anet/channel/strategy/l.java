package anet.channel.strategy;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

public class l {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f3951a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3952b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3953c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3954d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3955e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3956f;

        /* renamed from: g  reason: collision with root package name */
        public final String f3957g;

        /* renamed from: h  reason: collision with root package name */
        public final String f3958h;

        public a(JSONObject jSONObject) {
            this.f3951a = jSONObject.optInt("port");
            this.f3952b = jSONObject.optString("protocol");
            this.f3953c = jSONObject.optInt("cto");
            this.f3954d = jSONObject.optInt("rto");
            this.f3955e = jSONObject.optInt("retry");
            this.f3956f = jSONObject.optInt("heartbeat");
            this.f3957g = jSONObject.optString("rtt", "");
            this.f3958h = jSONObject.optString("publickey");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f3959a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3960b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3961c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3962d;

        /* renamed from: e  reason: collision with root package name */
        public final String f3963e;

        /* renamed from: f  reason: collision with root package name */
        public final String[] f3964f;

        /* renamed from: g  reason: collision with root package name */
        public final String[] f3965g;

        /* renamed from: h  reason: collision with root package name */
        public final a[] f3966h;

        /* renamed from: i  reason: collision with root package name */
        public final e[] f3967i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f3968j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f3969k;

        /* renamed from: l  reason: collision with root package name */
        public final int f3970l;

        public b(JSONObject jSONObject) {
            this.f3959a = jSONObject.optString(Constants.KEY_HOST);
            this.f3960b = jSONObject.optInt("ttl");
            this.f3961c = jSONObject.optString("safeAisles");
            this.f3962d = jSONObject.optString(BrowserInfo.KEY_CNAME, (String) null);
            this.f3963e = jSONObject.optString("unit", (String) null);
            this.f3968j = jSONObject.optInt("clear") != 1 ? false : true;
            this.f3969k = jSONObject.optBoolean("effectNow");
            this.f3970l = jSONObject.optInt("version");
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f3964f = new String[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f3964f[i10] = optJSONArray.optString(i10);
                }
            } else {
                this.f3964f = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sips");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                this.f3965g = null;
            } else {
                int length2 = optJSONArray2.length();
                this.f3965g = new String[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    this.f3965g[i11] = optJSONArray2.optString(i11);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("aisles");
            if (optJSONArray3 != null) {
                int length3 = optJSONArray3.length();
                this.f3966h = new a[length3];
                for (int i12 = 0; i12 < length3; i12++) {
                    this.f3966h[i12] = new a(optJSONArray3.optJSONObject(i12));
                }
            } else {
                this.f3966h = null;
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("strategies");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                this.f3967i = null;
                return;
            }
            int length4 = optJSONArray4.length();
            this.f3967i = new e[length4];
            for (int i13 = 0; i13 < length4; i13++) {
                this.f3967i[i13] = new e(optJSONArray4.optJSONObject(i13));
            }
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f3971a;

        /* renamed from: b  reason: collision with root package name */
        public final e[] f3972b;

        public c(JSONObject jSONObject) {
            this.f3971a = jSONObject.optString(Constants.KEY_HOST);
            JSONArray optJSONArray = jSONObject.optJSONArray("strategies");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f3972b = new e[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f3972b[i10] = new e(optJSONArray.optJSONObject(i10));
                }
                return;
            }
            this.f3972b = null;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f3973a;

        /* renamed from: b  reason: collision with root package name */
        public final b[] f3974b;

        /* renamed from: c  reason: collision with root package name */
        public final c[] f3975c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3976d;

        /* renamed from: e  reason: collision with root package name */
        public final String f3977e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3978f;

        /* renamed from: g  reason: collision with root package name */
        public final int f3979g;

        /* renamed from: h  reason: collision with root package name */
        public final int f3980h;

        public d(JSONObject jSONObject) {
            this.f3973a = jSONObject.optString("ip");
            this.f3976d = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID, (String) null);
            this.f3977e = jSONObject.optString("utdid", (String) null);
            this.f3978f = jSONObject.optInt(DispatchConstants.CONFIG_VERSION);
            this.f3979g = jSONObject.optInt("fcl");
            this.f3980h = jSONObject.optInt("fct");
            JSONArray optJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f3974b = new b[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f3974b[i10] = new b(optJSONArray.optJSONObject(i10));
                }
            } else {
                this.f3974b = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                this.f3975c = new c[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    this.f3975c[i11] = new c(optJSONArray2.optJSONObject(i11));
                }
                return;
            }
            this.f3975c = null;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f3981a;

        /* renamed from: b  reason: collision with root package name */
        public final a f3982b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3983c;

        public e(JSONObject jSONObject) {
            this.f3981a = jSONObject.optString("ip");
            this.f3983c = jSONObject.optString("path");
            this.f3982b = new a(jSONObject);
        }
    }

    public static d a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e10) {
            ALog.e("StrategyResultParser", "Parse HttpDns response failed.", (String) null, e10, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
