package a8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.umeng.analytics.pro.f;
import t9.i;
import z7.a;
import z7.b;

public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f10713a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final int f10714b = 17;

    /* renamed from: c  reason: collision with root package name */
    public GoogleSignInClient f10715c;

    /* renamed from: d  reason: collision with root package name */
    public a f10716d;

    public d(Activity activity, String str) {
        i.g(activity, "activity");
        i.g(str, "serverClientId");
        GoogleSignInOptions build = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestServerAuthCode(str).requestIdToken(str).requestId().requestEmail().requestProfile().build();
        i.f(build, "Builder(GoogleSignInOpti…\n                .build()");
        this.f10715c = GoogleSignIn.getClient(activity, build);
    }

    public static final void k(d dVar, Task task) {
        i.g(dVar, "this$0");
        i.g(task, "it");
        String str = dVar.f10713a;
    }

    public static final void l(d dVar, Activity activity, Task task) {
        i.g(dVar, "this$0");
        i.g(activity, "$activity");
        i.g(task, "it");
        dVar.j(activity);
    }

    public boolean a(int i10) {
        return i10 == 0;
    }

    public void b(a aVar) {
        i.g(aVar, "callback");
        this.f10716d = aVar;
    }

    public int c(Context context) {
        i.g(context, f.X);
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }

    public void d(Activity activity) {
        Intent intent;
        i.g(activity, "activity");
        GoogleSignInClient googleSignInClient = this.f10715c;
        if (googleSignInClient != null) {
            intent = googleSignInClient.getSignInIntent();
        } else {
            intent = null;
        }
        activity.startActivityForResult(intent, this.f10714b);
    }

    public void e(int i10, int i11, Intent intent) {
        if (i10 == this.f10714b) {
            Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
            i.f(signedInAccountFromIntent, "task");
            i(signedInAccountFromIntent);
        }
    }

    public void f(Activity activity) {
        Task<Void> signOut;
        i.g(activity, "activity");
        GoogleSignInClient googleSignInClient = this.f10715c;
        if (googleSignInClient != null && (signOut = googleSignInClient.signOut()) != null) {
            signOut.addOnCompleteListener(activity, (OnCompleteListener<Void>) new b(this, activity));
        }
    }

    public final void i(Task task) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Uri photoUrl;
        try {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) task.getResult(ApiException.class);
            x7.a aVar = new x7.a();
            String str6 = null;
            if (googleSignInAccount != null) {
                str = googleSignInAccount.getServerAuthCode();
            } else {
                str = null;
            }
            String str7 = "";
            if (str == null) {
                str = str7;
            }
            aVar.b(str);
            if (googleSignInAccount != null) {
                str2 = googleSignInAccount.getIdToken();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = str7;
            }
            aVar.d(str2);
            if (googleSignInAccount != null) {
                str3 = googleSignInAccount.getId();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = str7;
            }
            aVar.f(str3);
            if (googleSignInAccount != null) {
                str4 = googleSignInAccount.getDisplayName();
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = str7;
            }
            aVar.e(str4);
            if (googleSignInAccount == null || (photoUrl = googleSignInAccount.getPhotoUrl()) == null) {
                str5 = null;
            } else {
                str5 = photoUrl.toString();
            }
            if (str5 == null) {
                str5 = str7;
            }
            aVar.g(str5);
            if (googleSignInAccount != null) {
                str6 = googleSignInAccount.getEmail();
            }
            if (str6 != null) {
                str7 = str6;
            }
            aVar.c(str7);
            a aVar2 = this.f10716d;
            if (aVar2 != null) {
                aVar2.S0(1, aVar);
            }
        } catch (ApiException e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("signInResult:failed code=");
            sb.append(e10.getStatusCode());
            sb.append(" msg: ");
            sb.append(e10.getStatusMessage());
            a aVar3 = this.f10716d;
            if (aVar3 != null) {
                aVar3.p1(1, new y7.a(e10));
            }
        }
    }

    public final void j(Activity activity) {
        Task<Void> revokeAccess;
        GoogleSignInClient googleSignInClient = this.f10715c;
        if (googleSignInClient != null && (revokeAccess = googleSignInClient.revokeAccess()) != null) {
            revokeAccess.addOnCompleteListener(activity, (OnCompleteListener<Void>) new c(this));
        }
    }
}
