package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.model.RateLimit;

final class AutoValue_RateLimit extends RateLimit {
    private final long limit;
    private final String limiterKey;
    private final long timeToLiveMillis;

    public static final class Builder extends RateLimit.Builder {
        private Long limit;
        private String limiterKey;
        private Long timeToLiveMillis;

        public RateLimit build() {
            String str = "";
            if (this.limiterKey == null) {
                str = str + " limiterKey";
            }
            if (this.limit == null) {
                str = str + " limit";
            }
            if (this.timeToLiveMillis == null) {
                str = str + " timeToLiveMillis";
            }
            if (str.isEmpty()) {
                return new AutoValue_RateLimit(this.limiterKey, this.limit.longValue(), this.timeToLiveMillis.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public RateLimit.Builder setLimit(long j10) {
            this.limit = Long.valueOf(j10);
            return this;
        }

        public RateLimit.Builder setLimiterKey(String str) {
            if (str != null) {
                this.limiterKey = str;
                return this;
            }
            throw new NullPointerException("Null limiterKey");
        }

        public RateLimit.Builder setTimeToLiveMillis(long j10) {
            this.timeToLiveMillis = Long.valueOf(j10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RateLimit)) {
            return false;
        }
        RateLimit rateLimit = (RateLimit) obj;
        if (this.limiterKey.equals(rateLimit.limiterKey()) && this.limit == rateLimit.limit() && this.timeToLiveMillis == rateLimit.timeToLiveMillis()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.limit;
        long j11 = this.timeToLiveMillis;
        return ((((this.limiterKey.hashCode() ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public long limit() {
        return this.limit;
    }

    public String limiterKey() {
        return this.limiterKey;
    }

    public long timeToLiveMillis() {
        return this.timeToLiveMillis;
    }

    public String toString() {
        return "RateLimit{limiterKey=" + this.limiterKey + ", limit=" + this.limit + ", timeToLiveMillis=" + this.timeToLiveMillis + "}";
    }

    private AutoValue_RateLimit(String str, long j10, long j11) {
        this.limiterKey = str;
        this.limit = j10;
        this.timeToLiveMillis = j11;
    }
}
