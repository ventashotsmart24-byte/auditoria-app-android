package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.lang.Strings;
import java.util.Map;

class DefaultTokenizedJwt implements TokenizedJwt {
    private final CharSequence digest;
    private final CharSequence payload;
    private final CharSequence protectedHeader;

    public DefaultTokenizedJwt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.protectedHeader = charSequence;
        this.payload = charSequence2;
        this.digest = charSequence3;
    }

    public Header createHeader(Map<String, ?> map) {
        if (Strings.hasText(getDigest())) {
            return new DefaultJwsHeader(map);
        }
        return new DefaultHeader(map);
    }

    public CharSequence getDigest() {
        return this.digest;
    }

    public CharSequence getPayload() {
        return this.payload;
    }

    public CharSequence getProtected() {
        return this.protectedHeader;
    }
}
