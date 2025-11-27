package com.hpplay.component.protocol.srp6;

import java.math.BigInteger;
import java.security.MessageDigest;

public interface XRoutine {
    BigInteger computeX(MessageDigest messageDigest, byte[] bArr, byte[] bArr2, byte[] bArr3);
}
