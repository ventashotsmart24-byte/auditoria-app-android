package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use Interners.new*Interner")
public interface Interner<E> {
    @CanIgnoreReturnValue
    E intern(E e10);
}
