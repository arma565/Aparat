package com.android_learn.aparatpro.ui.activity.categoryvideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.android_learn.aparatpro.databinding.ActivityCategoryVideoBinding;
import com.android_learn.aparatpro.ui.fragment.favorite.VideoAdapter;
import com.android_learn.aparatpro.api.ApiCaller;
import com.android_learn.aparatpro.model.Category;
import com.android_learn.aparatpro.model.IResponseListener;
import com.android_learn.aparatpro.model.Video;

import java.util.List;

public class CategoryVideoActivity extends AppCompatActivity {
    ActivityCategoryVideoBinding binding;
    Bundle bundle;
    Category category;
    //ApiCaller apiCaller;
    CategoryVideoViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        category = bundle.getParcelable("categoryObj");

        viewModel = new ViewModelProvider(this).get(CategoryVideoViewModel.class);
        viewModel.getCategoryVideo(category.getId()).observe(this, new Observer<List<Video>>() {
            @Override
            public void onChanged(List<Video> videoList) {
                binding.recCategoryVideo.setAdapter(new VideoAdapter(getApplicationContext() , videoList));
                binding.recCategoryVideo.setLayoutManager(new GridLayoutManager(getApplicationContext() , 2));
            }
        });



   /*     apiCaller = new ApiCaller();
        apiCaller.getCategoryVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                binding.recCategoryVideo.setAdapter(new VideoAdapter(getApplicationContext() , (List<Video>) responseMessage));
                binding.recCategoryVideo.setLayoutManager(new GridLayoutManager(getApplicationContext() , 2));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        } , category.getId());*/

    }
}