package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

public final class DirectResourceLoader<DataT> implements ModelLoader<Integer, DataT> {
    private final Context context;
    private final ResourceOpener<DataT> resourceOpener;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor>, ResourceOpener<AssetFileDescriptor> {
        private final Context context;

        public AssetFileDescriptorFactory(Context context2) {
            this.context = context2;
        }

        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.context, this);
        }

        public Class<AssetFileDescriptor> getDataClass() {
            return AssetFileDescriptor.class;
        }

        public void teardown() {
        }

        public void close(AssetFileDescriptor assetFileDescriptor) {
            assetFileDescriptor.close();
        }

        public AssetFileDescriptor open(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResourceFd(i10);
        }
    }

    public static final class DrawableFactory implements ModelLoaderFactory<Integer, Drawable>, ResourceOpener<Drawable> {
        private final Context context;

        public DrawableFactory(Context context2) {
            this.context = context2;
        }

        public ModelLoader<Integer, Drawable> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.context, this);
        }

        public void close(Drawable drawable) {
        }

        public Class<Drawable> getDataClass() {
            return Drawable.class;
        }

        public void teardown() {
        }

        public Drawable open(Resources.Theme theme, Resources resources, int i10) {
            return DrawableDecoderCompat.getDrawable(this.context, i10, theme);
        }
    }

    public static final class InputStreamFactory implements ModelLoaderFactory<Integer, InputStream>, ResourceOpener<InputStream> {
        private final Context context;

        public InputStreamFactory(Context context2) {
            this.context = context2;
        }

        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.context, this);
        }

        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        public void teardown() {
        }

        public void close(InputStream inputStream) {
            inputStream.close();
        }

        public InputStream open(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResource(i10);
        }
    }

    public static final class ResourceDataFetcher<DataT> implements DataFetcher<DataT> {
        private DataT data;
        private final int resourceId;
        private final ResourceOpener<DataT> resourceOpener;
        private final Resources resources;
        private final Resources.Theme theme;

        public ResourceDataFetcher(Resources.Theme theme2, Resources resources2, ResourceOpener<DataT> resourceOpener2, int i10) {
            this.theme = theme2;
            this.resources = resources2;
            this.resourceOpener = resourceOpener2;
            this.resourceId = i10;
        }

        public void cancel() {
        }

        public void cleanup() {
            DataT datat = this.data;
            if (datat != null) {
                try {
                    this.resourceOpener.close(datat);
                } catch (IOException unused) {
                }
            }
        }

        public Class<DataT> getDataClass() {
            return this.resourceOpener.getDataClass();
        }

        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(Priority priority, DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataT open = this.resourceOpener.open(this.theme, this.resources, this.resourceId);
                this.data = open;
                dataCallback.onDataReady(open);
            } catch (Resources.NotFoundException e10) {
                dataCallback.onLoadFailed(e10);
            }
        }
    }

    public interface ResourceOpener<DataT> {
        void close(DataT datat);

        Class<DataT> getDataClass();

        DataT open(Resources.Theme theme, Resources resources, int i10);
    }

    public DirectResourceLoader(Context context2, ResourceOpener<DataT> resourceOpener2) {
        this.context = context2.getApplicationContext();
        this.resourceOpener = resourceOpener2;
    }

    public static ModelLoaderFactory<Integer, AssetFileDescriptor> assetFileDescriptorFactory(Context context2) {
        return new AssetFileDescriptorFactory(context2);
    }

    public static ModelLoaderFactory<Integer, Drawable> drawableFactory(Context context2) {
        return new DrawableFactory(context2);
    }

    public static ModelLoaderFactory<Integer, InputStream> inputStreamFactory(Context context2) {
        return new InputStreamFactory(context2);
    }

    public boolean handles(Integer num) {
        return true;
    }

    public ModelLoader.LoadData<DataT> buildLoadData(Integer num, int i10, int i11, Options options) {
        Resources resources;
        Resources.Theme theme = (Resources.Theme) options.get(ResourceDrawableDecoder.THEME);
        if (Build.VERSION.SDK_INT < 21 || theme == null) {
            resources = this.context.getResources();
        } else {
            resources = theme.getResources();
        }
        return new ModelLoader.LoadData<>(new ObjectKey(num), new ResourceDataFetcher(theme, resources, this.resourceOpener, num.intValue()));
    }
}
