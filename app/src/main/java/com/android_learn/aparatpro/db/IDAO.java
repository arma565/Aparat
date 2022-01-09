package com.android_learn.aparatpro.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.android_learn.aparatpro.model.Video;

import java.util.List;

@Dao
public interface IDAO {

    @Insert
    long insert(Video video);

    @Update
    void update(Video video);

    @Delete
    void delete(Video video);

    @Query("delete from tbl_video where id=:id")
    void deleteVideo(int id);

    @Query("select * from tbl_video where id=:id")
    boolean isRowExist(int id);

    @Query("select * from tbl_video")
    List<Video> videoList();

}
