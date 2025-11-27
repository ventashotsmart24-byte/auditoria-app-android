package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

public class w2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1414a;

    /* renamed from: b  reason: collision with root package name */
    public final View f1415b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f1416c;

    /* renamed from: d  reason: collision with root package name */
    public final WindowManager.LayoutParams f1417d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f1418e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f1419f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    public final int[] f1420g = new int[2];

    public w2(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1417d = layoutParams;
        this.f1414a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.f1415b = inflate;
        this.f1416c = (TextView) inflate.findViewById(R$id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public final void a(View view, int i10, int i11, boolean z10, WindowManager.LayoutParams layoutParams) {
        int i12;
        int i13;
        int i14;
        int i15;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1414a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1414a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            i13 = i11 + dimensionPixelOffset2;
            i12 = i11 - dimensionPixelOffset2;
        } else {
            i13 = view.getHeight();
            i12 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.f1414a.getResources();
        if (z10) {
            i14 = R$dimen.tooltip_y_offset_touch;
        } else {
            i14 = R$dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i14);
        View b10 = b(view);
        if (b10 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b10.getWindowVisibleDisplayFrame(this.f1418e);
        Rect rect = this.f1418e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.f1414a.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                i15 = resources2.getDimensionPixelSize(identifier);
            } else {
                i15 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.f1418e.set(0, i15, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b10.getLocationOnScreen(this.f1420g);
        view.getLocationOnScreen(this.f1419f);
        int[] iArr = this.f1419f;
        int i16 = iArr[0];
        int[] iArr2 = this.f1420g;
        int i17 = i16 - iArr2[0];
        iArr[0] = i17;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i17 + i10) - (b10.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1415b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1415b.getMeasuredHeight();
        int i18 = this.f1419f[1];
        int i19 = ((i12 + i18) - dimensionPixelOffset3) - measuredHeight;
        int i20 = i18 + i13 + dimensionPixelOffset3;
        if (z10) {
            if (i19 >= 0) {
                layoutParams.y = i19;
            } else {
                layoutParams.y = i20;
            }
        } else if (measuredHeight + i20 <= this.f1418e.height()) {
            layoutParams.y = i20;
        } else {
            layoutParams.y = i19;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f1414a.getSystemService("window")).removeView(this.f1415b);
        }
    }

    public boolean d() {
        if (this.f1415b.getParent() != null) {
            return true;
        }
        return false;
    }

    public void e(View view, int i10, int i11, boolean z10, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1416c.setText(charSequence);
        a(view, i10, i11, z10, this.f1417d);
        ((WindowManager) this.f1414a.getSystemService("window")).addView(this.f1415b, this.f1417d);
    }
}
