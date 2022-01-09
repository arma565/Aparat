package com.android_learn.aparatpro.ui.activity.categoryvideo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android_learn.aparatpro.api.ApiClient;
import com.android_learn.aparatpro.api.IService;
import com.android_learn.aparatpro.model.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryVideoViewModel extends AndroidViewModel {

    MutableLiveData<List<Video>> mutableLiveData = null;
    public CategoryVideoViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Video>> getCategoryVideo(String catId){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        loadData(catId);
        return mutableLiveData;
    }
    public void loadData(String catId){
        IService service = ApiClient.getRetrofit().create(IService.class);
        service.getCatVideos(catId).enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {

            }
        });
    }

}
