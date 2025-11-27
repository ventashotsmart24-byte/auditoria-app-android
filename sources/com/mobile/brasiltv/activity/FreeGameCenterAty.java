package com.mobile.brasiltv.activity;

import a6.a;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f;
import com.mobile.brasiltv.view.BottomDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import d6.b;
import f5.c;
import g5.d0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s1.m;
import s1.q;
import t9.i;

public final class FreeGameCenterAty extends c {

    /* renamed from: k  reason: collision with root package name */
    public d0 f12012k;

    /* renamed from: l  reason: collision with root package name */
    public long f12013l;

    /* renamed from: m  reason: collision with root package name */
    public Map f12014m = new LinkedHashMap();

    public View R2(int i10) {
        Map map = this.f12014m;
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

    public void k2() {
        n2();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_free_game_center);
        this.f12013l = SystemClock.elapsedRealtime();
        int i10 = R$id.mRvGame;
        ((RecyclerView) R2(i10)).setLayoutManager(new LinearLayoutManager(Q1(), 1, false));
        ((RecyclerView) R2(i10)).addItemDecoration(new BottomDecoration(AutoUtils.getPercentHeightSize(10)));
        List z10 = m.f9270a.z(a.f10646a.e());
        if (z10 != null) {
            this.f12012k = new d0(this, z10);
            f.f12516a.c();
        }
        ((RecyclerView) R2(i10)).setAdapter(this.f12012k);
        d0 d0Var = this.f12012k;
        if (d0Var != null) {
            d0Var.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        long j10;
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f12013l;
        if (elapsedRealtime < 1000) {
            j10 = 1;
        } else {
            j10 = elapsedRealtime / ((long) 1000);
        }
        q qVar = q.f9311a;
        Context applicationContext = getApplicationContext();
        i.f(applicationContext, "applicationContext");
        String e10 = a.f10646a.e();
        b bVar = b.f6366a;
        Context applicationContext2 = getApplicationContext();
        i.f(applicationContext2, "applicationContext");
        qVar.i(applicationContext, e10, bVar.m(applicationContext2), j10);
        super.onDestroy();
    }
}
