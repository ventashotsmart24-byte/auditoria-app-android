package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.o f2999a;

    /* renamed from: b  reason: collision with root package name */
    public int f3000b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f3001c;

    public static class a extends m {
        public a(RecyclerView.o oVar) {
            super(oVar, (a) null);
        }

        public int d(View view) {
            return this.f2999a.getDecoratedRight(view) + ((RecyclerView.p) view.getLayoutParams()).rightMargin;
        }

        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2999a.getDecoratedMeasuredWidth(view) + pVar.leftMargin + pVar.rightMargin;
        }

        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2999a.getDecoratedMeasuredHeight(view) + pVar.topMargin + pVar.bottomMargin;
        }

        public int g(View view) {
            return this.f2999a.getDecoratedLeft(view) - ((RecyclerView.p) view.getLayoutParams()).leftMargin;
        }

        public int h() {
            return this.f2999a.getWidth();
        }

        public int i() {
            return this.f2999a.getWidth() - this.f2999a.getPaddingRight();
        }

        public int j() {
            return this.f2999a.getPaddingRight();
        }

        public int k() {
            return this.f2999a.getWidthMode();
        }

        public int l() {
            return this.f2999a.getHeightMode();
        }

        public int m() {
            return this.f2999a.getPaddingLeft();
        }

        public int n() {
            return (this.f2999a.getWidth() - this.f2999a.getPaddingLeft()) - this.f2999a.getPaddingRight();
        }

        public int p(View view) {
            this.f2999a.getTransformedBoundingBox(view, true, this.f3001c);
            return this.f3001c.right;
        }

        public int q(View view) {
            this.f2999a.getTransformedBoundingBox(view, true, this.f3001c);
            return this.f3001c.left;
        }

        public void r(int i10) {
            this.f2999a.offsetChildrenHorizontal(i10);
        }
    }

    public static class b extends m {
        public b(RecyclerView.o oVar) {
            super(oVar, (a) null);
        }

        public int d(View view) {
            return this.f2999a.getDecoratedBottom(view) + ((RecyclerView.p) view.getLayoutParams()).bottomMargin;
        }

        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2999a.getDecoratedMeasuredHeight(view) + pVar.topMargin + pVar.bottomMargin;
        }

        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f2999a.getDecoratedMeasuredWidth(view) + pVar.leftMargin + pVar.rightMargin;
        }

        public int g(View view) {
            return this.f2999a.getDecoratedTop(view) - ((RecyclerView.p) view.getLayoutParams()).topMargin;
        }

        public int h() {
            return this.f2999a.getHeight();
        }

        public int i() {
            return this.f2999a.getHeight() - this.f2999a.getPaddingBottom();
        }

        public int j() {
            return this.f2999a.getPaddingBottom();
        }

        public int k() {
            return this.f2999a.getHeightMode();
        }

        public int l() {
            return this.f2999a.getWidthMode();
        }

        public int m() {
            return this.f2999a.getPaddingTop();
        }

        public int n() {
            return (this.f2999a.getHeight() - this.f2999a.getPaddingTop()) - this.f2999a.getPaddingBottom();
        }

        public int p(View view) {
            this.f2999a.getTransformedBoundingBox(view, true, this.f3001c);
            return this.f3001c.bottom;
        }

        public int q(View view) {
            this.f2999a.getTransformedBoundingBox(view, true, this.f3001c);
            return this.f3001c.top;
        }

        public void r(int i10) {
            this.f2999a.offsetChildrenVertical(i10);
        }
    }

    public /* synthetic */ m(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static m a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static m b(RecyclerView.o oVar, int i10) {
        if (i10 == 0) {
            return a(oVar);
        }
        if (i10 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static m c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f3000b) {
            return 0;
        }
        return n() - this.f3000b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i10);

    public void s() {
        this.f3000b = n();
    }

    public m(RecyclerView.o oVar) {
        this.f3000b = Integer.MIN_VALUE;
        this.f3001c = new Rect();
        this.f2999a = oVar;
    }
}
