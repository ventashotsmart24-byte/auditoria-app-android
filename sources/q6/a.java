package q6;

import android.content.Context;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.d0;
import com.mobile.brasiltv.utils.j1;
import com.titan.ranger.bean.Entry;
import com.titan.ranger.bean.Env;
import com.umeng.analytics.pro.f;
import d6.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l8.h;
import mobile.com.requestframe.utils.response.CdnListBeanResult;
import mobile.com.requestframe.utils.response.CdnUrl;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData;
import r5.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19342a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f19343b = "TitanHelper";

    /* renamed from: c  reason: collision with root package name */
    public static Env f19344c;

    public final void a() {
        List<CdnListBeanResult> list;
        boolean z10;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        CdnUrl cdnUrl;
        CdnUrl cdnUrl2;
        GetSlbInfoBeanResultData A = i.f19378a.A();
        if (A != null) {
            list = A.getCdn_list();
        } else {
            list = null;
        }
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CdnListBeanResult cdnListBeanResult = (CdnListBeanResult) it.next();
                ArrayList arrayList2 = new ArrayList();
                List<CdnUrl> url_list = cdnListBeanResult.getUrl_list();
                if (url_list != null) {
                    for (CdnUrl url : url_list) {
                        arrayList2.add(url.getUrl());
                    }
                }
                String cdn_id_mark = cdnListBeanResult.getCdn_id_mark();
                if (cdn_id_mark == null) {
                    str = "";
                } else {
                    str = cdn_id_mark;
                }
                String tag = cdnListBeanResult.getTag();
                String rule_id_mark = cdnListBeanResult.getRule_id_mark();
                if (rule_id_mark == null) {
                    str2 = "";
                } else {
                    str2 = rule_id_mark;
                }
                String main_addr = cdnListBeanResult.getMain_addr();
                if (main_addr == null) {
                    str3 = "";
                } else {
                    str3 = main_addr;
                }
                String main_addr_mark = cdnListBeanResult.getMain_addr_mark();
                if (main_addr_mark == null) {
                    str4 = "";
                } else {
                    str4 = main_addr_mark;
                }
                String spared_addr = cdnListBeanResult.getSpared_addr();
                if (spared_addr == null) {
                    str5 = "";
                } else {
                    str5 = spared_addr;
                }
                String spared_addr_mark = cdnListBeanResult.getSpared_addr_mark();
                if (spared_addr_mark == null) {
                    str6 = "";
                } else {
                    str6 = spared_addr_mark;
                }
                if (t9.i.b(cdnListBeanResult.getCdn_type(), "1")) {
                    str7 = "slb";
                } else {
                    str7 = "";
                }
                List<CdnUrl> url_list2 = cdnListBeanResult.getUrl_list();
                if (url_list2 == null || (cdnUrl2 = url_list2.get(i10)) == null) {
                    str8 = null;
                } else {
                    str8 = cdnUrl2.getUrl();
                }
                String a10 = d0.a(str8, DynamicLink.Builder.KEY_LINK);
                t9.i.f(a10, "getFieldAddress(it.url_list?.get(0)?.url, \"link\")");
                List<CdnUrl> url_list3 = cdnListBeanResult.getUrl_list();
                Iterator<T> it2 = it;
                if (url_list3 == null || (cdnUrl = url_list3.get(0)) == null) {
                    str9 = null;
                } else {
                    str9 = cdnUrl.getUrl();
                }
                String a11 = d0.a(str9, "sign_type");
                t9.i.f(a11, "getFieldAddress(it.url_l…get(0)?.url, \"sign_type\")");
                int size = list.size() - cdnListBeanResult.getSerial_number();
                String gslb_params = cdnListBeanResult.getGslb_params();
                if (gslb_params == null) {
                    str10 = "";
                } else {
                    str10 = gslb_params;
                }
                Entry entry = r6;
                Entry entry2 = new Entry(str, tag, str2, str3, str4, str5, str6, str7, a10, a11, size, 1, arrayList2, str10);
                arrayList.add(entry);
                it = it2;
                i10 = 0;
            }
            if (b0.I(arrayList)) {
                h.f7639m.a().C(arrayList);
            }
        }
    }

    public final void b(Context context, String str) {
        t9.i.g(context, f.X);
        String l10 = b.f6366a.l();
        String E = w6.i.f9510g.E();
        String str2 = v7.b.f9475a;
        t9.i.f(str2, "KEY");
        if (str == null) {
            str = "";
        }
        String b10 = j1.b(context);
        t9.i.f(b10, "getAndroidId(context)");
        Env env = new Env("com.msandroid.mobile", "60201", l10, E, str2, str, b10, -1);
        if (!t9.i.b(f19344c, env)) {
            f19344c = env;
            h a10 = h.f7639m.a();
            Env env2 = f19344c;
            t9.i.d(env2);
            a10.D(env2);
        }
    }
}
