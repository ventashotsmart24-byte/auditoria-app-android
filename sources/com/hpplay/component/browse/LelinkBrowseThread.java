package com.hpplay.component.browse;

public class LelinkBrowseThread extends Thread {
    public LelinkBrowseThread(String str) {
        setName(str);
    }

    public LelinkBrowseThread(Runnable runnable, String str) {
        super(runnable);
        setName(str);
    }
}
