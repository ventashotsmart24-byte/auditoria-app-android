package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaw<T extends Session> extends zzam {
    private final SessionManagerListener<T> zza;
    private final Class<T> zzb;

    public zzaw(SessionManagerListener<T> sessionManagerListener, Class<T> cls) {
        this.zza = sessionManagerListener;
        this.zzb = cls;
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionEnded((Session) this.zzb.cast(session), i10);
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionEnding((Session) this.zzb.cast(session));
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionResumeFailed((Session) this.zzb.cast(session), i10);
        }
    }

    public final void zzf(IObjectWrapper iObjectWrapper, boolean z10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionResumed((Session) this.zzb.cast(session), z10);
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, String str) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionResuming((Session) this.zzb.cast(session), str);
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionStartFailed((Session) this.zzb.cast(session), i10);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionStarted((Session) this.zzb.cast(session), str);
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionStarting((Session) this.zzb.cast(session));
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, int i10) {
        SessionManagerListener<T> sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionSuspended((Session) this.zzb.cast(session), i10);
        }
    }
}
