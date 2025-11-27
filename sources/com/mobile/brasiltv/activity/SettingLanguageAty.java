package com.mobile.brasiltv.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.LanguageChangeEvent;
import com.mobile.brasiltv.utils.b;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.view.VideoLoadingDialog;
import com.msandroid.mobile.R;
import f5.c;
import f5.s4;
import h9.g;
import h9.h;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;
import t9.j;

public final class SettingLanguageAty extends c {

    /* renamed from: k  reason: collision with root package name */
    public final g f12176k = h.b(new a(this));

    /* renamed from: l  reason: collision with root package name */
    public Map f12177l = new LinkedHashMap();

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SettingLanguageAty f12178a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SettingLanguageAty settingLanguageAty) {
            super(0);
            this.f12178a = settingLanguageAty;
        }

        /* renamed from: b */
        public final VideoLoadingDialog invoke() {
            return new VideoLoadingDialog(this.f12178a);
        }
    }

    public static final void U2(SettingLanguageAty settingLanguageAty, Drawable drawable, RadioGroup radioGroup, int i10) {
        i.g(settingLanguageAty, "this$0");
        int i11 = R$id.rbEN;
        ((RadioButton) settingLanguageAty.S2(i11)).setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        int i12 = R$id.rbPT;
        ((RadioButton) settingLanguageAty.S2(i12)).setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        int i13 = R$id.rbES;
        ((RadioButton) settingLanguageAty.S2(i13)).setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        if (i10 == ((RadioButton) settingLanguageAty.S2(i12)).getId()) {
            settingLanguageAty.T2("pt");
            ((RadioButton) settingLanguageAty.S2(i12)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else if (i10 == ((RadioButton) settingLanguageAty.S2(i11)).getId()) {
            settingLanguageAty.T2(XML.DEFAULT_CONTENT_LANGUAGE);
            ((RadioButton) settingLanguageAty.S2(i11)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            settingLanguageAty.T2("es");
            ((RadioButton) settingLanguageAty.S2(i13)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        xa.c.c().j(new LanguageChangeEvent());
        RootColumnId.mainId = -1;
        RootColumnId.mainColumn = null;
        b0.c0(settingLanguageAty, TransitionLanguageAty.class);
        com.mobile.brasiltv.utils.a.b().e();
    }

    public View S2(int i10) {
        Map map = this.f12177l;
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

    public final void T2(String str) {
        M2().k(str);
        b.b(this, str);
        b.c(this, str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_setting_language);
        Drawable drawable = getResources().getDrawable(R.drawable.icon_muti_select);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        if (TextUtils.equals(M2().c(), "pt") || f0.c()) {
            int i10 = R$id.rbPT;
            ((RadioButton) S2(i10)).setChecked(true);
            ((RadioButton) S2(i10)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else if (TextUtils.equals(M2().c(), "es") || f0.b()) {
            int i11 = R$id.rbES;
            ((RadioButton) S2(i11)).setChecked(true);
            ((RadioButton) S2(i11)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else if (TextUtils.equals(M2().c(), XML.DEFAULT_CONTENT_LANGUAGE)) {
            int i12 = R$id.rbEN;
            ((RadioButton) S2(i12)).setChecked(true);
            ((RadioButton) S2(i12)).setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        ((RadioGroup) S2(R$id.rgInfo)).setOnCheckedChangeListener(new s4(this, drawable));
    }
}
