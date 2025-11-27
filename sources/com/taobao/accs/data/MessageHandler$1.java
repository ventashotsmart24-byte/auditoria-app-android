package com.taobao.accs.data;

import java.util.LinkedHashMap;
import java.util.Map;

class MessageHandler$1 extends LinkedHashMap<String, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f12958a;

    public MessageHandler$1(d dVar) {
        this.f12958a = dVar;
    }

    public boolean removeEldestEntry(Map.Entry<String, String> entry) {
        if (size() > 50) {
            return true;
        }
        return false;
    }
}
