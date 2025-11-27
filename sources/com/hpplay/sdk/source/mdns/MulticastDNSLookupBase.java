package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.AAAARecord;
import com.hpplay.sdk.source.mdns.xbill.dns.ARecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverConfig;
import com.hpplay.sdk.source.mdns.xbill.dns.SRVRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.TXTRecord;
import java.io.Closeable;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class MulticastDNSLookupBase implements Constants, Closeable {
    private String TAG;
    protected Object browseID;
    protected int dclass;
    protected Querier defaultQuerier;
    protected Name[] defaultSearchPath;
    protected Name[] names;
    protected Querier querier;
    protected Message[] queries;
    protected Name[] searchPath;
    protected int type;

    public MulticastDNSLookupBase(Name... nameArr) {
        this(nameArr, 255, 255);
    }

    public void addNames(Name[] nameArr) {
        if (nameArr != null && nameArr.length > 0) {
            Name[] nameArr2 = this.names;
            Name[] nameArr3 = new Name[(nameArr2.length + nameArr.length)];
            System.arraycopy(nameArr2, 0, nameArr3, 0, nameArr2.length);
            System.arraycopy(nameArr2, nameArr2.length, nameArr3, nameArr2.length, nameArr.length);
            this.names = nameArr3;
            buildQueries();
        }
    }

    public void addSearchPath(Name[] nameArr) {
        if (nameArr != null && nameArr.length > 0) {
            Name[] nameArr2 = this.searchPath;
            Name[] nameArr3 = new Name[(nameArr2.length + nameArr.length)];
            System.arraycopy(nameArr2, 0, nameArr3, 0, nameArr2.length);
            System.arraycopy(nameArr2, nameArr2.length, nameArr3, nameArr2.length, this.names.length);
            this.searchPath = nameArr3;
            buildQueries();
        }
    }

    public void buildQueries() {
        if (this.names != null && this.searchPath != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Message message = null;
            int i10 = 0;
            while (true) {
                Name[] nameArr = this.names;
                if (i10 >= nameArr.length) {
                    break;
                }
                Name name = nameArr[i10];
                if (!name.isAbsolute()) {
                    int i11 = 0;
                    while (true) {
                        Name[] nameArr2 = this.searchPath;
                        if (i11 >= nameArr2.length) {
                            break;
                        }
                        try {
                            Name concatenate = Name.concatenate(name, nameArr2[i11]);
                            if (!MulticastDNSQuerier.isMulticastDomain(this.searchPath[i11])) {
                                arrayList2.add(Message.newQuery(Record.newRecord(concatenate, this.type, this.dclass)));
                            } else if (message == null) {
                                message = Message.newQuery(Record.newRecord(concatenate, this.type, this.dclass));
                            } else {
                                message.addRecord(Record.newRecord(concatenate, this.type, this.dclass), 0);
                            }
                            arrayList.add(concatenate);
                        } catch (Exception unused) {
                        }
                        i11++;
                    }
                } else {
                    if (!MulticastDNSQuerier.isMulticastDomain(name)) {
                        arrayList2.add(Message.newQuery(Record.newRecord(name, this.type, this.dclass)));
                    } else if (message == null) {
                        message = Message.newQuery(Record.newRecord(name, this.type, this.dclass));
                    } else {
                        message.addRecord(Record.newRecord(name, this.type, this.dclass), 0);
                    }
                    arrayList.add(name);
                }
                i10++;
            }
            if (message != null) {
                arrayList2.add(message);
            }
            this.names = (Name[]) arrayList.toArray(new Name[arrayList.size()]);
            this.queries = (Message[]) arrayList2.toArray(new Message[arrayList2.size()]);
        }
    }

    public void closed() {
        try {
            this.querier.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public ServiceInstance[] extractServiceInstances(Record[] recordArr) {
        HashMap hashMap = new HashMap();
        Arrays.sort(recordArr, new ServiceRecodSorter());
        for (SRVRecord sRVRecord : recordArr) {
            int type2 = sRVRecord.getType();
            if (type2 == 1) {
                ARecord aRecord = (ARecord) sRVRecord;
                for (ServiceInstance serviceInstance : hashMap.values()) {
                    if (aRecord.getName().equals(serviceInstance.getHost())) {
                        if (aRecord.getTTL() > 0) {
                            serviceInstance.addAddress(aRecord.getAddress());
                        } else {
                            serviceInstance.removeAddress(aRecord.getAddress());
                        }
                    }
                }
            } else if (type2 == 12) {
                PTRRecord pTRRecord = (PTRRecord) sRVRecord;
                ServiceInstance serviceInstance2 = (ServiceInstance) hashMap.get(pTRRecord.getTarget());
                if (serviceInstance2 != null) {
                    if (pTRRecord.getTTL() > 0) {
                        serviceInstance2.addPointer(pTRRecord.getName());
                    } else {
                        serviceInstance2.removePointer(pTRRecord.getName());
                    }
                }
            } else if (type2 == 16) {
                TXTRecord tXTRecord = (TXTRecord) sRVRecord;
                ServiceInstance serviceInstance3 = (ServiceInstance) hashMap.get(tXTRecord.getName());
                if (serviceInstance3 != null) {
                    if (tXTRecord.getTTL() > 0) {
                        serviceInstance3.addTextRecords(tXTRecord);
                    } else {
                        serviceInstance3.removeTextRecords(tXTRecord);
                    }
                }
            } else if (type2 == 28) {
                AAAARecord aAAARecord = (AAAARecord) sRVRecord;
                for (ServiceInstance serviceInstance4 : hashMap.values()) {
                    if (aAAARecord.getName().equals(serviceInstance4.getHost())) {
                        if (aAAARecord.getTTL() > 0) {
                            serviceInstance4.addAddress(aAAARecord.getAddress());
                        } else {
                            serviceInstance4.removeAddress(aAAARecord.getAddress());
                        }
                    }
                }
            } else if (type2 == 33) {
                try {
                    ServiceInstance serviceInstance5 = new ServiceInstance(sRVRecord);
                    hashMap.put(serviceInstance5.getName(), serviceInstance5);
                } catch (Exception unused) {
                }
            }
        }
        return (ServiceInstance[]) hashMap.values().toArray(new ServiceInstance[hashMap.size()]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.hpplay.sdk.source.mdns.Querier getDefaultQuerier() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.hpplay.sdk.source.mdns.Querier r0 = r3.defaultQuerier     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x000e
            com.hpplay.sdk.source.mdns.MulticastDNSQuerier r0 = new com.hpplay.sdk.source.mdns.MulticastDNSQuerier     // Catch:{ IOException -> 0x000e }
            r1 = 1
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ IOException -> 0x000e }
            r3.defaultQuerier = r0     // Catch:{ IOException -> 0x000e }
        L_0x000e:
            com.hpplay.sdk.source.mdns.Querier r0 = r3.defaultQuerier     // Catch:{ all -> 0x0012 }
            monitor-exit(r3)
            return r0
        L_0x0012:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.MulticastDNSLookupBase.getDefaultQuerier():com.hpplay.sdk.source.mdns.Querier");
    }

    public synchronized Name[] getDefaultSearchPath() {
        int i10;
        int i11;
        if (this.defaultSearchPath == null) {
            Name[] searchPath2 = ResolverConfig.getCurrentConfig().searchPath();
            if (searchPath2 != null) {
                i10 = searchPath2.length;
            } else {
                i10 = 0;
            }
            this.defaultSearchPath = new Name[(i10 + this.defaultQuerier.getMulticastDomains().length)];
            if (searchPath2 != null) {
                Name[] nameArr = new Name[(searchPath2.length + this.defaultQuerier.getMulticastDomains().length)];
                this.defaultSearchPath = nameArr;
                System.arraycopy(searchPath2, 0, nameArr, 0, searchPath2.length);
                i11 = searchPath2.length;
            } else {
                this.defaultSearchPath = new Name[this.defaultQuerier.getMulticastDomains().length];
                i11 = 0;
            }
            System.arraycopy(this.defaultQuerier.getMulticastDomains(), 0, this.defaultSearchPath, i11, this.defaultQuerier.getMulticastDomains().length);
        }
        return this.defaultSearchPath;
    }

    public Name[] getNames() {
        return this.names;
    }

    public synchronized Querier getQuerier() {
        return this.querier;
    }

    public Name[] getSearchPath() {
        return this.searchPath;
    }

    public synchronized void setDefaultQuerier(Querier querier2) {
        this.defaultQuerier = querier2;
    }

    public synchronized void setDefaultSearchPath(Name[] nameArr) {
        this.defaultSearchPath = nameArr;
    }

    public void setNames(Name[] nameArr) {
        this.names = nameArr;
        buildQueries();
    }

    public synchronized void setQuerier(Querier querier2) {
        this.querier = querier2;
    }

    public void setSearchPath(Name[] nameArr) {
        this.searchPath = nameArr;
        buildQueries();
    }

    public MulticastDNSLookupBase(Name[] nameArr, int i10) {
        this(nameArr, i10, 255);
    }

    public MulticastDNSLookupBase(Name[] nameArr, int i10, int i11) {
        this();
        this.names = nameArr;
        this.type = i10;
        this.dclass = i11;
        buildQueries();
    }

    public synchronized void setDefaultSearchPath(String[] strArr) {
        if (strArr == null) {
            this.defaultSearchPath = null;
            return;
        }
        Name[] nameArr = new Name[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            nameArr[i10] = Name.fromString(strArr[i10], Name.root);
        }
        this.defaultSearchPath = nameArr;
    }

    public void setNames(String[] strArr) {
        if (strArr == null) {
            this.names = null;
            return;
        }
        Name[] nameArr = new Name[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            nameArr[i10] = Name.fromString(strArr[i10], Name.root);
        }
        setNames(nameArr);
    }

    public void setSearchPath(String[] strArr) {
        if (strArr == null) {
            this.searchPath = null;
            return;
        }
        Name[] nameArr = new Name[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            nameArr[i10] = Name.fromString(strArr[i10], Name.root);
        }
        setSearchPath(nameArr);
    }

    public MulticastDNSLookupBase(String... strArr) {
        this(strArr, 255, 255);
    }

    public void addNames(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            Name[] nameArr = new Name[strArr.length];
            for (int i10 = 0; i10 < strArr.length; i10++) {
                nameArr[i10] = Name.fromString(strArr[i10], Name.root);
            }
            addNames(nameArr);
        }
    }

    public void addSearchPath(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            Name[] nameArr = new Name[strArr.length];
            for (int i10 = 0; i10 < strArr.length; i10++) {
                nameArr[i10] = Name.fromString(strArr[i10], Name.root);
            }
            addSearchPath(nameArr);
        }
    }

    public MulticastDNSLookupBase(String str, int i10) {
        this(new String[]{str}, i10, 255);
    }

    public MulticastDNSLookupBase(String str, int i10, int i11) {
        this(new String[]{str}, i10, i11);
    }

    public MulticastDNSLookupBase(String[] strArr, int i10) {
        this(strArr, i10, 255);
    }

    public MulticastDNSLookupBase(String[] strArr, int i10, int i11) {
        this();
        if (strArr == null || strArr.length <= 0) {
            throw new UnknownHostException("Invalid Name(s) specified!");
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < strArr.length; i12++) {
            if (strArr[i12].endsWith(".")) {
                try {
                    arrayList.add(new Name(strArr[i12]));
                } catch (Exception unused) {
                }
            } else {
                for (int i13 = 0; i13 < this.searchPath.length; i13++) {
                    try {
                        arrayList.add(new Name(strArr[i12] + "." + this.searchPath[i13]));
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        this.names = (Name[]) arrayList.toArray(new Name[arrayList.size()]);
        this.type = i10;
        this.dclass = i11;
        buildQueries();
    }

    public MulticastDNSLookupBase() {
        this.TAG = "MulticastDNSLookupBase";
        this.type = 255;
        this.dclass = 255;
        this.querier = getDefaultQuerier();
        this.searchPath = getDefaultSearchPath();
    }

    public MulticastDNSLookupBase(Message message) {
        this();
        this.queries = new Message[]{(Message) message.clone()};
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        int i11 = -1;
        for (Record record : MulticastDNSUtils.extractRecords(message, 0)) {
            if (!arrayList.contains(record)) {
                arrayList.add(record.getName());
            }
            i10 = i10 < 0 ? record.getType() : 255;
            i11 = i11 < 0 ? record.getDClass() : 255;
        }
        if (arrayList.size() > 0) {
            this.type = i10;
            this.dclass = i11;
            try {
                this.names = (Name[]) arrayList.toArray(new Record[arrayList.size()]);
            } catch (Exception unused) {
            }
        }
    }
}
