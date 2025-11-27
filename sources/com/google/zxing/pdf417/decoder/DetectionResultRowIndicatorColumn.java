package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z10) {
        super(boundingBox);
        this.isLeft = z10;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        BoundingBox boundingBox = getBoundingBox();
        if (this.isLeft) {
            resultPoint = boundingBox.getTopLeft();
        } else {
            resultPoint = boundingBox.getTopRight();
        }
        if (this.isLeft) {
            resultPoint2 = boundingBox.getBottomLeft();
        } else {
            resultPoint2 = boundingBox.getBottomRight();
        }
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) resultPoint2.getY());
        Codeword[] codewords = getCodewords();
        int i10 = -1;
        int i11 = 0;
        int i12 = 1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) resultPoint.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            Codeword codeword = codewords[imageRowToCodewordIndex2];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber = codeword.getRowNumber() - i10;
                if (rowNumber == 0) {
                    i11++;
                } else {
                    if (rowNumber == 1) {
                        i12 = Math.max(i12, i11);
                        i10 = codeword.getRowNumber();
                    } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                        codewords[imageRowToCodewordIndex2] = null;
                    } else {
                        i10 = codeword.getRowNumber();
                    }
                    i11 = 1;
                }
            }
        }
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i10 = 0; i10 < codewordArr.length; i10++) {
            Codeword codeword = codewordArr[i10];
            if (codeword != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i10] = null;
                } else {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    int i11 = rowNumber % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                                codewordArr[i10] = null;
                            }
                        } else if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                            codewordArr[i10] = null;
                        }
                    } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                        codewordArr[i10] = null;
                    }
                }
            }
        }
    }

    private void setRowNumbers() {
        for (Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    public void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        boolean z10;
        boolean z11;
        Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        BoundingBox boundingBox = getBoundingBox();
        if (this.isLeft) {
            resultPoint = boundingBox.getTopLeft();
        } else {
            resultPoint = boundingBox.getTopRight();
        }
        if (this.isLeft) {
            resultPoint2 = boundingBox.getBottomLeft();
        } else {
            resultPoint2 = boundingBox.getBottomRight();
        }
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) resultPoint2.getY());
        int i10 = -1;
        int i11 = 0;
        int i12 = 1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) resultPoint.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            Codeword codeword = codewords[imageRowToCodewordIndex2];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber() - i10;
                if (rowNumber == 0) {
                    i11++;
                } else {
                    if (rowNumber == 1) {
                        i12 = Math.max(i12, i11);
                        i10 = codeword.getRowNumber();
                    } else if (rowNumber < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber > imageRowToCodewordIndex2) {
                        codewords[imageRowToCodewordIndex2] = null;
                    } else {
                        if (i12 > 2) {
                            rowNumber *= i12 - 2;
                        }
                        if (rowNumber >= imageRowToCodewordIndex2) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        for (int i13 = 1; i13 <= rowNumber && !z10; i13++) {
                            if (codewords[imageRowToCodewordIndex2 - i13] != null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                        }
                        if (z10) {
                            codewords[imageRowToCodewordIndex2] = null;
                        } else {
                            i10 = codeword.getRowNumber();
                        }
                    }
                    i11 = 1;
                }
            }
        }
    }

    public BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewords = getCodewords();
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                int i10 = rowNumber % 3;
                if (i10 == 0) {
                    barcodeValue2.setValue((value * 3) + 1);
                } else if (i10 == 1) {
                    barcodeValue4.setValue(value / 3);
                    barcodeValue3.setValue(value % 3);
                } else if (i10 == 2) {
                    barcodeValue.setValue(value + 1);
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    public int[] getRowHeights() {
        int rowNumber;
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int rowCount = barcodeMetadata.getRowCount();
        int[] iArr = new int[rowCount];
        for (Codeword codeword : getCodewords()) {
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < rowCount) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
        }
        return iArr;
    }

    public boolean isLeft() {
        return this.isLeft;
    }

    public String toString() {
        return "IsLeft: " + this.isLeft + 10 + super.toString();
    }
}
