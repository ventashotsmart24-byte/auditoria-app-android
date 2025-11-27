package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6ClientSession;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import com.hpplay.component.protocol.srp6.SRP6ServerEvidenceContext;
import com.hpplay.component.protocol.srp6.ServerEvidenceRoutine;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ServerEvidenceRoutineImpl implements ServerEvidenceRoutine {
    private final SRP6ClientSession srp6ClientSession;

    public ServerEvidenceRoutineImpl(SRP6ClientSession sRP6ClientSession) {
        this.srp6ClientSession = sRP6ClientSession;
    }

    public BigInteger computeServerEvidence(SRP6CryptoParams sRP6CryptoParams, SRP6ServerEvidenceContext sRP6ServerEvidenceContext) {
        try {
            MessageDigest instance = MessageDigest.getInstance(sRP6CryptoParams.H);
            instance.update(BigIntegerUtils.bigIntegerToBytes(sRP6ServerEvidenceContext.A));
            instance.update(BigIntegerUtils.bigIntegerToBytes(sRP6ServerEvidenceContext.M1));
            instance.update(this.srp6ClientSession.getSessionKeyHash());
            return new BigInteger(1, instance.digest());
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Could not locate requested algorithm", e10);
        }
    }
}
