package d4;

import java.io.Serializable;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f6290a = new e();

    public class a extends q {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6291b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6292c;

        public a(String str, String str2) {
            this.f6291b = str;
            this.f6292c = str2;
        }

        public String c(String str) {
            return this.f6291b + str + this.f6292c;
        }

        public String toString() {
            return "[PreAndSuffixTransformer('" + this.f6291b + "','" + this.f6292c + "')]";
        }
    }

    public class b extends q {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6293b;

        public b(String str) {
            this.f6293b = str;
        }

        public String c(String str) {
            return this.f6293b + str;
        }

        public String toString() {
            return "[PrefixTransformer('" + this.f6293b + "')]";
        }
    }

    public class c extends q {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6294b;

        public c(String str) {
            this.f6294b = str;
        }

        public String c(String str) {
            return str + this.f6294b;
        }

        public String toString() {
            return "[SuffixTransformer('" + this.f6294b + "')]";
        }
    }

    public static class d extends q implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public final q f6295b;

        /* renamed from: c  reason: collision with root package name */
        public final q f6296c;

        public d(q qVar, q qVar2) {
            this.f6295b = qVar;
            this.f6296c = qVar2;
        }

        public String c(String str) {
            return this.f6295b.c(this.f6296c.c(str));
        }

        public String toString() {
            return "[ChainedTransformer(" + this.f6295b + ", " + this.f6296c + ")]";
        }
    }

    public static final class e extends q implements Serializable {
        public String c(String str) {
            return str;
        }
    }

    public static q a(q qVar, q qVar2) {
        return new d(qVar, qVar2);
    }

    public static q b(String str, String str2) {
        boolean z10;
        boolean z11 = true;
        if (str == null || str.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (str2 == null || str2.isEmpty()) {
            z11 = false;
        }
        if (z10) {
            if (z11) {
                return new a(str, str2);
            }
            return new b(str);
        } else if (z11) {
            return new c(str2);
        } else {
            return f6290a;
        }
    }

    public abstract String c(String str);
}
