package com.hpplay.common.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class CpuFilter implements FileFilter {
    public boolean accept(File file) {
        if (Pattern.matches("cpu[0-9]", file.getName())) {
            return true;
        }
        return false;
    }
}
