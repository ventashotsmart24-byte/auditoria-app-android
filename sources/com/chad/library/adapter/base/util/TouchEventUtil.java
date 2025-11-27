package com.chad.library.adapter.base.util;

public class TouchEventUtil {
    public static String getTouchAction(int i10) {
        String str = "Unknow:id=" + i10;
        if (i10 == 0) {
            return "ACTION_DOWN";
        }
        if (i10 == 1) {
            return "ACTION_UP";
        }
        if (i10 == 2) {
            return "ACTION_MOVE";
        }
        if (i10 == 3) {
            return "ACTION_CANCEL";
        }
        if (i10 != 4) {
            return str;
        }
        return "ACTION_OUTSIDE";
    }
}
