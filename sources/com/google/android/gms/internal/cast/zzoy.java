package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzov;
import com.google.android.gms.internal.cast.zzoy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzoy<MessageType extends zzoy<MessageType, BuilderType>, BuilderType extends zzov<MessageType, BuilderType>> extends zznr<MessageType, BuilderType> {
    private static final Map<Object, zzoy<?, ?>> zzb = new ConcurrentHashMap();
    protected zzre zzc = zzre.zzc();
    protected int zzd = -1;

    public static <T extends zzoy> void zzA(Class<T> cls, T t10) {
        zzb.put(cls, t10);
    }

    public static <T extends zzoy> T zzt(Class<T> cls) {
        Map<Object, zzoy<?, ?>> map = zzb;
        T t10 = (zzoy) map.get(cls);
        if (t10 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t10 = (zzoy) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (t10 == null) {
            t10 = (zzoy) ((zzoy) zzrn.zze(cls)).zzb(6, (Object) null, (Object) null);
            if (t10 != null) {
                map.put(cls, t10);
            } else {
                throw new IllegalStateException();
            }
        }
        return t10;
    }

    public static zzpd zzu() {
        return zzoz.zze();
    }

    public static zzpf zzv() {
        return zzpt.zze();
    }

    public static <E> zzpg<E> zzw() {
        return zzqn.zzd();
    }

    public static Object zzy(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static Object zzz(zzqe zzqe, String str, Object[] objArr) {
        return new zzqo(zzqe, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzqm.zza().zzb(getClass()).zze(this, (zzoy) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.zza;
        if (i10 != 0) {
            return i10;
        }
        int zzb2 = zzqm.zza().zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        return zzqg.zza(this, super.toString());
    }

    public final void zzB(zzol zzol) {
        zzqm.zza().zzb(getClass()).zzi(this, zzom.zza(zzol));
    }

    public abstract Object zzb(int i10, Object obj, Object obj2);

    public final int zzn() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzp(int i10) {
        this.zzd = i10;
    }

    public final int zzq() {
        int i10 = this.zzd;
        if (i10 != -1) {
            return i10;
        }
        int zza = zzqm.zza().zzb(getClass()).zza(this);
        this.zzd = zza;
        return zza;
    }

    public final <MessageType extends zzoy<MessageType, BuilderType>, BuilderType extends zzov<MessageType, BuilderType>> BuilderType zzr() {
        return (zzov) zzb(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzqe zzs() {
        return (zzoy) zzb(6, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzqd zzx() {
        zzov zzov = (zzov) zzb(5, (Object) null, (Object) null);
        zzov.zzo(this);
        return zzov;
    }
}
