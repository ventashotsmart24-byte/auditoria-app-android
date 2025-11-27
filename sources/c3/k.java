package c3;

import j3.i;
import j3.m;
import java.io.Closeable;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class k implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public static final i f4738b = i.a(r.values());

    /* renamed from: a  reason: collision with root package name */
    public int f4739a;

    public enum a {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        ALLOW_MISSING_VALUES(false),
        ALLOW_TRAILING_COMMA(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false),
        INCLUDE_SOURCE_IN_LOCATION(true);
        

        /* renamed from: a  reason: collision with root package name */
        public final boolean f4756a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4757b;

        /* access modifiers changed from: public */
        a(boolean z10) {
            this.f4757b = 1 << ordinal();
            this.f4756a = z10;
        }

        public static int a() {
            int i10 = 0;
            for (a aVar : values()) {
                if (aVar.b()) {
                    i10 |= aVar.d();
                }
            }
            return i10;
        }

        public boolean b() {
            return this.f4756a;
        }

        public boolean c(int i10) {
            if ((i10 & this.f4757b) != 0) {
                return true;
            }
            return false;
        }

        public int d() {
            return this.f4757b;
        }
    }

    public enum b {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    public k() {
    }

    public k(int i10) {
        this.f4739a = i10;
    }

    public void A0(Object obj) {
        m V = V();
        if (V != null) {
            V.i(obj);
        }
    }

    public k B0(int i10) {
        this.f4739a = i10;
        return this;
    }

    public void C0(c cVar) {
        throw new UnsupportedOperationException("Parser of type " + getClass().getName() + " does not support schema of type '" + cVar.a() + "'");
    }

    public abstract k D0();

    public abstract String E();

    public abstract n I();

    public abstract BigDecimal L();

    public abstract double M();

    public Object N() {
        return null;
    }

    public abstract float O();

    public abstract int P();

    public abstract long Q();

    public abstract b R();

    public abstract Number S();

    public Number T() {
        return S();
    }

    public Object U() {
        return null;
    }

    public abstract m V();

    public abstract i W();

    public short X() {
        int P = P();
        if (P >= -32768 && P <= 32767) {
            return (short) P;
        }
        throw new e3.a(this, String.format("Numeric value (%s) out of range of Java short", new Object[]{Y()}), n.VALUE_NUMBER_INT, Short.TYPE);
    }

    public abstract String Y();

    public abstract char[] Z();

    public o a() {
        o y10 = y();
        if (y10 != null) {
            return y10;
        }
        throw new IllegalStateException("No ObjectCodec defined for parser, needed for deserialization");
    }

    public abstract int a0();

    public j b(String str) {
        return new j(this, str).f((m) null);
    }

    public abstract int b0();

    public boolean c() {
        return false;
    }

    public abstract i c0();

    public abstract void close();

    public Object d0() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public abstract int e0();

    public abstract void f();

    public abstract long f0();

    public abstract String g0();

    public abstract boolean h0();

    public abstract boolean i0();

    public abstract boolean j0(n nVar);

    public abstract boolean k0(int i10);

    public boolean l0(a aVar) {
        return aVar.c(this.f4739a);
    }

    public String m() {
        return E();
    }

    public abstract boolean m0();

    public abstract n n();

    public abstract boolean n0();

    public abstract boolean o0();

    public abstract boolean p0();

    public abstract int q();

    public String q0() {
        if (s0() == n.FIELD_NAME) {
            return E();
        }
        return null;
    }

    public String r0() {
        if (s0() == n.VALUE_STRING) {
            return Y();
        }
        return null;
    }

    public abstract BigInteger s();

    public abstract n s0();

    public abstract n t0();

    public byte[] u() {
        return v(b.a());
    }

    public k u0(int i10, int i11) {
        return this;
    }

    public abstract byte[] v(a aVar);

    public k v0(int i10, int i11) {
        return B0((i10 & i11) | (this.f4739a & (i11 ^ -1)));
    }

    public abstract int w0(a aVar, OutputStream outputStream);

    public byte x() {
        int P = P();
        if (P >= -128 && P <= 255) {
            return (byte) P;
        }
        throw new e3.a(this, String.format("Numeric value (%s) out of range of Java byte", new Object[]{Y()}), n.VALUE_NUMBER_INT, Byte.TYPE);
    }

    public Object x0(Class cls) {
        return a().b(this, cls);
    }

    public abstract o y();

    public v y0() {
        return a().a(this);
    }

    public abstract i z();

    public boolean z0() {
        return false;
    }
}
