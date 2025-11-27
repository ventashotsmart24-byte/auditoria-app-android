package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;

    public RequestLimiter(Utils utils2) {
        this.utils = utils2;
    }

    private synchronized long getBackoffDuration(int i10) {
        if (!isRetryableError(i10)) {
            return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
        }
        double pow = Math.pow(2.0d, (double) this.attemptCount);
        double randomDelayForSyncPrevention = (double) this.utils.getRandomDelayForSyncPrevention();
        Double.isNaN(randomDelayForSyncPrevention);
        return (long) Math.min(pow + randomDelayForSyncPrevention, (double) MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
    }

    private static boolean isRetryableError(int i10) {
        return i10 == 429 || (i10 >= 500 && i10 < 600);
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int i10) {
        return (i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404;
    }

    private synchronized void resetBackoffStrategy() {
        this.attemptCount = 0;
    }

    public synchronized boolean isRequestAllowed() {
        boolean z10;
        if (this.attemptCount == 0 || this.utils.currentTimeInMillis() > this.nextRequestTime) {
            z10 = true;
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized void setNextRequestTime(int i10) {
        if (isSuccessfulOrRequiresNewFidCreation(i10)) {
            resetBackoffStrategy();
            return;
        }
        this.attemptCount++;
        this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i10);
    }

    public RequestLimiter() {
        this.utils = Utils.getInstance();
    }
}
