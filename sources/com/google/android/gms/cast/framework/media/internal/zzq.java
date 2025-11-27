package com.google.android.gms.cast.framework.media.internal;

public final class zzq {
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r4.containsKey(r1) != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r1 != 4) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(com.google.android.gms.cast.MediaMetadata r4) {
        /*
            java.lang.String r0 = "com.google.android.gms.cast.metadata.SUBTITLE"
            boolean r1 = r4.containsKey(r0)
            if (r1 != 0) goto L_0x003c
            int r1 = r4.getMediaType()
            r2 = 1
            if (r1 == r2) goto L_0x003a
            r2 = 2
            if (r1 == r2) goto L_0x0037
            r2 = 3
            java.lang.String r3 = "com.google.android.gms.cast.metadata.ARTIST"
            if (r1 == r2) goto L_0x001d
            r2 = 4
            if (r1 == r2) goto L_0x001b
            goto L_0x003c
        L_0x001b:
            r0 = r3
            goto L_0x003c
        L_0x001d:
            boolean r1 = r4.containsKey(r3)
            if (r1 == 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            java.lang.String r1 = "com.google.android.gms.cast.metadata.ALBUM_ARTIST"
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto L_0x002e
        L_0x002c:
            r0 = r1
            goto L_0x003c
        L_0x002e:
            java.lang.String r1 = "com.google.android.gms.cast.metadata.COMPOSER"
            boolean r2 = r4.containsKey(r1)
            if (r2 == 0) goto L_0x003c
            goto L_0x002c
        L_0x0037:
            java.lang.String r0 = "com.google.android.gms.cast.metadata.SERIES_TITLE"
            goto L_0x003c
        L_0x003a:
            java.lang.String r0 = "com.google.android.gms.cast.metadata.STUDIO"
        L_0x003c:
            java.lang.String r4 = r4.getString(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.internal.zzq.zza(com.google.android.gms.cast.MediaMetadata):java.lang.String");
    }
}
