package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.ClientEvidenceRoutine;
import com.hpplay.component.protocol.srp6.SRP6ClientEvidenceContext;
import com.hpplay.component.protocol.srp6.SRP6ClientSession;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ClientEvidenceRoutineImpl implements ClientEvidenceRoutine {
    private final SRP6ClientSession srp6ClientSession;

    public ClientEvidenceRoutineImpl(SRP6ClientSession sRP6ClientSession) {
        this.srp6ClientSession = sRP6ClientSession;
    }

    private static byte[] xor(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }

    public BigInteger computeClientEvidence(SRP6CryptoParams sRP6CryptoParams, SRP6ClientEvidenceContext sRP6ClientEvidenceContext) {
        try {
            MessageDigest instance = MessageDigest.getInstance(sRP6CryptoParams.H);
            instance.update(BigIntegerUtils.bigIntegerToBytes(sRP6CryptoParams.N));
            byte[] digest = instance.digest();
            instance.update(BigIntegerUtils.bigIntegerToBytes(sRP6CryptoParams.f10566g));
            byte[] xor = xor(digest, instance.digest());
            instance.update(sRP6ClientEvidenceContext.userID.getBytes(StandardCharsets.UTF_8));
            byte[] digest2 = instance.digest();
            instance.update(xor);
            instance.update(digest2);
            instance.update(BigIntegerUtils.bigIntegerToBytes(sRP6ClientEvidenceContext.f10563s));
            instance.update(BigIntegerUtils.bigIntegerToBytes(sRP6ClientEvidenceContext.A));
            instance.update(BigIntegerUtils.bigIntegerToBytes(sRP6ClientEvidenceContext.B));
            instance.update(this.srp6ClientSession.getSessionKeyHash());
            return new BigInteger(1, instance.digest());
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Could not locate requested algorithm", e10);
        }
    }
}
