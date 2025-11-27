package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i10, int i11, int i12) {
        boolean z10;
        int i13;
        int i14;
        float f10;
        float f11;
        int i15;
        int i16;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        int i17 = i10;
        int i18 = i11;
        int i19 = i12;
        if (i19 <= 4) {
            try {
                Result decode = this.delegate.decode(binaryBitmap2, map);
                Iterator<Result> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getText().equals(decode.getText())) {
                            z10 = true;
                            break;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (!z10) {
                    list.add(translateResultPoints(decode, i17, i18));
                } else {
                    List<Result> list2 = list;
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f12 = (float) width;
                    float f13 = (float) height;
                    float f14 = 0.0f;
                    float f15 = 0.0f;
                    for (ResultPoint resultPoint : resultPoints) {
                        if (resultPoint != null) {
                            float x10 = resultPoint.getX();
                            float y10 = resultPoint.getY();
                            if (x10 < f12) {
                                f12 = x10;
                            }
                            if (y10 < f13) {
                                f13 = y10;
                            }
                            if (x10 > f14) {
                                f14 = x10;
                            }
                            if (y10 > f15) {
                                f15 = y10;
                            }
                        }
                    }
                    if (f12 > 100.0f) {
                        f10 = f14;
                        f11 = f13;
                        i14 = height;
                        i13 = width;
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, (int) f12, height), map, list, i10, i11, i19 + 1);
                    } else {
                        f10 = f14;
                        f11 = f13;
                        i14 = height;
                        i13 = width;
                    }
                    if (f11 > 100.0f) {
                        int i20 = (int) f11;
                        i15 = i13;
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, i15, i20), map, list, i10, i11, i19 + 1);
                    } else {
                        i15 = i13;
                    }
                    float f16 = f10;
                    if (f16 < ((float) (i15 - 100))) {
                        int i21 = (int) f16;
                        i16 = i14;
                        doDecodeMultiple(binaryBitmap2.crop(i21, 0, i15 - i21, i16), map, list, i17 + i21, i11, i19 + 1);
                    } else {
                        i16 = i14;
                    }
                    if (f15 < ((float) (i16 - 100))) {
                        int i22 = (int) f15;
                        doDecodeMultiple(binaryBitmap2.crop(0, i22, i15, i16 - i22), map, list, i10, i18 + i22, i19 + 1);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    private static Result translateResultPoints(Result result, int i10, int i11) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i12 = 0; i12 < resultPoints.length; i12++) {
            ResultPoint resultPoint = resultPoints[i12];
            if (resultPoint != null) {
                resultPointArr[i12] = new ResultPoint(resultPoint.getX() + ((float) i10), resultPoint.getY() + ((float) i11));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) {
        return decodeMultiple(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
