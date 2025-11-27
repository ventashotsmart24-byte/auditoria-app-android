package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() {
        @CheckForNull
        public char[] escape(char c10) {
            return null;
        }

        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }
    };

    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        /* access modifiers changed from: private */
        @CheckForNull
        public String unsafeReplacement;

        @CanIgnoreReturnValue
        public Builder addEscape(char c10, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c10), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                @CheckForNull
                private final char[] replacementChars;

                {
                    char[] cArr;
                    if (Builder.this.unsafeReplacement != null) {
                        cArr = Builder.this.unsafeReplacement.toCharArray();
                    } else {
                        cArr = null;
                    }
                    this.replacementChars = cArr;
                }

                @CheckForNull
                public char[] escapeUnsafe(char c10) {
                    return this.replacementChars;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c10, char c11) {
            this.safeMin = c10;
            this.safeMax = c11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(String str) {
            this.unsafeReplacement = str;
            return this;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = 65535;
            this.unsafeReplacement = null;
        }
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        String str;
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        String name = escaper.getClass().getName();
        if (name.length() != 0) {
            str = "Cannot create a UnicodeEscaper from: ".concat(name);
        } else {
            str = new String("Cannot create a UnicodeEscaper from: ");
        }
        throw new IllegalArgumentException(str);
    }

    public static Builder builder() {
        return new Builder();
    }

    @CheckForNull
    public static String computeReplacement(CharEscaper charEscaper, char c10) {
        return stringOrNull(charEscaper.escape(c10));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    @CheckForNull
    private static String stringOrNull(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            @CheckForNull
            public char[] escape(int i10) {
                int i11;
                int i12;
                if (i10 < 65536) {
                    return CharEscaper.this.escape((char) i10);
                }
                char[] cArr = new char[2];
                Character.toChars(i10, cArr, 0);
                char[] escape = CharEscaper.this.escape(cArr[0]);
                char[] escape2 = CharEscaper.this.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                if (escape != null) {
                    i11 = escape.length;
                } else {
                    i11 = 1;
                }
                if (escape2 != null) {
                    i12 = escape2.length;
                } else {
                    i12 = 1;
                }
                char[] cArr2 = new char[(i12 + i11)];
                if (escape != null) {
                    for (int i13 = 0; i13 < escape.length; i13++) {
                        cArr2[i13] = escape[i13];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i14 = 0; i14 < escape2.length; i14++) {
                        cArr2[i11 + i14] = escape2[i14];
                    }
                } else {
                    cArr2[i11] = cArr[1];
                }
                return cArr2;
            }
        };
    }

    @CheckForNull
    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i10) {
        return stringOrNull(unicodeEscaper.escape(i10));
    }
}
