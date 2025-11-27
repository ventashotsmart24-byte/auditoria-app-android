package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import b0.b;
import java.lang.reflect.Method;

public class j extends c implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    public final u.b f961d;

    /* renamed from: e  reason: collision with root package name */
    public Method f962e;

    public class a extends b0.b {

        /* renamed from: d  reason: collision with root package name */
        public final ActionProvider f963d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f963d = actionProvider;
        }

        public boolean b() {
            return this.f963d.hasSubMenu();
        }

        public View d() {
            return this.f963d.onCreateActionView();
        }

        public boolean f() {
            return this.f963d.onPerformDefaultAction();
        }

        public void g(SubMenu subMenu) {
            this.f963d.onPrepareSubMenu(j.this.d(subMenu));
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f  reason: collision with root package name */
        public b.C0066b f965f;

        public b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean c() {
            return this.f963d.isVisible();
        }

        public View e(MenuItem menuItem) {
            return this.f963d.onCreateActionView(menuItem);
        }

        public boolean h() {
            return this.f963d.overridesItemVisibility();
        }

        public void l(b.C0066b bVar) {
            b bVar2;
            this.f965f = bVar;
            ActionProvider actionProvider = this.f963d;
            if (bVar != null) {
                bVar2 = this;
            } else {
                bVar2 = null;
            }
            actionProvider.setVisibilityListener(bVar2);
        }

        public void onActionProviderVisibilityChanged(boolean z10) {
            b.C0066b bVar = this.f965f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z10);
            }
        }
    }

    public static class c extends FrameLayout implements g.c {

        /* renamed from: a  reason: collision with root package name */
        public final CollapsibleActionView f967a;

        public c(View view) {
            super(view.getContext());
            this.f967a = (CollapsibleActionView) view;
            addView(view);
        }

        public void a() {
            this.f967a.onActionViewExpanded();
        }

        public View b() {
            return (View) this.f967a;
        }

        public void c() {
            this.f967a.onActionViewCollapsed();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f968a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f968a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f968a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f968a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f970a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f970a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f970a.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, u.b bVar) {
        super(context);
        if (bVar != null) {
            this.f961d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f961d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f961d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        b0.b a10 = this.f961d.a();
        if (a10 instanceof a) {
            return ((a) a10).f963d;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f961d.getActionView();
        if (actionView instanceof c) {
            return ((c) actionView).b();
        }
        return actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f961d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f961d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f961d.getContentDescription();
    }

    public int getGroupId() {
        return this.f961d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f961d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f961d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f961d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f961d.getIntent();
    }

    public int getItemId() {
        return this.f961d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f961d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f961d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f961d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f961d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f961d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f961d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f961d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f961d.getTooltipText();
    }

    public void h(boolean z10) {
        try {
            if (this.f962e == null) {
                this.f962e = this.f961d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f962e.invoke(this.f961d, new Object[]{Boolean.valueOf(z10)});
        } catch (Exception unused) {
        }
    }

    public boolean hasSubMenu() {
        return this.f961d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f961d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f961d.isCheckable();
    }

    public boolean isChecked() {
        return this.f961d.isChecked();
    }

    public boolean isEnabled() {
        return this.f961d.isEnabled();
    }

    public boolean isVisible() {
        return this.f961d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f874a, actionProvider);
        u.b bVar2 = this.f961d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.b(bVar);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f961d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.f961d.setAlphabeticShortcut(c10);
        return this;
    }

    public MenuItem setCheckable(boolean z10) {
        this.f961d.setCheckable(z10);
        return this;
    }

    public MenuItem setChecked(boolean z10) {
        this.f961d.setChecked(z10);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f961d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z10) {
        this.f961d.setEnabled(z10);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f961d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f961d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f961d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f961d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.f961d.setNumericShortcut(c10);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        d dVar;
        u.b bVar = this.f961d;
        if (onActionExpandListener != null) {
            dVar = new d(onActionExpandListener);
        } else {
            dVar = null;
        }
        bVar.setOnActionExpandListener(dVar);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        e eVar;
        u.b bVar = this.f961d;
        if (onMenuItemClickListener != null) {
            eVar = new e(onMenuItemClickListener);
        } else {
            eVar = null;
        }
        bVar.setOnMenuItemClickListener(eVar);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.f961d.setShortcut(c10, c11);
        return this;
    }

    public void setShowAsAction(int i10) {
        this.f961d.setShowAsAction(i10);
    }

    public MenuItem setShowAsActionFlags(int i10) {
        this.f961d.setShowAsActionFlags(i10);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f961d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f961d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f961d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z10) {
        return this.f961d.setVisible(z10);
    }

    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f961d.setAlphabeticShortcut(c10, i10);
        return this;
    }

    public MenuItem setIcon(int i10) {
        this.f961d.setIcon(i10);
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f961d.setNumericShortcut(c10, i10);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f961d.setShortcut(c10, c11, i10, i11);
        return this;
    }

    public MenuItem setTitle(int i10) {
        this.f961d.setTitle(i10);
        return this;
    }

    public MenuItem setActionView(int i10) {
        this.f961d.setActionView(i10);
        View actionView = this.f961d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f961d.setActionView((View) new c(actionView));
        }
        return this;
    }
}
