package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import java.util.Map;

public class CardMessage extends InAppMessage {
    private final String backgroundHexColor;
    private final Text body;
    private final ImageData landscapeImageData;
    private final ImageData portraitImageData;
    private final Action primaryAction;
    private final Action secondaryAction;
    private final Text title;

    public static class Builder {
        String backgroundHexColor;
        Text body;
        ImageData landscapeImageData;
        ImageData portraitImageData;
        Action primaryAction;
        Action secondaryAction;
        Text title;

        public CardMessage build(CampaignMetadata campaignMetadata, Map<String, String> map) {
            Action action = this.primaryAction;
            if (action == null) {
                throw new IllegalArgumentException("Card model must have a primary action");
            } else if (action.getButton() != null) {
                Action action2 = this.secondaryAction;
                if (action2 != null && action2.getButton() == null) {
                    throw new IllegalArgumentException("Card model secondary action must be null or have a button");
                } else if (this.title == null) {
                    throw new IllegalArgumentException("Card model must have a title");
                } else if (this.portraitImageData == null && this.landscapeImageData == null) {
                    throw new IllegalArgumentException("Card model must have at least one image");
                } else if (!TextUtils.isEmpty(this.backgroundHexColor)) {
                    return new CardMessage(campaignMetadata, this.title, this.body, this.portraitImageData, this.landscapeImageData, this.backgroundHexColor, this.primaryAction, this.secondaryAction, map);
                } else {
                    throw new IllegalArgumentException("Card model must have a background color");
                }
            } else {
                throw new IllegalArgumentException("Card model must have a primary action button");
            }
        }

        public Builder setBackgroundHexColor(String str) {
            this.backgroundHexColor = str;
            return this;
        }

        public Builder setBody(Text text) {
            this.body = text;
            return this;
        }

        public Builder setLandscapeImageData(ImageData imageData) {
            this.landscapeImageData = imageData;
            return this;
        }

        public Builder setPortraitImageData(ImageData imageData) {
            this.portraitImageData = imageData;
            return this;
        }

        public Builder setPrimaryAction(Action action) {
            this.primaryAction = action;
            return this;
        }

        public Builder setSecondaryAction(Action action) {
            this.secondaryAction = action;
            return this;
        }

        public Builder setTitle(Text text) {
            this.title = text;
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
        if (!(obj instanceof CardMessage)) {
            return false;
        }
        CardMessage cardMessage = (CardMessage) obj;
        if (hashCode() != cardMessage.hashCode()) {
            return false;
        }
        Text text = this.body;
        if ((text == null && cardMessage.body != null) || (text != null && !text.equals(cardMessage.body))) {
            return false;
        }
        Action action = this.secondaryAction;
        if ((action == null && cardMessage.secondaryAction != null) || (action != null && !action.equals(cardMessage.secondaryAction))) {
            return false;
        }
        ImageData imageData = this.portraitImageData;
        if ((imageData == null && cardMessage.portraitImageData != null) || (imageData != null && !imageData.equals(cardMessage.portraitImageData))) {
            return false;
        }
        ImageData imageData2 = this.landscapeImageData;
        if ((imageData2 != null || cardMessage.landscapeImageData == null) && ((imageData2 == null || imageData2.equals(cardMessage.landscapeImageData)) && this.title.equals(cardMessage.title) && this.primaryAction.equals(cardMessage.primaryAction) && this.backgroundHexColor.equals(cardMessage.backgroundHexColor))) {
            return true;
        }
        return false;
    }

    @Deprecated
    public Action getAction() {
        return this.primaryAction;
    }

    public String getBackgroundHexColor() {
        return this.backgroundHexColor;
    }

    public Text getBody() {
        return this.body;
    }

    @Deprecated
    public ImageData getImageData() {
        return this.portraitImageData;
    }

    public ImageData getLandscapeImageData() {
        return this.landscapeImageData;
    }

    public ImageData getPortraitImageData() {
        return this.portraitImageData;
    }

    public Action getPrimaryAction() {
        return this.primaryAction;
    }

    public Action getSecondaryAction() {
        return this.secondaryAction;
    }

    public Text getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        Text text = this.body;
        int i13 = 0;
        if (text != null) {
            i10 = text.hashCode();
        } else {
            i10 = 0;
        }
        Action action = this.secondaryAction;
        if (action != null) {
            i11 = action.hashCode();
        } else {
            i11 = 0;
        }
        ImageData imageData = this.portraitImageData;
        if (imageData != null) {
            i12 = imageData.hashCode();
        } else {
            i12 = 0;
        }
        ImageData imageData2 = this.landscapeImageData;
        if (imageData2 != null) {
            i13 = imageData2.hashCode();
        }
        return this.title.hashCode() + i10 + this.backgroundHexColor.hashCode() + this.primaryAction.hashCode() + i11 + i12 + i13;
    }

    private CardMessage(CampaignMetadata campaignMetadata, Text text, Text text2, ImageData imageData, ImageData imageData2, String str, Action action, Action action2, Map<String, String> map) {
        super(campaignMetadata, MessageType.CARD, map);
        this.title = text;
        this.body = text2;
        this.portraitImageData = imageData;
        this.landscapeImageData = imageData2;
        this.backgroundHexColor = str;
        this.primaryAction = action;
        this.secondaryAction = action2;
    }
}
