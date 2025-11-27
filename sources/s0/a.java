package s0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final Map f9209e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final File f9210a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f9211b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9212c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f9213d;

    public a(String str, File file, boolean z10) {
        File file2 = new File(file, str + ".lck");
        this.f9210a = file2;
        this.f9211b = a(file2.getAbsolutePath());
        this.f9212c = z10;
    }

    public static Lock a(String str) {
        Lock lock;
        Map map = f9209e;
        synchronized (map) {
            lock = (Lock) map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void b() {
        this.f9211b.lock();
        if (this.f9212c) {
            try {
                FileChannel channel = new FileOutputStream(this.f9210a).getChannel();
                this.f9213d = channel;
                channel.lock();
            } catch (IOException e10) {
                throw new IllegalStateException("Unable to grab copy lock.", e10);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f9213d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f9211b.unlock();
    }
}
