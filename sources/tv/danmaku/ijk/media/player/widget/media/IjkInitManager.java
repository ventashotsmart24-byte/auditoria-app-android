package tv.danmaku.ijk.media.player.widget.media;

import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.ijk.media.player.IjkLibLoader;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class IjkInitManager {
    private static final String TAG = "IjkInitManager";
    private static volatile IjkInitManager ourInstance;
    private AtomicInteger initCount = new AtomicInteger(0);

    private IjkInitManager() {
    }

    public static IjkInitManager getInstance() {
        if (ourInstance == null) {
            synchronized (IjkInitManager.class) {
                if (ourInstance == null) {
                    ourInstance = new IjkInitManager();
                }
            }
        }
        return ourInstance;
    }

    public void endIjk() {
        if (this.initCount.decrementAndGet() == 0) {
            IjkMediaPlayer.native_profileEnd();
        }
    }

    public void initIjk() {
        if (this.initCount.getAndIncrement() == 0) {
            IjkMediaPlayer.loadLibrariesOnce((IjkLibLoader) null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        }
    }
}
