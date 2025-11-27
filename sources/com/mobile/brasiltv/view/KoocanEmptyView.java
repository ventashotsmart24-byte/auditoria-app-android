package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class KoocanEmptyView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private AnimationDrawable loading;
    private ReloadListener reloadListener;
    private Type viewType;

    public interface ReloadListener {
        void onClick();
    }

    public enum Type {
        NO_CONTENT,
        NO_WIFI,
        NO_DISCUSS,
        NO_COLLECT,
        NO_MSG,
        NO_PLAY,
        NO_ORDER,
        LOADING,
        NO_BESPEAK,
        NO_LIVE_ORDER,
        NO_SEARCH
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.mobile.brasiltv.view.KoocanEmptyView$Type[] r0 = com.mobile.brasiltv.view.KoocanEmptyView.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_CONTENT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_WIFI     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_DISCUSS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_COLLECT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_MSG     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_PLAY     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_ORDER     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.LOADING     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_LIVE_ORDER     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_BESPEAK     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.mobile.brasiltv.view.KoocanEmptyView$Type r1 = com.mobile.brasiltv.view.KoocanEmptyView.Type.NO_SEARCH     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.KoocanEmptyView.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context) {
        super(context);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
    }

    private final Type changeNum2Type(int i10) {
        switch (i10) {
            case 0:
                return Type.NO_CONTENT;
            case 1:
                return Type.NO_WIFI;
            case 2:
                return Type.NO_DISCUSS;
            case 3:
                return Type.NO_COLLECT;
            case 4:
                return Type.NO_MSG;
            case 5:
                return Type.NO_PLAY;
            case 6:
                return Type.NO_ORDER;
            case 7:
                return Type.LOADING;
            case 9:
                return Type.NO_BESPEAK;
            case 10:
                return Type.NO_LIVE_ORDER;
            case 11:
                return Type.NO_SEARCH;
            default:
                return Type.NO_CONTENT;
        }
    }

    private final void configView() {
        ((AutoLinearLayout) _$_findCachedViewById(R$id.koocanEmptyContent)).setOnClickListener(new l(this));
    }

    /* access modifiers changed from: private */
    public static final void configView$lambda$1(KoocanEmptyView koocanEmptyView, View view) {
        i.g(koocanEmptyView, "this$0");
        ReloadListener reloadListener2 = koocanEmptyView.reloadListener;
        if (reloadListener2 != null && koocanEmptyView.viewType == Type.NO_WIFI) {
            reloadListener2.onClick();
            koocanEmptyView.changeType(Type.LOADING);
        }
    }

    private final void initView(Context context, int i10) {
        LayoutInflater.from(context).inflate(R.layout.koocan_empty, this);
        changeType(changeNum2Type(i10));
    }

    private final void intView(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.f11936g, i10, i10);
        i.f(obtainStyledAttributes, "context.theme.obtainStyl…fStyleAttr, defStyleAttr)");
        int i11 = obtainStyledAttributes.getInt(1, 1);
        int color = obtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.color_secondary_background));
        initView(context, i11);
        setBackground(color);
        configView();
    }

    private final void setTip(int i10) {
        ((TextView) _$_findCachedViewById(R$id.koocanEmptyTip)).setText(b0.z(i10));
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

    public final void changeType(Type type) {
        i.g(type, "type");
        this.viewType = type;
        if (type == Type.LOADING) {
            ((LinearLayout) _$_findCachedViewById(R$id.koocanEmptyLayout)).setVisibility(8);
            ((ProgressBar) _$_findCachedViewById(R$id.koocanLoadLayout)).setVisibility(0);
        } else {
            ((LinearLayout) _$_findCachedViewById(R$id.koocanEmptyLayout)).setVisibility(0);
            ((ProgressBar) _$_findCachedViewById(R$id.koocanLoadLayout)).setVisibility(8);
        }
        int i10 = R$id.koocanEmptyRefreshTip;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                setTip((int) R.string.koocan_no_content);
                return;
            case 2:
                setTip((int) R.string.koocan_no_net);
                if (this.reloadListener != null) {
                    ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
                    return;
                }
                return;
            case 3:
                setTip((int) R.string.koocan_no_discuss);
                return;
            case 4:
                setTip((int) R.string.koocan_no_collect);
                return;
            case 5:
                setTip((int) R.string.koocan_no_msg);
                return;
            case 6:
                setTip((int) R.string.koocan_no_play);
                return;
            case 7:
                setTip((int) R.string.koocan_no_order);
                return;
            case 9:
                setTip((int) R.string.channel_live_advance_no);
                return;
            case 10:
                setTip((int) R.string.live_order_no_hint_top);
                return;
            case 11:
                setTip((int) R.string.live_order_no_hint_top);
                return;
            default:
                return;
        }
    }

    public final AnimationDrawable getLoading() {
        return this.loading;
    }

    public final ReloadListener getReloadListener() {
        return this.reloadListener;
    }

    public final Type getViewType() {
        return this.viewType;
    }

    public final void setBackground(int i10) {
        ((AutoLinearLayout) _$_findCachedViewById(R$id.koocanEmptyContent)).setBackgroundColor(i10);
    }

    public final void setBackgroundDrawable(int i10) {
        ((AutoLinearLayout) _$_findCachedViewById(R$id.koocanEmptyContent)).setBackgroundResource(i10);
    }

    public final void setLoading(AnimationDrawable animationDrawable) {
        this.loading = animationDrawable;
    }

    public final void setReloadListener(ReloadListener reloadListener2) {
        this.reloadListener = reloadListener2;
        if (this.viewType == Type.NO_WIFI) {
            ((TextView) _$_findCachedViewById(R$id.koocanEmptyRefreshTip)).setVisibility(0);
        }
    }

    public final void setTextImageMarginTop(int i10) {
        int i11 = R$id.koocanEmptyTip;
        ViewGroup.LayoutParams layoutParams = ((TextView) _$_findCachedViewById(i11)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = i10;
        ((TextView) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
    }

    public final void setViewType(Type type) {
        i.g(type, "<set-?>");
        this.viewType = type;
    }

    public void setVisibility(int i10) {
        AnimationDrawable animationDrawable;
        if (i10 == 0) {
            AnimationDrawable animationDrawable2 = this.loading;
            if (animationDrawable2 != null) {
                animationDrawable2.start();
            }
        } else if ((i10 == 4 || i10 == 8) && (animationDrawable = this.loading) != null) {
            animationDrawable.stop();
        }
        super.setVisibility(i10);
    }

    public final void setTip(String str) {
        i.g(str, "str");
        ((TextView) _$_findCachedViewById(R$id.koocanEmptyTip)).setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
        intView(context, attributeSet, 0);
    }

    private final void initView(Type type) {
        LayoutInflater.from(getContext()).inflate(R.layout.koocan_empty, this);
        changeType(type);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
        intView(context, attributeSet, i10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoocanEmptyView(Context context, Type type) {
        super(context);
        i.g(type, "type");
        this._$_findViewCache = new LinkedHashMap();
        this.viewType = Type.NO_CONTENT;
        initView(type);
        configView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KoocanEmptyView(Context context, Type type, int i10, g gVar) {
        this(context, (i10 & 2) != 0 ? Type.NO_CONTENT : type);
    }
}
