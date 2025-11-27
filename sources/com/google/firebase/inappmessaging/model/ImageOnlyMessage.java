package com.google.firebase.inappmessaging.model;

import java.util.Map;
import javax.annotation.Nullable;

public class ImageOnlyMessage extends InAppMessage {
    @Nullable
    private Action action;
    private ImageData imageData;

    public static class Builder {
        @Nullable
        Action action;
        @Nullable
        ImageData imageData;

        public ImageOnlyMessage build(CampaignMetadata campaignMetadata, @Nullable Map<String, String> map) {
            ImageData imageData2 = this.imageData;
            if (imageData2 != null) {
                return new ImageOnlyMessage(campaignMetadata, imageData2, this.action, map);
            }
            throw new IllegalArgumentException("ImageOnly model must have image data");
        }

        public Builder setAction(@Nullable Action action2) {
            this.action = action2;
            return this;
        }

        public Builder setImageData(@Nullable ImageData imageData2) {
            this.imageData = imageData2;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageOnlyMessage)) {
            return false;
        }
        ImageOnlyMessage imageOnlyMessage = (ImageOnlyMessage) obj;
        if (hashCode() != imageOnlyMessage.hashCode()) {
            return false;
        }
        Action action2 = this.action;
        if ((action2 != null || imageOnlyMessage.action == null) && ((action2 == null || action2.equals(imageOnlyMessage.action)) && this.imageData.equals(imageOnlyMessage.imageData))) {
            return true;
        }
        return false;
    }

    @Nullable
    public Action getAction() {
        return this.action;
    }

    public ImageData getImageData() {
        return this.imageData;
    }

    public int hashCode() {
        int i10;
        Action action2 = this.action;
        if (action2 != null) {
            i10 = action2.hashCode();
        } else {
            i10 = 0;
        }
        return this.imageData.hashCode() + i10;
    }

    private ImageOnlyMessage(CampaignMetadata campaignMetadata, ImageData imageData2, @Nullable Action action2, @Nullable Map<String, String> map) {
        super(campaignMetadata, MessageType.IMAGE_ONLY, map);
        this.imageData = imageData2;
        this.action = action2;
    }
}
