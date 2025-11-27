package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.Date;

public class RRSIGRecord extends SIGBase {
    private static final long serialVersionUID = -2609150673537226317L;

    public RRSIGRecord() {
    }

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
        return new RRSIGRecord();
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

    public RRSIGRecord(Name name, int i10, long j10, int i11, int i12, long j11, Date date, Date date2, int i13, Name name2, byte[] bArr) {
        super(name, 46, i10, j10, i11, i12, j11, date, date2, i13, name2, bArr);
    }
}
