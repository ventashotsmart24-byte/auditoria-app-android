package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.firebase.inappmessaging.MessagesProto;
import com.google.firebase.inappmessaging.model.Button;

public class Action {
    private final String actionUrl;
    private final Button button;

    public static class Builder {
        private String actionUrl;
        private Button button;

        public Action build() {
            return new Action(this.actionUrl, this.button);
        }

        public Builder setActionUrl(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.actionUrl = str;
            }
            return this;
        }

        public Builder setButton(Button button2) {
            this.button = button2;
            return this;
        }

        public Builder setButton(MessagesProto.Button button2) {
            Button.Builder builder = new Button.Builder();
            builder.setButtonHexColor(button2.getButtonHexColor());
            builder.setText(button2.getText());
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
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        if (hashCode() != action.hashCode()) {
            return false;
        }
        String str = this.actionUrl;
        if ((str == null && action.actionUrl != null) || (str != null && !str.equals(action.actionUrl))) {
            return false;
        }
        Button button2 = this.button;
        if ((button2 != null || action.button != null) && (button2 == null || !button2.equals(action.button))) {
            return false;
        }
        return true;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public Button getButton() {
        return this.button;
    }

    public int hashCode() {
        int i10;
        String str = this.actionUrl;
        int i11 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        Button button2 = this.button;
        if (button2 != null) {
            i11 = button2.hashCode();
        }
        return i10 + i11;
    }

    private Action(String str, Button button2) {
        this.actionUrl = str;
        this.button = button2;
    }
}
