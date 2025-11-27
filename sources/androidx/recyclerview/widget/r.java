package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

public abstract class r extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f3005a;

    /* renamed from: b  reason: collision with root package name */
    public Scroller f3006b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView.t f3007c = new a();

    public class a extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3008a = false;

        public a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0 && this.f3008a) {
                this.f3008a = false;
                r.this.l();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            if (i10 != 0 || i11 != 0) {
                this.f3008a = true;
            }
        }
    }

    public class b extends j {
        public b(Context context) {
            super(context);
        }

        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        public void onTargetFound(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
            r rVar = r.this;
            RecyclerView recyclerView = rVar.f3005a;
            if (recyclerView != null) {
                int[] c10 = rVar.c(recyclerView.getLayoutManager(), view);
                int i10 = c10[0];
                int i11 = c10[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i10), Math.abs(i11)));
                if (calculateTimeForDeceleration > 0) {
                    aVar.d(i10, i11, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }
        }
    }

    public boolean a(int i10, int i11) {
        RecyclerView.o layoutManager = this.f3005a.getLayoutManager();
        if (layoutManager == null || this.f3005a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f3005a.getMinFlingVelocity();
        if ((Math.abs(i11) > minFlingVelocity || Math.abs(i10) > minFlingVelocity) && k(layoutManager, i10, i11)) {
            return true;
        }
        return false;
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3005a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                g();
            }
            this.f3005a = recyclerView;
            if (recyclerView != null) {
                j();
                this.f3006b = new Scroller(this.f3005a.getContext(), new DecelerateInterpolator());
                l();
            }
        }
    }

    public abstract int[] c(RecyclerView.o oVar, View view);

    public int[] d(int i10, int i11) {
        this.f3006b.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f3006b.getFinalX(), this.f3006b.getFinalY()};
    }

    public RecyclerView.z e(RecyclerView.o oVar) {
        return f(oVar);
    }

    public j f(RecyclerView.o oVar) {
        if (!(oVar instanceof RecyclerView.z.b)) {
            return null;
        }
        return new b(this.f3005a.getContext());
    }

    public final void g() {
        this.f3005a.removeOnScrollListener(this.f3007c);
        this.f3005a.setOnFlingListener((RecyclerView.r) null);
    }

    public abstract View h(RecyclerView.o oVar);

    public abstract int i(RecyclerView.o oVar, int i10, int i11);

    public final void j() {
        if (this.f3005a.getOnFlingListener() == null) {
            this.f3005a.addOnScrollListener(this.f3007c);
            this.f3005a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    public final boolean k(RecyclerView.o oVar, int i10, int i11) {
        RecyclerView.z e10;
        int i12;
        if (!(oVar instanceof RecyclerView.z.b) || (e10 = e(oVar)) == null || (i12 = i(oVar, i10, i11)) == -1) {
            return false;
        }
        e10.setTargetPosition(i12);
        oVar.startSmoothScroll(e10);
        return true;
    }

    public void l() {
        RecyclerView.o layoutManager;
        View h10;
        RecyclerView recyclerView = this.f3005a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (h10 = h(layoutManager)) != null) {
            int[] c10 = c(layoutManager, h10);
            int i10 = c10[0];
            if (i10 != 0 || c10[1] != 0) {
                this.f3005a.smoothScrollBy(i10, c10[1]);
            }
        }
    }
}
