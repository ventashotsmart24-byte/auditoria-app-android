package com.loopj.android.http;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "FileAsyncHttpRH";
    protected final boolean append;
    protected final File file;
    protected File frontendFile;
    protected final boolean renameIfExists;

    public FileAsyncHttpResponseHandler(File file2) {
        this(file2, false);
    }

    public boolean deleteTargetFile() {
        if (getTargetFile() == null || !getTargetFile().delete()) {
            return false;
        }
        return true;
    }

    public File getOriginalFile() {
        boolean z10;
        if (this.file != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utils.asserts(z10, "Target file is null, fatal!");
        return this.file;
    }

    public byte[] getResponseData(HttpEntity httpEntity) {
        if (httpEntity == null) {
            return null;
        }
        InputStream content = httpEntity.getContent();
        long contentLength = httpEntity.getContentLength();
        FileOutputStream fileOutputStream = new FileOutputStream(getTargetFile(), this.append);
        if (content == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            int i10 = 0;
            while (true) {
                int read = content.read(bArr);
                if (read != -1 && !Thread.currentThread().isInterrupted()) {
                    i10 += read;
                    fileOutputStream.write(bArr, 0, read);
                    sendProgressMessage((long) i10, contentLength);
                }
            }
            return null;
        } finally {
            AsyncHttpClient.silentCloseInputStream(content);
            fileOutputStream.flush();
            AsyncHttpClient.silentCloseOutputStream(fileOutputStream);
        }
    }

    public File getTargetFile() {
        File file2;
        if (this.frontendFile == null) {
            if (getOriginalFile().isDirectory()) {
                file2 = getTargetFileByParsingURL();
            } else {
                file2 = getOriginalFile();
            }
            this.frontendFile = file2;
        }
        return this.frontendFile;
    }

    public File getTargetFileByParsingURL() {
        boolean z10;
        String str;
        Utils.asserts(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
        if (getRequestURI() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utils.asserts(z10, "RequestURI is null, cannot proceed");
        String uri = getRequestURI().toString();
        String substring = uri.substring(uri.lastIndexOf(47) + 1, uri.length());
        File file2 = new File(getOriginalFile(), substring);
        if (!file2.exists() || !this.renameIfExists) {
            return file2;
        }
        if (!substring.contains(".")) {
            str = substring + " (%d)";
        } else {
            str = substring.substring(0, substring.lastIndexOf(46)) + " (%d)" + substring.substring(substring.lastIndexOf(46), substring.length());
        }
        int i10 = 0;
        while (true) {
            File file3 = new File(getOriginalFile(), String.format(str, new Object[]{Integer.valueOf(i10)}));
            if (!file3.exists()) {
                return file3;
            }
            i10++;
        }
    }

    public File getTemporaryFile(Context context) {
        boolean z10;
        if (context != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Utils.asserts(z10, "Tried creating temporary file without having Context");
        try {
            return File.createTempFile("temp_", "_handled", context.getCacheDir());
        } catch (IOException e10) {
            AsyncHttpClient.log.e(LOG_TAG, "Cannot create temporary file", e10);
            return null;
        }
    }

    public abstract void onFailure(int i10, Header[] headerArr, Throwable th, File file2);

    public final void onFailure(int i10, Header[] headerArr, byte[] bArr, Throwable th) {
        onFailure(i10, headerArr, th, getTargetFile());
    }

    public abstract void onSuccess(int i10, Header[] headerArr, File file2);

    public final void onSuccess(int i10, Header[] headerArr, byte[] bArr) {
        onSuccess(i10, headerArr, getTargetFile());
    }

    public FileAsyncHttpResponseHandler(File file2, boolean z10) {
        this(file2, z10, false);
    }

    public FileAsyncHttpResponseHandler(File file2, boolean z10, boolean z11) {
        Utils.asserts(file2 != null, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (!file2.isDirectory() && !file2.getParentFile().isDirectory()) {
            Utils.asserts(file2.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
        }
        if (file2.isDirectory() && !file2.mkdirs()) {
            AsyncHttpClient.log.d(LOG_TAG, "Cannot create directories for requested Directory location, might not be a problem");
        }
        this.file = file2;
        this.append = z10;
        this.renameIfExists = z11;
    }

    public FileAsyncHttpResponseHandler(Context context) {
        this.file = getTemporaryFile(context);
        this.append = false;
        this.renameIfExists = false;
    }
}
