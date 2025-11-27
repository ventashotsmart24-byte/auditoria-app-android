package com.hpplay.component.protocol.plist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class NSDate extends NSObject {
    private static final long EPOCH = 978307200000L;
    private static final SimpleDateFormat sdfDefault;
    private static final SimpleDateFormat sdfGnuStep;
    private Date date;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdfDefault = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        sdfGnuStep = simpleDateFormat2;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public NSDate(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private static synchronized String makeDateString(Date date2) {
        String format;
        synchronized (NSDate.class) {
            format = sdfDefault.format(date2);
        }
        return format;
    }

    private static synchronized String makeDateStringGnuStep(Date date2) {
        String format;
        synchronized (NSDate.class) {
            format = sdfGnuStep.format(date2);
        }
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r2 = sdfGnuStep.parse(r2);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.util.Date parseDateString(java.lang.String r2) {
        /*
            java.lang.Class<com.hpplay.component.protocol.plist.NSDate> r0 = com.hpplay.component.protocol.plist.NSDate.class
            monitor-enter(r0)
            java.text.SimpleDateFormat r1 = sdfDefault     // Catch:{ ParseException -> 0x000d }
            java.util.Date r2 = r1.parse(r2)     // Catch:{ ParseException -> 0x000d }
            monitor-exit(r0)
            return r2
        L_0x000b:
            r2 = move-exception
            goto L_0x0015
        L_0x000d:
            java.text.SimpleDateFormat r1 = sdfGnuStep     // Catch:{ all -> 0x000b }
            java.util.Date r2 = r1.parse(r2)     // Catch:{ all -> 0x000b }
            monitor-exit(r0)
            return r2
        L_0x0015:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.plist.NSDate.parseDateString(java.lang.String):java.util.Date");
    }

    public boolean equals(Object obj) {
        if (!obj.getClass().equals(getClass()) || !this.date.equals(((NSDate) obj).getDate())) {
            return false;
        }
        return true;
    }

    public Date getDate() {
        return this.date;
    }

    public int hashCode() {
        return this.date.hashCode();
    }

    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append('\"');
        sb.append(makeDateString(this.date));
        sb.append('\"');
    }

    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<*D");
        sb.append(makeDateStringGnuStep(this.date));
        sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
    }

    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.write(51);
        double time = (double) (this.date.getTime() - EPOCH);
        Double.isNaN(time);
        binaryPropertyListWriter.writeDouble(time / 1000.0d);
    }

    public String toString() {
        return this.date.toString();
    }

    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<date>");
        sb.append(makeDateString(this.date));
        sb.append("</date>");
    }

    public NSDate(byte[] bArr, int i10, int i11) {
        this.date = new Date(((long) (BinaryPropertyListParser.parseDouble(bArr, i10, i11) * 1000.0d)) + EPOCH);
    }

    public NSDate clone() {
        return new NSDate((Date) getDate().clone());
    }

    public NSDate(String str) {
        this.date = parseDateString(str);
    }

    public NSDate(Date date2) {
        if (date2 != null) {
            this.date = date2;
            return;
        }
        throw new IllegalArgumentException("Date cannot be null");
    }
}
