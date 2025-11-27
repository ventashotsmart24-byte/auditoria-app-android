package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzkf<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzio<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmp zzc = zzmp.zzc();
    private int zzd = -1;

    private final int zza(zzlx zzlx) {
        if (zzlx == null) {
            return zzlu.zza().zzb(getClass()).zza(this);
        }
        return zzlx.zza(this);
    }

    public static zzkk zzbB() {
        return zzkg.zzf();
    }

    public static zzkl zzbC() {
        return zzlb.zzf();
    }

    public static zzkl zzbD(zzkl zzkl) {
        int i10;
        int size = zzkl.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        return zzkl.zze(i10);
    }

    public static zzkm zzbE() {
        return zzlv.zze();
    }

    public static zzkm zzbF(zzkm zzkm) {
        int i10;
        int size = zzkm.size();
        if (size == 0) {
            i10 = 10;
        } else {
            i10 = size + size;
        }
        return zzkm.zzd(i10);
    }

    public static Object zzbH(Method method, Object obj, Object... objArr) {
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

    public static Object zzbI(zzlm zzlm, String str, Object[] objArr) {
        return new zzlw(zzlm, str, objArr);
    }

    public static void zzbL(Class cls, zzkf zzkf) {
        zza.put(cls, zzkf);
        zzkf.zzbJ();
    }

    public static zzkf zzbz(Class cls) {
        Map map = zza;
        zzkf zzkf = (zzkf) map.get(cls);
        if (zzkf == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkf = (zzkf) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzkf == null) {
            zzkf = (zzkf) ((zzkf) zzmy.zze(cls)).zzl(6, (Object) null, (Object) null);
            if (zzkf != null) {
                map.put(cls, zzkf);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzkf;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlu.zza().zzb(getClass()).zzj(this, (zzkf) obj);
        }
        return false;
    }

    public final int hashCode() {
        if (zzbO()) {
            return zzbv();
        }
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int zzbv = zzbv();
        this.zzb = zzbv;
        return zzbv;
    }

    public final String toString() {
        return zzlo.zza(this, super.toString());
    }

    public final zzkf zzbA() {
        return (zzkf) zzl(4, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzll zzbG() {
        return (zzkb) zzl(5, (Object) null, (Object) null);
    }

    public final void zzbJ() {
        zzlu.zza().zzb(getClass()).zzf(this);
        zzbK();
    }

    public final void zzbK() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzbM(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final void zzbN(zzjm zzjm) {
        zzlu.zza().zzb(getClass()).zzi(this, zzjn.zza(zzjm));
    }

    public final boolean zzbO() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final /* synthetic */ zzlm zzbS() {
        return (zzkf) zzl(6, (Object) null, (Object) null);
    }

    public final int zzbr(zzlx zzlx) {
        if (zzbO()) {
            int zza2 = zza(zzlx);
            if (zza2 >= 0) {
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int zza3 = zza(zzlx);
        if (zza3 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza3;
            return zza3;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zza3);
    }

    public final int zzbv() {
        return zzlu.zza().zzb(getClass()).zzb(this);
    }

    public final int zzbw() {
        int i10;
        if (zzbO()) {
            i10 = zza((zzlx) null);
            if (i10 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i10);
            }
        } else {
            i10 = this.zzd & Integer.MAX_VALUE;
            if (i10 == Integer.MAX_VALUE) {
                i10 = zza((zzlx) null);
                if (i10 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i10;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i10);
                }
            }
        }
        return i10;
    }

    public final zzkb zzbx() {
        return (zzkb) zzl(5, (Object) null, (Object) null);
    }

    public final zzkb zzby() {
        zzkb zzkb = (zzkb) zzl(5, (Object) null, (Object) null);
        zzkb.zzaA(this);
        return zzkb;
    }

    public abstract Object zzl(int i10, Object obj, Object obj2);
}
