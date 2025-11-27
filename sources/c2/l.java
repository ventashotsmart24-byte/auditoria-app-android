package c2;

import android.text.TextUtils;
import com.bigbee.bean.CommonParamBean;
import com.taobao.accs.common.Constants;
import t9.i;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f4666a = new l();

    /* renamed from: b  reason: collision with root package name */
    public static final String f4667b = l.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static CommonParamBean f4668c = new CommonParamBean();

    public final String a() {
        String userName;
        CommonParamBean commonParamBean = f4668c;
        if (commonParamBean == null || (userName = commonParamBean.getUserName()) == null) {
            return "";
        }
        return userName;
    }

    public final CommonParamBean b() {
        return f4668c;
    }

    public final void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        i.g(str, "appId");
        i.g(str2, "appVer");
        i.g(str3, "sysVer");
        i.g(str4, Constants.KEY_MODEL);
        i.g(str5, "macAddr");
        i.g(str6, "reserve1");
        i.g(str7, "sn");
        f4668c.setAppId(str);
        f4668c.setAppVer(str2);
        f4668c.setSysVer(str3);
        f4668c.setModel(str4);
        f4668c.setMacAddr(str5);
        f4668c.setReserve1(str6);
        f4668c.setSn(str7);
    }

    public final void d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        i.g(str, "appId");
        i.g(str2, "appVer");
        i.g(str3, "sysVer");
        i.g(str4, Constants.KEY_MODEL);
        i.g(str5, "macAddr");
        i.g(str6, "reserve1");
        i.g(str7, "sn");
        i.g(str8, "userId");
        i.g(str9, "userName");
        c(str, str2, str3, str4, str5, str6, str7);
        f4668c.setUserId(str8);
        f4668c.setUserName(str9);
    }

    public final void e(String str, String str2) {
        i.g(str, "userId");
        i.g(str2, "sn");
        f4668c.setUserId(str);
        f4668c.setSn(str2);
    }

    public final void f(String str, String str2) {
        i.g(str, "userName");
        f4668c.setUserName(str);
        if (!TextUtils.isEmpty(str2)) {
            f4668c.setUserId(str2);
        }
    }
}
