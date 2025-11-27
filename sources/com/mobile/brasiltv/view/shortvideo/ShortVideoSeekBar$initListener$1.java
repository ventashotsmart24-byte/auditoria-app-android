package com.mobile.brasiltv.view.shortvideo;

import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.shortvideo.ShortVideoSeekBar;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

public final class ShortVideoSeekBar$initListener$1 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ ShortVideoSeekBar this$0;

    public ShortVideoSeekBar$initListener$1(ShortVideoSeekBar shortVideoSeekBar) {
        this.this$0 = shortVideoSeekBar;
    }

    /* access modifiers changed from: private */
    public static final void onStopTrackingTouch$lambda$0(ShortVideoSeekBar shortVideoSeekBar, SeekBar seekBar) {
        i.g(shortVideoSeekBar, "this$0");
        i.g(seekBar, "$seekBar");
        shortVideoSeekBar.removeCallbacks(shortVideoSeekBar.resetSeekBarRunnable);
        shortVideoSeekBar.postDelayed(shortVideoSeekBar.resetSeekBarRunnable, 2000);
        ShortVideoSeekBar.OnSeekListener access$getMSeekListener$p = shortVideoSeekBar.mSeekListener;
        if (access$getMSeekListener$p != null) {
            access$getMSeekListener$p.onSeekStop(seekBar.getProgress());
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        i.g(seekBar, "seekBar");
        this.this$0.setProgress(i10);
        ShortVideoSeekBar.OnSeekListener access$getMSeekListener$p = this.this$0.mSeekListener;
        if (access$getMSeekListener$p != null) {
            access$getMSeekListener$p.onSeeking(seekBar.getProgress());
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        i.g(seekBar, "seekBar");
        if (seekBar.isEnabled()) {
            ShortVideoSeekBar shortVideoSeekBar = this.this$0;
            int i10 = R$id.mSeekBar;
            ((AppCompatSeekBar) shortVideoSeekBar._$_findCachedViewById(i10)).setThumb(this.this$0.getContext().getResources().getDrawable(R.drawable.seekbar_thumb_shortvideo));
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvCurrentTime)).setVisibility(0);
            ((TextView) this.this$0._$_findCachedViewById(R$id.mTvMaxTime)).setVisibility(0);
            ((AppCompatSeekBar) this.this$0._$_findCachedViewById(i10)).setLayoutParams(new AutoLinearLayout.LayoutParams(-1, AutoUtils.getPercentHeightSize(64)));
            ((AppCompatSeekBar) this.this$0._$_findCachedViewById(i10)).setPadding(AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(50), AutoUtils.getPercentWidthSize(6), AutoUtils.getPercentHeightSize(10));
            ShortVideoSeekBar.OnSeekListener access$getMSeekListener$p = this.this$0.mSeekListener;
            if (access$getMSeekListener$p != null) {
                access$getMSeekListener$p.onSeekStart();
            }
            ShortVideoSeekBar shortVideoSeekBar2 = this.this$0;
            shortVideoSeekBar2.removeCallbacks(shortVideoSeekBar2.resetSeekBarRunnable);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        i.g(seekBar, "seekBar");
        if (seekBar.isEnabled()) {
            ((AppCompatSeekBar) this.this$0._$_findCachedViewById(R$id.mSeekBar)).post(new b(this.this$0, seekBar));
        }
    }
}
