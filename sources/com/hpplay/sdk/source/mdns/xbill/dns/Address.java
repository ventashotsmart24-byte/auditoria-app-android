package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.soap.SOAP;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class Address {
    public static final int IPv4 = 1;
    public static final int IPv6 = 2;

    private Address() {
    }

    private static InetAddress addrFromRecord(String str, Record record) {
        InetAddress inetAddress;
        if (record instanceof ARecord) {
            inetAddress = ((ARecord) record).getAddress();
        } else {
            inetAddress = ((AAAARecord) record).getAddress();
        }
        return InetAddress.getByAddress(str, inetAddress.getAddress());
    }

    public static int addressLength(int i10) {
        if (i10 == 1) {
            return 4;
        }
        if (i10 == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int familyOf(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress getByAddress(String str) {
        byte[] byteArray = toByteArray(str, 1);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        byte[] byteArray2 = toByteArray(str, 2);
        if (byteArray2 != null) {
            return InetAddress.getByAddress(str, byteArray2);
        }
        throw new UnknownHostException("Invalid address: " + str);
    }

    public static String getHostName(InetAddress inetAddress) {
        Record[] run = new Lookup(ReverseMap.fromAddress(inetAddress), 12).run();
        if (run != null) {
            return ((PTRRecord) run[0]).getTarget().toString();
        }
        throw new UnknownHostException("unknown address");
    }

    private static Record[] lookupHostName(String str, boolean z10) {
        Record[] run;
        Record[] run2;
        try {
            Lookup lookup = new Lookup(str, 1);
            Record[] run3 = lookup.run();
            if (run3 == null) {
                if (lookup.getResult() == 4 && (run2 = new Lookup(str, 28).run()) != null) {
                    return run2;
                }
                throw new UnknownHostException("unknown host");
            } else if (!z10 || (run = new Lookup(str, 28).run()) == null) {
                return run3;
            } else {
                Record[] recordArr = new Record[(run3.length + run.length)];
                System.arraycopy(run3, 0, recordArr, 0, run3.length);
                System.arraycopy(run, 0, recordArr, run3.length, run.length);
                return recordArr;
            }
        } catch (Exception unused) {
            throw new UnknownHostException("invalid name");
        }
    }

    private static byte[] parseV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            char charAt = str.charAt(i13);
            if (charAt < '0' || charAt > '9') {
                if (charAt != '.' || i10 == 3 || i11 == 0) {
                    return null;
                }
                bArr[i10] = (byte) i12;
                i10++;
                i11 = 0;
                i12 = 0;
            } else if (i11 == 3) {
                return null;
            } else {
                if (i11 > 0 && i12 == 0) {
                    return null;
                }
                i11++;
                i12 = (i12 * 10) + (charAt - '0');
                if (i12 > 255) {
                    return null;
                }
            }
        }
        if (i10 != 3 || i11 == 0) {
            return null;
        }
        bArr[i10] = (byte) i12;
        return bArr;
    }

    private static byte[] parseV6(String str) {
        int i10;
        byte[] byteArray;
        byte[] bArr = new byte[16];
        int i11 = -1;
        String[] split = str.split(SOAP.DELIM, -1);
        int length = split.length - 1;
        if (split[0].length() != 0) {
            i10 = 0;
        } else if (length + 0 <= 0 || split[1].length() != 0) {
            return null;
        } else {
            i10 = 1;
        }
        if (split[length].length() == 0) {
            if (length - i10 <= 0 || split[length - 1].length() != 0) {
                return null;
            }
            length--;
        }
        if ((length - i10) + 1 > 8) {
            return null;
        }
        int i12 = 0;
        while (true) {
            if (i10 > length) {
                break;
            }
            if (split[i10].length() == 0) {
                if (i11 >= 0) {
                    return null;
                }
                i11 = i12;
            } else if (split[i10].indexOf(46) < 0) {
                int i13 = 0;
                while (i13 < split[i10].length()) {
                    try {
                        if (Character.digit(split[i10].charAt(i13), 16) < 0) {
                            return null;
                        }
                        i13++;
                    } catch (NumberFormatException unused) {
                    }
                }
                int parseInt = Integer.parseInt(split[i10], 16);
                if (parseInt > 65535) {
                    break;
                } else if (parseInt < 0) {
                    break;
                } else {
                    int i14 = i12 + 1;
                    bArr[i12] = (byte) (parseInt >>> 8);
                    i12 = i14 + 1;
                    bArr[i14] = (byte) (parseInt & 255);
                }
            } else if (i10 < length || i10 > 6 || (byteArray = toByteArray(split[i10], 1)) == null) {
                return null;
            } else {
                int i15 = 0;
                while (i15 < 4) {
                    bArr[i12] = byteArray[i15];
                    i15++;
                    i12++;
                }
            }
            i10++;
        }
        if (i12 < 16 && i11 < 0) {
            return null;
        }
        if (i11 >= 0) {
            int i16 = (16 - i12) + i11;
            System.arraycopy(bArr, i11, bArr, i16, i12 - i11);
            while (i11 < i16) {
                bArr[i11] = 0;
                i11++;
            }
        }
        return bArr;
        return null;
    }

    public static int[] toArray(String str, int i10) {
        byte[] byteArray = toByteArray(str, i10);
        if (byteArray == null) {
            return null;
        }
        int[] iArr = new int[byteArray.length];
        for (int i11 = 0; i11 < byteArray.length; i11++) {
            iArr[i11] = byteArray[i11] & UnsignedBytes.MAX_VALUE;
        }
        return iArr;
    }

    public static byte[] toByteArray(String str, int i10) {
        if (i10 == 1) {
            return parseV4(str);
        }
        if (i10 == 2) {
            return parseV6(str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static String toDottedQuad(byte[] bArr) {
        return (bArr[0] & UnsignedBytes.MAX_VALUE) + "." + (bArr[1] & UnsignedBytes.MAX_VALUE) + "." + (bArr[2] & UnsignedBytes.MAX_VALUE) + "." + (bArr[3] & UnsignedBytes.MAX_VALUE);
    }

    public static InetAddress truncate(InetAddress inetAddress, int i10) {
        int i11;
        int addressLength = addressLength(familyOf(inetAddress)) * 8;
        if (i10 < 0 || i10 > addressLength) {
            throw new IllegalArgumentException("invalid mask length");
        } else if (i10 == addressLength) {
            return inetAddress;
        } else {
            byte[] address = inetAddress.getAddress();
            int i12 = i10 / 8;
            int i13 = i12 + 1;
            while (true) {
                if (i13 >= address.length) {
                    break;
                }
                address[i13] = 0;
                i13++;
            }
            byte b10 = 0;
            for (i11 = 0; i11 < i10 % 8; i11++) {
                b10 |= 1 << (7 - i11);
            }
            address[i12] = (byte) (address[i12] & b10);
            try {
                return InetAddress.getByAddress(address);
            } catch (UnknownHostException unused) {
                throw new IllegalArgumentException("invalid address");
            }
        }
    }

    public static int[] toArray(String str) {
        return toArray(str, 1);
    }

    public static InetAddress getByAddress(String str, int i10) {
        if (i10 == 1 || i10 == 2) {
            byte[] byteArray = toByteArray(str, i10);
            if (byteArray != null) {
                return InetAddress.getByAddress(str, byteArray);
            }
            throw new UnknownHostException("Invalid address: " + str);
        }
        throw new IllegalArgumentException("unknown address family");
    }
}
