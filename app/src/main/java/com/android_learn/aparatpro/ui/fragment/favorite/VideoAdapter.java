package com.android_learn.aparatpro.ui.fragment.favorite;

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
import com.android_learn.aparatpro.databinding.VideoRowBinding;
import com.android_learn.aparatpro.ui.activity.videoplayer.VideoPlayerActivity;
import com.android_learn.aparatpro.model.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoVH> {
    Context context ;
    List<Video> videoList;
    VideoRowBinding binding;
    public VideoAdapter(Context context , List<Video> videoList)
    {
        this.context = context;
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_row , null);
        binding = DataBindingUtil.inflate(LayoutInflater.from(context) , R.layout.video_row , parent , false);

        return new VideoVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {
        Video video = videoList.get(position);
        binding.setVideo(video);


       // holder.lbl_video.setText(video.getTitle());

        //Picasso.get().load(video.getIcon()).into(holder.img_video);

      /*  holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vide_player = new Intent(context , VideoPlayerActivity.class);
                intent_vide_player.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent_vide_player.putExtra("videoObj" , video);
                context.startActivity(intent_vide_player);
            }
        });*/

    }

    @BindingAdapter("imageShow")
    public static void showImage(AppCompatImageView img , String url){
        Picasso.get().load(url).into(img);
    }

    @BindingAdapter("clickImg")
    public static void clickImage(CardView cardView , Video video){
        Context context = cardView.getContext();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vide_player = new Intent(context , VideoPlayerActivity.class);
                intent_vide_player.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent_vide_player.putExtra("videoObj" , video);
                context.startActivity(intent_vide_player);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
