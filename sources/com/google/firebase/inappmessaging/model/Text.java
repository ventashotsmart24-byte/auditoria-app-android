package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;

public class Text {
    private final String hexColor;
    private final String text;

    public static class Builder {
        private String hexColor;
        private String text;

        public Text build() {
            if (!TextUtils.isEmpty(this.hexColor)) {
                return new Text(this.text, this.hexColor);
            }
            throw new IllegalArgumentException("Text model must have a color");
        }

        public Builder setHexColor(String str) {
            this.hexColor = str;
            return this;
        }

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        public Builder setText(MessagesProto.Text text2) {
            setText(text2.getText());
            setHexColor(text2.getHexColor());
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
        if (!(obj instanceof Text)) {
            return false;
        }
        Text text2 = (Text) obj;
        if (hashCode() != text2.hashCode()) {
            return false;
        }
        String str = this.text;
        if ((str != null || text2.text == null) && ((str == null || str.equals(text2.text)) && this.hexColor.equals(text2.hexColor))) {
            return true;
        }
        return false;
    }

    public String getHexColor() {
        return this.hexColor;
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode() + this.hexColor.hashCode();
        }
        return this.hexColor.hashCode();
    }

    private Text(String str, String str2) {
        this.text = str;
        this.hexColor = str2;
    }
}
