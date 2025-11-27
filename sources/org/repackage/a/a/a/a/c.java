package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.repackage.a.a.a.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public org.repackage.a.a.a.a f8632a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f8633b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f8634c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f8635d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f8636e = new b(this);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f8637a = new c((b) null);
    }

    public /* synthetic */ c(b bVar) {
    }

    public boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                    return false;
                }
                return true;
            } else if (packageInfo == null || packageInfo.versionCode < 1) {
                return false;
            } else {
                return true;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f8633b)) {
            this.f8633b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f8634c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f8633b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA1");
                    if (instance != null) {
                        byte[] digest = instance.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b10 : digest) {
                            sb.append(Integer.toHexString((b10 & UnsignedBytes.MAX_VALUE) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e11) {
                    e11.printStackTrace();
                }
            }
            this.f8634c = str2;
        }
        String a10 = ((a.C0112a.C0113a) this.f8632a).a(this.f8633b, this.f8634c, str);
        if (TextUtils.isEmpty(a10)) {
            return "";
        }
        return a10;
    }

    public synchronized String a(Context context, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        } else if (this.f8632a == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.f8636e, 1)) {
                synchronized (this.f8635d) {
                    try {
                        this.f8635d.wait(3000);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            if (this.f8632a == null) {
                return "";
            }
            try {
                return b(context, str);
            } catch (RemoteException e11) {
                e11.printStackTrace();
                return "";
            }
        } else {
            try {
                return b(context, str);
            } catch (RemoteException e12) {
                e12.printStackTrace();
                return "";
            }
        }
    }
}
