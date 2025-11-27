package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import d4.h;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.j;

public class n implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f4845e;

    /* renamed from: f  reason: collision with root package name */
    public static final j[] f4846f;

    /* renamed from: g  reason: collision with root package name */
    public static final n f4847g;

    /* renamed from: a  reason: collision with root package name */
    public final String[] f4848a;

    /* renamed from: b  reason: collision with root package name */
    public final j[] f4849b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f4850c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4851d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Class f4852a;

        /* renamed from: b  reason: collision with root package name */
        public final j[] f4853b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4854c;

        public a(Class cls, j[] jVarArr, int i10) {
            this.f4852a = cls;
            this.f4853b = jVarArr;
            this.f4854c = i10;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4854c == aVar.f4854c && this.f4852a == aVar.f4852a) {
                j[] jVarArr = aVar.f4853b;
                int length = this.f4853b.length;
                if (length == jVarArr.length) {
                    for (int i10 = 0; i10 < length; i10++) {
                        if (!this.f4853b[i10].equals(jVarArr[i10])) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f4854c;
        }

        public String toString() {
            return this.f4852a.getName() + "<>";
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final TypeVariable[] f4855a = AbstractList.class.getTypeParameters();

        /* renamed from: b  reason: collision with root package name */
        public static final TypeVariable[] f4856b = Collection.class.getTypeParameters();

        /* renamed from: c  reason: collision with root package name */
        public static final TypeVariable[] f4857c = Iterable.class.getTypeParameters();

        /* renamed from: d  reason: collision with root package name */
        public static final TypeVariable[] f4858d = List.class.getTypeParameters();

        /* renamed from: e  reason: collision with root package name */
        public static final TypeVariable[] f4859e = ArrayList.class.getTypeParameters();

        /* renamed from: f  reason: collision with root package name */
        public static final TypeVariable[] f4860f = Map.class.getTypeParameters();

        /* renamed from: g  reason: collision with root package name */
        public static final TypeVariable[] f4861g = HashMap.class.getTypeParameters();

        /* renamed from: h  reason: collision with root package name */
        public static final TypeVariable[] f4862h = LinkedHashMap.class.getTypeParameters();

        public static TypeVariable[] a(Class cls) {
            if (cls == Collection.class) {
                return f4856b;
            }
            if (cls == List.class) {
                return f4858d;
            }
            if (cls == ArrayList.class) {
                return f4859e;
            }
            if (cls == AbstractList.class) {
                return f4855a;
            }
            if (cls == Iterable.class) {
                return f4857c;
            }
            return cls.getTypeParameters();
        }

        public static TypeVariable[] b(Class cls) {
            if (cls == Map.class) {
                return f4860f;
            }
            if (cls == HashMap.class) {
                return f4861g;
            }
            if (cls == LinkedHashMap.class) {
                return f4862h;
            }
            return cls.getTypeParameters();
        }
    }

    static {
        String[] strArr = new String[0];
        f4845e = strArr;
        j[] jVarArr = new j[0];
        f4846f = jVarArr;
        f4847g = new n(strArr, jVarArr, (String[]) null);
    }

    public n(String[] strArr, j[] jVarArr, String[] strArr2) {
        strArr = strArr == null ? f4845e : strArr;
        this.f4848a = strArr;
        jVarArr = jVarArr == null ? f4846f : jVarArr;
        this.f4849b = jVarArr;
        if (strArr.length == jVarArr.length) {
            int length = jVarArr.length;
            int i10 = 1;
            for (int i11 = 0; i11 < length; i11++) {
                i10 += this.f4849b[i11].hashCode();
            }
            this.f4850c = strArr2;
            this.f4851d = i10;
            return;
        }
        throw new IllegalArgumentException("Mismatching names (" + strArr.length + "), types (" + jVarArr.length + ")");
    }

    public static n b(Class cls, List list) {
        j[] jVarArr;
        if (list == null || list.isEmpty()) {
            jVarArr = f4846f;
        } else {
            jVarArr = (j[]) list.toArray(f4846f);
        }
        return e(cls, jVarArr);
    }

    public static n c(Class cls, j jVar) {
        int i10;
        TypeVariable[] a10 = b.a(cls);
        if (a10 == null) {
            i10 = 0;
        } else {
            i10 = a10.length;
        }
        if (i10 == 1) {
            return new n(new String[]{a10[0].getName()}, new j[]{jVar}, (String[]) null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + i10);
    }

    public static n d(Class cls, j jVar, j jVar2) {
        int i10;
        TypeVariable[] b10 = b.b(cls);
        if (b10 == null) {
            i10 = 0;
        } else {
            i10 = b10.length;
        }
        if (i10 == 2) {
            return new n(new String[]{b10[0].getName(), b10[1].getName()}, new j[]{jVar, jVar2}, (String[]) null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 2 type parameters: class expects " + i10);
    }

    public static n e(Class cls, j[] jVarArr) {
        String[] strArr;
        String str;
        if (jVarArr == null) {
            jVarArr = f4846f;
        } else {
            int length = jVarArr.length;
            if (length == 1) {
                return c(cls, jVarArr[0]);
            }
            if (length == 2) {
                return d(cls, jVarArr[0], jVarArr[1]);
            }
        }
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = f4845e;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i10 = 0; i10 < length2; i10++) {
                strArr[i10] = typeParameters[i10].getName();
            }
        }
        if (strArr.length == jVarArr.length) {
            return new n(strArr, jVarArr, (String[]) null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with ");
        sb.append(jVarArr.length);
        sb.append(" type parameter");
        if (jVarArr.length == 1) {
            str = "";
        } else {
            str = "s";
        }
        sb.append(str);
        sb.append(": class expects ");
        sb.append(strArr.length);
        throw new IllegalArgumentException(sb.toString());
    }

    public static n f(List list, List list2) {
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return f4847g;
        }
        return new n((String[]) list.toArray(f4845e), (j[]) list2.toArray(f4846f), (String[]) null);
    }

    public static n g(Class cls, j jVar) {
        int i10;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null) {
            i10 = 0;
        } else {
            i10 = typeParameters.length;
        }
        if (i10 == 0) {
            return f4847g;
        }
        if (i10 == 1) {
            return new n(new String[]{typeParameters[0].getName()}, new j[]{jVar}, (String[]) null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + i10);
    }

    public static n h(Class cls, j[] jVarArr) {
        String str;
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            return f4847g;
        }
        if (jVarArr == null) {
            jVarArr = f4846f;
        }
        int length = typeParameters.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = typeParameters[i10].getName();
        }
        if (length == jVarArr.length) {
            return new n(strArr, jVarArr, (String[]) null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with ");
        sb.append(jVarArr.length);
        sb.append(" type parameter");
        if (jVarArr.length == 1) {
            str = "";
        } else {
            str = "s";
        }
        sb.append(str);
        sb.append(": class expects ");
        sb.append(length);
        throw new IllegalArgumentException(sb.toString());
    }

    public static n i() {
        return f4847g;
    }

    public Object a(Class cls) {
        return new a(cls, this.f4849b, this.f4851d);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!h.H(obj, getClass())) {
            return false;
        }
        n nVar = (n) obj;
        int length = this.f4849b.length;
        if (length != nVar.o()) {
            return false;
        }
        j[] jVarArr = nVar.f4849b;
        for (int i10 = 0; i10 < length; i10++) {
            if (!jVarArr[i10].equals(this.f4849b[i10])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f4851d;
    }

    public j j(String str) {
        j b02;
        int length = this.f4848a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(this.f4848a[i10])) {
                j jVar = this.f4849b[i10];
                if (!(jVar instanceof k) || (b02 = ((k) jVar).b0()) == null) {
                    return jVar;
                }
                return b02;
            }
        }
        return null;
    }

    public j k(int i10) {
        if (i10 < 0) {
            return null;
        }
        j[] jVarArr = this.f4849b;
        if (i10 >= jVarArr.length) {
            return null;
        }
        return jVarArr[i10];
    }

    public List l() {
        j[] jVarArr = this.f4849b;
        if (jVarArr.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(jVarArr);
    }

    public boolean m(String str) {
        String[] strArr = this.f4850c;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!str.equals(this.f4850c[length]));
        return true;
    }

    public boolean n() {
        if (this.f4849b.length == 0) {
            return true;
        }
        return false;
    }

    public int o() {
        return this.f4849b.length;
    }

    public j[] p() {
        return this.f4849b;
    }

    public n q(String str) {
        int i10;
        String[] strArr;
        String[] strArr2 = this.f4850c;
        if (strArr2 == null) {
            i10 = 0;
        } else {
            i10 = strArr2.length;
        }
        if (i10 == 0) {
            strArr = new String[1];
        } else {
            strArr = (String[]) Arrays.copyOf(strArr2, i10 + 1);
        }
        strArr[i10] = str;
        return new n(this.f4848a, this.f4849b, strArr);
    }

    public String toString() {
        if (this.f4849b.length == 0) {
            return "<>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        int length = this.f4849b.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 > 0) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            }
            sb.append(this.f4849b[i10].m());
        }
        sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        return sb.toString();
    }
}
