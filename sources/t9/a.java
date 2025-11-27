package t9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a implements Iterator, u9.a {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f19577a;

    /* renamed from: b  reason: collision with root package name */
    public int f19578b;

    public a(Object[] objArr) {
        i.g(objArr, "array");
        this.f19577a = objArr;
    }

    public boolean hasNext() {
        if (this.f19578b < this.f19577a.length) {
            return true;
        }
        return false;
    }

    public Object next() {
        try {
            Object[] objArr = this.f19577a;
            int i10 = this.f19578b;
            this.f19578b = i10 + 1;
            return objArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f19578b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
