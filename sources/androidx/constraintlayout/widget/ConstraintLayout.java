package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.HashMap;
import m.e;
import m.f;
import m.g;
import m.i;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray f1591a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f1592b = new ArrayList(4);

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1593c = new ArrayList(100);

    /* renamed from: d  reason: collision with root package name */
    public g f1594d = new g();

    /* renamed from: e  reason: collision with root package name */
    public int f1595e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1596f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f1597g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    public int f1598h = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1599i = true;

    /* renamed from: j  reason: collision with root package name */
    public int f1600j = 7;

    /* renamed from: k  reason: collision with root package name */
    public b f1601k = null;

    /* renamed from: l  reason: collision with root package name */
    public int f1602l = -1;

    /* renamed from: m  reason: collision with root package name */
    public HashMap f1603m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    public int f1604n = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f1605o = -1;

    /* renamed from: p  reason: collision with root package name */
    public int f1606p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f1607q = -1;

    /* renamed from: r  reason: collision with root package name */
    public int f1608r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f1609s = 0;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(attributeSet);
    }

    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
    }

    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public Object c(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap hashMap = this.f1603m;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f1603m.get(str);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final f d(int i10) {
        if (i10 == 0) {
            return this.f1594d;
        }
        View view = (View) this.f1591a.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1594d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).f1633l0;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i11 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i12 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = (float) i11;
                        float f11 = (float) i12;
                        float f12 = (float) (i11 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f13 = f11;
                        float f14 = f11;
                        float f15 = f12;
                        float f16 = f10;
                        Paint paint2 = paint;
                        canvas2.drawLine(f10, f13, f15, f14, paint);
                        float parseInt4 = (float) (i12 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f17 = f12;
                        float f18 = parseInt4;
                        canvas2.drawLine(f17, f14, f15, f18, paint);
                        float f19 = parseInt4;
                        float f20 = f16;
                        canvas2.drawLine(f17, f19, f20, f18, paint);
                        float f21 = f16;
                        canvas2.drawLine(f21, f19, f20, f14, paint);
                        paint.setColor(-16711936);
                        float f22 = f12;
                        Paint paint3 = paint;
                        canvas2.drawLine(f21, f14, f22, parseInt4, paint);
                        canvas2.drawLine(f21, parseInt4, f22, f14, paint);
                    }
                }
            }
        }
    }

    public View e(int i10) {
        return (View) this.f1591a.get(i10);
    }

    public final f f(View view) {
        if (view == this) {
            return this.f1594d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).f1633l0;
    }

    public final void g(AttributeSet attributeSet) {
        this.f1594d.W(this);
        this.f1591a.put(getId(), this);
        this.f1601k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1650a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f1595e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1595e);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f1596f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1596f);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f1597g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1597g);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f1598h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1598h);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f1600j = obtainStyledAttributes.getInt(index, this.f1600j);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        b bVar = new b();
                        this.f1601k = bVar;
                        bVar.d(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f1601k = null;
                    }
                    this.f1602l = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1594d.c1(this.f1600j);
    }

    public int getMaxHeight() {
        return this.f1598h;
    }

    public int getMaxWidth() {
        return this.f1597g;
    }

    public int getMinHeight() {
        return this.f1596f;
    }

    public int getMinWidth() {
        return this.f1595e;
    }

    public int getOptimizationLevel() {
        return this.f1594d.R0();
    }

    public final void h(int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        int baseline;
        int i12;
        int i13;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        int i14 = i10;
        int i15 = i11;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                f fVar = aVar.f1633l0;
                if (!aVar.Y && !aVar.Z) {
                    fVar.x0(childAt.getVisibility());
                    int i17 = aVar.width;
                    int i18 = aVar.height;
                    boolean z17 = aVar.V;
                    if (z17 || z16 || ((!z17 && aVar.I == 1) || i17 == -1 || (!(z16 = aVar.W) && (aVar.J == 1 || i18 == -1)))) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        if (i17 == 0) {
                            i12 = ViewGroup.getChildMeasureSpec(i14, paddingLeft, -2);
                            z12 = true;
                        } else if (i17 == -1) {
                            i12 = ViewGroup.getChildMeasureSpec(i14, paddingLeft, -1);
                            z12 = false;
                        } else {
                            if (i17 == -2) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            z12 = z15;
                            i12 = ViewGroup.getChildMeasureSpec(i14, paddingLeft, i17);
                        }
                        if (i18 == 0) {
                            i13 = ViewGroup.getChildMeasureSpec(i15, paddingTop, -2);
                            z11 = true;
                        } else if (i18 == -1) {
                            i13 = ViewGroup.getChildMeasureSpec(i15, paddingTop, -1);
                            z11 = false;
                        } else {
                            if (i18 == -2) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            i13 = ViewGroup.getChildMeasureSpec(i15, paddingTop, i18);
                        }
                        childAt.measure(i12, i13);
                        if (i17 == -2) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        fVar.z0(z13);
                        if (i18 == -2) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        fVar.c0(z14);
                        i17 = childAt.getMeasuredWidth();
                        i18 = childAt.getMeasuredHeight();
                    } else {
                        z12 = false;
                        z11 = false;
                    }
                    fVar.y0(i17);
                    fVar.b0(i18);
                    if (z12) {
                        fVar.B0(i17);
                    }
                    if (z11) {
                        fVar.A0(i18);
                    }
                    if (aVar.X && (baseline = childAt.getBaseline()) != -1) {
                        fVar.V(baseline);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0299  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(int r25, int r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            int r3 = r24.getPaddingTop()
            int r4 = r24.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r24.getPaddingLeft()
            int r5 = r24.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r24.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 8
            r9 = -1
            r10 = -2
            if (r7 >= r5) goto L_0x00c8
            android.view.View r12 = r0.getChildAt(r7)
            int r13 = r12.getVisibility()
            if (r13 != r8) goto L_0x002f
            goto L_0x00c4
        L_0x002f:
            android.view.ViewGroup$LayoutParams r8 = r12.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r8 = (androidx.constraintlayout.widget.ConstraintLayout.a) r8
            m.f r13 = r8.f1633l0
            boolean r14 = r8.Y
            if (r14 != 0) goto L_0x00c4
            boolean r14 = r8.Z
            if (r14 == 0) goto L_0x0041
            goto L_0x00c4
        L_0x0041:
            int r14 = r12.getVisibility()
            r13.x0(r14)
            int r14 = r8.width
            int r15 = r8.height
            if (r14 == 0) goto L_0x00b6
            if (r15 != 0) goto L_0x0051
            goto L_0x00b6
        L_0x0051:
            if (r14 != r10) goto L_0x0056
            r16 = 1
            goto L_0x0058
        L_0x0056:
            r16 = 0
        L_0x0058:
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r14)
            if (r15 != r10) goto L_0x0061
            r17 = 1
            goto L_0x0063
        L_0x0061:
            r17 = 0
        L_0x0063:
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r15)
            r12.measure(r6, r11)
            if (r14 != r10) goto L_0x006e
            r6 = 1
            goto L_0x006f
        L_0x006e:
            r6 = 0
        L_0x006f:
            r13.z0(r6)
            if (r15 != r10) goto L_0x0076
            r11 = 1
            goto L_0x0077
        L_0x0076:
            r11 = 0
        L_0x0077:
            r13.c0(r11)
            int r6 = r12.getMeasuredWidth()
            int r10 = r12.getMeasuredHeight()
            r13.y0(r6)
            r13.b0(r10)
            if (r16 == 0) goto L_0x008d
            r13.B0(r6)
        L_0x008d:
            if (r17 == 0) goto L_0x0092
            r13.A0(r10)
        L_0x0092:
            boolean r11 = r8.X
            if (r11 == 0) goto L_0x009f
            int r11 = r12.getBaseline()
            if (r11 == r9) goto L_0x009f
            r13.V(r11)
        L_0x009f:
            boolean r9 = r8.V
            if (r9 == 0) goto L_0x00c4
            boolean r8 = r8.W
            if (r8 == 0) goto L_0x00c4
            m.n r8 = r13.x()
            r8.h(r6)
            m.n r6 = r13.w()
            r6.h(r10)
            goto L_0x00c4
        L_0x00b6:
            m.n r6 = r13.x()
            r6.c()
            m.n r6 = r13.w()
            r6.c()
        L_0x00c4:
            int r7 = r7 + 1
            goto L_0x001d
        L_0x00c8:
            m.g r6 = r0.f1594d
            r6.e1()
            r6 = 0
        L_0x00ce:
            if (r6 >= r5) goto L_0x02a9
            android.view.View r7 = r0.getChildAt(r6)
            int r11 = r7.getVisibility()
            if (r11 != r8) goto L_0x00dc
            goto L_0x029b
        L_0x00dc:
            android.view.ViewGroup$LayoutParams r11 = r7.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r11 = (androidx.constraintlayout.widget.ConstraintLayout.a) r11
            m.f r12 = r11.f1633l0
            boolean r13 = r11.Y
            if (r13 != 0) goto L_0x029b
            boolean r13 = r11.Z
            if (r13 == 0) goto L_0x00ee
            goto L_0x029b
        L_0x00ee:
            int r13 = r7.getVisibility()
            r12.x0(r13)
            int r13 = r11.width
            int r14 = r11.height
            if (r13 == 0) goto L_0x00ff
            if (r14 == 0) goto L_0x00ff
            goto L_0x029b
        L_0x00ff:
            m.e$d r15 = m.e.d.LEFT
            m.e r16 = r12.h(r15)
            m.m r16 = r16.f()
            m.e$d r8 = m.e.d.RIGHT
            m.e r18 = r12.h(r8)
            m.m r18 = r18.f()
            m.e r15 = r12.h(r15)
            m.e r15 = r15.i()
            if (r15 == 0) goto L_0x0129
            m.e r8 = r12.h(r8)
            m.e r8 = r8.i()
            if (r8 == 0) goto L_0x0129
            r8 = 1
            goto L_0x012a
        L_0x0129:
            r8 = 0
        L_0x012a:
            m.e$d r15 = m.e.d.TOP
            m.e r19 = r12.h(r15)
            m.m r19 = r19.f()
            m.e$d r9 = m.e.d.BOTTOM
            m.e r20 = r12.h(r9)
            m.m r20 = r20.f()
            m.e r15 = r12.h(r15)
            m.e r15 = r15.i()
            if (r15 == 0) goto L_0x0154
            m.e r9 = r12.h(r9)
            m.e r9 = r9.i()
            if (r9 == 0) goto L_0x0154
            r9 = 1
            goto L_0x0155
        L_0x0154:
            r9 = 0
        L_0x0155:
            if (r13 != 0) goto L_0x015f
            if (r14 != 0) goto L_0x015f
            if (r8 == 0) goto L_0x015f
            if (r9 == 0) goto L_0x015f
            goto L_0x029b
        L_0x015f:
            m.g r15 = r0.f1594d
            m.f$b r15 = r15.s()
            m.f$b r10 = m.f.b.WRAP_CONTENT
            r21 = r5
            if (r15 == r10) goto L_0x016d
            r15 = 1
            goto L_0x016e
        L_0x016d:
            r15 = 0
        L_0x016e:
            m.g r5 = r0.f1594d
            m.f$b r5 = r5.B()
            if (r5 == r10) goto L_0x0178
            r5 = 1
            goto L_0x0179
        L_0x0178:
            r5 = 0
        L_0x0179:
            if (r15 != 0) goto L_0x0182
            m.n r10 = r12.x()
            r10.c()
        L_0x0182:
            if (r5 != 0) goto L_0x018b
            m.n r10 = r12.w()
            r10.c()
        L_0x018b:
            if (r13 != 0) goto L_0x01c2
            if (r15 == 0) goto L_0x01b9
            boolean r10 = r12.P()
            if (r10 == 0) goto L_0x01b9
            if (r8 == 0) goto L_0x01b9
            boolean r8 = r16.d()
            if (r8 == 0) goto L_0x01b9
            boolean r8 = r18.d()
            if (r8 == 0) goto L_0x01b9
            float r8 = r18.k()
            float r10 = r16.k()
            float r8 = r8 - r10
            int r13 = (int) r8
            m.n r8 = r12.x()
            r8.h(r13)
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r13)
            goto L_0x01cc
        L_0x01b9:
            r8 = -2
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r8)
            r8 = r10
            r10 = 1
            r15 = 0
            goto L_0x01dc
        L_0x01c2:
            r8 = -2
            r10 = -1
            if (r13 != r10) goto L_0x01ce
            int r16 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r10)
            r8 = r16
        L_0x01cc:
            r10 = 0
            goto L_0x01dc
        L_0x01ce:
            if (r13 != r8) goto L_0x01d2
            r8 = 1
            goto L_0x01d3
        L_0x01d2:
            r8 = 0
        L_0x01d3:
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r13)
            r23 = r10
            r10 = r8
            r8 = r23
        L_0x01dc:
            if (r14 != 0) goto L_0x021c
            if (r5 == 0) goto L_0x0210
            boolean r16 = r12.O()
            if (r16 == 0) goto L_0x0210
            if (r9 == 0) goto L_0x0210
            boolean r9 = r19.d()
            if (r9 == 0) goto L_0x0210
            boolean r9 = r20.d()
            if (r9 == 0) goto L_0x0210
            float r9 = r20.k()
            float r14 = r19.k()
            float r9 = r9 - r14
            int r14 = (int) r9
            m.n r9 = r12.w()
            r9.h(r14)
            int r9 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r14)
            r22 = r14
            r16 = 0
            r14 = r9
            r9 = -2
            goto L_0x023b
        L_0x0210:
            r9 = -2
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r9)
            r22 = r14
            r16 = 1
            r14 = r5
            r5 = 0
            goto L_0x023b
        L_0x021c:
            r9 = -1
            if (r14 != r9) goto L_0x022b
            int r16 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r9)
            r22 = r14
            r14 = r16
            r9 = -2
            r16 = 0
            goto L_0x023b
        L_0x022b:
            r9 = -2
            if (r14 != r9) goto L_0x0231
            r16 = 1
            goto L_0x0233
        L_0x0231:
            r16 = 0
        L_0x0233:
            int r18 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r14)
            r22 = r14
            r14 = r18
        L_0x023b:
            r7.measure(r8, r14)
            if (r13 != r9) goto L_0x0242
            r8 = 1
            goto L_0x0243
        L_0x0242:
            r8 = 0
        L_0x0243:
            r12.z0(r8)
            r14 = r22
            if (r14 != r9) goto L_0x024c
            r8 = 1
            goto L_0x024d
        L_0x024c:
            r8 = 0
        L_0x024d:
            r12.c0(r8)
            int r8 = r7.getMeasuredWidth()
            int r13 = r7.getMeasuredHeight()
            r12.y0(r8)
            r12.b0(r13)
            if (r10 == 0) goto L_0x0263
            r12.B0(r8)
        L_0x0263:
            if (r16 == 0) goto L_0x0268
            r12.A0(r13)
        L_0x0268:
            if (r15 == 0) goto L_0x0272
            m.n r10 = r12.x()
            r10.h(r8)
            goto L_0x0279
        L_0x0272:
            m.n r8 = r12.x()
            r8.g()
        L_0x0279:
            if (r5 == 0) goto L_0x0283
            m.n r5 = r12.w()
            r5.h(r13)
            goto L_0x028a
        L_0x0283:
            m.n r5 = r12.w()
            r5.g()
        L_0x028a:
            boolean r5 = r11.X
            if (r5 == 0) goto L_0x0299
            int r5 = r7.getBaseline()
            r7 = -1
            if (r5 == r7) goto L_0x029f
            r12.V(r5)
            goto L_0x029f
        L_0x0299:
            r7 = -1
            goto L_0x029f
        L_0x029b:
            r21 = r5
            r7 = -1
            r9 = -2
        L_0x029f:
            int r6 = r6 + 1
            r5 = r21
            r8 = 8
            r9 = -1
            r10 = -2
            goto L_0x00ce
        L_0x02a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i(int, int):void");
    }

    public final void j() {
        int i10;
        int i11;
        int i12;
        float f10;
        f d10;
        f d11;
        f d12;
        f d13;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z10 = false;
        if (isInEditMode) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    k(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    d(childAt.getId()).X(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            f f11 = f(getChildAt(i14));
            if (f11 != null) {
                f11.Q();
            }
        }
        if (this.f1602l != -1) {
            for (int i15 = 0; i15 < childCount; i15++) {
                int id = getChildAt(i15).getId();
                int i16 = this.f1602l;
            }
        }
        b bVar = this.f1601k;
        if (bVar != null) {
            bVar.a(this);
        }
        this.f1594d.M0();
        int size = this.f1592b.size();
        if (size > 0) {
            for (int i17 = 0; i17 < size; i17++) {
                ((a) this.f1592b.get(i17)).e(this);
            }
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            getChildAt(i18);
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            f f12 = f(childAt2);
            if (f12 != null) {
                a aVar = (a) childAt2.getLayoutParams();
                aVar.a();
                if (aVar.f1635m0) {
                    aVar.f1635m0 = z10;
                } else if (isInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt2.getId());
                        k(z10 ? 1 : 0, resourceName2, Integer.valueOf(childAt2.getId()));
                        d(childAt2.getId()).X(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                f12.x0(childAt2.getVisibility());
                if (aVar.f1611a0) {
                    f12.x0(8);
                }
                f12.W(childAt2);
                this.f1594d.I0(f12);
                if (!aVar.W || !aVar.V) {
                    this.f1593c.add(f12);
                }
                if (aVar.Y) {
                    i iVar = (i) f12;
                    int i20 = aVar.f1627i0;
                    int i21 = aVar.f1629j0;
                    float f13 = aVar.f1631k0;
                    if (f13 != -1.0f) {
                        iVar.L0(f13);
                    } else if (i20 != -1) {
                        iVar.J0(i20);
                    } else if (i21 != -1) {
                        iVar.K0(i21);
                    }
                } else if (aVar.f1616d != -1 || aVar.f1618e != -1 || aVar.f1620f != -1 || aVar.f1622g != -1 || aVar.f1639q != -1 || aVar.f1638p != -1 || aVar.f1640r != -1 || aVar.f1641s != -1 || aVar.f1624h != -1 || aVar.f1626i != -1 || aVar.f1628j != -1 || aVar.f1630k != -1 || aVar.f1632l != -1 || aVar.Q != -1 || aVar.R != -1 || aVar.f1634m != -1 || aVar.width == -1 || aVar.height == -1) {
                    int i22 = aVar.f1613b0;
                    int i23 = aVar.f1615c0;
                    int i24 = aVar.f1617d0;
                    int i25 = aVar.f1619e0;
                    int i26 = aVar.f1621f0;
                    int i27 = aVar.f1623g0;
                    float f14 = aVar.f1625h0;
                    int i28 = aVar.f1634m;
                    if (i28 != -1) {
                        f d14 = d(i28);
                        if (d14 != null) {
                            f12.f(d14, aVar.f1637o, aVar.f1636n);
                        }
                    } else {
                        if (i22 != -1) {
                            f d15 = d(i22);
                            if (d15 != null) {
                                e.d dVar = e.d.LEFT;
                                e.d dVar2 = dVar;
                                f10 = f14;
                                f fVar = d15;
                                i12 = i27;
                                e.d dVar3 = dVar;
                                i11 = i25;
                                f12.J(dVar2, fVar, dVar3, aVar.leftMargin, i26);
                            } else {
                                f10 = f14;
                                i12 = i27;
                                i11 = i25;
                            }
                        } else {
                            f10 = f14;
                            i12 = i27;
                            int i29 = i26;
                            i11 = i25;
                            if (!(i23 == -1 || (d13 = d(i23)) == null)) {
                                f12.J(e.d.LEFT, d13, e.d.RIGHT, aVar.leftMargin, i29);
                            }
                        }
                        if (i24 != -1) {
                            f d16 = d(i24);
                            if (d16 != null) {
                                f12.J(e.d.RIGHT, d16, e.d.LEFT, aVar.rightMargin, i12);
                            }
                        } else {
                            int i30 = i11;
                            if (!(i30 == -1 || (d12 = d(i30)) == null)) {
                                e.d dVar4 = e.d.RIGHT;
                                f12.J(dVar4, d12, dVar4, aVar.rightMargin, i12);
                            }
                        }
                        int i31 = aVar.f1624h;
                        if (i31 != -1) {
                            f d17 = d(i31);
                            if (d17 != null) {
                                e.d dVar5 = e.d.TOP;
                                f12.J(dVar5, d17, dVar5, aVar.topMargin, aVar.f1643u);
                            }
                        } else {
                            int i32 = aVar.f1626i;
                            if (!(i32 == -1 || (d11 = d(i32)) == null)) {
                                f12.J(e.d.TOP, d11, e.d.BOTTOM, aVar.topMargin, aVar.f1643u);
                            }
                        }
                        int i33 = aVar.f1628j;
                        if (i33 != -1) {
                            f d18 = d(i33);
                            if (d18 != null) {
                                f12.J(e.d.BOTTOM, d18, e.d.TOP, aVar.bottomMargin, aVar.f1645w);
                            }
                        } else {
                            int i34 = aVar.f1630k;
                            if (!(i34 == -1 || (d10 = d(i34)) == null)) {
                                e.d dVar6 = e.d.BOTTOM;
                                f12.J(dVar6, d10, dVar6, aVar.bottomMargin, aVar.f1645w);
                            }
                        }
                        int i35 = aVar.f1632l;
                        if (i35 != -1) {
                            View view = (View) this.f1591a.get(i35);
                            f d19 = d(aVar.f1632l);
                            if (!(d19 == null || view == null || !(view.getLayoutParams() instanceof a))) {
                                aVar.X = true;
                                ((a) view.getLayoutParams()).X = true;
                                e.d dVar7 = e.d.BASELINE;
                                f12.h(dVar7).a(d19.h(dVar7), 0, -1, e.c.STRONG, 0, true);
                                f12.h(e.d.TOP).m();
                                f12.h(e.d.BOTTOM).m();
                            }
                        }
                        if (f10 >= 0.0f && f10 != 0.5f) {
                            f12.d0(f10);
                        }
                        float f15 = aVar.A;
                        if (f15 >= 0.0f && f15 != 0.5f) {
                            f12.r0(f15);
                        }
                    }
                    if (isInEditMode && !((i10 = aVar.Q) == -1 && aVar.R == -1)) {
                        f12.o0(i10, aVar.R);
                    }
                    if (aVar.V) {
                        f12.g0(f.b.FIXED);
                        f12.y0(aVar.width);
                    } else if (aVar.width == -1) {
                        f12.g0(f.b.MATCH_PARENT);
                        f12.h(e.d.LEFT).f7675e = aVar.leftMargin;
                        f12.h(e.d.RIGHT).f7675e = aVar.rightMargin;
                    } else {
                        f12.g0(f.b.MATCH_CONSTRAINT);
                        f12.y0(0);
                    }
                    if (aVar.W) {
                        z10 = false;
                        f12.u0(f.b.FIXED);
                        f12.b0(aVar.height);
                    } else if (aVar.height == -1) {
                        f12.u0(f.b.MATCH_PARENT);
                        f12.h(e.d.TOP).f7675e = aVar.topMargin;
                        f12.h(e.d.BOTTOM).f7675e = aVar.bottomMargin;
                        z10 = false;
                    } else {
                        f12.u0(f.b.MATCH_CONSTRAINT);
                        z10 = false;
                        f12.b0(0);
                    }
                    String str = aVar.B;
                    if (str != null) {
                        f12.Y(str);
                    }
                    f12.i0(aVar.E);
                    f12.w0(aVar.F);
                    f12.e0(aVar.G);
                    f12.s0(aVar.H);
                    f12.h0(aVar.I, aVar.K, aVar.M, aVar.O);
                    f12.v0(aVar.J, aVar.L, aVar.N, aVar.P);
                }
            }
        }
    }

    public void k(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1603m == null) {
                this.f1603m = new HashMap();
            }
            String str = (String) obj;
            int indexOf = str.indexOf(Operator.Operation.DIVISION);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1603m.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public final void l(int i10, int i11) {
        f.b bVar;
        int i12;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        f.b bVar2 = f.b.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                bVar = f.b.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                bVar = bVar2;
            } else {
                i12 = Math.min(this.f1597g, size) - paddingLeft;
                bVar = bVar2;
            }
            i12 = 0;
        } else {
            i12 = size;
            bVar = f.b.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                bVar2 = f.b.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f1598h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            bVar2 = f.b.WRAP_CONTENT;
        }
        this.f1594d.m0(0);
        this.f1594d.l0(0);
        this.f1594d.g0(bVar);
        this.f1594d.y0(i12);
        this.f1594d.u0(bVar2);
        this.f1594d.b0(size2);
        this.f1594d.m0((this.f1595e - getPaddingLeft()) - getPaddingRight());
        this.f1594d.l0((this.f1596f - getPaddingTop()) - getPaddingBottom());
    }

    public void m(String str) {
        this.f1594d.K0();
    }

    public final void n() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            this.f1593c.clear();
            j();
        }
    }

    public final void o() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10);
        }
        int size = this.f1592b.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                ((a) this.f1592b.get(i11)).d(this);
            }
        }
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            a aVar = (a) childAt.getLayoutParams();
            f fVar = aVar.f1633l0;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.f1611a0) {
                int p10 = fVar.p();
                int q10 = fVar.q();
                childAt.layout(p10, q10, fVar.D() + p10, fVar.r() + q10);
            }
        }
        int size = this.f1592b.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                ((a) this.f1592b.get(i15)).c(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:160:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0363  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.System.currentTimeMillis()
            int r3 = android.view.View.MeasureSpec.getMode(r21)
            int r4 = android.view.View.MeasureSpec.getSize(r21)
            int r5 = android.view.View.MeasureSpec.getMode(r22)
            int r6 = android.view.View.MeasureSpec.getSize(r22)
            int r7 = r20.getPaddingLeft()
            int r8 = r20.getPaddingTop()
            m.g r9 = r0.f1594d
            r9.C0(r7)
            m.g r9 = r0.f1594d
            r9.D0(r8)
            m.g r9 = r0.f1594d
            int r10 = r0.f1597g
            r9.k0(r10)
            m.g r9 = r0.f1594d
            int r10 = r0.f1598h
            r9.j0(r10)
            m.g r9 = r0.f1594d
            int r10 = r20.getLayoutDirection()
            r11 = 0
            r12 = 1
            if (r10 != r12) goto L_0x0045
            r10 = 1
            goto L_0x0046
        L_0x0045:
            r10 = 0
        L_0x0046:
            r9.d1(r10)
            r20.l(r21, r22)
            m.g r9 = r0.f1594d
            int r9 = r9.D()
            m.g r10 = r0.f1594d
            int r10 = r10.r()
            boolean r13 = r0.f1599i
            if (r13 == 0) goto L_0x0063
            r0.f1599i = r11
            r20.n()
            r13 = 1
            goto L_0x0064
        L_0x0063:
            r13 = 0
        L_0x0064:
            int r14 = r0.f1600j
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x006d
            r14 = 1
            goto L_0x006e
        L_0x006d:
            r14 = 0
        L_0x006e:
            if (r14 == 0) goto L_0x007e
            m.g r15 = r0.f1594d
            r15.a1()
            m.g r15 = r0.f1594d
            r15.Y0(r9, r10)
            r20.i(r21, r22)
            goto L_0x0081
        L_0x007e:
            r20.h(r21, r22)
        L_0x0081:
            r20.o()
            int r15 = r20.getChildCount()
            if (r15 <= 0) goto L_0x0091
            if (r13 == 0) goto L_0x0091
            m.g r13 = r0.f1594d
            m.a.a(r13)
        L_0x0091:
            m.g r13 = r0.f1594d
            boolean r15 = r13.I0
            if (r15 == 0) goto L_0x00c3
            boolean r15 = r13.J0
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r15 == 0) goto L_0x00ad
            if (r3 != r12) goto L_0x00ad
            int r15 = r13.L0
            if (r15 >= r4) goto L_0x00a6
            r13.y0(r15)
        L_0x00a6:
            m.g r13 = r0.f1594d
            m.f$b r15 = m.f.b.FIXED
            r13.g0(r15)
        L_0x00ad:
            m.g r13 = r0.f1594d
            boolean r15 = r13.K0
            if (r15 == 0) goto L_0x00c3
            if (r5 != r12) goto L_0x00c3
            int r12 = r13.M0
            if (r12 >= r6) goto L_0x00bc
            r13.b0(r12)
        L_0x00bc:
            m.g r12 = r0.f1594d
            m.f$b r13 = m.f.b.FIXED
            r12.u0(r13)
        L_0x00c3:
            int r12 = r0.f1600j
            r13 = 32
            r12 = r12 & r13
            r15 = 1073741824(0x40000000, float:2.0)
            if (r12 != r13) goto L_0x0117
            m.g r12 = r0.f1594d
            int r12 = r12.D()
            m.g r13 = r0.f1594d
            int r13 = r13.r()
            int r11 = r0.f1604n
            if (r11 == r12) goto L_0x00e6
            if (r3 != r15) goto L_0x00e6
            m.g r3 = r0.f1594d
            java.util.List r3 = r3.H0
            r11 = 0
            m.a.i(r3, r11, r12)
        L_0x00e6:
            int r3 = r0.f1605o
            if (r3 == r13) goto L_0x00f4
            if (r5 != r15) goto L_0x00f4
            m.g r3 = r0.f1594d
            java.util.List r3 = r3.H0
            r5 = 1
            m.a.i(r3, r5, r13)
        L_0x00f4:
            m.g r3 = r0.f1594d
            boolean r5 = r3.J0
            if (r5 == 0) goto L_0x0105
            int r5 = r3.L0
            if (r5 <= r4) goto L_0x0105
            java.util.List r3 = r3.H0
            r11 = 0
            m.a.i(r3, r11, r4)
            goto L_0x0106
        L_0x0105:
            r11 = 0
        L_0x0106:
            m.g r3 = r0.f1594d
            boolean r4 = r3.K0
            if (r4 == 0) goto L_0x0117
            int r4 = r3.M0
            if (r4 <= r6) goto L_0x0117
            java.util.List r3 = r3.H0
            r4 = 1
            m.a.i(r3, r4, r6)
            goto L_0x0118
        L_0x0117:
            r4 = 1
        L_0x0118:
            int r3 = r20.getChildCount()
            if (r3 <= 0) goto L_0x0123
            java.lang.String r3 = "First pass"
            r0.m(r3)
        L_0x0123:
            java.util.ArrayList r3 = r0.f1593c
            int r3 = r3.size()
            int r5 = r20.getPaddingBottom()
            int r8 = r8 + r5
            int r5 = r20.getPaddingRight()
            int r7 = r7 + r5
            if (r3 <= 0) goto L_0x032d
            m.g r5 = r0.f1594d
            m.f$b r5 = r5.s()
            m.f$b r6 = m.f.b.WRAP_CONTENT
            if (r5 != r6) goto L_0x0141
            r5 = 1
            goto L_0x0142
        L_0x0141:
            r5 = 0
        L_0x0142:
            m.g r12 = r0.f1594d
            m.f$b r12 = r12.B()
            if (r12 != r6) goto L_0x014c
            r6 = 1
            goto L_0x014d
        L_0x014c:
            r6 = 0
        L_0x014d:
            m.g r12 = r0.f1594d
            int r12 = r12.D()
            int r13 = r0.f1595e
            int r12 = java.lang.Math.max(r12, r13)
            m.g r13 = r0.f1594d
            int r13 = r13.r()
            int r4 = r0.f1596f
            int r4 = java.lang.Math.max(r13, r4)
            r16 = r12
            r12 = 0
            r13 = 0
        L_0x0169:
            if (r12 >= r3) goto L_0x0292
            java.util.ArrayList r15 = r0.f1593c
            java.lang.Object r15 = r15.get(r12)
            m.f r15 = (m.f) r15
            java.lang.Object r17 = r15.m()
            r18 = r3
            r3 = r17
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L_0x0185
            r17 = r9
            r19 = r10
            goto L_0x027e
        L_0x0185:
            android.view.ViewGroup$LayoutParams r17 = r3.getLayoutParams()
            r19 = r10
            r10 = r17
            androidx.constraintlayout.widget.ConstraintLayout$a r10 = (androidx.constraintlayout.widget.ConstraintLayout.a) r10
            r17 = r9
            boolean r9 = r10.Z
            if (r9 != 0) goto L_0x027e
            boolean r9 = r10.Y
            if (r9 == 0) goto L_0x019b
            goto L_0x027e
        L_0x019b:
            int r9 = r3.getVisibility()
            r0 = 8
            if (r9 != r0) goto L_0x01a5
            goto L_0x027e
        L_0x01a5:
            if (r14 == 0) goto L_0x01bd
            m.n r0 = r15.x()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x01bd
            m.n r0 = r15.w()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x01bd
            goto L_0x027e
        L_0x01bd:
            int r0 = r10.width
            r9 = -2
            if (r0 != r9) goto L_0x01cb
            boolean r9 = r10.V
            if (r9 == 0) goto L_0x01cb
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r1, r7, r0)
            goto L_0x01d5
        L_0x01cb:
            int r0 = r15.D()
            r9 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9)
        L_0x01d5:
            int r9 = r10.height
            r1 = -2
            if (r9 != r1) goto L_0x01e3
            boolean r1 = r10.W
            if (r1 == 0) goto L_0x01e3
            int r1 = android.view.ViewGroup.getChildMeasureSpec(r2, r8, r9)
            goto L_0x01ed
        L_0x01e3:
            int r1 = r15.r()
            r9 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r9)
        L_0x01ed:
            r3.measure(r0, r1)
            int r0 = r3.getMeasuredWidth()
            int r1 = r3.getMeasuredHeight()
            int r9 = r15.D()
            if (r0 == r9) goto L_0x022e
            r15.y0(r0)
            if (r14 == 0) goto L_0x020a
            m.n r9 = r15.x()
            r9.h(r0)
        L_0x020a:
            if (r5 == 0) goto L_0x0228
            int r0 = r15.y()
            r9 = r16
            if (r0 <= r9) goto L_0x022a
            int r0 = r15.y()
            m.e$d r13 = m.e.d.RIGHT
            m.e r13 = r15.h(r13)
            int r13 = r13.d()
            int r0 = r0 + r13
            int r16 = java.lang.Math.max(r9, r0)
            goto L_0x022c
        L_0x0228:
            r9 = r16
        L_0x022a:
            r16 = r9
        L_0x022c:
            r13 = 1
            goto L_0x0230
        L_0x022e:
            r9 = r16
        L_0x0230:
            int r0 = r15.r()
            if (r1 == r0) goto L_0x025f
            r15.b0(r1)
            if (r14 == 0) goto L_0x0242
            m.n r0 = r15.w()
            r0.h(r1)
        L_0x0242:
            if (r6 == 0) goto L_0x025e
            int r0 = r15.l()
            if (r0 <= r4) goto L_0x025e
            int r0 = r15.l()
            m.e$d r1 = m.e.d.BOTTOM
            m.e r1 = r15.h(r1)
            int r1 = r1.d()
            int r0 = r0 + r1
            int r0 = java.lang.Math.max(r4, r0)
            r4 = r0
        L_0x025e:
            r13 = 1
        L_0x025f:
            boolean r0 = r10.X
            if (r0 == 0) goto L_0x0274
            int r0 = r3.getBaseline()
            r1 = -1
            if (r0 == r1) goto L_0x0274
            int r1 = r15.j()
            if (r0 == r1) goto L_0x0274
            r15.V(r0)
            r13 = 1
        L_0x0274:
            int r0 = r3.getMeasuredState()
            int r0 = android.view.View.combineMeasuredStates(r11, r0)
            r11 = r0
            goto L_0x0282
        L_0x027e:
            r9 = r16
            r16 = r9
        L_0x0282:
            int r12 = r12 + 1
            r15 = 1073741824(0x40000000, float:2.0)
            r0 = r20
            r1 = r21
            r9 = r17
            r3 = r18
            r10 = r19
            goto L_0x0169
        L_0x0292:
            r18 = r3
            r17 = r9
            r19 = r10
            r9 = r16
            r0 = r20
            if (r13 == 0) goto L_0x02df
            m.g r1 = r0.f1594d
            r3 = r17
            r1.y0(r3)
            m.g r1 = r0.f1594d
            r3 = r19
            r1.b0(r3)
            if (r14 == 0) goto L_0x02b3
            m.g r1 = r0.f1594d
            r1.e1()
        L_0x02b3:
            java.lang.String r1 = "2nd pass"
            r0.m(r1)
            m.g r1 = r0.f1594d
            int r1 = r1.D()
            if (r1 >= r9) goto L_0x02c7
            m.g r1 = r0.f1594d
            r1.y0(r9)
            r1 = 1
            goto L_0x02c8
        L_0x02c7:
            r1 = 0
        L_0x02c8:
            m.g r3 = r0.f1594d
            int r3 = r3.r()
            if (r3 >= r4) goto L_0x02d7
            m.g r1 = r0.f1594d
            r1.b0(r4)
            r12 = 1
            goto L_0x02d8
        L_0x02d7:
            r12 = r1
        L_0x02d8:
            if (r12 == 0) goto L_0x02df
            java.lang.String r1 = "3rd pass"
            r0.m(r1)
        L_0x02df:
            r3 = r18
            r1 = 0
        L_0x02e2:
            if (r1 >= r3) goto L_0x032e
            java.util.ArrayList r4 = r0.f1593c
            java.lang.Object r4 = r4.get(r1)
            m.f r4 = (m.f) r4
            java.lang.Object r5 = r4.m()
            android.view.View r5 = (android.view.View) r5
            if (r5 != 0) goto L_0x02f9
        L_0x02f4:
            r9 = 8
        L_0x02f6:
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x032a
        L_0x02f9:
            int r6 = r5.getMeasuredWidth()
            int r9 = r4.D()
            if (r6 != r9) goto L_0x030d
            int r6 = r5.getMeasuredHeight()
            int r9 = r4.r()
            if (r6 == r9) goto L_0x02f4
        L_0x030d:
            int r6 = r4.C()
            r9 = 8
            if (r6 == r9) goto L_0x02f6
            int r6 = r4.D()
            r10 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r10)
            int r4 = r4.r()
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r10)
            r5.measure(r6, r4)
        L_0x032a:
            int r1 = r1 + 1
            goto L_0x02e2
        L_0x032d:
            r11 = 0
        L_0x032e:
            m.g r1 = r0.f1594d
            int r1 = r1.D()
            int r1 = r1 + r7
            m.g r3 = r0.f1594d
            int r3 = r3.r()
            int r3 = r3 + r8
            r4 = r21
            int r1 = android.view.View.resolveSizeAndState(r1, r4, r11)
            int r4 = r11 << 16
            int r2 = android.view.View.resolveSizeAndState(r3, r2, r4)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.f1597g
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.f1598h
            int r2 = java.lang.Math.min(r3, r2)
            m.g r3 = r0.f1594d
            boolean r3 = r3.V0()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x0364
            r1 = r1 | r4
        L_0x0364:
            m.g r3 = r0.f1594d
            boolean r3 = r3.T0()
            if (r3 == 0) goto L_0x036d
            r2 = r2 | r4
        L_0x036d:
            r0.setMeasuredDimension(r1, r2)
            r0.f1604n = r1
            r0.f1605o = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        f f10 = f(view);
        if ((view instanceof c) && !(f10 instanceof i)) {
            a aVar = (a) view.getLayoutParams();
            i iVar = new i();
            aVar.f1633l0 = iVar;
            aVar.Y = true;
            iVar.M0(aVar.S);
        }
        if (view instanceof a) {
            a aVar2 = (a) view;
            aVar2.f();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.f1592b.contains(aVar2)) {
                this.f1592b.add(aVar2);
            }
        }
        this.f1591a.put(view.getId(), view);
        this.f1599i = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1591a.remove(view.getId());
        f f10 = f(view);
        this.f1594d.L0(f10);
        this.f1592b.remove(view);
        this.f1593c.remove(f10);
        this.f1599i = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        super.requestLayout();
        this.f1599i = true;
        this.f1604n = -1;
        this.f1605o = -1;
        this.f1606p = -1;
        this.f1607q = -1;
        this.f1608r = 0;
        this.f1609s = 0;
    }

    public void setConstraintSet(b bVar) {
        this.f1601k = bVar;
    }

    public void setId(int i10) {
        this.f1591a.remove(getId());
        super.setId(i10);
        this.f1591a.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 != this.f1598h) {
            this.f1598h = i10;
            requestLayout();
        }
    }

    public void setMaxWidth(int i10) {
        if (i10 != this.f1597g) {
            this.f1597g = i10;
            requestLayout();
        }
    }

    public void setMinHeight(int i10) {
        if (i10 != this.f1596f) {
            this.f1596f = i10;
            requestLayout();
        }
    }

    public void setMinWidth(int i10) {
        if (i10 != this.f1595e) {
            this.f1595e = i10;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1594d.c1(i10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        public float C = 0.0f;
        public int D = 1;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public float O = 1.0f;
        public float P = 1.0f;
        public int Q = -1;
        public int R = -1;
        public int S = -1;
        public boolean T = false;
        public boolean U = false;
        public boolean V = true;
        public boolean W = true;
        public boolean X = false;
        public boolean Y = false;
        public boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f1610a = -1;

        /* renamed from: a0  reason: collision with root package name */
        public boolean f1611a0 = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1612b = -1;

        /* renamed from: b0  reason: collision with root package name */
        public int f1613b0 = -1;

        /* renamed from: c  reason: collision with root package name */
        public float f1614c = -1.0f;

        /* renamed from: c0  reason: collision with root package name */
        public int f1615c0 = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f1616d = -1;

        /* renamed from: d0  reason: collision with root package name */
        public int f1617d0 = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f1618e = -1;

        /* renamed from: e0  reason: collision with root package name */
        public int f1619e0 = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f1620f = -1;

        /* renamed from: f0  reason: collision with root package name */
        public int f1621f0 = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f1622g = -1;

        /* renamed from: g0  reason: collision with root package name */
        public int f1623g0 = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f1624h = -1;

        /* renamed from: h0  reason: collision with root package name */
        public float f1625h0 = 0.5f;

        /* renamed from: i  reason: collision with root package name */
        public int f1626i = -1;

        /* renamed from: i0  reason: collision with root package name */
        public int f1627i0;

        /* renamed from: j  reason: collision with root package name */
        public int f1628j = -1;

        /* renamed from: j0  reason: collision with root package name */
        public int f1629j0;

        /* renamed from: k  reason: collision with root package name */
        public int f1630k = -1;

        /* renamed from: k0  reason: collision with root package name */
        public float f1631k0;

        /* renamed from: l  reason: collision with root package name */
        public int f1632l = -1;

        /* renamed from: l0  reason: collision with root package name */
        public f f1633l0 = new f();

        /* renamed from: m  reason: collision with root package name */
        public int f1634m = -1;

        /* renamed from: m0  reason: collision with root package name */
        public boolean f1635m0 = false;

        /* renamed from: n  reason: collision with root package name */
        public int f1636n = 0;

        /* renamed from: o  reason: collision with root package name */
        public float f1637o = 0.0f;

        /* renamed from: p  reason: collision with root package name */
        public int f1638p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f1639q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f1640r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f1641s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f1642t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f1643u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f1644v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f1645w = -1;

        /* renamed from: x  reason: collision with root package name */
        public int f1646x = -1;

        /* renamed from: y  reason: collision with root package name */
        public int f1647y = -1;

        /* renamed from: z  reason: collision with root package name */
        public float f1648z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a  reason: collision with other inner class name */
        public static class C0022a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f1649a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1649a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i10;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1650a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = C0022a.f1649a.get(index);
                switch (i12) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1634m);
                        this.f1634m = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.f1634m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.f1636n = obtainStyledAttributes.getDimensionPixelSize(index, this.f1636n);
                        break;
                    case 4:
                        float f10 = obtainStyledAttributes.getFloat(index, this.f1637o) % 360.0f;
                        this.f1637o = f10;
                        if (f10 >= 0.0f) {
                            break;
                        } else {
                            this.f1637o = (360.0f - f10) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f1610a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1610a);
                        break;
                    case 6:
                        this.f1612b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1612b);
                        break;
                    case 7:
                        this.f1614c = obtainStyledAttributes.getFloat(index, this.f1614c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1616d);
                        this.f1616d = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.f1616d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1618e);
                        this.f1618e = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.f1618e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1620f);
                        this.f1620f = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.f1620f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1622g);
                        this.f1622g = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.f1622g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1624h);
                        this.f1624h = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.f1624h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1626i);
                        this.f1626i = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.f1626i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1628j);
                        this.f1628j = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.f1628j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1630k);
                        this.f1630k = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.f1630k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1632l);
                        this.f1632l = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.f1632l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f1638p);
                        this.f1638p = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.f1638p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1639q);
                        this.f1639q = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.f1639q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1640r);
                        this.f1640r = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.f1640r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1641s);
                        this.f1641s = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.f1641s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.f1642t = obtainStyledAttributes.getDimensionPixelSize(index, this.f1642t);
                        break;
                    case 22:
                        this.f1643u = obtainStyledAttributes.getDimensionPixelSize(index, this.f1643u);
                        break;
                    case 23:
                        this.f1644v = obtainStyledAttributes.getDimensionPixelSize(index, this.f1644v);
                        break;
                    case 24:
                        this.f1645w = obtainStyledAttributes.getDimensionPixelSize(index, this.f1645w);
                        break;
                    case 25:
                        this.f1646x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1646x);
                        break;
                    case 26:
                        this.f1647y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1647y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.f1648z = obtainStyledAttributes.getFloat(index, this.f1648z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i13;
                        if (i13 != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        int i14 = obtainStyledAttributes.getInt(index, 0);
                        this.J = i14;
                        if (i14 != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) != -2) {
                                break;
                            } else {
                                this.K = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) != -2) {
                                break;
                            } else {
                                this.M = -2;
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) != -2) {
                                break;
                            } else {
                                this.L = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) != -2) {
                                break;
                            } else {
                                this.N = -2;
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    default:
                        switch (i12) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string == null) {
                                    break;
                                } else {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i10 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i10 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i10, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.D != 1) {
                                                        this.C = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    } else {
                                                        this.C = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.B.substring(i10);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            this.C = Float.parseFloat(substring4);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                break;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            int i10 = this.width;
            if (i10 == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            int i11 = this.height;
            if (i11 == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (i10 == 0 || i10 == -1) {
                this.V = false;
                if (i10 == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.W = false;
                if (i11 == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.f1614c != -1.0f || this.f1610a != -1 || this.f1612b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.f1633l0 instanceof i)) {
                    this.f1633l0 = new i();
                }
                ((i) this.f1633l0).M0(this.S);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0080  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                r7 = -1
                r6.f1617d0 = r7
                r6.f1619e0 = r7
                r6.f1613b0 = r7
                r6.f1615c0 = r7
                int r2 = r6.f1642t
                r6.f1621f0 = r2
                int r2 = r6.f1644v
                r6.f1623g0 = r2
                float r2 = r6.f1648z
                r6.f1625h0 = r2
                int r2 = r6.f1610a
                r6.f1627i0 = r2
                int r2 = r6.f1612b
                r6.f1629j0 = r2
                float r2 = r6.f1614c
                r6.f1631k0 = r2
                int r2 = r6.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0032
                r2 = 1
                goto L_0x0033
            L_0x0032:
                r2 = 0
            L_0x0033:
                if (r2 == 0) goto L_0x0096
                int r2 = r6.f1638p
                if (r2 == r7) goto L_0x003d
                r6.f1617d0 = r2
            L_0x003b:
                r3 = 1
                goto L_0x0044
            L_0x003d:
                int r2 = r6.f1639q
                if (r2 == r7) goto L_0x0044
                r6.f1619e0 = r2
                goto L_0x003b
            L_0x0044:
                int r2 = r6.f1640r
                if (r2 == r7) goto L_0x004b
                r6.f1615c0 = r2
                r3 = 1
            L_0x004b:
                int r2 = r6.f1641s
                if (r2 == r7) goto L_0x0052
                r6.f1613b0 = r2
                r3 = 1
            L_0x0052:
                int r2 = r6.f1646x
                if (r2 == r7) goto L_0x0058
                r6.f1623g0 = r2
            L_0x0058:
                int r2 = r6.f1647y
                if (r2 == r7) goto L_0x005e
                r6.f1621f0 = r2
            L_0x005e:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0068
                float r3 = r6.f1648z
                float r3 = r2 - r3
                r6.f1625h0 = r3
            L_0x0068:
                boolean r3 = r6.Y
                if (r3 == 0) goto L_0x00ba
                int r3 = r6.S
                if (r3 != r4) goto L_0x00ba
                float r3 = r6.f1614c
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 == 0) goto L_0x0080
                float r2 = r2 - r3
                r6.f1631k0 = r2
                r6.f1627i0 = r7
                r6.f1629j0 = r7
                goto L_0x00ba
            L_0x0080:
                int r2 = r6.f1610a
                if (r2 == r7) goto L_0x008b
                r6.f1629j0 = r2
                r6.f1627i0 = r7
                r6.f1631k0 = r4
                goto L_0x00ba
            L_0x008b:
                int r2 = r6.f1612b
                if (r2 == r7) goto L_0x00ba
                r6.f1627i0 = r2
                r6.f1629j0 = r7
                r6.f1631k0 = r4
                goto L_0x00ba
            L_0x0096:
                int r2 = r6.f1638p
                if (r2 == r7) goto L_0x009c
                r6.f1615c0 = r2
            L_0x009c:
                int r2 = r6.f1639q
                if (r2 == r7) goto L_0x00a2
                r6.f1613b0 = r2
            L_0x00a2:
                int r2 = r6.f1640r
                if (r2 == r7) goto L_0x00a8
                r6.f1617d0 = r2
            L_0x00a8:
                int r2 = r6.f1641s
                if (r2 == r7) goto L_0x00ae
                r6.f1619e0 = r2
            L_0x00ae:
                int r2 = r6.f1646x
                if (r2 == r7) goto L_0x00b4
                r6.f1621f0 = r2
            L_0x00b4:
                int r2 = r6.f1647y
                if (r2 == r7) goto L_0x00ba
                r6.f1623g0 = r2
            L_0x00ba:
                int r2 = r6.f1640r
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1641s
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1639q
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1638p
                if (r2 != r7) goto L_0x0104
                int r2 = r6.f1620f
                if (r2 == r7) goto L_0x00d9
                r6.f1617d0 = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e7
                if (r1 <= 0) goto L_0x00e7
                r6.rightMargin = r1
                goto L_0x00e7
            L_0x00d9:
                int r2 = r6.f1622g
                if (r2 == r7) goto L_0x00e7
                r6.f1619e0 = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00e7
                if (r1 <= 0) goto L_0x00e7
                r6.rightMargin = r1
            L_0x00e7:
                int r1 = r6.f1616d
                if (r1 == r7) goto L_0x00f6
                r6.f1613b0 = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
                r6.leftMargin = r0
                goto L_0x0104
            L_0x00f6:
                int r1 = r6.f1618e
                if (r1 == r7) goto L_0x0104
                r6.f1615c0 = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0104
                if (r0 <= 0) goto L_0x0104
                r6.leftMargin = r0
            L_0x0104:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(int i10, int i11) {
            super(i10, i11);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
