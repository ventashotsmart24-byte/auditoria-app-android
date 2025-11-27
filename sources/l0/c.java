package l0;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.n;
import android.widget.RemoteViews;
import androidx.media.R$id;
import androidx.media.R$integer;
import androidx.media.R$layout;
import o.r;
import o.s;

public class c extends s.f {

    /* renamed from: e  reason: collision with root package name */
    public int[] f7586e = null;

    /* renamed from: f  reason: collision with root package name */
    public MediaSessionCompat.Token f7587f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7588g;

    /* renamed from: h  reason: collision with root package name */
    public PendingIntent f7589h;

    public void b(r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            rVar.a().setStyle(m(new Notification.MediaStyle()));
        } else if (this.f7588g) {
            rVar.a().setOngoing(true);
        }
    }

    public RemoteViews i(r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return n();
    }

    public RemoteViews j(r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return null;
        }
        return o();
    }

    public Notification.MediaStyle m(Notification.MediaStyle mediaStyle) {
        int[] iArr = this.f7586e;
        if (iArr != null) {
            Notification.MediaStyle unused = mediaStyle.setShowActionsInCompactView(iArr);
        }
        MediaSessionCompat.Token token = this.f7587f;
        if (token != null) {
            Notification.MediaStyle unused2 = mediaStyle.setMediaSession(n.a(token.c()));
        }
        return mediaStyle;
    }

    public RemoteViews n() {
        int min = Math.min(this.f8411a.f8386b.size(), 5);
        RemoteViews c10 = c(false, q(min), false);
        c10.removeAllViews(R$id.media_actions);
        if (min > 0) {
            for (int i10 = 0; i10 < min; i10++) {
                c10.addView(R$id.media_actions, p((s.a) this.f8411a.f8386b.get(i10)));
            }
        }
        if (this.f7588g) {
            int i11 = R$id.cancel_action;
            c10.setViewVisibility(i11, 0);
            c10.setInt(i11, "setAlpha", this.f8411a.f8385a.getResources().getInteger(R$integer.cancel_button_image_alpha));
            c10.setOnClickPendingIntent(i11, this.f7589h);
        } else {
            c10.setViewVisibility(R$id.cancel_action, 8);
        }
        return c10;
    }

    public RemoteViews o() {
        int i10;
        RemoteViews c10 = c(false, r(), true);
        int size = this.f8411a.f8386b.size();
        int[] iArr = this.f7586e;
        if (iArr == null) {
            i10 = 0;
        } else {
            i10 = Math.min(iArr.length, 3);
        }
        c10.removeAllViews(R$id.media_actions);
        if (i10 > 0) {
            int i11 = 0;
            while (i11 < i10) {
                if (i11 < size) {
                    c10.addView(R$id.media_actions, p((s.a) this.f8411a.f8386b.get(this.f7586e[i11])));
                    i11++;
                } else {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i11), Integer.valueOf(size - 1)}));
                }
            }
        }
        if (this.f7588g) {
            c10.setViewVisibility(R$id.end_padder, 8);
            int i12 = R$id.cancel_action;
            c10.setViewVisibility(i12, 0);
            c10.setOnClickPendingIntent(i12, this.f7589h);
            c10.setInt(i12, "setAlpha", this.f8411a.f8385a.getResources().getInteger(R$integer.cancel_button_image_alpha));
        } else {
            c10.setViewVisibility(R$id.end_padder, 0);
            c10.setViewVisibility(R$id.cancel_action, 8);
        }
        return c10;
    }

    public final RemoteViews p(s.a aVar) {
        boolean z10;
        if (aVar.a() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        RemoteViews remoteViews = new RemoteViews(this.f8411a.f8385a.getPackageName(), R$layout.notification_media_action);
        int i10 = R$id.action0;
        remoteViews.setImageViewResource(i10, aVar.e());
        if (!z10) {
            remoteViews.setOnClickPendingIntent(i10, aVar.a());
        }
        remoteViews.setContentDescription(i10, aVar.j());
        return remoteViews;
    }

    public int q(int i10) {
        if (i10 <= 3) {
            return R$layout.notification_template_big_media_narrow;
        }
        return R$layout.notification_template_big_media;
    }

    public int r() {
        return R$layout.notification_template_media;
    }

    public c s(MediaSessionCompat.Token token) {
        this.f7587f = token;
        return this;
    }

    public c t(int... iArr) {
        this.f7586e = iArr;
        return this;
    }
}
