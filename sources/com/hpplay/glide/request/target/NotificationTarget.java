package com.hpplay.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.hpplay.glide.request.animation.GlideAnimation;

public class NotificationTarget extends SimpleTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context context2, RemoteViews remoteViews2, int i10, Notification notification2, int i11) {
        this(context2, remoteViews2, i10, Integer.MIN_VALUE, Integer.MIN_VALUE, notification2, i11);
    }

    private void update() {
        ((NotificationManager) this.context.getSystemService("notification")).notify(this.notificationId, this.notification);
    }

    public NotificationTarget(Context context2, RemoteViews remoteViews2, int i10, int i11, int i12, Notification notification2, int i13) {
        super(i11, i12);
        if (context2 == null) {
            throw new NullPointerException("Context must not be null!");
        } else if (notification2 == null) {
            throw new NullPointerException("Notification object can not be null!");
        } else if (remoteViews2 != null) {
            this.context = context2;
            this.viewId = i10;
            this.notification = notification2;
            this.notificationId = i13;
            this.remoteViews = remoteViews2;
        } else {
            throw new NullPointerException("RemoteViews object can not be null!");
        }
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }
}
