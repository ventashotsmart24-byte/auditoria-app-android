package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

public final class GetItemDataResultData implements Serializable {
    private AssetData assetData;

    public GetItemDataResultData(AssetData assetData2) {
        i.g(assetData2, "assetData");
        this.assetData = assetData2;
    }

    public static /* synthetic */ GetItemDataResultData copy$default(GetItemDataResultData getItemDataResultData, AssetData assetData2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            assetData2 = getItemDataResultData.assetData;
        }
        return getItemDataResultData.copy(assetData2);
    }

    public final AssetData component1() {
        return this.assetData;
    }

    public final GetItemDataResultData copy(AssetData assetData2) {
        i.g(assetData2, "assetData");
        return new GetItemDataResultData(assetData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetItemDataResultData) && i.b(this.assetData, ((GetItemDataResultData) obj).assetData);
    }

    public final AssetData getAssetData() {
        return this.assetData;
    }

    public int hashCode() {
        return this.assetData.hashCode();
    }

    public final void setAssetData(AssetData assetData2) {
        i.g(assetData2, "<set-?>");
        this.assetData = assetData2;
    }

    public String toString() {
        return "GetItemDataResultData(assetData=" + this.assetData + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
