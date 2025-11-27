package org.simpleframework.xml.filter;

import java.util.Map;

public class MapFilter implements Filter {
    private Filter filter;
    private Map map;

    public MapFilter(Map map2) {
        this(map2, (Filter) null);
    }

    public String replace(String str) {
        Object obj;
        Map map2 = this.map;
        if (map2 != null) {
            obj = map2.get(str);
        } else {
            obj = null;
        }
        if (obj != null) {
            return obj.toString();
        }
        Filter filter2 = this.filter;
        if (filter2 != null) {
            return filter2.replace(str);
        }
        return null;
    }

    public MapFilter(Map map2, Filter filter2) {
        this.filter = filter2;
        this.map = map2;
    }
}
