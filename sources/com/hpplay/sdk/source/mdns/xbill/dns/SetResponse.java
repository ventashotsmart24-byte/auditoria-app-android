package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.ArrayList;
import java.util.List;

public class SetResponse {
    private static final SetResponse nxdomain = new SetResponse(1);
    private static final SetResponse nxrrset = new SetResponse(2);
    private static final SetResponse unknown = new SetResponse(0);
    private Object data;
    private int type;

    private SetResponse() {
    }

    public static SetResponse ofType(int i10) {
        switch (i10) {
            case 0:
                return unknown;
            case 1:
                return nxdomain;
            case 2:
                return nxrrset;
            case 3:
            case 4:
            case 5:
            case 6:
                SetResponse setResponse = new SetResponse();
                setResponse.type = i10;
                setResponse.data = null;
                return setResponse;
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }

    public void addRRset(RRset rRset) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        ((List) this.data).add(rRset);
    }

    public RRset[] answers() {
        if (this.type != 6) {
            return null;
        }
        List list = (List) this.data;
        return (RRset[]) list.toArray(new RRset[list.size()]);
    }

    public CNAMERecord getCNAME() {
        return (CNAMERecord) ((RRset) this.data).first();
    }

    public DNAMERecord getDNAME() {
        return (DNAMERecord) ((RRset) this.data).first();
    }

    public RRset getNS() {
        return (RRset) this.data;
    }

    public boolean isCNAME() {
        if (this.type == 4) {
            return true;
        }
        return false;
    }

    public boolean isDNAME() {
        if (this.type == 5) {
            return true;
        }
        return false;
    }

    public boolean isDelegation() {
        if (this.type == 3) {
            return true;
        }
        return false;
    }

    public boolean isNXDOMAIN() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public boolean isNXRRSET() {
        if (this.type == 2) {
            return true;
        }
        return false;
    }

    public boolean isSuccessful() {
        if (this.type == 6) {
            return true;
        }
        return false;
    }

    public boolean isUnknown() {
        if (this.type == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return "unknown";
            case 1:
                return "NXDOMAIN";
            case 2:
                return "NXRRSET";
            case 3:
                return "delegation: " + this.data;
            case 4:
                return "CNAME: " + this.data;
            case 5:
                return "DNAME: " + this.data;
            case 6:
                return "successful";
            default:
                throw new IllegalStateException();
        }
    }

    public SetResponse(int i10, RRset rRset) {
        if (i10 < 0 || i10 > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.type = i10;
        this.data = rRset;
    }

    public SetResponse(int i10) {
        if (i10 < 0 || i10 > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.type = i10;
        this.data = null;
    }
}
