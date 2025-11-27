package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.p;
import b0.c1;
import b0.g0;

public class x extends Spinner implements g0 {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f1421i = {16843505};

    /* renamed from: a  reason: collision with root package name */
    public final f f1422a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1423b;

    /* renamed from: c  reason: collision with root package name */
    public t1 f1424c;

    /* renamed from: d  reason: collision with root package name */
    public SpinnerAdapter f1425d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1426e;

    /* renamed from: f  reason: collision with root package name */
    public g f1427f;

    /* renamed from: g  reason: collision with root package name */
    public int f1428g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f1429h;

    public class a extends t1 {

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ e f1430j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view, e eVar) {
            super(view);
            this.f1430j = eVar;
        }

        public p b() {
            return this.f1430j;
        }

        public boolean c() {
            if (x.this.getInternalPopup().isShowing()) {
                return true;
            }
            x.this.b();
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public void onGlobalLayout() {
            if (!x.this.getInternalPopup().isShowing()) {
                x.this.b();
            }
            ViewTreeObserver viewTreeObserver = x.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public class c implements g, DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public androidx.appcompat.app.c f1433a;

        /* renamed from: b  reason: collision with root package name */
        public ListAdapter f1434b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f1435c;

        public c() {
        }

        public int a() {
            return 0;
        }

        public void c(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public CharSequence d() {
            return this.f1435c;
        }

        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f1433a;
            if (cVar != null) {
                cVar.dismiss();
                this.f1433a = null;
            }
        }

        public Drawable e() {
            return null;
        }

        public void f(CharSequence charSequence) {
            this.f1435c = charSequence;
        }

        public void g(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void h(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void i(int i10, int i11) {
            if (this.f1434b != null) {
                c.a aVar = new c.a(x.this.getPopupContext());
                CharSequence charSequence = this.f1435c;
                if (charSequence != null) {
                    aVar.setTitle(charSequence);
                }
                androidx.appcompat.app.c create = aVar.setSingleChoiceItems(this.f1434b, x.this.getSelectedItemPosition(), (DialogInterface.OnClickListener) this).create();
                this.f1433a = create;
                ListView listView = create.getListView();
                listView.setTextDirection(i10);
                listView.setTextAlignment(i11);
                this.f1433a.show();
            }
        }

        public boolean isShowing() {
            androidx.appcompat.app.c cVar = this.f1433a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        public int j() {
            return 0;
        }

        public void k(ListAdapter listAdapter) {
            this.f1434b = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            x.this.setSelection(i10);
            if (x.this.getOnItemClickListener() != null) {
                x.this.performItemClick((View) null, i10, this.f1434b.getItemId(i10));
            }
            dismiss();
        }

        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }
    }

    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public SpinnerAdapter f1437a;

        /* renamed from: b  reason: collision with root package name */
        public ListAdapter f1438b;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1437a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1438b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && y.a(spinnerAdapter)) {
                ThemedSpinnerAdapter a10 = z.a(spinnerAdapter);
                if (a10.getDropDownViewTheme() != theme) {
                    a10.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1438b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i10);
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter == null || !spinnerAdapter.hasStableIds()) {
                return false;
            }
            return true;
        }

        public boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f1438b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1437a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class e extends y1 implements g {
        public CharSequence K;
        public ListAdapter L;
        public final Rect M = new Rect();
        public int N;

        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ x f1439a;

            public a(x xVar) {
                this.f1439a = xVar;
            }

            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                x.this.setSelection(i10);
                if (x.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    x.this.performItemClick(view, i10, eVar.L.getItemId(i10));
                }
                e.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.N(x.this)) {
                    e.this.dismiss();
                    return;
                }
                e.this.L();
                e.super.show();
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1442a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1442a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = x.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1442a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            w(x.this);
            C(true);
            H(0);
            E(new a(x.this));
        }

        public void L() {
            int i10;
            int i11;
            Drawable e10 = e();
            if (e10 != null) {
                e10.getPadding(x.this.f1429h);
                if (y2.b(x.this)) {
                    i10 = x.this.f1429h.right;
                } else {
                    i10 = -x.this.f1429h.left;
                }
            } else {
                Rect rect = x.this.f1429h;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = x.this.getPaddingLeft();
            int paddingRight = x.this.getPaddingRight();
            int width = x.this.getWidth();
            x xVar = x.this;
            int i12 = xVar.f1428g;
            if (i12 == -2) {
                int a10 = xVar.a((SpinnerAdapter) this.L, e());
                int i13 = x.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = x.this.f1429h;
                int i14 = (i13 - rect2.left) - rect2.right;
                if (a10 > i14) {
                    a10 = i14;
                }
                y(Math.max(a10, (width - paddingLeft) - paddingRight));
            } else if (i12 == -1) {
                y((width - paddingLeft) - paddingRight);
            } else {
                y(i12);
            }
            if (y2.b(x.this)) {
                i11 = i10 + (((width - paddingRight) - s()) - M());
            } else {
                i11 = i10 + paddingLeft + M();
            }
            c(i11);
        }

        public int M() {
            return this.N;
        }

        public boolean N(View view) {
            if (!c1.P(view) || !view.getGlobalVisibleRect(this.M)) {
                return false;
            }
            return true;
        }

        public CharSequence d() {
            return this.K;
        }

        public void f(CharSequence charSequence) {
            this.K = charSequence;
        }

        public void h(int i10) {
            this.N = i10;
        }

        public void i(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            L();
            B(2);
            super.show();
            ListView m10 = m();
            m10.setChoiceMode(1);
            m10.setTextDirection(i10);
            m10.setTextAlignment(i11);
            I(x.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = x.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                D(new c(bVar));
            }
        }

        public void k(ListAdapter listAdapter) {
            super.k(listAdapter);
            this.L = listAdapter;
        }
    }

    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public boolean f1444a;

        public static class a implements Parcelable.Creator {
            /* renamed from: a */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            /* renamed from: b */
            public f[] newArray(int i10) {
                return new f[i10];
            }
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f1444a ? (byte) 1 : 0);
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f1444a = parcel.readByte() != 0;
        }
    }

    public interface g {
        int a();

        void c(int i10);

        CharSequence d();

        void dismiss();

        Drawable e();

        void f(CharSequence charSequence);

        void g(int i10);

        void h(int i10);

        void i(int i10, int i11);

        boolean isShowing();

        int j();

        void k(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        drawable.getPadding(this.f1429h);
        Rect rect = this.f1429h;
        return i11 + rect.left + rect.right;
    }

    public void b() {
        this.f1427f.i(getTextDirection(), getTextAlignment());
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1422a;
        if (fVar != null) {
            fVar.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        g gVar = this.f1427f;
        if (gVar != null) {
            return gVar.a();
        }
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        g gVar = this.f1427f;
        if (gVar != null) {
            return gVar.j();
        }
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.f1427f != null) {
            return this.f1428g;
        }
        return super.getDropDownWidth();
    }

    public final g getInternalPopup() {
        return this.f1427f;
    }

    public Drawable getPopupBackground() {
        g gVar = this.f1427f;
        if (gVar != null) {
            return gVar.e();
        }
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f1423b;
    }

    public CharSequence getPrompt() {
        g gVar = this.f1427f;
        if (gVar != null) {
            return gVar.d();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1422a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1422a;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f1427f;
        if (gVar != null && gVar.isShowing()) {
            this.f1427f.dismiss();
        }
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f1427f != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (fVar.f1444a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    public Parcelable onSaveInstanceState() {
        boolean z10;
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f1427f;
        if (gVar == null || !gVar.isShowing()) {
            z10 = false;
        } else {
            z10 = true;
        }
        fVar.f1444a = z10;
        return fVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t1 t1Var = this.f1424c;
        if (t1Var == null || !t1Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        g gVar = this.f1427f;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.isShowing()) {
            return true;
        }
        b();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1422a;
        if (fVar != null) {
            fVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        f fVar = this.f1422a;
        if (fVar != null) {
            fVar.g(i10);
        }
    }

    public void setDropDownHorizontalOffset(int i10) {
        g gVar = this.f1427f;
        if (gVar != null) {
            gVar.h(i10);
            this.f1427f.c(i10);
            return;
        }
        super.setDropDownHorizontalOffset(i10);
    }

    public void setDropDownVerticalOffset(int i10) {
        g gVar = this.f1427f;
        if (gVar != null) {
            gVar.g(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    public void setDropDownWidth(int i10) {
        if (this.f1427f != null) {
            this.f1428g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f1427f;
        if (gVar != null) {
            gVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(d.b.d(getPopupContext(), i10));
    }

    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f1427f;
        if (gVar != null) {
            gVar.f(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1422a;
        if (fVar != null) {
            fVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1422a;
        if (fVar != null) {
            fVar.j(mode);
        }
    }

    public x(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1426e) {
            this.f1425d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1427f != null) {
            Context context = this.f1423b;
            if (context == null) {
                context = getContext();
            }
            this.f1427f.k(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public x(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r10 != null) goto L_0x0048;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public x(android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.f1429h = r0
            int[] r0 = androidx.appcompat.R$styleable.H
            r1 = 0
            androidx.appcompat.widget.r2 r0 = androidx.appcompat.widget.r2.u(r6, r7, r0, r8, r1)
            androidx.appcompat.widget.f r2 = new androidx.appcompat.widget.f
            r2.<init>(r5)
            r5.f1422a = r2
            if (r10 == 0) goto L_0x0022
            g.d r2 = new g.d
            r2.<init>((android.content.Context) r6, (android.content.res.Resources.Theme) r10)
            r5.f1423b = r2
            goto L_0x0034
        L_0x0022:
            int r10 = androidx.appcompat.R$styleable.Spinner_popupTheme
            int r10 = r0.n(r10, r1)
            if (r10 == 0) goto L_0x0032
            g.d r2 = new g.d
            r2.<init>((android.content.Context) r6, (int) r10)
            r5.f1423b = r2
            goto L_0x0034
        L_0x0032:
            r5.f1423b = r6
        L_0x0034:
            r10 = -1
            r2 = 0
            if (r9 != r10) goto L_0x005a
            int[] r10 = f1421i     // Catch:{ Exception -> 0x0056, all -> 0x004f }
            android.content.res.TypedArray r10 = r6.obtainStyledAttributes(r7, r10, r8, r1)     // Catch:{ Exception -> 0x0056, all -> 0x004f }
            boolean r3 = r10.hasValue(r1)     // Catch:{ Exception -> 0x0057, all -> 0x004c }
            if (r3 == 0) goto L_0x0048
            int r9 = r10.getInt(r1, r1)     // Catch:{ Exception -> 0x0057, all -> 0x004c }
        L_0x0048:
            r10.recycle()
            goto L_0x005a
        L_0x004c:
            r6 = move-exception
            r2 = r10
            goto L_0x0050
        L_0x004f:
            r6 = move-exception
        L_0x0050:
            if (r2 == 0) goto L_0x0055
            r2.recycle()
        L_0x0055:
            throw r6
        L_0x0056:
            r10 = r2
        L_0x0057:
            if (r10 == 0) goto L_0x005a
            goto L_0x0048
        L_0x005a:
            r10 = 1
            if (r9 == 0) goto L_0x0097
            if (r9 == r10) goto L_0x0060
            goto L_0x00a7
        L_0x0060:
            androidx.appcompat.widget.x$e r9 = new androidx.appcompat.widget.x$e
            android.content.Context r3 = r5.f1423b
            r9.<init>(r3, r7, r8)
            android.content.Context r3 = r5.f1423b
            int[] r4 = androidx.appcompat.R$styleable.H
            androidx.appcompat.widget.r2 r1 = androidx.appcompat.widget.r2.u(r3, r7, r4, r8, r1)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.m(r3, r4)
            r5.f1428g = r3
            int r3 = androidx.appcompat.R$styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r9.setBackgroundDrawable(r3)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r3 = r0.o(r3)
            r9.f(r3)
            r1.v()
            r5.f1427f = r9
            androidx.appcompat.widget.x$a r1 = new androidx.appcompat.widget.x$a
            r1.<init>(r5, r9)
            r5.f1424c = r1
            goto L_0x00a7
        L_0x0097:
            androidx.appcompat.widget.x$c r9 = new androidx.appcompat.widget.x$c
            r9.<init>()
            r5.f1427f = r9
            int r1 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r1 = r0.o(r1)
            r9.f(r1)
        L_0x00a7:
            int r9 = androidx.appcompat.R$styleable.Spinner_android_entries
            java.lang.CharSequence[] r9 = r0.q(r9)
            if (r9 == 0) goto L_0x00bf
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r6, r3, r9)
            int r6 = androidx.appcompat.R$layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r6)
            r5.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00bf:
            r0.v()
            r5.f1426e = r10
            android.widget.SpinnerAdapter r6 = r5.f1425d
            if (r6 == 0) goto L_0x00cd
            r5.setAdapter((android.widget.SpinnerAdapter) r6)
            r5.f1425d = r2
        L_0x00cd:
            androidx.appcompat.widget.f r6 = r5.f1422a
            r6.e(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
