package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class PasswordEditView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private int mCloseEyeResId;
    private int mOpenEyeResId;
    /* access modifiers changed from: private */
    public IPwdEditCallback mPwdEditCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PasswordEditView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void initListeners() {
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new m(this));
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new PasswordEditView$initListeners$2(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setOnClickListener(new n(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvEye)).setOnClickListener(new o(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$0(PasswordEditView passwordEditView, View view, boolean z10) {
        i.g(passwordEditView, "this$0");
        if (!z10) {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else if (TextUtils.isEmpty(t.W(((EditText) passwordEditView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$1(PasswordEditView passwordEditView, View view) {
        i.g(passwordEditView, "this$0");
        ((EditText) passwordEditView._$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$2(PasswordEditView passwordEditView, View view) {
        i.g(passwordEditView, "this$0");
        int i10 = R$id.mEtInput;
        if (!i.b(((EditText) passwordEditView._$_findCachedViewById(i10)).getTransformationMethod(), PasswordTransformationMethod.getInstance())) {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvEye)).setImageResource(passwordEditView.mCloseEyeResId);
            ((EditText) passwordEditView._$_findCachedViewById(i10)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvEye)).setImageResource(passwordEditView.mOpenEyeResId);
            ((EditText) passwordEditView._$_findCachedViewById(i10)).setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        ((EditText) passwordEditView._$_findCachedViewById(i10)).setSelection(t.W(((EditText) passwordEditView._$_findCachedViewById(i10)).getText().toString()).toString().length());
    }

    private final void initViews() {
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setTransformationMethod(PasswordTransformationMethod.getInstance());
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

    public final String getPassword() {
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
    }

    public final void setPwdEditCallback(IPwdEditCallback iPwdEditCallback) {
        i.g(iPwdEditCallback, "callback");
        this.mPwdEditCallback = iPwdEditCallback;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PasswordEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordEditView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_password_edit_view, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11948s, i10, 0);
        i.f(obtainStyledAttributes, "context.obtainStyledAttr…ditView, defStyleAttr, 0)");
        int resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvType)).setImageResource(resourceId);
        }
        String string = obtainStyledAttributes.getString(3);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(string == null ? "" : string);
        int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId2 != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setImageResource(resourceId2);
        }
        this.mCloseEyeResId = obtainStyledAttributes.getResourceId(0, 0);
        this.mOpenEyeResId = obtainStyledAttributes.getResourceId(1, 0);
        if (this.mCloseEyeResId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvEye)).setImageResource(this.mCloseEyeResId);
        }
        obtainStyledAttributes.recycle();
        initViews();
        initListeners();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PasswordEditView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
