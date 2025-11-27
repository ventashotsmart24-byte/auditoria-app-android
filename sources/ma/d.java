package ma;

import android.content.Context;
import c2.l;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import na.a;
import t9.i;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f18993a = new d();

    public final void a(Context context, String str, String str2, String str3, String str4) {
        i.g(context, f.X);
        i.g(str, "dnsType");
        i.g(str2, Constants.KEY_HOST);
        i.g(str3, "mapper");
        i.g(str4, "resolver");
        HashMap hashMap = new HashMap();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        i.f(format, "sDateFormat.format(Date())");
        hashMap.put("key_start_time", format);
        String h10 = a.h();
        i.f(h10, "getSn()");
        hashMap.put("sn", h10);
        String userId = l.f4666a.b().getUserId();
        if (userId == null) {
            userId = "";
        }
        hashMap.put("userId", userId);
        hashMap.put("apkVersion", String.valueOf(a.b()));
        hashMap.put("key_dns_type", str);
        hashMap.put("key_host", str2);
        hashMap.put("key_mapper", str3);
        hashMap.put("key_resolver", str4);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_BIGBEE_APP_DNS", (Map<String, String>) hashMap);
    }

    public final void b(Context context, String str, String str2, int i10, String str3) {
        i.g(context, f.X);
        i.g(str, "uri");
        i.g(str2, "domain");
        i.g(str3, "userName");
        if (i10 >= 0) {
            HashMap hashMap = new HashMap();
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            i.f(format, "sDateFormat.format(Date())");
            hashMap.put("key_start_time", format);
            String h10 = a.h();
            i.f(h10, "getSn()");
            hashMap.put("sn", h10);
            String userId = l.f4666a.b().getUserId();
            if (userId == null) {
                userId = "";
            }
            hashMap.put("userId", userId);
            hashMap.put("apkVersion", String.valueOf(a.b()));
            hashMap.put("key_uri", str);
            hashMap.put("key_domin", str2);
            hashMap.put("key_http_status", String.valueOf(i10));
            hashMap.put("key_user_name", str3);
            MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_BIGBEE_REQUEST_ERROR_MESSAGE", (Map<String, String>) hashMap);
        }
    }
}
