package qa;

import io.reactivex.Observable;
import mobile.com.requestframe.utils.response.ActiveResult;
import mobile.com.requestframe.utils.response.AddFavoriteResult;
import mobile.com.requestframe.utils.response.AddSubscribeResult;
import mobile.com.requestframe.utils.response.ApkQueryCouponResult;
import mobile.com.requestframe.utils.response.ApkReceiveCouponResult;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.BindPhoneResult;
import mobile.com.requestframe.utils.response.BindThirdPartResult;
import mobile.com.requestframe.utils.response.CancelSubscriptionResult;
import mobile.com.requestframe.utils.response.CheckForceBindResult;
import mobile.com.requestframe.utils.response.CheckGetVipResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.ConfigResult;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.DelSubscribeResult;
import mobile.com.requestframe.utils.response.EmailResetPwdResult;
import mobile.com.requestframe.utils.response.ExchangeCodeResult;
import mobile.com.requestframe.utils.response.ExchangeResult;
import mobile.com.requestframe.utils.response.FeedBackContactResult;
import mobile.com.requestframe.utils.response.FilterByContentResult;
import mobile.com.requestframe.utils.response.FilterGenreResult;
import mobile.com.requestframe.utils.response.FootballMatchResult;
import mobile.com.requestframe.utils.response.FreeResult;
import mobile.com.requestframe.utils.response.GetAuthInfoResult;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import mobile.com.requestframe.utils.response.GetDeviceResult;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import mobile.com.requestframe.utils.response.GetExchangeOrderInfoResult;
import mobile.com.requestframe.utils.response.GetFavoriteResult;
import mobile.com.requestframe.utils.response.GetHomeResult;
import mobile.com.requestframe.utils.response.GetItemDataResult;
import mobile.com.requestframe.utils.response.GetLiveDataResult;
import mobile.com.requestframe.utils.response.GetNextColumnResult;
import mobile.com.requestframe.utils.response.GetOrderInfoResult;
import mobile.com.requestframe.utils.response.GetPackageResult;
import mobile.com.requestframe.utils.response.GetPriorityVipResult;
import mobile.com.requestframe.utils.response.GetProgramResult;
import mobile.com.requestframe.utils.response.GetQrResult;
import mobile.com.requestframe.utils.response.GetShortVideoResult;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResult;
import mobile.com.requestframe.utils.response.GetSubscriptionRecordResult;
import mobile.com.requestframe.utils.response.GiftDaysResult;
import mobile.com.requestframe.utils.response.HeartBeatResult;
import mobile.com.requestframe.utils.response.LineupResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.MatchEventResult;
import mobile.com.requestframe.utils.response.MatchStatResult;
import mobile.com.requestframe.utils.response.MsgBoxResult;
import mobile.com.requestframe.utils.response.MsgNumResult;
import mobile.com.requestframe.utils.response.PropertiesInfoResult;
import mobile.com.requestframe.utils.response.PwdCheckResult;
import mobile.com.requestframe.utils.response.SearchByContentData;
import mobile.com.requestframe.utils.response.SearchByNameResult;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveMatchResult;
import mobile.com.requestframe.utils.response.SnTokenResult;
import mobile.com.requestframe.utils.response.StartPlayLiveResult;
import mobile.com.requestframe.utils.response.StartPlayVODResult;
import mobile.com.requestframe.utils.response.SubResponse;
import mobile.com.requestframe.utils.response.ThirdPartResult;
import mobile.com.requestframe.utils.response.TopUserResult;
import mobile.com.requestframe.utils.response.TypeQuestionResult;
import mobile.com.requestframe.utils.response.UpdatePwdResult;
import mobile.com.requestframe.utils.response.UpdateRestrictResult;
import mobile.com.requestframe.utils.response.UserBindResult;
import mobile.com.requestframe.utils.response.VerificationResult;
import mobile.com.requestframe.utils.response.VodRecommendsRespone;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface b {
    @POST("/api/portalCore/getExchangeOrderInfo")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetExchangeOrderInfoResult> A(@Body String str);

    @POST("/api/portalCore/v3/filterByContent")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<FilterByContentResult> A0(@Body String str);

    @POST("/api/portalCore/delFavorite")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<DelFavoriteResult> B(@Body String str);

    @POST("/api/portalCore/apkQueryCoupon")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<ApkQueryCouponResult> B0(@Body String str);

    @POST("/api/portalCore/checkVerifiCode")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<CheckVerificationResult> C(@Body String str);

    @POST("/api/portalCore/v2/getPriorityVip")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetPriorityVipResult> C0(@Body String str);

    @POST("/api/portalCore/v8/active")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<ActiveResult> D(@Body String str);

    @POST("/api/portalCore/v2/getFree")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<FreeResult> D0(@Body String str);

    @POST("/api/portalCore/package/getSubscriptionRecord")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetSubscriptionRecordResult> E(@Body String str);

    @POST("/api/portalCore/device-management/getDevice")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetDeviceResult> E0(@Body String str);

    @GET("/api/portalCore/epg/v2/getShelveMatch")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<ShelveMatchResult> F(@Query("appId") String str);

    @GET("/api/portalCore/epg/v2/getTeamEvent")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<MatchEventResult> F0(@Query("gameId") String str);

    @POST("/api/portalCore/getNextColumns")
    @Headers({"Cache-Control:no-store;Content-Type:application/json;charset=utf-8"})
    Observable<GetNextColumnResult> G(@Body String str);

    @POST("/api/portalCore/getTop")
    Observable<TopUserResult> G0(@Body String str);

    @POST("/api/portalCore/v3/filterGenre")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<FilterGenreResult> H(@Body String str);

    @POST("api/portalCore/reportHardInfo")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> H0(@Body String str);

    @POST("/api/portalCore/package/getOrderInfo")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetOrderInfoResult> I(@Body String str);

    @GET("/api/portalCore/epg/v2/getAllMatch")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<FootballMatchResult> I0(@Query("appId") String str, @Query("match") String str2, @Query("gameId") String str3, @Query("pageSize") int i10);

    @POST("/api/portalCore/getUserExchange")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<ExchangeCodeResult> J(@Body String str);

    @POST("/api/portalCore/updateBindEmailOrPwd")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<UpdatePwdResult> J0(@Body String str);

    @POST("/api/portalCore/v4/getItemData")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetItemDataResult> K(@Body String str);

    @POST("/api/portalCore/v2/checkGetVip")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<CheckGetVipResult> K0(@Body String str);

    @POST("/api/subs/terminal/metadata")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8;responseKey:NxZZ7EYgaJiJSBHjnq7sDxYvYRm32tPQ"})
    Observable<SubResponse> L(@Body String str);

    @POST("/api/portalCore/v10/startPlayVOD")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<StartPlayVODResult> L0(@Body String str);

    @POST("/api/portalCore/v3/getRecommends")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<VodRecommendsRespone> M(@Body String str);

    @POST("/api/portalCore/v4/resetPwd")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> N(@Body String str);

    @POST("/api/portalCore/box/update")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> O(@Body String str);

    @POST("/api/portalCore/box/select")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<MsgBoxResult> P(@Body String str);

    @POST("/api/portalCore/v14/getSlbInfo")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetSlbInfoBeanResult> Q(@Body String str);

    @PUT("/api/portalCore/device/updateOrInsert")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> R(@Body String str);

    @POST("/api/portalCore/pwdCheck")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<PwdCheckResult> S(@Body String str);

    @POST("/api/portalCore/getVerifiCode")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<VerificationResult> T(@Body String str);

    @POST("/api/portalCore/emailResetPassNotice")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<EmailResetPwdResult> U(@Body String str);

    @POST("/api/portalCore/getFavorite")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetFavoriteResult> V(@Body String str);

    @POST("/api/portalCore/qr/getResult")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetQrResult> W(@Body String str);

    @POST("/api/portalCore/blSearchByContent")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<SearchByContentData> X(@Body String str);

    @POST("/api/portalCore/package/cancelSubscription")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<CancelSubscriptionResult> Y(@Body String str);

    @POST("/api/portalCore/updateRestrictedStatus")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<UpdateRestrictResult> Z(@Body String str);

    @POST("/api/portalCore/feedback/getCustomerService")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<FeedBackContactResult> a(@Body String str);

    @POST("/api/portalCore/v3/getColumnContents")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetColumnContentsResult> a0(@Body String str);

    @POST("/api/portalCore/feedback/userFeedBack")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<BaseResult> b(@Body String str);

    @POST("/api/portalCore/package/getPackageCustomization")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetPackageResult> b0(@Body String str);

    @POST("/api/portalCore/box/delete")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> c(@Body String str);

    @GET("/api/portalCore/epg/v3/getFootballMatch")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<FootballMatchResult> c0(@Query("appId") String str, @Query("match") String str2, @Query("date") String str3, @Query("gameId") String str4, @Query("appLanguage") String str5);

    @POST("/api/portalCore/v2/sendEmailVerifyCode")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> d(@Body String str);

    @POST("/api/portalCore/bindPhone")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<BindPhoneResult> d0(@Body String str);

    @POST("/api/portalCore/v5/qr/getResult")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetQrResult> e(@Body String str);

    @POST("/api/portalCore/getBindInfo")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<UserBindResult> e0(@Body String str);

    @POST("/api/portalCore/v10/startPlayVOD")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Call<StartPlayVODResult> f(@Body String str);

    @POST("/api/portalCore/v9/getAuthInfo")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetAuthInfoResult> f0(@Body String str);

    @POST("/api/portalCore/v3/searchByName")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<SearchByNameResult> g(@Body String str);

    @POST("/api/portalCore/bindEmailGiftDays")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GiftDaysResult> g0(@Body String str);

    @GET("/api/portalCore/epg/v2/getLineUps")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<LineupResult> h(@Query("gameId") String str);

    @POST("/api/portalCore/addSubscribe")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<AddSubscribeResult> h0(@Body String str);

    @POST("/api/portalCore/v6/getLiveData")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetLiveDataResult> i(@Body String str);

    @POST("/api/portalCore/v5/heartbeat")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<HeartBeatResult> i0(@Body String str);

    @POST("/api/portalCore/getThridPart")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<ThirdPartResult> j(@Body String str);

    @POST("/api/portalCore/getShortVideo")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetShortVideoResult> j0(@Body String str);

    @GET("/api/portalCore/epg/v5/getNearestMatch")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<FootballMatchResult> k(@Query("appId") String str, @Query("pageSize") int i10);

    @POST("/api/portalCore/qr/waitConfirm")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> k0(@Body String str);

    @POST("/api/portalCore/getAreaCode")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<AreaCodeResult> l(@Body String str);

    @GET("/api/portalCore/epg/v2/getMatchDetail")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<MatchStatResult> l0(@Query("gameId") String str, @Query("teamAName") String str2, @Query("teamBName") String str3);

    @POST("/api/portalCore/v3/getProgram")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetProgramResult> m(@Body String str);

    @POST("/api/portalCore/v4/startPlayLive")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<StartPlayLiveResult> m0(@Body String str);

    @POST("/api/portalCore/checkForceBind")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<CheckForceBindResult> n(@Body String str);

    @POST("/api/portalCore/delSubscribe")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<DelSubscribeResult> n0(@Body String str);

    @POST("/api/portalCore/v3/snToken")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<SnTokenResult> o(@Body String str);

    @POST("/api/portalCore/v7/login/thirdpart")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<LoginResult> o0(@Body String str);

    @POST("/api/portalCore/changeBindPhone")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> p(@Body String str);

    @POST("/api/portalCore/getEmailSuffix")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetEmailSuffixResult> p0(@Body String str);

    @POST("/api/portalCore/getHome")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetHomeResult> q(@Body String str);

    @POST("/api/portalCore/v8/login")
    @Headers({"Content-type:application/json;charset=utf-8"})
    Observable<LoginResult> q0(@Body String str);

    @POST("/api/portalCore/device-management/deleteDevice")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> r(@Body String str);

    @POST("/api/portalCore/v2/addFavorite")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<AddFavoriteResult> r0(@Body String str);

    @POST("/api/portalCore/config/get")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "ProcessResult:false"})
    Observable<ConfigResult> s(@Body String str);

    @POST("/api/portalCore/v5/exchange")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<ExchangeResult> s0(@Body String str);

    @POST("/api/portalCore/v2/bindEmail")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> t(@Body String str);

    @POST("/api/portalCore/v2/validateVerifyCode")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> t0(@Body String str);

    @POST("/api/portalCore/epg/getSportsMatch")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<FootballMatchResult> u(@Body String str);

    @POST("/api/portalCore/bindThirdpart")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BindThirdPartResult> u0(@Body String str);

    @POST("/api/portalCore/v2/unBind")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> v(@Body String str);

    @POST("/api/portalCore/box/count")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<MsgNumResult> v0(@Body String str);

    @POST("/api/portalCore/apkReceiveCoupon")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<ApkReceiveCouponResult> w(@Body String str);

    @POST("/api/portalCore/v2/changeBindEmail")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> w0(@Body String str);

    @POST("/api/portalCore/getPropertiesInfo")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<PropertiesInfoResult> x(@Body String str);

    @POST("/api/portalCore/v3/searchByContent")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<SearchByContentData> x0(@Body String str);

    @POST("/api/portalCore/v15/getSlbInfo")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<GetSlbInfoBeanResult> y(@Body String str);

    @POST("/api/portalCore/v3/getShelveData")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<ShelveDataBean> y0(@Body String str);

    @POST("/api/portalCore/feedback/getTypeQuestion")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8", "needEncrypt:false"})
    Observable<TypeQuestionResult> z(@Body String str);

    @POST("/api/portalCore/v5/loginOut")
    @Headers({"Cache-Control:no-store;Content-type:application/json;charset=utf-8"})
    Observable<BaseResult> z0(@Body String str);
}
