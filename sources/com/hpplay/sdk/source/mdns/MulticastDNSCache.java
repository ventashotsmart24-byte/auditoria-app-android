package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.utils.Misc;
import com.hpplay.sdk.source.mdns.xbill.dns.Cache;
import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.RRset;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.SetResponse;
import java.io.Closeable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MulticastDNSCache extends Cache implements Closeable {
    protected static final Logger logger;
    private static MulticastDNSCache multicastDNSCache;
    private CacheMonitor cacheMonitor;
    public LinkedHashMap dataCopy;
    private Field dataField;
    private Method findElement;
    private MonitorTask monitorTask;
    private Method removeElement;

    public interface CacheMonitor {
        void begin();

        void check(RRset rRset, int i10, int i11);

        void end();

        void expired(RRset rRset, int i10);

        boolean isOperational();
    }

    static {
        boolean z10;
        String name = MulticastDNSCache.class.getName();
        if (Options.check("mdns_verbose") || Options.check("dns_verbose") || Options.check("verbose")) {
            z10 = true;
        } else {
            z10 = false;
        }
        logger = Misc.getLogger(name, z10);
    }

    public MulticastDNSCache() {
        this.cacheMonitor = null;
        this.dataField = null;
        this.findElement = null;
        this.removeElement = null;
        populateReflectedFields();
    }

    private ElementHelper findElementCopy(Name name, int i10, int i11) {
        Object invoke = this.findElement.invoke(this, new Object[]{name, new Integer(i10), new Integer(i11)});
        if (invoke == null) {
            return null;
        }
        try {
            return new ElementHelper(this, invoke);
        } catch (Exception e10) {
            logger.log(Level.WARNING, e10.getMessage(), e10);
            return null;
        }
    }

    public static MulticastDNSCache getInstance() {
        if (multicastDNSCache == null) {
            try {
                multicastDNSCache = new MulticastDNSCache();
            } catch (Exception unused) {
            }
        }
        return multicastDNSCache;
    }

    public synchronized void addRRset(RRset rRset, int i10) {
        super.addRRset(rRset, i10);
    }

    public synchronized void addRecord(Record record, int i10, Object obj) {
        super.addRecord(record, i10, obj);
    }

    public synchronized void close() {
        MonitorTask monitorTask2 = this.monitorTask;
        if (monitorTask2 != null) {
            monitorTask2.release();
        }
        release();
        this.cacheMonitor = null;
        multicastDNSCache = null;
    }

    public CacheMonitor getCacheMonitor() {
        return this.cacheMonitor;
    }

    public void populateReflectedFields() {
        Class<Name> cls = Name.class;
        if (this.monitorTask == null) {
            MonitorTask monitorTask2 = new MonitorTask(this);
            this.monitorTask = monitorTask2;
            monitorTask2.start();
        }
        Class<? super Object> superclass = getClass().getSuperclass();
        try {
            Field findField = ElementHelper.findField(superclass, "data");
            this.dataField = findField;
            AccessibleObject.setAccessible(new AccessibleObject[]{findField}, true);
            this.dataCopy = (LinkedHashMap) this.dataField.get(this);
        } catch (NoSuchFieldException e10) {
            logger.log(Level.WARNING, e10.getMessage(), e10);
            throw e10;
        } catch (Exception e11) {
            logger.log(Level.WARNING, e11.getMessage(), e11);
        }
        try {
            Class cls2 = Integer.TYPE;
            this.findElement = ElementHelper.findMethod(superclass, "findElement", new Class[]{cls, cls2, cls2});
            Method findMethod = ElementHelper.findMethod(superclass, "removeElement", new Class[]{cls, cls2});
            this.removeElement = findMethod;
            AccessibleObject.setAccessible(new AccessibleObject[]{this.findElement, findMethod}, true);
        } catch (NoSuchMethodException e12) {
            logger.log(Level.WARNING, e12.getMessage(), e12);
            throw e12;
        } catch (Exception e13) {
            logger.log(Level.WARNING, e13.getMessage(), e13);
        }
    }

    public Message queryCache(Message message) {
        return queryCache(message, 1);
    }

    public Record[] queryCacheForAdditionalRecords(Record record, int i10) {
        if (record == null) {
            return MulticastDNSUtils.EMPTY_RECORDS;
        }
        LinkedList linkedList = new LinkedList();
        Name targetFromRecord = MulticastDNSUtils.getTargetFromRecord(record);
        if (targetFromRecord != null) {
            SetResponse lookupRecords = lookupRecords(targetFromRecord, 255, i10);
            if (lookupRecords.isSuccessful()) {
                for (Record record2 : MulticastDNSUtils.extractRecords(lookupRecords.answers())) {
                    linkedList.add(record2);
                    for (Record add : queryCacheForAdditionalRecords(record2, i10)) {
                        linkedList.add(add);
                    }
                }
            }
        }
        return (Record[]) linkedList.toArray(new Record[linkedList.size()]);
    }

    public void removeElementCopy(Name name, int i10) {
        try {
            this.removeElement.invoke(this, new Object[]{name, new Integer(i10)});
        } catch (Exception e10) {
            logger.log(Level.WARNING, e10.getMessage(), e10);
        }
    }

    public synchronized void removeRRset(RRset rRset) {
        removeElementCopy(rRset.getName(), rRset.getType());
    }

    public synchronized void setCacheMonitor(CacheMonitor cacheMonitor2) {
        if (cacheMonitor2 != null) {
            this.cacheMonitor = cacheMonitor2;
        }
    }

    public synchronized void updateRRset(Record record, int i10) {
        long ttl = record.getTTL();
        ElementHelper findElementCopy = findElementCopy(record.getName(), record.getType(), 0);
        if (findElementCopy == null) {
            addRecord(record, i10, this);
        } else if (findElementCopy.compareCredibility(i10) <= 0) {
            if (findElementCopy.getElement() instanceof RRset) {
                ((RRset) findElementCopy.getElement()).addRR(record);
                if (findElementCopy.getTTL() == ttl) {
                    findElementCopy.resetExpire();
                } else {
                    addRecord(record, i10, this);
                }
            } else {
                addRecord(record, i10, this);
            }
        }
    }

    public Message queryCache(Message message, int i10) {
        Message message2 = message;
        int i11 = i10;
        int i12 = 255;
        int i13 = 1;
        if (message.getHeader().getOpcode() == 5) {
            Message message3 = new Message(message.getHeader().getID());
            Header header = message3.getHeader();
            header.setRcode(3);
            Stack stack = new Stack();
            for (Record name : MulticastDNSUtils.extractRecords(message2, 2)) {
                stack.push(name.getName());
            }
            while (!stack.isEmpty()) {
                SetResponse lookupRecords = lookupRecords((Name) stack.pop(), 255, i11);
                if (lookupRecords.isSuccessful()) {
                    header.setRcode(0);
                    header.setOpcode(0);
                    header.setFlag(0);
                    for (Record record : MulticastDNSUtils.extractRecords(lookupRecords.answers())) {
                        if (!message3.findRecord(record)) {
                            message3.addRecord(record, 1);
                        }
                        Name targetFromRecord = MulticastDNSUtils.getTargetFromRecord(record);
                        if (targetFromRecord != null) {
                            stack.push(targetFromRecord);
                        }
                    }
                }
            }
            return message3;
        }
        Message message4 = new Message(message.getHeader().getID());
        Header header2 = message4.getHeader();
        header2.setRcode(3);
        Record[] extractRecords = MulticastDNSUtils.extractRecords(message2, 0);
        if (extractRecords != null && extractRecords.length > 0) {
            int length = extractRecords.length;
            int i14 = 0;
            while (i14 < length) {
                Record record2 = extractRecords[i14];
                message4.addRecord(record2, 0);
                MulticastDNSUtils.setDClassForRecord(record2, record2.getDClass() & 32767);
                SetResponse lookupRecords2 = lookupRecords(record2.getName(), i12, i11);
                if (lookupRecords2.isSuccessful()) {
                    header2.setRcode(0);
                    header2.setOpcode(0);
                    header2.setFlag(0);
                    Record[] extractRecords2 = MulticastDNSUtils.extractRecords(lookupRecords2.answers());
                    if (extractRecords2 != null && extractRecords2.length > 0) {
                        int length2 = extractRecords2.length;
                        int i15 = 0;
                        while (i15 < length2) {
                            Record record3 = extractRecords2[i15];
                            if (!message4.findRecord(record3)) {
                                message4.addRecord(record3, i13);
                            }
                            for (Record record4 : queryCacheForAdditionalRecords(record3, i11)) {
                                if (!message4.findRecord(record4)) {
                                    message4.addRecord(record4, 3);
                                }
                            }
                            i15++;
                            i13 = 1;
                        }
                    }
                }
                i14++;
                i12 = 255;
                i13 = 1;
            }
        }
        return message4;
    }

    public MulticastDNSCache(int i10) {
        super(i10);
        this.cacheMonitor = null;
        this.dataField = null;
        this.findElement = null;
        this.removeElement = null;
        populateReflectedFields();
    }

    public MulticastDNSCache(String str) {
        super(str);
        this.cacheMonitor = null;
        this.dataField = null;
        this.findElement = null;
        this.removeElement = null;
        populateReflectedFields();
    }

    public MulticastDNSCache(Cache cache) {
        this();
        Field declaredField = cache.getClass().getDeclaredField("data");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(cache);
        Field declaredField2 = super.getClass().getDeclaredField("data");
        declaredField2.setAccessible(true);
        declaredField2.set(this, obj);
        populateReflectedFields();
    }
}
