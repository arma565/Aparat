package com.android_learn.aparatpro.ui.fragment.home;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android_learn.aparatpro.api.ApiClient;
import com.android_learn.aparatpro.api.IService;
import com.android_learn.aparatpro.model.News;
import com.android_learn.aparatpro.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends AndroidViewModel {
    MutableLiveData<List<News>> newsMutableLiveData = null;
    MutableLiveData<List<Video>> bestMutableLiveData = null;
    MutableLiveData<List<Video>> newVideoMutableLiveData = null;
    MutableLiveData<List<Video>> specialVideoMutableLiveData = null;
    IService service;
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<List<News>> getNewsMutableLiveData(){
        if (newsMutableLiveData == null){
            newsMutableLiveData = new MutableLiveData<>();
        }
        loadNews();
        return newsMutableLiveData;
    }
    public void loadNews(){
        service = ApiClient.getRetrofit().create(IService.class);
        service.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                newsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Log.e("","");
            }
        });
    }





    public MutableLiveData<List<Video>> getBestVideo(){
        if (bestMutableLiveData == null){
            bestMutableLiveData = new MutableLiveData<>();
        }
        loadBestVideo();
        return bestMutableLiveData;
    }
    public void loadBestVideo(){
        service = ApiClient.getRetrofit().create(IService.class);
        service.getBestVideos().enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                bestMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("","");
            }
        });
    }





    public MutableLiveData<List<Video>> getNewVideo(){
        if (newVideoMutableLiveData == null){
            newVideoMutableLiveData = new MutableLiveData<>();
        }
        loadGetNewVideo();
        return newVideoMutableLiveData;
    }
    public void loadGetNewVideo(){
        service = ApiClient.getRetrofit().create(IService.class);
        service.getNewVideos().enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                newVideoMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("","");
            }
        });
    }





    public MutableLiveData<List<Video>> getSpecialVideo(){
        if (specialVideoMutableLiveData == null){
            specialVideoMutableLiveData = new MutableLiveData<>();
        }
        loadGetSpecialVideo();
        return specialVideoMutableLiveData;
    }
    public void loadGetSpecialVideo(){
        service = ApiClient.getRetrofit().create(IService.class);
        service.getSpecialVideos().enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                specialVideoMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("","");
            }
        });
    }

}
