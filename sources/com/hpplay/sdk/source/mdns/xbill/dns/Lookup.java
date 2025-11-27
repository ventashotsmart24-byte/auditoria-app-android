package com.hpplay.sdk.source.mdns.xbill.dns;

import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class Lookup {
    public static final int HOST_NOT_FOUND = 3;
    public static final int SUCCESSFUL = 0;
    public static final int TRY_AGAIN = 2;
    public static final int TYPE_NOT_FOUND = 4;
    public static final int UNRECOVERABLE = 1;
    private static Map defaultCaches;
    private static int defaultNdots;
    private static Resolver defaultResolver;
    private static Name[] defaultSearchPath;
    private static final Name[] noAliases = new Name[0];
    private List aliases;
    private Record[] answers;
    private boolean badresponse;
    private String badresponse_error;
    private Cache cache;
    private int credibility;
    private int dclass;
    private boolean done;
    private boolean doneCurrent;
    private String error;
    private boolean foundAlias;
    private int iterations;
    private Name name;
    private boolean nametoolong;
    private boolean networkerror;
    private boolean nxdomain;
    private boolean referral;
    private Resolver resolver;
    private int result;
    private Name[] searchPath;
    private boolean temporary_cache;
    private boolean timedout;
    private int type;
    private boolean verbose;

    static {
        refreshDefault();
    }

    public Lookup(Name name2, int i10, int i11) {
        Type.check(i10);
        DClass.check(i11);
        if (Type.isRR(i10) || i10 == 255) {
            this.name = name2;
            this.type = i10;
            this.dclass = i11;
            synchronized (Lookup.class) {
                this.resolver = getDefaultResolver();
                this.searchPath = getDefaultSearchPath();
                this.cache = getDefaultCache(i11);
            }
            this.credibility = 3;
            this.verbose = Options.check("verbose");
            this.result = -1;
            return;
        }
        throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
    }

    private void checkDone() {
        if (!this.done || this.result == -1) {
            StringBuffer stringBuffer = new StringBuffer("Lookup of " + this.name + " ");
            if (this.dclass != 1) {
                stringBuffer.append(DClass.string(this.dclass) + " ");
            }
            stringBuffer.append(Type.string(this.type) + " isn't done");
            throw new IllegalStateException(stringBuffer.toString());
        }
    }

    private void follow(Name name2, Name name3) {
        this.foundAlias = true;
        this.badresponse = false;
        this.networkerror = false;
        this.timedout = false;
        this.nxdomain = false;
        this.referral = false;
        int i10 = this.iterations + 1;
        this.iterations = i10;
        if (i10 >= 6 || name2.equals(name3)) {
            this.result = 1;
            this.error = "CNAME loop";
            this.done = true;
            return;
        }
        if (this.aliases == null) {
            this.aliases = new ArrayList();
        }
        this.aliases.add(name3);
        lookup(name2);
    }

    public static synchronized Cache getDefaultCache(int i10) {
        Cache cache2;
        synchronized (Lookup.class) {
            DClass.check(i10);
            cache2 = (Cache) defaultCaches.get(Mnemonic.toInteger(i10));
            if (cache2 == null) {
                cache2 = new Cache(i10);
                defaultCaches.put(Mnemonic.toInteger(i10), cache2);
            }
        }
        return cache2;
    }

    public static synchronized Resolver getDefaultResolver() {
        Resolver resolver2;
        synchronized (Lookup.class) {
            resolver2 = defaultResolver;
        }
        return resolver2;
    }

    public static synchronized Name[] getDefaultSearchPath() {
        Name[] nameArr;
        synchronized (Lookup.class) {
            nameArr = defaultSearchPath;
        }
        return nameArr;
    }

    private void lookup(Name name2) {
        SetResponse lookupRecords = this.cache.lookupRecords(name2, this.type, this.credibility);
        if (this.verbose) {
            PrintStream printStream = System.err;
            printStream.println("lookup " + name2 + " " + Type.string(this.type));
            System.err.println(lookupRecords);
        }
        processResponse(name2, lookupRecords);
        if (!this.done && !this.doneCurrent) {
            Message newQuery = Message.newQuery(Record.newRecord(name2, this.type, this.dclass));
            try {
                Message send = this.resolver.send(newQuery);
                int rcode = send.getHeader().getRcode();
                if (rcode != 0 && rcode != 3) {
                    this.badresponse = true;
                    this.badresponse_error = Rcode.string(rcode);
                } else if (!newQuery.getQuestion().equals(send.getQuestion())) {
                    this.badresponse = true;
                    this.badresponse_error = "response does not match query";
                } else {
                    SetResponse addMessage = this.cache.addMessage(send);
                    if (addMessage == null) {
                        addMessage = this.cache.lookupRecords(name2, this.type, this.credibility);
                    }
                    if (this.verbose) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("queried " + name2 + " " + Type.string(this.type));
                        System.err.println(addMessage);
                    }
                    processResponse(name2, addMessage);
                }
            } catch (Exception e10) {
                if (e10 instanceof InterruptedIOException) {
                    this.timedout = true;
                } else {
                    this.networkerror = true;
                }
            }
        }
    }

    private void processResponse(Name name2, SetResponse setResponse) {
        if (setResponse.isSuccessful()) {
            RRset[] answers2 = setResponse.answers();
            ArrayList arrayList = new ArrayList();
            for (RRset rrs : answers2) {
                Iterator rrs2 = rrs.rrs();
                while (rrs2.hasNext()) {
                    arrayList.add(rrs2.next());
                }
            }
            this.result = 0;
            this.answers = (Record[]) arrayList.toArray(new Record[arrayList.size()]);
            this.done = true;
        } else if (setResponse.isNXDOMAIN()) {
            this.nxdomain = true;
            this.doneCurrent = true;
            if (this.iterations > 0) {
                this.result = 3;
                this.done = true;
            }
        } else if (setResponse.isNXRRSET()) {
            this.result = 4;
            this.answers = null;
            this.done = true;
        } else if (setResponse.isCNAME()) {
            follow(setResponse.getCNAME().getTarget(), name2);
        } else if (setResponse.isDNAME()) {
            try {
                follow(name2.fromDNAME(setResponse.getDNAME()), name2);
            } catch (Exception unused) {
                this.result = 1;
                this.error = "Invalid DNAME target";
                this.done = true;
            }
        } else if (setResponse.isDelegation()) {
            this.referral = true;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        throw new java.lang.RuntimeException("Failed to initialize resolver");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void refreshDefault() {
        /*
            java.lang.Class<com.hpplay.sdk.source.mdns.xbill.dns.Lookup> r0 = com.hpplay.sdk.source.mdns.xbill.dns.Lookup.class
            monitor-enter(r0)
            com.hpplay.sdk.source.mdns.xbill.dns.ExtendedResolver r1 = new com.hpplay.sdk.source.mdns.xbill.dns.ExtendedResolver     // Catch:{ UnknownHostException -> 0x0029 }
            r1.<init>()     // Catch:{ UnknownHostException -> 0x0029 }
            defaultResolver = r1     // Catch:{ UnknownHostException -> 0x0029 }
            com.hpplay.sdk.source.mdns.xbill.dns.ResolverConfig r1 = com.hpplay.sdk.source.mdns.xbill.dns.ResolverConfig.getCurrentConfig()     // Catch:{ all -> 0x0027 }
            com.hpplay.sdk.source.mdns.xbill.dns.Name[] r1 = r1.searchPath()     // Catch:{ all -> 0x0027 }
            defaultSearchPath = r1     // Catch:{ all -> 0x0027 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0027 }
            r1.<init>()     // Catch:{ all -> 0x0027 }
            defaultCaches = r1     // Catch:{ all -> 0x0027 }
            com.hpplay.sdk.source.mdns.xbill.dns.ResolverConfig r1 = com.hpplay.sdk.source.mdns.xbill.dns.ResolverConfig.getCurrentConfig()     // Catch:{ all -> 0x0027 }
            int r1 = r1.ndots()     // Catch:{ all -> 0x0027 }
            defaultNdots = r1     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)
            return
        L_0x0027:
            r1 = move-exception
            goto L_0x0031
        L_0x0029:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "Failed to initialize resolver"
            r1.<init>(r2)     // Catch:{ all -> 0x0027 }
            throw r1     // Catch:{ all -> 0x0027 }
        L_0x0031:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Lookup.refreshDefault():void");
    }

    private final void reset() {
        this.iterations = 0;
        this.foundAlias = false;
        this.done = false;
        this.doneCurrent = false;
        this.aliases = null;
        this.answers = null;
        this.result = -1;
        this.error = null;
        this.nxdomain = false;
        this.badresponse = false;
        this.badresponse_error = null;
        this.networkerror = false;
        this.timedout = false;
        this.nametoolong = false;
        this.referral = false;
        if (this.temporary_cache) {
            this.cache.clearCache();
        }
    }

    private void resolve(Name name2, Name name3) {
        this.doneCurrent = false;
        if (name3 != null) {
            try {
                name2 = Name.concatenate(name2, name3);
            } catch (Exception unused) {
                this.nametoolong = true;
                return;
            }
        }
        lookup(name2);
    }

    public static synchronized void setDefaultCache(Cache cache2, int i10) {
        synchronized (Lookup.class) {
            DClass.check(i10);
            defaultCaches.put(Mnemonic.toInteger(i10), cache2);
        }
    }

    public static synchronized void setDefaultResolver(Resolver resolver2) {
        synchronized (Lookup.class) {
            defaultResolver = resolver2;
        }
    }

    public static synchronized void setDefaultSearchPath(Name[] nameArr) {
        synchronized (Lookup.class) {
            defaultSearchPath = nameArr;
        }
    }

    public Name[] getAliases() {
        checkDone();
        List list = this.aliases;
        if (list == null) {
            return noAliases;
        }
        return (Name[]) list.toArray(new Name[list.size()]);
    }

    public Record[] getAnswers() {
        checkDone();
        return this.answers;
    }

    public String getErrorString() {
        checkDone();
        String str = this.error;
        if (str != null) {
            return str;
        }
        int i10 = this.result;
        if (i10 == 0) {
            return "successful";
        }
        if (i10 == 1) {
            return "unrecoverable error";
        }
        if (i10 == 2) {
            return "try again";
        }
        if (i10 == 3) {
            return "host not found";
        }
        if (i10 == 4) {
            return "type not found";
        }
        throw new IllegalStateException("unknown result");
    }

    public int getResult() {
        checkDone();
        return this.result;
    }

    public Record[] run() {
        if (this.done) {
            reset();
        }
        if (this.name.isAbsolute()) {
            resolve(this.name, (Name) null);
        } else if (this.searchPath == null) {
            resolve(this.name, Name.root);
        } else {
            if (this.name.labels() > defaultNdots) {
                resolve(this.name, Name.root);
            }
            if (this.done) {
                return this.answers;
            }
            int i10 = 0;
            while (true) {
                Name[] nameArr = this.searchPath;
                if (i10 >= nameArr.length) {
                    break;
                }
                resolve(this.name, nameArr[i10]);
                if (this.done) {
                    return this.answers;
                }
                if (this.foundAlias) {
                    break;
                }
                i10++;
            }
        }
        if (!this.done) {
            if (this.badresponse) {
                this.result = 2;
                this.error = this.badresponse_error;
                this.done = true;
            } else if (this.timedout) {
                this.result = 2;
                this.error = "timed out";
                this.done = true;
            } else if (this.networkerror) {
                this.result = 2;
                this.error = "network error";
                this.done = true;
            } else if (this.nxdomain) {
                this.result = 3;
                this.done = true;
            } else if (this.referral) {
                this.result = 1;
                this.error = "referral";
                this.done = true;
            } else if (this.nametoolong) {
                this.result = 1;
                this.error = "name too long";
                this.done = true;
            }
        }
        return this.answers;
    }

    public void setCache(Cache cache2) {
        if (cache2 == null) {
            this.cache = new Cache(this.dclass);
            this.temporary_cache = true;
            return;
        }
        this.cache = cache2;
        this.temporary_cache = false;
    }

    public void setCredibility(int i10) {
        this.credibility = i10;
    }

    public void setNdots(int i10) {
        if (i10 >= 0) {
            defaultNdots = i10;
            return;
        }
        throw new IllegalArgumentException("Illegal ndots value: " + i10);
    }

    public void setResolver(Resolver resolver2) {
        this.resolver = resolver2;
    }

    public void setSearchPath(Name[] nameArr) {
        this.searchPath = nameArr;
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
        this.searchPath = nameArr;
    }

    public static synchronized void setDefaultSearchPath(String[] strArr) {
        synchronized (Lookup.class) {
            if (strArr == null) {
                defaultSearchPath = null;
                return;
            }
            Name[] nameArr = new Name[strArr.length];
            for (int i10 = 0; i10 < strArr.length; i10++) {
                nameArr[i10] = Name.fromString(strArr[i10], Name.root);
            }
            defaultSearchPath = nameArr;
        }
    }

    public Lookup(Name name2, int i10) {
        this(name2, i10, 1);
    }

    public Lookup(Name name2) {
        this(name2, 1, 1);
    }

    public Lookup(String str, int i10, int i11) {
        this(Name.fromString(str), i10, i11);
    }

    public Lookup(String str, int i10) {
        this(Name.fromString(str), i10, 1);
    }

    public Lookup(String str) {
        this(Name.fromString(str), 1, 1);
    }
}
