package okhttp3.internal.http2;

import java.util.List;
import okio.BufferedSource;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public boolean onData(int i10, BufferedSource bufferedSource, int i11, boolean z10) {
            bufferedSource.skip((long) i11);
            return true;
        }

        public boolean onHeaders(int i10, List<Header> list, boolean z10) {
            return true;
        }

        public boolean onRequest(int i10, List<Header> list) {
            return true;
        }

        public void onReset(int i10, ErrorCode errorCode) {
        }
    };

    boolean onData(int i10, BufferedSource bufferedSource, int i11, boolean z10);

    boolean onHeaders(int i10, List<Header> list, boolean z10);

    boolean onRequest(int i10, List<Header> list);

    void onReset(int i10, ErrorCode errorCode);
}
