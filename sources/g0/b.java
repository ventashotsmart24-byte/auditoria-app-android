package g0;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import com.google.android.gms.cast.MediaError;
import com.google.common.base.Ascii;
import com.raizlabs.android.dbflow.sql.language.Operator;
import g0.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class b {
    public static final byte[] A = {-1, -40, -1};
    public static final byte[] B = {102, 116, 121, 112};
    public static final byte[] C = {109, 105, 102, 49};
    public static final byte[] D = {104, 101, 105, 99};
    public static final byte[] E = {79, 76, 89, 77, 80, 0};
    public static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] G = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    public static final byte[] H = {101, 88, 73, 102};
    public static final byte[] I = {73, 72, 68, 82};
    public static final byte[] J = {73, 69, 78, 68};
    public static final byte[] K = {82, 73, 70, 70};
    public static final byte[] L = {87, 69, 66, 80};
    public static final byte[] M = {69, 88, 73, 70};
    public static final byte[] N = {-99, 1, 42};
    public static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    public static SimpleDateFormat T;
    public static SimpleDateFormat U;
    public static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final d[] Y;
    public static final d[] Z;

    /* renamed from: a0  reason: collision with root package name */
    public static final d[] f6689a0;

    /* renamed from: b0  reason: collision with root package name */
    public static final d[] f6690b0;

    /* renamed from: c0  reason: collision with root package name */
    public static final d[] f6691c0;

    /* renamed from: d0  reason: collision with root package name */
    public static final d f6692d0 = new d("StripOffsets", 273, 3);

    /* renamed from: e0  reason: collision with root package name */
    public static final d[] f6693e0;

    /* renamed from: f0  reason: collision with root package name */
    public static final d[] f6694f0;

    /* renamed from: g0  reason: collision with root package name */
    public static final d[] f6695g0;

    /* renamed from: h0  reason: collision with root package name */
    public static final d[] f6696h0;

    /* renamed from: i0  reason: collision with root package name */
    public static final d[][] f6697i0;

    /* renamed from: j0  reason: collision with root package name */
    public static final d[] f6698j0 = {new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};

    /* renamed from: k0  reason: collision with root package name */
    public static final HashMap[] f6699k0;

    /* renamed from: l0  reason: collision with root package name */
    public static final HashMap[] f6700l0;

    /* renamed from: m0  reason: collision with root package name */
    public static final HashSet f6701m0 = new HashSet(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));

    /* renamed from: n0  reason: collision with root package name */
    public static final HashMap f6702n0 = new HashMap();

    /* renamed from: o0  reason: collision with root package name */
    public static final Charset f6703o0;

    /* renamed from: p0  reason: collision with root package name */
    public static final byte[] f6704p0;

    /* renamed from: q0  reason: collision with root package name */
    public static final byte[] f6705q0;

    /* renamed from: r0  reason: collision with root package name */
    public static final Pattern f6706r0 = Pattern.compile(".*[1-9].*");

    /* renamed from: s0  reason: collision with root package name */
    public static final Pattern f6707s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: t0  reason: collision with root package name */
    public static final Pattern f6708t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: u  reason: collision with root package name */
    public static final boolean f6709u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: u0  reason: collision with root package name */
    public static final Pattern f6710u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: v  reason: collision with root package name */
    public static final List f6711v = Arrays.asList(new Integer[]{1, 6, 3, 8});

    /* renamed from: w  reason: collision with root package name */
    public static final List f6712w = Arrays.asList(new Integer[]{2, 7, 4, 5});

    /* renamed from: x  reason: collision with root package name */
    public static final int[] f6713x = {8, 8, 8};

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f6714y = {4};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f6715z = {8};

    /* renamed from: a  reason: collision with root package name */
    public String f6716a;

    /* renamed from: b  reason: collision with root package name */
    public FileDescriptor f6717b;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager.AssetInputStream f6718c;

    /* renamed from: d  reason: collision with root package name */
    public int f6719d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6720e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap[] f6721f;

    /* renamed from: g  reason: collision with root package name */
    public Set f6722g;

    /* renamed from: h  reason: collision with root package name */
    public ByteOrder f6723h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6724i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6725j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6726k;

    /* renamed from: l  reason: collision with root package name */
    public int f6727l;

    /* renamed from: m  reason: collision with root package name */
    public int f6728m;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f6729n;

    /* renamed from: o  reason: collision with root package name */
    public int f6730o;

    /* renamed from: p  reason: collision with root package name */
    public int f6731p;

    /* renamed from: q  reason: collision with root package name */
    public int f6732q;

    /* renamed from: r  reason: collision with root package name */
    public int f6733r;

    /* renamed from: s  reason: collision with root package name */
    public int f6734s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6735t;

    public class a extends MediaDataSource {

        /* renamed from: a  reason: collision with root package name */
        public long f6736a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f6737b;

        public a(f fVar) {
            this.f6737b = fVar;
        }

        public void close() {
        }

        public long getSize() {
            return -1;
        }

        public int readAt(long j10, byte[] bArr, int i10, int i11) {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f6736a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + ((long) this.f6737b.available())) {
                        return -1;
                    }
                    this.f6737b.f(j10);
                    this.f6736a = j10;
                }
                if (i11 > this.f6737b.available()) {
                    i11 = this.f6737b.available();
                }
                int read = this.f6737b.read(bArr, i10, i11);
                if (read >= 0) {
                    this.f6736a += (long) read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f6736a = -1;
            return -1;
        }
    }

    /* renamed from: g0.b$b  reason: collision with other inner class name */
    public static class C0084b extends InputStream implements DataInput {

        /* renamed from: e  reason: collision with root package name */
        public static final ByteOrder f6739e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f  reason: collision with root package name */
        public static final ByteOrder f6740f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        public final DataInputStream f6741a;

        /* renamed from: b  reason: collision with root package name */
        public ByteOrder f6742b;

        /* renamed from: c  reason: collision with root package name */
        public int f6743c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f6744d;

        public C0084b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f6743c;
        }

        public int available() {
            return this.f6741a.available();
        }

        public long b() {
            return ((long) readInt()) & 4294967295L;
        }

        public void c(ByteOrder byteOrder) {
            this.f6742b = byteOrder;
        }

        public void e(int i10) {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int skip = (int) this.f6741a.skip((long) i12);
                if (skip <= 0) {
                    if (this.f6744d == null) {
                        this.f6744d = new byte[8192];
                    }
                    skip = this.f6741a.read(this.f6744d, 0, Math.min(8192, i12));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += skip;
            }
            this.f6743c += i11;
        }

        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int read() {
            this.f6743c++;
            return this.f6741a.read();
        }

        public boolean readBoolean() {
            this.f6743c++;
            return this.f6741a.readBoolean();
        }

        public byte readByte() {
            this.f6743c++;
            int read = this.f6741a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() {
            this.f6743c += 2;
            return this.f6741a.readChar();
        }

        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i10, int i11) {
            this.f6743c += i11;
            this.f6741a.readFully(bArr, i10, i11);
        }

        public int readInt() {
            this.f6743c += 4;
            int read = this.f6741a.read();
            int read2 = this.f6741a.read();
            int read3 = this.f6741a.read();
            int read4 = this.f6741a.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f6742b;
                if (byteOrder == f6739e) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f6740f) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f6742b);
            }
            throw new EOFException();
        }

        public String readLine() {
            return null;
        }

        public long readLong() {
            this.f6743c += 8;
            int read = this.f6741a.read();
            int read2 = this.f6741a.read();
            int read3 = this.f6741a.read();
            int read4 = this.f6741a.read();
            int read5 = this.f6741a.read();
            int read6 = this.f6741a.read();
            int read7 = this.f6741a.read();
            int read8 = this.f6741a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f6742b;
                if (byteOrder == f6739e) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i10 = read2;
                if (byteOrder == f6740f) {
                    return (((long) read) << 56) + (((long) i10) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.f6742b);
            }
            throw new EOFException();
        }

        public short readShort() {
            this.f6743c += 2;
            int read = this.f6741a.read();
            int read2 = this.f6741a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f6742b;
                if (byteOrder == f6739e) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f6740f) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f6742b);
            }
            throw new EOFException();
        }

        public String readUTF() {
            this.f6743c += 2;
            return this.f6741a.readUTF();
        }

        public int readUnsignedByte() {
            this.f6743c++;
            return this.f6741a.readUnsignedByte();
        }

        public int readUnsignedShort() {
            this.f6743c += 2;
            int read = this.f6741a.read();
            int read2 = this.f6741a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f6742b;
                if (byteOrder == f6739e) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f6740f) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f6742b);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public int skipBytes(int i10) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public C0084b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public C0084b(InputStream inputStream, ByteOrder byteOrder) {
            this.f6742b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f6741a = dataInputStream;
            dataInputStream.mark(0);
            this.f6743c = 0;
            this.f6742b = byteOrder;
        }

        public int read(byte[] bArr, int i10, int i11) {
            int read = this.f6741a.read(bArr, i10, i11);
            this.f6743c += read;
            return read;
        }

        public void readFully(byte[] bArr) {
            this.f6743c += bArr.length;
            this.f6741a.readFully(bArr);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f6745a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6746b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6747c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f6748d;

        public c(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1, bArr);
        }

        public static c a(String str) {
            byte[] bytes = (str + 0).getBytes(b.f6703o0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j10, ByteOrder byteOrder) {
            return c(new long[]{j10}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(b.W[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j10 : jArr) {
                wrap.putInt((int) j10);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(b.W[5] * eVarArr.length)]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.f6753a);
                wrap.putInt((int) eVar.f6754b);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c f(int i10, ByteOrder byteOrder) {
            return g(new int[]{i10}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(b.W[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putShort((short) i10);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (k10 instanceof String) {
                return Double.parseDouble((String) k10);
            } else {
                if (k10 instanceof long[]) {
                    long[] jArr = (long[]) k10;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof int[]) {
                    int[] iArr = (int[]) k10;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof double[]) {
                    double[] dArr = (double[]) k10;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof e[]) {
                    e[] eVarArr = (e[]) k10;
                    if (eVarArr.length == 1) {
                        return eVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int i(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (k10 instanceof String) {
                return Integer.parseInt((String) k10);
            } else {
                if (k10 instanceof long[]) {
                    long[] jArr = (long[]) k10;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof int[]) {
                    int[] iArr = (int[]) k10;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String j(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                return null;
            }
            if (k10 instanceof String) {
                return (String) k10;
            }
            StringBuilder sb = new StringBuilder();
            int i10 = 0;
            if (k10 instanceof long[]) {
                long[] jArr = (long[]) k10;
                while (i10 < jArr.length) {
                    sb.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (k10 instanceof int[]) {
                int[] iArr = (int[]) k10;
                while (i10 < iArr.length) {
                    sb.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (k10 instanceof double[]) {
                double[] dArr = (double[]) k10;
                while (i10 < dArr.length) {
                    sb.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(k10 instanceof e[])) {
                return null;
            } else {
                e[] eVarArr = (e[]) k10;
                while (i10 < eVarArr.length) {
                    sb.append(eVarArr[i10].f6753a);
                    sb.append('/');
                    sb.append(eVarArr[i10].f6754b);
                    i10++;
                    if (i10 != eVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:151:0x0187 A[SYNTHETIC, Splitter:B:151:0x0187] */
        /* JADX WARNING: Removed duplicated region for block: B:160:0x0193 A[SYNTHETIC, Splitter:B:160:0x0193] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object k(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                g0.b$b r3 = new g0.b$b     // Catch:{ IOException -> 0x0190, all -> 0x0184 }
                byte[] r4 = r10.f6748d     // Catch:{ IOException -> 0x0190, all -> 0x0184 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0190, all -> 0x0184 }
                r3.c(r11)     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r11 = r10.f6745a     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r4 = 0
                r5 = 1
                switch(r11) {
                    case 1: goto L_0x0148;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x0148;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x0016:
                goto L_0x0178
            L_0x0018:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x001c:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x0029
                double r5 = r3.readDouble()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x0036:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x0044
                float r5 = r3.readFloat()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                double r5 = (double) r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                g0.b$e[] r11 = new g0.b.e[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x0051:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x0069
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                long r5 = (long) r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r7 = r3.readInt()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                long r7 = (long) r7     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                g0.b$e r9 = new g0.b$e     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x0076:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x0083
                int r5 = r3.readInt()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x0090:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x009d
                short r5 = r3.readShort()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                g0.b$e[] r11 = new g0.b.e[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x00aa:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x00c0
                long r5 = r3.b()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                long r7 = r3.b()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                g0.b$e r9 = new g0.b$e     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r9.<init>(r5, r7)     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r9     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x00cd:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x00da
                long r5 = r3.b()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x00e7:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x00f4
                int r5 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11[r4] = r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r4 = r4 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                byte[] r6 = g0.b.X     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r11 < r6) goto L_0x011a
                r11 = 0
            L_0x0105:
                byte[] r6 = g0.b.X     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r11 >= r7) goto L_0x0117
                byte[] r7 = r10.f6748d     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                byte r8 = r6[r11]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r7 == r8) goto L_0x0114
                r5 = 0
                goto L_0x0117
            L_0x0114:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0117:
                if (r5 == 0) goto L_0x011a
                int r4 = r6.length     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x011a:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11.<init>()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x011f:
                int r5 = r10.f6746b     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r4 >= r5) goto L_0x013b
                byte[] r5 = r10.f6748d     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                byte r5 = r5[r4]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r5 != 0) goto L_0x012a
                goto L_0x013b
            L_0x012a:
                r6 = 32
                if (r5 < r6) goto L_0x0133
                char r5 = (char) r5     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11.append(r5)     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                goto L_0x0138
            L_0x0133:
                r5 = 63
                r11.append(r5)     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
            L_0x0138:
                int r4 = r4 + 1
                goto L_0x011f
            L_0x013b:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0143 }
                goto L_0x0147
            L_0x0143:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0147:
                return r11
            L_0x0148:
                byte[] r11 = r10.f6748d     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r6 = r11.length     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r6 != r5) goto L_0x0168
                byte r6 = r11[r4]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                if (r6 < 0) goto L_0x0168
                if (r6 > r5) goto L_0x0168
                java.lang.String r11 = new java.lang.String     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                char[] r5 = new char[r5]     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r5[r4] = r6     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r11.<init>(r5)     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0163 }
                goto L_0x0167
            L_0x0163:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0167:
                return r11
            L_0x0168:
                java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                java.nio.charset.Charset r5 = g0.b.f6703o0     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0191, all -> 0x0181 }
                r3.close()     // Catch:{ IOException -> 0x0173 }
                goto L_0x0177
            L_0x0173:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0177:
                return r4
            L_0x0178:
                r3.close()     // Catch:{ IOException -> 0x017c }
                goto L_0x0180
            L_0x017c:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0180:
                return r2
            L_0x0181:
                r11 = move-exception
                r2 = r3
                goto L_0x0185
            L_0x0184:
                r11 = move-exception
            L_0x0185:
                if (r2 == 0) goto L_0x018f
                r2.close()     // Catch:{ IOException -> 0x018b }
                goto L_0x018f
            L_0x018b:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x018f:
                throw r11
            L_0x0190:
                r3 = r2
            L_0x0191:
                if (r3 == 0) goto L_0x019b
                r3.close()     // Catch:{ IOException -> 0x0197 }
                goto L_0x019b
            L_0x0197:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x019b:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: g0.b.c.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + b.V[this.f6745a] + ", data length:" + this.f6748d.length + ")";
        }

        public c(int i10, int i11, long j10, byte[] bArr) {
            this.f6745a = i10;
            this.f6746b = i11;
            this.f6747c = j10;
            this.f6748d = bArr;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final long f6753a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6754b;

        public e(long j10, long j11) {
            if (j11 == 0) {
                this.f6753a = 0;
                this.f6754b = 1;
                return;
            }
            this.f6753a = j10;
            this.f6754b = j11;
        }

        public double a() {
            double d10 = (double) this.f6753a;
            double d11 = (double) this.f6754b;
            Double.isNaN(d10);
            Double.isNaN(d11);
            return d10 / d11;
        }

        public String toString() {
            return this.f6753a + Operator.Operation.DIVISION + this.f6754b;
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", com.umeng.ccg.c.f14559s, 2), new d("DateTime", 306, 2), new d("Artist", MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f6689a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f6690b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", 257, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", com.umeng.ccg.c.f14559s, 2), new d("DateTime", 306, 2), new d("Artist", MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f6691c0 = dVarArr5;
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f6693e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", 257, 4), new d("PreviewImageLength", 258, 4)};
        f6694f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f6695g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f6696h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f6697i0 = dVarArr10;
        f6699k0 = new HashMap[dVarArr10.length];
        f6700l0 = new HashMap[dVarArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        f6703o0 = forName;
        f6704p0 = "Exif\u0000\u0000".getBytes(forName);
        f6705q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            d[][] dVarArr11 = f6697i0;
            if (i10 < dVarArr11.length) {
                f6699k0[i10] = new HashMap();
                f6700l0[i10] = new HashMap();
                for (d dVar : dVarArr11[i10]) {
                    f6699k0[i10].put(Integer.valueOf(dVar.f6749a), dVar);
                    f6700l0[i10].put(dVar.f6750b, dVar);
                }
                i10++;
            } else {
                HashMap hashMap = f6702n0;
                d[] dVarArr12 = f6698j0;
                hashMap.put(Integer.valueOf(dVarArr12[0].f6749a), 5);
                hashMap.put(Integer.valueOf(dVarArr12[1].f6749a), 1);
                hashMap.put(Integer.valueOf(dVarArr12[2].f6749a), 2);
                hashMap.put(Integer.valueOf(dVarArr12[3].f6749a), 3);
                hashMap.put(Integer.valueOf(dVarArr12[4].f6749a), 7);
                hashMap.put(Integer.valueOf(dVarArr12[5].f6749a), 8);
                return;
            }
        }
    }

    public b(InputStream inputStream) {
        this(inputStream, 0);
    }

    public static boolean K(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    public static boolean q(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f6704p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f6704p0;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr2[i10] != bArr3[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static boolean s(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static boolean x(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                c.a.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final boolean A(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i10 >= bArr2.length) {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i11 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i11 + 4] != bArr3[i11]) {
                        return false;
                    }
                    i11++;
                }
            } else if (bArr[i10] != bArr2[i10]) {
                return false;
            } else {
                i10++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r5 = f6709u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0093, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0096, code lost:
        if (r5 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009c, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        if (f6709u != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a3, code lost:
        D();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a6, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0091 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B(java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00a7
            r0 = 0
            r1 = 0
        L_0x0004:
            g0.b$d[][] r2 = f6697i0     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r2 = r2.length     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r1 >= r2) goto L_0x0015
            java.util.HashMap[] r2 = r4.f6721f     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r3.<init>()     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r2[r1] = r3     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0015:
            boolean r1 = r4.f6720e     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r1 != 0) goto L_0x0027
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r5 = r4.g(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r4.f6719d = r5     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r5 = r1
        L_0x0027:
            int r1 = r4.f6719d     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            boolean r1 = K(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r1 == 0) goto L_0x0062
            g0.b$f r0 = new g0.b$f     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r0.<init>((java.io.InputStream) r5)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            boolean r5 = r4.f6720e     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            if (r5 == 0) goto L_0x003c
            r4.m(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x003c:
            int r5 = r4.f6719d     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r1 = 12
            if (r5 != r1) goto L_0x0046
            r4.e(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x0046:
            r1 = 7
            if (r5 != r1) goto L_0x004d
            r4.h(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x004d:
            r1 = 10
            if (r5 != r1) goto L_0x0055
            r4.l(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0058
        L_0x0055:
            r4.k(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
        L_0x0058:
            int r5 = r4.f6731p     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            long r1 = (long) r5     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r0.f(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r4.J(r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0062:
            g0.b$b r1 = new g0.b$b     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r1.<init>((java.io.InputStream) r5)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            int r5 = r4.f6719d     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            r2 = 4
            if (r5 != r2) goto L_0x0070
            r4.f(r1, r0, r0)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0070:
            r0 = 13
            if (r5 != r0) goto L_0x0078
            r4.i(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0078:
            r0 = 9
            if (r5 != r0) goto L_0x0080
            r4.j(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
            goto L_0x0087
        L_0x0080:
            r0 = 14
            if (r5 != r0) goto L_0x0087
            r4.n(r1)     // Catch:{ IOException | UnsupportedOperationException -> 0x0091 }
        L_0x0087:
            r4.a()
            boolean r5 = f6709u
            if (r5 == 0) goto L_0x009b
            goto L_0x0098
        L_0x008f:
            r5 = move-exception
            goto L_0x009c
        L_0x0091:
            boolean r5 = f6709u     // Catch:{ all -> 0x008f }
            r4.a()
            if (r5 == 0) goto L_0x009b
        L_0x0098:
            r4.D()
        L_0x009b:
            return
        L_0x009c:
            r4.a()
            boolean r0 = f6709u
            if (r0 == 0) goto L_0x00a6
            r4.D()
        L_0x00a6:
            throw r5
        L_0x00a7:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            goto L_0x00b0
        L_0x00af:
            throw r5
        L_0x00b0:
            goto L_0x00af
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.B(java.io.InputStream):void");
    }

    public final void C(C0084b bVar) {
        ByteOrder E2 = E(bVar);
        this.f6723h = E2;
        bVar.c(E2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i10 = this.f6719d;
        if (i10 == 7 || i10 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt >= 8) {
                int i11 = readInt - 8;
                if (i11 > 0) {
                    bVar.e(i11);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    public final void D() {
        for (int i10 = 0; i10 < this.f6721f.length; i10++) {
            StringBuilder sb = new StringBuilder();
            sb.append("The size of tag group[");
            sb.append(i10);
            sb.append("]: ");
            sb.append(this.f6721f[i10].size());
            for (Map.Entry entry : this.f6721f[i10].entrySet()) {
                c cVar = (c) entry.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("tagName: ");
                sb2.append((String) entry.getKey());
                sb2.append(", tagType: ");
                sb2.append(cVar.toString());
                sb2.append(", tagValue: '");
                sb2.append(cVar.j(this.f6723h));
                sb2.append("'");
            }
        }
    }

    public final ByteOrder E(C0084b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    public final void F(byte[] bArr, int i10) {
        f fVar = new f(bArr);
        C(fVar);
        G(fVar, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0243  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(g0.b.f r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.util.Set r3 = r0.f6722g
            int r4 = r1.f6743c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r24.readShort()
            boolean r4 = f6709u
            if (r4 == 0) goto L_0x0026
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "numberOfDirectoryEntry: "
            r4.append(r5)
            r4.append(r3)
        L_0x0026:
            if (r3 > 0) goto L_0x0029
            return
        L_0x0029:
            r4 = 0
            r5 = 0
        L_0x002b:
            r6 = 5
            r9 = 1
            if (r5 >= r3) goto L_0x02d8
            int r11 = r24.readUnsignedShort()
            int r12 = r24.readUnsignedShort()
            int r15 = r24.readInt()
            int r13 = r24.a()
            long r13 = (long) r13
            r16 = 4
            long r13 = r13 + r16
            java.util.HashMap[] r18 = f6699k0
            r7 = r18[r2]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            java.lang.Object r7 = r7.get(r8)
            g0.b$d r7 = (g0.b.d) r7
            boolean r8 = f6709u
            r10 = 3
            if (r8 == 0) goto L_0x0082
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r20 = java.lang.Integer.valueOf(r25)
            r6[r4] = r20
            java.lang.Integer r20 = java.lang.Integer.valueOf(r11)
            r6[r9] = r20
            if (r7 == 0) goto L_0x006a
            java.lang.String r9 = r7.f6750b
            goto L_0x006b
        L_0x006a:
            r9 = 0
        L_0x006b:
            r19 = 2
            r6[r19] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r6[r10] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r15)
            r18 = 4
            r6[r18] = r9
            java.lang.String r9 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String.format(r9, r6)
        L_0x0082:
            r6 = 7
            if (r7 != 0) goto L_0x0099
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r4 = "Skip the tag entry since tag number is not defined: "
            r9.append(r4)
            r9.append(r11)
        L_0x0094:
            r21 = r7
            r9 = r11
            goto L_0x0105
        L_0x0099:
            if (r12 <= 0) goto L_0x00f3
            int[] r4 = W
            int r9 = r4.length
            if (r12 < r9) goto L_0x00a1
            goto L_0x00f3
        L_0x00a1:
            boolean r9 = r7.a(r12)
            if (r9 != 0) goto L_0x00c5
            if (r8 == 0) goto L_0x0094
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "Skip the tag entry since data format ("
            r4.append(r9)
            java.lang.String[] r9 = V
            r9 = r9[r12]
            r4.append(r9)
            java.lang.String r9 = ") is unexpected for tag: "
            r4.append(r9)
            java.lang.String r9 = r7.f6750b
            r4.append(r9)
            goto L_0x0094
        L_0x00c5:
            if (r12 != r6) goto L_0x00c9
            int r12 = r7.f6751c
        L_0x00c9:
            r9 = r11
            long r10 = (long) r15
            r4 = r4[r12]
            r21 = r7
            long r6 = (long) r4
            long r6 = r6 * r10
            r10 = 0
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x00e2
            r10 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            r4 = 1
            goto L_0x0108
        L_0x00e2:
            if (r8 == 0) goto L_0x00f1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = "Skip the tag entry since the number of components is invalid: "
            r4.append(r10)
            r4.append(r15)
        L_0x00f1:
            r4 = 0
            goto L_0x0108
        L_0x00f3:
            r21 = r7
            r9 = r11
            if (r8 == 0) goto L_0x0105
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Skip the tag entry since data format is invalid: "
            r4.append(r6)
            r4.append(r12)
        L_0x0105:
            r4 = 0
            r6 = 0
        L_0x0108:
            if (r4 != 0) goto L_0x0113
            r1.f(r13)
            r22 = r3
            r21 = r5
            goto L_0x02ce
        L_0x0113:
            java.lang.String r4 = "Compression"
            int r10 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x019c
            int r10 = r24.readInt()
            if (r8 == 0) goto L_0x012f
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r22 = r3
            java.lang.String r3 = "seek to data offset: "
            r11.append(r3)
            r11.append(r10)
            goto L_0x0131
        L_0x012f:
            r22 = r3
        L_0x0131:
            int r3 = r0.f6719d
            r11 = 7
            if (r3 != r11) goto L_0x0191
            r3 = r21
            java.lang.String r11 = r3.f6750b
            r21 = r5
            java.lang.String r5 = "MakerNote"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x0147
            r0.f6732q = r10
            goto L_0x018e
        L_0x0147:
            r5 = 6
            if (r2 != r5) goto L_0x018e
            java.lang.String r11 = "ThumbnailImage"
            java.lang.String r5 = r3.f6750b
            boolean r5 = r11.equals(r5)
            if (r5 == 0) goto L_0x018e
            r0.f6733r = r10
            r0.f6734s = r15
            java.nio.ByteOrder r5 = r0.f6723h
            r11 = 6
            g0.b$c r5 = g0.b.c.f(r11, r5)
            int r11 = r0.f6733r
            r16 = r13
            long r13 = (long) r11
            java.nio.ByteOrder r11 = r0.f6723h
            g0.b$c r11 = g0.b.c.b(r13, r11)
            int r13 = r0.f6734s
            long r13 = (long) r13
            java.nio.ByteOrder r2 = r0.f6723h
            g0.b$c r2 = g0.b.c.b(r13, r2)
            java.util.HashMap[] r13 = r0.f6721f
            r14 = 4
            r13 = r13[r14]
            r13.put(r4, r5)
            java.util.HashMap[] r5 = r0.f6721f
            r5 = r5[r14]
            java.lang.String r13 = "JPEGInterchangeFormat"
            r5.put(r13, r11)
            java.util.HashMap[] r5 = r0.f6721f
            r5 = r5[r14]
            java.lang.String r11 = "JPEGInterchangeFormatLength"
            r5.put(r11, r2)
            goto L_0x0197
        L_0x018e:
            r16 = r13
            goto L_0x0197
        L_0x0191:
            r16 = r13
            r3 = r21
            r21 = r5
        L_0x0197:
            long r10 = (long) r10
            r1.f(r10)
            goto L_0x01a4
        L_0x019c:
            r22 = r3
            r16 = r13
            r3 = r21
            r21 = r5
        L_0x01a4:
            java.util.HashMap r2 = f6702n0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            java.lang.Object r2 = r2.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r8 == 0) goto L_0x01c7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "nextIfdType: "
            r5.append(r9)
            r5.append(r2)
            java.lang.String r9 = " byteCount: "
            r5.append(r9)
            r5.append(r6)
        L_0x01c7:
            r5 = 8
            if (r2 == 0) goto L_0x0259
            r4 = 3
            if (r12 == r4) goto L_0x01ed
            r4 = 4
            if (r12 == r4) goto L_0x01e8
            if (r12 == r5) goto L_0x01e3
            r4 = 9
            if (r12 == r4) goto L_0x01de
            r4 = 13
            if (r12 == r4) goto L_0x01de
            r4 = -1
            goto L_0x01f2
        L_0x01de:
            int r4 = r24.readInt()
            goto L_0x01f1
        L_0x01e3:
            short r4 = r24.readShort()
            goto L_0x01f1
        L_0x01e8:
            long r4 = r24.b()
            goto L_0x01f2
        L_0x01ed:
            int r4 = r24.readUnsignedShort()
        L_0x01f1:
            long r4 = (long) r4
        L_0x01f2:
            if (r8 == 0) goto L_0x0208
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r9 = 0
            r6[r9] = r7
            java.lang.String r3 = r3.f6750b
            r7 = 1
            r6[r7] = r3
            java.lang.String r3 = "Offset: %d, tagName: %s"
            java.lang.String.format(r3, r6)
        L_0x0208:
            r6 = 0
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0243
            java.util.Set r3 = r0.f6722g
            int r6 = (int) r4
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r3 = r3.contains(r6)
            if (r3 != 0) goto L_0x0226
            r1.f(r4)
            int r2 = r2.intValue()
            r0.G(r1, r2)
            goto L_0x0252
        L_0x0226:
            if (r8 == 0) goto L_0x0252
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r6)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ")"
            r3.append(r2)
            goto L_0x0252
        L_0x0243:
            if (r8 == 0) goto L_0x0252
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r4)
        L_0x0252:
            r13 = r16
            r1.f(r13)
            goto L_0x02ce
        L_0x0259:
            r13 = r16
            int r2 = r24.a()
            int r8 = r0.f6731p
            int r2 = r2 + r8
            int r7 = (int) r6
            byte[] r6 = new byte[r7]
            r1.readFully(r6)
            g0.b$c r7 = new g0.b$c
            long r8 = (long) r2
            r10 = r13
            r13 = r7
            r14 = r12
            r16 = r8
            r18 = r6
            r13.<init>(r14, r15, r16, r18)
            java.util.HashMap[] r2 = r0.f6721f
            r2 = r2[r25]
            java.lang.String r6 = r3.f6750b
            r2.put(r6, r7)
            java.lang.String r2 = "DNGVersion"
            java.lang.String r6 = r3.f6750b
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x028b
            r2 = 3
            r0.f6719d = r2
        L_0x028b:
            java.lang.String r2 = "Make"
            java.lang.String r6 = r3.f6750b
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x029f
            java.lang.String r2 = "Model"
            java.lang.String r6 = r3.f6750b
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x02ad
        L_0x029f:
            java.nio.ByteOrder r2 = r0.f6723h
            java.lang.String r2 = r7.j(r2)
            java.lang.String r6 = "PENTAX"
            boolean r2 = r2.contains(r6)
            if (r2 != 0) goto L_0x02c0
        L_0x02ad:
            java.lang.String r2 = r3.f6750b
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x02c2
            java.nio.ByteOrder r2 = r0.f6723h
            int r2 = r7.i(r2)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r3) goto L_0x02c2
        L_0x02c0:
            r0.f6719d = r5
        L_0x02c2:
            int r2 = r24.a()
            long r2 = (long) r2
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x02ce
            r1.f(r10)
        L_0x02ce:
            int r5 = r21 + 1
            short r5 = (short) r5
            r2 = r25
            r3 = r22
            r4 = 0
            goto L_0x002b
        L_0x02d8:
            int r2 = r24.readInt()
            boolean r3 = f6709u
            if (r3 == 0) goto L_0x02ef
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r7 = 0
            r4[r7] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String.format(r5, r4)
        L_0x02ef:
            long r4 = (long) r2
            r7 = 0
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0332
            java.util.Set r7 = r0.f6722g
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            boolean r7 = r7.contains(r8)
            if (r7 != 0) goto L_0x0322
            r1.f(r4)
            java.util.HashMap[] r2 = r0.f6721f
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0314
            r0.G(r1, r3)
            goto L_0x0341
        L_0x0314:
            java.util.HashMap[] r2 = r0.f6721f
            r2 = r2[r6]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0341
            r0.G(r1, r6)
            goto L_0x0341
        L_0x0322:
            if (r3 == 0) goto L_0x0341
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            goto L_0x0341
        L_0x0332:
            if (r3 == 0) goto L_0x0341
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
        L_0x0341:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.G(g0.b$f, int):void");
    }

    public final void H(int i10, String str, String str2) {
        if (!this.f6721f[i10].isEmpty() && this.f6721f[i10].get(str) != null) {
            HashMap hashMap = this.f6721f[i10];
            hashMap.put(str2, hashMap.get(str));
            this.f6721f[i10].remove(str);
        }
    }

    public final void I(f fVar, int i10) {
        c cVar = (c) this.f6721f[i10].get("ImageLength");
        c cVar2 = (c) this.f6721f[i10].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = (c) this.f6721f[i10].get("JPEGInterchangeFormat");
            c cVar4 = (c) this.f6721f[i10].get("JPEGInterchangeFormatLength");
            if (cVar3 != null && cVar4 != null) {
                int i11 = cVar3.i(this.f6723h);
                int i12 = cVar3.i(this.f6723h);
                fVar.f((long) i11);
                byte[] bArr = new byte[i12];
                fVar.read(bArr);
                f(new C0084b(bArr), i11, i10);
            }
        }
    }

    public final void J(C0084b bVar) {
        HashMap hashMap = this.f6721f[4];
        c cVar = (c) hashMap.get("Compression");
        if (cVar != null) {
            int i10 = cVar.i(this.f6723h);
            this.f6730o = i10;
            if (i10 != 1) {
                if (i10 == 6) {
                    o(bVar, hashMap);
                    return;
                } else if (i10 != 7) {
                    return;
                }
            }
            if (y(hashMap)) {
                p(bVar, hashMap);
                return;
            }
            return;
        }
        this.f6730o = 6;
        o(bVar, hashMap);
    }

    public final void L(int i10, int i11) {
        if (!this.f6721f[i10].isEmpty() && !this.f6721f[i11].isEmpty()) {
            c cVar = (c) this.f6721f[i10].get("ImageLength");
            c cVar2 = (c) this.f6721f[i10].get("ImageWidth");
            c cVar3 = (c) this.f6721f[i11].get("ImageLength");
            c cVar4 = (c) this.f6721f[i11].get("ImageWidth");
            if (cVar != null && cVar2 != null && cVar3 != null && cVar4 != null) {
                int i12 = cVar.i(this.f6723h);
                int i13 = cVar2.i(this.f6723h);
                int i14 = cVar3.i(this.f6723h);
                int i15 = cVar4.i(this.f6723h);
                if (i12 < i14 && i13 < i15) {
                    HashMap[] hashMapArr = this.f6721f;
                    HashMap hashMap = hashMapArr[i10];
                    hashMapArr[i10] = hashMapArr[i11];
                    hashMapArr[i11] = hashMap;
                }
            }
        }
    }

    public final void M(f fVar, int i10) {
        c cVar;
        c cVar2;
        c cVar3 = (c) this.f6721f[i10].get("DefaultCropSize");
        c cVar4 = (c) this.f6721f[i10].get("SensorTopBorder");
        c cVar5 = (c) this.f6721f[i10].get("SensorLeftBorder");
        c cVar6 = (c) this.f6721f[i10].get("SensorBottomBorder");
        c cVar7 = (c) this.f6721f[i10].get("SensorRightBorder");
        if (cVar3 != null) {
            if (cVar3.f6745a == 5) {
                e[] eVarArr = (e[]) cVar3.k(this.f6723h);
                if (eVarArr == null || eVarArr.length != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    sb.append(Arrays.toString(eVarArr));
                    return;
                }
                cVar2 = c.d(eVarArr[0], this.f6723h);
                cVar = c.d(eVarArr[1], this.f6723h);
            } else {
                int[] iArr = (int[]) cVar3.k(this.f6723h);
                if (iArr == null || iArr.length != 2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid crop size values. cropSize=");
                    sb2.append(Arrays.toString(iArr));
                    return;
                }
                cVar2 = c.f(iArr[0], this.f6723h);
                cVar = c.f(iArr[1], this.f6723h);
            }
            this.f6721f[i10].put("ImageWidth", cVar2);
            this.f6721f[i10].put("ImageLength", cVar);
        } else if (cVar4 == null || cVar5 == null || cVar6 == null || cVar7 == null) {
            I(fVar, i10);
        } else {
            int i11 = cVar4.i(this.f6723h);
            int i12 = cVar6.i(this.f6723h);
            int i13 = cVar7.i(this.f6723h);
            int i14 = cVar5.i(this.f6723h);
            if (i12 > i11 && i13 > i14) {
                c f10 = c.f(i12 - i11, this.f6723h);
                c f11 = c.f(i13 - i14, this.f6723h);
                this.f6721f[i10].put("ImageLength", f10);
                this.f6721f[i10].put("ImageWidth", f11);
            }
        }
    }

    public final void N() {
        L(0, 5);
        L(0, 4);
        L(5, 4);
        c cVar = (c) this.f6721f[1].get("PixelXDimension");
        c cVar2 = (c) this.f6721f[1].get("PixelYDimension");
        if (!(cVar == null || cVar2 == null)) {
            this.f6721f[0].put("ImageWidth", cVar);
            this.f6721f[0].put("ImageLength", cVar2);
        }
        if (this.f6721f[4].isEmpty() && z(this.f6721f[5])) {
            HashMap[] hashMapArr = this.f6721f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        z(this.f6721f[4]);
        H(0, "ThumbnailOrientation", "Orientation");
        H(0, "ThumbnailImageLength", "ImageLength");
        H(0, "ThumbnailImageWidth", "ImageWidth");
        H(5, "ThumbnailOrientation", "Orientation");
        H(5, "ThumbnailImageLength", "ImageLength");
        H(5, "ThumbnailImageWidth", "ImageWidth");
        H(4, "Orientation", "ThumbnailOrientation");
        H(4, "ImageLength", "ThumbnailImageLength");
        H(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void a() {
        String b10 = b("DateTimeOriginal");
        if (b10 != null && b("DateTime") == null) {
            this.f6721f[0].put("DateTime", c.a(b10));
        }
        if (b("ImageWidth") == null) {
            this.f6721f[0].put("ImageWidth", c.b(0, this.f6723h));
        }
        if (b("ImageLength") == null) {
            this.f6721f[0].put("ImageLength", c.b(0, this.f6723h));
        }
        if (b("Orientation") == null) {
            this.f6721f[0].put("Orientation", c.b(0, this.f6723h));
        }
        if (b("LightSource") == null) {
            this.f6721f[1].put("LightSource", c.b(0, this.f6723h));
        }
    }

    public String b(String str) {
        if (str != null) {
            c d10 = d(str);
            if (d10 != null) {
                if (!f6701m0.contains(str)) {
                    return d10.j(this.f6723h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i10 = d10.f6745a;
                    if (i10 == 5 || i10 == 10) {
                        e[] eVarArr = (e[]) d10.k(this.f6723h);
                        if (eVarArr == null || eVarArr.length != 3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid GPS Timestamp array. array=");
                            sb.append(Arrays.toString(eVarArr));
                            return null;
                        }
                        e eVar = eVarArr[0];
                        e eVar2 = eVarArr[1];
                        e eVar3 = eVarArr[2];
                        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) eVar.f6753a) / ((float) eVar.f6754b))), Integer.valueOf((int) (((float) eVar2.f6753a) / ((float) eVar2.f6754b))), Integer.valueOf((int) (((float) eVar3.f6753a) / ((float) eVar3.f6754b)))});
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("GPS Timestamp format is not rational. format=");
                    sb2.append(d10.f6745a);
                    return null;
                }
                try {
                    return Double.toString(d10.h(this.f6723h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public int c(String str, int i10) {
        if (str != null) {
            c d10 = d(str);
            if (d10 == null) {
                return i10;
            }
            try {
                return d10.i(this.f6723h);
            } catch (NumberFormatException unused) {
                return i10;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public final c d(String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                str = "PhotographicSensitivity";
            }
            for (int i10 = 0; i10 < f6697i0.length; i10++) {
                c cVar = (c) this.f6721f[i10].get(str);
                if (cVar != null) {
                    return cVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012f, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0138, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0139, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013c, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0131 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(g0.b.f r13) {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x013d
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            g0.b$a r2 = new g0.b$a     // Catch:{ RuntimeException -> 0x0131 }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x0131 }
            g0.c.b.a(r1, r2)     // Catch:{ RuntimeException -> 0x0131 }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x0131 }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x0131 }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0131 }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0131 }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x0131 }
            if (r4 == 0) goto L_0x0046
            r0 = 29
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r4 = 30
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0131 }
            r5 = 31
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0131 }
            goto L_0x0062
        L_0x0046:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x0131 }
            if (r0 == 0) goto L_0x005f
            r0 = 18
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r4 = 19
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x0131 }
            r5 = 24
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x0131 }
            goto L_0x0062
        L_0x005f:
            r0 = 0
            r4 = r0
            r5 = r4
        L_0x0062:
            r6 = 0
            if (r0 == 0) goto L_0x0078
            java.util.HashMap[] r7 = r12.f6721f     // Catch:{ RuntimeException -> 0x0131 }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x0131 }
            java.nio.ByteOrder r10 = r12.f6723h     // Catch:{ RuntimeException -> 0x0131 }
            g0.b$c r9 = g0.b.c.f(r9, r10)     // Catch:{ RuntimeException -> 0x0131 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x0078:
            if (r4 == 0) goto L_0x008d
            java.util.HashMap[] r7 = r12.f6721f     // Catch:{ RuntimeException -> 0x0131 }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x0131 }
            java.nio.ByteOrder r10 = r12.f6723h     // Catch:{ RuntimeException -> 0x0131 }
            g0.b$c r9 = g0.b.c.f(r9, r10)     // Catch:{ RuntimeException -> 0x0131 }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x008d:
            r7 = 6
            if (r5 == 0) goto L_0x00b7
            int r8 = java.lang.Integer.parseInt(r5)     // Catch:{ RuntimeException -> 0x0131 }
            r9 = 90
            if (r8 == r9) goto L_0x00a7
            r9 = 180(0xb4, float:2.52E-43)
            if (r8 == r9) goto L_0x00a5
            r9 = 270(0x10e, float:3.78E-43)
            if (r8 == r9) goto L_0x00a2
            r8 = 1
            goto L_0x00a8
        L_0x00a2:
            r8 = 8
            goto L_0x00a8
        L_0x00a5:
            r8 = 3
            goto L_0x00a8
        L_0x00a7:
            r8 = 6
        L_0x00a8:
            java.util.HashMap[] r9 = r12.f6721f     // Catch:{ RuntimeException -> 0x0131 }
            r9 = r9[r6]     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.f6723h     // Catch:{ RuntimeException -> 0x0131 }
            g0.b$c r8 = g0.b.c.f(r8, r11)     // Catch:{ RuntimeException -> 0x0131 }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x00b7:
            if (r2 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x0131 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x0131 }
            if (r3 <= r7) goto L_0x0102
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x0131 }
            r13.f(r8)     // Catch:{ RuntimeException -> 0x0131 }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x0131 }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x0131 }
            if (r9 != r7) goto L_0x00fa
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = f6704p0     // Catch:{ RuntimeException -> 0x0131 }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x0131 }
            if (r7 == 0) goto L_0x00f2
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x0131 }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x0131 }
            if (r13 != r3) goto L_0x00ea
            r12.f6731p = r2     // Catch:{ RuntimeException -> 0x0131 }
            r12.F(r7, r6)     // Catch:{ RuntimeException -> 0x0131 }
            goto L_0x010a
        L_0x00ea:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x00f2:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x00fa:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x0102:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x0131 }
            throw r13     // Catch:{ RuntimeException -> 0x0131 }
        L_0x010a:
            boolean r13 = f6709u     // Catch:{ RuntimeException -> 0x0131 }
            if (r13 == 0) goto L_0x012b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0131 }
            r13.<init>()     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r2 = "Heif meta: "
            r13.append(r2)     // Catch:{ RuntimeException -> 0x0131 }
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = "x"
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r13.append(r4)     // Catch:{ RuntimeException -> 0x0131 }
            java.lang.String r0 = ", rotation "
            r13.append(r0)     // Catch:{ RuntimeException -> 0x0131 }
            r13.append(r5)     // Catch:{ RuntimeException -> 0x0131 }
        L_0x012b:
            r1.release()
            return
        L_0x012f:
            r13 = move-exception
            goto L_0x0139
        L_0x0131:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x012f }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x012f }
            throw r13     // Catch:{ all -> 0x012f }
        L_0x0139:
            r1.release()
            throw r13
        L_0x013d:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.e(g0.b$f):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0162 A[LOOP:0: B:8:0x002f->B:57:0x0162, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(g0.b.C0084b r20, int r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            boolean r3 = f6709u
            if (r3 == 0) goto L_0x0017
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getJpegAttributes starting with: "
            r3.append(r4)
            r3.append(r1)
        L_0x0017:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.c(r3)
            byte r3 = r20.readByte()
            java.lang.String r4 = "Invalid marker: "
            r5 = -1
            if (r3 != r5) goto L_0x01b4
            byte r6 = r20.readByte()
            r7 = -40
            if (r6 != r7) goto L_0x0199
            r3 = 2
            r4 = 2
        L_0x002f:
            byte r6 = r20.readByte()
            if (r6 != r5) goto L_0x017c
            r6 = 1
            int r4 = r4 + r6
            byte r7 = r20.readByte()
            boolean r8 = f6709u
            if (r8 == 0) goto L_0x0052
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Found JPEG segment indicator: "
            r9.append(r10)
            r10 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r9.append(r10)
        L_0x0052:
            int r4 = r4 + r6
            r9 = -39
            if (r7 == r9) goto L_0x0176
            r9 = -38
            if (r7 != r9) goto L_0x005d
            goto L_0x0176
        L_0x005d:
            int r9 = r20.readUnsignedShort()
            int r9 = r9 - r3
            int r4 = r4 + r3
            if (r8 == 0) goto L_0x0087
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "JPEG segment: "
            r8.append(r10)
            r10 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r8.append(r10)
            java.lang.String r10 = " (length: "
            r8.append(r10)
            int r10 = r9 + 2
            r8.append(r10)
            java.lang.String r10 = ")"
            r8.append(r10)
        L_0x0087:
            java.lang.String r8 = "Invalid length"
            if (r9 < 0) goto L_0x0170
            r10 = -31
            r11 = 0
            if (r7 == r10) goto L_0x0106
            r10 = -2
            if (r7 == r10) goto L_0x00db
            switch(r7) {
                case -64: goto L_0x00a1;
                case -63: goto L_0x00a1;
                case -62: goto L_0x00a1;
                case -61: goto L_0x00a1;
                default: goto L_0x0096;
            }
        L_0x0096:
            switch(r7) {
                case -59: goto L_0x00a1;
                case -58: goto L_0x00a1;
                case -57: goto L_0x00a1;
                default: goto L_0x0099;
            }
        L_0x0099:
            switch(r7) {
                case -55: goto L_0x00a1;
                case -54: goto L_0x00a1;
                case -53: goto L_0x00a1;
                default: goto L_0x009c;
            }
        L_0x009c:
            switch(r7) {
                case -51: goto L_0x00a1;
                case -50: goto L_0x00a1;
                case -49: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            goto L_0x0160
        L_0x00a1:
            r1.e(r6)
            java.util.HashMap[] r6 = r0.f6721f
            r6 = r6[r2]
            r7 = 4
            if (r2 == r7) goto L_0x00ae
            java.lang.String r10 = "ImageLength"
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r10 = "ThumbnailImageLength"
        L_0x00b0:
            int r11 = r20.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.f6723h
            g0.b$c r11 = g0.b.c.b(r11, r13)
            r6.put(r10, r11)
            java.util.HashMap[] r6 = r0.f6721f
            r6 = r6[r2]
            if (r2 == r7) goto L_0x00c7
            java.lang.String r7 = "ImageWidth"
            goto L_0x00c9
        L_0x00c7:
            java.lang.String r7 = "ThumbnailImageWidth"
        L_0x00c9:
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.f6723h
            g0.b$c r10 = g0.b.c.b(r10, r12)
            r6.put(r7, r10)
            int r9 = r9 + -5
            goto L_0x0160
        L_0x00db:
            byte[] r7 = new byte[r9]
            int r10 = r1.read(r7)
            if (r10 != r9) goto L_0x00fe
            java.lang.String r9 = "UserComment"
            java.lang.String r10 = r0.b(r9)
            if (r10 != 0) goto L_0x015f
            java.util.HashMap[] r10 = r0.f6721f
            r6 = r10[r6]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r12 = f6703o0
            r10.<init>(r7, r12)
            g0.b$c r7 = g0.b.c.a(r10)
            r6.put(r9, r7)
            goto L_0x015f
        L_0x00fe:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0106:
            byte[] r7 = new byte[r9]
            r1.readFully(r7)
            int r10 = r4 + r9
            byte[] r12 = f6704p0
            boolean r13 = g0.c.c(r7, r12)
            if (r13 == 0) goto L_0x012c
            int r6 = r12.length
            byte[] r6 = java.util.Arrays.copyOfRange(r7, r6, r9)
            int r4 = r21 + r4
            int r7 = r12.length
            int r4 = r4 + r7
            r0.f6731p = r4
            r0.F(r6, r2)
            g0.b$b r4 = new g0.b$b
            r4.<init>((byte[]) r6)
            r0.J(r4)
            goto L_0x015e
        L_0x012c:
            byte[] r12 = f6705q0
            boolean r13 = g0.c.c(r7, r12)
            if (r13 == 0) goto L_0x015e
            int r13 = r12.length
            int r4 = r4 + r13
            int r12 = r12.length
            byte[] r7 = java.util.Arrays.copyOfRange(r7, r12, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r12 = r0.b(r9)
            if (r12 != 0) goto L_0x015e
            java.util.HashMap[] r12 = r0.f6721f
            r12 = r12[r11]
            g0.b$c r15 = new g0.b$c
            r14 = 1
            int r13 = r7.length
            long r3 = (long) r4
            r16 = r13
            r13 = r15
            r5 = r15
            r15 = r16
            r16 = r3
            r18 = r7
            r13.<init>(r14, r15, r16, r18)
            r12.put(r9, r5)
            r0.f6735t = r6
        L_0x015e:
            r4 = r10
        L_0x015f:
            r9 = 0
        L_0x0160:
            if (r9 < 0) goto L_0x016a
            r1.e(r9)
            int r4 = r4 + r9
            r3 = 2
            r5 = -1
            goto L_0x002f
        L_0x016a:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r8)
            throw r1
        L_0x0170:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r8)
            throw r1
        L_0x0176:
            java.nio.ByteOrder r2 = r0.f6723h
            r1.c(r2)
            return
        L_0x017c:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r6 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0199:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b4:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            goto L_0x01d0
        L_0x01cf:
            throw r1
        L_0x01d0:
            goto L_0x01cf
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.f(g0.b$b, int, int):void");
    }

    public final int g(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT);
        byte[] bArr = new byte[com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (s(bArr)) {
            return 4;
        }
        if (v(bArr)) {
            return 9;
        }
        if (r(bArr)) {
            return 12;
        }
        if (t(bArr)) {
            return 7;
        }
        if (w(bArr)) {
            return 10;
        }
        if (u(bArr)) {
            return 13;
        }
        if (A(bArr)) {
            return 14;
        }
        return 0;
    }

    public final void h(f fVar) {
        int i10;
        int i11;
        k(fVar);
        c cVar = (c) this.f6721f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f6748d);
            fVar2.c(this.f6723h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.f(0);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.f(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.f(12);
            }
            G(fVar2, 6);
            c cVar2 = (c) this.f6721f[7].get("PreviewImageStart");
            c cVar3 = (c) this.f6721f[7].get("PreviewImageLength");
            if (!(cVar2 == null || cVar3 == null)) {
                this.f6721f[5].put("JPEGInterchangeFormat", cVar2);
                this.f6721f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = (c) this.f6721f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.f6723h);
                if (iArr == null || iArr.length != 4) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid aspect frame values. frame=");
                    sb.append(Arrays.toString(iArr));
                    return;
                }
                int i12 = iArr[2];
                int i13 = iArr[0];
                if (i12 > i13 && (i10 = iArr[3]) > (i11 = iArr[1])) {
                    int i14 = (i12 - i13) + 1;
                    int i15 = (i10 - i11) + 1;
                    if (i14 < i15) {
                        int i16 = i14 + i15;
                        i15 = i16 - i15;
                        i14 = i16 - i15;
                    }
                    c f10 = c.f(i14, this.f6723h);
                    c f11 = c.f(i15, this.f6723h);
                    this.f6721f[0].put("ImageWidth", f10);
                    this.f6721f[0].put("ImageLength", f11);
                }
            }
        }
    }

    public final void i(C0084b bVar) {
        if (f6709u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getPngAttributes starting with: ");
            sb.append(bVar);
        }
        bVar.c(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        bVar.e(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i10 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i11 = i10 + 4;
                    if (i11 == 16) {
                        if (!Arrays.equals(bArr2, I)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, J)) {
                        if (Arrays.equals(bArr2, H)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f6731p = i11;
                                    F(bArr3, 0);
                                    N();
                                    J(new C0084b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + c.a(bArr2));
                        }
                        int i12 = readInt + 4;
                        bVar.e(i12);
                        length = i11 + i12;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(C0084b bVar) {
        boolean z10 = f6709u;
        if (z10) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRafAttributes starting with: ");
            sb.append(bVar);
        }
        bVar.e(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.e(i10 - bVar.a());
        bVar.read(bArr4);
        f(new C0084b(bArr4), i10, 5);
        bVar.e(i12 - bVar.a());
        bVar.c(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("numberOfDirectoryEntry: ");
            sb2.append(readInt);
        }
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f6692d0.f6749a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c f10 = c.f(readShort, this.f6723h);
                c f11 = c.f(readShort2, this.f6723h);
                this.f6721f[0].put("ImageLength", f10);
                this.f6721f[0].put("ImageWidth", f11);
                if (f6709u) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Updated to length: ");
                    sb3.append(readShort);
                    sb3.append(", width: ");
                    sb3.append(readShort2);
                    return;
                }
                return;
            }
            bVar.e(readUnsignedShort2);
        }
    }

    public final void k(f fVar) {
        c cVar;
        C(fVar);
        G(fVar, 0);
        M(fVar, 0);
        M(fVar, 5);
        M(fVar, 4);
        N();
        if (this.f6719d == 8 && (cVar = (c) this.f6721f[1].get("MakerNote")) != null) {
            f fVar2 = new f(cVar.f6748d);
            fVar2.c(this.f6723h);
            fVar2.e(6);
            G(fVar2, 9);
            c cVar2 = (c) this.f6721f[9].get("ColorSpace");
            if (cVar2 != null) {
                this.f6721f[1].put("ColorSpace", cVar2);
            }
        }
    }

    public final void l(f fVar) {
        if (f6709u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRw2Attributes starting with: ");
            sb.append(fVar);
        }
        k(fVar);
        c cVar = (c) this.f6721f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new C0084b(cVar.f6748d), (int) cVar.f6747c, 5);
        }
        c cVar2 = (c) this.f6721f[0].get("ISO");
        c cVar3 = (c) this.f6721f[1].get("PhotographicSensitivity");
        if (cVar2 != null && cVar3 == null) {
            this.f6721f[1].put("PhotographicSensitivity", cVar2);
        }
    }

    public final void m(f fVar) {
        byte[] bArr = f6704p0;
        fVar.e(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f6731p = bArr.length;
        F(bArr2, 0);
    }

    public final void n(C0084b bVar) {
        if (f6709u) {
            StringBuilder sb = new StringBuilder();
            sb.append("getWebpAttributes starting with: ");
            sb.append(bVar);
        }
        bVar.c(ByteOrder.LITTLE_ENDIAN);
        bVar.e(K.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = L;
        bVar.e(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i10 = length + 4 + 4;
                    if (Arrays.equals(M, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f6731p = i10;
                            F(bArr3, 0);
                            J(new C0084b(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + c.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i10 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            bVar.e(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void o(C0084b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar != null && cVar2 != null) {
            int i10 = cVar.i(this.f6723h);
            int i11 = cVar2.i(this.f6723h);
            if (this.f6719d == 7) {
                i10 += this.f6732q;
            }
            if (i10 > 0 && i11 > 0) {
                this.f6724i = true;
                if (this.f6716a == null && this.f6718c == null && this.f6717b == null) {
                    byte[] bArr = new byte[i11];
                    bVar.skip((long) i10);
                    bVar.read(bArr);
                    this.f6729n = bArr;
                }
                this.f6727l = i10;
                this.f6728m = i11;
            }
            if (f6709u) {
                StringBuilder sb = new StringBuilder();
                sb.append("Setting thumbnail attributes with offset: ");
                sb.append(i10);
                sb.append(", length: ");
                sb.append(i11);
            }
        }
    }

    public final void p(C0084b bVar, HashMap hashMap) {
        C0084b bVar2 = bVar;
        HashMap hashMap2 = hashMap;
        c cVar = (c) hashMap2.get("StripOffsets");
        c cVar2 = (c) hashMap2.get("StripByteCounts");
        if (cVar != null && cVar2 != null) {
            long[] b10 = c.b(cVar.k(this.f6723h));
            long[] b11 = c.b(cVar2.k(this.f6723h));
            if (b10 != null && b10.length != 0 && b11 != null && b11.length != 0 && b10.length == b11.length) {
                long j10 = 0;
                for (long j11 : b11) {
                    j10 += j11;
                }
                int i10 = (int) j10;
                byte[] bArr = new byte[i10];
                int i11 = 1;
                this.f6726k = true;
                this.f6725j = true;
                this.f6724i = true;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (i12 < b10.length) {
                    int i15 = (int) b10[i12];
                    int i16 = (int) b11[i12];
                    if (i12 < b10.length - i11 && ((long) (i15 + i16)) != b10[i12 + 1]) {
                        this.f6726k = false;
                    }
                    int i17 = i15 - i13;
                    if (i17 >= 0) {
                        long j12 = (long) i17;
                        if (bVar2.skip(j12) != j12) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to skip ");
                            sb.append(i17);
                            sb.append(" bytes.");
                            return;
                        }
                        int i18 = i13 + i17;
                        byte[] bArr2 = new byte[i16];
                        if (bVar2.read(bArr2) != i16) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to read ");
                            sb2.append(i16);
                            sb2.append(" bytes.");
                            return;
                        }
                        i13 = i18 + i16;
                        System.arraycopy(bArr2, 0, bArr, i14, i16);
                        i14 += i16;
                        i12++;
                        i11 = 1;
                    } else {
                        return;
                    }
                }
                this.f6729n = bArr;
                if (this.f6726k) {
                    this.f6727l = (int) b10[0];
                    this.f6728m = i10;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0090, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean r(byte[] r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            g0.b$b r2 = new g0.b$b     // Catch:{ Exception -> 0x008c }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008c }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = B     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 8
            r7 = 1
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r9 = 16
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r9 = r5
        L_0x0035:
            int r11 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r11 = (long) r11     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r9
            int r15 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r5 = 0
            r9 = 0
            r10 = 0
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = C     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r9 = 1
            goto L_0x0077
        L_0x006e:
            byte[] r11 = D     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r10 = 1
        L_0x0077:
            if (r9 == 0) goto L_0x007f
            if (r10 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r5 = r5 + r7
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x0093
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x0094
        L_0x0088:
            r1 = r2
            goto L_0x008c
        L_0x008a:
            r15 = move-exception
            goto L_0x0094
        L_0x008c:
            boolean r15 = f6709u     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0093
            r1.close()
        L_0x0093:
            return r0
        L_0x0094:
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            goto L_0x009b
        L_0x009a:
            throw r15
        L_0x009b:
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.r(byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean t(byte[] r4) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            g0.b$b r2 = new g0.b$b     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002e, all -> 0x0027 }
            java.nio.ByteOrder r4 = r3.E(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.f6723h = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.c(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0028
        L_0x0024:
            r1 = r2
            goto L_0x002f
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            throw r4
        L_0x002e:
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.t(byte[]):boolean");
    }

    public final boolean u(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public final boolean v(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(byte[] r4) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            g0.b$b r2 = new g0.b$b     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            java.nio.ByteOrder r4 = r3.E(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.f6723h = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.c(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0024
        L_0x0020:
            r1 = r2
            goto L_0x002b
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.close()
        L_0x0029:
            throw r4
        L_0x002a:
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.w(byte[]):boolean");
    }

    public final boolean y(HashMap hashMap) {
        c cVar;
        c cVar2 = (c) hashMap.get("BitsPerSample");
        if (cVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) cVar2.k(this.f6723h);
        int[] iArr2 = f6713x;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f6719d != 3 || (cVar = (c) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i10 = cVar.i(this.f6723h);
        if ((i10 != 1 || !Arrays.equals(iArr, f6715z)) && (i10 != 6 || !Arrays.equals(iArr, iArr2))) {
            return false;
        }
        return true;
    }

    public final boolean z(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        int i10 = cVar.i(this.f6723h);
        int i11 = cVar2.i(this.f6723h);
        if (i10 > 512 || i11 > 512) {
            return false;
        }
        return true;
    }

    public static class f extends C0084b {
        public f(byte[] bArr) {
            super(bArr);
            this.f6741a.mark(Integer.MAX_VALUE);
        }

        public void f(long j10) {
            int i10 = this.f6743c;
            if (((long) i10) > j10) {
                this.f6743c = 0;
                this.f6741a.reset();
            } else {
                j10 -= (long) i10;
            }
            e((int) j10);
        }

        public f(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f6741a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public b(InputStream inputStream, int i10) {
        d[][] dVarArr = f6697i0;
        this.f6721f = new HashMap[dVarArr.length];
        this.f6722g = new HashSet(dVarArr.length);
        this.f6723h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f6716a = null;
            if (i10 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f6704p0.length);
                if (q(bufferedInputStream)) {
                    this.f6720e = true;
                    this.f6718c = null;
                    this.f6717b = null;
                    inputStream = bufferedInputStream;
                } else {
                    return;
                }
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f6718c = (AssetManager.AssetInputStream) inputStream;
                this.f6717b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (x(fileInputStream.getFD())) {
                        this.f6718c = null;
                        this.f6717b = fileInputStream.getFD();
                    }
                }
                this.f6718c = null;
                this.f6717b = null;
            }
            B(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f6749a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6750b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6751c;

        /* renamed from: d  reason: collision with root package name */
        public final int f6752d;

        public d(String str, int i10, int i11) {
            this.f6750b = str;
            this.f6749a = i10;
            this.f6751c = i11;
            this.f6752d = -1;
        }

        public boolean a(int i10) {
            int i11;
            int i12 = this.f6751c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f6752d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            if ((i12 == 12 || i11 == 12) && i10 == 11) {
                return true;
            }
            return false;
        }

        public d(String str, int i10, int i11, int i12) {
            this.f6750b = str;
            this.f6749a = i10;
            this.f6751c = i11;
            this.f6752d = i12;
        }
    }
}
