package j6;

public interface d extends m5.a {

    public static final class a {
        public static /* synthetic */ void a(d dVar, String str, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    str = "";
                }
                dVar.c(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
        }
    }

    void c(String str);

    void onLoading();

    void s();
}
