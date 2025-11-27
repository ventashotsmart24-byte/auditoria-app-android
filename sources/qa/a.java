package qa;

import io.reactivex.Observable;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ConfigCenterResponse;
import mobile.com.requestframe.utils.response.GetAddrResult;
import mobile.com.requestframe.utils.response.JsonEpgResult;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface a {
    @POST("/api/configCenter/config/get")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<ConfigCenterResponse> a(@Body RequestBody requestBody);

    @GET
    Observable<ArrayList<JsonEpgResult>> b(@Url String str);

    @POST("/api/v2/dcs/getAddr")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<GetAddrResult> c(@Body RequestBody requestBody);
}
