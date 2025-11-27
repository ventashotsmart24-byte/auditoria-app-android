package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.a;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

public final class b implements ILogEncryptAction {
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return a.a(bArr, str);
        } catch (Exception e10) {
            Log.e("efs.base", "aes decrypt error", e10);
            return null;
        }
    }

    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return a.b(bArr, str);
        } catch (Exception e10) {
            Log.e("efs.base", "aes encrypt error", e10);
            return null;
        }
    }

    public final int getDeVal() {
        return 2;
    }
}
