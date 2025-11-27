package com.umeng.commonsdk.utils;

import java.io.File;

public interface FileLockCallback {
    boolean onFileLock(File file, int i10);

    boolean onFileLock(String str);

    boolean onFileLock(String str, Object obj);
}
