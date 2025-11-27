package com.hpplay.glide.load.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.hpplay.glide.Priority;
import com.hpplay.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MediaStoreThumbFetcher implements DataFetcher<InputStream> {
    private static final ThumbnailStreamOpenerFactory DEFAULT_FACTORY = new ThumbnailStreamOpenerFactory();
    private static final int MINI_HEIGHT = 384;
    private static final int MINI_WIDTH = 512;
    private static final String TAG = "MediaStoreThumbFetcher";
    private final Context context;
    private final DataFetcher<InputStream> defaultFetcher;
    private final ThumbnailStreamOpenerFactory factory;
    private final int height;
    private InputStream inputStream;
    private final Uri mediaStoreUri;
    private final int width;

    public static class FileService {
        public boolean exists(File file) {
            return file.exists();
        }

        public File get(String str) {
            return new File(str);
        }

        public long length(File file) {
            return file.length();
        }
    }

    public static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {"_data"};
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";

        public Cursor queryPath(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, (String) null);
        }
    }

    public interface ThumbnailQuery {
        Cursor queryPath(Context context, Uri uri);
    }

    public static class ThumbnailStreamOpener {
        private static final FileService DEFAULT_SERVICE = new FileService();
        private ThumbnailQuery query;
        private final FileService service;

        public ThumbnailStreamOpener(ThumbnailQuery thumbnailQuery) {
            this(DEFAULT_SERVICE, thumbnailQuery);
        }

        private Uri parseThumbUri(Cursor cursor) {
            String string = cursor.getString(0);
            if (!TextUtils.isEmpty(string)) {
                File file = this.service.get(string);
                if (this.service.exists(file) && this.service.length(file) > 0) {
                    return Uri.fromFile(file);
                }
            }
            return null;
        }

        public int getOrientation(Context context, Uri uri) {
            InputStream inputStream = null;
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                int orientation = new ImageHeaderParser(openInputStream).getOrientation();
                if (openInputStream == null) {
                    return orientation;
                }
                try {
                    openInputStream.close();
                    return orientation;
                } catch (IOException unused) {
                    return orientation;
                }
            } catch (IOException unused2) {
                if (Log.isLoggable(MediaStoreThumbFetcher.TAG, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to open uri: ");
                    sb.append(uri);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return -1;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0021  */
        /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.InputStream open(android.content.Context r3, android.net.Uri r4) {
            /*
                r2 = this;
                com.hpplay.glide.load.data.MediaStoreThumbFetcher$ThumbnailQuery r0 = r2.query
                android.database.Cursor r4 = r0.queryPath(r3, r4)
                r0 = 0
                if (r4 == 0) goto L_0x0019
                boolean r1 = r4.moveToFirst()     // Catch:{ all -> 0x0014 }
                if (r1 == 0) goto L_0x0019
                android.net.Uri r1 = r2.parseThumbUri(r4)     // Catch:{ all -> 0x0014 }
                goto L_0x001a
            L_0x0014:
                r3 = move-exception
                r4.close()
                throw r3
            L_0x0019:
                r1 = r0
            L_0x001a:
                if (r4 == 0) goto L_0x001f
                r4.close()
            L_0x001f:
                if (r1 == 0) goto L_0x0029
                android.content.ContentResolver r3 = r3.getContentResolver()
                java.io.InputStream r0 = r3.openInputStream(r1)
            L_0x0029:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener.open(android.content.Context, android.net.Uri):java.io.InputStream");
        }

        public ThumbnailStreamOpener(FileService fileService, ThumbnailQuery thumbnailQuery) {
            this.service = fileService;
            this.query = thumbnailQuery;
        }
    }

    public static class ThumbnailStreamOpenerFactory {
        public ThumbnailStreamOpener build(Uri uri, int i10, int i11) {
            if (!MediaStoreThumbFetcher.isMediaStoreUri(uri) || i10 > 512 || i11 > MediaStoreThumbFetcher.MINI_HEIGHT) {
                return null;
            }
            if (MediaStoreThumbFetcher.isMediaStoreVideo(uri)) {
                return new ThumbnailStreamOpener(new VideoThumbnailQuery());
            }
            return new ThumbnailStreamOpener(new ImageThumbnailQuery());
        }
    }

    public static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {"_data"};
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";

        public Cursor queryPath(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, (String) null);
        }
    }

    public MediaStoreThumbFetcher(Context context2, Uri uri, DataFetcher<InputStream> dataFetcher, int i10, int i11) {
        this(context2, uri, dataFetcher, i10, i11, DEFAULT_FACTORY);
    }

    /* access modifiers changed from: private */
    public static boolean isMediaStoreUri(Uri uri) {
        if (uri == null || !"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean isMediaStoreVideo(Uri uri) {
        if (!isMediaStoreUri(uri) || !uri.getPathSegments().contains("video")) {
            return false;
        }
        return true;
    }

    private InputStream openThumbInputStream(ThumbnailStreamOpener thumbnailStreamOpener) {
        InputStream inputStream2;
        int i10;
        try {
            inputStream2 = thumbnailStreamOpener.open(this.context, this.mediaStoreUri);
        } catch (FileNotFoundException unused) {
            Log.isLoggable(TAG, 3);
            inputStream2 = null;
        }
        if (inputStream2 != null) {
            i10 = thumbnailStreamOpener.getOrientation(this.context, this.mediaStoreUri);
        } else {
            i10 = -1;
        }
        if (i10 != -1) {
            return new ExifOrientationStream(inputStream2, i10);
        }
        return inputStream2;
    }

    public void cancel() {
    }

    public void cleanup() {
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused) {
            }
        }
        this.defaultFetcher.cleanup();
    }

    public String getId() {
        return this.mediaStoreUri.toString();
    }

    public MediaStoreThumbFetcher(Context context2, Uri uri, DataFetcher<InputStream> dataFetcher, int i10, int i11, ThumbnailStreamOpenerFactory thumbnailStreamOpenerFactory) {
        this.context = context2;
        this.mediaStoreUri = uri;
        this.defaultFetcher = dataFetcher;
        this.width = i10;
        this.height = i11;
        this.factory = thumbnailStreamOpenerFactory;
    }

    public InputStream loadData(Priority priority) {
        ThumbnailStreamOpener build = this.factory.build(this.mediaStoreUri, this.width, this.height);
        if (build != null) {
            this.inputStream = openThumbInputStream(build);
        }
        if (this.inputStream == null) {
            this.inputStream = this.defaultFetcher.loadData(priority);
        }
        return this.inputStream;
    }
}
