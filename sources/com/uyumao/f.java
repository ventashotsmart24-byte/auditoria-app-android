package com.uyumao;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.uyumao.g;
import java.util.HashMap;

public final class f extends Handler {
    public f(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        g.a aVar;
        if (message.what == 256) {
            int i10 = message.arg1;
            Object obj = message.obj;
            Integer valueOf = Integer.valueOf(i10 / 100);
            HashMap<Integer, g.a> hashMap = g.f16276c;
            if (hashMap != null) {
                if (hashMap.containsKey(valueOf)) {
                    aVar = g.f16276c.get(valueOf);
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.a(obj, i10);
                }
            }
        }
    }
}
