package anet.channel;

import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import java.util.HashMap;
import java.util.Map;

public final class Config {
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Config> f3526a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f3527b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f3528c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ENV f3529d = ENV.ONLINE;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ISecurity f3530e;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f3531a;

        /* renamed from: b  reason: collision with root package name */
        private String f3532b;

        /* renamed from: c  reason: collision with root package name */
        private ENV f3533c = ENV.ONLINE;

        /* renamed from: d  reason: collision with root package name */
        private String f3534d;

        /* renamed from: e  reason: collision with root package name */
        private String f3535e;

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
            r0 = new anet.channel.Config();
            anet.channel.Config.a(r0, r7.f3532b);
            anet.channel.Config.a(r0, r7.f3533c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
            if (android.text.TextUtils.isEmpty(r7.f3531a) == false) goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0083, code lost:
            anet.channel.Config.b(r0, anet.channel.util.StringUtils.concatString(r7.f3532b, "$", r7.f3533c.toString()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
            anet.channel.Config.b(r0, r7.f3531a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
            if (android.text.TextUtils.isEmpty(r7.f3535e) != false) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
            anet.channel.Config.a(r0, anet.channel.security.c.a().createNonSecurity(r7.f3535e));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b0, code lost:
            anet.channel.Config.a(r0, anet.channel.security.c.a().createSecurity(r7.f3534d));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bd, code lost:
            r1 = anet.channel.Config.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c1, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            anet.channel.Config.a().put(anet.channel.Config.c(r0), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cd, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ce, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public anet.channel.Config build() {
            /*
                r7 = this;
                java.lang.String r0 = r7.f3532b
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x00d5
                java.util.Map r0 = anet.channel.Config.f3526a
                monitor-enter(r0)
                java.util.Map r1 = anet.channel.Config.f3526a     // Catch:{ all -> 0x00d2 }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x00d2 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00d2 }
            L_0x0019:
                boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00d2 }
                if (r2 == 0) goto L_0x006b
                java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00d2 }
                anet.channel.Config r2 = (anet.channel.Config) r2     // Catch:{ all -> 0x00d2 }
                anet.channel.entity.ENV r3 = r2.f3529d     // Catch:{ all -> 0x00d2 }
                anet.channel.entity.ENV r4 = r7.f3533c     // Catch:{ all -> 0x00d2 }
                if (r3 != r4) goto L_0x0019
                java.lang.String r3 = r2.f3528c     // Catch:{ all -> 0x00d2 }
                java.lang.String r4 = r7.f3532b     // Catch:{ all -> 0x00d2 }
                boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00d2 }
                if (r3 == 0) goto L_0x0019
                java.lang.String r1 = "awcn.Config"
                java.lang.String r3 = "duplicated config exist!"
                r4 = 4
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00d2 }
                java.lang.String r5 = "appkey"
                r6 = 0
                r4[r6] = r5     // Catch:{ all -> 0x00d2 }
                java.lang.String r5 = r7.f3532b     // Catch:{ all -> 0x00d2 }
                r6 = 1
                r4[r6] = r5     // Catch:{ all -> 0x00d2 }
                java.lang.String r5 = "env"
                r6 = 2
                r4[r6] = r5     // Catch:{ all -> 0x00d2 }
                anet.channel.entity.ENV r5 = r7.f3533c     // Catch:{ all -> 0x00d2 }
                r6 = 3
                r4[r6] = r5     // Catch:{ all -> 0x00d2 }
                r5 = 0
                anet.channel.util.ALog.w(r1, r3, r5, r4)     // Catch:{ all -> 0x00d2 }
                java.lang.String r1 = r7.f3531a     // Catch:{ all -> 0x00d2 }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00d2 }
                if (r1 != 0) goto L_0x0069
                java.util.Map r1 = anet.channel.Config.f3526a     // Catch:{ all -> 0x00d2 }
                java.lang.String r3 = r7.f3531a     // Catch:{ all -> 0x00d2 }
                r1.put(r3, r2)     // Catch:{ all -> 0x00d2 }
            L_0x0069:
                monitor-exit(r0)     // Catch:{ all -> 0x00d2 }
                return r2
            L_0x006b:
                monitor-exit(r0)     // Catch:{ all -> 0x00d2 }
                anet.channel.Config r0 = new anet.channel.Config
                r0.<init>()
                java.lang.String r1 = r7.f3532b
                java.lang.String unused = r0.f3528c = r1
                anet.channel.entity.ENV r1 = r7.f3533c
                anet.channel.entity.ENV unused = r0.f3529d = r1
                java.lang.String r1 = r7.f3531a
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0095
                java.lang.String r1 = r7.f3532b
                java.lang.String r2 = "$"
                anet.channel.entity.ENV r3 = r7.f3533c
                java.lang.String r3 = r3.toString()
                java.lang.String r1 = anet.channel.util.StringUtils.concatString(r1, r2, r3)
                java.lang.String unused = r0.f3527b = r1
                goto L_0x009a
            L_0x0095:
                java.lang.String r1 = r7.f3531a
                java.lang.String unused = r0.f3527b = r1
            L_0x009a:
                java.lang.String r1 = r7.f3535e
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L_0x00b0
                anet.channel.security.ISecurityFactory r1 = anet.channel.security.c.a()
                java.lang.String r2 = r7.f3535e
                anet.channel.security.ISecurity r1 = r1.createNonSecurity(r2)
                anet.channel.security.ISecurity unused = r0.f3530e = r1
                goto L_0x00bd
            L_0x00b0:
                anet.channel.security.ISecurityFactory r1 = anet.channel.security.c.a()
                java.lang.String r2 = r7.f3534d
                anet.channel.security.ISecurity r1 = r1.createSecurity(r2)
                anet.channel.security.ISecurity unused = r0.f3530e = r1
            L_0x00bd:
                java.util.Map r1 = anet.channel.Config.f3526a
                monitor-enter(r1)
                java.util.Map r2 = anet.channel.Config.f3526a     // Catch:{ all -> 0x00cf }
                java.lang.String r3 = r0.f3527b     // Catch:{ all -> 0x00cf }
                r2.put(r3, r0)     // Catch:{ all -> 0x00cf }
                monitor-exit(r1)     // Catch:{ all -> 0x00cf }
                return r0
            L_0x00cf:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00cf }
                throw r0
            L_0x00d2:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00d2 }
                throw r1
            L_0x00d5:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.String r1 = "appkey can not be null or empty!"
                r0.<init>(r1)
                goto L_0x00de
            L_0x00dd:
                throw r0
            L_0x00de:
                goto L_0x00dd
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.Config.Builder.build():anet.channel.Config");
        }

        public Builder setAppSecret(String str) {
            this.f3535e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.f3532b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f3534d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f3533c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.f3531a = str;
            return this;
        }
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (f3526a) {
            for (Config next : f3526a.values()) {
                if (next.f3529d == env && next.f3528c.equals(str)) {
                    return next;
                }
            }
            return null;
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (f3526a) {
            config = f3526a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f3528c;
    }

    public ENV getEnv() {
        return this.f3529d;
    }

    public ISecurity getSecurity() {
        return this.f3530e;
    }

    public String getTag() {
        return this.f3527b;
    }

    public String toString() {
        return this.f3527b;
    }
}
