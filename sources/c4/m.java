package c4;

import c3.h;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import i3.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k3.c0;
import k3.j;
import k3.n;

public abstract class m extends j implements n {

    /* renamed from: j  reason: collision with root package name */
    public static final n f4839j = n.i();

    /* renamed from: k  reason: collision with root package name */
    public static final j[] f4840k = new j[0];

    /* renamed from: f  reason: collision with root package name */
    public final j f4841f;

    /* renamed from: g  reason: collision with root package name */
    public final j[] f4842g;

    /* renamed from: h  reason: collision with root package name */
    public final n f4843h;

    /* renamed from: i  reason: collision with root package name */
    public volatile transient String f4844i;

    public m(Class cls, n nVar, j jVar, j[] jVarArr, int i10, Object obj, Object obj2, boolean z10) {
        super(cls, i10, obj, obj2, z10);
        this.f4843h = nVar == null ? f4839j : nVar;
        this.f4841f = jVar;
        this.f4842g = jVarArr;
    }

    public static StringBuilder Y(Class cls, StringBuilder sb, boolean z10) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = name.charAt(i10);
                if (charAt == '.') {
                    charAt = '/';
                }
                sb.append(charAt);
            }
            if (z10) {
                sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
            }
        } else if (cls == Boolean.TYPE) {
            sb.append(ASCIIPropertyListParser.DATE_APPLE_END_TOKEN);
        } else if (cls == Byte.TYPE) {
            sb.append(ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN);
        } else if (cls == Short.TYPE) {
            sb.append('S');
        } else if (cls == Character.TYPE) {
            sb.append('C');
        } else if (cls == Integer.TYPE) {
            sb.append(ASCIIPropertyListParser.DATA_GSINT_BEGIN_TOKEN);
        } else if (cls == Long.TYPE) {
            sb.append('J');
        } else if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append(ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN);
        } else if (cls == Void.TYPE) {
            sb.append('V');
        } else {
            throw new IllegalStateException("Unrecognized primitive type: " + cls.getName());
        }
        return sb;
    }

    public boolean Z(int i10) {
        if (this.f7409a.getTypeParameters().length == i10) {
            return true;
        }
        return false;
    }

    public String a0() {
        return this.f7409a.getName();
    }

    public String c() {
        String str = this.f4844i;
        if (str == null) {
            return a0();
        }
        return str;
    }

    public void d(h hVar, c0 c0Var) {
        hVar.z0(c());
    }

    public void e(h hVar, c0 c0Var, w3.h hVar2) {
        b bVar = new b(this, c3.n.VALUE_STRING);
        hVar2.g(hVar, bVar);
        d(hVar, c0Var);
        hVar2.h(hVar, bVar);
    }

    public j f(int i10) {
        return this.f4843h.k(i10);
    }

    public int g() {
        return this.f4843h.o();
    }

    public final j i(Class cls) {
        j i10;
        j[] jVarArr;
        if (cls == this.f7409a) {
            return this;
        }
        if (cls.isInterface() && (jVarArr = this.f4842g) != null) {
            int length = jVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                j i12 = this.f4842g[i11].i(cls);
                if (i12 != null) {
                    return i12;
                }
            }
        }
        j jVar = this.f4841f;
        if (jVar == null || (i10 = jVar.i(cls)) == null) {
            return null;
        }
        return i10;
    }

    public n j() {
        return this.f4843h;
    }

    public List o() {
        j[] jVarArr = this.f4842g;
        if (jVarArr == null) {
            return Collections.emptyList();
        }
        int length = jVarArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Arrays.asList(jVarArr);
        }
        return Collections.singletonList(jVarArr[0]);
    }

    public j s() {
        return this.f4841f;
    }
}
