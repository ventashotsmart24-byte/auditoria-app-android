package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f1660b = {0, 4, 8};

    /* renamed from: c  reason: collision with root package name */
    public static SparseIntArray f1661c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap f1662a = new HashMap();

    /* renamed from: androidx.constraintlayout.widget.b$b  reason: collision with other inner class name */
    public static class C0023b {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1663a;

        /* renamed from: a0  reason: collision with root package name */
        public float f1664a0;

        /* renamed from: b  reason: collision with root package name */
        public int f1665b;

        /* renamed from: b0  reason: collision with root package name */
        public float f1666b0;

        /* renamed from: c  reason: collision with root package name */
        public int f1667c;

        /* renamed from: c0  reason: collision with root package name */
        public float f1668c0;

        /* renamed from: d  reason: collision with root package name */
        public int f1669d;

        /* renamed from: d0  reason: collision with root package name */
        public float f1670d0;

        /* renamed from: e  reason: collision with root package name */
        public int f1671e;

        /* renamed from: e0  reason: collision with root package name */
        public float f1672e0;

        /* renamed from: f  reason: collision with root package name */
        public int f1673f;

        /* renamed from: f0  reason: collision with root package name */
        public float f1674f0;

        /* renamed from: g  reason: collision with root package name */
        public float f1675g;

        /* renamed from: g0  reason: collision with root package name */
        public float f1676g0;

        /* renamed from: h  reason: collision with root package name */
        public int f1677h;

        /* renamed from: h0  reason: collision with root package name */
        public boolean f1678h0;

        /* renamed from: i  reason: collision with root package name */
        public int f1679i;

        /* renamed from: i0  reason: collision with root package name */
        public boolean f1680i0;

        /* renamed from: j  reason: collision with root package name */
        public int f1681j;

        /* renamed from: j0  reason: collision with root package name */
        public int f1682j0;

        /* renamed from: k  reason: collision with root package name */
        public int f1683k;

        /* renamed from: k0  reason: collision with root package name */
        public int f1684k0;

        /* renamed from: l  reason: collision with root package name */
        public int f1685l;

        /* renamed from: l0  reason: collision with root package name */
        public int f1686l0;

        /* renamed from: m  reason: collision with root package name */
        public int f1687m;

        /* renamed from: m0  reason: collision with root package name */
        public int f1688m0;

        /* renamed from: n  reason: collision with root package name */
        public int f1689n;

        /* renamed from: n0  reason: collision with root package name */
        public int f1690n0;

        /* renamed from: o  reason: collision with root package name */
        public int f1691o;

        /* renamed from: o0  reason: collision with root package name */
        public int f1692o0;

        /* renamed from: p  reason: collision with root package name */
        public int f1693p;

        /* renamed from: p0  reason: collision with root package name */
        public float f1694p0;

        /* renamed from: q  reason: collision with root package name */
        public int f1695q;

        /* renamed from: q0  reason: collision with root package name */
        public float f1696q0;

        /* renamed from: r  reason: collision with root package name */
        public int f1697r;

        /* renamed from: r0  reason: collision with root package name */
        public boolean f1698r0;

        /* renamed from: s  reason: collision with root package name */
        public int f1699s;

        /* renamed from: s0  reason: collision with root package name */
        public int f1700s0;

        /* renamed from: t  reason: collision with root package name */
        public int f1701t;

        /* renamed from: t0  reason: collision with root package name */
        public int f1702t0;

        /* renamed from: u  reason: collision with root package name */
        public float f1703u;

        /* renamed from: u0  reason: collision with root package name */
        public int[] f1704u0;

        /* renamed from: v  reason: collision with root package name */
        public float f1705v;

        /* renamed from: v0  reason: collision with root package name */
        public String f1706v0;

        /* renamed from: w  reason: collision with root package name */
        public String f1707w;

        /* renamed from: x  reason: collision with root package name */
        public int f1708x;

        /* renamed from: y  reason: collision with root package name */
        public int f1709y;

        /* renamed from: z  reason: collision with root package name */
        public float f1710z;

        public C0023b() {
            this.f1663a = false;
            this.f1671e = -1;
            this.f1673f = -1;
            this.f1675g = -1.0f;
            this.f1677h = -1;
            this.f1679i = -1;
            this.f1681j = -1;
            this.f1683k = -1;
            this.f1685l = -1;
            this.f1687m = -1;
            this.f1689n = -1;
            this.f1691o = -1;
            this.f1693p = -1;
            this.f1695q = -1;
            this.f1697r = -1;
            this.f1699s = -1;
            this.f1701t = -1;
            this.f1703u = 0.5f;
            this.f1705v = 0.5f;
            this.f1707w = null;
            this.f1708x = -1;
            this.f1709y = 0;
            this.f1710z = 0.0f;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = 0.0f;
            this.R = 0.0f;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = 0.0f;
            this.X = 0.0f;
            this.Y = 0.0f;
            this.Z = 0.0f;
            this.f1664a0 = 1.0f;
            this.f1666b0 = 1.0f;
            this.f1668c0 = Float.NaN;
            this.f1670d0 = Float.NaN;
            this.f1672e0 = 0.0f;
            this.f1674f0 = 0.0f;
            this.f1676g0 = 0.0f;
            this.f1678h0 = false;
            this.f1680i0 = false;
            this.f1682j0 = 0;
            this.f1684k0 = 0;
            this.f1686l0 = -1;
            this.f1688m0 = -1;
            this.f1690n0 = -1;
            this.f1692o0 = -1;
            this.f1694p0 = 1.0f;
            this.f1696q0 = 1.0f;
            this.f1698r0 = false;
            this.f1700s0 = -1;
            this.f1702t0 = -1;
        }

        public void a(ConstraintLayout.a aVar) {
            aVar.f1616d = this.f1677h;
            aVar.f1618e = this.f1679i;
            aVar.f1620f = this.f1681j;
            aVar.f1622g = this.f1683k;
            aVar.f1624h = this.f1685l;
            aVar.f1626i = this.f1687m;
            aVar.f1628j = this.f1689n;
            aVar.f1630k = this.f1691o;
            aVar.f1632l = this.f1693p;
            aVar.f1638p = this.f1695q;
            aVar.f1639q = this.f1697r;
            aVar.f1640r = this.f1699s;
            aVar.f1641s = this.f1701t;
            aVar.leftMargin = this.D;
            aVar.rightMargin = this.E;
            aVar.topMargin = this.F;
            aVar.bottomMargin = this.G;
            aVar.f1646x = this.P;
            aVar.f1647y = this.O;
            aVar.f1648z = this.f1703u;
            aVar.A = this.f1705v;
            aVar.f1634m = this.f1708x;
            aVar.f1636n = this.f1709y;
            aVar.f1637o = this.f1710z;
            aVar.B = this.f1707w;
            aVar.Q = this.A;
            aVar.R = this.B;
            aVar.F = this.Q;
            aVar.E = this.R;
            aVar.H = this.T;
            aVar.G = this.S;
            aVar.T = this.f1678h0;
            aVar.U = this.f1680i0;
            aVar.I = this.f1682j0;
            aVar.J = this.f1684k0;
            aVar.M = this.f1686l0;
            aVar.N = this.f1688m0;
            aVar.K = this.f1690n0;
            aVar.L = this.f1692o0;
            aVar.O = this.f1694p0;
            aVar.P = this.f1696q0;
            aVar.S = this.C;
            aVar.f1614c = this.f1675g;
            aVar.f1610a = this.f1671e;
            aVar.f1612b = this.f1673f;
            aVar.width = this.f1665b;
            aVar.height = this.f1667c;
            aVar.setMarginStart(this.I);
            aVar.setMarginEnd(this.H);
            aVar.a();
        }

        /* renamed from: b */
        public C0023b clone() {
            C0023b bVar = new C0023b();
            bVar.f1663a = this.f1663a;
            bVar.f1665b = this.f1665b;
            bVar.f1667c = this.f1667c;
            bVar.f1671e = this.f1671e;
            bVar.f1673f = this.f1673f;
            bVar.f1675g = this.f1675g;
            bVar.f1677h = this.f1677h;
            bVar.f1679i = this.f1679i;
            bVar.f1681j = this.f1681j;
            bVar.f1683k = this.f1683k;
            bVar.f1685l = this.f1685l;
            bVar.f1687m = this.f1687m;
            bVar.f1689n = this.f1689n;
            bVar.f1691o = this.f1691o;
            bVar.f1693p = this.f1693p;
            bVar.f1695q = this.f1695q;
            bVar.f1697r = this.f1697r;
            bVar.f1699s = this.f1699s;
            bVar.f1701t = this.f1701t;
            bVar.f1703u = this.f1703u;
            bVar.f1705v = this.f1705v;
            bVar.f1707w = this.f1707w;
            bVar.A = this.A;
            bVar.B = this.B;
            bVar.f1703u = this.f1703u;
            bVar.f1703u = this.f1703u;
            bVar.f1703u = this.f1703u;
            bVar.f1703u = this.f1703u;
            bVar.f1703u = this.f1703u;
            bVar.C = this.C;
            bVar.D = this.D;
            bVar.E = this.E;
            bVar.F = this.F;
            bVar.G = this.G;
            bVar.H = this.H;
            bVar.I = this.I;
            bVar.J = this.J;
            bVar.K = this.K;
            bVar.L = this.L;
            bVar.M = this.M;
            bVar.N = this.N;
            bVar.O = this.O;
            bVar.P = this.P;
            bVar.Q = this.Q;
            bVar.R = this.R;
            bVar.S = this.S;
            bVar.T = this.T;
            bVar.U = this.U;
            bVar.V = this.V;
            bVar.W = this.W;
            bVar.X = this.X;
            bVar.Y = this.Y;
            bVar.Z = this.Z;
            bVar.f1664a0 = this.f1664a0;
            bVar.f1666b0 = this.f1666b0;
            bVar.f1668c0 = this.f1668c0;
            bVar.f1670d0 = this.f1670d0;
            bVar.f1672e0 = this.f1672e0;
            bVar.f1674f0 = this.f1674f0;
            bVar.f1676g0 = this.f1676g0;
            bVar.f1678h0 = this.f1678h0;
            bVar.f1680i0 = this.f1680i0;
            bVar.f1682j0 = this.f1682j0;
            bVar.f1684k0 = this.f1684k0;
            bVar.f1686l0 = this.f1686l0;
            bVar.f1688m0 = this.f1688m0;
            bVar.f1690n0 = this.f1690n0;
            bVar.f1692o0 = this.f1692o0;
            bVar.f1694p0 = this.f1694p0;
            bVar.f1696q0 = this.f1696q0;
            bVar.f1700s0 = this.f1700s0;
            bVar.f1702t0 = this.f1702t0;
            int[] iArr = this.f1704u0;
            if (iArr != null) {
                bVar.f1704u0 = Arrays.copyOf(iArr, iArr.length);
            }
            bVar.f1708x = this.f1708x;
            bVar.f1709y = this.f1709y;
            bVar.f1710z = this.f1710z;
            bVar.f1698r0 = this.f1698r0;
            return bVar;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1661c = sparseIntArray;
        sparseIntArray.append(R$styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f1661c.append(R$styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f1661c.append(R$styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f1661c.append(R$styleable.ConstraintSet_android_orientation, 27);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f1661c.append(R$styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f1661c.append(R$styleable.ConstraintSet_layout_goneMarginTop, 16);
        f1661c.append(R$styleable.ConstraintSet_layout_goneMarginRight, 14);
        f1661c.append(R$styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f1661c.append(R$styleable.ConstraintSet_layout_goneMarginStart, 15);
        f1661c.append(R$styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintLeft_creator, 75);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintTop_creator, 75);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintRight_creator, 75);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintBottom_creator, 75);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
        f1661c.append(R$styleable.ConstraintSet_android_layout_marginLeft, 24);
        f1661c.append(R$styleable.ConstraintSet_android_layout_marginRight, 28);
        f1661c.append(R$styleable.ConstraintSet_android_layout_marginStart, 31);
        f1661c.append(R$styleable.ConstraintSet_android_layout_marginEnd, 8);
        f1661c.append(R$styleable.ConstraintSet_android_layout_marginTop, 34);
        f1661c.append(R$styleable.ConstraintSet_android_layout_marginBottom, 2);
        f1661c.append(R$styleable.ConstraintSet_android_layout_width, 23);
        f1661c.append(R$styleable.ConstraintSet_android_layout_height, 21);
        f1661c.append(R$styleable.ConstraintSet_android_visibility, 22);
        f1661c.append(R$styleable.ConstraintSet_android_alpha, 43);
        f1661c.append(R$styleable.ConstraintSet_android_elevation, 44);
        f1661c.append(R$styleable.ConstraintSet_android_rotationX, 45);
        f1661c.append(R$styleable.ConstraintSet_android_rotationY, 46);
        f1661c.append(R$styleable.ConstraintSet_android_rotation, 60);
        f1661c.append(R$styleable.ConstraintSet_android_scaleX, 47);
        f1661c.append(R$styleable.ConstraintSet_android_scaleY, 48);
        f1661c.append(R$styleable.ConstraintSet_android_transformPivotX, 49);
        f1661c.append(R$styleable.ConstraintSet_android_transformPivotY, 50);
        f1661c.append(R$styleable.ConstraintSet_android_translationX, 51);
        f1661c.append(R$styleable.ConstraintSet_android_translationY, 52);
        f1661c.append(R$styleable.ConstraintSet_android_translationZ, 53);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintCircle, 61);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f1661c.append(R$styleable.ConstraintSet_android_id, 38);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintWidth_percent, 69);
        f1661c.append(R$styleable.ConstraintSet_layout_constraintHeight_percent, 70);
        f1661c.append(R$styleable.ConstraintSet_chainUseRtl, 71);
        f1661c.append(R$styleable.ConstraintSet_barrierDirection, 72);
        f1661c.append(R$styleable.ConstraintSet_constraint_referenced_ids, 73);
        f1661c.append(R$styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    public static int e(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        if (resourceId == -1) {
            return typedArray.getInt(i10, -1);
        }
        return resourceId;
    }

    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1662a.keySet());
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f1662a.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    C0023b bVar = (C0023b) this.f1662a.get(Integer.valueOf(id));
                    if (childAt instanceof n.a) {
                        bVar.f1702t0 = 1;
                    }
                    int i11 = bVar.f1702t0;
                    if (i11 != -1 && i11 == 1) {
                        n.a aVar = (n.a) childAt;
                        aVar.setId(id);
                        aVar.setType(bVar.f1700s0);
                        aVar.setAllowsGoneWidget(bVar.f1698r0);
                        int[] iArr = bVar.f1704u0;
                        if (iArr != null) {
                            aVar.setReferencedIds(iArr);
                        } else {
                            String str = bVar.f1706v0;
                            if (str != null) {
                                int[] b10 = b(aVar, str);
                                bVar.f1704u0 = b10;
                                aVar.setReferencedIds(b10);
                            }
                        }
                    }
                    ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                    bVar.a(aVar2);
                    childAt.setLayoutParams(aVar2);
                    childAt.setVisibility(bVar.J);
                    int i12 = Build.VERSION.SDK_INT;
                    childAt.setAlpha(bVar.U);
                    childAt.setRotation(bVar.X);
                    childAt.setRotationX(bVar.Y);
                    childAt.setRotationY(bVar.Z);
                    childAt.setScaleX(bVar.f1664a0);
                    childAt.setScaleY(bVar.f1666b0);
                    if (!Float.isNaN(bVar.f1668c0)) {
                        childAt.setPivotX(bVar.f1668c0);
                    }
                    if (!Float.isNaN(bVar.f1670d0)) {
                        childAt.setPivotY(bVar.f1670d0);
                    }
                    childAt.setTranslationX(bVar.f1672e0);
                    childAt.setTranslationY(bVar.f1674f0);
                    if (i12 >= 21) {
                        childAt.setTranslationZ(bVar.f1676g0);
                        if (bVar.V) {
                            childAt.setElevation(bVar.W);
                        }
                    }
                }
                i10++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0023b bVar2 = (C0023b) this.f1662a.get(num);
            int i13 = bVar2.f1702t0;
            if (i13 != -1 && i13 == 1) {
                n.a aVar3 = new n.a(constraintLayout.getContext());
                aVar3.setId(num.intValue());
                int[] iArr2 = bVar2.f1704u0;
                if (iArr2 != null) {
                    aVar3.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar2.f1706v0;
                    if (str2 != null) {
                        int[] b11 = b(aVar3, str2);
                        bVar2.f1704u0 = b11;
                        aVar3.setReferencedIds(b11);
                    }
                }
                aVar3.setType(bVar2.f1700s0);
                ConstraintLayout.a a10 = constraintLayout.generateDefaultLayoutParams();
                aVar3.f();
                bVar2.a(a10);
                constraintLayout.addView(aVar3, a10);
            }
            if (bVar2.f1663a) {
                c cVar = new c(constraintLayout.getContext());
                cVar.setId(num.intValue());
                ConstraintLayout.a a11 = constraintLayout.generateDefaultLayoutParams();
                bVar2.a(a11);
                constraintLayout.addView(cVar, a11);
            }
        }
    }

    public final int[] b(View view, String str) {
        int i10;
        Object c10;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            try {
                i10 = R$id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (c10 = ((ConstraintLayout) view.getParent()).c(0, trim)) != null && (c10 instanceof Integer)) {
                i10 = ((Integer) c10).intValue();
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        if (i12 != split.length) {
            return Arrays.copyOf(iArr, i12);
        }
        return iArr;
    }

    public final C0023b c(Context context, AttributeSet attributeSet) {
        C0023b bVar = new C0023b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1652c);
        f(bVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return bVar;
    }

    public void d(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    C0023b c10 = c(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        c10.f1663a = true;
                    }
                    this.f1662a.put(Integer.valueOf(c10.f1669d), c10);
                }
            }
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public final void f(C0023b bVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            int i11 = f1661c.get(index);
            switch (i11) {
                case 1:
                    bVar.f1693p = e(typedArray, index, bVar.f1693p);
                    break;
                case 2:
                    bVar.G = typedArray.getDimensionPixelSize(index, bVar.G);
                    break;
                case 3:
                    bVar.f1691o = e(typedArray, index, bVar.f1691o);
                    break;
                case 4:
                    bVar.f1689n = e(typedArray, index, bVar.f1689n);
                    break;
                case 5:
                    bVar.f1707w = typedArray.getString(index);
                    break;
                case 6:
                    bVar.A = typedArray.getDimensionPixelOffset(index, bVar.A);
                    break;
                case 7:
                    bVar.B = typedArray.getDimensionPixelOffset(index, bVar.B);
                    break;
                case 8:
                    bVar.H = typedArray.getDimensionPixelSize(index, bVar.H);
                    break;
                case 9:
                    bVar.f1701t = e(typedArray, index, bVar.f1701t);
                    break;
                case 10:
                    bVar.f1699s = e(typedArray, index, bVar.f1699s);
                    break;
                case 11:
                    bVar.N = typedArray.getDimensionPixelSize(index, bVar.N);
                    break;
                case 12:
                    bVar.O = typedArray.getDimensionPixelSize(index, bVar.O);
                    break;
                case 13:
                    bVar.K = typedArray.getDimensionPixelSize(index, bVar.K);
                    break;
                case 14:
                    bVar.M = typedArray.getDimensionPixelSize(index, bVar.M);
                    break;
                case 15:
                    bVar.P = typedArray.getDimensionPixelSize(index, bVar.P);
                    break;
                case 16:
                    bVar.L = typedArray.getDimensionPixelSize(index, bVar.L);
                    break;
                case 17:
                    bVar.f1671e = typedArray.getDimensionPixelOffset(index, bVar.f1671e);
                    break;
                case 18:
                    bVar.f1673f = typedArray.getDimensionPixelOffset(index, bVar.f1673f);
                    break;
                case 19:
                    bVar.f1675g = typedArray.getFloat(index, bVar.f1675g);
                    break;
                case 20:
                    bVar.f1703u = typedArray.getFloat(index, bVar.f1703u);
                    break;
                case 21:
                    bVar.f1667c = typedArray.getLayoutDimension(index, bVar.f1667c);
                    break;
                case 22:
                    bVar.J = f1660b[typedArray.getInt(index, bVar.J)];
                    break;
                case 23:
                    bVar.f1665b = typedArray.getLayoutDimension(index, bVar.f1665b);
                    break;
                case 24:
                    bVar.D = typedArray.getDimensionPixelSize(index, bVar.D);
                    break;
                case 25:
                    bVar.f1677h = e(typedArray, index, bVar.f1677h);
                    break;
                case 26:
                    bVar.f1679i = e(typedArray, index, bVar.f1679i);
                    break;
                case 27:
                    bVar.C = typedArray.getInt(index, bVar.C);
                    break;
                case 28:
                    bVar.E = typedArray.getDimensionPixelSize(index, bVar.E);
                    break;
                case 29:
                    bVar.f1681j = e(typedArray, index, bVar.f1681j);
                    break;
                case 30:
                    bVar.f1683k = e(typedArray, index, bVar.f1683k);
                    break;
                case 31:
                    bVar.I = typedArray.getDimensionPixelSize(index, bVar.I);
                    break;
                case 32:
                    bVar.f1695q = e(typedArray, index, bVar.f1695q);
                    break;
                case 33:
                    bVar.f1697r = e(typedArray, index, bVar.f1697r);
                    break;
                case 34:
                    bVar.F = typedArray.getDimensionPixelSize(index, bVar.F);
                    break;
                case 35:
                    bVar.f1687m = e(typedArray, index, bVar.f1687m);
                    break;
                case 36:
                    bVar.f1685l = e(typedArray, index, bVar.f1685l);
                    break;
                case 37:
                    bVar.f1705v = typedArray.getFloat(index, bVar.f1705v);
                    break;
                case 38:
                    bVar.f1669d = typedArray.getResourceId(index, bVar.f1669d);
                    break;
                case 39:
                    bVar.R = typedArray.getFloat(index, bVar.R);
                    break;
                case 40:
                    bVar.Q = typedArray.getFloat(index, bVar.Q);
                    break;
                case 41:
                    bVar.S = typedArray.getInt(index, bVar.S);
                    break;
                case 42:
                    bVar.T = typedArray.getInt(index, bVar.T);
                    break;
                case 43:
                    bVar.U = typedArray.getFloat(index, bVar.U);
                    break;
                case 44:
                    bVar.V = true;
                    bVar.W = typedArray.getDimension(index, bVar.W);
                    break;
                case 45:
                    bVar.Y = typedArray.getFloat(index, bVar.Y);
                    break;
                case 46:
                    bVar.Z = typedArray.getFloat(index, bVar.Z);
                    break;
                case 47:
                    bVar.f1664a0 = typedArray.getFloat(index, bVar.f1664a0);
                    break;
                case 48:
                    bVar.f1666b0 = typedArray.getFloat(index, bVar.f1666b0);
                    break;
                case 49:
                    bVar.f1668c0 = typedArray.getFloat(index, bVar.f1668c0);
                    break;
                case 50:
                    bVar.f1670d0 = typedArray.getFloat(index, bVar.f1670d0);
                    break;
                case 51:
                    bVar.f1672e0 = typedArray.getDimension(index, bVar.f1672e0);
                    break;
                case 52:
                    bVar.f1674f0 = typedArray.getDimension(index, bVar.f1674f0);
                    break;
                case 53:
                    bVar.f1676g0 = typedArray.getDimension(index, bVar.f1676g0);
                    break;
                default:
                    switch (i11) {
                        case 60:
                            bVar.X = typedArray.getFloat(index, bVar.X);
                            break;
                        case 61:
                            bVar.f1708x = e(typedArray, index, bVar.f1708x);
                            break;
                        case 62:
                            bVar.f1709y = typedArray.getDimensionPixelSize(index, bVar.f1709y);
                            break;
                        case 63:
                            bVar.f1710z = typedArray.getFloat(index, bVar.f1710z);
                            break;
                        default:
                            switch (i11) {
                                case 69:
                                    bVar.f1694p0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    bVar.f1696q0 = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    bVar.f1700s0 = typedArray.getInt(index, bVar.f1700s0);
                                    break;
                                case 73:
                                    bVar.f1706v0 = typedArray.getString(index);
                                    break;
                                case 74:
                                    bVar.f1698r0 = typedArray.getBoolean(index, bVar.f1698r0);
                                    break;
                                case 75:
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("unused attribute 0x");
                                    sb.append(Integer.toHexString(index));
                                    sb.append("   ");
                                    sb.append(f1661c.get(index));
                                    break;
                                default:
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Unknown attribute 0x");
                                    sb2.append(Integer.toHexString(index));
                                    sb2.append("   ");
                                    sb2.append(f1661c.get(index));
                                    break;
                            }
                    }
            }
        }
    }
}
