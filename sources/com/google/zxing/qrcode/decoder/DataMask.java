package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

enum DataMask {
    DATA_MASK_000 {
        public boolean isMasked(int i10, int i11) {
            return ((i10 + i11) & 1) == 0;
        }
    },
    DATA_MASK_001 {
        public boolean isMasked(int i10, int i11) {
            return (i10 & 1) == 0;
        }
    },
    DATA_MASK_010 {
        public boolean isMasked(int i10, int i11) {
            if (i11 % 3 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_011 {
        public boolean isMasked(int i10, int i11) {
            if ((i10 + i11) % 3 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_100 {
        public boolean isMasked(int i10, int i11) {
            if ((((i10 / 2) + (i11 / 3)) & 1) == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_101 {
        public boolean isMasked(int i10, int i11) {
            if ((i10 * i11) % 6 == 0) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_110 {
        public boolean isMasked(int i10, int i11) {
            if ((i10 * i11) % 6 < 3) {
                return true;
            }
            return false;
        }
    },
    DATA_MASK_111 {
        public boolean isMasked(int i10, int i11) {
            if (((i10 + i11 + ((i10 * i11) % 3)) & 1) == 0) {
                return true;
            }
            return false;
        }
    };

    public abstract boolean isMasked(int i10, int i11);

    public final void unmaskBitMatrix(BitMatrix bitMatrix, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                if (isMasked(i11, i12)) {
                    bitMatrix.flip(i12, i11);
                }
            }
        }
    }
}
