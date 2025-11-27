package c3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.RootDescription;
import com.raizlabs.android.dbflow.sql.language.Operator;
import f3.a;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public int f4766a;

    /* renamed from: b  reason: collision with root package name */
    public int f4767b;

    public m() {
    }

    public m(m mVar) {
        this.f4766a = mVar.f4766a;
        this.f4767b = mVar.f4767b;
    }

    public final int a() {
        int i10 = this.f4767b;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public abstract String b();

    public abstract Object c();

    public final int d() {
        return this.f4767b + 1;
    }

    public abstract m e();

    public final boolean f() {
        if (this.f4766a == 1) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (this.f4766a == 2) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        if (this.f4766a == 0) {
            return true;
        }
        return false;
    }

    public abstract void i(Object obj);

    public String j() {
        int i10 = this.f4766a;
        if (i10 == 0) {
            return RootDescription.ROOT_ELEMENT;
        }
        if (i10 == 1) {
            return "Array";
        }
        if (i10 != 2) {
            return Operator.Operation.EMPTY_PARAM;
        }
        return "Object";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i10 = this.f4766a;
        if (i10 == 0) {
            sb.append(Operator.Operation.DIVISION);
        } else if (i10 != 1) {
            sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
            String b10 = b();
            if (b10 != null) {
                sb.append('\"');
                a.a(sb, b10);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        } else {
            sb.append('[');
            sb.append(a());
            sb.append(']');
        }
        return sb.toString();
    }

    public m(int i10, int i11) {
        this.f4766a = i10;
        this.f4767b = i11;
    }
}
