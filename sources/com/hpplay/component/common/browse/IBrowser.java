package com.hpplay.component.common.browse;

public interface IBrowser {
    public static final int CHOOSE_ALL = 3;
    public static final int CHOOSE_DLNA = 2;
    public static final int CHOOSE_MDNS = 1;

    String getBrowseErrorMsg();

    void startBrowse(int i10);

    void startBrowse(int i10, IBrowseResultListener iBrowseResultListener);

    void stopBrowse();
}
