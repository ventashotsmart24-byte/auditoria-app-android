package com.hpplay.sdk.source.api;

public enum BleState {
    BLE_ADVERTISE_SUPPORTED(0),
    BLE_ADVERTISE_NO_SUPPORT_ANDROID_SDK_LOWER(1),
    BLE_ADVERTISE_NO_SUPPORT_BT_DEVICE(2),
    BLE_ADVERTISE_NO_SUPPORT_BLE_DEVICE(3),
    BLE_ADVERTISE_PERMISSION_DENIED(4),
    BLE_ADVERTISE_BT_TURNED_OFF(5),
    BLE_ADVERTISE_NOT_SET_ENABLE(6),
    BLE_ADVERTISE_PUBLISH_SUCCESS(10),
    BLE_ADVERTISE_FAILED_DATA_TOO_LARGE(11),
    BLE_ADVERTISE_FAILED_TOO_MANY_ADVERTISERS(12),
    BLE_ADVERTISE_FAILED_ALREADY_STARTED(13),
    BLE_ADVERTISE_FAILED_INTERNAL_ERROR(14),
    BLE_ADVERTISE_FAILED_FEATURE_UNSUPPORTED(15),
    BLE_ADVERTISE_UNKNOWN_ERROR(99);
    
    private int value;

    /* renamed from: com.hpplay.sdk.source.api.BleState$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hpplay$sdk$source$api$BleState = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hpplay.sdk.source.api.BleState[] r0 = com.hpplay.sdk.source.api.BleState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$hpplay$sdk$source$api$BleState = r0
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_NO_SUPPORT_ANDROID_SDK_LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_NO_SUPPORT_BT_DEVICE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_NO_SUPPORT_BLE_DEVICE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_PERMISSION_DENIED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_BT_TURNED_OFF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_UNKNOWN_ERROR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_PUBLISH_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x006c }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_FAILED_DATA_TOO_LARGE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_FAILED_TOO_MANY_ADVERTISERS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_FAILED_ALREADY_STARTED     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_FAILED_INTERNAL_ERROR     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x009c }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_FAILED_FEATURE_UNSUPPORTED     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$hpplay$sdk$source$api$BleState     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.hpplay.sdk.source.api.BleState r1 = com.hpplay.sdk.source.api.BleState.BLE_ADVERTISE_NOT_SET_ENABLE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.api.BleState.AnonymousClass1.<clinit>():void");
        }
    }

    private BleState(int i10) {
        this.value = i10;
    }

    public static BleState getByValue(int i10) {
        for (BleState bleState : values()) {
            if (bleState.value() == i10) {
                return bleState;
            }
        }
        return null;
    }

    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$hpplay$sdk$source$api$BleState[ordinal()]) {
            case 1:
                return "BLE_ADVERTISE_SUPPORTED";
            case 2:
                return "BLE_ADVERTISE_NO_SUPPORT_ANDROID_SDK_LOWER";
            case 3:
                return "BLE_ADVERTISE_NO_SUPPORT_BT_DEVICE";
            case 4:
                return "BLE_ADVERTISE_NO_SUPPORT_BLE_DEVICE";
            case 5:
                return "BLE_ADVERTISE_PERMISSION_DENIED";
            case 6:
                return "BLE_ADVERTISE_BT_TURNED_OFF";
            case 7:
                return "BLE_ADVERTISE_UNKNOWN_ERROR";
            case 8:
                return "BLE_ADVERTISE_PUBLISH_SUCCESS";
            case 9:
                return "BLE_ADVERTISE_FAILED_DATA_TOO_LARGE";
            case 10:
                return "BLE_ADVERTISE_FAILED_TOO_MANY_ADVERTISERS";
            case 11:
                return "BLE_ADVERTISE_FAILED_ALREADY_STARTED";
            case 12:
                return "BLE_ADVERTISE_FAILED_INTERNAL_ERROR";
            case 13:
                return "BLE_ADVERTISE_FAILED_FEATURE_UNSUPPORTED";
            case 14:
                return "BLE_ADVERTISE_NOT_SET_ENABLE";
            default:
                return "";
        }
    }

    public int value() {
        return this.value;
    }
}
