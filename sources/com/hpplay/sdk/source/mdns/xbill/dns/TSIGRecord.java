package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Date;

public class TSIGRecord extends Record {
    private static final long serialVersionUID = -88820909016649306L;
    private Name alg;
    private int error;
    private int fudge;
    private int originalID;
    private byte[] other;
    private byte[] signature;
    private Date timeSigned;

    public TSIGRecord() {
    }

    public Name getAlgorithm() {
        return this.alg;
    }

    public int getError() {
        return this.error;
    }

    public int getFudge() {
        return this.fudge;
    }

    public Record getObject() {
        return new TSIGRecord();
    }

    public int getOriginalID() {
        return this.originalID;
    }

    public byte[] getOther() {
        return this.other;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public Date getTimeSigned() {
        return this.timeSigned;
    }

    public void rdataFromString(Tokenizer tokenizer, Name name) {
        throw tokenizer.exception("no text format defined for TSIG");
    }

    public void rrFromWire(DNSInput dNSInput) {
        this.alg = new Name(dNSInput);
        this.timeSigned = new Date(((((long) dNSInput.readU16()) << 32) + dNSInput.readU32()) * 1000);
        this.fudge = dNSInput.readU16();
        this.signature = dNSInput.readByteArray(dNSInput.readU16());
        this.originalID = dNSInput.readU16();
        this.error = dNSInput.readU16();
        int readU16 = dNSInput.readU16();
        if (readU16 > 0) {
            this.other = dNSInput.readByteArray(readU16);
        } else {
            this.other = null;
        }
    }

    public String rrToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.alg);
        stringBuffer.append(" ");
        if (Options.check("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(this.timeSigned.getTime() / 1000);
        stringBuffer.append(" ");
        stringBuffer.append(this.fudge);
        stringBuffer.append(" ");
        stringBuffer.append(this.signature.length);
        if (Options.check("multiline")) {
            stringBuffer.append("\n");
            stringBuffer.append(base64.formatString(this.signature, 64, HTTP.TAB, false));
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(base64.toString(this.signature));
        }
        stringBuffer.append(" ");
        stringBuffer.append(Rcode.TSIGstring(this.error));
        stringBuffer.append(" ");
        byte[] bArr = this.other;
        if (bArr == null) {
            stringBuffer.append(0);
        } else {
            stringBuffer.append(bArr.length);
            if (Options.check("multiline")) {
                stringBuffer.append("\n\n\n\t");
            } else {
                stringBuffer.append(" ");
            }
            if (this.error == 18) {
                byte[] bArr2 = this.other;
                if (bArr2.length != 6) {
                    stringBuffer.append("<invalid BADTIME other data>");
                } else {
                    stringBuffer.append("<server time: ");
                    stringBuffer.append(new Date(((((long) (bArr2[0] & UnsignedBytes.MAX_VALUE)) << 40) + (((long) (bArr2[1] & UnsignedBytes.MAX_VALUE)) << 32) + ((long) ((bArr2[2] & UnsignedBytes.MAX_VALUE) << Ascii.CAN)) + ((long) ((bArr2[3] & UnsignedBytes.MAX_VALUE) << 16)) + ((long) ((bArr2[4] & UnsignedBytes.MAX_VALUE) << 8)) + ((long) (bArr2[5] & UnsignedBytes.MAX_VALUE))) * 1000));
                    stringBuffer.append(Operator.Operation.GREATER_THAN);
                }
            } else {
                stringBuffer.append(Operator.Operation.LESS_THAN);
                stringBuffer.append(base64.toString(this.other));
                stringBuffer.append(Operator.Operation.GREATER_THAN);
            }
        }
        if (Options.check("multiline")) {
            stringBuffer.append(" )");
        }
        return stringBuffer.toString();
    }

    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        this.alg.toWire(dNSOutput, (Compression) null, z10);
        long time = this.timeSigned.getTime() / 1000;
        dNSOutput.writeU16((int) (time >> 32));
        dNSOutput.writeU32(time & 4294967295L);
        dNSOutput.writeU16(this.fudge);
        dNSOutput.writeU16(this.signature.length);
        dNSOutput.writeByteArray(this.signature);
        dNSOutput.writeU16(this.originalID);
        dNSOutput.writeU16(this.error);
        byte[] bArr = this.other;
        if (bArr != null) {
            dNSOutput.writeU16(bArr.length);
            dNSOutput.writeByteArray(this.other);
            return;
        }
        dNSOutput.writeU16(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TSIGRecord(Name name, int i10, long j10, Name name2, Date date, int i11, byte[] bArr, int i12, int i13, byte[] bArr2) {
        super(name, 250, i10, j10);
        Name name3 = name2;
        this.alg = Record.checkName("alg", name2);
        this.timeSigned = date;
        int i14 = i11;
        this.fudge = Record.checkU16("fudge", i11);
        this.signature = bArr;
        this.originalID = Record.checkU16("originalID", i12);
        this.error = Record.checkU16("error", i13);
        this.other = bArr2;
    }
}
