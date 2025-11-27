package com.hpplay.component.protocol.srp6;

import com.hpplay.component.protocol.srp6.SRP6Exception;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class SRP6ClientSession extends SRP6Session {
    private static final long serialVersionUID = -479060216624675478L;

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f10564a;
    private String password;
    private State state;

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f10565x;
    private XRoutine xRoutine;

    public enum State {
        INIT,
        STEP_1,
        STEP_2,
        STEP_3
    }

    public SRP6ClientSession(int i10) {
        super(i10);
        this.f10565x = null;
        this.f10564a = null;
        this.xRoutine = null;
        this.state = State.INIT;
        updateLastActivityTime();
    }

    public State getState() {
        return this.state;
    }

    public XRoutine getXRoutine() {
        return this.xRoutine;
    }

    public void setXRoutine(XRoutine xRoutine2) {
        this.xRoutine = xRoutine2;
    }

    public void step1(String str, String str2) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("The user identity 'I' must not be null or empty");
        }
        this.userID = str;
        if (str2 != null) {
            this.password = str2;
            if (this.state == State.INIT) {
                this.state = State.STEP_1;
                updateLastActivityTime();
                return;
            }
            throw new IllegalStateException("State violation: Session must be in INIT state");
        }
        throw new IllegalArgumentException("The user password 'P' must not be null");
    }

    public SRP6ClientCredentials step2(SRP6CryptoParams sRP6CryptoParams, BigInteger bigInteger, BigInteger bigInteger2) {
        SRP6CryptoParams sRP6CryptoParams2 = sRP6CryptoParams;
        BigInteger bigInteger3 = bigInteger;
        BigInteger bigInteger4 = bigInteger2;
        if (sRP6CryptoParams2 != null) {
            this.config = sRP6CryptoParams2;
            MessageDigest messageDigestInstance = sRP6CryptoParams.getMessageDigestInstance();
            if (messageDigestInstance == null) {
                throw new IllegalArgumentException("Unsupported hash algorithm 'H': " + sRP6CryptoParams2.H);
            } else if (bigInteger3 != null) {
                this.f10570s = bigInteger3;
                if (bigInteger4 != null) {
                    this.B = bigInteger4;
                    if (this.state != State.STEP_1) {
                        throw new IllegalStateException("State violation: Session must be in STEP_1 state");
                    } else if (hasTimedOut()) {
                        throw new SRP6Exception("Session timeout", SRP6Exception.CauseType.TIMEOUT);
                    } else if (this.srp6Routines.isValidPublicValue(sRP6CryptoParams2.N, bigInteger4)) {
                        XRoutine xRoutine2 = this.xRoutine;
                        if (xRoutine2 != null) {
                            this.f10565x = xRoutine2.computeX(sRP6CryptoParams.getMessageDigestInstance(), BigIntegerUtils.bigIntegerToBytes(bigInteger), this.userID.getBytes(Charset.forName("UTF-8")), this.password.getBytes(Charset.forName("UTF-8")));
                        } else {
                            this.f10565x = this.srp6Routines.computeX(messageDigestInstance, BigIntegerUtils.bigIntegerToBytes(bigInteger), this.password.getBytes(Charset.forName("UTF-8")));
                            messageDigestInstance.reset();
                        }
                        this.f10564a = this.srp6Routines.generatePrivateValue(sRP6CryptoParams2.N, this.random);
                        messageDigestInstance.reset();
                        this.A = this.srp6Routines.computePublicClientValue(sRP6CryptoParams2.N, sRP6CryptoParams2.f10566g, this.f10564a);
                        this.f10569k = this.srp6Routines.computeK(messageDigestInstance, sRP6CryptoParams2.N, sRP6CryptoParams2.f10566g);
                        messageDigestInstance.reset();
                        if (this.hashedKeysRoutine != null) {
                            this.f10571u = this.hashedKeysRoutine.computeU(sRP6CryptoParams, new URoutineContext(this.A, bigInteger4));
                        } else {
                            this.f10571u = this.srp6Routines.computeU(messageDigestInstance, sRP6CryptoParams2.N, this.A, bigInteger4);
                            messageDigestInstance.reset();
                        }
                        BigInteger computeSessionKey = this.srp6Routines.computeSessionKey(sRP6CryptoParams2.N, sRP6CryptoParams2.f10566g, this.f10569k, this.f10565x, this.f10571u, this.f10564a, bigInteger2);
                        this.S = computeSessionKey;
                        if (this.clientEvidenceRoutine != null) {
                            this.M1 = this.clientEvidenceRoutine.computeClientEvidence(sRP6CryptoParams, new SRP6ClientEvidenceContext(this.userID, bigInteger, this.A, bigInteger2, computeSessionKey));
                        } else {
                            this.M1 = this.srp6Routines.computeClientEvidence(messageDigestInstance, this.A, bigInteger4, computeSessionKey);
                            messageDigestInstance.reset();
                        }
                        this.state = State.STEP_2;
                        updateLastActivityTime();
                        return new SRP6ClientCredentials(this.A, this.M1);
                    } else {
                        throw new SRP6Exception("Bad server public value 'B'", SRP6Exception.CauseType.BAD_PUBLIC_VALUE);
                    }
                } else {
                    throw new IllegalArgumentException("The public server value 'B' must not be null");
                }
            } else {
                throw new IllegalArgumentException("The salt 's' must not be null");
            }
        } else {
            throw new IllegalArgumentException("The SRP-6a crypto parameters must not be null");
        }
    }

    public void step3(BigInteger bigInteger) {
        BigInteger bigInteger2;
        if (bigInteger != null) {
            this.M2 = bigInteger;
            if (this.state != State.STEP_2) {
                throw new IllegalStateException("State violation: Session must be in STEP_2 state");
            } else if (!hasTimedOut()) {
                if (this.serverEvidenceRoutine != null) {
                    bigInteger2 = this.serverEvidenceRoutine.computeServerEvidence(this.config, new SRP6ServerEvidenceContext(this.A, this.M1, this.S));
                } else {
                    bigInteger2 = this.srp6Routines.computeServerEvidence(this.config.getMessageDigestInstance(), this.A, this.M1, this.S);
                }
                if (bigInteger2.equals(bigInteger)) {
                    this.state = State.STEP_3;
                    updateLastActivityTime();
                    return;
                }
                throw new SRP6Exception("Bad server credentials", SRP6Exception.CauseType.BAD_CREDENTIALS);
            } else {
                throw new SRP6Exception("Session timeout", SRP6Exception.CauseType.TIMEOUT);
            }
        } else {
            throw new IllegalArgumentException("The server evidence message 'M2' must not be null");
        }
    }

    public SRP6ClientSession() {
        this(0);
    }
}
