package w1;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import com.umeng.analytics.pro.f;
import java.io.File;
import r1.a;
import s1.m;
import t9.i;
import t9.t;
import v1.b;

public final class c implements a {
    public static final void d(b bVar, String str, t tVar) {
        i.g(str, "$adType");
        i.g(tVar, "$isSuccess");
        if (bVar != null) {
            bVar.a(str, tVar.f19597a);
        }
    }

    public void a(Context context, String str, AdInfo adInfo, b bVar) {
        i.g(context, f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        t tVar = new t();
        a aVar = a.f8975a;
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        tVar.f19597a = aVar.f(context, url);
        m.f9270a.P().post(new b(bVar, str, tVar));
    }

    public File b(Context context, String str, AdInfo adInfo) {
        i.g(context, f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        a aVar = a.f8975a;
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        return aVar.c(context, url);
    }
}
