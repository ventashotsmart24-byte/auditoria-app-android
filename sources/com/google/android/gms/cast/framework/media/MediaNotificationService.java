package com.google.android.gms.cast.framework.media;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzb;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzcn;
import java.util.ArrayList;
import java.util.List;
import l0.c;
import o.s;

public class MediaNotificationService extends Service {
    @RecentlyNonNull
    public static final String ACTION_UPDATE_NOTIFICATION = "com.google.android.gms.cast.framework.action.UPDATE_NOTIFICATION";
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("MediaNotificationService");
    private static Runnable zzb;
    private NotificationOptions zzc;
    private ImagePicker zzd;
    private ComponentName zze;
    private ComponentName zzf;
    private List<s.a> zzg = new ArrayList();
    private int[] zzh;
    private long zzi;
    private zzb zzj;
    private ImageHints zzk;
    private Resources zzl;
    private zzn zzm;
    /* access modifiers changed from: private */
    public zzo zzn;
    private NotificationManager zzo;
    private Notification zzp;
    /* access modifiers changed from: private */
    public CastContext zzq;
    private final BroadcastReceiver zzr = new zzl(this);

    public static boolean isNotificationOptionsValid(@RecentlyNonNull CastOptions castOptions) {
        NotificationOptions notificationOptions;
        int i10;
        int length;
        CastMediaOptions castMediaOptions = castOptions.getCastMediaOptions();
        if (castMediaOptions == null || (notificationOptions = castMediaOptions.getNotificationOptions()) == null) {
            return false;
        }
        zzg zzm2 = notificationOptions.zzm();
        if (zzm2 == null) {
            return true;
        }
        List<NotificationAction> zzg2 = zzg(zzm2);
        int[] zzk2 = zzk(zzm2);
        if (zzg2 == null) {
            i10 = 0;
        } else {
            i10 = zzg2.size();
        }
        Class<NotificationActionsProvider> cls = NotificationActionsProvider.class;
        if (zzg2 == null || zzg2.isEmpty()) {
            zza.e(cls.getSimpleName().concat(" doesn't provide any action."), new Object[0]);
        } else if (zzg2.size() > 5) {
            zza.e(cls.getSimpleName().concat(" provides more than 5 actions."), new Object[0]);
        } else if (zzk2 == null || (length = zzk2.length) == 0) {
            zza.e(cls.getSimpleName().concat(" doesn't provide any actions for compact view."), new Object[0]);
        } else {
            int i11 = 0;
            while (i11 < length) {
                int i12 = zzk2[i11];
                if (i12 < 0 || i12 >= i10) {
                    zza.e(cls.getSimpleName().concat("provides a compact view action whose index is out of bounds."), new Object[0]);
                } else {
                    i11++;
                }
            }
            return true;
        }
        return false;
    }

    public static void zze() {
        Runnable runnable = zzb;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final o.s.a zzf(java.lang.String r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            int r2 = r20.hashCode()
            java.lang.String r4 = "com.google.android.gms.cast.framework.action.FORWARD"
            java.lang.String r5 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            java.lang.String r6 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            java.lang.String r7 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            java.lang.String r8 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            java.lang.String r9 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            java.lang.String r10 = "com.google.android.gms.cast.framework.action.REWIND"
            r11 = 1
            r12 = 0
            switch(r2) {
                case -1699820260: goto L_0x004c;
                case -945151566: goto L_0x0044;
                case -945080078: goto L_0x003c;
                case -668151673: goto L_0x0034;
                case -124479363: goto L_0x002c;
                case 235550565: goto L_0x0024;
                case 1362116196: goto L_0x001c;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0054
        L_0x001c:
            boolean r2 = r1.equals(r4)
            if (r2 == 0) goto L_0x0054
            r2 = 3
            goto L_0x0055
        L_0x0024:
            boolean r2 = r1.equals(r5)
            if (r2 == 0) goto L_0x0054
            r2 = 0
            goto L_0x0055
        L_0x002c:
            boolean r2 = r1.equals(r6)
            if (r2 == 0) goto L_0x0054
            r2 = 6
            goto L_0x0055
        L_0x0034:
            boolean r2 = r1.equals(r7)
            if (r2 == 0) goto L_0x0054
            r2 = 5
            goto L_0x0055
        L_0x003c:
            boolean r2 = r1.equals(r8)
            if (r2 == 0) goto L_0x0054
            r2 = 2
            goto L_0x0055
        L_0x0044:
            boolean r2 = r1.equals(r9)
            if (r2 == 0) goto L_0x0054
            r2 = 1
            goto L_0x0055
        L_0x004c:
            boolean r2 = r1.equals(r10)
            if (r2 == 0) goto L_0x0054
            r2 = 4
            goto L_0x0055
        L_0x0054:
            r2 = -1
        L_0x0055:
            r13 = 30000(0x7530, double:1.4822E-319)
            r15 = 10000(0x2710, double:4.9407E-320)
            r17 = 134217728(0x8000000, float:3.85186E-34)
            java.lang.String r3 = "googlecast-extra_skip_step_ms"
            r18 = 0
            switch(r2) {
                case 0: goto L_0x01dc;
                case 1: goto L_0x01a8;
                case 2: goto L_0x0174;
                case 3: goto L_0x0120;
                case 4: goto L_0x00cc;
                case 5: goto L_0x00a0;
                case 6: goto L_0x006e;
                default: goto L_0x0062;
            }
        L_0x0062:
            com.google.android.gms.cast.internal.Logger r2 = zza
            java.lang.Object[] r3 = new java.lang.Object[r11]
            r3[r12] = r1
            java.lang.String r1 = "Action: %s is not a pre-defined action."
            r2.e(r1, r3)
            return r18
        L_0x006e:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r6)
            android.content.ComponentName r2 = r0.zze
            r1.setComponent(r2)
            int r2 = com.google.android.gms.internal.cast.zzcn.zza
            android.app.PendingIntent r1 = com.google.android.gms.internal.cast.zzcn.zzb(r0, r12, r1, r2)
            o.s$a$a r2 = new o.s$a$a
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r0.zzc
            int r3 = r3.getDisconnectDrawableResId()
            android.content.res.Resources r4 = r0.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r0.zzc
            int r5 = r5.zza()
            java.lang.Object[] r6 = new java.lang.Object[r11]
            java.lang.String r7 = ""
            r6[r12] = r7
            java.lang.String r4 = r4.getString(r5, r6)
            r2.<init>(r3, r4, r1)
            o.s$a r1 = r2.a()
            return r1
        L_0x00a0:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r7)
            android.content.ComponentName r2 = r0.zze
            r1.setComponent(r2)
            int r2 = com.google.android.gms.internal.cast.zzcn.zza
            android.app.PendingIntent r1 = com.google.android.gms.internal.cast.zzcn.zzb(r0, r12, r1, r2)
            o.s$a$a r2 = new o.s$a$a
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r0.zzc
            int r3 = r3.getDisconnectDrawableResId()
            android.content.res.Resources r4 = r0.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r0.zzc
            int r5 = r5.zza()
            java.lang.String r4 = r4.getString(r5)
            r2.<init>(r3, r4, r1)
            o.s$a r1 = r2.a()
            return r1
        L_0x00cc:
            long r1 = r0.zzi
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r10)
            android.content.ComponentName r5 = r0.zze
            r4.setComponent(r5)
            r4.putExtra(r3, r1)
            int r3 = com.google.android.gms.internal.cast.zzcn.zza
            r3 = r3 | r17
            android.app.PendingIntent r3 = com.google.android.gms.internal.cast.zzcn.zzb(r0, r12, r4, r3)
            com.google.android.gms.cast.framework.media.NotificationOptions r4 = r0.zzc
            int r4 = r4.getRewindDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r0.zzc
            int r5 = r5.zzj()
            int r6 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r6 != 0) goto L_0x0100
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r4 = r1.getRewind10DrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r5 = r1.zzh()
            goto L_0x0110
        L_0x0100:
            int r6 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0110
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r4 = r1.getRewind30DrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r5 = r1.zzi()
        L_0x0110:
            o.s$a$a r1 = new o.s$a$a
            android.content.res.Resources r2 = r0.zzl
            java.lang.String r2 = r2.getString(r5)
            r1.<init>(r4, r2, r3)
            o.s$a r1 = r1.a()
            return r1
        L_0x0120:
            long r1 = r0.zzi
            android.content.Intent r5 = new android.content.Intent
            r5.<init>(r4)
            android.content.ComponentName r4 = r0.zze
            r5.setComponent(r4)
            r5.putExtra(r3, r1)
            int r3 = com.google.android.gms.internal.cast.zzcn.zza
            r3 = r3 | r17
            android.app.PendingIntent r3 = com.google.android.gms.internal.cast.zzcn.zzb(r0, r12, r5, r3)
            com.google.android.gms.cast.framework.media.NotificationOptions r4 = r0.zzc
            int r4 = r4.getForwardDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r0.zzc
            int r5 = r5.zzd()
            int r6 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r6 != 0) goto L_0x0154
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r4 = r1.getForward10DrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r5 = r1.zzb()
            goto L_0x0164
        L_0x0154:
            int r6 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0164
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r4 = r1.getForward30DrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r5 = r1.zzc()
        L_0x0164:
            o.s$a$a r1 = new o.s$a$a
            android.content.res.Resources r2 = r0.zzl
            java.lang.String r2 = r2.getString(r5)
            r1.<init>(r4, r2, r3)
            o.s$a r1 = r1.a()
            return r1
        L_0x0174:
            com.google.android.gms.cast.framework.media.zzn r1 = r0.zzm
            boolean r1 = r1.zzg
            if (r1 == 0) goto L_0x018a
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r8)
            android.content.ComponentName r2 = r0.zze
            r1.setComponent(r2)
            int r2 = com.google.android.gms.internal.cast.zzcn.zza
            android.app.PendingIntent r18 = com.google.android.gms.internal.cast.zzcn.zzb(r0, r12, r1, r2)
        L_0x018a:
            r1 = r18
            o.s$a$a r2 = new o.s$a$a
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r0.zzc
            int r3 = r3.getSkipPrevDrawableResId()
            android.content.res.Resources r4 = r0.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r0.zzc
            int r5 = r5.zzl()
            java.lang.String r4 = r4.getString(r5)
            r2.<init>(r3, r4, r1)
            o.s$a r1 = r2.a()
            return r1
        L_0x01a8:
            com.google.android.gms.cast.framework.media.zzn r1 = r0.zzm
            boolean r1 = r1.zzf
            if (r1 == 0) goto L_0x01be
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r9)
            android.content.ComponentName r2 = r0.zze
            r1.setComponent(r2)
            int r2 = com.google.android.gms.internal.cast.zzcn.zza
            android.app.PendingIntent r18 = com.google.android.gms.internal.cast.zzcn.zzb(r0, r12, r1, r2)
        L_0x01be:
            r1 = r18
            o.s$a$a r2 = new o.s$a$a
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r0.zzc
            int r3 = r3.getSkipNextDrawableResId()
            android.content.res.Resources r4 = r0.zzl
            com.google.android.gms.cast.framework.media.NotificationOptions r5 = r0.zzc
            int r5 = r5.zzk()
            java.lang.String r4 = r4.getString(r5)
            r2.<init>(r3, r4, r1)
            o.s$a r1 = r2.a()
            return r1
        L_0x01dc:
            com.google.android.gms.cast.framework.media.zzn r1 = r0.zzm
            int r2 = r1.zzc
            boolean r1 = r1.zzb
            r3 = 2
            if (r2 != r3) goto L_0x01f2
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r0.zzc
            int r2 = r2.getStopLiveStreamDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r0.zzc
            int r3 = r3.getStopLiveStreamTitleResId()
            goto L_0x01fe
        L_0x01f2:
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r0.zzc
            int r2 = r2.getPauseDrawableResId()
            com.google.android.gms.cast.framework.media.NotificationOptions r3 = r0.zzc
            int r3 = r3.zzf()
        L_0x01fe:
            if (r1 != 0) goto L_0x0206
            com.google.android.gms.cast.framework.media.NotificationOptions r2 = r0.zzc
            int r2 = r2.getPlayDrawableResId()
        L_0x0206:
            if (r1 != 0) goto L_0x020e
            com.google.android.gms.cast.framework.media.NotificationOptions r1 = r0.zzc
            int r3 = r1.zzg()
        L_0x020e:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r5)
            android.content.ComponentName r4 = r0.zze
            r1.setComponent(r4)
            int r4 = com.google.android.gms.internal.cast.zzcn.zza
            android.app.PendingIntent r1 = com.google.android.gms.internal.cast.zzcn.zzb(r0, r12, r1, r4)
            o.s$a$a r4 = new o.s$a$a
            android.content.res.Resources r5 = r0.zzl
            java.lang.String r3 = r5.getString(r3)
            r4.<init>(r2, r3, r1)
            o.s$a r1 = r4.a()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.MediaNotificationService.zzf(java.lang.String):o.s$a");
    }

    private static List<NotificationAction> zzg(zzg zzg2) {
        try {
            return zzg2.zzf();
        } catch (RemoteException e10) {
            zza.e(e10, "Unable to call %s on %s.", "getNotificationActions", zzg.class.getSimpleName());
            return null;
        }
    }

    private final void zzh(zzg zzg2) {
        int[] iArr;
        s.a aVar;
        int[] zzk2 = zzk(zzg2);
        if (zzk2 == null) {
            iArr = null;
        } else {
            iArr = (int[]) zzk2.clone();
        }
        this.zzh = iArr;
        List<NotificationAction> zzg3 = zzg(zzg2);
        this.zzg = new ArrayList();
        if (zzg3 != null) {
            for (NotificationAction next : zzg3) {
                String action = next.getAction();
                if (action.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || action.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || action.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || action.equals(MediaIntentReceiver.ACTION_FORWARD) || action.equals(MediaIntentReceiver.ACTION_REWIND) || action.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || action.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                    aVar = zzf(next.getAction());
                } else {
                    Intent intent = new Intent(next.getAction());
                    intent.setComponent(this.zze);
                    aVar = new s.a.C0108a(next.getIconResId(), next.getContentDescription(), zzcn.zzb(this, 0, intent, zzcn.zza)).a();
                }
                if (aVar != null) {
                    this.zzg.add(aVar);
                }
            }
        }
    }

    private final void zzi() {
        this.zzg = new ArrayList();
        for (String zzf2 : this.zzc.getActions()) {
            s.a zzf3 = zzf(zzf2);
            if (zzf3 != null) {
                this.zzg.add(zzf3);
            }
        }
        this.zzh = (int[]) this.zzc.getCompatActionIndices().clone();
    }

    /* access modifiers changed from: private */
    public final void zzj() {
        Bitmap bitmap;
        if (this.zzm != null) {
            zzo zzo2 = this.zzn;
            PendingIntent pendingIntent = null;
            if (zzo2 == null) {
                bitmap = null;
            } else {
                bitmap = zzo2.zzb;
            }
            s.e G = new s.e(this, "cast_media_notification").u(bitmap).B(this.zzc.getSmallIconDrawableResId()).p(this.zzm.zzd).o(this.zzl.getString(this.zzc.getCastingToDeviceStringResId(), new Object[]{this.zzm.zze})).y(true).A(false).G(1);
            ComponentName componentName = this.zzf;
            if (componentName != null) {
                Intent intent = new Intent();
                intent.putExtra("targetActivity", componentName);
                intent.setAction(componentName.flattenToString());
                pendingIntent = zzcn.zzb(this, 1, intent, zzcn.zza | 134217728);
            }
            if (pendingIntent != null) {
                G.n(pendingIntent);
            }
            zzg zzm2 = this.zzc.zzm();
            if (zzm2 != null) {
                zza.i("actionsProvider != null", new Object[0]);
                zzh(zzm2);
            } else {
                zza.i("actionsProvider == null", new Object[0]);
                zzi();
            }
            for (s.a b10 : this.zzg) {
                G.b(b10);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                c cVar = new c();
                int[] iArr = this.zzh;
                if (iArr != null) {
                    cVar.t(iArr);
                }
                MediaSessionCompat.Token token = this.zzm.zza;
                if (token != null) {
                    cVar.s(token);
                }
                G.D(cVar);
            }
            Notification c10 = G.c();
            this.zzp = c10;
            startForeground(1, c10);
        }
    }

    private static int[] zzk(zzg zzg2) {
        try {
            return zzg2.zzg();
        } catch (RemoteException e10) {
            zza.e(e10, "Unable to call %s on %s.", "getCompactViewActionIndices", zzg.class.getSimpleName());
            return null;
        }
    }

    @RecentlyNullable
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        return null;
    }

    public void onCreate() {
        this.zzo = (NotificationManager) getSystemService("notification");
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        this.zzq = sharedInstance;
        CastMediaOptions castMediaOptions = (CastMediaOptions) Preconditions.checkNotNull(sharedInstance.getCastOptions().getCastMediaOptions());
        this.zzc = (NotificationOptions) Preconditions.checkNotNull(castMediaOptions.getNotificationOptions());
        this.zzd = castMediaOptions.getImagePicker();
        this.zzl = getResources();
        this.zze = new ComponentName(getApplicationContext(), castMediaOptions.getMediaIntentReceiverClassName());
        if (!TextUtils.isEmpty(this.zzc.getTargetActivityClassName())) {
            this.zzf = new ComponentName(getApplicationContext(), this.zzc.getTargetActivityClassName());
        } else {
            this.zzf = null;
        }
        this.zzi = this.zzc.getSkipStepMs();
        int dimensionPixelSize = this.zzl.getDimensionPixelSize(this.zzc.zze());
        this.zzk = new ImageHints(1, dimensionPixelSize, dimensionPixelSize);
        this.zzj = new zzb(getApplicationContext(), this.zzk);
        ComponentName componentName = this.zzf;
        if (componentName != null) {
            registerReceiver(this.zzr, new IntentFilter(componentName.flattenToString()));
        }
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("cast_media_notification", "Cast", 2);
            notificationChannel.setShowBadge(false);
            this.zzo.createNotificationChannel(notificationChannel);
        }
    }

    public void onDestroy() {
        zzb zzb2 = this.zzj;
        if (zzb2 != null) {
            zzb2.zza();
        }
        if (this.zzf != null) {
            try {
                unregisterReceiver(this.zzr);
            } catch (IllegalArgumentException e10) {
                zza.e(e10, "Unregistering trampoline BroadcastReceiver failed", new Object[0]);
            }
        }
        zzb = null;
        this.zzo.cancel(1);
    }

    public int onStartCommand(@RecentlyNonNull Intent intent, int i10, int i11) {
        boolean z10;
        WebImage webImage;
        zzn zzn2;
        Intent intent2 = intent;
        MediaInfo mediaInfo = (MediaInfo) Preconditions.checkNotNull((MediaInfo) intent2.getParcelableExtra("extra_media_info"));
        MediaMetadata mediaMetadata = (MediaMetadata) Preconditions.checkNotNull(mediaInfo.getMetadata());
        int intExtra = intent2.getIntExtra("extra_remote_media_client_player_state", 0);
        CastDevice castDevice = (CastDevice) Preconditions.checkNotNull((CastDevice) intent2.getParcelableExtra("extra_cast_device"));
        if (intExtra == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzn zzn3 = new zzn(z10, mediaInfo.getStreamType(), mediaMetadata.getString(MediaMetadata.KEY_TITLE), castDevice.getFriendlyName(), (MediaSessionCompat.Token) intent2.getParcelableExtra("extra_media_session_token"), intent2.getBooleanExtra("extra_can_skip_next", false), intent2.getBooleanExtra("extra_can_skip_prev", false));
        if (intent2.getBooleanExtra("extra_media_notification_force_update", false) || (zzn2 = this.zzm) == null || zzn3.zzb != zzn2.zzb || zzn3.zzc != zzn2.zzc || !CastUtils.zzh(zzn3.zzd, zzn2.zzd) || !CastUtils.zzh(zzn3.zze, zzn2.zze) || zzn3.zzf != zzn2.zzf || zzn3.zzg != zzn2.zzg) {
            this.zzm = zzn3;
            zzj();
        }
        ImagePicker imagePicker = this.zzd;
        if (imagePicker != null) {
            webImage = imagePicker.onPickImage(mediaMetadata, this.zzk);
        } else if (mediaMetadata.hasImages()) {
            webImage = mediaMetadata.getImages().get(0);
        } else {
            webImage = null;
        }
        zzo zzo2 = new zzo(webImage);
        zzo zzo3 = this.zzn;
        if (zzo3 == null || !CastUtils.zzh(zzo2.zza, zzo3.zza)) {
            this.zzj.zzc(new zzm(this, zzo2));
            this.zzj.zzd(zzo2.zza);
        }
        startForeground(1, this.zzp);
        zzb = new zzk(this, i11);
        return 2;
    }
}
