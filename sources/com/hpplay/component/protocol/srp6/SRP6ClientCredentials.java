package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;

public final class SRP6ClientCredentials {
    public final BigInteger A;
    public final BigInteger M1;

    public SRP6ClientCredentials(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger != null) {
            this.A = bigInteger;
            if (bigInteger2 != null) {
                this.M1 = bigInteger2;
                return;
            }
            throw new IllegalArgumentException("The client evidence message 'M1' must not be null");
        }
        throw new IllegalArgumentException("The public client value 'A' must not be null");
    }
}
