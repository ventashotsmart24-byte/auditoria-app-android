package anet.channel.security;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.ALog;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import java.util.HashMap;
import java.util.Map;

class b implements ISecurity {

    /* renamed from: a  reason: collision with root package name */
    private static String f3824a = "awcn.DefaultSecurityGuard";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3825b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Integer> f3826c;

    /* renamed from: d  reason: collision with root package name */
    private String f3827d;

    static {
        try {
            Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
            f3825b = true;
            HashMap hashMap = new HashMap();
            f3826c = hashMap;
            hashMap.put(ISecurity.SIGN_ALGORITHM_HMAC_SHA1, 3);
            f3826c.put(ISecurity.CIPHER_ALGORITHM_AES128, 16);
        } catch (Throwable unused) {
            f3825b = false;
        }
    }

    public b(String str) {
        this.f3827d = str;
    }

    public byte[] decrypt(Context context, String str, String str2, byte[] bArr) {
        Integer num;
        IStaticDataEncryptComponent staticDataEncryptComp;
        if (!f3825b || context == null || bArr == null || TextUtils.isEmpty(str2) || !f3826c.containsKey(str) || (num = f3826c.get(str)) == null) {
            return null;
        }
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            if (!(instance == null || (staticDataEncryptComp = instance.getStaticDataEncryptComp()) == null)) {
                return staticDataEncryptComp.staticBinarySafeDecryptNoB64(num.intValue(), str2, bArr, this.f3827d);
            }
        } catch (Throwable th) {
            ALog.e(f3824a, "staticBinarySafeDecryptNoB64", (String) null, th, new Object[0]);
        }
        return null;
    }

    public byte[] getBytes(Context context, String str) {
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            if (instance == null || (dynamicDataStoreComp = instance.getDynamicDataStoreComp()) == null) {
                return null;
            }
            return dynamicDataStoreComp.getByteArray(str);
        } catch (Throwable th) {
            ALog.e(f3824a, "getBytes", (String) null, th, new Object[0]);
            return null;
        }
    }

    public boolean isSecOff() {
        return false;
    }

    public boolean saveBytes(Context context, String str, byte[] bArr) {
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (context == null || bArr == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SecurityGuardManager instance = SecurityGuardManager.getInstance(context);
            if (instance == null || (dynamicDataStoreComp = instance.getDynamicDataStoreComp()) == null || dynamicDataStoreComp.putByteArray(str, bArr) == 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            ALog.e(f3824a, "saveBytes", (String) null, th, new Object[0]);
            return false;
        }
    }

    public String sign(Context context, String str, String str2, String str3) {
        if (f3825b && context != null && !TextUtils.isEmpty(str2) && f3826c.containsKey(str)) {
            try {
                ISecureSignatureComponent secureSignatureComp = SecurityGuardManager.getInstance(context).getSecureSignatureComp();
                if (secureSignatureComp != null) {
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = str2;
                    securityGuardParamContext.paramMap.put("INPUT", str3);
                    securityGuardParamContext.requestType = f3826c.get(str).intValue();
                    return secureSignatureComp.signRequest(securityGuardParamContext, this.f3827d);
                }
            } catch (Throwable th) {
                ALog.e(f3824a, "Securityguard sign request failed.", (String) null, th, new Object[0]);
            }
        }
        return null;
    }
}
