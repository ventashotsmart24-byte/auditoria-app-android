package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.impl.io.Streams;
import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.CheckedSupplier;
import io.jsonwebtoken.impl.lang.DefaultRegistry;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.SecurityException;
import io.jsonwebtoken.security.SignatureException;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import org.android.agoo.common.AgooConstants;

public class JcaTemplate {
    private static final List<InstanceFactory<?>> FACTORIES;
    private static final Registry<Class<?>, InstanceFactory<?>> REGISTRY;
    private final String jcaName;
    /* access modifiers changed from: private */
    public final Provider provider;
    /* access modifiers changed from: private */
    public final SecureRandom secureRandom;

    public static class AlgorithmParametersFactory extends JcaInstanceFactory<AlgorithmParameters> {
        public AlgorithmParametersFactory() {
            super(AlgorithmParameters.class);
        }

        public AlgorithmParameters doGet(String str, Provider provider) {
            return provider != null ? AlgorithmParameters.getInstance(str, provider) : AlgorithmParameters.getInstance(str);
        }
    }

    public static class CertificateFactoryFactory extends JcaInstanceFactory<CertificateFactory> {
        public CertificateFactoryFactory() {
            super(CertificateFactory.class);
        }

        public CertificateFactory doGet(String str, Provider provider) {
            return provider != null ? CertificateFactory.getInstance(str, provider) : CertificateFactory.getInstance(str);
        }
    }

    public static class CipherFactory extends JcaInstanceFactory<Cipher> {
        public CipherFactory() {
            super(Cipher.class);
        }

        public Cipher doGet(String str, Provider provider) {
            return provider != null ? Cipher.getInstance(str, provider) : Cipher.getInstance(str);
        }
    }

    public interface InstanceFactory<T> extends Identifiable {
        T get(String str, Provider provider);

        Class<T> getInstanceClass();
    }

    public static class KeyAgreementFactory extends JcaInstanceFactory<KeyAgreement> {
        public KeyAgreementFactory() {
            super(KeyAgreement.class);
        }

        public KeyAgreement doGet(String str, Provider provider) {
            return provider != null ? KeyAgreement.getInstance(str, provider) : KeyAgreement.getInstance(str);
        }
    }

    public static class KeyFactoryFactory extends JcaInstanceFactory<KeyFactory> {
        public KeyFactoryFactory() {
            super(KeyFactory.class);
        }

        public KeyFactory doGet(String str, Provider provider) {
            return provider != null ? KeyFactory.getInstance(str, provider) : KeyFactory.getInstance(str);
        }
    }

    public static class KeyGeneratorFactory extends JcaInstanceFactory<KeyGenerator> {
        public KeyGeneratorFactory() {
            super(KeyGenerator.class);
        }

        public KeyGenerator doGet(String str, Provider provider) {
            return provider != null ? KeyGenerator.getInstance(str, provider) : KeyGenerator.getInstance(str);
        }
    }

    public static class KeyPairGeneratorFactory extends JcaInstanceFactory<KeyPairGenerator> {
        public KeyPairGeneratorFactory() {
            super(KeyPairGenerator.class);
        }

        public KeyPairGenerator doGet(String str, Provider provider) {
            return provider != null ? KeyPairGenerator.getInstance(str, provider) : KeyPairGenerator.getInstance(str);
        }
    }

    public static class MacFactory extends JcaInstanceFactory<Mac> {
        public MacFactory() {
            super(Mac.class);
        }

        public Mac doGet(String str, Provider provider) {
            return provider != null ? Mac.getInstance(str, provider) : Mac.getInstance(str);
        }
    }

    public static class MessageDigestFactory extends JcaInstanceFactory<MessageDigest> {
        public MessageDigestFactory() {
            super(MessageDigest.class);
        }

        public MessageDigest doGet(String str, Provider provider) {
            return provider != null ? MessageDigest.getInstance(str, provider) : MessageDigest.getInstance(str);
        }
    }

    public static class SecretKeyFactoryFactory extends JcaInstanceFactory<SecretKeyFactory> {
        public SecretKeyFactoryFactory() {
            super(SecretKeyFactory.class);
        }

        public SecretKeyFactory doGet(String str, Provider provider) {
            return provider != null ? SecretKeyFactory.getInstance(str, provider) : SecretKeyFactory.getInstance(str);
        }
    }

    public static class SignatureFactory extends JcaInstanceFactory<Signature> {
        public SignatureFactory() {
            super(Signature.class);
        }

        public Signature doGet(String str, Provider provider) {
            return provider != null ? Signature.getInstance(str, provider) : Signature.getInstance(str);
        }
    }

    static {
        List<InstanceFactory<?>> of = Collections.of(new CipherFactory(), new KeyFactoryFactory(), new SecretKeyFactoryFactory(), new KeyGeneratorFactory(), new KeyPairGeneratorFactory(), new KeyAgreementFactory(), new MessageDigestFactory(), new SignatureFactory(), new MacFactory(), new AlgorithmParametersFactory(), new CertificateFactoryFactory());
        FACTORIES = of;
        REGISTRY = new DefaultRegistry("JCA Instance Factory", "instance class", of, new Function<InstanceFactory<?>, Class<?>>() {
            public Class<?> apply(InstanceFactory<?> instanceFactory) {
                return instanceFactory.getInstanceClass();
            }
        });
    }

    public JcaTemplate(String str) {
        this(str, (Provider) null);
    }

    /* access modifiers changed from: private */
    public <T, R> R execute(Class<T> cls, CheckedFunction<T, R> checkedFunction, Provider provider2) {
        InstanceFactory instanceFactory = REGISTRY.get(cls);
        Assert.notNull(instanceFactory, "Unsupported JCA instance class.");
        return checkedFunction.apply(Assert.isInstanceOf(cls, instanceFactory.get(this.jcaName, provider2), "Factory instance does not match expected type."));
    }

    private int getJdk8213363BugExpectedSize(InvalidKeyException invalidKeyException) {
        String message = invalidKeyException.getMessage();
        if (!Strings.hasText(message) || !message.startsWith("key length must be ")) {
            return -1;
        }
        try {
            return Integer.parseInt(message.substring(19));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private boolean isJdk8213363Bug(InvalidKeySpecException invalidKeySpecException) {
        if (!isJdk11()) {
            return false;
        }
        if (("XDH".equals(this.jcaName) || "X25519".equals(this.jcaName) || "X448".equals(this.jcaName)) && (invalidKeySpecException.getCause() instanceof InvalidKeyException) && !Objects.isEmpty((Object[]) invalidKeySpecException.getStackTrace()) && "sun.security.ec.XDHKeyFactory".equals(invalidKeySpecException.getStackTrace()[0].getClassName()) && "engineGeneratePrivate".equals(invalidKeySpecException.getStackTrace()[0].getMethodName())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public KeySpec respecIfNecessary(InvalidKeySpecException invalidKeySpecException, KeySpec keySpec) {
        EdwardsCurve edwardsCurve;
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            return null;
        }
        byte[] encoded = ((PKCS8EncodedKeySpec) keySpec).getEncoded();
        if (isJdk8213363Bug(invalidKeySpecException)) {
            int jdk8213363BugExpectedSize = getJdk8213363BugExpectedSize((InvalidKeyException) Assert.isInstanceOf(InvalidKeyException.class, invalidKeySpecException.getCause(), "Unexpected argument."));
            if ((jdk8213363BugExpectedSize == 32 || jdk8213363BugExpectedSize == 56) && Bytes.length(encoded) >= jdk8213363BugExpectedSize) {
                byte[] bArr = new byte[jdk8213363BugExpectedSize];
                System.arraycopy(encoded, encoded.length - jdk8213363BugExpectedSize, bArr, 0, jdk8213363BugExpectedSize);
                if (jdk8213363BugExpectedSize == 32) {
                    edwardsCurve = EdwardsCurve.X25519;
                } else {
                    edwardsCurve = EdwardsCurve.X448;
                }
                return edwardsCurve.privateKeySpec(bArr, false);
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T, R> R fallback(final java.lang.Class<T> r2, final io.jsonwebtoken.impl.lang.CheckedFunction<T, R> r3) {
        /*
            r1 = this;
            io.jsonwebtoken.impl.security.JcaTemplate$3 r0 = new io.jsonwebtoken.impl.security.JcaTemplate$3
            r0.<init>(r2, r3)
            java.lang.Object r2 = r1.execute((java.lang.Class<?>) r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.JcaTemplate.fallback(java.lang.Class, io.jsonwebtoken.impl.lang.CheckedFunction):java.lang.Object");
    }

    public Provider findBouncyCastle() {
        return Providers.findBouncyCastle();
    }

    public KeyPair generateKeyPair() {
        return (KeyPair) withKeyPairGenerator(new CheckedFunction<KeyPairGenerator, KeyPair>() {
            public KeyPair apply(KeyPairGenerator keyPairGenerator) {
                return keyPairGenerator.generateKeyPair();
            }
        });
    }

    public PrivateKey generatePrivate(KeyFactory keyFactory, KeySpec keySpec) {
        return keyFactory.generatePrivate(keySpec);
    }

    public PublicKey generatePublic(final KeySpec keySpec) {
        return (PublicKey) fallback(KeyFactory.class, new CheckedFunction<KeyFactory, PublicKey>() {
            public PublicKey apply(KeyFactory keyFactory) {
                return keyFactory.generatePublic(keySpec);
            }
        });
    }

    public SecretKey generateSecretKey(final int i10) {
        return (SecretKey) withKeyGenerator(new CheckedFunction<KeyGenerator, SecretKey>() {
            public SecretKey apply(KeyGenerator keyGenerator) {
                keyGenerator.init(i10, JcaTemplate.this.secureRandom);
                return keyGenerator.generateKey();
            }
        });
    }

    public X509Certificate generateX509Certificate(final byte[] bArr) {
        return (X509Certificate) fallback(CertificateFactory.class, new CheckedFunction<CertificateFactory, X509Certificate>() {
            public X509Certificate apply(CertificateFactory certificateFactory) {
                return (X509Certificate) certificateFactory.generateCertificate(Streams.of(bArr));
            }
        });
    }

    public boolean isJdk11() {
        return System.getProperty("java.version").startsWith(AgooConstants.ACK_BODY_NULL);
    }

    public <R> R withAlgorithmParameters(CheckedFunction<AlgorithmParameters, R> checkedFunction) {
        return execute(AlgorithmParameters.class, checkedFunction);
    }

    public <R> R withCertificateFactory(CheckedFunction<CertificateFactory, R> checkedFunction) {
        return execute(CertificateFactory.class, checkedFunction);
    }

    public <R> R withCipher(CheckedFunction<Cipher, R> checkedFunction) {
        return execute(Cipher.class, checkedFunction);
    }

    public <R> R withKeyAgreement(CheckedFunction<KeyAgreement, R> checkedFunction) {
        return execute(KeyAgreement.class, checkedFunction);
    }

    public <R> R withKeyFactory(CheckedFunction<KeyFactory, R> checkedFunction) {
        return execute(KeyFactory.class, checkedFunction);
    }

    public <R> R withKeyGenerator(CheckedFunction<KeyGenerator, R> checkedFunction) {
        return execute(KeyGenerator.class, checkedFunction);
    }

    public <R> R withKeyPairGenerator(CheckedFunction<KeyPairGenerator, R> checkedFunction) {
        return execute(KeyPairGenerator.class, checkedFunction);
    }

    public <R> R withMac(CheckedFunction<Mac, R> checkedFunction) {
        return execute(Mac.class, checkedFunction);
    }

    public <R> R withMessageDigest(CheckedFunction<MessageDigest, R> checkedFunction) {
        return execute(MessageDigest.class, checkedFunction);
    }

    public <R> R withSecretKeyFactory(CheckedFunction<SecretKeyFactory, R> checkedFunction) {
        return execute(SecretKeyFactory.class, checkedFunction);
    }

    public <R> R withSignature(CheckedFunction<Signature, R> checkedFunction) {
        return execute(Signature.class, checkedFunction);
    }

    public JcaTemplate(String str, Provider provider2) {
        this(str, provider2, (SecureRandom) null);
    }

    public KeyPair generateKeyPair(final int i10) {
        return (KeyPair) withKeyPairGenerator(new CheckedFunction<KeyPairGenerator, KeyPair>() {
            public KeyPair apply(KeyPairGenerator keyPairGenerator) {
                keyPairGenerator.initialize(i10, JcaTemplate.this.secureRandom);
                return keyPairGenerator.generateKeyPair();
            }
        });
    }

    public PrivateKey generatePrivate(final KeySpec keySpec) {
        return (PrivateKey) fallback(KeyFactory.class, new CheckedFunction<KeyFactory, PrivateKey>() {
            public PrivateKey apply(KeyFactory keyFactory) {
                try {
                    return JcaTemplate.this.generatePrivate(keyFactory, keySpec);
                } catch (InvalidKeySpecException e10) {
                    KeySpec access$300 = JcaTemplate.this.respecIfNecessary(e10, keySpec);
                    if (access$300 != null) {
                        return JcaTemplate.this.generatePrivate(keyFactory, access$300);
                    }
                    throw e10;
                }
            }
        });
    }

    public JcaTemplate(String str, Provider provider2, SecureRandom secureRandom2) {
        this.jcaName = (String) Assert.hasText(str, "jcaName string cannot be null or empty.");
        this.secureRandom = secureRandom2 == null ? Randoms.secureRandom() : secureRandom2;
        this.provider = provider2;
    }

    public KeyPair generateKeyPair(final AlgorithmParameterSpec algorithmParameterSpec) {
        return (KeyPair) withKeyPairGenerator(new CheckedFunction<KeyPairGenerator, KeyPair>() {
            public KeyPair apply(KeyPairGenerator keyPairGenerator) {
                keyPairGenerator.initialize(algorithmParameterSpec, JcaTemplate.this.secureRandom);
                return keyPairGenerator.generateKeyPair();
            }
        });
    }

    public static abstract class JcaInstanceFactory<T> implements InstanceFactory<T> {
        private final ConcurrentMap<String, Boolean> FALLBACK_ATTEMPTS = new ConcurrentHashMap();
        private final Class<T> clazz;

        public JcaInstanceFactory(Class<T> cls) {
            this.clazz = (Class) Assert.notNull(cls, "Class argument cannot be null.");
        }

        public abstract T doGet(String str, Provider provider);

        public Provider findBouncyCastle() {
            return Providers.findBouncyCastle();
        }

        public final T get(String str, Provider provider) {
            Provider provider2;
            Provider findBouncyCastle;
            Assert.hasText(str, "jcaName cannot be null or empty.");
            Boolean bool = this.FALLBACK_ATTEMPTS.get(str);
            if (provider != null || bool == null || !bool.booleanValue()) {
                provider2 = provider;
            } else {
                provider2 = findBouncyCastle();
            }
            try {
                return doGet(str, provider2);
            } catch (NoSuchAlgorithmException e10) {
                if (provider == null && bool == null && (findBouncyCastle = findBouncyCastle()) != null) {
                    T doGet = doGet(str, findBouncyCastle);
                    this.FALLBACK_ATTEMPTS.putIfAbsent(str, Boolean.TRUE);
                    return doGet;
                }
                throw wrap(e10, str, provider, (Provider) null);
            } catch (Exception e11) {
                throw wrap(e11, str, provider, (Provider) null);
            } catch (Throwable unused) {
                this.FALLBACK_ATTEMPTS.putIfAbsent(str, Boolean.FALSE);
                throw wrap(e10, str, provider, (Provider) null);
            }
        }

        public String getId() {
            return this.clazz.getSimpleName();
        }

        public Class<T> getInstanceClass() {
            return this.clazz;
        }

        public Exception wrap(Exception exc, String str, Provider provider, Provider provider2) {
            String str2;
            String str3 = "Unable to obtain '" + str + "' " + getId() + " instance from ";
            if (provider != null) {
                str2 = str3 + "specified '" + provider + "' Provider";
            } else {
                str2 = str3 + "default JCA Provider";
            }
            if (provider2 != null) {
                str2 = str2 + " or fallback '" + provider2 + "' Provider";
            }
            return wrap(str2 + ": " + exc.getMessage(), exc);
        }

        public Exception wrap(String str, Exception exc) {
            if (Signature.class.isAssignableFrom(this.clazz) || Mac.class.isAssignableFrom(this.clazz)) {
                return new SignatureException(str, exc);
            }
            return new SecurityException(str, exc);
        }
    }

    private <T> T execute(Class<?> cls, CheckedSupplier<T> checkedSupplier) {
        try {
            return checkedSupplier.get();
        } catch (SecurityException e10) {
            throw e10;
        } catch (Throwable th) {
            throw new SecurityException(cls.getSimpleName() + " callback execution failed: " + th.getMessage(), th);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T, R> R execute(final java.lang.Class<T> r2, final io.jsonwebtoken.impl.lang.CheckedFunction<T, R> r3) {
        /*
            r1 = this;
            io.jsonwebtoken.impl.security.JcaTemplate$2 r0 = new io.jsonwebtoken.impl.security.JcaTemplate$2
            r0.<init>(r2, r3)
            java.lang.Object r2 = r1.execute((java.lang.Class<?>) r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.JcaTemplate.execute(java.lang.Class, io.jsonwebtoken.impl.lang.CheckedFunction):java.lang.Object");
    }
}
