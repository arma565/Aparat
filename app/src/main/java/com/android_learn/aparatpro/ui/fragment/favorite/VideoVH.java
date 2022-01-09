package com.android_learn.aparatpro.ui.fragment.favorite;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android_learn.aparatpro.R;
import com.android_learn.aparatpro.databinding.VideoRowBinding;

public class VideoVH extends RecyclerView.ViewHolder {
/*    AppCompatImageView img_video;
    CardView cardView;
    AppCompatTextView lbl_video;*/
    public VideoVH(@NonNull VideoRowBinding binding) {
        super(binding.getRoot());
/*        img_video = itemView.findViewById(R.id.img_video);
        cardView = itemView.findViewById(R.id.card_video);
        lbl_video = itemView.findViewById(R.id.lbl_video);*/
    }
}
