package com.hpplay.sdk.source.browse.api;

public class DeprecatedParceResultListenerWrapper implements IServiceInfoParseListener {
    private final IParceResultListener mParceResultListener;

    public DeprecatedParceResultListenerWrapper(IParceResultListener iParceResultListener) {
        this.mParceResultListener = iParceResultListener;
    }

    public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
        IParceResultListener iParceResultListener = this.mParceResultListener;
        if (iParceResultListener != null) {
            iParceResultListener.onParceResult(i10, lelinkServiceInfo);
        }
    }
}
