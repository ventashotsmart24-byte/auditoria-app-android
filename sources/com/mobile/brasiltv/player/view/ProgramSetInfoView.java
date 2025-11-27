package com.mobile.brasiltv.player.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.PlaySetIndexEvent;
import com.mobile.brasiltv.bean.event.RequestAuthEvent;
import com.mobile.brasiltv.bean.event.SelectedSeason;
import com.mobile.brasiltv.db.Links;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.HorizontalDecoration;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g7.l;
import h9.h;
import i9.j;
import i9.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.ProgramSeason;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import t9.g;
import t9.i;
import t9.z;

public final class ProgramSetInfoView extends AutoRelativeLayout {

    /* renamed from: j  reason: collision with root package name */
    public static final a f6148j = new a((g) null);

    /* renamed from: a  reason: collision with root package name */
    public AssetData f6149a;

    /* renamed from: b  reason: collision with root package name */
    public int f6150b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6151c;

    /* renamed from: d  reason: collision with root package name */
    public final h9.g f6152d;

    /* renamed from: e  reason: collision with root package name */
    public l f6153e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6154f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6155g;

    /* renamed from: h  reason: collision with root package name */
    public int f6156h;

    /* renamed from: i  reason: collision with root package name */
    public Map f6157i = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgramSetInfoView f12478a;

        public b(ProgramSetInfoView programSetInfoView) {
            this.f12478a = programSetInfoView;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            i.g(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i10);
            if (this.f12478a.f6155g) {
                this.f12478a.f6155g = false;
                ProgramSetInfoView programSetInfoView = this.f12478a;
                programSetInfoView.x(programSetInfoView.f6156h);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            i.g(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i10, i11);
            ProgramSetInfoView programSetInfoView = this.f12478a;
            int i12 = R$id.mSeekBarProgram;
            if (((SeekBar) programSetInfoView._$_findCachedViewById(i12)).getVisibility() == 0) {
                ProgramSetInfoView programSetInfoView2 = this.f12478a;
                int i13 = R$id.mRecyclerSelectInfo;
                int computeHorizontalScrollRange = ((RecyclerView) programSetInfoView2._$_findCachedViewById(i13)).computeHorizontalScrollRange() - ((RecyclerView) this.f12478a._$_findCachedViewById(i13)).getWidth();
                ((SeekBar) this.f12478a._$_findCachedViewById(i12)).setProgress((((SeekBar) this.f12478a._$_findCachedViewById(i12)).getMax() * recyclerView.computeHorizontalScrollOffset()) / computeHorizontalScrollRange);
            }
        }
    }

    public static final class c implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgramSetInfoView f12479a;

        public c(ProgramSetInfoView programSetInfoView) {
            this.f12479a = programSetInfoView;
        }

        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            i.g(seekBar, "seekBar");
            if (z10) {
                ProgramSetInfoView programSetInfoView = this.f12479a;
                int i11 = R$id.mRecyclerSelectInfo;
                ((RecyclerView) this.f12479a._$_findCachedViewById(i11)).scrollBy((((((RecyclerView) programSetInfoView._$_findCachedViewById(i11)).computeHorizontalScrollRange() - ((RecyclerView) this.f12479a._$_findCachedViewById(i11)).getWidth()) * i10) / seekBar.getMax()) - ((RecyclerView) this.f12479a._$_findCachedViewById(i11)).computeHorizontalScrollOffset(), 0);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            i.g(seekBar, "seekBar");
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            i.g(seekBar, "seekBar");
        }
    }

    public static final class d implements l.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProgramSetInfoView f12480a;

        public d(ProgramSetInfoView programSetInfoView) {
            this.f12480a = programSetInfoView;
        }

        public void a(int i10, ProgramSeason programSeason) {
            i.g(programSeason, "data");
            xa.c.c().j(new SelectedSeason(programSeason));
            l c10 = this.f12480a.f6153e;
            i.d(c10);
            c10.dismiss();
        }
    }

    public ProgramSetInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6152d = h.b(r6.i.f19411a);
        this.f6154f = 100;
        m();
        this.f6156h = -1;
        LayoutInflater.from(context).inflate(R.layout.layout_program_set_info_view, this, true);
        j();
    }

    private final int getSelectedSeason() {
        AssetData assetData = this.f6149a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        List<ProgramSeason> sameSeasonSeriesList = assetData.getSameSeasonSeriesList();
        i.d(sameSeasonSeriesList);
        int i10 = 0;
        for (T next : sameSeasonSeriesList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                j.j();
            }
            String contentId = ((ProgramSeason) next).getContentId();
            AssetData assetData2 = this.f6149a;
            if (assetData2 == null) {
                i.w("data");
                assetData2 = null;
            }
            if (i.b(contentId, assetData2.getContentId())) {
                return i10;
            }
            i10 = i11;
        }
        return 0;
    }

    private final n6.a getSetInfoAdapter() {
        return (n6.a) this.f6152d.getValue();
    }

    public static /* synthetic */ void l(ProgramSetInfoView programSetInfoView, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        programSetInfoView.k(i10);
    }

    public static /* synthetic */ void p(ProgramSetInfoView programSetInfoView, int i10, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        programSetInfoView.o(i10, z10, z11);
    }

    public static /* synthetic */ void s(ProgramSetInfoView programSetInfoView, VodDao vodDao, AssetData assetData, String str, boolean z10, boolean z11, int i10, Object obj) {
        boolean z12;
        if ((i10 & 16) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        programSetInfoView.r(vodDao, assetData, str, z10, z12);
    }

    public static final void t(ProgramSetInfoView programSetInfoView, View view) {
        i.g(programSetInfoView, "this$0");
        if (programSetInfoView.f6153e == null) {
            Context context = programSetInfoView.getContext();
            i.e(context, "null cannot be cast to non-null type android.app.Activity");
            l lVar = new l((Activity) context);
            programSetInfoView.f6153e = lVar;
            i.d(lVar);
            lVar.j(new d(programSetInfoView));
        }
        l lVar2 = programSetInfoView.f6153e;
        if (lVar2 != null) {
            lVar2.c(false);
        }
        l lVar3 = programSetInfoView.f6153e;
        if (lVar3 != null) {
            AssetData assetData = programSetInfoView.f6149a;
            if (assetData == null) {
                i.w("data");
                assetData = null;
            }
            List<ProgramSeason> sameSeasonSeriesList = assetData.getSameSeasonSeriesList();
            i.d(sameSeasonSeriesList);
            List G = r.G(sameSeasonSeriesList);
            i.e(G, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.ProgramSeason>");
            lVar3.k((ArrayList) G, programSetInfoView.getSelectedSeason());
        }
    }

    public static final void v(ProgramSetInfoView programSetInfoView, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        i.g(programSetInfoView, "this$0");
        if (programSetInfoView.getSetInfoAdapter().a() != i10) {
            p(programSetInfoView, i10, false, false, 6, (Object) null);
        }
        programSetInfoView.f6156h = i10;
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.f6157i;
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

    public final void h() {
        l lVar;
        l lVar2 = this.f6153e;
        boolean z10 = false;
        if (lVar2 != null && lVar2.isShowing()) {
            z10 = true;
        }
        if (z10 && (lVar = this.f6153e) != null) {
            lVar.dismiss();
        }
    }

    @xa.j
    public final void handleSelectEvent(PlaySetIndexEvent playSetIndexEvent) {
        i.g(playSetIndexEvent, "event");
        if (this.f6151c || playSetIndexEvent.isCast()) {
            b0.U(this, "收到请求开始鉴权");
            AssetData assetData = this.f6149a;
            if (assetData == null) {
                i.w("data");
                assetData = null;
            }
            n(assetData.getSimpleProgramList().get(playSetIndexEvent.getPlaySetIndex()), playSetIndexEvent.getPlaySetIndex(), playSetIndexEvent.isCast(), playSetIndexEvent.isVideoStop());
            if (getSetInfoAdapter().getData().size() > 0) {
                getSetInfoAdapter().c(playSetIndexEvent.getPlaySetIndex());
            }
        }
    }

    public final void i(String str) {
        AssetData assetData = this.f6149a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        if (i.b("movie", assetData.getProgramType())) {
            setVisibility(8);
        } else if (i.b(str, "1")) {
            setVisibility(8);
        } else {
            setVisibility(0);
            w();
            q();
            u();
        }
    }

    public final void j() {
        int i10 = R$id.mRecyclerSelectInfo;
        ((RecyclerView) _$_findCachedViewById(i10)).setLayoutManager(new LinearLayoutManagerWrapper(getContext(), 0, false));
        ((RecyclerView) _$_findCachedViewById(i10)).addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(20)));
        ((RecyclerView) _$_findCachedViewById(i10)).setItemAnimator((RecyclerView.l) null);
        ((RecyclerView) _$_findCachedViewById(i10)).addOnScrollListener(new b(this));
        ((SeekBar) _$_findCachedViewById(R$id.mSeekBarProgram)).setOnSeekBarChangeListener(new c(this));
    }

    public final void k(int i10) {
        this.f6150b = i10;
        this.f6156h = i10;
        AssetData assetData = this.f6149a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        assetData.getSimpleProgramList().get(i10).setPlayed(true);
    }

    public final void m() {
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
    }

    public final void n(SimpleProgramList simpleProgramList, int i10, boolean z10, boolean z11) {
        xa.c.c().j(new RequestAuthEvent(i10, simpleProgramList, z10, z11));
    }

    public final void o(int i10, boolean z10, boolean z11) {
        xa.c.c().j(new PlaySetIndexEvent(i10, z10, z11));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xa.c.c().r(this);
    }

    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = R$id.mRecyclerSelectInfo;
        if (((RecyclerView) _$_findCachedViewById(i14)).getAdapter() != null) {
            ((RecyclerView) _$_findCachedViewById(i14)).scrollToPosition(this.f6156h);
        }
    }

    public final void q() {
        boolean z10;
        AssetData assetData = this.f6149a;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        List<ProgramSeason> sameSeasonSeriesList = assetData.getSameSeasonSeriesList();
        if (sameSeasonSeriesList == null || sameSeasonSeriesList.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || sameSeasonSeriesList.size() == 1) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlSeason)).setVisibility(8);
            return;
        }
        int i10 = R$id.mLlSeason;
        ((AutoLinearLayout) _$_findCachedViewById(i10)).setVisibility(0);
        ((AutoLinearLayout) _$_findCachedViewById(i10)).setOnClickListener(new r6.h(this));
        AssetData assetData2 = this.f6149a;
        if (assetData2 == null) {
            i.w("data");
            assetData2 = null;
        }
        List<ProgramSeason> sameSeasonSeriesList2 = assetData2.getSameSeasonSeriesList();
        i.d(sameSeasonSeriesList2);
        int i11 = 0;
        for (T next : sameSeasonSeriesList2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                j.j();
            }
            ProgramSeason programSeason = (ProgramSeason) next;
            String contentId = programSeason.getContentId();
            AssetData assetData3 = this.f6149a;
            if (assetData3 == null) {
                i.w("data");
                assetData3 = null;
            }
            if (i.b(contentId, assetData3.getContentId())) {
                ((TextView) _$_findCachedViewById(R$id.mTvSeasonSelect)).setText(getContext().getString(R.string.vod_season, new Object[]{Integer.valueOf(programSeason.getSeasonNumber())}));
            }
            i11 = i12;
        }
    }

    public final void r(VodDao vodDao, AssetData assetData, String str, boolean z10, boolean z11) {
        int i10;
        i.g(vodDao, "vodDao");
        i.g(assetData, "program");
        i.g(str, "vodType");
        this.f6149a = assetData;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        if (assetData.getSimpleProgramList().isEmpty()) {
            setVisibility(8);
            return;
        }
        AssetData assetData2 = this.f6149a;
        if (assetData2 == null) {
            i.w("data");
            assetData2 = null;
        }
        if (i.b("movie", assetData2.getProgramType())) {
            p(this, 0, z10, z11, 1, (Object) null);
        } else {
            AssetData assetData3 = this.f6149a;
            if (assetData3 == null) {
                i.w("data");
                assetData3 = null;
            }
            Links queryRecordByContentId$default = VodDao.queryRecordByContentId$default(vodDao, assetData3.getContentId(), 0, 2, (Object) null);
            if (queryRecordByContentId$default != null) {
                i10 = queryRecordByContentId$default.getPosition();
            } else {
                i10 = 0;
            }
            if (i10 >= 0) {
                AssetData assetData4 = this.f6149a;
                if (assetData4 == null) {
                    i.w("data");
                    assetData4 = null;
                }
                if (i10 < assetData4.getSimpleProgramList().size()) {
                    o(i10, z10, z11);
                    k(i10);
                }
            }
            p(this, 0, z10, z11, 1, (Object) null);
            l(this, 0, 1, (Object) null);
        }
        i(str);
    }

    public final void setIsResumed(boolean z10) {
        this.f6151c = z10;
    }

    public final void u() {
        int i10 = R$id.mRecyclerSelectInfo;
        ((RecyclerView) _$_findCachedViewById(i10)).setAdapter(getSetInfoAdapter());
        getSetInfoAdapter().b(this.f6150b);
        n6.a setInfoAdapter = getSetInfoAdapter();
        AssetData assetData = this.f6149a;
        AssetData assetData2 = null;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        setInfoAdapter.setNewData(assetData.getSimpleProgramList());
        getSetInfoAdapter().setOnItemClickListener(new r6.g(this));
        AssetData assetData3 = this.f6149a;
        if (assetData3 == null) {
            i.w("data");
        } else {
            assetData2 = assetData3;
        }
        if (assetData2.getSimpleProgramList().size() >= this.f6154f) {
            ((SeekBar) _$_findCachedViewById(R$id.mSeekBarProgram)).setVisibility(0);
        } else {
            ((SeekBar) _$_findCachedViewById(R$id.mSeekBarProgram)).setVisibility(8);
        }
        ((RecyclerView) _$_findCachedViewById(i10)).scrollToPosition(this.f6150b);
    }

    public final void w() {
        String str;
        int i10 = R$id.mTextSetNumber;
        TextView textView = (TextView) _$_findCachedViewById(i10);
        AssetData assetData = this.f6149a;
        AssetData assetData2 = null;
        if (assetData == null) {
            i.w("data");
            assetData = null;
        }
        int updateCount = assetData.getUpdateCount();
        AssetData assetData3 = this.f6149a;
        if (assetData3 == null) {
            i.w("data");
            assetData3 = null;
        }
        boolean z10 = false;
        if (updateCount == assetData3.getVolumnCount()) {
            z zVar = z.f19601a;
            String string = getResources().getString(R.string.recommend_episodes_all);
            i.f(string, "resources.getString(R.st…g.recommend_episodes_all)");
            Object[] objArr = new Object[1];
            AssetData assetData4 = this.f6149a;
            if (assetData4 == null) {
                i.w("data");
                assetData4 = null;
            }
            objArr[0] = Integer.valueOf(assetData4.getVolumnCount());
            str = String.format(string, Arrays.copyOf(objArr, 1));
            i.f(str, "format(format, *args)");
        } else {
            z zVar2 = z.f19601a;
            String string2 = getResources().getString(R.string.recommend_episodes);
            i.f(string2, "resources.getString(R.string.recommend_episodes)");
            Object[] objArr2 = new Object[1];
            AssetData assetData5 = this.f6149a;
            if (assetData5 == null) {
                i.w("data");
                assetData5 = null;
            }
            objArr2[0] = Integer.valueOf(assetData5.getUpdateCount());
            str = String.format(string2, Arrays.copyOf(objArr2, 1));
            i.f(str, "format(format, *args)");
        }
        textView.setText(str);
        AssetData assetData6 = this.f6149a;
        if (assetData6 == null) {
            i.w("data");
        } else {
            assetData2 = assetData6;
        }
        List<ProgramSeason> sameSeasonSeriesList = assetData2.getSameSeasonSeriesList();
        if (sameSeasonSeriesList == null || sameSeasonSeriesList.isEmpty()) {
            z10 = true;
        }
        if (z10) {
            ((TextView) _$_findCachedViewById(i10)).setGravity(19);
        } else {
            ((TextView) _$_findCachedViewById(i10)).setGravity(21);
        }
    }

    public final void x(int i10) {
        int i11 = R$id.mRecyclerSelectInfo;
        int childLayoutPosition = ((RecyclerView) _$_findCachedViewById(i11)).getChildLayoutPosition(((RecyclerView) _$_findCachedViewById(i11)).getChildAt(0));
        int childLayoutPosition2 = ((RecyclerView) _$_findCachedViewById(i11)).getChildLayoutPosition(((RecyclerView) _$_findCachedViewById(i11)).getChildAt(((RecyclerView) _$_findCachedViewById(i11)).getChildCount() - 1));
        if (i10 < childLayoutPosition) {
            ((RecyclerView) _$_findCachedViewById(i11)).smoothScrollToPosition(i10);
        } else if (i10 <= childLayoutPosition2) {
            int i12 = i10 - childLayoutPosition;
            if (i12 >= 0 && i12 < ((RecyclerView) _$_findCachedViewById(i11)).getChildCount()) {
                ((RecyclerView) _$_findCachedViewById(i11)).smoothScrollBy(((RecyclerView) _$_findCachedViewById(i11)).getChildAt(i12).getLeft(), 0);
            }
        } else {
            ((RecyclerView) _$_findCachedViewById(i11)).smoothScrollToPosition(i10);
            this.f6156h = i10;
            this.f6155g = true;
        }
    }
}
