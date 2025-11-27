package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobile.brasiltv.R$styleable;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;

public final class LiveFragmentTabLayout extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private RelativeLayout leftCon;
    private View leftIndex;
    private TextView leftText;
    private int leftTextColor;
    private int leftTextSize;
    private TabOnClickListener onClickListener;
    private RelativeLayout rightCon;
    private View rightIndex;
    private TextView rightText;
    private int rightTextColor;
    private int rightTextSize;
    private int selectIndexColor;
    private boolean selectLeft;
    private int selectTextColor;

    public LiveFragmentTabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(LiveFragmentTabLayout liveFragmentTabLayout, View view) {
        i.g(liveFragmentTabLayout, "this$0");
        if (!liveFragmentTabLayout.selectLeft) {
            liveFragmentTabLayout.selectLeft = true;
            liveFragmentTabLayout.selectedLeftText();
            TabOnClickListener tabOnClickListener = liveFragmentTabLayout.onClickListener;
            if (tabOnClickListener != null) {
                tabOnClickListener.leftTextClick();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(LiveFragmentTabLayout liveFragmentTabLayout, View view) {
        i.g(liveFragmentTabLayout, "this$0");
        if (liveFragmentTabLayout.selectLeft) {
            liveFragmentTabLayout.selectLeft = false;
            liveFragmentTabLayout.selectedRightText();
            TabOnClickListener tabOnClickListener = liveFragmentTabLayout.onClickListener;
            if (tabOnClickListener != null) {
                tabOnClickListener.rightTextClick();
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

    public final void initView(Context context, AttributeSet attributeSet) {
        TypedArray typedArray;
        int i10;
        int i11;
        int i12;
        int i13;
        if (attributeSet != null) {
            if (context != null) {
                typedArray = context.obtainStyledAttributes(attributeSet, R$styleable.f11940k);
            } else {
                typedArray = null;
            }
            int i14 = -16776961;
            if (typedArray != null) {
                i10 = typedArray.getColor(0, this.leftTextColor);
            } else {
                i10 = -16776961;
            }
            this.leftTextColor = i10;
            if (typedArray != null) {
                i11 = typedArray.getColor(3, this.rightTextColor);
            } else {
                i11 = -16776961;
            }
            this.rightTextColor = i11;
            if (typedArray != null) {
                i12 = typedArray.getColor(6, this.selectIndexColor);
            } else {
                i12 = -16776961;
            }
            this.selectIndexColor = i12;
            if (typedArray != null) {
                i14 = typedArray.getColor(7, this.selectTextColor);
            }
            this.selectTextColor = i14;
            int i15 = 10;
            if (typedArray != null) {
                i13 = typedArray.getDimensionPixelSize(1, this.leftTextSize);
            } else {
                i13 = 10;
            }
            this.leftTextSize = i13;
            if (typedArray != null) {
                i15 = typedArray.getDimensionPixelSize(4, this.rightTextSize);
            }
            this.rightTextSize = i15;
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_live_table, this, true);
        i.f(inflate, "from(context).inflate(R.…t_live_table, this, true)");
        this.leftText = (TextView) inflate.findViewById(R.id.leftText);
        this.rightText = (TextView) inflate.findViewById(R.id.rightText);
        this.leftCon = (RelativeLayout) inflate.findViewById(R.id.leftCon);
        this.rightCon = (RelativeLayout) inflate.findViewById(R.id.rightCon);
        this.leftIndex = inflate.findViewById(R.id.leftIndex);
        this.rightIndex = inflate.findViewById(R.id.rightIndex);
        TextView textView = this.leftText;
        if (textView != null) {
            textView.setText(b0.z(R.string.live_channel));
        }
        TextView textView2 = this.leftText;
        if (textView2 != null) {
            textView2.setTextSize(2, (float) this.leftTextSize);
        }
        TextView textView3 = this.leftText;
        if (textView3 != null) {
            textView3.setTextColor(this.leftTextColor);
        }
        TextView textView4 = this.rightText;
        if (textView4 != null) {
            textView4.setText(b0.z(R.string.live_fav));
        }
        TextView textView5 = this.rightText;
        if (textView5 != null) {
            textView5.setTextSize(2, (float) this.rightTextSize);
        }
        TextView textView6 = this.rightText;
        if (textView6 != null) {
            textView6.setTextColor(this.rightTextColor);
        }
        View view = this.leftIndex;
        if (view != null) {
            view.setBackgroundColor(this.selectIndexColor);
        }
        View view2 = this.rightIndex;
        if (view2 != null) {
            view2.setBackgroundColor(this.selectIndexColor);
        }
        RelativeLayout relativeLayout = this.leftCon;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new m(this));
        }
        RelativeLayout relativeLayout2 = this.rightCon;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new n(this));
        }
        selectedLeftText();
    }

    public final void selectedLeftText() {
        TextView textView = this.leftText;
        if (textView != null) {
            textView.setTextColor(this.selectTextColor);
        }
        TextView textView2 = this.rightText;
        if (textView2 != null) {
            textView2.setTextColor(this.rightTextColor);
        }
        View view = this.leftIndex;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.rightIndex;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void selectedRightText() {
        TextView textView = this.rightText;
        if (textView != null) {
            textView.setTextColor(this.selectTextColor);
        }
        TextView textView2 = this.leftText;
        if (textView2 != null) {
            textView2.setTextColor(this.rightTextColor);
        }
        View view = this.rightIndex;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.leftIndex;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void setOnClickListener(TabOnClickListener tabOnClickListener) {
        i.g(tabOnClickListener, "onClickListener");
        this.onClickListener = tabOnClickListener;
    }

    public LiveFragmentTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveFragmentTabLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this._$_findViewCache = new LinkedHashMap();
        this.leftTextColor = -16776961;
        this.rightTextColor = -16776961;
        this.selectIndexColor = -16776961;
        this.selectTextColor = -16776961;
        this.leftTextSize = 10;
        this.rightTextSize = 10;
        this.selectLeft = true;
        initView(context, attributeSet);
    }
}
