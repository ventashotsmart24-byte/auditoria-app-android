package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import c5.a;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.x;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import i7.b;
import ja.c;
import t9.g;
import t9.i;
import w6.i;

public final class VersionForbiddenDialog extends CommonDialog {
    private a mCheckUpdate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VersionForbiddenDialog(Context context) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
    }

    private final void checkUpdate() {
        ((AutoFrameLayout) findViewById(R$id.mAflLoading)).setVisibility(0);
        if (this.mCheckUpdate == null) {
            this.mCheckUpdate = new a(new c(".update"), new la.a(".update"));
        }
        a aVar = this.mCheckUpdate;
        if (aVar != null) {
            aVar.f();
        }
        a aVar2 = this.mCheckUpdate;
        if (aVar2 != null) {
            Context context = getContext();
            i.c cVar = w6.i.f9510g;
            aVar2.g(context, cVar.E(), cVar.l(), new VersionForbiddenDialog$checkUpdate$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void handleForceUpgrade(UpdateBean updateBean) {
        boolean z10;
        d5.c cVar = new d5.c();
        if (updateBean.getForceUpdate() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.q(z10);
        cVar.w(updateBean.getMd5());
        cVar.y(updateBean.getUrl());
        cVar.x(updateBean.getSpareUrl());
        cVar.p(s6.a.f9335a.a().i());
        cVar.t(updateBean.getDefaultDownloadUrl());
        cVar.v(x.f12622a.h());
        cVar.u(y5.a.f19919a);
        cVar.s(R.mipmap.ic_logo);
        cVar.r(R.mipmap.ic_logo);
        new b(getContext(), updateBean, cVar).j(new g1()).show();
        xa.c.c().m(new HasNewUpdateEvent(true));
    }

    /* access modifiers changed from: private */
    public static final void handleForceUpgrade$lambda$5(DialogInterface dialogInterface, boolean z10) {
    }

    private final void handleUpgradeBussiness(UpdateBean updateBean) {
        boolean z10;
        d5.c cVar = new d5.c();
        if (updateBean.getForceUpdate() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.q(z10);
        cVar.w(updateBean.getMd5());
        cVar.y(updateBean.getUrl());
        cVar.p(s6.a.f9335a.a().i());
        cVar.t(updateBean.getDefaultDownloadUrl());
        cVar.v(x.f12622a.h());
        cVar.u(y5.a.f19919a);
        cVar.s(R.mipmap.ic_logo);
        cVar.r(R.mipmap.ic_logo);
        i7.a m10 = new i7.a(getContext(), updateBean, cVar, Boolean.FALSE).m(new h1(this));
        t9.i.f(m10, "CommonUpgradeDialog(cont…Dialog)\n                }");
        b0.S(m10, DialogManager.DIALOG_UPDATE);
        xa.c.c().m(new HasNewUpdateEvent(true));
    }

    /* access modifiers changed from: private */
    public static final void handleUpgradeBussiness$lambda$4(VersionForbiddenDialog versionForbiddenDialog, DialogInterface dialogInterface, boolean z10) {
        t9.i.g(versionForbiddenDialog, "this$0");
        if (!z10) {
            if (MainAty.A.i()) {
                DialogManager dialogManager = DialogManager.INSTANCE;
                if (!dialogManager.hasDialogSaved(DialogManager.DIALOG_VERSION_FORBIDDEN)) {
                    Context context = versionForbiddenDialog.getContext();
                    t9.i.f(context, f.X);
                    dialogManager.showByManager(new VersionForbiddenDialog(context), DialogManager.DIALOG_VERSION_FORBIDDEN);
                }
            }
            DialogManager dialogManager2 = DialogManager.INSTANCE;
            t9.i.e(dialogInterface, "null cannot be cast to non-null type android.app.Dialog");
            dialogManager2.showNext((Dialog) dialogInterface);
        }
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(View view) {
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(VersionForbiddenDialog versionForbiddenDialog, View view) {
        t9.i.g(versionForbiddenDialog, "this$0");
        versionForbiddenDialog.checkUpdate();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$3(VersionForbiddenDialog versionForbiddenDialog, View view) {
        t9.i.g(versionForbiddenDialog, "this$0");
        String e10 = s6.a.f9335a.a().e();
        Context context = versionForbiddenDialog.getContext();
        t9.i.f(context, f.X);
        b0.f0(context, "http://" + e10);
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_version_forbidden;
    }

    public void initListener() {
        ((AutoFrameLayout) findViewById(R$id.mAflLoading)).setOnClickListener(new i1());
        ((TextView) findViewById(R$id.mTvUpdate)).setOnClickListener(new j1(this));
        ((TextView) findViewById(R$id.mTvUpgradeLink)).setOnClickListener(new k1(this));
    }

    public void initView() {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(R.id.tvEmail);
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) findViewById(R.id.autoEmails);
        x xVar = x.f12622a;
        if (xVar.h().length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            autoLinearLayout.setVisibility(4);
        } else {
            autoLinearLayout.setVisibility(0);
            textView.setText(xVar.h());
        }
        TextView textView2 = (TextView) findViewById(R.id.tvVersion);
        String f10 = na.f.f(na.a.f8315a, "key_user_id", "");
        if (f10.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f10 = w6.i.f9510g.l();
        }
        t9.i.f(f10, "userId");
        if (f10.length() == 0) {
            z12 = true;
        }
        if (z12) {
            textView2.setText(getContext().getResources().getString(R.string.current_version) + na.a.c());
        } else {
            textView2.setText(getContext().getResources().getString(R.string.current_version) + na.a.c() + "  " + getContext().getResources().getString(R.string.uid) + f10);
        }
        String e10 = s6.a.f9335a.a().e();
        ((TextView) findViewById(R$id.mTvUpgradeLink)).setText(Html.fromHtml(getContext().getString(R.string.version_forbidden_upgrade_hint) + " <font color=\"#22A4E6\"><u>" + e10 + "</u></font>"));
    }
}
