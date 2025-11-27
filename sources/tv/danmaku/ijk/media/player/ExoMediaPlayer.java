package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Log;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import tv.danmaku.ijk.media.player.misc.ExoTrackInfo;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class ExoMediaPlayer extends AbstractMediaPlayer {
    private final String TAG = "ExoMediaPlayer";
    private Context mContext;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public boolean mIsBuffering = false;
    /* access modifiers changed from: private */
    public boolean mIsPreparing = true;
    /* access modifiers changed from: private */
    public SimpleExoPlayer mPlayer;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private DefaultTrackSelector mTrackSelector;

    public ExoMediaPlayer(Context context) {
        this.mContext = context;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this.mContext);
        this.mTrackSelector = defaultTrackSelector;
        defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setPreferredAudioLanguage("por"));
        this.mPlayer = new SimpleExoPlayer.Builder(this.mContext).setTrackSelector(this.mTrackSelector).build();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPlayer.addListener(new Player.EventListener() {
            public void onIsLoadingChanged(boolean z10) {
                if (!z10) {
                    ExoMediaPlayer exoMediaPlayer = ExoMediaPlayer.this;
                    exoMediaPlayer.notifyOnBufferingUpdate(exoMediaPlayer.mPlayer.getBufferedPercentage(), ExoMediaPlayer.this.mPlayer.getBufferedPosition());
                }
            }

            public void onIsPlayingChanged(boolean z10) {
            }

            public void onPlayWhenReadyChanged(boolean z10, int i10) {
            }

            public void onPlaybackStateChanged(int i10) {
                if (i10 == 2) {
                    ExoMediaPlayer.this.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_START, IMediaPlayer.MEDIA_INFO_BUFFERING_START);
                    boolean unused = ExoMediaPlayer.this.mIsBuffering = true;
                } else if (i10 == 3) {
                    if (ExoMediaPlayer.this.mIsBuffering) {
                        boolean unused2 = ExoMediaPlayer.this.mIsBuffering = false;
                        ExoMediaPlayer.this.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_END, IMediaPlayer.MEDIA_INFO_BUFFERING_END);
                    }
                    if (ExoMediaPlayer.this.mIsPreparing) {
                        boolean unused3 = ExoMediaPlayer.this.mIsPreparing = false;
                        ExoMediaPlayer.this.notifyOnPrepared();
                    }
                } else if (i10 == 4) {
                    if (ExoMediaPlayer.this.mIsBuffering) {
                        boolean unused4 = ExoMediaPlayer.this.mIsBuffering = false;
                        ExoMediaPlayer.this.notifyOnInfo(IMediaPlayer.MEDIA_INFO_BUFFERING_END, IMediaPlayer.MEDIA_INFO_BUFFERING_END);
                        return;
                    }
                    ExoMediaPlayer.this.stayAwake(false);
                    ExoMediaPlayer.this.notifyOnCompletion();
                }
            }

            public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                ExoMediaPlayer.this.notifyOnError(exoPlaybackException.type, exoPlaybackException.rendererFormatSupport);
                ExoMediaPlayer.this.stayAwake(false);
            }

            public void onPositionDiscontinuity(int i10) {
            }

            public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }
        });
        this.mPlayer.addAnalyticsListener(new AnalyticsListener() {
            public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i10, long j10) {
                Log.w("ExoMediaPlayer", "onDroppedVideoFrames:  droppedFrames: " + i10);
            }

            public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            }

            public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            }

            public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
                ExoMediaPlayer.this.notifyOnInfo(3, 3);
            }

            public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void stayAwake(boolean z10) {
        this.mStayAwake = z10;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        boolean z10;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            if (!this.mScreenOnWhilePlaying || !this.mStayAwake) {
                z10 = false;
            } else {
                z10 = true;
            }
            surfaceHolder.setKeepScreenOn(z10);
        }
    }

    public int getAudioSessionId() {
        return this.mPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return this.mPlayer.getCurrentPosition();
        }
        final AtomicLong atomicLong = new AtomicLong(-1);
        this.mHandler.post(new Runnable() {
            public void run() {
                atomicLong.set(ExoMediaPlayer.this.mPlayer.getCurrentPosition());
            }
        });
        do {
        } while (atomicLong.get() == -1);
        return atomicLong.get();
    }

    public String getDataSource() {
        return null;
    }

    public long getDuration() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return this.mPlayer.getDuration();
        }
        final AtomicLong atomicLong = new AtomicLong(-1);
        this.mHandler.post(new Runnable() {
            public void run() {
                atomicLong.set(ExoMediaPlayer.this.mPlayer.getDuration());
            }
        });
        do {
        } while (atomicLong.get() == -1);
        return atomicLong.get();
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mMediaPlayerName = "ExoPlayer";
        return mediaInfo;
    }

    public int getSelectedAudioTrack(int i10) {
        if (this.mPlayer.getAudioFormat() == null || this.mPlayer.getAudioFormat().id == null) {
            return -1;
        }
        return Integer.getInteger(this.mPlayer.getAudioFormat().id, -1).intValue() - 1;
    }

    public ITrackInfo[] getTrackInfo() {
        ArrayList arrayList = new ArrayList();
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.mTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null) {
            for (int i10 = 0; i10 < currentMappedTrackInfo.getRendererCount(); i10++) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i10);
                for (int i11 = 0; i11 < trackGroups.length; i11++) {
                    arrayList.add(new ExoTrackInfo(trackGroups.get(i11)));
                }
            }
        }
        if (arrayList.size() > 0) {
            return (ITrackInfo[]) arrayList.toArray(new ExoTrackInfo[0]);
        }
        return new ITrackInfo[0];
    }

    public int getVideoHeight() {
        if (this.mPlayer.getVideoFormat() == null) {
            return 0;
        }
        return this.mPlayer.getVideoFormat().height;
    }

    public int getVideoSarDen() {
        return 0;
    }

    public int getVideoSarNum() {
        return 0;
    }

    public int getVideoWidth() {
        if (this.mPlayer.getVideoFormat() == null) {
            return 0;
        }
        return this.mPlayer.getVideoFormat().width;
    }

    public boolean isLooping() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            final AtomicInteger atomicInteger = new AtomicInteger(-1);
            this.mHandler.post(new Runnable() {
                public void run() {
                    atomicInteger.set(ExoMediaPlayer.this.mPlayer.getRepeatMode());
                }
            });
            do {
            } while (atomicInteger.get() == -1);
            if (atomicInteger.get() == 2) {
                return true;
            }
            return false;
        } else if (this.mPlayer.getRepeatMode() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPlayable() {
        return true;
    }

    public boolean isPlaying() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return this.mPlayer.isPlaying();
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        this.mHandler.post(new Runnable() {
            public void run() {
                atomicBoolean2.set(ExoMediaPlayer.this.mPlayer.isPlaying());
                atomicBoolean.set(true);
            }
        });
        do {
        } while (!atomicBoolean.get());
        return atomicBoolean2.get();
    }

    public void pause() {
        stayAwake(false);
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.pause();
            }
        });
    }

    public void prepareAsync() {
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.setPlayWhenReady(true);
                ExoMediaPlayer.this.mPlayer.prepare();
            }
        });
    }

    public void release() {
        stayAwake(false);
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.release();
            }
        });
    }

    public void reset() {
        stayAwake(false);
    }

    public void seekTo(final long j10) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.seekTo(j10);
            }
        });
    }

    public void selectAudioTrack(String str) {
        DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
        defaultTrackSelector.setParameters(defaultTrackSelector.getParameters().buildUpon().setPreferredAudioLanguage(str));
    }

    public void setAudioStreamType(int i10) {
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            setSurface((Surface) null);
        } else {
            setSurface(surfaceHolder.getSurface());
        }
    }

    public void setKeepInBackground(boolean z10) {
    }

    public void setLogEnabled(boolean z10) {
    }

    public void setLooping(final boolean z10) {
        this.mHandler.post(new Runnable() {
            public void run() {
                int i10;
                SimpleExoPlayer access$000 = ExoMediaPlayer.this.mPlayer;
                if (z10) {
                    i10 = 2;
                } else {
                    i10 = 0;
                }
                access$000.setRepeatMode(i10);
            }
        });
    }

    public void setScreenOnWhilePlaying(boolean z10) {
        if (this.mScreenOnWhilePlaying != z10) {
            if (z10 && this.mSurfaceHolder == null) {
                Log.w("ExoMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z10;
            updateSurfaceScreenOn();
        }
    }

    public void setSurface(final Surface surface) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.setVideoSurface(surface);
            }
        });
    }

    public void setVolume(final float f10, float f11) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.setVolume(f10);
            }
        });
    }

    public void setWakeMode(Context context, int i10) {
    }

    public void start() {
        stayAwake(true);
        this.mPlayer.play();
    }

    public void stop() {
        stayAwake(false);
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.stop();
                ExoMediaPlayer.this.mPlayer.release();
                ExoMediaPlayer.this.mPlayer.setVideoSurface((Surface) null);
            }
        });
    }

    public void selectAudioTrack(int i10) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = this.mTrackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo != null) {
            int i11 = -1;
            int i12 = -1;
            for (int i13 = 0; i13 < currentMappedTrackInfo.getRendererCount(); i13++) {
                TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i13);
                int rendererType = currentMappedTrackInfo.getRendererType(i13);
                for (int i14 = 0; i14 < trackGroups.length; i14++) {
                    i12++;
                    if (1 == rendererType) {
                        i11++;
                        if (i10 == i12) {
                            break;
                        }
                    }
                }
            }
            TrackGroupArray trackGroups2 = currentMappedTrackInfo.getTrackGroups(1);
            DefaultTrackSelector.SelectionOverride selectionOverride = new DefaultTrackSelector.SelectionOverride(i11, new int[]{0});
            DefaultTrackSelector defaultTrackSelector = this.mTrackSelector;
            defaultTrackSelector.setParameters(defaultTrackSelector.getParameters().buildUpon().setSelectionOverride(1, trackGroups2, selectionOverride));
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
    }

    public void setDataSource(Context context, final Uri uri) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.setMediaItem(MediaItem.fromUri(uri));
            }
        });
    }

    public void setDataSource(final String str) {
        this.mHandler.post(new Runnable() {
            public void run() {
                ExoMediaPlayer.this.mPlayer.setMediaItem(MediaItem.fromUri(str));
            }
        });
    }
}
