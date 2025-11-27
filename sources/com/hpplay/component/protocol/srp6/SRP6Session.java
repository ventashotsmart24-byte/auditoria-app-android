package com.hpplay.component.protocol.srp6;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public abstract class SRP6Session implements Serializable {
    private static final long serialVersionUID = 3813344182070859518L;
    protected BigInteger A;
    protected BigInteger B;
    protected BigInteger M1;
    protected BigInteger M2;
    protected BigInteger S;
    private Map<String, Object> attributes;
    protected ClientEvidenceRoutine clientEvidenceRoutine;
    protected SRP6CryptoParams config;
    protected URoutine hashedKeysRoutine;

    /* renamed from: k  reason: collision with root package name */
    protected BigInteger f10569k;
    protected long lastActivity;
    protected SecureRandom random;

    /* renamed from: s  reason: collision with root package name */
    protected BigInteger f10570s;
    protected ServerEvidenceRoutine serverEvidenceRoutine;
    protected final SRP6Routines srp6Routines;
    protected final int timeout;

    /* renamed from: u  reason: collision with root package name */
    protected BigInteger f10571u;
    protected String userID;

    public SRP6Session(int i10, SRP6Routines sRP6Routines) {
        this.random = new SecureRandom();
        this.userID = null;
        this.f10570s = null;
        this.A = null;
        this.B = null;
        this.f10571u = null;
        this.f10569k = null;
        this.S = null;
        this.M1 = null;
        this.M2 = null;
        this.clientEvidenceRoutine = null;
        this.serverEvidenceRoutine = null;
        this.hashedKeysRoutine = null;
        this.attributes = null;
        if (i10 >= 0) {
            this.timeout = i10;
            this.srp6Routines = sRP6Routines;
            return;
        }
        throw new IllegalArgumentException("The timeout must be zero (no timeout) or greater");
    }

    public Object getAttribute(String str) {
        if (str != null) {
            Map<String, Object> map = this.attributes;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
        throw new IllegalArgumentException("The attribute key must not be null");
    }

    public BigInteger getClientEvidenceMessage() {
        return this.M1;
    }

    public ClientEvidenceRoutine getClientEvidenceRoutine() {
        return this.clientEvidenceRoutine;
    }

    public SRP6CryptoParams getCryptoParams() {
        return this.config;
    }

    public URoutine getHashedKeysRoutine() {
        return this.hashedKeysRoutine;
    }

    public long getLastActivityTime() {
        return this.lastActivity;
    }

    public BigInteger getPublicClientValue() {
        return this.A;
    }

    public BigInteger getPublicServerValue() {
        return this.B;
    }

    public BigInteger getSalt() {
        return this.f10570s;
    }

    public BigInteger getServerEvidenceMessage() {
        return this.M2;
    }

    public ServerEvidenceRoutine getServerEvidenceRoutine() {
        return this.serverEvidenceRoutine;
    }

    public BigInteger getSessionKey() {
        return this.S;
    }

    public byte[] getSessionKeyHash() {
        if (this.S == null) {
            return null;
        }
        MessageDigest messageDigestInstance = this.config.getMessageDigestInstance();
        if (messageDigestInstance != null) {
            return messageDigestInstance.digest(BigIntegerUtils.bigIntegerToBytes(this.S));
        }
        throw new IllegalArgumentException("Unsupported hash algorithm 'H': " + this.config.H);
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getUserID() {
        return this.userID;
    }

    public boolean hasTimedOut() {
        if (this.timeout != 0 && System.currentTimeMillis() > this.lastActivity + ((long) (this.timeout * 1000))) {
            return true;
        }
        return false;
    }

    public void setAttribute(String str, Object obj) {
        if (str != null) {
            if (this.attributes == null) {
                this.attributes = new HashMap();
            }
            this.attributes.put(str, obj);
            return;
        }
        throw new IllegalArgumentException("The attribute key must not be null");
    }

    public void setClientEvidenceRoutine(ClientEvidenceRoutine clientEvidenceRoutine2) {
        this.clientEvidenceRoutine = clientEvidenceRoutine2;
    }

    public void setHashedKeysRoutine(URoutine uRoutine) {
        this.hashedKeysRoutine = uRoutine;
    }

    public void setServerEvidenceRoutine(ServerEvidenceRoutine serverEvidenceRoutine2) {
        this.serverEvidenceRoutine = serverEvidenceRoutine2;
    }

    public void updateLastActivityTime() {
        this.lastActivity = System.currentTimeMillis();
    }

    public SRP6Session(int i10) {
        this(i10, new SRP6Routines());
    }

    public SRP6Session() {
        this(0, new SRP6Routines());
    }
}
