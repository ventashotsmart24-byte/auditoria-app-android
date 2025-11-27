package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
public final class FileBackedOutputStream extends OutputStream {
    @CheckForNull
    @GuardedBy("this")
    private File file;
    private final int fileThreshold;
    @CheckForNull
    @GuardedBy("this")
    private MemoryOutput memory;
    @GuardedBy("this")
    private OutputStream out;
    @CheckForNull
    private final File parentDirectory;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    public static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }

        public int getCount() {
            return this.count;
        }
    }

    public FileBackedOutputStream(int i10) {
        this(i10, false);
    }

    /* access modifiers changed from: private */
    public synchronized InputStream openInputStream() {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        Objects.requireNonNull(this.memory);
        return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
    }

    @GuardedBy("this")
    private void update(int i10) {
        MemoryOutput memoryOutput = this.memory;
        if (memoryOutput != null && memoryOutput.getCount() + i10 > this.fileThreshold) {
            File createTempFile = File.createTempFile("FileBackedOutputStream", (String) null, this.parentDirectory);
            if (this.resetOnFinalize) {
                createTempFile.deleteOnExit();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
                fileOutputStream.flush();
                this.out = fileOutputStream;
                this.file = createTempFile;
                this.memory = null;
            } catch (IOException e10) {
                createTempFile.delete();
                throw e10;
            }
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    public synchronized void close() {
        this.out.close();
    }

    public synchronized void flush() {
        this.out.flush();
    }

    @CheckForNull
    @VisibleForTesting
    public synchronized File getFile() {
        return this.file;
    }

    public synchronized void reset() {
        try {
            close();
            MemoryOutput memoryOutput = this.memory;
            if (memoryOutput == null) {
                this.memory = new MemoryOutput();
            } else {
                memoryOutput.reset();
            }
            this.out = this.memory;
            File file2 = this.file;
            if (file2 != null) {
                this.file = null;
                if (!file2.delete()) {
                    String valueOf = String.valueOf(file2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                    sb.append("Could not delete: ");
                    sb.append(valueOf);
                    throw new IOException(sb.toString());
                }
            }
        } catch (Throwable th) {
            if (this.memory == null) {
                this.memory = new MemoryOutput();
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            File file3 = this.file;
            if (file3 != null) {
                this.file = null;
                if (!file3.delete()) {
                    String valueOf2 = String.valueOf(file3);
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 18);
                    sb2.append("Could not delete: ");
                    sb2.append(valueOf2);
                    throw new IOException(sb2.toString());
                }
            }
            throw th;
        }
    }

    public synchronized void write(int i10) {
        update(1);
        this.out.write(i10);
    }

    public FileBackedOutputStream(int i10, boolean z10) {
        this(i10, z10, (File) null);
    }

    private FileBackedOutputStream(int i10, boolean z10, @CheckForNull File file2) {
        this.fileThreshold = i10;
        this.resetOnFinalize = z10;
        this.parentDirectory = file2;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.memory = memoryOutput;
        this.out = memoryOutput;
        if (z10) {
            this.source = new ByteSource() {
                public void finalize() {
                    try {
                        FileBackedOutputStream.this.reset();
                    } catch (Throwable th) {
                        th.printStackTrace(System.err);
                    }
                }

                public InputStream openStream() {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        } else {
            this.source = new ByteSource() {
                public InputStream openStream() {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        }
    }

    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i10, int i11) {
        update(i11);
        this.out.write(bArr, i10, i11);
    }
}
