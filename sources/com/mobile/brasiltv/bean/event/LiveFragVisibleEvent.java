package com.mobile.brasiltv.bean.event;

public final class LiveFragVisibleEvent {
    private boolean visible;

    public LiveFragVisibleEvent(boolean z10) {
        this.visible = z10;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final void setVisible(boolean z10) {
        this.visible = z10;
    }
}
