package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;

final class zzo implements SessionManagerListener<CastSession> {
    final /* synthetic */ ExpandedControllerActivity zza;

    public /* synthetic */ zzo(ExpandedControllerActivity expandedControllerActivity, zzn zzn) {
        this.zza = expandedControllerActivity;
    }

    public final /* synthetic */ void onSessionEnded(Session session, int i10) {
        CastSession castSession = (CastSession) session;
        this.zza.finish();
    }

    public final /* bridge */ /* synthetic */ void onSessionEnding(Session session) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(Session session, int i10) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z10) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionStartFailed(Session session, int i10) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i10) {
        CastSession castSession = (CastSession) session;
    }
}
