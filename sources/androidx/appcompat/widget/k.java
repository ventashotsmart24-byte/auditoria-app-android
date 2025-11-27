package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.e2;
import d.b;

public final class k {

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f1257b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public static k f1258c;

    /* renamed from: a  reason: collision with root package name */
    public e2 f1259a;

    public static class a implements e2.e {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f1260a = {R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        public final int[] f1261b = {R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        public final int[] f1262c = {R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl_dark, R$drawable.abc_text_select_handle_middle_mtrl_dark, R$drawable.abc_text_select_handle_right_mtrl_dark, R$drawable.abc_text_select_handle_left_mtrl_light, R$drawable.abc_text_select_handle_middle_mtrl_light, R$drawable.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d  reason: collision with root package name */
        public final int[] f1263d = {R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        public final int[] f1264e = {R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        public final int[] f1265f = {R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};

        public Drawable a(e2 e2Var, Context context, int i10) {
            if (i10 != R$drawable.abc_cab_background_top_material) {
                return null;
            }
            return new LayerDrawable(new Drawable[]{e2Var.j(context, R$drawable.abc_cab_background_internal_bg), e2Var.j(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
        }

        public ColorStateList b(Context context, int i10) {
            if (i10 == R$drawable.abc_edit_text_material) {
                return b.c(context, R$color.abc_tint_edittext);
            }
            if (i10 == R$drawable.abc_switch_track_mtrl_alpha) {
                return b.c(context, R$color.abc_tint_switch_track);
            }
            if (i10 == R$drawable.abc_switch_thumb_material) {
                return k(context);
            }
            if (i10 == R$drawable.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i10 == R$drawable.abc_btn_borderless_material) {
                return g(context);
            }
            if (i10 == R$drawable.abc_btn_colored_material) {
                return i(context);
            }
            if (i10 == R$drawable.abc_spinner_mtrl_am_alpha || i10 == R$drawable.abc_spinner_textfield_background_material) {
                return b.c(context, R$color.abc_tint_spinner);
            }
            if (f(this.f1261b, i10)) {
                return n2.d(context, R$attr.colorControlNormal);
            }
            if (f(this.f1264e, i10)) {
                return b.c(context, R$color.abc_tint_default);
            }
            if (f(this.f1265f, i10)) {
                return b.c(context, R$color.abc_tint_btn_checkable);
            }
            if (i10 == R$drawable.abc_seekbar_thumb_material) {
                return b.c(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.k.f1257b
                int[] r1 = r6.f1260a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L_0x0015
                int r8 = androidx.appcompat.R$attr.colorControlNormal
            L_0x0011:
                r1 = r0
            L_0x0012:
                r0 = -1
                r5 = 1
                goto L_0x0050
            L_0x0015:
                int[] r1 = r6.f1262c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x0020
                int r8 = androidx.appcompat.R$attr.colorControlActivated
                goto L_0x0011
            L_0x0020:
                int[] r1 = r6.f1263d
                boolean r1 = r6.f(r1, r8)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L_0x0032
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L_0x002d:
                r1 = r0
                r8 = 16842801(0x1010031, float:2.3693695E-38)
                goto L_0x0012
            L_0x0032:
                int r1 = androidx.appcompat.R$drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L_0x0047
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r0
                r5 = 1
                r0 = r8
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                goto L_0x0050
            L_0x0047:
                int r1 = androidx.appcompat.R$drawable.abc_dialog_material_background
                if (r8 != r1) goto L_0x004c
                goto L_0x002d
            L_0x004c:
                r1 = r0
                r8 = 0
                r0 = -1
                r5 = 0
            L_0x0050:
                if (r5 == 0) goto L_0x006d
                boolean r3 = androidx.appcompat.widget.o1.a(r9)
                if (r3 == 0) goto L_0x005c
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x005c:
                int r7 = androidx.appcompat.widget.n2.b(r7, r8)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.k.e(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r4) goto L_0x006c
                r9.setAlpha(r0)
            L_0x006c:
                return r2
            L_0x006d:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k.a.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        public PorterDuff.Mode d(int i10) {
            if (i10 == R$drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public boolean e(Context context, int i10, Drawable drawable) {
            if (i10 == R$drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i11 = R$attr.colorControlNormal;
                l(findDrawableByLayerId, n2.b(context, i11), k.f1257b);
                l(layerDrawable.findDrawableByLayerId(16908303), n2.b(context, i11), k.f1257b);
                l(layerDrawable.findDrawableByLayerId(16908301), n2.b(context, R$attr.colorControlActivated), k.f1257b);
                return true;
            } else if (i10 != R$drawable.abc_ratingbar_material && i10 != R$drawable.abc_ratingbar_indicator_material && i10 != R$drawable.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                l(layerDrawable2.findDrawableByLayerId(16908288), n2.a(context, R$attr.colorControlNormal), k.f1257b);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i12 = R$attr.colorControlActivated;
                l(findDrawableByLayerId2, n2.b(context, i12), k.f1257b);
                l(layerDrawable2.findDrawableByLayerId(16908301), n2.b(context, i12), k.f1257b);
                return true;
            }
        }

        public final boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i10) {
            int b10 = n2.b(context, R$attr.colorControlHighlight);
            int a10 = n2.a(context, R$attr.colorButtonNormal);
            return new ColorStateList(new int[][]{n2.f1287b, n2.f1290e, n2.f1288c, n2.f1294i}, new int[]{a10, r.a.i(b10, i10), r.a.i(b10, i10), i10});
        }

        public final ColorStateList i(Context context) {
            return h(context, n2.b(context, R$attr.colorAccent));
        }

        public final ColorStateList j(Context context) {
            return h(context, n2.b(context, R$attr.colorButtonNormal));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i10 = R$attr.colorSwitchThumbNormal;
            ColorStateList d10 = n2.d(context, i10);
            if (d10 == null || !d10.isStateful()) {
                iArr[0] = n2.f1287b;
                iArr2[0] = n2.a(context, i10);
                iArr[1] = n2.f1291f;
                iArr2[1] = n2.b(context, R$attr.colorControlActivated);
                iArr[2] = n2.f1294i;
                iArr2[2] = n2.b(context, i10);
            } else {
                int[] iArr3 = n2.f1287b;
                iArr[0] = iArr3;
                iArr2[0] = d10.getColorForState(iArr3, 0);
                iArr[1] = n2.f1291f;
                iArr2[1] = n2.b(context, R$attr.colorControlActivated);
                iArr[2] = n2.f1294i;
                iArr2[2] = d10.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final void l(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (o1.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = k.f1257b;
            }
            drawable.setColorFilter(k.e(i10, mode));
        }
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            if (f1258c == null) {
                h();
            }
            kVar = f1258c;
        }
        return kVar;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter l10;
        synchronized (k.class) {
            l10 = e2.l(i10, mode);
        }
        return l10;
    }

    public static synchronized void h() {
        synchronized (k.class) {
            if (f1258c == null) {
                k kVar = new k();
                f1258c = kVar;
                kVar.f1259a = e2.h();
                f1258c.f1259a.u(new a());
            }
        }
    }

    public static void i(Drawable drawable, p2 p2Var, int[] iArr) {
        e2.w(drawable, p2Var, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f1259a.j(context, i10);
    }

    public synchronized Drawable d(Context context, int i10, boolean z10) {
        return this.f1259a.k(context, i10, z10);
    }

    public synchronized ColorStateList f(Context context, int i10) {
        return this.f1259a.m(context, i10);
    }

    public synchronized void g(Context context) {
        this.f1259a.s(context);
    }
}
