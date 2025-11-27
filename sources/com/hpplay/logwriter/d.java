package com.hpplay.logwriter;

import java.io.File;
import java.util.Comparator;

public class d implements Comparator<File> {
    /* renamed from: a */
    public int compare(File file, File file2) {
        return (int) (file.lastModified() - file2.lastModified());
    }
}
