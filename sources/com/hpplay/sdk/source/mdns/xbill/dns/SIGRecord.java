package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.Date;

public class SIGRecord extends SIGBase {
    private static final long serialVersionUID = 4963556060953589058L;

    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    public /* bridge */ /* synthetic */ Date getExpire() {
        return super.getExpire();
    }

    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    public /* bridge */ /* synthetic */ int getLabels() {
        return super.getLabels();
    }

    public Record getObject() {
        return new SIGRecord();
    }

    public /* bridge */ /* synthetic */ long getOrigTTL() {
        return super.getOrigTTL();
    }

    public /* bridge */ /* synthetic */ Name getSigner() {
        return super.getSigner();
    }

    public /* bridge */ /* synthetic */ Date getTimeSigned() {
        return super.getTimeSigned();
    }

    public /* bridge */ /* synthetic */ int getTypeCovered() {
        return super.getTypeCovered();
    }
}
