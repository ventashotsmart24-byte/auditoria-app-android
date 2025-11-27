package com.google.android.gms.internal.cast;

public enum zzrs {
    DOUBLE(zzrt.DOUBLE, 1),
    FLOAT(zzrt.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzrt.BOOLEAN, 0),
    STRING(zzrt.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzrt.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzrt.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzrt zzt;

    private zzrs(zzrt zzrt, int i10) {
        this.zzt = zzrt;
    }

    public final zzrt zza() {
        return this.zzt;
    }
}
