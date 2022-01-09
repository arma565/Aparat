package com.android_learn.aparatpro.api;

import com.android_learn.aparatpro.model.Category;
import com.android_learn.aparatpro.model.IResponseListener;
import com.android_learn.aparatpro.model.News;
import com.android_learn.aparatpro.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {

    IService iService;
    public ApiCaller()
    {
        iService = ApiClient.getRetrofit().create(IService.class);
    }

    public void getNews(IResponseListener listener)
    {
        Call<List<News>> getNew = iService.getNews();
        getNew.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString()+"");
            }
        });
    }

    public void getBestVideos(IResponseListener listener)
    {
        Call<List<Video>> getBest = iService.getBestVideos();
        getBest.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString()+"");
            }
        });
    }

    public void getNewVideos(IResponseListener listener)
    {
        Call<List<Video>> getNewV = iService.getNewVideos();
        getNewV.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString()+"");
            }
        });
    }

    public void getSpecialVideos(IResponseListener listener)
    {
        Call<List<Video>> getSpecial = iService.getSpecialVideos();
        getSpecial.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString()+"");
            }
        });
    }

    public void getCategory(IResponseListener listener)
    {
        Call<List<Category>> cat_list = iService.getVideoCategory();
        cat_list.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString()+"");
            }
        });
    }

    public void getCategoryVideos(IResponseListener listener , String videoId)
    {
        Call<List<Video>> getCatVideo = iService.getCatVideos(videoId);
        getCatVideo.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString()+"");
            }
        });
    }




}
