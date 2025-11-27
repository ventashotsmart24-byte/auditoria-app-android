package com.mobile.brasiltv.utils;

import androidx.recyclerview.widget.RecyclerView;

public class o0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f12604a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12605b = false;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f12606c;

    /* renamed from: d  reason: collision with root package name */
    public b f12607d;

    public class a extends RecyclerView.t {
        public a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (o0.this.f12604a && i10 == 0) {
                o0 o0Var = o0.this;
                if (o0Var.f(o0Var.f12606c) && !o0.this.f12605b && o0.this.f12607d != null) {
                    o0.this.f12607d.a();
                }
            }
        }
    }

    public interface b {
        void a();
    }

    public o0(RecyclerView recyclerView) {
        this.f12606c = recyclerView;
    }

    public final boolean f(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
            return true;
        }
        return false;
    }

    public void g(boolean z10) {
        this.f12605b = z10;
    }

    public void h(boolean z10) {
        this.f12604a = z10;
    }

    public void i(b bVar) {
        this.f12607d = bVar;
        this.f12606c.addOnScrollListener(new a());
    }
}
