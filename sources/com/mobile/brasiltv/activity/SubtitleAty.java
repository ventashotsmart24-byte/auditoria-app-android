package com.mobile.brasiltv.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.view.dialog.SubtitleOptionsDialog;
import com.mobile.brasiltv.view.dialog.SubtitleStyleOptionsDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import f5.p5;
import f5.q5;
import f5.r5;
import f5.s5;
import f5.t5;
import f5.u5;
import f5.v5;
import f5.w5;
import f5.x5;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;
import t9.j;

public final class SubtitleAty extends f5.c {

    /* renamed from: k  reason: collision with root package name */
    public final g f12222k = h.b(new a(this));

    /* renamed from: l  reason: collision with root package name */
    public final g f12223l = h.b(new c(this));

    /* renamed from: m  reason: collision with root package name */
    public final g f12224m = h.b(new d(this));

    /* renamed from: n  reason: collision with root package name */
    public final g f12225n = h.b(new b(this));

    /* renamed from: o  reason: collision with root package name */
    public final g f12226o = h.b(new e(this));

    /* renamed from: p  reason: collision with root package name */
    public Map f12227p = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubtitleAty f12228a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SubtitleAty subtitleAty) {
            super(0);
            this.f12228a = subtitleAty;
        }

        /* renamed from: b */
        public final String[] invoke() {
            return new String[]{this.f12228a.getResources().getString(R.string.subtitle_language_pt), this.f12228a.getResources().getString(R.string.subtitle_language_en), this.f12228a.getResources().getString(R.string.subtitle_language_es)};
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubtitleAty f12229a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SubtitleAty subtitleAty) {
            super(0);
            this.f12229a = subtitleAty;
        }

        /* renamed from: b */
        public final String[] invoke() {
            return new String[]{this.f12229a.getResources().getString(R.string.subtitle_color_white), this.f12229a.getResources().getString(R.string.subtitle_color_yellow)};
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubtitleAty f12230a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SubtitleAty subtitleAty) {
            super(0);
            this.f12230a = subtitleAty;
        }

        /* renamed from: b */
        public final String[] invoke() {
            return new String[]{this.f12230a.getResources().getString(R.string.subtitle_language_pt), this.f12230a.getResources().getString(R.string.subtitle_language_en), this.f12230a.getResources().getString(R.string.subtitle_language_es)};
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubtitleAty f12231a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(SubtitleAty subtitleAty) {
            super(0);
            this.f12231a = subtitleAty;
        }

        /* renamed from: b */
        public final String[] invoke() {
            return new String[]{this.f12231a.getResources().getString(R.string.subtitle_size_normal), this.f12231a.getResources().getString(R.string.subtitle_size_small), this.f12231a.getResources().getString(R.string.subtitle_size_big)};
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SubtitleAty f12232a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SubtitleAty subtitleAty) {
            super(0);
            this.f12232a = subtitleAty;
        }

        /* renamed from: b */
        public final ArrayList invoke() {
            return SubtitleManager.INSTANCE.getStyleList(this.f12232a);
        }
    }

    public static final void g3(SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.audio_language);
        i.f(string, "resources.getString(R.string.audio_language)");
        SubtitleOptionsDialog subtitleOptionsDialog = new SubtitleOptionsDialog(subtitleAty, string, subtitleAty.b3(), SubtitleManager.GLOBAL_AUDIO_LANGUAGE, 0, 16, (t9.g) null);
        subtitleOptionsDialog.show();
        subtitleOptionsDialog.setOnCancelListener(new x5(subtitleAty));
    }

    public static final void h3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        subtitleAty.q3();
    }

    public static final void i3(SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.subtitle_language);
        i.f(string, "resources.getString(R.string.subtitle_language)");
        SubtitleOptionsDialog subtitleOptionsDialog = new SubtitleOptionsDialog(subtitleAty, string, subtitleAty.c3(), SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, 0, 16, (t9.g) null);
        subtitleOptionsDialog.show();
        subtitleOptionsDialog.setOnCancelListener(new v5(subtitleAty));
    }

    public static final void j3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        subtitleManager.clearLruCacheSwitch();
        subtitleManager.clearSelectSubtitle();
        subtitleAty.q3();
    }

    public static final void k3(SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.subtitle_size);
        i.f(string, "resources.getString(R.string.subtitle_size)");
        SubtitleOptionsDialog subtitleOptionsDialog = new SubtitleOptionsDialog(subtitleAty, string, subtitleAty.d3(), SubtitleManager.GLOBAL_SUBTITLE_SIZE, 0, 16, (t9.g) null);
        subtitleOptionsDialog.show();
        subtitleOptionsDialog.setOnCancelListener(new u5(subtitleAty));
    }

    public static final void l3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        subtitleAty.q3();
    }

    public static final void m3(SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        String string = subtitleAty.getResources().getString(R.string.subtitle_Style);
        i.f(string, "resources.getString(R.string.subtitle_Style)");
        SubtitleStyleOptionsDialog subtitleStyleOptionsDialog = new SubtitleStyleOptionsDialog(subtitleAty, string, subtitleAty.e3(), SubtitleManager.GLOBAL_SUBTITLE_COLOR, 0, 16, (t9.g) null);
        subtitleStyleOptionsDialog.show();
        subtitleStyleOptionsDialog.setOnCancelListener(new w5(subtitleAty));
    }

    public static final void n3(SubtitleAty subtitleAty, DialogInterface dialogInterface) {
        i.g(subtitleAty, "this$0");
        subtitleAty.q3();
    }

    public static final void o3(SubtitleAty subtitleAty, View view) {
        i.g(subtitleAty, "this$0");
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        subtitleManager.setMGlobalSwitch(!subtitleManager.getMGlobalSwitch());
        ((ImageView) subtitleAty.a3(R$id.mIvSwitch)).setSelected(subtitleManager.getMGlobalSwitch());
        subtitleManager.clearSelectSubtitle();
        subtitleManager.clearLruCacheSwitch();
        subtitleAty.p3(subtitleManager.getMGlobalSwitch());
    }

    public View a3(int i10) {
        Map map = this.f12227p;
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

    public final String[] b3() {
        return (String[]) this.f12222k.getValue();
    }

    public final String[] c3() {
        return (String[]) this.f12223l.getValue();
    }

    public final String[] d3() {
        return (String[]) this.f12224m.getValue();
    }

    public final ArrayList e3() {
        return (ArrayList) this.f12226o.getValue();
    }

    public final void f3() {
        q3();
        ((AutoFrameLayout) a3(R$id.mFlAudioLanguage)).setOnClickListener(new p5(this));
        ((AutoFrameLayout) a3(R$id.mFlLanguage)).setOnClickListener(new q5(this));
        ((AutoFrameLayout) a3(R$id.mFlSize)).setOnClickListener(new r5(this));
        ((AutoFrameLayout) a3(R$id.mFlColor)).setOnClickListener(new s5(this));
        ((ImageView) a3(R$id.mIvSwitch)).setOnClickListener(new t5(this));
    }

    public void k2() {
        n2();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_subtitle);
        f3();
    }

    public void onStop() {
        super.onStop();
        n0 n0Var = n0.f12601a;
        String[] strArr = {SubtitleManager.GLOBAL_AUDIO_LANGUAGE, SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE, SubtitleManager.GLOBAL_SUBTITLE_SIZE, SubtitleManager.GLOBAL_SUBTITLE_COLOR, SubtitleManager.GLOBAL_SUBTITLE_SWITCH};
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        n0Var.l(this, strArr, new Object[]{Integer.valueOf(subtitleManager.getMGlobalAudioLanguage()), Integer.valueOf(subtitleManager.getMGlobalLanguage()), Integer.valueOf(subtitleManager.getMGlobalSize()), Integer.valueOf(subtitleManager.getMGlobalColor()), Boolean.valueOf(subtitleManager.getMGlobalSwitch())});
    }

    public final void p3(boolean z10) {
        ((AutoFrameLayout) a3(R$id.mFlLanguage)).setEnabled(z10);
        ((AutoFrameLayout) a3(R$id.mFlColor)).setEnabled(z10);
        ((AutoFrameLayout) a3(R$id.mFlSize)).setEnabled(z10);
    }

    public final void q3() {
        String str;
        String str2;
        String str3;
        int i10;
        int i11;
        TextView textView = (TextView) a3(R$id.mTvSelectedAudioLanguage);
        SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
        int mGlobalAudioLanguage = subtitleManager.getMGlobalAudioLanguage();
        if (mGlobalAudioLanguage == 0) {
            str = getResources().getString(R.string.subtitle_language_pt);
        } else if (mGlobalAudioLanguage == 1) {
            str = getResources().getString(R.string.subtitle_language_en);
        } else if (mGlobalAudioLanguage != 2) {
            str = getResources().getString(R.string.subtitle_language_pt);
        } else {
            str = getResources().getString(R.string.subtitle_language_es);
        }
        textView.setText(str);
        TextView textView2 = (TextView) a3(R$id.mTvSelectedLanguage);
        int mGlobalLanguage = subtitleManager.getMGlobalLanguage();
        if (mGlobalLanguage == 0) {
            str2 = getResources().getString(R.string.subtitle_language_pt);
        } else if (mGlobalLanguage == 1) {
            str2 = getResources().getString(R.string.subtitle_language_en);
        } else if (mGlobalLanguage != 2) {
            str2 = getResources().getString(R.string.subtitle_language_es);
        } else {
            str2 = getResources().getString(R.string.subtitle_language_es);
        }
        textView2.setText(str2);
        TextView textView3 = (TextView) a3(R$id.mTvSelectedSize);
        int mGlobalSize = subtitleManager.getMGlobalSize();
        if (mGlobalSize == 0) {
            str3 = getResources().getString(R.string.subtitle_size_normal);
        } else if (mGlobalSize == 1) {
            str3 = getResources().getString(R.string.subtitle_size_small);
        } else if (mGlobalSize != 2) {
            str3 = getResources().getString(R.string.subtitle_size_normal);
        } else {
            str3 = getResources().getString(R.string.subtitle_size_big);
        }
        textView3.setText(str3);
        TextView textView4 = (TextView) a3(R$id.mTvSelectedColor);
        int mGlobalColor = subtitleManager.getMGlobalColor();
        if (mGlobalColor == 0) {
            i10 = getResources().getColor(R.color.color_important_white);
        } else if (mGlobalColor == 1) {
            i10 = getResources().getColor(R.color.color_ffaa00);
        } else if (mGlobalColor != 2) {
            i10 = getResources().getColor(R.color.color_important_white);
        } else {
            i10 = getResources().getColor(R.color.color_important_white);
        }
        textView4.setTextColor(i10);
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) a3(R$id.mLlBg);
        int mGlobalColor2 = subtitleManager.getMGlobalColor();
        if (mGlobalColor2 == 0) {
            i11 = getResources().getColor(R.color.transparent);
        } else if (mGlobalColor2 == 1) {
            i11 = getResources().getColor(R.color.transparent);
        } else if (mGlobalColor2 != 2) {
            i11 = getResources().getColor(R.color.transparent);
        } else {
            i11 = getResources().getColor(R.color.color_191919);
        }
        autoLinearLayout.setBackgroundColor(i11);
        ((ImageView) a3(R$id.mIvSwitch)).setSelected(subtitleManager.getMGlobalSwitch());
        p3(subtitleManager.getMGlobalSwitch());
    }
}
