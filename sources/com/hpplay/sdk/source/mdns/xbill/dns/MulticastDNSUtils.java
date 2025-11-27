package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.utils.Misc;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MulticastDNSUtils {
    public static final Record[] EMPTY_RECORDS = new Record[0];
    private static final Logger logger = Misc.getLogger((Class<?>) MulticastDNSUtils.class, Options.check("mdns_verbose"));

    public static boolean answersAll(Message message, Message message2) {
        int opcode = message2.getHeader().getOpcode();
        if (opcode != 0 && opcode != 1 && opcode != 2 && opcode != 4) {
            return false;
        }
        Record[] extractRecords = extractRecords(message, 0);
        Record[] extractRecords2 = extractRecords(message2, 0);
        int length = extractRecords.length;
        boolean[] zArr = new boolean[length];
        int i10 = 0;
        for (Record record : extractRecords) {
            zArr[i10] = false;
            int length2 = extractRecords2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length2) {
                    break;
                }
                Record record2 = extractRecords2[i11];
                if (!record.getName().equals(record2.getName()) || !(record2.getType() == 255 || record.getType() == record2.getType())) {
                    i11++;
                }
            }
            zArr[i10] = true;
            i10++;
        }
        for (int i12 = 0; i12 < length; i12++) {
            if (!zArr[i12]) {
                return false;
            }
        }
        return true;
    }

    public static boolean answersAny(Message message, Message message2) {
        Header header = message2.getHeader();
        if (!header.getFlag(0)) {
            return false;
        }
        int opcode = header.getOpcode();
        if ((opcode != 0 && opcode != 1 && opcode != 2 && opcode != 4) || message == null) {
            return false;
        }
        Record[] extractRecords = extractRecords(message, 0);
        Record[] extractRecords2 = extractRecords(message2, 1, 3, 2);
        for (Record record : extractRecords) {
            for (Record record2 : extractRecords2) {
                if (record.getName().equals(record2.getName()) && (record.getType() == 255 || record.getType() == record2.getType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Record clone(Record record) {
        return record.cloneRecord();
    }

    public static Record[] extractRecords(Message message, int... iArr) {
        Record[] recordArr = EMPTY_RECORDS;
        for (int sectionArray : iArr) {
            Record[] sectionArray2 = message.getSectionArray(sectionArray);
            if (sectionArray2 != null && sectionArray2.length > 0) {
                Record[] recordArr2 = new Record[(recordArr.length + sectionArray2.length)];
                System.arraycopy(recordArr, 0, recordArr2, 0, recordArr.length);
                System.arraycopy(sectionArray2, 0, recordArr2, recordArr.length, sectionArray2.length);
                recordArr = recordArr2;
            }
        }
        return recordArr;
    }

    public static String getHostName() {
        String str = System.getenv().get("HOSTNAME");
        if (str == null || str.trim().length() == 0) {
            str = System.getenv().get("COMPUTERNAME");
        }
        if (str != null && str.trim().length() != 0) {
            return str;
        }
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostName = localHost.getHostName();
            if (hostName == null || hostName.startsWith("unknown")) {
                return localHost.getCanonicalHostName();
            }
            return hostName;
        } catch (UnknownHostException unused) {
            return str;
        }
    }

    public static InetAddress[] getLocalAddresses() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        arrayList.add(inetAddresses.nextElement());
                    }
                }
            }
        } catch (SocketException unused) {
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }

    public static String getMachineName() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && str == null) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (true) {
                        if (!inetAddresses.hasMoreElements()) {
                            break;
                        }
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.getCanonicalHostName().equalsIgnoreCase(nextElement2.getHostAddress())) {
                            str = nextElement2.getCanonicalHostName();
                            break;
                        }
                    }
                }
            }
        } catch (SocketException unused) {
        }
        return str;
    }

    public static Name getTargetFromRecord(Record record) {
        if (record instanceof SingleNameBase) {
            return ((SingleNameBase) record).getSingleName();
        }
        try {
            Method method = record.getClass().getMethod("getTarget", new Class[0]);
            if (method == null) {
                return null;
            }
            Object invoke = method.invoke(record, new Object[0]);
            if (invoke instanceof Name) {
                return (Name) invoke;
            }
            return null;
        } catch (Exception unused) {
            Logger logger2 = logger;
            Level level = Level.FINE;
            String name = MulticastDNSUtils.class.getName();
            logger2.logp(level, name, "getTargetFromRecord", "No target specified in record " + record.getClass().getSimpleName() + ": " + record);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean messagesEqual(com.hpplay.sdk.source.mdns.xbill.dns.Message r6, com.hpplay.sdk.source.mdns.xbill.dns.Message r7) {
        /*
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r6 == 0) goto L_0x005c
            if (r7 != 0) goto L_0x000a
            goto L_0x005c
        L_0x000a:
            com.hpplay.sdk.source.mdns.xbill.dns.Header r2 = r6.getHeader()
            com.hpplay.sdk.source.mdns.xbill.dns.Header r3 = r7.getHeader()
            if (r2 != r3) goto L_0x0016
        L_0x0014:
            r2 = 0
            goto L_0x003f
        L_0x0016:
            if (r2 == 0) goto L_0x0014
            if (r3 != 0) goto L_0x001b
            goto L_0x0014
        L_0x001b:
            boolean[] r4 = r2.getFlags()
            boolean[] r5 = r3.getFlags()
            boolean r4 = java.util.Arrays.equals(r4, r5)
            if (r4 != 0) goto L_0x002a
            return r1
        L_0x002a:
            int r4 = r2.getOpcode()
            int r5 = r3.getOpcode()
            if (r4 != r5) goto L_0x0014
            int r2 = r2.getRcode()
            int r3 = r3.getRcode()
            if (r2 != r3) goto L_0x0014
            r2 = 1
        L_0x003f:
            if (r2 == 0) goto L_0x005a
            r2 = 2
            r3 = 3
            int[] r4 = new int[]{r1, r0, r2, r3}
            com.hpplay.sdk.source.mdns.xbill.dns.Record[] r7 = extractRecords(r7, r4)
            int[] r2 = new int[]{r1, r0, r2, r3}
            com.hpplay.sdk.source.mdns.xbill.dns.Record[] r6 = extractRecords(r6, r2)
            boolean r6 = java.util.Arrays.equals(r7, r6)
            if (r6 == 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            return r0
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils.messagesEqual(com.hpplay.sdk.source.mdns.xbill.dns.Message, com.hpplay.sdk.source.mdns.xbill.dns.Message):boolean");
    }

    public static Message newQueryResponse(Record[] recordArr, int i10) {
        Message message = new Message();
        Header header = message.getHeader();
        header.setRcode(0);
        header.setOpcode(0);
        header.setFlag(0);
        for (Record addRecord : recordArr) {
            message.addRecord(addRecord, i10);
        }
        return message;
    }

    public static void setDClassForRecord(Record record, int i10) {
        record.dclass = i10;
    }

    public static void setTLLForRecord(Record record, long j10) {
        record.setTTL(j10);
    }

    public static Message[] splitMessage(Message message) {
        ArrayList arrayList = new ArrayList();
        int intValue = Options.intValue("mdns_max_records_per_message");
        if (intValue > 1) {
            intValue = 10;
        }
        int[] iArr = {0, 1, 2, 3};
        Message message2 = null;
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = iArr[i10];
            Record[] sectionArray = message.getSectionArray(i11);
            for (int i12 = 0; i12 < sectionArray.length; i12++) {
                if (message2 == null) {
                    message2 = new Message();
                    Header header = (Header) message.getHeader().clone();
                    header.setCount(0, 0);
                    header.setCount(1, 0);
                    header.setCount(2, 0);
                    header.setCount(3, 0);
                    message2.setHeader(header);
                    message2.addRecord(sectionArray[i12], i11);
                } else {
                    message2.addRecord(sectionArray[i12], i11);
                }
                if (i12 != 0 && i12 % intValue == 0) {
                    arrayList.add(message2);
                    message2 = null;
                }
            }
        }
        return (Message[]) arrayList.toArray(new Message[arrayList.size()]);
    }

    public static final Record[] extractRecords(RRset rRset) {
        Iterator rrs;
        int i10 = 0;
        if (rRset == null) {
            return new Record[0];
        }
        int size = rRset.size();
        Record[] recordArr = new Record[size];
        if (size > 0 && (rrs = rRset.rrs(false)) != null) {
            while (rrs.hasNext()) {
                recordArr[i10] = (Record) rrs.next();
                i10++;
            }
        }
        return recordArr;
    }

    public static final Record[] extractRecords(RRset[] rRsetArr) {
        if (rRsetArr == null || rRsetArr.length == 0) {
            return EMPTY_RECORDS;
        }
        int i10 = 0;
        for (RRset size : rRsetArr) {
            i10 += size.size();
        }
        Record[] recordArr = new Record[i10];
        int i11 = 0;
        for (RRset extractRecords : rRsetArr) {
            Record[] extractRecords2 = extractRecords(extractRecords);
            int length = extractRecords2.length;
            int i12 = 0;
            while (i12 < length) {
                recordArr[i11] = extractRecords2[i12];
                i12++;
                i11++;
            }
        }
        return recordArr;
    }
}
