package com.hpplay.glide.load;

public enum DecodeFormat {
    ALWAYS_ARGB_8888,
    PREFER_ARGB_8888,
    PREFER_RGB_565;
    
    public static final DecodeFormat DEFAULT = null;

    /* access modifiers changed from: public */
    static {
        DecodeFormat decodeFormat;
        DEFAULT = decodeFormat;
    }
}
