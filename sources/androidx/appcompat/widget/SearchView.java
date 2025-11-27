package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import b0.c1;
import com.google.android.gms.actions.SearchIntents;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends u1 implements g.c {

    /* renamed from: h0  reason: collision with root package name */
    public static final k f1095h0 = new k();
    public boolean A;
    public CharSequence B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public int J;
    public SearchableInfo K;
    public Bundle L;
    public final Runnable M;
    public Runnable N;
    public final WeakHashMap O;
    public final View.OnClickListener Q;
    public View.OnKeyListener S;
    public final TextView.OnEditorActionListener V;
    public final AdapterView.OnItemClickListener W;

    /* renamed from: a  reason: collision with root package name */
    public final SearchAutoComplete f1096a;

    /* renamed from: b  reason: collision with root package name */
    public final View f1097b;

    /* renamed from: c  reason: collision with root package name */
    public final View f1098c;

    /* renamed from: d  reason: collision with root package name */
    public final View f1099d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f1100e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f1101f;

    /* renamed from: f0  reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f1102f0;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f1103g;

    /* renamed from: g0  reason: collision with root package name */
    public TextWatcher f1104g0;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f1105h;

    /* renamed from: i  reason: collision with root package name */
    public final View f1106i;

    /* renamed from: j  reason: collision with root package name */
    public p f1107j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f1108k;

    /* renamed from: l  reason: collision with root package name */
    public Rect f1109l;

    /* renamed from: m  reason: collision with root package name */
    public int[] f1110m;

    /* renamed from: n  reason: collision with root package name */
    public int[] f1111n;

    /* renamed from: o  reason: collision with root package name */
    public final ImageView f1112o;

    /* renamed from: p  reason: collision with root package name */
    public final Drawable f1113p;

    /* renamed from: q  reason: collision with root package name */
    public final int f1114q;

    /* renamed from: r  reason: collision with root package name */
    public final int f1115r;

    /* renamed from: s  reason: collision with root package name */
    public final Intent f1116s;

    /* renamed from: t  reason: collision with root package name */
    public final Intent f1117t;

    /* renamed from: u  reason: collision with root package name */
    public final CharSequence f1118u;

    /* renamed from: v  reason: collision with root package name */
    public View.OnFocusChangeListener f1119v;

    /* renamed from: w  reason: collision with root package name */
    public View.OnClickListener f1120w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1121x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f1122y;

    /* renamed from: z  reason: collision with root package name */
    public e0.a f1123z;

    public static class SearchAutoComplete extends e {

        /* renamed from: d  reason: collision with root package name */
        public int f1124d;

        /* renamed from: e  reason: collision with root package name */
        public SearchView f1125e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1126f;

        /* renamed from: g  reason: collision with root package name */
        public final Runnable f1127g;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 >= 600) {
                return 192;
            }
            if (i10 < 640 || i11 < 480) {
                return 160;
            }
            return 192;
        }

        public boolean a() {
            if (TextUtils.getTrimmedLength(getText()) == 0) {
                return true;
            }
            return false;
        }

        public void b() {
            if (this.f1126f) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1126f = false;
            }
        }

        public boolean enoughToFilter() {
            if (this.f1124d <= 0 || super.enoughToFilter()) {
                return true;
            }
            return false;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1126f) {
                removeCallbacks(this.f1127g);
                post(this.f1127g);
            }
            return onCreateInputConnection;
        }

        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f1125e.E();
        }

        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1125e.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f1125e.hasFocus() && getVisibility() == 0) {
                this.f1126f = true;
                if (SearchView.r(getContext())) {
                    SearchView.f1095h0.c(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f1126f = false;
                removeCallbacks(this.f1127g);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f1126f = false;
                removeCallbacks(this.f1127g);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f1126f = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f1125e = searchView;
        }

        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f1124d = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f1127g = new a();
            this.f1124d = getThreshold();
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.D(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            SearchView.this.K();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            e0.a aVar = SearchView.this.f1123z;
            if (aVar instanceof l2) {
                aVar.a((Cursor) null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f1119v;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.g();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f1100e) {
                searchView.A();
            } else if (view == searchView.f1103g) {
                searchView.w();
            } else if (view == searchView.f1101f) {
                searchView.B();
            } else if (view == searchView.f1105h) {
                searchView.F();
            } else if (view == searchView.f1096a) {
                searchView.m();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.K == null) {
                return false;
            }
            if (searchView.f1096a.isPopupShowing() && SearchView.this.f1096a.getListSelection() != -1) {
                return SearchView.this.C(view, i10, keyEvent);
            }
            if (SearchView.this.f1096a.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.u(0, (String) null, searchView2.f1096a.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.B();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            SearchView.this.x(i10, 0, (String) null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            SearchView.this.y(i10);
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public Method f1139a;

        /* renamed from: b  reason: collision with root package name */
        public Method f1140b;

        /* renamed from: c  reason: collision with root package name */
        public Method f1141c;

        public k() {
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1139a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = cls.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1140b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = cls.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1141c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f1140b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f1139a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView, boolean z10) {
            Method method = this.f1141c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z10)});
                } catch (Exception unused) {
                }
            }
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o extends f0.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public boolean f1142a;

        public static class a implements Parcelable.ClassLoaderCreator {
            /* renamed from: a */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            /* renamed from: c */
            public o[] newArray(int i10) {
                return new o[i10];
            }
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1142a + "}";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f1142a));
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1142a = ((Boolean) parcel.readValue((ClassLoader) null)).booleanValue();
        }
    }

    public static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final View f1143a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f1144b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        public final Rect f1145c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        public final Rect f1146d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        public final int f1147e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1148f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1147e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f1143a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f1144b.set(rect);
            this.f1146d.set(rect);
            Rect rect3 = this.f1146d;
            int i10 = this.f1147e;
            rect3.inset(-i10, -i10);
            this.f1145c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x0032
                if (r2 == r5) goto L_0x0020
                if (r2 == r3) goto L_0x0020
                r6 = 3
                if (r2 == r6) goto L_0x001b
                goto L_0x003d
            L_0x001b:
                boolean r2 = r7.f1148f
                r7.f1148f = r4
                goto L_0x002f
            L_0x0020:
                boolean r2 = r7.f1148f
                if (r2 == 0) goto L_0x002f
                android.graphics.Rect r6 = r7.f1146d
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L_0x002f
                r5 = r2
                r2 = 0
                goto L_0x003f
            L_0x002f:
                r5 = r2
            L_0x0030:
                r2 = 1
                goto L_0x003f
            L_0x0032:
                android.graphics.Rect r2 = r7.f1144b
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L_0x003d
                r7.f1148f = r5
                goto L_0x0030
            L_0x003d:
                r2 = 1
                r5 = 0
            L_0x003f:
                if (r5 == 0) goto L_0x0072
                if (r2 == 0) goto L_0x005f
                android.graphics.Rect r2 = r7.f1145c
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L_0x005f
                android.view.View r0 = r7.f1143a
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.f1143a
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L_0x006c
            L_0x005f:
                android.graphics.Rect r2 = r7.f1145c
                int r3 = r2.left
                int r0 = r0 - r3
                float r0 = (float) r0
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r8.setLocation(r0, r1)
            L_0x006c:
                android.view.View r0 = r7.f1143a
                boolean r4 = r0.dispatchTouchEvent(r8)
            L_0x0072:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.p.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    public SearchView(Context context) {
        this(context, (AttributeSet) null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    public static boolean r(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private void setQuery(CharSequence charSequence) {
        int i10;
        this.f1096a.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.f1096a;
        if (TextUtils.isEmpty(charSequence)) {
            i10 = 0;
        } else {
            i10 = charSequence.length();
        }
        searchAutoComplete.setSelection(i10);
    }

    public void A() {
        P(false);
        this.f1096a.requestFocus();
        this.f1096a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f1120w;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void B() {
        Editable text = this.f1096a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.K != null) {
                u(0, (String) null, text.toString());
            }
            this.f1096a.setImeVisibility(false);
            l();
        }
    }

    public boolean C(View view, int i10, KeyEvent keyEvent) {
        int i11;
        if (this.K != null && this.f1123z != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                return x(this.f1096a.getListSelection(), 0, (String) null);
            }
            if (i10 == 21 || i10 == 22) {
                if (i10 == 21) {
                    i11 = 0;
                } else {
                    i11 = this.f1096a.length();
                }
                this.f1096a.setSelection(i11);
                this.f1096a.setListSelection(0);
                this.f1096a.clearListSelection();
                f1095h0.c(this.f1096a, true);
                return true;
            } else if (i10 == 19) {
                this.f1096a.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void D(CharSequence charSequence) {
        Editable text = this.f1096a.getText();
        this.H = text;
        boolean z10 = !TextUtils.isEmpty(text);
        O(z10);
        Q(!z10);
        J();
        N();
        this.G = charSequence.toString();
    }

    public void E() {
        P(q());
        G();
        if (this.f1096a.hasFocus()) {
            m();
        }
    }

    public void F() {
        SearchableInfo searchableInfo = this.K;
        if (searchableInfo != null) {
            try {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(k(this.f1116s, searchableInfo));
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(j(this.f1117t, searchableInfo));
                }
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    public final void G() {
        post(this.M);
    }

    public final void H(int i10) {
        Editable text = this.f1096a.getText();
        Cursor d10 = this.f1123z.d();
        if (d10 != null) {
            if (d10.moveToPosition(i10)) {
                CharSequence b10 = this.f1123z.b(d10);
                if (b10 != null) {
                    setQuery(b10);
                } else {
                    setQuery(text);
                }
            } else {
                setQuery(text);
            }
        }
    }

    public void I(CharSequence charSequence, boolean z10) {
        this.f1096a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f1096a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.H = charSequence;
        }
        if (z10 && !TextUtils.isEmpty(charSequence)) {
            B();
        }
    }

    public final void J() {
        int[] iArr;
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1096a.getText());
        int i10 = 0;
        if (!z11 && (!this.f1121x || this.I)) {
            z10 = false;
        }
        ImageView imageView = this.f1103g;
        if (!z10) {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        Drawable drawable = this.f1103g.getDrawable();
        if (drawable != null) {
            if (z11) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    public void K() {
        int[] iArr;
        if (this.f1096a.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f1098c.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f1099d.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void L() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1096a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(o(queryHint));
    }

    public final void M() {
        this.f1096a.setThreshold(this.K.getSuggestThreshold());
        this.f1096a.setImeOptions(this.K.getImeOptions());
        int inputType = this.K.getInputType();
        int i10 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.K.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1096a.setInputType(inputType);
        e0.a aVar = this.f1123z;
        if (aVar != null) {
            aVar.a((Cursor) null);
        }
        if (this.K.getSuggestAuthority() != null) {
            l2 l2Var = new l2(getContext(), this, this.K, this.O);
            this.f1123z = l2Var;
            this.f1096a.setAdapter(l2Var);
            l2 l2Var2 = (l2) this.f1123z;
            if (this.C) {
                i10 = 2;
            }
            l2Var2.x(i10);
        }
    }

    public final void N() {
        int i10;
        if (!s() || !(this.f1101f.getVisibility() == 0 || this.f1105h.getVisibility() == 0)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        this.f1099d.setVisibility(i10);
    }

    public final void O(boolean z10) {
        int i10;
        if (!this.A || !s() || !hasFocus() || (!z10 && this.F)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        this.f1101f.setVisibility(i10);
    }

    public final void P(boolean z10) {
        int i10;
        int i11;
        this.f1122y = z10;
        int i12 = 0;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        boolean z11 = !TextUtils.isEmpty(this.f1096a.getText());
        this.f1100e.setVisibility(i10);
        O(z11);
        View view = this.f1097b;
        if (z10) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        view.setVisibility(i11);
        if (this.f1112o.getDrawable() == null || this.f1121x) {
            i12 = 8;
        }
        this.f1112o.setVisibility(i12);
        J();
        Q(!z11);
        N();
    }

    public final void Q(boolean z10) {
        int i10 = 8;
        if (this.F && !q() && z10) {
            this.f1101f.setVisibility(8);
            i10 = 0;
        }
        this.f1105h.setVisibility(i10);
    }

    public void a() {
        if (!this.I) {
            this.I = true;
            int imeOptions = this.f1096a.getImeOptions();
            this.J = imeOptions;
            this.f1096a.setImeOptions(imeOptions | 33554432);
            this.f1096a.setText("");
            setIconified(false);
        }
    }

    public void c() {
        I("", false);
        clearFocus();
        P(true);
        this.f1096a.setImeOptions(this.J);
        this.I = false;
    }

    public void clearFocus() {
        this.D = true;
        super.clearFocus();
        this.f1096a.clearFocus();
        this.f1096a.setImeVisibility(false);
        this.D = false;
    }

    public void g() {
        int i10;
        int i11;
        if (this.f1106i.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f1098c.getPaddingLeft();
            Rect rect = new Rect();
            boolean b10 = y2.b(this);
            if (this.f1121x) {
                i10 = resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R$dimen.abc_dropdownitem_text_padding_left);
            } else {
                i10 = 0;
            }
            this.f1096a.getDropDownBackground().getPadding(rect);
            if (b10) {
                i11 = -rect.left;
            } else {
                i11 = paddingLeft - (rect.left + i10);
            }
            this.f1096a.setDropDownHorizontalOffset(i11);
            this.f1096a.setDropDownWidth((((this.f1106i.getWidth() + rect.left) + rect.right) + i10) - paddingLeft);
        }
    }

    public int getImeOptions() {
        return this.f1096a.getImeOptions();
    }

    public int getInputType() {
        return this.f1096a.getInputType();
    }

    public int getMaxWidth() {
        return this.E;
    }

    public CharSequence getQuery() {
        return this.f1096a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.B;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.K;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.f1118u;
        }
        return getContext().getText(this.K.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f1115r;
    }

    public int getSuggestionRowLayout() {
        return this.f1114q;
    }

    public e0.a getSuggestionsAdapter() {
        return this.f1123z;
    }

    public final Intent h(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.H);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.L;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.K.getSearchActivity());
        return intent;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r10 = r10.getPosition();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        r11 = new java.lang.StringBuilder();
        r11.append("Search suggestions cursor at row ");
        r11.append(r10);
        r11.append(" returned exception.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent i(android.database.Cursor r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            r0 = 0
            java.lang.String r1 = "suggest_intent_action"
            java.lang.String r1 = androidx.appcompat.widget.l2.o(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            if (r1 != 0) goto L_0x000f
            android.app.SearchableInfo r1 = r9.K     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = r1.getSuggestIntentAction()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x000f:
            if (r1 != 0) goto L_0x0013
            java.lang.String r1 = "android.intent.action.SEARCH"
        L_0x0013:
            r3 = r1
            java.lang.String r1 = "suggest_intent_data"
            java.lang.String r1 = androidx.appcompat.widget.l2.o(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            if (r1 != 0) goto L_0x0022
            android.app.SearchableInfo r1 = r9.K     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = r1.getSuggestIntentData()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x0022:
            if (r1 == 0) goto L_0x0044
            java.lang.String r2 = "suggest_intent_data_id"
            java.lang.String r2 = androidx.appcompat.widget.l2.o(r10, r2)     // Catch:{ RuntimeException -> 0x0061 }
            if (r2 == 0) goto L_0x0044
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0061 }
            r4.<init>()     // Catch:{ RuntimeException -> 0x0061 }
            r4.append(r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = "/"
            r4.append(r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = android.net.Uri.encode(r2)     // Catch:{ RuntimeException -> 0x0061 }
            r4.append(r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = r4.toString()     // Catch:{ RuntimeException -> 0x0061 }
        L_0x0044:
            if (r1 != 0) goto L_0x0048
            r4 = r0
            goto L_0x004d
        L_0x0048:
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ RuntimeException -> 0x0061 }
            r4 = r1
        L_0x004d:
            java.lang.String r1 = "suggest_intent_query"
            java.lang.String r6 = androidx.appcompat.widget.l2.o(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            java.lang.String r1 = "suggest_intent_extra_data"
            java.lang.String r5 = androidx.appcompat.widget.l2.o(r10, r1)     // Catch:{ RuntimeException -> 0x0061 }
            r2 = r9
            r7 = r11
            r8 = r12
            android.content.Intent r10 = r2.h(r3, r4, r5, r6, r7, r8)     // Catch:{ RuntimeException -> 0x0061 }
            return r10
        L_0x0061:
            int r10 = r10.getPosition()     // Catch:{ RuntimeException -> 0x0066 }
            goto L_0x0067
        L_0x0066:
            r10 = -1
        L_0x0067:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Search suggestions cursor at row "
            r11.append(r12)
            r11.append(r10)
            java.lang.String r10 = " returned exception."
            r11.append(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.i(android.database.Cursor, int, java.lang.String):android.content.Intent");
    }

    public final Intent j(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i10;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, Ints.MAX_POWER_OF_TWO);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.L;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i10 = searchableInfo.getVoiceMaxResults();
        } else {
            i10 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i10);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final Intent k(Intent intent, SearchableInfo searchableInfo) {
        String str;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            str = null;
        } else {
            str = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", str);
        return intent2;
    }

    public final void l() {
        this.f1096a.dismissDropDown();
    }

    public void m() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1096a.refreshAutoCompleteResults();
            return;
        }
        k kVar = f1095h0;
        kVar.b(this.f1096a);
        kVar.a(this.f1096a);
    }

    public final void n(View view, Rect rect) {
        view.getLocationInWindow(this.f1110m);
        getLocationInWindow(this.f1111n);
        int[] iArr = this.f1110m;
        int i10 = iArr[1];
        int[] iArr2 = this.f1111n;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    public final CharSequence o(CharSequence charSequence) {
        if (!this.f1121x || this.f1113p == null) {
            return charSequence;
        }
        double textSize = (double) this.f1096a.getTextSize();
        Double.isNaN(textSize);
        int i10 = (int) (textSize * 1.25d);
        this.f1113p.setBounds(0, 0, i10, i10);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1113p), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.M);
        post(this.N);
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            n(this.f1096a, this.f1108k);
            Rect rect = this.f1109l;
            Rect rect2 = this.f1108k;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            p pVar = this.f1107j;
            if (pVar == null) {
                p pVar2 = new p(this.f1109l, this.f1108k, this.f1096a);
                this.f1107j = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.a(this.f1109l, this.f1108k);
        }
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        if (q()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            int i13 = this.E;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.E;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i12 = this.E) > 0) {
            size = Math.min(i12, size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(size2, Ints.MAX_POWER_OF_TWO));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.getSuperState());
        P(oVar.f1142a);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f1142a = q();
        return oVar;
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        G();
    }

    public final boolean p() {
        Intent intent;
        SearchableInfo searchableInfo = this.K;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.K.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1116s;
        } else if (this.K.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1117t;
        } else {
            intent = null;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    public boolean q() {
        return this.f1122y;
    }

    public boolean requestFocus(int i10, Rect rect) {
        if (this.D || !isFocusable()) {
            return false;
        }
        if (q()) {
            return super.requestFocus(i10, rect);
        }
        boolean requestFocus = this.f1096a.requestFocus(i10, rect);
        if (requestFocus) {
            P(false);
        }
        return requestFocus;
    }

    public final boolean s() {
        if ((this.A || this.F) && !q()) {
            return true;
        }
        return false;
    }

    public void setAppSearchData(Bundle bundle) {
        this.L = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            w();
        } else {
            A();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.f1121x != z10) {
            this.f1121x = z10;
            P(z10);
            L();
        }
    }

    public void setImeOptions(int i10) {
        this.f1096a.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f1096a.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.E = i10;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1119v = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1120w = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.B = charSequence;
        L();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        int i10;
        this.C = z10;
        e0.a aVar = this.f1123z;
        if (aVar instanceof l2) {
            l2 l2Var = (l2) aVar;
            if (z10) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            l2Var.x(i10);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.K = searchableInfo;
        if (searchableInfo != null) {
            M();
            L();
        }
        boolean p10 = p();
        this.F = p10;
        if (p10) {
            this.f1096a.setPrivateImeOptions("nm");
        }
        P(q());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.A = z10;
        P(q());
    }

    public void setSuggestionsAdapter(e0.a aVar) {
        this.f1123z = aVar;
        this.f1096a.setAdapter(aVar);
    }

    public final void t(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e10) {
                Log.e("SearchView", "Failed launch activity: " + intent, e10);
            }
        }
    }

    public void u(int i10, String str, String str2) {
        getContext().startActivity(h("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i10, str));
    }

    public final boolean v(int i10, int i11, String str) {
        Cursor d10 = this.f1123z.d();
        if (d10 == null || !d10.moveToPosition(i10)) {
            return false;
        }
        t(i(d10, i11, str));
        return true;
    }

    public void w() {
        if (!TextUtils.isEmpty(this.f1096a.getText())) {
            this.f1096a.setText("");
            this.f1096a.requestFocus();
            this.f1096a.setImeVisibility(true);
        } else if (this.f1121x) {
            clearFocus();
            P(true);
        }
    }

    public boolean x(int i10, int i11, String str) {
        v(i10, 0, (String) null);
        this.f1096a.setImeVisibility(false);
        l();
        return true;
    }

    public boolean y(int i10) {
        H(i10);
        return true;
    }

    public void z(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1108k = new Rect();
        this.f1109l = new Rect();
        this.f1110m = new int[2];
        this.f1111n = new int[2];
        this.M = new b();
        this.N = new c();
        this.O = new WeakHashMap();
        f fVar = new f();
        this.Q = fVar;
        this.S = new g();
        h hVar = new h();
        this.V = hVar;
        i iVar = new i();
        this.W = iVar;
        j jVar = new j();
        this.f1102f0 = jVar;
        this.f1104g0 = new a();
        r2 u10 = r2.u(context, attributeSet, R$styleable.G, i10, 0);
        LayoutInflater.from(context).inflate(u10.n(R$styleable.SearchView_layout, R$layout.abc_search_view), this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f1096a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f1097b = findViewById(R$id.search_edit_frame);
        View findViewById = findViewById(R$id.search_plate);
        this.f1098c = findViewById;
        View findViewById2 = findViewById(R$id.submit_area);
        this.f1099d = findViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.search_button);
        this.f1100e = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.search_go_btn);
        this.f1101f = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.search_close_btn);
        this.f1103g = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.search_voice_btn);
        this.f1105h = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.search_mag_icon);
        this.f1112o = imageView5;
        c1.o0(findViewById, u10.g(R$styleable.SearchView_queryBackground));
        c1.o0(findViewById2, u10.g(R$styleable.SearchView_submitBackground));
        int i11 = R$styleable.SearchView_searchIcon;
        imageView.setImageDrawable(u10.g(i11));
        imageView2.setImageDrawable(u10.g(R$styleable.SearchView_goIcon));
        imageView3.setImageDrawable(u10.g(R$styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(u10.g(R$styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(u10.g(i11));
        this.f1113p = u10.g(R$styleable.SearchView_searchHintIcon);
        u2.a(imageView, getResources().getString(R$string.abc_searchview_description_search));
        this.f1114q = u10.n(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.f1115r = u10.n(R$styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f1104g0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.S);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(u10.a(R$styleable.SearchView_iconifiedByDefault, true));
        int f10 = u10.f(R$styleable.SearchView_android_maxWidth, -1);
        if (f10 != -1) {
            setMaxWidth(f10);
        }
        this.f1118u = u10.p(R$styleable.SearchView_defaultQueryHint);
        this.B = u10.p(R$styleable.SearchView_queryHint);
        int k10 = u10.k(R$styleable.SearchView_android_imeOptions, -1);
        if (k10 != -1) {
            setImeOptions(k10);
        }
        int k11 = u10.k(R$styleable.SearchView_android_inputType, -1);
        if (k11 != -1) {
            setInputType(k11);
        }
        setFocusable(u10.a(R$styleable.SearchView_android_focusable, true));
        u10.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f1116s = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1117t = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f1106i = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        P(this.f1121x);
        L();
    }
}
