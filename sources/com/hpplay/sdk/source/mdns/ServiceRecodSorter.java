package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import java.util.Comparator;

public class ServiceRecodSorter implements Comparator {
    public int compare(Object obj, Object obj2) {
        if (!(obj instanceof Record) || !(obj2 instanceof Record)) {
            return -1;
        }
        int type = ((Record) obj).getType();
        int type2 = ((Record) obj2).getType();
        if (type != 1) {
            if (type != 12) {
                if (type == 16) {
                    if (type2 != 12) {
                        if (type2 == 16) {
                            return 0;
                        }
                        if (type2 != 33) {
                            return -1;
                        }
                    }
                    return 1;
                } else if (type != 28) {
                    if (type != 33) {
                        if (type != 47) {
                            return -1;
                        }
                        if (type2 == 1 || type2 == 12 || type2 == 16 || type2 == 28 || type2 == 33) {
                            return 1;
                        }
                        if (type2 != 47) {
                            return -1;
                        }
                        return 0;
                    } else if (type2 == 33) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            } else if (type2 == 12) {
                return 0;
            } else {
                if (type2 != 33) {
                    return -1;
                }
                return 1;
            }
        }
        if (type2 != 1) {
            if (!(type2 == 12 || type2 == 16)) {
                if (type2 != 28) {
                    if (type2 != 33) {
                        return -1;
                    }
                }
            }
            return 1;
        }
        return 0;
    }
}
