package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

public class IdentifierIdObserver extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8725a = "VMS_SDK_Observer";

    /* renamed from: b  reason: collision with root package name */
    private String f8726b;

    /* renamed from: c  reason: collision with root package name */
    private int f8727c;

    /* renamed from: d  reason: collision with root package name */
    private IdentifierIdClient f8728d;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i10, String str) {
        super((Handler) null);
        this.f8728d = identifierIdClient;
        this.f8727c = i10;
        this.f8726b = str;
    }

    public void onChange(boolean z10) {
        IdentifierIdClient identifierIdClient = this.f8728d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.f8727c, this.f8726b);
        } else {
            Log.e(f8725a, "mIdentifierIdClient is null");
        }
    }
}
