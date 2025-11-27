package com.hpplay.sdk.source.mdns.xbill.dns;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

final class FormattedTime {

    /* renamed from: w2  reason: collision with root package name */
    private static NumberFormat f11834w2;

    /* renamed from: w4  reason: collision with root package name */
    private static NumberFormat f11835w4;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f11834w2 = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        f11835w4 = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(4);
        f11835w4.setGroupingUsed(false);
    }

    private FormattedTime() {
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        StringBuffer stringBuffer = new StringBuffer();
        gregorianCalendar.setTime(date);
        stringBuffer.append(f11835w4.format((long) gregorianCalendar.get(1)));
        stringBuffer.append(f11834w2.format((long) (gregorianCalendar.get(2) + 1)));
        stringBuffer.append(f11834w2.format((long) gregorianCalendar.get(5)));
        stringBuffer.append(f11834w2.format((long) gregorianCalendar.get(11)));
        stringBuffer.append(f11834w2.format((long) gregorianCalendar.get(12)));
        stringBuffer.append(f11834w2.format((long) gregorianCalendar.get(13)));
        return stringBuffer.toString();
    }

    public static Date parse(String str) {
        if (str.length() == 14) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            gregorianCalendar.clear();
            try {
                gregorianCalendar.set(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(4, 6)) - 1, Integer.parseInt(str.substring(6, 8)), Integer.parseInt(str.substring(8, 10)), Integer.parseInt(str.substring(10, 12)), Integer.parseInt(str.substring(12, 14)));
                return gregorianCalendar.getTime();
            } catch (NumberFormatException unused) {
                throw new Exception("Invalid time encoding: " + str);
            }
        } else {
            throw new Exception("Invalid time encoding: " + str);
        }
    }
}
