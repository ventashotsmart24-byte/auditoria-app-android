package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Message;

public class Response {
    private Exception exception;
    private Object id;
    private Message message;

    public Response(Object obj, Exception exc) {
        this.message = null;
        this.id = obj;
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }

    public Object getID() {
        return this.id;
    }

    public Message getMessage() {
        return this.message;
    }

    public boolean inError() {
        if (this.exception != null) {
            return true;
        }
        return false;
    }

    public Response(Object obj, Message message2) {
        this.exception = null;
        this.id = obj;
        this.message = message2;
    }
}
