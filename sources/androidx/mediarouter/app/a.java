package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.j;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import n0.s0;
import n0.t0;

public class a extends j {

    /* renamed from: a  reason: collision with root package name */
    public final t0 f2482a;

    /* renamed from: b  reason: collision with root package name */
    public final b f2483b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f2484c;

    /* renamed from: d  reason: collision with root package name */
    public s0 f2485d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f2486e;

    /* renamed from: f  reason: collision with root package name */
    public c f2487f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f2488g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2489h;

    /* renamed from: i  reason: collision with root package name */
    public long f2490i;

    /* renamed from: j  reason: collision with root package name */
    public final Handler f2491j;

    /* renamed from: androidx.mediarouter.app.a$a  reason: collision with other inner class name */
    public class C0036a extends Handler {
        public C0036a() {
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.f((List) message.obj);
            }
        }
    }

    public final class b extends t0.b {
        public b() {
        }

        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            a.this.c();
        }

        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            a.this.c();
        }

        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            a.this.c();
        }

        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            a.this.dismiss();
        }
    }

    public static final class c extends ArrayAdapter implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final LayoutInflater f2494a;

        /* renamed from: b  reason: collision with root package name */
        public final Drawable f2495b;

        /* renamed from: c  reason: collision with root package name */
        public final Drawable f2496c;

        /* renamed from: d  reason: collision with root package name */
        public final Drawable f2497d;

        /* renamed from: e  reason: collision with root package name */
        public final Drawable f2498e;

        public c(Context context, List list) {
            super(context, 0, list);
            this.f2494a = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R$attr.mediaRouteDefaultIconDrawable, R$attr.mediaRouteTvIconDrawable, R$attr.mediaRouteSpeakerIconDrawable, R$attr.mediaRouteSpeakerGroupIconDrawable});
            this.f2495b = obtainStyledAttributes.getDrawable(0);
            this.f2496c = obtainStyledAttributes.getDrawable(1);
            this.f2497d = obtainStyledAttributes.getDrawable(2);
            this.f2498e = obtainStyledAttributes.getDrawable(3);
            obtainStyledAttributes.recycle();
        }

        public final Drawable a(t0.i iVar) {
            int f10 = iVar.f();
            if (f10 == 1) {
                return this.f2496c;
            }
            if (f10 == 2) {
                return this.f2497d;
            }
            if (iVar.y()) {
                return this.f2498e;
            }
            return this.f2495b;
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public final Drawable b(t0.i iVar) {
            Uri j10 = iVar.j();
            if (j10 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(getContext().getContentResolver().openInputStream(j10), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load ");
                    sb.append(j10);
                }
            }
            return a(iVar);
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f2494a.inflate(R$layout.mr_chooser_list_item, viewGroup, false);
            }
            t0.i iVar = (t0.i) getItem(i10);
            TextView textView = (TextView) view.findViewById(R$id.mr_chooser_route_name);
            TextView textView2 = (TextView) view.findViewById(R$id.mr_chooser_route_desc);
            textView.setText(iVar.m());
            String d10 = iVar.d();
            boolean z10 = true;
            if (!(iVar.c() == 2 || iVar.c() == 1)) {
                z10 = false;
            }
            if (!z10 || TextUtils.isEmpty(d10)) {
                textView.setGravity(16);
                textView2.setVisibility(8);
                textView2.setText("");
            } else {
                textView.setGravity(80);
                textView2.setVisibility(0);
                textView2.setText(d10);
            }
            view.setEnabled(iVar.x());
            ImageView imageView = (ImageView) view.findViewById(R$id.mr_chooser_route_icon);
            if (imageView != null) {
                imageView.setImageDrawable(b(iVar));
            }
            return view;
        }

        public boolean isEnabled(int i10) {
            return ((t0.i) getItem(i10)).x();
        }

        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            t0.i iVar = (t0.i) getItem(i10);
            if (iVar.x()) {
                ((ImageView) view.findViewById(R$id.mr_chooser_route_icon)).setVisibility(8);
                ((ProgressBar) view.findViewById(R$id.mr_chooser_route_progress_bar)).setVisibility(0);
                iVar.I();
            }
        }
    }

    public static final class d implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public static final d f2499a = new d();

        /* renamed from: a */
        public int compare(t0.i iVar, t0.i iVar2) {
            return iVar.m().compareToIgnoreCase(iVar2.m());
        }
    }

    public a(Context context) {
        this(context, 0);
    }

    public boolean a(t0.i iVar) {
        if (iVar.w() || !iVar.x() || !iVar.E(this.f2485d)) {
            return false;
        }
        return true;
    }

    public void b(List list) {
        int size = list.size();
        while (true) {
            int i10 = size - 1;
            if (size > 0) {
                if (!a((t0.i) list.get(i10))) {
                    list.remove(i10);
                }
                size = i10;
            } else {
                return;
            }
        }
    }

    public void c() {
        if (this.f2489h) {
            ArrayList arrayList = new ArrayList(this.f2482a.l());
            b(arrayList);
            Collections.sort(arrayList, d.f2499a);
            if (SystemClock.uptimeMillis() - this.f2490i >= 300) {
                f(arrayList);
                return;
            }
            this.f2491j.removeMessages(1);
            Handler handler = this.f2491j;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.f2490i + 300);
        }
    }

    public void d(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f2485d.equals(s0Var)) {
            this.f2485d = s0Var;
            if (this.f2489h) {
                this.f2482a.q(this.f2483b);
                this.f2482a.b(s0Var, this.f2483b, 1);
            }
            c();
        }
    }

    public void e() {
        getWindow().setLayout(f.b(getContext()), -2);
    }

    public void f(List list) {
        this.f2490i = SystemClock.uptimeMillis();
        this.f2486e.clear();
        this.f2486e.addAll(list);
        this.f2487f.notifyDataSetChanged();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2489h = true;
        this.f2482a.b(this.f2485d, this.f2483b, 1);
        c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_chooser_dialog);
        this.f2486e = new ArrayList();
        this.f2487f = new c(getContext(), this.f2486e);
        ListView listView = (ListView) findViewById(R$id.mr_chooser_list);
        this.f2488g = listView;
        listView.setAdapter(this.f2487f);
        this.f2488g.setOnItemClickListener(this.f2487f);
        this.f2488g.setEmptyView(findViewById(16908292));
        this.f2484c = (TextView) findViewById(R$id.mr_chooser_title);
        e();
    }

    public void onDetachedFromWindow() {
        this.f2489h = false;
        this.f2482a.q(this.f2483b);
        this.f2491j.removeMessages(1);
        super.onDetachedFromWindow();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2484c.setText(charSequence);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.i.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.i.c(r2)
            r1.<init>(r2, r3)
            n0.s0 r2 = n0.s0.f8047c
            r1.f2485d = r2
            androidx.mediarouter.app.a$a r2 = new androidx.mediarouter.app.a$a
            r2.<init>()
            r1.f2491j = r2
            android.content.Context r2 = r1.getContext()
            n0.t0 r2 = n0.t0.i(r2)
            r1.f2482a = r2
            androidx.mediarouter.app.a$b r2 = new androidx.mediarouter.app.a$b
            r2.<init>()
            r1.f2483b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.a.<init>(android.content.Context, int):void");
    }

    public void setTitle(int i10) {
        this.f2484c.setText(i10);
    }
}
