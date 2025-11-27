package com.efs.sdk.base.observer;

import java.util.Map;

public interface IConfigCallback {
    void onChange(Map<String, Object> map);
}
