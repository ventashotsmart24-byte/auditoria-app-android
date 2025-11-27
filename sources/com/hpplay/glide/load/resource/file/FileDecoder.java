package com.hpplay.glide.load.resource.file;

import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder implements ResourceDecoder<File, File> {
    public String getId() {
        return "";
    }

    public Resource<File> decode(File file, int i10, int i11) {
        return new FileResource(file);
    }
}
