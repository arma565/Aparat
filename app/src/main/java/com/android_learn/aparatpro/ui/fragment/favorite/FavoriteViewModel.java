package com.android_learn.aparatpro.ui.fragment.favorite;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android_learn.aparatpro.db.AppDatabase;
import com.android_learn.aparatpro.model.Video;

import java.util.List;

public class FavoriteViewModel extends AndroidViewModel {

    MutableLiveData<List<Video>> mutableLiveData = null;
    AppDatabase appDatabase;
    public FavoriteViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(application.getApplicationContext());
    }

    public MutableLiveData<List<Video>> getVideoList(){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        loadData();
        return mutableLiveData;

    }

    public void loadData(){
        List<Video> videoList = appDatabase.idao().videoList();
        mutableLiveData.setValue(videoList);
    }

}
