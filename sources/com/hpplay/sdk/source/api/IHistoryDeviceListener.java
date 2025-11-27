package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

public interface IHistoryDeviceListener extends DeviceListenerConstant {
    void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list);

    void onRemoveDevice(int i10, int i11);
}
