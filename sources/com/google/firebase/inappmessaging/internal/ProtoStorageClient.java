package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    public ProtoStorageClient(Application application2, String str) {
        this.application = application2;
        this.fileName = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ AbstractMessageLite lambda$read$1(Parser parser) {
        FileInputStream openFileInput;
        AbstractMessageLite abstractMessageLite;
        synchronized (this) {
            try {
                openFileInput = this.application.openFileInput(this.fileName);
                abstractMessageLite = (AbstractMessageLite) parser.parseFrom((InputStream) openFileInput);
                if (openFileInput != null) {
                    openFileInput.close();
                }
            } catch (InvalidProtocolBufferException | FileNotFoundException e10) {
                Logging.logi("Recoverable exception while reading cache: " + e10.getMessage());
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return abstractMessageLite;
        throw th;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$write$0(AbstractMessageLite abstractMessageLite) {
        synchronized (this) {
            FileOutputStream openFileOutput = this.application.openFileOutput(this.fileName, 0);
            try {
                openFileOutput.write(abstractMessageLite.toByteArray());
                openFileOutput.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return abstractMessageLite;
        throw th;
    }

    public <T extends AbstractMessageLite> Maybe<T> read(Parser<T> parser) {
        return Maybe.fromCallable(new w1(this, parser));
    }

    public Completable write(AbstractMessageLite abstractMessageLite) {
        return Completable.fromCallable(new x1(this, abstractMessageLite));
    }
}
