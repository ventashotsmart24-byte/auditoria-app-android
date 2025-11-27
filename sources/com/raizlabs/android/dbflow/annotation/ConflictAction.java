package com.raizlabs.android.dbflow.annotation;

public enum ConflictAction {
    NONE,
    ROLLBACK,
    ABORT,
    FAIL,
    IGNORE,
    REPLACE;

    /* renamed from: com.raizlabs.android.dbflow.annotation.ConflictAction$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.raizlabs.android.dbflow.annotation.ConflictAction[] r0 = com.raizlabs.android.dbflow.annotation.ConflictAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction = r0
                com.raizlabs.android.dbflow.annotation.ConflictAction r1 = com.raizlabs.android.dbflow.annotation.ConflictAction.ROLLBACK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction     // Catch:{ NoSuchFieldError -> 0x001d }
                com.raizlabs.android.dbflow.annotation.ConflictAction r1 = com.raizlabs.android.dbflow.annotation.ConflictAction.ABORT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.raizlabs.android.dbflow.annotation.ConflictAction r1 = com.raizlabs.android.dbflow.annotation.ConflictAction.FAIL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.raizlabs.android.dbflow.annotation.ConflictAction r1 = com.raizlabs.android.dbflow.annotation.ConflictAction.IGNORE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction     // Catch:{ NoSuchFieldError -> 0x003e }
                com.raizlabs.android.dbflow.annotation.ConflictAction r1 = com.raizlabs.android.dbflow.annotation.ConflictAction.REPLACE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.annotation.ConflictAction.AnonymousClass1.<clinit>():void");
        }
    }

    public static int getSQLiteDatabaseAlgorithmInt(ConflictAction conflictAction) {
        int i10 = AnonymousClass1.$SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction[conflictAction.ordinal()];
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    i11 = 4;
                    if (i10 != 4) {
                        i11 = 5;
                        if (i10 != 5) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i11;
    }
}
