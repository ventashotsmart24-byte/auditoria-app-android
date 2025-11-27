package com.hpplay.component.protocol;

import android.content.Context;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.encrypt.ED25519Encrypt;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.component.utils.EncryptUtil;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

public class ProtocolUtils {
    public static final String CONTENT_LENGTH = "Content-Length:";
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final String TAG = "ProtocolUtils";

    public static byte[] Encrypt(String str) {
        byte[] bArr = new byte[16];
        try {
            ED25519Encrypt eD25519Encrypt = new ED25519Encrypt();
            byte[] bytes = str.getBytes("UTF-8");
            eD25519Encrypt.strcrypt(bytes, bytes.length, bArr);
            for (int i10 = 0; i10 < 16; i10++) {
                bArr[i10] = (byte) (bArr[i10] ^ 120);
            }
            return bArr;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 5)];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i11 + 1;
            cArr[i11] = '0';
            int i13 = i12 + 1;
            cArr[i12] = 'x';
            int i14 = i13 + 1;
            char[] cArr2 = HEX_CHAR;
            cArr[i13] = cArr2[(b10 >>> 4) & 15];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[b10 & 15];
            cArr[i15] = ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN;
            i10++;
            i11 = i15 + 1;
        }
        return new String(cArr);
    }

    public static int bytesToInt(byte[] bArr) {
        return ((bArr[3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[0] & UnsignedBytes.MAX_VALUE) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static boolean checkLoaclPort(int i10) {
        try {
            return isPortUsing("127.0.0.1", i10);
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return true;
        }
    }

    public static String createSessionId(String str) {
        return EncryptUtil.md5EncryData((str + String.valueOf(System.currentTimeMillis())).toUpperCase()).toUpperCase();
    }

    public static String drEncrypt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bArr = new byte[16];
            ED25519Encrypt eD25519Encrypt = new ED25519Encrypt();
            byte[] bytes = str.getBytes("UTF-8");
            eD25519Encrypt.strcrypt(bytes, bytes.length, bArr);
            String str2 = "";
            for (int i10 = 0; i10 < 16; i10++) {
                String hexString = Integer.toHexString(bArr[i10] & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return "";
        }
    }

    public static byte[] getBody(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] == 13 && bArr[i10 + 1] == 10 && bArr[i10 + 2] == 13) {
                int i11 = i10 + 3;
                if (bArr[i11] == 10) {
                    int i12 = i10 + 4;
                    int length = bArr.length - i12;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, i12, bArr2, 0, length);
                    CLog.d(TAG, "body totalLength" + (bArr.length - i11));
                    return bArr2;
                }
            }
        }
        return null;
    }

    public static int getContentLength(String str) {
        String[] split = str.split("\r\n");
        int i10 = 0;
        while (i10 < split.length) {
            if (split[i10].contains("Content-Length:")) {
                try {
                    int intValue = Integer.valueOf(split[i10].split(SOAP.DELIM)[1].toString().trim()).intValue();
                    CLog.d(TAG, "contentLength" + intValue + "");
                    return intValue;
                } catch (Exception e10) {
                    CLog.w(TAG, (Throwable) e10);
                    return 0;
                }
            } else {
                i10++;
            }
        }
        return 0;
    }

    public static String getDateTime(long j10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Calendar a10 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        a10.setTimeInMillis(j10);
        int a11 = a10.get(1);
        int a12 = a10.get(2) + 1;
        if (String.valueOf(a12).length() == 1) {
            str = "0" + a12;
        } else {
            str = String.valueOf(a12);
        }
        int a13 = a10.get(5);
        if (String.valueOf(a13).length() == 1) {
            str2 = "0" + a13;
        } else {
            str2 = String.valueOf(a13);
        }
        int a14 = a10.get(11);
        if (String.valueOf(a14).length() == 1) {
            str3 = "0" + a14;
        } else {
            str3 = String.valueOf(a14);
        }
        int a15 = a10.get(12);
        if (String.valueOf(a15).length() == 1) {
            str4 = "0" + a15;
        } else {
            str4 = String.valueOf(a15);
        }
        int a16 = a10.get(13);
        if (String.valueOf(a16).length() == 1) {
            str5 = "0" + a16;
        } else {
            str5 = String.valueOf(a16);
        }
        return a11 + Operator.Operation.MINUS + str + Operator.Operation.MINUS + str2 + " " + str3 + SOAP.DELIM + str4 + SOAP.DELIM + str5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[SYNTHETIC, Splitter:B:22:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c A[SYNTHETIC, Splitter:B:28:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileEncrypt(java.lang.String r4) {
        /*
            r0 = 8192(0x2000, float:1.14794E-41)
            r1 = 0
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0047 }
            com.hpplay.component.protocol.encrypt.ED25519Encrypt r2 = new com.hpplay.component.protocol.encrypt.ED25519Encrypt     // Catch:{ Exception -> 0x0047 }
            r2.<init>()     // Catch:{ Exception -> 0x0047 }
            r2.mdInit()     // Catch:{ Exception -> 0x0047 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0047 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0047 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0047 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0047 }
        L_0x0017:
            int r1 = r4.read(r0)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r3 = -1
            if (r1 == r3) goto L_0x0022
            r2.mdUpdate(r0, r1)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            goto L_0x0017
        L_0x0022:
            r4.close()     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r0 = 16
            byte[] r1 = new byte[r0]     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r2.mdDoFinal(r1)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.math.BigInteger r2 = new java.math.BigInteger     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r3 = 1
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            java.lang.String r0 = r2.toString(r0)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
            r4.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x0059
        L_0x003a:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0059
        L_0x003f:
            r0 = move-exception
            r1 = r4
            goto L_0x005a
        L_0x0042:
            r0 = move-exception
            r1 = r4
            goto L_0x0048
        L_0x0045:
            r0 = move-exception
            goto L_0x005a
        L_0x0047:
            r0 = move-exception
        L_0x0048:
            java.lang.String r4 = "ProtocolUtils"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r4, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0057:
            java.lang.String r0 = ""
        L_0x0059:
            return r0
        L_0x005a:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0064:
            goto L_0x0066
        L_0x0065:
            throw r0
        L_0x0066:
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.ProtocolUtils.getFileEncrypt(java.lang.String):java.lang.String");
    }

    public static String getFirstLineOfHeader(byte[] bArr) {
        try {
            String[] split = new String(bArr).split("\n");
            if (split == null || split.length <= 0) {
                return "";
            }
            return split[0];
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return "";
        }
    }

    public static String getHeader(byte[] bArr) {
        int length = bArr.length;
        int indexOf = new String(bArr).indexOf("\r\n\r\n");
        byte[] bArr2 = new byte[indexOf];
        System.arraycopy(bArr, 0, bArr2, 0, indexOf);
        return new String(bArr2, 0, indexOf);
    }

    public static String getLoaclIp() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!(nextElement instanceof Inet6Address)) {
                        if (!"127.0.0.1".equals(nextElement.getHostAddress())) {
                            str = nextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        return str;
    }

    public static boolean getProtocolDivide(ArrayList<Byte> arrayList) {
        if (arrayList.size() > 11 && arrayList.get(arrayList.size() - 1).byteValue() == 10 && arrayList.get(arrayList.size() - 2).byteValue() == 13 && arrayList.get(arrayList.size() - 3).byteValue() == 10 && arrayList.get(arrayList.size() - 4).byteValue() == 13) {
            return true;
        }
        return false;
    }

    public static String getStreaEncrypt(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        try {
            byte[] bArr = new byte[8192];
            ED25519Encrypt eD25519Encrypt = new ED25519Encrypt();
            eD25519Encrypt.mdInit();
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    eD25519Encrypt.mdUpdate(bArr, read);
                } else {
                    inputStream.close();
                    byte[] bArr2 = new byte[16];
                    eD25519Encrypt.mdDoFinal(bArr2);
                    return new BigInteger(1, bArr2).toString(16);
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[Catch:{ SocketException -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getWifiIp() {
        /*
            r0 = 0
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ SocketException -> 0x0036 }
        L_0x0005:
            boolean r2 = r1.hasMoreElements()     // Catch:{ SocketException -> 0x0036 }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r1.nextElement()     // Catch:{ SocketException -> 0x0036 }
            java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch:{ SocketException -> 0x0036 }
            java.util.Enumeration r3 = r2.getInetAddresses()     // Catch:{ SocketException -> 0x0036 }
            java.lang.String r2 = r2.getDisplayName()     // Catch:{ SocketException -> 0x0036 }
            java.lang.String r4 = "wlan0"
            boolean r2 = r2.contains(r4)     // Catch:{ SocketException -> 0x0036 }
            if (r2 == 0) goto L_0x0005
        L_0x0021:
            boolean r1 = r3.hasMoreElements()     // Catch:{ SocketException -> 0x0036 }
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r3.nextElement()     // Catch:{ SocketException -> 0x0036 }
            java.net.InetAddress r1 = (java.net.InetAddress) r1     // Catch:{ SocketException -> 0x0036 }
            boolean r2 = r1 instanceof java.net.Inet4Address     // Catch:{ SocketException -> 0x0036 }
            if (r2 == 0) goto L_0x0021
            java.lang.String r0 = r1.getHostAddress()     // Catch:{ SocketException -> 0x0036 }
            goto L_0x003c
        L_0x0036:
            r1 = move-exception
            java.lang.String r2 = "ProtocolUtils"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r2, (java.lang.Throwable) r1)
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.ProtocolUtils.getWifiIp():java.lang.String");
    }

    public static byte[] intToBytes(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        com.hpplay.component.common.utils.CLog.w(TAG, (java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isPortUsing(java.lang.String r2, int r3) {
        /*
            java.lang.String r0 = "ProtocolUtils"
            java.net.InetAddress r2 = java.net.InetAddress.getByName(r2)
            java.net.Socket r1 = new java.net.Socket     // Catch:{ IOException -> 0x0017, all -> 0x0015 }
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0017, all -> 0x0015 }
            r1.close()     // Catch:{ IOException -> 0x000f }
            goto L_0x0013
        L_0x000f:
            r2 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x0013:
            r2 = 1
            goto L_0x001c
        L_0x0015:
            r2 = move-exception
            throw r2
        L_0x0017:
            r2 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r2)
            r2 = 0
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.ProtocolUtils.isPortUsing(java.lang.String, int):boolean");
    }

    public static byte[] removeHeader(byte[] bArr) {
        int length = bArr.length;
        String str = new String(bArr);
        int indexOf = str.indexOf("\r\n\r\n");
        int i10 = (length - indexOf) - 4;
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, indexOf + 4, bArr2, 0, i10);
        if (!new String(bArr2, 0, i10).startsWith("\n")) {
            return bArr2;
        }
        int indexOf2 = str.indexOf("\r\n\r\n\n");
        int i11 = (length - indexOf2) - 6;
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr, indexOf2 + 6, bArr3, 0, i11);
        return bArr3;
    }

    public static String strEncrpyt(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            CLog.w(TAG, (Throwable) e10);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            bArr = str.getBytes();
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bArr2 = new byte[16];
            new ED25519Encrypt().strcrypt(bArr, bArr.length, bArr2);
            char[] cArr2 = new char[32];
            int i10 = 0;
            for (int i11 = 0; i11 < 16; i11++) {
                byte b10 = bArr2[i11];
                int i12 = i10 + 1;
                cArr2[i10] = cArr[(b10 >>> 4) & 15];
                i10 = i12 + 1;
                cArr2[i12] = cArr[b10 & 15];
            }
            return new String(cArr2);
        } catch (Exception e11) {
            CLog.w(TAG, (Throwable) e11);
            return null;
        }
    }

    public static byte[] strToMdHash(String str) {
        byte[] bArr = new byte[16];
        try {
            ED25519Encrypt eD25519Encrypt = new ED25519Encrypt();
            byte[] bytes = str.getBytes("UTF-8");
            eD25519Encrypt.mdInit();
            eD25519Encrypt.mdUpdate(bytes, bytes.length);
            eD25519Encrypt.mdDoFinal(bArr);
            return bArr;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return null;
        }
    }
}
