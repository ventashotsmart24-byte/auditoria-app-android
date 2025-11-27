package com.hpplay.sdk.source.utils;

public class CheckDisconnect {
    private boolean disableDisconnectCheck(int i10, int i11) {
        return i10 == 212012 || i11 == 212013 || i11 == 212015 || i11 == 212001 || i11 == 212018;
    }

    public static boolean disableRetry(int i10, int i11) {
        return i10 == 212012 || i11 == 212001 || i11 == 212014 || i11 == 212013 || i11 == 212015;
    }
}
