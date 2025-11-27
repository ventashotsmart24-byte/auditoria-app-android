package d5;

import com.mobile.bean.UpdateBean;
import j7.e;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class a implements Converter {
    /* renamed from: a */
    public UpdateBean convert(ResponseBody responseBody) {
        return e.a(responseBody.byteStream());
    }
}
