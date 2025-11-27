package com.mobile.brasiltv.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.UpdateRecordAtyEvent;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.mobile.brasiltv.view.dialog.DeleteConfirmDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.a3;
import f5.b3;
import f5.c3;
import f5.d;
import f5.d3;
import f5.z2;
import g5.r2;
import i6.h0;
import i6.i0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.p2;
import t9.i;
import xa.j;

public final class RecordsAty extends d implements i0, DeleteConfirmDialog.ConfirmCallback {

    /* renamed from: l  reason: collision with root package name */
    public boolean f5987l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f5988m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5989n;

    /* renamed from: o  reason: collision with root package name */
    public r2 f5990o = new r2(this, new ArrayList());

    /* renamed from: p  reason: collision with root package name */
    public p2 f5991p;

    /* renamed from: q  reason: collision with root package name */
    public Map f5992q = new LinkedHashMap();

    public static final class a extends GridLayoutManager.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecordsAty f12091a;

        public a(RecordsAty recordsAty) {
            this.f12091a = recordsAty;
        }

        public int getSpanSize(int i10) {
            if (this.f12091a.b3().d().get(i10) instanceof Album) {
                return 1;
            }
            return 3;
        }
    }

    public static final class b implements r2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecordsAty f12092a;

        public b(RecordsAty recordsAty) {
            this.f12092a = recordsAty;
        }

        public void a(Album album, int i10) {
            i.g(album, "album");
            b0.q(this.f12092a, album, "history");
        }

        public void b(int i10, int i11) {
            boolean z10 = true;
            if (i10 == i11) {
                this.f12092a.l3(true);
                ((ImageView) this.f12092a.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_select);
            } else {
                this.f12092a.l3(false);
                ((ImageView) this.f12092a.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
            }
            RecordsAty recordsAty = this.f12092a;
            if (i10 == 0) {
                z10 = false;
            }
            recordsAty.m3(z10);
            if (i10 == 0) {
                ((TextView) this.f12092a.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_666666));
            } else {
                ((TextView) this.f12092a.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_important));
            }
        }
    }

    public static final void d3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        if (recordsAty.f5988m) {
            recordsAty.f5989n = false;
            ((TextView) recordsAty.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_666666));
            recordsAty.f5990o.g(false);
            ((ImageView) recordsAty.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
        } else {
            recordsAty.f5989n = true;
            ((TextView) recordsAty.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_important));
            recordsAty.f5990o.g(true);
            ((ImageView) recordsAty.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_select);
        }
        recordsAty.f5988m = !recordsAty.f5988m;
    }

    public static final void e3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        ((ImageView) recordsAty.Z2(R$id.mIvAllCb)).performClick();
    }

    public static final void f3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        if (recordsAty.f5989n) {
            if (!recordsAty.f5988m) {
                recordsAty.S2().p(recordsAty.f5990o.d());
            } else {
                new DeleteConfirmDialog(recordsAty, R.string.history_whether_delete_all, recordsAty).show();
            }
        }
    }

    public static final void i3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        recordsAty.k3();
    }

    public static final void j3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        recordsAty.k3();
    }

    public void F(List list) {
        i.g(list, "list");
        ((TitleView) Z2(R$id.titleView)).getIvMenuView().setVisibility(0);
        ((AutoLinearLayout) Z2(R$id.mLlEmptyRecord)).setVisibility(8);
        this.f5990o.b(list);
    }

    public void R2() {
        n3(new p2(this, this));
        h3();
        c3();
        g3();
        S2().x();
    }

    public int T2() {
        return R.layout.aty_records;
    }

    public View Z2(int i10) {
        Map map = this.f5992q;
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

    /* renamed from: a3 */
    public p2 S2() {
        p2 p2Var = this.f5991p;
        if (p2Var != null) {
            return p2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final r2 b3() {
        return this.f5990o;
    }

    public final void c3() {
        ((ImageView) Z2(R$id.mIvAllCb)).setOnClickListener(new b3(this));
        ((TextView) Z2(R$id.mTvAllCb)).setOnClickListener(new c3(this));
        ((TextView) Z2(R$id.mTvDelete)).setOnClickListener(new d3(this));
    }

    public final void g3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Q1(), 3);
        gridLayoutManager.setSpanSizeLookup(new a(this));
        int i10 = R$id.mRecyclerRecord;
        ((RecyclerView) Z2(i10)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) Z2(i10)).addItemDecoration(new VerticalItemDecoration(Q1(), 0, AutoUtils.getPercentHeightSize(24)));
        ((RecyclerView) Z2(i10)).setAdapter(this.f5990o);
        this.f5990o.h(new b(this));
    }

    public final void h3() {
        int i10 = R$id.titleView;
        ((TitleView) Z2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) Z2(i10)).getSettingView().setVisibility(8);
        ((TitleView) Z2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) Z2(i10)).setIvMenuSrc(R.drawable.icon_delete_history);
        ((TitleView) Z2(i10)).setIvMenuClickListener(new z2(this));
        ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) Z2(i10)).setTvMenuText(b0.A(this, R.string.cancel));
        ((TitleView) Z2(i10)).setTvMenuClickListener(new a3(this));
    }

    public void k2() {
        n2();
    }

    public final void k3() {
        if (this.f5987l) {
            int i10 = R$id.titleView;
            ((TitleView) Z2(i10)).getIvMenuView().setVisibility(0);
            ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
            ((AutoRelativeLayout) Z2(R$id.mRlDeletePanel)).setVisibility(8);
        } else {
            int i11 = R$id.titleView;
            ((TitleView) Z2(i11)).getIvMenuView().setVisibility(8);
            ((TitleView) Z2(i11)).getTvMenuView().setVisibility(0);
            ((AutoRelativeLayout) Z2(R$id.mRlDeletePanel)).setVisibility(0);
        }
        this.f5988m = false;
        this.f5989n = false;
        ((ImageView) Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
        ((TextView) Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_666666));
        boolean z10 = !this.f5987l;
        this.f5987l = z10;
        this.f5990o.i(z10);
    }

    public void l() {
        ((TitleView) Z2(R$id.titleView)).getIvMenuView().setVisibility(8);
        ((AutoLinearLayout) Z2(R$id.mLlEmptyRecord)).setVisibility(0);
        this.f5990o.b(new ArrayList());
    }

    public final void l3(boolean z10) {
        this.f5988m = z10;
    }

    public final void m3(boolean z10) {
        this.f5989n = z10;
    }

    public void n3(p2 p2Var) {
        i.g(p2Var, "<set-?>");
        this.f5991p = p2Var;
    }

    /* renamed from: o3 */
    public void Y0(h0 h0Var) {
        i.g(h0Var, "presenter");
    }

    public void onConfirm() {
        S2().p(this.f5990o.d());
    }

    public void p2() {
    }

    @j(sticky = true)
    public final void updateRecord(UpdateRecordAtyEvent updateRecordAtyEvent) {
        i.g(updateRecordAtyEvent, "event");
        S2().x();
    }

    public void z2() {
        this.f5987l = false;
        this.f5988m = false;
        int i10 = R$id.titleView;
        ((TitleView) Z2(i10)).getIvMenuView().setVisibility(0);
        ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
        ((ImageView) Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
        ((AutoRelativeLayout) Z2(R$id.mRlDeletePanel)).setVisibility(8);
    }
}
