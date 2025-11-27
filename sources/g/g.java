package g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.o1;
import androidx.appcompat.widget.r2;
import b0.t;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    public static final Class[] f6644e;

    /* renamed from: f  reason: collision with root package name */
    public static final Class[] f6645f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f6646a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f6647b;

    /* renamed from: c  reason: collision with root package name */
    public Context f6648c;

    /* renamed from: d  reason: collision with root package name */
    public Object f6649d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        public static final Class[] f6650c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        public Object f6651a;

        /* renamed from: b  reason: collision with root package name */
        public Method f6652b;

        public a(Object obj, String str) {
            this.f6651a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f6652b = cls.getMethod(str, f6650c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f6652b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f6652b.invoke(this.f6651a, new Object[]{menuItem})).booleanValue();
                }
                this.f6652b.invoke(this.f6651a, new Object[]{menuItem});
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public class b {
        public b0.b A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        public Menu f6653a;

        /* renamed from: b  reason: collision with root package name */
        public int f6654b;

        /* renamed from: c  reason: collision with root package name */
        public int f6655c;

        /* renamed from: d  reason: collision with root package name */
        public int f6656d;

        /* renamed from: e  reason: collision with root package name */
        public int f6657e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6658f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6659g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f6660h;

        /* renamed from: i  reason: collision with root package name */
        public int f6661i;

        /* renamed from: j  reason: collision with root package name */
        public int f6662j;

        /* renamed from: k  reason: collision with root package name */
        public CharSequence f6663k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f6664l;

        /* renamed from: m  reason: collision with root package name */
        public int f6665m;

        /* renamed from: n  reason: collision with root package name */
        public char f6666n;

        /* renamed from: o  reason: collision with root package name */
        public int f6667o;

        /* renamed from: p  reason: collision with root package name */
        public char f6668p;

        /* renamed from: q  reason: collision with root package name */
        public int f6669q;

        /* renamed from: r  reason: collision with root package name */
        public int f6670r;

        /* renamed from: s  reason: collision with root package name */
        public boolean f6671s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f6672t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f6673u;

        /* renamed from: v  reason: collision with root package name */
        public int f6674v;

        /* renamed from: w  reason: collision with root package name */
        public int f6675w;

        /* renamed from: x  reason: collision with root package name */
        public String f6676x;

        /* renamed from: y  reason: collision with root package name */
        public String f6677y;

        /* renamed from: z  reason: collision with root package name */
        public String f6678z;

        public b(Menu menu) {
            this.f6653a = menu;
            h();
        }

        public void a() {
            this.f6660h = true;
            i(this.f6653a.add(this.f6654b, this.f6661i, this.f6662j, this.f6663k));
        }

        public SubMenu b() {
            this.f6660h = true;
            SubMenu addSubMenu = this.f6653a.addSubMenu(this.f6654b, this.f6661i, this.f6662j, this.f6663k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f6660h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f6648c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(str);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f6648c.obtainStyledAttributes(attributeSet, R$styleable.A);
            this.f6654b = obtainStyledAttributes.getResourceId(R$styleable.MenuGroup_android_id, 0);
            this.f6655c = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_menuCategory, 0);
            this.f6656d = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_orderInCategory, 0);
            this.f6657e = obtainStyledAttributes.getInt(R$styleable.MenuGroup_android_checkableBehavior, 0);
            this.f6658f = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_visible, true);
            this.f6659g = obtainStyledAttributes.getBoolean(R$styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z10;
            r2 t10 = r2.t(g.this.f6648c, attributeSet, R$styleable.B);
            this.f6661i = t10.n(R$styleable.MenuItem_android_id, 0);
            this.f6662j = (t10.k(R$styleable.MenuItem_android_menuCategory, this.f6655c) & -65536) | (t10.k(R$styleable.MenuItem_android_orderInCategory, this.f6656d) & Message.MAXLENGTH);
            this.f6663k = t10.p(R$styleable.MenuItem_android_title);
            this.f6664l = t10.p(R$styleable.MenuItem_android_titleCondensed);
            this.f6665m = t10.n(R$styleable.MenuItem_android_icon, 0);
            this.f6666n = c(t10.o(R$styleable.MenuItem_android_alphabeticShortcut));
            this.f6667o = t10.k(R$styleable.MenuItem_alphabeticModifiers, 4096);
            this.f6668p = c(t10.o(R$styleable.MenuItem_android_numericShortcut));
            this.f6669q = t10.k(R$styleable.MenuItem_numericModifiers, 4096);
            int i10 = R$styleable.MenuItem_android_checkable;
            if (t10.r(i10)) {
                this.f6670r = t10.a(i10, false) ? 1 : 0;
            } else {
                this.f6670r = this.f6657e;
            }
            this.f6671s = t10.a(R$styleable.MenuItem_android_checked, false);
            this.f6672t = t10.a(R$styleable.MenuItem_android_visible, this.f6658f);
            this.f6673u = t10.a(R$styleable.MenuItem_android_enabled, this.f6659g);
            this.f6674v = t10.k(R$styleable.MenuItem_showAsAction, -1);
            this.f6678z = t10.o(R$styleable.MenuItem_android_onClick);
            this.f6675w = t10.n(R$styleable.MenuItem_actionLayout, 0);
            this.f6676x = t10.o(R$styleable.MenuItem_actionViewClass);
            String o10 = t10.o(R$styleable.MenuItem_actionProviderClass);
            this.f6677y = o10;
            if (o10 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && this.f6675w == 0 && this.f6676x == null) {
                this.A = (b0.b) e(o10, g.f6645f, g.this.f6647b);
            } else {
                this.A = null;
            }
            this.B = t10.p(R$styleable.MenuItem_contentDescription);
            this.C = t10.p(R$styleable.MenuItem_tooltipText);
            int i11 = R$styleable.MenuItem_iconTintMode;
            if (t10.r(i11)) {
                this.E = o1.e(t10.k(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = R$styleable.MenuItem_iconTint;
            if (t10.r(i12)) {
                this.D = t10.c(i12);
            } else {
                this.D = null;
            }
            t10.v();
            this.f6660h = false;
        }

        public void h() {
            this.f6654b = 0;
            this.f6655c = 0;
            this.f6656d = 0;
            this.f6657e = 0;
            this.f6658f = true;
            this.f6659g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z10;
            MenuItem enabled = menuItem.setChecked(this.f6671s).setVisible(this.f6672t).setEnabled(this.f6673u);
            boolean z11 = false;
            if (this.f6670r >= 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            enabled.setCheckable(z10).setTitleCondensed(this.f6664l).setIcon(this.f6665m);
            int i10 = this.f6674v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f6678z != null) {
                if (!g.this.f6648c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f6678z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z12 = menuItem instanceof i;
            if (z12) {
                i iVar = (i) menuItem;
            }
            if (this.f6670r >= 2) {
                if (z12) {
                    ((i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.f6676x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f6644e, g.this.f6646a));
                z11 = true;
            }
            int i11 = this.f6675w;
            if (i11 > 0 && !z11) {
                menuItem.setActionView(i11);
            }
            b0.b bVar = this.A;
            if (bVar != null) {
                t.b(menuItem, bVar);
            }
            t.d(menuItem, this.B);
            t.h(menuItem, this.C);
            t.c(menuItem, this.f6666n, this.f6667o);
            t.g(menuItem, this.f6668p, this.f6669q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                t.f(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                t.e(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f6644e = clsArr;
        f6645f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f6648c = context;
        Object[] objArr = {context};
        this.f6646a = objArr;
        this.f6647b = objArr;
    }

    public final Object a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    public Object b() {
        if (this.f6649d == null) {
            this.f6649d = a(this.f6648c);
        }
        return this.f6649d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z11 && name2.equals(str)) {
                            str = null;
                            z11 = false;
                        } else if (name2.equals("group")) {
                            bVar.h();
                        } else if (name2.equals(PlistBuilder.KEY_ITEM)) {
                            if (!bVar.d()) {
                                b0.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.b()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z10 = true;
                        }
                    }
                } else if (!z11) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.f(attributeSet);
                    } else if (name3.equals(PlistBuilder.KEY_ITEM)) {
                        bVar.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z11 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof u.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f6648c.getResources().getLayout(i10);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e10) {
            throw new InflateException("Error inflating menu XML", e10);
        } catch (IOException e11) {
            throw new InflateException("Error inflating menu XML", e11);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
