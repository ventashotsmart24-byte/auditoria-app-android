package com.hpplay.glide.load.resource.file;

import com.hpplay.glide.load.resource.SimpleResource;
import java.io.File;

public class FileResource extends SimpleResource<File> {
    public FileResource(File file) {
        super(file);
    }
}
