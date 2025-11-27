package io.jsonwebtoken.impl;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.io.IOException;
import java.io.Reader;

public class JwtTokenizer {
    static final char DELIMITER = '.';
    private static final String DELIM_ERR_MSG_PREFIX = "Invalid compact JWT string: Compact JWSs must contain exactly 2 period characters, and compact JWEs must contain exactly 4.  Found: ";

    private static int read(Reader reader, char[] cArr) {
        try {
            return reader.read(cArr);
        } catch (IOException e10) {
            throw new MalformedJwtException("Unable to read compact JWT: " + e10.getMessage(), e10);
        }
    }

    public <T extends TokenizedJwt> T tokenize(Reader reader) {
        String str;
        Assert.notNull(reader, "Reader argument cannot be null.");
        char[] cArr = new char[4096];
        StringBuilder sb = new StringBuilder(4096);
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        int i10 = 0;
        int i11 = 0;
        while (i10 != -1) {
            i10 = read(reader, cArr);
            int i12 = 0;
            while (true) {
                if (i12 < i10) {
                    char c10 = cArr[i12];
                    if (!Character.isWhitespace(c10)) {
                        if (c10 == '.') {
                            CharSequence clean = Strings.clean((CharSequence) sb);
                            if (clean != null) {
                                str = clean.toString();
                            } else {
                                str = str2;
                            }
                            if (i11 == 0) {
                                str3 = str;
                            } else if (i11 == 1) {
                                str4 = str;
                                str5 = str4;
                            } else if (i11 == 2) {
                                str4 = str2;
                                str6 = str;
                            } else if (i11 == 3) {
                                str4 = str;
                            }
                            i11++;
                            sb.setLength(0);
                        } else {
                            sb.append(c10);
                        }
                        i12++;
                    } else {
                        throw new MalformedJwtException("Compact JWT strings may not contain whitespace.");
                    }
                }
            }
        }
        if (i11 == 2 || i11 == 4) {
            if (sb.length() > 0) {
                str2 = sb.toString();
            }
            if (i11 == 2) {
                return new DefaultTokenizedJwt(str3, str4, str2);
            }
            return new DefaultTokenizedJwe(str3, str4, str2, str5, str6);
        }
        throw new MalformedJwtException(DELIM_ERR_MSG_PREFIX + i11);
    }
}
