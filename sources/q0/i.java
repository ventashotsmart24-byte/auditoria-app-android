package q0;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import s0.a;
import s0.d;
import t0.b;
import t0.c;

public class i implements c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8912a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8913b;

    /* renamed from: c  reason: collision with root package name */
    public final File f8914c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8915d;

    /* renamed from: e  reason: collision with root package name */
    public final c f8916e;

    /* renamed from: f  reason: collision with root package name */
    public a f8917f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8918g;

    public i(Context context, String str, File file, int i10, c cVar) {
        this.f8912a = context;
        this.f8913b = str;
        this.f8914c = file;
        this.f8915d = i10;
        this.f8916e = cVar;
    }

    public synchronized b A() {
        if (!this.f8918g) {
            c();
            this.f8918g = true;
        }
        return this.f8916e.A();
    }

    public final void a(File file) {
        ReadableByteChannel readableByteChannel;
        if (this.f8913b != null) {
            readableByteChannel = Channels.newChannel(this.f8912a.getAssets().open(this.f8913b));
        } else if (this.f8914c != null) {
            readableByteChannel = new FileInputStream(this.f8914c).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f8912a.getCacheDir());
        createTempFile.deleteOnExit();
        d.a(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }

    public void b(a aVar) {
        this.f8917f = aVar;
    }

    public final void c() {
        boolean z10;
        String databaseName = getDatabaseName();
        File databasePath = this.f8912a.getDatabasePath(databaseName);
        a aVar = this.f8917f;
        if (aVar == null || aVar.f8855j) {
            z10 = true;
        } else {
            z10 = false;
        }
        a aVar2 = new a(databaseName, this.f8912a.getFilesDir(), z10);
        try {
            aVar2.b();
            if (!databasePath.exists()) {
                a(databasePath);
                aVar2.c();
            } else if (this.f8917f == null) {
                aVar2.c();
            } else {
                try {
                    int c10 = s0.c.c(databasePath);
                    int i10 = this.f8915d;
                    if (c10 == i10) {
                        aVar2.c();
                    } else if (this.f8917f.a(c10, i10)) {
                        aVar2.c();
                    } else {
                        if (this.f8912a.deleteDatabase(databaseName)) {
                            try {
                                a(databasePath);
                            } catch (IOException unused) {
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to delete database file (");
                            sb.append(databaseName);
                            sb.append(") for a copy destructive migration.");
                        }
                        aVar2.c();
                    }
                } catch (IOException unused2) {
                    aVar2.c();
                }
            }
        } catch (IOException e10) {
            throw new RuntimeException("Unable to copy database file.", e10);
        } catch (Throwable th) {
            aVar2.c();
            throw th;
        }
    }

    public synchronized void close() {
        this.f8916e.close();
        this.f8918g = false;
    }

    public String getDatabaseName() {
        return this.f8916e.getDatabaseName();
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f8916e.setWriteAheadLoggingEnabled(z10);
    }
}
