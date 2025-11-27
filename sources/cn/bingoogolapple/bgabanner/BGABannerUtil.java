package cn.bingoogolapple.bgabanner;

import a0.d;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import b0.c1;
import java.util.Collection;
import java.util.List;

public class BGABannerUtil {

    public static class LoadBitmapPair<S extends Throwable> extends d {
        public LoadBitmapPair(Bitmap bitmap, S s10) {
            super(bitmap, s10);
        }
    }

    private BGABannerUtil() {
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = 1;
        if (!(i10 == 0 || i11 == 0)) {
            int i13 = options.outHeight;
            int i14 = options.outWidth;
            if (i13 > i11 || i14 > i10) {
                int i15 = i13 / 2;
                int i16 = i14 / 2;
                while (i15 / i12 >= i11 && i16 / i12 >= i10) {
                    i12 *= 2;
                }
            }
        }
        return i12;
    }

    public static int dp2px(Context context, float f10) {
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a7 A[SYNTHETIC, Splitter:B:40:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b9 A[SYNTHETIC, Splitter:B:48:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c7 A[SYNTHETIC, Splitter:B:56:0x00c7] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x009d=Splitter:B:37:0x009d, B:45:0x00af=Splitter:B:45:0x00af} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static cn.bingoogolapple.bgabanner.BGABannerUtil.LoadBitmapPair<java.lang.Throwable> getImageFromResource(android.content.Context r8, int r9, int r10, int r11) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565
            r2 = 0
            if (r10 != 0) goto L_0x0029
            if (r11 != 0) goto L_0x0029
            r0.inPreferredConfig = r1     // Catch:{ OutOfMemoryError -> 0x00ad, Exception -> 0x009b, all -> 0x0099 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ OutOfMemoryError -> 0x00ad, Exception -> 0x009b, all -> 0x0099 }
            java.io.InputStream r8 = r8.openRawResource(r9)     // Catch:{ OutOfMemoryError -> 0x00ad, Exception -> 0x009b, all -> 0x0099 }
            cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair r9 = new cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r8, r2, r0)     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r9.<init>(r10, r2)     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r8.close()     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            goto L_0x0087
        L_0x0023:
            r9 = move-exception
            goto L_0x009d
        L_0x0026:
            r9 = move-exception
            goto L_0x00af
        L_0x0029:
            r3 = 1
            r0.inJustDecodeBounds = r3     // Catch:{ OutOfMemoryError -> 0x00ad, Exception -> 0x009b, all -> 0x0099 }
            r0.inPreferredConfig = r1     // Catch:{ OutOfMemoryError -> 0x00ad, Exception -> 0x009b, all -> 0x0099 }
            android.content.res.Resources r4 = r8.getResources()     // Catch:{ OutOfMemoryError -> 0x00ad, Exception -> 0x009b, all -> 0x0099 }
            java.io.InputStream r4 = r4.openRawResource(r9)     // Catch:{ OutOfMemoryError -> 0x00ad, Exception -> 0x009b, all -> 0x0099 }
            android.graphics.BitmapFactory.decodeStream(r4, r2, r0)     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            r4.reset()     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            r4.close()     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            int r5 = r0.outWidth     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            int r6 = r0.outHeight     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            int r7 = getResizedDimension(r10, r11, r5, r6)     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            int r10 = getResizedDimension(r11, r10, r6, r5)     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            r11 = 0
            r0.inJustDecodeBounds = r11     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            int r11 = calculateInSampleSize(r0, r7, r10)     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            r0.inSampleSize = r11     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            r0.inPreferredConfig = r1     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            java.io.InputStream r8 = r8.openRawResource(r9)     // Catch:{ OutOfMemoryError -> 0x0096, Exception -> 0x0093, all -> 0x0090 }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r8, r2, r0)     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r8.close()     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            if (r9 == 0) goto L_0x0081
            int r11 = r9.getWidth()     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            if (r11 > r7) goto L_0x0073
            int r11 = r9.getHeight()     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            if (r11 <= r10) goto L_0x0081
        L_0x0073:
            cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair r11 = new cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createScaledBitmap(r9, r7, r10, r3)     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r11.<init>(r10, r2)     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r9.recycle()     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r9 = r11
            goto L_0x0087
        L_0x0081:
            cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair r10 = new cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r10.<init>(r9, r2)     // Catch:{ OutOfMemoryError -> 0x0026, Exception -> 0x0023 }
            r9 = r10
        L_0x0087:
            r8.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x00c2
        L_0x008b:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00c2
        L_0x0090:
            r9 = move-exception
            r2 = r4
            goto L_0x00c5
        L_0x0093:
            r9 = move-exception
            r8 = r4
            goto L_0x009d
        L_0x0096:
            r9 = move-exception
            r8 = r4
            goto L_0x00af
        L_0x0099:
            r9 = move-exception
            goto L_0x00c5
        L_0x009b:
            r9 = move-exception
            r8 = r2
        L_0x009d:
            r9.printStackTrace()     // Catch:{ all -> 0x00c3 }
            cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair r10 = new cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair     // Catch:{ all -> 0x00c3 }
            r10.<init>(r2, r9)     // Catch:{ all -> 0x00c3 }
            if (r8 == 0) goto L_0x00c1
            r8.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00c1
        L_0x00ab:
            r8 = move-exception
            goto L_0x00be
        L_0x00ad:
            r9 = move-exception
            r8 = r2
        L_0x00af:
            r9.printStackTrace()     // Catch:{ all -> 0x00c3 }
            cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair r10 = new cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair     // Catch:{ all -> 0x00c3 }
            r10.<init>(r2, r9)     // Catch:{ all -> 0x00c3 }
            if (r8 == 0) goto L_0x00c1
            r8.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r8 = move-exception
        L_0x00be:
            r8.printStackTrace()
        L_0x00c1:
            r9 = r10
        L_0x00c2:
            return r9
        L_0x00c3:
            r9 = move-exception
            r2 = r8
        L_0x00c5:
            if (r2 == 0) goto L_0x00cf
            r2.close()     // Catch:{ IOException -> 0x00cb }
            goto L_0x00cf
        L_0x00cb:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00cf:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bingoogolapple.bgabanner.BGABannerUtil.getImageFromResource(android.content.Context, int, int, int):cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair");
    }

    public static ImageView getItemImageView(Context context, int i10, BGALocalImageSize bGALocalImageSize, ImageView.ScaleType scaleType) {
        ImageView imageView = new ImageView(context);
        imageView.setImageBitmap(getScaledImageFromResource(context, i10, bGALocalImageSize.getMaxWidth(), bGALocalImageSize.getMaxHeight(), bGALocalImageSize.getMinWidth(), bGALocalImageSize.getMinHeight()));
        imageView.setClickable(true);
        imageView.setScaleType(scaleType);
        return imageView;
    }

    public static int getResizedDimension(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 0) {
            return i12;
        }
        if (i10 == 0) {
            double d10 = (double) i11;
            double d11 = (double) i13;
            Double.isNaN(d10);
            Double.isNaN(d11);
            double d12 = (double) i12;
            Double.isNaN(d12);
            return (int) (d12 * (d10 / d11));
        } else if (i11 == 0) {
            return i10;
        } else {
            double d13 = (double) i13;
            double d14 = (double) i12;
            Double.isNaN(d13);
            Double.isNaN(d14);
            double d15 = d13 / d14;
            double d16 = (double) i10;
            Double.isNaN(d16);
            double d17 = (double) i11;
            if (d16 * d15 <= d17) {
                return i10;
            }
            Double.isNaN(d17);
            return (int) (d17 / d15);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x000b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getScaledImageFromResource(android.content.Context r2, int r3, int r4, int r5, float r6, float r7) {
        /*
        L_0x0000:
            cn.bingoogolapple.bgabanner.BGABannerUtil$LoadBitmapPair r0 = getImageFromResource(r2, r3, r4, r5)
            if (r0 == 0) goto L_0x000b
            java.lang.Object r1 = r0.first
            if (r1 == 0) goto L_0x000b
            goto L_0x0021
        L_0x000b:
            int r4 = r4 / 2
            int r5 = r5 / 2
            if (r0 == 0) goto L_0x0021
            java.lang.Object r1 = r0.second
            boolean r1 = r1 instanceof java.lang.OutOfMemoryError
            if (r1 == 0) goto L_0x0021
            float r1 = (float) r4
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0021
            float r1 = (float) r5
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0000
        L_0x0021:
            if (r0 != 0) goto L_0x0025
            r2 = 0
            return r2
        L_0x0025:
            java.lang.Object r2 = r0.first
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bingoogolapple.bgabanner.BGABannerUtil.getScaledImageFromResource(android.content.Context, int, int, int, float, float):android.graphics.Bitmap");
    }

    public static boolean isCollectionEmpty(Collection collection, Collection... collectionArr) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        for (Collection collection2 : collectionArr) {
            if (collection2 == null || collection2.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCollectionNotEmpty(Collection collection, Collection... collectionArr) {
        return !isCollectionEmpty(collection, collectionArr);
    }

    public static boolean isIndexNotOutOfBounds(int i10, Collection collection) {
        if (!isCollectionNotEmpty(collection, new Collection[0]) || i10 >= collection.size()) {
            return false;
        }
        return true;
    }

    public static void resetPageTransformer(List<? extends View> list) {
        if (list != null) {
            for (View view : list) {
                view.setVisibility(0);
                c1.n0(view, 1.0f);
                c1.A0(view, ((float) view.getMeasuredWidth()) * 0.5f);
                c1.B0(view, ((float) view.getMeasuredHeight()) * 0.5f);
                c1.K0(view, 0.0f);
                c1.L0(view, 0.0f);
                c1.G0(view, 1.0f);
                c1.H0(view, 1.0f);
                c1.E0(view, 0.0f);
                c1.F0(view, 0.0f);
                c1.D0(view, 0.0f);
            }
        }
    }

    public static int sp2px(Context context, float f10) {
        return (int) TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics());
    }
}
