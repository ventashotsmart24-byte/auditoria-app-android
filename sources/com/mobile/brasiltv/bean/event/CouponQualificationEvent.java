package com.mobile.brasiltv.bean.event;

public final class CouponQualificationEvent {
    private boolean isHasCouponQualification;

    public CouponQualificationEvent(boolean z10) {
        this.isHasCouponQualification = z10;
    }

    public final boolean isHasCouponQualification() {
        return this.isHasCouponQualification;
    }

    public final void setHasCouponQualification(boolean z10) {
        this.isHasCouponQualification = z10;
    }
}
