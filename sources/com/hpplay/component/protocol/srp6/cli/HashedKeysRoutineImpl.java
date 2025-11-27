package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import com.hpplay.component.protocol.srp6.URoutine;
import com.hpplay.component.protocol.srp6.URoutineContext;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class HashedKeysRoutineImpl implements URoutine {
    public BigInteger computeU(SRP6CryptoParams sRP6CryptoParams, URoutineContext uRoutineContext) {
        try {
            MessageDigest instance = MessageDigest.getInstance(sRP6CryptoParams.H);
            instance.update(BigIntegerUtils.bigIntegerToBytes(uRoutineContext.A));
            instance.update(BigIntegerUtils.bigIntegerToBytes(uRoutineContext.B));
            return BigIntegerUtils.bigIntegerFromBytes(instance.digest());
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Could not locate requested algorithm", e10);
        }
    }
}
