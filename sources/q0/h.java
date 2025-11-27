package q0;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import t0.d;
import t0.e;

public class h implements e, d {

    /* renamed from: i  reason: collision with root package name */
    public static final TreeMap f8903i = new TreeMap();

    /* renamed from: a  reason: collision with root package name */
    public volatile String f8904a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f8905b;

    /* renamed from: c  reason: collision with root package name */
    public final double[] f8906c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f8907d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[][] f8908e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f8909f;

    /* renamed from: g  reason: collision with root package name */
    public final int f8910g;

    /* renamed from: h  reason: collision with root package name */
    public int f8911h;

    public h(int i10) {
        this.f8910g = i10;
        int i11 = i10 + 1;
        this.f8909f = new int[i11];
        this.f8905b = new long[i11];
        this.f8906c = new double[i11];
        this.f8907d = new String[i11];
        this.f8908e = new byte[i11][];
    }

    public static h c(String str, int i10) {
        TreeMap treeMap = f8903i;
        synchronized (treeMap) {
            Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                h hVar = (h) ceilingEntry.getValue();
                hVar.e(str, i10);
                return hVar;
            }
            h hVar2 = new h(i10);
            hVar2.e(str, i10);
            return hVar2;
        }
    }

    public static void f() {
        TreeMap treeMap = f8903i;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator it = treeMap.descendingKeySet().iterator();
            while (true) {
                int i10 = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i10;
                } else {
                    return;
                }
            }
        }
    }

    public void a(d dVar) {
        for (int i10 = 1; i10 <= this.f8911h; i10++) {
            int i11 = this.f8909f[i10];
            if (i11 == 1) {
                dVar.bindNull(i10);
            } else if (i11 == 2) {
                dVar.bindLong(i10, this.f8905b[i10]);
            } else if (i11 == 3) {
                dVar.bindDouble(i10, this.f8906c[i10]);
            } else if (i11 == 4) {
                dVar.bindString(i10, this.f8907d[i10]);
            } else if (i11 == 5) {
                dVar.bindBlob(i10, this.f8908e[i10]);
            }
        }
    }

    public String b() {
        return this.f8904a;
    }

    public void bindBlob(int i10, byte[] bArr) {
        this.f8909f[i10] = 5;
        this.f8908e[i10] = bArr;
    }

    public void bindDouble(int i10, double d10) {
        this.f8909f[i10] = 3;
        this.f8906c[i10] = d10;
    }

    public void bindLong(int i10, long j10) {
        this.f8909f[i10] = 2;
        this.f8905b[i10] = j10;
    }

    public void bindNull(int i10) {
        this.f8909f[i10] = 1;
    }

    public void bindString(int i10, String str) {
        this.f8909f[i10] = 4;
        this.f8907d[i10] = str;
    }

    public void close() {
    }

    public void e(String str, int i10) {
        this.f8904a = str;
        this.f8911h = i10;
    }

    public void release() {
        TreeMap treeMap = f8903i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f8910g), this);
            f();
        }
    }
}
