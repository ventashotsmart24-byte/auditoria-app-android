package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.n;
import b0.b;
import s.h;
import u.b;

public final class i implements b {
    public View A;
    public b0.b B;
    public MenuItem.OnActionExpandListener C;
    public boolean D = false;
    public ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    public final int f934a;

    /* renamed from: b  reason: collision with root package name */
    public final int f935b;

    /* renamed from: c  reason: collision with root package name */
    public final int f936c;

    /* renamed from: d  reason: collision with root package name */
    public final int f937d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f938e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f939f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f940g;

    /* renamed from: h  reason: collision with root package name */
    public char f941h;

    /* renamed from: i  reason: collision with root package name */
    public int f942i = 4096;

    /* renamed from: j  reason: collision with root package name */
    public char f943j;

    /* renamed from: k  reason: collision with root package name */
    public int f944k = 4096;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f945l;

    /* renamed from: m  reason: collision with root package name */
    public int f946m = 0;

    /* renamed from: n  reason: collision with root package name */
    public g f947n;

    /* renamed from: o  reason: collision with root package name */
    public r f948o;

    /* renamed from: p  reason: collision with root package name */
    public Runnable f949p;

    /* renamed from: q  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f950q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f951r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f952s;

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f953t = null;

    /* renamed from: u  reason: collision with root package name */
    public PorterDuff.Mode f954u = null;

    /* renamed from: v  reason: collision with root package name */
    public boolean f955v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f956w = false;

    /* renamed from: x  reason: collision with root package name */
    public boolean f957x = false;

    /* renamed from: y  reason: collision with root package name */
    public int f958y = 16;

    /* renamed from: z  reason: collision with root package name */
    public int f959z;

    public class a implements b.C0066b {
        public a() {
        }

        public void onActionProviderVisibilityChanged(boolean z10) {
            i iVar = i.this;
            iVar.f947n.onItemVisibleChanged(iVar);
        }
    }

    public i(g gVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f947n = gVar;
        this.f934a = i11;
        this.f935b = i10;
        this.f936c = i12;
        this.f937d = i13;
        this.f938e = charSequence;
        this.f959z = i14;
    }

    public static void d(StringBuilder sb, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb.append(str);
        }
    }

    public boolean A() {
        if (!this.f947n.isShortcutsVisible() || g() == 0) {
            return false;
        }
        return true;
    }

    public boolean B() {
        if ((this.f959z & 4) == 4) {
            return true;
        }
        return false;
    }

    public b0.b a() {
        return this.B;
    }

    public u.b b(b0.b bVar) {
        b0.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.j();
        }
        this.A = null;
        this.B = bVar;
        this.f947n.onItemsChanged(true);
        b0.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.l(new a());
        }
        return this;
    }

    public void c() {
        this.f947n.onItemActionRequestChanged(this);
    }

    public boolean collapseActionView() {
        if ((this.f959z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f947n.collapseItemActionView(this);
        }
        return false;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable != null && this.f957x && (this.f955v || this.f956w)) {
            drawable = h.r(drawable).mutate();
            if (this.f955v) {
                h.o(drawable, this.f953t);
            }
            if (this.f956w) {
                h.p(drawable, this.f954u);
            }
            this.f957x = false;
        }
        return drawable;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f947n.expandItemActionView(this);
        }
        return false;
    }

    public int f() {
        return this.f937d;
    }

    public char g() {
        if (this.f947n.isQwertyMode()) {
            return this.f943j;
        }
        return this.f941h;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        b0.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View e10 = bVar.e(this);
        this.A = e10;
        return e10;
    }

    public int getAlphabeticModifiers() {
        return this.f944k;
    }

    public char getAlphabeticShortcut() {
        return this.f943j;
    }

    public CharSequence getContentDescription() {
        return this.f951r;
    }

    public int getGroupId() {
        return this.f935b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f945l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f946m == 0) {
            return null;
        }
        Drawable d10 = d.b.d(this.f947n.getContext(), this.f946m);
        this.f946m = 0;
        this.f945l = d10;
        return e(d10);
    }

    public ColorStateList getIconTintList() {
        return this.f953t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f954u;
    }

    public Intent getIntent() {
        return this.f940g;
    }

    public int getItemId() {
        return this.f934a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f942i;
    }

    public char getNumericShortcut() {
        return this.f941h;
    }

    public int getOrder() {
        return this.f936c;
    }

    public SubMenu getSubMenu() {
        return this.f948o;
    }

    public CharSequence getTitle() {
        return this.f938e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f939f;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f938e;
    }

    public CharSequence getTooltipText() {
        return this.f952s;
    }

    public String h() {
        int i10;
        char g10 = g();
        if (g10 == 0) {
            return "";
        }
        Resources resources = this.f947n.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f947n.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        if (this.f947n.isQwertyMode()) {
            i10 = this.f944k;
        } else {
            i10 = this.f942i;
        }
        d(sb, i10, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb, i10, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb, i10, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb, i10, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb, i10, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb, i10, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (g10 == 8) {
            sb.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (g10 == 10) {
            sb.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (g10 != ' ') {
            sb.append(g10);
        } else {
            sb.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    public boolean hasSubMenu() {
        if (this.f948o != null) {
            return true;
        }
        return false;
    }

    public CharSequence i(n.a aVar) {
        if (aVar == null || !aVar.prefersCondensedTitle()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        if ((this.f958y & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isChecked() {
        if ((this.f958y & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean isEnabled() {
        if ((this.f958y & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible() {
        b0.b bVar = this.B;
        if (bVar == null || !bVar.h()) {
            if ((this.f958y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.f958y & 8) != 0 || !this.B.c()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean j() {
        b0.b bVar;
        if ((this.f959z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.e(this);
        }
        if (this.A != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f950q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f947n;
        if (gVar.dispatchMenuItemSelected(gVar, this)) {
            return true;
        }
        Runnable runnable = this.f949p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f940g != null) {
            try {
                this.f947n.getContext().startActivity(this.f940g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        b0.b bVar = this.B;
        if (bVar == null || !bVar.f()) {
            return false;
        }
        return true;
    }

    public boolean l() {
        if ((this.f958y & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if ((this.f958y & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if ((this.f959z & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if ((this.f959z & 2) == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: p */
    public u.b setActionView(int i10) {
        Context context = this.f947n.getContext();
        setActionView(LayoutInflater.from(context).inflate(i10, new LinearLayout(context), false));
        return this;
    }

    /* renamed from: q */
    public u.b setActionView(View view) {
        int i10;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f934a) > 0) {
            view.setId(i10);
        }
        this.f947n.onItemActionRequestChanged(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f947n.onItemsChanged(false);
    }

    public void s(boolean z10) {
        int i10;
        int i11 = this.f958y;
        int i12 = i11 & -3;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int i13 = i10 | i12;
        this.f958y = i13;
        if (i11 != i13) {
            this.f947n.onItemsChanged(false);
        }
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f943j == c10) {
            return this;
        }
        this.f943j = Character.toLowerCase(c10);
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f958y;
        boolean z11 = z10 | (i10 & true);
        this.f958y = z11 ? 1 : 0;
        if (i10 != z11) {
            this.f947n.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        if ((this.f958y & 4) != 0) {
            this.f947n.setExclusiveItemChecked(this);
        } else {
            s(z10);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f958y |= 16;
        } else {
            this.f958y &= -17;
        }
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f946m = 0;
        this.f945l = drawable;
        this.f957x = true;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f953t = colorStateList;
        this.f955v = true;
        this.f957x = true;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f954u = mode;
        this.f956w = true;
        this.f957x = true;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f940g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        if (this.f941h == c10) {
            return this;
        }
        this.f941h = c10;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f950q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.f941h = c10;
        this.f943j = Character.toLowerCase(c11);
        this.f947n.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 == 0 || i11 == 1 || i11 == 2) {
            this.f959z = i10;
            this.f947n.onItemActionRequestChanged(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f938e = charSequence;
        this.f947n.onItemsChanged(false);
        r rVar = this.f948o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f939f = charSequence;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f947n.onItemVisibleChanged(this);
        }
        return this;
    }

    public void t(boolean z10) {
        int i10;
        int i11 = this.f958y & -5;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        this.f958y = i10 | i11;
    }

    public String toString() {
        CharSequence charSequence = this.f938e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        if (z10) {
            this.f958y |= 32;
        } else {
            this.f958y &= -33;
        }
    }

    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    /* renamed from: w */
    public u.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(r rVar) {
        this.f948o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    public boolean y(boolean z10) {
        int i10;
        int i11 = this.f958y;
        int i12 = i11 & -9;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        int i13 = i10 | i12;
        this.f958y = i13;
        if (i11 != i13) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return this.f947n.getOptionalIconsVisible();
    }

    public u.b setContentDescription(CharSequence charSequence) {
        this.f951r = charSequence;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public u.b setTooltipText(CharSequence charSequence) {
        this.f952s = charSequence;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f943j == c10 && this.f944k == i10) {
            return this;
        }
        this.f943j = Character.toLowerCase(c10);
        this.f944k = KeyEvent.normalizeMetaState(i10);
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f941h == c10 && this.f942i == i10) {
            return this;
        }
        this.f941h = c10;
        this.f942i = KeyEvent.normalizeMetaState(i10);
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f941h = c10;
        this.f942i = KeyEvent.normalizeMetaState(i10);
        this.f943j = Character.toLowerCase(c11);
        this.f944k = KeyEvent.normalizeMetaState(i11);
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.f945l = null;
        this.f946m = i10;
        this.f957x = true;
        this.f947n.onItemsChanged(false);
        return this;
    }

    public MenuItem setTitle(int i10) {
        return setTitle((CharSequence) this.f947n.getContext().getString(i10));
    }
}
