package com.mobile.brasiltv.view.input;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.y1;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import t9.g;
import t9.i;

public final class EmailPrefixInputView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    public IEmailPrefixInputCallback mEmailPrefixInputCallback;
    private ArrayList<String> mEmailSuffixList;
    private y1 mEmailSuffixPopupWindow;
    /* access modifiers changed from: private */
    public int mEmailSuffixSelectedIndex;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmailPrefixInputView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final ArrayAdapter<String> createEmailSuffixAdapter() {
        return new EmailPrefixInputView$createEmailSuffixAdapter$1(this, getContext(), this.mEmailSuffixList);
    }

    private final void hideEmailSuffixPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvEmailSelector)).setSelected(false);
        y1 y1Var = this.mEmailSuffixPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
        }
        this.mEmailSuffixPopupWindow = null;
    }

    private final void initListeners() {
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new e(this));
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new EmailPrefixInputView$initListeners$2(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvClearInput)).setOnClickListener(new f(this));
        ((TextView) _$_findCachedViewById(R$id.mTvEmailSuffix)).setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$0(EmailPrefixInputView emailPrefixInputView, View view, boolean z10) {
        i.g(emailPrefixInputView, "this$0");
        if (!z10) {
            ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(8);
            return;
        }
        IEmailPrefixInputCallback iEmailPrefixInputCallback = emailPrefixInputView.mEmailPrefixInputCallback;
        if (iEmailPrefixInputCallback != null) {
            iEmailPrefixInputCallback.onInputFocused();
        }
        if (b0.J(t.W(((EditText) emailPrefixInputView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(8);
        } else {
            ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$1(EmailPrefixInputView emailPrefixInputView, View view) {
        i.g(emailPrefixInputView, "this$0");
        ((EditText) emailPrefixInputView._$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$2(EmailPrefixInputView emailPrefixInputView, View view) {
        i.g(emailPrefixInputView, "this$0");
        if (emailPrefixInputView.isShowingEmailSuffixPopup()) {
            emailPrefixInputView.hideEmailSuffixPopup();
        } else {
            emailPrefixInputView.showEmailSuffixPopup();
        }
    }

    private final boolean isShowingEmailSuffixPopup() {
        boolean z10;
        y1 y1Var = this.mEmailSuffixPopupWindow;
        if (y1Var == null) {
            return false;
        }
        if (y1Var == null || !y1Var.isShowing()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    private final void showEmailSuffixPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvEmailSelector)).setSelected(true);
        y1 y1Var = new y1(getContext());
        this.mEmailSuffixPopupWindow = y1Var;
        y1Var.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.selector_bg_login_edit));
        y1 y1Var2 = this.mEmailSuffixPopupWindow;
        if (y1Var2 != null) {
            y1Var2.k(createEmailSuffixAdapter());
        }
        y1 y1Var3 = this.mEmailSuffixPopupWindow;
        if (y1Var3 != null) {
            y1Var3.w((TextView) _$_findCachedViewById(R$id.mTvEmailSuffix));
        }
        y1 y1Var4 = this.mEmailSuffixPopupWindow;
        if (y1Var4 != null) {
            y1Var4.C(true);
        }
        y1 y1Var5 = this.mEmailSuffixPopupWindow;
        if (y1Var5 != null) {
            y1Var5.D(new h(this));
        }
        y1 y1Var6 = this.mEmailSuffixPopupWindow;
        if (y1Var6 != null) {
            y1Var6.E(new i(this));
        }
        y1 y1Var7 = this.mEmailSuffixPopupWindow;
        if (y1Var7 != null) {
            y1Var7.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void showEmailSuffixPopup$lambda$3(EmailPrefixInputView emailPrefixInputView) {
        i.g(emailPrefixInputView, "this$0");
        emailPrefixInputView.mEmailSuffixPopupWindow = null;
        ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvEmailSelector)).setSelected(false);
    }

    /* access modifiers changed from: private */
    public static final void showEmailSuffixPopup$lambda$4(EmailPrefixInputView emailPrefixInputView, AdapterView adapterView, View view, int i10, long j10) {
        i.g(emailPrefixInputView, "this$0");
        emailPrefixInputView.mEmailSuffixSelectedIndex = i10;
        ((TextView) emailPrefixInputView._$_findCachedViewById(R$id.mTvEmailSuffix)).setText(emailPrefixInputView.mEmailSuffixList.get(emailPrefixInputView.mEmailSuffixSelectedIndex));
        y1 y1Var = emailPrefixInputView.mEmailSuffixPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
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

    public final String getFullEmailText() {
        String str;
        int i10 = this.mEmailSuffixSelectedIndex;
        if (i10 >= 0) {
            str = this.mEmailSuffixList.get(i10);
        } else {
            str = "";
        }
        i.f(str, "if (mEmailSuffixSelected…\n            \"\"\n        }");
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString() + str;
    }

    public final String getInputText() {
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
    }

    public final void setEmailPrefixInputCallback(IEmailPrefixInputCallback iEmailPrefixInputCallback) {
        i.g(iEmailPrefixInputCallback, "callback");
        this.mEmailPrefixInputCallback = iEmailPrefixInputCallback;
    }

    public final void setEmailSuffixList(List<String> list) {
        ListAdapter listAdapter;
        ListView m10;
        i.g(list, "emailSuffixList");
        this.mEmailSuffixList.clear();
        this.mEmailSuffixSelectedIndex = 0;
        this.mEmailSuffixList.addAll(list);
        ((TextView) _$_findCachedViewById(R$id.mTvEmailSuffix)).setText(this.mEmailSuffixList.get(this.mEmailSuffixSelectedIndex));
        if (isShowingEmailSuffixPopup()) {
            y1 y1Var = this.mEmailSuffixPopupWindow;
            if (y1Var == null || (m10 = y1Var.m()) == null) {
                listAdapter = null;
            } else {
                listAdapter = m10.getAdapter();
            }
            i.e(listAdapter, "null cannot be cast to non-null type android.widget.ArrayAdapter<kotlin.String>");
            ((ArrayAdapter) listAdapter).notifyDataSetChanged();
        }
    }

    public final void setHintSize(String str) {
        i.g(str, "hintText");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(new SpannedString(spannableString));
    }

    public final void setInputFilter(InputFilter inputFilter) {
        i.g(inputFilter, "inputFilter");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setFilters(new InputFilter[]{inputFilter});
    }

    public final void setInputText(String str) {
        i.g(str, "inputText");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EmailPrefixInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmailPrefixInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.mEmailSuffixSelectedIndex = -1;
        this.mEmailSuffixList = new ArrayList<>();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_email_prefix_input, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11934e, i10, 0);
        i.f(obtainStyledAttributes, "context.obtainStyledAttr…putView, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(1);
        setHintSize(string == null ? "" : string);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setTextColor(obtainStyledAttributes.getColor(2, getResources().getColor(R.color.color_999999)));
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvClearInput)).setImageResource(resourceId);
        }
        obtainStyledAttributes.recycle();
        initListeners();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmailPrefixInputView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
