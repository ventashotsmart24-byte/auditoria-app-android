package com.google.firebase.inappmessaging.display.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.google.common.net.HttpHeaders;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

@FirebaseAppScope
public class FiamImageLoader {
    private final RequestManager requestManager;
    /* access modifiers changed from: private */
    public final Map<String, Set<CustomTarget>> tags = new HashMap();

    public static abstract class Callback extends CustomTarget<Drawable> {
        private ImageView imageView;

        private void setImage(Drawable drawable) {
            ImageView imageView2 = this.imageView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
            }
        }

        public abstract void onError(Exception exc);

        public void onLoadCleared(Drawable drawable) {
            Logging.logd("Downloading Image Cleared");
            setImage(drawable);
            onSuccess();
        }

        public void onLoadFailed(Drawable drawable) {
            Logging.logd("Downloading Image Failed");
            setImage(drawable);
            onError(new Exception("Image loading failed!"));
        }

        public abstract void onSuccess();

        public void setImageView(ImageView imageView2) {
            this.imageView = imageView2;
        }

        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
            Logging.logd("Downloading Image Success!!!");
            setImage(drawable);
            onSuccess();
        }
    }

    public class FiamImageRequestCreator {
        private final RequestBuilder<Drawable> requestBuilder;
        private String tag;
        private Callback target;

        public FiamImageRequestCreator(RequestBuilder<Drawable> requestBuilder2) {
            this.requestBuilder = requestBuilder2;
        }

        private void checkAndTag() {
            Set set;
            if (this.target != null && !TextUtils.isEmpty(this.tag)) {
                synchronized (FiamImageLoader.this.tags) {
                    if (FiamImageLoader.this.tags.containsKey(this.tag)) {
                        set = (Set) FiamImageLoader.this.tags.get(this.tag);
                    } else {
                        set = new HashSet();
                        FiamImageLoader.this.tags.put(this.tag, set);
                    }
                    if (!set.contains(this.target)) {
                        set.add(this.target);
                    }
                }
            }
        }

        public void into(ImageView imageView, Callback callback) {
            Logging.logd("Downloading Image Callback : " + callback);
            callback.setImageView(imageView);
            this.requestBuilder.into(callback);
            this.target = callback;
            checkAndTag();
        }

        public FiamImageRequestCreator placeholder(int i10) {
            this.requestBuilder.placeholder(i10);
            Logging.logd("Downloading Image Placeholder : " + i10);
            return this;
        }

        public FiamImageRequestCreator tag(Class cls) {
            this.tag = cls.getSimpleName();
            checkAndTag();
            return this;
        }
    }

    @Inject
    public FiamImageLoader(RequestManager requestManager2) {
        this.requestManager = requestManager2;
    }

    public void cancelTag(Class cls) {
        String simpleName = cls.getSimpleName();
        synchronized (simpleName) {
            if (this.tags.containsKey(simpleName)) {
                for (CustomTarget customTarget : this.tags.get(simpleName)) {
                    if (customTarget != null) {
                        this.requestManager.clear((Target<?>) customTarget);
                    }
                }
            }
        }
    }

    public boolean containsTag(String str) {
        Map<String, Set<CustomTarget>> map = this.tags;
        if (map == null || !map.containsKey(str) || this.tags.get(str) == null || this.tags.get(str).size() <= 0) {
            return false;
        }
        return true;
    }

    public FiamImageRequestCreator load(String str) {
        Logging.logd("Starting Downloading Image : " + str);
        return new FiamImageRequestCreator((RequestBuilder) this.requestManager.load((Object) new GlideUrl(str, (Headers) new LazyHeaders.Builder().addHeader(HttpHeaders.ACCEPT, "image/*").build())).format(DecodeFormat.PREFER_ARGB_8888));
    }
}
