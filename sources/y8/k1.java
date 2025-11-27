package y8;

import com.google.android.gms.cast.MediaTrack;
import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.taobao.accs.common.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import y8.v0;

public final class k1 {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f20039d = Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));

    /* renamed from: e  reason: collision with root package name */
    public static final List f20040e = g();

    /* renamed from: f  reason: collision with root package name */
    public static final k1 f20041f = b.OK.b();

    /* renamed from: g  reason: collision with root package name */
    public static final k1 f20042g = b.CANCELLED.b();

    /* renamed from: h  reason: collision with root package name */
    public static final k1 f20043h = b.UNKNOWN.b();

    /* renamed from: i  reason: collision with root package name */
    public static final k1 f20044i = b.INVALID_ARGUMENT.b();

    /* renamed from: j  reason: collision with root package name */
    public static final k1 f20045j = b.DEADLINE_EXCEEDED.b();

    /* renamed from: k  reason: collision with root package name */
    public static final k1 f20046k = b.NOT_FOUND.b();

    /* renamed from: l  reason: collision with root package name */
    public static final k1 f20047l = b.ALREADY_EXISTS.b();

    /* renamed from: m  reason: collision with root package name */
    public static final k1 f20048m = b.PERMISSION_DENIED.b();

    /* renamed from: n  reason: collision with root package name */
    public static final k1 f20049n = b.UNAUTHENTICATED.b();

    /* renamed from: o  reason: collision with root package name */
    public static final k1 f20050o = b.RESOURCE_EXHAUSTED.b();

    /* renamed from: p  reason: collision with root package name */
    public static final k1 f20051p = b.FAILED_PRECONDITION.b();

    /* renamed from: q  reason: collision with root package name */
    public static final k1 f20052q = b.ABORTED.b();

    /* renamed from: r  reason: collision with root package name */
    public static final k1 f20053r = b.OUT_OF_RANGE.b();

    /* renamed from: s  reason: collision with root package name */
    public static final k1 f20054s = b.UNIMPLEMENTED.b();

    /* renamed from: t  reason: collision with root package name */
    public static final k1 f20055t = b.INTERNAL.b();

    /* renamed from: u  reason: collision with root package name */
    public static final k1 f20056u = b.UNAVAILABLE.b();

    /* renamed from: v  reason: collision with root package name */
    public static final k1 f20057v = b.DATA_LOSS.b();

    /* renamed from: w  reason: collision with root package name */
    public static final v0.g f20058w = v0.g.g("grpc-status", false, new c());

    /* renamed from: x  reason: collision with root package name */
    public static final v0.j f20059x;

    /* renamed from: y  reason: collision with root package name */
    public static final v0.g f20060y;

    /* renamed from: a  reason: collision with root package name */
    public final b f20061a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20062b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f20063c;

    public enum b {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f20082a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f20083b;

        /* access modifiers changed from: public */
        b(int i10) {
            this.f20082a = i10;
            this.f20083b = Integer.toString(i10).getBytes(Charsets.US_ASCII);
        }

        public k1 b() {
            return (k1) k1.f20040e.get(this.f20082a);
        }

        public int c() {
            return this.f20082a;
        }

        public final byte[] d() {
            return this.f20083b;
        }
    }

    public static final class c implements v0.j {
        public c() {
        }

        /* renamed from: c */
        public k1 b(byte[] bArr) {
            return k1.j(bArr);
        }

        /* renamed from: d */
        public byte[] a(k1 k1Var) {
            return k1Var.n().d();
        }
    }

    public static final class d implements v0.j {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f20084a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d() {
        }

        public static boolean c(byte b10) {
            return b10 < 32 || b10 >= 126 || b10 == 37;
        }

        public static String e(byte[] bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            int i10 = 0;
            while (i10 < bArr.length) {
                if (bArr[i10] == 37 && i10 + 2 < bArr.length) {
                    try {
                        allocate.put((byte) Integer.parseInt(new String(bArr, i10 + 1, 2, Charsets.US_ASCII), 16));
                        i10 += 3;
                    } catch (NumberFormatException unused) {
                    }
                }
                allocate.put(bArr[i10]);
                i10++;
            }
            return new String(allocate.array(), 0, allocate.position(), Charsets.UTF_8);
        }

        public static byte[] g(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[(((bArr.length - i10) * 3) + i10)];
            if (i10 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i10);
            }
            int i11 = i10;
            while (i10 < bArr.length) {
                byte b10 = bArr[i10];
                if (c(b10)) {
                    bArr2[i11] = 37;
                    byte[] bArr3 = f20084a;
                    bArr2[i11 + 1] = bArr3[(b10 >> 4) & 15];
                    bArr2[i11 + 2] = bArr3[b10 & 15];
                    i11 += 3;
                } else {
                    bArr2[i11] = b10;
                    i11++;
                }
                i10++;
            }
            return Arrays.copyOf(bArr2, i11);
        }

        /* renamed from: d */
        public String b(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b10 = bArr[i10];
                if (b10 < 32 || b10 >= 126 || (b10 == 37 && i10 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        /* renamed from: f */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            for (int i10 = 0; i10 < bytes.length; i10++) {
                if (c(bytes[i10])) {
                    return g(bytes, i10);
                }
            }
            return bytes;
        }
    }

    static {
        d dVar = new d();
        f20059x = dVar;
        f20060y = v0.g.g("grpc-message", false, dVar);
    }

    public k1(b bVar) {
        this(bVar, (String) null, (Throwable) null);
    }

    public static List g() {
        TreeMap treeMap = new TreeMap();
        b[] values = b.values();
        int length = values.length;
        int i10 = 0;
        while (i10 < length) {
            b bVar = values[i10];
            k1 k1Var = (k1) treeMap.put(Integer.valueOf(bVar.c()), new k1(bVar));
            if (k1Var == null) {
                i10++;
            } else {
                throw new IllegalStateException("Code value duplication between " + k1Var.n().name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String h(k1 k1Var) {
        if (k1Var.f20062b == null) {
            return k1Var.f20061a.toString();
        }
        return k1Var.f20061a + ": " + k1Var.f20062b;
    }

    public static k1 i(int i10) {
        if (i10 >= 0) {
            List list = f20040e;
            if (i10 <= list.size()) {
                return (k1) list.get(i10);
            }
        }
        k1 k1Var = f20043h;
        return k1Var.r("Unknown code " + i10);
    }

    public static k1 j(byte[] bArr) {
        if (bArr.length == 1 && bArr[0] == 48) {
            return f20041f;
        }
        return k(bArr);
    }

    public static k1 k(byte[] bArr) {
        byte b10;
        int length = bArr.length;
        char c10 = 1;
        int i10 = 0;
        if (length != 1) {
            if (length == 2 && (b10 = bArr[0]) >= 48 && b10 <= 57) {
                i10 = 0 + ((b10 - 48) * 10);
            }
            k1 k1Var = f20043h;
            return k1Var.r("Unknown code " + new String(bArr, Charsets.US_ASCII));
        }
        c10 = 0;
        byte b11 = bArr[c10];
        if (b11 >= 48 && b11 <= 57) {
            int i11 = i10 + (b11 - 48);
            List list = f20040e;
            if (i11 < list.size()) {
                return (k1) list.get(i11);
            }
        }
        k1 k1Var2 = f20043h;
        return k1Var2.r("Unknown code " + new String(bArr, Charsets.US_ASCII));
    }

    public static k1 l(Throwable th) {
        for (Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof l1) {
                return ((l1) th2).a();
            }
            if (th2 instanceof m1) {
                return ((m1) th2).a();
            }
        }
        return f20043h.q(th);
    }

    public l1 c() {
        return new l1(this);
    }

    public m1 d() {
        return new m1(this);
    }

    public m1 e(v0 v0Var) {
        return new m1(this, v0Var);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public k1 f(String str) {
        if (str == null) {
            return this;
        }
        if (this.f20062b == null) {
            return new k1(this.f20061a, str, this.f20063c);
        }
        b bVar = this.f20061a;
        return new k1(bVar, this.f20062b + "\n" + str, this.f20063c);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable m() {
        return this.f20063c;
    }

    public b n() {
        return this.f20061a;
    }

    public String o() {
        return this.f20062b;
    }

    public boolean p() {
        if (b.OK == this.f20061a) {
            return true;
        }
        return false;
    }

    public k1 q(Throwable th) {
        if (Objects.equal(this.f20063c, th)) {
            return this;
        }
        return new k1(this.f20061a, this.f20062b, th);
    }

    public k1 r(String str) {
        if (Objects.equal(this.f20062b, str)) {
            return this;
        }
        return new k1(this.f20061a, str, this.f20063c);
    }

    public String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper((Object) this).add(Constants.KEY_HTTP_CODE, (Object) this.f20061a.name()).add(MediaTrack.ROLE_DESCRIPTION, (Object) this.f20062b);
        Throwable th = this.f20063c;
        Object obj = th;
        if (th != null) {
            obj = Throwables.getStackTraceAsString(th);
        }
        return add.add("cause", obj).toString();
    }

    public k1(b bVar, String str, Throwable th) {
        this.f20061a = (b) Preconditions.checkNotNull(bVar, Constants.KEY_HTTP_CODE);
        this.f20062b = str;
        this.f20063c = th;
    }
}
