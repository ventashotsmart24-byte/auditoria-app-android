package z6;

import android.content.Context;
import com.mobile.brasiltv.utils.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class a {
    public static boolean a(Context context, String str, String str2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStream = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(new File(str2));
            } catch (IOException e10) {
                e = e10;
                try {
                    e.printStackTrace();
                    j.a(fileOutputStream2, inputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    j.a(fileOutputStream2, inputStream);
                    throw th;
                }
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        j.a(fileOutputStream, inputStream);
                        return true;
                    }
                }
            } catch (IOException e11) {
                e = e11;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                j.a(fileOutputStream2, inputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                j.a(fileOutputStream2, inputStream);
                throw th;
            }
        } catch (IOException e12) {
            e = e12;
            inputStream = null;
            e.printStackTrace();
            j.a(fileOutputStream2, inputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            j.a(fileOutputStream2, inputStream);
            throw th;
        }
    }

    public static void b(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File b10 : listFiles) {
                    b(b10);
                }
            }
            file.delete();
        }
    }
}
