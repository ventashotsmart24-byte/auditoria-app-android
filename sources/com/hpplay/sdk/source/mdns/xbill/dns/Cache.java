package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cache {
    private static final int defaultMaxEntries = 50000;
    private CacheMap data;
    private int dclass;
    private int maxcache;
    private int maxncache;

    public static class CacheMap extends LinkedHashMap {
        private int maxsize;

        public CacheMap(int i10) {
            super(16, 0.75f, true);
            this.maxsize = i10;
        }

        public int getMaxSize() {
            return this.maxsize;
        }

        public boolean removeEldestEntry(Map.Entry entry) {
            if (this.maxsize < 0 || size() <= this.maxsize) {
                return false;
            }
            return true;
        }

        public void setMaxSize(int i10) {
            this.maxsize = i10;
        }
    }

    public interface Element {
        int compareCredibility(int i10);

        boolean expired();

        int getType();
    }

    public static class NegativeElement implements Element {
        int credibility;
        int expire;
        Name name;
        int type;

        public NegativeElement(Name name2, int i10, SOARecord sOARecord, int i11, long j10) {
            long j11;
            this.name = name2;
            this.type = i10;
            if (sOARecord != null) {
                j11 = sOARecord.getMinimum();
            } else {
                j11 = 0;
            }
            this.credibility = i11;
            this.expire = Cache.limitExpire(j11, j10);
        }

        public final int compareCredibility(int i10) {
            return this.credibility - i10;
        }

        public final boolean expired() {
            if (((int) (System.currentTimeMillis() / 1000)) >= this.expire) {
                return true;
            }
            return false;
        }

        public int getType() {
            return this.type;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.type == 0) {
                stringBuffer.append("NXDOMAIN " + this.name);
            } else {
                stringBuffer.append("NXRRSET " + this.name + " " + Type.string(this.type));
            }
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.credibility);
            return stringBuffer.toString();
        }
    }

    public Cache(int i10) {
        this.maxncache = -1;
        this.maxcache = -1;
        this.dclass = i10;
        this.data = new CacheMap(defaultMaxEntries);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void addElement(com.hpplay.sdk.source.mdns.xbill.dns.Name r4, com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheMap r0 = r3.data     // Catch:{ all -> 0x0059 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x0010
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheMap r0 = r3.data     // Catch:{ all -> 0x0059 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0059 }
            monitor-exit(r3)
            return
        L_0x0010:
            int r1 = r5.getType()     // Catch:{ all -> 0x0059 }
            boolean r2 = r0 instanceof java.util.List     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x0039
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0059 }
            r4 = 0
        L_0x001b:
            int r2 = r0.size()     // Catch:{ all -> 0x0059 }
            if (r4 >= r2) goto L_0x0035
            java.lang.Object r2 = r0.get(r4)     // Catch:{ all -> 0x0059 }
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element r2 = (com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element) r2     // Catch:{ all -> 0x0059 }
            int r2 = r2.getType()     // Catch:{ all -> 0x0059 }
            if (r2 != r1) goto L_0x0032
            r0.set(r4, r5)     // Catch:{ all -> 0x0059 }
            monitor-exit(r3)
            return
        L_0x0032:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0035:
            r0.add(r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0057
        L_0x0039:
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element r0 = (com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element) r0     // Catch:{ all -> 0x0059 }
            int r2 = r0.getType()     // Catch:{ all -> 0x0059 }
            if (r2 != r1) goto L_0x0047
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheMap r0 = r3.data     // Catch:{ all -> 0x0059 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0057
        L_0x0047:
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ all -> 0x0059 }
            r1.<init>()     // Catch:{ all -> 0x0059 }
            r1.add(r0)     // Catch:{ all -> 0x0059 }
            r1.add(r5)     // Catch:{ all -> 0x0059 }
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheMap r5 = r3.data     // Catch:{ all -> 0x0059 }
            r5.put(r4, r1)     // Catch:{ all -> 0x0059 }
        L_0x0057:
            monitor-exit(r3)
            return
        L_0x0059:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x005d
        L_0x005c:
            throw r4
        L_0x005d:
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Cache.addElement(com.hpplay.sdk.source.mdns.xbill.dns.Name, com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element):void");
    }

    private synchronized Element[] allElements(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            return (Element[]) list.toArray(new Element[list.size()]);
        }
        return new Element[]{(Element) obj};
    }

    private synchronized Object exactName(Name name) {
        return this.data.get(name);
    }

    private synchronized Element findElement(Name name, int i10, int i11) {
        Object exactName = exactName(name);
        if (exactName == null) {
            return null;
        }
        return oneElement(name, exactName, i10, i11);
    }

    private RRset[] findRecords(Name name, int i10, int i11) {
        SetResponse lookupRecords = lookupRecords(name, i10, i11);
        if (lookupRecords.isSuccessful()) {
            return lookupRecords.answers();
        }
        return null;
    }

    private final int getCred(int i10, boolean z10) {
        if (i10 == 1) {
            if (!z10) {
                return 3;
            }
            return 4;
        } else if (i10 == 2) {
            if (!z10) {
                return 3;
            }
            return 4;
        } else if (i10 == 3) {
            return 1;
        } else {
            throw new IllegalArgumentException("getCred: invalid section");
        }
    }

    /* access modifiers changed from: private */
    public static int limitExpire(long j10, long j11) {
        if (j11 >= 0 && j11 < j10) {
            j10 = j11;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + j10;
        if (currentTimeMillis < 0 || currentTimeMillis > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) currentTimeMillis;
    }

    private static void markAdditional(RRset rRset, Set set) {
        if (rRset.first().getAdditionalName() != null) {
            Iterator rrs = rRset.rrs();
            while (rrs.hasNext()) {
                Name additionalName = ((Record) rrs.next()).getAdditionalName();
                if (additionalName != null) {
                    set.add(additionalName);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r2.getType() == r7) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element oneElement(com.hpplay.sdk.source.mdns.xbill.dns.Name r5, java.lang.Object r6, int r7, int r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 255(0xff, float:3.57E-43)
            if (r7 == r0) goto L_0x004a
            boolean r0 = r6 instanceof java.util.List     // Catch:{ all -> 0x0048 }
            r1 = 0
            if (r0 == 0) goto L_0x0024
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0048 }
            r0 = 0
        L_0x000d:
            int r2 = r6.size()     // Catch:{ all -> 0x0048 }
            if (r0 < r2) goto L_0x0014
            goto L_0x002e
        L_0x0014:
            java.lang.Object r2 = r6.get(r0)     // Catch:{ all -> 0x0048 }
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element r2 = (com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element) r2     // Catch:{ all -> 0x0048 }
            int r3 = r2.getType()     // Catch:{ all -> 0x0048 }
            if (r3 != r7) goto L_0x0021
            goto L_0x002f
        L_0x0021:
            int r0 = r0 + 1
            goto L_0x000d
        L_0x0024:
            r2 = r6
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element r2 = (com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element) r2     // Catch:{ all -> 0x0048 }
            int r6 = r2.getType()     // Catch:{ all -> 0x0048 }
            if (r6 != r7) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            if (r2 != 0) goto L_0x0033
            monitor-exit(r4)
            return r1
        L_0x0033:
            boolean r6 = r2.expired()     // Catch:{ all -> 0x0048 }
            if (r6 == 0) goto L_0x003e
            r4.removeElement(r5, r7)     // Catch:{ all -> 0x0048 }
            monitor-exit(r4)
            return r1
        L_0x003e:
            int r5 = r2.compareCredibility(r8)     // Catch:{ all -> 0x0048 }
            if (r5 >= 0) goto L_0x0046
            monitor-exit(r4)
            return r1
        L_0x0046:
            monitor-exit(r4)
            return r2
        L_0x0048:
            r5 = move-exception
            goto L_0x0052
        L_0x004a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0048 }
            java.lang.String r6 = "oneElement(ANY)"
            r5.<init>(r6)     // Catch:{ all -> 0x0048 }
            throw r5     // Catch:{ all -> 0x0048 }
        L_0x0052:
            monitor-exit(r4)
            goto L_0x0055
        L_0x0054:
            throw r5
        L_0x0055:
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Cache.oneElement(com.hpplay.sdk.source.mdns.xbill.dns.Name, java.lang.Object, int, int):com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void removeElement(com.hpplay.sdk.source.mdns.xbill.dns.Name r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheMap r0 = r3.data     // Catch:{ all -> 0x0048 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r3)
            return
        L_0x000b:
            boolean r1 = r0 instanceof java.util.List     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0037
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0048 }
            r1 = 0
        L_0x0012:
            int r2 = r0.size()     // Catch:{ all -> 0x0048 }
            if (r1 >= r2) goto L_0x0046
            java.lang.Object r2 = r0.get(r1)     // Catch:{ all -> 0x0048 }
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element r2 = (com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element) r2     // Catch:{ all -> 0x0048 }
            int r2 = r2.getType()     // Catch:{ all -> 0x0048 }
            if (r2 != r5) goto L_0x0034
            r0.remove(r1)     // Catch:{ all -> 0x0048 }
            int r5 = r0.size()     // Catch:{ all -> 0x0048 }
            if (r5 != 0) goto L_0x0032
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheMap r5 = r3.data     // Catch:{ all -> 0x0048 }
            r5.remove(r4)     // Catch:{ all -> 0x0048 }
        L_0x0032:
            monitor-exit(r3)
            return
        L_0x0034:
            int r1 = r1 + 1
            goto L_0x0012
        L_0x0037:
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element r0 = (com.hpplay.sdk.source.mdns.xbill.dns.Cache.Element) r0     // Catch:{ all -> 0x0048 }
            int r0 = r0.getType()     // Catch:{ all -> 0x0048 }
            if (r0 == r5) goto L_0x0041
            monitor-exit(r3)
            return
        L_0x0041:
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheMap r5 = r3.data     // Catch:{ all -> 0x0048 }
            r5.remove(r4)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r3)
            return
        L_0x0048:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x004c
        L_0x004b:
            throw r4
        L_0x004c:
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Cache.removeElement(com.hpplay.sdk.source.mdns.xbill.dns.Name, int):void");
    }

    private synchronized void removeName(Name name) {
        this.data.remove(name);
    }

    public SetResponse addMessage(Message message) {
        SOARecord sOARecord;
        SetResponse setResponse;
        Message message2 = message;
        boolean flag = message.getHeader().getFlag(5);
        Record question = message.getQuestion();
        int rcode = message.getHeader().getRcode();
        boolean check = Options.check("verbosecache");
        if ((rcode != 0 && rcode != 3) || question == null) {
            return null;
        }
        Name name = question.getName();
        int type = question.getType();
        int dClass = question.getDClass();
        HashSet hashSet = new HashSet();
        int i10 = 1;
        RRset[] sectionRRsets = message2.getSectionRRsets(1);
        SetResponse setResponse2 = null;
        Name name2 = name;
        int i11 = 0;
        boolean z10 = false;
        while (i11 < sectionRRsets.length) {
            if (sectionRRsets[i11].getDClass() == dClass) {
                int type2 = sectionRRsets[i11].getType();
                Name name3 = sectionRRsets[i11].getName();
                int cred = getCred(i10, flag);
                if ((type2 == type || type == 255) && name3.equals(name2)) {
                    addRRset(sectionRRsets[i11], cred);
                    if (name2 == name) {
                        if (setResponse2 == null) {
                            setResponse = new SetResponse(6);
                        } else {
                            setResponse = setResponse2;
                        }
                        setResponse.addRRset(sectionRRsets[i11]);
                        setResponse2 = setResponse;
                    }
                    markAdditional(sectionRRsets[i11], hashSet);
                    z10 = true;
                    i11++;
                    i10 = 1;
                } else if (type2 == 5 && name3.equals(name2)) {
                    addRRset(sectionRRsets[i11], cred);
                    if (name2 == name) {
                        setResponse2 = new SetResponse(4, sectionRRsets[i11]);
                    }
                    name2 = ((CNAMERecord) sectionRRsets[i11].first()).getTarget();
                } else if (type2 == 39 && name2.subdomain(name3)) {
                    addRRset(sectionRRsets[i11], cred);
                    if (name2 == name) {
                        setResponse2 = new SetResponse(5, sectionRRsets[i11]);
                    }
                    try {
                        name2 = name2.fromDNAME((DNAMERecord) sectionRRsets[i11].first());
                        i11++;
                        i10 = 1;
                    } catch (Exception unused) {
                    }
                }
            }
            i11++;
            i10 = 1;
        }
        int i12 = 2;
        RRset[] sectionRRsets2 = message2.getSectionRRsets(2);
        RRset rRset = null;
        RRset rRset2 = null;
        for (int i13 = 0; i13 < sectionRRsets2.length; i13++) {
            if (sectionRRsets2[i13].getType() == 6 && name2.subdomain(sectionRRsets2[i13].getName())) {
                rRset2 = sectionRRsets2[i13];
            } else if (sectionRRsets2[i13].getType() == 2 && name2.subdomain(sectionRRsets2[i13].getName())) {
                rRset = sectionRRsets2[i13];
            }
        }
        if (!z10) {
            if (rcode == 3) {
                type = 0;
            }
            if (rcode == 3 || rRset2 != null || rRset == null) {
                int cred2 = getCred(2, flag);
                if (rRset2 != null) {
                    sOARecord = (SOARecord) rRset2.first();
                } else {
                    sOARecord = null;
                }
                addNegative(name2, type, sOARecord, cred2);
                if (setResponse2 == null) {
                    if (rcode == 3) {
                        i12 = 1;
                    }
                    setResponse2 = SetResponse.ofType(i12);
                }
            } else {
                addRRset(rRset, getCred(2, flag));
                markAdditional(rRset, hashSet);
                if (setResponse2 == null) {
                    setResponse2 = new SetResponse(3, rRset);
                }
            }
        } else if (rcode == 0 && rRset != null) {
            addRRset(rRset, getCred(2, flag));
            markAdditional(rRset, hashSet);
        }
        SetResponse setResponse3 = setResponse2;
        RRset[] sectionRRsets3 = message2.getSectionRRsets(3);
        for (int i14 = 0; i14 < sectionRRsets3.length; i14++) {
            int type3 = sectionRRsets3[i14].getType();
            if ((type3 == 1 || type3 == 28 || type3 == 38) && hashSet.contains(sectionRRsets3[i14].getName())) {
                addRRset(sectionRRsets3[i14], getCred(3, flag));
            }
        }
        if (check) {
            System.out.println("addMessage: " + setResponse3);
        }
        return setResponse3;
    }

    public synchronized void addNegative(Name name, int i10, SOARecord sOARecord, int i11) {
        long j10;
        Name name2 = name;
        int i12 = i11;
        synchronized (this) {
            if (sOARecord != null) {
                j10 = sOARecord.getTTL();
            } else {
                j10 = 0;
            }
            int i13 = i10;
            Element findElement = findElement(name, i10, 0);
            if (j10 != 0) {
                if (findElement != null && findElement.compareCredibility(i12) <= 0) {
                    findElement = null;
                }
                if (findElement == null) {
                    addElement(name, new NegativeElement(name, i10, sOARecord, i11, (long) this.maxncache));
                }
            } else if (findElement != null && findElement.compareCredibility(i12) <= 0) {
                removeElement(name, i10);
            }
        }
    }

    public synchronized void addRRset(RRset rRset, int i10) {
        CacheRRset cacheRRset;
        long ttl = rRset.getTTL();
        Name name = rRset.getName();
        int type = rRset.getType();
        Element findElement = findElement(name, type, 0);
        if (ttl != 0) {
            if (findElement != null && findElement.compareCredibility(i10) <= 0) {
                findElement = null;
            }
            if (findElement == null) {
                if (rRset instanceof CacheRRset) {
                    cacheRRset = (CacheRRset) rRset;
                } else {
                    cacheRRset = new CacheRRset(rRset, i10, (long) this.maxcache);
                }
                addElement(name, cacheRRset);
            }
        } else if (findElement != null && findElement.compareCredibility(i10) <= 0) {
            removeElement(name, type);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addRecord(com.hpplay.sdk.source.mdns.xbill.dns.Record r7, int r8, java.lang.Object r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.hpplay.sdk.source.mdns.xbill.dns.Name r9 = r7.getName()     // Catch:{ all -> 0x0038 }
            int r0 = r7.getRRsetType()     // Catch:{ all -> 0x0038 }
            boolean r1 = com.hpplay.sdk.source.mdns.xbill.dns.Type.isRR(r0)     // Catch:{ all -> 0x0038 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r6)
            return
        L_0x0011:
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$Element r9 = r6.findElement(r9, r0, r8)     // Catch:{ all -> 0x0038 }
            if (r9 != 0) goto L_0x0027
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheRRset r9 = new com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheRRset     // Catch:{ all -> 0x0038 }
            int r0 = r6.maxcache     // Catch:{ all -> 0x0038 }
            long r4 = (long) r0     // Catch:{ all -> 0x0038 }
            r0 = r9
            r1 = r6
            r2 = r7
            r3 = r8
            r0.<init>((com.hpplay.sdk.source.mdns.xbill.dns.Record) r2, (int) r3, (long) r4)     // Catch:{ all -> 0x0038 }
            r6.addRRset(r9, r8)     // Catch:{ all -> 0x0038 }
            goto L_0x0036
        L_0x0027:
            int r8 = r9.compareCredibility(r8)     // Catch:{ all -> 0x0038 }
            if (r8 != 0) goto L_0x0036
            boolean r8 = r9 instanceof com.hpplay.sdk.source.mdns.xbill.dns.Cache.CacheRRset     // Catch:{ all -> 0x0038 }
            if (r8 == 0) goto L_0x0036
            com.hpplay.sdk.source.mdns.xbill.dns.Cache$CacheRRset r9 = (com.hpplay.sdk.source.mdns.xbill.dns.Cache.CacheRRset) r9     // Catch:{ all -> 0x0038 }
            r9.addRR(r7)     // Catch:{ all -> 0x0038 }
        L_0x0036:
            monitor-exit(r6)
            return
        L_0x0038:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Cache.addRecord(com.hpplay.sdk.source.mdns.xbill.dns.Record, int, java.lang.Object):void");
    }

    public synchronized void clearCache() {
        this.data.clear();
    }

    public int getDClass() {
        return this.dclass;
    }

    public int getMaxCache() {
        return this.maxcache;
    }

    public int getSize() {
        return this.data.size();
    }

    public synchronized SetResponse lookup(Name name, int i10, int i11) {
        boolean z10;
        boolean z11;
        Name name2;
        int i12 = i10;
        int i13 = i11;
        synchronized (this) {
            int labels = name.labels();
            for (int i14 = labels; i14 >= 1; i14--) {
                if (i14 == 1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (i14 == labels) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z10) {
                    name2 = Name.root;
                    Name name3 = name;
                } else if (z11) {
                    name2 = name;
                    Name name4 = name2;
                } else {
                    name2 = new Name(name, labels - i14);
                }
                Object obj = this.data.get(name2);
                if (obj != null) {
                    if (z11 && i12 == 255) {
                        SetResponse setResponse = new SetResponse(6);
                        Element[] allElements = allElements(obj);
                        int i15 = 0;
                        for (Element element : allElements) {
                            if (element.expired()) {
                                removeElement(name2, element.getType());
                            } else if ((element instanceof CacheRRset) && element.compareCredibility(i13) >= 0) {
                                setResponse.addRRset((CacheRRset) element);
                                i15++;
                            }
                        }
                        if (i15 > 0) {
                            return setResponse;
                        }
                    } else if (z11) {
                        Element oneElement = oneElement(name2, obj, i12, i13);
                        if (oneElement != null && (oneElement instanceof CacheRRset)) {
                            SetResponse setResponse2 = new SetResponse(6);
                            setResponse2.addRRset((CacheRRset) oneElement);
                            return setResponse2;
                        } else if (oneElement != null) {
                            SetResponse setResponse3 = new SetResponse(2);
                            return setResponse3;
                        } else {
                            Element oneElement2 = oneElement(name2, obj, 5, i13);
                            if (oneElement2 != null && (oneElement2 instanceof CacheRRset)) {
                                SetResponse setResponse4 = new SetResponse(4, (CacheRRset) oneElement2);
                                return setResponse4;
                            }
                        }
                    } else {
                        Element oneElement3 = oneElement(name2, obj, 39, i13);
                        if (oneElement3 != null && (oneElement3 instanceof CacheRRset)) {
                            SetResponse setResponse5 = new SetResponse(5, (CacheRRset) oneElement3);
                            return setResponse5;
                        }
                    }
                    Element oneElement4 = oneElement(name2, obj, 2, i13);
                    if (oneElement4 != null && (oneElement4 instanceof CacheRRset)) {
                        SetResponse setResponse6 = new SetResponse(3, (CacheRRset) oneElement4);
                        return setResponse6;
                    } else if (!z11) {
                        continue;
                    } else if (oneElement(name2, obj, 0, i13) != null) {
                        SetResponse ofType = SetResponse.ofType(1);
                        return ofType;
                    }
                }
            }
            SetResponse ofType2 = SetResponse.ofType(0);
            return ofType2;
        }
    }

    public SetResponse lookupRecords(Name name, int i10, int i11) {
        return lookup(name, i10, i11);
    }

    public void release() {
        CacheMap cacheMap = this.data;
        if (cacheMap != null) {
            cacheMap.clear();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (this) {
            for (Object allElements : this.data.values()) {
                Element[] allElements2 = allElements(allElements);
                for (Element append : allElements2) {
                    stringBuffer.append(append);
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    public class CacheRRset extends RRset implements Element {
        private static final long serialVersionUID = 5971755205903597024L;
        int credibility;
        int expire;

        public CacheRRset(Record record, int i10, long j10) {
            this.credibility = i10;
            this.expire = Cache.limitExpire(record.getTTL(), j10);
            addRR(record);
        }

        public final int compareCredibility(int i10) {
            return this.credibility - i10;
        }

        public final boolean expired() {
            if (((int) (System.currentTimeMillis() / 1000)) >= this.expire) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.toString());
            stringBuffer.append(" cl = ");
            stringBuffer.append(this.credibility);
            return stringBuffer.toString();
        }

        public CacheRRset(RRset rRset, int i10, long j10) {
            super(rRset);
            this.credibility = i10;
            this.expire = Cache.limitExpire(rRset.getTTL(), j10);
        }
    }

    public Cache() {
        this(1);
    }

    public Cache(String str) {
        this.maxncache = -1;
        this.maxcache = -1;
        this.data = new CacheMap(defaultMaxEntries);
        Master master = new Master(str);
        while (true) {
            Record nextRecord = master.nextRecord();
            if (nextRecord != null) {
                addRecord(nextRecord, 0, master);
            } else {
                return;
            }
        }
    }
}
