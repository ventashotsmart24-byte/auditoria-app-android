package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    public static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            float access$800 = this.operation.getStartAngle();
            float access$900 = this.operation.getSweepAngle();
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i10, access$800, access$900);
        }
    }

    public static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f10, float f11) {
            this.operation = pathLineOperation;
            this.startX = f10;
            this.startY = f11;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.operation.f10033y - this.startY), (double) (this.operation.f10032x - this.startX)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.startX, this.startY);
            matrix2.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i10);
        }

        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation.f10033y - this.startY) / (this.operation.f10032x - this.startX))));
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f10, float f11, float f12, float f13) {
            setLeft(f10);
            setTop(f11);
            setRight(f12);
            setBottom(f13);
        }

        /* access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        /* access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        private void setBottom(float f10) {
            this.bottom = f10;
        }

        private void setLeft(float f10) {
            this.left = f10;
        }

        private void setRight(float f10) {
            this.right = f10;
        }

        /* access modifiers changed from: private */
        public void setStartAngle(float f10) {
            this.startAngle = f10;
        }

        /* access modifiers changed from: private */
        public void setSweepAngle(float f10) {
            this.sweepAngle = f10;
        }

        private void setTop(float f10) {
            this.top = f10;
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public float f10032x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public float f10033y;

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f10032x, this.f10033y);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        /* access modifiers changed from: private */
        public void setControlX(float f10) {
            this.controlX = f10;
        }

        /* access modifiers changed from: private */
        public void setControlY(float f10) {
            this.controlY = f10;
        }

        /* access modifiers changed from: private */
        public void setEndX(float f10) {
            this.endX = f10;
        }

        /* access modifiers changed from: private */
        public void setEndY(float f10) {
            this.endY = f10;
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    public static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i10, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f10) {
        if (getCurrentShadowAngle() != f10) {
            float currentShadowAngle2 = ((f10 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
            if (currentShadowAngle2 <= ANGLE_LEFT) {
                PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
                pathArcOperation.setStartAngle(getCurrentShadowAngle());
                pathArcOperation.setSweepAngle(currentShadowAngle2);
                this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
                setCurrentShadowAngle(f10);
            }
        }
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f10, float f11) {
        addConnectingShadowIfNecessary(f10);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f11);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f10) {
        this.currentShadowAngle = f10;
    }

    private void setEndShadowAngle(float f10) {
        this.endShadowAngle = f10;
    }

    private void setEndX(float f10) {
        this.endX = f10;
    }

    private void setEndY(float f10) {
        this.endY = f10;
    }

    private void setStartX(float f10) {
        this.startX = f10;
    }

    private void setStartY(float f10) {
        this.startY = f10;
    }

    public void addArc(float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z10;
        float f16;
        PathArcOperation pathArcOperation = new PathArcOperation(f10, f11, f12, f13);
        pathArcOperation.setStartAngle(f14);
        pathArcOperation.setSweepAngle(f15);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f17 = f14 + f15;
        if (f15 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f14 = (f14 + ANGLE_LEFT) % 360.0f;
        }
        if (z10) {
            f16 = (ANGLE_LEFT + f17) % 360.0f;
        } else {
            f16 = f17;
        }
        addShadowCompatOperation(arcShadowOperation, f14, f16);
        double d10 = (double) f17;
        setEndX(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        setEndY(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.operations.get(i10).applyToPath(matrix, path);
        }
    }

    public ShadowCompatOperation createShadowCompatOperation(final Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() {
            public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i10, Canvas canvas) {
                for (ShadowCompatOperation draw : arrayList) {
                    draw.draw(matrix, shadowRenderer, i10, canvas);
                }
            }
        };
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f10, float f11) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.f10032x = f10;
        float unused2 = pathLineOperation.f10033y = f11;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f10);
        setEndY(f11);
    }

    public void quadToPoint(float f10, float f11, float f12, float f13) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f10);
        pathQuadOperation.setControlY(f11);
        pathQuadOperation.setEndX(f12);
        pathQuadOperation.setEndY(f13);
        this.operations.add(pathQuadOperation);
        setEndX(f12);
        setEndY(f13);
    }

    public void reset(float f10, float f11) {
        reset(f10, f11, ANGLE_UP, 0.0f);
    }

    public void reset(float f10, float f11, float f12, float f13) {
        setStartX(f10);
        setStartY(f11);
        setEndX(f10);
        setEndY(f11);
        setCurrentShadowAngle(f12);
        setEndShadowAngle((f12 + f13) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
    }

    public ShapePath(float f10, float f11) {
        reset(f10, f11);
    }
}
