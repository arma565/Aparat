package com.android_learn.aparatpro.ui.fragment.category;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android_learn.aparatpro.api.ApiClient;
import com.android_learn.aparatpro.api.IService;
import com.android_learn.aparatpro.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends AndroidViewModel {
    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    MutableLiveData<List<Category>> mutableLiveData = null;

    public MutableLiveData<List<Category>> getCategory(){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        loadData();
        return mutableLiveData;
    }

    public void loadData(){
        IService service =  ApiClient.getRetrofit().create(IService.class);
        service.getVideoCategory().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

}
