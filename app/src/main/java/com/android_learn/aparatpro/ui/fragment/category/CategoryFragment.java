package com.android_learn.aparatpro.ui.fragment.category;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android_learn.aparatpro.api.ApiCaller;
import com.android_learn.aparatpro.databinding.FragmentCategoryBinding;
import com.android_learn.aparatpro.model.Category;
import com.android_learn.aparatpro.model.IResponseListener;

import java.util.List;


public class CategoryFragment extends Fragment {
    LifecycleOwner owner;
    FragmentCategoryBinding binding;
    CategoryViewModel viewModel;
    //ApiCaller apiCaller;
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        owner = this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentCategoryBinding.inflate(getLayoutInflater());

       viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
       viewModel.getCategory().observe(owner, new Observer<List<Category>>() {
           @Override
           public void onChanged(List<Category> categoryList) {
               binding.recFragCategory.setAdapter(new CategoryAdapter(getActivity() , categoryList));
               binding.recFragCategory.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false));
           }
       });





/*       apiCaller = new ApiCaller();

       apiCaller.getCategory(new IResponseListener() {
           @Override
           public void onSuccess(Object responseMessage) {


               binding.recFragCategory.setAdapter(new CategoryAdapter(getActivity() , (List<Category>) responseMessage));
               binding.recFragCategory.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false));

           }

           @Override
           public void onFailure(String errorResponseMessage) {

           }
       });*/




        return binding.getRoot();
    }
}