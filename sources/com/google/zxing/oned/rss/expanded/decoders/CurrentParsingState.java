package com.google.zxing.oned.rss.expanded.decoders;

final class CurrentParsingState {
    private State encoding = State.NUMERIC;
    private int position = 0;

    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int getPosition() {
        return this.position;
    }

    public void incrementPosition(int i10) {
        this.position += i10;
    }

    public boolean isAlpha() {
        if (this.encoding == State.ALPHA) {
            return true;
        }
        return false;
    }

    public boolean isIsoIec646() {
        if (this.encoding == State.ISO_IEC_646) {
            return true;
        }
        return false;
    }

    public boolean isNumeric() {
        if (this.encoding == State.NUMERIC) {
            return true;
        }
        return false;
    }

    public void setAlpha() {
        this.encoding = State.ALPHA;
    }

    public void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }

    public void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    public void setPosition(int i10) {
        this.position = i10;
    }
}
