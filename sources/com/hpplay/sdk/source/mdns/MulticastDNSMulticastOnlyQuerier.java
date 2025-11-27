package com.hpplay.sdk.source.mdns;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.hpplay.sdk.source.mdns.net.DatagramProcessor;
import com.hpplay.sdk.source.mdns.net.Packet;
import com.hpplay.sdk.source.mdns.net.PacketListener;
import com.hpplay.sdk.source.mdns.utils.Wait;
import com.hpplay.sdk.source.mdns.xbill.dns.Cache;
import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.OPTRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Opcode;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.RRset;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import com.hpplay.sdk.source.mdns.xbill.dns.TSIG;
import com.hpplay.sdk.source.mdns.xbill.dns.TSIGRecord;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MulticastDNSMulticastOnlyQuerier implements Querier, PacketListener {
    public static final int DEFAULT_EDNS_PAYLOADSIZE = 1280;
    public static final String TAG = "MulticastDNSMulticastOnlyQuerier";
    private static final boolean USE_ONLY_IPV4_ADDR = true;
    private static final boolean USE_ONLY_IPV6_ADDR = false;
    protected MulticastDNSCache cache;
    public CacheMonitors cacheMonitor;
    protected boolean cacheVerbose;
    protected Cacher cacher;
    protected boolean ignoreTruncation;
    private ReceiveMessageThread mReceiveMessageThread;
    protected CopyOnWriteArrayList<ResolverListener> mResolverListener;
    protected boolean mdnsVerbose;
    protected InetAddress multicastAddress;
    protected CopyOnWriteArrayList<DatagramProcessor> multicastProcessors;
    protected int port;
    protected OPTRecord queryOPT;
    protected long responseWaitTime;
    protected long timeoutValue;
    protected TSIG tsig;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MulticastDNSMulticastOnlyQuerier(boolean z10) {
        this((InetAddress) null, InetAddress.getByName(z10 ? Constants.DEFAULT_IPv6_ADDRESS : Constants.DEFAULT_IPv4_ADDRESS));
    }

    public static Application getApplication() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, (Object[]) null), (Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getIpStr(int i10) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i11 = 0;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (isUsableAddress(nextElement)) {
                            if (i11 >= i10) {
                                return nextElement.getHostAddress();
                            }
                            i11++;
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private boolean isUsableAddress(InetAddress inetAddress) {
        if (inetAddress instanceof Inet6Address) {
            return false;
        }
        return true;
    }

    private void startMDNS(InetAddress inetAddress, InetAddress inetAddress2) {
        if (inetAddress.getAddress().length == inetAddress2.getAddress().length) {
            this.multicastProcessors.add(new DatagramProcessor(inetAddress, inetAddress2, this.port, this));
        }
    }

    public void applyEDNS(Message message) {
        if (this.queryOPT != null && message.getOPT() == null) {
            message.addRecord(this.queryOPT, 3);
        }
    }

    public void broadcast(Message message, boolean z10) {
        boolean z11;
        if (message.getHeader().getOpcode() == 5) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            updateCache(MulticastDNSUtils.extractRecords(message, 0, 1, 2, 3), 4);
            writeMessageToWire(convertUpdateToQueryResponse(message));
        } else if (z10) {
            Message queryCache = this.cache.queryCache(message, 1);
            Integer[] numArr = {1, 3, 2};
            for (int i10 = 0; i10 < 3; i10++) {
                Integer num = numArr[i10];
                Record[] sectionArray = queryCache.getSectionArray(num.intValue());
                if (sectionArray != null && sectionArray.length > 0) {
                    for (Record record : sectionArray) {
                        if (!message.findRecord(record)) {
                            message.addRecord(record, num.intValue());
                        }
                    }
                }
            }
            writeMessageToWire(message);
        } else {
            writeMessageToWire(message);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|(1:2)|3|(4:4|5|(1:7)|8)|10|(5:12|(6:15|16|17|29|28|13)|19|20|(1:22))|23|24|(2:26|30)(1:32)) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003a A[Catch:{ Exception -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r3 = this;
            com.hpplay.sdk.source.mdns.ReceiveMessageThread r0 = r3.mReceiveMessageThread
            if (r0 == 0) goto L_0x0007
            r0.release()
        L_0x0007:
            r0 = 0
            com.hpplay.sdk.source.mdns.MulticastDNSCache r1 = r3.cache     // Catch:{ Exception -> 0x0012 }
            if (r1 == 0) goto L_0x000f
            r1.close()     // Catch:{ Exception -> 0x0012 }
        L_0x000f:
            r3.cache = r0     // Catch:{ Exception -> 0x0012 }
            goto L_0x0013
        L_0x0012:
        L_0x0013:
            java.util.concurrent.CopyOnWriteArrayList<com.hpplay.sdk.source.mdns.net.DatagramProcessor> r1 = r3.multicastProcessors
            if (r1 == 0) goto L_0x0036
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r1.next()
            com.hpplay.sdk.source.mdns.net.DatagramProcessor r2 = (com.hpplay.sdk.source.mdns.net.DatagramProcessor) r2
            r2.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x001b
        L_0x002b:
            goto L_0x001b
        L_0x002d:
            java.util.concurrent.CopyOnWriteArrayList<com.hpplay.sdk.source.mdns.net.DatagramProcessor> r1 = r3.multicastProcessors     // Catch:{ Exception -> 0x0036 }
            if (r1 == 0) goto L_0x0036
            r1.clear()     // Catch:{ Exception -> 0x0036 }
            r3.multicastProcessors = r0     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            java.util.concurrent.CopyOnWriteArrayList<com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener> r1 = r3.mResolverListener     // Catch:{ Exception -> 0x003f }
            if (r1 == 0) goto L_0x003f
            r1.clear()     // Catch:{ Exception -> 0x003f }
            r3.mResolverListener = r0     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.MulticastDNSMulticastOnlyQuerier.close():void");
    }

    public Message convertUpdateToQueryResponse(Message message) {
        Message message2 = new Message();
        Header header = message2.getHeader();
        header.setOpcode(0);
        header.setFlag(5);
        header.setFlag(0);
        Record[] sectionArray = message.getSectionArray(2);
        for (Record addRecord : sectionArray) {
            message2.addRecord(addRecord, 1);
        }
        Record[] sectionArray2 = message.getSectionArray(3);
        for (Record addRecord2 : sectionArray2) {
            message2.addRecord(addRecord2, 3);
        }
        return message2;
    }

    public Cache getCache() {
        return this.cache;
    }

    public InetAddress getDeviceIpAddress(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        try {
            int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
            return InetAddress.getByAddress(new byte[]{(byte) (ipAddress & 255), (byte) ((ipAddress >> 8) & 255), (byte) ((ipAddress >> 16) & 255), (byte) ((ipAddress >> 24) & 255)});
        } catch (Exception unused) {
            return null;
        }
    }

    public int getHostCount() {
        int i10 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (isUsableAddress(inetAddresses.nextElement())) {
                        i10++;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return i10;
    }

    public Name[] getMulticastDomains() {
        boolean isIPv4 = isIPv4();
        boolean isIPv6 = isIPv6();
        if (isIPv4 && isIPv6) {
            return Constants.ALL_MULTICAST_DNS_DOMAINS;
        }
        if (isIPv4) {
            return Constants.IPv4_MULTICAST_DOMAINS;
        }
        if (isIPv6) {
            return Constants.IPv6_MULTICAST_DOMAINS;
        }
        return new Name[0];
    }

    public boolean initNetWorkState() {
        return false;
    }

    public boolean isIPv4() {
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            if (it.next().isIPv4()) {
                return true;
            }
        }
        return false;
    }

    public boolean isIPv6() {
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            if (it.next().isIPv6()) {
                return true;
            }
        }
        return false;
    }

    public boolean isOperational() {
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            if (!it.next().isOperational()) {
                return false;
            }
        }
        return this.cacheMonitor.isOperational();
    }

    public void packetReceived(Packet packet) {
        byte[] data = packet.getData();
        if (data.length > 0 && data.length >= 12) {
            try {
                Message parseMessage = parseMessage(data);
                CopyOnWriteArrayList<ResolverListener> copyOnWriteArrayList = this.mResolverListener;
                if (copyOnWriteArrayList != null) {
                    Iterator<ResolverListener> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().receiveMessage(Integer.valueOf(parseMessage.getHeader().getID()), parseMessage);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public Message parseMessage(byte[] bArr) {
        try {
            return new Message(bArr);
        } catch (IOException e10) {
            if (this.mdnsVerbose) {
                e10.printStackTrace(System.err);
            }
            Exception exc = new Exception("Error parsing message - " + e10.getMessage());
            exc.setStackTrace(e10.getStackTrace());
            throw exc;
        }
    }

    public ResolverListener registerListener(ResolverListener resolverListener) {
        this.mResolverListener.add(resolverListener);
        return resolverListener;
    }

    public Message send(Message message) {
        if (message != null) {
            Message message2 = (Message) message.clone();
            int opcode = message2.getHeader().getOpcode();
            if (opcode == 0 || opcode == 1) {
                Message queryCache = this.cache.queryCache(message2, 1);
                if (MulticastDNSUtils.answersAll(message2, queryCache)) {
                    return queryCache;
                }
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                sendAsync(message2, new ResolverListener() {
                    public void handleException(Object obj, Exception exc) {
                        synchronized (arrayList) {
                            arrayList2.add(exc);
                            arrayList.notifyAll();
                        }
                    }

                    public void receiveMessage(Object obj, Message message) {
                        synchronized (arrayList) {
                            arrayList.add(message);
                            arrayList.notifyAll();
                        }
                    }
                });
                Wait.forResponse((Iterable) arrayList);
                if (arrayList2.size() > 0) {
                    Exception exc = (Exception) arrayList2.get(0);
                    IOException iOException = new IOException(exc.getMessage());
                    iOException.setStackTrace(exc.getStackTrace());
                    throw iOException;
                }
            } else if (opcode == 5) {
                broadcast(message2, false);
            } else {
                throw new IOException("Don't know what to do with Opcode: " + Opcode.string(opcode) + " queries.");
            }
            return this.cache.queryCache(message2, 1);
        }
        throw new IOException("Query is null");
    }

    public Object sendAsync(Message message, ResolverListener resolverListener) {
        Message message2 = (Message) message.clone();
        Integer valueOf = Integer.valueOf(message2.getHeader().getID());
        int opcode = message2.getHeader().getOpcode();
        ListenerWrapper listenerWrapper = new ListenerWrapper(valueOf, message2, resolverListener, this);
        registerListener(listenerWrapper);
        if (opcode == 0 || opcode == 1) {
            try {
                Message queryCache = this.cache.queryCache(message2, 1);
                if (queryCache != null && queryCache.getRcode() == 0 && MulticastDNSUtils.answersAll(message2, queryCache)) {
                    MessageInfos messageInfos = new MessageInfos();
                    messageInfos.setIds(valueOf);
                    messageInfos.setListener(resolverListener);
                    messageInfos.setMessage(queryCache);
                    this.mReceiveMessageThread.updateReceiveData(messageInfos);
                }
                try {
                    broadcast(message2, false);
                } catch (IOException e10) {
                    unregisterListener(listenerWrapper);
                    resolverListener.handleException(valueOf, e10);
                }
                int intValue = Options.intValue("mdns_resolve_wait");
                System.currentTimeMillis();
                unregisterListener(listenerWrapper);
            } catch (Exception e11) {
                resolverListener.handleException(valueOf, e11);
            }
        } else if (opcode != 5) {
            resolverListener.handleException(valueOf, new IOException("Don't know what to do with Opcode: " + Opcode.string(opcode) + " queries."));
            unregisterListener(listenerWrapper);
        } else {
            try {
                broadcast(message2, false);
            } catch (Exception e12) {
                resolverListener.handleException(valueOf, e12);
                unregisterListener(listenerWrapper);
            }
        }
        return valueOf;
    }

    public void setAddress(InetAddress inetAddress) {
        this.multicastAddress = inetAddress;
    }

    public void setCache(Cache cache2) {
        if (cache2 instanceof MulticastDNSCache) {
            MulticastDNSCache multicastDNSCache = (MulticastDNSCache) cache2;
            this.cache = multicastDNSCache;
            if (multicastDNSCache.getCacheMonitor() == null) {
                this.cache.setCacheMonitor(this.cacheMonitor);
                return;
            }
            return;
        }
        try {
            MulticastDNSCache multicastDNSCache2 = new MulticastDNSCache(cache2);
            this.cache = multicastDNSCache2;
            if (multicastDNSCache2.getCacheMonitor() == null) {
                this.cache.setCacheMonitor(this.cacheMonitor);
            }
        } catch (Exception e10) {
            throw new IllegalArgumentException("Could not set Cache - " + e10.getMessage());
        }
    }

    public void setEDNS(int i10) {
        setEDNS(i10, 0, 0, (List) null);
    }

    public void setIgnoreTruncation(boolean z10) {
        this.ignoreTruncation = z10;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public void setRetryWaitTime(int i10) {
        setRetryWaitTime(i10, 0);
    }

    public void setTCP(boolean z10) {
    }

    public void setTSIGKey(TSIG tsig2) {
        this.tsig = tsig2;
    }

    public void setTimeout(int i10) {
        setTimeout(i10, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0012, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean unregisterListener(com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            java.util.concurrent.CopyOnWriteArrayList<com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener> r1 = r2.mResolverListener     // Catch:{ Exception -> 0x0011, all -> 0x000e }
            if (r1 != 0) goto L_0x0008
            monitor-exit(r2)
            return r0
        L_0x0008:
            boolean r3 = r1.remove(r3)     // Catch:{ Exception -> 0x0011, all -> 0x000e }
            monitor-exit(r2)
            return r3
        L_0x000e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x0011:
            monitor-exit(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.MulticastDNSMulticastOnlyQuerier.unregisterListener(com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener):boolean");
    }

    public void updateCache(Record[] recordArr, int i10) {
        if (recordArr != null && recordArr.length > 0) {
            for (Record clone : recordArr) {
                try {
                    Record clone2 = MulticastDNSUtils.clone(clone);
                    MulticastDNSUtils.setDClassForRecord(clone2, clone2.getDClass() & 32767);
                    if (clone2.getTTL() > 0) {
                        RRset[] answers = this.cache.lookupRecords(clone2.getName(), clone2.getType(), 1).answers();
                        if (answers == null || answers.length <= 0) {
                            this.cache.addRecord(clone2, i10, (Object) null);
                        } else {
                            Record[] extractRecords = MulticastDNSUtils.extractRecords(answers);
                            if (extractRecords != null && extractRecords.length > 0) {
                                this.cache.updateRRset(clone2, i10);
                            }
                        }
                    } else {
                        this.cache.removeElementCopy(clone2.getName(), clone2.getType());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public int verifyTSIG(Message message, Message message2, byte[] bArr, TSIG tsig2) {
        if (tsig2 == null) {
            return 0;
        }
        return tsig2.verify(message2, bArr, message.getTSIG());
    }

    public void writeMessageToWire(Message message) {
        int i10;
        Header header = message.getHeader();
        header.setID(0);
        applyEDNS(message);
        TSIG tsig2 = this.tsig;
        if (tsig2 != null) {
            tsig2.apply(message, (TSIGRecord) null);
        }
        byte[] wire = message.toWire((int) Message.MAXLENGTH);
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            DatagramProcessor next = it.next();
            OPTRecord opt = message.getOPT();
            if (opt != null) {
                i10 = opt.getPayloadSize();
            } else {
                i10 = next.getMaxPayloadSize();
            }
            if (wire.length <= i10) {
                try {
                    next.send(wire);
                } catch (Exception e10) {
                    Iterator<ResolverListener> it2 = this.mResolverListener.iterator();
                    while (it2.hasNext()) {
                        it2.next().handleException(TAG, e10);
                    }
                }
            } else if (!header.getFlag(0)) {
                Message[] splitMessage = MulticastDNSUtils.splitMessage(message);
                for (Message writeMessageToWire : splitMessage) {
                    writeMessageToWire(writeMessageToWire);
                }
                return;
            } else {
                throw new IOException("DNS Message too large! - " + wire.length + " bytes in size.");
            }
        }
    }

    public void writeResponse(Message message) {
        Header header = message.getHeader();
        header.setFlag(5);
        header.setFlag(0);
        header.setRcode(0);
        writeMessageToWire(message);
    }

    public MulticastDNSMulticastOnlyQuerier(InetAddress inetAddress, InetAddress inetAddress2) {
        this.mdnsVerbose = false;
        this.cacheVerbose = false;
        this.mResolverListener = new CopyOnWriteArrayList<>();
        this.port = Constants.DEFAULT_PORT;
        this.ignoreTruncation = false;
        this.timeoutValue = 6000;
        this.responseWaitTime = 500;
        this.multicastProcessors = new CopyOnWriteArrayList<>();
        if (this.mReceiveMessageThread == null) {
            ReceiveMessageThread receiveMessageThread = new ReceiveMessageThread();
            this.mReceiveMessageThread = receiveMessageThread;
            receiveMessageThread.start();
        }
        this.cacheMonitor = new CacheMonitors(this);
        boolean z10 = true;
        this.mdnsVerbose = Options.check("mdns_verbose") || Options.check("verbose");
        if (!Options.check("mdns_cache_verbose") && !Options.check("cache_verbose")) {
            z10 = false;
        }
        this.cacheVerbose = z10;
        MulticastDNSCache instance = MulticastDNSCache.getInstance();
        this.cache = instance;
        if (instance.getCacheMonitor() == null) {
            this.cache.setCacheMonitor(this.cacheMonitor);
        }
        setAddress(inetAddress2);
        if (inetAddress != null) {
            this.multicastProcessors.add(new DatagramProcessor(inetAddress, inetAddress2, this.port, this));
        } else {
            try {
                int hostCount = getHostCount();
                for (int i10 = 0; i10 < hostCount; i10++) {
                    String ipStr = getIpStr(i10);
                    if (!TextUtils.isEmpty(ipStr)) {
                        startMDNS(InetAddress.getByName(ipStr), inetAddress2);
                    }
                }
            } catch (Exception unused) {
                startMDNS(getDeviceIpAddress(getApplication()), inetAddress2);
            }
        }
        Cacher cacher2 = new Cacher(this);
        this.cacher = cacher2;
        registerListener(cacher2);
        Iterator<DatagramProcessor> it = this.multicastProcessors.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
        registerListener(new MulticastDNSResponder(this.mdnsVerbose, this));
    }

    public void setEDNS(int i10, int i11, int i12, List list) {
        if (i10 == 0 || i10 == -1) {
            this.queryOPT = new OPTRecord(i11 == 0 ? 1280 : i11, 0, i10, i12, list);
            return;
        }
        throw new IllegalArgumentException("invalid EDNS level - must be 0 or -1");
    }

    public void setRetryWaitTime(int i10, int i11) {
        this.responseWaitTime = (((long) i10) * 1000) + ((long) i11);
    }

    public void setTimeout(int i10, int i11) {
        this.timeoutValue = (((long) i10) * 1000) + ((long) i11);
    }
}
