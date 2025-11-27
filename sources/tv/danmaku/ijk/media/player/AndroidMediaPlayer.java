package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public class AndroidMediaPlayer extends AbstractMediaPlayer {
    private static MediaInfo sMediaInfo;
    private String mDataSource;
    private final Object mInitLock;
    private final AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;

    public class AndroidMediaPlayerListenerHolder implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnTimedTextListener {
        public final WeakReference<AndroidMediaPlayer> mWeakMediaPlayer;

        public AndroidMediaPlayerListenerHolder(AndroidMediaPlayer androidMediaPlayer) {
            this.mWeakMediaPlayer = new WeakReference<>(androidMediaPlayer);
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnBufferingUpdate(i10);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnCompletion();
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            if (this.mWeakMediaPlayer.get() == null || !AndroidMediaPlayer.this.notifyOnError(i10, i11)) {
                return false;
            }
            return true;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            if (this.mWeakMediaPlayer.get() == null || !AndroidMediaPlayer.this.notifyOnInfo(i10, i11)) {
                return false;
            }
            return true;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnPrepared();
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnSeekComplete();
            }
        }

        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            IjkTimedText ijkTimedText;
            if (this.mWeakMediaPlayer.get() != null) {
                if (timedText != null) {
                    ijkTimedText = new IjkTimedText(timedText.getBounds(), timedText.getText());
                } else {
                    ijkTimedText = null;
                }
                AndroidMediaPlayer.this.notifyOnTimedText(ijkTimedText);
            }
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
            if (this.mWeakMediaPlayer.get() != null) {
                AndroidMediaPlayer.this.notifyOnVideoSizeChanged(i10, i11, 1, 1);
            }
        }
    }

    public static class MediaDataSourceProxy extends MediaDataSource {
        private final IMediaDataSource mMediaDataSource;

        public MediaDataSourceProxy(IMediaDataSource iMediaDataSource) {
            this.mMediaDataSource = iMediaDataSource;
        }

        public void close() {
            this.mMediaDataSource.close();
        }

        public long getSize() {
            return this.mMediaDataSource.getSize();
        }

        public int readAt(long j10, byte[] bArr, int i10, int i11) {
            return this.mMediaDataSource.readAt(j10, bArr, i10, i11);
        }
    }

    public AndroidMediaPlayer() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.mInitLock = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.mInternalMediaPlayer = mediaPlayer;
            fixMediaPlayerBug(mediaPlayer);
        }
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = new AndroidMediaPlayerListenerHolder(this);
        attachInternalListeners();
    }

    private void attachInternalListeners() {
        this.mInternalMediaPlayer.setOnPreparedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnBufferingUpdateListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnCompletionListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnSeekCompleteListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnVideoSizeChangedListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnErrorListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnInfoListener(this.mInternalListenerAdapter);
        this.mInternalMediaPlayer.setOnTimedTextListener(this.mInternalListenerAdapter);
    }

    private void fixMediaPlayerBug(MediaPlayer mediaPlayer) {
        Class<MediaPlayer> cls = MediaPlayer.class;
        if (Build.VERSION.SDK_INT == 19) {
            try {
                Class.forName("com.amlogic.SubTitleService.ISubTitleService");
                Method declaredMethod = cls.getDeclaredMethod("getSubtitleService", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(mediaPlayer, new Object[0]);
                Field declaredField = cls.getDeclaredField("subTitleService");
                declaredField.setAccessible(true);
                final Object obj = declaredField.get(mediaPlayer);
                declaredField.set(mediaPlayer, Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object obj, Method method, Object[] objArr) {
                        try {
                            return method.invoke(obj, objArr);
                        } catch (InvocationTargetException e10) {
                            String stackTraceString = Log.getStackTraceString(e10);
                            Log.e("AndroidMediaPlayer", stackTraceString);
                            if (TextUtils.isEmpty(stackTraceString) || !stackTraceString.contains("DeadObjectException")) {
                                throw e10;
                            }
                            Class<?> returnType = method.getReturnType();
                            if (returnType == Integer.TYPE) {
                                return -1;
                            }
                            if (returnType == String.class) {
                                return "";
                            }
                            if (returnType == Boolean.TYPE) {
                                return Boolean.FALSE;
                            }
                            return null;
                        }
                    }
                }));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            this.mMediaDataSource = null;
        }
    }

    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        try {
            return (long) this.mInternalMediaPlayer.getCurrentPosition();
        } catch (IllegalStateException e10) {
            DebugLog.printStackTrace(e10);
            return 0;
        }
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    public long getDuration() {
        try {
            return (long) this.mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e10) {
            DebugLog.printStackTrace(e10);
            return 0;
        }
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = "android";
            mediaInfo.mVideoDecoderImpl = "HW";
            mediaInfo.mAudioDecoder = "android";
            mediaInfo.mAudioDecoderImpl = "HW";
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    public int getVideoSarDen() {
        return 1;
    }

    public int getVideoSarNum() {
        return 1;
    }

    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    public boolean isPlayable() {
        return true;
    }

    public boolean isPlaying() {
        try {
            return this.mInternalMediaPlayer.isPlaying();
        } catch (IllegalStateException e10) {
            DebugLog.printStackTrace(e10);
            return false;
        }
    }

    public void pause() {
        this.mInternalMediaPlayer.pause();
    }

    public void prepareAsync() {
        this.mInternalMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void reset() {
        try {
            this.mInternalMediaPlayer.reset();
        } catch (IllegalStateException e10) {
            DebugLog.printStackTrace(e10);
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    public void seekTo(long j10) {
        this.mInternalMediaPlayer.seekTo((int) j10);
    }

    public void setAudioStreamType(int i10) {
        this.mInternalMediaPlayer.setAudioStreamType(i10);
    }

    public void setDataSource(Context context, Uri uri) {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.mInitLock) {
            if (!this.mIsReleased) {
                this.mInternalMediaPlayer.setDisplay(surfaceHolder);
            }
        }
    }

    public void setKeepInBackground(boolean z10) {
    }

    public void setLogEnabled(boolean z10) {
    }

    public void setLooping(boolean z10) {
        this.mInternalMediaPlayer.setLooping(z10);
    }

    public void setScreenOnWhilePlaying(boolean z10) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(z10);
    }

    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
    }

    public void setVolume(float f10, float f11) {
        this.mInternalMediaPlayer.setVolume(f10, f11);
    }

    public void setWakeMode(Context context, int i10) {
        this.mInternalMediaPlayer.setWakeMode(context, i10);
    }

    public void start() {
        try {
            this.mInternalMediaPlayer.start();
        } catch (Exception unused) {
        }
    }

    public void stop() {
        this.mInternalMediaPlayer.stop();
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) {
        this.mDataSource = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.mInternalMediaPlayer.setDataSource(str);
        } else {
            this.mInternalMediaPlayer.setDataSource(parse.getPath());
        }
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        releaseMediaDataSource();
        MediaDataSourceProxy mediaDataSourceProxy = new MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = mediaDataSourceProxy;
        this.mInternalMediaPlayer.setDataSource(mediaDataSourceProxy);
    }
}
