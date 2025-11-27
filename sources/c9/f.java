package c9;

import anet.channel.util.HttpConstant;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.messaging.Constants;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f11428a = ByteString.encodeUtf8(SOAP.DELIM);

    /* renamed from: b  reason: collision with root package name */
    public static final d[] f11429b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map f11430c = f();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List f11431a;

        /* renamed from: b  reason: collision with root package name */
        public final BufferedSource f11432b;

        /* renamed from: c  reason: collision with root package name */
        public int f11433c;

        /* renamed from: d  reason: collision with root package name */
        public int f11434d;

        /* renamed from: e  reason: collision with root package name */
        public d[] f11435e;

        /* renamed from: f  reason: collision with root package name */
        public int f11436f;

        /* renamed from: g  reason: collision with root package name */
        public int f11437g;

        /* renamed from: h  reason: collision with root package name */
        public int f11438h;

        public a(int i10, Source source) {
            this(i10, i10, source);
        }

        public final void a() {
            int i10 = this.f11434d;
            int i11 = this.f11438h;
            if (i10 >= i11) {
                return;
            }
            if (i10 == 0) {
                b();
            } else {
                d(i11 - i10);
            }
        }

        public final void b() {
            Arrays.fill(this.f11435e, (Object) null);
            this.f11436f = this.f11435e.length - 1;
            this.f11437g = 0;
            this.f11438h = 0;
        }

        public final int c(int i10) {
            return this.f11436f + 1 + i10;
        }

        public final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f11435e.length;
                while (true) {
                    length--;
                    i11 = this.f11436f;
                    if (length < i11 || i10 <= 0) {
                        d[] dVarArr = this.f11435e;
                        System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f11437g);
                        this.f11436f += i12;
                    } else {
                        int i13 = this.f11435e[length].f11422c;
                        i10 -= i13;
                        this.f11438h -= i13;
                        this.f11437g--;
                        i12++;
                    }
                }
                d[] dVarArr2 = this.f11435e;
                System.arraycopy(dVarArr2, i11 + 1, dVarArr2, i11 + 1 + i12, this.f11437g);
                this.f11436f += i12;
            }
            return i12;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f11431a);
            this.f11431a.clear();
            return arrayList;
        }

        public final ByteString f(int i10) {
            if (i(i10)) {
                return f.f11429b[i10].f11420a;
            }
            int c10 = c(i10 - f.f11429b.length);
            if (c10 >= 0) {
                d[] dVarArr = this.f11435e;
                if (c10 < dVarArr.length) {
                    return dVarArr[c10].f11420a;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public void g(int i10) {
            this.f11433c = i10;
            this.f11434d = i10;
            a();
        }

        public final void h(int i10, d dVar) {
            this.f11431a.add(dVar);
            int i11 = dVar.f11422c;
            if (i10 != -1) {
                i11 -= this.f11435e[c(i10)].f11422c;
            }
            int i12 = this.f11434d;
            if (i11 > i12) {
                b();
                return;
            }
            int d10 = d((this.f11438h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f11437g + 1;
                d[] dVarArr = this.f11435e;
                if (i13 > dVarArr.length) {
                    d[] dVarArr2 = new d[(dVarArr.length * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f11436f = this.f11435e.length - 1;
                    this.f11435e = dVarArr2;
                }
                int i14 = this.f11436f;
                this.f11436f = i14 - 1;
                this.f11435e[i14] = dVar;
                this.f11437g++;
            } else {
                this.f11435e[i10 + c(i10) + d10] = dVar;
            }
            this.f11438h += i11;
        }

        public final boolean i(int i10) {
            if (i10 < 0 || i10 > f.f11429b.length - 1) {
                return false;
            }
            return true;
        }

        public final int j() {
            return this.f11432b.readByte() & UnsignedBytes.MAX_VALUE;
        }

        public ByteString k() {
            boolean z10;
            int j10 = j();
            if ((j10 & 128) == 128) {
                z10 = true;
            } else {
                z10 = false;
            }
            int n10 = n(j10, 127);
            if (z10) {
                return ByteString.of(h.f().c(this.f11432b.readByteArray((long) n10)));
            }
            return this.f11432b.readByteString((long) n10);
        }

        public void l() {
            while (!this.f11432b.exhausted()) {
                byte readByte = this.f11432b.readByte() & UnsignedBytes.MAX_VALUE;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                    m(n(readByte, 127) - 1);
                } else if (readByte == 64) {
                    p();
                } else if ((readByte & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                    o(n(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int n10 = n(readByte, 31);
                    this.f11434d = n10;
                    if (n10 < 0 || n10 > this.f11433c) {
                        throw new IOException("Invalid dynamic table size update " + this.f11434d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    r();
                } else {
                    q(n(readByte, 15) - 1);
                }
            }
        }

        public final void m(int i10) {
            if (i(i10)) {
                this.f11431a.add(f.f11429b[i10]);
                return;
            }
            int c10 = c(i10 - f.f11429b.length);
            if (c10 >= 0) {
                d[] dVarArr = this.f11435e;
                if (c10 <= dVarArr.length - 1) {
                    this.f11431a.add(dVarArr[c10]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public int n(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int j10 = j();
                if ((j10 & 128) == 0) {
                    return i11 + (j10 << i13);
                }
                i11 += (j10 & 127) << i13;
                i13 += 7;
            }
        }

        public final void o(int i10) {
            h(-1, new d(f(i10), k()));
        }

        public final void p() {
            h(-1, new d(f.e(k()), k()));
        }

        public final void q(int i10) {
            this.f11431a.add(new d(f(i10), k()));
        }

        public final void r() {
            this.f11431a.add(new d(f.e(k()), k()));
        }

        public a(int i10, int i11, Source source) {
            this.f11431a = new ArrayList();
            d[] dVarArr = new d[8];
            this.f11435e = dVarArr;
            this.f11436f = dVarArr.length - 1;
            this.f11437g = 0;
            this.f11438h = 0;
            this.f11433c = i10;
            this.f11434d = i11;
            this.f11432b = Okio.buffer(source);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Buffer f11439a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11440b;

        /* renamed from: c  reason: collision with root package name */
        public int f11441c;

        /* renamed from: d  reason: collision with root package name */
        public int f11442d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11443e;

        /* renamed from: f  reason: collision with root package name */
        public int f11444f;

        /* renamed from: g  reason: collision with root package name */
        public d[] f11445g;

        /* renamed from: h  reason: collision with root package name */
        public int f11446h;

        /* renamed from: i  reason: collision with root package name */
        public int f11447i;

        /* renamed from: j  reason: collision with root package name */
        public int f11448j;

        public b(Buffer buffer) {
            this(4096, false, buffer);
        }

        public final void a() {
            Arrays.fill(this.f11445g, (Object) null);
            this.f11447i = this.f11445g.length - 1;
            this.f11446h = 0;
            this.f11448j = 0;
        }

        public final int b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f11445g.length;
                while (true) {
                    length--;
                    i11 = this.f11447i;
                    if (length < i11 || i10 <= 0) {
                        d[] dVarArr = this.f11445g;
                        System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f11446h);
                        this.f11447i += i12;
                    } else {
                        int i13 = this.f11445g[length].f11422c;
                        i10 -= i13;
                        this.f11448j -= i13;
                        this.f11446h--;
                        i12++;
                    }
                }
                d[] dVarArr2 = this.f11445g;
                System.arraycopy(dVarArr2, i11 + 1, dVarArr2, i11 + 1 + i12, this.f11446h);
                this.f11447i += i12;
            }
            return i12;
        }

        public final void c(d dVar) {
            int i10 = dVar.f11422c;
            int i11 = this.f11444f;
            if (i10 > i11) {
                a();
                return;
            }
            b((this.f11448j + i10) - i11);
            int i12 = this.f11446h + 1;
            d[] dVarArr = this.f11445g;
            if (i12 > dVarArr.length) {
                d[] dVarArr2 = new d[(dVarArr.length * 2)];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f11447i = this.f11445g.length - 1;
                this.f11445g = dVarArr2;
            }
            int i13 = this.f11447i;
            this.f11447i = i13 - 1;
            this.f11445g[i13] = dVar;
            this.f11446h++;
            this.f11448j += i10;
        }

        public void d(ByteString byteString) {
            if (!this.f11440b || h.f().e(byteString.toByteArray()) >= byteString.size()) {
                f(byteString.size(), 127, 0);
                this.f11439a.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            h.f().d(byteString.toByteArray(), buffer.outputStream());
            ByteString readByteString = buffer.readByteString();
            f(readByteString.size(), 127, 128);
            this.f11439a.write(readByteString);
        }

        public void e(List list) {
            int i10;
            int i11;
            if (this.f11443e) {
                int i12 = this.f11442d;
                if (i12 < this.f11444f) {
                    f(i12, 31, 32);
                }
                this.f11443e = false;
                this.f11442d = Integer.MAX_VALUE;
                f(this.f11444f, 31, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                d dVar = (d) list.get(i13);
                ByteString asciiLowercase = dVar.f11420a.toAsciiLowercase();
                ByteString byteString = dVar.f11421b;
                Integer num = (Integer) f.f11430c.get(asciiLowercase);
                if (num != null) {
                    i11 = num.intValue() + 1;
                    if (i11 >= 2 && i11 <= 7) {
                        if (f.f11429b[i11 - 1].f11421b.equals(byteString)) {
                            i10 = i11;
                        } else if (f.f11429b[i11].f11421b.equals(byteString)) {
                            i10 = i11;
                            i11++;
                        }
                    }
                    i10 = i11;
                    i11 = -1;
                } else {
                    i11 = -1;
                    i10 = -1;
                }
                if (i11 == -1) {
                    int i14 = this.f11447i;
                    while (true) {
                        i14++;
                        d[] dVarArr = this.f11445g;
                        if (i14 >= dVarArr.length) {
                            break;
                        } else if (dVarArr[i14].f11420a.equals(asciiLowercase)) {
                            if (this.f11445g[i14].f11421b.equals(byteString)) {
                                i11 = f.f11429b.length + (i14 - this.f11447i);
                                break;
                            } else if (i10 == -1) {
                                i10 = (i14 - this.f11447i) + f.f11429b.length;
                            }
                        }
                    }
                }
                if (i11 != -1) {
                    f(i11, 127, 128);
                } else if (i10 == -1) {
                    this.f11439a.writeByte(64);
                    d(asciiLowercase);
                    d(byteString);
                    c(dVar);
                } else if (!asciiLowercase.startsWith(f.f11428a) || d.f11417h.equals(asciiLowercase)) {
                    f(i10, 63, 64);
                    d(byteString);
                    c(dVar);
                } else {
                    f(i10, 15, 0);
                    d(byteString);
                }
            }
        }

        public void f(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f11439a.writeByte(i10 | i12);
                return;
            }
            this.f11439a.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f11439a.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f11439a.writeByte(i13);
        }

        public b(int i10, boolean z10, Buffer buffer) {
            this.f11442d = Integer.MAX_VALUE;
            d[] dVarArr = new d[8];
            this.f11445g = dVarArr;
            this.f11447i = dVarArr.length - 1;
            this.f11441c = i10;
            this.f11444f = i10;
            this.f11440b = z10;
            this.f11439a = buffer;
        }
    }

    static {
        ByteString byteString = d.f11414e;
        ByteString byteString2 = d.f11415f;
        ByteString byteString3 = d.f11416g;
        ByteString byteString4 = d.f11413d;
        f11429b = new d[]{new d(d.f11417h, ""), new d(byteString, "GET"), new d(byteString, "POST"), new d(byteString2, (String) Operator.Operation.DIVISION), new d(byteString2, "/index.html"), new d(byteString3, (String) HttpConstant.HTTP), new d(byteString3, "https"), new d(byteString4, (String) ProtocolBuilder.LELINK_STATE_SUCCESS), new d(byteString4, "204"), new d(byteString4, "206"), new d(byteString4, "304"), new d(byteString4, "400"), new d(byteString4, "404"), new d(byteString4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d((String) PlistBuilder.KEY_CONTENT_LOCATION, ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d((String) Constants.MessagePayloadKeys.FROM, ""), new d((String) com.taobao.accs.common.Constants.KEY_HOST, ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d((String) DynamicLink.Builder.KEY_LINK, ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
    }

    public static ByteString e(ByteString byteString) {
        int size = byteString.size();
        int i10 = 0;
        while (i10 < size) {
            byte b10 = byteString.getByte(i10);
            if (b10 < 65 || b10 > 90) {
                i10++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public static Map f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f11429b.length);
        int i10 = 0;
        while (true) {
            d[] dVarArr = f11429b;
            if (i10 >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i10].f11420a)) {
                linkedHashMap.put(dVarArr[i10].f11420a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
