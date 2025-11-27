package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.base.Ascii;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.HMAC;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import java.util.Date;

public class TSIG {
    public static final short FUDGE = 300;
    public static final Name HMAC;
    public static final Name HMAC_MD5;
    public static final Name HMAC_SHA1 = Name.fromConstantString("hmac-sha1.");
    public static final Name HMAC_SHA224 = Name.fromConstantString("hmac-sha224.");
    public static final Name HMAC_SHA256 = Name.fromConstantString("hmac-sha256.");
    public static final Name HMAC_SHA384 = Name.fromConstantString("hmac-sha384.");
    public static final Name HMAC_SHA512 = Name.fromConstantString("hmac-sha512.");
    /* access modifiers changed from: private */
    public Name alg;
    /* access modifiers changed from: private */
    public String digest;
    /* access modifiers changed from: private */
    public int digestBlockLength;
    /* access modifiers changed from: private */
    public byte[] key;
    /* access modifiers changed from: private */
    public Name name;

    public static class StreamVerifier {
        private TSIG key;
        private TSIGRecord lastTSIG;
        private int lastsigned;
        private int nresponses = 0;
        private HMAC verifier;

        public StreamVerifier(TSIG tsig, TSIGRecord tSIGRecord) {
            this.key = tsig;
            this.verifier = new HMAC(tsig.digest, this.key.digestBlockLength, this.key.key);
            this.lastTSIG = tSIGRecord;
        }

        public int verify(Message message, byte[] bArr) {
            int i10;
            int i11;
            boolean z10;
            TSIGRecord tsig = message.getTSIG();
            int i12 = this.nresponses + 1;
            this.nresponses = i12;
            if (i12 == 1) {
                int verify = this.key.verify(message, bArr, this.lastTSIG);
                if (verify == 0) {
                    byte[] signature = tsig.getSignature();
                    DNSOutput dNSOutput = new DNSOutput();
                    dNSOutput.writeU16(signature.length);
                    this.verifier.update(dNSOutput.toByteArray());
                    this.verifier.update(signature);
                }
                this.lastTSIG = tsig;
                return verify;
            }
            if (tsig != null) {
                message.getHeader().decCount(3);
            }
            byte[] wire = message.getHeader().toWire();
            if (tsig != null) {
                message.getHeader().incCount(3);
            }
            this.verifier.update(wire);
            if (tsig == null) {
                i11 = bArr.length;
                i10 = wire.length;
            } else {
                i11 = message.tsigstart;
                i10 = wire.length;
            }
            this.verifier.update(bArr, wire.length, i11 - i10);
            if (tsig != null) {
                this.lastsigned = this.nresponses;
                this.lastTSIG = tsig;
                if (!tsig.getName().equals(this.key.name) || !tsig.getAlgorithm().equals(this.key.alg)) {
                    if (Options.check("verbose")) {
                        System.err.println("BADKEY failure");
                    }
                    message.tsigState = 4;
                    return 17;
                }
                DNSOutput dNSOutput2 = new DNSOutput();
                long time = tsig.getTimeSigned().getTime() / 1000;
                dNSOutput2.writeU16((int) (time >> 32));
                dNSOutput2.writeU32(time & 4294967295L);
                dNSOutput2.writeU16(tsig.getFudge());
                this.verifier.update(dNSOutput2.toByteArray());
                if (!this.verifier.verify(tsig.getSignature())) {
                    if (Options.check("verbose")) {
                        System.err.println("BADSIG failure");
                    }
                    message.tsigState = 4;
                    return 16;
                }
                this.verifier.clear();
                DNSOutput dNSOutput3 = new DNSOutput();
                dNSOutput3.writeU16(tsig.getSignature().length);
                this.verifier.update(dNSOutput3.toByteArray());
                this.verifier.update(tsig.getSignature());
                message.tsigState = 1;
                return 0;
            }
            if (this.nresponses - this.lastsigned >= 100) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                message.tsigState = 4;
                return 1;
            }
            message.tsigState = 2;
            return 0;
        }
    }

    static {
        Name fromConstantString = Name.fromConstantString("HMAC-MD5.SIG-ALG.REG.INT.");
        HMAC_MD5 = fromConstantString;
        HMAC = fromConstantString;
    }

    public TSIG(Name name2, Name name3, byte[] bArr) {
        this.name = name3;
        this.alg = name2;
        this.key = bArr;
        getDigest();
    }

    public static TSIG fromString(String str) {
        String[] split = str.split("[:/]", 3);
        if (split.length >= 2) {
            if (split.length == 3) {
                try {
                    return new TSIG(split[0], split[1], split[2]);
                } catch (IllegalArgumentException unused) {
                    split = str.split("[:/]", 2);
                }
            }
            return new TSIG(HMAC_MD5, split[0], split[1]);
        }
        throw new IllegalArgumentException("Invalid TSIG key specification");
    }

    private void getDigest() {
        if (this.alg.equals(HMAC_MD5)) {
            this.digest = "md5";
            this.digestBlockLength = 64;
        } else if (this.alg.equals(HMAC_SHA1)) {
            this.digest = "sha-1";
            this.digestBlockLength = 64;
        } else if (this.alg.equals(HMAC_SHA224)) {
            this.digest = "sha-224";
            this.digestBlockLength = 64;
        } else if (this.alg.equals(HMAC_SHA256)) {
            this.digest = "sha-256";
            this.digestBlockLength = 64;
        } else if (this.alg.equals(HMAC_SHA512)) {
            this.digest = "sha-512";
            this.digestBlockLength = 128;
        } else if (this.alg.equals(HMAC_SHA384)) {
            this.digest = "sha-384";
            this.digestBlockLength = 128;
        } else {
            throw new IllegalArgumentException("Invalid algorithm");
        }
    }

    public void apply(Message message, int i10, TSIGRecord tSIGRecord) {
        message.addRecord(generate(message, message.toWire(), i10, tSIGRecord), 3);
        message.tsigState = 3;
    }

    public TSIGRecord generate(Message message, byte[] bArr, int i10, TSIGRecord tSIGRecord) {
        Date date;
        HMAC hmac;
        int i11;
        byte[] bArr2;
        byte[] bArr3;
        int i12 = i10;
        if (i12 != 18) {
            date = new Date();
        } else {
            date = tSIGRecord.getTimeSigned();
        }
        Date date2 = date;
        if (i12 == 0 || i12 == 18) {
            hmac = new HMAC(this.digest, this.digestBlockLength, this.key);
        } else {
            hmac = null;
        }
        int intValue = Options.intValue("tsigfudge");
        if (intValue < 0 || intValue > 32767) {
            i11 = 300;
        } else {
            i11 = intValue;
        }
        if (tSIGRecord != null) {
            DNSOutput dNSOutput = new DNSOutput();
            dNSOutput.writeU16(tSIGRecord.getSignature().length);
            if (hmac != null) {
                hmac.update(dNSOutput.toByteArray());
                hmac.update(tSIGRecord.getSignature());
            }
        }
        if (hmac != null) {
            hmac.update(bArr);
        }
        DNSOutput dNSOutput2 = new DNSOutput();
        this.name.toWireCanonical(dNSOutput2);
        dNSOutput2.writeU16(255);
        dNSOutput2.writeU32(0);
        this.alg.toWireCanonical(dNSOutput2);
        long time = date2.getTime() / 1000;
        dNSOutput2.writeU16((int) (time >> 32));
        dNSOutput2.writeU32(time & 4294967295L);
        dNSOutput2.writeU16(i11);
        dNSOutput2.writeU16(i12);
        dNSOutput2.writeU16(0);
        if (hmac != null) {
            hmac.update(dNSOutput2.toByteArray());
        }
        if (hmac != null) {
            bArr2 = hmac.sign();
        } else {
            bArr2 = new byte[0];
        }
        byte[] bArr4 = bArr2;
        if (i12 == 18) {
            DNSOutput dNSOutput3 = new DNSOutput();
            long time2 = new Date().getTime() / 1000;
            dNSOutput3.writeU16((int) (time2 >> 32));
            dNSOutput3.writeU32(time2 & 4294967295L);
            bArr3 = dNSOutput3.toByteArray();
        } else {
            bArr3 = null;
        }
        return new TSIGRecord(this.name, 255, 0, this.alg, date2, i11, bArr4, message.getHeader().getID(), i10, bArr3);
    }

    public int recordLength() {
        return this.name.length() + 10 + this.alg.length() + 8 + 18 + 4 + 8;
    }

    public byte verify(Message message, byte[] bArr, int i10, TSIGRecord tSIGRecord) {
        message.tsigState = 4;
        TSIGRecord tsig = message.getTSIG();
        HMAC hmac = new HMAC(this.digest, this.digestBlockLength, this.key);
        if (tsig == null) {
            return 1;
        }
        if (!tsig.getName().equals(this.name) || !tsig.getAlgorithm().equals(this.alg)) {
            if (Options.check("verbose")) {
                System.err.println("BADKEY failure");
            }
            return 17;
        }
        if (Math.abs(System.currentTimeMillis() - tsig.getTimeSigned().getTime()) <= ((long) tsig.getFudge()) * 1000) {
            if (!(tSIGRecord == null || tsig.getError() == 17 || tsig.getError() == 16)) {
                DNSOutput dNSOutput = new DNSOutput();
                dNSOutput.writeU16(tSIGRecord.getSignature().length);
                hmac.update(dNSOutput.toByteArray());
                hmac.update(tSIGRecord.getSignature());
            }
            message.getHeader().decCount(3);
            byte[] wire = message.getHeader().toWire();
            message.getHeader().incCount(3);
            hmac.update(wire);
            hmac.update(bArr, wire.length, message.tsigstart - wire.length);
            DNSOutput dNSOutput2 = new DNSOutput();
            tsig.getName().toWireCanonical(dNSOutput2);
            dNSOutput2.writeU16(tsig.dclass);
            dNSOutput2.writeU32(tsig.ttl);
            tsig.getAlgorithm().toWireCanonical(dNSOutput2);
            long time = tsig.getTimeSigned().getTime() / 1000;
            dNSOutput2.writeU16((int) (time >> 32));
            dNSOutput2.writeU32(time & 4294967295L);
            dNSOutput2.writeU16(tsig.getFudge());
            dNSOutput2.writeU16(tsig.getError());
            if (tsig.getOther() != null) {
                dNSOutput2.writeU16(tsig.getOther().length);
                dNSOutput2.writeByteArray(tsig.getOther());
            } else {
                dNSOutput2.writeU16(0);
            }
            hmac.update(dNSOutput2.toByteArray());
            byte[] signature = tsig.getSignature();
            int digestLength = hmac.digestLength();
            int i11 = this.digest.equals("md5") ? 10 : digestLength / 2;
            if (signature.length > digestLength) {
                if (Options.check("verbose")) {
                    System.err.println("BADSIG: signature too long");
                }
                return 16;
            } else if (signature.length < i11) {
                if (Options.check("verbose")) {
                    System.err.println("BADSIG: signature too short");
                }
                return 16;
            } else if (!hmac.verify(signature, true)) {
                if (Options.check("verbose")) {
                    System.err.println("BADSIG: signature verification");
                }
                return 16;
            } else {
                message.tsigState = 1;
                return 0;
            }
        } else if (!Options.check("verbose")) {
            return Ascii.DC2;
        } else {
            System.err.println("BADTIME failure");
            return Ascii.DC2;
        }
    }

    public void apply(Message message, TSIGRecord tSIGRecord) {
        apply(message, 0, tSIGRecord);
    }

    public TSIG(Name name2, byte[] bArr) {
        this(HMAC_MD5, name2, bArr);
    }

    public TSIG(Name name2, String str, String str2) {
        byte[] fromString = base64.fromString(str2);
        this.key = fromString;
        if (fromString != null) {
            try {
                this.name = Name.fromString(str, Name.root);
                this.alg = name2;
                getDigest();
            } catch (Exception unused) {
                throw new IllegalArgumentException("Invalid TSIG key name");
            }
        } else {
            throw new IllegalArgumentException("Invalid TSIG key string");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TSIG(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            com.hpplay.sdk.source.mdns.xbill.dns.Name r0 = HMAC_MD5
            r1.<init>((com.hpplay.sdk.source.mdns.xbill.dns.Name) r0, (java.lang.String) r3, (java.lang.String) r4)
            java.lang.String r3 = "hmac-md5"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0010
            r1.alg = r0
            goto L_0x0050
        L_0x0010:
            java.lang.String r3 = "hmac-sha1"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x001d
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = HMAC_SHA1
            r1.alg = r2
            goto L_0x0050
        L_0x001d:
            java.lang.String r3 = "hmac-sha224"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x002a
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = HMAC_SHA224
            r1.alg = r2
            goto L_0x0050
        L_0x002a:
            java.lang.String r3 = "hmac-sha256"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0037
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = HMAC_SHA256
            r1.alg = r2
            goto L_0x0050
        L_0x0037:
            java.lang.String r3 = "hmac-sha384"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0044
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = HMAC_SHA384
            r1.alg = r2
            goto L_0x0050
        L_0x0044:
            java.lang.String r3 = "hmac-sha512"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x0054
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = HMAC_SHA512
            r1.alg = r2
        L_0x0050:
            r1.getDigest()
            return
        L_0x0054:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid TSIG algorithm"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.TSIG.<init>(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public TSIG(String str, String str2) {
        this(HMAC_MD5, str, str2);
    }

    public int verify(Message message, byte[] bArr, TSIGRecord tSIGRecord) {
        return verify(message, bArr, bArr.length, tSIGRecord);
    }
}
