package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.ArrayList;
import java.util.List;

public class ExtendedResolver implements Resolver {
    private static final int quantum = 5;
    /* access modifiers changed from: private */
    public int lbStart = 0;
    /* access modifiers changed from: private */
    public boolean loadBalance = false;
    /* access modifiers changed from: private */
    public List resolvers;
    /* access modifiers changed from: private */
    public int retries = 3;

    public static class Resolution implements ResolverListener {
        boolean done;
        Object[] inprogress;
        ResolverListener listener;
        int outstanding;
        Message query;
        Resolver[] resolvers;
        Message response;
        int retries;
        int[] sent;
        Throwable thrown;

        public Resolution(ExtendedResolver extendedResolver, Message message) {
            List access$000 = extendedResolver.resolvers;
            this.resolvers = (Resolver[]) access$000.toArray(new Resolver[access$000.size()]);
            if (extendedResolver.loadBalance) {
                int length = this.resolvers.length;
                int access$208 = ExtendedResolver.access$208(extendedResolver) % length;
                if (extendedResolver.lbStart > length) {
                    int unused = extendedResolver.lbStart = length;
                }
                if (access$208 > 0) {
                    Resolver[] resolverArr = new Resolver[length];
                    for (int i10 = 0; i10 < length; i10++) {
                        resolverArr[i10] = this.resolvers[(i10 + access$208) % length];
                    }
                    this.resolvers = resolverArr;
                }
            }
            Resolver[] resolverArr2 = this.resolvers;
            this.sent = new int[resolverArr2.length];
            this.inprogress = new Object[resolverArr2.length];
            this.retries = extendedResolver.retries;
            this.query = message;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:63:0x009a, code lost:
            if ((r5.thrown instanceof java.lang.Exception) != false) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x009c, code lost:
            r5.thrown = new java.lang.RuntimeException(r5.thrown.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a9, code lost:
            r5.listener.handleException(r5, (java.lang.Exception) r5.thrown);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00b2, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleException(java.lang.Object r6, java.lang.Exception r7) {
            /*
                r5 = this;
                java.lang.String r0 = "verbose"
                boolean r0 = com.hpplay.sdk.source.mdns.xbill.dns.Options.check(r0)
                if (r0 == 0) goto L_0x001e
                java.io.PrintStream r0 = java.lang.System.err
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "ExtendedResolver: got "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r1 = r1.toString()
                r0.println(r1)
            L_0x001e:
                monitor-enter(r5)
                int r0 = r5.outstanding     // Catch:{ all -> 0x00b3 }
                r1 = 1
                int r0 = r0 - r1
                r5.outstanding = r0     // Catch:{ all -> 0x00b3 }
                boolean r0 = r5.done     // Catch:{ all -> 0x00b3 }
                if (r0 == 0) goto L_0x002b
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                return
            L_0x002b:
                r0 = 0
                r2 = 0
            L_0x002d:
                java.lang.Object[] r3 = r5.inprogress     // Catch:{ all -> 0x00b3 }
                int r4 = r3.length     // Catch:{ all -> 0x00b3 }
                if (r2 >= r4) goto L_0x0039
                r4 = r3[r2]     // Catch:{ all -> 0x00b3 }
                if (r4 == r6) goto L_0x0039
                int r2 = r2 + 1
                goto L_0x002d
            L_0x0039:
                int r6 = r3.length     // Catch:{ all -> 0x00b3 }
                if (r2 != r6) goto L_0x003e
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                return
            L_0x003e:
                int[] r6 = r5.sent     // Catch:{ all -> 0x00b3 }
                r6 = r6[r2]     // Catch:{ all -> 0x00b3 }
                if (r6 != r1) goto L_0x004b
                com.hpplay.sdk.source.mdns.xbill.dns.Resolver[] r3 = r5.resolvers     // Catch:{ all -> 0x00b3 }
                int r3 = r3.length     // Catch:{ all -> 0x00b3 }
                int r3 = r3 - r1
                if (r2 >= r3) goto L_0x004b
                r0 = 1
            L_0x004b:
                boolean r3 = r7 instanceof java.io.InterruptedIOException     // Catch:{ all -> 0x00b3 }
                if (r3 == 0) goto L_0x005d
                int r3 = r5.retries     // Catch:{ all -> 0x00b3 }
                if (r6 >= r3) goto L_0x0056
                r5.send(r2)     // Catch:{ all -> 0x00b3 }
            L_0x0056:
                java.lang.Throwable r6 = r5.thrown     // Catch:{ all -> 0x00b3 }
                if (r6 != 0) goto L_0x006e
                r5.thrown = r7     // Catch:{ all -> 0x00b3 }
                goto L_0x006e
            L_0x005d:
                boolean r6 = r7 instanceof java.net.SocketException     // Catch:{ all -> 0x00b3 }
                if (r6 == 0) goto L_0x006c
                java.lang.Throwable r6 = r5.thrown     // Catch:{ all -> 0x00b3 }
                if (r6 == 0) goto L_0x0069
                boolean r6 = r6 instanceof java.io.InterruptedIOException     // Catch:{ all -> 0x00b3 }
                if (r6 == 0) goto L_0x006e
            L_0x0069:
                r5.thrown = r7     // Catch:{ all -> 0x00b3 }
                goto L_0x006e
            L_0x006c:
                r5.thrown = r7     // Catch:{ all -> 0x00b3 }
            L_0x006e:
                boolean r6 = r5.done     // Catch:{ all -> 0x00b3 }
                if (r6 == 0) goto L_0x0074
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                return
            L_0x0074:
                if (r0 == 0) goto L_0x007a
                int r2 = r2 + r1
                r5.send(r2)     // Catch:{ all -> 0x00b3 }
            L_0x007a:
                boolean r6 = r5.done     // Catch:{ all -> 0x00b3 }
                if (r6 == 0) goto L_0x0080
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                return
            L_0x0080:
                int r6 = r5.outstanding     // Catch:{ all -> 0x00b3 }
                if (r6 != 0) goto L_0x008f
                r5.done = r1     // Catch:{ all -> 0x00b3 }
                com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener r6 = r5.listener     // Catch:{ all -> 0x00b3 }
                if (r6 != 0) goto L_0x008f
                r5.notifyAll()     // Catch:{ all -> 0x00b3 }
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                return
            L_0x008f:
                boolean r6 = r5.done     // Catch:{ all -> 0x00b3 }
                if (r6 != 0) goto L_0x0095
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                return
            L_0x0095:
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                java.lang.Throwable r6 = r5.thrown
                boolean r6 = r6 instanceof java.lang.Exception
                if (r6 != 0) goto L_0x00a9
                java.lang.RuntimeException r6 = new java.lang.RuntimeException
                java.lang.Throwable r7 = r5.thrown
                java.lang.String r7 = r7.getMessage()
                r6.<init>(r7)
                r5.thrown = r6
            L_0x00a9:
                com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener r6 = r5.listener
                java.lang.Throwable r7 = r5.thrown
                java.lang.Exception r7 = (java.lang.Exception) r7
                r6.handleException(r5, r7)
                return
            L_0x00b3:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00b3 }
                goto L_0x00b7
            L_0x00b6:
                throw r6
            L_0x00b7:
                goto L_0x00b6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.ExtendedResolver.Resolution.handleException(java.lang.Object, java.lang.Exception):void");
        }

        public void receiveMessage(Object obj, Message message) {
            if (Options.check("verbose")) {
                System.err.println("ExtendedResolver: received message");
            }
            synchronized (this) {
                if (!this.done) {
                    this.response = message;
                    this.done = true;
                    ResolverListener resolverListener = this.listener;
                    if (resolverListener == null) {
                        notifyAll();
                    } else {
                        resolverListener.receiveMessage(this, message);
                    }
                }
            }
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void send(int r5) {
            /*
                r4 = this;
                int[] r0 = r4.sent
                r1 = r0[r5]
                r2 = 1
                int r1 = r1 + r2
                r0[r5] = r1
                int r0 = r4.outstanding
                int r0 = r0 + r2
                r4.outstanding = r0
                java.lang.Object[] r0 = r4.inprogress     // Catch:{ all -> 0x001c }
                com.hpplay.sdk.source.mdns.xbill.dns.Resolver[] r1 = r4.resolvers     // Catch:{ all -> 0x001c }
                r1 = r1[r5]     // Catch:{ all -> 0x001c }
                com.hpplay.sdk.source.mdns.xbill.dns.Message r3 = r4.query     // Catch:{ all -> 0x001c }
                java.lang.Object r1 = r1.sendAsync(r3, r4)     // Catch:{ all -> 0x001c }
                r0[r5] = r1     // Catch:{ all -> 0x001c }
                goto L_0x002c
            L_0x001c:
                r5 = move-exception
                monitor-enter(r4)
                r4.thrown = r5     // Catch:{ all -> 0x002d }
                r4.done = r2     // Catch:{ all -> 0x002d }
                com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener r5 = r4.listener     // Catch:{ all -> 0x002d }
                if (r5 != 0) goto L_0x002b
                r4.notifyAll()     // Catch:{ all -> 0x002d }
                monitor-exit(r4)     // Catch:{ all -> 0x002d }
                return
            L_0x002b:
                monitor-exit(r4)     // Catch:{ all -> 0x002d }
            L_0x002c:
                return
            L_0x002d:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x002d }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.ExtendedResolver.Resolution.send(int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            wait();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
            r0 = r3.response;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
            if (r0 != null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
            r0 = r3.thrown;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
            if ((r0 instanceof java.io.IOException) == false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
            if ((r0 instanceof java.lang.RuntimeException) == false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
            if ((r0 instanceof java.lang.Error) != false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            throw ((java.lang.Error) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
            throw new java.lang.IllegalStateException("ExtendedResolver failure");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0055, code lost:
            throw ((java.lang.RuntimeException) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
            throw ((java.io.IOException) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            if (r3.done == false) goto L_0x0030;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002c */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x002c A[LOOP:0: B:7:0x002c->B:35:0x002c, LOOP_START, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.hpplay.sdk.source.mdns.xbill.dns.Message start() {
            /*
                r3 = this;
                r0 = 0
                int[] r1 = r3.sent     // Catch:{ Exception -> 0x0023 }
                r2 = r1[r0]     // Catch:{ Exception -> 0x0023 }
                int r2 = r2 + 1
                r1[r0] = r2     // Catch:{ Exception -> 0x0023 }
                int r1 = r3.outstanding     // Catch:{ Exception -> 0x0023 }
                int r1 = r1 + 1
                r3.outstanding = r1     // Catch:{ Exception -> 0x0023 }
                java.lang.Object[] r1 = r3.inprogress     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r2 = new java.lang.Object     // Catch:{ Exception -> 0x0023 }
                r2.<init>()     // Catch:{ Exception -> 0x0023 }
                r1[r0] = r2     // Catch:{ Exception -> 0x0023 }
                com.hpplay.sdk.source.mdns.xbill.dns.Resolver[] r1 = r3.resolvers     // Catch:{ Exception -> 0x0023 }
                r1 = r1[r0]     // Catch:{ Exception -> 0x0023 }
                com.hpplay.sdk.source.mdns.xbill.dns.Message r2 = r3.query     // Catch:{ Exception -> 0x0023 }
                com.hpplay.sdk.source.mdns.xbill.dns.Message r0 = r1.send(r2)     // Catch:{ Exception -> 0x0023 }
                return r0
            L_0x0023:
                r1 = move-exception
                java.lang.Object[] r2 = r3.inprogress
                r0 = r2[r0]
                r3.handleException(r0, r1)
                monitor-enter(r3)
            L_0x002c:
                boolean r0 = r3.done     // Catch:{ all -> 0x0059 }
                if (r0 != 0) goto L_0x0034
                r3.wait()     // Catch:{ InterruptedException -> 0x002c }
                goto L_0x002c
            L_0x0034:
                monitor-exit(r3)     // Catch:{ all -> 0x0059 }
                com.hpplay.sdk.source.mdns.xbill.dns.Message r0 = r3.response
                if (r0 == 0) goto L_0x003a
                return r0
            L_0x003a:
                java.lang.Throwable r0 = r3.thrown
                boolean r1 = r0 instanceof java.io.IOException
                if (r1 != 0) goto L_0x0056
                boolean r1 = r0 instanceof java.lang.RuntimeException
                if (r1 != 0) goto L_0x0053
                boolean r1 = r0 instanceof java.lang.Error
                if (r1 == 0) goto L_0x004b
                java.lang.Error r0 = (java.lang.Error) r0
                throw r0
            L_0x004b:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "ExtendedResolver failure"
                r0.<init>(r1)
                throw r0
            L_0x0053:
                java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0
                throw r0
            L_0x0056:
                java.io.IOException r0 = (java.io.IOException) r0
                throw r0
            L_0x0059:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0059 }
                goto L_0x005d
            L_0x005c:
                throw r0
            L_0x005d:
                goto L_0x005c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.ExtendedResolver.Resolution.start():com.hpplay.sdk.source.mdns.xbill.dns.Message");
        }

        public void startAsync(ResolverListener resolverListener) {
            this.listener = resolverListener;
            send(0);
        }
    }

    public ExtendedResolver() {
        init();
        String[] servers = ResolverConfig.getCurrentConfig().servers();
        if (servers != null) {
            for (String simpleResolver : servers) {
                SimpleResolver simpleResolver2 = new SimpleResolver(simpleResolver);
                simpleResolver2.setTimeout(5);
                this.resolvers.add(simpleResolver2);
            }
            return;
        }
        this.resolvers.add(new SimpleResolver());
    }

    public static /* synthetic */ int access$208(ExtendedResolver extendedResolver) {
        int i10 = extendedResolver.lbStart;
        extendedResolver.lbStart = i10 + 1;
        return i10;
    }

    private void init() {
        this.resolvers = new ArrayList();
    }

    public Message send(Message message) {
        return new Resolution(this, message).start();
    }

    public Object sendAsync(Message message, ResolverListener resolverListener) {
        Resolution resolution = new Resolution(this, message);
        resolution.startAsync(resolverListener);
        return resolution;
    }

    public void setEDNS(int i10) {
        for (int i11 = 0; i11 < this.resolvers.size(); i11++) {
            ((Resolver) this.resolvers.get(i11)).setEDNS(i10);
        }
    }

    public void setIgnoreTruncation(boolean z10) {
        for (int i10 = 0; i10 < this.resolvers.size(); i10++) {
            ((Resolver) this.resolvers.get(i10)).setIgnoreTruncation(z10);
        }
    }

    public void setPort(int i10) {
        for (int i11 = 0; i11 < this.resolvers.size(); i11++) {
            ((Resolver) this.resolvers.get(i11)).setPort(i10);
        }
    }

    public void setTCP(boolean z10) {
        for (int i10 = 0; i10 < this.resolvers.size(); i10++) {
            ((Resolver) this.resolvers.get(i10)).setTCP(z10);
        }
    }

    public void setTSIGKey(TSIG tsig) {
        for (int i10 = 0; i10 < this.resolvers.size(); i10++) {
            ((Resolver) this.resolvers.get(i10)).setTSIGKey(tsig);
        }
    }

    public void setTimeout(int i10, int i11) {
        for (int i12 = 0; i12 < this.resolvers.size(); i12++) {
            ((Resolver) this.resolvers.get(i12)).setTimeout(i10, i11);
        }
    }

    public void setEDNS(int i10, int i11, int i12, List list) {
        for (int i13 = 0; i13 < this.resolvers.size(); i13++) {
            ((Resolver) this.resolvers.get(i13)).setEDNS(i10, i11, i12, list);
        }
    }

    public void setTimeout(int i10) {
        setTimeout(i10, 0);
    }
}
