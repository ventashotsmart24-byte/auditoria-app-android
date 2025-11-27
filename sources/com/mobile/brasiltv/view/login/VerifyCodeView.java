package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

public final class VerifyCodeView extends AutoLinearLayout {
    private final long SMS_SEND_DELAY;
    private final long SMS_SEND_MAX_TIME;
    public Map<Integer, View> _$_findViewCache;
    private boolean mCountDowning;
    private boolean mFindMobile;
    private Handler mSmsSendHandler;
    private Runnable mSmsSendRunnable;
    private long mSmsSendTime;
    /* access modifiers changed from: private */
    public IVerifyCodeCallback mVerifyCodeCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VerifyCodeView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void countdownSmsSend() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSmsSendTime);
        sb.append('s');
        ((TextView) _$_findCachedViewById(R$id.mTvSend)).setText(sb.toString());
        long j10 = this.mSmsSendTime - 1;
        this.mSmsSendTime = j10;
        if (j10 == 0) {
            cancelCountDown();
        } else {
            this.mSmsSendHandler.postDelayed(this.mSmsSendRunnable, this.SMS_SEND_DELAY);
        }
    }

    private final void initListeners() {
        ((EditText) _$_findCachedViewById(R$id.mEtVerifyCode)).addTextChangedListener(new VerifyCodeView$initListeners$1(this));
        ((TextView) _$_findCachedViewById(R$id.mTvSend)).setOnClickListener(new a0(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$1(VerifyCodeView verifyCodeView, View view) {
        i.g(verifyCodeView, "this$0");
        verifyCodeView.requestFocus();
        IVerifyCodeCallback iVerifyCodeCallback = verifyCodeView.mVerifyCodeCallback;
        if (iVerifyCodeCallback != null) {
            iVerifyCodeCallback.onSendSms();
        }
    }

    /* access modifiers changed from: private */
    public static final void mSmsSendRunnable$lambda$0(VerifyCodeView verifyCodeView) {
        i.g(verifyCodeView, "this$0");
        verifyCodeView.countdownSmsSend();
    }

    public static /* synthetic */ void startCountDown$default(VerifyCodeView verifyCodeView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = verifyCodeView.SMS_SEND_MAX_TIME;
        }
        verifyCodeView.startCountDown(j10);
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

    public final void cancelCountDown() {
        this.mSmsSendHandler.removeCallbacks(this.mSmsSendRunnable);
        int i10 = R$id.mTvSend;
        ((TextView) _$_findCachedViewById(i10)).setText(getResources().getString(R.string.be_send_sms));
        ((TextView) _$_findCachedViewById(i10)).setEnabled(this.mFindMobile);
        this.mCountDowning = false;
    }

    public final String getVerifyCode() {
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtVerifyCode)).getText().toString()).toString();
    }

    public final void setHintSize(String str) {
        i.g(str, "hintText");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
        ((EditText) _$_findCachedViewById(R$id.mEtVerifyCode)).setHint(new SpannedString(spannableString));
    }

    public final void setSendEnabled(boolean z10) {
        boolean z11;
        this.mFindMobile = z10;
        TextView textView = (TextView) _$_findCachedViewById(R$id.mTvSend);
        if (this.mCountDowning || !z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        textView.setEnabled(z11);
    }

    public final void setVerifyCodeCallback(IVerifyCodeCallback iVerifyCodeCallback) {
        i.g(iVerifyCodeCallback, "callback");
        this.mVerifyCodeCallback = iVerifyCodeCallback;
    }

    public final void startCountDown(long j10) {
        this.mCountDowning = true;
        ((TextView) _$_findCachedViewById(R$id.mTvSend)).setEnabled(false);
        this.mSmsSendTime = j10;
        this.mSmsSendHandler.post(this.mSmsSendRunnable);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerifyCodeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.SMS_SEND_DELAY = 1000;
        this.SMS_SEND_MAX_TIME = 180;
        this.mSmsSendHandler = new Handler();
        this.mSmsSendRunnable = new b0(this);
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_verify_code_view, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.E, i10, 0);
        i.f(obtainStyledAttributes, "context.obtainStyledAttr…odeView, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(0);
        setHintSize(string == null ? "" : string);
        obtainStyledAttributes.recycle();
        initListeners();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerifyCodeView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
