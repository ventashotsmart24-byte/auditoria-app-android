package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.ExtendedResolver;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.Name;
import com.hpplay.sdk.source.mdns.xbill.dns.Options;
import com.hpplay.sdk.source.mdns.xbill.dns.Resolver;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import com.hpplay.sdk.source.mdns.xbill.dns.TSIG;
import java.io.IOException;
import java.util.List;

public class MulticastDNSQuerier implements Querier {
    private Querier ipv4Responder;
    private Querier ipv6Responder;
    protected boolean mIpv4;
    protected boolean mIpv6;
    /* access modifiers changed from: private */
    public ResolverListener mResolverListener;
    protected Resolver[] mUnicastResolvers;
    private boolean mdnsVerbose;
    protected Querier[] multicastResponders;
    protected ResolverListener resolverDispatch;

    public MulticastDNSQuerier() {
        this(true, false, new Resolver[]{new ExtendedResolver()});
    }

    private boolean getNetWorkInfos(boolean z10, boolean z11, Resolver[] resolverArr) {
        Exception e10;
        Querier querier;
        this.mdnsVerbose = Options.check("mdns_verbose");
        if (resolverArr == null || resolverArr.length == 0) {
            this.mUnicastResolvers = new Resolver[]{new ExtendedResolver()};
        } else {
            this.mUnicastResolvers = resolverArr;
        }
        IOException iOException = null;
        if (z10) {
            try {
                this.ipv4Responder = new MulticastDNSMulticastOnlyQuerier(false);
                this.mIpv4 = true;
            } catch (Exception e11) {
                e10 = e11;
                this.ipv4Responder = null;
            }
        }
        e10 = null;
        if (z11) {
            try {
                this.ipv6Responder = new MulticastDNSMulticastOnlyQuerier(true);
                this.mIpv6 = true;
            } catch (IOException e12) {
                this.ipv6Responder = null;
                iOException = e12;
            }
        }
        Querier querier2 = this.ipv4Responder;
        if (querier2 != null && (querier = this.ipv6Responder) != null) {
            this.multicastResponders = new Querier[]{querier2, querier};
            querier2.registerListener(this.resolverDispatch);
            this.ipv6Responder.registerListener(this.resolverDispatch);
            return true;
        } else if (querier2 != null) {
            this.multicastResponders = new Querier[]{querier2};
            querier2.registerListener(this.resolverDispatch);
            return true;
        } else {
            Querier querier3 = this.ipv6Responder;
            if (querier3 != null) {
                this.multicastResponders = new Querier[]{querier3};
                querier3.registerListener(this.resolverDispatch);
                return true;
            } else if (e10 != null) {
                throw e10;
            } else if (iOException == null) {
                return false;
            } else {
                throw iOException;
            }
        }
    }

    public static boolean isMulticastDomain(Name name) {
        for (Name name2 : Constants.IPv4_MULTICAST_DOMAINS) {
            if (name.equals(name2) || name.subdomain(name2)) {
                return true;
            }
        }
        for (Name name3 : Constants.IPv6_MULTICAST_DOMAINS) {
            if (name.equals(name3) || name.subdomain(name3)) {
                return true;
            }
        }
        return false;
    }

    public void broadcast(Message message, boolean z10) {
        IOException e10 = null;
        boolean z11 = false;
        for (Querier broadcast : this.multicastResponders) {
            try {
                broadcast.broadcast(message, z10);
                z11 = true;
            } catch (IOException e11) {
                e10 = e11;
            }
        }
        for (Resolver sendAsync : this.mUnicastResolvers) {
            sendAsync.sendAsync(message, new ResolverListener() {
                public void handleException(Object obj, Exception exc) {
                    if (MulticastDNSQuerier.this.mResolverListener != null) {
                        MulticastDNSQuerier.this.mResolverListener.handleException(obj, exc);
                    }
                }

                public void receiveMessage(Object obj, Message message) {
                    if (MulticastDNSQuerier.this.mResolverListener != null) {
                        MulticastDNSQuerier.this.mResolverListener.receiveMessage(obj, message);
                    }
                }
            });
        }
        if (!z11 && e10 != null) {
            throw e10;
        }
    }

    public void close() {
        for (Querier close : this.multicastResponders) {
            try {
                close.close();
            } catch (Exception unused) {
            }
        }
        this.ipv4Responder = null;
        this.ipv6Responder = null;
    }

    public Name[] getMulticastDomains() {
        boolean z10 = this.mIpv4;
        if (z10 && this.mIpv6) {
            return Constants.ALL_MULTICAST_DNS_DOMAINS;
        }
        if (z10) {
            return Constants.IPv4_MULTICAST_DOMAINS;
        }
        if (this.mIpv6) {
            return Constants.IPv6_MULTICAST_DOMAINS;
        }
        return new Name[0];
    }

    public Resolver[] getmUnicastResolvers() {
        return this.mUnicastResolvers;
    }

    public boolean initNetWorkState() {
        return getNetWorkInfos(this.mIpv4, this.mIpv6, this.mUnicastResolvers);
    }

    public boolean isIPv4() {
        return this.mIpv4;
    }

    public boolean isIPv6() {
        return this.mIpv6;
    }

    public boolean isOperational() {
        for (Querier isOperational : this.multicastResponders) {
            if (!isOperational.isOperational()) {
                return false;
            }
        }
        return true;
    }

    public ResolverListener registerListener(ResolverListener resolverListener) {
        for (Querier registerListener : this.multicastResponders) {
            this.mResolverListener = registerListener.registerListener(resolverListener);
        }
        return resolverListener;
    }

    public Message send(Message message) {
        Resolution resolution = new Resolution(this, message, (ResolverListener) null);
        resolution.start();
        return resolution.getResponse(Querier.DEFAULT_TIMEOUT);
    }

    public Object sendAsync(Message message, ResolverListener resolverListener) {
        Resolution resolution = new Resolution(this, message, resolverListener);
        resolution.start();
        return resolution;
    }

    public void setEDNS(int i10) {
        for (Querier edns : this.multicastResponders) {
            edns.setEDNS(i10);
        }
        for (Resolver edns2 : this.mUnicastResolvers) {
            edns2.setEDNS(i10);
        }
    }

    public void setIgnoreTruncation(boolean z10) {
        for (Querier ignoreTruncation : this.multicastResponders) {
            ignoreTruncation.setIgnoreTruncation(z10);
        }
        for (Resolver ignoreTruncation2 : this.mUnicastResolvers) {
            ignoreTruncation2.setIgnoreTruncation(z10);
        }
    }

    public void setPort(int i10) {
        for (Querier port : this.multicastResponders) {
            port.setPort(i10);
        }
    }

    public void setRetryWaitTime(int i10) {
        for (Querier timeout : this.multicastResponders) {
            timeout.setTimeout(i10);
        }
    }

    public void setTCP(boolean z10) {
        for (Resolver tcp : this.mUnicastResolvers) {
            tcp.setTCP(z10);
        }
    }

    public void setTSIGKey(TSIG tsig) {
        for (Querier tSIGKey : this.multicastResponders) {
            tSIGKey.setTSIGKey(tsig);
        }
        for (Resolver tSIGKey2 : this.mUnicastResolvers) {
            tSIGKey2.setTSIGKey(tsig);
        }
    }

    public void setTimeout(int i10) {
        for (Querier timeout : this.multicastResponders) {
            timeout.setTimeout(i10);
        }
        for (Resolver timeout2 : this.mUnicastResolvers) {
            timeout2.setTimeout(i10);
        }
    }

    public boolean unregisterListener(ResolverListener resolverListener) {
        for (Querier unregisterListener : this.multicastResponders) {
            unregisterListener.unregisterListener(resolverListener);
        }
        return true;
    }

    public MulticastDNSQuerier(boolean z10, boolean z11) {
        this(z10, z11, (Resolver[]) null);
    }

    public MulticastDNSQuerier(boolean z10, boolean z11, Resolver resolver) {
        this(z10, z11, new Resolver[]{resolver});
    }

    public void setRetryWaitTime(int i10, int i11) {
        for (Querier timeout : this.multicastResponders) {
            timeout.setTimeout(i10, i11);
        }
    }

    public MulticastDNSQuerier(boolean z10, boolean z11, Resolver[] resolverArr) {
        this.mIpv4 = false;
        this.mIpv6 = false;
        this.resolverDispatch = new ResolverListener() {
            public void handleException(Object obj, Exception exc) {
                if (MulticastDNSQuerier.this.mResolverListener != null) {
                    MulticastDNSQuerier.this.mResolverListener.handleException(obj, exc);
                }
            }

            public void receiveMessage(Object obj, Message message) {
                if (MulticastDNSQuerier.this.mResolverListener != null) {
                    MulticastDNSQuerier.this.mResolverListener.receiveMessage(obj, message);
                }
            }
        };
        this.ipv4Responder = null;
        this.ipv6Responder = null;
        this.mIpv4 = z10;
        this.mIpv6 = z11;
        this.mUnicastResolvers = resolverArr;
    }

    public void setEDNS(int i10, int i11, int i12, List list) {
        for (Querier edns : this.multicastResponders) {
            edns.setEDNS(i10, i11, i12, list);
        }
        for (Resolver edns2 : this.mUnicastResolvers) {
            edns2.setEDNS(i10, i11, i12, list);
        }
    }

    public void setTimeout(int i10, int i11) {
        for (Querier timeout : this.multicastResponders) {
            timeout.setTimeout(i10, i11);
        }
        for (Resolver timeout2 : this.mUnicastResolvers) {
            timeout2.setTimeout(i10, i11);
        }
    }
}
