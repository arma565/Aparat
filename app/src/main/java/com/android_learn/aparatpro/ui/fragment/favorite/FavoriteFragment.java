package com.android_learn.aparatpro.ui.fragment.favorite;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android_learn.aparatpro.databinding.FragmentFavoriteBinding;
import com.android_learn.aparatpro.db.AppDatabase;
import com.android_learn.aparatpro.model.Video;

import java.util.List;


public class FavoriteFragment extends Fragment {

    AppDatabase appDatabase;
    FragmentFavoriteBinding binding;
    LifecycleOwner owner;
    FavoriteViewModel viewModel;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        owner = this;
    }

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());
        appDatabase = AppDatabase.getInstance(getActivity());

        viewModel = new ViewModelProvider(this).get(FavoriteViewModel.class);
        viewModel.getVideoList().observe(owner, new Observer<List<Video>>() {
            @Override
            public void onChanged(List<Video> videoList) {
                VideoAdapter adapter = new VideoAdapter(getActivity() ,videoList);
                binding.recFragFavorite.setAdapter(adapter);
                binding.recFragFavorite.setLayoutManager(new GridLayoutManager(getActivity() , 2));
            }
        });





        return binding.getRoot();
    }



}