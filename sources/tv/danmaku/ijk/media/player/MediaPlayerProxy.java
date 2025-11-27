package tv.danmaku.ijk.media.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

public class MediaPlayerProxy implements IMediaPlayer {
    protected final IMediaPlayer mBackEndMediaPlayer;

    public MediaPlayerProxy(IMediaPlayer iMediaPlayer) {
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    public int getAudioSessionId() {
        return this.mBackEndMediaPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        return this.mBackEndMediaPlayer.getCurrentPosition();
    }

    public String getDataSource() {
        return this.mBackEndMediaPlayer.getDataSource();
    }

    public long getDuration() {
        return this.mBackEndMediaPlayer.getDuration();
    }

    public IMediaPlayer getInternalMediaPlayer() {
        return this.mBackEndMediaPlayer;
    }

    public MediaInfo getMediaInfo() {
        return this.mBackEndMediaPlayer.getMediaInfo();
    }

    public ITrackInfo[] getTrackInfo() {
        return this.mBackEndMediaPlayer.getTrackInfo();
    }

    public int getVideoHeight() {
        return this.mBackEndMediaPlayer.getVideoHeight();
    }

    public int getVideoSarDen() {
        return this.mBackEndMediaPlayer.getVideoSarDen();
    }

    public int getVideoSarNum() {
        return this.mBackEndMediaPlayer.getVideoSarNum();
    }

    public int getVideoWidth() {
        return this.mBackEndMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mBackEndMediaPlayer.isLooping();
    }

    public boolean isPlayable() {
        return false;
    }

    public boolean isPlaying() {
        return this.mBackEndMediaPlayer.isPlaying();
    }

    public void pause() {
        this.mBackEndMediaPlayer.pause();
    }

    public void prepareAsync() {
        this.mBackEndMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mBackEndMediaPlayer.release();
    }

    public void reset() {
        this.mBackEndMediaPlayer.reset();
    }

    public void seekTo(long j10) {
        this.mBackEndMediaPlayer.seekTo(j10);
    }

    public void setAudioStreamType(int i10) {
        this.mBackEndMediaPlayer.setAudioStreamType(i10);
    }

    public void setDataSource(Context context, Uri uri) {
        this.mBackEndMediaPlayer.setDataSource(context, uri);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mBackEndMediaPlayer.setDisplay(surfaceHolder);
    }

    public void setKeepInBackground(boolean z10) {
        this.mBackEndMediaPlayer.setKeepInBackground(z10);
    }

    public void setLogEnabled(boolean z10) {
    }

    public void setLooping(boolean z10) {
        this.mBackEndMediaPlayer.setLooping(z10);
    }

    public void setOnBufferingUpdateListener(final IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        if (onBufferingUpdateListener != null) {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener() {
                public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10, long j10) {
                    onBufferingUpdateListener.onBufferingUpdate(MediaPlayerProxy.this, i10, j10);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnBufferingUpdateListener((IMediaPlayer.OnBufferingUpdateListener) null);
        }
    }

    public void setOnCompletionListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            this.mBackEndMediaPlayer.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
                public void onCompletion(IMediaPlayer iMediaPlayer) {
                    onCompletionListener.onCompletion(MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnCompletionListener((IMediaPlayer.OnCompletionListener) null);
        }
    }

    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener != null) {
            this.mBackEndMediaPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
                public boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                    return onErrorListener.onError(MediaPlayerProxy.this, i10, i11);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnErrorListener((IMediaPlayer.OnErrorListener) null);
        }
    }

    public void setOnInfoListener(final IMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener != null) {
            this.mBackEndMediaPlayer.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
                public boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11) {
                    return onInfoListener.onInfo(MediaPlayerProxy.this, i10, i11);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnInfoListener((IMediaPlayer.OnInfoListener) null);
        }
    }

    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        if (onPreparedListener != null) {
            this.mBackEndMediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
                public void onPrepared(IMediaPlayer iMediaPlayer) {
                    onPreparedListener.onPrepared(MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnPreparedListener((IMediaPlayer.OnPreparedListener) null);
        }
    }

    public void setOnReplayListener(final IMediaPlayer.OnReplayListener onReplayListener) {
        if (onReplayListener != null) {
            this.mBackEndMediaPlayer.setOnReplayListener(new IMediaPlayer.OnReplayListener() {
                public void onReplay(IMediaPlayer iMediaPlayer) {
                    onReplayListener.onReplay(MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnReplayListener((IMediaPlayer.OnReplayListener) null);
        }
    }

    public void setOnSeekCompleteListener(final IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener != null) {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener() {
                public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                    onSeekCompleteListener.onSeekComplete(MediaPlayerProxy.this);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnSeekCompleteListener((IMediaPlayer.OnSeekCompleteListener) null);
        }
    }

    public void setOnSeekListener(final IMediaPlayer.OnSeekListener onSeekListener) {
        if (onSeekListener != null) {
            this.mBackEndMediaPlayer.setOnSeekListener(new IMediaPlayer.OnSeekListener() {
                public void onSeek(IMediaPlayer iMediaPlayer, long j10) {
                    onSeekListener.onSeek(MediaPlayerProxy.this, j10);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnSeekListener((IMediaPlayer.OnSeekListener) null);
        }
    }

    public void setOnTimedTextListener(final IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        if (onTimedTextListener != null) {
            this.mBackEndMediaPlayer.setOnTimedTextListener(new IMediaPlayer.OnTimedTextListener() {
                public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
                    onTimedTextListener.onTimedText(MediaPlayerProxy.this, ijkTimedText);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnTimedTextListener((IMediaPlayer.OnTimedTextListener) null);
        }
    }

    public void setOnVideoSizeChangedListener(final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener != null) {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() {
                public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i10, int i11, int i12, int i13) {
                    onVideoSizeChangedListener.onVideoSizeChanged(MediaPlayerProxy.this, i10, i11, i12, i13);
                }
            });
        } else {
            this.mBackEndMediaPlayer.setOnVideoSizeChangedListener((IMediaPlayer.OnVideoSizeChangedListener) null);
        }
    }

    public void setScreenOnWhilePlaying(boolean z10) {
        this.mBackEndMediaPlayer.setScreenOnWhilePlaying(z10);
    }

    public void setSurface(Surface surface) {
        this.mBackEndMediaPlayer.setSurface(surface);
    }

    public void setVolume(float f10, float f11) {
        this.mBackEndMediaPlayer.setVolume(f10, f11);
    }

    public void setWakeMode(Context context, int i10) {
        this.mBackEndMediaPlayer.setWakeMode(context, i10);
    }

    public void start() {
        this.mBackEndMediaPlayer.start();
    }

    public void stop() {
        this.mBackEndMediaPlayer.stop();
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.mBackEndMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mBackEndMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) {
        this.mBackEndMediaPlayer.setDataSource(str);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mBackEndMediaPlayer.setDataSource(iMediaDataSource);
    }
}
