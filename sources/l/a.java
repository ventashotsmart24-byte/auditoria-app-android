package l;

import java.util.Arrays;
import l.i;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f7531a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final b f7532b;

    /* renamed from: c  reason: collision with root package name */
    public final c f7533c;

    /* renamed from: d  reason: collision with root package name */
    public int f7534d = 8;

    /* renamed from: e  reason: collision with root package name */
    public i f7535e = null;

    /* renamed from: f  reason: collision with root package name */
    public int[] f7536f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    public int[] f7537g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    public float[] f7538h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    public int f7539i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f7540j = -1;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7541k = false;

    public a(b bVar, c cVar) {
        this.f7532b = bVar;
        this.f7533c = cVar;
    }

    public final void a(i iVar, float f10, boolean z10) {
        if (f10 != 0.0f) {
            int i10 = this.f7539i;
            if (i10 == -1) {
                this.f7539i = 0;
                this.f7538h[0] = f10;
                this.f7536f[0] = iVar.f7571b;
                this.f7537g[0] = -1;
                iVar.f7579j++;
                iVar.a(this.f7532b);
                this.f7531a++;
                if (!this.f7541k) {
                    int i11 = this.f7540j + 1;
                    this.f7540j = i11;
                    int[] iArr = this.f7536f;
                    if (i11 >= iArr.length) {
                        this.f7541k = true;
                        this.f7540j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            int i13 = -1;
            while (i10 != -1 && i12 < this.f7531a) {
                int i14 = this.f7536f[i10];
                int i15 = iVar.f7571b;
                if (i14 == i15) {
                    float[] fArr = this.f7538h;
                    float f11 = fArr[i10] + f10;
                    fArr[i10] = f11;
                    if (f11 == 0.0f) {
                        if (i10 == this.f7539i) {
                            this.f7539i = this.f7537g[i10];
                        } else {
                            int[] iArr2 = this.f7537g;
                            iArr2[i13] = iArr2[i10];
                        }
                        if (z10) {
                            iVar.c(this.f7532b);
                        }
                        if (this.f7541k) {
                            this.f7540j = i10;
                        }
                        iVar.f7579j--;
                        this.f7531a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i13 = i10;
                }
                i10 = this.f7537g[i10];
                i12++;
            }
            int i16 = this.f7540j;
            int i17 = i16 + 1;
            if (this.f7541k) {
                int[] iArr3 = this.f7536f;
                if (iArr3[i16] != -1) {
                    i16 = iArr3.length;
                }
            } else {
                i16 = i17;
            }
            int[] iArr4 = this.f7536f;
            if (i16 >= iArr4.length && this.f7531a < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.f7536f;
                    if (i18 >= iArr5.length) {
                        break;
                    } else if (iArr5[i18] == -1) {
                        i16 = i18;
                        break;
                    } else {
                        i18++;
                    }
                }
            }
            int[] iArr6 = this.f7536f;
            if (i16 >= iArr6.length) {
                i16 = iArr6.length;
                int i19 = this.f7534d * 2;
                this.f7534d = i19;
                this.f7541k = false;
                this.f7540j = i16 - 1;
                this.f7538h = Arrays.copyOf(this.f7538h, i19);
                this.f7536f = Arrays.copyOf(this.f7536f, this.f7534d);
                this.f7537g = Arrays.copyOf(this.f7537g, this.f7534d);
            }
            this.f7536f[i16] = iVar.f7571b;
            this.f7538h[i16] = f10;
            if (i13 != -1) {
                int[] iArr7 = this.f7537g;
                iArr7[i16] = iArr7[i13];
                iArr7[i13] = i16;
            } else {
                this.f7537g[i16] = this.f7539i;
                this.f7539i = i16;
            }
            iVar.f7579j++;
            iVar.a(this.f7532b);
            this.f7531a++;
            if (!this.f7541k) {
                this.f7540j++;
            }
            int i20 = this.f7540j;
            int[] iArr8 = this.f7536f;
            if (i20 >= iArr8.length) {
                this.f7541k = true;
                this.f7540j = iArr8.length - 1;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0090 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l.i b(l.e r15) {
        /*
            r14 = this;
            int r0 = r14.f7539i
            r1 = 0
            r2 = 0
            r3 = 0
            r3 = r1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000b:
            r9 = -1
            if (r0 == r9) goto L_0x0098
            int r9 = r14.f7531a
            if (r4 >= r9) goto L_0x0098
            float[] r9 = r14.f7538h
            r10 = r9[r0]
            l.c r11 = r14.f7533c
            l.i[] r11 = r11.f7549c
            int[] r12 = r14.f7536f
            r12 = r12[r0]
            r11 = r11[r12]
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0033
            r12 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x0042
            r9[r0] = r2
            l.b r9 = r14.f7532b
            r11.c(r9)
            goto L_0x0041
        L_0x0033:
            r12 = 981668463(0x3a83126f, float:0.001)
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x0042
            r9[r0] = r2
            l.b r9 = r14.f7532b
            r11.c(r9)
        L_0x0041:
            r10 = 0
        L_0x0042:
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x0090
            l.i$a r9 = r11.f7576g
            l.i$a r12 = l.i.a.UNRESTRICTED
            r13 = 1
            if (r9 != r12) goto L_0x006c
            if (r3 != 0) goto L_0x0057
            boolean r3 = r14.k(r11, r15)
        L_0x0053:
            r5 = r3
            r7 = r10
            r3 = r11
            goto L_0x0090
        L_0x0057:
            int r9 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0060
            boolean r3 = r14.k(r11, r15)
            goto L_0x0053
        L_0x0060:
            if (r5 != 0) goto L_0x0090
            boolean r9 = r14.k(r11, r15)
            if (r9 == 0) goto L_0x0090
            r7 = r10
            r3 = r11
            r5 = 1
            goto L_0x0090
        L_0x006c:
            if (r3 != 0) goto L_0x0090
            int r9 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x0090
            if (r1 != 0) goto L_0x007c
            boolean r1 = r14.k(r11, r15)
        L_0x0078:
            r6 = r1
            r8 = r10
            r1 = r11
            goto L_0x0090
        L_0x007c:
            int r9 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0085
            boolean r1 = r14.k(r11, r15)
            goto L_0x0078
        L_0x0085:
            if (r6 != 0) goto L_0x0090
            boolean r9 = r14.k(r11, r15)
            if (r9 == 0) goto L_0x0090
            r8 = r10
            r1 = r11
            r6 = 1
        L_0x0090:
            int[] r9 = r14.f7537g
            r0 = r9[r0]
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0098:
            if (r3 == 0) goto L_0x009b
            return r3
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l.a.b(l.e):l.i");
    }

    public final void c() {
        int i10 = this.f7539i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f7531a) {
            i iVar = this.f7533c.f7549c[this.f7536f[i10]];
            if (iVar != null) {
                iVar.c(this.f7532b);
            }
            i10 = this.f7537g[i10];
            i11++;
        }
        this.f7539i = -1;
        this.f7540j = -1;
        this.f7541k = false;
        this.f7531a = 0;
    }

    public final boolean d(i iVar) {
        int i10 = this.f7539i;
        if (i10 == -1) {
            return false;
        }
        int i11 = 0;
        while (i10 != -1 && i11 < this.f7531a) {
            if (this.f7536f[i10] == iVar.f7571b) {
                return true;
            }
            i10 = this.f7537g[i10];
            i11++;
        }
        return false;
    }

    public void e(float f10) {
        int i10 = this.f7539i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f7531a) {
            float[] fArr = this.f7538h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f7537g[i10];
            i11++;
        }
    }

    public final float f(i iVar) {
        int i10 = this.f7539i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f7531a) {
            if (this.f7536f[i10] == iVar.f7571b) {
                return this.f7538h[i10];
            }
            i10 = this.f7537g[i10];
            i11++;
        }
        return 0.0f;
    }

    public i g(boolean[] zArr, i iVar) {
        i.a aVar;
        int i10 = this.f7539i;
        int i11 = 0;
        i iVar2 = null;
        float f10 = 0.0f;
        while (i10 != -1 && i11 < this.f7531a) {
            float f11 = this.f7538h[i10];
            if (f11 < 0.0f) {
                i iVar3 = this.f7533c.f7549c[this.f7536f[i10]];
                if ((zArr == null || !zArr[iVar3.f7571b]) && iVar3 != iVar && (((aVar = iVar3.f7576g) == i.a.SLACK || aVar == i.a.f7583d) && f11 < f10)) {
                    f10 = f11;
                    iVar2 = iVar3;
                }
            }
            i10 = this.f7537g[i10];
            i11++;
        }
        return iVar2;
    }

    public final i h(int i10) {
        int i11 = this.f7539i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f7531a) {
            if (i12 == i10) {
                return this.f7533c.f7549c[this.f7536f[i11]];
            }
            i11 = this.f7537g[i11];
            i12++;
        }
        return null;
    }

    public final float i(int i10) {
        int i11 = this.f7539i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f7531a) {
            if (i12 == i10) {
                return this.f7538h[i11];
            }
            i11 = this.f7537g[i11];
            i12++;
        }
        return 0.0f;
    }

    public void j() {
        int i10 = this.f7539i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f7531a) {
            float[] fArr = this.f7538h;
            fArr[i10] = fArr[i10] * -1.0f;
            i10 = this.f7537g[i10];
            i11++;
        }
    }

    public final boolean k(i iVar, e eVar) {
        if (iVar.f7579j <= 1) {
            return true;
        }
        return false;
    }

    public final void l(i iVar, float f10) {
        if (f10 == 0.0f) {
            m(iVar, true);
            return;
        }
        int i10 = this.f7539i;
        if (i10 == -1) {
            this.f7539i = 0;
            this.f7538h[0] = f10;
            this.f7536f[0] = iVar.f7571b;
            this.f7537g[0] = -1;
            iVar.f7579j++;
            iVar.a(this.f7532b);
            this.f7531a++;
            if (!this.f7541k) {
                int i11 = this.f7540j + 1;
                this.f7540j = i11;
                int[] iArr = this.f7536f;
                if (i11 >= iArr.length) {
                    this.f7541k = true;
                    this.f7540j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = 0;
        int i13 = -1;
        while (i10 != -1 && i12 < this.f7531a) {
            int i14 = this.f7536f[i10];
            int i15 = iVar.f7571b;
            if (i14 == i15) {
                this.f7538h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i13 = i10;
            }
            i10 = this.f7537g[i10];
            i12++;
        }
        int i16 = this.f7540j;
        int i17 = i16 + 1;
        if (this.f7541k) {
            int[] iArr2 = this.f7536f;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.f7536f;
        if (i16 >= iArr3.length && this.f7531a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f7536f;
                if (i18 >= iArr4.length) {
                    break;
                } else if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                } else {
                    i18++;
                }
            }
        }
        int[] iArr5 = this.f7536f;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.f7534d * 2;
            this.f7534d = i19;
            this.f7541k = false;
            this.f7540j = i16 - 1;
            this.f7538h = Arrays.copyOf(this.f7538h, i19);
            this.f7536f = Arrays.copyOf(this.f7536f, this.f7534d);
            this.f7537g = Arrays.copyOf(this.f7537g, this.f7534d);
        }
        this.f7536f[i16] = iVar.f7571b;
        this.f7538h[i16] = f10;
        if (i13 != -1) {
            int[] iArr6 = this.f7537g;
            iArr6[i16] = iArr6[i13];
            iArr6[i13] = i16;
        } else {
            this.f7537g[i16] = this.f7539i;
            this.f7539i = i16;
        }
        iVar.f7579j++;
        iVar.a(this.f7532b);
        int i20 = this.f7531a + 1;
        this.f7531a = i20;
        if (!this.f7541k) {
            this.f7540j++;
        }
        int[] iArr7 = this.f7536f;
        if (i20 >= iArr7.length) {
            this.f7541k = true;
        }
        if (this.f7540j >= iArr7.length) {
            this.f7541k = true;
            this.f7540j = iArr7.length - 1;
        }
    }

    public final float m(i iVar, boolean z10) {
        if (this.f7535e == iVar) {
            this.f7535e = null;
        }
        int i10 = this.f7539i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f7531a) {
            if (this.f7536f[i10] == iVar.f7571b) {
                if (i10 == this.f7539i) {
                    this.f7539i = this.f7537g[i10];
                } else {
                    int[] iArr = this.f7537g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    iVar.c(this.f7532b);
                }
                iVar.f7579j--;
                this.f7531a--;
                this.f7536f[i10] = -1;
                if (this.f7541k) {
                    this.f7540j = i10;
                }
                return this.f7538h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f7537g[i10];
        }
        return 0.0f;
    }

    public final void n(b bVar, b bVar2, boolean z10) {
        int i10 = this.f7539i;
        while (true) {
            int i11 = 0;
            while (i10 != -1 && i11 < this.f7531a) {
                int i12 = this.f7536f[i10];
                i iVar = bVar2.f7542a;
                if (i12 == iVar.f7571b) {
                    float f10 = this.f7538h[i10];
                    m(iVar, z10);
                    a aVar = bVar2.f7545d;
                    int i13 = aVar.f7539i;
                    int i14 = 0;
                    while (i13 != -1 && i14 < aVar.f7531a) {
                        a(this.f7533c.f7549c[aVar.f7536f[i13]], aVar.f7538h[i13] * f10, z10);
                        i13 = aVar.f7537g[i13];
                        i14++;
                    }
                    bVar.f7543b += bVar2.f7543b * f10;
                    if (z10) {
                        bVar2.f7542a.c(bVar);
                    }
                    i10 = this.f7539i;
                } else {
                    i10 = this.f7537g[i10];
                    i11++;
                }
            }
            return;
        }
    }

    public void o(b bVar, b[] bVarArr) {
        int i10 = this.f7539i;
        while (true) {
            int i11 = 0;
            while (i10 != -1 && i11 < this.f7531a) {
                i iVar = this.f7533c.f7549c[this.f7536f[i10]];
                if (iVar.f7572c != -1) {
                    float f10 = this.f7538h[i10];
                    m(iVar, true);
                    b bVar2 = bVarArr[iVar.f7572c];
                    if (!bVar2.f7546e) {
                        a aVar = bVar2.f7545d;
                        int i12 = aVar.f7539i;
                        int i13 = 0;
                        while (i12 != -1 && i13 < aVar.f7531a) {
                            a(this.f7533c.f7549c[aVar.f7536f[i12]], aVar.f7538h[i12] * f10, true);
                            i12 = aVar.f7537g[i12];
                            i13++;
                        }
                    }
                    bVar.f7543b += bVar2.f7543b * f10;
                    bVar2.f7542a.c(bVar);
                    i10 = this.f7539i;
                } else {
                    i10 = this.f7537g[i10];
                    i11++;
                }
            }
            return;
        }
    }

    public String toString() {
        int i10 = this.f7539i;
        String str = "";
        int i11 = 0;
        while (i10 != -1 && i11 < this.f7531a) {
            str = ((str + " -> ") + this.f7538h[i10] + " : ") + this.f7533c.f7549c[this.f7536f[i10]];
            i10 = this.f7537g[i10];
            i11++;
        }
        return str;
    }
}
