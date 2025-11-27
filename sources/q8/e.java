package q8;

import com.umeng.analytics.pro.bt;
import i8.c;
import i8.d;
import l8.h;

public abstract class e {
    public static void a(String str) {
        h.f7639m.a().v(d.SYS_EVENT_TYPE_APP, i8.e.NONE, g(str));
    }

    public static void b(String str, int i10) {
        h.f7639m.a().u(d.SYS_EVENT_TYPE_DEVICE, f(str), i10);
    }

    public static void c(String str) {
        h.f7639m.a().v(d.SYS_EVENT_TYPE_DOZE, i8.e.NONE, g(str));
    }

    public static void d(String str, String str2) {
        h.f7639m.a().v(d.SYS_EVENT_TYPE_NET, h(str), g(str2));
    }

    public static void e(String str) {
        h.f7639m.a().v(d.SYS_EVENT_TYPE_SCREEN, i8.e.NONE, g(str));
    }

    public static i8.e f(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -331239923:
                if (str.equals(bt.Z)) {
                    c10 = 0;
                    break;
                }
                break;
            case 3083677:
                if (str.equals("disk")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3500592:
                if (str.equals("ring")) {
                    c10 = 2;
                    break;
                }
                break;
            case 104086693:
                if (str.equals("mouse")) {
                    c10 = 3;
                    break;
                }
                break;
            case 503739367:
                if (str.equals("keyboard")) {
                    c10 = 4;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return i8.e.DEVICE_TYPE_BATTERY;
            case 1:
                return i8.e.DEVICE_TYPE_DISK;
            case 2:
                return i8.e.DEVICE_TYPE_RING;
            case 3:
                return i8.e.DEVICE_TYPE_MOUSE;
            case 4:
                return i8.e.DEVICE_TYPE_KEYBOARD;
            default:
                return i8.e.NONE;
        }
    }

    public static c g(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -934426579:
                if (str.equals("resume")) {
                    c10 = 0;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    c10 = 1;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c10 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return c.EVENT_TYPE_RESUME;
            case 1:
                return c.EVENT_TYPE_STOP;
            case 2:
                return c.EVENT_TYPE_PAUSE;
            case 3:
                return c.EVENT_TYPE_START;
            default:
                return c.EVENT_TYPE_START;
        }
    }

    public static i8.e h(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -916596374:
                if (str.equals("cellular")) {
                    c10 = 0;
                    break;
                }
                break;
            case 3652034:
                if (str.equals("wlan")) {
                    c10 = 1;
                    break;
                }
                break;
            case 113139839:
                if (str.equals("wired")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return i8.e.NET_TYPE_CELLULAR;
            case 1:
                return i8.e.NET_TYPE_WLAN;
            case 2:
                return i8.e.NET_TYPE_WIRED;
            default:
                return i8.e.NONE;
        }
    }
}
