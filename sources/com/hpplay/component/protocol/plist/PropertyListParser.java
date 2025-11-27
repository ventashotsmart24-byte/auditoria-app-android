package com.hpplay.component.protocol.plist;

import com.google.common.primitives.UnsignedBytes;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PropertyListParser {
    private static final int READ_BUFFER_LENGTH = 2048;
    private static final int TYPE_ASCII = 2;
    private static final int TYPE_BINARY = 1;
    private static final int TYPE_ERROR_BLANK = 10;
    private static final int TYPE_ERROR_UNKNOWN = 11;
    private static final int TYPE_XML = 0;

    public static void convertToASCII(File file, File file2) {
        NSObject parse = parse(file);
        if (parse instanceof NSDictionary) {
            saveAsASCII((NSDictionary) parse, file2);
        } else if (parse instanceof NSArray) {
            saveAsASCII((NSArray) parse, file2);
        } else {
            throw new PropertyListFormatException("The root of the given input property list is neither a Dictionary nor an Array!");
        }
    }

    public static void convertToBinary(File file, File file2) {
        saveAsBinary(parse(file), file2);
    }

    public static void convertToGnuStepASCII(File file, File file2) {
        NSObject parse = parse(file);
        if (parse instanceof NSDictionary) {
            saveAsGnuStepASCII((NSDictionary) parse, file2);
        } else if (parse instanceof NSArray) {
            saveAsGnuStepASCII((NSArray) parse, file2);
        } else {
            throw new PropertyListFormatException("The root of the given input property list is neither a Dictionary nor an Array!");
        }
    }

    public static void convertToXml(File file, File file2) {
        saveAsXML(parse(file), file2);
    }

    private static int determineType(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return 10;
        }
        if (trim.startsWith("bplist")) {
            return 1;
        }
        if (trim.startsWith("(") || trim.startsWith("{") || trim.startsWith(Operator.Operation.DIVISION)) {
            return 2;
        }
        return trim.startsWith(Operator.Operation.LESS_THAN) ? 0 : 11;
    }

    public static NSObject parse(String str) {
        return parse(new File(str));
    }

    public static byte[] readAll(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void saveAsASCII(NSDictionary nSDictionary, File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
            try {
                outputStreamWriter.write(nSDictionary.toASCIIPropertyList());
            } finally {
                try {
                    outputStreamWriter.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("The output directory does not exist and could not be created.");
        }
    }

    public static void saveAsBinary(NSObject nSObject, File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            BinaryPropertyListWriter.write(file, nSObject);
            return;
        }
        throw new IOException("The output directory does not exist and could not be created.");
    }

    public static void saveAsGnuStepASCII(NSDictionary nSDictionary, File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
            try {
                outputStreamWriter.write(nSDictionary.toGnuStepASCIIPropertyList());
            } finally {
                try {
                    outputStreamWriter.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("The output directory does not exist and could not be created.");
        }
    }

    public static void saveAsXML(NSObject nSObject, File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                saveAsXML(nSObject, (OutputStream) fileOutputStream);
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("The output directory does not exist and could not be created.");
        }
    }

    public static NSObject parse(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse((InputStream) fileInputStream);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void saveAsBinary(NSObject nSObject, OutputStream outputStream) {
        BinaryPropertyListWriter.write(outputStream, nSObject);
    }

    private static int determineType(byte[] bArr) {
        int i10 = 0;
        if (bArr.length >= 3 && (bArr[0] & UnsignedBytes.MAX_VALUE) == 239 && (bArr[1] & UnsignedBytes.MAX_VALUE) == 187 && (bArr[2] & UnsignedBytes.MAX_VALUE) == 191) {
            i10 = 3;
        }
        while (i10 < bArr.length && ((r0 = bArr[i10]) == 32 || r0 == 9 || r0 == 13 || r0 == 10 || r0 == 12)) {
            i10++;
        }
        return determineType(new String(bArr, i10, Math.min(8, bArr.length - i10)));
    }

    public static NSObject parse(byte[] bArr) {
        return parse((InputStream) new ByteArrayInputStream(bArr));
    }

    public static NSObject parse(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        int determineType = determineType(inputStream, 0);
        if (determineType == 0) {
            return XMLPropertyListParser.parse(inputStream);
        }
        if (determineType == 1) {
            return BinaryPropertyListParser.parse(inputStream);
        }
        if (determineType == 2) {
            return ASCIIPropertyListParser.parse(inputStream);
        }
        if (determineType == 10) {
            return null;
        }
        throw new PropertyListFormatException("The given data is not a property list of a supported format.");
    }

    public static void saveAsASCII(NSArray nSArray, File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
            try {
                outputStreamWriter.write(nSArray.toASCIIPropertyList());
            } finally {
                try {
                    outputStreamWriter.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("The output directory does not exist and could not be created.");
        }
    }

    public static void saveAsGnuStepASCII(NSArray nSArray, File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "ASCII");
            try {
                outputStreamWriter.write(nSArray.toGnuStepASCIIPropertyList());
            } finally {
                try {
                    outputStreamWriter.close();
                } catch (IOException unused) {
                }
            }
        } else {
            throw new IOException("The output directory does not exist and could not be created.");
        }
    }

    public static void saveAsXML(NSObject nSObject, OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        outputStreamWriter.write(nSObject.toXMLPropertyList());
        outputStreamWriter.flush();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int determineType(java.io.InputStream r8, int r9) {
        /*
            int r0 = r9 + 1024
            boolean r1 = r8.markSupported()
            if (r1 == 0) goto L_0x000b
            r8.mark(r0)
        L_0x000b:
            long r1 = (long) r9
            r8.skip(r1)
            r1 = 0
            r2 = 0
        L_0x0011:
            r3 = 1
            int r9 = r9 + r3
            if (r9 <= r0) goto L_0x001d
            r8.reset()
            int r8 = determineType(r8, r0)
            return r8
        L_0x001d:
            int r4 = r8.read()
            r5 = 3
            if (r9 >= r5) goto L_0x003b
            if (r9 != 0) goto L_0x002a
            r5 = 239(0xef, float:3.35E-43)
            if (r4 == r5) goto L_0x0039
        L_0x002a:
            if (r2 == 0) goto L_0x003b
            if (r9 != r3) goto L_0x0032
            r2 = 187(0xbb, float:2.62E-43)
            if (r4 == r2) goto L_0x0039
        L_0x0032:
            r2 = 2
            if (r9 != r2) goto L_0x003b
            r2 = 191(0xbf, float:2.68E-43)
            if (r4 != r2) goto L_0x003b
        L_0x0039:
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            r5 = 10
            r6 = -1
            if (r4 == r6) goto L_0x0055
            r7 = 32
            if (r4 == r7) goto L_0x0011
            r7 = 9
            if (r4 == r7) goto L_0x0011
            r7 = 13
            if (r4 == r7) goto L_0x0011
            if (r4 == r5) goto L_0x0011
            r7 = 12
            if (r4 == r7) goto L_0x0011
            if (r2 != 0) goto L_0x0011
        L_0x0055:
            if (r4 != r6) goto L_0x0058
            return r5
        L_0x0058:
            r9 = 8
            byte[] r9 = new byte[r9]
            byte r0 = (byte) r4
            r9[r1] = r0
            r0 = 7
            int r0 = r8.read(r9, r3, r0)
            java.lang.String r2 = new java.lang.String
            r2.<init>(r9, r1, r0)
            int r9 = determineType((java.lang.String) r2)
            boolean r0 = r8.markSupported()
            if (r0 == 0) goto L_0x0076
            r8.reset()
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.plist.PropertyListParser.determineType(java.io.InputStream, int):int");
    }
}
