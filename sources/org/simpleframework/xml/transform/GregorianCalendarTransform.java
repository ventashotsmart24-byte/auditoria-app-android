package org.simpleframework.xml.transform;

import java.util.Date;
import java.util.GregorianCalendar;

class GregorianCalendarTransform implements Transform<GregorianCalendar> {
    private final DateTransform transform;

    public GregorianCalendarTransform() {
        this(Date.class);
    }

    public GregorianCalendarTransform(Class cls) {
        this.transform = new DateTransform(cls);
    }

    public GregorianCalendar read(String str) {
        return read(this.transform.read(str));
    }

    public String write(GregorianCalendar gregorianCalendar) {
        return this.transform.write(gregorianCalendar.getTime());
    }

    private GregorianCalendar read(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (date != null) {
            gregorianCalendar.setTime(date);
        }
        return gregorianCalendar;
    }
}
