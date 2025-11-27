package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;

public final class KeyPairs {
    private KeyPairs() {
    }

    public static <K> K assertKey(Key key, Class<K> cls, String str) {
        String str2;
        Assert.notNull(key, "Key argument cannot be null.");
        Assert.notNull(cls, "Class argument cannot be null.");
        if (key instanceof PrivateKey) {
            str2 = "private";
        } else {
            str2 = "public";
        }
        if (cls.isInstance(key)) {
            return cls.cast(key);
        }
        throw new IllegalArgumentException(str + str2 + " key must be an instance of " + cls.getName() + ". Type found: " + key.getClass().getName());
    }

    private static String familyPrefix(Class<?> cls) {
        if (RSAKey.class.isAssignableFrom(cls)) {
            return "RSA ";
        }
        if (ECKey.class.isAssignableFrom(cls)) {
            return "EC ";
        }
        return "";
    }

    public static <K> K getKey(KeyPair keyPair, Class<K> cls) {
        Key key;
        Assert.notNull(keyPair, "KeyPair cannot be null.");
        String str = familyPrefix(cls) + "KeyPair ";
        if (PrivateKey.class.isAssignableFrom(cls)) {
            key = keyPair.getPrivate();
        } else {
            key = keyPair.getPublic();
        }
        return assertKey(key, cls, str);
    }
}
