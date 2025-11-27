package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

public final class SubData {
    private final List<SubItem> file;
    private String language;

    public SubData(List<SubItem> list, String str) {
        this.file = list;
        this.language = str;
    }

    public static /* synthetic */ SubData copy$default(SubData subData, List<SubItem> list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = subData.file;
        }
        if ((i10 & 2) != 0) {
            str = subData.language;
        }
        return subData.copy(list, str);
    }

    public final List<SubItem> component1() {
        return this.file;
    }

    public final String component2() {
        return this.language;
    }

    public final SubData copy(List<SubItem> list, String str) {
        return new SubData(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubData)) {
            return false;
        }
        SubData subData = (SubData) obj;
        return i.b(this.file, subData.file) && i.b(this.language, subData.language);
    }

    public final List<SubItem> getFile() {
        return this.file;
    }

    public final String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        List<SubItem> list = this.file;
        int i10 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.language;
        if (str != null) {
            i10 = str.hashCode();
        }
        return hashCode + i10;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public String toString() {
        return "SubData(file=" + this.file + ", language=" + this.language + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
