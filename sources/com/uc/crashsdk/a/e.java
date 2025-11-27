package com.uc.crashsdk.a;

import com.google.android.gms.cast.MediaError;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.sdk.source.common.global.Constant;
import com.uc.crashsdk.a;
import com.uc.crashsdk.b;
import com.uc.crashsdk.f;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f13486a = true;

    /* renamed from: b  reason: collision with root package name */
    private final int f13487b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f13488c;

    public e(int i10) {
        this.f13487b = i10;
        this.f13488c = null;
    }

    public final boolean a() {
        int i10 = this.f13487b;
        if (i10 == 451 || i10 == 452) {
            return com.uc.crashsdk.e.b(i10, this.f13488c);
        }
        switch (i10) {
            case 351:
            case 352:
            case 353:
            case 354:
                return h.b(i10, this.f13488c);
            default:
                switch (i10) {
                    case 751:
                    case 752:
                    case 753:
                    case 754:
                    case 755:
                    case 756:
                        return f.a(i10, this.f13488c);
                    default:
                        a.d("crashsdk", "Unknown sync runnable: " + toString());
                        if (f13486a) {
                            return false;
                        }
                        throw new AssertionError();
                }
        }
    }

    public void run() {
        int i10 = this.f13487b;
        if (i10 == 10) {
            f.a(i10, this.f13488c);
        } else if (i10 == 500) {
            d.a(i10);
        } else if (i10 == 700) {
            f.b(i10);
        } else if (i10 == 800) {
            g.a(i10);
        } else if (i10 == 201 || i10 == 202) {
            a.a(i10);
        } else {
            switch (i10) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                    b.a(i10);
                    return;
                default:
                    switch (i10) {
                        case 301:
                        case 302:
                        case 303:
                            h.a(i10, this.f13488c);
                            return;
                        default:
                            switch (i10) {
                                case 401:
                                case 402:
                                case UPnPStatus.OUT_OF_SYNC:
                                    break;
                                default:
                                    switch (i10) {
                                        case 405:
                                        case 406:
                                        case 407:
                                        case 408:
                                        case 409:
                                        case Constant.TOKEN_EXPIRED:
                                        case MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER:
                                        case 412:
                                        case 413:
                                        case 414:
                                        case 415:
                                        case 416:
                                            break;
                                        default:
                                            a.d("crashsdk", "Unknown async runnable: " + toString());
                                            if (!f13486a) {
                                                throw new AssertionError();
                                            }
                                            return;
                                    }
                            }
                            com.uc.crashsdk.e.a(i10, this.f13488c);
                            return;
                    }
            }
        }
    }

    public String toString() {
        return super.toString() + "@action_" + this.f13487b;
    }

    public e(int i10, Object[] objArr) {
        this.f13487b = i10;
        this.f13488c = objArr;
    }
}
