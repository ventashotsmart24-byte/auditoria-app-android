package c4;

import com.raizlabs.android.dbflow.sql.language.Operator;
import d4.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import k3.j;

public class q implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final o f4888a;

    public static final class a extends StringTokenizer {

        /* renamed from: a  reason: collision with root package name */
        public final String f4889a;

        /* renamed from: b  reason: collision with root package name */
        public int f4890b;

        /* renamed from: c  reason: collision with root package name */
        public String f4891c;

        public a(String str) {
            super(str, "<,>", true);
            this.f4889a = str;
        }

        public String a() {
            return this.f4889a;
        }

        public String b() {
            return this.f4889a.substring(this.f4890b);
        }

        public void c(String str) {
            this.f4891c = str;
        }

        public boolean hasMoreTokens() {
            if (this.f4891c != null || super.hasMoreTokens()) {
                return true;
            }
            return false;
        }

        public String nextToken() {
            String str = this.f4891c;
            if (str != null) {
                this.f4891c = null;
                return str;
            }
            String nextToken = super.nextToken();
            this.f4890b += nextToken.length();
            return nextToken.trim();
        }
    }

    public q(o oVar) {
        this.f4888a = oVar;
    }

    public IllegalArgumentException a(a aVar, String str) {
        return new IllegalArgumentException(String.format("Failed to parse type '%s' (remaining: '%s'): %s", new Object[]{aVar.a(), aVar.b(), str}));
    }

    public Class b(String str, a aVar) {
        try {
            return this.f4888a.J(str);
        } catch (Exception e10) {
            h.j0(e10);
            throw a(aVar, "Cannot locate class '" + str + "', problem: " + e10.getMessage());
        }
    }

    public j c(String str) {
        a aVar = new a(str.trim());
        j d10 = d(aVar);
        if (!aVar.hasMoreTokens()) {
            return d10;
        }
        throw a(aVar, "Unexpected tokens after complete type");
    }

    public j d(a aVar) {
        if (aVar.hasMoreTokens()) {
            Class b10 = b(aVar.nextToken(), aVar);
            if (aVar.hasMoreTokens()) {
                String nextToken = aVar.nextToken();
                if (Operator.Operation.LESS_THAN.equals(nextToken)) {
                    return this.f4888a.i((c) null, b10, n.b(b10, e(aVar)));
                }
                aVar.c(nextToken);
            }
            return this.f4888a.i((c) null, b10, n.i());
        }
        throw a(aVar, "Unexpected end-of-string");
    }

    public List e(a aVar) {
        ArrayList arrayList = new ArrayList();
        while (aVar.hasMoreTokens()) {
            arrayList.add(d(aVar));
            if (!aVar.hasMoreTokens()) {
                break;
            }
            String nextToken = aVar.nextToken();
            if (Operator.Operation.GREATER_THAN.equals(nextToken)) {
                return arrayList;
            }
            if (!",".equals(nextToken)) {
                throw a(aVar, "Unexpected token '" + nextToken + "', expected ',' or '>')");
            }
        }
        throw a(aVar, "Unexpected end-of-string");
    }
}
