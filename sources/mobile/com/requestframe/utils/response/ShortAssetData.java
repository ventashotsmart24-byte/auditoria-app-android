package mobile.com.requestframe.utils.response;

import anet.channel.strategy.dispatch.DispatchConstants;
import ba.t;
import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.List;
import t9.i;

public final class ShortAssetData {
    private String actorDisplay;
    private String alias;
    private String contentId;
    private String description;
    private String director;
    private String name;
    private List<ShelvePoster> posterList;
    private String resourceId;
    private String tags;
    private List<ShortVideo> totalMovieList;
    private String type;

    public ShortAssetData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<ShortVideo> list, List<ShelvePoster> list2) {
        i.g(str, "contentId");
        i.g(str2, "name");
        i.g(str3, "alias");
        i.g(str4, "director");
        i.g(str5, "actorDisplay");
        i.g(str6, "tags");
        i.g(str8, "type");
        i.g(str9, MediaTrack.ROLE_DESCRIPTION);
        i.g(list, "totalMovieList");
        this.contentId = str;
        this.name = str2;
        this.alias = str3;
        this.director = str4;
        this.actorDisplay = str5;
        this.tags = str6;
        this.resourceId = str7;
        this.type = str8;
        this.description = str9;
        this.totalMovieList = list;
        this.posterList = list2;
    }

    public static /* synthetic */ ShortAssetData copy$default(ShortAssetData shortAssetData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, List list2, int i10, Object obj) {
        ShortAssetData shortAssetData2 = shortAssetData;
        int i11 = i10;
        return shortAssetData.copy((i11 & 1) != 0 ? shortAssetData2.contentId : str, (i11 & 2) != 0 ? shortAssetData2.name : str2, (i11 & 4) != 0 ? shortAssetData2.alias : str3, (i11 & 8) != 0 ? shortAssetData2.director : str4, (i11 & 16) != 0 ? shortAssetData2.actorDisplay : str5, (i11 & 32) != 0 ? shortAssetData2.tags : str6, (i11 & 64) != 0 ? shortAssetData2.resourceId : str7, (i11 & 128) != 0 ? shortAssetData2.type : str8, (i11 & 256) != 0 ? shortAssetData2.description : str9, (i11 & 512) != 0 ? shortAssetData2.totalMovieList : list, (i11 & 1024) != 0 ? shortAssetData2.posterList : list2);
    }

    private final String getMediaCode(String str) {
        String str2;
        try {
            int y10 = t.y(str, "media_code", 0, false, 6, (Object) null);
            if (y10 == -1) {
                return "";
            }
            int y11 = t.y(str, Operator.Operation.EQUALS, y10, false, 4, (Object) null);
            int y12 = t.y(str, DispatchConstants.SIGN_SPLIT_SYMBOL, y10, false, 4, (Object) null);
            if (y11 == -1) {
                return "";
            }
            if (y12 == -1) {
                str2 = str.substring(y11 + 1);
                i.f(str2, "this as java.lang.String).substring(startIndex)");
            } else {
                str2 = str.substring(y11 + 1, y12);
                i.f(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            return str2;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final String component1() {
        return this.contentId;
    }

    public final List<ShortVideo> component10() {
        return this.totalMovieList;
    }

    public final List<ShelvePoster> component11() {
        return this.posterList;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.alias;
    }

    public final String component4() {
        return this.director;
    }

    public final String component5() {
        return this.actorDisplay;
    }

    public final String component6() {
        return this.tags;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.type;
    }

    public final String component9() {
        return this.description;
    }

    public final ShortAssetData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<ShortVideo> list, List<ShelvePoster> list2) {
        i.g(str, "contentId");
        i.g(str2, "name");
        String str10 = str3;
        i.g(str10, "alias");
        String str11 = str4;
        i.g(str11, "director");
        String str12 = str5;
        i.g(str12, "actorDisplay");
        String str13 = str6;
        i.g(str13, "tags");
        String str14 = str8;
        i.g(str14, "type");
        String str15 = str9;
        i.g(str15, MediaTrack.ROLE_DESCRIPTION);
        List<ShortVideo> list3 = list;
        i.g(list3, "totalMovieList");
        return new ShortAssetData(str, str2, str10, str11, str12, str13, str7, str14, str15, list3, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortAssetData)) {
            return false;
        }
        ShortAssetData shortAssetData = (ShortAssetData) obj;
        return i.b(this.contentId, shortAssetData.contentId) && i.b(this.name, shortAssetData.name) && i.b(this.alias, shortAssetData.alias) && i.b(this.director, shortAssetData.director) && i.b(this.actorDisplay, shortAssetData.actorDisplay) && i.b(this.tags, shortAssetData.tags) && i.b(this.resourceId, shortAssetData.resourceId) && i.b(this.type, shortAssetData.type) && i.b(this.description, shortAssetData.description) && i.b(this.totalMovieList, shortAssetData.totalMovieList) && i.b(this.posterList, shortAssetData.posterList);
    }

    public final String getActorDisplay() {
        return this.actorDisplay;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDirector() {
        return this.director;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlayUrl(String str) {
        boolean z10;
        boolean z11;
        i.g(str, "svs_address");
        List<ShortVideo> list = this.totalMovieList;
        boolean z12 = true;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "";
        }
        List<ShortMovie> movieList = this.totalMovieList.get(0).getMovieList();
        if (movieList == null || movieList.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "";
        }
        List<License> licenseList = this.totalMovieList.get(0).getMovieList().get(0).getLicenseList();
        if (licenseList != null && !licenseList.isEmpty()) {
            z12 = false;
        }
        if (z12) {
            return "";
        }
        String license = this.totalMovieList.get(0).getMovieList().get(0).getLicenseList().get(0).getLicense();
        return "http://" + str + "/media/" + getMediaCode(license) + '?' + license;
    }

    public final List<ShelvePoster> getPosterList() {
        return this.posterList;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getTags() {
        return this.tags;
    }

    public final List<ShortVideo> getTotalMovieList() {
        return this.totalMovieList;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.contentId.hashCode() * 31) + this.name.hashCode()) * 31) + this.alias.hashCode()) * 31) + this.director.hashCode()) * 31) + this.actorDisplay.hashCode()) * 31) + this.tags.hashCode()) * 31;
        String str = this.resourceId;
        int i10 = 0;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.description.hashCode()) * 31) + this.totalMovieList.hashCode()) * 31;
        List<ShelvePoster> list = this.posterList;
        if (list != null) {
            i10 = list.hashCode();
        }
        return hashCode2 + i10;
    }

    public final void setActorDisplay(String str) {
        i.g(str, "<set-?>");
        this.actorDisplay = str;
    }

    public final void setAlias(String str) {
        i.g(str, "<set-?>");
        this.alias = str;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setDescription(String str) {
        i.g(str, "<set-?>");
        this.description = str;
    }

    public final void setDirector(String str) {
        i.g(str, "<set-?>");
        this.director = str;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setPosterList(List<ShelvePoster> list) {
        this.posterList = list;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setTags(String str) {
        i.g(str, "<set-?>");
        this.tags = str;
    }

    public final void setTotalMovieList(List<ShortVideo> list) {
        i.g(list, "<set-?>");
        this.totalMovieList = list;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "ShortAssetData(contentId=" + this.contentId + ", name=" + this.name + ", alias=" + this.alias + ", director=" + this.director + ", actorDisplay=" + this.actorDisplay + ", tags=" + this.tags + ", resourceId=" + this.resourceId + ", type=" + this.type + ", description=" + this.description + ", totalMovieList=" + this.totalMovieList + ", posterList=" + this.posterList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
