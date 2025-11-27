package y2;

import com.dcs.bean.V1Result;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface a {
    @POST("/v1/{fake-value1}/{fake-value2}")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<V1Result> a(@Path("fake-value1") String str, @Path("fake-value2") String str2, @Header("ETag") String str3, @Body RequestBody requestBody);

    @POST("/n1/{fake-value1}/{fake-value2}")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<V1Result> b(@Path("fake-value1") String str, @Path("fake-value2") String str2, @Header("ETag") String str3, @Body RequestBody requestBody);
}
