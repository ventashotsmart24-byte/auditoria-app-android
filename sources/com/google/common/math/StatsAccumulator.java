package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public final class StatsAccumulator {
    private long count = 0;
    private double max = Double.NaN;
    private double mean = 0.0d;
    private double min = Double.NaN;
    private double sumOfSquaresOfDeltas = 0.0d;

    public static double calculateNewMeanNonFinite(double d10, double d11) {
        if (Doubles.isFinite(d10)) {
            return d11;
        }
        if (Doubles.isFinite(d11) || d10 == d11) {
            return d10;
        }
        return Double.NaN;
    }

    private void merge(long j10, double d10, double d11, double d12, double d13) {
        long j11 = j10;
        double d14 = d10;
        double d15 = d11;
        double d16 = d12;
        double d17 = d13;
        long j12 = this.count;
        if (j12 == 0) {
            this.count = j11;
            this.mean = d14;
            this.sumOfSquaresOfDeltas = d15;
            this.min = d16;
            this.max = d17;
            return;
        }
        this.count = j12 + j11;
        if (!Doubles.isFinite(this.mean) || !Doubles.isFinite(d10)) {
            this.mean = calculateNewMeanNonFinite(this.mean, d14);
            this.sumOfSquaresOfDeltas = Double.NaN;
        } else {
            double d18 = this.mean;
            double d19 = d14 - d18;
            double d20 = (double) j11;
            Double.isNaN(d20);
            double d21 = (double) this.count;
            Double.isNaN(d21);
            double d22 = d18 + ((d19 * d20) / d21);
            this.mean = d22;
            double d23 = this.sumOfSquaresOfDeltas;
            Double.isNaN(d20);
            this.sumOfSquaresOfDeltas = d23 + d15 + (d19 * (d14 - d22) * d20);
        }
        this.min = Math.min(this.min, d16);
        this.max = Math.max(this.max, d13);
    }

    public void add(double d10) {
        long j10 = this.count;
        if (j10 == 0) {
            this.count = 1;
            this.mean = d10;
            this.min = d10;
            this.max = d10;
            if (!Doubles.isFinite(d10)) {
                this.sumOfSquaresOfDeltas = Double.NaN;
                return;
            }
            return;
        }
        this.count = j10 + 1;
        if (!Doubles.isFinite(d10) || !Doubles.isFinite(this.mean)) {
            this.mean = calculateNewMeanNonFinite(this.mean, d10);
            this.sumOfSquaresOfDeltas = Double.NaN;
        } else {
            double d11 = this.mean;
            double d12 = d10 - d11;
            double d13 = (double) this.count;
            Double.isNaN(d13);
            double d14 = d11 + (d12 / d13);
            this.mean = d14;
            this.sumOfSquaresOfDeltas += d12 * (d10 - d14);
        }
        this.min = Math.min(this.min, d10);
        this.max = Math.max(this.max, d10);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        for (Number doubleValue : iterable) {
            add(doubleValue.doubleValue());
        }
    }

    public long count() {
        return this.count;
    }

    public double max() {
        boolean z10;
        if (this.count != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        return this.max;
    }

    public double mean() {
        boolean z10;
        if (this.count != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        return this.mean;
    }

    public double min() {
        boolean z10;
        if (this.count != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        return this.min;
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        boolean z10;
        if (this.count != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        double ensureNonNegative = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        double d10 = (double) this.count;
        Double.isNaN(d10);
        return ensureNonNegative / d10;
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        boolean z10;
        if (this.count > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        double ensureNonNegative = DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas);
        double d10 = (double) (this.count - 1);
        Double.isNaN(d10);
        return ensureNonNegative / d10;
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        double d10 = this.mean;
        double d11 = (double) this.count;
        Double.isNaN(d11);
        return d10 * d11;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(((Number) it.next()).doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double add : dArr) {
            add(add);
        }
    }

    public void addAll(int... iArr) {
        for (int i10 : iArr) {
            add((double) i10);
        }
    }

    public void addAll(long... jArr) {
        for (long j10 : jArr) {
            add((double) j10);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() != 0) {
            merge(stats.count(), stats.mean(), stats.sumOfSquaresOfDeltas(), stats.min(), stats.max());
        }
    }

    public void addAll(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.count() != 0) {
            merge(statsAccumulator.count(), statsAccumulator.mean(), statsAccumulator.sumOfSquaresOfDeltas(), statsAccumulator.min(), statsAccumulator.max());
        }
    }
}
