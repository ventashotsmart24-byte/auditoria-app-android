package com.mobile.brasiltv.view.adView;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import com.advertlib.bean.AdInfoWrapper;
import t9.i;

public final class BeforeVodAdView$playVideo$3 implements SurfaceHolder.Callback {
    final /* synthetic */ MediaPlayer $player;
    final /* synthetic */ BeforeVodAdView this$0;

    public BeforeVodAdView$playVideo$3(BeforeVodAdView beforeVodAdView, MediaPlayer mediaPlayer) {
        this.this$0 = beforeVodAdView;
        this.$player = mediaPlayer;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        i.g(surfaceHolder, "holder");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        String str;
        boolean z10;
        i.g(surfaceHolder, "holder");
        AdInfoWrapper access$getMAdInfoWrapper$p = this.this$0.mAdInfoWrapper;
        String str2 = null;
        if (access$getMAdInfoWrapper$p != null) {
            str = access$getMAdInfoWrapper$p.getCachePath();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            this.$player.reset();
            MediaPlayer mediaPlayer = this.$player;
            AdInfoWrapper access$getMAdInfoWrapper$p2 = this.this$0.mAdInfoWrapper;
            if (access$getMAdInfoWrapper$p2 != null) {
                str2 = access$getMAdInfoWrapper$p2.getCachePath();
            }
            mediaPlayer.setDataSource(str2);
            this.$player.setDisplay(surfaceHolder);
            this.$player.prepare();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        i.g(surfaceHolder, "holder");
    }
}
