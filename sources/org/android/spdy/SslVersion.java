package org.android.spdy;

public enum SslVersion {
    SLIGHT_VERSION_V1(0);
    
    private int code;

    private SslVersion(int i10) {
        this.code = i10;
    }

    public int getint() {
        return this.code;
    }
}
