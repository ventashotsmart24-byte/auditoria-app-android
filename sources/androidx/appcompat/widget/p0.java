package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.widget.b;
import java.lang.ref.WeakReference;
import q.h;

public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f1308a;

    /* renamed from: b  reason: collision with root package name */
    public p2 f1309b;

    /* renamed from: c  reason: collision with root package name */
    public p2 f1310c;

    /* renamed from: d  reason: collision with root package name */
    public p2 f1311d;

    /* renamed from: e  reason: collision with root package name */
    public p2 f1312e;

    /* renamed from: f  reason: collision with root package name */
    public p2 f1313f;

    /* renamed from: g  reason: collision with root package name */
    public p2 f1314g;

    /* renamed from: h  reason: collision with root package name */
    public p2 f1315h;

    /* renamed from: i  reason: collision with root package name */
    public final e1 f1316i;

    /* renamed from: j  reason: collision with root package name */
    public int f1317j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f1318k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f1319l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1320m;

    public static class a extends h.c {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f1321a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1322b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1323c;

        /* renamed from: androidx.appcompat.widget.p0$a$a  reason: collision with other inner class name */
        public class C0017a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference f1324a;

            /* renamed from: b  reason: collision with root package name */
            public final Typeface f1325b;

            public C0017a(WeakReference weakReference, Typeface typeface) {
                this.f1324a = weakReference;
                this.f1325b = typeface;
            }

            public void run() {
                p0 p0Var = (p0) this.f1324a.get();
                if (p0Var != null) {
                    p0Var.B(this.f1325b);
                }
            }
        }

        public a(p0 p0Var, int i10, int i11) {
            this.f1321a = new WeakReference(p0Var);
            this.f1322b = i10;
            this.f1323c = i11;
        }

        public void onFontRetrievalFailed(int i10) {
        }

        public void onFontRetrieved(Typeface typeface) {
            int i10;
            boolean z10;
            p0 p0Var = (p0) this.f1321a.get();
            if (p0Var != null) {
                if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f1322b) != -1) {
                    if ((this.f1323c & 2) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    typeface = Typeface.create(typeface, i10, z10);
                }
                p0Var.q(new C0017a(this.f1321a, typeface));
            }
        }
    }

    public p0(TextView textView) {
        this.f1308a = textView;
        this.f1316i = new e1(textView);
    }

    public static p2 d(Context context, k kVar, int i10) {
        ColorStateList f10 = kVar.f(context, i10);
        if (f10 == null) {
            return null;
        }
        p2 p2Var = new p2();
        p2Var.f1330d = true;
        p2Var.f1327a = f10;
        return p2Var;
    }

    public final void A(int i10, float f10) {
        this.f1316i.v(i10, f10);
    }

    public void B(Typeface typeface) {
        if (this.f1320m) {
            this.f1308a.setTypeface(typeface);
            this.f1319l = typeface;
        }
    }

    public final void C(Context context, r2 r2Var) {
        String o10;
        boolean z10;
        boolean z11;
        this.f1317j = r2Var.k(R$styleable.TextAppearance_android_textStyle, this.f1317j);
        int i10 = Build.VERSION.SDK_INT;
        boolean z12 = false;
        if (i10 >= 28) {
            int k10 = r2Var.k(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f1318k = k10;
            if (k10 != -1) {
                this.f1317j = (this.f1317j & 2) | 0;
            }
        }
        int i11 = R$styleable.TextAppearance_android_fontFamily;
        if (r2Var.r(i11) || r2Var.r(R$styleable.TextAppearance_fontFamily)) {
            this.f1319l = null;
            int i12 = R$styleable.TextAppearance_fontFamily;
            if (r2Var.r(i12)) {
                i11 = i12;
            }
            int i13 = this.f1318k;
            int i14 = this.f1317j;
            if (!context.isRestricted()) {
                try {
                    Typeface j10 = r2Var.j(i11, this.f1317j, new a(this, i13, i14));
                    if (j10 != null) {
                        if (i10 < 28 || this.f1318k == -1) {
                            this.f1319l = j10;
                        } else {
                            Typeface create = Typeface.create(j10, 0);
                            int i15 = this.f1318k;
                            if ((this.f1317j & 2) != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            this.f1319l = Typeface.create(create, i15, z11);
                        }
                    }
                    if (this.f1319l == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    this.f1320m = z10;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1319l == null && (o10 = r2Var.o(i11)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1318k == -1) {
                    this.f1319l = Typeface.create(o10, this.f1317j);
                    return;
                }
                Typeface create2 = Typeface.create(o10, 0);
                int i16 = this.f1318k;
                if ((this.f1317j & 2) != 0) {
                    z12 = true;
                }
                this.f1319l = Typeface.create(create2, i16, z12);
                return;
            }
            return;
        }
        int i17 = R$styleable.TextAppearance_android_typeface;
        if (r2Var.r(i17)) {
            this.f1320m = false;
            int k11 = r2Var.k(i17, 1);
            if (k11 == 1) {
                this.f1319l = Typeface.SANS_SERIF;
            } else if (k11 == 2) {
                this.f1319l = Typeface.SERIF;
            } else if (k11 == 3) {
                this.f1319l = Typeface.MONOSPACE;
            }
        }
    }

    public final void a(Drawable drawable, p2 p2Var) {
        if (drawable != null && p2Var != null) {
            k.i(drawable, p2Var, this.f1308a.getDrawableState());
        }
    }

    public void b() {
        if (!(this.f1309b == null && this.f1310c == null && this.f1311d == null && this.f1312e == null)) {
            Drawable[] compoundDrawables = this.f1308a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1309b);
            a(compoundDrawables[1], this.f1310c);
            a(compoundDrawables[2], this.f1311d);
            a(compoundDrawables[3], this.f1312e);
        }
        if (this.f1313f != null || this.f1314g != null) {
            Drawable[] compoundDrawablesRelative = this.f1308a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f1313f);
            a(compoundDrawablesRelative[2], this.f1314g);
        }
    }

    public void c() {
        this.f1316i.a();
    }

    public int e() {
        return this.f1316i.h();
    }

    public int f() {
        return this.f1316i.i();
    }

    public int g() {
        return this.f1316i.j();
    }

    public int[] h() {
        return this.f1316i.k();
    }

    public int i() {
        return this.f1316i.l();
    }

    public ColorStateList j() {
        p2 p2Var = this.f1315h;
        if (p2Var != null) {
            return p2Var.f1327a;
        }
        return null;
    }

    public PorterDuff.Mode k() {
        p2 p2Var = this.f1315h;
        if (p2Var != null) {
            return p2Var.f1328b;
        }
        return null;
    }

    public boolean l() {
        return this.f1316i.p();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
            r23 = this;
            r7 = r23
            r0 = r24
            r1 = r25
            android.widget.TextView r2 = r7.f1308a
            android.content.Context r2 = r2.getContext()
            androidx.appcompat.widget.k r3 = androidx.appcompat.widget.k.b()
            int[] r4 = androidx.appcompat.R$styleable.f552m
            r5 = 0
            androidx.appcompat.widget.r2 r4 = androidx.appcompat.widget.r2.u(r2, r0, r4, r1, r5)
            int r6 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_textAppearance
            r8 = -1
            int r6 = r4.n(r6, r8)
            int r9 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableLeft
            boolean r10 = r4.r(r9)
            if (r10 == 0) goto L_0x0030
            int r9 = r4.n(r9, r5)
            androidx.appcompat.widget.p2 r9 = d(r2, r3, r9)
            r7.f1309b = r9
        L_0x0030:
            int r9 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableTop
            boolean r10 = r4.r(r9)
            if (r10 == 0) goto L_0x0042
            int r9 = r4.n(r9, r5)
            androidx.appcompat.widget.p2 r9 = d(r2, r3, r9)
            r7.f1310c = r9
        L_0x0042:
            int r9 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableRight
            boolean r10 = r4.r(r9)
            if (r10 == 0) goto L_0x0054
            int r9 = r4.n(r9, r5)
            androidx.appcompat.widget.p2 r9 = d(r2, r3, r9)
            r7.f1311d = r9
        L_0x0054:
            int r9 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableBottom
            boolean r10 = r4.r(r9)
            if (r10 == 0) goto L_0x0066
            int r9 = r4.n(r9, r5)
            androidx.appcompat.widget.p2 r9 = d(r2, r3, r9)
            r7.f1312e = r9
        L_0x0066:
            int r9 = android.os.Build.VERSION.SDK_INT
            int r10 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableStart
            boolean r11 = r4.r(r10)
            if (r11 == 0) goto L_0x007a
            int r10 = r4.n(r10, r5)
            androidx.appcompat.widget.p2 r10 = d(r2, r3, r10)
            r7.f1313f = r10
        L_0x007a:
            int r10 = androidx.appcompat.R$styleable.AppCompatTextHelper_android_drawableEnd
            boolean r11 = r4.r(r10)
            if (r11 == 0) goto L_0x008c
            int r10 = r4.n(r10, r5)
            androidx.appcompat.widget.p2 r10 = d(r2, r3, r10)
            r7.f1314g = r10
        L_0x008c:
            r4.v()
            android.widget.TextView r4 = r7.f1308a
            android.text.method.TransformationMethod r4 = r4.getTransformationMethod()
            boolean r4 = r4 instanceof android.text.method.PasswordTransformationMethod
            r10 = 26
            r12 = 23
            if (r6 == r8) goto L_0x010a
            int[] r14 = androidx.appcompat.R$styleable.L
            androidx.appcompat.widget.r2 r6 = androidx.appcompat.widget.r2.s(r2, r6, r14)
            if (r4 != 0) goto L_0x00b3
            int r14 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r15 = r6.r(r14)
            if (r15 == 0) goto L_0x00b3
            boolean r14 = r6.a(r14, r5)
            r15 = 1
            goto L_0x00b5
        L_0x00b3:
            r14 = 0
            r15 = 0
        L_0x00b5:
            r7.C(r2, r6)
            if (r9 >= r12) goto L_0x00e5
            int r11 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            boolean r17 = r6.r(r11)
            if (r17 == 0) goto L_0x00c7
            android.content.res.ColorStateList r11 = r6.c(r11)
            goto L_0x00c8
        L_0x00c7:
            r11 = 0
        L_0x00c8:
            int r13 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            boolean r18 = r6.r(r13)
            if (r18 == 0) goto L_0x00d5
            android.content.res.ColorStateList r13 = r6.c(r13)
            goto L_0x00d6
        L_0x00d5:
            r13 = 0
        L_0x00d6:
            int r8 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            boolean r19 = r6.r(r8)
            if (r19 == 0) goto L_0x00e3
            android.content.res.ColorStateList r8 = r6.c(r8)
            goto L_0x00e8
        L_0x00e3:
            r8 = 0
            goto L_0x00e8
        L_0x00e5:
            r8 = 0
            r11 = 0
            r13 = 0
        L_0x00e8:
            int r12 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            boolean r20 = r6.r(r12)
            if (r20 == 0) goto L_0x00f5
            java.lang.String r12 = r6.o(r12)
            goto L_0x00f6
        L_0x00f5:
            r12 = 0
        L_0x00f6:
            if (r9 < r10) goto L_0x0105
            int r10 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            boolean r21 = r6.r(r10)
            if (r21 == 0) goto L_0x0105
            java.lang.String r10 = r6.o(r10)
            goto L_0x0106
        L_0x0105:
            r10 = 0
        L_0x0106:
            r6.v()
            goto L_0x0111
        L_0x010a:
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0111:
            int[] r6 = androidx.appcompat.R$styleable.L
            androidx.appcompat.widget.r2 r6 = androidx.appcompat.widget.r2.u(r2, r0, r6, r1, r5)
            if (r4 != 0) goto L_0x012c
            int r5 = androidx.appcompat.R$styleable.TextAppearance_textAllCaps
            boolean r22 = r6.r(r5)
            if (r22 == 0) goto L_0x012c
            r22 = r8
            r8 = 0
            boolean r14 = r6.a(r5, r8)
            r5 = 23
            r15 = 1
            goto L_0x0130
        L_0x012c:
            r22 = r8
            r5 = 23
        L_0x0130:
            if (r9 >= r5) goto L_0x0157
            int r5 = androidx.appcompat.R$styleable.TextAppearance_android_textColor
            boolean r8 = r6.r(r5)
            if (r8 == 0) goto L_0x013e
            android.content.res.ColorStateList r11 = r6.c(r5)
        L_0x013e:
            int r5 = androidx.appcompat.R$styleable.TextAppearance_android_textColorHint
            boolean r8 = r6.r(r5)
            if (r8 == 0) goto L_0x014a
            android.content.res.ColorStateList r13 = r6.c(r5)
        L_0x014a:
            int r5 = androidx.appcompat.R$styleable.TextAppearance_android_textColorLink
            boolean r8 = r6.r(r5)
            if (r8 == 0) goto L_0x0157
            android.content.res.ColorStateList r8 = r6.c(r5)
            goto L_0x0159
        L_0x0157:
            r8 = r22
        L_0x0159:
            int r5 = androidx.appcompat.R$styleable.TextAppearance_textLocale
            boolean r16 = r6.r(r5)
            if (r16 == 0) goto L_0x0165
            java.lang.String r12 = r6.o(r5)
        L_0x0165:
            r5 = 26
            if (r9 < r5) goto L_0x0175
            int r5 = androidx.appcompat.R$styleable.TextAppearance_fontVariationSettings
            boolean r16 = r6.r(r5)
            if (r16 == 0) goto L_0x0175
            java.lang.String r10 = r6.o(r5)
        L_0x0175:
            r5 = 28
            if (r9 < r5) goto L_0x0192
            int r5 = androidx.appcompat.R$styleable.TextAppearance_android_textSize
            boolean r16 = r6.r(r5)
            if (r16 == 0) goto L_0x0192
            r16 = r3
            r3 = -1
            int r5 = r6.f(r5, r3)
            if (r5 != 0) goto L_0x0194
            android.widget.TextView r3 = r7.f1308a
            r5 = 0
            r0 = 0
            r3.setTextSize(r0, r5)
            goto L_0x0194
        L_0x0192:
            r16 = r3
        L_0x0194:
            r7.C(r2, r6)
            r6.v()
            if (r11 == 0) goto L_0x01a1
            android.widget.TextView r0 = r7.f1308a
            r0.setTextColor(r11)
        L_0x01a1:
            if (r13 == 0) goto L_0x01a8
            android.widget.TextView r0 = r7.f1308a
            r0.setHintTextColor(r13)
        L_0x01a8:
            if (r8 == 0) goto L_0x01af
            android.widget.TextView r0 = r7.f1308a
            r0.setLinkTextColor(r8)
        L_0x01af:
            if (r4 != 0) goto L_0x01b6
            if (r15 == 0) goto L_0x01b6
            r7.r(r14)
        L_0x01b6:
            android.graphics.Typeface r0 = r7.f1319l
            if (r0 == 0) goto L_0x01cc
            int r3 = r7.f1318k
            r4 = -1
            if (r3 != r4) goto L_0x01c7
            android.widget.TextView r3 = r7.f1308a
            int r4 = r7.f1317j
            r3.setTypeface(r0, r4)
            goto L_0x01cc
        L_0x01c7:
            android.widget.TextView r3 = r7.f1308a
            r3.setTypeface(r0)
        L_0x01cc:
            if (r10 == 0) goto L_0x01d3
            android.widget.TextView r0 = r7.f1308a
            boolean unused = r0.setFontVariationSettings(r10)
        L_0x01d3:
            if (r12 == 0) goto L_0x01fb
            r0 = 24
            if (r9 < r0) goto L_0x01e3
            android.widget.TextView r0 = r7.f1308a
            android.os.LocaleList r3 = android.os.LocaleList.forLanguageTags(r12)
            r0.setTextLocales(r3)
            goto L_0x01fb
        L_0x01e3:
            r0 = 21
            if (r9 < r0) goto L_0x01fb
            r0 = 44
            int r0 = r12.indexOf(r0)
            r3 = 0
            java.lang.String r0 = r12.substring(r3, r0)
            android.widget.TextView r3 = r7.f1308a
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            r3.setTextLocale(r0)
        L_0x01fb:
            androidx.appcompat.widget.e1 r0 = r7.f1316i
            r3 = r24
            r0.q(r3, r1)
            boolean r0 = androidx.core.widget.b.P
            if (r0 == 0) goto L_0x0243
            androidx.appcompat.widget.e1 r0 = r7.f1316i
            int r0 = r0.l()
            if (r0 == 0) goto L_0x0243
            androidx.appcompat.widget.e1 r0 = r7.f1316i
            int[] r0 = r0.k()
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0243
            android.widget.TextView r1 = r7.f1308a
            int r1 = r1.getAutoSizeStepGranularity()
            float r1 = (float) r1
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x023d
            android.widget.TextView r0 = r7.f1308a
            androidx.appcompat.widget.e1 r1 = r7.f1316i
            int r1 = r1.i()
            androidx.appcompat.widget.e1 r4 = r7.f1316i
            int r4 = r4.h()
            androidx.appcompat.widget.e1 r5 = r7.f1316i
            int r5 = r5.j()
            r6 = 0
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r4, r5, r6)
            goto L_0x0243
        L_0x023d:
            r6 = 0
            android.widget.TextView r1 = r7.f1308a
            r1.setAutoSizeTextTypeUniformWithPresetSizes(r0, r6)
        L_0x0243:
            int[] r0 = androidx.appcompat.R$styleable.f553n
            androidx.appcompat.widget.r2 r8 = androidx.appcompat.widget.r2.t(r2, r3, r0)
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.n(r0, r1)
            r3 = r16
            if (r0 == r1) goto L_0x025a
            android.graphics.drawable.Drawable r0 = r3.c(r2, r0)
            r4 = r0
            goto L_0x025b
        L_0x025a:
            r4 = 0
        L_0x025b:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTopCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0269
            android.graphics.drawable.Drawable r0 = r3.c(r2, r0)
            r5 = r0
            goto L_0x026a
        L_0x0269:
            r5 = 0
        L_0x026a:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableRightCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0278
            android.graphics.drawable.Drawable r0 = r3.c(r2, r0)
            r6 = r0
            goto L_0x0279
        L_0x0278:
            r6 = 0
        L_0x0279:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableBottomCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0287
            android.graphics.drawable.Drawable r0 = r3.c(r2, r0)
            r9 = r0
            goto L_0x0288
        L_0x0287:
            r9 = 0
        L_0x0288:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableStartCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x0296
            android.graphics.drawable.Drawable r0 = r3.c(r2, r0)
            r10 = r0
            goto L_0x0297
        L_0x0296:
            r10 = 0
        L_0x0297:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableEndCompat
            int r0 = r8.n(r0, r1)
            if (r0 == r1) goto L_0x02a5
            android.graphics.drawable.Drawable r0 = r3.c(r2, r0)
            r11 = r0
            goto L_0x02a6
        L_0x02a5:
            r11 = 0
        L_0x02a6:
            r0 = r23
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r9
            r5 = r10
            r6 = r11
            r0.x(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTint
            boolean r1 = r8.r(r0)
            if (r1 == 0) goto L_0x02c2
            android.content.res.ColorStateList r0 = r8.c(r0)
            android.widget.TextView r1 = r7.f1308a
            androidx.core.widget.e0.h(r1, r0)
        L_0x02c2:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_drawableTintMode
            boolean r1 = r8.r(r0)
            if (r1 == 0) goto L_0x02da
            r1 = -1
            int r0 = r8.k(r0, r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.o1.e(r0, r2)
            android.widget.TextView r2 = r7.f1308a
            androidx.core.widget.e0.i(r2, r0)
            goto L_0x02db
        L_0x02da:
            r1 = -1
        L_0x02db:
            int r0 = androidx.appcompat.R$styleable.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.f(r0, r1)
            int r2 = androidx.appcompat.R$styleable.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.f(r2, r1)
            int r3 = androidx.appcompat.R$styleable.AppCompatTextView_lineHeight
            int r3 = r8.f(r3, r1)
            r8.v()
            if (r0 == r1) goto L_0x02f7
            android.widget.TextView r4 = r7.f1308a
            androidx.core.widget.e0.k(r4, r0)
        L_0x02f7:
            if (r2 == r1) goto L_0x02fe
            android.widget.TextView r0 = r7.f1308a
            androidx.core.widget.e0.l(r0, r2)
        L_0x02fe:
            if (r3 == r1) goto L_0x0305
            android.widget.TextView r0 = r7.f1308a
            androidx.core.widget.e0.m(r0, r3)
        L_0x0305:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.p0.m(android.util.AttributeSet, int):void");
    }

    public void n(boolean z10, int i10, int i11, int i12, int i13) {
        if (!b.P) {
            c();
        }
    }

    public void o() {
        b();
    }

    public void p(Context context, int i10) {
        String o10;
        ColorStateList c10;
        r2 s10 = r2.s(context, i10, R$styleable.L);
        int i11 = R$styleable.TextAppearance_textAllCaps;
        if (s10.r(i11)) {
            r(s10.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = R$styleable.TextAppearance_android_textColor;
            if (s10.r(i13) && (c10 = s10.c(i13)) != null) {
                this.f1308a.setTextColor(c10);
            }
        }
        int i14 = R$styleable.TextAppearance_android_textSize;
        if (s10.r(i14) && s10.f(i14, -1) == 0) {
            this.f1308a.setTextSize(0, 0.0f);
        }
        C(context, s10);
        if (i12 >= 26) {
            int i15 = R$styleable.TextAppearance_fontVariationSettings;
            if (s10.r(i15) && (o10 = s10.o(i15)) != null) {
                boolean unused = this.f1308a.setFontVariationSettings(o10);
            }
        }
        s10.v();
        Typeface typeface = this.f1319l;
        if (typeface != null) {
            this.f1308a.setTypeface(typeface, this.f1317j);
        }
    }

    public void q(Runnable runnable) {
        this.f1308a.post(runnable);
    }

    public void r(boolean z10) {
        this.f1308a.setAllCaps(z10);
    }

    public void s(int i10, int i11, int i12, int i13) {
        this.f1316i.r(i10, i11, i12, i13);
    }

    public void t(int[] iArr, int i10) {
        this.f1316i.s(iArr, i10);
    }

    public void u(int i10) {
        this.f1316i.t(i10);
    }

    public void v(ColorStateList colorStateList) {
        boolean z10;
        if (this.f1315h == null) {
            this.f1315h = new p2();
        }
        p2 p2Var = this.f1315h;
        p2Var.f1327a = colorStateList;
        if (colorStateList != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p2Var.f1330d = z10;
        y();
    }

    public void w(PorterDuff.Mode mode) {
        boolean z10;
        if (this.f1315h == null) {
            this.f1315h = new p2();
        }
        p2 p2Var = this.f1315h;
        p2Var.f1328b = mode;
        if (mode != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p2Var.f1329c = z10;
        y();
    }

    public final void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.f1308a.getCompoundDrawablesRelative();
            TextView textView = this.f1308a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = this.f1308a.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.f1308a.getCompoundDrawables();
                TextView textView2 = this.f1308a;
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                return;
            }
            TextView textView3 = this.f1308a;
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            Drawable drawable8 = compoundDrawablesRelative2[2];
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
        }
    }

    public final void y() {
        p2 p2Var = this.f1315h;
        this.f1309b = p2Var;
        this.f1310c = p2Var;
        this.f1311d = p2Var;
        this.f1312e = p2Var;
        this.f1313f = p2Var;
        this.f1314g = p2Var;
    }

    public void z(int i10, float f10) {
        if (!b.P && !l()) {
            A(i10, f10);
        }
    }
}
