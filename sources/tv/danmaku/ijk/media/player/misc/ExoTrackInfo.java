package tv.danmaku.ijk.media.player.misc;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.MimeTypes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Locale;

public class ExoTrackInfo implements ITrackInfo {
    private TrackGroup mTrackGroup;

    public ExoTrackInfo(TrackGroup trackGroup) {
        this.mTrackGroup = trackGroup;
    }

    public IMediaFormat getFormat() {
        return null;
    }

    public String getInfoInline() {
        return null;
    }

    public String getLanguage() {
        if (this.mTrackGroup.getFormat(0).language != null) {
            return new Locale(this.mTrackGroup.getFormat(0).language).getISO3Language();
        }
        return this.mTrackGroup.getFormat(0).language;
    }

    public int getTrackType() {
        String str = this.mTrackGroup.getFormat(0).sampleMimeType;
        if (MimeTypes.isVideo(str)) {
            return 1;
        }
        if (MimeTypes.isAudio(str)) {
            return 2;
        }
        return 0;
    }

    public String toString() {
        return "ExoTrackInfo{mTrackGroup.Format=" + this.mTrackGroup.getFormat(0).toString() + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
