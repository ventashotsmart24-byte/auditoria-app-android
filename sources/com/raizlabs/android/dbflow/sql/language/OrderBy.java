package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.annotation.Collate;
import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;

public class OrderBy implements Query {
    public static final String ASCENDING = "ASC";
    public static final String DESCENDING = "DESC";
    private Collate collation;
    private NameAlias column;
    private boolean isAscending;
    private String orderByString;

    public OrderBy(NameAlias nameAlias) {
        this.column = nameAlias;
    }

    public static OrderBy fromNameAlias(NameAlias nameAlias) {
        return new OrderBy(nameAlias);
    }

    public static OrderBy fromProperty(IProperty iProperty) {
        return new OrderBy(iProperty.getNameAlias());
    }

    public static OrderBy fromString(String str) {
        return new OrderBy(str);
    }

    public OrderBy ascending() {
        this.isAscending = true;
        return this;
    }

    public OrderBy collate(Collate collate) {
        this.collation = collate;
        return this;
    }

    public OrderBy descending() {
        this.isAscending = false;
        return this;
    }

    public String getQuery() {
        String str;
        String str2 = this.orderByString;
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.column);
        sb.append(" ");
        if (this.collation != null) {
            sb.append("COLLATE");
            sb.append(" ");
            sb.append(this.collation);
            sb.append(" ");
        }
        if (this.isAscending) {
            str = ASCENDING;
        } else {
            str = DESCENDING;
        }
        sb.append(str);
        return sb.toString();
    }

    public String toString() {
        return getQuery();
    }

    public OrderBy(NameAlias nameAlias, boolean z10) {
        this(nameAlias);
        this.isAscending = z10;
    }

    public OrderBy(String str) {
        this.orderByString = str;
    }
}
