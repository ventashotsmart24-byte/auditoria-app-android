package com.hpplay.sdk.source.browse.api;

import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import java.util.List;

public interface IServiceInfoListParseListener {
    void onParseResult(List<ServiceInfoParseBean> list);
}
