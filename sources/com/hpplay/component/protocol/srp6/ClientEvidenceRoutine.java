package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

public interface ClientEvidenceRoutine {
    BigInteger computeClientEvidence(SRP6CryptoParams sRP6CryptoParams, SRP6ClientEvidenceContext sRP6ClientEvidenceContext);
}
