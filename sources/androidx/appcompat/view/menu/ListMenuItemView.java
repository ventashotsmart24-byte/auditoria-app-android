package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.r2;
import b0.c1;

public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a  reason: collision with root package name */
    public i f824a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f825b;

    /* renamed from: c  reason: collision with root package name */
    public RadioButton f826c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f827d;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f828e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f829f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f830g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f831h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f832i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f833j;

    /* renamed from: k  reason: collision with root package name */
    public int f834k;

    /* renamed from: l  reason: collision with root package name */
    public Context f835l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f836m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f837n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f838o;

    /* renamed from: p  reason: collision with root package name */
    public int f839p;

    /* renamed from: q  reason: collision with root package name */
    public LayoutInflater f840q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f841r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f840q == null) {
            this.f840q = LayoutInflater.from(getContext());
        }
        return this.f840q;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        int i10;
        ImageView imageView = this.f830g;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f831h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f831h.getLayoutParams();
            rect.top += this.f831h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public final void b(View view, int i10) {
        LinearLayout linearLayout = this.f832i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    public final void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, this, false);
        this.f828e = checkBox;
        a(checkBox);
    }

    public final void d() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, this, false);
        this.f825b = imageView;
        b(imageView, 0);
    }

    public final void e() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, this, false);
        this.f826c = radioButton;
        a(radioButton);
    }

    public void f(boolean z10, char c10) {
        int i10;
        if (!z10 || !this.f824a.A()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            this.f829f.setText(this.f824a.h());
        }
        if (this.f829f.getVisibility() != i10) {
            this.f829f.setVisibility(i10);
        }
    }

    public i getItemData() {
        return this.f824a;
    }

    public void initialize(i iVar, int i10) {
        int i11;
        this.f824a = iVar;
        this.f839p = i10;
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        f(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        c1.o0(this, this.f833j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f827d = textView;
        int i10 = this.f834k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f835l, i10);
        }
        this.f829f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f830g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f837n);
        }
        this.f831h = (ImageView) findViewById(R$id.group_divider);
        this.f832i = (LinearLayout) findViewById(R$id.content);
    }

    public void onMeasure(int i10, int i11) {
        if (this.f825b != null && this.f836m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f825b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z10) {
        View view;
        CompoundButton compoundButton;
        if (z10 || this.f826c != null || this.f828e != null) {
            if (this.f824a.m()) {
                if (this.f826c == null) {
                    e();
                }
                compoundButton = this.f826c;
                view = this.f828e;
            } else {
                if (this.f828e == null) {
                    c();
                }
                compoundButton = this.f828e;
                view = this.f826c;
            }
            if (z10) {
                compoundButton.setChecked(this.f824a.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f828e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f826c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f824a.m()) {
            if (this.f826c == null) {
                e();
            }
            compoundButton = this.f826c;
        } else {
            if (this.f828e == null) {
                c();
            }
            compoundButton = this.f828e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f841r = z10;
        this.f836m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        int i10;
        ImageView imageView = this.f831h;
        if (imageView != null) {
            if (this.f838o || !z10) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            imageView.setVisibility(i10);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10;
        if (this.f824a.z() || this.f841r) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || this.f836m) {
            ImageView imageView = this.f825b;
            if (imageView != null || drawable != null || this.f836m) {
                if (imageView == null) {
                    d();
                }
                if (drawable != null || this.f836m) {
                    ImageView imageView2 = this.f825b;
                    if (!z10) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f825b.getVisibility() != 0) {
                        this.f825b.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f825b.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f827d.setText(charSequence);
            if (this.f827d.getVisibility() != 0) {
                this.f827d.setVisibility(0);
            }
        } else if (this.f827d.getVisibility() != 8) {
            this.f827d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        r2 u10 = r2.u(getContext(), attributeSet, R$styleable.C, i10, 0);
        this.f833j = u10.g(R$styleable.MenuView_android_itemBackground);
        this.f834k = u10.n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f836m = u10.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f835l = context;
        this.f837n = u10.g(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R$attr.dropDownListViewStyle, 0);
        this.f838o = obtainStyledAttributes.hasValue(0);
        u10.v();
        obtainStyledAttributes.recycle();
    }
}
