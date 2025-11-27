package f5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.activity.ExperienceCastPlayAty;
import g7.d;
import n6.b;

public final /* synthetic */ class s0 implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExperienceCastPlayAty f16673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f16674b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f16675c;

    public /* synthetic */ s0(ExperienceCastPlayAty experienceCastPlayAty, b bVar, d dVar) {
        this.f16673a = experienceCastPlayAty;
        this.f16674b = bVar;
        this.f16675c = dVar;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        ExperienceCastPlayAty.l3(this.f16673a, this.f16674b, this.f16675c, baseQuickAdapter, view, i10);
    }
}
