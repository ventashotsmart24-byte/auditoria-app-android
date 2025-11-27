package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import b5.a;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.utils.x;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import d5.c;
import h7.g;
import i7.b;
import java.util.Iterator;
import k7.f;

public class MineUpgradeDialog extends Dialog {
    public KoocanButton dialog_cancel;
    public KoocanButton dialog_submit;
    /* access modifiers changed from: private */
    public UpdateBean mUpdateBean;

    public MineUpgradeDialog(Context context, UpdateBean updateBean) {
        super(context, R.style.OptionDialog);
        setContentView(R.layout.dialog_mine_upgrade);
        this.mUpdateBean = updateBean;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            window.setAttributes(attributes);
        }
        this.dialog_cancel = (KoocanButton) findViewById(R.id.dialog_cancel);
        this.dialog_submit = (KoocanButton) findViewById(R.id.dialog_submit);
        setCanceledOnTouchOutside(false);
        this.dialog_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MineUpgradeDialog.this.dismiss();
            }
        });
        this.dialog_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MineUpgradeDialog.this.dismiss();
                if (MineUpgradeDialog.this.mUpdateBean.getUrl() != null) {
                    f.b("downloadUrl:" + MineUpgradeDialog.this.mUpdateBean.getUrl());
                    MineUpgradeDialog mineUpgradeDialog = MineUpgradeDialog.this;
                    mineUpgradeDialog.handleUpgradeBussiness(mineUpgradeDialog.mUpdateBean);
                }
            }
        });
    }

    private void gotoForceUpgrade(c cVar) {
        new b(getContext(), this.mUpdateBean, cVar).show();
    }

    private void gotoNormalUpgrade(c cVar) {
        boolean z10;
        Iterator it = a.g().h().iterator();
        while (true) {
            if (it.hasNext()) {
                if (((h7.c) it.next()) instanceof h7.f) {
                    z10 = true;
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        if (!z10) {
            a.g().j(new h7.f(getContext(), cVar.g()));
            a.g().j(new g(getContext(), cVar));
        }
        a.g().m(getContext(), cVar);
    }

    /* access modifiers changed from: private */
    public void handleUpgradeBussiness(UpdateBean updateBean) {
        c cVar = new c();
        boolean z10 = true;
        if (updateBean.getForceUpdate() != 1) {
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
        if (cVar.m()) {
            gotoForceUpgrade(cVar);
        } else {
            gotoNormalUpgrade(cVar);
        }
    }

    public void onBackPressed() {
        dismiss();
    }
}
