package b0;

import android.view.View;
import android.view.ViewGroup;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public int f4031a;

    /* renamed from: b  reason: collision with root package name */
    public int f4032b;

    public a0(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f4031a | this.f4032b;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f4032b = i10;
        } else {
            this.f4031a = i10;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i10) {
        if (i10 == 1) {
            this.f4032b = 0;
        } else {
            this.f4031a = 0;
        }
    }
}
