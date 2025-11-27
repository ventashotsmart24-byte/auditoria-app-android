package r;

import android.graphics.Path;
import java.util.ArrayList;

public abstract class d {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f8947a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8948b;
    }

    public static void a(ArrayList arrayList, char c10, float[] fArr) {
        arrayList.add(new b(c10, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            b bVar = bVarArr[i10];
            char c10 = bVar.f8949a;
            b bVar2 = bVarArr2[i10];
            if (c10 != bVar2.f8949a || bVar.f8950b.length != bVar2.f8950b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] c(float[] fArr, int i10, int i11) {
        if (i10 <= i11) {
            int length = fArr.length;
            if (i10 < 0 || i10 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i12 = i11 - i10;
            int min = Math.min(i12, length - i10);
            float[] fArr2 = new float[i12];
            System.arraycopy(fArr, i10, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static b[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        while (i10 < str.length()) {
            int i12 = i(str, i10);
            String trim = str.substring(i11, i12).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i11 = i12;
            i10 = i12 + 1;
        }
        if (i10 - i11 == 1 && i11 < str.length()) {
            a(arrayList, str.charAt(i11), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        b[] d10 = d(str);
        if (d10 == null) {
            return null;
        }
        try {
            b.e(d10, path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException("Error in parsing " + str, e10);
        }
    }

    public static b[] f(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            bVarArr2[i10] = new b(bVarArr[i10]);
        }
        return bVarArr2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:1:0x0007->B:20:0x003a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.String r8, int r9, r.d.a r10) {
        /*
            r0 = 0
            r10.f8948b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0035
            r6 = 69
            if (r5 == r6) goto L_0x0033
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0033
            switch(r5) {
                case 44: goto L_0x0035;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0031
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0037
        L_0x0027:
            r10.f8948b = r7
            goto L_0x0035
        L_0x002a:
            if (r1 == r9) goto L_0x0031
            if (r2 != 0) goto L_0x0031
            r10.f8948b = r7
            goto L_0x0035
        L_0x0031:
            r2 = 0
            goto L_0x0037
        L_0x0033:
            r2 = 1
            goto L_0x0037
        L_0x0035:
            r2 = 0
            r4 = 1
        L_0x0037:
            if (r4 == 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003d:
            r10.f8947a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.d.g(java.lang.String, int, r.d$a):void");
    }

    public static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i10 = 1;
            int i11 = 0;
            while (i10 < length) {
                g(str, i10, aVar);
                int i12 = aVar.f8947a;
                if (i10 < i12) {
                    fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                    i11++;
                }
                if (aVar.f8948b) {
                    i10 = i12;
                } else {
                    i10 = i12 + 1;
                }
            }
            return c(fArr, 0, i11);
        } catch (NumberFormatException e10) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e10);
        }
    }

    public static int i(String str, int i10) {
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    public static void j(b[] bVarArr, b[] bVarArr2) {
        for (int i10 = 0; i10 < bVarArr2.length; i10++) {
            bVarArr[i10].f8949a = bVarArr2[i10].f8949a;
            int i11 = 0;
            while (true) {
                float[] fArr = bVarArr2[i10].f8950b;
                if (i11 >= fArr.length) {
                    break;
                }
                bVarArr[i10].f8950b[i11] = fArr[i11];
                i11++;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public char f8949a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f8950b;

        public b(char c10, float[] fArr) {
            this.f8949a = c10;
            this.f8950b = fArr;
        }

        public static void a(Path path, float[] fArr, char c10, char c11, float[] fArr2) {
            int i10;
            int i11;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            Path path2 = path;
            char c12 = c11;
            float[] fArr3 = fArr2;
            float f20 = fArr[0];
            float f21 = fArr[1];
            float f22 = fArr[2];
            float f23 = fArr[3];
            float f24 = fArr[4];
            float f25 = fArr[5];
            switch (c12) {
                case 'A':
                case 'a':
                    i10 = 7;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i10 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i10 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f24, f25);
                    f20 = f24;
                    f22 = f20;
                    f21 = f25;
                    f23 = f21;
                    break;
            }
            i10 = 2;
            float f26 = f20;
            float f27 = f21;
            float f28 = f24;
            float f29 = f25;
            int i12 = 0;
            char c13 = c10;
            while (i12 < fArr3.length) {
                if (c12 != 'A') {
                    if (c12 == 'C') {
                        i11 = i12;
                        int i13 = i11 + 2;
                        int i14 = i11 + 3;
                        int i15 = i11 + 4;
                        int i16 = i11 + 5;
                        path.cubicTo(fArr3[i11 + 0], fArr3[i11 + 1], fArr3[i13], fArr3[i14], fArr3[i15], fArr3[i16]);
                        f26 = fArr3[i15];
                        float f30 = fArr3[i16];
                        float f31 = fArr3[i13];
                        float f32 = fArr3[i14];
                        f27 = f30;
                        f23 = f32;
                        f22 = f31;
                    } else if (c12 == 'H') {
                        i11 = i12;
                        int i17 = i11 + 0;
                        path2.lineTo(fArr3[i17], f27);
                        f26 = fArr3[i17];
                    } else if (c12 == 'Q') {
                        i11 = i12;
                        int i18 = i11 + 0;
                        int i19 = i11 + 1;
                        int i20 = i11 + 2;
                        int i21 = i11 + 3;
                        path2.quadTo(fArr3[i18], fArr3[i19], fArr3[i20], fArr3[i21]);
                        float f33 = fArr3[i18];
                        float f34 = fArr3[i19];
                        f26 = fArr3[i20];
                        f27 = fArr3[i21];
                        f22 = f33;
                        f23 = f34;
                    } else if (c12 == 'V') {
                        i11 = i12;
                        int i22 = i11 + 0;
                        path2.lineTo(f26, fArr3[i22]);
                        f27 = fArr3[i22];
                    } else if (c12 != 'a') {
                        if (c12 == 'c') {
                            int i23 = i12 + 2;
                            int i24 = i12 + 3;
                            int i25 = i12 + 4;
                            int i26 = i12 + 5;
                            path.rCubicTo(fArr3[i12 + 0], fArr3[i12 + 1], fArr3[i23], fArr3[i24], fArr3[i25], fArr3[i26]);
                            f13 = fArr3[i23] + f26;
                            f12 = fArr3[i24] + f27;
                            f26 += fArr3[i25];
                            f14 = fArr3[i26];
                            f27 += f14;
                            f22 = f13;
                            f23 = f12;
                        } else if (c12 != 'h') {
                            if (c12 != 'q') {
                                if (c12 == 'v') {
                                    int i27 = i12 + 0;
                                    path2.rLineTo(0.0f, fArr3[i27]);
                                    f15 = fArr3[i27];
                                } else if (c12 != 'L') {
                                    if (c12 == 'M') {
                                        f26 = fArr3[i12 + 0];
                                        f27 = fArr3[i12 + 1];
                                        if (i12 > 0) {
                                            path2.lineTo(f26, f27);
                                        } else {
                                            path2.moveTo(f26, f27);
                                        }
                                    } else if (c12 == 'S') {
                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                            f26 = (f26 * 2.0f) - f22;
                                            f27 = (f27 * 2.0f) - f23;
                                        }
                                        float f35 = f27;
                                        int i28 = i12 + 0;
                                        int i29 = i12 + 1;
                                        int i30 = i12 + 2;
                                        int i31 = i12 + 3;
                                        path.cubicTo(f26, f35, fArr3[i28], fArr3[i29], fArr3[i30], fArr3[i31]);
                                        f13 = fArr3[i28];
                                        f12 = fArr3[i29];
                                        f26 = fArr3[i30];
                                        f27 = fArr3[i31];
                                        f22 = f13;
                                        f23 = f12;
                                    } else if (c12 == 'T') {
                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                            f26 = (f26 * 2.0f) - f22;
                                            f27 = (f27 * 2.0f) - f23;
                                        }
                                        int i32 = i12 + 0;
                                        int i33 = i12 + 1;
                                        path2.quadTo(f26, f27, fArr3[i32], fArr3[i33]);
                                        float f36 = fArr3[i32];
                                        float f37 = fArr3[i33];
                                        i11 = i12;
                                        f23 = f27;
                                        f22 = f26;
                                        f26 = f36;
                                        f27 = f37;
                                    } else if (c12 == 'l') {
                                        int i34 = i12 + 0;
                                        int i35 = i12 + 1;
                                        path2.rLineTo(fArr3[i34], fArr3[i35]);
                                        f26 += fArr3[i34];
                                        f15 = fArr3[i35];
                                    } else if (c12 == 'm') {
                                        float f38 = fArr3[i12 + 0];
                                        f26 += f38;
                                        float f39 = fArr3[i12 + 1];
                                        f27 += f39;
                                        if (i12 > 0) {
                                            path2.rLineTo(f38, f39);
                                        } else {
                                            path2.rMoveTo(f38, f39);
                                        }
                                    } else if (c12 == 's') {
                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                            float f40 = f26 - f22;
                                            f16 = f27 - f23;
                                            f17 = f40;
                                        } else {
                                            f17 = 0.0f;
                                            f16 = 0.0f;
                                        }
                                        int i36 = i12 + 0;
                                        int i37 = i12 + 1;
                                        int i38 = i12 + 2;
                                        int i39 = i12 + 3;
                                        path.rCubicTo(f17, f16, fArr3[i36], fArr3[i37], fArr3[i38], fArr3[i39]);
                                        f13 = fArr3[i36] + f26;
                                        f12 = fArr3[i37] + f27;
                                        f26 += fArr3[i38];
                                        f14 = fArr3[i39];
                                    } else if (c12 == 't') {
                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                            f18 = f26 - f22;
                                            f19 = f27 - f23;
                                        } else {
                                            f19 = 0.0f;
                                            f18 = 0;
                                        }
                                        int i40 = i12 + 0;
                                        int i41 = i12 + 1;
                                        path2.rQuadTo(f18, f19, fArr3[i40], fArr3[i41]);
                                        float f41 = f18 + f26;
                                        float f42 = f19 + f27;
                                        f26 += fArr3[i40];
                                        f27 += fArr3[i41];
                                        f23 = f42;
                                        f22 = f41;
                                    }
                                    i11 = i12;
                                    f29 = f27;
                                    f28 = f26;
                                } else {
                                    int i42 = i12 + 0;
                                    int i43 = i12 + 1;
                                    path2.lineTo(fArr3[i42], fArr3[i43]);
                                    f26 = fArr3[i42];
                                    f27 = fArr3[i43];
                                }
                                f27 += f15;
                            } else {
                                int i44 = i12 + 0;
                                int i45 = i12 + 1;
                                int i46 = i12 + 2;
                                int i47 = i12 + 3;
                                path2.rQuadTo(fArr3[i44], fArr3[i45], fArr3[i46], fArr3[i47]);
                                f13 = fArr3[i44] + f26;
                                f12 = fArr3[i45] + f27;
                                f26 += fArr3[i46];
                                f14 = fArr3[i47];
                            }
                            f27 += f14;
                            f22 = f13;
                            f23 = f12;
                        } else {
                            int i48 = i12 + 0;
                            path2.rLineTo(fArr3[i48], 0.0f);
                            f26 += fArr3[i48];
                        }
                        i11 = i12;
                    } else {
                        int i49 = i12 + 5;
                        int i50 = i12 + 6;
                        i11 = i12;
                        c(path, f26, f27, fArr3[i49] + f26, fArr3[i50] + f27, fArr3[i12 + 0], fArr3[i12 + 1], fArr3[i12 + 2], fArr3[i12 + 3] != 0.0f, fArr3[i12 + 4] != 0.0f);
                        f10 = f26 + fArr3[i49];
                        f11 = f27 + fArr3[i50];
                    }
                    i12 = i11 + i10;
                    c13 = c11;
                    c12 = c13;
                } else {
                    i11 = i12;
                    int i51 = i11 + 5;
                    int i52 = i11 + 6;
                    c(path, f26, f27, fArr3[i51], fArr3[i52], fArr3[i11 + 0], fArr3[i11 + 1], fArr3[i11 + 2], fArr3[i11 + 3] != 0.0f, fArr3[i11 + 4] != 0.0f);
                    f10 = fArr3[i51];
                    f11 = fArr3[i52];
                }
                f23 = f27;
                f22 = f26;
                i12 = i11 + i10;
                c13 = c11;
                c12 = c13;
            }
            fArr[0] = f26;
            fArr[1] = f27;
            fArr[2] = f22;
            fArr[3] = f23;
            fArr[4] = f28;
            fArr[5] = f29;
        }

        public static void b(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
            double d19 = d12;
            int ceil = (int) Math.ceil(Math.abs((d18 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d16);
            double sin = Math.sin(d16);
            double cos2 = Math.cos(d17);
            double sin2 = Math.sin(d17);
            double d20 = -d19;
            double d21 = d20 * cos;
            double d22 = d13 * sin;
            double d23 = (d21 * sin2) - (d22 * cos2);
            double d24 = d20 * sin;
            double d25 = d13 * cos;
            double d26 = (sin2 * d24) + (cos2 * d25);
            double d27 = (double) ceil;
            Double.isNaN(d27);
            double d28 = d18 / d27;
            double d29 = d17;
            double d30 = d26;
            double d31 = d23;
            int i10 = 0;
            double d32 = d14;
            double d33 = d15;
            while (i10 < ceil) {
                double d34 = d29 + d28;
                double sin3 = Math.sin(d34);
                double cos3 = Math.cos(d34);
                double d35 = (d10 + ((d19 * cos) * cos3)) - (d22 * sin3);
                double d36 = d11 + (d19 * sin * cos3) + (d25 * sin3);
                double d37 = (d21 * sin3) - (d22 * cos3);
                double d38 = (sin3 * d24) + (cos3 * d25);
                double d39 = d34 - d29;
                double tan = Math.tan(d39 / 2.0d);
                double sin4 = (Math.sin(d39) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d40 = d32 + (d31 * sin4);
                double d41 = cos;
                double d42 = sin;
                path.rLineTo(0.0f, 0.0f);
                float f10 = (float) (d35 - (sin4 * d37));
                float f11 = (float) (d36 - (sin4 * d38));
                path.cubicTo((float) d40, (float) (d33 + (d30 * sin4)), f10, f11, (float) d35, (float) d36);
                i10++;
                d28 = d28;
                sin = d42;
                d32 = d35;
                d24 = d24;
                cos = d41;
                d29 = d34;
                d30 = d38;
                d31 = d37;
                ceil = ceil;
                d33 = d36;
                d19 = d12;
            }
        }

        public static void c(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
            double d10;
            double d11;
            boolean z12;
            float f17 = f10;
            float f18 = f12;
            float f19 = f14;
            boolean z13 = z11;
            double radians = Math.toRadians((double) f16);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d12 = (double) f17;
            Double.isNaN(d12);
            double d13 = d12 * cos;
            double d14 = d12;
            double d15 = (double) f11;
            Double.isNaN(d15);
            double d16 = (double) f19;
            Double.isNaN(d16);
            double d17 = (d13 + (d15 * sin)) / d16;
            double d18 = (double) (-f17);
            Double.isNaN(d18);
            Double.isNaN(d15);
            double d19 = (d18 * sin) + (d15 * cos);
            double d20 = d15;
            double d21 = (double) f15;
            Double.isNaN(d21);
            double d22 = (double) f18;
            Double.isNaN(d22);
            double d23 = d19 / d21;
            double d24 = (double) f13;
            Double.isNaN(d24);
            Double.isNaN(d16);
            double d25 = ((d22 * cos) + (d24 * sin)) / d16;
            double d26 = d16;
            double d27 = (double) (-f18);
            Double.isNaN(d27);
            Double.isNaN(d24);
            Double.isNaN(d21);
            double d28 = ((d27 * sin) + (d24 * cos)) / d21;
            double d29 = d17 - d25;
            double d30 = d23 - d28;
            double d31 = (d17 + d25) / 2.0d;
            double d32 = (d23 + d28) / 2.0d;
            double d33 = sin;
            double d34 = (d29 * d29) + (d30 * d30);
            if (d34 != 0.0d) {
                double d35 = (1.0d / d34) - 0.25d;
                if (d35 < 0.0d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Points are too far apart ");
                    sb.append(d34);
                    float sqrt = (float) (Math.sqrt(d34) / 1.99999d);
                    c(path, f10, f11, f12, f13, f19 * sqrt, f15 * sqrt, f16, z10, z11);
                    return;
                }
                double sqrt2 = Math.sqrt(d35);
                double d36 = d29 * sqrt2;
                double d37 = sqrt2 * d30;
                boolean z14 = z11;
                if (z10 == z14) {
                    d11 = d31 - d37;
                    d10 = d32 + d36;
                } else {
                    d11 = d31 + d37;
                    d10 = d32 - d36;
                }
                double atan2 = Math.atan2(d23 - d10, d17 - d11);
                double atan22 = Math.atan2(d28 - d10, d25 - d11) - atan2;
                if (atan22 >= 0.0d) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z14 != z12) {
                    if (atan22 > 0.0d) {
                        atan22 -= 6.283185307179586d;
                    } else {
                        atan22 += 6.283185307179586d;
                    }
                }
                Double.isNaN(d26);
                double d38 = d11 * d26;
                Double.isNaN(d21);
                double d39 = d10 * d21;
                b(path, (d38 * cos) - (d39 * d33), (d38 * d33) + (d39 * cos), d26, d21, d14, d20, radians, atan2, atan22);
            }
        }

        public static void e(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c10 = 'm';
            for (int i10 = 0; i10 < bVarArr.length; i10++) {
                b bVar = bVarArr[i10];
                a(path, fArr, c10, bVar.f8949a, bVar.f8950b);
                c10 = bVarArr[i10].f8949a;
            }
        }

        public void d(b bVar, b bVar2, float f10) {
            this.f8949a = bVar.f8949a;
            int i10 = 0;
            while (true) {
                float[] fArr = bVar.f8950b;
                if (i10 < fArr.length) {
                    this.f8950b[i10] = (fArr[i10] * (1.0f - f10)) + (bVar2.f8950b[i10] * f10);
                    i10++;
                } else {
                    return;
                }
            }
        }

        public b(b bVar) {
            this.f8949a = bVar.f8949a;
            float[] fArr = bVar.f8950b;
            this.f8950b = d.c(fArr, 0, fArr.length);
        }
    }
}
