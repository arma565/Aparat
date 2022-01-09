package com.android_learn.aparatpro.api;

import com.android_learn.aparatpro.model.Category;
import com.android_learn.aparatpro.model.News;
import com.android_learn.aparatpro.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {

    @GET("getNewVideos.php")
    Call<List<Video>> getNewVideos();

    @GET("getBestVideos.php")
    Call<List<Video>> getBestVideos();

    @GET("getSpecial.php")
    Call<List<Video>> getSpecialVideos();

    @GET("getNews.php")
    Call<List<News>> getNews();

    @GET("getCategory.php")
    Call<List<Category>> getVideoCategory();

    @FormUrlEncoded
    @POST("getVideosCategory.php")
    Call<List<Video>> getCatVideos(@Field("catId") String id);



}
