package d4;

import c3.q;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import m3.m;

public final class l implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final Class f6281a;

    /* renamed from: b  reason: collision with root package name */
    public final Enum[] f6282b;

    /* renamed from: c  reason: collision with root package name */
    public final q[] f6283c;

    public l(Class cls, q[] qVarArr) {
        this.f6281a = cls;
        this.f6282b = (Enum[]) cls.getEnumConstants();
        this.f6283c = qVarArr;
    }

    public static l a(Class cls, q[] qVarArr) {
        return new l(cls, qVarArr);
    }

    public static l b(m mVar, Class cls) {
        Class r10 = h.r(cls);
        Enum[] enumArr = (Enum[]) r10.getEnumConstants();
        if (enumArr != null) {
            String[] o10 = mVar.g().o(r10, enumArr, new String[enumArr.length]);
            q[] qVarArr = new q[enumArr.length];
            int length = enumArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Enum enumR = enumArr[i10];
                String str = o10[i10];
                if (str == null) {
                    str = enumR.name();
                }
                qVarArr[enumR.ordinal()] = mVar.d(str);
            }
            return a(cls, qVarArr);
        }
        throw new IllegalArgumentException("Cannot determine enum constants for Class " + cls.getName());
    }

    public Class c() {
        return this.f6281a;
    }

    public q d(Enum enumR) {
        return this.f6283c[enumR.ordinal()];
    }

    public Collection e() {
        return Arrays.asList(this.f6283c);
    }
}
