package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.KeyException;
import io.jsonwebtoken.security.KeyLengthSupplier;
import io.jsonwebtoken.security.KeyPairBuilder;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EdwardsCurve extends AbstractCurve implements KeyLengthSupplier {
    private static final byte[] ASN1_OID_PREFIX = {6, 3, 43, 101};
    private static final Map<Integer, EdwardsCurve> BY_OID_TERMINAL_NODE = new LinkedHashMap(4);
    private static final Function<Key, String> CURVE_NAME_FINDER = new NamedParameterSpecValueFinder();
    public static final EdwardsCurve Ed25519;
    public static final EdwardsCurve Ed448;
    private static final String OID_PREFIX = "1.3.101.";
    private static final Map<String, EdwardsCurve> REGISTRY = new LinkedHashMap(8);
    public static final Collection<EdwardsCurve> VALUES;
    public static final EdwardsCurve X25519;
    public static final EdwardsCurve X448;
    final byte[] ASN1_OID;
    private final String OID;
    private final byte[] PRIVATE_KEY_ASN1_PREFIX;
    private final byte[] PRIVATE_KEY_JDK11_PREFIX;
    private final byte[] PUBLIC_KEY_ASN1_PREFIX;
    private final int encodedKeyByteLength;
    private final int keyBitLength;
    private final boolean signatureCurve;

    static {
        EdwardsCurve edwardsCurve = new EdwardsCurve("X25519", 110);
        X25519 = edwardsCurve;
        EdwardsCurve edwardsCurve2 = new EdwardsCurve("X448", 111);
        X448 = edwardsCurve2;
        EdwardsCurve edwardsCurve3 = new EdwardsCurve("Ed25519", 112);
        Ed25519 = edwardsCurve3;
        EdwardsCurve edwardsCurve4 = new EdwardsCurve("Ed448", 113);
        Ed448 = edwardsCurve4;
        List<EdwardsCurve> of = Collections.of(edwardsCurve, edwardsCurve2, edwardsCurve3, edwardsCurve4);
        VALUES = of;
        for (EdwardsCurve edwardsCurve5 : of) {
            byte[] bArr = edwardsCurve5.ASN1_OID;
            BY_OID_TERMINAL_NODE.put(Integer.valueOf(bArr[bArr.length - 1]), edwardsCurve5);
            Map<String, EdwardsCurve> map = REGISTRY;
            map.put(edwardsCurve5.getId(), edwardsCurve5);
            map.put(edwardsCurve5.OID, edwardsCurve5);
        }
    }

    public EdwardsCurve(String str, int i10) {
        super(str, str);
        int i11;
        boolean z10;
        if (i10 < 110 || i10 > 113) {
            throw new IllegalArgumentException("Invalid Edwards Curve ASN.1 OID terminal node value");
        }
        if (i10 % 2 == 0) {
            i11 = 255;
        } else {
            i11 = 448;
        }
        this.keyBitLength = i11;
        int length = Bytes.length(i10 == 113 ? i11 + 8 : i11);
        this.encodedKeyByteLength = length;
        this.OID = OID_PREFIX + i10;
        if (i10 == 112 || i10 == 113) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.signatureCurve = z10;
        byte[] concat = Bytes.concat(ASN1_OID_PREFIX, new byte[]{(byte) i10});
        this.ASN1_OID = concat;
        this.PUBLIC_KEY_ASN1_PREFIX = publicKeyAsn1Prefix(length, concat);
        this.PRIVATE_KEY_ASN1_PREFIX = privateKeyPkcs8Prefix(length, concat, true);
        this.PRIVATE_KEY_JDK11_PREFIX = privateKeyPkcs8Prefix(length, concat, false);
    }

    public static <K extends Key> K assertEdwards(K k10) {
        forKey(k10);
        return k10;
    }

    private void assertLength(byte[] bArr, boolean z10) {
        String str;
        int length = Bytes.length(bArr);
        if (length != this.encodedKeyByteLength) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid ");
            sb.append(getId());
            sb.append(" encoded ");
            if (z10) {
                str = "PublicKey";
            } else {
                str = "PrivateKey";
            }
            sb.append(str);
            sb.append(" length. Should be ");
            sb.append(Bytes.bytesMsg(this.encodedKeyByteLength));
            sb.append(", found ");
            sb.append(Bytes.bytesMsg(length));
            sb.append(".");
            throw new InvalidKeyException(sb.toString());
        }
    }

    public static PublicKey derivePublic(PrivateKey privateKey) {
        return EdwardsPublicKeyDeriver.INSTANCE.apply(privateKey);
    }

    public static EdwardsCurve findById(String str) {
        return REGISTRY.get(str);
    }

    public static EdwardsCurve findByKey(Key key) {
        if (key == null) {
            return null;
        }
        EdwardsCurve findById = findById(key.getAlgorithm());
        if (findById == null) {
            findById = findById(CURVE_NAME_FINDER.apply(key));
        }
        byte[] findEncoded = KeysBridge.findEncoded(key);
        if (findById == null && !Bytes.isEmpty(findEncoded)) {
            findById = BY_OID_TERMINAL_NODE.get(Integer.valueOf(findOidTerminalNode(findEncoded)));
        }
        if (findById != null && !Bytes.isEmpty(findEncoded)) {
            try {
                findById.getKeyMaterial(key);
            } catch (Throwable unused) {
                return null;
            }
        }
        return findById;
    }

    private static int findOidTerminalNode(byte[] bArr) {
        int length;
        byte[] bArr2 = ASN1_OID_PREFIX;
        int indexOf = Bytes.indexOf(bArr, bArr2);
        if (indexOf <= -1 || (length = indexOf + bArr2.length) >= bArr.length) {
            return -1;
        }
        return bArr[length];
    }

    public static EdwardsCurve forKey(Key key) {
        Assert.notNull(key, "Key cannot be null.");
        EdwardsCurve findByKey = findByKey(key);
        if (findByKey != null) {
            return findByKey;
        }
        throw new InvalidKeyException("Unrecognized Edwards Curve key: [" + KeysBridge.toString(key) + "]");
    }

    public static boolean isEdwards(Key key) {
        if (key == null) {
            return false;
        }
        String clean = Strings.clean(key.getAlgorithm());
        if ("EdDSA".equals(clean) || "XDH".equals(clean) || findByKey(key) != null) {
            return true;
        }
        return false;
    }

    private static byte[] privateKeyPkcs8Prefix(int i10, byte[] bArr, boolean z10) {
        byte[] bArr2 = z10 ? new byte[]{4, (byte) (i10 + 2), 4, (byte) i10} : new byte[]{4, (byte) i10};
        return Bytes.concat(new byte[]{48, (byte) (bArr.length + 5 + bArr2.length + i10), 2, 1, 0, 48, 5}, bArr, bArr2);
    }

    private static byte[] publicKeyAsn1Prefix(int i10, byte[] bArr) {
        return Bytes.concat(new byte[]{48, (byte) (i10 + 10), 48, 5}, bArr, new byte[]{3, (byte) (i10 + 1), 0});
    }

    public boolean contains(Key key) {
        return findByKey(key).equals(this);
    }

    /* JADX WARNING: type inference failed for: r7v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r1v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r1v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r4v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r0v8, types: [byte] */
    /* JADX WARNING: type inference failed for: r4v5, types: [byte] */
    /* JADX WARNING: type inference failed for: r0v12, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r1v11, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r1v13, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r4v4, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r4v5, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] doGetKeyMaterial(java.security.Key r7) {
        /*
            r6 = this;
            byte[] r7 = io.jsonwebtoken.impl.security.KeysBridge.getEncoded(r7)
            byte[] r0 = r6.ASN1_OID
            int r0 = io.jsonwebtoken.impl.lang.Bytes.indexOf(r7, r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r2 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "Missing or incorrect algorithm OID."
            io.jsonwebtoken.lang.Assert.gt(r1, r3, r4)
            byte[] r1 = r6.ASN1_OID
            int r1 = r1.length
            int r0 = r0 + r1
            byte r1 = r7[r0]
            r3 = 5
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            if (r1 != r3) goto L_0x0035
            int r0 = r0 + 1
            byte r1 = r7[r0]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "OID NULL terminator should indicate zero unused bytes."
            io.jsonwebtoken.lang.Assert.eq(r1, r5, r3)
            int r0 = r0 + 1
        L_0x0035:
            byte r1 = r7[r0]
            r3 = 3
            if (r1 != r3) goto L_0x0051
            int r0 = r0 + 1
            int r1 = r0 + 1
            byte r0 = r7[r0]
            int r3 = r1 + 1
            byte r1 = r7[r1]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r4 = "BIT STREAM should not indicate unused bytes."
            io.jsonwebtoken.lang.Assert.eq(r1, r5, r4)
            int r4 = r0 + -1
            r0 = r3
            goto L_0x0066
        L_0x0051:
            r2 = 4
            if (r1 != r2) goto L_0x0066
            int r0 = r0 + 1
            int r1 = r0 + 1
            byte r4 = r7[r0]
            byte r0 = r7[r1]
            if (r0 != r2) goto L_0x0065
            int r1 = r1 + 1
            int r0 = r1 + 1
            byte r4 = r7[r1]
            goto L_0x0066
        L_0x0065:
            r0 = r1
        L_0x0066:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            int r2 = r6.encodedKeyByteLength
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "Invalid key length."
            io.jsonwebtoken.lang.Assert.eq(r1, r2, r3)
            int r4 = r4 + r0
            byte[] r7 = java.util.Arrays.copyOfRange(r7, r0, r4)
            int r0 = io.jsonwebtoken.impl.lang.Bytes.length((byte[]) r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r1 = r6.encodedKeyByteLength
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            io.jsonwebtoken.lang.Assert.eq(r0, r1, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.EdwardsCurve.doGetKeyMaterial(java.security.Key):byte[]");
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ String getId() {
        return super.getId();
    }

    public /* bridge */ /* synthetic */ String getJcaName() {
        return super.getJcaName();
    }

    public int getKeyBitLength() {
        return this.keyBitLength;
    }

    public byte[] getKeyMaterial(Key key) {
        try {
            return doGetKeyMaterial(key);
        } catch (Throwable th) {
            if (th instanceof KeyException) {
                throw th;
            }
            throw new InvalidKeyException("Invalid " + getId() + " ASN.1 encoding: " + th.getMessage(), th);
        }
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public boolean isSignatureCurve() {
        return this.signatureCurve;
    }

    public KeyPairBuilder keyPair() {
        return new DefaultKeyPairBuilder(getJcaName(), this.keyBitLength);
    }

    public KeySpec privateKeySpec(byte[] bArr, boolean z10) {
        byte[] bArr2;
        if (z10) {
            bArr2 = this.PRIVATE_KEY_ASN1_PREFIX;
        } else {
            bArr2 = this.PRIVATE_KEY_JDK11_PREFIX;
        }
        return new PKCS8EncodedKeySpec(Bytes.concat(bArr2, bArr));
    }

    public PrivateKey toPrivateKey(byte[] bArr, Provider provider) {
        assertLength(bArr, false);
        return new JcaTemplate(getJcaName(), provider).generatePrivate(privateKeySpec(bArr, true));
    }

    public PublicKey toPublicKey(byte[] bArr, Provider provider) {
        assertLength(bArr, true);
        return new JcaTemplate(getJcaName(), provider).generatePublic(new X509EncodedKeySpec(Bytes.concat(this.PUBLIC_KEY_ASN1_PREFIX, bArr)));
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
