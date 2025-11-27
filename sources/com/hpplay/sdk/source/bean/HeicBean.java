package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.io.Serializable;

public class HeicBean implements Serializable {
    public LelinkPlayerInfo lelinkPlayerInfo;
    public LelinkServiceInfo lelinkServiceInfo;
    public String path;
    public int type;
}
