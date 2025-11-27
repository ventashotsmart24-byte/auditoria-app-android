package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TabHost;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.d;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TracksChooserDialogFragment extends d {
    boolean zza;
    List<MediaTrack> zzb;
    List<MediaTrack> zzc;
    private long[] zzd;
    /* access modifiers changed from: private */
    public Dialog zze;
    private RemoteMediaClient zzf;
    private MediaInfo zzg;
    private long[] zzh;

    @Deprecated
    public TracksChooserDialogFragment() {
    }

    @RecentlyNonNull
    public static TracksChooserDialogFragment newInstance() {
        return new TracksChooserDialogFragment();
    }

    public static /* bridge */ /* synthetic */ void zzc(TracksChooserDialogFragment tracksChooserDialogFragment, zzbv zzbv, zzbv zzbv2) {
        if (!tracksChooserDialogFragment.zza) {
            tracksChooserDialogFragment.zzf();
            return;
        }
        RemoteMediaClient remoteMediaClient = (RemoteMediaClient) Preconditions.checkNotNull(tracksChooserDialogFragment.zzf);
        if (!remoteMediaClient.hasMediaSession()) {
            tracksChooserDialogFragment.zzf();
            return;
        }
        ArrayList arrayList = new ArrayList();
        MediaTrack zza2 = zzbv.zza();
        if (!(zza2 == null || zza2.getId() == -1)) {
            arrayList.add(Long.valueOf(zza2.getId()));
        }
        MediaTrack zza3 = zzbv2.zza();
        if (zza3 != null) {
            arrayList.add(Long.valueOf(zza3.getId()));
        }
        long[] jArr = tracksChooserDialogFragment.zzd;
        if (jArr != null && jArr.length > 0) {
            HashSet hashSet = new HashSet();
            for (MediaTrack id : tracksChooserDialogFragment.zzc) {
                hashSet.add(Long.valueOf(id.getId()));
            }
            for (MediaTrack id2 : tracksChooserDialogFragment.zzb) {
                hashSet.add(Long.valueOf(id2.getId()));
            }
            for (long valueOf : jArr) {
                Long valueOf2 = Long.valueOf(valueOf);
                if (!hashSet.contains(valueOf2)) {
                    arrayList.add(valueOf2);
                }
            }
        }
        long[] jArr2 = new long[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            jArr2[i10] = ((Long) arrayList.get(i10)).longValue();
        }
        Arrays.sort(jArr2);
        remoteMediaClient.setActiveMediaTracks(jArr2);
        tracksChooserDialogFragment.zzf();
    }

    private static int zzd(List<MediaTrack> list, long[] jArr, int i10) {
        if (!(jArr == null || list == null)) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                for (long j10 : jArr) {
                    if (j10 == list.get(i11).getId()) {
                        return i11;
                    }
                }
            }
        }
        return i10;
    }

    private static ArrayList<MediaTrack> zze(List<MediaTrack> list, int i10) {
        ArrayList<MediaTrack> arrayList = new ArrayList<>();
        for (MediaTrack next : list) {
            if (next.getType() == i10) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final void zzf() {
        Dialog dialog = this.zze;
        if (dialog != null) {
            dialog.cancel();
            this.zze = null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zza = true;
        this.zzc = new ArrayList();
        this.zzb = new ArrayList();
        this.zzd = new long[0];
        CastSession currentCastSession = CastContext.getSharedInstance(getContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            this.zza = false;
            return;
        }
        RemoteMediaClient remoteMediaClient = currentCastSession.getRemoteMediaClient();
        this.zzf = remoteMediaClient;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || this.zzf.getMediaInfo() == null) {
            this.zza = false;
            return;
        }
        RemoteMediaClient remoteMediaClient2 = this.zzf;
        long[] jArr = this.zzh;
        if (jArr != null) {
            this.zzd = jArr;
        } else {
            MediaStatus mediaStatus = remoteMediaClient2.getMediaStatus();
            if (mediaStatus != null) {
                this.zzd = mediaStatus.getActiveTrackIds();
            }
        }
        MediaInfo mediaInfo = this.zzg;
        if (mediaInfo == null) {
            mediaInfo = remoteMediaClient2.getMediaInfo();
        }
        if (mediaInfo == null) {
            this.zza = false;
            return;
        }
        List<MediaTrack> mediaTracks = mediaInfo.getMediaTracks();
        if (mediaTracks == null) {
            this.zza = false;
            return;
        }
        this.zzc = zze(mediaTracks, 2);
        ArrayList<MediaTrack> zze2 = zze(mediaTracks, 1);
        this.zzb = zze2;
        if (!zze2.isEmpty()) {
            List<MediaTrack> list = this.zzb;
            MediaTrack.Builder builder = new MediaTrack.Builder(-1, 1);
            builder.setName(getActivity().getString(R.string.cast_tracks_chooser_dialog_none));
            builder.setSubtype(2);
            builder.setContentId("");
            list.add(0, builder.build());
        }
    }

    @RecentlyNonNull
    public Dialog onCreateDialog(Bundle bundle) {
        int zzd2 = zzd(this.zzb, this.zzd, 0);
        int zzd3 = zzd(this.zzc, this.zzd, -1);
        zzbv zzbv = new zzbv(getActivity(), this.zzb, zzd2);
        zzbv zzbv2 = new zzbv(getActivity(), this.zzc, zzd3);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.cast_tracks_chooser_dialog_layout, (ViewGroup) null);
        int i10 = R.id.text_list_view;
        ListView listView = (ListView) inflate.findViewById(i10);
        int i11 = R.id.audio_list_view;
        ListView listView2 = (ListView) inflate.findViewById(i11);
        TabHost tabHost = (TabHost) inflate.findViewById(R.id.tab_host);
        tabHost.setup();
        if (zzbv.getCount() == 0) {
            listView.setVisibility(4);
        } else {
            listView.setAdapter(zzbv);
            TabHost.TabSpec newTabSpec = tabHost.newTabSpec("textTab");
            newTabSpec.setContent(i10);
            newTabSpec.setIndicator(getActivity().getString(R.string.cast_tracks_chooser_dialog_subtitles));
            tabHost.addTab(newTabSpec);
        }
        if (zzbv2.getCount() <= 1) {
            listView2.setVisibility(4);
        } else {
            listView2.setAdapter(zzbv2);
            TabHost.TabSpec newTabSpec2 = tabHost.newTabSpec("audioTab");
            newTabSpec2.setContent(i11);
            newTabSpec2.setIndicator(getActivity().getString(R.string.cast_tracks_chooser_dialog_audio));
            tabHost.addTab(newTabSpec2);
        }
        builder.setView(inflate).setPositiveButton(getActivity().getString(R.string.cast_tracks_chooser_dialog_ok), new zzbs(this, zzbv, zzbv2)).setNegativeButton(R.string.cast_tracks_chooser_dialog_cancel, new zzbr(this));
        Dialog dialog = this.zze;
        if (dialog != null) {
            dialog.cancel();
            this.zze = null;
        }
        AlertDialog create = builder.create();
        this.zze = create;
        return create;
    }

    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage((Message) null);
        }
        super.onDestroyView();
    }

    private TracksChooserDialogFragment(MediaInfo mediaInfo, long[] jArr) {
        this.zzg = mediaInfo;
        this.zzh = jArr;
    }

    @RecentlyNonNull
    @Deprecated
    public static TracksChooserDialogFragment newInstance(@RecentlyNonNull MediaInfo mediaInfo, @RecentlyNonNull long[] jArr) {
        return new TracksChooserDialogFragment(mediaInfo, jArr);
    }
}
