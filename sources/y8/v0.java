package y8;

import androidx.appcompat.app.m;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class v0 {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f20179c = Logger.getLogger(v0.class.getName());

    /* renamed from: d  reason: collision with root package name */
    public static final e f20180d = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final d f20181e = new b();

    /* renamed from: f  reason: collision with root package name */
    public static final BaseEncoding f20182f = BaseEncoding.base64().omitPadding();

    /* renamed from: a  reason: collision with root package name */
    public Object[] f20183a;

    /* renamed from: b  reason: collision with root package name */
    public int f20184b;

    public class a implements e {
    }

    public class b implements d {
        /* renamed from: c */
        public String b(String str) {
            return str;
        }

        /* renamed from: d */
        public String a(String str) {
            return str;
        }
    }

    public static class c extends g {

        /* renamed from: f  reason: collision with root package name */
        public final d f20185f;

        public /* synthetic */ c(String str, boolean z10, d dVar, a aVar) {
            this(str, z10, dVar);
        }

        public Object h(byte[] bArr) {
            return this.f20185f.b(new String(bArr, Charsets.US_ASCII));
        }

        public byte[] j(Object obj) {
            return this.f20185f.a(obj).getBytes(Charsets.US_ASCII);
        }

        public c(String str, boolean z10, d dVar) {
            super(str, z10, dVar, (a) null);
            Preconditions.checkArgument(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", (Object) str, (Object) "-bin");
            this.f20185f = (d) Preconditions.checkNotNull(dVar, "marshaller");
        }
    }

    public interface d {
        String a(Object obj);

        Object b(String str);
    }

    public interface e {
    }

    public interface f {
    }

    public static abstract class g {

        /* renamed from: e  reason: collision with root package name */
        public static final BitSet f20186e = b();

        /* renamed from: a  reason: collision with root package name */
        public final String f20187a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20188b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f20189c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f20190d;

        public /* synthetic */ g(String str, boolean z10, Object obj, a aVar) {
            this(str, z10, obj);
        }

        public static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
                bitSet.set(c10);
            }
            for (char c11 = 'a'; c11 <= 'z'; c11 = (char) (c11 + 1)) {
                bitSet.set(c11);
            }
            return bitSet;
        }

        public static g e(String str, d dVar) {
            return f(str, false, dVar);
        }

        public static g f(String str, boolean z10, d dVar) {
            return new c(str, z10, dVar, (a) null);
        }

        public static g g(String str, boolean z10, j jVar) {
            return new i(str, z10, jVar, (a) null);
        }

        public static String k(String str, boolean z10) {
            Preconditions.checkNotNull(str, "name");
            Preconditions.checkArgument(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                v0.f20179c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", new RuntimeException("exception to show backtrace"));
            }
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (!z10 || charAt != ':' || i10 != 0) {
                    Preconditions.checkArgument(f20186e.get(charAt), "Invalid character '%s' in key name '%s'", charAt, (Object) str);
                }
            }
            return str;
        }

        public byte[] a() {
            return this.f20189c;
        }

        public final Object c(Class cls) {
            if (cls.isInstance(this.f20190d)) {
                return cls.cast(this.f20190d);
            }
            return null;
        }

        public final String d() {
            return this.f20188b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f20188b.equals(((g) obj).f20188b);
        }

        public abstract Object h(byte[] bArr);

        public final int hashCode() {
            return this.f20188b.hashCode();
        }

        public boolean i() {
            return false;
        }

        public abstract byte[] j(Object obj);

        public String toString() {
            return "Key{name='" + this.f20188b + "'}";
        }

        public g(String str, boolean z10, Object obj) {
            String str2 = (String) Preconditions.checkNotNull(str, "name");
            this.f20187a = str2;
            String k10 = k(str2.toLowerCase(Locale.ROOT), z10);
            this.f20188b = k10;
            this.f20189c = k10.getBytes(Charsets.US_ASCII);
            this.f20190d = obj;
        }
    }

    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final Object f20191a;

        /* renamed from: b  reason: collision with root package name */
        public volatile byte[] f20192b;

        public h(f fVar, Object obj) {
            this.f20191a = obj;
        }

        public static h a(g gVar, Object obj) {
            b(gVar);
            m.a(Preconditions.checkNotNull(null));
            return new h((f) null, obj);
        }

        public static f b(g gVar) {
            m.a(gVar.c(f.class));
            return null;
        }

        public byte[] c() {
            if (this.f20192b == null) {
                synchronized (this) {
                    if (this.f20192b == null) {
                        this.f20192b = v0.q(e());
                    }
                }
            }
            return this.f20192b;
        }

        public Object d(g gVar) {
            if (gVar.i()) {
                b(gVar);
            }
            return gVar.h(c());
        }

        public InputStream e() {
            throw null;
        }
    }

    public static final class i extends g {

        /* renamed from: f  reason: collision with root package name */
        public final j f20193f;

        public /* synthetic */ i(String str, boolean z10, j jVar, a aVar) {
            this(str, z10, jVar);
        }

        public Object h(byte[] bArr) {
            return this.f20193f.b(bArr);
        }

        public byte[] j(Object obj) {
            return this.f20193f.a(obj);
        }

        public i(String str, boolean z10, j jVar) {
            super(str, z10, jVar, (a) null);
            Preconditions.checkArgument(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", (Object) str, (Object) "-bin");
            this.f20193f = (j) Preconditions.checkNotNull(jVar, "marshaller");
        }
    }

    public interface j {
        byte[] a(Object obj);

        Object b(byte[] bArr);
    }

    public v0() {
    }

    public v0(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    public static byte[] q(InputStream inputStream) {
        try {
            return ByteStreams.toByteArray(inputStream);
        } catch (IOException e10) {
            throw new RuntimeException("failure reading serialized stream", e10);
        }
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int d() {
        Object[] objArr = this.f20183a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public void e(g gVar) {
        if (!i()) {
            int i10 = 0;
            for (int i11 = 0; i11 < this.f20184b; i11++) {
                if (!c(gVar.a(), n(i11))) {
                    m(i10, n(i11));
                    s(i10, r(i11));
                    i10++;
                }
            }
            Arrays.fill(this.f20183a, i10 * 2, j(), (Object) null);
            this.f20184b = i10;
        }
    }

    public final void f(int i10) {
        Object[] objArr = new Object[i10];
        if (!i()) {
            System.arraycopy(this.f20183a, 0, objArr, 0, j());
        }
        this.f20183a = objArr;
    }

    public Object g(g gVar) {
        for (int i10 = this.f20184b - 1; i10 >= 0; i10--) {
            if (c(gVar.a(), n(i10))) {
                return v(i10, gVar);
            }
        }
        return null;
    }

    public int h() {
        return this.f20184b;
    }

    public final boolean i() {
        if (this.f20184b == 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.f20184b * 2;
    }

    public final void k() {
        if (j() == 0 || j() == d()) {
            f(Math.max(j() * 2, 8));
        }
    }

    public void l(v0 v0Var) {
        if (!v0Var.i()) {
            int d10 = d() - j();
            if (i() || d10 < v0Var.j()) {
                f(j() + v0Var.j());
            }
            System.arraycopy(v0Var.f20183a, 0, this.f20183a, j(), v0Var.j());
            this.f20184b += v0Var.f20184b;
        }
    }

    public final void m(int i10, byte[] bArr) {
        this.f20183a[i10 * 2] = bArr;
    }

    public final byte[] n(int i10) {
        return (byte[]) this.f20183a[i10 * 2];
    }

    public void o(g gVar, Object obj) {
        Preconditions.checkNotNull(gVar, "key");
        Preconditions.checkNotNull(obj, "value");
        k();
        m(this.f20184b, gVar.a());
        if (gVar.i()) {
            s(this.f20184b, h.a(gVar, obj));
        } else {
            t(this.f20184b, gVar.j(obj));
        }
        this.f20184b++;
    }

    public byte[][] p() {
        byte[][] bArr = new byte[j()][];
        Object[] objArr = this.f20183a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, j());
        } else {
            for (int i10 = 0; i10 < this.f20184b; i10++) {
                int i11 = i10 * 2;
                bArr[i11] = n(i10);
                bArr[i11 + 1] = u(i10);
            }
        }
        return bArr;
    }

    public final Object r(int i10) {
        return this.f20183a[(i10 * 2) + 1];
    }

    public final void s(int i10, Object obj) {
        if (this.f20183a instanceof byte[][]) {
            f(d());
        }
        this.f20183a[(i10 * 2) + 1] = obj;
    }

    public final void t(int i10, byte[] bArr) {
        this.f20183a[(i10 * 2) + 1] = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i10 = 0; i10 < this.f20184b; i10++) {
            if (i10 != 0) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            }
            byte[] n10 = n(i10);
            Charset charset = Charsets.US_ASCII;
            String str = new String(n10, charset);
            sb.append(str);
            sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            if (str.endsWith("-bin")) {
                sb.append(f20182f.encode(u(i10)));
            } else {
                sb.append(new String(u(i10), charset));
            }
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        return sb.toString();
    }

    public final byte[] u(int i10) {
        Object r10 = r(i10);
        if (r10 instanceof byte[]) {
            return (byte[]) r10;
        }
        return ((h) r10).c();
    }

    public final Object v(int i10, g gVar) {
        Object r10 = r(i10);
        if (r10 instanceof byte[]) {
            return gVar.h((byte[]) r10);
        }
        return ((h) r10).d(gVar);
    }

    public v0(int i10, byte[]... bArr) {
        this(i10, (Object[]) bArr);
    }

    public v0(int i10, Object[] objArr) {
        this.f20184b = i10;
        this.f20183a = objArr;
    }
}
