package c3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

public class w implements Comparable, Serializable {

    /* renamed from: g  reason: collision with root package name */
    public static final w f4802g = new w(0, 0, 0, (String) null, (String) null, (String) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f4803a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4804b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4805c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4806d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4807e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4808f;

    public w(int i10, int i11, int i12, String str, String str2, String str3) {
        this.f4803a = i10;
        this.f4804b = i11;
        this.f4805c = i12;
        this.f4808f = str;
        this.f4806d = str2 == null ? "" : str2;
        this.f4807e = str3 == null ? "" : str3;
    }

    public static w c() {
        return f4802g;
    }

    /* renamed from: a */
    public int compareTo(w wVar) {
        if (wVar == this) {
            return 0;
        }
        int compareTo = this.f4806d.compareTo(wVar.f4806d);
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = this.f4807e.compareTo(wVar.f4807e);
        if (compareTo2 != 0) {
            return compareTo2;
        }
        int i10 = this.f4803a - wVar.f4803a;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f4804b - wVar.f4804b;
        if (i11 == 0) {
            return this.f4805c - wVar.f4805c;
        }
        return i11;
    }

    public boolean b() {
        String str = this.f4808f;
        if (str == null || str.length() <= 0) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        w wVar = (w) obj;
        if (wVar.f4803a == this.f4803a && wVar.f4804b == this.f4804b && wVar.f4805c == this.f4805c && wVar.f4807e.equals(this.f4807e) && wVar.f4806d.equals(this.f4806d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f4807e.hashCode() ^ (((this.f4806d.hashCode() + this.f4803a) - this.f4804b) + this.f4805c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4803a);
        sb.append('.');
        sb.append(this.f4804b);
        sb.append('.');
        sb.append(this.f4805c);
        if (b()) {
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            sb.append(this.f4808f);
        }
        return sb.toString();
    }
}
