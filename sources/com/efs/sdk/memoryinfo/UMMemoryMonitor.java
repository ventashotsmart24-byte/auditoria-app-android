package com.efs.sdk.memoryinfo;

public class UMMemoryMonitor {
    private static final d F = new d();

    private UMMemoryMonitor() {
    }

    public static UMMemoryMonitorApi get() {
        return F;
    }
}
