package com.google.android.gms.cast.framework.media;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzbv extends ArrayAdapter<MediaTrack> implements View.OnClickListener {
    private final Context zza;
    private int zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbv(Context context, List<MediaTrack> list, int i10) {
        super(context, R.layout.cast_tracks_chooser_dialog_row_layout, list == null ? new ArrayList<>() : list);
        this.zza = context;
        this.zzb = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008c, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            r6 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0033
            android.content.Context r8 = r6.zza
            java.lang.String r1 = "layout_inflater"
            java.lang.Object r8 = r8.getSystemService(r1)
            android.view.LayoutInflater r8 = (android.view.LayoutInflater) r8
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            android.view.LayoutInflater r8 = (android.view.LayoutInflater) r8
            int r1 = com.google.android.gms.cast.framework.R.layout.cast_tracks_chooser_dialog_row_layout
            android.view.View r8 = r8.inflate(r1, r9, r0)
            com.google.android.gms.cast.framework.media.zzbu r9 = new com.google.android.gms.cast.framework.media.zzbu
            int r1 = com.google.android.gms.cast.framework.R.id.text
            android.view.View r1 = r8.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = com.google.android.gms.cast.framework.R.id.radio
            android.view.View r2 = r8.findViewById(r2)
            android.widget.RadioButton r2 = (android.widget.RadioButton) r2
            r3 = 0
            r9.<init>(r6, r1, r2, r3)
            r8.setTag(r9)
            goto L_0x003f
        L_0x0033:
            java.lang.Object r9 = r8.getTag()
            com.google.android.gms.cast.framework.media.zzbu r9 = (com.google.android.gms.cast.framework.media.zzbu) r9
            java.lang.Object r9 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            com.google.android.gms.cast.framework.media.zzbu r9 = (com.google.android.gms.cast.framework.media.zzbu) r9
        L_0x003f:
            android.widget.RadioButton r1 = r9.zzb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            r1.setTag(r2)
            android.widget.RadioButton r1 = r9.zzb
            int r2 = r6.zzb
            r3 = 1
            if (r2 != r7) goto L_0x0051
            r2 = 1
            goto L_0x0052
        L_0x0051:
            r2 = 0
        L_0x0052:
            r1.setChecked(r2)
            r8.setOnClickListener(r6)
            java.lang.Object r1 = r6.getItem(r7)
            com.google.android.gms.cast.MediaTrack r1 = (com.google.android.gms.cast.MediaTrack) r1
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.cast.MediaTrack r1 = (com.google.android.gms.cast.MediaTrack) r1
            java.lang.String r2 = r1.getName()
            java.util.Locale r4 = r1.getLanguageLocale()
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L_0x00a0
            int r1 = r1.getSubtype()
            r2 = 2
            if (r1 != r2) goto L_0x0082
            android.content.Context r7 = r6.zza
            int r0 = com.google.android.gms.cast.framework.R.string.cast_tracks_chooser_dialog_closed_captions
            java.lang.String r2 = r7.getString(r0)
            goto L_0x00a0
        L_0x0082:
            if (r4 == 0) goto L_0x008f
            java.lang.String r2 = r4.getDisplayLanguage()
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x008f
            goto L_0x00a0
        L_0x008f:
            android.content.Context r1 = r6.zza
            int r2 = com.google.android.gms.cast.framework.R.string.cast_tracks_chooser_dialog_default_track_name
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r7 = r7 + r3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r4[r0] = r7
            java.lang.String r2 = r1.getString(r2, r4)
        L_0x00a0:
            android.widget.TextView r7 = r9.zza
            r7.setText(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.zzbv.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void onClick(View view) {
        this.zzb = ((Integer) Preconditions.checkNotNull(((zzbu) Preconditions.checkNotNull((zzbu) view.getTag())).zzb.getTag())).intValue();
        notifyDataSetChanged();
    }

    public final MediaTrack zza() {
        int i10 = this.zzb;
        if (i10 < 0 || i10 >= getCount()) {
            return null;
        }
        return (MediaTrack) getItem(this.zzb);
    }
}
