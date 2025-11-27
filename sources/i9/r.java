package i9;

import ba.k;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import s9.l;
import t9.i;
import t9.j;
import w9.c;

public abstract class r extends q {

    public static final class a implements aa.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Iterable f17409a;

        public a(Iterable iterable) {
            this.f17409a = iterable;
        }

        public Iterator iterator() {
            return this.f17409a.iterator();
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f17410a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i10) {
            super(1);
            this.f17410a = i10;
        }

        public final Object b(int i10) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f17410a + '.');
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return b(((Number) obj).intValue());
        }
    }

    public static final Object A(Iterable iterable) {
        i.g(iterable, "<this>");
        if (iterable instanceof List) {
            return B((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object B(List list) {
        i.g(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final List C(Iterable iterable, Comparator comparator) {
        i.g(iterable, "<this>");
        i.g(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return G(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            f.d(array, comparator);
            return f.a(array);
        }
        List H = H(iterable);
        n.m(H, comparator);
        return H;
    }

    public static final List D(Iterable iterable, int i10) {
        boolean z10;
        i.g(iterable, "<this>");
        int i11 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        } else if (i10 == 0) {
            return j.d();
        } else {
            if (iterable instanceof Collection) {
                if (i10 >= ((Collection) iterable).size()) {
                    return G(iterable);
                }
                if (i10 == 1) {
                    return i.b(s(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i10);
            for (Object add : iterable) {
                arrayList.add(add);
                i11++;
                if (i11 == i10) {
                    break;
                }
            }
            return j.i(arrayList);
        }
    }

    public static final Collection E(Iterable iterable, Collection collection) {
        i.g(iterable, "<this>");
        i.g(collection, FirebaseAnalytics.Param.DESTINATION);
        for (Object add : iterable) {
            collection.add(add);
        }
        return collection;
    }

    public static final int[] F(Collection collection) {
        i.g(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Number) it.next()).intValue();
            i10++;
        }
        return iArr;
    }

    public static final List G(Iterable iterable) {
        Object obj;
        i.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j.i(H(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return j.d();
        }
        if (size != 1) {
            return I(collection);
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return i.b(obj);
    }

    public static final List H(Iterable iterable) {
        i.g(iterable, "<this>");
        if (iterable instanceof Collection) {
            return I((Collection) iterable);
        }
        return (List) E(iterable, new ArrayList());
    }

    public static final List I(Collection collection) {
        i.g(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final Set J(Iterable iterable) {
        Object obj;
        i.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return b0.c((Set) E(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return b0.b();
        }
        if (size != 1) {
            return (Set) E(iterable, new LinkedHashSet(y.a(collection.size())));
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return a0.a(obj);
    }

    public static final aa.b o(Iterable iterable) {
        i.g(iterable, "<this>");
        return new a(iterable);
    }

    public static final boolean p(Iterable iterable, Object obj) {
        i.g(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (v(iterable, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static final Object q(Iterable iterable, int i10) {
        i.g(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).get(i10);
        }
        return r(iterable, i10, new b(i10));
    }

    public static final Object r(Iterable iterable, int i10, l lVar) {
        i.g(iterable, "<this>");
        i.g(lVar, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i10 < 0 || i10 > j.f(list)) {
                return lVar.invoke(Integer.valueOf(i10));
            }
            return list.get(i10);
        } else if (i10 < 0) {
            return lVar.invoke(Integer.valueOf(i10));
        } else {
            int i11 = 0;
            for (Object next : iterable) {
                int i12 = i11 + 1;
                if (i10 == i11) {
                    return next;
                }
                i11 = i12;
            }
            return lVar.invoke(Integer.valueOf(i10));
        }
    }

    public static final Object s(Iterable iterable) {
        i.g(iterable, "<this>");
        if (iterable instanceof List) {
            return t((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object t(List list) {
        i.g(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final Object u(List list, int i10) {
        i.g(list, "<this>");
        if (i10 < 0 || i10 > j.f(list)) {
            return null;
        }
        return list.get(i10);
    }

    public static final int v(Iterable iterable, Object obj) {
        i.g(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i10 = 0;
        for (Object next : iterable) {
            if (i10 < 0) {
                j.j();
            }
            if (i.b(obj, next)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final Appendable w(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar) {
        i.g(iterable, "<this>");
        i.g(appendable, "buffer");
        i.g(charSequence, "separator");
        i.g(charSequence2, "prefix");
        i.g(charSequence3, "postfix");
        i.g(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i11 = 0;
        for (Object next : iterable) {
            i11++;
            if (i11 > 1) {
                appendable.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            k.a(appendable, next, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String x(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar) {
        i.g(iterable, "<this>");
        i.g(charSequence, "separator");
        i.g(charSequence2, "prefix");
        i.g(charSequence3, "postfix");
        i.g(charSequence4, "truncated");
        String sb = ((StringBuilder) w(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        i.f(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String y(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
        CharSequence charSequence5;
        int i12;
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i11 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i11 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i11 & 8) != 0) {
            i12 = -1;
        } else {
            i12 = i10;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return x(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static final Object z(Collection collection, c cVar) {
        i.g(collection, "<this>");
        i.g(cVar, "random");
        if (!collection.isEmpty()) {
            return q(collection, cVar.c(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }
}
