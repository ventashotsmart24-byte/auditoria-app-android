package com.bigbee.bean.body;

import java.util.List;

public class CustomizeBodyBean {
    private List<KeyValueBean> parameter;

    public List<KeyValueBean> getParameter() {
        return this.parameter;
    }

    public void setParameter(List<KeyValueBean> list) {
        this.parameter = list;
    }
}
