package com.hpplay.sdk.source.mdns.xbill.dns;

public class UNKRecord extends Record {
    private static final long serialVersionUID = -4193583311594626915L;
    private byte[] data;

    public byte[] getData() {
        return this.data;
    }

    public Record getObject() {
        return new UNKRecord();
    }

    public void rdataFromString(Tokenizer tokenizer, Name name) {
        throw tokenizer.exception("invalid unknown RR encoding");
    }

    public void rrFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    public String rrToString() {
        return Record.unknownToString(this.data);
    }

    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        dNSOutput.writeByteArray(this.data);
    }
}
