package com.mobile.brasiltv.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import e6.r;
import e6.s;
import e6.t;
import e6.u;
import java.util.LinkedHashMap;
import java.util.Map;
import ma.m;
import mobile.com.requestframe.utils.response.UpdatePwdResult;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import w6.i;

public final class ChangePwdAty extends f5.c {

    /* renamed from: k  reason: collision with root package name */
    public Map f6073k = new LinkedHashMap();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f12292a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            Intent putExtra = intent.putExtra("is_edit_editable", false);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_EDIT_EDITABLE, false)");
            return putExtra;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12293a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 1);
            intent.putExtra("bind_Type", "3");
            Intent putExtra = intent.putExtra("is_edit_editable", false);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_EDIT_EDITABLE, false)");
            return putExtra;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12294a = new c();

        public c() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            Intent putExtra = intent.putExtra("is_edit_editable", true);
            i.f(putExtra, "intent.putExtra(ResetAty.IS_EDIT_EDITABLE, true)");
            return putExtra;
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangePwdAty f12295a;

        public d(ChangePwdAty changePwdAty) {
            this.f12295a = changePwdAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12295a.V2(R$id.mTextConfirm);
            ChangePwdAty changePwdAty = this.f12295a;
            EditText editText = (EditText) changePwdAty.V2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!changePwdAty.c3(editText)) {
                ChangePwdAty changePwdAty2 = this.f12295a;
                EditText editText2 = (EditText) changePwdAty2.V2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!changePwdAty2.c3(editText2)) {
                    ChangePwdAty changePwdAty3 = this.f12295a;
                    EditText editText3 = (EditText) changePwdAty3.V2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!changePwdAty3.c3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
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

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangePwdAty f12296a;

        public e(ChangePwdAty changePwdAty) {
            this.f12296a = changePwdAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12296a.V2(R$id.mTextConfirm);
            ChangePwdAty changePwdAty = this.f12296a;
            EditText editText = (EditText) changePwdAty.V2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!changePwdAty.c3(editText)) {
                ChangePwdAty changePwdAty2 = this.f12296a;
                EditText editText2 = (EditText) changePwdAty2.V2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!changePwdAty2.c3(editText2)) {
                    ChangePwdAty changePwdAty3 = this.f12296a;
                    EditText editText3 = (EditText) changePwdAty3.V2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!changePwdAty3.c3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
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

    public static final class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangePwdAty f12297a;

        public f(ChangePwdAty changePwdAty) {
            this.f12297a = changePwdAty;
        }

        public void afterTextChanged(Editable editable) {
            boolean z10;
            TextView textView = (TextView) this.f12297a.V2(R$id.mTextConfirm);
            ChangePwdAty changePwdAty = this.f12297a;
            EditText editText = (EditText) changePwdAty.V2(R$id.mEditOldPassword);
            i.f(editText, "mEditOldPassword");
            if (!changePwdAty.c3(editText)) {
                ChangePwdAty changePwdAty2 = this.f12297a;
                EditText editText2 = (EditText) changePwdAty2.V2(R$id.mEditNewPassword);
                i.f(editText2, "mEditNewPassword");
                if (!changePwdAty2.c3(editText2)) {
                    ChangePwdAty changePwdAty3 = this.f12297a;
                    EditText editText3 = (EditText) changePwdAty3.V2(R$id.mEditPasswordAgain);
                    i.f(editText3, "mEditPasswordAgain");
                    if (!changePwdAty3.c3(editText3)) {
                        z10 = true;
                        textView.setEnabled(z10);
                    }
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

    public static final class g extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChangePwdAty f12298a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f12299b;

        public g(ChangePwdAty changePwdAty, w wVar) {
            this.f12298a = changePwdAty;
            this.f12299b = wVar;
        }

        /* renamed from: f */
        public void onNext(UpdatePwdResult updatePwdResult) {
            i.g(updatePwdResult, "t");
            ((AutoRelativeLayout) this.f12298a.V2(R$id.mLayoutChange)).setVisibility(8);
            ((AutoLinearLayout) this.f12298a.V2(R$id.mLayoutSuccess)).setVisibility(0);
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            Object obj = this.f12299b.f19600a;
            i.f(obj, "enNewPwd");
            memberInfo.putPassword((String) obj, false);
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            String p10 = y.p(y.f12639a, str, (String) null, (String) null, 6, (Object) null);
            if (i.b(str, "aaa100022")) {
                p10 = this.f12298a.getResources().getString(R.string.origin_password_error_tips);
                i.f(p10, "resources.getString(R.st…igin_password_error_tips)");
            }
            f1.f12517a.x(p10);
        }
    }

    public static final void Y2(ChangePwdAty changePwdAty, View view) {
        i.g(changePwdAty, "this$0");
        b0.c0(changePwdAty, MainAty.class);
    }

    public static final void Z2(ChangePwdAty changePwdAty, View view) {
        i.g(changePwdAty, "this$0");
        int i10 = R$id.mEditOldPassword;
        if (!i.b(((EditText) changePwdAty.V2(i10)).getTransformationMethod(), PasswordTransformationMethod.getInstance())) {
            ((ImageView) changePwdAty.V2(R$id.mImageEye)).setImageResource(R.drawable.icon_hide_password);
            ((EditText) changePwdAty.V2(i10)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            ((ImageView) changePwdAty.V2(R$id.mImageEye)).setImageResource(R.drawable.icon_show_password);
            ((EditText) changePwdAty.V2(i10)).setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        ((EditText) changePwdAty.V2(i10)).setSelection(((EditText) changePwdAty.V2(i10)).getText().toString().length());
    }

    public static final void a3(ChangePwdAty changePwdAty, View view) {
        i.g(changePwdAty, "this$0");
        int i10 = R$id.mEditNewPassword;
        if (!j1.g(((EditText) changePwdAty.V2(i10)).getText().toString())) {
            int i11 = R$id.mTextErrorNotify;
            ((TextView) changePwdAty.V2(i11)).setVisibility(0);
            ((TextView) changePwdAty.V2(i11)).setText(changePwdAty.getResources().getString(R.string.password_format_error_tips));
        } else {
            int i12 = R$id.mEditPasswordAgain;
            if (!j1.g(((EditText) changePwdAty.V2(i12)).getText().toString())) {
                int i13 = R$id.mTextErrorNotify;
                ((TextView) changePwdAty.V2(i13)).setVisibility(0);
                ((TextView) changePwdAty.V2(i13)).setText(changePwdAty.getResources().getString(R.string.password_error_tips));
            } else if (!i.b(((EditText) changePwdAty.V2(i10)).getText().toString(), ((EditText) changePwdAty.V2(i12)).getText().toString())) {
                int i14 = R$id.mTextErrorNotify;
                ((TextView) changePwdAty.V2(i14)).setVisibility(0);
                ((TextView) changePwdAty.V2(i14)).setText(changePwdAty.getResources().getString(R.string.not_match_password));
            } else {
                ((TextView) changePwdAty.V2(R$id.mTextErrorNotify)).setVisibility(8);
                changePwdAty.d3();
            }
        }
        Context Q1 = changePwdAty.Q1();
        i.e(Q1, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.F((f5.c) Q1);
    }

    public static final void b3(ChangePwdAty changePwdAty, View view) {
        i.g(changePwdAty, "this$0");
        i.c cVar = w6.i.f9510g;
        Class<ResetAty> cls = ResetAty.class;
        if (t9.i.b(cVar.h(), "1")) {
            b0.d0(changePwdAty, cls, a.f12292a);
        } else if (t9.i.b(cVar.j(), "1")) {
            b0.d0(changePwdAty, cls, b.f12293a);
        } else {
            b0.d0(changePwdAty, cls, c.f12294a);
        }
    }

    public View V2(int i10) {
        Map map = this.f6073k;
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

    public final void X2() {
        int i10 = R$id.mTextConfirm;
        ((TextView) V2(i10)).setEnabled(false);
        int i11 = R$id.title_view;
        ((TitleView) V2(i11)).setXVisible(0);
        ((AutoRelativeLayout) V2(R$id.mLayoutChange)).setVisibility(0);
        ((AutoLinearLayout) V2(R$id.mLayoutSuccess)).setVisibility(8);
        int i12 = R$id.mEditOldPassword;
        ((EditText) V2(i12)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        int i13 = R$id.mEditNewPassword;
        ((EditText) V2(i13)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        int i14 = R$id.mEditPasswordAgain;
        ((EditText) V2(i14)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        SpannableString spannableString = new SpannableString(getString(R.string.login_forget_pwd));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        int i15 = R$id.mTextForgetPassword;
        ((TextView) V2(i15)).setText(spannableString);
        ((TitleView) V2(i11)).setXClickListener(new r(this));
        ((ImageView) V2(R$id.mImageEye)).setOnClickListener(new s(this));
        ((TextView) V2(i10)).setOnClickListener(new t(this));
        ((TextView) V2(i15)).setOnClickListener(new u(this));
        ((EditText) V2(i12)).addTextChangedListener(new d(this));
        ((EditText) V2(i13)).addTextChangedListener(new e(this));
        ((EditText) V2(i14)).addTextChangedListener(new f(this));
    }

    public final boolean c3(EditText editText) {
        String obj = ba.t.W(editText.getText().toString()).toString();
        if (obj == null || obj.length() == 0) {
            return true;
        }
        return false;
    }

    public final void d3() {
        String e10 = m.e(((EditText) V2(R$id.mEditOldPassword)).getText().toString());
        String obj = ba.t.W(((EditText) V2(R$id.mEditNewPassword)).getText().toString()).toString();
        w wVar = new w();
        wVar.f19600a = m.e(obj);
        w6.i b10 = w6.i.f9510g.b();
        t9.i.f(e10, "oldPwd");
        Object obj2 = wVar.f19600a;
        t9.i.f(obj2, "enNewPwd");
        b10.p2(e10, (String) obj2).compose(O1()).subscribe(new g(this, wVar));
    }

    public void k2() {
        n2();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_change_password);
        X2();
    }

    @xa.j
    public final void onEventMainThread(ClosePageEvent closePageEvent) {
        t9.i.g(closePageEvent, "closePageEvent");
        finish();
    }
}
