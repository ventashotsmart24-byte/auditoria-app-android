package anet.channel;

import android.content.Intent;

public interface ISessionListener {
    void onConnectionChanged(Intent intent);
}
