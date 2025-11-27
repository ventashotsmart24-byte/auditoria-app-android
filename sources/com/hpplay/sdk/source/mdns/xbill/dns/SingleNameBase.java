package com.hpplay.sdk.source.mdns.xbill.dns;

abstract class SingleNameBase extends Record {
    private static final long serialVersionUID = -18595042501413L;
    protected Name singleName;

    public SingleNameBase() {
    }

    public Name getSingleName() {
        return this.singleName;
    }

    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.singleName = tokenizer.getName(name);
    }

    public void rrFromWire(DNSInput dNSInput) {
        this.singleName = new Name(dNSInput);
    }

    public String rrToString() {
        return this.singleName.toString();
    }

    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        this.singleName.toWire(dNSOutput, (Compression) null, z10);
    }

    public SingleNameBase(Name name, int i10, int i11, long j10, Name name2, String str) {
        super(name, i10, i11, j10);
        this.singleName = Record.checkName(str, name2);
    }
}
