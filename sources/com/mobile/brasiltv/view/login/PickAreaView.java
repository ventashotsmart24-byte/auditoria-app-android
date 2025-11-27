package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.i0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class PickAreaView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    public String mArea;
    private String mAreaCode;
    /* access modifiers changed from: private */
    public IPickAreaCallback mPickAreaCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PickAreaView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void initListeners() {
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflPickArea)).setOnClickListener(new p(this));
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new q(this));
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new PickAreaView$initListeners$3(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setOnClickListener(new r(this));
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$0(PickAreaView pickAreaView, View view) {
        i.g(pickAreaView, "this$0");
        IPickAreaCallback iPickAreaCallback = pickAreaView.mPickAreaCallback;
        if (iPickAreaCallback != null) {
            iPickAreaCallback.onPickArea();
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$1(PickAreaView pickAreaView, View view, boolean z10) {
        i.g(pickAreaView, "this$0");
        if (!z10) {
            ((ImageView) pickAreaView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else if (TextUtils.isEmpty(t.W(((EditText) pickAreaView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) pickAreaView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) pickAreaView._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void initListeners$lambda$2(PickAreaView pickAreaView, View view) {
        i.g(pickAreaView, "this$0");
        ((EditText) pickAreaView._$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    private final void initViews() {
        ((TextView) _$_findCachedViewById(R$id.mTvArea)).setText(this.mArea);
        ((TextView) _$_findCachedViewById(R$id.mTvAreaCode)).setText('+' + this.mAreaCode);
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

    public final void fillAreaInfo(String str, String str2) {
        i.g(str, "area");
        i.g(str2, "areaCode");
        setAreaInfo(str, str2);
        ((TextView) _$_findCachedViewById(R$id.mTvArea)).setText(this.mArea);
        ((TextView) _$_findCachedViewById(R$id.mTvAreaCode)).setText('+' + this.mAreaCode);
    }

    public final void fillMobile(String str) {
        i.g(str, "mobile");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText(str);
    }

    public final String getArea() {
        return this.mArea;
    }

    public final String getAreaCode() {
        return this.mAreaCode;
    }

    public final String getAreaMobile() {
        i0 i0Var = i0.f12587a;
        EditText editText = (EditText) _$_findCachedViewById(R$id.mEtInput);
        i.f(editText, "mEtInput");
        return i0Var.b(editText, this.mArea);
    }

    public final void setAreaInfo(String str, String str2) {
        i.g(str, "area");
        i.g(str2, "areaCode");
        this.mArea = str;
        this.mAreaCode = str2;
    }

    public final void setPickAreaCallback(IPickAreaCallback iPickAreaCallback) {
        i.g(iPickAreaCallback, "callback");
        this.mPickAreaCallback = iPickAreaCallback;
    }

    public final void updateAreaInfo(String str, String str2) {
        i.g(str, "area");
        i.g(str2, "areaCode");
        setAreaInfo(str, str2);
        ((TextView) _$_findCachedViewById(R$id.mTvArea)).setText(this.mArea);
        ((TextView) _$_findCachedViewById(R$id.mTvAreaCode)).setText('+' + this.mAreaCode);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PickAreaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickAreaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.mArea = "";
        this.mAreaCode = "";
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_pick_area_view, this, true);
        initViews();
        initListeners();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PickAreaView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
