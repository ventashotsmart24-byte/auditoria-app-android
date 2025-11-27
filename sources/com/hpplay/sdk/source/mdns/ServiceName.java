package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import java.io.PrintStream;

public class ServiceName extends Name {
    private static final byte[][] PROTOCOLS;
    private static final byte[] SUB_SERVICE_INDICATOR = {4, 95, 115, 117, 98};
    private static final long serialVersionUID = 201305151047L;
    private String application;
    private String domain;
    private String fullSubType;
    private String fullType;
    private String instance;
    private String protocol;
    private final Name serviceRRName;
    private final Name serviceTypeName;
    private String subType;
    private String type;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0094, code lost:
        if (r3 != null) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa A[SYNTHETIC, Splitter:B:25:0x00aa] */
    static {
        /*
            r0 = 5
            byte[] r1 = new byte[r0]
            r1 = {4, 95, 115, 117, 98} // fill-array
            SUB_SERVICE_INDICATOR = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 3
            byte[][] r3 = new byte[r2][]
            byte[] r4 = new byte[r0]
            r4 = {4, 95, 116, 99, 112} // fill-array
            r5 = 0
            r3[r5] = r4
            byte[] r0 = new byte[r0]
            r0 = {4, 95, 117, 100, 112} // fill-array
            r4 = 1
            r3[r4] = r0
            r0 = 6
            byte[] r0 = new byte[r0]
            r0 = {5, 95, 115, 99, 116, 112} // fill-array
            r6 = 2
            r3[r6] = r0
            r0 = 0
        L_0x002a:
            if (r0 >= r2) goto L_0x0034
            r6 = r3[r0]
            r1.add(r6)
            int r0 = r0 + 1
            goto L_0x002a
        L_0x0034:
            java.lang.Class<com.hpplay.sdk.source.mdns.ServiceName> r0 = com.hpplay.sdk.source.mdns.ServiceName.class
            java.lang.String r2 = "ServiceName.protocol"
            java.net.URL r0 = r0.getResource(r2)
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            java.io.InputStream r7 = r0.openStream()     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0071, all -> 0x006f }
        L_0x004b:
            java.lang.String r2 = r3.readLine()     // Catch:{ Exception -> 0x006d }
            if (r2 == 0) goto L_0x0069
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x006d }
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x006d }
            int r6 = r2.length     // Catch:{ Exception -> 0x006d }
            int r6 = r6 + r4
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x006d }
            int r7 = r2.length     // Catch:{ Exception -> 0x006d }
            byte r7 = (byte) r7     // Catch:{ Exception -> 0x006d }
            r6[r5] = r7     // Catch:{ Exception -> 0x006d }
            int r7 = r2.length     // Catch:{ Exception -> 0x006d }
            java.lang.System.arraycopy(r2, r5, r6, r4, r7)     // Catch:{ Exception -> 0x006d }
            r1.add(r6)     // Catch:{ Exception -> 0x006d }
            goto L_0x004b
        L_0x0069:
            r3.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x0097
        L_0x006d:
            r2 = move-exception
            goto L_0x0075
        L_0x006f:
            r0 = move-exception
            goto L_0x00a8
        L_0x0071:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
        L_0x0075:
            java.util.logging.Logger r4 = java.util.logging.Logger.getAnonymousLogger()     // Catch:{ all -> 0x00a6 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r6.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = "Could not find Protocols file \""
            r6.append(r7)     // Catch:{ all -> 0x00a6 }
            r6.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = "\""
            r6.append(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00a6 }
            r4.log(r5, r0, r2)     // Catch:{ all -> 0x00a6 }
            if (r3 == 0) goto L_0x0097
            goto L_0x0069
        L_0x0097:
            int r0 = r1.size()
            byte[][] r0 = new byte[r0][]
            java.lang.Object[] r0 = r1.toArray(r0)
            byte[][] r0 = (byte[][]) r0
            PROTOCOLS = r0
            return
        L_0x00a6:
            r0 = move-exception
            r2 = r3
        L_0x00a8:
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ IOException -> 0x00ad }
        L_0x00ad:
            goto L_0x00af
        L_0x00ae:
            throw r0
        L_0x00af:
            goto L_0x00ae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.ServiceName.<clinit>():void");
    }

    public ServiceName(String str) {
        this(new Name(str));
    }

    private static final boolean arrayEquals(byte[] bArr, byte[] bArr2, short s10) {
        short s11 = (short) bArr2[s10];
        if (s11 != bArr[0] || bArr2.length <= s10 + s11) {
            return false;
        }
        for (int i10 = 1; i10 < s11; i10++) {
            if (bArr[i10] != bArr2[s10 + i10]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... strArr) {
        String str;
        if (strArr.length > 0) {
            str = strArr[0];
        } else {
            str = "Steve Posick's Work MacBook Pro._test._sub._syncmate._tcp.local.";
        }
        Name name = new Name(str);
        ServiceName serviceName = new ServiceName(name);
        PrintStream printStream = System.out;
        printStream.println("Service Name = " + serviceName);
        PrintStream printStream2 = System.out;
        printStream2.println("Instance: " + serviceName.instance);
        PrintStream printStream3 = System.out;
        printStream3.println("Full Type: " + serviceName.fullType);
        PrintStream printStream4 = System.out;
        printStream4.println("Sub Type: " + serviceName.subType);
        PrintStream printStream5 = System.out;
        printStream5.println("Type: " + serviceName.type);
        PrintStream printStream6 = System.out;
        printStream6.println("Application: " + serviceName.application);
        PrintStream printStream7 = System.out;
        printStream7.println("Protocol: " + serviceName.protocol);
        PrintStream printStream8 = System.out;
        printStream8.println("Domain: " + serviceName.domain);
        long nanoTime = System.nanoTime();
        for (int i10 = 0; i10 < 100000; i10++) {
            new ServiceName(name);
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        PrintStream printStream9 = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Took ");
        double d10 = (double) nanoTime2;
        Double.isNaN(d10);
        sb.append(d10 / 1000000.0d);
        sb.append(" milliseconds to parse ");
        sb.append(100000);
        sb.append(" service names at ");
        long j10 = nanoTime2 / ((long) 100000);
        double d11 = (double) j10;
        Double.isNaN(d11);
        sb.append(d11 / 1000000.0d);
        sb.append(" millis / ");
        sb.append(j10);
        sb.append(" nanoseconds each name");
        printStream9.println(sb.toString());
    }

    public String getApplication() {
        return this.application;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getFullSubType() {
        return this.fullSubType;
    }

    public String getFullType() {
        return this.fullType;
    }

    public String getInstance() {
        return this.instance;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Name getServiceRRName() {
        return this.serviceRRName;
    }

    public Name getServiceTypeName() {
        return this.serviceTypeName;
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public ServiceName(String str, Name name) {
        this(new Name(str, name));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ServiceName(com.hpplay.sdk.source.mdns.xbill.dns.Name r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            r0.<init>((com.hpplay.sdk.source.mdns.xbill.dns.Name) r1, (int) r2)
            r3 = 1
            java.lang.Class<com.hpplay.sdk.source.mdns.xbill.dns.Name> r5 = com.hpplay.sdk.source.mdns.xbill.dns.Name.class
            java.lang.String r6 = "name"
            java.lang.reflect.Field r5 = r5.getDeclaredField(r6)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchFieldException -> 0x001b }
            r5.setAccessible(r3)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchFieldException -> 0x001b }
            java.lang.Object r5 = r5.get(r1)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchFieldException -> 0x001b }
            byte[] r5 = (byte[]) r5     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchFieldException -> 0x001b }
            goto L_0x001d
        L_0x001b:
            r5 = 0
        L_0x001d:
            int r6 = r17.labels()
            if (r5 != 0) goto L_0x003e
            short r5 = r17.length()
            byte[] r5 = new byte[r5]
            r7 = 0
            r8 = 0
        L_0x002b:
            if (r7 >= r6) goto L_0x003e
            byte[] r9 = r1.getLabel(r7)
            byte r10 = r9[r2]
            int r10 = r10 + r3
            java.lang.System.arraycopy(r9, r2, r5, r8, r10)
            byte r9 = r9[r2]
            int r9 = r9 + r3
            int r8 = r8 + r9
            int r7 = r7 + 1
            goto L_0x002b
        L_0x003e:
            short[] r7 = new short[r6]
            r8 = -1
            r9 = -1
            r10 = -1
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0046:
            if (r11 >= r6) goto L_0x0071
            r7[r11] = r13
            byte r14 = r5[r13]
            r15 = r14 & 255(0xff, float:3.57E-43)
            short r15 = (short) r15
            int r15 = r15 + r13
            int r15 = r15 + r3
            short r15 = (short) r15
            if (r14 <= 0) goto L_0x006d
            int r14 = r13 + 1
            byte r14 = r5[r14]
            r4 = 95
            if (r14 != r4) goto L_0x006d
            if (r8 >= 0) goto L_0x005f
            r8 = r11
        L_0x005f:
            if (r9 >= 0) goto L_0x006a
            byte[] r4 = SUB_SERVICE_INDICATOR
            boolean r4 = arrayEquals(r4, r5, r13)
            if (r4 == 0) goto L_0x006a
            r9 = r11
        L_0x006a:
            int r12 = r12 + 1
            r10 = r11
        L_0x006d:
            int r11 = r11 + 1
            r13 = r15
            goto L_0x0046
        L_0x0071:
            if (r12 <= 0) goto L_0x01c3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r4 = 46
            if (r8 <= 0) goto L_0x00a3
            r11 = 0
        L_0x007d:
            if (r11 >= r8) goto L_0x0095
            short r12 = r7[r11]
            byte r13 = r5[r12]
            if (r13 <= 0) goto L_0x0092
            java.lang.String r14 = new java.lang.String
            int r12 = r12 + 1
            r14.<init>(r5, r12, r13)
            r1.append(r14)
            r1.append(r4)
        L_0x0092:
            int r11 = r11 + 1
            goto L_0x007d
        L_0x0095:
            int r11 = r1.length()
            int r11 = r11 - r3
            java.lang.String r11 = r1.substring(r2, r11)
            r0.instance = r11
            r1.setLength(r2)
        L_0x00a3:
            if (r8 > r10) goto L_0x00f3
            short r11 = r7[r8]
            byte r12 = r5[r11]
            if (r12 <= 0) goto L_0x00f0
            java.lang.String r13 = new java.lang.String
            int r11 = r11 + 1
            r13.<init>(r5, r11, r12)
            if (r8 >= r9) goto L_0x00b8
            r1.append(r13)
            goto L_0x00ed
        L_0x00b8:
            if (r8 != r9) goto L_0x00cf
            int r11 = r1.length()
            int r11 = r11 - r3
            java.lang.String r11 = r1.substring(r2, r11)
            r0.subType = r11
            r1.append(r13)
            java.lang.String r11 = r1.toString()
            r0.fullSubType = r11
            goto L_0x00ed
        L_0x00cf:
            if (r8 != r10) goto L_0x00ea
            r1.append(r13)
            byte[][] r9 = PROTOCOLS
            int r11 = r9.length
            r12 = 0
        L_0x00d8:
            if (r12 >= r11) goto L_0x00f3
            r14 = r9[r12]
            short r15 = r7[r8]
            boolean r14 = arrayEquals(r14, r5, r15)
            if (r14 == 0) goto L_0x00e7
            r0.protocol = r13
            goto L_0x00f3
        L_0x00e7:
            int r12 = r12 + 1
            goto L_0x00d8
        L_0x00ea:
            r1.append(r13)
        L_0x00ed:
            r1.append(r4)
        L_0x00f0:
            int r8 = r8 + 1
            goto L_0x00a3
        L_0x00f3:
            java.lang.String r8 = r0.fullSubType
            if (r8 == 0) goto L_0x012f
            int r8 = r8.length()
            int r8 = r8 + r3
            int r9 = r1.length()
            java.lang.String r8 = r1.substring(r8, r9)
            r0.type = r8
            java.lang.String r8 = r1.toString()
            r0.fullType = r8
            java.lang.String r8 = r0.protocol
            if (r8 == 0) goto L_0x012a
            java.lang.String r8 = r0.fullSubType
            int r8 = r8.length()
            int r8 = r8 + r3
            int r9 = r1.length()
            java.lang.String r11 = r0.protocol
            int r11 = r11.length()
            int r9 = r9 - r11
            int r9 = r9 - r3
            java.lang.String r8 = r1.substring(r8, r9)
            r0.application = r8
            goto L_0x0150
        L_0x012a:
            java.lang.String r8 = r0.type
            r0.application = r8
            goto L_0x0150
        L_0x012f:
            java.lang.String r8 = r1.toString()
            r0.fullType = r8
            r0.type = r8
            java.lang.String r9 = r0.protocol
            if (r9 == 0) goto L_0x014e
            int r8 = r1.length()
            java.lang.String r9 = r0.protocol
            int r9 = r9.length()
            int r8 = r8 - r9
            int r8 = r8 - r3
            java.lang.String r8 = r1.substring(r2, r8)
            r0.application = r8
            goto L_0x0150
        L_0x014e:
            r0.application = r8
        L_0x0150:
            r1.setLength(r2)
            int r10 = r10 + r3
        L_0x0154:
            if (r10 >= r6) goto L_0x016c
            short r3 = r7[r10]
            byte r8 = r5[r3]
            if (r8 <= 0) goto L_0x0169
            java.lang.String r9 = new java.lang.String
            int r3 = r3 + 1
            r9.<init>(r5, r3, r8)
            r1.append(r9)
            r1.append(r4)
        L_0x0169:
            int r10 = r10 + 1
            goto L_0x0154
        L_0x016c:
            int r3 = r1.length()
            java.lang.String r3 = r1.substring(r2, r3)
            r0.domain = r3
            r1.setLength(r2)
            com.hpplay.sdk.source.mdns.xbill.dns.Name r1 = new com.hpplay.sdk.source.mdns.xbill.dns.Name
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.type
            r2.append(r3)
            java.lang.String r3 = r0.domain
            if (r3 == 0) goto L_0x019d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "."
            r3.append(r4)
            java.lang.String r4 = r0.domain
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L_0x019f
        L_0x019d:
            java.lang.String r3 = ""
        L_0x019f:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            r0.serviceTypeName = r1
            java.lang.String r2 = r0.instance
            if (r2 == 0) goto L_0x01bf
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x01bf
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = new com.hpplay.sdk.source.mdns.xbill.dns.Name
            java.lang.String r3 = r0.instance
            r2.<init>((java.lang.String) r3, (com.hpplay.sdk.source.mdns.xbill.dns.Name) r1)
            r0.serviceRRName = r2
            goto L_0x01c2
        L_0x01bf:
            r1 = 0
            r0.serviceRRName = r1
        L_0x01c2:
            return
        L_0x01c3:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Name \""
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = "\" is not an IETF RFC 2782 or IETF RFC 6763 compliant service name."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            goto L_0x01e0
        L_0x01df:
            throw r2
        L_0x01e0:
            goto L_0x01df
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.ServiceName.<init>(com.hpplay.sdk.source.mdns.xbill.dns.Name):void");
    }
}
