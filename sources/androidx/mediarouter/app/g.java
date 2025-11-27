package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.j;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import n0.s0;
import n0.t0;

public class g extends j {

    /* renamed from: a  reason: collision with root package name */
    public final t0 f2583a;

    /* renamed from: b  reason: collision with root package name */
    public final c f2584b;

    /* renamed from: c  reason: collision with root package name */
    public Context f2585c;

    /* renamed from: d  reason: collision with root package name */
    public s0 f2586d;

    /* renamed from: e  reason: collision with root package name */
    public List f2587e;

    /* renamed from: f  reason: collision with root package name */
    public ImageButton f2588f;

    /* renamed from: g  reason: collision with root package name */
    public d f2589g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f2590h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2591i;

    /* renamed from: j  reason: collision with root package name */
    public t0.i f2592j;

    /* renamed from: k  reason: collision with root package name */
    public long f2593k;

    /* renamed from: l  reason: collision with root package name */
    public long f2594l;

    /* renamed from: m  reason: collision with root package name */
    public final Handler f2595m;

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                g.this.f((List) message.obj);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            g.this.dismiss();
        }
    }

    public final class c extends t0.b {
        public c() {
        }

        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            g.this.c();
        }

        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            g.this.c();
        }

        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            g.this.c();
        }

        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            g.this.dismiss();
        }
    }

    public final class d extends RecyclerView.g {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList f2599a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f2600b;

        /* renamed from: c  reason: collision with root package name */
        public final Drawable f2601c;

        /* renamed from: d  reason: collision with root package name */
        public final Drawable f2602d;

        /* renamed from: e  reason: collision with root package name */
        public final Drawable f2603e;

        /* renamed from: f  reason: collision with root package name */
        public final Drawable f2604f;

        public class a extends RecyclerView.d0 {

            /* renamed from: a  reason: collision with root package name */
            public TextView f2606a;

            public a(View view) {
                super(view);
                this.f2606a = (TextView) view.findViewById(R$id.mr_picker_header_name);
            }

            public void b(b bVar) {
                this.f2606a.setText(bVar.a().toString());
            }
        }

        public class b {

            /* renamed from: a  reason: collision with root package name */
            public final Object f2608a;

            /* renamed from: b  reason: collision with root package name */
            public final int f2609b;

            public b(Object obj) {
                this.f2608a = obj;
                if (obj instanceof String) {
                    this.f2609b = 1;
                } else if (obj instanceof t0.i) {
                    this.f2609b = 2;
                } else {
                    this.f2609b = 0;
                }
            }

            public Object a() {
                return this.f2608a;
            }

            public int b() {
                return this.f2609b;
            }
        }

        public class c extends RecyclerView.d0 {

            /* renamed from: a  reason: collision with root package name */
            public final View f2611a;

            /* renamed from: b  reason: collision with root package name */
            public final ImageView f2612b;

            /* renamed from: c  reason: collision with root package name */
            public final ProgressBar f2613c;

            /* renamed from: d  reason: collision with root package name */
            public final TextView f2614d;

            public class a implements View.OnClickListener {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ t0.i f2616a;

                public a(t0.i iVar) {
                    this.f2616a = iVar;
                }

                public void onClick(View view) {
                    g gVar = g.this;
                    t0.i iVar = this.f2616a;
                    gVar.f2592j = iVar;
                    iVar.I();
                    c.this.f2612b.setVisibility(4);
                    c.this.f2613c.setVisibility(0);
                }
            }

            public c(View view) {
                super(view);
                this.f2611a = view;
                this.f2612b = (ImageView) view.findViewById(R$id.mr_picker_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_picker_route_progress_bar);
                this.f2613c = progressBar;
                this.f2614d = (TextView) view.findViewById(R$id.mr_picker_route_name);
                i.t(g.this.f2585c, progressBar);
            }

            public void b(b bVar) {
                t0.i iVar = (t0.i) bVar.a();
                this.f2611a.setVisibility(0);
                this.f2613c.setVisibility(4);
                this.f2611a.setOnClickListener(new a(iVar));
                this.f2614d.setText(iVar.m());
                this.f2612b.setImageDrawable(d.this.b(iVar));
            }
        }

        public d() {
            this.f2600b = LayoutInflater.from(g.this.f2585c);
            this.f2601c = i.g(g.this.f2585c);
            this.f2602d = i.q(g.this.f2585c);
            this.f2603e = i.m(g.this.f2585c);
            this.f2604f = i.n(g.this.f2585c);
            d();
        }

        public final Drawable a(t0.i iVar) {
            int f10 = iVar.f();
            if (f10 == 1) {
                return this.f2602d;
            }
            if (f10 == 2) {
                return this.f2603e;
            }
            if (iVar.y()) {
                return this.f2604f;
            }
            return this.f2601c;
        }

        public Drawable b(t0.i iVar) {
            Uri j10 = iVar.j();
            if (j10 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(g.this.f2585c.getContentResolver().openInputStream(j10), (String) null);
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

        public b c(int i10) {
            return (b) this.f2599a.get(i10);
        }

        public void d() {
            this.f2599a.clear();
            this.f2599a.add(new b(g.this.f2585c.getString(R$string.mr_chooser_title)));
            for (t0.i bVar : g.this.f2587e) {
                this.f2599a.add(new b(bVar));
            }
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f2599a.size();
        }

        public int getItemViewType(int i10) {
            return ((b) this.f2599a.get(i10)).b();
        }

        public void onBindViewHolder(RecyclerView.d0 d0Var, int i10) {
            int itemViewType = getItemViewType(i10);
            b c10 = c(i10);
            if (itemViewType == 1) {
                ((a) d0Var).b(c10);
            } else if (itemViewType == 2) {
                ((c) d0Var).b(c10);
            }
        }

        public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 1) {
                return new a(this.f2600b.inflate(R$layout.mr_picker_header_item, viewGroup, false));
            }
            if (i10 != 2) {
                return null;
            }
            return new c(this.f2600b.inflate(R$layout.mr_picker_route_item, viewGroup, false));
        }
    }

    public static final class e implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public static final e f2618a = new e();

        /* renamed from: a */
        public int compare(t0.i iVar, t0.i iVar2) {
            return iVar.m().compareToIgnoreCase(iVar2.m());
        }
    }

    public g(Context context) {
        this(context, 0);
    }

    public boolean a(t0.i iVar) {
        if (iVar.w() || !iVar.x() || !iVar.E(this.f2586d)) {
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
        if (this.f2592j == null && this.f2591i) {
            ArrayList arrayList = new ArrayList(this.f2583a.l());
            b(arrayList);
            Collections.sort(arrayList, e.f2618a);
            if (SystemClock.uptimeMillis() - this.f2594l >= this.f2593k) {
                f(arrayList);
                return;
            }
            this.f2595m.removeMessages(1);
            Handler handler = this.f2595m;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.f2594l + this.f2593k);
        }
    }

    public void d(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f2586d.equals(s0Var)) {
            this.f2586d = s0Var;
            if (this.f2591i) {
                this.f2583a.q(this.f2584b);
                this.f2583a.b(s0Var, this.f2584b, 1);
            }
            c();
        }
    }

    public void e() {
        getWindow().setLayout(f.c(this.f2585c), f.a(this.f2585c));
    }

    public void f(List list) {
        this.f2594l = SystemClock.uptimeMillis();
        this.f2587e.clear();
        this.f2587e.addAll(list);
        this.f2589g.d();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2591i = true;
        this.f2583a.b(this.f2586d, this.f2584b, 1);
        c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_picker_dialog);
        i.s(this.f2585c, this);
        this.f2587e = new ArrayList();
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_picker_close_button);
        this.f2588f = imageButton;
        imageButton.setOnClickListener(new b());
        this.f2589g = new d();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.mr_picker_list);
        this.f2590h = recyclerView;
        recyclerView.setAdapter(this.f2589g);
        this.f2590h.setLayoutManager(new LinearLayoutManager(this.f2585c));
        e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2591i = false;
        this.f2583a.q(this.f2584b);
        this.f2595m.removeMessages(1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.i.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.i.c(r2)
            r1.<init>(r2, r3)
            n0.s0 r2 = n0.s0.f8047c
            r1.f2586d = r2
            androidx.mediarouter.app.g$a r2 = new androidx.mediarouter.app.g$a
            r2.<init>()
            r1.f2595m = r2
            android.content.Context r2 = r1.getContext()
            n0.t0 r3 = n0.t0.i(r2)
            r1.f2583a = r3
            androidx.mediarouter.app.g$c r3 = new androidx.mediarouter.app.g$c
            r3.<init>()
            r1.f2584b = r3
            r1.f2585c = r2
            android.content.res.Resources r2 = r2.getResources()
            int r3 = androidx.mediarouter.R$integer.mr_update_routes_delay_ms
            int r2 = r2.getInteger(r3)
            long r2 = (long) r2
            r1.f2593k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.g.<init>(android.content.Context, int):void");
    }
}
