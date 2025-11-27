package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.entity.UMessage;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public final class ap implements Externalizable {
    private static final long serialVersionUID = -1;

    /* renamed from: a  reason: collision with root package name */
    public UMessage f15401a;

    /* renamed from: b  reason: collision with root package name */
    long f15402b;

    /* renamed from: c  reason: collision with root package name */
    public int f15403c;

    public ap(UMessage uMessage) {
        this.f15401a = uMessage;
        this.f15402b = System.currentTimeMillis();
        a();
    }

    private void a() {
        JSONObject optJSONObject = this.f15401a.getRaw().optJSONObject("u");
        if (optJSONObject != null) {
            this.f15403c = optJSONObject.optInt("ia");
        }
    }

    public final boolean equals(Object obj) {
        UMessage uMessage;
        UMessage uMessage2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ap)) {
            return false;
        }
        ap apVar = (ap) obj;
        if (hashCode() != apVar.hashCode() || (uMessage = this.f15401a) == null || (uMessage2 = apVar.f15401a) == null) {
            return false;
        }
        if (uMessage == uMessage2) {
            return true;
        }
        return TextUtils.equals(uMessage.getRaw().toString(), apVar.f15401a.getRaw().toString());
    }

    public final int hashCode() {
        UMessage uMessage = this.f15401a;
        if (uMessage == null) {
            return super.hashCode();
        }
        if (uMessage.getRaw() == null) {
            return super.hashCode();
        }
        return this.f15401a.getRaw().hashCode();
    }

    public final void readExternal(ObjectInput objectInput) {
        this.f15402b = objectInput.readLong();
        try {
            this.f15401a = new UMessage(new JSONObject((String) objectInput.readObject()));
            a();
        } catch (Exception e10) {
            throw new IOException(e10);
        }
    }

    public final String toString() {
        UMessage uMessage = this.f15401a;
        if (uMessage == null) {
            return "";
        }
        return uMessage.getMsgId();
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeLong(this.f15402b);
        objectOutput.writeObject(this.f15401a.getRaw().toString());
        objectOutput.writeObject((Object) null);
    }

    public ap() {
    }
}
