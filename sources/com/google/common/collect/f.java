package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Comparator;

public final /* synthetic */ class f implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Comparator f10065a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f10066b;

    public /* synthetic */ f(Comparator comparator, Comparator comparator2) {
        this.f10065a = comparator;
        this.f10066b = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return RegularImmutableTable.lambda$forCells$0(this.f10065a, this.f10066b, (Table.Cell) obj, (Table.Cell) obj2);
    }
}
