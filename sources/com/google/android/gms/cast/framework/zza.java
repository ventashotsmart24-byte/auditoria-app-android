package com.google.android.gms.cast.framework;

import com.google.android.datatransport.Transformer;
import com.google.android.gms.internal.cast.zzku;
import com.google.android.gms.internal.cast.zzol;
import java.io.IOException;

public final /* synthetic */ class zza implements Transformer {
    public static final /* synthetic */ zza zza = new zza();

    private /* synthetic */ zza() {
    }

    public final Object apply(Object obj) {
        zzku zzku = (zzku) obj;
        try {
            byte[] bArr = new byte[zzku.zzq()];
            zzol zzC = zzol.zzC(bArr);
            zzku.zzB(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e10) {
            String name = zzku.getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e10);
        }
    }
}
