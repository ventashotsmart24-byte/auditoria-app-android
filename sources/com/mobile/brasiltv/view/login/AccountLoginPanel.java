package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.TitleBarView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class AccountLoginPanel extends AutoLinearLayout implements ILoginPanel {
    public Map<Integer, View> _$_findViewCache;
    private IAccountLoginCallback mAccountLoginCallback;
    /* access modifiers changed from: private */
    public boolean mFindAccount;
    /* access modifiers changed from: private */
    public boolean mFindPassword;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccountLoginPanel(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void initListeners() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        int i10 = R$id.mTvForgetPwd;
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setAntiAlias(true);
        setOnClickListener(new c());
        ((TitleBarView) _$_findCachedViewById(R$id.mTbvTitle)).setOnBackClickListener(new d(this));
        ((AccountEditView) _$_findCachedViewById(R$id.mAevAccount)).setAccountEditCallback(new AccountLoginPanel$initListeners$3(this));
        ((PasswordEditView) _$_findCachedViewById(R$id.mPevPassword)).setPwdEditCallback(new AccountLoginPanel$initListeners$4(this));
        ((TextView) _$_findCachedViewById(i10)).setOnClickListener(new e(this));
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$0(View view) {
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$1(AccountLoginPanel accountLoginPanel, View view) {
        i.g(accountLoginPanel, "this$0");
        IAccountLoginCallback iAccountLoginCallback = accountLoginPanel.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onClosePanel();
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$2(AccountLoginPanel accountLoginPanel, View view) {
        i.g(accountLoginPanel, "this$0");
        IAccountLoginCallback iAccountLoginCallback = accountLoginPanel.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onForgetPwd();
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$3(AccountLoginPanel accountLoginPanel, View view) {
        i.g(accountLoginPanel, "this$0");
        accountLoginPanel.requestFocus();
        IAccountLoginCallback iAccountLoginCallback = accountLoginPanel.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onAccountLogin(((AccountEditView) accountLoginPanel._$_findCachedViewById(R$id.mAevAccount)).getAccount(), ((PasswordEditView) accountLoginPanel._$_findCachedViewById(R$id.mPevPassword)).getPassword());
        }
    }

    /* access modifiers changed from: private */
    public final void updateLoginBtnEnable() {
        boolean z10;
        TextView textView = (TextView) _$_findCachedViewById(R$id.mTvLogin);
        if (!this.mFindAccount || !this.mFindPassword) {
            z10 = false;
        } else {
            z10 = true;
        }
        textView.setEnabled(z10);
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

    public void cancelSmsCountDown() {
    }

    public void closeLoginPanel() {
        IAccountLoginCallback iAccountLoginCallback = this.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onClosePanel();
        }
    }

    public void fillAccount(String str) {
        boolean z10;
        i.g(str, "account");
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((AccountEditView) _$_findCachedViewById(R$id.mAevAccount)).setText(str);
        }
    }

    public String getMobile() {
        return "";
    }

    public void hideErrorHint(long j10) {
    }

    public final void isEmailLogin(boolean z10) {
        int i10;
        AccountEditView accountEditView = (AccountEditView) _$_findCachedViewById(R$id.mAevAccount);
        Context context = getContext();
        if (z10) {
            i10 = R.string.enter_email_hint;
        } else {
            i10 = R.string.enter_account_hint;
        }
        String string = context.getString(i10);
        i.f(string, "context.getString(if (is…tring.enter_account_hint)");
        accountEditView.setHint(string);
    }

    public final void setAccountLoginCallback(IAccountLoginCallback iAccountLoginCallback) {
        i.g(iAccountLoginCallback, "callback");
        this.mAccountLoginCallback = iAccountLoginCallback;
    }

    public final void setDeviceId(String str) {
        i.g(str, "deviceId");
        ((TextView) _$_findCachedViewById(R$id.mTvDeviceId)).setText(str);
    }

    public void showErrorHint(String str) {
        i.g(str, "errorHint");
    }

    public void startSmsCountDown() {
    }

    public void updateAreaInfo(String str, String str2) {
        i.g(str, "area");
        i.g(str2, "areaCode");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AccountLoginPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountLoginPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_account_login_panel, this, true);
        initListeners();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountLoginPanel(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
