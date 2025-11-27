package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {
    private final Double batteryLevel;
    private final int batteryVelocity;
    private final long diskUsed;
    private final int orientation;
    private final boolean proximityOn;
    private final long ramUsed;

    public static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {
        private Double batteryLevel;
        private Integer batteryVelocity;
        private Long diskUsed;
        private Integer orientation;
        private Boolean proximityOn;
        private Long ramUsed;

        public CrashlyticsReport.Session.Event.Device build() {
            String str = "";
            if (this.batteryVelocity == null) {
                str = str + " batteryVelocity";
            }
            if (this.proximityOn == null) {
                str = str + " proximityOn";
            }
            if (this.orientation == null) {
                str = str + " orientation";
            }
            if (this.ramUsed == null) {
                str = str + " ramUsed";
            }
            if (this.diskUsed == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.batteryLevel, this.batteryVelocity.intValue(), this.proximityOn.booleanValue(), this.orientation.intValue(), this.ramUsed.longValue(), this.diskUsed.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double d10) {
            this.batteryLevel = d10;
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int i10) {
            this.batteryVelocity = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long j10) {
            this.diskUsed = Long.valueOf(j10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setOrientation(int i10) {
            this.orientation = Integer.valueOf(i10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean z10) {
            this.proximityOn = Boolean.valueOf(z10);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long j10) {
            this.ramUsed = Long.valueOf(j10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d10 = this.batteryLevel;
        if (d10 != null ? d10.equals(device.getBatteryLevel()) : device.getBatteryLevel() == null) {
            if (this.batteryVelocity == device.getBatteryVelocity() && this.proximityOn == device.isProximityOn() && this.orientation == device.getOrientation() && this.ramUsed == device.getRamUsed() && this.diskUsed == device.getDiskUsed()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Double getBatteryLevel() {
        return this.batteryLevel;
    }

    public int getBatteryVelocity() {
        return this.batteryVelocity;
    }

    public long getDiskUsed() {
        return this.diskUsed;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public long getRamUsed() {
        return this.ramUsed;
    }

    public int hashCode() {
        int i10;
        int i11;
        Double d10 = this.batteryLevel;
        if (d10 == null) {
            i10 = 0;
        } else {
            i10 = d10.hashCode();
        }
        int i12 = (((i10 ^ 1000003) * 1000003) ^ this.batteryVelocity) * 1000003;
        if (this.proximityOn) {
            i11 = 1231;
        } else {
            i11 = 1237;
        }
        long j10 = this.ramUsed;
        long j11 = this.diskUsed;
        return ((((((i12 ^ i11) * 1000003) ^ this.orientation) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public boolean isProximityOn() {
        return this.proximityOn;
    }

    public String toString() {
        return "Device{batteryLevel=" + this.batteryLevel + ", batteryVelocity=" + this.batteryVelocity + ", proximityOn=" + this.proximityOn + ", orientation=" + this.orientation + ", ramUsed=" + this.ramUsed + ", diskUsed=" + this.diskUsed + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Device(Double d10, int i10, boolean z10, int i11, long j10, long j11) {
        this.batteryLevel = d10;
        this.batteryVelocity = i10;
        this.proximityOn = z10;
        this.orientation = i11;
        this.ramUsed = j10;
        this.diskUsed = j11;
    }
}
