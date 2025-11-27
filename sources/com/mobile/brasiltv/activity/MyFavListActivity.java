package com.mobile.brasiltv.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.mobile.brasiltv.view.dialog.DeleteConfirmDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.a2;
import f5.b2;
import f5.c2;
import f5.d2;
import f5.e2;
import f5.f2;
import f5.g2;
import f5.h2;
import f5.i2;
import f5.j2;
import f5.l1;
import f5.m1;
import f5.n1;
import f5.o1;
import f5.p1;
import f5.q1;
import f5.r1;
import f5.s1;
import f5.t1;
import f5.u1;
import f5.v1;
import f5.w1;
import f5.x1;
import f5.y1;
import f5.z1;
import g5.d1;
import h9.t;
import i6.z;
import i9.r;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.g1;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.Favorite;
import s9.p;
import w6.i;

public final class MyFavListActivity extends f5.d implements z, SwipeRefreshLayout.j, DeleteConfirmDialog.ConfirmCallback {

    /* renamed from: l  reason: collision with root package name */
    public boolean f5950l;

    /* renamed from: m  reason: collision with root package name */
    public g1 f5951m;

    /* renamed from: n  reason: collision with root package name */
    public final h9.g f5952n = h9.h.b(new g(this));

    /* renamed from: o  reason: collision with root package name */
    public boolean f5953o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5954p;

    /* renamed from: q  reason: collision with root package name */
    public int f5955q;

    /* renamed from: r  reason: collision with root package name */
    public Map f5956r = new LinkedHashMap();

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyFavListActivity f12048a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MyFavListActivity myFavListActivity) {
            super(1);
            this.f12048a = myFavListActivity;
        }

        /* renamed from: b */
        public final Boolean invoke(Favorite favorite) {
            boolean z10;
            t9.i.g(favorite, "it");
            if (!this.f12048a.H3()) {
                return Boolean.valueOf(favorite.isSelect());
            }
            if (favorite.getId() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12049a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Integer invoke(Favorite favorite) {
            t9.i.g(favorite, "it");
            return favorite.getId();
        }
    }

    public static final class c extends t9.j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final c f12050a = new c();

        public c() {
            super(2);
        }

        public final void b(ArrayList arrayList, Integer num) {
            t9.i.d(num);
            arrayList.add(num);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, (Integer) obj2);
            return t.f17319a;
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f12051a = new d();

        public d() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(ArrayList arrayList) {
            t9.i.g(arrayList, "it");
            if (!arrayList.isEmpty()) {
                return Boolean.TRUE;
            }
            throw new NullPointerException("delList is empty");
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyFavListActivity f12052a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f12053b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MyFavListActivity myFavListActivity, ArrayList arrayList) {
            super(1);
            this.f12052a = myFavListActivity;
            this.f12053b = arrayList;
        }

        public final void b(DelFavoriteResult delFavoriteResult) {
            List data = this.f12052a.F3().getData();
            t9.i.f(data, "mMyFavListAdapter.data");
            int size = data.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    break;
                }
                ArrayList arrayList = this.f12053b;
                t9.i.f(arrayList, "filterArray");
                if (r.p(arrayList, ((Favorite) data.get(size)).getId())) {
                    data.remove(size);
                }
            }
            this.f12052a.c4();
            this.f12052a.F3().notifyDataSetChanged();
            if (data.size() == 0) {
                MyFavListActivity myFavListActivity = this.f12052a;
                myFavListActivity.a0(myFavListActivity.f5950l);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((DelFavoriteResult) obj);
            return t.f17319a;
        }
    }

    public static final class f extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyFavListActivity f12054a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12055a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12055a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12055a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public f(MyFavListActivity myFavListActivity) {
            this.f12054a = myFavListActivity;
        }

        /* renamed from: f */
        public void onNext(DelFavoriteResult delFavoriteResult) {
            t9.i.g(delFavoriteResult, "t");
            b0.U(this, "delFavSuccess,favoriteId:" + delFavoriteResult.getReturnCode());
            LoadingDialog.Companion.hidden();
            ((ImageView) this.f12054a.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
            this.f12054a.k4(0);
        }

        public void onComplete() {
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            LoadingDialog.Companion.show(this.f12054a.getFragmentManager());
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            LoadingDialog.Companion.hidden();
            x.f12622a.w(this.f12054a.Q1(), new a(str));
        }
    }

    public static final class g extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyFavListActivity f12056a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(MyFavListActivity myFavListActivity) {
            super(0);
            this.f12056a = myFavListActivity;
        }

        /* renamed from: b */
        public final d1 invoke() {
            return new d1(this.f12056a);
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f12057a = new h();

        public h() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(Favorite favorite) {
            t9.i.g(favorite, "it");
            return Boolean.valueOf(favorite.isSelect());
        }
    }

    public static final class i extends t9.j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final i f12058a = new i();

        public i() {
            super(2);
        }

        public final void b(ArrayList arrayList, Favorite favorite) {
            t9.i.d(favorite);
            arrayList.add(favorite);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, (Favorite) obj2);
            return t.f17319a;
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyFavListActivity f12059a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(MyFavListActivity myFavListActivity) {
            super(1);
            this.f12059a = myFavListActivity;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return t.f17319a;
        }

        public final void invoke(ArrayList arrayList) {
            if (this.f12059a.H3() || !arrayList.isEmpty()) {
                MyFavListActivity myFavListActivity = this.f12059a;
                int i10 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i10)).setBackgroundColor(this.f12059a.getResources().getColor(R.color.color_important));
                ((Button) this.f12059a.t3(i10)).setClickable(true);
                return;
            }
            MyFavListActivity myFavListActivity2 = this.f12059a;
            int i11 = R$id.btnDelete;
            ((Button) myFavListActivity2.t3(i11)).setBackgroundColor(this.f12059a.getResources().getColor(R.color.color_666666));
            ((Button) this.f12059a.t3(i11)).setClickable(false);
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final k f12060a = new k();

        public k() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class l extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final l f12061a = new l();

        public l() {
            super(1);
        }

        public final void b(Favorite favorite) {
            t9.i.g(favorite, "it");
            favorite.setSelect(false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Favorite) obj);
            return t.f17319a;
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyFavListActivity f12062a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(MyFavListActivity myFavListActivity) {
            super(1);
            this.f12062a = myFavListActivity;
        }

        public final void b(t tVar) {
            this.f12062a.F3().notifyDataSetChanged();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((t) obj);
            return t.f17319a;
        }
    }

    public static final ArrayList A3() {
        return new ArrayList();
    }

    public static final void B3(p pVar, Object obj, Object obj2) {
        t9.i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final boolean C3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ObservableSource D3(MyFavListActivity myFavListActivity, ArrayList arrayList) {
        t9.i.g(myFavListActivity, "this$0");
        t9.i.g(arrayList, "filterArray");
        b0.U(myFavListActivity, "MyFavListActivity 删除 " + arrayList);
        return w6.i.f9510g.b().o1(r.F(arrayList)).doOnNext(new b2(new e(myFavListActivity, arrayList)));
    }

    public static final void E3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void M3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        Context Q1 = myFavListActivity.Q1();
        t9.i.e(Q1, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((f5.c) Q1, EmailAty.class);
    }

    public static final void N3(MyFavListActivity myFavListActivity, View view) {
        boolean z10;
        t9.i.g(myFavListActivity, "this$0");
        int i10 = R$id.mEditPassword;
        Editable text = ((EditText) myFavListActivity.t3(i10)).getText();
        if (text == null || text.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            String obj = ba.t.W(((EditText) myFavListActivity.t3(i10)).getText().toString()).toString();
            if (!j1.f(obj)) {
                int i11 = R$id.mTextErrorNotify;
                ((TextView) myFavListActivity.t3(i11)).setVisibility(0);
                Context Q1 = myFavListActivity.Q1();
                t9.i.d(Q1);
                ((TextView) myFavListActivity.t3(i11)).setText(Q1.getResources().getString(R.string.password_format_incorrect));
                return;
            }
            myFavListActivity.S2().k(obj);
        }
    }

    public static final void O3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        i.c cVar = w6.i.f9510g;
        if (!t9.i.b(cVar.c(), "1") || t9.i.b(cVar.h(), "1") || t9.i.b(cVar.j(), "1")) {
            Intent intent = new Intent(myFavListActivity.Q1(), ResetAty.class);
            if (t9.i.b(cVar.h(), "1")) {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 2);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", false);
            } else if (t9.i.b(cVar.j(), "1")) {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 1);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", false);
            } else {
                intent.putExtra("need_x_button", false);
                intent.putExtra("bind_from", 2);
                intent.putExtra("bind_Type", "3");
                intent.putExtra("is_edit_editable", true);
            }
            myFavListActivity.startActivity(intent);
            return;
        }
        f1.f12517a.w(R.string.mine_please_bind);
    }

    public static final void Q3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.c4();
    }

    public static final void R3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.c4();
    }

    public static final void S3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        if (b0.I(myFavListActivity.F3().getData())) {
            boolean z10 = !myFavListActivity.f5954p;
            myFavListActivity.f5954p = z10;
            if (z10) {
                myFavListActivity.f5955q = myFavListActivity.F3().getData().size();
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_select);
                int i10 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i10)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_important));
                ((Button) myFavListActivity.t3(i10)).setClickable(true);
            } else {
                int i11 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i11)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_666666));
                ((Button) myFavListActivity.t3(i11)).setClickable(false);
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
                myFavListActivity.f5955q = 0;
            }
            for (Favorite select : myFavListActivity.F3().getData()) {
                select.setSelect(myFavListActivity.f5954p);
            }
            myFavListActivity.F3().notifyDataSetChanged();
        }
    }

    public static final void T3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        if (myFavListActivity.f5954p) {
            new DeleteConfirmDialog(myFavListActivity, R.string.my_fav_whether_delete_all, myFavListActivity).show();
        } else {
            myFavListActivity.x3();
        }
    }

    public static final void U3(MyFavListActivity myFavListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        String str;
        MyFavListActivity myFavListActivity2 = myFavListActivity;
        int i11 = i10;
        t9.i.g(myFavListActivity, "this$0");
        BaseQuickAdapter baseQuickAdapter2 = baseQuickAdapter;
        View viewByPosition = baseQuickAdapter.getViewByPosition((RecyclerView) myFavListActivity.t3(R$id.mRecyclerFav), i11, R.id.itemCheckbox);
        t9.i.e(viewByPosition, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) viewByPosition;
        if (myFavListActivity2.f5953o) {
            if (((Favorite) myFavListActivity.F3().getData().get(i11)).isSelect()) {
                ((Favorite) myFavListActivity.F3().getData().get(i11)).setSelect(false);
                imageView.setImageResource(R.drawable.icon_no_select);
                myFavListActivity2.f5955q--;
            } else {
                myFavListActivity2.f5955q++;
                ((Favorite) myFavListActivity.F3().getData().get(i11)).setSelect(true);
                imageView.setImageResource(R.drawable.icon_select);
            }
            if (myFavListActivity2.f5955q == myFavListActivity.F3().getData().size()) {
                myFavListActivity2.f5954p = true;
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_select);
            } else {
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
                myFavListActivity2.f5954p = false;
            }
            if (myFavListActivity2.f5955q == 0) {
                int i12 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i12)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_666666));
                ((Button) myFavListActivity.t3(i12)).setClickable(false);
            } else {
                int i13 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i13)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_important));
                ((Button) myFavListActivity.t3(i13)).setClickable(true);
            }
        } else {
            a7.d dVar = a7.d.f10697a;
            String o10 = dVar.o(((Favorite) myFavListActivity.F3().getData().get(i11)).getPosterList(), dVar.g());
            if (o10 == null) {
                o10 = "";
            }
            String str2 = o10;
            String type = ((Favorite) myFavListActivity.F3().getData().get(i11)).getType();
            String contentId = ((Favorite) myFavListActivity.F3().getData().get(i11)).getContentId();
            EnterType enterType = EnterType.CATEGORY;
            String alias = ((Favorite) myFavListActivity.F3().getData().get(i11)).getAlias();
            String str3 = null;
            if (alias != null) {
                str = ba.t.W(alias).toString();
            } else {
                str = null;
            }
            String name = ((Favorite) myFavListActivity.F3().getData().get(i11)).getName();
            if (name != null) {
                str3 = ba.t.W(name).toString();
            }
            b0.t(myFavListActivity, type, "", contentId, enterType, b0.c(str, str3), false, false, 0, "fav", str2, 192, (Object) null);
        }
        myFavListActivity.F3().notifyDataSetChanged();
    }

    public static final void V3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.p4(false);
    }

    public static final void W3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.p4(true);
    }

    public static final void X3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.finish();
    }

    public static final boolean d4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ArrayList e4() {
        return new ArrayList();
    }

    public static final void f4(p pVar, Object obj, Object obj2) {
        t9.i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final void g4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final t i4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (t) lVar.invoke(obj);
    }

    public static final void j4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean y3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final Integer z3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (Integer) lVar.invoke(obj);
    }

    public final d1 F3() {
        return (d1) this.f5952n.getValue();
    }

    /* renamed from: G3 */
    public g1 S2() {
        g1 g1Var = this.f5951m;
        if (g1Var != null) {
            return g1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public void H0(List list, boolean z10) {
        t9.i.g(list, "favoriteList");
        if (this.f5950l == z10) {
            LoadingDialog.Companion.hidden();
            ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(0);
            F3().setNewData(list);
            K3();
            if (this.f5953o) {
                ((TitleView) t3(R$id.myFavTitleView)).getTvMenuView().setVisibility(0);
            } else {
                ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(0);
            }
            if (this.f5954p) {
                int i10 = R$id.btnDelete;
                ((Button) t3(i10)).setBackgroundColor(getResources().getColor(R.color.color_666666));
                ((Button) t3(i10)).setClickable(false);
                ((ImageView) t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
                this.f5955q = 0;
            }
        }
    }

    public final boolean H3() {
        return this.f5954p;
    }

    public void I() {
        MainAty.A.o(false);
        xa.c.c().j(new CheckPwdSuccessEvent());
    }

    public final void I3() {
        t3(R$id.mIncludeBindNotification).setVisibility(8);
    }

    public final void J3() {
        t3(R$id.mIncludePassword).setVisibility(8);
        ((EditText) t3(R$id.mEditPassword)).getText().clear();
        ((TextView) t3(R$id.mTextErrorNotify)).setVisibility(8);
    }

    public final void K3() {
        ((KoocanEmptyView) t3(R$id.mMyFavLoadingView)).setVisibility(8);
        int i10 = R$id.mMyFavRefreshLayout;
        if (((SwipeRefreshLayout) t3(i10)) != null && ((SwipeRefreshLayout) t3(i10)).isRefreshing()) {
            ((SwipeRefreshLayout) t3(i10)).setRefreshing(false);
        }
    }

    public final void L3() {
        ((TextView) t3(R$id.mTvGotoBind)).setOnClickListener(new q1(this));
        ((TextView) t3(R$id.mTextConfirm)).setOnClickListener(new r1(this));
        ((TextView) t3(R$id.mTextForgetPassword)).setOnClickListener(new s1(this));
    }

    public final void P3() {
        ((TextView) t3(R$id.mTvTabNormal)).setOnClickListener(new g2(this));
        ((TextView) t3(R$id.mTvTabCR)).setOnClickListener(new h2(this));
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setOnRefreshListener(this);
        int i10 = R$id.myFavTitleView;
        ((TitleView) t3(i10)).setOnBackClickListener(new i2(this));
        ((TitleView) t3(i10)).setIvMenuClickListener(new j2(this));
        ((TitleView) t3(i10)).setTvMenuClickListener(new m1(this));
        ((AutoLinearLayout) t3(R$id.selectAllLayout)).setOnClickListener(new n1(this));
        ((Button) t3(R$id.btnDelete)).setOnClickListener(new o1(this));
        F3().setOnItemClickListener(new p1(this));
    }

    public void R2() {
        l4(new g1(this, this));
        a4();
        Z3();
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setColorSchemeResources(R.color.color_important);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        int i10 = R$id.mRecyclerFav;
        ((RecyclerView) t3(i10)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) t3(i10)).addItemDecoration(new VerticalItemDecoration(Q1(), 0, AutoUtils.getPercentHeightSize(24)));
        ((RecyclerView) t3(i10)).setAdapter(F3());
        P3();
        L3();
        Y3();
    }

    public int T2() {
        return R.layout.activity_my_fav_list;
    }

    public final void Y3() {
        ((KoocanEmptyView) t3(R$id.mMyFavLoadingView)).setTextImageMarginTop(AutoUtils.getPercentHeightSize(186));
    }

    public final void Z3() {
        if (t9.i.b(w6.i.f9510g.A(), "1")) {
            ((AutoLinearLayout) t3(R$id.mLlTab)).setVisibility(0);
            ((TextView) t3(R$id.mTvTabNormal)).setSelected(true);
            return;
        }
        ((AutoLinearLayout) t3(R$id.mLlTab)).setVisibility(8);
    }

    public void a0(boolean z10) {
        if (this.f5950l == z10) {
            LoadingDialog.Companion.hidden();
            int i10 = R$id.mMyFavRefreshLayout;
            ((SwipeRefreshLayout) t3(i10)).setVisibility(0);
            ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(8);
            int i11 = R$id.mMyFavLoadingView;
            ((KoocanEmptyView) t3(i11)).setVisibility(0);
            if (((SwipeRefreshLayout) t3(i10)) != null && ((SwipeRefreshLayout) t3(i10)).isRefreshing()) {
                ((SwipeRefreshLayout) t3(i10)).setRefreshing(false);
            }
            ((KoocanEmptyView) t3(i11)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            String string = getResources().getString(R.string.no_collect_favorite);
            t9.i.f(string, "resources.getString(R.string.no_collect_favorite)");
            ((KoocanEmptyView) t3(i11)).setTip(string);
            ((KoocanEmptyView) t3(i11)).setBackgroundDrawable(R.drawable.my_fave_empty);
        }
    }

    public final void a4() {
        int i10 = R$id.myFavTitleView;
        ((TitleView) t3(i10)).getSettingView().setVisibility(8);
        ((TitleView) t3(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) t3(i10)).setIvMenuSrc(R.drawable.icon_delete_history);
        ((TitleView) t3(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) t3(i10)).setTvMenuText(b0.A(this, R.string.cancel));
    }

    public final void b4() {
        d6.b bVar = d6.b.f6366a;
        if (!bVar.a() || (bVar.c() && !bVar.b() && !bVar.d())) {
            m4();
        } else {
            o4();
        }
    }

    public final void c4() {
        this.f5953o = !this.f5953o;
        Observable.fromIterable(F3().getData()).filter(new t1(h.f12057a)).collect(new u1(), new v1(i.f12058a)).compose(O1()).subscribe(new x1(new j(this)), new y1(k.f12060a));
        if (!this.f5953o || F3().getData().size() == 0) {
            int i10 = R$id.myFavTitleView;
            ((TitleView) t3(i10)).getIvMenuView().setVisibility(0);
            ((TitleView) t3(i10)).getTvMenuView().setVisibility(8);
            ((AutoRelativeLayout) t3(R$id.mMyFavBottomLayout)).setVisibility(8);
            ((ImageView) t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
            this.f5955q = 0;
            this.f5954p = false;
            Observable.fromIterable(F3().getData()).map(new z1(l.f12061a)).compose(O1()).compose(p0.a()).subscribe(new a2(new m(this)));
        } else {
            int i11 = R$id.myFavTitleView;
            ((TitleView) t3(i11)).getIvMenuView().setVisibility(8);
            ((TitleView) t3(i11)).getTvMenuView().setVisibility(0);
            ((AutoRelativeLayout) t3(R$id.mMyFavBottomLayout)).setVisibility(0);
        }
        F3().g(this.f5953o);
        F3().notifyDataSetChanged();
    }

    @xa.j
    public final void checkPwdSuccess(CheckPwdSuccessEvent checkPwdSuccessEvent) {
        t9.i.g(checkPwdSuccessEvent, "event");
        if (this.f5950l) {
            n4(true);
        }
    }

    public void e1(String str, boolean z10) {
        t9.i.g(str, "returnCode");
        if (this.f5950l == z10) {
            LoadingDialog.Companion.hidden();
            ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(0);
            ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(8);
            int i10 = R$id.mMyFavLoadingView;
            ((KoocanEmptyView) t3(i10)).changeType(KoocanEmptyView.Type.NO_DISCUSS);
            ((KoocanEmptyView) t3(i10)).setVisibility(0);
            String string = getResources().getString(R.string.fav_record_failde);
            t9.i.f(string, "resources.getString(R.string.fav_record_failde)");
            ((KoocanEmptyView) t3(i10)).setTip(string);
        }
    }

    public void k2() {
        n2();
    }

    public final void k4(int i10) {
        this.f5955q = i10;
    }

    public void l4(g1 g1Var) {
        t9.i.g(g1Var, "<set-?>");
        this.f5951m = g1Var;
    }

    public final void m4() {
        t3(R$id.mIncludeBindNotification).setVisibility(0);
        t3(R$id.mIncludePassword).setVisibility(8);
        ((ImageView) t3(R$id.mIvClose)).setVisibility(4);
    }

    public final void n4(boolean z10) {
        List list;
        LoadingDialog.Companion.show(getFragmentManager());
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(8);
        K3();
        I3();
        J3();
        if (z10) {
            list = S2().m();
        } else {
            list = S2().n();
        }
        if (list == null) {
            S2().d(z10);
        } else if (list.isEmpty()) {
            a0(z10);
        } else {
            H0(list, z10);
        }
    }

    public final void o4() {
        ((EditText) t3(R$id.mEditPassword)).getText().clear();
        ((TextView) t3(R$id.mTextErrorNotify)).setVisibility(8);
        t3(R$id.mIncludeBindNotification).setVisibility(8);
        t3(R$id.mIncludePassword).setVisibility(0);
        ((ImageView) t3(R$id.mImageClose)).setVisibility(4);
    }

    public void onConfirm() {
        x3();
    }

    public void onRefresh() {
        S2().d(this.f5950l);
    }

    public final void p4(boolean z10) {
        if (!this.f5953o) {
            if (!z10) {
                int i10 = R$id.mTvTabNormal;
                if (!((TextView) t3(i10)).isSelected()) {
                    ((TextView) t3(i10)).setSelected(true);
                    ((TextView) t3(R$id.mTvTabCR)).setSelected(false);
                    this.f5950l = false;
                } else {
                    return;
                }
            } else {
                int i11 = R$id.mTvTabCR;
                if (!((TextView) t3(i11)).isSelected()) {
                    ((TextView) t3(i11)).setSelected(true);
                    ((TextView) t3(R$id.mTvTabNormal)).setSelected(false);
                    this.f5950l = true;
                    if (MainAty.A.f()) {
                        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(8);
                        K3();
                        ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(8);
                        b4();
                        return;
                    }
                } else {
                    return;
                }
            }
            n4(z10);
        }
    }

    public View t3(int i10) {
        Map map = this.f5956r;
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

    public final void x3() {
        Observable.fromIterable(F3().getData()).filter(new l1(new a(this))).map(new w1(b.f12049a)).collect(new c2(), new d2(c.f12050a)).filter(new e2(d.f12051a)).flatMapObservable(new f2(this)).compose(O1()).subscribe(new f(this));
    }

    public void y(boolean z10) {
        if (z10) {
            LoadingDialog.Companion.show(getFragmentManager());
        } else {
            LoadingDialog.Companion.hidden();
        }
    }
}
