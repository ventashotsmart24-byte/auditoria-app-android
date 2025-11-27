package r;

import android.graphics.Color;
import com.hpplay.cybergarage.upnp.UPnP;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f8941a = new ThreadLocal();

    public static void a(int i10, int i11, int i12, float[] fArr) {
        float f10;
        float f11;
        float f12 = ((float) i10) / 255.0f;
        float f13 = ((float) i11) / 255.0f;
        float f14 = ((float) i12) / 255.0f;
        float max = Math.max(f12, Math.max(f13, f14));
        float min = Math.min(f12, Math.min(f13, f14));
        float f15 = max - min;
        float f16 = (max + min) / 2.0f;
        if (max == min) {
            f10 = 0.0f;
            f11 = 0.0f;
        } else {
            if (max == f12) {
                f10 = ((f13 - f14) / f15) % 6.0f;
            } else if (max == f13) {
                f10 = ((f14 - f12) / f15) + 2.0f;
            } else {
                f10 = 4.0f + ((f12 - f13) / f15);
            }
            f11 = f15 / (1.0f - Math.abs((2.0f * f16) - 1.0f));
        }
        float f17 = (f10 * 60.0f) % 360.0f;
        if (f17 < 0.0f) {
            f17 += 360.0f;
        }
        fArr[0] = k(f17, 0.0f, 360.0f);
        fArr[1] = k(f11, 0.0f, 1.0f);
        fArr[2] = k(f16, 0.0f, 1.0f);
    }

    public static void b(int i10, int i11, int i12, double[] dArr) {
        double d10;
        double d11;
        double d12;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d13 = (double) i10;
            Double.isNaN(d13);
            double d14 = d13 / 255.0d;
            if (d14 < 0.04045d) {
                d10 = d14 / 12.92d;
            } else {
                d10 = Math.pow((d14 + 0.055d) / 1.055d, 2.4d);
            }
            double d15 = (double) i11;
            Double.isNaN(d15);
            double d16 = d15 / 255.0d;
            if (d16 < 0.04045d) {
                d11 = d16 / 12.92d;
            } else {
                d11 = Math.pow((d16 + 0.055d) / 1.055d, 2.4d);
            }
            double d17 = (double) i12;
            Double.isNaN(d17);
            double d18 = d17 / 255.0d;
            if (d18 < 0.04045d) {
                d12 = d18 / 12.92d;
            } else {
                d12 = Math.pow((d18 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * d10) + (0.3576d * d11) + (0.1805d * d12)) * 100.0d;
            dArr2[1] = ((0.2126d * d10) + (0.7152d * d11) + (0.0722d * d12)) * 100.0d;
            dArr2[2] = ((d10 * 0.0193d) + (d11 * 0.1192d) + (d12 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static double c(int i10, int i11) {
        if (Color.alpha(i11) == 255) {
            if (Color.alpha(i10) < 255) {
                i10 = i(i10, i11);
            }
            double d10 = d(i10) + 0.05d;
            double d11 = d(i11) + 0.05d;
            return Math.max(d10, d11) / Math.min(d10, d11);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i11));
    }

    public static double d(int i10) {
        double[] l10 = l();
        g(i10, l10);
        return l10[1] / 100.0d;
    }

    public static int e(int i10, int i11, float f10) {
        int i12 = 255;
        if (Color.alpha(i11) == 255) {
            double d10 = (double) f10;
            if (c(m(i10, 255), i11) < d10) {
                return -1;
            }
            int i13 = 0;
            for (int i14 = 0; i14 <= 10 && i12 - i13 > 1; i14++) {
                int i15 = (i13 + i12) / 2;
                if (c(m(i10, i15), i11) < d10) {
                    i13 = i15;
                } else {
                    i12 = i15;
                }
            }
            return i12;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i11));
    }

    public static void f(int i10, float[] fArr) {
        a(Color.red(i10), Color.green(i10), Color.blue(i10), fArr);
    }

    public static void g(int i10, double[] dArr) {
        b(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    public static int h(int i10, int i11) {
        return 255 - (((255 - i11) * (255 - i10)) / 255);
    }

    public static int i(int i10, int i11) {
        int alpha = Color.alpha(i11);
        int alpha2 = Color.alpha(i10);
        int h10 = h(alpha2, alpha);
        return Color.argb(h10, j(Color.red(i10), alpha2, Color.red(i11), alpha, h10), j(Color.green(i10), alpha2, Color.green(i11), alpha, h10), j(Color.blue(i10), alpha2, Color.blue(i11), alpha, h10));
    }

    public static int j(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            return 0;
        }
        return (((i10 * 255) * i11) + ((i12 * i13) * (255 - i11))) / (i14 * 255);
    }

    public static float k(float f10, float f11, float f12) {
        if (f10 < f11) {
            return f11;
        }
        return f10 > f12 ? f12 : f10;
    }

    public static double[] l() {
        ThreadLocal threadLocal = f8941a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int m(int i10, int i11) {
        if (i11 >= 0 && i11 <= 255) {
            return (i10 & UPnP.CONFIGID_UPNP_ORG_MAX) | (i11 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
