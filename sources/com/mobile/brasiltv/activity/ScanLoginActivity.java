package com.mobile.brasiltv.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.HttpConstant;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.mobile.brasiltv.bean.event.ExitScanPageEvent;
import com.mobile.brasiltv.mine.activity.ScanLoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.zxing.view.ViewfinderView;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import e7.g;
import e7.h;
import f5.c;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import xa.j;

public class ScanLoginActivity extends c implements SurfaceHolder.Callback {

    /* renamed from: k  reason: collision with root package name */
    public e7.a f6008k;

    /* renamed from: l  reason: collision with root package name */
    public ViewfinderView f6009l;

    /* renamed from: m  reason: collision with root package name */
    public TitleView f6010m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f6011n;

    /* renamed from: o  reason: collision with root package name */
    public Vector f6012o;

    /* renamed from: p  reason: collision with root package name */
    public String f6013p;

    /* renamed from: q  reason: collision with root package name */
    public g f6014q;

    /* renamed from: r  reason: collision with root package name */
    public MediaPlayer f6015r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f6016s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6017t;

    /* renamed from: u  reason: collision with root package name */
    public ProgressDialog f6018u;

    /* renamed from: v  reason: collision with root package name */
    public String f6019v;

    /* renamed from: w  reason: collision with root package name */
    public Bitmap f6020w;

    /* renamed from: x  reason: collision with root package name */
    public final MediaPlayer.OnCompletionListener f6021x = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ScanLoginActivity scanLoginActivity = ScanLoginActivity.this;
            Result a32 = scanLoginActivity.a3(scanLoginActivity.f6019v);
            if (a32 != null) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("qr_scan_result", a32.getText());
                intent.putExtras(bundle);
                ScanLoginActivity.this.setResult(161, intent);
                return;
            }
            Message obtainMessage = ScanLoginActivity.this.f6008k.obtainMessage();
            obtainMessage.what = R.id.decode_failed;
            obtainMessage.obj = "Scan failed!";
            ScanLoginActivity.this.f6008k.sendMessage(obtainMessage);
        }
    }

    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    }

    public void T2() {
        this.f6009l.g();
    }

    public Handler U2() {
        return this.f6008k;
    }

    public ViewfinderView V2() {
        return this.f6009l;
    }

    public void W2(Result result, Bitmap bitmap) {
        String str;
        this.f6014q.b();
        Z2();
        String text = result.getText();
        if (TextUtils.isEmpty(text)) {
            if (!isFinishing()) {
                f1.f12517a.x("Scan failed!");
            }
        } else if (text != null && text.contains("qrtoken") && text.contains("userId")) {
            int indexOf = text.indexOf("qrtoken=");
            int indexOf2 = text.indexOf("&userId=");
            int indexOf3 = text.indexOf(DispatchConstants.SIGN_SPLIT_SYMBOL, indexOf2 + 1);
            if (indexOf3 == -1) {
                str = text.substring(indexOf2 + 8);
            } else {
                str = text.substring(indexOf2 + 8, indexOf3);
            }
            Intent intent = new Intent(this, ScanLoginAty.class);
            ScanLoginAty.a aVar = ScanLoginAty.f12382o;
            intent.putExtra(aVar.a(), text.substring(indexOf + 8, indexOf2));
            intent.putExtra(aVar.b(), str);
            startActivity(intent);
        } else if (text != null && (text.startsWith(HttpConstant.HTTP) || text.startsWith("https"))) {
            b0.h0(this, text, true, true, false, false);
        } else if (!isFinishing()) {
            f1.f12517a.w(R.string.scan_recognition_failed);
            Message obtainMessage = this.f6008k.obtainMessage();
            obtainMessage.what = R.id.restart_preview;
            obtainMessage.obj = "Restart Preview!";
            this.f6008k.sendMessageDelayed(obtainMessage, 3000);
        }
    }

    public final void X2() {
        if (this.f6016s && this.f6015r == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f6015r = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.f6015r.setOnCompletionListener(this.f6021x);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                this.f6015r.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f6015r.setVolume(0.1f, 0.1f);
                this.f6015r.prepare();
            } catch (IOException unused) {
                this.f6015r = null;
            }
        }
    }

    public final void Y2(SurfaceHolder surfaceHolder) {
        try {
            d7.c.c().g(surfaceHolder);
            if (this.f6008k == null) {
                this.f6008k = new e7.a(this, this.f6012o, this.f6013p);
            }
        } catch (IOException | RuntimeException unused) {
        }
    }

    public final void Z2() {
        MediaPlayer mediaPlayer;
        if (this.f6016s && (mediaPlayer = this.f6015r) != null) {
            mediaPlayer.start();
        }
        if (this.f6017t) {
            ((Vibrator) getSystemService("vibrator")).vibrate(200);
        }
    }

    public Result a3(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "UTF8");
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i10 = 1;
        options.inJustDecodeBounds = true;
        this.f6020w = BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int i11 = (int) (((float) options.outHeight) / 200.0f);
        if (i11 > 0) {
            i10 = i11;
        }
        options.inSampleSize = i10;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        this.f6020w = decodeFile;
        try {
            return new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new h(decodeFile))), hashtable);
        } catch (NotFoundException e10) {
            e10.printStackTrace();
            return null;
        } catch (ChecksumException e11) {
            e11.printStackTrace();
            return null;
        } catch (FormatException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    @j
    public void exitScanPage(ExitScanPageEvent exitScanPageEvent) {
        finish();
    }

    public void k2() {
        n2();
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == -1 && i10 == 100) {
            Cursor query = getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
            if (query.moveToFirst()) {
                this.f6019v = query.getString(query.getColumnIndex("_data"));
            }
            query.close();
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f6018u = progressDialog;
            progressDialog.setMessage("正在扫描...");
            this.f6018u.setCancelable(false);
            this.f6018u.show();
            new Thread(new a()).start();
        }
        super.onActivityResult(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scan_login);
        d7.c.f(getApplication());
        this.f6009l = (ViewfinderView) findViewById(R.id.viewfinder_content);
        this.f6010m = (TitleView) findViewById(R.id.mTitleTop);
        this.f6011n = false;
        this.f6014q = new g(this);
        this.f6010m.setLayoutBackground(R.color.transparent);
    }

    public void onDestroy() {
        this.f6014q.c();
        MediaPlayer mediaPlayer = this.f6015r;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        e7.a aVar = this.f6008k;
        if (aVar != null) {
            aVar.a();
            this.f6008k = null;
        }
        d7.c.c().b();
    }

    public void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.scanner_view)).getHolder();
        if (this.f6011n) {
            Y2(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.f6012o = null;
        this.f6013p = null;
        this.f6016s = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.f6016s = false;
        }
        X2();
        this.f6017t = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!this.f6011n) {
            this.f6011n = true;
            Y2(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f6011n = false;
    }
}
