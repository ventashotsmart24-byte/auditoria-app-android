package o0;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.umcrash.UMCrash;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final File f8417a;

    /* renamed from: b  reason: collision with root package name */
    public final long f8418b;

    /* renamed from: c  reason: collision with root package name */
    public final File f8419c;

    /* renamed from: d  reason: collision with root package name */
    public final RandomAccessFile f8420d;

    /* renamed from: e  reason: collision with root package name */
    public final FileChannel f8421e;

    /* renamed from: f  reason: collision with root package name */
    public final FileLock f8422f;

    public class a implements FileFilter {
        public a() {
        }

        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* renamed from: o0.b$b  reason: collision with other inner class name */
    public static class C0111b extends File {

        /* renamed from: a  reason: collision with root package name */
        public long f8424a = -1;

        public C0111b(File file, String str) {
            super(file, str);
        }
    }

    public b(File file, File file2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        this.f8417a = file;
        this.f8419c = file2;
        this.f8418b = m(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f8420d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f8421e = channel;
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Blocking on lock ");
                sb2.append(file3.getPath());
                this.f8422f = channel.lock();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(file3.getPath());
                sb3.append(" locked");
            } catch (IOException e10) {
                e = e10;
                b(this.f8421e);
                throw e;
            } catch (RuntimeException e11) {
                e = e11;
                b(this.f8421e);
                throw e;
            } catch (Error e12) {
                e = e12;
                b(this.f8421e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e13) {
            b(this.f8420d);
            throw e13;
        }
    }

    public static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, com.hpplay.logwriter.b.f10583e, file.getParentFile());
        StringBuilder sb = new StringBuilder();
        sb.append("Extracting ");
        sb.append(createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Renaming to ");
                sb2.append(file.getPath());
                if (createTempFile.renameTo(file)) {
                    b(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            b(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    public static SharedPreferences e(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    public static long f(File file) {
        long lastModified = file.lastModified();
        if (lastModified == -1) {
            return lastModified - 1;
        }
        return lastModified;
    }

    public static long m(File file) {
        long c10 = c.c(file);
        if (c10 == -1) {
            return c10 - 1;
        }
        return c10;
    }

    public static boolean n(Context context, File file, long j10, String str) {
        SharedPreferences e10 = e(context);
        if (e10.getLong(str + UMCrash.SP_KEY_TIMESTAMP, -1) == f(file)) {
            if (e10.getLong(str + "crc", -1) != j10) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void v(Context context, String str, long j10, long j11, List list) {
        SharedPreferences.Editor edit = e(context).edit();
        edit.putLong(str + UMCrash.SP_KEY_TIMESTAMP, j10);
        edit.putLong(str + "crc", j11);
        edit.putInt(str + "dex.number", list.size() + 1);
        Iterator it = list.iterator();
        int i10 = 2;
        while (it.hasNext()) {
            C0111b bVar = (C0111b) it.next();
            edit.putLong(str + "dex.crc." + i10, bVar.f8424a);
            edit.putLong(str + "dex.time." + i10, bVar.lastModified());
            i10++;
        }
        edit.commit();
    }

    public final void a() {
        File[] listFiles = this.f8419c.listFiles(new a());
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(this.f8419c.getPath());
            sb.append(").");
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            if (!file.delete()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to delete old file ");
                sb3.append(file.getPath());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(file.getPath());
            }
        }
    }

    public void close() {
        this.f8422f.release();
        this.f8421e.close();
        this.f8420d.close();
    }

    public List q(Context context, String str, boolean z10) {
        List list;
        List list2;
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor.load(");
        sb.append(this.f8417a.getPath());
        sb.append(", ");
        sb.append(z10);
        sb.append(", ");
        sb.append(str);
        sb.append(")");
        if (this.f8422f.isValid()) {
            if (z10 || n(context, this.f8417a, this.f8418b, str)) {
                list2 = u();
                v(context, str, f(this.f8417a), this.f8418b, list2);
            } else {
                try {
                    list = s(context, str);
                } catch (IOException unused) {
                    list2 = u();
                    v(context, str, f(this.f8417a), this.f8418b, list2);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("load found ");
                sb2.append(list.size());
                sb2.append(" secondary dex files");
                return list;
            }
            list = list2;
            StringBuilder sb22 = new StringBuilder();
            sb22.append("load found ");
            sb22.append(list.size());
            sb22.append(" secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public final List s(Context context, String str) {
        String str2 = str;
        String str3 = this.f8417a.getName() + ".classes";
        SharedPreferences e10 = e(context);
        int i10 = e10.getInt(str2 + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i10 + -1);
        int i11 = 2;
        while (i11 <= i10) {
            C0111b bVar = new C0111b(this.f8419c, str3 + i11 + com.hpplay.logwriter.b.f10583e);
            if (bVar.isFile()) {
                bVar.f8424a = m(bVar);
                long j10 = e10.getLong(str2 + "dex.crc." + i11, -1);
                long j11 = e10.getLong(str2 + "dex.time." + i11, -1);
                long lastModified = bVar.lastModified();
                if (j11 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = e10;
                    if (j10 == bVar.f8424a) {
                        arrayList.add(bVar);
                        i11++;
                        e10 = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str2 + "\"), expected modification time: " + j11 + ", modification time: " + lastModified + ", expected crc: " + j10 + ", file crc: " + bVar.f8424a);
            }
            throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + "'");
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r10 = new java.lang.StringBuilder();
        r10.append("Failed to read crc from ");
        r10.append(r8.getAbsolutePath());
        r10 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0083 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List u() {
        /*
            r14 = this;
            java.lang.String r0 = ".dex"
            java.lang.String r1 = "classes"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r14.f8417a
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = ".classes"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r14.a()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile
            java.io.File r5 = r14.f8417a
            r4.<init>(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r5.<init>()     // Catch:{ all -> 0x0135 }
            r5.append(r1)     // Catch:{ all -> 0x0135 }
            r6 = 2
            r5.append(r6)     // Catch:{ all -> 0x0135 }
            r5.append(r0)     // Catch:{ all -> 0x0135 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0135 }
            java.util.zip.ZipEntry r5 = r4.getEntry(r5)     // Catch:{ all -> 0x0135 }
        L_0x0041:
            if (r5 == 0) goto L_0x0131
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r7.<init>()     // Catch:{ all -> 0x0135 }
            r7.append(r2)     // Catch:{ all -> 0x0135 }
            r7.append(r6)     // Catch:{ all -> 0x0135 }
            java.lang.String r8 = ".zip"
            r7.append(r8)     // Catch:{ all -> 0x0135 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0135 }
            o0.b$b r8 = new o0.b$b     // Catch:{ all -> 0x0135 }
            java.io.File r9 = r14.f8419c     // Catch:{ all -> 0x0135 }
            r8.<init>(r9, r7)     // Catch:{ all -> 0x0135 }
            r3.add(r8)     // Catch:{ all -> 0x0135 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r7.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r9 = "Extraction is needed for file "
            r7.append(r9)     // Catch:{ all -> 0x0135 }
            r7.append(r8)     // Catch:{ all -> 0x0135 }
            r7 = 0
            r9 = 0
            r10 = 0
        L_0x0071:
            r11 = 3
            if (r9 >= r11) goto L_0x00ed
            if (r10 != 0) goto L_0x00ed
            int r9 = r9 + 1
            c(r4, r5, r8, r2)     // Catch:{ all -> 0x0135 }
            long r10 = m(r8)     // Catch:{ IOException -> 0x0083 }
            r8.f8424a = r10     // Catch:{ IOException -> 0x0083 }
            r10 = 1
            goto L_0x0095
        L_0x0083:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r10.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r11 = "Failed to read crc from "
            r10.append(r11)     // Catch:{ all -> 0x0135 }
            java.lang.String r11 = r8.getAbsolutePath()     // Catch:{ all -> 0x0135 }
            r10.append(r11)     // Catch:{ all -> 0x0135 }
            r10 = 0
        L_0x0095:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r11.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = "Extraction "
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            if (r10 == 0) goto L_0x00a4
            java.lang.String r12 = "succeeded"
            goto L_0x00a6
        L_0x00a4:
            java.lang.String r12 = "failed"
        L_0x00a6:
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = " '"
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = r8.getAbsolutePath()     // Catch:{ all -> 0x0135 }
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = "': length "
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            long r12 = r8.length()     // Catch:{ all -> 0x0135 }
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = " - crc: "
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            long r12 = r8.f8424a     // Catch:{ all -> 0x0135 }
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            if (r10 != 0) goto L_0x0071
            r8.delete()     // Catch:{ all -> 0x0135 }
            boolean r11 = r8.exists()     // Catch:{ all -> 0x0135 }
            if (r11 == 0) goto L_0x0071
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r11.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = "Failed to delete corrupted secondary dex '"
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = r8.getPath()     // Catch:{ all -> 0x0135 }
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            java.lang.String r12 = "'"
            r11.append(r12)     // Catch:{ all -> 0x0135 }
            goto L_0x0071
        L_0x00ed:
            if (r10 == 0) goto L_0x0109
            int r6 = r6 + 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r5.<init>()     // Catch:{ all -> 0x0135 }
            r5.append(r1)     // Catch:{ all -> 0x0135 }
            r5.append(r6)     // Catch:{ all -> 0x0135 }
            r5.append(r0)     // Catch:{ all -> 0x0135 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0135 }
            java.util.zip.ZipEntry r5 = r4.getEntry(r5)     // Catch:{ all -> 0x0135 }
            goto L_0x0041
        L_0x0109:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0135 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0135 }
            r1.<init>()     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = "Could not create zip file "
            r1.append(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = r8.getAbsolutePath()     // Catch:{ all -> 0x0135 }
            r1.append(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = " for secondary dex ("
            r1.append(r2)     // Catch:{ all -> 0x0135 }
            r1.append(r6)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0135 }
            r0.<init>(r1)     // Catch:{ all -> 0x0135 }
            throw r0     // Catch:{ all -> 0x0135 }
        L_0x0131:
            r4.close()     // Catch:{ IOException -> 0x0134 }
        L_0x0134:
            return r3
        L_0x0135:
            r0 = move-exception
            r4.close()     // Catch:{ IOException -> 0x0139 }
        L_0x0139:
            goto L_0x013b
        L_0x013a:
            throw r0
        L_0x013b:
            goto L_0x013a
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.b.u():java.util.List");
    }
}
