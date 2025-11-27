package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

public class c implements f {
    public void a(e eVar, float f10) {
        p(eVar).h(f10);
    }

    public float b(e eVar) {
        return p(eVar).d();
    }

    public void c(e eVar, float f10) {
        eVar.f().setElevation(f10);
    }

    public float d(e eVar) {
        return p(eVar).c();
    }

    public ColorStateList e(e eVar) {
        return p(eVar).b();
    }

    public float f(e eVar) {
        return b(eVar) * 2.0f;
    }

    public void g(e eVar) {
        o(eVar, d(eVar));
    }

    public void h(e eVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        eVar.a(new h(colorStateList, f10));
        View f13 = eVar.f();
        f13.setClipToOutline(true);
        f13.setElevation(f11);
        o(eVar, f12);
    }

    public float i(e eVar) {
        return eVar.f().getElevation();
    }

    public void j(e eVar) {
        o(eVar, d(eVar));
    }

    public void k(e eVar) {
        if (!eVar.b()) {
            eVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        float d10 = d(eVar);
        float b10 = b(eVar);
        int ceil = (int) Math.ceil((double) i.c(d10, b10, eVar.e()));
        int ceil2 = (int) Math.ceil((double) i.d(d10, b10, eVar.e()));
        eVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public void l() {
    }

    public float m(e eVar) {
        return b(eVar) * 2.0f;
    }

    public void n(e eVar, ColorStateList colorStateList) {
        p(eVar).f(colorStateList);
    }

    public void o(e eVar, float f10) {
        p(eVar).g(f10, eVar.b(), eVar.e());
        k(eVar);
    }

    public final h p(e eVar) {
        return (h) eVar.c();
    }
}
