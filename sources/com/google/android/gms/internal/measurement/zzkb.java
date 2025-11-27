package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;

public class zzkb<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
    protected zzkf zza;
    private final zzkf zzb;

    public zzkb(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzbO()) {
            this.zza = messagetype.zzbA();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzlu.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final zzkb zzaA(zzkf zzkf) {
        if (!this.zzb.equals(zzkf)) {
            if (!this.zza.zzbO()) {
                zzaH();
            }
            zza(this.zza, zzkf);
        }
        return this;
    }

    public final zzkb zzaB(byte[] bArr, int i10, int i11, zzjr zzjr) {
        if (!this.zza.zzbO()) {
            zzaH();
        }
        try {
            zzlu.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i11, new zzir(zzjr));
            return this;
        } catch (zzkp e10) {
            throw e10;
        } catch (IndexOutOfBoundsException unused) {
            throw zzkp.zzf();
        } catch (IOException e11) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        if (r3 != false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final MessageType zzaC() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.zzkf r0 = r5.zzaE()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.zzl(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L_0x0013
            goto L_0x0030
        L_0x0013:
            if (r3 == 0) goto L_0x0031
            com.google.android.gms.internal.measurement.zzlu r3 = com.google.android.gms.internal.measurement.zzlu.zza()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.measurement.zzlx r3 = r3.zzb(r4)
            boolean r3 = r3.zzk(r0)
            if (r1 == r3) goto L_0x0029
            r1 = r2
            goto L_0x002a
        L_0x0029:
            r1 = r0
        L_0x002a:
            r4 = 2
            r0.zzl(r4, r1, r2)
            if (r3 == 0) goto L_0x0031
        L_0x0030:
            return r0
        L_0x0031:
            com.google.android.gms.internal.measurement.zzmn r1 = new com.google.android.gms.internal.measurement.zzmn
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkb.zzaC():com.google.android.gms.internal.measurement.zzkf");
    }

    /* renamed from: zzaD */
    public MessageType zzaE() {
        if (!this.zza.zzbO()) {
            return this.zza;
        }
        this.zza.zzbJ();
        return this.zza;
    }

    public final void zzaG() {
        if (!this.zza.zzbO()) {
            zzaH();
        }
    }

    public void zzaH() {
        zzkf zzbA = this.zzb.zzbA();
        zza(zzbA, this.zza);
        this.zza = zzbA;
    }

    public final /* bridge */ /* synthetic */ zzin zzav(byte[] bArr, int i10, int i11) {
        zzaB(bArr, 0, i11, zzjr.zza);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzin zzaw(byte[] bArr, int i10, int i11, zzjr zzjr) {
        zzaB(bArr, 0, i11, zzjr);
        return this;
    }

    /* renamed from: zzaz */
    public final zzkb zzau() {
        zzkb zzkb = (zzkb) this.zzb.zzl(5, (Object) null, (Object) null);
        zzkb.zza = zzaE();
        return zzkb;
    }

    public final /* bridge */ /* synthetic */ zzlm zzbS() {
        throw null;
    }
}
