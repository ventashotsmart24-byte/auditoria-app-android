package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import java.util.Map;

class DefaultTokenizedJwe extends DefaultTokenizedJwt implements TokenizedJwe {
    private final CharSequence encryptedKey;
    private final CharSequence iv;

    public DefaultTokenizedJwe(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        super(charSequence, charSequence2, charSequence3);
        this.encryptedKey = charSequence4;
        this.iv = charSequence5;
    }

    public Header createHeader(Map<String, ?> map) {
        return new DefaultJweHeader(map);
    }

    public CharSequence getEncryptedKey() {
        return this.encryptedKey;
    }

    public CharSequence getIv() {
        return this.iv;
    }
}
