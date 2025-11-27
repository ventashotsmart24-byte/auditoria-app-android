package cn.bingoogolapple.bgabanner;

import android.view.View;

public abstract class BGAOnNoDoubleClickListener implements View.OnClickListener {
    private long mLastClickTime;
    private int mThrottleFirstTime;

    public BGAOnNoDoubleClickListener() {
        this.mThrottleFirstTime = 1000;
        this.mLastClickTime = 0;
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastClickTime > ((long) this.mThrottleFirstTime)) {
            this.mLastClickTime = currentTimeMillis;
            onNoDoubleClick(view);
        }
    }

    public abstract void onNoDoubleClick(View view);

    public BGAOnNoDoubleClickListener(int i10) {
        this.mLastClickTime = 0;
        this.mThrottleFirstTime = i10;
    }
}
