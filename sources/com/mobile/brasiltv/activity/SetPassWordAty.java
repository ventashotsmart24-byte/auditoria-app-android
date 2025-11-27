package com.mobile.brasiltv.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import ba.s;
import ba.t;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import f5.j4;
import f5.k4;
import f5.l4;
import i6.s0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.v3;
import ma.m;
import t9.i;
import xa.c;

public final class SetPassWordAty extends d implements s0 {

    /* renamed from: l  reason: collision with root package name */
    public Boolean f12147l;

    /* renamed from: m  reason: collision with root package name */
    public String f12148m;

    /* renamed from: n  reason: collision with root package name */
    public String f12149n;

    /* renamed from: o  reason: collision with root package name */
    public String f12150o;

    /* renamed from: p  reason: collision with root package name */
    public String f12151p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f12152q;

    /* renamed from: r  reason: collision with root package name */
    public v3 f12153r;

    /* renamed from: s  reason: collision with root package name */
    public Map f12154s = new LinkedHashMap();

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPassWordAty f12155a;

        public a(SetPassWordAty setPassWordAty) {
            this.f12155a = setPassWordAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12155a.X2(R$id.confirmBt);
            SetPassWordAty setPassWordAty = this.f12155a;
            EditText editText = (EditText) setPassWordAty.X2(R$id.pwdFirst);
            i.f(editText, "pwdFirst");
            if (!setPassWordAty.e3(editText)) {
                SetPassWordAty setPassWordAty2 = this.f12155a;
                EditText editText2 = (EditText) setPassWordAty2.X2(R$id.pwdSecond);
                i.f(editText2, "pwdSecond");
                if (!setPassWordAty2.e3(editText2)) {
                    z10 = true;
                    textView.setEnabled(z10);
                }
            }
            z10 = false;
            textView.setEnabled(z10);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPassWordAty f12156a;

        public b(SetPassWordAty setPassWordAty) {
            this.f12156a = setPassWordAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12156a.X2(R$id.confirmBt);
            SetPassWordAty setPassWordAty = this.f12156a;
            EditText editText = (EditText) setPassWordAty.X2(R$id.pwdFirst);
            i.f(editText, "pwdFirst");
            if (!setPassWordAty.e3(editText)) {
                SetPassWordAty setPassWordAty2 = this.f12156a;
                EditText editText2 = (EditText) setPassWordAty2.X2(R$id.pwdSecond);
                i.f(editText2, "pwdSecond");
                if (!setPassWordAty2.e3(editText2)) {
                    z10 = true;
                    textView.setEnabled(z10);
                }
            }
            z10 = false;
            textView.setEnabled(z10);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final void a3(SetPassWordAty setPassWordAty, View view) {
        i.g(setPassWordAty, "this$0");
        setPassWordAty.finish();
    }

    public static final void b3(SetPassWordAty setPassWordAty, View view) {
        i.g(setPassWordAty, "this$0");
        setPassWordAty.Z2();
    }

    public static final void c3(SetPassWordAty setPassWordAty, View view) {
        String str;
        String str2;
        String str3;
        i.g(setPassWordAty, "this$0");
        String obj = t.W(((EditText) setPassWordAty.X2(R$id.pwdFirst)).getText().toString()).toString();
        String obj2 = t.W(((EditText) setPassWordAty.X2(R$id.pwdSecond)).getText().toString()).toString();
        if (!j1.g(obj)) {
            int i10 = R$id.mTextErrorNotify;
            ((TextView) setPassWordAty.X2(i10)).setVisibility(0);
            ((TextView) setPassWordAty.X2(i10)).setText(setPassWordAty.getResources().getString(R.string.password_format_error_tips));
        } else if (!j1.g(obj2)) {
            int i11 = R$id.mTextErrorNotify;
            ((TextView) setPassWordAty.X2(i11)).setVisibility(0);
            ((TextView) setPassWordAty.X2(i11)).setText(setPassWordAty.getResources().getString(R.string.password_error_tips));
        } else if (!i.b(obj, obj2)) {
            int i12 = R$id.mTextErrorNotify;
            ((TextView) setPassWordAty.X2(i12)).setVisibility(0);
            ((TextView) setPassWordAty.X2(i12)).setText(setPassWordAty.getResources().getString(R.string.not_match_password));
        } else {
            ((TextView) setPassWordAty.X2(R$id.mTextErrorNotify)).setVisibility(8);
            String str4 = "";
            if (setPassWordAty.f12152q) {
                v3 d32 = setPassWordAty.S2();
                String str5 = setPassWordAty.f12148m;
                if (str5 == null) {
                    str = str4;
                } else {
                    str = str5;
                }
                String str6 = setPassWordAty.f12149n;
                if (str6 == null) {
                    str2 = str4;
                } else {
                    str2 = str6;
                }
                String str7 = setPassWordAty.f12150o;
                if (str7 == null) {
                    str3 = str4;
                } else {
                    str3 = str7;
                }
                String e10 = m.e(obj);
                i.f(e10, "md5(firstPassword)");
                d32.m(str, str2, str3, "3", e10);
                return;
            }
            v3 d33 = setPassWordAty.S2();
            String str8 = setPassWordAty.f12148m;
            if (str8 == null) {
                str8 = str4;
            }
            String str9 = setPassWordAty.f12149n;
            if (str9 == null) {
                str9 = str4;
            }
            String str10 = setPassWordAty.f12150o;
            if (str10 != null) {
                str4 = str10;
            }
            String e11 = m.e(obj);
            i.f(e11, "md5(firstPassword)");
            d33.i(str8, str9, str4, e11);
        }
    }

    public void H() {
        String str = this.f12151p;
        if (str == null || TextUtils.isEmpty(str) || !s.g(this.f12151p, "ResetAty", false, 2, (Object) null)) {
            b0.c0(this, PhoneBindSuccessAty.class);
            finish();
            return;
        }
        ((AutoRelativeLayout) X2(R$id.resetPwdSuccess)).setVisibility(0);
        ((AutoLinearLayout) X2(R$id.resetPwd)).setVisibility(8);
        int i10 = R$id.mTitleView;
        ((TitleView) X2(i10)).setTitle(getResources().getString(R.string.reset_successful));
        ((TitleView) X2(i10)).setXVisible(0);
        b0.F(this);
    }

    public void R2() {
        int i10 = R$id.confirmBt;
        ((TextView) X2(i10)).setEnabled(false);
        f3(new v3(this, this));
        int i11 = R$id.mTitleView;
        ((TitleView) X2(i11)).setTitle(getResources().getString(R.string.set_pwd));
        ((TitleView) X2(i11)).setXVisible(8);
        this.f12152q = getIntent().getBooleanExtra("is_forget_pwd", false);
        String stringExtra = getIntent().getStringExtra("set_pwd_from");
        this.f12151p = stringExtra;
        if (stringExtra == null) {
            this.f12151p = "";
        }
        String stringExtra2 = getIntent().getStringExtra("user_phone");
        this.f12148m = stringExtra2;
        if (stringExtra2 == null) {
            this.f12148m = "";
        }
        String stringExtra3 = getIntent().getStringExtra("user_area_code");
        this.f12149n = stringExtra3;
        if (stringExtra3 == null) {
            this.f12149n = "";
        }
        String stringExtra4 = getIntent().getStringExtra("user_verfication");
        this.f12150o = stringExtra4;
        if (stringExtra4 == null) {
            this.f12150o = "";
        }
        ((TitleView) X2(i11)).setXClickListener(new j4(this));
        ((TitleView) X2(i11)).setOnBackClickListener(new k4(this));
        ((TextView) X2(i10)).setOnClickListener(new l4(this));
        ((EditText) X2(R$id.pwdFirst)).addTextChangedListener(new a(this));
        ((EditText) X2(R$id.pwdSecond)).addTextChangedListener(new b(this));
    }

    public int T2() {
        return R.layout.activity_setpassword;
    }

    public View X2(int i10) {
        Map map = this.f12154s;
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

    public final void Z2() {
        Boolean bool = this.f12147l;
        if (i.b(bool, Boolean.TRUE)) {
            b0.c0(this, MainAty.class);
        } else if (i.b(bool, Boolean.FALSE)) {
            b0.c0(this, LoginAty.class);
            finish();
        } else {
            finish();
        }
    }

    /* renamed from: d3 */
    public v3 S2() {
        v3 v3Var = this.f12153r;
        if (v3Var != null) {
            return v3Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final boolean e3(EditText editText) {
        String obj = t.W(editText.getText().toString()).toString();
        if (obj == null || obj.length() == 0) {
            return true;
        }
        return false;
    }

    public void f3(v3 v3Var) {
        i.g(v3Var, "<set-?>");
        this.f12153r = v3Var;
    }

    public void k2() {
        n2();
    }

    public void o(String str) {
        i.g(str, Constant.KEY_MSG);
    }

    public void onBackPressed() {
        Z2();
    }

    public void showLoading(boolean z10) {
    }

    public void w0(boolean z10) {
        c.c().j(new ClosePageEvent());
        ((AutoRelativeLayout) X2(R$id.resetPwdSuccess)).setVisibility(0);
        ((AutoLinearLayout) X2(R$id.resetPwd)).setVisibility(8);
        int i10 = R$id.mTitleView;
        ((TitleView) X2(i10)).setTitle(getResources().getString(R.string.reset_successful));
        ((TitleView) X2(i10)).setXVisible(8);
        this.f12147l = Boolean.valueOf(z10);
        b0.F(this);
    }

    public void x() {
        c.c().j(new ClosePageEvent());
        finish();
    }
}
