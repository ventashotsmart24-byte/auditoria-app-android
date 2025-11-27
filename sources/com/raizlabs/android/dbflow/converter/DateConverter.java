package com.raizlabs.android.dbflow.converter;

import java.util.Date;

public class DateConverter extends TypeConverter<Long, Date> {
    public Long getDBValue(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }

    public Date getModelValue(Long l10) {
        if (l10 == null) {
            return null;
        }
        return new Date(l10.longValue());
    }
}
