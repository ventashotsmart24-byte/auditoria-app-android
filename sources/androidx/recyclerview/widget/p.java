package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class p {
    public static int a(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1;
        }
        return Math.min(mVar.n(), mVar.d(view2) - mVar.g(view));
    }

    public static int b(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z10, boolean z11) {
        int i10;
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(oVar.getPosition(view), oVar.getPosition(view2));
        int max = Math.max(oVar.getPosition(view), oVar.getPosition(view2));
        if (z11) {
            i10 = Math.max(0, (a0Var.b() - max) - 1);
        } else {
            i10 = Math.max(0, min);
        }
        if (!z10) {
            return i10;
        }
        return Math.round((((float) i10) * (((float) Math.abs(mVar.d(view2) - mVar.g(view))) / ((float) (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1)))) + ((float) (mVar.m() - mVar.g(view))));
    }

    public static int c(RecyclerView.a0 a0Var, m mVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.getChildCount() == 0 || a0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return a0Var.b();
        }
        return (int) ((((float) (mVar.d(view2) - mVar.g(view))) / ((float) (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1))) * ((float) a0Var.b()));
    }
}
