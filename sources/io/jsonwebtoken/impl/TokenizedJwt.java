package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import java.util.Map;

public interface TokenizedJwt {
    Header createHeader(Map<String, ?> map);

    CharSequence getDigest();

    CharSequence getPayload();

    CharSequence getProtected();
}
