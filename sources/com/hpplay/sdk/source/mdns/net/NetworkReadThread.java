package com.hpplay.sdk.source.mdns.net;

public class NetworkReadThread extends Thread {
    public NetworkReadThread(Runnable runnable) {
        super(runnable);
        setName("NetworkReadThread");
    }
}
