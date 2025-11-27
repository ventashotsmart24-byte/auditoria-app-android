package k0;

import a0.c;
import android.text.TextUtils;

public class j implements e {

    /* renamed from: a  reason: collision with root package name */
    public String f7219a;

    /* renamed from: b  reason: collision with root package name */
    public int f7220b;

    /* renamed from: c  reason: collision with root package name */
    public int f7221c;

    public j(String str, int i10, int i11) {
        this.f7219a = str;
        this.f7220b = i10;
        this.f7221c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f7220b < 0 || jVar.f7220b < 0) {
            if (!TextUtils.equals(this.f7219a, jVar.f7219a) || this.f7221c != jVar.f7221c) {
                return false;
            }
            return true;
        } else if (TextUtils.equals(this.f7219a, jVar.f7219a) && this.f7220b == jVar.f7220b && this.f7221c == jVar.f7221c) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return c.b(this.f7219a, Integer.valueOf(this.f7221c));
    }
}
