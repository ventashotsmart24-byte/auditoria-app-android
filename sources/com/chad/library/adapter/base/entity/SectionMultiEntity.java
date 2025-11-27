package com.chad.library.adapter.base.entity;

import java.io.Serializable;

public abstract class SectionMultiEntity<T> implements Serializable, MultiItemEntity {
    public String header;
    public boolean isHeader;

    /* renamed from: t  reason: collision with root package name */
    public T f5118t;

    public SectionMultiEntity(boolean z10, String str) {
        this.isHeader = z10;
        this.header = str;
        this.f5118t = null;
    }

    public SectionMultiEntity(T t10) {
        this.isHeader = false;
        this.header = null;
        this.f5118t = t10;
    }
}
