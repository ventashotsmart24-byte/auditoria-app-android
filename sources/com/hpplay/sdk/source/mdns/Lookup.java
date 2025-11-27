package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.utils.Wait;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Lookup extends MulticastDNSLookupBase {

    public static class Domain {
        private boolean isDefault;
        private boolean isLegacy;
        private final Name name;

        public Domain(Name name2) {
            this.name = name2;
            byte[] label = name2.getLabel(0);
            if (label != null) {
                char c10 = (char) label[0];
                if (c10 == 'd') {
                    this.isDefault = true;
                } else if (c10 == 'l') {
                    this.isLegacy = true;
                }
            }
        }

        public boolean equals(Object obj) {
            Name name2;
            if (obj == this || (name2 = this.name) == obj) {
                return true;
            }
            if (obj instanceof Domain) {
                return name2.equals(((Domain) obj).name);
            }
            return false;
        }

        public Name getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public boolean isDefault() {
            return this.isDefault;
        }

        public boolean isLegacy() {
            return this.isLegacy;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.name);
            String str2 = "";
            if (this.isDefault) {
                str = "  [default]";
            } else {
                str = str2;
            }
            sb.append(str);
            if (this.isLegacy) {
                str2 = "  [legacy]";
            }
            sb.append(str2);
            return sb.toString();
        }
    }

    public interface RecordListener {
        void handleException(Object obj, Exception exc);

        void receiveRecord(Object obj, Record record);
    }

    public Lookup(Name... nameArr) {
        super(nameArr);
    }

    public void close() {
    }

    public Domain[] lookupDomains() {
        final Set synchronizedSet = Collections.synchronizedSet(new HashSet());
        final List synchronizedList = Collections.synchronizedList(new LinkedList());
        Message[] messageArr = this.queries;
        if (messageArr != null && messageArr.length > 0) {
            lookupRecordsAsync((RecordListener) new RecordListener() {
                public void handleException(Object obj, Exception exc) {
                    synchronizedList.add(exc);
                }

                public void receiveRecord(Object obj, Record record) {
                    if (record.getTTL() > 0 && record.getType() == 12) {
                        String name = ((PTRRecord) record).getTarget().toString();
                        if (!name.endsWith(".")) {
                            name = name + ".";
                        }
                        try {
                            synchronizedSet.add(new Domain(new Name(name)));
                        } catch (Exception e10) {
                            e10.printStackTrace(System.err);
                        }
                    }
                }
            });
            Wait.forResponse((Iterable) synchronizedSet);
        }
        for (Name domain : this.searchPath) {
            synchronizedSet.add(new Domain(domain));
        }
        return (Domain[]) synchronizedSet.toArray(new Domain[synchronizedSet.size()]);
    }

    public Record[] lookupRecords() {
        final ConcurrentLinkedQueue<Message> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        final ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        lookupRecordsAsync((ResolverListener) new ResolverListener() {
            public void handleException(Object obj, Exception exc) {
                concurrentLinkedQueue2.add(exc);
            }

            public void receiveMessage(Object obj, Message message) {
                concurrentLinkedQueue.add(message);
            }
        });
        Wait.forResponse((Iterable) concurrentLinkedQueue);
        ArrayList arrayList = new ArrayList();
        for (Message message : concurrentLinkedQueue) {
            if (message.getRcode() == 0) {
                arrayList.addAll(Arrays.asList(MulticastDNSUtils.extractRecords(message, 1, 2, 3)));
            }
        }
        return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
    }

    public Object[] lookupRecordsAsync(final RecordListener recordListener) {
        return lookupRecordsAsync((ResolverListener) new ResolverListener() {
            public void handleException(Object obj, Exception exc) {
                recordListener.handleException(obj, exc);
            }

            public void receiveMessage(Object obj, Message message) {
                for (Record receiveRecord : MulticastDNSUtils.extractRecords(message, 1, 3, 2)) {
                    recordListener.receiveRecord(obj, receiveRecord);
                }
            }
        });
    }

    public ServiceInstance[] lookupServices() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(extractServiceInstances(lookupRecords())));
        return (ServiceInstance[]) arrayList.toArray(new ServiceInstance[arrayList.size()]);
    }

    public Lookup(Name[] nameArr, int i10) {
        super(nameArr, i10);
    }

    public Object[] lookupRecordsAsync(ResolverListener resolverListener) {
        ArrayList arrayList = new ArrayList(this.queries.length);
        for (Message sendAsync : this.queries) {
            getQuerier().sendAsync(sendAsync, resolverListener);
        }
        return arrayList.toArray();
    }

    public Lookup(Name name, int i10) {
        super(new Name[]{name}, i10);
    }

    public Lookup(Name[] nameArr, int i10, int i11) {
        super(nameArr, i10, i11);
    }

    public static ServiceInstance[] lookupServices(Name name) {
        return lookupServices(new Name[]{name}, 255, 255);
    }

    public Lookup(Name name, int i10, int i11) {
        super(new Name[]{name}, i10, i11);
    }

    public static ServiceInstance[] lookupServices(Name[] nameArr) {
        return lookupServices(nameArr, 255, 255);
    }

    public Lookup(String... strArr) {
        super(strArr);
    }

    public static ServiceInstance[] lookupServices(Name name, int i10) {
        return lookupServices(new Name[]{name}, i10, 255);
    }

    public Lookup(String str, int i10) {
        super(str, i10);
    }

    public static ServiceInstance[] lookupServices(Name[] nameArr, int i10) {
        return lookupServices(nameArr, i10, 255);
    }

    public Lookup(String str, int i10, int i11) {
        super(str, i10, i11);
    }

    public static ServiceInstance[] lookupServices(Name name, int i10, int i11) {
        return lookupServices(new Name[]{name}, i10, i11);
    }

    public Lookup(String[] strArr, int i10) {
        super(strArr, i10);
    }

    public static ServiceInstance[] lookupServices(Name[] nameArr, int i10, int i11) {
        Lookup lookup = new Lookup(nameArr, i10, i11);
        try {
            return lookup.lookupServices();
        } finally {
            lookup.close();
        }
    }

    public Lookup(String[] strArr, int i10, int i11) {
        super(strArr, i10, i11);
    }

    public Lookup() {
    }

    public static Record[] lookupRecords(Name name) {
        return lookupRecords(new Name[]{name}, 255, 255);
    }

    public Lookup(Message message) {
        super(message);
    }

    public static Record[] lookupRecords(Name[] nameArr) {
        return lookupRecords(nameArr, 255, 255);
    }

    public static Record[] lookupRecords(Name name, int i10) {
        return lookupRecords(new Name[]{name}, i10, 255);
    }

    public static Record[] lookupRecords(Name[] nameArr, int i10) {
        return lookupRecords(nameArr, i10, 255);
    }

    public static Record[] lookupRecords(Name name, int i10, int i11) {
        return lookupRecords(new Name[]{name}, i10, i11);
    }

    public static Record[] lookupRecords(Name[] nameArr, int i10, int i11) {
        Lookup lookup = new Lookup(nameArr, i10, i11);
        try {
            return lookup.lookupRecords();
        } finally {
            lookup.close();
        }
    }
}
