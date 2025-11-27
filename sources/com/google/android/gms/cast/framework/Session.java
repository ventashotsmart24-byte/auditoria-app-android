package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzm;

public abstract class Session {
    private static final Logger zza = new Logger("Session");
    private final zzaj zzb;
    private final zzav zzc;

    public Session(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        zzav zzav = new zzav(this, (zzau) null);
        this.zzc = zzav;
        this.zzb = zzm.zzd(context, str, str2, zzav);
    }

    public abstract void end(boolean z10);

    @RecentlyNullable
    public final String getCategory() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzh();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "getCategory", zzaj.class.getSimpleName());
            }
        }
        return null;
    }

    @RecentlyNullable
    public final String getSessionId() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzi();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "getSessionId", zzaj.class.getSimpleName());
            }
        }
        return null;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return 0;
    }

    public boolean isConnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzp();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "isConnected", zzaj.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isConnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzq();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "isConnecting", zzaj.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isDisconnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzr();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "isDisconnected", zzaj.class.getSimpleName());
            }
        }
        return true;
    }

    public boolean isDisconnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzs();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "isDisconnecting", zzaj.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isResuming() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzt();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "isResuming", zzaj.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isSuspended() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzu();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "isSuspended", zzaj.class.getSimpleName());
            }
        }
        return false;
    }

    public final void notifyFailedToResumeSession(int i10) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzj(i10);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "notifyFailedToResumeSession", zzaj.class.getSimpleName());
            }
        }
    }

    public final void notifyFailedToStartSession(int i10) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzk(i10);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "notifyFailedToStartSession", zzaj.class.getSimpleName());
            }
        }
    }

    public final void notifySessionEnded(int i10) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzl(i10);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "notifySessionEnded", zzaj.class.getSimpleName());
            }
        }
    }

    public final void notifySessionResumed(boolean z10) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzm(z10);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "notifySessionResumed", zzaj.class.getSimpleName());
            }
        }
    }

    public final void notifySessionStarted(@RecentlyNonNull String str) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzn(str);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "notifySessionStarted", zzaj.class.getSimpleName());
            }
        }
    }

    public final void notifySessionSuspended(int i10) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzo(i10);
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "notifySessionSuspended", zzaj.class.getSimpleName());
            }
        }
    }

    public void onResuming(@RecentlyNonNull Bundle bundle) {
    }

    public void onStarting(@RecentlyNonNull Bundle bundle) {
    }

    public abstract void resume(@RecentlyNonNull Bundle bundle);

    public abstract void start(@RecentlyNonNull Bundle bundle);

    public void zzj(@RecentlyNonNull Bundle bundle) {
    }

    public final int zzk() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                if (zzaj.zze() >= 211100000) {
                    return this.zzb.zzf();
                }
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "getSessionStartType", zzaj.class.getSimpleName());
            }
        }
        return 0;
    }

    @RecentlyNullable
    public final IObjectWrapper zzl() {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzg();
            } catch (RemoteException e10) {
                zza.d(e10, "Unable to call %s on %s.", "getWrappedObject", zzaj.class.getSimpleName());
            }
        }
        return null;
    }
}
