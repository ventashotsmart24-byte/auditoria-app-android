package com.google.common.collect;

import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f10064a;

    public /* synthetic */ d(Comparator comparator) {
        this.f10064a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f10064a.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
    }
}
