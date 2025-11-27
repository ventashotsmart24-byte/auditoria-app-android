package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    public static int codePointAt(CharSequence charSequence, int i10, int i11) {
        Preconditions.checkNotNull(charSequence);
        if (i10 < i11) {
            int i12 = i10 + 1;
            char charAt = charSequence.charAt(i10);
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                String valueOf = String.valueOf(charSequence);
                StringBuilder sb = new StringBuilder(valueOf.length() + 88);
                sb.append("Unexpected low surrogate character '");
                sb.append(charAt);
                sb.append("' with value ");
                sb.append(charAt);
                sb.append(" at index ");
                sb.append(i12 - 1);
                sb.append(" in '");
                sb.append(valueOf);
                sb.append("'");
                throw new IllegalArgumentException(sb.toString());
            } else if (i12 == i11) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i12);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                String valueOf2 = String.valueOf(charSequence);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 89);
                sb2.append("Expected low surrogate but got char '");
                sb2.append(charAt2);
                sb2.append("' with value ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(i12);
                sb2.append(" in '");
                sb2.append(valueOf2);
                sb2.append("'");
                throw new IllegalArgumentException(sb2.toString());
            }
        } else {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    private static char[] growBuffer(char[] cArr, int i10, int i11) {
        if (i11 >= 0) {
            char[] cArr2 = new char[i11];
            if (i10 > 0) {
                System.arraycopy(cArr, 0, cArr2, 0, i10);
            }
            return cArr2;
        }
        throw new AssertionError("Cannot increase internal buffer any further");
    }

    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int nextEscapeIndex = nextEscapeIndex(str, 0, length);
        return nextEscapeIndex == length ? str : escapeSlow(str, nextEscapeIndex);
    }

    @CheckForNull
    public abstract char[] escape(int i10);

    public final String escapeSlow(String str, int i10) {
        int i11;
        int length = str.length();
        char[] charBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i12 = 0;
        int i13 = 0;
        while (i10 < length) {
            int codePointAt = codePointAt(str, i10, length);
            if (codePointAt >= 0) {
                char[] escape = escape(codePointAt);
                if (Character.isSupplementaryCodePoint(codePointAt)) {
                    i11 = 2;
                } else {
                    i11 = 1;
                }
                int i14 = i11 + i10;
                if (escape != null) {
                    int i15 = i10 - i12;
                    int i16 = i13 + i15;
                    int length2 = escape.length + i16;
                    if (charBufferFromThreadLocal.length < length2) {
                        charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i13, length2 + (length - i10) + 32);
                    }
                    if (i15 > 0) {
                        str.getChars(i12, i10, charBufferFromThreadLocal, i13);
                        i13 = i16;
                    }
                    if (escape.length > 0) {
                        System.arraycopy(escape, 0, charBufferFromThreadLocal, i13, escape.length);
                        i13 += escape.length;
                    }
                    i12 = i14;
                }
                i10 = nextEscapeIndex(str, i14, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i17 = length - i12;
        if (i17 > 0) {
            int i18 = i17 + i13;
            if (charBufferFromThreadLocal.length < i18) {
                charBufferFromThreadLocal = growBuffer(charBufferFromThreadLocal, i13, i18);
            }
            str.getChars(i12, length, charBufferFromThreadLocal, i13);
            i13 = i18;
        }
        return new String(charBufferFromThreadLocal, 0, i13);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i10, int i11) {
        int i12;
        while (i10 < i11) {
            int codePointAt = codePointAt(charSequence, i10, i11);
            if (codePointAt < 0 || escape(codePointAt) != null) {
                break;
            }
            if (Character.isSupplementaryCodePoint(codePointAt)) {
                i12 = 2;
            } else {
                i12 = 1;
            }
            i10 += i12;
        }
        return i10;
    }
}
