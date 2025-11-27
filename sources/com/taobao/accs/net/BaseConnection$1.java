package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import java.util.LinkedHashMap;
import java.util.Map;

class BaseConnection$1 extends LinkedHashMap<Integer, Message> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f13023a;

    public BaseConnection$1(a aVar) {
        this.f13023a = aVar;
    }

    public boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
        if (size() > 10) {
            return true;
        }
        return false;
    }
}
