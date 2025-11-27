package com.mobile.brasiltv.mine.activity;

import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import e6.w0;
import f5.c;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class PlaylistActivity extends c {

    /* renamed from: m  reason: collision with root package name */
    public static final a f12379m = new a((g) null);

    /* renamed from: k  reason: collision with root package name */
    public final String f12380k = "PlaylistActivity";

    /* renamed from: l  reason: collision with root package name */
    public Map f12381l = new LinkedHashMap();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final void T2(PlaylistActivity playlistActivity, String str, View view) {
        i.g(playlistActivity, "this$0");
        b0.i(playlistActivity, String.valueOf(str));
        Display a10 = playlistActivity.getDisplay();
        i.d(a10);
        int height = a10.getHeight();
        f1.a aVar = f1.f12517a;
        String string = playlistActivity.getString(R.string.copy_success);
        i.f(string, "getString(R.string.copy_success)");
        aVar.n(playlistActivity, string, 0, 48, 0, height / 3);
    }

    public View S2(int i10) {
        Map map = this.f12381l;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_playlist);
        String stringExtra = getIntent().getStringExtra("url");
        ((TextView) S2(R$id.mTvPlaylistUrl)).setText(String.valueOf(stringExtra));
        ((TextView) S2(R$id.mButtonCopy)).setOnClickListener(new w0(this, stringExtra));
    }
}
