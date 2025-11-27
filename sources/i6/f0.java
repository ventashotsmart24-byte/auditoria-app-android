package i6;

public interface f0 extends l5.a {

    public static final class a {
        public static /* synthetic */ void a(f0 f0Var, String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13, int i11, Object obj) {
            boolean z14;
            String str6;
            int[] iArr2;
            boolean z15;
            int i12 = i11;
            if (obj == null) {
                if ((i12 & 128) != 0) {
                    z14 = false;
                } else {
                    z14 = z12;
                }
                if ((i12 & 256) != 0) {
                    str6 = null;
                } else {
                    str6 = str5;
                }
                if ((i12 & 512) != 0) {
                    iArr2 = null;
                } else {
                    iArr2 = iArr;
                }
                if ((i12 & 1024) != 0) {
                    z15 = false;
                } else {
                    z15 = z13;
                }
                f0Var.a(str, str2, i10, str3, str4, z10, z11, z14, str6, iArr2, z15);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authProgram");
        }
    }

    void a(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13);
}
