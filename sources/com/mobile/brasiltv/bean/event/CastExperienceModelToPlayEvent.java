package com.mobile.brasiltv.bean.event;

import t9.g;

public final class CastExperienceModelToPlayEvent {
    private boolean isDLNA;

    public CastExperienceModelToPlayEvent() {
        this(false, 1, (g) null);
    }

    public final boolean isDLNA() {
        return this.isDLNA;
    }

    public final void setDLNA(boolean z10) {
        this.isDLNA = z10;
    }

    public CastExperienceModelToPlayEvent(boolean z10) {
        this.isDLNA = z10;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CastExperienceModelToPlayEvent(boolean z10, int i10, g gVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
