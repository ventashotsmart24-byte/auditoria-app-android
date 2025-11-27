package i7;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.mobile.autoupdate.R$id;
import com.mobile.autoupdate.R$layout;
import com.mobile.autoupdate.R$string;
import com.mobile.autoupdate.R$style;
import com.mobile.bean.UpdateBean;
import com.mobile.view.UpgradeProgressView;
import h7.e;
import h7.g;

public class b extends Dialog implements h7.c {

    /* renamed from: a  reason: collision with root package name */
    public final UpdateBean f17348a;

    /* renamed from: b  reason: collision with root package name */
    public final d5.c f17349b;

    /* renamed from: c  reason: collision with root package name */
    public UpgradeProgressView f17350c;

    /* renamed from: d  reason: collision with root package name */
    public e f17351d;

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (b.this.f17351d != null) {
                b.this.f17351d.a(dialogInterface, false);
            }
        }
    }

    /* renamed from: i7.b$b  reason: collision with other inner class name */
    public class C0227b implements View.OnClickListener {
        public C0227b() {
        }

        public void onClick(View view) {
            b.this.h();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            j7.a.c(b.this.getContext(), b.this.f17349b.g());
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    public b(Context context, UpdateBean updateBean, d5.c cVar) {
        super(context, R$style.UpgradeDialog);
        this.f17348a = updateBean;
        this.f17349b = cVar;
    }

    public void A(long j10, long j11) {
        this.f17350c.setProgress((int) ((j10 * 100) / j11));
    }

    public final String d() {
        String str;
        try {
            str = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            str = "";
        }
        return getContext().getString(R$string.upgrade_progress_current_version, new Object[]{str});
    }

    public final String e() {
        String f10 = this.f17349b.f();
        String c10 = this.f17349b.c();
        if (TextUtils.isEmpty(f10)) {
            return c10;
        }
        return f10;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f17348a.getNote())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : this.f17348a.getNote().split("\\n")) {
            sb.append("<b>·</b> ");
            sb.append(append);
            sb.append("<br>");
        }
        return sb.toString();
    }

    public final String g() {
        return "(" + getContext().getString(R$string.upgrade_progress_version, new Object[]{this.f17348a.getVersionName()}) + ")";
    }

    public final void h() {
        String e10 = e();
        if (!e10.startsWith("http://") && !e10.startsWith("https://")) {
            e10 = "http://" + e10;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(e10));
        getContext().startActivity(intent);
    }

    public final void i() {
        b5.a.g().j(new g(getContext(), this.f17349b));
        b5.a.g().j(this);
        b5.a.g().m(getContext(), this.f17349b);
    }

    public b j(e eVar) {
        if (eVar == null) {
            return this;
        }
        this.f17351d = eVar;
        setOnDismissListener(new a());
        return this;
    }

    public final void k() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        ((TextView) findViewById(R$id.mTvUpdating)).setVisibility(8);
        ((TextView) findViewById(R$id.mTvDontCloseApp)).setVisibility(8);
        ((TextView) findViewById(R$id.mTvDownloadFail)).setVisibility(0);
        String format = String.format("<u><font color=\"#22a4e6\">%s</font></u>", new Object[]{e()});
        ((TextView) findViewById(R$id.mTvDownloadLinkDesc)).setText(Html.fromHtml(getContext().getString(R$string.upgrade_progress_download_link, new Object[]{format})));
        TextView textView = (TextView) findViewById(R$id.mTvDownloadHint);
        textView.setVisibility(0);
        textView.setText(R$string.upgrade_progress_cant_download);
        TextView textView2 = (TextView) findViewById(R$id.mTvContract);
        textView2.setVisibility(0);
        if (!this.f17349b.h().isEmpty()) {
            textView2.setText(getContext().getString(R$string.upgrade_progress_contract_email, new Object[]{this.f17349b.h()}));
        }
        Button button = (Button) findViewById(R$id.mBtnClose);
        button.setText(R$string.upgrade_progress_close);
        button.setVisibility(0);
        button.setOnClickListener(new d());
    }

    public final void l() {
        Button button = (Button) findViewById(R$id.mBtnClose);
        button.setText(R$string.upgrade_progress_install);
        button.setVisibility(0);
        button.setOnClickListener(new c());
    }

    public final void m() {
        TextView textView = (TextView) findViewById(R$id.mTvDownloadLinkDesc);
        textView.setOnClickListener(new C0227b());
        String format = String.format("<u><font color=\"#22a4e6\">%s</font></u>", new Object[]{e()});
        textView.setText(Html.fromHtml(getContext().getString(R$string.upgrade_progress_click_download_url, new Object[]{format})));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.dialog_upgrade_progress);
        getWindow().setLayout(-1, -1);
        getWindow().addFlags(2);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.9f;
        getWindow().setAttributes(attributes);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(R$id.mTvReleaseNote);
        this.f17350c = (UpgradeProgressView) findViewById(R$id.mUpvProgress);
        ((TextView) findViewById(R$id.mTvVersion)).setText(g());
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setText(Html.fromHtml(f()));
        ((TextView) findViewById(R$id.mTvCurrentVersion)).setText(d());
        m();
        i();
    }

    public void onFailure(Exception exc) {
        this.f17350c.setInvalid(true);
        b5.a.g().n(this);
        k();
    }

    public void onSuccess() {
        this.f17350c.setProgress(100);
        b5.a.g().n(this);
        l();
        j7.a.c(getContext(), this.f17349b.g());
    }

    public void z() {
    }
}
