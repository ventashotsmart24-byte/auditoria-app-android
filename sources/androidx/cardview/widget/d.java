package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

public abstract class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final RectF f1499a = new RectF();

    public void a(e eVar, float f10) {
        q(eVar).p(f10);
        k(eVar);
    }

    public float b(e eVar) {
        return q(eVar).g();
    }

    public void c(e eVar, float f10) {
        q(eVar).r(f10);
    }

    public float d(e eVar) {
        return q(eVar).i();
    }

    public ColorStateList e(e eVar) {
        return q(eVar).f();
    }

    public float f(e eVar) {
        return q(eVar).j();
    }

    public void g(e eVar) {
        q(eVar).m(eVar.e());
        k(eVar);
    }

    public void h(e eVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        i p10 = p(context, colorStateList, f10, f11, f12);
        p10.m(eVar.e());
        eVar.a(p10);
        k(eVar);
    }

    public float i(e eVar) {
        return q(eVar).l();
    }

    public void j(e eVar) {
    }

    public void k(e eVar) {
        Rect rect = new Rect();
        q(eVar).h(rect);
        eVar.d((int) Math.ceil((double) m(eVar)), (int) Math.ceil((double) f(eVar)));
        eVar.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float m(e eVar) {
        return q(eVar).k();
    }

    public void n(e eVar, ColorStateList colorStateList) {
        q(eVar).o(colorStateList);
    }

    public void o(e eVar, float f10) {
        q(eVar).q(f10);
        k(eVar);
    }

    public final i p(Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        return new i(context.getResources(), colorStateList, f10, f11, f12);
    }

    public final i q(e eVar) {
        return (i) eVar.c();
    }
}
