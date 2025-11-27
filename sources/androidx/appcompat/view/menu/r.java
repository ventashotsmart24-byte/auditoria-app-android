package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.g;
import com.hpplay.cybergarage.soap.SOAP;

public class r extends g implements SubMenu {
    private i mItem;
    private g mParentMenu;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.mParentMenu = gVar;
        this.mItem = iVar;
    }

    public boolean collapseItemActionView(i iVar) {
        return this.mParentMenu.collapseItemActionView(iVar);
    }

    public boolean dispatchMenuItemSelected(g gVar, MenuItem menuItem) {
        if (super.dispatchMenuItemSelected(gVar, menuItem) || this.mParentMenu.dispatchMenuItemSelected(gVar, menuItem)) {
            return true;
        }
        return false;
    }

    public boolean expandItemActionView(i iVar) {
        return this.mParentMenu.expandItemActionView(iVar);
    }

    public String getActionViewStatesKey() {
        int i10;
        i iVar = this.mItem;
        if (iVar != null) {
            i10 = iVar.getItemId();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + SOAP.DELIM + i10;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public g getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(g.a aVar) {
        this.mParentMenu.setCallback(aVar);
    }

    public void setGroupDividerEnabled(boolean z10) {
        this.mParentMenu.setGroupDividerEnabled(z10);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z10) {
        this.mParentMenu.setQwertyMode(z10);
    }

    public void setShortcutsVisible(boolean z10) {
        this.mParentMenu.setShortcutsVisible(z10);
    }

    public SubMenu setHeaderIcon(int i10) {
        return (SubMenu) super.setHeaderIconInt(i10);
    }

    public SubMenu setHeaderTitle(int i10) {
        return (SubMenu) super.setHeaderTitleInt(i10);
    }

    public SubMenu setIcon(int i10) {
        this.mItem.setIcon(i10);
        return this;
    }
}
