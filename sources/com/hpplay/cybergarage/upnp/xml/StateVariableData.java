package com.hpplay.cybergarage.upnp.xml;

import com.hpplay.cybergarage.upnp.control.QueryListener;
import com.hpplay.cybergarage.upnp.control.QueryResponse;

public class StateVariableData extends NodeData {
    private QueryListener queryListener = null;
    private QueryResponse queryRes = null;
    private String value = "";

    public QueryListener getQueryListener() {
        return this.queryListener;
    }

    public QueryResponse getQueryResponse() {
        return this.queryRes;
    }

    public String getValue() {
        return this.value;
    }

    public void setQueryListener(QueryListener queryListener2) {
        this.queryListener = queryListener2;
    }

    public void setQueryResponse(QueryResponse queryResponse) {
        this.queryRes = queryResponse;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
