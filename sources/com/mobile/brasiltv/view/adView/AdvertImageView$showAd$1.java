package com.mobile.brasiltv.view.adView;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import com.umeng.analytics.pro.f;
import d6.b;
import h9.t;
import s1.q;
import s9.l;
import s9.p;
import t9.i;
import t9.j;

public final class AdvertImageView$showAd$1 extends j implements l {
    final /* synthetic */ AdvertImageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertImageView$showAd$1(AdvertImageView advertImageView) {
        super(1);
        this.this$0 = advertImageView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return t.f17319a;
    }

    public final void invoke(boolean z10) {
        p access$getMShowAdListener$p = this.this$0.mShowAdListener;
        if (access$getMShowAdListener$p != null) {
            access$getMShowAdListener$p.invoke(this.this$0.mAdInfo, Boolean.valueOf(z10));
        }
        if (z10) {
            q qVar = q.f9311a;
            Context context = this.this$0.getContext();
            i.f(context, f.X);
            b bVar = b.f6366a;
            Context context2 = this.this$0.getContext();
            i.f(context2, f.X);
            String m10 = bVar.m(context2);
            String access$getMAdType$p = this.this$0.mAdType;
            if (access$getMAdType$p == null) {
                access$getMAdType$p = "";
            }
            AdInfo access$getMAdInfo$p = this.this$0.mAdInfo;
            i.d(access$getMAdInfo$p);
            qVar.j(context, m10, access$getMAdType$p, access$getMAdInfo$p);
        }
    }
}
