package com.hpplay.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.hpplay.glide.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SizeConfigStrategy implements LruPoolStrategy {
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS = {Bitmap.Config.ALPHA_8};
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS = {Bitmap.Config.ARGB_8888, null};
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS = {Bitmap.Config.RGB_565};
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    private final KeyPool keyPool = new KeyPool();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    /* renamed from: com.hpplay.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$graphics$Bitmap$Config = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$Config     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$Config     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$android$graphics$Bitmap$Config     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.engine.bitmap_recycle.SizeConfigStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i10, Bitmap.Config config) {
            Key key = (Key) get();
            key.init(i10, config);
            return key;
        }

        public Key create() {
            return new Key(this);
        }
    }

    private void decrementBitmapOfSize(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(config);
        Integer num2 = sizesForConfig.get(num);
        if (num2.intValue() == 1) {
            sizesForConfig.remove(num);
        } else {
            sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private Key findBestKey(Key key, int i10, Bitmap.Config config) {
        Bitmap.Config[] inConfigs = getInConfigs(config);
        int length = inConfigs.length;
        int i11 = 0;
        while (i11 < length) {
            Bitmap.Config config2 = inConfigs[i11];
            Integer ceilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(i10));
            if (ceilingKey == null || ceilingKey.intValue() > i10 * 8) {
                i11++;
            } else {
                if (ceilingKey.intValue() == i10) {
                    if (config2 == null) {
                        if (config == null) {
                            return key;
                        }
                    } else if (config2.equals(config)) {
                        return key;
                    }
                }
                this.keyPool.offer(key);
                return this.keyPool.get(ceilingKey.intValue(), config2);
            }
        }
        return key;
    }

    /* access modifiers changed from: private */
    public static String getBitmapString(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        int i10 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i10 == 1) {
            return ARGB_8888_IN_CONFIGS;
        }
        if (i10 == 2) {
            return RGB_565_IN_CONFIGS;
        }
        if (i10 == 3) {
            return ARGB_4444_IN_CONFIGS;
        }
        if (i10 == 4) {
            return ALPHA_8_IN_CONFIGS;
        }
        return new Bitmap.Config[]{config};
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        int bitmapByteSize = Util.getBitmapByteSize(i10, i11, config);
        Bitmap bitmap = this.groupedMap.get(findBestKey(this.keyPool.get(bitmapByteSize, config), bitmapByteSize, config));
        if (bitmap != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmap)), bitmap.getConfig());
            if (bitmap.getConfig() != null) {
                config2 = bitmap.getConfig();
            } else {
                config2 = Bitmap.Config.ARGB_8888;
            }
            bitmap.reconfigure(i10, i11, config2);
        }
        return bitmap;
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(key, bitmap);
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num = sizesForConfig.get(Integer.valueOf(key.size));
        Integer valueOf = Integer.valueOf(key.size);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        sizesForConfig.put(valueOf, Integer.valueOf(i10));
    }

    public Bitmap removeLast() {
        Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(removeLast)), removeLast.getConfig());
        }
        return removeLast;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.groupedMap);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.sortedSizes.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    public static final class Key implements Poolable {
        private Bitmap.Config config;
        private final KeyPool pool;
        /* access modifiers changed from: private */
        public int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof com.hpplay.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key
                r1 = 0
                if (r0 == 0) goto L_0x001d
                com.hpplay.glide.load.engine.bitmap_recycle.SizeConfigStrategy$Key r4 = (com.hpplay.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key) r4
                int r0 = r3.size
                int r2 = r4.size
                if (r0 != r2) goto L_0x001d
                android.graphics.Bitmap$Config r0 = r3.config
                android.graphics.Bitmap$Config r4 = r4.config
                if (r0 != 0) goto L_0x0016
                if (r4 != 0) goto L_0x001d
                goto L_0x001c
            L_0x0016:
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x001d
            L_0x001c:
                r1 = 1
            L_0x001d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.engine.bitmap_recycle.SizeConfigStrategy.Key.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i10;
            int i11 = this.size * 31;
            Bitmap.Config config2 = this.config;
            if (config2 != null) {
                i10 = config2.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        public void init(int i10, Bitmap.Config config2) {
            this.size = i10;
            this.config = config2;
        }

        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }

        public Key(KeyPool keyPool, int i10, Bitmap.Config config2) {
            this(keyPool);
            init(i10, config2);
        }
    }

    public String logBitmap(int i10, int i11, Bitmap.Config config) {
        return getBitmapString(Util.getBitmapByteSize(i10, i11, config), config);
    }
}
