package com.mobile.brasiltv.activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CastToPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.g;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.msandroid.mobile.R;
import com.titan.cast.bean.Device;
import f5.c;
import f5.k;
import f5.m;
import f5.n;
import f5.o;
import f5.p;
import f5.q;
import g5.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s9.l;
import t9.i;
import t9.j;
import t9.z;
import w6.i;

public final class CastByNativeDeviceAty extends c implements g.a {

    /* renamed from: k  reason: collision with root package name */
    public String f11969k = "";

    /* renamed from: l  reason: collision with root package name */
    public t f11970l = new t(this, new ArrayList());

    /* renamed from: m  reason: collision with root package name */
    public Map f11971m = new LinkedHashMap();

    public static final class a implements t.a {
        public void a(Device device, int i10) {
            i.g(device, "serviceInfo");
            g.f12519a.t(device);
            h.f12562a.x(true);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CastByNativeDeviceAty f11972a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CastByNativeDeviceAty castByNativeDeviceAty) {
            super(1);
            this.f11972a = castByNativeDeviceAty;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            z zVar = z.f19601a;
            String string = this.f11972a.Q1().getString(R.string.cast_dlna_trial);
            i.f(string, "context.getString(R.string.cast_dlna_trial)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            i.f(format, "format(format, *args)");
            ((TextView) this.f11972a.Z2(R$id.mTvSearchDeviceTips)).setText(format);
        }
    }

    public static final void a3(CastByNativeDeviceAty castByNativeDeviceAty) {
        i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.o3();
    }

    public static final void b3(CastByNativeDeviceAty castByNativeDeviceAty) {
        i.g(castByNativeDeviceAty, "this$0");
        int i10 = R$id.mTvErrorHint;
        ((TextView) castByNativeDeviceAty.Z2(i10)).setVisibility(0);
        ((TextView) castByNativeDeviceAty.Z2(i10)).setText(castByNativeDeviceAty.getString(R.string.cast_connection_failed));
    }

    public static final void c3(CastByNativeDeviceAty castByNativeDeviceAty, List list) {
        i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.l3(list);
    }

    public static final void e3(CastByNativeDeviceAty castByNativeDeviceAty, View view) {
        i.g(castByNativeDeviceAty, "this$0");
        Context Q1 = castByNativeDeviceAty.Q1();
        StringBuilder sb = new StringBuilder();
        sb.append(b0.x(m7.c.g()));
        sb.append("/#/app-help?isFree=false&appId=");
        sb.append(na.a.g());
        sb.append("&userId=");
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.H());
        sb.append("&lang=");
        sb.append(f0.a());
        sb.append("&appVersion=");
        sb.append(na.a.b());
        sb.append("&timestamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar.v());
        b0.j0(Q1, sb.toString(), false, true, false, false, 24, (Object) null);
    }

    public static final void g3(CastByNativeDeviceAty castByNativeDeviceAty, View view) {
        t9.i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.finish();
    }

    public static final void h3(View view) {
    }

    public static final void j3(CastByNativeDeviceAty castByNativeDeviceAty) {
        t9.i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.o3();
    }

    public static final void k3(CastByNativeDeviceAty castByNativeDeviceAty) {
        t9.i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.n3();
    }

    public void G0(boolean z10) {
        if (z10) {
            h hVar = h.f12562a;
            hVar.w(hVar.k());
            if (t9.i.b(this.f11969k, "LIVE") || t9.i.b(this.f11969k, "VOD")) {
                xa.c.c().j(new CastToPlayEvent(this.f11969k));
            }
            runOnUiThread(new p(this));
            finish();
            return;
        }
        runOnUiThread(new q(this));
    }

    public View Z2(int i10) {
        Map map = this.f11971m;
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

    public void d1(List list) {
        if (list != null) {
            runOnUiThread(new f5.l(this, list));
        }
    }

    public final void d3() {
        this.f11970l.f(new a());
        ((TextView) Z2(R$id.mTvHelp)).setOnClickListener(new o(this));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        t9.i.g(motionEvent, "ev");
        int i10 = R$id.mTvErrorHint;
        if (((TextView) Z2(i10)).getVisibility() != 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        ((TextView) Z2(i10)).setVisibility(8);
        return true;
    }

    public final void f3() {
        int i10 = R$id.title_view;
        ((TitleView) Z2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) Z2(i10)).setAtyBackVisible(8);
        ((TitleView) Z2(i10)).setXVisible(0);
        ((TitleView) Z2(i10)).getSettingView().setVisibility(8);
        ((TitleView) Z2(i10)).getIvMenuView().setVisibility(0);
        ((TitleView) Z2(i10)).setIvMenuSrc(R.drawable.anim_cast_refresh);
        ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
        x.f12622a.w(Q1(), new b(this));
        ((TitleView) Z2(i10)).setXClickListener(new f5.j(this));
        ((TitleView) Z2(i10)).setIvMenuClickListener(new k());
    }

    public final void i3() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        int i10 = R$id.mRvDevice;
        ((RecyclerView) Z2(i10)).setLayoutManager(linearLayoutManager);
        ((RecyclerView) Z2(i10)).setAdapter(this.f11970l);
        ((RecyclerView) Z2(i10)).addItemDecoration(new VerticalItemDecoration(this, 0, 65));
        ((RecyclerView) Z2(i10)).setScrollbarFadingEnabled(false);
    }

    public void k2() {
        n2();
    }

    public final void l3(List list) {
        ((RecyclerView) Z2(R$id.mRvDevice)).setVisibility(0);
        int i10 = R$id.mTvNotFoundDLNA;
        ((TextView) Z2(i10)).setVisibility(8);
        ((TextView) Z2(i10)).setOnClickListener((View.OnClickListener) null);
        this.f11970l.b(list);
    }

    public final void m3() {
        g.f12519a.F();
    }

    public final void n3() {
        Drawable drawable = ((TitleView) Z2(R$id.title_view)).getIvMenuView().getDrawable();
        t9.i.e(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) drawable).start();
    }

    public final void o3() {
        Drawable drawable = ((TitleView) Z2(R$id.title_view)).getIvMenuView().getDrawable();
        t9.i.e(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) drawable).stop();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_cast_device);
        String stringExtra = getIntent().getStringExtra("from_type");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f11969k = stringExtra;
        f3();
        i3();
        d3();
        h.f12562a.x(false);
        g.f12519a.i();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        runOnUiThread(new m(this));
        g gVar = g.f12519a;
        gVar.H();
        gVar.v((g.a) null);
    }

    public void onResume() {
        super.onResume();
        runOnUiThread(new n(this));
        m3();
        g.f12519a.v(this);
    }
}
