package com.mobile.brasiltv.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i0;
import com.mobile.brasiltv.utils.z0;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.bt;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import f5.m2;
import f5.n2;
import f5.o2;
import f5.p2;
import i6.e0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.n1;
import na.f;
import s9.l;
import t9.i;
import t9.j;

public final class PhoneAty extends d implements e0 {

    /* renamed from: l  reason: collision with root package name */
    public boolean f12068l;

    /* renamed from: m  reason: collision with root package name */
    public Handler f12069m = new Handler();

    /* renamed from: n  reason: collision with root package name */
    public int f12070n = 180;

    /* renamed from: o  reason: collision with root package name */
    public String f12071o = "Brazil";

    /* renamed from: p  reason: collision with root package name */
    public String f12072p = "55";

    /* renamed from: q  reason: collision with root package name */
    public String f12073q = "1";

    /* renamed from: r  reason: collision with root package name */
    public Runnable f12074r = new b(this);

    /* renamed from: s  reason: collision with root package name */
    public Runnable f12075s = new m2(this);

    /* renamed from: t  reason: collision with root package name */
    public n1 f12076t;

    /* renamed from: u  reason: collision with root package name */
    public Map f12077u = new LinkedHashMap();

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneAty f12078a;

        public a(PhoneAty phoneAty) {
            this.f12078a = phoneAty;
        }

        public void afterTextChanged(Editable editable) {
            i0 i0Var = i0.f12587a;
            EditText editText = (EditText) this.f12078a.Y2(R$id.phoneNum);
            i.f(editText, "phoneNum");
            i0Var.a(editText, this, this.f12078a.f12071o);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneAty f12079a;

        public b(PhoneAty phoneAty) {
            this.f12079a = phoneAty;
        }

        public void run() {
            PhoneAty phoneAty = this.f12079a;
            int i10 = R$id.sendMsgBt;
            ((CheckBox) phoneAty.Y2(i10)).setText(this.f12079a.getResources().getString(R.string.retrive_super) + ' ' + this.f12079a.f12070n + 's');
            PhoneAty phoneAty2 = this.f12079a;
            phoneAty2.f12070n = phoneAty2.f12070n - 1;
            if (this.f12079a.f12070n == 0) {
                this.f12079a.f12069m.removeCallbacks(this);
                ((CheckBox) this.f12079a.Y2(i10)).setChecked(false);
                ((CheckBox) this.f12079a.Y2(i10)).setEnabled(true);
                ((CheckBox) this.f12079a.Y2(i10)).setText(this.f12079a.getResources().getString(R.string.sending));
                this.f12079a.f12070n = 180;
                return;
            }
            this.f12079a.f12069m.postDelayed(this, 1000);
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PhoneAty f12080a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f12081b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(PhoneAty phoneAty, String str) {
            super(1);
            this.f12080a = phoneAty;
            this.f12081b = str;
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("user_area_code", this.f12080a.f12072p);
            intent.putExtra("user_verfication", t.W(((EditText) this.f12080a.Y2(R$id.verificationEdit)).getText().toString()).toString());
            Intent putExtra = intent.putExtra("user_phone", this.f12081b);
            i.f(putExtra, "intent.putExtra(Constant.USER_PHONE, phoneNumber)");
            return putExtra;
        }
    }

    public static final void e3(PhoneAty phoneAty, View view) {
        i.g(phoneAty, "this$0");
        b0.e0(phoneAty, SelectNationAty.class, 1002);
    }

    public static final void f3(PhoneAty phoneAty, CompoundButton compoundButton, boolean z10) {
        i.g(phoneAty, "this$0");
        if (z10) {
            int i10 = R$id.phoneNum;
            if (TextUtils.isEmpty(t.W(((EditText) phoneAty.Y2(i10)).getText().toString()).toString())) {
                ((CheckBox) phoneAty.Y2(R$id.sendMsgBt)).setChecked(false);
                int i11 = R$id.errorTx;
                ((TextView) phoneAty.Y2(i11)).setText(phoneAty.getResources().getString(R.string.empty_phone));
                ((TextView) phoneAty.Y2(i11)).setVisibility(0);
                phoneAty.h3();
                return;
            }
            i0 i0Var = i0.f12587a;
            EditText editText = (EditText) phoneAty.Y2(i10);
            i.f(editText, "phoneNum");
            String b10 = i0Var.b(editText, phoneAty.f12071o);
            if (TextUtils.isEmpty(b10) || !z0.a(b10, phoneAty.f12071o)) {
                ((CheckBox) phoneAty.Y2(R$id.sendMsgBt)).setChecked(false);
                int i12 = R$id.errorTx;
                ((TextView) phoneAty.Y2(i12)).setText(phoneAty.getResources().getString(R.string.invalid_phone_number));
                ((TextView) phoneAty.Y2(i12)).setVisibility(0);
                phoneAty.h3();
                return;
            }
            ((CheckBox) phoneAty.Y2(R$id.sendMsgBt)).setEnabled(false);
            phoneAty.S2().l(b10, phoneAty.f12072p, phoneAty.f12073q);
            return;
        }
        int i13 = R$id.sendMsgBt;
        ((CheckBox) phoneAty.Y2(i13)).setTextColor(phoneAty.getResources().getColor(R.color.color_important));
        ((CheckBox) phoneAty.Y2(i13)).setEnabled(true);
    }

    public static final void g3(PhoneAty phoneAty, View view) {
        i.g(phoneAty, "this$0");
        phoneAty.h3();
        i0 i0Var = i0.f12587a;
        int i10 = R$id.phoneNum;
        EditText editText = (EditText) phoneAty.Y2(i10);
        i.f(editText, "phoneNum");
        String b10 = i0Var.b(editText, phoneAty.f12071o);
        if (TextUtils.isEmpty(t.W(((EditText) phoneAty.Y2(i10)).getText().toString()).toString())) {
            int i11 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i11)).setVisibility(0);
            ((TextView) phoneAty.Y2(i11)).setText(phoneAty.getResources().getString(R.string.empty_phone));
            return;
        }
        int i12 = R$id.verificationEdit;
        if (TextUtils.isEmpty(t.W(((EditText) phoneAty.Y2(i12)).getText().toString()).toString())) {
            int i13 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i13)).setVisibility(0);
            ((TextView) phoneAty.Y2(i13)).setText(phoneAty.getResources().getString(R.string.empty_verification_code));
        } else if (t.W(((EditText) phoneAty.Y2(i12)).getText().toString()).toString().length() != 6) {
            int i14 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i14)).setVisibility(0);
            ((TextView) phoneAty.Y2(i14)).setText(phoneAty.getResources().getString(R.string.verification_invalid));
        } else if (TextUtils.isEmpty(b10) || !z0.a(b10, phoneAty.f12071o)) {
            int i15 = R$id.errorTx;
            ((TextView) phoneAty.Y2(i15)).setVisibility(0);
            ((TextView) phoneAty.Y2(i15)).setText(phoneAty.getResources().getString(R.string.invalid_phone_number));
        } else {
            phoneAty.k3();
            phoneAty.S2().i(b10, phoneAty.f12072p, t.W(((EditText) phoneAty.Y2(i12)).getText().toString()).toString(), "1");
        }
    }

    public static final void j3(PhoneAty phoneAty) {
        i.g(phoneAty, "this$0");
        TextView textView = (TextView) phoneAty.Y2(R$id.errorTx);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void H() {
        b0.c0(this, PhoneBindSuccessAty.class);
        finish();
    }

    public void P() {
        ((CheckBox) Y2(R$id.sendMsgBt)).setTextColor(getResources().getColor(R.color.color_f7bd46));
        this.f12069m.post(this.f12074r);
    }

    public void R2() {
        l3(new n1(this, this));
        ((AutoRelativeLayout) Y2(R$id.chooseCountry)).setOnClickListener(new n2(this));
        int i10 = R$id.sendMsgBt;
        ((CheckBox) Y2(i10)).setEnabled(true);
        ((CheckBox) Y2(i10)).setOnCheckedChangeListener(new o2(this));
        ((EditText) Y2(R$id.phoneNum)).addTextChangedListener(new a(this));
        int i11 = R$id.title_view;
        ((TitleView) Y2(i11)).setTitle(getResources().getString(R.string.phone_binding));
        ((TitleView) Y2(i11)).setXVisible(8);
        ((TextView) Y2(R$id.mTextLogOther)).setOnClickListener(new p2(this));
    }

    public int T2() {
        return R.layout.activity_phone;
    }

    public void X0() {
        i0 i0Var = i0.f12587a;
        EditText editText = (EditText) Y2(R$id.phoneNum);
        i.f(editText, "phoneNum");
        String b10 = i0Var.b(editText, this.f12071o);
        if (i.b(w6.i.f9510g.s(), "1")) {
            S2().h(b10, this.f12072p, t.W(((EditText) Y2(R$id.verificationEdit)).getText().toString()).toString(), (String) null);
            return;
        }
        b0.d0(this, SetPassWordAty.class, new c(this, b10));
        finish();
    }

    public View Y2(int i10) {
        Map map = this.f12077u;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void h3() {
        k3();
        this.f12069m.postDelayed(this.f12075s, 5000);
    }

    public void i2() {
        int i10 = R$id.sendMsgBt;
        ((CheckBox) Y2(i10)).setChecked(false);
        ((CheckBox) Y2(i10)).setEnabled(true);
    }

    /* renamed from: i3 */
    public n1 S2() {
        n1 n1Var = this.f12076t;
        if (n1Var != null) {
            return n1Var;
        }
        i.w("mPresenter");
        return null;
    }

    public void k2() {
        n2();
    }

    public final void k3() {
        this.f12069m.removeCallbacks(this.f12075s);
    }

    public void l3(n1 n1Var) {
        i.g(n1Var, "<set-?>");
        this.f12076t = n1Var;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        super.onActivityResult(i10, i11, intent);
        try {
            if (i11 == SelectNationAty.f12129p.a() && i10 == 1002) {
                String str2 = null;
                if (intent != null) {
                    str = intent.getStringExtra("register_nation");
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                this.f12071o = str;
                if (intent != null) {
                    str2 = intent.getStringExtra("register_code");
                }
                if (str2 == null) {
                    str2 = "";
                }
                this.f12072p = str2;
                f.k(this, "login_area_code", str2);
                ((TextView) Y2(R$id.countryName)).setText(this.f12071o);
                ((TextView) Y2(R$id.areNum)).setText('+' + this.f12072p);
                ((EditText) Y2(R$id.phoneNum)).setText("");
                this.f12068l = true;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f12069m.removeCallbacks(this.f12074r);
        this.f12069m.removeCallbacks(this.f12075s);
    }

    public void showLoading(boolean z10) {
    }

    public void v(String str, String str2) {
        i.g(str, "areaCode");
        i.g(str2, bt.O);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !this.f12068l && TextUtils.isEmpty(t.W(((EditText) Y2(R$id.phoneNum)).getText().toString()).toString())) {
            this.f12072p = str;
            this.f12071o = str2;
            ((TextView) Y2(R$id.countryName)).setText(this.f12071o);
            ((TextView) Y2(R$id.areNum)).setText('+' + this.f12072p);
        }
    }
}
