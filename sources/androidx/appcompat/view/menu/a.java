package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import s.h;
import u.b;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final int f842a;

    /* renamed from: b  reason: collision with root package name */
    public final int f843b;

    /* renamed from: c  reason: collision with root package name */
    public final int f844c;

    /* renamed from: d  reason: collision with root package name */
    public final int f845d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f846e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f847f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f848g;

    /* renamed from: h  reason: collision with root package name */
    public char f849h;

    /* renamed from: i  reason: collision with root package name */
    public int f850i = 4096;

    /* renamed from: j  reason: collision with root package name */
    public char f851j;

    /* renamed from: k  reason: collision with root package name */
    public int f852k = 4096;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f853l;

    /* renamed from: m  reason: collision with root package name */
    public int f854m = 0;

    /* renamed from: n  reason: collision with root package name */
    public Context f855n;

    /* renamed from: o  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f856o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f857p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f858q;

    /* renamed from: r  reason: collision with root package name */
    public ColorStateList f859r = null;

    /* renamed from: s  reason: collision with root package name */
    public PorterDuff.Mode f860s = null;

    /* renamed from: t  reason: collision with root package name */
    public boolean f861t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f862u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f863v = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f855n = context;
        this.f842a = i11;
        this.f843b = i10;
        this.f844c = i12;
        this.f845d = i13;
        this.f846e = charSequence;
    }

    public b0.b a() {
        return null;
    }

    public b b(b0.b bVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f853l;
        if (drawable == null) {
            return;
        }
        if (this.f861t || this.f862u) {
            Drawable r10 = h.r(drawable);
            this.f853l = r10;
            Drawable mutate = r10.mutate();
            this.f853l = mutate;
            if (this.f861t) {
                h.o(mutate, this.f859r);
            }
            if (this.f862u) {
                h.p(this.f853l, this.f860s);
            }
        }
    }

    public boolean collapseActionView() {
        return false;
    }

    /* renamed from: d */
    public b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public boolean expandActionView() {
        return false;
    }

    /* renamed from: f */
    public b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f852k;
    }

    public char getAlphabeticShortcut() {
        return this.f851j;
    }

    public CharSequence getContentDescription() {
        return this.f857p;
    }

    public int getGroupId() {
        return this.f843b;
    }

    public Drawable getIcon() {
        return this.f853l;
    }

    public ColorStateList getIconTintList() {
        return this.f859r;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f860s;
    }

    public Intent getIntent() {
        return this.f848g;
    }

    public int getItemId() {
        return this.f842a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f850i;
    }

    public char getNumericShortcut() {
        return this.f849h;
    }

    public int getOrder() {
        return this.f845d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f846e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f847f;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f846e;
    }

    public CharSequence getTooltipText() {
        return this.f858q;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        if ((this.f863v & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isChecked() {
        if ((this.f863v & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isEnabled() {
        if ((this.f863v & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        if ((this.f863v & 8) == 0) {
            return true;
        }
        return false;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.f851j = Character.toLowerCase(c10);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        this.f863v = z10 | (this.f863v & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        int i10;
        int i11 = this.f863v & -3;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        this.f863v = i10 | i11;
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        int i10;
        int i11 = this.f863v & -17;
        if (z10) {
            i10 = 16;
        } else {
            i10 = 0;
        }
        this.f863v = i10 | i11;
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f853l = drawable;
        this.f854m = 0;
        c();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f859r = colorStateList;
        this.f861t = true;
        c();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f860s = mode;
        this.f862u = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f848g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.f849h = c10;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f856o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.f849h = c10;
        this.f851j = Character.toLowerCase(c11);
        return this;
    }

    public void setShowAsAction(int i10) {
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f846e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f847f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        int i10 = 8;
        int i11 = this.f863v & 8;
        if (z10) {
            i10 = 0;
        }
        this.f863v = i11 | i10;
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f851j = Character.toLowerCase(c10);
        this.f852k = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    public b setContentDescription(CharSequence charSequence) {
        this.f857p = charSequence;
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f849h = c10;
        this.f850i = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    public MenuItem setTitle(int i10) {
        this.f846e = this.f855n.getResources().getString(i10);
        return this;
    }

    public b setTooltipText(CharSequence charSequence) {
        this.f858q = charSequence;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f849h = c10;
        this.f850i = KeyEvent.normalizeMetaState(i10);
        this.f851j = Character.toLowerCase(c11);
        this.f852k = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.f854m = i10;
        this.f853l = p.a.getDrawable(this.f855n, i10);
        c();
        return this;
    }
}
