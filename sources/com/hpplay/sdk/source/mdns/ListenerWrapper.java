package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import java.lang.ref.WeakReference;

public class ListenerWrapper implements ResolverListener {
    private WeakReference<Object> idWeakReference;
    private WeakReference<ResolverListener> listenerWeakReference;
    private WeakReference<Message> messageWeakReference;
    private WeakReference<MulticastDNSMulticastOnlyQuerier> weakReference;

    public ListenerWrapper(Object obj, Message message, ResolverListener resolverListener, MulticastDNSMulticastOnlyQuerier multicastDNSMulticastOnlyQuerier) {
        this.idWeakReference = new WeakReference<>(obj);
        this.messageWeakReference = new WeakReference<>(message);
        this.listenerWeakReference = new WeakReference<>(resolverListener);
        this.weakReference = new WeakReference<>(multicastDNSMulticastOnlyQuerier);
    }

    public boolean equals(Object obj) {
        if (this == obj || this.listenerWeakReference.get() == obj) {
            return true;
        }
        if (!(obj instanceof ListenerWrapper) || this.listenerWeakReference.get() == null || this.listenerWeakReference.get() != ((ListenerWrapper) obj).listenerWeakReference.get()) {
            return false;
        }
        return true;
    }

    public void handleException(Object obj, Exception exc) {
        if (this.idWeakReference.get() == null || this.idWeakReference.get().equals(obj)) {
            if (this.listenerWeakReference.get() != null) {
                this.listenerWeakReference.get().handleException(this.idWeakReference.get(), exc);
            }
            WeakReference<MulticastDNSMulticastOnlyQuerier> weakReference2 = this.weakReference;
            if (weakReference2 != null && weakReference2.get() != null) {
                this.weakReference.get().unregisterListener(this);
            }
        }
    }

    public int hashCode() {
        if (this.listenerWeakReference.get() != null) {
            return this.listenerWeakReference.get().hashCode();
        }
        return 0;
    }

    public void receiveMessage(Object obj, Message message) {
        if (message != null) {
            Header header = message.getHeader();
            if ((header.getFlag(0) || header.getFlag(5) || (header.getFlag(10) && this.messageWeakReference.get() != null)) && MulticastDNSUtils.answersAny(this.messageWeakReference.get(), message) && this.idWeakReference.get() != null) {
                this.listenerWeakReference.get().receiveMessage(this.idWeakReference.get(), message);
                WeakReference<MulticastDNSMulticastOnlyQuerier> weakReference2 = this.weakReference;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.weakReference.get().unregisterListener(this);
                }
            }
        }
    }
}
