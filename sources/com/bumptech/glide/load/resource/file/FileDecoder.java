package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder implements ResourceDecoder<File, File> {
    public boolean handles(File file, Options options) {
        return true;
    }

    public Resource<File> decode(File file, int i10, int i11, Options options) {
        return new FileResource(file);
    }
}
