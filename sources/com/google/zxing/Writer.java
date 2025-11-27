package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i10, int i11);

    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map);
}
