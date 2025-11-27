package com.google.android.gms.common.server.response;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.hpplay.component.common.ParamsMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', '\"'};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaf = {10};
    private static final zai zag = new zaa();
    private static final zai zah = new zab();
    private static final zai zai = new zac();
    private static final zai zaj = new zad();
    private static final zai zak = new zae();
    private static final zai zal = new zaf();
    private static final zai zam = new zag();
    private static final zai zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack zat = new Stack();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z10 = false;
        boolean z11 = false;
        loop0:
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                for (int i10 = 0; i10 < read; i10++) {
                    char c10 = cArr[i10];
                    if (Character.isISOControl(c10)) {
                        if (cArr2 == null) {
                            break loop0;
                        }
                        int i11 = 0;
                        while (i11 <= 0) {
                            if (cArr2[i11] != c10) {
                                i11++;
                            }
                        }
                        break loop0;
                    }
                    if (c10 == '\"') {
                        if (!z11) {
                            sb.append(cArr, 0, i10);
                            bufferedReader.reset();
                            bufferedReader.skip((long) (i10 + 1));
                            if (z10) {
                                return JsonUtils.unescapeString(sb.toString());
                            }
                            return sb.toString();
                        }
                    } else if (c10 == '\\') {
                        z11 = !z11;
                        z10 = true;
                    }
                    z11 = false;
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    private final char zai(BufferedReader bufferedReader) {
        if (bufferedReader.read(this.zao) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zao[0])) {
            if (bufferedReader.read(this.zao) == -1) {
                return 0;
            }
        }
        return this.zao[0];
    }

    /* access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) {
        int i10;
        int i11;
        int i12;
        int i13;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            char c10 = cArr[0];
            if (c10 == '-') {
                i10 = Integer.MIN_VALUE;
            } else {
                i10 = ParamsMap.MirrorParams.CAPTRUESOURCE_FLAG_MIUI;
            }
            if (c10 == '-') {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (i11 < zam2) {
                i13 = i11 + 1;
                int digit = Character.digit(cArr[i11], 10);
                if (digit >= 0) {
                    i12 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i13 = i11;
                i12 = 0;
            }
            while (i13 < zam2) {
                int i14 = i13 + 1;
                int digit2 = Character.digit(cArr[i13], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i12 >= -214748364) {
                    int i15 = i12 * 10;
                    if (i15 >= i10 + digit2) {
                        i12 = i15 - digit2;
                        i13 = i14;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i11 == 0) {
                return -i12;
            }
            if (i13 > 1) {
                return i12;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private final int zam(BufferedReader bufferedReader, char[] cArr) {
        int i10;
        char zai2 = zai(bufferedReader);
        if (zai2 == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (zai2 == ',') {
            throw new ParseException("Missing value");
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zai2 == '\"') {
                i10 = 0;
                boolean z10 = false;
                while (i10 < 1024 && bufferedReader.read(cArr, i10, 1) != -1) {
                    char c10 = cArr[i10];
                    if (!Character.isISOControl(c10)) {
                        if (c10 == '\"') {
                            if (!z10) {
                                bufferedReader.reset();
                                bufferedReader.skip((long) (i10 + 1));
                                return i10;
                            }
                        } else if (c10 == '\\') {
                            z10 = !z10;
                            i10++;
                        }
                        z10 = false;
                        i10++;
                    } else {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
            } else {
                cArr[0] = zai2;
                int i11 = 1;
                while (i10 < 1024 && bufferedReader.read(cArr, i10, 1) != -1) {
                    char c11 = cArr[i10];
                    if (c11 == '}' || c11 == ',' || Character.isWhitespace(c11) || cArr[i10] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i10 - 1));
                        cArr[i10] = 0;
                        return i10;
                    }
                    i11 = i10 + 1;
                }
            }
            if (i10 == 1024) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    /* access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) {
        long j10;
        long j11;
        int i10;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            int i11 = 0;
            char c10 = cArr[0];
            if (c10 == '-') {
                j10 = Long.MIN_VALUE;
            } else {
                j10 = -9223372036854775807L;
            }
            if (c10 == '-') {
                i11 = 1;
            }
            if (i11 < zam2) {
                i10 = i11 + 1;
                int digit = Character.digit(cArr[i11], 10);
                if (digit >= 0) {
                    j11 = (long) (-digit);
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j11 = 0;
                i10 = i11;
            }
            while (i10 < zam2) {
                int i12 = i10 + 1;
                int digit2 = Character.digit(cArr[i10], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j11 >= -922337203685477580L) {
                    long j12 = j11 * 10;
                    long j13 = (long) digit2;
                    if (j12 >= j10 + j13) {
                        j11 = j12 - j13;
                        i10 = i12;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i11 == 0) {
                return -j11;
            }
            if (i10 > 1) {
                return j11;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final String zao(BufferedReader bufferedReader) {
        return zap(bufferedReader, this.zap, this.zar, (char[]) null);
    }

    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            return zaA(bufferedReader, cArr, sb, cArr2);
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        throw new ParseException("Expected string");
    }

    private final String zaq(BufferedReader bufferedReader) {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, (char[]) null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        } else if (zai2 == '}') {
            zaw(2);
            return null;
        } else {
            throw new ParseException("Unexpected token: " + zai2);
        }
    }

    private final String zar(BufferedReader bufferedReader) {
        bufferedReader.mark(1024);
        char zai2 = zai(bufferedReader);
        int i10 = 1;
        if (zai2 != '\"') {
            if (zai2 != ',') {
                if (zai2 == '[') {
                    this.zat.push(5);
                    bufferedReader.mark(32);
                    if (zai(bufferedReader) != ']') {
                        bufferedReader.reset();
                        boolean z10 = false;
                        loop1:
                        while (true) {
                            boolean z11 = false;
                            while (i10 > 0) {
                                char zai3 = zai(bufferedReader);
                                if (zai3 == 0) {
                                    throw new ParseException("Unexpected EOF while parsing array");
                                } else if (!Character.isISOControl(zai3)) {
                                    if (zai3 == '\"') {
                                        if (!z11) {
                                            z10 = !z10;
                                        }
                                        zai3 = '\"';
                                    }
                                    if (zai3 == '[') {
                                        if (!z10) {
                                            i10++;
                                        }
                                        zai3 = '[';
                                    }
                                    if (zai3 == ']' && !z10) {
                                        i10--;
                                    }
                                    if (zai3 == '\\' && z10) {
                                        z11 = !z11;
                                    }
                                } else {
                                    throw new ParseException("Unexpected control character while reading array");
                                }
                            }
                            zaw(5);
                            break loop1;
                        }
                    } else {
                        zaw(5);
                    }
                } else if (zai2 != '{') {
                    bufferedReader.reset();
                    zam(bufferedReader, this.zaq);
                } else {
                    this.zat.push(1);
                    bufferedReader.mark(32);
                    char zai4 = zai(bufferedReader);
                    if (zai4 == '}') {
                        zaw(1);
                    } else if (zai4 == '\"') {
                        bufferedReader.reset();
                        zaq(bufferedReader);
                        do {
                        } while (zar(bufferedReader) != null);
                        zaw(1);
                    } else {
                        throw new ParseException("Unexpected token " + zai4);
                    }
                }
            } else {
                throw new ParseException("Missing value");
            }
        } else if (bufferedReader.read(this.zao) != -1) {
            char c10 = this.zao[0];
            boolean z12 = false;
            do {
                if (c10 == '\"') {
                    if (z12) {
                        c10 = '\"';
                        z12 = true;
                    }
                }
                if (c10 == '\\') {
                    z12 = !z12;
                } else {
                    z12 = false;
                }
                if (bufferedReader.read(this.zao) != -1) {
                    c10 = this.zao[0];
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
            } while (!Character.isISOControl(c10));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        } else if (zai5 == '}') {
            zaw(2);
            return null;
        } else {
            throw new ParseException("Unexpected token " + zai5);
        }
    }

    /* access modifiers changed from: private */
    public final BigDecimal zas(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final BigInteger zat(BufferedReader bufferedReader) {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    private final ArrayList zau(BufferedReader bufferedReader, zai zai2) {
        char zai3 = zai(bufferedReader);
        if (zai3 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        } else if (zai3 == '[') {
            this.zat.push(5);
            ArrayList arrayList = new ArrayList();
            while (true) {
                bufferedReader.mark(1024);
                char zai4 = zai(bufferedReader);
                if (zai4 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (zai4 != ',') {
                    if (zai4 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zai2.zaa(this, bufferedReader));
                    } else {
                        zaw(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) {
        ArrayList arrayList = new ArrayList();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        } else if (zai2 == '{') {
            this.zat.push(1);
            while (true) {
                try {
                    FastJsonResponse zad2 = field.zad();
                    if (!zaz(bufferedReader, zad2)) {
                        return arrayList;
                    }
                    arrayList.add(zad2);
                    char zai3 = zai(bufferedReader);
                    if (zai3 != ',') {
                        if (zai3 == ']') {
                            zaw(5);
                            return arrayList;
                        }
                        throw new ParseException("Unexpected token: " + zai3);
                    } else if (zai(bufferedReader) == '{') {
                        this.zat.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (InstantiationException e10) {
                    throw new ParseException("Error instantiating inner object", e10);
                } catch (IllegalAccessException e11) {
                    throw new ParseException("Error instantiating inner object", e11);
                }
            }
        } else {
            throw new ParseException("Unexpected token: " + zai2);
        }
    }

    private final void zaw(int i10) {
        if (!this.zat.isEmpty()) {
            int intValue = ((Integer) this.zat.pop()).intValue();
            if (intValue != i10) {
                throw new ParseException("Expected state " + i10 + " but had " + intValue);
            }
            return;
        }
        throw new ParseException("Expected state " + i10 + " but had empty stack");
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) {
        int i10 = 0;
        while (true) {
            int length = cArr.length;
            if (i10 < length) {
                int read = bufferedReader.read(this.zap, 0, length - i10);
                if (read != -1) {
                    int i11 = 0;
                    while (i11 < read) {
                        if (cArr[i11 + i10] == this.zap[i11]) {
                            i11++;
                        } else {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i10 += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z10) {
        char[] cArr;
        char[] cArr2;
        char zai2 = zai(bufferedReader);
        if (zai2 != '\"') {
            if (zai2 == 'f') {
                if (z10) {
                    cArr = zae;
                } else {
                    cArr = zad;
                }
                zax(bufferedReader, cArr);
                return false;
            } else if (zai2 == 'n') {
                zax(bufferedReader, zaa);
                return false;
            } else if (zai2 == 't') {
                if (z10) {
                    cArr2 = zac;
                } else {
                    cArr2 = zab;
                }
                zax(bufferedReader, cArr2);
                return true;
            } else {
                throw new ParseException("Unexpected token: " + zai2);
            }
        } else if (!z10) {
            return zay(bufferedReader, true);
        } else {
            throw new ParseException("No boolean value found in string");
        }
    }

    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) {
        HashMap hashMap;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq2 = zaq(bufferedReader);
        if (zaq2 != null) {
            while (zaq2 != null) {
                FastJsonResponse.Field field = fieldMappings.get(zaq2);
                if (field == null) {
                    zaq2 = zar(bufferedReader);
                } else {
                    this.zat.push(4);
                    int i10 = field.zaa;
                    switch (i10) {
                        case 0:
                            if (!field.zab) {
                                fastJsonResponse2.zau(field, zal(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zav(field, zau(bufferedReader2, zag));
                                break;
                            }
                        case 1:
                            if (!field.zab) {
                                fastJsonResponse2.zae(field, zat(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zag(field, zau(bufferedReader2, zam));
                                break;
                            }
                        case 2:
                            if (!field.zab) {
                                fastJsonResponse2.zax(field, zan(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zay(field, zau(bufferedReader2, zah));
                                break;
                            }
                        case 3:
                            if (!field.zab) {
                                fastJsonResponse2.zaq(field, zak(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zas(field, zau(bufferedReader2, zai));
                                break;
                            }
                        case 4:
                            if (!field.zab) {
                                fastJsonResponse2.zam(field, zaj(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zao(field, zau(bufferedReader2, zaj));
                                break;
                            }
                        case 5:
                            if (!field.zab) {
                                fastJsonResponse2.zaa(field, zas(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zac(field, zau(bufferedReader2, zan));
                                break;
                            }
                        case 6:
                            if (!field.zab) {
                                fastJsonResponse2.zai(field, zay(bufferedReader2, false));
                                break;
                            } else {
                                fastJsonResponse2.zaj(field, zau(bufferedReader2, zak));
                                break;
                            }
                        case 7:
                            if (!field.zab) {
                                fastJsonResponse2.zaA(field, zao(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zaC(field, zau(bufferedReader2, zal));
                                break;
                            }
                        case 8:
                            fastJsonResponse2.zal(field, Base64Utils.decode(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 9:
                            fastJsonResponse2.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 10:
                            char zai2 = zai(bufferedReader);
                            if (zai2 == 'n') {
                                zax(bufferedReader2, zaa);
                                hashMap = null;
                            } else if (zai2 == '{') {
                                this.zat.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zai3 = zai(bufferedReader);
                                    if (zai3 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    } else if (zai3 == '\"') {
                                        String zaA = zaA(bufferedReader2, this.zap, this.zar, (char[]) null);
                                        if (zai(bufferedReader) != ':') {
                                            throw new ParseException("No map value found for key ".concat(String.valueOf(zaA)));
                                        } else if (zai(bufferedReader) == '\"') {
                                            hashMap.put(zaA, zaA(bufferedReader2, this.zap, this.zar, (char[]) null));
                                            char zai4 = zai(bufferedReader);
                                            if (zai4 != ',') {
                                                if (zai4 == '}') {
                                                    zaw(1);
                                                } else {
                                                    throw new ParseException("Unexpected character while parsing string map: " + zai4);
                                                }
                                            }
                                        } else {
                                            throw new ParseException("Expected String value for key ".concat(String.valueOf(zaA)));
                                        }
                                    } else if (zai3 == '}') {
                                        zaw(1);
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse2.zaB(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zai5 = zai(bufferedReader);
                                if (zai5 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, (ArrayList) null);
                                    break;
                                } else {
                                    this.zat.push(5);
                                    if (zai5 == '[') {
                                        fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader2, field));
                                        break;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zai6 = zai(bufferedReader);
                                if (zai6 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeInternal(field, field.zae, null);
                                    break;
                                } else {
                                    this.zat.push(1);
                                    if (zai6 == '{') {
                                        try {
                                            FastJsonResponse zad2 = field.zad();
                                            zaz(bufferedReader2, zad2);
                                            fastJsonResponse2.addConcreteTypeInternal(field, field.zae, zad2);
                                            break;
                                        } catch (InstantiationException e10) {
                                            throw new ParseException("Error instantiating inner object", e10);
                                        } catch (IllegalAccessException e11) {
                                            throw new ParseException("Error instantiating inner object", e11);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                        default:
                            throw new ParseException("Invalid field type " + i10);
                    }
                    zaw(4);
                    zaw(2);
                    char zai7 = zai(bufferedReader);
                    if (zai7 == ',') {
                        zaq2 = zaq(bufferedReader);
                    } else if (zai7 == '}') {
                        zaq2 = null;
                    } else {
                        throw new ParseException("Expected end of object or field separator, but found: " + zai7);
                    }
                }
            }
            zaw(1);
            return true;
        }
        zaw(1);
        return false;
    }

    @KeepForSdk
    public void parse(InputStream inputStream, T t10) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zat.push(0);
            char zai2 = zai(bufferedReader);
            if (zai2 != 0) {
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t10.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.entrySet().iterator().next().getValue();
                        t10.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (zai2 == '{') {
                    this.zat.push(1);
                    zaz(bufferedReader, t10);
                } else {
                    throw new ParseException("Unexpected token: " + zai2);
                }
                zaw(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e10) {
            throw new ParseException((Throwable) e10);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }
}
