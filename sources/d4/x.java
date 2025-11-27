package d4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.flowcontrol.FlowControl;
import f3.f;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class x extends DateFormat {

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f6315g = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f6316h = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f6317i = {"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};

    /* renamed from: j  reason: collision with root package name */
    public static final TimeZone f6318j;

    /* renamed from: k  reason: collision with root package name */
    public static final Locale f6319k;

    /* renamed from: l  reason: collision with root package name */
    public static final DateFormat f6320l;

    /* renamed from: m  reason: collision with root package name */
    public static final x f6321m = new x();

    /* renamed from: n  reason: collision with root package name */
    public static final Calendar f6322n;

    /* renamed from: a  reason: collision with root package name */
    public transient TimeZone f6323a;

    /* renamed from: b  reason: collision with root package name */
    public final Locale f6324b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f6325c;

    /* renamed from: d  reason: collision with root package name */
    public transient Calendar f6326d;

    /* renamed from: e  reason: collision with root package name */
    public transient DateFormat f6327e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6328f;

    static {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            f6318j = timeZone;
            Locale locale = Locale.US;
            f6319k = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            f6320l = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            f6322n = new GregorianCalendar(timeZone, locale);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public x() {
        this.f6328f = true;
        this.f6324b = f6319k;
    }

    public static final DateFormat b(DateFormat dateFormat, String str, TimeZone timeZone, Locale locale, Boolean bool) {
        DateFormat dateFormat2;
        if (!locale.equals(f6319k)) {
            dateFormat2 = new SimpleDateFormat(str, locale);
            if (timeZone == null) {
                timeZone = f6318j;
            }
            dateFormat2.setTimeZone(timeZone);
        } else {
            dateFormat2 = (DateFormat) dateFormat.clone();
            if (timeZone != null) {
                dateFormat2.setTimeZone(timeZone);
            }
        }
        if (bool != null) {
            dateFormat2.setLenient(bool.booleanValue());
        }
        return dateFormat2;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static int g(String str, int i10) {
        return ((str.charAt(i10) - '0') * 10) + (str.charAt(i10 + 1) - '0');
    }

    public static int h(String str, int i10) {
        return ((str.charAt(i10) - '0') * 1000) + ((str.charAt(i10 + 1) - '0') * 100) + ((str.charAt(i10 + 2) - '0') * 10) + (str.charAt(i10 + 3) - '0');
    }

    public static void n(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 10;
        if (i11 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i11 + 48));
            i10 -= i11 * 10;
        }
        stringBuffer.append((char) (i10 + 48));
    }

    public static void o(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 100;
        if (i11 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i11 + 48));
            i10 -= i11 * 100;
        }
        n(stringBuffer, i10);
    }

    public static void p(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 100;
        if (i11 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i11 > 99) {
                stringBuffer.append(i11);
            } else {
                n(stringBuffer, i11);
            }
            i10 -= i11 * 100;
        }
        n(stringBuffer, i10);
    }

    public void a() {
        this.f6327e = null;
    }

    public void d(TimeZone timeZone, Locale locale, Date date, StringBuffer stringBuffer) {
        Calendar f10 = f(timeZone);
        f10.setTime(date);
        int i10 = f10.get(1);
        char c10 = '+';
        if (f10.get(0) == 0) {
            e(stringBuffer, i10);
        } else {
            if (i10 > 9999) {
                stringBuffer.append('+');
            }
            p(stringBuffer, i10);
        }
        stringBuffer.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        n(stringBuffer, f10.get(2) + 1);
        stringBuffer.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        n(stringBuffer, f10.get(5));
        stringBuffer.append(ASCIIPropertyListParser.DATE_APPLE_DATE_TIME_DELIMITER);
        n(stringBuffer, f10.get(11));
        stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
        n(stringBuffer, f10.get(12));
        stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
        n(stringBuffer, f10.get(13));
        stringBuffer.append('.');
        o(stringBuffer, f10.get(14));
        int offset = timeZone.getOffset(f10.getTimeInMillis());
        if (offset != 0) {
            int i11 = offset / 60000;
            int abs = Math.abs(i11 / 60);
            int abs2 = Math.abs(i11 % 60);
            if (offset < 0) {
                c10 = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
            }
            stringBuffer.append(c10);
            n(stringBuffer, abs);
            if (this.f6328f) {
                stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
            }
            n(stringBuffer, abs2);
        } else if (this.f6328f) {
            stringBuffer.append("+00:00");
        } else {
            stringBuffer.append("+0000");
        }
    }

    public void e(StringBuffer stringBuffer, int i10) {
        if (i10 == 1) {
            stringBuffer.append("+0000");
            return;
        }
        stringBuffer.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        p(stringBuffer, i10 - 1);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public Calendar f(TimeZone timeZone) {
        Calendar calendar = this.f6326d;
        if (calendar == null) {
            calendar = (Calendar) f6322n.clone();
            this.f6326d = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.f6323a;
        if (timeZone == null) {
            timeZone = f6318j;
        }
        d(timeZone, this.f6324b, date, stringBuffer);
        return stringBuffer;
    }

    public TimeZone getTimeZone() {
        return this.f6323a;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public Date i(String str, ParsePosition parsePosition) {
        char c10;
        String str2;
        int i10;
        int i11;
        String str3 = str;
        int length = str.length();
        TimeZone timeZone = f6318j;
        if (!(this.f6323a == null || 'Z' == str3.charAt(length - 1))) {
            timeZone = this.f6323a;
        }
        Calendar f10 = f(timeZone);
        f10.clear();
        int i12 = 0;
        if (length > 10) {
            Matcher matcher = f6316h.matcher(str3);
            if (matcher.matches()) {
                int start = matcher.start(2);
                int end = matcher.end(2);
                int i13 = end - start;
                if (i13 > 1) {
                    int g10 = g(str3, start + 1) * 3600;
                    if (i13 >= 5) {
                        g10 += g(str3, end - 2) * 60;
                    }
                    if (str3.charAt(start) == '-') {
                        i11 = g10 * FlowControl.DELAY_MAX_BRUSH;
                    } else {
                        i11 = g10 * 1000;
                    }
                    f10.set(15, i11);
                    f10.set(16, 0);
                }
                int h10 = h(str3, 0);
                int g11 = g(str3, 5) - 1;
                int g12 = g(str3, 8);
                int g13 = g(str3, 11);
                int g14 = g(str3, 14);
                if (length <= 16 || str3.charAt(16) != ':') {
                    i10 = 0;
                } else {
                    i10 = g(str3, 17);
                }
                int i14 = h10;
                int i15 = g11;
                int i16 = g12;
                int i17 = g13;
                Matcher matcher2 = matcher;
                f10.set(i14, i15, i16, i17, g14, i10);
                int start2 = matcher2.start(1) + 1;
                int end2 = matcher2.end(1);
                if (start2 >= end2) {
                    f10.set(14, 0);
                } else {
                    int i18 = end2 - start2;
                    if (i18 != 0) {
                        if (i18 != 1) {
                            if (i18 != 2) {
                                if (i18 == 3 || i18 <= 9) {
                                    i12 = 0 + (str3.charAt(start2 + 2) - '0');
                                } else {
                                    throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", new Object[]{str3, matcher2.group(1).substring(1)}), start2);
                                }
                            }
                            i12 += (str3.charAt(start2 + 1) - '0') * 10;
                        }
                        i12 += (str3.charAt(start2) - '0') * 100;
                    }
                    f10.set(14, i12);
                }
                return f10.getTime();
            }
            c10 = 1;
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else if (f6315g.matcher(str3).matches()) {
            f10.set(h(str3, 0), g(str3, 5) - 1, g(str3, 8), 0, 0, 0);
            f10.set(14, 0);
            return f10.getTime();
        } else {
            str2 = "yyyy-MM-dd";
            c10 = 1;
        }
        Object[] objArr = new Object[3];
        objArr[0] = str3;
        objArr[c10] = str2;
        objArr[2] = this.f6325c;
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", objArr), 0);
    }

    public boolean isLenient() {
        Boolean bool = this.f6325c;
        if (bool == null || bool.booleanValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date j(java.lang.String r5, java.text.ParsePosition r6) {
        /*
            r4 = this;
            boolean r0 = r4.m(r5)
            if (r0 == 0) goto L_0x000b
            java.util.Date r5 = r4.q(r5, r6)
            return r5
        L_0x000b:
            int r0 = r5.length()
        L_0x000f:
            int r0 = r0 + -1
            r1 = 45
            if (r0 < 0) goto L_0x0025
            char r2 = r5.charAt(r0)
            r3 = 48
            if (r2 < r3) goto L_0x0021
            r3 = 57
            if (r2 <= r3) goto L_0x000f
        L_0x0021:
            if (r0 > 0) goto L_0x0025
            if (r2 == r1) goto L_0x000f
        L_0x0025:
            if (r0 >= 0) goto L_0x0039
            r0 = 0
            char r2 = r5.charAt(r0)
            if (r2 == r1) goto L_0x0034
            boolean r0 = f3.f.b(r5, r0)
            if (r0 == 0) goto L_0x0039
        L_0x0034:
            java.util.Date r5 = r4.k(r5, r6)
            return r5
        L_0x0039:
            java.util.Date r5 = r4.r(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.x.j(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public final Date k(String str, ParsePosition parsePosition) {
        try {
            return new Date(f.l(str));
        } catch (NumberFormatException unused) {
            throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", new Object[]{str}), parsePosition.getErrorIndex());
        }
    }

    /* renamed from: l */
    public x clone() {
        return new x(this.f6323a, this.f6324b, this.f6325c, this.f6328f);
    }

    public boolean m(String str) {
        if (str.length() < 7 || !Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(3)) || str.charAt(4) != '-' || !Character.isDigit(str.charAt(5))) {
            return false;
        }
        return true;
    }

    public Date parse(String str) {
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date j10 = j(trim, parsePosition);
        if (j10 != null) {
            return j10;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : f6317i) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(str2);
        }
        sb.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{trim, sb.toString()}), parsePosition.getErrorIndex());
    }

    public Date q(String str, ParsePosition parsePosition) {
        try {
            return i(str, parsePosition);
        } catch (IllegalArgumentException e10) {
            throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", new Object[]{str, e10.getMessage()}), parsePosition.getErrorIndex());
        }
    }

    public Date r(String str, ParsePosition parsePosition) {
        if (this.f6327e == null) {
            this.f6327e = b(f6320l, "EEE, dd MMM yyyy HH:mm:ss zzz", this.f6323a, this.f6324b, this.f6325c);
        }
        return this.f6327e.parse(str, parsePosition);
    }

    public String s() {
        String str;
        StringBuilder sb = new StringBuilder(100);
        sb.append("[one of: '");
        sb.append("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        sb.append("', '");
        sb.append("EEE, dd MMM yyyy HH:mm:ss zzz");
        sb.append("' (");
        if (Boolean.FALSE.equals(this.f6325c)) {
            str = "strict";
        } else {
            str = "lenient";
        }
        sb.append(str);
        sb.append(")]");
        return sb.toString();
    }

    public void setLenient(boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        if (!c(valueOf, this.f6325c)) {
            this.f6325c = valueOf;
            a();
        }
    }

    public void setTimeZone(TimeZone timeZone) {
        if (!timeZone.equals(this.f6323a)) {
            a();
            this.f6323a = timeZone;
        }
    }

    public x t(Boolean bool) {
        if (c(bool, this.f6325c)) {
            return this;
        }
        return new x(this.f6323a, this.f6324b, bool, this.f6328f);
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", new Object[]{getClass().getName(), this.f6323a, this.f6324b, this.f6325c});
    }

    public x u(Locale locale) {
        if (locale.equals(this.f6324b)) {
            return this;
        }
        return new x(this.f6323a, locale, this.f6325c, this.f6328f);
    }

    public x v(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = f6318j;
        }
        TimeZone timeZone2 = this.f6323a;
        if (timeZone == timeZone2 || timeZone.equals(timeZone2)) {
            return this;
        }
        return new x(timeZone, this.f6324b, this.f6325c, this.f6328f);
    }

    public x(TimeZone timeZone, Locale locale, Boolean bool, boolean z10) {
        this.f6323a = timeZone;
        this.f6324b = locale;
        this.f6325c = bool;
        this.f6328f = z10;
    }

    public Date parse(String str, ParsePosition parsePosition) {
        try {
            return j(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
