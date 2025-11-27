package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzov;
import com.google.android.gms.internal.cast.zzoy;

public class zzov<MessageType extends zzoy<MessageType, BuilderType>, BuilderType extends zzov<MessageType, BuilderType>> extends zznq<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    public zzov(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzoy) messagetype.zzb(4, (Object) null, (Object) null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzqm.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    public final /* synthetic */ zznq zzl(zznr zznr) {
        zzo((zzoy) zznr);
        return this;
    }

    /* renamed from: zzn */
    public final BuilderType zzk() {
        BuilderType buildertype = (zzov) this.zzc.zzb(5, (Object) null, (Object) null);
        buildertype.zzo(zzr());
        return buildertype;
    }

    public final BuilderType zzo(MessageType messagetype) {
        if (this.zzb) {
            zzt();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final MessageType zzp() {
        MessageType messagetype;
        MessageType zzq = zzr();
        boolean z10 = true;
        byte byteValue = ((Byte) zzq.zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue != 1) {
            if (byteValue == 0) {
                z10 = false;
            } else {
                boolean zzf = zzqm.zza().zzb(zzq.getClass()).zzf(zzq);
                if (true != zzf) {
                    messagetype = null;
                } else {
                    messagetype = zzq;
                }
                zzq.zzb(2, messagetype, (Object) null);
                z10 = zzf;
            }
        }
        if (z10) {
            return zzq;
        }
        throw new zzrc(zzq);
    }

    /* renamed from: zzq */
    public MessageType zzr() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzqm.zza().zzb(messagetype.getClass()).zzc(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final /* synthetic */ zzqe zzs() {
        return this.zzc;
    }

    public void zzt() {
        MessageType messagetype = (zzoy) this.zza.zzb(4, (Object) null, (Object) null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }
}
