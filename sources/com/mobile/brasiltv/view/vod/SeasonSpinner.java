package com.mobile.brasiltv.view.vod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.y1;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.j1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ProgramSeason;
import t9.g;
import t9.i;

public final class SeasonSpinner extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;
    /* access modifiers changed from: private */
    public AbsSeasonAdapter mSeasonAdapter;
    private y1 mSeasonPopupWindow;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SeasonSpinner(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(SeasonSpinner seasonSpinner, View view) {
        i.g(seasonSpinner, "this$0");
        if (seasonSpinner.isShowingSeasonPopup()) {
            seasonSpinner.hideSeasonPopup();
        } else {
            seasonSpinner.showSeasonPopup();
        }
    }

    private final ArrayAdapter<ProgramSeason> createSeasonAdapter() {
        List list;
        AbsSeasonAdapter absSeasonAdapter = this.mSeasonAdapter;
        if (absSeasonAdapter == null || (list = absSeasonAdapter.getItemData()) == null) {
            list = new ArrayList();
        }
        return new SeasonSpinner$createSeasonAdapter$1(list, this, getContext());
    }

    private final void hideSeasonPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvArrow)).setSelected(false);
        y1 y1Var = this.mSeasonPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
        }
        this.mSeasonPopupWindow = null;
    }

    private final boolean isShowingSeasonPopup() {
        boolean z10;
        y1 y1Var = this.mSeasonPopupWindow;
        if (y1Var == null) {
            return false;
        }
        if (y1Var == null || !y1Var.isShowing()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    private final void showSeasonPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvArrow)).setSelected(true);
        y1 y1Var = new y1(getContext());
        this.mSeasonPopupWindow = y1Var;
        y1Var.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.bg_pop_season));
        y1 y1Var2 = this.mSeasonPopupWindow;
        if (y1Var2 != null) {
            y1Var2.k(createSeasonAdapter());
        }
        y1 y1Var3 = this.mSeasonPopupWindow;
        if (y1Var3 != null) {
            y1Var3.w(this);
        }
        y1 y1Var4 = this.mSeasonPopupWindow;
        if (y1Var4 != null) {
            y1Var4.C(true);
        }
        y1 y1Var5 = this.mSeasonPopupWindow;
        if (y1Var5 != null) {
            y1Var5.D(new a(this));
        }
        y1 y1Var6 = this.mSeasonPopupWindow;
        if (y1Var6 != null) {
            y1Var6.g(-j1.a(getContext(), 2));
        }
        y1 y1Var7 = this.mSeasonPopupWindow;
        if (y1Var7 != null) {
            y1Var7.E(new b(this));
        }
        y1 y1Var8 = this.mSeasonPopupWindow;
        if (y1Var8 != null) {
            y1Var8.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void showSeasonPopup$lambda$1(SeasonSpinner seasonSpinner) {
        i.g(seasonSpinner, "this$0");
        seasonSpinner.mSeasonPopupWindow = null;
        ((ImageView) seasonSpinner._$_findCachedViewById(R$id.mIvArrow)).setSelected(false);
    }

    /* access modifiers changed from: private */
    public static final void showSeasonPopup$lambda$2(SeasonSpinner seasonSpinner, AdapterView adapterView, View view, int i10, long j10) {
        ProgramSeason programSeason;
        i.g(seasonSpinner, "this$0");
        AbsSeasonAdapter absSeasonAdapter = seasonSpinner.mSeasonAdapter;
        if (absSeasonAdapter != null) {
            if (absSeasonAdapter != null) {
                programSeason = absSeasonAdapter.getItem(i10);
            } else {
                programSeason = null;
            }
            absSeasonAdapter.onClickItem(i10, programSeason);
        }
        y1 y1Var = seasonSpinner.mSeasonPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
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

    public final void setSeasonAdapter(AbsSeasonAdapter absSeasonAdapter) {
        i.g(absSeasonAdapter, "adapter");
        this.mSeasonAdapter = absSeasonAdapter;
    }

    public void setVisibility(int i10) {
        y1 y1Var;
        super.setVisibility(i10);
        if (i10 != 0 && (y1Var = this.mSeasonPopupWindow) != null) {
            y1Var.dismiss();
        }
    }

    public final void updateSelectedIndex(int i10) {
        ProgramSeason programSeason;
        AbsSeasonAdapter absSeasonAdapter = this.mSeasonAdapter;
        if (absSeasonAdapter != null) {
            absSeasonAdapter.setSelectedIndex(i10);
        }
        AbsSeasonAdapter absSeasonAdapter2 = this.mSeasonAdapter;
        if (absSeasonAdapter2 != null) {
            TextView textView = (TextView) _$_findCachedViewById(R$id.mTvSeason);
            i.f(textView, "mTvSeason");
            AbsSeasonAdapter absSeasonAdapter3 = this.mSeasonAdapter;
            if (absSeasonAdapter3 != null) {
                programSeason = absSeasonAdapter3.getItem(i10);
            } else {
                programSeason = null;
            }
            absSeasonAdapter2.update(textView, programSeason);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SeasonSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeasonSpinner(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_spinner_season, this, true);
        setOnClickListener(new c(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SeasonSpinner(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
