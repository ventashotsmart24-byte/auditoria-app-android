package com.google.common.net;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import java.util.Collection;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return ImmutableMultiset.copyOf((Collection) obj);
    }
}
