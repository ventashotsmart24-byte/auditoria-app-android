package l7;

import android.widget.TextView;
import l7.e;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f18675a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f18676b;

    public /* synthetic */ d(TextView textView, f fVar) {
        this.f18675a = textView;
        this.f18676b = fVar;
    }

    public final void run() {
        e.a.l(this.f18675a, this.f18676b);
    }
}
