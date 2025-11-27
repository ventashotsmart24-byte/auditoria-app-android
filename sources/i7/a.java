package i7;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.autoupdate.R$id;
import com.mobile.autoupdate.R$layout;
import com.mobile.autoupdate.R$string;
import com.mobile.autoupdate.R$style;
import com.mobile.bean.UpdateBean;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import h7.g;
import java.util.Iterator;

public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public final UpdateBean f17337a;

    /* renamed from: b  reason: collision with root package name */
    public final d5.c f17338b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17339c = false;

    /* renamed from: d  reason: collision with root package name */
    public h7.e f17340d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17341e;

    /* renamed from: i7.a$a  reason: collision with other inner class name */
    public class C0226a implements Runnable {
        public C0226a() {
        }

        public void run() {
            ViewGroup.LayoutParams layoutParams = a.this.f17341e.getLayoutParams();
            if (a.this.f17341e.getLineCount() > 3) {
                layoutParams.height = AutoUtils.getPercentWidthSize(340);
            } else {
                layoutParams.height = AutoUtils.getPercentWidthSize(150);
            }
            a.this.f17341e.setLayoutParams(layoutParams);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            a.this.l();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            a.this.k();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            h7.d unused = a.this.getClass();
            throw null;
        }
    }

    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f17340d != null) {
                a.this.f17340d.a(dialogInterface, a.this.f17339c);
            }
        }
    }

    public a(Context context, UpdateBean updateBean, d5.c cVar, Boolean bool) {
        super(context, R$style.UpgradeDialog);
        this.f17337a = updateBean;
        this.f17338b = cVar;
        setContentView(R$layout.dialog_common_upgrade);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(600);
            window.setAttributes(attributes);
        }
        ImageView imageView = (ImageView) findViewById(R$id.ivClose);
        this.f17341e = (TextView) findViewById(R$id.tvContent);
        TextView textView = (TextView) findViewById(R$id.tvEmail);
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) findViewById(R$id.autoEmails);
        if (cVar.b().isEmpty()) {
            autoLinearLayout.setVisibility(4);
        } else {
            autoLinearLayout.setVisibility(0);
            textView.setText(cVar.b());
        }
        TextView textView2 = (TextView) findViewById(R$id.mCopyTips);
        Button button = (Button) findViewById(R$id.mBtnCopy);
        if (bool.booleanValue()) {
            textView2.setVisibility(0);
            button.setVisibility(0);
        } else {
            textView2.setVisibility(8);
            button.setVisibility(8);
        }
        ((TextView) findViewById(R$id.tvUpgradeVersion)).setText("V" + updateBean.getVersionName());
        TextView textView3 = (TextView) findViewById(R$id.tvVersion);
        if (cVar.l().isEmpty()) {
            textView3.setText(getContext().getResources().getString(R$string.current_version) + cVar.a());
        } else {
            textView3.setText(getContext().getResources().getString(R$string.current_version) + cVar.a() + "  " + getContext().getResources().getString(R$string.uid) + cVar.l());
        }
        Button button2 = (Button) findViewById(R$id.kbUpgrade);
        TextView textView4 = (TextView) findViewById(R$id.tvOfficialDownloadUrl);
        this.f17341e.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.f17341e.setText(updateBean.getNote());
        this.f17341e.post(new C0226a());
        textView4.setText(Html.fromHtml(h()));
        if (cVar.m()) {
            imageView.setVisibility(8);
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        }
        imageView.setOnClickListener(new b());
        button2.setOnClickListener(new c());
        textView4.setOnClickListener(new d());
        button.setOnClickListener(new e());
    }

    public final String g() {
        String f10 = this.f17338b.f();
        String c10 = this.f17338b.c();
        if (TextUtils.isEmpty(f10)) {
            return c10;
        }
        return f10;
    }

    public final String h() {
        String format = String.format("<u><font color=\"#22a4e6\">%s</font></u>", new Object[]{g().replace("http://", "").replace("https://", "")});
        return getContext().getString(R$string.common_click_official_website, new Object[]{format});
    }

    public final void i() {
        this.f17339c = true;
        new b(getContext(), this.f17337a, this.f17338b).j(this.f17340d).show();
    }

    public final void j() {
        boolean z10;
        Iterator it = b5.a.g().h().iterator();
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
            b5.a.g().j(new h7.f(getContext(), this.f17338b.g()));
            b5.a.g().j(new g(getContext(), this.f17338b));
        }
        b5.a.g().m(getContext(), this.f17338b);
    }

    public final void k() {
        try {
            String g10 = g();
            if (!g10.startsWith("http://") && !g10.startsWith("https://")) {
                g10 = "http://" + g10;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(g10));
            getContext().startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void l() {
        if (this.f17338b.m()) {
            i();
        } else {
            j();
        }
        dismiss();
    }

    public a m(h7.e eVar) {
        if (eVar == null) {
            return this;
        }
        this.f17340d = eVar;
        setOnDismissListener(new f());
        return this;
    }
}
