package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONObject;

@Keep
public class MediaIntentReceiver extends BroadcastReceiver {
    @RecentlyNonNull
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    @RecentlyNonNull
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    @RecentlyNonNull
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    @RecentlyNonNull
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    @RecentlyNonNull
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    @RecentlyNonNull
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    @RecentlyNonNull
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    @RecentlyNonNull
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";

    private static RemoteMediaClient getRemoteMediaClient(CastSession castSession) {
        if (castSession == null || !castSession.isConnected()) {
            return null;
        }
        return castSession.getRemoteMediaClient();
    }

    private void seek(CastSession castSession, long j10) {
        RemoteMediaClient remoteMediaClient;
        if (j10 != 0 && (remoteMediaClient = getRemoteMediaClient(castSession)) != null && !remoteMediaClient.isLiveStream() && !remoteMediaClient.isPlayingAd()) {
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() + j10);
        }
    }

    private void togglePlayback(CastSession castSession) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient(castSession);
        if (remoteMediaClient != null) {
            remoteMediaClient.togglePlayback();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r1 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r10).getSessionManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(@androidx.annotation.RecentlyNonNull android.content.Context r10, @androidx.annotation.RecentlyNonNull android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r0 = r11.getAction()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            com.google.android.gms.cast.framework.CastContext r1 = com.google.android.gms.cast.framework.CastContext.getSharedInstance(r10)
            com.google.android.gms.cast.framework.SessionManager r1 = r1.getSessionManager()
            com.google.android.gms.cast.framework.Session r2 = r1.getCurrentSession()
            if (r2 != 0) goto L_0x0016
            return
        L_0x0016:
            int r3 = r0.hashCode()
            r4 = 0
            r5 = 1
            switch(r3) {
                case -1699820260: goto L_0x0066;
                case -945151566: goto L_0x005c;
                case -945080078: goto L_0x0052;
                case -668151673: goto L_0x0048;
                case -124479363: goto L_0x003e;
                case 235550565: goto L_0x0034;
                case 1362116196: goto L_0x002a;
                case 1997055314: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0070
        L_0x0020:
            java.lang.String r3 = "android.intent.action.MEDIA_BUTTON"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 7
            goto L_0x0071
        L_0x002a:
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.FORWARD"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 3
            goto L_0x0071
        L_0x0034:
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 0
            goto L_0x0071
        L_0x003e:
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.DISCONNECT"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 6
            goto L_0x0071
        L_0x0048:
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.STOP_CASTING"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 5
            goto L_0x0071
        L_0x0052:
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.SKIP_PREV"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 2
            goto L_0x0071
        L_0x005c:
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.SKIP_NEXT"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 1
            goto L_0x0071
        L_0x0066:
            java.lang.String r3 = "com.google.android.gms.cast.framework.action.REWIND"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0070
            r3 = 4
            goto L_0x0071
        L_0x0070:
            r3 = -1
        L_0x0071:
            r6 = 0
            java.lang.String r8 = "googlecast-extra_skip_step_ms"
            switch(r3) {
                case 0: goto L_0x00a0;
                case 1: goto L_0x009c;
                case 2: goto L_0x0098;
                case 3: goto L_0x0090;
                case 4: goto L_0x0088;
                case 5: goto L_0x0084;
                case 6: goto L_0x0080;
                case 7: goto L_0x007c;
                default: goto L_0x0078;
            }
        L_0x0078:
            r9.onReceiveOtherAction(r10, r0, r11)
            return
        L_0x007c:
            r9.onReceiveActionMediaButton(r2, r11)
            return
        L_0x0080:
            r1.endCurrentSession(r4)
            return
        L_0x0084:
            r1.endCurrentSession(r5)
            return
        L_0x0088:
            long r10 = r11.getLongExtra(r8, r6)
            r9.onReceiveActionRewind(r2, r10)
            return
        L_0x0090:
            long r10 = r11.getLongExtra(r8, r6)
            r9.onReceiveActionForward(r2, r10)
            return
        L_0x0098:
            r9.onReceiveActionSkipPrev(r2)
            return
        L_0x009c:
            r9.onReceiveActionSkipNext(r2)
            return
        L_0x00a0:
            r9.onReceiveActionTogglePlayback(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.MediaIntentReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    public void onReceiveActionForward(@RecentlyNonNull Session session, long j10) {
        if (session instanceof CastSession) {
            seek((CastSession) session, j10);
        }
    }

    public void onReceiveActionMediaButton(@RecentlyNonNull Session session, @RecentlyNonNull Intent intent) {
        KeyEvent keyEvent;
        if ((session instanceof CastSession) && intent.hasExtra("android.intent.extra.KEY_EVENT") && (keyEvent = (KeyEvent) ((Bundle) Preconditions.checkNotNull(intent.getExtras())).get("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85) {
            togglePlayback((CastSession) session);
        }
    }

    public void onReceiveActionRewind(@RecentlyNonNull Session session, long j10) {
        if (session instanceof CastSession) {
            seek((CastSession) session, -j10);
        }
    }

    public void onReceiveActionSkipNext(@RecentlyNonNull Session session) {
        RemoteMediaClient remoteMediaClient;
        if ((session instanceof CastSession) && (remoteMediaClient = getRemoteMediaClient((CastSession) session)) != null && !remoteMediaClient.isPlayingAd()) {
            remoteMediaClient.queueNext((JSONObject) null);
        }
    }

    public void onReceiveActionSkipPrev(@RecentlyNonNull Session session) {
        RemoteMediaClient remoteMediaClient;
        if ((session instanceof CastSession) && (remoteMediaClient = getRemoteMediaClient((CastSession) session)) != null && !remoteMediaClient.isPlayingAd()) {
            remoteMediaClient.queuePrev((JSONObject) null);
        }
    }

    public void onReceiveActionTogglePlayback(@RecentlyNonNull Session session) {
        if (session instanceof CastSession) {
            togglePlayback((CastSession) session);
        }
    }

    public void onReceiveOtherAction(Context context, @RecentlyNonNull String str, @RecentlyNonNull Intent intent) {
    }

    @Deprecated
    public void onReceiveOtherAction(@RecentlyNonNull String str, @RecentlyNonNull Intent intent) {
        onReceiveOtherAction((Context) null, str, intent);
    }
}
