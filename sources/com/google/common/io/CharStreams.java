package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    public static final class NullWriter extends Writer {
        /* access modifiers changed from: private */
        public static final NullWriter INSTANCE = new NullWriter();

        private NullWriter() {
        }

        public Writer append(char c10) {
            return this;
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return "CharStreams.nullWriter()";
        }

        public void write(int i10) {
        }

        public Writer append(@CheckForNull CharSequence charSequence) {
            return this;
        }

        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        public void write(char[] cArr, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11 + i10, cArr.length);
        }

        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        public void write(String str, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11 + i10, str.length());
        }

        public Writer append(@CheckForNull CharSequence charSequence, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, charSequence == null ? 4 : charSequence.length());
            return this;
        }
    }

    private CharStreams() {
    }

    @Beta
    public static Writer asWriter(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable readable, Appendable appendable) {
        if (!(readable instanceof Reader)) {
            Preconditions.checkNotNull(readable);
            Preconditions.checkNotNull(appendable);
            CharBuffer createBuffer = createBuffer();
            long j10 = 0;
            while (readable.read(createBuffer) != -1) {
                Java8Compatibility.flip(createBuffer);
                appendable.append(createBuffer);
                j10 += (long) createBuffer.remaining();
                Java8Compatibility.clear(createBuffer);
            }
            return j10;
        } else if (appendable instanceof StringBuilder) {
            return copyReaderToBuilder((Reader) readable, (StringBuilder) appendable);
        } else {
            return copyReaderToWriter((Reader) readable, asWriter(appendable));
        }
    }

    @CanIgnoreReturnValue
    public static long copyReaderToBuilder(Reader reader, StringBuilder sb) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb);
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j10;
            }
            sb.append(cArr, 0, read);
            j10 += (long) read;
        }
    }

    @CanIgnoreReturnValue
    public static long copyReaderToWriter(Reader reader, Writer writer) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j10 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j10;
            }
            writer.write(cArr, 0, read);
            j10 += (long) read;
        }
    }

    public static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable readable) {
        CharBuffer createBuffer = createBuffer();
        long j10 = 0;
        while (true) {
            long read = (long) readable.read(createBuffer);
            if (read == -1) {
                return j10;
            }
            j10 += read;
            Java8Compatibility.clear(createBuffer);
        }
    }

    @Beta
    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    @Beta
    public static List<String> readLines(Readable readable) {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    @Beta
    public static void skipFully(Reader reader, long j10) {
        Preconditions.checkNotNull(reader);
        while (j10 > 0) {
            long skip = reader.skip(j10);
            if (skip != 0) {
                j10 -= skip;
            } else {
                throw new EOFException();
            }
        }
    }

    public static String toString(Readable readable) {
        return toStringBuilder(readable).toString();
    }

    private static StringBuilder toStringBuilder(Readable readable) {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            copyReaderToBuilder((Reader) readable, sb);
        } else {
            copy(readable, sb);
        }
        return sb;
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    @Beta
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null || !lineProcessor.processLine(readLine)) {
            }
            readLine = lineReader.readLine();
            break;
        } while (!lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }
}
