package com.google.android.gms.cast.framework.media.widget;

import android.widget.ImageView;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;

public interface ControlButtonsContainer {
    @RecentlyNonNull
    ImageView getButtonImageViewAt(int i10);

    int getButtonSlotCount();

    int getButtonTypeAt(int i10);

    @RecentlyNullable
    UIMediaController getUIMediaController();
}
