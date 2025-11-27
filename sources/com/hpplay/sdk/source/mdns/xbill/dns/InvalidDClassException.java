package com.hpplay.sdk.source.mdns.xbill.dns;

public class InvalidDClassException extends IllegalArgumentException {
    public InvalidDClassException(int i10) {
        super("Invalid DNS class: " + i10);
    }
}
