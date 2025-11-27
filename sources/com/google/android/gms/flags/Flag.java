package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
public abstract class Flag<T> {
    private final String mKey;
    private final int zze;
    private final T zzf;

    @Deprecated
    public static class BooleanFlag extends Flag<Boolean> {
        public BooleanFlag(int i10, String str, Boolean bool) {
            super(i10, str, bool);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final Boolean zza(zzc zzc) {
            try {
                return Boolean.valueOf(zzc.getBooleanFlagValue(getKey(), ((Boolean) zzb()).booleanValue(), getSource()));
            } catch (RemoteException unused) {
                return (Boolean) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class IntegerFlag extends Flag<Integer> {
        public IntegerFlag(int i10, String str, Integer num) {
            super(i10, str, num);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzc */
        public final Integer zza(zzc zzc) {
            try {
                return Integer.valueOf(zzc.getIntFlagValue(getKey(), ((Integer) zzb()).intValue(), getSource()));
            } catch (RemoteException unused) {
                return (Integer) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class LongFlag extends Flag<Long> {
        public LongFlag(int i10, String str, Long l10) {
            super(i10, str, l10);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzd */
        public final Long zza(zzc zzc) {
            try {
                return Long.valueOf(zzc.getLongFlagValue(getKey(), ((Long) zzb()).longValue(), getSource()));
            } catch (RemoteException unused) {
                return (Long) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class StringFlag extends Flag<String> {
        public StringFlag(int i10, String str, String str2) {
            super(i10, str, str2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zze */
        public final String zza(zzc zzc) {
            try {
                return zzc.getStringFlagValue(getKey(), (String) zzb(), getSource());
            } catch (RemoteException unused) {
                return (String) zzb();
            }
        }
    }

    private Flag(int i10, String str, T t10) {
        this.zze = i10;
        this.mKey = str;
        this.zzf = t10;
        Singletons.flagRegistry().zza(this);
    }

    @KeepForSdk
    @Deprecated
    public static BooleanFlag define(int i10, String str, Boolean bool) {
        return new BooleanFlag(i10, str, bool);
    }

    @KeepForSdk
    public T get() {
        return Singletons.zzd().zzb(this);
    }

    public final String getKey() {
        return this.mKey;
    }

    @Deprecated
    public final int getSource() {
        return this.zze;
    }

    public abstract T zza(zzc zzc);

    public final T zzb() {
        return this.zzf;
    }

    @KeepForSdk
    @Deprecated
    public static IntegerFlag define(int i10, String str, int i11) {
        return new IntegerFlag(i10, str, Integer.valueOf(i11));
    }

    @KeepForSdk
    @Deprecated
    public static LongFlag define(int i10, String str, long j10) {
        return new LongFlag(i10, str, Long.valueOf(j10));
    }

    @KeepForSdk
    @Deprecated
    public static StringFlag define(int i10, String str, String str2) {
        return new StringFlag(i10, str, str2);
    }
}
