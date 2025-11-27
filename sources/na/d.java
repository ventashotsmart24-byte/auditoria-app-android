package na;

import android.text.TextUtils;
import com.hpplay.component.protocol.ProtocolBuilder;

public abstract class d {
    public static boolean a(String str) {
        if (TextUtils.equals(str, "aaa100010") || TextUtils.equals(str, "aaa100011") || TextUtils.equals(str, "aaa100040") || TextUtils.equals(str, "aaa100042") || TextUtils.equals(str, "aaa100044") || TextUtils.equals(str, "aaa100055") || TextUtils.equals(str, "aaa100041") || TextUtils.equals(str, "aaa100045") || TextUtils.equals(str, "aaa100039") || TextUtils.equals(str, "aaa100074")) {
            return true;
        }
        return false;
    }

    public static String b(String str) {
        if (a(str)) {
            return "EA1";
        }
        if (h(str)) {
            return "EA2";
        }
        if (TextUtils.equals(str, "aaa100017")) {
            return "EA3";
        }
        if (TextUtils.equals(str, "aaa100018")) {
            return "EA4";
        }
        if (TextUtils.equals(str, "aaa100050")) {
            return "EA5";
        }
        if (i(str)) {
            return "EA6";
        }
        if (TextUtils.equals(str, "50010") || TextUtils.equals(str, "50012") || TextUtils.equals(str, "50011")) {
            return "EA7";
        }
        if (TextUtils.equals(str, "50014")) {
            return "EA9";
        }
        if (TextUtils.equals(str, "portal100040")) {
            return "EA10";
        }
        if (TextUtils.equals(str, "portal100024")) {
            return "EA11";
        }
        if (TextUtils.equals(str, "portal200001")) {
            return "EA17";
        }
        if (TextUtils.equals(str, "portal100055")) {
            return "EA19";
        }
        if (TextUtils.equals(str, "aaa100075")) {
            return "EA24";
        }
        if (TextUtils.equals(str, "aaa100078")) {
            return "EA27";
        }
        return "no_report_type";
    }

    public static String c(String str) {
        if (TextUtils.equals(str, "portal100022") || TextUtils.equals(str, "portal100023")) {
            return "EB1";
        }
        if (TextUtils.equals(str, "50010") || TextUtils.equals(str, "50012") || TextUtils.equals(str, "50011")) {
            return "EB2";
        }
        if (i(str)) {
            return "EB3";
        }
        return "no_report_type";
    }

    public static String d(String str) {
        if (TextUtils.equals(str, "50010") || TextUtils.equals(str, "50011") || TextUtils.equals(str, "25100") || TextUtils.equals(str, "50012")) {
            return "EC1";
        }
        if (TextUtils.equals(str, "400")) {
            return "EC2";
        }
        if (TextUtils.equals(str, ProtocolBuilder.LELINK_STATE_SCREENCODE)) {
            return "EC4";
        }
        if (TextUtils.equals(str, "500")) {
            return "EC3";
        }
        if (TextUtils.equals(str, "503")) {
            return "EC4";
        }
        if (TextUtils.equals(str, "EC5") || TextUtils.equals(str, "20900")) {
            return "EC5";
        }
        if (TextUtils.equals(str, "32600")) {
            return "EC25";
        }
        if (TextUtils.equals(str, "25500")) {
            return "EC13";
        }
        if (TextUtils.equals(str, "20700")) {
            return "EC3";
        }
        if (TextUtils.equals(str, "20800")) {
            return "EC4";
        }
        if (TextUtils.equals(str, "20600")) {
            return "EC2";
        }
        return "no_report_type";
    }

    public static String e(String str) {
        if (TextUtils.equals(str, "CUSTOM_NO_ASSOCIATED_PORTAL")) {
            return "ED2";
        }
        if (TextUtils.equals(str, "1")) {
            return "ED3";
        }
        if (TextUtils.equals(str, "portal100041")) {
            return "ED4";
        }
        if (TextUtils.equals(str, "portal100042")) {
            return "ED5";
        }
        if (TextUtils.equals(str, "portal100043")) {
            return "ED6";
        }
        if (TextUtils.equals(str, "aaa100048")) {
            return "ED7";
        }
        return "no_report_type";
    }

    public static String f(String str) {
        if (TextUtils.equals(str, "aaa100027") || TextUtils.equals(str, "aaa100028") || TextUtils.equals(str, "aaa100029") || TextUtils.equals(str, "aaa100030")) {
            return "EE2";
        }
        return "no_report_type";
    }

    public static String g(String str) {
        if (TextUtils.equals(str, "portal100054")) {
            return "EF1";
        }
        if (TextUtils.equals(str, "portal100057")) {
            return "EF2";
        }
        if (TextUtils.equals(str, "portal100028")) {
            return "EF3";
        }
        if (TextUtils.equals(str, "portal100058")) {
            return "EF4";
        }
        if (TextUtils.equals(str, "portal100059")) {
            return "EF5";
        }
        if (TextUtils.equals(str, "aaa100076")) {
            return "EF6";
        }
        if (TextUtils.equals(str, "aaa100077")) {
            return "EF7";
        }
        if (TextUtils.equals(str, "aaa100079")) {
            return "EF8";
        }
        if (TextUtils.equals(str, "aaa100080")) {
            return "EF9";
        }
        if (TextUtils.equals(str, "aaa100022")) {
            return "EF11";
        }
        if (TextUtils.equals(str, "aaa100003") || TextUtils.equals(str, "portal100067")) {
            return "EF12";
        }
        if (TextUtils.equals(str, "aaa100082")) {
            return "EF13";
        }
        if (TextUtils.equals(str, "portal100064")) {
            return "EF16";
        }
        if (TextUtils.equals(str, "portal100065")) {
            return "EF17";
        }
        if (TextUtils.equals(str, "aaa100090")) {
            return "EF18";
        }
        if (TextUtils.equals(str, "portal100066")) {
            return "EF19";
        }
        if (TextUtils.equals(str, "portal100068")) {
            return "EF20";
        }
        if (TextUtils.equals(str, "aaa100081")) {
            return "EF21";
        }
        return "no_report_type";
    }

    public static boolean h(String str) {
        if (TextUtils.equals(str, "aaa100019") || TextUtils.equals(str, "aaa100004")) {
            return true;
        }
        return false;
    }

    public static boolean i(String str) {
        if (TextUtils.equals(str, "800") || TextUtils.equals(str, "1000") || TextUtils.equals(str, "500") || TextUtils.equals(str, "1") || TextUtils.equals(str, "portal100000")) {
            return true;
        }
        return false;
    }
}
