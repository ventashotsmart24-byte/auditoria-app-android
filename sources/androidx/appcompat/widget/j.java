package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.widget.g;
import s.h;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final CompoundButton f1251a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f1252b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f1253c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1254d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1255e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1256f;

    public j(CompoundButton compoundButton) {
        this.f1251a = compoundButton;
    }

    public void a() {
        Drawable a10 = g.a(this.f1251a);
        if (a10 == null) {
            return;
        }
        if (this.f1254d || this.f1255e) {
            Drawable mutate = h.r(a10).mutate();
            if (this.f1254d) {
                h.o(mutate, this.f1252b);
            }
            if (this.f1255e) {
                h.p(mutate, this.f1253c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1251a.getDrawableState());
            }
            this.f1251a.setButtonDrawable(mutate);
        }
    }

    public int b(int i10) {
        return i10;
    }

    public ColorStateList c() {
        return this.f1252b;
    }

    public PorterDuff.Mode d() {
        return this.f1253c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e A[SYNTHETIC, Splitter:B:12:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051 A[Catch:{ all -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062 A[Catch:{ all -> 0x0075 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f1251a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R$styleable.f557r
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0075 }
            boolean r0 = r4.hasValue(r5)     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x002b
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x002b
            android.widget.CompoundButton r0 = r3.f1251a     // Catch:{ NotFoundException -> 0x002a }
            android.content.Context r1 = r0.getContext()     // Catch:{ NotFoundException -> 0x002a }
            android.graphics.drawable.Drawable r5 = d.b.d(r1, r5)     // Catch:{ NotFoundException -> 0x002a }
            r0.setButtonDrawable(r5)     // Catch:{ NotFoundException -> 0x002a }
            r5 = 1
            goto L_0x002c
        L_0x002a:
        L_0x002b:
            r5 = 0
        L_0x002c:
            if (r5 != 0) goto L_0x0049
            int r5 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch:{ all -> 0x0075 }
            boolean r0 = r4.hasValue(r5)     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0049
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x0049
            android.widget.CompoundButton r0 = r3.f1251a     // Catch:{ all -> 0x0075 }
            android.content.Context r1 = r0.getContext()     // Catch:{ all -> 0x0075 }
            android.graphics.drawable.Drawable r5 = d.b.d(r1, r5)     // Catch:{ all -> 0x0075 }
            r0.setButtonDrawable(r5)     // Catch:{ all -> 0x0075 }
        L_0x0049:
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0075 }
            boolean r0 = r4.hasValue(r5)     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x005a
            android.widget.CompoundButton r0 = r3.f1251a     // Catch:{ all -> 0x0075 }
            android.content.res.ColorStateList r5 = r4.getColorStateList(r5)     // Catch:{ all -> 0x0075 }
            androidx.core.widget.g.c(r0, r5)     // Catch:{ all -> 0x0075 }
        L_0x005a:
            int r5 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0075 }
            boolean r0 = r4.hasValue(r5)     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0071
            android.widget.CompoundButton r0 = r3.f1251a     // Catch:{ all -> 0x0075 }
            r1 = -1
            int r5 = r4.getInt(r5, r1)     // Catch:{ all -> 0x0075 }
            r1 = 0
            android.graphics.PorterDuff$Mode r5 = androidx.appcompat.widget.o1.e(r5, r1)     // Catch:{ all -> 0x0075 }
            androidx.core.widget.g.d(r0, r5)     // Catch:{ all -> 0x0075 }
        L_0x0071:
            r4.recycle()
            return
        L_0x0075:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.e(android.util.AttributeSet, int):void");
    }

    public void f() {
        if (this.f1256f) {
            this.f1256f = false;
            return;
        }
        this.f1256f = true;
        a();
    }

    public void g(ColorStateList colorStateList) {
        this.f1252b = colorStateList;
        this.f1254d = true;
        a();
    }

    public void h(PorterDuff.Mode mode) {
        this.f1253c = mode;
        this.f1255e = true;
        a();
    }
}
