package com.android_learn.aparatpro.ui.activity.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android_learn.aparatpro.R;
import com.android_learn.aparatpro.databinding.ActivityVideoPlayerBinding;
import com.android_learn.aparatpro.db.AppDatabase;
import com.android_learn.aparatpro.model.Video;
import com.android_learn.aparatpro.utility.Rebirth;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

public class VideoPlayerActivity extends AppCompatActivity {
    ActivityVideoPlayerBinding binding;
    Bundle bundle;
    Video video;
    ExoPlayer exoPlayer;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();
        video = bundle.getParcelable("videoObj");
        appDatabase = AppDatabase.getInstance(getApplicationContext());
        exoPlayer = new ExoPlayer.Builder(getApplicationContext()).build();

        binding.videoPlayer.setPlayer(exoPlayer);

        MediaItem mediaItem = MediaItem.fromUri(video.getLink());
        exoPlayer.setMediaItem(mediaItem);

        exoPlayer.prepare();
        exoPlayer.play();

        binding.txtTime.setText(video.getTime());
        binding.txtViews.setText(String.valueOf(video.getView()));
        binding.txtDescription.setText(video.getDescription());

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Rebirth.triggerRebirth(VideoPlayerActivity.this);
            }
        });



        if(appDatabase.idao().isRowExist(Integer.parseInt(video.getId())))
        {
            binding.imgFavBorder.setImageResource(R.drawable.ic_baseline_favorite_24);
        }else
        {
            binding.imgFavBorder.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }
        binding.imgFavBorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(appDatabase.idao().isRowExist(Integer.parseInt(video.getId())))
                {
                    appDatabase.idao().deleteVideo(Integer.parseInt(video.getId()));
                    binding.imgFavBorder.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }else
                {
                    appDatabase.idao().insert(video);
                    binding.imgFavBorder.setImageResource(R.drawable.ic_baseline_favorite_24);
                }
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (exoPlayer != null) {
            exoPlayer.stop();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Rebirth.triggerRebirth(VideoPlayerActivity.this);
    }
}