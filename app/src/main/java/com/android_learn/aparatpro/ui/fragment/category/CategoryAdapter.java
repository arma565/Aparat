package com.android_learn.aparatpro.ui.fragment.category;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android_learn.aparatpro.R;
import com.android_learn.aparatpro.ui.activity.categoryvideo.CategoryVideoActivity;
import com.android_learn.aparatpro.databinding.CatRowBinding;
import com.android_learn.aparatpro.model.Category;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryVH> {
    Context context ;
    List<Category> categoryList;
    CatRowBinding binding;
    public CategoryAdapter(Context context , List<Category> categoryList)
    {
        this.context = context;
        this.categoryList = categoryList;
    }



    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_row , null);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context) , R.layout.cat_row , parent , false);
        return new CategoryVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {

        Category cat = categoryList.get(position);

        binding.setCategory(cat);

/*        holder.txt_cat_title.setText(category.getTitle());

        Picasso.get().load(category.getIcon()).into(holder.img_cat_row);*/

/*        holder.card_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_cat_video = new Intent(context , CategoryVideoActivity.class);
                intent_cat_video.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent_cat_video.putExtra("categoryObj" , category);
                context.startActivity(intent_cat_video);
            }
        });*/





    }


    @BindingAdapter("showImage")
    public static void imageShow(AppCompatImageView img , String url){
        Picasso.get().load(url).into(img);
        // Glide.with(img.getContext()).load(url).into(img);

    }

    @BindingAdapter("imageIcon")
    public static void clickImage(CardView cardView , Category category){
        Context context = cardView.getContext();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_cat_video = new Intent(context , CategoryVideoActivity.class);
                intent_cat_video.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent_cat_video.putExtra("categoryObj" , category);
                context.startActivity(intent_cat_video);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
