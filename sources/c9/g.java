package c9;

import c9.b;
import c9.f;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class g implements j {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f11449a = Logger.getLogger(b.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f11450b = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    public static final class a implements Source {

        /* renamed from: a  reason: collision with root package name */
        public final BufferedSource f11451a;

        /* renamed from: b  reason: collision with root package name */
        public int f11452b;

        /* renamed from: c  reason: collision with root package name */
        public byte f11453c;

        /* renamed from: d  reason: collision with root package name */
        public int f11454d;

        /* renamed from: e  reason: collision with root package name */
        public int f11455e;

        /* renamed from: f  reason: collision with root package name */
        public short f11456f;

        public a(BufferedSource bufferedSource) {
            this.f11451a = bufferedSource;
        }

        public final void a() {
            int i10 = this.f11454d;
            int f10 = g.m(this.f11451a);
            this.f11455e = f10;
            this.f11452b = f10;
            byte readByte = (byte) (this.f11451a.readByte() & UnsignedBytes.MAX_VALUE);
            this.f11453c = (byte) (this.f11451a.readByte() & UnsignedBytes.MAX_VALUE);
            if (g.f11449a.isLoggable(Level.FINE)) {
                g.f11449a.fine(b.b(true, this.f11454d, this.f11452b, readByte, this.f11453c));
            }
            int readInt = this.f11451a.readInt() & Integer.MAX_VALUE;
            this.f11454d = readInt;
            if (readByte != 9) {
                throw g.k("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i10) {
                throw g.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() {
        }

        public long read(Buffer buffer, long j10) {
            while (true) {
                int i10 = this.f11455e;
                if (i10 == 0) {
                    this.f11451a.skip((long) this.f11456f);
                    this.f11456f = 0;
                    if ((this.f11453c & 4) != 0) {
                        return -1;
                    }
                    a();
                } else {
                    long read = this.f11451a.read(buffer, Math.min(j10, (long) i10));
                    if (read == -1) {
                        return -1;
                    }
                    this.f11455e -= (int) read;
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.f11451a.timeout();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f11457a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f11458b = new String[64];

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f11459c = new String[256];

        static {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr = f11459c;
                if (i11 >= strArr.length) {
                    break;
                }
                strArr[i11] = String.format("%8s", new Object[]{Integer.toBinaryString(i11)}).replace(' ', '0');
                i11++;
            }
            String[] strArr2 = f11458b;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            int i12 = iArr[0];
            strArr2[i12 | 8] = strArr2[i12] + "|PADDED";
            strArr2[4] = "END_HEADERS";
            strArr2[32] = "PRIORITY";
            strArr2[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i13 = 0; i13 < 3; i13++) {
                int i14 = iArr2[i13];
                int i15 = iArr[0];
                String[] strArr3 = f11458b;
                int i16 = i15 | i14;
                strArr3[i16] = strArr3[i15] + '|' + strArr3[i14];
                strArr3[i16 | 8] = strArr3[i15] + '|' + strArr3[i14] + "|PADDED";
            }
            while (true) {
                String[] strArr4 = f11458b;
                if (i10 < strArr4.length) {
                    if (strArr4[i10] == null) {
                        strArr4[i10] = f11459c[i10];
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }

        public static String a(byte b10, byte b11) {
            String str;
            if (b11 == 0) {
                return "";
            }
            if (!(b10 == 2 || b10 == 3)) {
                if (b10 == 4 || b10 == 6) {
                    if (b11 == 1) {
                        return "ACK";
                    }
                    return f11459c[b11];
                } else if (!(b10 == 7 || b10 == 8)) {
                    String[] strArr = f11458b;
                    if (b11 < strArr.length) {
                        str = strArr[b11];
                    } else {
                        str = f11459c[b11];
                    }
                    if (b10 == 5 && (b11 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b10 != 0 || (b11 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
                }
            }
            return f11459c[b11];
        }

        public static String b(boolean z10, int i10, int i11, byte b10, byte b11) {
            String str;
            String str2;
            String[] strArr = f11457a;
            if (b10 < strArr.length) {
                str = strArr[b10];
            } else {
                str = String.format("0x%02x", new Object[]{Byte.valueOf(b10)});
            }
            String a10 = a(b10, b11);
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            if (z10) {
                str2 = "<<";
            } else {
                str2 = ">>";
            }
            objArr[0] = str2;
            objArr[1] = Integer.valueOf(i10);
            objArr[2] = Integer.valueOf(i11);
            objArr[3] = str;
            objArr[4] = a10;
            return String.format(locale, "%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public final BufferedSource f11460a;

        /* renamed from: b  reason: collision with root package name */
        public final a f11461b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f11462c;

        /* renamed from: d  reason: collision with root package name */
        public final f.a f11463d;

        public c(BufferedSource bufferedSource, int i10, boolean z10) {
            this.f11460a = bufferedSource;
            this.f11462c = z10;
            a aVar = new a(bufferedSource);
            this.f11461b = aVar;
            this.f11463d = new f.a(i10, aVar);
        }

        public final void a(b.a aVar, int i10, byte b10, int i11) {
            boolean z10;
            short s10 = 0;
            boolean z11 = true;
            if ((b10 & 1) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((b10 & 32) == 0) {
                z11 = false;
            }
            if (!z11) {
                if ((b10 & 8) != 0) {
                    s10 = (short) (this.f11460a.readByte() & UnsignedBytes.MAX_VALUE);
                }
                aVar.data(z10, i11, this.f11460a, g.l(i10, b10, s10));
                this.f11460a.skip((long) s10);
                return;
            }
            throw g.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        public final void b(b.a aVar, int i10, byte b10, int i11) {
            if (i10 < 8) {
                throw g.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i10));
            } else if (i11 == 0) {
                int readInt = this.f11460a.readInt();
                int readInt2 = this.f11460a.readInt();
                int i12 = i10 - 8;
                a a10 = a.a(readInt2);
                if (a10 != null) {
                    ByteString byteString = ByteString.EMPTY;
                    if (i12 > 0) {
                        byteString = this.f11460a.readByteString((long) i12);
                    }
                    aVar.f(readInt, a10, byteString);
                    return;
                }
                throw g.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            } else {
                throw g.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
        }

        public final List c(int i10, short s10, byte b10, int i11) {
            a aVar = this.f11461b;
            aVar.f11455e = i10;
            aVar.f11452b = i10;
            aVar.f11456f = s10;
            aVar.f11453c = b10;
            aVar.f11454d = i11;
            this.f11463d.l();
            return this.f11463d.e();
        }

        public void close() {
            this.f11460a.close();
        }

        public final void e(b.a aVar, int i10, byte b10, int i11) {
            boolean z10;
            short s10 = 0;
            if (i11 != 0) {
                if ((b10 & 1) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((b10 & 8) != 0) {
                    s10 = (short) (this.f11460a.readByte() & UnsignedBytes.MAX_VALUE);
                }
                if ((b10 & 32) != 0) {
                    m(aVar, i11);
                    i10 -= 5;
                }
                aVar.e(false, z10, i11, -1, c(g.l(i10, b10, s10), s10, b10, i11), e.HTTP_20_HEADERS);
                return;
            }
            throw g.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }

        public final void f(b.a aVar, int i10, byte b10, int i11) {
            boolean z10 = false;
            if (i10 != 8) {
                throw g.k("TYPE_PING length != 8: %s", Integer.valueOf(i10));
            } else if (i11 == 0) {
                int readInt = this.f11460a.readInt();
                int readInt2 = this.f11460a.readInt();
                if ((b10 & 1) != 0) {
                    z10 = true;
                }
                aVar.ping(z10, readInt, readInt2);
            } else {
                throw g.k("TYPE_PING streamId != 0", new Object[0]);
            }
        }

        public final void m(b.a aVar, int i10) {
            boolean z10;
            int readInt = this.f11460a.readInt();
            if ((Integer.MIN_VALUE & readInt) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            aVar.priority(i10, readInt & Integer.MAX_VALUE, (this.f11460a.readByte() & UnsignedBytes.MAX_VALUE) + 1, z10);
        }

        public final void n(b.a aVar, int i10, byte b10, int i11) {
            if (i10 != 5) {
                throw g.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i10));
            } else if (i11 != 0) {
                m(aVar, i11);
            } else {
                throw g.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
        }

        public final void q(b.a aVar, int i10, byte b10, int i11) {
            short s10 = 0;
            if (i11 != 0) {
                if ((b10 & 8) != 0) {
                    s10 = (short) (this.f11460a.readByte() & UnsignedBytes.MAX_VALUE);
                }
                aVar.pushPromise(i11, this.f11460a.readInt() & Integer.MAX_VALUE, c(g.l(i10 - 4, b10, s10), s10, b10, i11));
                return;
            }
            throw g.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        public final void s(b.a aVar, int i10, byte b10, int i11) {
            if (i10 != 4) {
                throw g.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i10));
            } else if (i11 != 0) {
                int readInt = this.f11460a.readInt();
                a a10 = a.a(readInt);
                if (a10 != null) {
                    aVar.d(i11, a10);
                } else {
                    throw g.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                }
            } else {
                throw g.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
        }

        public boolean t(b.a aVar) {
            try {
                this.f11460a.require(9);
                int f10 = g.m(this.f11460a);
                if (f10 < 0 || f10 > 16384) {
                    throw g.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(f10));
                }
                byte readByte = (byte) (this.f11460a.readByte() & UnsignedBytes.MAX_VALUE);
                byte readByte2 = (byte) (this.f11460a.readByte() & UnsignedBytes.MAX_VALUE);
                int readInt = this.f11460a.readInt() & Integer.MAX_VALUE;
                if (g.f11449a.isLoggable(Level.FINE)) {
                    g.f11449a.fine(b.b(true, readInt, f10, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        a(aVar, f10, readByte2, readInt);
                        break;
                    case 1:
                        e(aVar, f10, readByte2, readInt);
                        break;
                    case 2:
                        n(aVar, f10, readByte2, readInt);
                        break;
                    case 3:
                        s(aVar, f10, readByte2, readInt);
                        break;
                    case 4:
                        u(aVar, f10, readByte2, readInt);
                        break;
                    case 5:
                        q(aVar, f10, readByte2, readInt);
                        break;
                    case 6:
                        f(aVar, f10, readByte2, readInt);
                        break;
                    case 7:
                        b(aVar, f10, readByte2, readInt);
                        break;
                    case 8:
                        v(aVar, f10, readByte2, readInt);
                        break;
                    default:
                        this.f11460a.skip((long) f10);
                        break;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        public final void u(b.a aVar, int i10, byte b10, int i11) {
            if (i11 != 0) {
                throw g.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b10 & 1) != 0) {
                if (i10 == 0) {
                    aVar.ackSettings();
                    return;
                }
                throw g.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            } else if (i10 % 6 == 0) {
                i iVar = new i();
                for (int i12 = 0; i12 < i10; i12 += 6) {
                    short readShort = this.f11460a.readShort();
                    int readInt = this.f11460a.readInt();
                    switch (readShort) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (!(readInt == 0 || readInt == 1)) {
                                throw g.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            readShort = 4;
                            break;
                        case 4:
                            if (readInt >= 0) {
                                readShort = 7;
                                break;
                            } else {
                                throw g.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        case 5:
                            if (readInt < 16384 || readInt > 16777215) {
                                throw g.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            }
                    }
                    iVar.e(readShort, 0, readInt);
                }
                aVar.g(false, iVar);
                if (iVar.b() >= 0) {
                    this.f11463d.g(iVar.b());
                }
            } else {
                throw g.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i10));
            }
        }

        public final void v(b.a aVar, int i10, byte b10, int i11) {
            if (i10 == 4) {
                long readInt = ((long) this.f11460a.readInt()) & TTL.MAX_VALUE;
                if (readInt != 0) {
                    aVar.windowUpdate(i11, readInt);
                    return;
                }
                throw g.k("windowSizeIncrement was 0", new Object[0]);
            }
            throw g.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i10));
        }
    }

    public static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        public final BufferedSink f11464a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11465b;

        /* renamed from: c  reason: collision with root package name */
        public final Buffer f11466c;

        /* renamed from: d  reason: collision with root package name */
        public final f.b f11467d;

        /* renamed from: e  reason: collision with root package name */
        public int f11468e = 16384;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11469f;

        public d(BufferedSink bufferedSink, boolean z10) {
            this.f11464a = bufferedSink;
            this.f11465b = z10;
            Buffer buffer = new Buffer();
            this.f11466c = buffer;
            this.f11467d = new f.b(buffer);
        }

        public synchronized void F(i iVar) {
            int i10;
            if (!this.f11469f) {
                b(0, iVar.f() * 6, (byte) 4, (byte) 0);
                for (int i11 = 0; i11 < 10; i11++) {
                    if (iVar.d(i11)) {
                        if (i11 == 4) {
                            i10 = 3;
                        } else if (i11 == 7) {
                            i10 = 4;
                        } else {
                            i10 = i11;
                        }
                        this.f11464a.writeShort(i10);
                        this.f11464a.writeInt(iVar.a(i11));
                    }
                }
                this.f11464a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public synchronized void K(boolean z10, boolean z11, int i10, int i11, List list) {
            if (!z11) {
                try {
                    if (!this.f11469f) {
                        c(z10, i10, list);
                    } else {
                        throw new IOException("closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }

        public void a(int i10, byte b10, Buffer buffer, int i11) {
            b(i10, i11, (byte) 0, b10);
            if (i11 > 0) {
                this.f11464a.write(buffer, (long) i11);
            }
        }

        public void b(int i10, int i11, byte b10, byte b11) {
            if (g.f11449a.isLoggable(Level.FINE)) {
                g.f11449a.fine(b.b(false, i10, i11, b10, b11));
            }
            int i12 = this.f11468e;
            if (i11 > i12) {
                throw g.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i12), Integer.valueOf(i11));
            } else if ((Integer.MIN_VALUE & i10) == 0) {
                g.n(this.f11464a, i11);
                this.f11464a.writeByte(b10 & UnsignedBytes.MAX_VALUE);
                this.f11464a.writeByte(b11 & UnsignedBytes.MAX_VALUE);
                this.f11464a.writeInt(i10 & Integer.MAX_VALUE);
            } else {
                throw g.j("reserved bit set: %s", Integer.valueOf(i10));
            }
        }

        public void c(boolean z10, int i10, List list) {
            byte b10;
            if (!this.f11469f) {
                this.f11467d.e(list);
                long size = this.f11466c.size();
                int min = (int) Math.min((long) this.f11468e, size);
                long j10 = (long) min;
                if (size == j10) {
                    b10 = 4;
                } else {
                    b10 = 0;
                }
                if (z10) {
                    b10 = (byte) (b10 | 1);
                }
                b(i10, min, (byte) 1, b10);
                this.f11464a.write(this.f11466c, j10);
                if (size > j10) {
                    e(i10, size - j10);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public synchronized void close() {
            this.f11469f = true;
            this.f11464a.close();
        }

        public synchronized void connectionPreface() {
            if (this.f11469f) {
                throw new IOException("closed");
            } else if (this.f11465b) {
                if (g.f11449a.isLoggable(Level.FINE)) {
                    g.f11449a.fine(String.format(">> CONNECTION %s", new Object[]{g.f11450b.hex()}));
                }
                this.f11464a.write(g.f11450b.toByteArray());
                this.f11464a.flush();
            }
        }

        public synchronized void d(int i10, a aVar) {
            if (this.f11469f) {
                throw new IOException("closed");
            } else if (aVar.f11410a != -1) {
                b(i10, 4, (byte) 3, (byte) 0);
                this.f11464a.writeInt(aVar.f11410a);
                this.f11464a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public synchronized void data(boolean z10, int i10, Buffer buffer, int i11) {
            byte b10;
            if (!this.f11469f) {
                if (z10) {
                    b10 = (byte) 1;
                } else {
                    b10 = 0;
                }
                a(i10, b10, buffer, i11);
            } else {
                throw new IOException("closed");
            }
        }

        public final void e(int i10, long j10) {
            byte b10;
            while (j10 > 0) {
                int min = (int) Math.min((long) this.f11468e, j10);
                long j11 = (long) min;
                j10 -= j11;
                if (j10 == 0) {
                    b10 = 4;
                } else {
                    b10 = 0;
                }
                b(i10, min, (byte) 9, b10);
                this.f11464a.write(this.f11466c, j11);
            }
        }

        public synchronized void flush() {
            if (!this.f11469f) {
                this.f11464a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public synchronized void g(i iVar) {
            if (!this.f11469f) {
                this.f11468e = iVar.c(this.f11468e);
                b(0, 0, (byte) 4, (byte) 1);
                this.f11464a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public int maxDataLength() {
            return this.f11468e;
        }

        public synchronized void o(int i10, a aVar, byte[] bArr) {
            if (this.f11469f) {
                throw new IOException("closed");
            } else if (aVar.f11410a != -1) {
                b(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f11464a.writeInt(i10);
                this.f11464a.writeInt(aVar.f11410a);
                if (bArr.length > 0) {
                    this.f11464a.write(bArr);
                }
                this.f11464a.flush();
            } else {
                throw g.j("errorCode.httpCode == -1", new Object[0]);
            }
        }

        public synchronized void ping(boolean z10, int i10, int i11) {
            byte b10;
            if (!this.f11469f) {
                if (z10) {
                    b10 = 1;
                } else {
                    b10 = 0;
                }
                b(0, 8, (byte) 6, b10);
                this.f11464a.writeInt(i10);
                this.f11464a.writeInt(i11);
                this.f11464a.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public synchronized void windowUpdate(int i10, long j10) {
            if (this.f11469f) {
                throw new IOException("closed");
            } else if (j10 == 0 || j10 > TTL.MAX_VALUE) {
                throw g.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j10));
            } else {
                b(i10, 4, (byte) 8, (byte) 0);
                this.f11464a.writeInt((int) j10);
                this.f11464a.flush();
            }
        }
    }

    public static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static IOException k(String str, Object... objArr) {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    public static int l(int i10, byte b10, short s10) {
        if ((b10 & 8) != 0) {
            i10--;
        }
        if (s10 <= i10) {
            return (short) (i10 - s10);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s10), Integer.valueOf(i10));
    }

    public static int m(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & UnsignedBytes.MAX_VALUE) | ((bufferedSource.readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((bufferedSource.readByte() & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static void n(BufferedSink bufferedSink, int i10) {
        bufferedSink.writeByte((i10 >>> 16) & 255);
        bufferedSink.writeByte((i10 >>> 8) & 255);
        bufferedSink.writeByte(i10 & 255);
    }

    public b a(BufferedSource bufferedSource, boolean z10) {
        return new c(bufferedSource, 4096, z10);
    }

    public c b(BufferedSink bufferedSink, boolean z10) {
        return new d(bufferedSink, z10);
    }
}
