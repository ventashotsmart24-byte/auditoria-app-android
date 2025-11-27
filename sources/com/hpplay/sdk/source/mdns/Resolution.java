package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.Resolver;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Resolution implements ResolverListener {
    private WeakReference<MulticastDNSQuerier> dnsQuerierWeakReference;
    private WeakReference<ResolverListener> listenerWeakReference = null;
    private boolean mdnsVerbose = false;
    private WeakReference<Message> messageWeakReference = null;
    private final List requestIDs = new ArrayList();
    private int requestsSent;
    private final LinkedList responses = new LinkedList();

    public Resolution(MulticastDNSQuerier multicastDNSQuerier, Message message, ResolverListener resolverListener) {
        this.dnsQuerierWeakReference = new WeakReference<>(multicastDNSQuerier);
        this.messageWeakReference = new WeakReference<>(message);
        this.listenerWeakReference = new WeakReference<>(resolverListener);
        this.mdnsVerbose = Options.check("mdns_verbose");
    }

    public static boolean hasMulticastDomains(Message message) {
        Record[] extractRecords = MulticastDNSUtils.extractRecords(message, 0, 1, 2, 3);
        if (extractRecords != null) {
            for (Record name : extractRecords) {
                if (MulticastDNSQuerier.isMulticastDomain(name.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasUnicastDomains(Message message) {
        Record[] extractRecords = MulticastDNSUtils.extractRecords(message, 0, 1, 2, 3);
        if (extractRecords != null) {
            for (Record name : extractRecords) {
                if (!MulticastDNSQuerier.isMulticastDomain(name.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Message getResponse(int i10) {
        boolean z10;
        Message message = (Message) this.messageWeakReference.get().clone();
        Header header = message.getHeader();
        int i11 = 1;
        try {
            Message[] results = getResults(true, i10);
            if (results == null || results.length <= 0) {
                z10 = false;
            } else {
                header.setRcode(0);
                header.setOpcode(0);
                header.setFlag(0);
                int length = results.length;
                int i12 = 0;
                boolean z11 = false;
                while (i12 < length) {
                    Message message2 = results[i12];
                    Header header2 = message2.getHeader();
                    if (header2.getRcode() == 0) {
                        if (header2.getFlag(5)) {
                            header.setFlag(5);
                        }
                        if (header2.getFlag(10)) {
                            header.setFlag(10);
                        }
                        int[] iArr = {i11, 3, 2};
                        for (int i13 = 0; i13 < 3; i13++) {
                            int i14 = iArr[i13];
                            Record[] sectionArray = message2.getSectionArray(i14);
                            if (sectionArray != null && sectionArray.length > 0) {
                                for (Record record : sectionArray) {
                                    if (!message.findRecord(record)) {
                                        message.addRecord(record, i14);
                                        z11 = true;
                                    }
                                }
                            }
                        }
                    }
                    i12++;
                    i11 = 1;
                }
                z10 = z11;
            }
            if (!z10) {
                header.setRcode(3);
            }
            return message;
        } catch (Exception e10) {
            if (e10 instanceof IOException) {
                throw ((IOException) e10);
            }
            IOException iOException = new IOException(e10.getMessage());
            iOException.setStackTrace(e10.getStackTrace());
            throw iOException;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|(2:11|12)|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hpplay.sdk.source.mdns.xbill.dns.Message[] getResults(boolean r5, int r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x002b
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = (long) r6
            long r0 = r0 + r5
        L_0x0008:
            boolean r5 = r4.hasResults()
            if (r5 != 0) goto L_0x002b
            long r5 = java.lang.System.currentTimeMillis()
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x002b
            java.util.LinkedList r2 = r4.responses
            monitor-enter(r2)
            boolean r3 = r4.hasResults()     // Catch:{ all -> 0x0028 }
            if (r3 != 0) goto L_0x0026
            java.util.LinkedList r3 = r4.responses     // Catch:{ InterruptedException -> 0x0026 }
            long r5 = r0 - r5
            r3.wait(r5)     // Catch:{ InterruptedException -> 0x0026 }
        L_0x0026:
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            goto L_0x0008
        L_0x0028:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            throw r5
        L_0x002b:
            java.util.LinkedList r5 = r4.responses
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0087
            java.util.LinkedList r5 = new java.util.LinkedList
            r5.<init>()
            java.util.LinkedList r6 = new java.util.LinkedList
            r6.<init>()
            java.util.LinkedList r0 = r4.responses
            java.util.Iterator r0 = r0.iterator()
        L_0x0043:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0065
            java.lang.Object r1 = r0.next()
            com.hpplay.sdk.source.mdns.Response r1 = (com.hpplay.sdk.source.mdns.Response) r1
            boolean r2 = r1.inError()
            if (r2 == 0) goto L_0x005d
            java.lang.Exception r1 = r1.getException()
            r6.add(r1)
            goto L_0x0043
        L_0x005d:
            com.hpplay.sdk.source.mdns.xbill.dns.Message r1 = r1.getMessage()
            r5.add(r1)
            goto L_0x0043
        L_0x0065:
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x0078
            int r6 = r5.size()
            com.hpplay.sdk.source.mdns.xbill.dns.Message[] r6 = new com.hpplay.sdk.source.mdns.xbill.dns.Message[r6]
            java.lang.Object[] r5 = r5.toArray(r6)
            com.hpplay.sdk.source.mdns.xbill.dns.Message[] r5 = (com.hpplay.sdk.source.mdns.xbill.dns.Message[]) r5
            return r5
        L_0x0078:
            int r5 = r6.size()
            if (r5 > 0) goto L_0x007f
            goto L_0x0087
        L_0x007f:
            r5 = 0
            java.lang.Object r5 = r6.get(r5)
            java.lang.Exception r5 = (java.lang.Exception) r5
            throw r5
        L_0x0087:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.Resolution.getResults(boolean, int):com.hpplay.sdk.source.mdns.xbill.dns.Message[]");
    }

    public void handleException(Object obj, Exception exc) {
        if (this.requestIDs.size() != 0 && (!this.requestIDs.contains(obj) || this != obj || !equals(obj))) {
            synchronized (this.responses) {
                this.responses.add(new Response(obj, exc));
                this.responses.notifyAll();
            }
            if (this.listenerWeakReference.get() != null) {
                this.listenerWeakReference.get().handleException(this, exc);
            }
        } else if (!this.mdnsVerbose) {
        } else {
            if (this.requestIDs.size() == 0 || (this.requestIDs.contains(obj) && this == obj && equals(obj))) {
                Objects.toString(obj);
            }
        }
    }

    public boolean hasResults() {
        if (this.responses.size() >= this.requestsSent) {
            return true;
        }
        return false;
    }

    public boolean inError() {
        Iterator it = this.responses.iterator();
        while (it.hasNext()) {
            if (!((Response) it.next()).inError()) {
                return false;
            }
        }
        return true;
    }

    public void receiveMessage(Object obj, Message message) {
        if (this.requestIDs.size() == 0 || this.requestIDs.contains(obj) || this == obj || equals(obj) || MulticastDNSUtils.answersAny(this.messageWeakReference.get(), message)) {
            synchronized (this.responses) {
                this.responses.add(new Response((Object) this, message));
                this.responses.notifyAll();
            }
            if (this.listenerWeakReference.get() != null) {
                this.listenerWeakReference.get().receiveMessage(this, message);
            }
        } else if (this.mdnsVerbose) {
            if (this.requestIDs.size() != 0 && (!this.requestIDs.contains(obj) || this != obj || !equals(obj))) {
                StringBuilder sb = new StringBuilder();
                sb.append("!!!!! Message Disgarded ");
                sb.append("[Request ID does not match Response ID] ");
            }
            MulticastDNSUtils.answersAny(this.messageWeakReference.get(), message);
        }
    }

    public Object start() {
        this.requestsSent = 0;
        this.requestIDs.clear();
        WeakReference<MulticastDNSQuerier> weakReference = this.dnsQuerierWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        if (hasUnicastDomains(this.messageWeakReference.get()) && this.dnsQuerierWeakReference.get().mUnicastResolvers != null && this.dnsQuerierWeakReference.get().mUnicastResolvers.length > 0) {
            for (Resolver sendAsync : this.dnsQuerierWeakReference.get().mUnicastResolvers) {
                this.requestIDs.add(sendAsync.sendAsync(this.messageWeakReference.get(), this));
                this.requestsSent++;
            }
        }
        if (hasMulticastDomains(this.messageWeakReference.get()) && this.dnsQuerierWeakReference.get().multicastResponders != null && this.dnsQuerierWeakReference.get().multicastResponders.length > 0) {
            for (Querier sendAsync2 : this.dnsQuerierWeakReference.get().multicastResponders) {
                this.requestIDs.add(sendAsync2.sendAsync(this.messageWeakReference.get(), this));
                this.requestsSent++;
            }
        }
        return this;
    }
}
