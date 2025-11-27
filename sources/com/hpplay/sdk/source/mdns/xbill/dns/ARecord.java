package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ARecord extends Record {
    private static final long serialVersionUID = -2172609200849142323L;
    private int addr;

    public ARecord() {
    }

    private static final int fromArray(byte[] bArr) {
        return (bArr[3] & UnsignedBytes.MAX_VALUE) | ((bArr[0] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    private static final byte[] toArray(int i10) {
        return new byte[]{(byte) ((i10 >>> 24) & 255), (byte) ((i10 >>> 16) & 255), (byte) ((i10 >>> 8) & 255), (byte) (i10 & 255)};
    }

    public InetAddress getAddress() {
        try {
            Name name = this.name;
            if (name == null) {
                return InetAddress.getByAddress(toArray(this.addr));
            }
            return InetAddress.getByAddress(name.toString(), toArray(this.addr));
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    public Record getObject() {
        return new ARecord();
    }

    public void rdataFromString(Tokenizer tokenizer, Name name) {
        this.addr = fromArray(tokenizer.getAddressBytes(1));
    }

    public void rrFromWire(DNSInput dNSInput) {
        this.addr = fromArray(dNSInput.readByteArray(4));
    }

    public String rrToString() {
        return Address.toDottedQuad(toArray(this.addr));
    }

    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        dNSOutput.writeU32(((long) this.addr) & 4294967295L);
    }

    public ARecord(Name name, int i10, long j10, InetAddress inetAddress) {
        super(name, 1, i10, j10);
        if (Address.familyOf(inetAddress) == 1) {
            this.addr = fromArray(inetAddress.getAddress());
            return;
        }
        throw new IllegalArgumentException("invalid IPv4 address");
    }
}
