package com.mobile.brasiltv.player.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.GridLayoutManagerWrapper;
import com.mobile.brasiltv.view.PaddingItemDecoration;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import f5.c;
import g5.w;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ShelveAsset;
import na.e;
import r6.d;
import t9.i;

public final class ProgramRecommendInfoView extends AutoLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public final int f12471a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12472b;

    /* renamed from: c  reason: collision with root package name */
    public int f12473c;

    /* renamed from: d  reason: collision with root package name */
    public final g f12474d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f12475e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12476f;

    /* renamed from: g  reason: collision with root package name */
    public Map f12477g = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgramRecommendInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.g(context, f.X);
        this.f12471a = 6;
        this.f12472b = 12;
        this.f12474d = h.b(new r6.f(this));
        this.f12475e = new ArrayList();
        LayoutInflater.from(context).inflate(R.layout.layout_program_recommend_view, this, true);
        initView();
    }

    public static final void d(ProgramRecommendInfoView programRecommendInfoView, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(programRecommendInfoView, "this$0");
        ShelveAsset shelveAsset = (ShelveAsset) programRecommendInfoView.getAdapter().getItem(i10);
        if (shelveAsset != null) {
            e.f19075a = true;
            Context context = programRecommendInfoView.getContext();
            i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            b0.s((c) context, shelveAsset, "detail/recommend", programRecommendInfoView.f12476f);
        }
    }

    public static final void e(ProgramRecommendInfoView programRecommendInfoView, View view) {
        i.g(programRecommendInfoView, "this$0");
        programRecommendInfoView.g();
    }

    private final w getAdapter() {
        return (w) this.f12474d.getValue();
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.f12477g;
        View view = (View) map.get(Integer.valueOf(i10));
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

    public final void c(List list) {
        i.g(list, "recommendList");
        this.f12475e.clear();
        this.f12475e.addAll(list);
        this.f12473c = 0;
        if (list.size() >= this.f12472b) {
            ((ImageView) _$_findCachedViewById(R$id.mImgRefresh)).setVisibility(0);
        }
        if (list.size() < this.f12471a) {
            getAdapter().setNewData(list);
            return;
        }
        w adapter = getAdapter();
        int i10 = this.f12473c;
        adapter.setNewData(list.subList(i10, this.f12471a + i10));
        this.f12473c += this.f12471a;
    }

    public final void f(boolean z10) {
        this.f12476f = z10;
    }

    public final void g() {
        int size = this.f12475e.size();
        boolean z10 = true;
        int i10 = (this.f12473c + this.f12471a) - 1;
        if (i10 < 0 || i10 >= size) {
            z10 = false;
        }
        if (!z10) {
            this.f12473c = 0;
        }
        w adapter = getAdapter();
        ArrayList arrayList = this.f12475e;
        int i11 = this.f12473c;
        adapter.setNewData(arrayList.subList(i11, this.f12471a + i11));
        this.f12473c += this.f12471a;
    }

    public final void initView() {
        setOrientation(1);
        int i10 = R$id.mRecyclerChange;
        ((RecyclerView) _$_findCachedViewById(i10)).setLayoutManager(new GridLayoutManagerWrapper(getContext(), 3));
        Context context = getContext();
        i.f(context, f.X);
        ((RecyclerView) _$_findCachedViewById(i10)).addItemDecoration(new PaddingItemDecoration(context, 1, false, true));
        ((RecyclerView) _$_findCachedViewById(i10)).setAdapter(getAdapter());
        getAdapter().setOnItemClickListener(new d(this));
        ((ImageView) _$_findCachedViewById(R$id.mImgRefresh)).setOnClickListener(new r6.e(this));
    }
}
