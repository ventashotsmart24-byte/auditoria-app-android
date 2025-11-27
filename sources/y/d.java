package y;

import a0.h;
import android.util.Base64;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f9812a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9813b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9814c;

    /* renamed from: d  reason: collision with root package name */
    public final List f9815d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9816e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final String f9817f;

    public d(String str, String str2, String str3, List list) {
        this.f9812a = (String) h.d(str);
        this.f9813b = (String) h.d(str2);
        this.f9814c = (String) h.d(str3);
        this.f9815d = (List) h.d(list);
        this.f9817f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + Operator.Operation.MINUS + str2 + Operator.Operation.MINUS + str3;
    }

    public List b() {
        return this.f9815d;
    }

    public int c() {
        return this.f9816e;
    }

    public String d() {
        return this.f9817f;
    }

    public String e() {
        return this.f9812a;
    }

    public String f() {
        return this.f9813b;
    }

    public String g() {
        return this.f9814c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f9812a + ", mProviderPackage: " + this.f9813b + ", mQuery: " + this.f9814c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f9815d.size(); i10++) {
            sb.append(" [");
            List list = (List) this.f9815d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i11), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f9816e);
        return sb.toString();
    }
}
