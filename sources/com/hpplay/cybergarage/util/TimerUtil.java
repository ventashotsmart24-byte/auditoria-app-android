package com.hpplay.cybergarage.util;

public final class TimerUtil {
    public static final void wait(int i10) {
        try {
            Thread.sleep((long) i10);
        } catch (Exception unused) {
        }
    }

    public static final void waitRandom(int i10) {
        double random = Math.random();
        double d10 = (double) i10;
        Double.isNaN(d10);
        try {
            Thread.sleep((long) ((int) (random * d10)));
        } catch (Exception unused) {
        }
    }
}
