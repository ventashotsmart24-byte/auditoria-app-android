package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Count implements Serializable {
    private int value;

    public Count(int i10) {
        this.value = i10;
    }

    public void add(int i10) {
        this.value += i10;
    }

    public int addAndGet(int i10) {
        int i11 = this.value + i10;
        this.value = i11;
        return i11;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Count) || ((Count) obj).value != this.value) {
            return false;
        }
        return true;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int i10) {
        int i11 = this.value;
        this.value = i10;
        return i11;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int i10) {
        this.value = i10;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
