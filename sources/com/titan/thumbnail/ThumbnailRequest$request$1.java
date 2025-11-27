package com.titan.thumbnail;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import m8.d;
import t9.i;

public final class ThumbnailRequest$request$1 implements Observer<ThumbnailResult> {
    public void onComplete() {
    }

    public void onError(Throwable th) {
        i.h(th, "e");
        ThumbnailCallback access$getMthumbnailCallback$p = ThumbnailRequest.mthumbnailCallback;
        if (access$getMthumbnailCallback$p != null) {
            access$getMthumbnailCallback$p.onGetThumbnail(false);
        }
    }

    public void onSubscribe(Disposable disposable) {
        i.h(disposable, "d");
        ThumbnailRequest.mDisposable = disposable;
    }

    public void onNext(ThumbnailResult thumbnailResult) {
        i.h(thumbnailResult, "t");
        if (d.b(thumbnailResult.getSource_url()) && thumbnailResult.getCombines() != null) {
            List<CombineData> combines = thumbnailResult.getCombines();
            if (combines == null) {
                i.q();
            }
            if (!combines.isEmpty()) {
                ThumbnailUtil.INSTANCE.setData(thumbnailResult);
                ThumbnailCallback access$getMthumbnailCallback$p = ThumbnailRequest.mthumbnailCallback;
                if (access$getMthumbnailCallback$p != null) {
                    access$getMthumbnailCallback$p.onGetThumbnail(true);
                    return;
                }
                return;
            }
        }
        ThumbnailCallback access$getMthumbnailCallback$p2 = ThumbnailRequest.mthumbnailCallback;
        if (access$getMthumbnailCallback$p2 != null) {
            access$getMthumbnailCallback$p2.onGetThumbnail(false);
        }
    }
}
