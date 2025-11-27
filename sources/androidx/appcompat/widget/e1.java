package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import com.uc.crashsdk.export.LogType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class e1 {

    /* renamed from: k  reason: collision with root package name */
    public static final RectF f1208k = new RectF();

    /* renamed from: l  reason: collision with root package name */
    public static ConcurrentHashMap f1209l = new ConcurrentHashMap();

    /* renamed from: m  reason: collision with root package name */
    public static ConcurrentHashMap f1210m = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public int f1211a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1212b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f1213c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f1214d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f1215e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f1216f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f1217g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f1218h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f1219i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f1220j;

    public e1(TextView textView) {
        this.f1219i = textView;
        this.f1220j = textView.getContext();
    }

    public static Method m(String str) {
        try {
            Method method = (Method) f1209l.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1209l.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r2 = new java.lang.StringBuilder();
        r2.append("Failed to invoke TextView#");
        r2.append(r3);
        r2.append("() method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object o(java.lang.Object r2, java.lang.String r3, java.lang.Object r4) {
        /*
            java.lang.reflect.Method r0 = m(r3)     // Catch:{ Exception -> 0x000e, all -> 0x000c }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000e, all -> 0x000c }
            java.lang.Object r4 = r0.invoke(r2, r1)     // Catch:{ Exception -> 0x000e, all -> 0x000c }
            goto L_0x0020
        L_0x000c:
            r2 = move-exception
            throw r2
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "Failed to invoke TextView#"
            r2.append(r0)
            r2.append(r3)
            java.lang.String r3 = "() method"
            r2.append(r3)
        L_0x0020:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e1.o(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public final boolean A() {
        return !(this.f1219i instanceof l);
    }

    public final void B(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        } else if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        } else if (f12 > 0.0f) {
            this.f1211a = 1;
            this.f1214d = f10;
            this.f1215e = f11;
            this.f1213c = f12;
            this.f1217g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
    }

    public void a() {
        boolean z10;
        int i10;
        if (p()) {
            if (this.f1212b) {
                if (this.f1219i.getMeasuredHeight() > 0 && this.f1219i.getMeasuredWidth() > 0) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        z10 = this.f1219i.isHorizontallyScrollable();
                    } else {
                        z10 = ((Boolean) o(this.f1219i, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
                    }
                    if (z10) {
                        i10 = LogType.ANR;
                    } else {
                        i10 = (this.f1219i.getMeasuredWidth() - this.f1219i.getTotalPaddingLeft()) - this.f1219i.getTotalPaddingRight();
                    }
                    int height = (this.f1219i.getHeight() - this.f1219i.getCompoundPaddingBottom()) - this.f1219i.getCompoundPaddingTop();
                    if (i10 > 0 && height > 0) {
                        RectF rectF = f1208k;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i10;
                            rectF.bottom = (float) height;
                            float g10 = (float) g(rectF);
                            if (g10 != this.f1219i.getTextSize()) {
                                v(0, g10);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1212b = true;
        }
    }

    public final int[] b(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    public final void c() {
        this.f1211a = 0;
        this.f1214d = -1.0f;
        this.f1215e = -1.0f;
        this.f1213c = -1.0f;
        this.f1216f = new int[0];
        this.f1212b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            return e(charSequence, alignment, i10, i11);
        }
        return f(charSequence, alignment, i10);
    }

    public final StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        TextDirectionHeuristic textDirectionHeuristic;
        StaticLayout.Builder a10 = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1218h, i10);
        StaticLayout.Builder a11 = a10.setAlignment(alignment).setLineSpacing(this.f1219i.getLineSpacingExtra(), this.f1219i.getLineSpacingMultiplier()).setIncludePad(this.f1219i.getIncludeFontPadding()).setBreakStrategy(this.f1219i.getBreakStrategy()).setHyphenationFrequency(this.f1219i.getHyphenationFrequency());
        if (i11 == -1) {
            i11 = Integer.MAX_VALUE;
        }
        StaticLayout.Builder unused = a11.setMaxLines(i11);
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                textDirectionHeuristic = this.f1219i.getTextDirectionHeuristic();
            } else {
                textDirectionHeuristic = (TextDirectionHeuristic) o(this.f1219i, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
            }
            StaticLayout.Builder unused2 = a10.setTextDirection(textDirectionHeuristic);
        } catch (ClassCastException unused3) {
        }
        return a10.build();
    }

    public final StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i10) {
        return new StaticLayout(charSequence, this.f1218h, i10, alignment, this.f1219i.getLineSpacingMultiplier(), this.f1219i.getLineSpacingExtra(), this.f1219i.getIncludeFontPadding());
    }

    public final int g(RectF rectF) {
        int length = this.f1216f.length;
        if (length != 0) {
            int i10 = 1;
            int i11 = length - 1;
            int i12 = 0;
            while (i10 <= i11) {
                int i13 = (i10 + i11) / 2;
                if (z(this.f1216f[i13], rectF)) {
                    int i14 = i13 + 1;
                    i12 = i10;
                    i10 = i14;
                } else {
                    i12 = i13 - 1;
                    i11 = i12;
                }
            }
            return this.f1216f[i12];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public int h() {
        return Math.round(this.f1215e);
    }

    public int i() {
        return Math.round(this.f1214d);
    }

    public int j() {
        return Math.round(this.f1213c);
    }

    public int[] k() {
        return this.f1216f;
    }

    public int l() {
        return this.f1211a;
    }

    public void n(int i10) {
        TextPaint textPaint = this.f1218h;
        if (textPaint == null) {
            this.f1218h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1218h.set(this.f1219i.getPaint());
        this.f1218h.setTextSize((float) i10);
    }

    public boolean p() {
        if (!A() || this.f1211a == 0) {
            return false;
        }
        return true;
    }

    public void q(AttributeSet attributeSet, int i10) {
        float f10;
        float f11;
        float f12;
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1220j.obtainStyledAttributes(attributeSet, R$styleable.f553n, i10, 0);
        int i11 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f1211a = obtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        if (obtainStyledAttributes.hasValue(i12)) {
            f10 = obtainStyledAttributes.getDimension(i12, -1.0f);
        } else {
            f10 = -1.0f;
        }
        int i13 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        if (obtainStyledAttributes.hasValue(i13)) {
            f11 = obtainStyledAttributes.getDimension(i13, -1.0f);
        } else {
            f11 = -1.0f;
        }
        int i14 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (obtainStyledAttributes.hasValue(i14)) {
            f12 = obtainStyledAttributes.getDimension(i14, -1.0f);
        } else {
            f12 = -1.0f;
        }
        int i15 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i15) && (resourceId = obtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            x(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!A()) {
            this.f1211a = 0;
        } else if (this.f1211a == 1) {
            if (!this.f1217g) {
                DisplayMetrics displayMetrics = this.f1220j.getResources().getDisplayMetrics();
                if (f11 == -1.0f) {
                    f11 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (f12 == -1.0f) {
                    f12 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (f10 == -1.0f) {
                    f10 = 1.0f;
                }
                B(f11, f12, f10);
            }
            w();
        }
    }

    public void r(int i10, int i11, int i12, int i13) {
        if (A()) {
            DisplayMetrics displayMetrics = this.f1220j.getResources().getDisplayMetrics();
            B(TypedValue.applyDimension(i13, (float) i10, displayMetrics), TypedValue.applyDimension(i13, (float) i11, displayMetrics), TypedValue.applyDimension(i13, (float) i12, displayMetrics));
            if (w()) {
                a();
            }
        }
    }

    public void s(int[] iArr, int i10) {
        if (A()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1220j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, (float) iArr[i11], displayMetrics));
                    }
                }
                this.f1216f = b(iArr2);
                if (!y()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1217g = false;
            }
            if (w()) {
                a();
            }
        }
    }

    public void t(int i10) {
        if (!A()) {
            return;
        }
        if (i10 == 0) {
            c();
        } else if (i10 == 1) {
            DisplayMetrics displayMetrics = this.f1220j.getResources().getDisplayMetrics();
            B(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (w()) {
                a();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
        }
    }

    public final void u(float f10) {
        if (f10 != this.f1219i.getPaint().getTextSize()) {
            this.f1219i.getPaint().setTextSize(f10);
            boolean isInLayout = this.f1219i.isInLayout();
            if (this.f1219i.getLayout() != null) {
                this.f1212b = false;
                try {
                    Method m10 = m("nullLayouts");
                    if (m10 != null) {
                        m10.invoke(this.f1219i, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (!isInLayout) {
                    this.f1219i.requestLayout();
                } else {
                    this.f1219i.forceLayout();
                }
                this.f1219i.invalidate();
            }
        }
    }

    public void v(int i10, float f10) {
        Resources resources;
        Context context = this.f1220j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        u(TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics()));
    }

    public final boolean w() {
        if (!A() || this.f1211a != 1) {
            this.f1212b = false;
        } else {
            if (!this.f1217g || this.f1216f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1215e - this.f1214d) / this.f1213c))) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f1214d + (((float) i10) * this.f1213c));
                }
                this.f1216f = b(iArr);
            }
            this.f1212b = true;
        }
        return this.f1212b;
    }

    public final void x(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f1216f = b(iArr);
            y();
        }
    }

    public final boolean y() {
        boolean z10;
        int[] iArr = this.f1216f;
        int length = iArr.length;
        if (length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f1217g = z10;
        if (z10) {
            this.f1211a = 1;
            this.f1214d = (float) iArr[0];
            this.f1215e = (float) iArr[length - 1];
            this.f1213c = -1.0f;
        }
        return z10;
    }

    public final boolean z(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1219i.getText();
        TransformationMethod transformationMethod = this.f1219i.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1219i)) == null)) {
            text = transformation;
        }
        int maxLines = this.f1219i.getMaxLines();
        n(i10);
        StaticLayout d10 = d(text, (Layout.Alignment) o(this.f1219i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        if ((maxLines == -1 || (d10.getLineCount() <= maxLines && d10.getLineEnd(d10.getLineCount() - 1) == text.length())) && ((float) d10.getHeight()) <= rectF.bottom) {
            return true;
        }
        return false;
    }
}
