package c0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final int f4537a;

    /* renamed from: b  reason: collision with root package name */
    public final g0 f4538b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4539c;

    public a(int i10, g0 g0Var, int i11) {
        this.f4537a = i10;
        this.f4538b = g0Var;
        this.f4539c = i11;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f4537a);
        this.f4538b.N(this.f4539c, bundle);
    }
}
