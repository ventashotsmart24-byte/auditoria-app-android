package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2987a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f2988b;

    /* renamed from: c  reason: collision with root package name */
    public int f2989c;

    /* renamed from: d  reason: collision with root package name */
    public int f2990d;

    /* renamed from: e  reason: collision with root package name */
    public int f2991e;

    /* renamed from: f  reason: collision with root package name */
    public int f2992f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f2993g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2994h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2995i;

    public boolean a(RecyclerView.a0 a0Var) {
        int i10 = this.f2989c;
        if (i10 < 0 || i10 >= a0Var.b()) {
            return false;
        }
        return true;
    }

    public View b(RecyclerView.v vVar) {
        View o10 = vVar.o(this.f2989c);
        this.f2989c += this.f2990d;
        return o10;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2988b + ", mCurrentPosition=" + this.f2989c + ", mItemDirection=" + this.f2990d + ", mLayoutDirection=" + this.f2991e + ", mStartLine=" + this.f2992f + ", mEndLine=" + this.f2993g + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
