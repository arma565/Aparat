package com.android_learn.aparatpro.ui.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.android_learn.aparatpro.R;
import com.android_learn.aparatpro.model.News;
import com.android_learn.aparatpro.model.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    Context context ;
    List<News> newsList;
    public ViewPagerAdapter(Context context , List<News> newsList)
    {
        this.context = context;
        this.newsList = newsList;
    }
    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.image_layout , null);

        AppCompatImageView img = view.findViewById(R.id.img_icon);

        container.addView(view , 0);

        News news_class = newsList.get(position);


        Picasso.get().load(news_class.getIcon()).into(img);





        return view;
    }
}
