package androidx.fragment.app;

import a0.h;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.y;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final l f2034a;

    public j(l lVar) {
        this.f2034a = lVar;
    }

    public static j b(l lVar) {
        return new j((l) h.e(lVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        l lVar = this.f2034a;
        lVar.f2069e.k(lVar, lVar, fragment);
    }

    public void c() {
        this.f2034a.f2069e.y();
    }

    public void d(Configuration configuration) {
        this.f2034a.f2069e.A(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f2034a.f2069e.B(menuItem);
    }

    public void f() {
        this.f2034a.f2069e.C();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f2034a.f2069e.D(menu, menuInflater);
    }

    public void h() {
        this.f2034a.f2069e.E();
    }

    public void i() {
        this.f2034a.f2069e.G();
    }

    public void j(boolean z10) {
        this.f2034a.f2069e.H(z10);
    }

    public boolean k(MenuItem menuItem) {
        return this.f2034a.f2069e.J(menuItem);
    }

    public void l(Menu menu) {
        this.f2034a.f2069e.K(menu);
    }

    public void m() {
        this.f2034a.f2069e.M();
    }

    public void n(boolean z10) {
        this.f2034a.f2069e.N(z10);
    }

    public boolean o(Menu menu) {
        return this.f2034a.f2069e.O(menu);
    }

    public void p() {
        this.f2034a.f2069e.Q();
    }

    public void q() {
        this.f2034a.f2069e.R();
    }

    public void r() {
        this.f2034a.f2069e.T();
    }

    public boolean s() {
        return this.f2034a.f2069e.a0(true);
    }

    public o t() {
        return this.f2034a.f2069e;
    }

    public void u() {
        this.f2034a.f2069e.T0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2034a.f2069e.u0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        l lVar = this.f2034a;
        if (lVar instanceof y) {
            lVar.f2069e.h1(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public Parcelable x() {
        return this.f2034a.f2069e.j1();
    }
}
