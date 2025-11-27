package s0;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import q0.e;
import t0.b;

public abstract class c {
    /* JADX INFO: finally extract failed */
    public static void a(b bVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor B = bVar.B("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (B.moveToNext()) {
            try {
                arrayList.add(B.getString(0));
            } catch (Throwable th) {
                B.close();
                throw th;
            }
        }
        B.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.execSQL("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(e eVar, t0.e eVar2, boolean z10, CancellationSignal cancellationSignal) {
        int i10;
        Cursor q10 = eVar.q(eVar2, cancellationSignal);
        if (!z10 || !(q10 instanceof AbstractWindowedCursor)) {
            return q10;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) q10;
        int count = abstractWindowedCursor.getCount();
        if (abstractWindowedCursor.hasWindow()) {
            i10 = abstractWindowedCursor.getWindow().getNumRows();
        } else {
            i10 = count;
        }
        if (Build.VERSION.SDK_INT < 23 || i10 < count) {
            return b.a(abstractWindowedCursor);
        }
        return q10;
    }

    public static int c(File file) {
        FileChannel fileChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel = new FileInputStream(file).getChannel();
            fileChannel.tryLock(60, 4, true);
            fileChannel.position(60);
            if (fileChannel.read(allocate) == 4) {
                allocate.rewind();
                int i10 = allocate.getInt();
                fileChannel.close();
                return i10;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }
}
