package com.hpplay.glide;

import com.hpplay.glide.request.FutureTarget;
import com.hpplay.glide.request.target.Target;
import java.io.File;

interface DownloadOptions {
    FutureTarget<File> downloadOnly(int i10, int i11);

    <Y extends Target<File>> Y downloadOnly(Y y10);
}
