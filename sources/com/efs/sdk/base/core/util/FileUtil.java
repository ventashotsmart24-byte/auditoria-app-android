package com.efs.sdk.base.core.util;

import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.model.LogDto;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FileUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f5294a = new Random();

    public static void copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        try {
                            Log.e("efs.util.file", "error when copy", e);
                            safeClose(fileInputStream);
                            safeClose(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            safeClose(fileInputStream);
                            safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        safeClose(fileInputStream);
                        safeClose(fileOutputStream);
                        throw th;
                    }
                }
                safeClose(fileInputStream2);
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                Log.e("efs.util.file", "error when copy", e);
                safeClose(fileInputStream);
                safeClose(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                safeClose(fileInputStream);
                safeClose(fileOutputStream);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileOutputStream = null;
            Log.e("efs.util.file", "error when copy", e);
            safeClose(fileInputStream);
            safeClose(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            safeClose(fileInputStream);
            safeClose(fileOutputStream);
            throw th;
        }
        safeClose(fileOutputStream);
    }

    public static LogDto createCodeLogDtoByName(String str) {
        String[] split = str.split("_");
        if (split.length != 11) {
            Log.w("efs.util.file", "[code log]File name error, name is ".concat(str));
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        byte byteValue2 = Byte.valueOf(split[3]).byteValue();
        String str4 = split[7];
        String str5 = split[8];
        long longValue = Long.valueOf(split[9]).longValue();
        long longValue2 = Long.valueOf(split[10]).longValue();
        LogDto logDto = new LogDto(str2, byteValue2);
        logDto.setCp(str3);
        logDto.setDe(byteValue);
        logDto.setUid(str4);
        logDto.setDid(str5);
        logDto.setBeginTime(longValue);
        logDto.setEndTime(longValue2);
        return logDto;
    }

    public static LogDto createLogDtoByName(String str) {
        String[] split = str.split("_");
        if (split.length != 7) {
            Log.w("efs.util.file", "File name error, name is ".concat(str));
            return null;
        }
        String str2 = split[0];
        String str3 = split[1];
        byte byteValue = Byte.valueOf(split[2]).byteValue();
        LogDto logDto = new LogDto(str2, Byte.valueOf(split[3]).byteValue());
        logDto.setCp(str3);
        logDto.setDe(byteValue);
        return logDto;
    }

    public static void delete(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File delete : listFiles) {
                    delete(delete);
                }
            }
            file.delete();
        }
    }

    public static String getCodelogFileName(LogDto logDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(logDto.getLogType());
        sb.append("_");
        sb.append(logDto.getCp());
        sb.append("_");
        sb.append(logDto.getDe());
        sb.append("_");
        sb.append(logDto.getLogProtocol());
        sb.append("_");
        sb.append(ProcessUtil.myPid());
        sb.append("_");
        sb.append(f5294a.nextInt(10000));
        sb.append("_");
        a.a();
        sb.append(a.b());
        sb.append("_");
        sb.append(logDto.getUid());
        sb.append("_");
        sb.append(logDto.getDid());
        sb.append("_");
        sb.append(logDto.getBeginTime());
        sb.append("_");
        sb.append(logDto.getEndTime());
        return sb.toString();
    }

    public static String getFileName(LogDto logDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(logDto.getLogType());
        sb.append("_");
        sb.append(logDto.getCp());
        sb.append("_");
        sb.append(logDto.getDe());
        sb.append("_");
        sb.append(logDto.getLogProtocol());
        sb.append("_");
        sb.append(ProcessUtil.myPid());
        sb.append("_");
        sb.append(f5294a.nextInt(10000));
        sb.append("_");
        a.a();
        sb.append(a.b());
        return sb.toString();
    }

    public static long getFolderSize(File file) {
        long j10 = 0;
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File folderSize : listFiles) {
            j10 += getFolderSize(folderSize);
        }
        return j10;
    }

    public static List<File> listFiles(File file) {
        if (file.isFile()) {
            return Collections.emptyList();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                arrayList.add(file2);
                Log.i("efs.util.file", "file is " + file2.getName());
            } else {
                arrayList.addAll(listFiles(file2));
            }
        }
        return arrayList;
    }

    public static void move(File file, File file2) {
        copy(file, file2);
        delete(file);
    }

    public static String read(File file) {
        return read(file, 1024);
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static boolean write(String str, byte[] bArr) {
        return write(new File(str), bArr);
    }

    public static String read(File file, int i10) {
        String str = "";
        if (!file.exists()) {
            return str;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i10];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                str = sb.toString();
                safeClose(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    Log.e("efs.util.file", "read file error", th);
                    return str;
                } finally {
                    safeClose(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            Log.e("efs.util.file", "read file error", th);
            return str;
        }
        return str;
    }

    /* JADX INFO: finally extract failed */
    public static boolean write(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                safeClose(fileOutputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    safeClose(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    safeClose(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
            safeClose(fileOutputStream);
            return false;
        }
    }

    public static boolean write(File file, String str) {
        return write(file, str.getBytes());
    }

    public static byte[] read(String str) {
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                safeClose(fileInputStream2);
            } catch (Exception e10) {
                e = e10;
                fileInputStream = fileInputStream2;
                try {
                    Log.e("efs.util.file", "read data error", e);
                    safeClose(fileInputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    safeClose(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                safeClose(fileInputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            Log.e("efs.util.file", "read data error", e);
            safeClose(fileInputStream);
            return bArr;
        }
        return bArr;
    }
}
