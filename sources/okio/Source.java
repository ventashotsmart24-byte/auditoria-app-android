package okio;

import java.io.Closeable;

public interface Source extends Closeable {
    void close();

    long read(Buffer buffer, long j10);

    Timeout timeout();
}
