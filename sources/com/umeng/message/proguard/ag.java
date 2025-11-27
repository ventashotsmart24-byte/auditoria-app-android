package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ag extends AsyncTask<String, Void, Bitmap[]> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15333b = "com.umeng.message.proguard.ag";

    /* renamed from: a  reason: collision with root package name */
    public a f15334a;

    /* renamed from: c  reason: collision with root package name */
    private String f15335c;

    /* renamed from: d  reason: collision with root package name */
    private BitmapFactory.Options f15336d;

    public interface a {
        void a(Bitmap[] bitmapArr);
    }

    public ag(Context context, UInAppMessage uInAppMessage) {
        this.f15335c = f.a(context, uInAppMessage.msg_id);
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i10 = displayMetrics.widthPixels;
            int i11 = displayMetrics.heightPixels;
            BitmapFactory.Options options = new BitmapFactory.Options();
            this.f15336d = options;
            options.inSampleSize = a(uInAppMessage, i10, i11);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap[] doInBackground(String... strArr) {
        Bitmap bitmap;
        boolean z10;
        Bitmap[] bitmapArr = new Bitmap[strArr.length];
        int i10 = 0;
        while (i10 < strArr.length) {
            try {
                String str = strArr[i10];
                StringBuilder sb = new StringBuilder();
                sb.append(str.hashCode());
                if (!new File(this.f15335c, sb.toString()).exists()) {
                    Bitmap a10 = a(strArr[i10]);
                    bitmapArr[i10] = a10;
                    if (a10 == null) {
                        String str2 = strArr[i10];
                        String str3 = f15333b;
                        UMLog.mutlInfo(str3, 2, "Downloading image start");
                        URLConnection openConnection = new URL(str2).openConnection();
                        openConnection.connect();
                        InputStream inputStream = openConnection.getInputStream();
                        if (this.f15336d == null) {
                            bitmap = BitmapFactory.decodeStream(inputStream);
                        } else {
                            UMLog.mutlInfo(str3, 2, "decode options");
                            bitmap = BitmapFactory.decodeStream(inputStream, (Rect) null, this.f15336d);
                        }
                        inputStream.close();
                        UMLog.mutlInfo(str3, 2, "Downloading image finish");
                        bitmapArr[i10] = bitmap;
                        String str4 = strArr[i10];
                        if (bitmap != null) {
                            try {
                                File file = new File(this.f15335c);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str4.hashCode());
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f15335c, sb2.toString()));
                                z10 = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e10) {
                                    e = e10;
                                }
                            } catch (Exception e11) {
                                e = e11;
                                z10 = false;
                                e.printStackTrace();
                                UMLog.mutlInfo(f15333b, 2, "store bitmap".concat(String.valueOf(z10)));
                                i10++;
                            }
                            UMLog.mutlInfo(f15333b, 2, "store bitmap".concat(String.valueOf(z10)));
                        }
                    }
                } else {
                    bitmapArr[i10] = a(strArr[i10]);
                }
                i10++;
            } catch (IOException e12) {
                e12.printStackTrace();
            }
        }
        return bitmapArr;
    }

    public /* synthetic */ void onPostExecute(Object obj) {
        Bitmap[] bitmapArr = (Bitmap[]) obj;
        super.onPostExecute(bitmapArr);
        int length = bitmapArr.length;
        int i10 = 0;
        while (i10 < length) {
            if (bitmapArr[i10] != null) {
                i10++;
            } else {
                return;
            }
        }
        a aVar = this.f15334a;
        if (aVar != null) {
            aVar.a(bitmapArr);
        }
    }

    private Bitmap a(String str) {
        Bitmap bitmap = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            String sb2 = sb.toString();
            bitmap = BitmapFactory.decodeFile(this.f15335c + sb2);
            UMLog.mutlInfo(f15333b, 2, "load from local");
            return bitmap;
        } catch (Exception e10) {
            e10.printStackTrace();
            return bitmap;
        }
    }

    private static int a(UInAppMessage uInAppMessage, int i10, int i11) {
        int i12 = uInAppMessage.height;
        int i13 = uInAppMessage.width;
        int i14 = 1;
        if (i12 > i11 || i13 > i10) {
            int i15 = i12 / 2;
            int i16 = i13 / 2;
            while (i15 / i14 >= i11 && i16 / i14 >= i10) {
                i14 *= 2;
            }
        }
        return i14;
    }
}
