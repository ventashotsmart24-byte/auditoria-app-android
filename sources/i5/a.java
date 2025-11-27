package i5;

import android.content.Context;
import android.os.Bundle;
import com.mobile.brasiltv.base.R$color;
import h9.g;
import h9.h;
import t9.j;

public abstract class a extends u8.a {

    /* renamed from: b  reason: collision with root package name */
    public final g f17322b = h.b(new C0225a(this));

    /* renamed from: i5.a$a  reason: collision with other inner class name */
    public static final class C0225a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17323a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0225a(a aVar) {
            super(0);
            this.f17323a = aVar;
        }

        /* renamed from: b */
        public final a invoke() {
            return this.f17323a;
        }
    }

    public final Context Q1() {
        return (Context) this.f17322b.getValue();
    }

    public void k2() {
        m2(getResources().getColor(R$color.statusBarColor));
    }

    public final void m2(int i10) {
        n5.a.f(n5.a.f8310a, this, i10, 0, 4, (Object) null);
    }

    public final void n2() {
        n5.a.f8310a.h(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k2();
    }
}
