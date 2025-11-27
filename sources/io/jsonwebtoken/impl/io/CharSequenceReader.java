package io.jsonwebtoken.impl.io;

import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

public class CharSequenceReader extends Reader implements Serializable {
    private static final long serialVersionUID = 3724187752191401220L;
    private final CharSequence charSequence;
    private final Integer end;
    private int idx;
    private int mark;
    private final int start;

    public CharSequenceReader(CharSequence charSequence2) {
        this(charSequence2, 0);
    }

    private int end() {
        int i10;
        int length = this.charSequence.length();
        Integer num = this.end;
        if (num == null) {
            i10 = Integer.MAX_VALUE;
        } else {
            i10 = num.intValue();
        }
        return Math.min(length, i10);
    }

    private int start() {
        return Math.min(this.charSequence.length(), this.start);
    }

    public void close() {
        int i10 = this.start;
        this.idx = i10;
        this.mark = i10;
    }

    public void mark(int i10) {
        this.mark = this.idx;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (this.idx >= end()) {
            return -1;
        }
        CharSequence charSequence2 = this.charSequence;
        int i10 = this.idx;
        this.idx = i10 + 1;
        return charSequence2.charAt(i10);
    }

    public boolean ready() {
        if (this.idx < end()) {
            return true;
        }
        return false;
    }

    public void reset() {
        this.idx = this.mark;
    }

    public long skip(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j10);
        } else if (this.idx >= end()) {
            return 0;
        } else {
            int min = (int) Math.min((long) end(), ((long) this.idx) + j10);
            this.idx = min;
            return (long) (min - this.idx);
        }
    }

    public String toString() {
        return this.charSequence.subSequence(start(), end()).toString();
    }

    public CharSequenceReader(CharSequence charSequence2, int i10) {
        this(charSequence2, i10, Integer.MAX_VALUE);
    }

    public CharSequenceReader(String str, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Start index is less than zero: " + i10);
        } else if (i11 >= i10) {
            this.charSequence = str == null ? "" : str;
            this.start = i10;
            this.end = Integer.valueOf(i11);
            this.idx = i10;
            this.mark = i10;
        } else {
            throw new IllegalArgumentException("End index is less than start " + i10 + ": " + i11);
        }
    }

    public int read(char[] cArr, int i10, int i11) {
        if (this.idx >= end()) {
            return -1;
        }
        Objects.requireNonNull(cArr, "array");
        if (i11 < 0 || i10 < 0 || i10 + i11 > cArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i10 + ", length=" + i11);
        }
        CharSequence charSequence2 = this.charSequence;
        if (charSequence2 instanceof String) {
            int min = Math.min(i11, end() - this.idx);
            int i12 = this.idx;
            ((String) this.charSequence).getChars(i12, i12 + min, cArr, i10);
            this.idx += min;
            return min;
        } else if (charSequence2 instanceof StringBuilder) {
            int min2 = Math.min(i11, end() - this.idx);
            int i13 = this.idx;
            ((StringBuilder) this.charSequence).getChars(i13, i13 + min2, cArr, i10);
            this.idx += min2;
            return min2;
        } else if (charSequence2 instanceof StringBuffer) {
            int min3 = Math.min(i11, end() - this.idx);
            int i14 = this.idx;
            ((StringBuffer) this.charSequence).getChars(i14, i14 + min3, cArr, i10);
            this.idx += min3;
            return min3;
        } else {
            int i15 = 0;
            for (int i16 = 0; i16 < i11; i16++) {
                int read = read();
                if (read == -1) {
                    return i15;
                }
                cArr[i10 + i16] = (char) read;
                i15++;
            }
            return i15;
        }
    }
}
