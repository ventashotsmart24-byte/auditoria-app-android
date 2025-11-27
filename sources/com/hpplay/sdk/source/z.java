package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.bean.AudioFrameBean;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.VideoFrameBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

public interface z extends IInterface {

    public static abstract class a extends Binder implements z {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.SDKInterface";
        static final int TRANSACTION_addFavoriteDevice = 59;
        static final int TRANSACTION_addPinCodeToLelinkServiceInfo = 36;
        static final int TRANSACTION_addQRCodeToLelinkServiceInfo = 35;
        static final int TRANSACTION_addVolume = 24;
        static final int TRANSACTION_appendPlayList = 55;
        static final int TRANSACTION_browse = 12;
        static final int TRANSACTION_canPlayLocalMedia = 39;
        static final int TRANSACTION_canPlayScreen = 38;
        static final int TRANSACTION_clearPlayList = 56;
        static final int TRANSACTION_connect = 15;
        static final int TRANSACTION_createPinCode = 33;
        static final int TRANSACTION_createShortUrl = 34;
        static final int TRANSACTION_disconnect = 16;
        static final int TRANSACTION_getConnectInfos = 17;
        static final int TRANSACTION_getFavoriteDeviceList = 61;
        static final int TRANSACTION_getHistoryDeviceList = 64;
        static final int TRANSACTION_getOption = 46;
        static final int TRANSACTION_getSDKInfos = 50;
        static final int TRANSACTION_initSdkWithUserId = 1;
        static final int TRANSACTION_multiMirrorControl = 47;
        static final int TRANSACTION_multiPushControl = 48;
        static final int TRANSACTION_pause = 23;
        static final int TRANSACTION_removeFavoriteDevice = 60;
        static final int TRANSACTION_removeHistoryDevice = 65;
        static final int TRANSACTION_resume = 22;
        static final int TRANSACTION_seekTo = 13;
        static final int TRANSACTION_setAuthListener = 30;
        static final int TRANSACTION_setCloudMirrorPlayListener = 49;
        static final int TRANSACTION_setCommonListener = 53;
        static final int TRANSACTION_setConnectStatusListener = 9;
        static final int TRANSACTION_setCreatePinCodeListener = 31;
        static final int TRANSACTION_setCreateShortUrlListener = 32;
        static final int TRANSACTION_setDaPlayListenerListener = 8;
        static final int TRANSACTION_setDebugAVListener = 5;
        static final int TRANSACTION_setDebugMode = 2;
        static final int TRANSACTION_setDebugTimestamp = 3;
        static final int TRANSACTION_setFavoriteDeviceAlias = 62;
        static final int TRANSACTION_setFavoriteDeviceListener = 58;
        static final int TRANSACTION_setHistoryDeviceListener = 63;
        static final int TRANSACTION_setLelinkPlayListenerListener = 6;
        static final int TRANSACTION_setLelinkServiceInfoListener = 4;
        static final int TRANSACTION_setLelinkServiceInfoOption = 29;
        static final int TRANSACTION_setLogCallback = 51;
        static final int TRANSACTION_setMirrorChangeListener = 52;
        static final int TRANSACTION_setNewPlayListenerListener = 7;
        static final int TRANSACTION_setOption = 28;
        static final int TRANSACTION_setReceiverPropertiesCallback = 66;
        static final int TRANSACTION_setRelevantInfoListener = 40;
        static final int TRANSACTION_setSearchBannerDataCallback = 45;
        static final int TRANSACTION_setSendPassCallback = 57;
        static final int TRANSACTION_setServiceInfoListParseListener = 11;
        static final int TRANSACTION_setServiceInfoParseListener = 10;
        static final int TRANSACTION_setSinkKeyEventListener = 43;
        static final int TRANSACTION_setSinkTouchEventListener = 44;
        static final int TRANSACTION_setSystemApp = 37;
        static final int TRANSACTION_setVolume = 26;
        static final int TRANSACTION_startMirrorForPlayerInfo = 21;
        static final int TRANSACTION_startOnlineCheck = 54;
        static final int TRANSACTION_startPlayMedia = 18;
        static final int TRANSACTION_startPlayMediaForPlayerInfo = 19;
        static final int TRANSACTION_startPlayMediaImmed = 20;
        static final int TRANSACTION_stopBrowse = 14;
        static final int TRANSACTION_stopPlay = 27;
        static final int TRANSACTION_subVolume = 25;
        static final int TRANSACTION_updateAudioData = 41;
        static final int TRANSACTION_updateVideoData = 42;

        /* renamed from: com.hpplay.sdk.source.z$a$a  reason: collision with other inner class name */
        public static class C0183a implements z {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11921a;

            public C0183a(IBinder iBinder) {
                this.f11921a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addPinCodeToLelinkServiceInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f11921a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addQRCodeToLelinkServiceInfo(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f11921a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void addVolume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeTypedArray(dramaInfoBeanArr, 0);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    this.f11921a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f11921a;
            }

            public void browse(boolean z10, boolean z11) {
                int i10;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    int i11 = 1;
                    if (z10) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    obtain.writeInt(i10);
                    if (!z11) {
                        i11 = 0;
                    }
                    obtain.writeInt(i11);
                    this.f11921a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    boolean z10 = true;
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    boolean z10 = true;
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearPlayList() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void connect(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void createPinCode() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void createShortUrl() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean disconnect(LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    boolean z10 = true;
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<LelinkServiceInfo> getConnectInfos() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(LelinkServiceInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getFavoriteDeviceList(int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f11921a.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getHistoryDeviceList(int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f11921a.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getOption(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f11921a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getSDKInfos(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f11921a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void initSdkWithUserId(String str, String str2, String str3, String str4, String str5) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    this.f11921a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list) {
                int i10;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (z10) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    obtain.writeInt(i10);
                    obtain.writeTypedList(list);
                    this.f11921a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10) {
                int i11;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (z10) {
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    obtain.writeInt(i11);
                    obtain.writeTypedList(list);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    this.f11921a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeFavoriteDevice(List<LelinkServiceInfo> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    this.f11921a.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeHistoryDevice(List<LelinkServiceInfo> list, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    obtain.writeInt(i10);
                    this.f11921a.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void seekTo(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f11921a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAuthListener(a aVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (aVar != null) {
                        iBinder = aVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCloudMirrorPlayListener(c cVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (cVar != null) {
                        iBinder = cVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCommonListener(d dVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (dVar != null) {
                        iBinder = dVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setConnectStatusListener(e eVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (eVar != null) {
                        iBinder = eVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCreatePinCodeListener(f fVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCreateShortUrlListener(g gVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (gVar != null) {
                        iBinder = gVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDaPlayListenerListener(h hVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (hVar != null) {
                        iBinder = hVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDebugAVListener(i iVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (iVar != null) {
                        iBinder = iVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDebugMode(boolean z10) {
                int i10;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (z10) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    obtain.writeInt(i10);
                    this.f11921a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDebugTimestamp(boolean z10) {
                int i10;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (z10) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    obtain.writeInt(i10);
                    this.f11921a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f11921a.transact(62, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setFavoriteDeviceListener(j jVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (jVar != null) {
                        iBinder = jVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setHistoryDeviceListener(k kVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (kVar != null) {
                        iBinder = kVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setLelinkPlayListenerListener(l lVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lVar != null) {
                        iBinder = lVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setLelinkServiceInfoListener(b bVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setLelinkServiceInfoOption(int i10, LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    boolean z10 = true;
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setLogCallback(m mVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (mVar != null) {
                        iBinder = mVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMirrorChangeListener(n nVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (nVar != null) {
                        iBinder = nVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setNewPlayListenerListener(o oVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (oVar != null) {
                        iBinder = oVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOption(int i10, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeStringArray(strArr);
                    this.f11921a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setReceiverPropertiesCallback(q qVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (qVar != null) {
                        iBinder = qVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRelevantInfoListener(r rVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (rVar != null) {
                        iBinder = rVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSearchBannerDataCallback(s sVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (sVar != null) {
                        iBinder = sVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSendPassCallback(t tVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (tVar != null) {
                        iBinder = tVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setServiceInfoListParseListener(u uVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (uVar != null) {
                        iBinder = uVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setServiceInfoParseListener(v vVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (vVar != null) {
                        iBinder = vVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSinkKeyEventListener(w wVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (wVar != null) {
                        iBinder = wVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, x xVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (sinkTouchEventArea != null) {
                        obtain.writeInt(1);
                        sinkTouchEventArea.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeFloat(f10);
                    if (xVar != null) {
                        iBinder = xVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11921a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setSystemApp(boolean z10) {
                int i10;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (z10) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    obtain.writeInt(i10);
                    this.f11921a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVolume(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f11921a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startMirrorForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkPlayerInfo != null) {
                        obtain.writeInt(1);
                        lelinkPlayerInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startOnlineCheck(p pVar, List<LelinkServiceInfo> list) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (pVar != null) {
                        iBinder = pVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeTypedList(list);
                    this.f11921a.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startPlayMedia(String str, int i10, boolean z10) {
                int i11;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    if (z10) {
                        i11 = 1;
                    } else {
                        i11 = 0;
                    }
                    obtain.writeInt(i11);
                    this.f11921a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startPlayMediaForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (lelinkPlayerInfo != null) {
                        obtain.writeInt(1);
                        lelinkPlayerInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    int i11 = 1;
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    if (!z10) {
                        i11 = 0;
                    }
                    obtain.writeInt(i11);
                    this.f11921a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopBrowse() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopPlay() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void subVolume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    this.f11921a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (audioFrameBean != null) {
                        obtain.writeInt(1);
                        audioFrameBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (videoFrameBean != null) {
                        obtain.writeInt(1);
                        videoFrameBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11921a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static z asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof z)) {
                return new C0183a(iBinder);
            }
            return (z) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.hpplay.sdk.source.api.LelinkPlayerInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.hpplay.sdk.source.api.LelinkPlayerInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: com.hpplay.sdk.source.bean.AudioFrameBean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: com.hpplay.sdk.source.bean.VideoFrameBean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: com.hpplay.sdk.source.bean.SinkTouchEventArea} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: com.hpplay.sdk.source.browse.api.LelinkServiceInfo} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v41 */
        /* JADX WARNING: type inference failed for: r3v42 */
        /* JADX WARNING: type inference failed for: r3v43 */
        /* JADX WARNING: type inference failed for: r3v44 */
        /* JADX WARNING: type inference failed for: r3v45 */
        /* JADX WARNING: type inference failed for: r3v46 */
        /* JADX WARNING: type inference failed for: r3v47 */
        /* JADX WARNING: type inference failed for: r3v48 */
        /* JADX WARNING: type inference failed for: r3v49 */
        /* JADX WARNING: type inference failed for: r3v50 */
        /* JADX WARNING: type inference failed for: r3v51 */
        /* JADX WARNING: type inference failed for: r3v52 */
        /* JADX WARNING: type inference failed for: r3v53 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
            /*
                r8 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                java.lang.String r2 = "com.hpplay.sdk.source.SDKInterface"
                if (r9 == r0) goto L_0x052d
                r0 = 0
                r3 = 0
                switch(r9) {
                    case 1: goto L_0x050e;
                    case 2: goto L_0x04fd;
                    case 3: goto L_0x04ec;
                    case 4: goto L_0x04da;
                    case 5: goto L_0x04c8;
                    case 6: goto L_0x04b6;
                    case 7: goto L_0x04a4;
                    case 8: goto L_0x0492;
                    case 9: goto L_0x0480;
                    case 10: goto L_0x046e;
                    case 11: goto L_0x045c;
                    case 12: goto L_0x0442;
                    case 13: goto L_0x0434;
                    case 14: goto L_0x042a;
                    case 15: goto L_0x0411;
                    case 16: goto L_0x03f4;
                    case 17: goto L_0x03e6;
                    case 18: goto L_0x03cd;
                    case 19: goto L_0x03b4;
                    case 20: goto L_0x038c;
                    case 21: goto L_0x0373;
                    case 22: goto L_0x0369;
                    case 23: goto L_0x035f;
                    case 24: goto L_0x0355;
                    case 25: goto L_0x034b;
                    case 26: goto L_0x033d;
                    case 27: goto L_0x0333;
                    case 28: goto L_0x0321;
                    case 29: goto L_0x0300;
                    case 30: goto L_0x02ee;
                    case 31: goto L_0x02dc;
                    case 32: goto L_0x02ca;
                    case 33: goto L_0x02c0;
                    case 34: goto L_0x02b6;
                    case 35: goto L_0x02a8;
                    case 36: goto L_0x029a;
                    case 37: goto L_0x0289;
                    case 38: goto L_0x026c;
                    case 39: goto L_0x024f;
                    case 40: goto L_0x023d;
                    case 41: goto L_0x0220;
                    case 42: goto L_0x0203;
                    case 43: goto L_0x01f1;
                    case 44: goto L_0x01cc;
                    case 45: goto L_0x01ba;
                    case 46: goto L_0x01a8;
                    case 47: goto L_0x0191;
                    case 48: goto L_0x0172;
                    case 49: goto L_0x0160;
                    case 50: goto L_0x014e;
                    case 51: goto L_0x013c;
                    case 52: goto L_0x012a;
                    case 53: goto L_0x0118;
                    case 54: goto L_0x0100;
                    case 55: goto L_0x00e2;
                    case 56: goto L_0x00d8;
                    case 57: goto L_0x00c6;
                    case 58: goto L_0x00b4;
                    case 59: goto L_0x009b;
                    case 60: goto L_0x008b;
                    case 61: goto L_0x0079;
                    case 62: goto L_0x005c;
                    case 63: goto L_0x004a;
                    case 64: goto L_0x0038;
                    case 65: goto L_0x0024;
                    case 66: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r9 = super.onTransact(r9, r10, r11, r12)
                return r9
            L_0x0012:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.q r9 = com.hpplay.sdk.source.q.a.asInterface(r9)
                r8.setReceiverPropertiesCallback(r9)
                r11.writeNoException()
                return r1
            L_0x0024:
                r10.enforceInterface(r2)
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.util.ArrayList r9 = r10.createTypedArrayList(r9)
                int r10 = r10.readInt()
                r8.removeHistoryDevice(r9, r10)
                r11.writeNoException()
                return r1
            L_0x0038:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                int r10 = r10.readInt()
                r8.getHistoryDeviceList(r9, r10)
                r11.writeNoException()
                return r1
            L_0x004a:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.k r9 = com.hpplay.sdk.source.k.a.asInterface(r9)
                r8.setHistoryDeviceListener(r9)
                r11.writeNoException()
                return r1
            L_0x005c:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x006e
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x006e:
                java.lang.String r9 = r10.readString()
                r8.setFavoriteDeviceAlias(r3, r9)
                r11.writeNoException()
                return r1
            L_0x0079:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                int r10 = r10.readInt()
                r8.getFavoriteDeviceList(r9, r10)
                r11.writeNoException()
                return r1
            L_0x008b:
                r10.enforceInterface(r2)
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.util.ArrayList r9 = r10.createTypedArrayList(r9)
                r8.removeFavoriteDevice(r9)
                r11.writeNoException()
                return r1
            L_0x009b:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00ad
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x00ad:
                r8.addFavoriteDevice(r3)
                r11.writeNoException()
                return r1
            L_0x00b4:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.j r9 = com.hpplay.sdk.source.j.a.asInterface(r9)
                r8.setFavoriteDeviceListener(r9)
                r11.writeNoException()
                return r1
            L_0x00c6:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.t r9 = com.hpplay.sdk.source.t.a.asInterface(r9)
                r8.setSendPassCallback(r9)
                r11.writeNoException()
                return r1
            L_0x00d8:
                r10.enforceInterface(r2)
                r8.clearPlayList()
                r11.writeNoException()
                return r1
            L_0x00e2:
                r10.enforceInterface(r2)
                android.os.Parcelable$Creator<com.hpplay.sdk.source.bean.DramaInfoBean> r9 = com.hpplay.sdk.source.bean.DramaInfoBean.CREATOR
                java.lang.Object[] r9 = r10.createTypedArray(r9)
                com.hpplay.sdk.source.bean.DramaInfoBean[] r9 = (com.hpplay.sdk.source.bean.DramaInfoBean[]) r9
                int r12 = r10.readInt()
                int r0 = r10.readInt()
                int r10 = r10.readInt()
                r8.appendPlayList(r9, r12, r0, r10)
                r11.writeNoException()
                return r1
            L_0x0100:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.p r9 = com.hpplay.sdk.source.p.a.asInterface(r9)
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r12 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.util.ArrayList r10 = r10.createTypedArrayList(r12)
                r8.startOnlineCheck(r9, r10)
                r11.writeNoException()
                return r1
            L_0x0118:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.d r9 = com.hpplay.sdk.source.d.a.asInterface(r9)
                r8.setCommonListener(r9)
                r11.writeNoException()
                return r1
            L_0x012a:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.n r9 = com.hpplay.sdk.source.n.a.asInterface(r9)
                r8.setMirrorChangeListener(r9)
                r11.writeNoException()
                return r1
            L_0x013c:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.m r9 = com.hpplay.sdk.source.m.a.asInterface(r9)
                r8.setLogCallback(r9)
                r11.writeNoException()
                return r1
            L_0x014e:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                java.lang.String r9 = r8.getSDKInfos(r9)
                r11.writeNoException()
                r11.writeString(r9)
                return r1
            L_0x0160:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.c r9 = com.hpplay.sdk.source.c.a.asInterface(r9)
                r8.setCloudMirrorPlayListener(r9)
                r11.writeNoException()
                return r1
            L_0x0172:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x017c
                r0 = 1
            L_0x017c:
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.util.ArrayList r9 = r10.createTypedArrayList(r9)
                java.lang.String r12 = r10.readString()
                int r10 = r10.readInt()
                r8.multiPushControl(r0, r9, r12, r10)
                r11.writeNoException()
                return r1
            L_0x0191:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x019b
                r0 = 1
            L_0x019b:
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.util.ArrayList r9 = r10.createTypedArrayList(r9)
                r8.multiMirrorControl(r0, r9)
                r11.writeNoException()
                return r1
            L_0x01a8:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                java.lang.String r9 = r8.getOption(r9)
                r11.writeNoException()
                r11.writeString(r9)
                return r1
            L_0x01ba:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.s r9 = com.hpplay.sdk.source.s.a.asInterface(r9)
                r8.setSearchBannerDataCallback(r9)
                r11.writeNoException()
                return r1
            L_0x01cc:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x01de
                android.os.Parcelable$Creator<com.hpplay.sdk.source.bean.SinkTouchEventArea> r9 = com.hpplay.sdk.source.bean.SinkTouchEventArea.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.bean.SinkTouchEventArea r3 = (com.hpplay.sdk.source.bean.SinkTouchEventArea) r3
            L_0x01de:
                float r9 = r10.readFloat()
                android.os.IBinder r10 = r10.readStrongBinder()
                com.hpplay.sdk.source.x r10 = com.hpplay.sdk.source.x.a.asInterface(r10)
                r8.setSinkTouchEventListener(r3, r9, r10)
                r11.writeNoException()
                return r1
            L_0x01f1:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.w r9 = com.hpplay.sdk.source.w.a.asInterface(r9)
                r8.setSinkKeyEventListener(r9)
                r11.writeNoException()
                return r1
            L_0x0203:
                r10.enforceInterface(r2)
                byte[] r9 = r10.createByteArray()
                int r12 = r10.readInt()
                if (r12 == 0) goto L_0x0219
                android.os.Parcelable$Creator<com.hpplay.sdk.source.bean.VideoFrameBean> r12 = com.hpplay.sdk.source.bean.VideoFrameBean.CREATOR
                java.lang.Object r10 = r12.createFromParcel(r10)
                r3 = r10
                com.hpplay.sdk.source.bean.VideoFrameBean r3 = (com.hpplay.sdk.source.bean.VideoFrameBean) r3
            L_0x0219:
                r8.updateVideoData(r9, r3)
                r11.writeNoException()
                return r1
            L_0x0220:
                r10.enforceInterface(r2)
                byte[] r9 = r10.createByteArray()
                int r12 = r10.readInt()
                if (r12 == 0) goto L_0x0236
                android.os.Parcelable$Creator<com.hpplay.sdk.source.bean.AudioFrameBean> r12 = com.hpplay.sdk.source.bean.AudioFrameBean.CREATOR
                java.lang.Object r10 = r12.createFromParcel(r10)
                r3 = r10
                com.hpplay.sdk.source.bean.AudioFrameBean r3 = (com.hpplay.sdk.source.bean.AudioFrameBean) r3
            L_0x0236:
                r8.updateAudioData(r9, r3)
                r11.writeNoException()
                return r1
            L_0x023d:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.r r9 = com.hpplay.sdk.source.r.a.asInterface(r9)
                r8.setRelevantInfoListener(r9)
                r11.writeNoException()
                return r1
            L_0x024f:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0261
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x0261:
                boolean r9 = r8.canPlayLocalMedia(r3)
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x026c:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x027e
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x027e:
                boolean r9 = r8.canPlayScreen(r3)
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x0289:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0293
                r0 = 1
            L_0x0293:
                r8.setSystemApp(r0)
                r11.writeNoException()
                return r1
            L_0x029a:
                r10.enforceInterface(r2)
                java.lang.String r9 = r10.readString()
                r8.addPinCodeToLelinkServiceInfo(r9)
                r11.writeNoException()
                return r1
            L_0x02a8:
                r10.enforceInterface(r2)
                java.lang.String r9 = r10.readString()
                r8.addQRCodeToLelinkServiceInfo(r9)
                r11.writeNoException()
                return r1
            L_0x02b6:
                r10.enforceInterface(r2)
                r8.createShortUrl()
                r11.writeNoException()
                return r1
            L_0x02c0:
                r10.enforceInterface(r2)
                r8.createPinCode()
                r11.writeNoException()
                return r1
            L_0x02ca:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.g r9 = com.hpplay.sdk.source.g.a.asInterface(r9)
                r8.setCreateShortUrlListener(r9)
                r11.writeNoException()
                return r1
            L_0x02dc:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.f r9 = com.hpplay.sdk.source.f.a.asInterface(r9)
                r8.setCreatePinCodeListener(r9)
                r11.writeNoException()
                return r1
            L_0x02ee:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.a r9 = com.hpplay.sdk.source.a.C0156a.asInterface(r9)
                r8.setAuthListener(r9)
                r11.writeNoException()
                return r1
            L_0x0300:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                int r12 = r10.readInt()
                if (r12 == 0) goto L_0x0316
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r12 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r10 = r12.createFromParcel(r10)
                r3 = r10
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x0316:
                boolean r9 = r8.setLelinkServiceInfoOption(r9, r3)
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x0321:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                java.lang.String[] r10 = r10.createStringArray()
                r8.setOption(r9, r10)
                r11.writeNoException()
                return r1
            L_0x0333:
                r10.enforceInterface(r2)
                r8.stopPlay()
                r11.writeNoException()
                return r1
            L_0x033d:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                r8.setVolume(r9)
                r11.writeNoException()
                return r1
            L_0x034b:
                r10.enforceInterface(r2)
                r8.subVolume()
                r11.writeNoException()
                return r1
            L_0x0355:
                r10.enforceInterface(r2)
                r8.addVolume()
                r11.writeNoException()
                return r1
            L_0x035f:
                r10.enforceInterface(r2)
                r8.pause()
                r11.writeNoException()
                return r1
            L_0x0369:
                r10.enforceInterface(r2)
                r8.resume()
                r11.writeNoException()
                return r1
            L_0x0373:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0385
                android.os.Parcelable$Creator<com.hpplay.sdk.source.api.LelinkPlayerInfo> r9 = com.hpplay.sdk.source.api.LelinkPlayerInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.api.LelinkPlayerInfo r3 = (com.hpplay.sdk.source.api.LelinkPlayerInfo) r3
            L_0x0385:
                r8.startMirrorForPlayerInfo(r3)
                r11.writeNoException()
                return r1
            L_0x038c:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x039e
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x039e:
                java.lang.String r9 = r10.readString()
                int r12 = r10.readInt()
                int r10 = r10.readInt()
                if (r10 == 0) goto L_0x03ad
                r0 = 1
            L_0x03ad:
                r8.startPlayMediaImmed(r3, r9, r12, r0)
                r11.writeNoException()
                return r1
            L_0x03b4:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x03c6
                android.os.Parcelable$Creator<com.hpplay.sdk.source.api.LelinkPlayerInfo> r9 = com.hpplay.sdk.source.api.LelinkPlayerInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.api.LelinkPlayerInfo r3 = (com.hpplay.sdk.source.api.LelinkPlayerInfo) r3
            L_0x03c6:
                r8.startPlayMediaForPlayerInfo(r3)
                r11.writeNoException()
                return r1
            L_0x03cd:
                r10.enforceInterface(r2)
                java.lang.String r9 = r10.readString()
                int r12 = r10.readInt()
                int r10 = r10.readInt()
                if (r10 == 0) goto L_0x03df
                r0 = 1
            L_0x03df:
                r8.startPlayMedia(r9, r12, r0)
                r11.writeNoException()
                return r1
            L_0x03e6:
                r10.enforceInterface(r2)
                java.util.List r9 = r8.getConnectInfos()
                r11.writeNoException()
                r11.writeTypedList(r9)
                return r1
            L_0x03f4:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0406
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x0406:
                boolean r9 = r8.disconnect(r3)
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x0411:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0423
                android.os.Parcelable$Creator<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r9 = com.hpplay.sdk.source.browse.api.LelinkServiceInfo.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r3 = r9
                com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3
            L_0x0423:
                r8.connect(r3)
                r11.writeNoException()
                return r1
            L_0x042a:
                r10.enforceInterface(r2)
                r8.stopBrowse()
                r11.writeNoException()
                return r1
            L_0x0434:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                r8.seekTo(r9)
                r11.writeNoException()
                return r1
            L_0x0442:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x044d
                r9 = 1
                goto L_0x044e
            L_0x044d:
                r9 = 0
            L_0x044e:
                int r10 = r10.readInt()
                if (r10 == 0) goto L_0x0455
                r0 = 1
            L_0x0455:
                r8.browse(r9, r0)
                r11.writeNoException()
                return r1
            L_0x045c:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.u r9 = com.hpplay.sdk.source.u.a.asInterface(r9)
                r8.setServiceInfoListParseListener(r9)
                r11.writeNoException()
                return r1
            L_0x046e:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.v r9 = com.hpplay.sdk.source.v.a.asInterface(r9)
                r8.setServiceInfoParseListener(r9)
                r11.writeNoException()
                return r1
            L_0x0480:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.e r9 = com.hpplay.sdk.source.e.a.asInterface(r9)
                r8.setConnectStatusListener(r9)
                r11.writeNoException()
                return r1
            L_0x0492:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.h r9 = com.hpplay.sdk.source.h.a.asInterface(r9)
                r8.setDaPlayListenerListener(r9)
                r11.writeNoException()
                return r1
            L_0x04a4:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.o r9 = com.hpplay.sdk.source.o.a.asInterface(r9)
                r8.setNewPlayListenerListener(r9)
                r11.writeNoException()
                return r1
            L_0x04b6:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.l r9 = com.hpplay.sdk.source.l.a.asInterface(r9)
                r8.setLelinkPlayListenerListener(r9)
                r11.writeNoException()
                return r1
            L_0x04c8:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.i r9 = com.hpplay.sdk.source.i.a.asInterface(r9)
                r8.setDebugAVListener(r9)
                r11.writeNoException()
                return r1
            L_0x04da:
                r10.enforceInterface(r2)
                android.os.IBinder r9 = r10.readStrongBinder()
                com.hpplay.sdk.source.b r9 = com.hpplay.sdk.source.b.a.asInterface(r9)
                r8.setLelinkServiceInfoListener(r9)
                r11.writeNoException()
                return r1
            L_0x04ec:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x04f6
                r0 = 1
            L_0x04f6:
                r8.setDebugTimestamp(r0)
                r11.writeNoException()
                return r1
            L_0x04fd:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0507
                r0 = 1
            L_0x0507:
                r8.setDebugMode(r0)
                r11.writeNoException()
                return r1
            L_0x050e:
                r10.enforceInterface(r2)
                java.lang.String r3 = r10.readString()
                java.lang.String r4 = r10.readString()
                java.lang.String r5 = r10.readString()
                java.lang.String r6 = r10.readString()
                java.lang.String r7 = r10.readString()
                r2 = r8
                r2.initSdkWithUserId(r3, r4, r5, r6, r7)
                r11.writeNoException()
                return r1
            L_0x052d:
                r11.writeString(r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.z.a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void addFavoriteDevice(LelinkServiceInfo lelinkServiceInfo);

    void addPinCodeToLelinkServiceInfo(String str);

    void addQRCodeToLelinkServiceInfo(String str);

    void addVolume();

    void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12);

    void browse(boolean z10, boolean z11);

    boolean canPlayLocalMedia(LelinkServiceInfo lelinkServiceInfo);

    boolean canPlayScreen(LelinkServiceInfo lelinkServiceInfo);

    void clearPlayList();

    void connect(LelinkServiceInfo lelinkServiceInfo);

    void createPinCode();

    void createShortUrl();

    boolean disconnect(LelinkServiceInfo lelinkServiceInfo);

    List<LelinkServiceInfo> getConnectInfos();

    void getFavoriteDeviceList(int i10, int i11);

    void getHistoryDeviceList(int i10, int i11);

    String getOption(int i10);

    String getSDKInfos(int i10);

    void initSdkWithUserId(String str, String str2, String str3, String str4, String str5);

    void multiMirrorControl(boolean z10, List<LelinkServiceInfo> list);

    void multiPushControl(boolean z10, List<LelinkServiceInfo> list, String str, int i10);

    void pause();

    void removeFavoriteDevice(List<LelinkServiceInfo> list);

    void removeHistoryDevice(List<LelinkServiceInfo> list, int i10);

    void resume();

    void seekTo(int i10);

    void setAuthListener(a aVar);

    void setCloudMirrorPlayListener(c cVar);

    void setCommonListener(d dVar);

    void setConnectStatusListener(e eVar);

    void setCreatePinCodeListener(f fVar);

    void setCreateShortUrlListener(g gVar);

    void setDaPlayListenerListener(h hVar);

    void setDebugAVListener(i iVar);

    void setDebugMode(boolean z10);

    void setDebugTimestamp(boolean z10);

    void setFavoriteDeviceAlias(LelinkServiceInfo lelinkServiceInfo, String str);

    void setFavoriteDeviceListener(j jVar);

    void setHistoryDeviceListener(k kVar);

    void setLelinkPlayListenerListener(l lVar);

    void setLelinkServiceInfoListener(b bVar);

    boolean setLelinkServiceInfoOption(int i10, LelinkServiceInfo lelinkServiceInfo);

    void setLogCallback(m mVar);

    void setMirrorChangeListener(n nVar);

    void setNewPlayListenerListener(o oVar);

    void setOption(int i10, String[] strArr);

    void setReceiverPropertiesCallback(q qVar);

    void setRelevantInfoListener(r rVar);

    void setSearchBannerDataCallback(s sVar);

    void setSendPassCallback(t tVar);

    void setServiceInfoListParseListener(u uVar);

    void setServiceInfoParseListener(v vVar);

    void setSinkKeyEventListener(w wVar);

    void setSinkTouchEventListener(SinkTouchEventArea sinkTouchEventArea, float f10, x xVar);

    void setSystemApp(boolean z10);

    void setVolume(int i10);

    void startMirrorForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo);

    void startOnlineCheck(p pVar, List<LelinkServiceInfo> list);

    void startPlayMedia(String str, int i10, boolean z10);

    void startPlayMediaForPlayerInfo(LelinkPlayerInfo lelinkPlayerInfo);

    void startPlayMediaImmed(LelinkServiceInfo lelinkServiceInfo, String str, int i10, boolean z10);

    void stopBrowse();

    void stopPlay();

    void subVolume();

    void updateAudioData(byte[] bArr, AudioFrameBean audioFrameBean);

    void updateVideoData(byte[] bArr, VideoFrameBean videoFrameBean);
}
