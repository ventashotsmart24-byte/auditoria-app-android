package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public final class PairedStatsAccumulator {
    private double sumOfProductsOfDeltas = 0.0d;
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();

    private static double ensureInUnitRange(double d10) {
        return Doubles.constrainToRange(d10, -1.0d, 1.0d);
    }

    private double ensurePositive(double d10) {
        if (d10 > 0.0d) {
            return d10;
        }
        return Double.MIN_VALUE;
    }

    public void add(double d10, double d11) {
        this.xStats.add(d10);
        if (!Doubles.isFinite(d10) || !Doubles.isFinite(d11)) {
            this.sumOfProductsOfDeltas = Double.NaN;
        } else if (this.xStats.count() > 1) {
            this.sumOfProductsOfDeltas += (d10 - this.xStats.mean()) * (d11 - this.yStats.mean());
        }
        this.yStats.add(d11);
    }

    public void addAll(PairedStats pairedStats) {
        if (pairedStats.count() != 0) {
            this.xStats.addAll(pairedStats.xStats());
            if (this.yStats.count() == 0) {
                this.sumOfProductsOfDeltas = pairedStats.sumOfProductsOfDeltas();
            } else {
                double d10 = this.sumOfProductsOfDeltas;
                double sumOfProductsOfDeltas2 = pairedStats.sumOfProductsOfDeltas();
                double mean = (pairedStats.xStats().mean() - this.xStats.mean()) * (pairedStats.yStats().mean() - this.yStats.mean());
                double count = (double) pairedStats.count();
                Double.isNaN(count);
                this.sumOfProductsOfDeltas = d10 + sumOfProductsOfDeltas2 + (mean * count);
            }
            this.yStats.addAll(pairedStats.yStats());
        }
    }

    public long count() {
        return this.xStats.count();
    }

    public final LinearTransformation leastSquaresFit() {
        boolean z10;
        boolean z11 = true;
        if (count() > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas <= 0.0d) {
            if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) {
                z11 = false;
            }
            Preconditions.checkState(z11);
            return LinearTransformation.vertical(this.xStats.mean());
        } else if (this.yStats.sumOfSquaresOfDeltas() > 0.0d) {
            return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
        } else {
            return LinearTransformation.horizontal(this.yStats.mean());
        }
    }

    public final double pearsonsCorrelationCoefficient() {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        if (count() > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas > 0.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (sumOfSquaresOfDeltas2 <= 0.0d) {
            z12 = false;
        }
        Preconditions.checkState(z12);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        boolean z10;
        if (count() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        double d10 = this.sumOfProductsOfDeltas;
        double count = (double) count();
        Double.isNaN(count);
        return d10 / count;
    }

    public final double sampleCovariance() {
        boolean z10;
        if (count() > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10);
        double d10 = this.sumOfProductsOfDeltas;
        double count = (double) (count() - 1);
        Double.isNaN(count);
        return d10 / count;
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }
}
