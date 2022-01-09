package com.android_learn.aparatpro.ui.fragment.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android_learn.aparatpro.ui.fragment.favorite.VideoAdapter;
import com.android_learn.aparatpro.ui.activity.main.ViewPagerAdapter;
import com.android_learn.aparatpro.api.ApiCaller;
import com.android_learn.aparatpro.databinding.FragmentHomeBinding;
import com.android_learn.aparatpro.model.IResponseListener;
import com.android_learn.aparatpro.model.News;
import com.android_learn.aparatpro.model.Video;

import java.util.List;


public class HomeFragment extends Fragment {

    ApiCaller apiCaller;
    FragmentHomeBinding binding;
    HomeViewModel viewModel;
    LifecycleOwner owner;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        owner = this;
    }

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getNewsMutableLiveData().observe(owner, new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> newsList) {
                ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity() , newsList);
                binding.viewPager.setAdapter(adapter);
            }
        });

        viewModel.getBestVideo().observe(owner, new Observer<List<Video>>() {
            @Override
            public void onChanged(List<Video> videoList) {

                binding.recBestVideos.setAdapter(new VideoAdapter(getActivity() , videoList));
                binding.recBestVideos.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , false));
            }
        });

        viewModel.getNewVideo().observe(owner, new Observer<List<Video>>() {
            @Override
            public void onChanged(List<Video> videoList) {
                binding.recNewVideos.setAdapter(new VideoAdapter(getActivity() ,videoList));
                binding.recNewVideos.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , false));
            }
        });

        viewModel.getSpecialVideo().observe(owner, new Observer<List<Video>>() {
            @Override
            public void onChanged(List<Video> videoList) {
                binding.recSpecialVideos.setAdapter(new VideoAdapter(getActivity(),videoList));
                binding.recSpecialVideos.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , false));
            }
        });








/*        apiCaller = new ApiCaller();

        apiCaller.getNews(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                List<News> newsList = (List<News>) responseMessage;
                ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity() , newsList);
                binding.viewPager.setAdapter(adapter);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        apiCaller.getBestVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                binding.recBestVideos.setAdapter(new VideoAdapter(getActivity() , (List<Video>) responseMessage));
                binding.recBestVideos.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , false));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        apiCaller.getNewVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                binding.recNewVideos.setAdapter(new VideoAdapter(getActivity() , (List<Video>) responseMessage));
                binding.recNewVideos.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.HORIZONTAL , false));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        apiCaller.getSpecialVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                binding.recSpecialVideos.setAdapter(new VideoAdapter(getActivity(),(List<Video>) responseMessage));
                binding.recSpecialVideos.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.HORIZONTAL , false));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });*/


        return binding.getRoot();
    }
}