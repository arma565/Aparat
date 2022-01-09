package com.android_learn.aparatpro.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_video")
public class Video implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int videoID;
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private String id;
    @ColumnInfo(name = "cat_id")
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;
    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    @Expose
    private String icon;
    @ColumnInfo(name = "creator")
    @SerializedName("creator")
    @Expose
    private String creator;
    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    private String description;
    @ColumnInfo(name = "link")
    @SerializedName("link")
    @Expose
    private String link;
    @ColumnInfo(name = "view")
    @SerializedName("view")
    @Expose
    private String view;
    @ColumnInfo(name = "time")
    @SerializedName("time")
    @Expose
    private String time;
    @ColumnInfo(name = "special")
    @SerializedName("special")
    @Expose
    private String special;

    public Video()
    {

    }

    public Video(String id, String catId, String title, String icon, String creator, String description, String link, String view, String time, String special) {
        this.id = id;
        this.catId = catId;
        this.title = title;
        this.icon = icon;
        this.creator = creator;
        this.description = description;
        this.link = link;
        this.view = view;
        this.time = time;
        this.special = special;
    }

    @Ignore
    public Video(int videoID, String id, String catId, String title, String icon, String creator, String description, String link, String view, String time, String special) {
        this.setVideoID(videoID);
        this.id = id;
        this.catId = catId;
        this.title = title;
        this.icon = icon;
        this.creator = creator;
        this.description = description;
        this.link = link;
        this.view = view;
        this.time = time;
        this.special = special;
    }









    protected Video(Parcel in) {
        id = in.readString();
        catId = in.readString();
        title = in.readString();
        icon = in.readString();
        creator = in.readString();
        description = in.readString();
        link = in.readString();
        view = in.readString();
        time = in.readString();
        special = in.readString();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(catId);
        dest.writeString(title);
        dest.writeString(icon);
        dest.writeString(creator);
        dest.writeString(description);
        dest.writeString(link);
        dest.writeString(view);
        dest.writeString(time);
        dest.writeString(special);
    }

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }
}
