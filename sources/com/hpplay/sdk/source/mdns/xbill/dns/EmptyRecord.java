package com.hpplay.sdk.source.mdns.xbill.dns;

class EmptyRecord extends Record {
    private static final long serialVersionUID = 3601852050646429582L;

    public Record getObject() {
        return new EmptyRecord();
    }

    public void rdataFromString(Tokenizer tokenizer, Name name) {
    }

    public void rrFromWire(DNSInput dNSInput) {
    }

    public String rrToString() {
        return "";
    }

    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
    }
}
