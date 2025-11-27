package com.google.android.gms.internal.cast;

public abstract class zzr extends zzb implements zzs {
    public zzr() {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x00a4;
                case 2: goto L_0x0091;
                case 3: goto L_0x0082;
                case 4: goto L_0x006b;
                case 5: goto L_0x0060;
                case 6: goto L_0x0058;
                case 7: goto L_0x004c;
                case 8: goto L_0x003c;
                case 9: goto L_0x0030;
                case 10: goto L_0x0025;
                case 11: goto L_0x001d;
                case 12: goto L_0x0011;
                case 13: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            int r2 = r3.readInt()
            r1.zzj(r2)
            r4.writeNoException()
            goto L_0x00ce
        L_0x0011:
            boolean r2 = r1.zzk()
            r4.writeNoException()
            com.google.android.gms.internal.cast.zzc.zzb(r4, r2)
            goto L_0x00ce
        L_0x001d:
            r1.zzf()
            r4.writeNoException()
            goto L_0x00ce
        L_0x0025:
            r4.writeNoException()
            r2 = 12451000(0xbdfcb8, float:1.7447567E-38)
            r4.writeInt(r2)
            goto L_0x00ce
        L_0x0030:
            java.lang.String r2 = r1.zzc()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x00ce
        L_0x003c:
            java.lang.String r2 = r3.readString()
            android.os.Bundle r2 = r1.zzb(r2)
            r4.writeNoException()
            com.google.android.gms.internal.cast.zzc.zzd(r4, r2)
            goto L_0x00ce
        L_0x004c:
            boolean r2 = r1.zzl()
            r4.writeNoException()
            com.google.android.gms.internal.cast.zzc.zzb(r4, r2)
            goto L_0x00ce
        L_0x0058:
            r1.zzh()
            r4.writeNoException()
            goto L_0x00ce
        L_0x0060:
            java.lang.String r2 = r3.readString()
            r1.zzi(r2)
            r4.writeNoException()
            goto L_0x00ce
        L_0x006b:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.cast.zzc.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            int r3 = r3.readInt()
            boolean r2 = r1.zzm(r2, r3)
            r4.writeNoException()
            com.google.android.gms.internal.cast.zzc.zzb(r4, r2)
            goto L_0x00ce
        L_0x0082:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.cast.zzc.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            r1.zzg(r2)
            r4.writeNoException()
            goto L_0x00ce
        L_0x0091:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.cast.zzc.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            int r3 = r3.readInt()
            r1.zzd(r2, r3)
            r4.writeNoException()
            goto L_0x00ce
        L_0x00a4:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.cast.zzc.zza(r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x00b4
            r3 = 0
            goto L_0x00c8
        L_0x00b4:
            java.lang.String r5 = "com.google.android.gms.cast.framework.internal.IMediaRouterCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzu
            if (r0 == 0) goto L_0x00c2
            r3 = r5
            com.google.android.gms.internal.cast.zzu r3 = (com.google.android.gms.internal.cast.zzu) r3
            goto L_0x00c8
        L_0x00c2:
            com.google.android.gms.internal.cast.zzt r5 = new com.google.android.gms.internal.cast.zzt
            r5.<init>(r3)
            r3 = r5
        L_0x00c8:
            r1.zze(r2, r3)
            r4.writeNoException()
        L_0x00ce:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzr.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
