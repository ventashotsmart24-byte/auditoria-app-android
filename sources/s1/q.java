package s1;

import android.content.Context;
import android.os.SystemClock;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdReportBean;
import com.advertlib.bean.ReportWrapperBean;
import com.advertlib.bean.TimeInfoBean;
import com.advertlib.bean.UserIdentityFrequency;
import com.umeng.analytics.pro.f;
import h9.t;
import java.util.ArrayList;
import java.util.List;
import s2.d;
import t9.g;
import t9.i;
import u1.a;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f9311a = new q();

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f9312b;

    /* renamed from: c  reason: collision with root package name */
    public static List f9313c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static final String f9314d = q.class.getSimpleName();

    public static final void e(List list) {
        i.g(list, "$ids");
        a aVar = f9312b;
        if (aVar != null) {
            aVar.m(list);
        }
    }

    public static final void l(ReportWrapperBean reportWrapperBean, TimeInfoBean timeInfoBean) {
        i.g(reportWrapperBean, "$bean");
        boolean isClickEvent = reportWrapperBean.isClickEvent();
        boolean z10 = !isClickEvent;
        String ad_id = reportWrapperBean.getAdInfo().getAd_id();
        String ad_name = reportWrapperBean.getAdInfo().getAd_name();
        if (ad_name == null) {
            ad_name = "unknown";
        }
        String userName = reportWrapperBean.getUserName();
        int appVersion = reportWrapperBean.getAppVersion();
        String pagekegeName = reportWrapperBean.getPagekegeName();
        String media_type = reportWrapperBean.getAdInfo().getMedia_type();
        if (media_type == null) {
            media_type = "";
        }
        AdReportBean adReportBean = new AdReportBean(ad_id, ad_name, z10 ? 1 : 0, isClickEvent ? 1 : 0, "", "", userName, appVersion, pagekegeName, media_type, reportWrapperBean.getAdType(), timeInfoBean.getCurrTime(reportWrapperBean.getLocalTime()), reportWrapperBean.getGameStayTime());
        a aVar = f9312b;
        if (aVar != null) {
            aVar.q(adReportBean);
        }
    }

    public final void c() {
        if (!f9313c.isEmpty()) {
            List<ReportWrapperBean> list = f9313c;
            f9313c = new ArrayList();
            for (ReportWrapperBean k10 : list) {
                f9311a.k(k10);
            }
        }
    }

    public final void d(List list) {
        i.g(list, "ids");
        m.f9270a.Q().execute(new d.e("delete report", (Runnable) new p(list), false));
    }

    public final List f(Context context) {
        i.g(context, f.X);
        a aVar = f9312b;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    public final void g(Context context) {
        i.g(context, f.X);
        if (f9312b == null) {
            synchronized (q.class) {
                if (f9312b == null) {
                    f9312b = new a(context);
                }
                t tVar = t.f17319a;
            }
        }
    }

    public final void h(Context context, String str, String str2, AdInfo adInfo) {
        String str3;
        Context context2 = context;
        i.g(context2, f.X);
        i.g(str2, "adType");
        if (adInfo != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String packageName = context.getPackageName();
            i.f(packageName, "context.packageName");
            int b10 = y1.f.f9867a.b(context2);
            if (str == null) {
                str3 = "unknown";
            } else {
                str3 = str;
            }
            k(new ReportWrapperBean(true, elapsedRealtime, packageName, b10, str3, str2, adInfo, 0, 128, (g) null));
        }
    }

    public final void i(Context context, String str, String str2, long j10) {
        String str3;
        Context context2 = context;
        i.g(context2, f.X);
        i.g(str, "adType");
        AdInfo adInfo = new AdInfo("0", "", "", "", "", "", 1, 0, (UserIdentityFrequency) null, (String) null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context.getPackageName();
        i.f(packageName, "context.packageName");
        int b10 = y1.f.f9867a.b(context2);
        if (str2 == null) {
            str3 = "unknown";
        } else {
            str3 = str2;
        }
        k(new ReportWrapperBean(false, elapsedRealtime, packageName, b10, str3, str, adInfo, j10));
    }

    public final void j(Context context, String str, String str2, AdInfo adInfo) {
        String str3;
        Context context2 = context;
        i.g(context2, f.X);
        i.g(str2, "adType");
        i.g(adInfo, "adInfo");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context.getPackageName();
        i.f(packageName, "context.packageName");
        int b10 = y1.f.f9867a.b(context2);
        if (str == null) {
            str3 = "unknown";
        } else {
            str3 = str;
        }
        k(new ReportWrapperBean(false, elapsedRealtime, packageName, b10, str3, str2, adInfo, 0, 128, (g) null));
    }

    public final void k(ReportWrapperBean reportWrapperBean) {
        m mVar = m.f9270a;
        TimeInfoBean R = mVar.R();
        if (R == null || f9312b == null) {
            f9313c.add(reportWrapperBean);
        } else {
            mVar.Q().execute(new d.e("report event", (Runnable) new o(reportWrapperBean, R), false));
        }
    }

    public final void m(Context context, String str, String str2, AdInfo adInfo) {
        String str3;
        Context context2 = context;
        i.g(context2, f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context.getPackageName();
        i.f(packageName, "context.packageName");
        int b10 = y1.f.f9867a.b(context2);
        if (str2 == null) {
            str3 = "unknown";
        } else {
            str3 = str2;
        }
        k(new ReportWrapperBean(true, elapsedRealtime, packageName, b10, str3, str, adInfo, 0, 128, (g) null));
    }
}
