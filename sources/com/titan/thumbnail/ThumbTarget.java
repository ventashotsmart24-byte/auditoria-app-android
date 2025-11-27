package com.titan.thumbnail;

import android.view.View;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import java.io.File;
import t9.i;

public abstract class ThumbTarget extends SimpleTarget<File> {
    private final int tagId = R.id.glide_custom_view_target_tag;
    private final String url;
    private final View view;

    public ThumbTarget(View view2, String str) {
        i.h(view2, "view");
        i.h(str, "url");
        this.view = view2;
        this.url = str;
    }

    public Request getRequest() {
        Object tag = this.view.getTag(this.tagId);
        if (!(tag instanceof Request)) {
            tag = null;
        }
        return (Request) tag;
    }

    public final String getUrl() {
        return this.url;
    }

    public final View getView() {
        return this.view;
    }

    public abstract void onResourceReadyUrl(File file, String str);

    public void setRequest(Request request) {
        this.view.setTag(this.tagId, request);
    }

    public void onResourceReady(File file, Transition<? super File> transition) {
        i.h(file, "resource");
        onResourceReadyUrl(file, this.url);
    }
}
