package com.hpplay.glide.load.engine.bitmap_recycle;

import com.hpplay.glide.load.engine.bitmap_recycle.Poolable;
import com.hpplay.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool = Util.createQueue(20);

    public abstract T create();

    public T get() {
        T t10 = (Poolable) this.keyPool.poll();
        if (t10 == null) {
            return create();
        }
        return t10;
    }

    public void offer(T t10) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t10);
        }
    }
}
