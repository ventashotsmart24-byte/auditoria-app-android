package com.hpplay.glide.load.model;

import com.hpplay.glide.util.LruCache;
import com.hpplay.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> ModelKey<A> get(A a10, int i10, int i11) {
            ModelKey<A> poll = KEY_QUEUE.poll();
            if (poll == null) {
                poll = new ModelKey<>();
            }
            poll.init(a10, i10, i11);
            return poll;
        }

        private void init(A a10, int i10, int i11) {
            this.model = a10;
            this.width = i10;
            this.height = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            KEY_QUEUE.offer(this);
        }
    }

    public ModelCache() {
        this(250);
    }

    public B get(A a10, int i10, int i11) {
        ModelKey modelKey = ModelKey.get(a10, i10, i11);
        B b10 = this.cache.get(modelKey);
        modelKey.release();
        return b10;
    }

    public void put(A a10, int i10, int i11, B b10) {
        this.cache.put(ModelKey.get(a10, i10, i11), b10);
    }

    public ModelCache(int i10) {
        this.cache = new LruCache<ModelKey<A>, B>(i10) {
            public void onItemEvicted(ModelKey<A> modelKey, B b10) {
                modelKey.release();
            }
        };
    }
}
