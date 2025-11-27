package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import com.taobao.accs.common.Constants;
import java.security.PublicKey;

abstract class KEYBase extends Record {
    private static final long serialVersionUID = 3469321722693285454L;
    protected int alg;
    protected int flags;
    protected int footprint = -1;
    protected byte[] key;
    protected int proto;
    protected PublicKey publicKey = null;

    public KEYBase() {
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFootprint() {
        int i10;
        byte b10;
        int i11 = this.footprint;
        if (i11 >= 0) {
            return i11;
        }
        DNSOutput dNSOutput = new DNSOutput();
        int i12 = 0;
        rrToWire(dNSOutput, (Compression) null, false);
        byte[] byteArray = dNSOutput.toByteArray();
        if (this.alg == 1) {
            byte b11 = byteArray[byteArray.length - 3] & UnsignedBytes.MAX_VALUE;
            b10 = byteArray[byteArray.length - 2] & UnsignedBytes.MAX_VALUE;
            i10 = b11 << 8;
        } else {
            i10 = 0;
            while (i12 < byteArray.length - 1) {
                i10 += ((byteArray[i12] & UnsignedBytes.MAX_VALUE) << 8) + (byteArray[i12 + 1] & UnsignedBytes.MAX_VALUE);
                i12 += 2;
            }
            if (i12 < byteArray.length) {
                i10 += (byteArray[i12] & UnsignedBytes.MAX_VALUE) << 8;
            }
            b10 = (i10 >> 16) & UnsignedBytes.MAX_VALUE;
        }
        int i13 = (i10 + b10) & Message.MAXLENGTH;
        this.footprint = i13;
        return i13;
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getProtocol() {
        return this.proto;
    }

    public PublicKey getPublicKey() {
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 != null) {
            return publicKey2;
        }
        PublicKey publicKey3 = DNSSEC.toPublicKey(this);
        this.publicKey = publicKey3;
        return publicKey3;
    }

    public void rrFromWire(DNSInput dNSInput) {
        this.flags = dNSInput.readU16();
        this.proto = dNSInput.readU8();
        this.alg = dNSInput.readU8();
        if (dNSInput.remaining() > 0) {
            this.key = dNSInput.readByteArray();
        }
    }

    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.flags);
        stringBuffer.append(" ");
        stringBuffer.append(this.proto);
        stringBuffer.append(" ");
        stringBuffer.append(this.alg);
        if (this.key != null) {
            if (Options.check("multiline")) {
                stringBuffer.append(" (\n");
                stringBuffer.append(base64.formatString(this.key, 64, HTTP.TAB, true));
                stringBuffer.append(" ; key_tag = ");
                stringBuffer.append(getFootprint());
            } else {
                stringBuffer.append(" ");
                stringBuffer.append(base64.toString(this.key));
            }
        }
        return stringBuffer.toString();
    }

    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        dNSOutput.writeU16(this.flags);
        dNSOutput.writeU8(this.proto);
        dNSOutput.writeU8(this.alg);
        byte[] bArr = this.key;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    public KEYBase(Name name, int i10, int i11, long j10, int i12, int i13, int i14, byte[] bArr) {
        super(name, i10, i11, j10);
        this.flags = Record.checkU16(Constants.KEY_FLAGS, i12);
        this.proto = Record.checkU8("proto", i13);
        this.alg = Record.checkU8("alg", i14);
        this.key = bArr;
    }
}
