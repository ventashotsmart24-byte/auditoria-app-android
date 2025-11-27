package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
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

public final class MobileLoginPanel extends AutoLinearLayout implements ILoginPanel, IPickAreaCallback {
    private long DELAY_ERROR_HINT;
    public Map<Integer, View> _$_findViewCache;
    private Runnable mErrorHintRunnable;
    private boolean mFindMobile;
    /* access modifiers changed from: private */
    public boolean mFindPassword;
    private IMobileLoginCallback mMobileLoginCallback;
    private Handler mMobileLoginHandler;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MobileLoginPanel(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void initListeners() {
        setOnClickListener(new g());
        int i10 = R$id.mTvForgetPwd;
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setAntiAlias(true);
        ((TitleBarView) _$_findCachedViewById(R$id.mTbvTitle)).setOnBackClickListener(new h(this));
        ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).setPickAreaCallback(this);
        ((PasswordEditView) _$_findCachedViewById(R$id.mPevPassword)).setPwdEditCallback(new MobileLoginPanel$initListeners$3(this));
        ((TextView) _$_findCachedViewById(i10)).setOnClickListener(new i(this));
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setOnClickListener(new j(this));
        ((TextView) _$_findCachedViewById(R$id.mTvUseSmsLogin)).setOnClickListener(new k(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$1(View view) {
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$2(MobileLoginPanel mobileLoginPanel, View view) {
        i.g(mobileLoginPanel, "this$0");
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onClosePanel();
        }
        mobileLoginPanel.mMobileLoginHandler.removeCallbacks(mobileLoginPanel.mErrorHintRunnable);
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$3(MobileLoginPanel mobileLoginPanel, View view) {
        i.g(mobileLoginPanel, "this$0");
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onForgetPwd();
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$4(MobileLoginPanel mobileLoginPanel, View view) {
        i.g(mobileLoginPanel, "this$0");
        mobileLoginPanel.requestFocus();
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            int i10 = R$id.mPavArea;
            iMobileLoginCallback.onMobileLogin(((PickAreaView) mobileLoginPanel._$_findCachedViewById(i10)).getArea(), ((PickAreaView) mobileLoginPanel._$_findCachedViewById(i10)).getAreaCode(), ((PickAreaView) mobileLoginPanel._$_findCachedViewById(i10)).getAreaMobile(), ((PasswordEditView) mobileLoginPanel._$_findCachedViewById(R$id.mPevPassword)).getPassword());
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$5(MobileLoginPanel mobileLoginPanel, View view) {
        i.g(mobileLoginPanel, "this$0");
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onUseSmsLogin();
        }
    }

    private final void initViews() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        int i10 = R$id.mTvUseSmsLogin;
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setAntiAlias(true);
    }

    /* access modifiers changed from: private */
    public static final void mErrorHintRunnable$lambda$0(MobileLoginPanel mobileLoginPanel) {
        i.g(mobileLoginPanel, "this$0");
        mobileLoginPanel.hideErrorHint();
    }

    /* access modifiers changed from: private */
    public final void updateLoginBtnEnable() {
        boolean z10;
        TextView textView = (TextView) _$_findCachedViewById(R$id.mTvLogin);
        if (!this.mFindMobile || !this.mFindPassword) {
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
        IMobileLoginCallback iMobileLoginCallback = this.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onClosePanel();
        }
        this.mMobileLoginHandler.removeCallbacks(this.mErrorHintRunnable);
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
            ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).fillMobile(str);
        }
    }

    public final void fillArea(String str) {
        boolean z10;
        String str2;
        i.g(str, "areaCode");
        int i10 = 0;
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String[] stringArray = getResources().getStringArray(R.array.nation);
            i.f(stringArray, "resources.getStringArray(R.array.nation)");
            String[] stringArray2 = getResources().getStringArray(R.array.code);
            i.f(stringArray2, "resources.getStringArray(R.array.code)");
            int length = stringArray2.length;
            while (true) {
                if (i10 >= length) {
                    str2 = "";
                    break;
                } else if (i.b(stringArray2[i10], str)) {
                    str2 = stringArray[i10];
                    i.f(str2, "nationData[i]");
                    break;
                } else {
                    i10++;
                }
            }
            ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).fillAreaInfo(str2, str);
        }
    }

    public String getMobile() {
        return ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).getAreaMobile();
    }

    public void hideErrorHint(long j10) {
        hideErrorHint();
        this.mMobileLoginHandler.removeCallbacks(this.mErrorHintRunnable);
    }

    public void onPickArea() {
        IMobileLoginCallback iMobileLoginCallback = this.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onPickArea();
        }
    }

    public void onTextChanged(String str) {
        i.g(str, "content");
        this.mFindMobile = !TextUtils.isEmpty(str);
        updateLoginBtnEnable();
    }

    public final void setMobileLoginCallback(IMobileLoginCallback iMobileLoginCallback) {
        i.g(iMobileLoginCallback, "callback");
        this.mMobileLoginCallback = iMobileLoginCallback;
    }

    public void showErrorHint(String str) {
        i.g(str, "errorHint");
        int i10 = R$id.mTvErrorHint;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).setText(str);
        this.mMobileLoginHandler.removeCallbacks(this.mErrorHintRunnable);
        this.mMobileLoginHandler.postDelayed(this.mErrorHintRunnable, this.DELAY_ERROR_HINT);
    }

    public void startSmsCountDown() {
    }

    public void updateAreaInfo(String str, String str2) {
        i.g(str, "area");
        i.g(str2, "areaCode");
        ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).updateAreaInfo(str, str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MobileLoginPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileLoginPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.DELAY_ERROR_HINT = 5000;
        this.mMobileLoginHandler = new Handler();
        this.mErrorHintRunnable = new l(this);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_mobile_login_panel, this, true);
        initViews();
        initListeners();
    }

    private final void hideErrorHint() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(4);
        ((TextView) _$_findCachedViewById(i10)).setText("");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobileLoginPanel(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
