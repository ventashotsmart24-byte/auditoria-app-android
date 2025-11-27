package l8;

import android.text.TextUtils;
import m8.d;
import t9.i;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18691a = new a();

    public final IMediaPlayer a(String str, boolean z10, int i10, boolean z11, String str2) {
        i.h(str, "defaultLanguage");
        IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
        IjkMediaPlayer.native_setLogLevel(6);
        if (i10 == 1) {
            ijkMediaPlayer.setOption(4, "mediacodec", 1);
            ijkMediaPlayer.setOption(4, "mediacodec-hevc", 1);
        }
        ijkMediaPlayer.setOption(4, "overlay-format", "fcc-_es2");
        ijkMediaPlayer.setOption(4, "opensles", 0);
        ijkMediaPlayer.setOption(1, "http-detect-range-support", 0);
        ijkMediaPlayer.setOption(2, "skip_loop_filter", 48);
        ijkMediaPlayer.setOption(4, "live-streaming", 1);
        ijkMediaPlayer.setOption(4, "delay-optimization", 1);
        ijkMediaPlayer.setOption(4, "start-on-prepared", 1);
        ijkMediaPlayer.setOption(4, "timeout", 20000);
        ijkMediaPlayer.setOption(4, "get-av-frame-timeout", 20000);
        if (!TextUtils.isEmpty(str)) {
            ijkMediaPlayer.setOption(4, "audio_language", str);
        }
        ijkMediaPlayer.setOption(1, "flush_packets", 1);
        ijkMediaPlayer.setOption(4, "framedrop", 1);
        ijkMediaPlayer.setOption(4, "render-wait-start", 1);
        ijkMediaPlayer.setOption(1, "reconnect", 1);
        ijkMediaPlayer.setOption(1, "reconnect_delay_max", 5);
        ijkMediaPlayer.setOption(1, "http_multiple", 0);
        ijkMediaPlayer.setOption(4, "max-buffer-audio-tracks", 4);
        if (z10) {
            ijkMediaPlayer.setOption(4, "live_mode", 1);
        }
        if (z11) {
            ijkMediaPlayer.setOption(4, "avio", 1);
            ijkMediaPlayer.setOption(4, "min-frames", 30);
        }
        if (d.b(str2)) {
            ijkMediaPlayer.setOption(4, "iformat", str2);
        }
        return ijkMediaPlayer;
    }
}
