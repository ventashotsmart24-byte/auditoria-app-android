package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base16;
import com.hpplay.sdk.source.mdns.xbill.dns.utils.base64;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Tokenizer {
    public static final int COMMENT = 5;
    public static final int EOF = 0;
    public static final int EOL = 1;
    public static final int IDENTIFIER = 3;
    public static final int QUOTED_STRING = 4;
    public static final int WHITESPACE = 2;
    private static String delim = " \t\n;()\"";
    private static String quotes = "\"";
    private Token current;
    private String delimiters;
    private String filename;
    private PushbackInputStream is;
    private int line;
    private int multiline;
    private boolean quoting;
    private StringBuffer sb;
    private boolean ungottenToken;
    private boolean wantClose;

    public static class Token {
        public int type;
        public String value;

        /* access modifiers changed from: private */
        public Token set(int i10, StringBuffer stringBuffer) {
            String str;
            if (i10 >= 0) {
                this.type = i10;
                if (stringBuffer == null) {
                    str = null;
                } else {
                    str = stringBuffer.toString();
                }
                this.value = str;
                return this;
            }
            throw new IllegalArgumentException();
        }

        public boolean isString() {
            int i10 = this.type;
            if (i10 == 3 || i10 == 4) {
                return true;
            }
            return false;
        }

        public String toString() {
            int i10 = this.type;
            if (i10 == 0) {
                return "<eof>";
            }
            if (i10 == 1) {
                return "<eol>";
            }
            if (i10 == 2) {
                return "<whitespace>";
            }
            if (i10 == 3) {
                return "<identifier: " + this.value + Operator.Operation.GREATER_THAN;
            } else if (i10 == 4) {
                return "<quoted_string: " + this.value + Operator.Operation.GREATER_THAN;
            } else if (i10 != 5) {
                return "<unknown>";
            } else {
                return "<comment: " + this.value + Operator.Operation.GREATER_THAN;
            }
        }

        private Token() {
            this.type = -1;
            this.value = null;
        }
    }

    public static class TokenizerException extends Exception {
        String message;

        public TokenizerException(String str, int i10, String str2) {
            super(str + SOAP.DELIM + i10 + ": " + str2);
            this.message = str2;
        }

        public String getBaseMessage() {
            return this.message;
        }
    }

    public Tokenizer(InputStream inputStream) {
        this.is = new PushbackInputStream(!(inputStream instanceof BufferedInputStream) ? new BufferedInputStream(inputStream) : inputStream, 2);
        this.ungottenToken = false;
        this.multiline = 0;
        this.quoting = false;
        this.delimiters = delim;
        this.current = new Token();
        this.sb = new StringBuffer();
        this.filename = "<none>";
        this.line = 1;
    }

    private String _getIdentifier(String str) {
        Token token = get();
        if (token.type == 3) {
            return token.value;
        }
        throw exception("expected " + str);
    }

    private void checkUnbalancedParens() {
        if (this.multiline > 0) {
            throw exception("unbalanced parentheses");
        }
    }

    private int getChar() {
        int read = this.is.read();
        if (read == 13) {
            int read2 = this.is.read();
            if (read2 != 10) {
                this.is.unread(read2);
            }
            read = 10;
        }
        if (read == 10) {
            this.line++;
        }
        return read;
    }

    private String remainingStrings() {
        StringBuffer stringBuffer = null;
        while (true) {
            Token token = get();
            if (!token.isString()) {
                break;
            }
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append(token.value);
        }
        unget();
        if (stringBuffer == null) {
            return null;
        }
        return stringBuffer.toString();
    }

    private int skipWhitespace() {
        int i10;
        int i11 = 0;
        while (true) {
            i10 = getChar();
            if (i10 == 32 || i10 == 9 || (i10 == 10 && this.multiline > 0)) {
                i11++;
            }
        }
        ungetChar(i10);
        return i11;
    }

    private void ungetChar(int i10) {
        if (i10 != -1) {
            this.is.unread(i10);
            if (i10 == 10) {
                this.line--;
            }
        }
    }

    public void close() {
        if (this.wantClose) {
            try {
                this.is.close();
            } catch (Exception unused) {
            }
        }
    }

    public Exception exception(String str) {
        return new TokenizerException(this.filename, this.line, str);
    }

    public void finalize() {
        close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0106 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer.Token get(boolean r10, boolean r11) {
        /*
            r9 = this;
            boolean r0 = r9.ungottenToken
            r1 = 5
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0020
            r9.ungottenToken = r4
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r0 = r9.current
            int r5 = r0.type
            if (r5 != r2) goto L_0x0013
            if (r10 == 0) goto L_0x0020
            return r0
        L_0x0013:
            if (r5 == r1) goto L_0x001d
            if (r5 != r3) goto L_0x001c
            int r10 = r9.line
            int r10 = r10 + r3
            r9.line = r10
        L_0x001c:
            return r0
        L_0x001d:
            if (r11 == 0) goto L_0x0020
            return r0
        L_0x0020:
            int r0 = r9.skipWhitespace()
            r5 = 0
            if (r0 <= 0) goto L_0x0030
            if (r10 == 0) goto L_0x0030
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r9.current
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r10.set(r2, r5)
            return r10
        L_0x0030:
            java.lang.StringBuffer r10 = r9.sb
            r10.setLength(r4)
            r10 = 3
        L_0x0036:
            int r0 = r9.getChar()
            r2 = 10
            r6 = -1
            if (r0 == r6) goto L_0x0074
            java.lang.String r7 = r9.delimiters
            int r7 = r7.indexOf(r0)
            if (r7 == r6) goto L_0x0048
            goto L_0x0074
        L_0x0048:
            r7 = 92
            if (r0 != r7) goto L_0x005f
            int r0 = r9.getChar()
            if (r0 == r6) goto L_0x0058
            java.lang.StringBuffer r2 = r9.sb
            r2.append(r7)
            goto L_0x006d
        L_0x0058:
            java.lang.String r10 = "unterminated escape sequence"
            java.lang.Exception r10 = r9.exception(r10)
            throw r10
        L_0x005f:
            boolean r6 = r9.quoting
            if (r6 == 0) goto L_0x006d
            if (r0 == r2) goto L_0x0066
            goto L_0x006d
        L_0x0066:
            java.lang.String r10 = "newline in quoted string"
            java.lang.Exception r10 = r9.exception(r10)
            throw r10
        L_0x006d:
            java.lang.StringBuffer r2 = r9.sb
            char r0 = (char) r0
            r2.append(r0)
            goto L_0x0036
        L_0x0074:
            if (r0 != r6) goto L_0x0099
            boolean r11 = r9.quoting
            if (r11 != 0) goto L_0x0092
            java.lang.StringBuffer r11 = r9.sb
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0089
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r9.current
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r10.set(r4, r5)
            return r10
        L_0x0089:
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r11 = r9.current
            java.lang.StringBuffer r0 = r9.sb
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r11.set(r10, r0)
            return r10
        L_0x0092:
            java.lang.String r10 = "EOF in quoted string"
            java.lang.Exception r10 = r9.exception(r10)
            throw r10
        L_0x0099:
            java.lang.StringBuffer r7 = r9.sb
            int r7 = r7.length()
            r8 = 4
            if (r7 != 0) goto L_0x013b
            if (r10 != r8) goto L_0x00a6
            goto L_0x013b
        L_0x00a6:
            r7 = 40
            if (r0 != r7) goto L_0x00b3
            int r0 = r9.multiline
            int r0 = r0 + r3
            r9.multiline = r0
            r9.skipWhitespace()
            goto L_0x0036
        L_0x00b3:
            r7 = 41
            if (r0 != r7) goto L_0x00cb
            int r0 = r9.multiline
            if (r0 <= 0) goto L_0x00c4
            int r0 = r0 + -1
            r9.multiline = r0
            r9.skipWhitespace()
            goto L_0x0036
        L_0x00c4:
            java.lang.String r10 = "invalid release parenthesis"
            java.lang.Exception r10 = r9.exception(r10)
            throw r10
        L_0x00cb:
            r7 = 34
            if (r0 != r7) goto L_0x00e7
            boolean r0 = r9.quoting
            if (r0 != 0) goto L_0x00dc
            r9.quoting = r3
            java.lang.String r10 = quotes
            r9.delimiters = r10
            r10 = 4
            goto L_0x0036
        L_0x00dc:
            r9.quoting = r4
            java.lang.String r0 = delim
            r9.delimiters = r0
            r9.skipWhitespace()
            goto L_0x0036
        L_0x00e7:
            if (r0 != r2) goto L_0x00f0
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r9.current
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r10.set(r3, r5)
            return r10
        L_0x00f0:
            r7 = 59
            if (r0 != r7) goto L_0x0135
        L_0x00f4:
            int r0 = r9.getChar()
            if (r0 == r2) goto L_0x0104
            if (r0 != r6) goto L_0x00fd
            goto L_0x0104
        L_0x00fd:
            java.lang.StringBuffer r7 = r9.sb
            char r0 = (char) r0
            r7.append(r0)
            goto L_0x00f4
        L_0x0104:
            if (r11 == 0) goto L_0x0112
            r9.ungetChar(r0)
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r9.current
            java.lang.StringBuffer r11 = r9.sb
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r10.set(r1, r11)
            return r10
        L_0x0112:
            if (r0 != r6) goto L_0x0120
            if (r10 == r8) goto L_0x0120
            r9.checkUnbalancedParens()
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r9.current
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r10.set(r4, r5)
            return r10
        L_0x0120:
            int r0 = r9.multiline
            if (r0 > 0) goto L_0x012b
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r9.current
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r10.set(r3, r5)
            return r10
        L_0x012b:
            r9.skipWhitespace()
            java.lang.StringBuffer r0 = r9.sb
            r0.setLength(r4)
            goto L_0x0036
        L_0x0135:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>()
            throw r10
        L_0x013b:
            r9.ungetChar(r0)
            java.lang.StringBuffer r11 = r9.sb
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0152
            if (r10 == r8) goto L_0x0152
            r9.checkUnbalancedParens()
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r9.current
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r10.set(r4, r5)
            return r10
        L_0x0152:
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r11 = r9.current
            java.lang.StringBuffer r0 = r9.sb
            com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token r10 = r11.set(r10, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer.get(boolean, boolean):com.hpplay.sdk.source.mdns.xbill.dns.Tokenizer$Token");
    }

    public InetAddress getAddress(int i10) {
        try {
            return Address.getByAddress(_getIdentifier("an address"), i10);
        } catch (UnknownHostException e10) {
            throw exception(e10.getMessage());
        }
    }

    public byte[] getAddressBytes(int i10) {
        String _getIdentifier = _getIdentifier("an address");
        byte[] byteArray = Address.toByteArray(_getIdentifier, i10);
        if (byteArray != null) {
            return byteArray;
        }
        throw exception("Invalid address: " + _getIdentifier);
    }

    public byte[] getBase64(boolean z10) {
        String remainingStrings = remainingStrings();
        if (remainingStrings != null) {
            byte[] fromString = base64.fromString(remainingStrings);
            if (fromString != null) {
                return fromString;
            }
            throw exception("invalid base64 encoding");
        } else if (!z10) {
            return null;
        } else {
            throw exception("expected base64 encoded string");
        }
    }

    public void getEOL() {
        int i10 = get().type;
        if (i10 != 1 && i10 != 0) {
            throw exception("expected EOL or EOF");
        }
    }

    public byte[] getHex(boolean z10) {
        String remainingStrings = remainingStrings();
        if (remainingStrings != null) {
            byte[] fromString = base16.fromString(remainingStrings);
            if (fromString != null) {
                return fromString;
            }
            throw exception("invalid hex encoding");
        } else if (!z10) {
            return null;
        } else {
            throw exception("expected hex encoded string");
        }
    }

    public String getIdentifier() {
        return _getIdentifier("an identifier");
    }

    public long getLong() {
        String _getIdentifier = _getIdentifier("an integer");
        if (Character.isDigit(_getIdentifier.charAt(0))) {
            try {
                return Long.parseLong(_getIdentifier);
            } catch (NumberFormatException unused) {
                throw exception("expected an integer");
            }
        } else {
            throw exception("expected an integer");
        }
    }

    public Name getName(Name name) {
        try {
            Name fromString = Name.fromString(_getIdentifier("a name"), name);
            if (fromString.isAbsolute()) {
                return fromString;
            }
            throw new Exception("name.isAbsolute");
        } catch (Exception e10) {
            throw exception(e10.getMessage());
        }
    }

    public String getString() {
        Token token = get();
        if (token.isString()) {
            return token.value;
        }
        throw exception("expected a string");
    }

    public long getTTL() {
        try {
            return TTL.parseTTL(_getIdentifier("a TTL value"));
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL value");
        }
    }

    public long getTTLLike() {
        try {
            return TTL.parse(_getIdentifier("a TTL-like value"), false);
        } catch (NumberFormatException unused) {
            throw exception("expected a TTL-like value");
        }
    }

    public int getUInt16() {
        long j10 = getLong();
        if (j10 >= 0 && j10 <= 65535) {
            return (int) j10;
        }
        throw exception("expected an 16 bit unsigned integer");
    }

    public long getUInt32() {
        long j10 = getLong();
        if (j10 >= 0 && j10 <= 4294967295L) {
            return j10;
        }
        throw exception("expected an 32 bit unsigned integer");
    }

    public int getUInt8() {
        long j10 = getLong();
        if (j10 >= 0 && j10 <= 255) {
            return (int) j10;
        }
        throw exception("expected an 8 bit unsigned integer");
    }

    public void unget() {
        if (!this.ungottenToken) {
            if (this.current.type == 1) {
                this.line--;
            }
            this.ungottenToken = true;
            return;
        }
        throw new IllegalStateException("Cannot unget multiple tokens");
    }

    public byte[] getBase64() {
        return getBase64(false);
    }

    public byte[] getHex() {
        return getHex(false);
    }

    public Tokenizer(String str) {
        this((InputStream) new ByteArrayInputStream(str.getBytes()));
    }

    public Tokenizer(File file) {
        this((InputStream) new FileInputStream(file));
        this.wantClose = true;
        this.filename = file.getName();
    }

    public Token get() {
        return get(false, false);
    }
}
