package com.github.ybq.android.spinkit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.github.ybq.android.library.R$attr;
import com.github.ybq.android.library.R$style;
import com.github.ybq.android.library.R$styleable;
import h4.e;
import i4.b;
import i4.c;
import i4.d;
import i4.f;
import i4.g;
import i4.h;
import i4.i;
import i4.j;

public class SpinKitView extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    public e4.a f5835a;

    /* renamed from: b  reason: collision with root package name */
    public int f5836b;

    /* renamed from: c  reason: collision with root package name */
    public e f5837c;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5838a;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                e4.a[] r0 = e4.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5838a = r0
                e4.a r1 = e4.a.ROTATING_PLANE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x001d }
                e4.a r1 = e4.a.DOUBLE_BOUNCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x0028 }
                e4.a r1 = e4.a.WAVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x0033 }
                e4.a r1 = e4.a.WANDERING_CUBES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x003e }
                e4.a r1 = e4.a.PULSE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x0049 }
                e4.a r1 = e4.a.CHASING_DOTS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x0054 }
                e4.a r1 = e4.a.THREE_BOUNCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x0060 }
                e4.a r1 = e4.a.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x006c }
                e4.a r1 = e4.a.CUBE_GRID     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x0078 }
                e4.a r1 = e4.a.FADING_CIRCLE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f5838a     // Catch:{ NoSuchFieldError -> 0x0084 }
                e4.a r1 = e4.a.FOLDING_CUBE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.ybq.android.spinkit.SpinKitView.a.<clinit>():void");
        }
    }

    public SpinKitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.SpinKitViewStyle);
    }

    public final void a() {
        switch (a.f5838a[this.f5835a.ordinal()]) {
            case 1:
                setIndeterminateDrawable((e) new h());
                return;
            case 2:
                setIndeterminateDrawable((e) new d());
                return;
            case 3:
                setIndeterminateDrawable((e) new h());
                return;
            case 4:
                setIndeterminateDrawable((e) new j());
                return;
            case 5:
                setIndeterminateDrawable((e) new g());
                return;
            case 6:
                setIndeterminateDrawable((e) new i4.a());
                return;
            case 7:
                setIndeterminateDrawable((e) new i());
                return;
            case 8:
                setIndeterminateDrawable((e) new b());
                return;
            case 9:
                setIndeterminateDrawable((e) new c());
                return;
            case 10:
                setIndeterminateDrawable((e) new i4.e());
                return;
            case 11:
                setIndeterminateDrawable((e) new f());
                return;
            default:
                return;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        super.setIndeterminateDrawable(drawable);
        if (drawable instanceof e) {
            setIndeterminateDrawable((e) drawable);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setIndeterminateDrawableTiled(Drawable drawable) {
        super.setIndeterminateDrawableTiled(drawable);
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R$style.SpinKitView);
    }

    public e getIndeterminateDrawable() {
        return this.f5837c;
    }

    public SpinKitView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5834a, i10, i11);
        this.f5835a = e4.a.values()[obtainStyledAttributes.getInt(R$styleable.SpinKitView_SpinKit_Style, 0)];
        this.f5836b = obtainStyledAttributes.getColor(R$styleable.SpinKitView_SpinKit_Color, -1);
        obtainStyledAttributes.recycle();
        a();
        setIndeterminate(true);
    }

    public void setIndeterminateDrawable(e eVar) {
        super.setIndeterminateDrawable(eVar);
        this.f5837c = eVar;
        eVar.t(this.f5836b);
    }
}
