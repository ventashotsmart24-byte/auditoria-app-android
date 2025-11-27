package com.hpplay.component.common.nfc;

public interface INFCController {
    public static final int TYPE_NDEF = 1;

    INFCHandle CreateHandler(int i10);
}
