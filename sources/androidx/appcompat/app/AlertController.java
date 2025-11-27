package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.u1;
import androidx.core.widget.NestedScrollView;
import b0.c1;
import java.lang.ref.WeakReference;

public class AlertController {
    public NestedScrollView A;
    public int B = 0;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int I = -1;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public int Q = 0;
    public Handler R;
    public final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Context f566a;

    /* renamed from: b  reason: collision with root package name */
    public final j f567b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f568c;

    /* renamed from: d  reason: collision with root package name */
    public final int f569d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f570e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f571f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f572g;

    /* renamed from: h  reason: collision with root package name */
    public View f573h;

    /* renamed from: i  reason: collision with root package name */
    public int f574i;

    /* renamed from: j  reason: collision with root package name */
    public int f575j;

    /* renamed from: k  reason: collision with root package name */
    public int f576k;

    /* renamed from: l  reason: collision with root package name */
    public int f577l;

    /* renamed from: m  reason: collision with root package name */
    public int f578m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f579n = false;

    /* renamed from: o  reason: collision with root package name */
    public Button f580o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f581p;

    /* renamed from: q  reason: collision with root package name */
    public Message f582q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f583r;

    /* renamed from: s  reason: collision with root package name */
    public Button f584s;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f585t;

    /* renamed from: u  reason: collision with root package name */
    public Message f586u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f587v;

    /* renamed from: w  reason: collision with root package name */
    public Button f588w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f589x;

    /* renamed from: y  reason: collision with root package name */
    public Message f590y;

    /* renamed from: z  reason: collision with root package name */
    public Drawable f591z;

    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        public final int f592a;

        /* renamed from: b  reason: collision with root package name */
        public final int f593b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.F);
            this.f593b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f592a = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z10, boolean z11) {
            int i10;
            int i11;
            if (!z11 || !z10) {
                int paddingLeft = getPaddingLeft();
                if (z10) {
                    i10 = getPaddingTop();
                } else {
                    i10 = this.f592a;
                }
                int paddingRight = getPaddingRight();
                if (z11) {
                    i11 = getPaddingBottom();
                } else {
                    i11 = this.f593b;
                }
                setPadding(paddingLeft, i10, paddingRight, i11);
            }
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f580o && (message4 = alertController.f582q) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f584s && (message3 = alertController.f586u) != null) {
                message = Message.obtain(message3);
            } else if (view != alertController.f588w || (message2 = alertController.f590y) == null) {
                message = null;
            } else {
                message = Message.obtain(message2);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f567b).sendToTarget();
        }
    }

    public class b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f595a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f596b;

        public b(View view, View view2) {
            this.f595a = view;
            this.f596b = view2;
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            AlertController.g(nestedScrollView, this.f595a, this.f596b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f598a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f599b;

        public c(View view, View view2) {
            this.f598a = view;
            this.f599b = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.A, this.f598a, this.f599b);
        }
    }

    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f601a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f602b;

        public d(View view, View view2) {
            this.f601a = view;
            this.f602b = view2;
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            AlertController.g(absListView, this.f601a, this.f602b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f604a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f605b;

        public e(View view, View view2) {
            this.f604a = view;
            this.f605b = view2;
        }

        public void run() {
            AlertController.g(AlertController.this.f572g, this.f604a, this.f605b);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public AdapterView.OnItemSelectedListener O;
        public boolean P = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f607a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f608b;

        /* renamed from: c  reason: collision with root package name */
        public int f609c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f610d;

        /* renamed from: e  reason: collision with root package name */
        public int f611e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f612f;

        /* renamed from: g  reason: collision with root package name */
        public View f613g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f614h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f615i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f616j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f617k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f618l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f619m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f620n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f621o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f622p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f623q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f624r;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f625s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f626t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f627u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f628v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f629w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f630x;

        /* renamed from: y  reason: collision with root package name */
        public int f631y;

        /* renamed from: z  reason: collision with root package name */
        public View f632z;

        public class a extends ArrayAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f633a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f633a = recycleListView;
            }

            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f633a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        public class b extends CursorAdapter {

            /* renamed from: a  reason: collision with root package name */
            public final int f635a;

            /* renamed from: b  reason: collision with root package name */
            public final int f636b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f637c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ AlertController f638d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f637c = recycleListView;
                this.f638d = alertController;
                Cursor cursor2 = getCursor();
                this.f635a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f636b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f635a));
                RecycleListView recycleListView = this.f637c;
                int position = cursor.getPosition();
                boolean z10 = true;
                if (cursor.getInt(this.f636b) != 1) {
                    z10 = false;
                }
                recycleListView.setItemChecked(position, z10);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f608b.inflate(this.f638d.M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AlertController f640a;

            public c(AlertController alertController) {
                this.f640a = alertController;
            }

            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                f.this.f630x.onClick(this.f640a.f567b, i10);
                if (!f.this.H) {
                    this.f640a.f567b.dismiss();
                }
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecycleListView f642a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AlertController f643b;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f642a = recycleListView;
                this.f643b = alertController;
            }

            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f642a.isItemChecked(i10);
                }
                f.this.J.onClick(this.f643b.f567b, i10, this.f642a.isItemChecked(i10));
            }
        }

        public f(Context context) {
            this.f607a = context;
            this.f624r = true;
            this.f608b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f613g;
            if (view != null) {
                alertController.n(view);
            } else {
                CharSequence charSequence = this.f612f;
                if (charSequence != null) {
                    alertController.s(charSequence);
                }
                Drawable drawable = this.f610d;
                if (drawable != null) {
                    alertController.p(drawable);
                }
                int i10 = this.f609c;
                if (i10 != 0) {
                    alertController.o(i10);
                }
                int i11 = this.f611e;
                if (i11 != 0) {
                    alertController.o(alertController.d(i11));
                }
            }
            CharSequence charSequence2 = this.f614h;
            if (charSequence2 != null) {
                alertController.q(charSequence2);
            }
            CharSequence charSequence3 = this.f615i;
            if (!(charSequence3 == null && this.f616j == null)) {
                alertController.l(-1, charSequence3, this.f617k, (Message) null, this.f616j);
            }
            CharSequence charSequence4 = this.f618l;
            if (!(charSequence4 == null && this.f619m == null)) {
                alertController.l(-2, charSequence4, this.f620n, (Message) null, this.f619m);
            }
            CharSequence charSequence5 = this.f621o;
            if (!(charSequence5 == null && this.f622p == null)) {
                alertController.l(-3, charSequence5, this.f623q, (Message) null, this.f622p);
            }
            if (!(this.f628v == null && this.K == null && this.f629w == null)) {
                b(alertController);
            }
            View view2 = this.f632z;
            if (view2 == null) {
                int i12 = this.f631y;
                if (i12 != 0) {
                    alertController.t(i12);
                }
            } else if (this.E) {
                alertController.v(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.u(view2);
            }
        }

        /* JADX WARNING: type inference failed for: r8v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r8v3 */
        /* JADX WARNING: type inference failed for: r8v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v22, types: [androidx.appcompat.app.AlertController$f$b] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$f$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(androidx.appcompat.app.AlertController r10) {
            /*
                r9 = this;
                android.view.LayoutInflater r0 = r9.f608b
                int r1 = r10.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r9.G
                if (r1 == 0) goto L_0x0034
                android.database.Cursor r1 = r9.K
                if (r1 != 0) goto L_0x0025
                androidx.appcompat.app.AlertController$f$a r8 = new androidx.appcompat.app.AlertController$f$a
                android.content.Context r3 = r9.f607a
                int r4 = r10.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r9.f628v
                r1 = r8
                r2 = r9
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0068
            L_0x0025:
                androidx.appcompat.app.AlertController$f$b r8 = new androidx.appcompat.app.AlertController$f$b
                android.content.Context r3 = r9.f607a
                android.database.Cursor r4 = r9.K
                r5 = 0
                r1 = r8
                r2 = r9
                r6 = r0
                r7 = r10
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0068
            L_0x0034:
                boolean r1 = r9.H
                if (r1 == 0) goto L_0x003b
                int r1 = r10.N
                goto L_0x003d
            L_0x003b:
                int r1 = r10.O
            L_0x003d:
                r4 = r1
                android.database.Cursor r1 = r9.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005a
                android.widget.SimpleCursorAdapter r8 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r9.f607a
                android.database.Cursor r5 = r9.K
                java.lang.String r1 = r9.L
                java.lang.String[] r6 = new java.lang.String[]{r1}
                int[] r7 = new int[]{r2}
                r2 = r8
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0068
            L_0x005a:
                android.widget.ListAdapter r8 = r9.f629w
                if (r8 == 0) goto L_0x005f
                goto L_0x0068
            L_0x005f:
                androidx.appcompat.app.AlertController$h r8 = new androidx.appcompat.app.AlertController$h
                android.content.Context r1 = r9.f607a
                java.lang.CharSequence[] r3 = r9.f628v
                r8.<init>(r1, r4, r2, r3)
            L_0x0068:
                r10.H = r8
                int r1 = r9.I
                r10.I = r1
                android.content.DialogInterface$OnClickListener r1 = r9.f630x
                if (r1 == 0) goto L_0x007b
                androidx.appcompat.app.AlertController$f$c r1 = new androidx.appcompat.app.AlertController$f$c
                r1.<init>(r10)
                r0.setOnItemClickListener(r1)
                goto L_0x0087
            L_0x007b:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r9.J
                if (r1 == 0) goto L_0x0087
                androidx.appcompat.app.AlertController$f$d r1 = new androidx.appcompat.app.AlertController$f$d
                r1.<init>(r0, r10)
                r0.setOnItemClickListener(r1)
            L_0x0087:
                android.widget.AdapterView$OnItemSelectedListener r1 = r9.O
                if (r1 == 0) goto L_0x008e
                r0.setOnItemSelectedListener(r1)
            L_0x008e:
                boolean r1 = r9.H
                if (r1 == 0) goto L_0x0097
                r1 = 1
                r0.setChoiceMode(r1)
                goto L_0x009f
            L_0x0097:
                boolean r1 = r9.G
                if (r1 == 0) goto L_0x009f
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x009f:
                r10.f572g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.f.b(androidx.appcompat.app.AlertController):void");
        }
    }

    public static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference f645a;

        public g(DialogInterface dialogInterface) {
            this.f645a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f645a.get(), message.what);
            } else if (i10 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class h extends ArrayAdapter {
        public h(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, j jVar, Window window) {
        this.f566a = context;
        this.f567b = jVar;
        this.f568c = window;
        this.R = new g(jVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.f546g, R$attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f569d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        jVar.supportRequestWindowFeature(1);
    }

    public static boolean B(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void g(View view, View view2, View view3) {
        int i10;
        int i11 = 0;
        if (view2 != null) {
            if (view.canScrollVertically(-1)) {
                i10 = 0;
            } else {
                i10 = 4;
            }
            view2.setVisibility(i10);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i11 = 4;
            }
            view3.setVisibility(i11);
        }
    }

    public final void A() {
        boolean z10;
        boolean z11;
        boolean z12;
        ListAdapter listAdapter;
        View findViewById;
        View view;
        View findViewById2;
        View findViewById3 = this.f568c.findViewById(R$id.parentPanel);
        int i10 = R$id.topPanel;
        View findViewById4 = findViewById3.findViewById(i10);
        int i11 = R$id.contentPanel;
        View findViewById5 = findViewById3.findViewById(i11);
        int i12 = R$id.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.customPanel);
        y(viewGroup);
        View findViewById7 = viewGroup.findViewById(i10);
        View findViewById8 = viewGroup.findViewById(i11);
        View findViewById9 = viewGroup.findViewById(i12);
        ViewGroup j10 = j(findViewById7, findViewById4);
        ViewGroup j11 = j(findViewById8, findViewById5);
        ViewGroup j12 = j(findViewById9, findViewById6);
        x(j11);
        w(j12);
        z(j10);
        char c10 = 0;
        if (viewGroup.getVisibility() != 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 == null || j10.getVisibility() == 8) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (j12 == null || j12.getVisibility() == 8) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!(z12 || j11 == null || (findViewById2 = j11.findViewById(R$id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z11) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.f571f == null && this.f572g == null) {
                view = null;
            } else {
                view = j10.findViewById(R$id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(j11 == null || (findViewById = j11.findViewById(R$id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f572g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view2 = this.f572g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z12) {
                    c10 = 2;
                }
                r(j11, view2, z11 | c10 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f572g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i13 = this.I;
            if (i13 > -1) {
                listView2.setItemChecked(i13, true);
                listView2.setSelection(i13);
            }
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public Button c(int i10) {
        if (i10 == -3) {
            return this.f588w;
        }
        if (i10 == -2) {
            return this.f584s;
        }
        if (i10 != -1) {
            return null;
        }
        return this.f580o;
    }

    public int d(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f566a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f572g;
    }

    public void f() {
        this.f567b.setContentView(k());
        A();
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean i(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public final ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int k() {
        int i10 = this.K;
        if (i10 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i10;
        }
        return this.J;
    }

    public void l(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f589x = charSequence;
            this.f590y = message;
            this.f591z = drawable;
        } else if (i10 == -2) {
            this.f585t = charSequence;
            this.f586u = message;
            this.f587v = drawable;
        } else if (i10 == -1) {
            this.f581p = charSequence;
            this.f582q = message;
            this.f583r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m(int i10) {
        this.Q = i10;
    }

    public void n(View view) {
        this.G = view;
    }

    public void o(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i10 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void p(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void q(CharSequence charSequence) {
        this.f571f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void r(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f568c.findViewById(R$id.scrollIndicatorUp);
        View findViewById2 = this.f568c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            c1.I0(view, i10, i11);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i10 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i10 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f571f != null) {
                this.A.setOnScrollChangeListener(new b(findViewById, findViewById2));
                this.A.post(new c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f572g;
            if (listView != null) {
                listView.setOnScrollListener(new d(findViewById, findViewById2));
                this.f572g.post(new e(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    public void s(CharSequence charSequence) {
        this.f570e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void t(int i10) {
        this.f573h = null;
        this.f574i = i10;
        this.f579n = false;
    }

    public void u(View view) {
        this.f573h = view;
        this.f574i = 0;
        this.f579n = false;
    }

    public void v(View view, int i10, int i11, int i12, int i13) {
        this.f573h = view;
        this.f574i = 0;
        this.f579n = true;
        this.f575j = i10;
        this.f576k = i11;
        this.f577l = i12;
        this.f578m = i13;
    }

    public final void w(ViewGroup viewGroup) {
        boolean z10;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f580o = button;
        button.setOnClickListener(this.S);
        boolean z11 = true;
        if (!TextUtils.isEmpty(this.f581p) || this.f583r != null) {
            this.f580o.setText(this.f581p);
            Drawable drawable = this.f583r;
            if (drawable != null) {
                int i10 = this.f569d;
                drawable.setBounds(0, 0, i10, i10);
                this.f580o.setCompoundDrawables(this.f583r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f580o.setVisibility(0);
            z10 = true;
        } else {
            this.f580o.setVisibility(8);
            z10 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f584s = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f585t) || this.f587v != null) {
            this.f584s.setText(this.f585t);
            Drawable drawable2 = this.f587v;
            if (drawable2 != null) {
                int i11 = this.f569d;
                drawable2.setBounds(0, 0, i11, i11);
                this.f584s.setCompoundDrawables(this.f587v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f584s.setVisibility(0);
            z10 |= true;
        } else {
            this.f584s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f588w = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f589x) || this.f591z != null) {
            this.f588w.setText(this.f589x);
            Drawable drawable3 = this.f583r;
            if (drawable3 != null) {
                int i12 = this.f569d;
                drawable3.setBounds(0, 0, i12, i12);
                this.f580o.setCompoundDrawables(this.f583r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f588w.setVisibility(0);
            z10 |= true;
        } else {
            this.f588w.setVisibility(8);
        }
        if (B(this.f566a)) {
            if (z10) {
                b(this.f580o);
            } else if (z10) {
                b(this.f584s);
            } else if (z10) {
                b(this.f588w);
            }
        }
        if (!z10) {
            z11 = false;
        }
        if (!z11) {
            viewGroup.setVisibility(8);
        }
    }

    public final void x(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f568c.findViewById(R$id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f571f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f572g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f572g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    public final void y(ViewGroup viewGroup) {
        View view = this.f573h;
        boolean z10 = false;
        if (view == null) {
            if (this.f574i != 0) {
                view = LayoutInflater.from(this.f566a).inflate(this.f574i, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z10 = true;
        }
        if (!z10 || !a(view)) {
            this.f568c.setFlags(131072, 131072);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) this.f568c.findViewById(R$id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f579n) {
                frameLayout.setPadding(this.f575j, this.f576k, this.f577l, this.f578m);
            }
            if (this.f572g != null) {
                ((u1.a) viewGroup.getLayoutParams()).f1392a = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void z(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f568c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f568c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f570e)) || !this.P) {
            this.f568c.findViewById(R$id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f568c.findViewById(R$id.alertTitle);
        this.E = textView;
        textView.setText(this.f570e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }
}
