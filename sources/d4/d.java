package d4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class d implements Iterator, Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f6257a;

    /* renamed from: b  reason: collision with root package name */
    public int f6258b = 0;

    public d(Object[] objArr) {
        this.f6257a = objArr;
    }

    public boolean hasNext() {
        if (this.f6258b < this.f6257a.length) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return this;
    }

    public Object next() {
        int i10 = this.f6258b;
        Object[] objArr = this.f6257a;
        if (i10 < objArr.length) {
            this.f6258b = i10 + 1;
            return objArr[i10];
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
