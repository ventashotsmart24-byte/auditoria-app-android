package h7;

import android.app.Notification;
import android.content.Context;
import android.widget.RemoteViews;
import b5.a;
import com.mobile.autoupdate.R$id;
import com.mobile.autoupdate.R$layout;
import com.mobile.autoupdate.R$string;
import com.raizlabs.android.dbflow.sql.language.Operator;
import d5.c;
import q5.i;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17303a;

    /* renamed from: b  reason: collision with root package name */
    public final c f17304b;

    /* renamed from: c  reason: collision with root package name */
    public int f17305c = 0;

    /* renamed from: d  reason: collision with root package name */
    public Notification f17306d = null;

    public g(Context context, c cVar) {
        this.f17303a = context;
        this.f17304b = cVar;
    }

    public void A(long j10, long j11) {
        b((int) ((j10 * 100) / j11));
    }

    public final void a() {
        Context context = this.f17303a;
        if (context != null) {
            i iVar = i.f19305a;
            if (iVar.j(context)) {
                Notification a10 = new i.a().s(this.f17303a).q("progress").r(4).v(this.f17304b.d()).x(this.f17304b.e()).w(false).p(false).u(true).t(R$layout.layout_update_remote_view).a();
                this.f17306d = a10;
                a10.contentView.setImageViewResource(R$id.img_icon, this.f17304b.d());
                this.f17306d.contentView.setTextViewText(R$id.text_title, this.f17303a.getString(R$string.notify_begin_download));
                this.f17306d.flags |= 2;
                int g10 = iVar.g();
                this.f17305c = g10;
                iVar.k(this.f17303a, this.f17306d, g10);
            }
        }
    }

    public final void b(int i10) {
        Notification notification = this.f17306d;
        if (notification != null && this.f17303a != null) {
            RemoteViews remoteViews = notification.contentView;
            int i11 = R$id.text_title;
            remoteViews.setTextViewText(i11, this.f17303a.getString(R$string.notify_download_percent, new Object[]{Integer.valueOf(i10)}) + Operator.Operation.MOD);
            this.f17306d.contentView.setProgressBar(R$id.progress_download, 100, i10, false);
            Notification notification2 = this.f17306d;
            notification2.flags = notification2.flags | 2;
            i.f19305a.k(this.f17303a, notification2, this.f17305c);
        }
    }

    public final void c() {
        Context context;
        if (this.f17306d != null && (context = this.f17303a) != null) {
            i.f19305a.c(context, this.f17305c);
        }
    }

    public final void d() {
        Context context;
        if (this.f17306d != null && (context = this.f17303a) != null) {
            i.f19305a.c(context, this.f17305c);
        }
    }

    public void onFailure(Exception exc) {
        a.g().n(this);
        c();
    }

    public void onSuccess() {
        a.g().n(this);
        d();
    }

    public void z() {
        a();
    }
}
