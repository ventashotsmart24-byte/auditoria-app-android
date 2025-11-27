package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.DropDownListView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import na.d;
import t9.g;
import t9.i;

public final class QuickLoginPanel extends AutoLinearLayout implements ILoginPanel {
    public Map<Integer, View> _$_findViewCache;
    private final Runnable mGoLoginRunnable;
    /* access modifiers changed from: private */
    public IQuickLoginCallback mQuickLoginCallback;
    private boolean quickLoginExpired;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QuickLoginPanel(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void initListeners() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        ((TextView) _$_findCachedViewById(R$id.mTvQuickLogin)).setOnClickListener(new s(this));
        ((DropDownListView) _$_findCachedViewById(R$id.mDropView)).setRemoveAccountListener(new QuickLoginPanel$initListeners$2(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$0(QuickLoginPanel quickLoginPanel, View view) {
        i.g(quickLoginPanel, "this$0");
        IQuickLoginCallback iQuickLoginCallback = quickLoginPanel.mQuickLoginCallback;
        if (iQuickLoginCallback != null) {
            iQuickLoginCallback.onAccountLogin(((DropDownListView) quickLoginPanel._$_findCachedViewById(R$id.mDropView)).getSelectAccount());
        }
    }

    /* access modifiers changed from: private */
    public static final void mGoLoginRunnable$lambda$1(QuickLoginPanel quickLoginPanel) {
        i.g(quickLoginPanel, "this$0");
        ((TextView) quickLoginPanel._$_findCachedViewById(R$id.mTvError)).setVisibility(8);
        if (quickLoginPanel.quickLoginExpired) {
            quickLoginPanel.quickLoginExpired = false;
            IQuickLoginCallback iQuickLoginCallback = quickLoginPanel.mQuickLoginCallback;
            if (iQuickLoginCallback != null) {
                iQuickLoginCallback.onLoginExpired(((DropDownListView) quickLoginPanel._$_findCachedViewById(R$id.mDropView)).getSelectAccount());
            }
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

    public final void attachDataToView(ArrayList<SwitchAccountBean> arrayList) {
        i.g(arrayList, "list");
        ((DropDownListView) _$_findCachedViewById(R$id.mDropView)).attachDataToView(arrayList);
        ((TextView) _$_findCachedViewById(R$id.mTvQuickLogin)).setEnabled(!arrayList.isEmpty());
    }

    public void cancelSmsCountDown() {
    }

    public void closeLoginPanel() {
        IQuickLoginCallback iQuickLoginCallback = this.mQuickLoginCallback;
        if (iQuickLoginCallback != null) {
            iQuickLoginCallback.onClosePanel();
        }
        ((TextView) _$_findCachedViewById(R$id.mTvError)).removeCallbacks(this.mGoLoginRunnable);
    }

    public void fillAccount(String str) {
        i.g(str, "account");
    }

    public String getMobile() {
        return "";
    }

    public void hideErrorHint(long j10) {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((TextView) _$_findCachedViewById(R$id.mTvError)).removeCallbacks(this.mGoLoginRunnable);
    }

    public final void setAccountLoginCallback(IQuickLoginCallback iQuickLoginCallback) {
        i.g(iQuickLoginCallback, "callback");
        this.mQuickLoginCallback = iQuickLoginCallback;
    }

    public final void showError(String str) {
        i.g(str, "error");
        if (i.b(str, "aaa100012") || i.b(str, "aaa100022") || i.b(str, "aaa100027") || i.b(str, "aaa100028") || i.b(str, "aaa100080") || i.b(str, "aaa100081") || i.b(str, "aaa100091") || i.b(str, "aaa100081") || i.b(str, "aaa100093") || i.b(str, "portal100075")) {
            this.quickLoginExpired = true;
            ((TextView) _$_findCachedViewById(R$id.mTvError)).setText(getContext().getString(R.string.switch_account_expired));
        } else if (i.b(d.b(str), "EA2")) {
            this.quickLoginExpired = false;
            x xVar = x.f12622a;
            Context context = getContext();
            i.f(context, f.X);
            xVar.w(context, new QuickLoginPanel$showError$1(str));
            return;
        } else {
            this.quickLoginExpired = false;
            ((TextView) _$_findCachedViewById(R$id.mTvError)).setText(getContext().getString(R.string.scan_login_failed));
        }
        int i10 = R$id.mTvError;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).removeCallbacks(this.mGoLoginRunnable);
        ((TextView) _$_findCachedViewById(i10)).postDelayed(this.mGoLoginRunnable, 3000);
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
    public QuickLoginPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuickLoginPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_quick_login_panel, this, true);
        initListeners();
        this.mGoLoginRunnable = new t(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickLoginPanel(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
