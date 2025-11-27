package com.efs.sdk.pa;

public interface PATraceListener {
    void onAnrTrace();

    void onCheck(boolean z10);

    void onUnexcept(Object obj);
}
