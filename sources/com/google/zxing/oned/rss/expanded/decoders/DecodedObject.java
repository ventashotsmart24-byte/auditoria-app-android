package com.google.zxing.oned.rss.expanded.decoders;

abstract class DecodedObject {
    private final int newPosition;

    public DecodedObject(int i10) {
        this.newPosition = i10;
    }

    public final int getNewPosition() {
        return this.newPosition;
    }
}
