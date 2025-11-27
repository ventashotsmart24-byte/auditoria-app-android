package com.raizlabs.android.dbflow.converter;

import com.raizlabs.android.dbflow.annotation.TypeConverter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@TypeConverter(allowedSubtypes = {GregorianCalendar.class})
public class CalendarConverter extends TypeConverter<Long, Calendar> {
    public Long getDBValue(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public Calendar getModelValue(Long l10) {
        if (l10 == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(l10.longValue());
        return instance;
    }
}
