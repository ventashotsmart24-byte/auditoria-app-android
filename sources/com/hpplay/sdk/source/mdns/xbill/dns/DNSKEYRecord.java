package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.xbill.dns.DNSSEC;
import java.security.PublicKey;

public class DNSKEYRecord extends KEYBase {
    private static final long serialVersionUID = -8679800040426675002L;

    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    public /* bridge */ /* synthetic */ int getFlags() {
        return super.getFlags();
    }

    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    public /* bridge */ /* synthetic */ byte[] getKey() {
        return super.getKey();
    }

    public Record getObject() {
        return new DNSKEYRecord();
    }

    public /* bridge */ /* synthetic */ int getProtocol() {
        return super.getProtocol();
    }

    public /* bridge */ /* synthetic */ PublicKey getPublicKey() {
        return super.getPublicKey();
    }

    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.flags = tokenizer.getUInt16();
        this.proto = tokenizer.getUInt8();
        String string = tokenizer.getString();
        int value = DNSSEC.Algorithm.value(string);
        this.alg = value;
        if (value >= 0) {
            this.key = tokenizer.getBase64();
            return;
        }
        throw tokenizer.exception("Invalid algorithm: " + string);
    }
}
