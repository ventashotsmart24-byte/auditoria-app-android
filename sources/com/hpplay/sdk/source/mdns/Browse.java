package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.util.LinkedList;
import java.util.List;

public class Browse extends MulticastDNSLookupBase {
    public static final String TAG = "MDNSBrowse";
    protected List<BrowseOperation> browseOperations = new LinkedList();

    public Browse() {
    }

    public synchronized void close() {
        for (BrowseOperation release : this.browseOperations) {
            try {
                release.release();
            } catch (Exception unused) {
            }
        }
        this.browseOperations.clear();
    }

    public String getErrorMsg() {
        try {
            if (this.browseOperations.size() <= 0) {
                return null;
            }
            String str = null;
            for (BrowseOperation errorMsg : this.browseOperations) {
                str = errorMsg.getErrorMsg();
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    public synchronized void start(DNSSDListener dNSSDListener) {
        if (dNSSDListener != null) {
            try {
                Message[] messageArr = this.queries;
                if (messageArr == null || messageArr.length == 0) {
                    throw new NullPointerException("Error sending asynchronous query, No queries specified!");
                }
                BrowseOperation browseOperation = new BrowseOperation((ResolverListener) null, this.queries, this.querier, this.dclass);
                browseOperation.setDNSSDListener(dNSSDListener);
                this.browseOperations.add(browseOperation);
                browseOperation.start();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Error sending asynchronous query, listener is null!");
        }
    }

    public Browse(Name... nameArr) {
        super(nameArr);
    }

    public Browse(Name[] nameArr, int i10) {
        super(nameArr, i10);
    }

    public Browse(Name[] nameArr, int i10, int i11) {
        super(nameArr, i10, i11);
    }

    public Browse(Message message) {
        super(message);
    }

    public Browse(String... strArr) {
        super(strArr);
    }

    public Browse(String[] strArr, int i10) {
        super(strArr, i10);
    }

    public Browse(String[] strArr, int i10, int i11) {
        super(strArr, i10, i11);
    }
}
