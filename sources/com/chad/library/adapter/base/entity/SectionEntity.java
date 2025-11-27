package com.chad.library.adapter.base.entity;

import java.io.Serializable;

public abstract class SectionEntity<T> implements Serializable {
    public String header;
    public boolean isHeader;

    /* renamed from: t  reason: collision with root package name */
    public T f5117t;

    public SectionEntity(boolean z10, String str) {
        this.isHeader = z10;
        this.header = str;
        this.f5117t = null;
    }

    public SectionEntity(T t10) {
        this.isHeader = false;
        this.header = null;
        this.f5117t = t10;
    }
}
