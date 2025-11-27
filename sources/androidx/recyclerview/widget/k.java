package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class k extends r {

    /* renamed from: d  reason: collision with root package name */
    public m f2996d;

    /* renamed from: e  reason: collision with root package name */
    public m f2997e;

    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = n(oVar, view, q(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = n(oVar, view, r(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View h(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return p(oVar, r(oVar));
        }
        if (oVar.canScrollHorizontally()) {
            return p(oVar, q(oVar));
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r4 = r0 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i(androidx.recyclerview.widget.RecyclerView.o r9, int r10, int r11) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.recyclerview.widget.RecyclerView.z.b
            r1 = -1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r9.getItemCount()
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            android.view.View r2 = r8.h(r9)
            if (r2 != 0) goto L_0x0014
            return r1
        L_0x0014:
            int r2 = r9.getPosition(r2)
            if (r2 != r1) goto L_0x001b
            return r1
        L_0x001b:
            r3 = r9
            androidx.recyclerview.widget.RecyclerView$z$b r3 = (androidx.recyclerview.widget.RecyclerView.z.b) r3
            int r4 = r0 + -1
            android.graphics.PointF r3 = r3.computeScrollVectorForPosition(r4)
            if (r3 != 0) goto L_0x0027
            return r1
        L_0x0027:
            boolean r5 = r9.canScrollHorizontally()
            r6 = 0
            r7 = 0
            if (r5 == 0) goto L_0x003f
            androidx.recyclerview.widget.m r5 = r8.q(r9)
            int r10 = r8.o(r9, r5, r10, r7)
            float r5 = r3.x
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0040
            int r10 = -r10
            goto L_0x0040
        L_0x003f:
            r10 = 0
        L_0x0040:
            boolean r5 = r9.canScrollVertically()
            if (r5 == 0) goto L_0x0056
            androidx.recyclerview.widget.m r5 = r8.r(r9)
            int r11 = r8.o(r9, r5, r7, r11)
            float r3 = r3.y
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0057
            int r11 = -r11
            goto L_0x0057
        L_0x0056:
            r11 = 0
        L_0x0057:
            boolean r9 = r9.canScrollVertically()
            if (r9 == 0) goto L_0x005e
            r10 = r11
        L_0x005e:
            if (r10 != 0) goto L_0x0061
            return r1
        L_0x0061:
            int r2 = r2 + r10
            if (r2 >= 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r7 = r2
        L_0x0066:
            if (r7 < r0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r4 = r7
        L_0x006a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.i(androidx.recyclerview.widget.RecyclerView$o, int, int):int");
    }

    public final float m(RecyclerView.o oVar, m mVar) {
        int max;
        int childCount = oVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = oVar.getChildAt(i12);
            int position = oVar.getPosition(childAt);
            if (position != -1) {
                if (position < i10) {
                    view = childAt;
                    i10 = position;
                }
                if (position > i11) {
                    view2 = childAt;
                    i11 = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(mVar.d(view), mVar.d(view2)) - Math.min(mVar.g(view), mVar.g(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i11 - i10) + 1));
    }

    public final int n(RecyclerView.o oVar, View view, m mVar) {
        return (mVar.g(view) + (mVar.e(view) / 2)) - (mVar.m() + (mVar.n() / 2));
    }

    public final int o(RecyclerView.o oVar, m mVar, int i10, int i11) {
        int i12;
        int[] d10 = d(i10, i11);
        float m10 = m(oVar, mVar);
        if (m10 <= 0.0f) {
            return 0;
        }
        if (Math.abs(d10[0]) > Math.abs(d10[1])) {
            i12 = d10[0];
        } else {
            i12 = d10[1];
        }
        return Math.round(((float) i12) / m10);
    }

    public final View p(RecyclerView.o oVar, m mVar) {
        int childCount = oVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int m10 = mVar.m() + (mVar.n() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = oVar.getChildAt(i11);
            int abs = Math.abs((mVar.g(childAt) + (mVar.e(childAt) / 2)) - m10);
            if (abs < i10) {
                view = childAt;
                i10 = abs;
            }
        }
        return view;
    }

    public final m q(RecyclerView.o oVar) {
        m mVar = this.f2997e;
        if (mVar == null || mVar.f2999a != oVar) {
            this.f2997e = m.a(oVar);
        }
        return this.f2997e;
    }

    public final m r(RecyclerView.o oVar) {
        m mVar = this.f2996d;
        if (mVar == null || mVar.f2999a != oVar) {
            this.f2996d = m.c(oVar);
        }
        return this.f2996d;
    }
}
