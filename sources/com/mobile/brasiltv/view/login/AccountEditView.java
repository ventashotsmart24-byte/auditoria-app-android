package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class AccountEditView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    public IAccountEditCallback mAccountEditCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccountEditView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void initListeners() {
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new a(this));
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new AccountEditView$initListeners$2(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$0(AccountEditView accountEditView, View view, boolean z10) {
        i.g(accountEditView, "this$0");
        if (!z10) {
            ((ImageView) accountEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else if (TextUtils.isEmpty(t.W(((EditText) accountEditView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) accountEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) accountEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$1(AccountEditView accountEditView, View view) {
        i.g(accountEditView, "this$0");
        ((EditText) accountEditView._$_findCachedViewById(R$id.mEtInput)).setText("");
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

    public final String getAccount() {
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
    }

    public final void setAccountEditCallback(IAccountEditCallback iAccountEditCallback) {
        i.g(iAccountEditCallback, "callback");
        this.mAccountEditCallback = iAccountEditCallback;
    }

    public final void setHint(String str) {
        i.g(str, "hint");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(str);
    }

    public final void setText(String str) {
        i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccountEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountEditView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_account_edit_view, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11930a, i10, 0);
        i.f(obtainStyledAttributes, "context.obtainStyledAttr…ditView, defStyleAttr, 0)");
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvType)).setImageResource(resourceId);
        }
        String string = obtainStyledAttributes.getString(1);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(string == null ? "" : string);
        int resourceId2 = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId2 != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setImageResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
        initListeners();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountEditView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
