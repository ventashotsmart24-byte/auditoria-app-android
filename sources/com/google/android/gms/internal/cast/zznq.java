package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zznq;
import com.google.android.gms.internal.cast.zznr;

public abstract class zznq<MessageType extends zznr<MessageType, BuilderType>, BuilderType extends zznq<MessageType, BuilderType>> implements zzqd {
    /* renamed from: zzk */
    public abstract BuilderType clone();

    public abstract BuilderType zzl(MessageType messagetype);

    public final /* bridge */ /* synthetic */ zzqd zzm(zzqe zzqe) {
        if (zzs().getClass().isInstance(zzqe)) {
            return zzl((zznr) zzqe);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
