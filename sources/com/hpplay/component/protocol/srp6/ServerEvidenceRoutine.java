package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

public interface ServerEvidenceRoutine {
    BigInteger computeServerEvidence(SRP6CryptoParams sRP6CryptoParams, SRP6ServerEvidenceContext sRP6ServerEvidenceContext);
}
