package com.hpplay.sdk.source.mdns.xbill.dns;

class ResolveThread extends Thread {
    String TAG = "ResolveThreadfgfd";
    private Object id;
    private ResolverListener listener;
    private Message query;
    private Resolver res;

    public ResolveThread(Resolver resolver, Message message, Object obj, ResolverListener resolverListener) {
        this.res = resolver;
        this.query = message;
        this.id = obj;
        this.listener = resolverListener;
    }

    public void run() {
        try {
            this.listener.receiveMessage(this.id, this.res.send(this.query));
        } catch (Exception e10) {
            this.listener.handleException(this.id, e10);
        }
    }
}
