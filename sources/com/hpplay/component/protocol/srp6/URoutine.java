package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

public interface URoutine {
    BigInteger computeU(SRP6CryptoParams sRP6CryptoParams, URoutineContext uRoutineContext);
}
