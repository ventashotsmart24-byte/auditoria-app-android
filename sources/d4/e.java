package d4;

import b3.r;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import k3.j;

public abstract class e {
    public static String a(j jVar) {
        String str;
        String str2;
        String name = jVar.q().getName();
        if (c(name)) {
            if (name.indexOf(46, 10) >= 0) {
                return null;
            }
            str2 = "Java 8 date/time";
            str = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else if (!d(name)) {
            return null;
        } else {
            str2 = "Joda date/time";
            str = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        }
        return String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", new Object[]{str2, h.G(jVar), str});
    }

    public static Object b(j jVar) {
        Class<String> q10 = jVar.q();
        Class b02 = h.b0(q10);
        if (b02 != null) {
            return h.m(b02);
        }
        if (jVar.D() || jVar.b()) {
            return r.a.NON_EMPTY;
        }
        if (q10 == String.class) {
            return "";
        }
        if (jVar.N(Date.class)) {
            return new Date(0);
        }
        if (!jVar.N(Calendar.class)) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(0);
        return gregorianCalendar;
    }

    public static boolean c(String str) {
        return str.startsWith("java.time.");
    }

    public static boolean d(String str) {
        return str.startsWith("org.joda.time.");
    }
}
