package com.hpplay.cybergarage.http;

import com.hpplay.cybergarage.soap.SOAP;
import java.util.Calendar;
import java.util.TimeZone;

public class Date {
    private static final String[] MONTH_STRING = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] WEEK_STRING = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private Calendar cal;

    public Date(Calendar calendar) {
        this.cal = calendar;
    }

    public static final Date getInstance() {
        return new Date(Calendar.getInstance(TimeZone.getTimeZone("GMT")));
    }

    public static final Date getLocalInstance() {
        return new Date(Calendar.getInstance());
    }

    public static final String toDateString(int i10) {
        if (i10 >= 10) {
            return Integer.toString(i10);
        }
        return "0" + Integer.toString(i10);
    }

    public static final String toMonthString(int i10) {
        int i11 = i10 + 0;
        if (i11 < 0 || i11 >= 12) {
            return "";
        }
        return MONTH_STRING[i11];
    }

    public static final String toTimeString(int i10) {
        String str = "";
        if (i10 < 10) {
            str = str + "0";
        }
        return str + Integer.toString(i10);
    }

    public static final String toWeekString(int i10) {
        int i11 = i10 - 1;
        if (i11 < 0 || i11 >= 7) {
            return "";
        }
        return WEEK_STRING[i11];
    }

    public Calendar getCalendar() {
        return this.cal;
    }

    public String getDateString() {
        Calendar calendar = getCalendar();
        return toWeekString(calendar.get(7)) + ", " + toTimeString(calendar.get(5)) + " " + toMonthString(calendar.get(2)) + " " + Integer.toString(calendar.get(1)) + " " + toTimeString(calendar.get(11)) + SOAP.DELIM + toTimeString(calendar.get(12)) + SOAP.DELIM + toTimeString(calendar.get(13)) + " GMT";
    }

    public int getHour() {
        return getCalendar().get(11);
    }

    public int getMinute() {
        return getCalendar().get(12);
    }

    public int getSecond() {
        return getCalendar().get(13);
    }

    public String getTimeString() {
        String str;
        Calendar calendar = getCalendar();
        StringBuilder sb = new StringBuilder();
        sb.append(toDateString(calendar.get(11)));
        if (calendar.get(13) % 2 == 0) {
            str = SOAP.DELIM;
        } else {
            str = " ";
        }
        sb.append(str);
        sb.append(toDateString(calendar.get(12)));
        return sb.toString();
    }
}
