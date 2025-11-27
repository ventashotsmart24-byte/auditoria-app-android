package com.mobile.brasiltv.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import s9.p;
import t9.i;

public final class DropDownListView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ImageView mArrowImg;
    private ArrayList<SwitchAccountBean> mData;
    /* access modifiers changed from: private */
    public final DropDownPop mPop;
    /* access modifiers changed from: private */
    public p mRemoveListener;
    /* access modifiers changed from: private */
    public int mSelectPos;
    /* access modifiers changed from: private */
    public TextView mTextView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DropDownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        i.g(context, f.X);
        i.g(attributeSet, "attr");
        this.mPop = new DropDownPop(context);
        this.mData = new ArrayList<>();
        initView();
        initListener();
    }

    private final void initListener() {
        this.mPop.setItemClickListener(new DropDownListView$initListener$1(this));
        this.mPop.setOnDismissListener(new g(this));
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(DropDownListView dropDownListView) {
        i.g(dropDownListView, "this$0");
        dropDownListView.rotateArrow(false);
    }

    private final void initView() {
        setFocusable(true);
        setClickable(true);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.bg_dropdown_recentlogins);
        int percentWidthSize = AutoUtils.getPercentWidthSize(20);
        setPadding(percentWidthSize, 0, percentWidthSize, 0);
        TextView textView = new TextView(getContext());
        this.mTextView = textView;
        textView.setTextColor(-1);
        TextView textView2 = this.mTextView;
        ImageView imageView = null;
        if (textView2 == null) {
            i.w("mTextView");
            textView2 = null;
        }
        textView2.setSingleLine();
        TextView textView3 = this.mTextView;
        if (textView3 == null) {
            i.w("mTextView");
            textView3 = null;
        }
        textView3.setGravity(16);
        TextView textView4 = this.mTextView;
        if (textView4 == null) {
            i.w("mTextView");
            textView4 = null;
        }
        textView4.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        TextView textView5 = this.mTextView;
        if (textView5 == null) {
            i.w("mTextView");
            textView5 = null;
        }
        textView5.setTextSize(0, (float) AutoUtils.getPercentWidthSize(32));
        AutoLinearLayout.LayoutParams layoutParams = new AutoLinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        TextView textView6 = this.mTextView;
        if (textView6 == null) {
            i.w("mTextView");
            textView6 = null;
        }
        addView(textView6, layoutParams);
        ImageView imageView2 = new ImageView(getContext());
        this.mArrowImg = imageView2;
        imageView2.setImageResource(R.drawable.ic_dropdown_arrow_new);
        AutoLinearLayout.LayoutParams layoutParams2 = new AutoLinearLayout.LayoutParams(AutoUtils.getPercentWidthSize(25), AutoUtils.getPercentHeightSize(18));
        ImageView imageView3 = this.mArrowImg;
        if (imageView3 == null) {
            i.w("mArrowImg");
        } else {
            imageView = imageView3;
        }
        addView(imageView, layoutParams2);
    }

    private final void rotateArrow(boolean z10) {
        ObjectAnimator objectAnimator;
        ImageView imageView = null;
        if (z10) {
            ImageView imageView2 = this.mArrowImg;
            if (imageView2 == null) {
                i.w("mArrowImg");
            } else {
                imageView = imageView2;
            }
            objectAnimator = ObjectAnimator.ofFloat(imageView, ParamsMap.MirrorParams.KEY_ROTATION, new float[]{0.0f, 180.0f});
        } else {
            ImageView imageView3 = this.mArrowImg;
            if (imageView3 == null) {
                i.w("mArrowImg");
            } else {
                imageView = imageView3;
            }
            objectAnimator = ObjectAnimator.ofFloat(imageView, ParamsMap.MirrorParams.KEY_ROTATION, new float[]{180.0f, 0.0f});
        }
        objectAnimator.setDuration(200);
        objectAnimator.start();
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
        i.g(arrayList, "data");
        this.mData.clear();
        this.mData.addAll(arrayList);
        this.mPop.setData(arrayList);
        setClickable(!arrayList.isEmpty());
        if (!(!arrayList.isEmpty()) || this.mSelectPos >= arrayList.size()) {
            setText("");
            return;
        }
        SwitchAccountBean switchAccountBean = arrayList.get(this.mSelectPos);
        i.f(switchAccountBean, "data[mSelectPos]");
        setText(switchAccountBean.getShowName());
    }

    public final SwitchAccountBean getSelectAccount() {
        SwitchAccountBean switchAccountBean = this.mData.get(this.mSelectPos);
        i.f(switchAccountBean, "mData[mSelectPos]");
        return switchAccountBean;
    }

    public final String getText() {
        TextView textView = this.mTextView;
        if (textView == null) {
            i.w("mTextView");
            textView = null;
        }
        return textView.getText().toString();
    }

    public boolean performClick() {
        rotateArrow(true);
        this.mPop.showAsDropDown(this, 0, AutoUtils.getPercentHeightSize(5));
        return super.performClick();
    }

    public final void setRemoveAccountListener(p pVar) {
        i.g(pVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mRemoveListener = pVar;
    }

    public final void setText(String str) {
        i.g(str, "content");
        TextView textView = this.mTextView;
        if (textView == null) {
            i.w("mTextView");
            textView = null;
        }
        textView.setText(str);
    }
}
