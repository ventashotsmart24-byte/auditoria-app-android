package b0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.MenuItem;
import u.b;

public abstract class t {
    public static b a(MenuItem menuItem) {
        if (menuItem instanceof b) {
            return ((b) menuItem).a();
        }
        return null;
    }

    public static MenuItem b(MenuItem menuItem, b bVar) {
        if (menuItem instanceof b) {
            return ((b) menuItem).b(bVar);
        }
        return menuItem;
    }

    public static void c(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof b) {
            ((b) menuItem).setAlphabeticShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            MenuItem unused = menuItem.setAlphabeticShortcut(c10, i10);
        }
    }

    public static void d(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof b) {
            ((b) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            MenuItem unused = menuItem.setContentDescription(charSequence);
        }
    }

    public static void e(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof b) {
            ((b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            MenuItem unused = menuItem.setIconTintList(colorStateList);
        }
    }

    public static void f(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof b) {
            ((b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            MenuItem unused = menuItem.setIconTintMode(mode);
        }
    }

    public static void g(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof b) {
            ((b) menuItem).setNumericShortcut(c10, i10);
        } else if (Build.VERSION.SDK_INT >= 26) {
            MenuItem unused = menuItem.setNumericShortcut(c10, i10);
        }
    }

    public static void h(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof b) {
            ((b) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            MenuItem unused = menuItem.setTooltipText(charSequence);
        }
    }
}
