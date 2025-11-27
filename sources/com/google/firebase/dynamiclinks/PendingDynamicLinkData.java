package com.google.firebase.dynamiclinks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkUTMParams;

public class PendingDynamicLinkData {
    private final DynamicLinkData dynamicLinkData;
    private final DynamicLinkUTMParams dynamicLinkUTMParams;

    @KeepForSdk
    @VisibleForTesting
    public PendingDynamicLinkData(DynamicLinkData dynamicLinkData2) {
        if (dynamicLinkData2 == null) {
            this.dynamicLinkData = null;
            this.dynamicLinkUTMParams = null;
            return;
        }
        if (dynamicLinkData2.getClickTimestamp() == 0) {
            dynamicLinkData2.setClickTimestamp(DefaultClock.getInstance().currentTimeMillis());
        }
        this.dynamicLinkData = dynamicLinkData2;
        this.dynamicLinkUTMParams = new DynamicLinkUTMParams(dynamicLinkData2);
    }

    public long getClickTimestamp() {
        DynamicLinkData dynamicLinkData2 = this.dynamicLinkData;
        if (dynamicLinkData2 == null) {
            return 0;
        }
        return dynamicLinkData2.getClickTimestamp();
    }

    @KeepForSdk
    public Bundle getExtensions() {
        DynamicLinkData dynamicLinkData2 = this.dynamicLinkData;
        if (dynamicLinkData2 == null) {
            return new Bundle();
        }
        return dynamicLinkData2.getExtensionBundle();
    }

    public Uri getLink() {
        String deepLink;
        DynamicLinkData dynamicLinkData2 = this.dynamicLinkData;
        if (dynamicLinkData2 == null || (deepLink = dynamicLinkData2.getDeepLink()) == null) {
            return null;
        }
        return Uri.parse(deepLink);
    }

    public int getMinimumAppVersion() {
        DynamicLinkData dynamicLinkData2 = this.dynamicLinkData;
        if (dynamicLinkData2 == null) {
            return 0;
        }
        return dynamicLinkData2.getMinVersion();
    }

    @VisibleForTesting
    public Uri getRedirectUrl() {
        DynamicLinkData dynamicLinkData2 = this.dynamicLinkData;
        if (dynamicLinkData2 == null) {
            return null;
        }
        return dynamicLinkData2.getRedirectUrl();
    }

    public Intent getUpdateAppIntent(Context context) {
        if (getMinimumAppVersion() == 0) {
            return null;
        }
        try {
            if (context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode < getMinimumAppVersion() && getRedirectUrl() != null) {
                return new Intent("android.intent.action.VIEW").setData(getRedirectUrl()).setPackage("com.android.vending");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public Bundle getUtmParameters() {
        DynamicLinkUTMParams dynamicLinkUTMParams2 = this.dynamicLinkUTMParams;
        if (dynamicLinkUTMParams2 == null) {
            return new Bundle();
        }
        return dynamicLinkUTMParams2.asBundle();
    }

    public PendingDynamicLinkData(String str, int i10, long j10, Uri uri) {
        DynamicLinkData dynamicLinkData2 = new DynamicLinkData((String) null, str, i10, j10, (Bundle) null, uri);
        this.dynamicLinkData = dynamicLinkData2;
        this.dynamicLinkUTMParams = new DynamicLinkUTMParams(dynamicLinkData2);
    }
}
