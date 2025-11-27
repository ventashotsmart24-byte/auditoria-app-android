package com.hpplay.glide.module;

import android.content.Context;
import com.hpplay.glide.Glide;
import com.hpplay.glide.GlideBuilder;

public interface GlideModule {
    void applyOptions(Context context, GlideBuilder glideBuilder);

    void registerComponents(Context context, Glide glide);
}
