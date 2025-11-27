package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public int f6626a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f6627b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f6628c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f6629d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f6630e;

    public d(Context context, int i10) {
        super(context);
        this.f6626a = i10;
    }

    public void a(Configuration configuration) {
        if (this.f6630e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f6629d == null) {
            this.f6629d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f6630e == null) {
            Configuration configuration = this.f6629d;
            if (configuration == null) {
                this.f6630e = super.getResources();
            } else {
                this.f6630e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f6630e;
    }

    public int c() {
        return this.f6626a;
    }

    public final void d() {
        boolean z10;
        if (this.f6627b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f6627b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f6627b.setTo(theme);
            }
        }
        e(this.f6627b, this.f6626a, z10);
    }

    public void e(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f6628c == null) {
            this.f6628c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f6628c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f6627b;
        if (theme != null) {
            return theme;
        }
        if (this.f6626a == 0) {
            this.f6626a = R$style.Theme_AppCompat_Light;
        }
        d();
        return this.f6627b;
    }

    public void setTheme(int i10) {
        if (this.f6626a != i10) {
            this.f6626a = i10;
            d();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f6627b = theme;
    }
}
