package com.umeng.message.proguard;

import com.umeng.message.proguard.bx;
import java.util.concurrent.ConcurrentHashMap;

public final class ci {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap<bx.c, ch> f15598a = new ConcurrentHashMap<>(8);

    public static ch a(bx.c cVar) {
        ch chVar;
        if (cVar != null) {
            ConcurrentHashMap<bx.c, ch> concurrentHashMap = f15598a;
            ch chVar2 = concurrentHashMap.get(cVar);
            if (chVar2 != null) {
                return chVar2;
            }
            synchronized (concurrentHashMap) {
                chVar = concurrentHashMap.get(cVar);
                if (chVar == null) {
                    chVar = new cj(cVar);
                    concurrentHashMap.put(cVar, chVar);
                }
            }
            return chVar;
        }
        throw new IllegalArgumentException("type cant be null!");
    }
}
