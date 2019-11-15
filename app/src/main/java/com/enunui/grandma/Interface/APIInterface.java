package com.enunui.grandma.Interface;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;


//Interface to generate POST,GET,DELETE,PUT methods


public interface APIInterface {




    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("http://www.haplot.com/veg/index.php?")
    Observable<String> get_jsonContent(@Field("action") String str, @Field("video_id") String str2);//,@Body RequestPoll request

}
